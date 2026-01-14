<template>
  <div class="app-container">
    <!-- 页面标题 -->
    <div class="page-header mb-4">
      <h2 class="page-title">
        <i-ep-document-checked class="title-icon"></i-ep-document-checked>
        资质考试记录管理
      </h2>
      <p class="page-description">管理系统资质考试记录信息，包括考试成绩、答题详情和阅卷结果等</p>
    </div>

    <!-- 动态搜索表单 -->
    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <div v-show="showSearch" class="search-container mb-4">
        <el-card shadow="hover" class="search-card">
          <template #header>
            <div class="flex items-center justify-between">
              <div class="flex items-center gap-2">
                <i-ep-search class="search-icon"></i-ep-search>
                <span>搜索条件</span>
              </div>
              <el-button text type="primary" @click="toggleSearchConfig">
                <i-ep-setting class="btn-icon"></i-ep-setting>
                搜索配置
              </el-button>
            </div>
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

    <el-card shadow="never" class="table-card">
      <template #header>
        <div class="mb8 flex items-center gap-2 flex-nowrap">
          <i-ep-list class="table-icon"></i-ep-list>
          <span class="font-medium">资质考试记录列表</span>
          <el-tag type="info" size="small" class="ml-2">{{ total }} 条记录</el-tag>
          <div class="ml-auto flex items-center gap-2">
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['qualification:qualificationExamRecord:add']">新增</el-button>
            <el-button
              type="success"
              plain
              icon="Edit"
              :disabled="single"
              @click="handleUpdate()"
              v-hasPermi="['qualification:qualificationExamRecord:edit']"
              >修改</el-button
            >
            <el-button
              type="danger"
              plain
              icon="Delete"
              :disabled="multiple"
              @click="handleDelete()"
              v-hasPermi="['qualification:qualificationExamRecord:remove']"
              >删除</el-button
            >
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['qualification:qualificationExamRecord:export']"
              >导出</el-button
            >
            <el-button type="info" plain icon="Setting" @click="showFieldConfig = true">字段配置</el-button>
            <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
          </div>
        </div>
      </template>

      <el-table v-loading="loading" border :data="qualificationExamRecordList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column
          v-for="field in fieldConfigManager.visibleFields"
          :key="field.prop"
          :label="field.label"
          :prop="field.prop"
          :width="field.width"
          :min-width="field.minWidth || 120"
          resizable
          align="center"
        >
          <template #default="scope">
            <span v-if="['startTime', 'submitTime', 'markingTime'].includes(field.prop)">{{ parseTime(scope.row[field.prop], '{y}-{m}-{d}') }}</span>
            <el-tag v-else-if="field.prop === 'examResult'" :type="getExamResultTagType(scope.row[field.prop])">
              {{ getExamResultLabel(scope.row[field.prop]) }}
            </el-tag>
            <span v-else>{{ scope.row[field.prop] }}</span>
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
                v-hasPermi="['qualification:qualificationExamRecord:edit']"
              ></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button
                link
                type="primary"
                icon="Delete"
                @click="handleDelete(scope.row)"
                v-hasPermi="['qualification:qualificationExamRecord:remove']"
              ></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改资质考试记录对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="700px" append-to-body>
      <el-form ref="qualificationExamRecordFormRef" :model="form" :rules="rules" label-width="120px">
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="考试安排ID" prop="examId">
              <el-input v-model="form.examId" placeholder="请输入考试安排ID" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="试卷ID" prop="paperId">
              <el-input v-model="form.paperId" placeholder="请输入试卷ID" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="考生ID" prop="examineeId">
              <el-input v-model="form.examineeId" placeholder="请输入考生ID" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="考生姓名" prop="examineeName">
              <el-input v-model="form.examineeName" placeholder="请输入考生姓名" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="开始时间" prop="startTime">
              <el-date-picker
                clearable
                v-model="form.startTime"
                type="datetime"
                value-format="YYYY-MM-DD HH:mm:ss"
                placeholder="请选择开始时间"
                style="width: 100%"
              >
              </el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="提交时间" prop="submitTime">
              <el-date-picker
                clearable
                v-model="form.submitTime"
                type="datetime"
                value-format="YYYY-MM-DD HH:mm:ss"
                placeholder="请选择提交时间"
                style="width: 100%"
              >
              </el-date-picker>
            </el-form-item>
          </el-col>
        </el-row>
        <el-form-item label="答题卡" prop="answerSheet">
          <el-input v-model="form.answerSheet" type="textarea" :rows="4" placeholder="请输入答题卡JSON" />
        </el-form-item>
        <el-row :gutter="20">
          <el-col :span="8">
            <el-form-item label="客观题得分" prop="objectiveScore">
              <el-input-number v-model="form.objectiveScore" :min="0" :max="999" :precision="1" placeholder="请输入客观题得分" style="width: 100%" />
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="主观题得分" prop="subjectiveScore">
              <el-input-number v-model="form.subjectiveScore" :min="0" :max="999" :precision="1" placeholder="请输入主观题得分" style="width: 100%" />
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="总分" prop="totalScore">
              <el-input-number v-model="form.totalScore" :min="0" :max="999" :precision="1" placeholder="请输入总分" style="width: 100%" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="20">
          <el-col :span="8">
            <el-form-item label="考试结果" prop="examResult">
              <el-select v-model="form.examResult" placeholder="请选择考试结果" style="width: 100%">
                <el-option label="及格" value="及格" />
                <el-option label="不及格" value="不及格" />
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="阅卷状态" prop="markingStatus">
              <el-select v-model="form.markingStatus" placeholder="请选择阅卷状态" style="width: 100%">
                <el-option label="未阅卷" value="0" />
                <el-option label="阅卷中" value="1" />
                <el-option label="已阅卷" value="2" />
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="阅卷人" prop="marker">
              <el-input v-model="form.marker" placeholder="请输入阅卷人" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-form-item label="阅卷时间" prop="markingTime">
          <el-date-picker
            clearable
            v-model="form.markingTime"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择阅卷时间"
            style="width: 200px"
          >
          </el-date-picker>
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
    <FieldConfigDialog v-model:visible="showFieldConfig" :field-config-manager="fieldConfigManager" @confirm="handleFieldConfigConfirm" />
    <SearchConfigDialog v-model="showSearchConfig" :search-config-manager="searchConfigManager" @confirm="handleSearchConfigConfirm" />
  </div>
