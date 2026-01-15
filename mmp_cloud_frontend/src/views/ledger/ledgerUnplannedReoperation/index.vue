<template>
  <div class="p-2">
    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <div v-show="showSearch" class="mb-[10px]">
        <el-card shadow="hover">
          <el-form ref="queryFormRef" :model="queryParams" :inline="true">
            <el-form-item label="患者姓名" prop="patientName">
              <el-input v-model="queryParams.patientName" placeholder="请输入患者姓名" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="第一次手术日期" prop="firstOperationDate">
              <el-date-picker
                clearable
                v-model="queryParams.firstOperationDate"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择第一次手术日期"
              />
            </el-form-item>
            <el-form-item label="再次手术日期" prop="reoperationDate">
              <el-date-picker
                clearable
                v-model="queryParams.reoperationDate"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择再次手术日期"
              />
            </el-form-item>
            <el-form-item label="手术科室" prop="department">
              <el-input v-model="queryParams.department" placeholder="请输入手术科室" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="手术医师" prop="surgeon">
              <el-input v-model="queryParams.surgeon" placeholder="请输入手术医师" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="第一次手术名称" prop="firstOperationName">
              <el-input v-model="queryParams.firstOperationName" placeholder="请输入第一次手术名称" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="再次手术名称" prop="reoperationName">
              <el-input v-model="queryParams.reoperationName" placeholder="请输入再次手术名称" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="再次手术原因" prop="reoperationReason">
              <el-input v-model="queryParams.reoperationReason" placeholder="请输入再次手术原因" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="并发症" prop="complications">
              <el-input v-model="queryParams.complications" placeholder="请输入并发症" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="医疗评价" prop="medicalEvaluation">
              <el-input v-model="queryParams.medicalEvaluation" placeholder="请输入医疗评价" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item>
              <el-button type="primary" icon="Search" @click="handleQuery">搜索</el-button>
              <el-button icon="Refresh" @click="resetQuery">重置</el-button>
            </el-form-item>
          </el-form>
        </el-card>
      </div>
    </transition>

    <el-card shadow="never">
      <template #header>
        <el-row :gutter="10" class="mb8">
          <el-col :span="1.5">
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['ledger:ledgerUnplannedReoperation:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button
              type="success"
              plain
              icon="Edit"
              :disabled="single"
              @click="handleUpdate()"
              v-hasPermi="['ledger:ledgerUnplannedReoperation:edit']"
              >修改</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button
              type="danger"
              plain
              icon="Delete"
              :disabled="multiple"
              @click="handleDelete()"
              v-hasPermi="['ledger:ledgerUnplannedReoperation:remove']"
              >删除</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['ledger:ledgerUnplannedReoperation:export']"
              >导出</el-button
            >
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" border :data="ledgerUnplannedReoperationList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="主键ID" align="center" prop="id" v-if="false" />
        <el-table-column label="患者姓名" align="center" prop="patientName" />
        <el-table-column label="第一次手术日期" align="center" prop="firstOperationDate" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.firstOperationDate, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="再次手术日期" align="center" prop="reoperationDate" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.reoperationDate, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="手术科室" align="center" prop="department" />
        <el-table-column label="手术医师" align="center" prop="surgeon" />
        <el-table-column label="第一次手术名称" align="center" prop="firstOperationName" />
        <el-table-column label="再次手术名称" align="center" prop="reoperationName" />
        <el-table-column label="再次手术原因" align="center" prop="reoperationReason" />
        <el-table-column label="并发症" align="center" prop="complications" />
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
                v-hasPermi="['ledger:ledgerUnplannedReoperation:edit']"
              ></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button
                link
                type="primary"
                icon="Delete"
                @click="handleDelete(scope.row)"
                v-hasPermi="['ledger:ledgerUnplannedReoperation:remove']"
              ></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改非计划再次手术登记本对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="ledgerUnplannedReoperationFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="患者ID" prop="patientId">
          <el-input v-model="form.patientId" placeholder="请输入患者ID" />
        </el-form-item>
        <el-form-item label="患者姓名" prop="patientName">
          <el-input v-model="form.patientName" placeholder="请输入患者姓名" />
        </el-form-item>
        <el-form-item label="第一次手术日期" prop="firstOperationDate">
          <el-date-picker
            clearable
            v-model="form.firstOperationDate"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择第一次手术日期"
          >
          </el-date-picker>
        </el-form-item>
        <el-form-item label="再次手术日期" prop="reoperationDate">
          <el-date-picker
            clearable
            v-model="form.reoperationDate"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择再次手术日期"
          >
          </el-date-picker>
        </el-form-item>
        <el-form-item label="手术科室" prop="department">
          <el-input v-model="form.department" placeholder="请输入手术科室" />
        </el-form-item>
        <el-form-item label="手术医师" prop="surgeon">
          <el-input v-model="form.surgeon" placeholder="请输入手术医师" />
        </el-form-item>
        <el-form-item label="第一次手术名称" prop="firstOperationName">
          <el-input v-model="form.firstOperationName" placeholder="请输入第一次手术名称" />
        </el-form-item>
        <el-form-item label="再次手术名称" prop="reoperationName">
          <el-input v-model="form.reoperationName" placeholder="请输入再次手术名称" />
        </el-form-item>
        <el-form-item label="再次手术原因" prop="reoperationReason">
          <el-input v-model="form.reoperationReason" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="并发症" prop="complications">
          <el-input v-model="form.complications" type="textarea" placeholder="请输入内容" />
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

<script setup name="LedgerUnplannedReoperation" lang="ts">
import {
  listLedgerUnplannedReoperation,
  getLedgerUnplannedReoperation,
  delLedgerUnplannedReoperation,
  addLedgerUnplannedReoperation,
  updateLedgerUnplannedReoperation
} from '@/api/ledger/ledgerUnplannedReoperation';
import {
  LedgerUnplannedReoperationVO,
  LedgerUnplannedReoperationQuery,
  LedgerUnplannedReoperationForm
} from '@/api/ledger/ledgerUnplannedReoperation/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const ledgerUnplannedReoperationList = ref<LedgerUnplannedReoperationVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const ledgerUnplannedReoperationFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: LedgerUnplannedReoperationForm = {
  id: undefined,
  patientId: undefined,
  patientName: undefined,
  firstOperationDate: undefined,
  reoperationDate: undefined,
  department: undefined,
  surgeon: undefined,
  firstOperationName: undefined,
  reoperationName: undefined,
  reoperationReason: undefined,
  complications: undefined,
  medicalEvaluation: undefined,
  status: undefined,
  remark: undefined
};
const data = reactive<PageData<LedgerUnplannedReoperationForm, LedgerUnplannedReoperationQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    patientName: undefined,
    firstOperationDate: undefined,
    reoperationDate: undefined,
    department: undefined,
    surgeon: undefined,
    firstOperationName: undefined,
    reoperationName: undefined,
    reoperationReason: undefined,
    complications: undefined,
    medicalEvaluation: undefined,
    status: undefined,
    params: {}
  },
  rules: {
    id: [{ required: true, message: '主键ID不能为空', trigger: 'blur' }],
    patientId: [{ required: true, message: '患者ID不能为空', trigger: 'blur' }],
    patientName: [{ required: true, message: '患者姓名不能为空', trigger: 'blur' }],
    firstOperationDate: [{ required: true, message: '第一次手术日期不能为空', trigger: 'blur' }],
    reoperationDate: [{ required: true, message: '再次手术日期不能为空', trigger: 'blur' }]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询非计划再次手术登记本列表 */
const getList = async () => {
  loading.value = true;
  const res = await listLedgerUnplannedReoperation(queryParams.value);
  ledgerUnplannedReoperationList.value = res.rows;
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
  ledgerUnplannedReoperationFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: LedgerUnplannedReoperationVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加非计划再次手术登记本';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: LedgerUnplannedReoperationVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getLedgerUnplannedReoperation(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改非计划再次手术登记本';
};

/** 提交按钮 */
const submitForm = () => {
  ledgerUnplannedReoperationFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateLedgerUnplannedReoperation(form.value).finally(() => (buttonLoading.value = false));
      } else {
        await addLedgerUnplannedReoperation(form.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: LedgerUnplannedReoperationVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除非计划再次手术登记本编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delLedgerUnplannedReoperation(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'ledger/ledgerUnplannedReoperation/export',
    {
      ...queryParams.value
    },
    `ledgerUnplannedReoperation_${new Date().getTime()}.xlsx`
  );
};

onMounted(() => {
  getList();
});
</script>
