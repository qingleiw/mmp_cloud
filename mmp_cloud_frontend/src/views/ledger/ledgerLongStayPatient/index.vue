<template>
  <div class="p-2">
    <!-- 页面标题 -->
    <div class="page-header mb-4">
      <h2 class="page-title">
        <i-ep-timer class="title-icon"></i-ep-timer>
        长期住院患者管理
      </h2>
      <p class="page-description">管理长期住院患者信息</p>
    </div>


    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <div v-show="showSearch" class="mb-[10px]">
        <el-card shadow="hover" class="search-card">
          <template #header>
            <div class="search-header">
              <span class="search-title">
                <i-ep-search class="search-icon"></i-ep-search>
                搜索条件
              </span>
              <div class="search-actions">
                <el-button text type="primary" @click="handleSearchConfig" class="config-btn">
                  <i-ep-setting class="btn-icon"></i-ep-setting>
                  搜索配置
                </el-button>
              </div>
            </div>
          
    <!-- 搜索配置对话框 -->
    <SearchConfigDialog
      v-model:visible="searchConfigVisible"
      v-model:fields="visibleSearchFields"
      :config="[]"
      title="搜索字段配置"
    />
    
    <!-- 字段配置对话框 -->
    <FieldConfigDialog
      v-model:visible="fieldConfigVisible"
      :config="[]"
      title="列表字段配置"
    />
  </template>
          <DynamicSearchForm
            ref="queryFormRef"
            :query="queryParams"
            :visible-fields="visibleSearchFields"
            @search="handleQuery"
            @reset="resetQuery"
          />
        </el-card>
      </div>
    </transition>

    <el-card shadow="never">
      <template #header>
              <div class="table-header">
        <div class="table-title">
          <i-ep-list class="table-icon"></i-ep-list>
          <span>长期住院患者列表</span>
        </div>
        <div class="table-actions">

          
            <el-button size="small" type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['ledger:ledgerLongStayPatient:add']">新增</el-button>
          
          
            <el-button size="small" type="success" plain icon="Edit" :disabled="single" @click="handleUpdate()" v-hasPermi="['ledger:ledgerLongStayPatient:edit']"
              >修改</el-button
            >
          
          
            <el-button size="small"
              type="danger"
              plain
              icon="Delete"
              :disabled="multiple"
              @click="handleDelete()"
              v-hasPermi="['ledger:ledgerLongStayPatient:remove']"
              >删除</el-button
            >
          
          
            <el-button size="small" type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['ledger:ledgerLongStayPatient:export']"
              >导出</el-button
            >
          
          
          <el-button text type="primary" @click="handleFieldConfig" class="config-btn">
            <i-ep-setting class="btn-icon"></i-ep-setting>
            字段配置
          </el-button>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </div>
      </div>
      </template>

      <el-table v-loading="loading" border :data="ledgerLongStayPatientList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="主键ID" align="center" prop="id" v-if="false" />
        <el-table-column label="患者姓名" align="center" prop="patientName" />
        <el-table-column label="入院日期" align="center" prop="admissionDate" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.admissionDate, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="出院日期" align="center" prop="dischargeDate" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.dischargeDate, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="住院天数" align="center" prop="hospitalDays" />
        <el-table-column label="所在科室" align="center" prop="department" />
        <el-table-column label="诊断" align="center" prop="diagnosis" />
        <el-table-column label="治疗方案" align="center" prop="treatmentPlan" />
        <el-table-column label="并发症" align="center" prop="complications" />
        <el-table-column label="特殊原因" align="center" prop="specialReasons" />
        <el-table-column label="医疗评价" align="center" prop="medicalEvaluation" />
        <el-table-column label="状态" align="center" prop="status" />
        <el-table-column label="备注" align="center" prop="remark" />
        <el-table-column label="操作" align="center" fixed="right" class-name="small-padding fixed-width">
          <template #default="scope">
            <el-tooltip content="修改" placement="top">
              <el-button
                link
                type="primary"
                icon="Edit"
                @click="handleUpdate(scope.row)"
                v-hasPermi="['ledger:ledgerLongStayPatient:edit']"
              ></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button
                link
                type="primary"
                icon="Delete"
                @click="handleDelete(scope.row)"
                v-hasPermi="['ledger:ledgerLongStayPatient:remove']"
              ></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改住院超30天患者登记本对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="ledgerLongStayPatientFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="患者ID" prop="patientId">
          <el-input v-model="form.patientId" placeholder="请输入患者ID" />
        </el-form-item>
        <el-form-item label="患者姓名" prop="patientName">
          <el-input v-model="form.patientName" placeholder="请输入患者姓名" />
        </el-form-item>
        <el-form-item label="入院日期" prop="admissionDate">
          <el-date-picker clearable v-model="form.admissionDate" type="datetime" value-format="YYYY-MM-DD HH:mm:ss" placeholder="请选择入院日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="出院日期" prop="dischargeDate">
          <el-date-picker clearable v-model="form.dischargeDate" type="datetime" value-format="YYYY-MM-DD HH:mm:ss" placeholder="请选择出院日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="住院天数" prop="hospitalDays">
          <el-input v-model="form.hospitalDays" placeholder="请输入住院天数" />
        </el-form-item>
        <el-form-item label="所在科室" prop="department">
          <el-input v-model="form.department" placeholder="请输入所在科室" />
        </el-form-item>
        <el-form-item label="诊断" prop="diagnosis">
          <el-input v-model="form.diagnosis" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="治疗方案" prop="treatmentPlan">
          <el-input v-model="form.treatmentPlan" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="并发症" prop="complications">
          <el-input v-model="form.complications" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="特殊原因" prop="specialReasons">
          <el-input v-model="form.specialReasons" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="医疗评价" prop="medicalEvaluation">
          <el-input v-model="form.medicalEvaluation" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" type="textarea" placeholder="请输入内容" />
        </el-form-item>
      </el-form>
      <template #footer>
        <div class="dialog-footer">
          <el-button :loading="buttonLoading" type="primary" @click="submitForm">确 定</el-button>
          <el-button @click="cancel">取 消</el-button>
        </div>
      </template>
    </el-dialog>
  </div>
