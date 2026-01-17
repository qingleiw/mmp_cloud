<template>
  <div class="app-container">
    <!-- 页面标题 -->
    <div class="page-header mb-4">
      <h2 class="page-title">
        <i-ep-document-copy class="title-icon"></i-ep-document-copy>
        考试试卷管理
      </h2>
      <p class="page-description">管理考试试卷和题库</p>
    </div>












      <div class="header-desc">管理系统资质考试试卷信息，包括试卷基本信息、题目设置和考试规则等</div>
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
    
    <!-- 字段配置对话框 -->
    <FieldConfigDialog
      v-model:visible="fieldConfigVisible"
      :config="[]"
      title="列表字段配置"
    />
  </template>
      <DynamicSearchForm ref="queryFormRef" :query="queryParams" :visible-fields="visibleSearchFields" @search="handleQuery" @reset="resetQuery" />
    </el-card>

    <!-- 数据表格 -->
    <div class="table-card">
      <div class="mb8 flex items-center gap-2 flex-nowrap">
        <i-ep-list />
        <span class="font-medium">资质考试试卷列表</span>
        <el-tag type="info" size="small" class="ml-2">{{ total }} 条记录</el-tag>
        <div class="ml-auto flex items-center gap-2">
          <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['qualification:qualificationExamPaper:add']">新增</el-button>
          <el-button
            type="success"
            plain
            icon="Edit"
            :disabled="single"
            @click="handleUpdate()"
            v-hasPermi="['qualification:qualificationExamPaper:edit']"
            >修改</el-button
          >
          <el-button
            type="danger"
            plain
            icon="Delete"
            :disabled="multiple"
            @click="handleDelete()"
            v-hasPermi="['qualification:qualificationExamPaper:remove']"
            >删除</el-button
          >
          <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['qualification:qualificationExamPaper:export']"
            >导出</el-button
          >
          <el-button type="info" plain icon="Setting" @click="showFieldConfig = true">字段配置</el-button>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </div>
      </div>

      <el-table v-loading="loading" border :data="qualificationExamPaperList" @selection-change="handleSelectionChange">
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
            <el-tag v-if="field.prop === 'isEnabled'" :type="scope.row[field.prop] === '1' ? 'success' : 'danger'">
              {{ scope.row[field.prop] === '1' ? '启用' : '禁用' }}
            </el-tag>
            <el-tag v-else-if="field.prop === 'isRandom'" :type="scope.row[field.prop] === '1' ? 'primary' : 'info'">
              {{ scope.row[field.prop] === '1' ? '随机抽题' : '固定题目' }}
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
                v-hasPermi="['qualification:qualificationExamPaper:edit']"
              ></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button
                link
                type="primary"
                icon="Delete"
                @click="handleDelete(scope.row)"
                v-hasPermi="['qualification:qualificationExamPaper:remove']"
              ></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <div class="pagination-container">
        <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
      </div>
    </div>
    <!-- 添加或修改资质考核试卷对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="700px" append-to-body>
      <el-form ref="qualificationExamPaperFormRef" :model="form" :rules="rules" label-width="120px">
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="试卷编号" prop="paperCode">
              <el-input v-model="form.paperCode" placeholder="请输入试卷编号" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="试卷名称" prop="paperName">
              <el-input v-model="form.paperName" placeholder="请输入试卷名称" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="关联资质ID" prop="qualificationId">
              <el-input v-model="form.qualificationId" placeholder="请输入关联资质ID" />
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="总分" prop="totalScore">
              <el-input-number v-model="form.totalScore" :min="0" :max="999" placeholder="请输入总分" style="width: 100%" />
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="及格分" prop="passScore">
              <el-input-number v-model="form.passScore" :min="0" :max="999" placeholder="请输入及格分" style="width: 100%" />
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="考试时长" prop="examDuration">
              <el-input-number v-model="form.examDuration" :min="1" :max="999" placeholder="请输入考试时长(分钟)" style="width: 100%" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="20">
          <el-col :span="8">
            <el-form-item label="是否随机抽题" prop="isRandom">
              <el-select v-model="form.isRandom" placeholder="请选择是否随机抽题" style="width: 100%">
                <el-option label="是" value="1" />
                <el-option label="否" value="0" />
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
        <el-form-item label="题目ID列表" prop="questionIds">
          <el-input v-model="form.questionIds" type="textarea" :rows="4" placeholder="请输入题目ID列表JSON" />
        </el-form-item>
        <el-form-item label="随机规则" prop="randomRule">
          <el-input v-model="form.randomRule" type="textarea" :rows="3" placeholder="请输入随机规则JSON" />
        </el-form-item>
      </el-form>
      <template #footer>
        <div class="dialog-footer">
          <el-button :loading="buttonLoading" type="primary" @click="submitForm">确 定</el-button>
          <el-button @click="cancel">取 消</el-button>
        </div>
      </template>
    </el-dialog><SearchConfigDialog v-model="showSearchConfig" :search-config-manager="searchConfigManager" @confirm="handleSearchConfigConfirm" />
  </div>
