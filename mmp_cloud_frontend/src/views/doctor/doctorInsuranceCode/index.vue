<template>
  <div class="p-2">
    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <div v-show="showSearch" class="mb-[10px]">
        <el-card shadow="hover">
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
        <el-row :gutter="10" class="mb8">
          <el-col :span="1.5">
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['system:doctorInsuranceCode:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="success" plain icon="Edit" :disabled="single" @click="handleUpdate()" v-hasPermi="['system:doctorInsuranceCode:edit']"
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
              v-hasPermi="['system:doctorInsuranceCode:remove']"
              >删除</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['system:doctorInsuranceCode:export']">导出</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="info" plain icon="Setting" @click="showFieldConfig = true">字段配置</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="info" plain icon="Setting" @click="handleSearchConfig">搜索项配置</el-button>
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" border :data="doctorInsuranceCodeList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column
          v-for="field in visibleColumns"
          :key="field.prop"
          :label="field.label"
          align="center"
          :prop="field.prop"
          :width="field.width || undefined"
        >
          <template #default="scope">
            <span v-if="field.prop === 'validDate' || field.prop === 'applyDate' || field.prop === 'approveDate'">
              {{ parseTime(scope.row[field.prop], '{y}-{m}-{d}') }}
            </span>
            <template v-else-if="field.prop === 'doctorId'">
              <span>{{ getDoctorName(scope.row.doctorId) }}</span>
            </template>
            <span v-else>
              {{ scope.row[field.prop] }}
            </span>
          </template>
        </el-table-column>
        <el-table-column label="操作" align="center" fixed="right" class-name="small-padding fixed-width">
          <template #default="scope">
            <el-tooltip content="修改" placement="top">
              <el-button
                link
                type="primary"
                icon="Edit"
                @click="handleUpdate(scope.row)"
                v-hasPermi="['system:doctorInsuranceCode:edit']"
              ></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button
                link
                type="primary"
                icon="Delete"
                @click="handleDelete(scope.row)"
                v-hasPermi="['system:doctorInsuranceCode:remove']"
              ></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改医保医师码对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="doctorInsuranceCodeFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="医生ID" prop="doctorId">
          <el-input v-model="form.doctorId" placeholder="请输入医生ID" />
        </el-form-item>
        <el-form-item label="医保医师码" prop="insuranceCode">
          <el-input v-model="form.insuranceCode" placeholder="请输入医保医师码" />
        </el-form-item>
        <el-form-item label="有效期至" prop="validDate">
          <el-date-picker clearable v-model="form.validDate" type="datetime" value-format="YYYY-MM-DD HH:mm:ss" placeholder="请选择有效期至">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="申请日期" prop="applyDate">
          <el-date-picker clearable v-model="form.applyDate" type="datetime" value-format="YYYY-MM-DD HH:mm:ss" placeholder="请选择申请日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="审批日期" prop="approveDate">
          <el-date-picker clearable v-model="form.approveDate" type="datetime" value-format="YYYY-MM-DD HH:mm:ss" placeholder="请选择审批日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="是否删除" prop="delFlag">
          <el-input v-model="form.delFlag" placeholder="请输入是否删除" />
        </el-form-item>
      </el-form>
      <template #footer>
        <div class="dialog-footer">
          <el-button :loading="buttonLoading" type="primary" @click="submitForm">确 定</el-button>
          <el-button @click="cancel">取 消</el-button>
        </div>
      </template>
    </el-dialog>

    <!-- 字段配置对话框 -->
    <FieldConfigDialog v-model="showFieldConfig" :field-config-manager="fieldConfigManager" @confirm="handleFieldConfigConfirm" />
    <SearchConfigDialog v-model="searchConfigVisible" :search-config-manager="searchConfigManager" @confirm="handleSearchConfigConfirm" />
  </div>
</template>

<script setup name="DoctorInsuranceCode" lang="ts">
import {
  listDoctorInsuranceCode,
  getDoctorInsuranceCode,
  delDoctorInsuranceCode,
  addDoctorInsuranceCode,
  updateDoctorInsuranceCode
} from '@/api/doctor/doctorInsuranceCode';
import { listDoctorBasicInfo } from '@/api/doctor/doctorBasicInfo';
import { DoctorBasicInfoVO } from '@/api/doctor/doctorBasicInfo/types';
import { DoctorInsuranceCodeVO, DoctorInsuranceCodeQuery, DoctorInsuranceCodeForm } from '@/api/doctor/doctorInsuranceCode/types';
import { createDoctorInsuranceCodeFieldConfig } from '@/utils/fieldConfig';
import FieldConfigDialog from '@/components/FieldConfigDialog.vue';
import DynamicSearchForm from '@/components/DynamicSearchForm.vue';
import SearchConfigDialog from '@/components/SearchConfigDialog.vue';
import { createDoctorInsuranceCodeSearchConfig } from '@/utils/mmpSearchConfigs';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const doctorInsuranceCodeList = ref<DoctorInsuranceCodeVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const showFieldConfig = ref(false);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

// 医生选项
const doctorOptions = ref<DoctorBasicInfoVO[]>([]);

const queryFormRef = ref<ElFormInstance>();
const doctorInsuranceCodeFormRef = ref<ElFormInstance>();

// 字段配置相关变量
const fieldConfigManager = createDoctorInsuranceCodeFieldConfig();
const visibleColumns = computed(() => fieldConfigManager.getVisibleFields());
const searchConfigManager = createDoctorInsuranceCodeSearchConfig();
const searchConfigVisible = ref(false);
const visibleSearchFields = computed(() => searchConfigManager.getVisibleFields());

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: DoctorInsuranceCodeForm = {
  id: undefined,
  doctorId: undefined,
  insuranceCode: undefined,
  insuranceType: undefined,
  validDate: undefined,
  status: undefined,
  applyDate: undefined,
  approveDate: undefined,
  remark: undefined,
  delFlag: undefined
};
const data = reactive<PageData<DoctorInsuranceCodeForm, DoctorInsuranceCodeQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    doctorId: undefined,
    insuranceCode: undefined,
    insuranceType: undefined,
    validDate: undefined,
    status: undefined,
    applyDate: undefined,
    approveDate: undefined,
    delFlag: undefined,
    params: {}
  },
  rules: {
    id: [{ required: true, message: '主键ID不能为空', trigger: 'blur' }],
    doctorId: [{ required: true, message: '医生ID不能为空', trigger: 'blur' }]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询医保医师码列表 */
const getList = async () => {
  loading.value = true;
  const res = await listDoctorInsuranceCode(queryParams.value);
  doctorInsuranceCodeList.value = res.rows;
  total.value = res.total;
  loading.value = false;
};

/** 加载医生选项 */
const loadDoctorOptions = async () => {
  try {
    const res = await listDoctorBasicInfo({ pageSize: 1000 });
    doctorOptions.value = res.rows;
  } catch (error) {
    console.error('获取医生列表失败:', error);
    doctorOptions.value = [];
  }
};

/** 获取医生姓名 */
const getDoctorName = (doctorId: string | number) => {
  const doctor = doctorOptions.value.find(d => d.id === doctorId);
  return doctor ? doctor.doctorName : `医生ID: ${doctorId}`;
};

/** 取消按钮 */
const cancel = () => {
  reset();
  dialog.visible = false;
};

/** 表单重置 */
const reset = () => {
  form.value = { ...initFormData };
  doctorInsuranceCodeFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: DoctorInsuranceCodeVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加医保医师码';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: DoctorInsuranceCodeVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getDoctorInsuranceCode(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改医保医师码';
};

/** 提交按钮 */
const submitForm = () => {
  doctorInsuranceCodeFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateDoctorInsuranceCode(form.value).finally(() => (buttonLoading.value = false));
      } else {
        await addDoctorInsuranceCode(form.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: DoctorInsuranceCodeVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除医保医师码编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delDoctorInsuranceCode(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/doctorInsuranceCode/export',
    {
      ...queryParams.value
    },
    `doctorInsuranceCode_${new Date().getTime()}.xlsx`
  );
};

/** 字段配置确认 */
const handleFieldConfigConfirm = () => {
  // 字段配置更新后刷新列表
  getList();
};

const handleSearchConfig = () => {
  searchConfigVisible.value = true;
};
const handleSearchConfigConfirm = () => {
  searchConfigVisible.value = false;
};

onMounted(() => {
  getList();
  loadDoctorOptions();
});
</script>
