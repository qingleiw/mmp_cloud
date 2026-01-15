<template>
  <div class="app-container">
    <!-- 页面头部 -->
    <div class="page-header">
      <div class="header-title">
        <i-ep-document-checked />
        资质考试安排管理
      </div>
      <div class="header-desc">管理系统资质考试安排信息，包括考试基本信息、时间安排和考生管理等</div>
    </div>

    <!-- 搜索区域 -->
    <el-card class="search-card" shadow="hover">
      <template #header>
        <div class="flex items-center justify-between">
          <div class="flex items-center gap-2">
            <i-ep-search class="search-icon"></i-ep-search>
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
        <span class="font-medium">考试安排列表</span>
        <el-tag type="info" size="small" class="ml-2">{{ total }} 条记录</el-tag>
        <div class="ml-auto flex items-center gap-2">
          <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['qualification:qualificationExamArrangement:add']"
            >新增</el-button
          >
          <el-button
            type="success"
            plain
            icon="Edit"
            :disabled="single"
            @click="handleUpdate()"
            v-hasPermi="['qualification:qualificationExamArrangement:edit']"
            >修改</el-button
          >
          <el-button
            type="danger"
            plain
            icon="Delete"
            :disabled="multiple"
            @click="handleDelete()"
            v-hasPermi="['qualification:qualificationExamArrangement:remove']"
            >删除</el-button
          >
          <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['qualification:qualificationExamArrangement:export']"
            >导出</el-button
          >
          <el-button type="info" plain icon="Setting" @click="showFieldConfig = true">字段配置</el-button>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </div>
      </div>

      <el-table v-loading="loading" border :data="qualificationExamArrangementList" @selection-change="handleSelectionChange">
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
            <span v-if="field.prop === 'examStartTime' || field.prop === 'examEndTime'">{{ parseTime(scope.row[field.prop], '{y}-{m}-{d}') }}</span>
            <el-tag v-else-if="field.prop === 'examStatus'" :type="getExamStatusTagType(scope.row[field.prop])">
              {{ getExamStatusLabel(scope.row[field.prop]) }}
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
                v-hasPermi="['qualification:qualificationExamArrangement:edit']"
              ></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button
                link
                type="primary"
                icon="Delete"
                @click="handleDelete(scope.row)"
                v-hasPermi="['qualification:qualificationExamArrangement:remove']"
              ></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <div class="pagination-container">
        <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
      </div>
    </div>
    <!-- 添加或修改资质考试安排对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="700px" append-to-body>
      <el-form ref="qualificationExamArrangementFormRef" :model="form" :rules="rules" label-width="120px">
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="考试编号" prop="examCode">
              <el-input v-model="form.examCode" placeholder="请输入考试编号" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="考试名称" prop="examName">
              <el-input v-model="form.examName" placeholder="请输入考试名称" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="试卷ID" prop="paperId">
              <el-input v-model="form.paperId" placeholder="请输入试卷ID" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="资质ID" prop="qualificationId">
              <el-input v-model="form.qualificationId" placeholder="请输入资质ID" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="考试开始时间" prop="examStartTime">
              <el-date-picker
                clearable
                v-model="form.examStartTime"
                type="datetime"
                value-format="YYYY-MM-DD HH:mm:ss"
                placeholder="请选择考试开始时间"
                style="width: 100%"
              >
              </el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="考试结束时间" prop="examEndTime">
              <el-date-picker
                clearable
                v-model="form.examEndTime"
                type="datetime"
                value-format="YYYY-MM-DD HH:mm:ss"
                placeholder="请选择考试结束时间"
                style="width: 100%"
              >
              </el-date-picker>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="考试状态" prop="examStatus">
              <el-select v-model="form.examStatus" placeholder="请选择考试状态" style="width: 100%">
                <el-option label="未开始" value="0" />
                <el-option label="进行中" value="1" />
                <el-option label="已结束" value="2" />
                <el-option label="已取消" value="3" />
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="删除标志" prop="delFlag">
              <el-select v-model="form.delFlag" placeholder="请选择删除标志" style="width: 100%">
                <el-option label="正常" value="0" />
                <el-option label="已删除" value="1" />
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>
        <el-form-item label="考生ID列表" prop="examineeIds">
          <el-input v-model="form.examineeIds" type="textarea" :rows="4" placeholder="请输入考生ID列表(逗号分隔)" />
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

