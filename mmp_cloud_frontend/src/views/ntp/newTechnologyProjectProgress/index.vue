<template>
  <div class="app-container">
    <!-- 页面标题 -->
    <div class="page-header mb-4">
      <h2 class="page-title">
        <i-ep-setting class="title-icon"></i-ep-setting>
        新技术进展报告管理
      </h2>
      <p class="page-description">管理系统新技术项目的进展报告</p>
    </div>

    <!-- 动态搜索表单 -->
    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <div v-show="showSearch" class="search-container mb-4">
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
          </template>
          <DynamicSearchForm
            ref="searchFormRef"
            :query="queryParams"
            :visible-fields="visibleSearchFields"
            @search="handleQuery"
            @reset="resetQuery"
          />
        </el-card>
      </div>
    </transition>

    <!-- 数据表格 -->
    <el-card shadow="never" class="table-card">
      <template #header>
        <div class="table-header">
          <div class="table-title">
            <i-ep-list class="table-icon"></i-ep-list>
            <span>新技术进展报告列表</span>
            <el-tag type="info" size="small" class="ml-2">{{ total }} 条记录</el-tag>
          </div>
          <div class="table-actions">
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['ntp:newTechnologyProjectProgress:add']" size="small"
              >新增</el-button
            >
            <el-button
              type="success"
              plain
              icon="Edit"
              :disabled="single"
              @click="handleUpdate()"
              v-hasPermi="['ntp:newTechnologyProjectProgress:edit']"
              size="small"
              >修改</el-button
            >
            <el-button
              type="danger"
              plain
              icon="Delete"
              :disabled="multiple"
              @click="handleDelete()"
              v-hasPermi="['ntp:newTechnologyProjectProgress:remove']"
              size="small"
              >删除</el-button
            >
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['ntp:newTechnologyProjectProgress:export']" size="small"
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

      <el-table v-loading="loading" border :data="newTechnologyProjectProgressList" @selection-change="handleSelectionChange" class="new-technology-project-progress-table">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column
          v-for="field in fieldConfigManager.getVisibleFields()"
          :key="field.prop"
          :label="field.label"
          align="center"
          :prop="field.prop"
          :width="field.width"
          :min-width="field.minWidth || 120"
          resizable
        >
          <template #default="scope">
            <!-- 报告类型字段 -->
            <el-tag v-if="field.prop === 'reportType'" :type="getReportTypeTagType(scope.row.reportType) as 'primary' | 'success' | 'warning' | 'info' | 'danger'">
              {{ getReportTypeText(scope.row.reportType) }}
            </el-tag>
            <!-- 继续状态字段 -->
            <el-tag v-else-if="field.prop === 'continueStatus'" :type="getContinueStatusTagType(scope.row.continueStatus) as 'primary' | 'success' | 'warning' | 'info' | 'danger'">
              {{ getContinueStatusText(scope.row.continueStatus) }}
            </el-tag>
            <!-- 报告状态字段 -->
            <el-tag v-else-if="field.prop === 'reportStatus'" :type="getReportStatusTagType(scope.row.reportStatus) as 'primary' | 'success' | 'warning' | 'info' | 'danger'">
              {{ getReportStatusText(scope.row.reportStatus) }}
            </el-tag>
            <!-- 日期字段 -->
            <span v-else-if="field.prop === 'reportDate'">
              {{ parseTime(scope.row.reportDate, '{y}-{m}-{d}') }}
            </span>
            <!-- 时间字段 -->
            <span v-else-if="field.prop === 'createTime' || field.prop === 'updateTime'">
              {{ parseTime(scope.row[field.prop], '{y}-{m}-{d} {h}:{i}') }}
            </span>
            <!-- 默认显示 -->
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
                v-hasPermi="['ntp:newTechnologyProjectProgress:edit']"
              ></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button
                link
                type="primary"
                icon="Delete"
                @click="handleDelete(scope.row)"
                v-hasPermi="['ntp:newTechnologyProjectProgress:remove']"
              ></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>

    <!-- 添加或修改新技术进展报告对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="700px" append-to-body>
      <el-form ref="newTechnologyProjectProgressFormRef" :model="form" :rules="rules" label-width="120px">
        <el-row :gutter="20">
          <el-col
            v-for="field in fieldConfigManager.getVisibleFields()"
            :key="field.prop"
            :span="field.type === 'textarea' ? 24 : 12"
          >
            <el-form-item :label="field.label" :prop="field.prop">
              <!-- 报告类型选择框 -->
              <el-select v-if="field.prop === 'reportType'" v-model="form.reportType" placeholder="请选择报告类型" clearable style="width: 100%">
                <el-option label="进展报告" value="1" />
                <el-option label="结题报告" value="2" />
              </el-select>
              <!-- 继续状态选择框 -->
              <el-select v-else-if="field.prop === 'continueStatus'" v-model="form.continueStatus" placeholder="请选择继续状态" clearable style="width: 100%">
                <el-option label="继续开展" value="1" />
                <el-option label="终止" value="2" />
                <el-option label="暂停" value="3" />
              </el-select>
              <!-- 报告状态选择框 -->
              <el-select v-else-if="field.prop === 'reportStatus'" v-model="form.reportStatus" placeholder="请选择报告状态" clearable style="width: 100%">
                <el-option label="草稿" value="0" />
                <el-option label="已提交" value="1" />
                <el-option label="审核中" value="2" />
                <el-option label="已通过" value="3" />
                <el-option label="已驳回" value="4" />
              </el-select>
              <!-- 日期选择器 -->
              <el-date-picker
                v-else-if="field.prop === 'reportDate'"
                clearable
                v-model="form.reportDate"
                type="datetime"
                value-format="YYYY-MM-DD HH:mm:ss"
                placeholder="请选择报告日期"
                style="width: 100%"
              />
              <!-- 数字输入框 -->
              <el-input-number
                v-else-if="field.type === 'number'"
                v-model="form[field.prop]"
                :min="field.min || 0"
                :max="field.max || 99999"
                :placeholder="field.placeholder || `请输入${field.label}`"
                style="width: 100%"
              />
              <!-- 文本域 -->
              <el-input
                v-else-if="field.type === 'textarea'"
                v-model="form[field.prop]"
                type="textarea"
                :placeholder="field.placeholder || `请输入${field.label}`"
                :maxlength="field.maxlength"
                :show-word-limit="field.showWordLimit"
                :rows="field.rows || 3"
              />
              <!-- 默认文本输入框 -->
              <el-input
                v-else
                v-model="form[field.prop]"
                :type="field.type || 'text'"
                :placeholder="field.placeholder || `请输入${field.label}`"
                :maxlength="field.maxlength"
                :show-word-limit="field.showWordLimit"
              />
            </el-form-item>
          </el-col>
        </el-row>
      </el-form>
      <template #footer>
        <div class="dialog-footer">
          <el-button :loading="buttonLoading" type="primary" @click="submitForm">确 定</el-button>
          <el-button @click="cancel">取 消</el-button>
        </div>
      </template>
    </el-dialog>

    <!-- 字段配置对话框 -->
    <field-config-dialog
      v-model:visible="fieldConfigDialogVisible"
      :field-config-manager="fieldConfigManager"
      @confirm="handleFieldConfigConfirm"
    />

    <!-- 搜索配置对话框 -->
    <search-config-dialog
      v-model:visible="searchConfigDialogVisible"
      :search-config-manager="searchConfigManager"
      @confirm="handleSearchConfigConfirm"
    />
  </div>