</template>

<script setup name="LedgerLongStayPatient" lang="ts">
import DynamicSearchForm from '@/components/DynamicSearchForm.vue';
import SearchConfigDialog from '@/components/SearchConfigDialog.vue';
import FieldConfigDialog from '@/components/FieldConfigDialog.vue';
import {
  listLedgerLongStayPatient,
  getLedgerLongStayPatient,
  delLedgerLongStayPatient,
  addLedgerLongStayPatient,
  updateLedgerLongStayPatient
} from '@/api/ledger/ledgerLongStayPatient';
import { LedgerLongStayPatientVO, LedgerLongStayPatientQuery, LedgerLongStayPatientForm } from '@/api/ledger/ledgerLongStayPatient/types';


const searchConfigVisible = ref(false);
const fieldConfigVisible = ref(false);
const visibleSearchFields = ref<string[]>([]);

const handleSearchConfig = () => {
  searchConfigVisible.value = true;
};

const handleFieldConfig = () => {
  fieldConfigVisible.value = true;
};

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const ledgerLongStayPatientList = ref<LedgerLongStayPatientVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const ledgerLongStayPatientFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: LedgerLongStayPatientForm = {
  id: undefined,
  patientId: undefined,
  patientName: undefined,
  admissionDate: undefined,
  dischargeDate: undefined,
  hospitalDays: undefined,
  department: undefined,
  diagnosis: undefined,
  treatmentPlan: undefined,
  complications: undefined,
  specialReasons: undefined,
  medicalEvaluation: undefined,
  status: undefined,
  remark: undefined
};
const data = reactive<PageData<LedgerLongStayPatientForm, LedgerLongStayPatientQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    patientName: undefined,
    admissionDate: undefined,
    dischargeDate: undefined,
    hospitalDays: undefined,
    department: undefined,
    diagnosis: undefined,
    treatmentPlan: undefined,
    complications: undefined,
    specialReasons: undefined,
    medicalEvaluation: undefined,
    status: undefined,
    params: {}
  },
  rules: {
    id: [{ required: true, message: '主键ID不能为空', trigger: 'blur' }],
    patientId: [{ required: true, message: '患者ID不能为空', trigger: 'blur' }],
    patientName: [{ required: true, message: '患者姓名不能为空', trigger: 'blur' }],
    admissionDate: [{ required: true, message: '入院日期不能为空', trigger: 'blur' }]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询住院超30天患者登记本列表 */
const getList = async () => {
  loading.value = true;
  const res = await listLedgerLongStayPatient(queryParams.value);
  ledgerLongStayPatientList.value = res.rows;
  total.value = res.total;
  loading.value = false;
};

/** 取消按钮 */
const cancel = () => {
  reset();
  dialog.visible = false;
};

/** 表单重置 */
const reset = () => {
  form.value = { ...initFormData };
  ledgerLongStayPatientFormRef.value?.resetFields();
};

/** 搜索按钮操作 */
const handleQuery = () => {
  queryParams.value.pageNum = 1;
  getList();
};

/** 重置按钮操作 */
const resetQuery = () => {
  queryFormRef.value?.resetFields();
  handleQuery();
};

/** 多选框选中数据 */
const handleSelectionChange = (selection: LedgerLongStayPatientVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加住院超30天患者登记本';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: LedgerLongStayPatientVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getLedgerLongStayPatient(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改住院超30天患者登记本';
};

/** 提交按钮 */
const submitForm = () => {
  ledgerLongStayPatientFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateLedgerLongStayPatient(form.value).finally(() => (buttonLoading.value = false));
      } else {
        await addLedgerLongStayPatient(form.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: LedgerLongStayPatientVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除住院超30天患者登记本编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delLedgerLongStayPatient(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'ledger/ledgerLongStayPatient/export',
    {
      ...queryParams.value
    },
    `ledgerLongStayPatient_${new Date().getTime()}.xlsx`
  );
};

onMounted(() => {
  getList();
});
</script>
