<template>
  <div class="app-container">
    <!-- 页面头部 -->
    <div class="page-header">
      <div class="header-title">
        <i-ep-document-checked />
        资质考试题目管理
      </div>
      <div class="header-desc">管理系统资质考试题目，包括题目内容、选项、答案、难度设置等信息</div>
    </div>

    <!-- 搜索区域 -->
    <el-card class="search-card" shadow="hover">
      <template #header>
        <div class="flex items-center justify-between">
          <div class="flex items-center gap-2">
            <i-ep-search />
            <span>搜索条件</span>
          </div>
          <el-button type="info" text icon="Setting" @click="toggleSearchConfig">搜索配置</el-button>
        </div>
      </template>
      <DynamicSearchForm ref="queryFormRef" :query="queryParams" :visible-fields="visibleSearchFields" @search="handleQuery" @reset="resetQuery" />
    </el-card>

    <!-- 数据表格 -->
    <div class="table-card">
      <div class="mb8 flex items-center gap-2 flex-nowrap">
        <i-ep-list />
        <span class="font-medium">考试题目列表</span>
        <el-tag type="info" size="small" class="ml-2">{{ total }} 条记录</el-tag>
        <div class="ml-auto flex items-center gap-2">
          <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['system:qualificationExamQuestion:add']">新增</el-button>
          <el-button
            type="success"
            plain
            icon="Edit"
            :disabled="single"
            @click="handleUpdate()"
            v-hasPermi="['system:qualificationExamQuestion:edit']"
            >修改</el-button
          >
          <el-button
            type="danger"
            plain
            icon="Delete"
            :disabled="multiple"
            @click="handleDelete()"
            v-hasPermi="['system:qualificationExamQuestion:remove']"
            >删除</el-button
          >
          <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['system:qualificationExamQuestion:export']"
            >导出</el-button
          >
          <el-button type="info" plain icon="Setting" @click="showFieldConfig = true">字段配置</el-button>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </div>
      </div>

      <el-table
        v-loading="loading"
        border
        :data="qualificationExamQuestionList"
        @selection-change="handleSelectionChange"
        class="record-table"
        :default-sort="{ prop: 'createTime', order: 'descending' }"
      >
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column
          v-for="field in visibleColumns"
          :key="field.prop"
          :label="field.label"
          :prop="field.prop"
          :width="field.width"
          align="center"
          show-overflow-tooltip
          :sortable="false"
          :resizable="true"
        >
          <template #default="scope">
            <!-- 题型标签 -->
            <el-tag v-if="field.prop === 'questionType'" :type="getQuestionTypeTagType(scope.row.questionType)" size="small">
              {{ getQuestionTypeLabel(scope.row.questionType) }}
            </el-tag>
            <!-- 难度级别标签 -->
            <el-tag v-else-if="field.prop === 'difficultyLevel'" :type="getDifficultyTagType(scope.row.difficultyLevel)" size="small">
              {{ getDifficultyLabel(scope.row.difficultyLevel) }}
            </el-tag>
            <!-- 启用状态标签 -->
            <el-tag v-else-if="field.prop === 'isEnabled'" :type="scope.row.isEnabled === 1 ? 'success' : 'danger'" size="small">
              {{ scope.row.isEnabled === 1 ? '启用' : '禁用' }}
            </el-tag>
            <!-- 删除标志状态标签 -->
            <el-tag v-else-if="field.prop === 'delFlag'" :type="scope.row.delFlag === 0 ? 'success' : 'danger'" size="small">
              {{ scope.row.delFlag === 0 ? '正常' : '已删除' }}
            </el-tag>
            <!-- 默认显示 -->
            <span v-else>{{ scope.row[field.prop] }}</span>
          </template>
        </el-table-column>
        <el-table-column label="操作" align="center" width="120" class-name="small-padding fixed-width">
          <template #default="scope">
            <el-button link type="primary" @click="handleView(scope.row)"><i-ep-view />查看</el-button>
          </template>
        </el-table-column>
      </el-table>

      <div class="pagination-container">
        <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
      </div>
    </div>

    <!-- 添加或修改资质考核题库对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="700px" append-to-body>
      <el-form ref="qualificationExamQuestionFormRef" :model="form" :rules="rules" label-width="120px">
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="题目编号" prop="questionCode">
              <el-input v-model="form.questionCode" placeholder="请输入题目编号" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="关联资质ID" prop="qualificationId">
              <el-input v-model="form.qualificationId" placeholder="请输入关联资质ID" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="题目类型" prop="questionType">
              <el-select v-model="form.questionType" placeholder="请选择题目类型" style="width: 100%">
                <el-option label="单选题" value="单选题" />
                <el-option label="多选题" value="多选题" />
                <el-option label="判断题" value="判断题" />
                <el-option label="填空题" value="填空题" />
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="分值" prop="score">
              <el-input-number v-model="form.score" :min="0" :max="100" :precision="1" placeholder="请输入分值" style="width: 100%" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-form-item label="题目内容">
          <editor v-model="form.questionContent" :min-height="192" />
        </el-form-item>
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="选项A" prop="optionA">
              <el-input v-model="form.optionA" type="textarea" :rows="2" placeholder="请输入选项A" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="选项B" prop="optionB">
              <el-input v-model="form.optionB" type="textarea" :rows="2" placeholder="请输入选项B" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="选项C" prop="optionC">
              <el-input v-model="form.optionC" type="textarea" :rows="2" placeholder="请输入选项C" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="选项D" prop="optionD">
              <el-input v-model="form.optionD" type="textarea" :rows="2" placeholder="请输入选项D" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="选项E" prop="optionE">
              <el-input v-model="form.optionE" type="textarea" :rows="2" placeholder="请输入选项E" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="正确答案" prop="correctAnswer">
              <el-input v-model="form.correctAnswer" placeholder="请输入正确答案" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="20">
          <el-col :span="8">
            <el-form-item label="难度级别" prop="difficultyLevel">
              <el-select v-model="form.difficultyLevel" placeholder="请选择难度级别" style="width: 100%">
                <el-option label="易" value="1" />
                <el-option label="中" value="2" />
                <el-option label="难" value="3" />
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="是否启用" prop="isEnabled">
              <el-select v-model="form.isEnabled" placeholder="请选择是否启用" style="width: 100%">
                <el-option label="启用" value="1" />
                <el-option label="禁用" value="0" />
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="删除标志" prop="delFlag">
              <el-select v-model="form.delFlag" placeholder="请选择删除标志" style="width: 100%">
                <el-option label="正常" value="0" />
                <el-option label="已删除" value="1" />
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>
        <el-form-item label="答案解析" prop="answerAnalysis">
          <el-input v-model="form.answerAnalysis" type="textarea" :rows="4" placeholder="请输入答案解析" />
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
    <!-- 搜索配置对话框 -->
    <SearchConfigDialog v-model="searchConfigVisible" :search-config-manager="searchConfigManager" @confirm="handleSearchConfigConfirm" />
  </div>