</template>

<script setup name="NewTechnologyProjectProgress" lang="ts">
import { ref, reactive, computed, getCurrentInstance } from 'vue';
import type { ComponentInternalInstance } from 'vue';
import {
  listNewTechnologyProjectProgress,
  getNewTechnologyProjectProgress,
  delNewTechnologyProjectProgress,
  addNewTechnologyProjectProgress,
  updateNewTechnologyProjectProgress
} from '@/api/ntp/newTechnologyProjectProgress';
import {
  NewTechnologyProjectProgressVO,
  NewTechnologyProjectProgressQuery,
  NewTechnologyProjectProgressForm
} from '@/api/ntp/newTechnologyProjectProgress/types';
import { FieldConfigManager } from '@/utils/configs/fieldConfigManager';
import { createNewTechnologyProjectProgressFieldConfig } from '@/utils/configs/ntp/ntpFieldConfigs';
import { createNewTechnologyProjectProgressSearchConfig } from '@/utils/configs/ntp/ntpSearchConfigs';
import DynamicSearchForm from '@/components/DynamicSearchForm.vue';
import FieldConfigDialog from '@/components/FieldConfigDialog.vue';
import SearchConfigDialog from '@/components/SearchConfigDialog.vue';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const newTechnologyProjectProgressList = ref<NewTechnologyProjectProgressVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const newTechnologyProjectProgressFormRef = ref<ElFormInstance>();
const searchFormRef = ref();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

