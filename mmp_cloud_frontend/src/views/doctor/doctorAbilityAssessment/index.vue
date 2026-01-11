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
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['system:doctorAbilityAssessment:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button
              type="success"
              plain
              icon="Edit"
              :disabled="single"
              @click="handleUpdate()"
              v-hasPermi="['system:doctorAbilityAssessment:edit']"
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
              v-hasPermi="['system:doctorAbilityAssessment:remove']"
              >删除</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['system:doctorAbilityAssessment:export']"
              >导出</el-button
            >
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

      <el-table v-loading="loading" border :data="doctorAbilityAssessmentList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column
          v-for="field in visibleColumns"
          :key="field.prop"
          :label="field.label"
          align="center"
          :prop="field.prop"
          :width="field.width || undefined"
        >
          <template #default="scope" v-if="field.prop === 'assessmentDate' || field.prop === 'createTime' || field.prop === 'updateTime'">
            <span>{{ parseTime(scope.row[field.prop], '{y}-{m}-{d} {h}:{i}:{s}') }}</span>
          </template>
          <template #default="scope" v-else-if="field.prop === 'delFlag'">
            <el-tag :type="scope.row[field.prop] === 0 ? 'success' : 'danger'">
              {{ scope.row[field.prop] === 0 ? '否' : '是' }}
            </el-tag>
          </template>
          <template #default="scope" v-else>
            {{ scope.row[field.prop] }}
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
                v-hasPermi="['system:doctorAbilityAssessment:edit']"
              ></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button
                link
                type="primary"
                icon="Delete"
                @click="handleDelete(scope.row)"
                v-hasPermi="['system:doctorAbilityAssessment:remove']"
              ></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改医师能力评估对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="doctorAbilityAssessmentFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="医生ID" prop="doctorId">
          <el-input v-model="form.doctorId" placeholder="请输入医生ID" />
        </el-form-item>
        <el-form-item label="评估年度" prop="assessmentYear">
          <el-input v-model="form.assessmentYear" placeholder="请输入评估年度" />
        </el-form-item>
        <el-form-item label="临床能力得分" prop="clinicalAbilityScore">
          <el-input v-model="form.clinicalAbilityScore" placeholder="请输入临床能力得分" />
        </el-form-item>
        <el-form-item label="教学能力得分" prop="teachingAbilityScore">
          <el-input v-model="form.teachingAbilityScore" placeholder="请输入教学能力得分" />
        </el-form-item>
        <el-form-item label="科研能力得分" prop="researchAbilityScore">
          <el-input v-model="form.researchAbilityScore" placeholder="请输入科研能力得分" />
        </el-form-item>
        <el-form-item label="管理能力得分" prop="managementAbilityScore">
          <el-input v-model="form.managementAbilityScore" placeholder="请输入管理能力得分" />
        </el-form-item>
        <el-form-item label="总分" prop="totalScore">
          <el-input v-model="form.totalScore" placeholder="请输入总分" />
        </el-form-item>
        <el-form-item label="评估结果 优秀/良好/合格/不合格" prop="assessmentResult">
          <el-input v-model="form.assessmentResult" placeholder="请输入评估结果 优秀/良好/合格/不合格" />
        </el-form-item>
        <el-form-item label="评估人" prop="assessor">
          <el-input v-model="form.assessor" placeholder="请输入评估人" />
        </el-form-item>
        <el-form-item label="评估日期" prop="assessmentDate">
          <el-date-picker clearable v-model="form.assessmentDate" type="datetime" value-format="YYYY-MM-DD HH:mm:ss" placeholder="请选择评估日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="评估意见" prop="remark">
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

<script setup name="DoctorAbilityAssessment" lang="ts">
import {
  listDoctorAbilityAssessment,
  getDoctorAbilityAssessment,
  delDoctorAbilityAssessment,
  addDoctorAbilityAssessment,
  updateDoctorAbilityAssessment
} from '@/api/doctor/doctorAbilityAssessment';
import { DoctorAbilityAssessmentVO, DoctorAbilityAssessmentQuery, DoctorAbilityAssessmentForm } from '@/api/doctor/doctorAbilityAssessment/types';
import FieldConfigDialog from '@/components/FieldConfigDialog.vue';
import { createDoctorAbilityAssessmentFieldConfig } from '@/utils/mmpFieldConfigs';
import DynamicSearchForm from '@/components/DynamicSearchForm.vue';
import SearchConfigDialog from '@/components/SearchConfigDialog.vue';
import RightToolbar from '@/components/RightToolbar/index.vue';
import Pagination from '@/components/Pagination/index.vue';
import { createDoctorAbilityAssessmentSearchConfig } from '@/utils/mmpSearchConfigs';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const doctorAbilityAssessmentList = ref<DoctorAbilityAssessmentVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const showFieldConfig = ref(false);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const doctorAbilityAssessmentFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: DoctorAbilityAssessmentForm = {
  id: undefined,
  doctorId: undefined,
  assessmentYear: undefined,
  assessmentType: undefined,
  clinicalAbilityScore: undefined,
  teachingAbilityScore: undefined,
  researchAbilityScore: undefined,
  managementAbilityScore: undefined,
  totalScore: undefined,
  assessmentResult: undefined,
  assessor: undefined,
  assessmentDate: undefined,
  remark: undefined,
  delFlag: undefined
};
const data = reactive<PageData<DoctorAbilityAssessmentForm, DoctorAbilityAssessmentQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    doctorId: undefined,
    assessmentYear: undefined,
    assessmentType: undefined,
    clinicalAbilityScore: undefined,
    teachingAbilityScore: undefined,
    researchAbilityScore: undefined,
    managementAbilityScore: undefined,
    totalScore: undefined,
    assessmentResult: undefined,
    assessor: undefined,
    assessmentDate: undefined,
    delFlag: undefined,
    params: {}
  },
  rules: {
    id: [{ required: true, message: '主键ID不能为空', trigger: 'blur' }],
    doctorId: [{ required: true, message: '医生ID不能为空', trigger: 'blur' }]
  }
});