</template>

<script setup name="QualificationExamRecord" lang="ts">
import {
  listQualificationExamRecord,
  getQualificationExamRecord,
  delQualificationExamRecord,
  addQualificationExamRecord,
  updateQualificationExamRecord
} from '@/api/qualification/qualificationExamRecord';
import { QualificationExamRecordVO, QualificationExamRecordQuery, QualificationExamRecordForm } from '@/api/qualification/qualificationExamRecord/types';
import { createQualificationExamRecordFieldConfig } from '@/utils/mmpFieldConfigs';
import { createQualificationExamRecordSearchConfig } from '@/utils/mmpSearchConfigs';
import DynamicSearchForm from '@/components/DynamicSearchForm.vue';
import FieldConfigDialog from '@/components/FieldConfigDialog.vue';
import SearchConfigDialog from '@/components/SearchConfigDialog.vue';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const qualificationExamRecordList = ref<QualificationExamRecordVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const showFieldConfig = ref(false);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const fieldConfigManager = createQualificationExamRecordFieldConfig();
const searchConfigManager = createQualificationExamRecordSearchConfig();

const queryFormRef = ref<ElFormInstance>();
const qualificationExamRecordFormRef = ref<ElFormInstance>();

// 搜索和字段配置相关
const showSearchConfig = ref(false);
const visibleSearchFields = computed(() => searchConfigManager.getVisibleFields());

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: QualificationExamRecordForm = {
  id: undefined,
  examId: undefined,
  examineeId: undefined,
  examineeName: undefined,
  paperId: undefined,
  startTime: undefined,
  submitTime: undefined,
  answerSheet: undefined,
  objectiveScore: undefined,
  subjectiveScore: undefined,
  totalScore: undefined,
  examResult: undefined,
  markingStatus: undefined,
  marker: undefined,
  markingTime: undefined
};
const data = reactive<PageData<QualificationExamRecordForm, QualificationExamRecordQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    examId: undefined,
    examineeId: undefined,
    examineeName: undefined,
    paperId: undefined,
    startTime: undefined,
    submitTime: undefined,
    answerSheet: undefined,
    objectiveScore: undefined,
    subjectiveScore: undefined,
    totalScore: undefined,
    examResult: undefined,
    markingStatus: undefined,
    marker: undefined,
    markingTime: undefined,
    params: {}
  },
  rules: {
    examId: [{ required: true, message: '考试安排ID不能为空', trigger: 'blur' }],
    examineeId: [{ required: true, message: '考生ID不能为空', trigger: 'blur' }]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 切换搜索配置对话框 */
const toggleSearchConfig = () => {
  showSearchConfig.value = !showSearchConfig.value;
};

/** 获取考试结果标签类型 */
const getExamResultTagType = (value: string) => {
  if (value === '及格') return 'success';
  if (value === '不及格') return 'danger';
  return 'info';
};

/** 获取考试结果标签文本 */
const getExamResultLabel = (value: string) => {
  return value || '未知';
};

/** 查询资质考试记录列表 */
const getList = async () => {
  loading.value = true;
  const res = await listQualificationExamRecord(queryParams.value);
  qualificationExamRecordList.value = res.rows;
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
  qualificationExamRecordFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: QualificationExamRecordVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加资质考试记录';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: QualificationExamRecordVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getQualificationExamRecord(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改资质考试记录';
};

/** 提交按钮 */
const submitForm = () => {
  qualificationExamRecordFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateQualificationExamRecord(form.value).finally(() => (buttonLoading.value = false));
      } else {
        await addQualificationExamRecord(form.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: QualificationExamRecordVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除资质考试记录编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delQualificationExamRecord(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导入按钮操作占位 */
const handleImport = () => {};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/qualificationExamRecord/export',
    {
      ...queryParams.value
    },
    `qualificationExamRecord_${new Date().getTime()}.xlsx`
  );
};

/** 字段配置确认 */
const handleFieldConfigConfirm = () => {
  showFieldConfig.value = false;
  // 字段配置已保存到localStorage，无需额外操作
};

/** 搜索配置确认 */
const handleSearchConfigConfirm = () => {
  showSearchConfig.value = false;
  // 搜索配置已保存到localStorage，无需额外操作
};

onMounted(() => {
  getList();
});
</script>
<style scoped>
.page-description {
  font-size: 13px;
  color: #86909c;
  line-height: 1.6;
}
.table-card {
  background: white;
  border-radius: 8px;
  padding: 12px;
}
.table-card .mb8 {
  min-height: 44px;
  padding: 6px 8px;
  display: flex;
  align-items: center;
}
</style>