<script setup name="QualificationExamArrangement" lang="ts">
import {
  listQualificationExamArrangement,
  getQualificationExamArrangement,
  delQualificationExamArrangement,
  addQualificationExamArrangement,
  updateQualificationExamArrangement
} from '@/api/qualification/qualificationExamArrangement';
import {
  QualificationExamArrangementVO,
  QualificationExamArrangementQuery,
  QualificationExamArrangementForm
} from '@/api/qualification/qualificationExamArrangement/types';
import { createQualificationExamArrangementFieldConfig } from '@/utils/configs/qualification/FieldConfigs';
import { createQualificationExamArrangementSearchConfig } from '@/utils/configs/qualification/SearchConfigs';
import DynamicSearchForm from '@/components/DynamicSearchForm.vue';
import FieldConfigDialog from '@/components/FieldConfigDialog.vue';
import SearchConfigDialog from '@/components/SearchConfigDialog.vue';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const qualificationExamArrangementList = ref<QualificationExamArrangementVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const showFieldConfig = ref(false);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const fieldConfigManager = createQualificationExamArrangementFieldConfig();
const searchConfigManager = createQualificationExamArrangementSearchConfig();

const queryFormRef = ref<ElFormInstance>();
const qualificationExamArrangementFormRef = ref<ElFormInstance>();

// 搜索和字段配置相关
const showSearchConfig = ref(false);
const visibleSearchFields = computed(() => searchConfigManager.getVisibleFields());

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: QualificationExamArrangementForm = {
  id: undefined,
  examCode: undefined,
  examName: undefined,
  paperId: undefined,
  qualificationId: undefined,
  examStartTime: undefined,
  examEndTime: undefined,
  examineeIds: undefined,
  examStatus: undefined,
  delFlag: undefined
};
const data = reactive<PageData<QualificationExamArrangementForm, QualificationExamArrangementQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    examCode: undefined,
    examName: undefined,
    paperId: undefined,
    qualificationId: undefined,
    examStartTime: undefined,
    examEndTime: undefined,
    examineeIds: undefined,
    examStatus: undefined,
    delFlag: undefined,
    params: {}
  },
  rules: {
    examCode: [{ required: true, message: '考试编号不能为空', trigger: 'blur' }]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 切换搜索配置对话框 */
const toggleSearchConfig = () => {
  showSearchConfig.value = !showSearchConfig.value;
};

/** 获取考试状态标签类型 */
const getExamStatusTagType = (value: string) => {
  if (value === '0') return 'info';
  if (value === '1') return 'primary';
  if (value === '2') return 'success';
  if (value === '3') return 'danger';
  return 'info';
};

/** 获取考试状态标签文本 */
const getExamStatusLabel = (value: string) => {
  if (value === '0') return '未开始';
  if (value === '1') return '进行中';
  if (value === '2') return '已结束';
  if (value === '3') return '已取消';
  return value || '未知';
};

/** 查询资质考试安排列表 */
const getList = async () => {
  loading.value = true;
  const res = await listQualificationExamArrangement(queryParams.value);
  qualificationExamArrangementList.value = res.rows;
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
  qualificationExamArrangementFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: QualificationExamArrangementVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加资质考试安排';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: QualificationExamArrangementVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getQualificationExamArrangement(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改资质考试安排';
};

/** 提交按钮 */
const submitForm = () => {
  qualificationExamArrangementFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateQualificationExamArrangement(form.value).finally(() => (buttonLoading.value = false));
      } else {
        await addQualificationExamArrangement(form.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: QualificationExamArrangementVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除资质考试安排编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delQualificationExamArrangement(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导入按钮操作占位 */
const handleImport = () => {};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/qualificationExamArrangement/export',
    {
      ...queryParams.value
    },
    `qualificationExamArrangement_${new Date().getTime()}.xlsx`
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