</template>

<script setup name="QualificationExamQuestion" lang="ts">
import {
  listQualificationExamQuestion,
  getQualificationExamQuestion,
  delQualificationExamQuestion,
  addQualificationExamQuestion,
  updateQualificationExamQuestion
} from '@/api/system/qualificationExamQuestion';
import {
  QualificationExamQuestionVO,
  QualificationExamQuestionQuery,
  QualificationExamQuestionForm
} from '@/api/system/qualificationExamQuestion/types';
import { createQualificationExamQuestionFieldConfig } from '@/utils/mmpFieldConfigs';
import { createQualificationExamQuestionSearchConfig } from '@/utils/mmpSearchConfigs';
import DynamicSearchForm from '@/components/DynamicSearchForm.vue';
import FieldConfigDialog from '@/components/FieldConfigDialog.vue';
import SearchConfigDialog from '@/components/SearchConfigDialog.vue';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const qualificationExamQuestionList = ref<QualificationExamQuestionVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const showFieldConfig = ref(false);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const qualificationExamQuestionFormRef = ref<ElFormInstance>();

// 字段配置和搜索配置管理器
const fieldConfigManager = createQualificationExamQuestionFieldConfig();
const visibleColumns = computed(() => fieldConfigManager.getVisibleFields());
const searchConfigManager = createQualificationExamQuestionSearchConfig();
const searchConfigVisible = ref(false);
const visibleSearchFields = computed(() => searchConfigManager.getVisibleFields());

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: QualificationExamQuestionForm = {
  id: undefined,
  questionCode: undefined,
  qualificationId: undefined,
  questionType: undefined,
  questionContent: undefined,
  optionA: undefined,
  optionB: undefined,
  optionC: undefined,
  optionD: undefined,
  optionE: undefined,
  correctAnswer: undefined,
  answerAnalysis: undefined,
  difficultyLevel: undefined,
  score: undefined,
  isEnabled: undefined,
  delFlag: undefined
};
const data = reactive<PageData<QualificationExamQuestionForm, QualificationExamQuestionQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    questionCode: undefined,
    qualificationId: undefined,
    questionType: undefined,
    questionContent: undefined,
    optionA: undefined,
    optionB: undefined,
    optionC: undefined,
    optionD: undefined,
    optionE: undefined,
    correctAnswer: undefined,
    answerAnalysis: undefined,
    difficultyLevel: undefined,
    score: undefined,
    isEnabled: undefined,
    delFlag: undefined,
    params: {}
  },
  rules: {
    questionCode: [{ required: true, message: '题目编号不能为空', trigger: 'blur' }]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 获取题型标签类型 */
const getQuestionTypeTagType = (value: string) => {
  if (value === 'single') return 'primary';
  if (value === 'multiple') return 'success';
  if (value === 'judgment') return 'warning';
  if (value === 'essay') return 'info';
  return 'info';
};

/** 获取题型标签文本 */
const getQuestionTypeLabel = (value: string) => {
  if (value === 'single') return '单选';
  if (value === 'multiple') return '多选';
  if (value === 'judgment') return '判断';
  if (value === 'essay') return '简答';
  return value || '未知';
};

/** 获取难度标签类型 */
const getDifficultyTagType = (value: string) => {
  if (value === '1') return 'success';
  if (value === '2') return 'warning';
  if (value === '3') return 'danger';
  return 'info';
};

/** 获取难度标签文本 */
const getDifficultyLabel = (value: string) => {
  if (value === '1') return '易';
  if (value === '2') return '中';
  if (value === '3') return '难';
  return value || '未知';
};

/** 切换搜索配置对话框 */
const toggleSearchConfig = () => {
  searchConfigVisible.value = !searchConfigVisible.value;
};

/** 搜索配置确认 */
const handleSearchConfigConfirm = () => {
  searchConfigVisible.value = false;
  // 搜索配置已保存到localStorage，无需额外操作
};

/** 搜索项配置 */
const handleSearchConfig = () => {
  searchConfigVisible.value = true;
};
const getList = async () => {
  loading.value = true;
  const res = await listQualificationExamQuestion(queryParams.value);
  qualificationExamQuestionList.value = res.rows;
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
  qualificationExamQuestionFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: QualificationExamQuestionVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加资质考核题库';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: QualificationExamQuestionVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getQualificationExamQuestion(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改资质考核题库';
};

/** 提交按钮 */
const submitForm = () => {
  qualificationExamQuestionFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateQualificationExamQuestion(form.value).finally(() => (buttonLoading.value = false));
      } else {
        await addQualificationExamQuestion(form.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: QualificationExamQuestionVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除资质考核题库编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delQualificationExamQuestion(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导入按钮操作占位 */
const handleImport = () => {};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/qualificationExamQuestion/export',
    {
      ...queryParams.value
    },
    `qualificationExamQuestion_${new Date().getTime()}.xlsx`
  );
};

/** 字段配置确认 */
const handleFieldConfigConfirm = () => {
  showFieldConfig.value = false;
  // 字段配置已保存到localStorage，无需额外操作
};

onMounted(() => {
  getList();
});

const handleView = (row: QualificationExamQuestionVO) => {
  proxy?.$modal.alert(`查看题目：${(row as any).questionCode || ''}`);
};
</script>
<style scoped>
.page-header .header-desc {
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