const { queryParams, form, rules } = toRefs(data);

// 字段配置管理器
const fieldConfigManager = createDoctorAbilityAssessmentFieldConfig();

// 初始化时清除之前的字段配置和localStorage缓存，确保新配置生效
fieldConfigManager.clearConfig();
localStorage.removeItem('doctorAbilityAssessment_field_config');

// 计算可见列
const visibleColumns = computed(() => {
  return fieldConfigManager.getVisibleFields();
});
const searchConfigManager = createDoctorAbilityAssessmentSearchConfig();
const searchConfigVisible = ref(false);
const visibleSearchFields = computed(() => searchConfigManager.getVisibleFields());

/** 查询医师能力评估列表 */
const getList = async () => {
  loading.value = true;
  const res = await listDoctorAbilityAssessment(queryParams.value);
  doctorAbilityAssessmentList.value = res.rows;
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
  doctorAbilityAssessmentFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: DoctorAbilityAssessmentVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加医师能力评估';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: DoctorAbilityAssessmentVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getDoctorAbilityAssessment(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改医师能力评估';
};

/** 提交按钮 */
const submitForm = () => {
  doctorAbilityAssessmentFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateDoctorAbilityAssessment(form.value).finally(() => (buttonLoading.value = false));
      } else {
        await addDoctorAbilityAssessment(form.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: DoctorAbilityAssessmentVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除医师能力评估编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delDoctorAbilityAssessment(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/doctorAbilityAssessment/export',
    {
      ...queryParams.value
    },
    `doctorAbilityAssessment_${new Date().getTime()}.xlsx`
  );
};

/** 字段配置确认 */
const handleFieldConfigConfirm = (config: any) => {
  fieldConfigManager.saveConfig(config);
  showFieldConfig.value = false;
};

const handleSearchConfig = () => {
  searchConfigVisible.value = true;
};

const handleSearchConfigConfirm = () => {
  searchConfigVisible.value = false;
};

/** 重置字段配置 */
const handleFieldConfigReset = () => {
  fieldConfigManager.clearConfig();
  // 同时清除localStorage中的缓存
  localStorage.removeItem('doctorAbilityAssessment_field_config');
  proxy?.$modal.msgSuccess('字段配置已重置，请刷新页面');
};

onMounted(() => {
  getList();
});
</script>