</template>

<script setup name="QualificationExamPaper" lang="ts">
import {
  listQualificationExamPaper,
  getQualificationExamPaper,
  delQualificationExamPaper,
  addQualificationExamPaper,
  updateQualificationExamPaper
} from '@/api/qualification/qualificationExamPaper';
import { QualificationExamPaperVO, QualificationExamPaperQuery, QualificationExamPaperForm } from '@/api/qualification/qualificationExamPaper/types';
import { FieldConfigManager } from '@/utils/configs/fieldConfigManager';
import { createQualificationExamPaperFieldConfig } from '@/utils/configs/qualification/qualificationFieldConfigs';
import { createQualificationExamPaperSearchConfig } from '@/utils/configs/qualification/qualificationSearchConfigs';
import DynamicSearchForm from '@/components/DynamicSearchForm.vue';
import FieldConfigDialog from '@/components/FieldConfigDialog.vue';
import SearchConfigDialog from '@/components/SearchConfigDialog.vue';


const searchConfigVisible = ref(false);
const fieldConfigVisible = ref(false);



const handleSearchConfig = () => {
  searchConfigVisible.value = true;
};

const handleFieldConfig = () => {
  fieldConfigVisible.value = true;
};

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const qualificationExamPaperList = ref<QualificationExamPaperVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const showFieldConfig = ref(false);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const fieldConfigManager = createQualificationExamPaperFieldConfig();
const searchConfigManager = createQualificationExamPaperSearchConfig();

const queryFormRef = ref<ElFormInstance>();
const qualificationExamPaperFormRef = ref<ElFormInstance>();

// 搜索和字段配置相关
const showSearchConfig = ref(false);
const visibleSearchFields = computed(() => searchConfigManager.getVisibleFields());
const toggleSearchConfig = () => {
  showSearchConfig.value = !showSearchConfig.value;
};

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: QualificationExamPaperForm = {
  id: undefined,
  paperCode: undefined,
  paperName: undefined,
  qualificationId: undefined,
  totalScore: undefined,
  passScore: undefined,
  examDuration: undefined,
  questionIds: undefined,
  isRandom: undefined,
  randomRule: undefined,
  isEnabled: undefined,
  delFlag: undefined
};
const data = reactive<PageData<QualificationExamPaperForm, QualificationExamPaperQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    paperCode: undefined,
    paperName: undefined,
    qualificationId: undefined,
    totalScore: undefined,
    passScore: undefined,
    examDuration: undefined,
    questionIds: undefined,
    isRandom: undefined,
    randomRule: undefined,
    isEnabled: undefined,
    delFlag: undefined,
    params: {}
  },
  rules: {
    paperCode: [{ required: true, message: '试卷编号不能为空', trigger: 'blur' }]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询资质考核试卷列表 */
const getList = async () => {
  loading.value = true;
  const res = await listQualificationExamPaper(queryParams.value);
  qualificationExamPaperList.value = res.rows;
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
  qualificationExamPaperFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: QualificationExamPaperVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加资质考核试卷';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: QualificationExamPaperVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getQualificationExamPaper(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改资质考核试卷';
};

/** 提交按钮 */
const submitForm = () => {
  qualificationExamPaperFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateQualificationExamPaper(form.value).finally(() => (buttonLoading.value = false));
      } else {
        await addQualificationExamPaper(form.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: QualificationExamPaperVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除资质考核试卷编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delQualificationExamPaper(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导入按钮操作占位 */
const handleImport = () => {};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/qualificationExamPaper/export',
    {
      ...queryParams.value
    },
    `qualificationExamPaper_${new Date().getTime()}.xlsx`
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
};

onMounted(() => {
  getList();
});
</script>

<style lang="scss" scoped>
.app-container {
  padding: 20px;
  background-color: #f5f5f5;
  min-height: 100vh;
}

.page-header {
    background: white;
    padding: 20px;
    border-radius: 8px;
    margin-bottom: 20px;
    box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);

    .page-title {
      display: flex;
      align-items: center;
      gap: 8px;
      margin: 0 0 8px 0;
      color: #1d2129;
      font-size: 18px;
      font-weight: 600;

      .title-icon {
        color: #409eff;
        font-size: 20px;
      }
    }

    .page-description {
      margin: 0;
      color: #86909c;
      font-size: 14px;
    }
  }
  .header-title {
    font-size: 18px;
    font-weight: 600;
    color: #1d2129;
    margin-bottom: 8px;
    display: flex;
    align-items: center;
    gap: 8px;

    i {
      color: #409eff;
      font-size: 20px;
    }
  }

  .header-desc {
    color: #86909c;
    font-size: 13px;
    line-height: 1.6;
  }
}

.search-card {
  background: white;
  padding: 20px;
  border-radius: 8px;
  margin-bottom: 20px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);

  .search-form {
    .el-form-item {
      margin-bottom: 16px;

      .el-input,
      .el-select,
      .el-date-editor {
        width: 100%;
      }
    }

    .search-buttons {
      display: flex;
      gap: 12px;
      justify-content: flex-end;
      margin-top: 16px;

      .el-button {
        min-width: 80px;
      }
    }
  }
}