// 配置管理器
const fieldConfigManager = new FieldConfigManager('newTechnologyProjectProgress', createNewTechnologyProjectProgressFieldConfig());
const searchConfigManager = createNewTechnologyProjectProgressSearchConfig();
const visibleSearchFields = computed(() => searchConfigManager.getVisibleFields());

// 配置对话框状态
const fieldConfigDialogVisible = ref(false);
const searchConfigDialogVisible = ref(false);

const initFormData: NewTechnologyProjectProgressForm = {
  id: undefined,
  reportNo: undefined,
  projectId: undefined,
  reportType: undefined,
  reportPeriod: undefined,
  reportDate: undefined,
  caseCount: undefined,
  successCount: undefined,
  complicationCount: undefined,
  adverseReactionCount: undefined,
  mortalityCount: undefined,
  effectEvaluation: undefined,
  existingProblems: undefined,
  improvementMeasures: undefined,
  nextPlan: undefined,
  continueStatus: undefined,
  monitoringIndicators: undefined,
  attachmentUrls: undefined,
  reportStatus: undefined,
  workflowInstanceId: undefined,
  remark: undefined
};
const data = reactive<PageData<NewTechnologyProjectProgressForm, NewTechnologyProjectProgressQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    reportNo: undefined,
    reportType: undefined,
    reportPeriod: undefined,
    reportDate: undefined,
    caseCount: undefined,
    successCount: undefined,
    complicationCount: undefined,
    adverseReactionCount: undefined,
    mortalityCount: undefined,
    effectEvaluation: undefined,
    existingProblems: undefined,
    improvementMeasures: undefined,
    nextPlan: undefined,
    continueStatus: undefined,
    monitoringIndicators: undefined,
    attachmentUrls: undefined,
    reportStatus: undefined,
    params: {}
  },
  rules: {
    id: [{ required: true, message: '主键ID不能为空', trigger: 'blur' }],
    reportNo: [{ required: true, message: '报告编号不能为空', trigger: 'blur' }],
    projectId: [{ required: true, message: '项目ID不能为空', trigger: 'blur' }]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询新技术进展报告列表 */
const getList = async () => {
  loading.value = true;
  const res = await listNewTechnologyProjectProgress(queryParams.value);
  newTechnologyProjectProgressList.value = res.rows;
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
  newTechnologyProjectProgressFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: NewTechnologyProjectProgressVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加新技术进展报告';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: NewTechnologyProjectProgressVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getNewTechnologyProjectProgress(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改新技术进展报告';
};

/** 提交按钮 */
const submitForm = () => {
  newTechnologyProjectProgressFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateNewTechnologyProjectProgress(form.value).finally(() => (buttonLoading.value = false));
      } else {
        await addNewTechnologyProjectProgress(form.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: NewTechnologyProjectProgressVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除新技术进展报告编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delNewTechnologyProjectProgress(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/newTechnologyProjectProgress/export',
    {
      ...queryParams.value
    },
    `newTechnologyProjectProgress_${new Date().getTime()}.xlsx`
  );
};

/** 字段配置按钮操作 */
const handleFieldConfig = () => {
  fieldConfigDialogVisible.value = true;
};

/** 搜索配置按钮操作 */
const handleSearchConfig = () => {
  searchConfigDialogVisible.value = true;
};

/** 字段配置确认 */
const handleFieldConfigConfirm = () => {
  fieldConfigDialogVisible.value = false;
};

/** 搜索配置确认 */
const handleSearchConfigConfirm = () => {
  searchConfigDialogVisible.value = false;
};

/** 获取报告类型文本 */
const getReportTypeText = (type: string | number) => {
  const typeMap: Record<string, string> = {
    '1': '进展报告',
    '2': '结题报告'
  };
  return typeMap[String(type)] || type;
};

/** 获取报告类型标签类型 */
const getReportTypeTagType = (type: string | number) => {
  const typeMap: Record<string, string> = {
    '1': 'primary',
    '2': 'success'
  };
  return typeMap[String(type)] || 'info';
};

/** 获取继续状态文本 */
const getContinueStatusText = (status: string | number) => {
  const statusMap: Record<string, string> = {
    '1': '继续开展',
    '2': '终止',
    '3': '暂停'
  };
  return statusMap[String(status)] || status;
};

/** 获取继续状态标签类型 */
const getContinueStatusTagType = (status: string | number) => {
  const statusMap: Record<string, string> = {
    '1': 'success',
    '2': 'danger',
    '3': 'warning'
  };
  return statusMap[String(status)] || 'info';
};

/** 获取报告状态文本 */
const getReportStatusText = (status: string | number) => {
  const statusMap: Record<string, string> = {
    '0': '草稿',
    '1': '已提交',
    '2': '审核中',
    '3': '已通过',
    '4': '已驳回'
  };
  return statusMap[String(status)] || status;
};

/** 获取报告状态标签类型 */
const getReportStatusTagType = (status: string | number) => {
  const statusMap: Record<string, string> = {
    '0': 'info',
    '1': 'primary',
    '2': 'warning',
    '3': 'success',
    '4': 'danger'
  };
  return statusMap[String(status)] || 'info';
};

onMounted(() => {
  getList();
});
</script>

<style scoped>
.app-container {
  background-color: #f5f5f5;
  min-height: 100vh;
  padding: 20px;
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

.search-card {
  background: white;
  border-radius: 8px;
  margin-bottom: 20px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);

  .search-header {
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin-bottom: 16px;

    .search-title {
      font-weight: 600;
      color: #1d2129;
      display: flex;
      align-items: center;
      gap: 6px;

      .search-icon {
        color: #409eff;
      }
    }

    .search-actions {
      .config-btn {
        color: #409eff;

        .btn-icon {
          margin-right: 4px;
        }
      }
    }
  }
}

.table-card {
  border-radius: 8px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);

  .table-header {
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin-bottom: 16px;

    .table-title {
      font-weight: 600;
      color: #1d2129;
      display: flex;
      align-items: center;
      gap: 8px;

      .table-icon {
        color: #409eff;
      }
    }

    .table-actions {
      display: flex;
      gap: 8px;
      align-items: center;

      .config-btn {
        color: #409eff;

        .btn-icon {
          margin-right: 4px;
        }
      }
    }
  }
}

.new-technology-project-progress-table {
  :deep(.el-table__header) {
    th {
      background-color: #fafafa;
      font-weight: 600;
      color: #1d2129;
    }
  }

  :deep(.el-table__row) {
    &:hover {
      background-color: #f5f7fa;
    }
  }
}

@media (max-width: 768px) {
  .app-container {
    padding: 12px;
  }

  .page-header {
    .page-title {
      font-size: 20px;
    }
  }

  .table-header {
    flex-direction: column;
    align-items: flex-start;
    gap: 12px;

    .table-actions {
      width: 100%;
      justify-content: flex-end;
    }
  }
}
</style>