.table-card {
  background: white;
  border-radius: 8px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
  overflow: hidden;
  padding: 12px;

  .mb8 {
    min-height: 44px;
    padding: 6px 8px;
    display: flex;
    align-items: center;
  }

  .table-header {
    padding: 16px 20px;
    border-bottom: 1px solid #f0f0f0;
    display: flex;
    justify-content: space-between;
    align-items: center;

    .table-title {
      font-size: 16px;
      font-weight: 600;
      color: #1d2129;
      display: flex;
      align-items: center;
      gap: 8px;

      i {
        color: #409eff;
        font-size: 18px;
      }
    }

    .table-actions {
      display: flex;
      gap: 8px;

      .el-button {
        min-width: 80px;
      }
    }
  }

  .el-table {
    .el-table__header {
      th {
        background-color: #fafafa;
        color: #1d2129;
        font-weight: 600;
        border-bottom: 1px solid #e5e6eb;
      }
    }

    .el-table__row {
      &:hover {
        background-color: #f5f7fa;
      }
    }

    .el-table__cell {
      border-bottom: 1px solid #f0f0f0;
      color: #1d2129;
    }
  }

  .pagination-container {
    padding: 16px 20px;
    border-top: 1px solid #f0f0f0;
    display: flex;
    justify-content: center;
  }
}

.dialog-form {
  .el-form-item {
    margin-bottom: 20px;

    .el-input,
    .el-select,
    .el-textarea {
      width: 100%;
    }
  }

  .dialog-footer {
    text-align: right;
    padding-top: 20px;

    .el-button {
      min-width: 80px;
    }
  }
}

.field-config-dialog {
  .field-list {
    max-height: 400px;
    overflow-y: auto;

    .field-item {
      display: flex;
      align-items: center;
      padding: 8px 0;
      border-bottom: 1px solid #f0f0f0;

      &:last-child {
        border-bottom: none;
      }

      .field-label {
        flex: 1;
        color: #1d2129;
      }

      .el-checkbox {
        margin-right: 0;
      }
    }
  }

  .dialog-footer {
    text-align: right;
    padding-top: 20px;

    .el-button {
      min-width: 80px;
    }
  }
}

.search-config-dialog {
  .search-list {
    max-height: 400px;
    overflow-y: auto;

    .search-item {
      display: flex;
      align-items: center;
      padding: 8px 0;
      border-bottom: 1px solid #f0f0f0;

      &:last-child {
        border-bottom: none;
      }

      .search-label {
        flex: 1;
        color: #1d2129;
      }

      .el-checkbox {
        margin-right: 0;
      }
    }
  }

  .dialog-footer {
    text-align: right;
    padding-top: 20px;

    .el-button {
      min-width: 80px;
    }
  }
}

// 响应式设计
@media (max-width: 768px) {
  .app-container {
    padding: 10px;
  }

  .page-header,
  .search-card {
    padding: 16px;
  }

  .search-form {
    .search-buttons {
      flex-direction: column;

      .el-button {
        width: 100%;
      }
    }
  }

  .table-card {
    .table-header {
      flex-direction: column;
      gap: 12px;
      align-items: flex-start;

      .table-actions {
        width: 100%;
        justify-content: flex-end;
      }
    }
  }
}
</style>
