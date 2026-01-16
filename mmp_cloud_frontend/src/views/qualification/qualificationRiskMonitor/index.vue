<template>
  <div class="app-container">
    <!-- 页面标题 -->
    <div class="page-header mb-4">
      <h2 class="page-title">
        <i-ep-warning class="title-icon"></i-ep-warning>
        资质风险监测管理
      </h2>
      <p class="page-description">管理系统资质风险监测信息，包括风险等级、处理状态和风险描述等</p>
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
          <span class="font-medium">资质风险监测列表</span>
          <el-tag type="info" size="small" class="ml-2">{{ total }} 条记录</el-tag>
          <div class="ml-auto flex items-center gap-2">
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['qualification:qualificationRiskMonitor:add']"
              >新增</el-button
            >
            <el-button
              type="success"
              plain
              icon="Edit"
              :disabled="single"
              @click="handleUpdate()"
              v-hasPermi="['qualification:qualificationRiskMonitor:edit']"
              >修改</el-button
            >
            <el-button
              type="danger"
              plain
              icon="Delete"
              :disabled="multiple"
              @click="handleDelete()"
              v-hasPermi="['qualification:qualificationRiskMonitor:remove']"
              >删除</el-button
            >
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['qualification:qualificationRiskMonitor:export']"
              >导出</el-button
            >
            <el-button type="info" plain icon="Setting" @click="toggleFieldConfig">字段配置</el-button>
            <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
          </div>
        </div>
      </template>

      <el-table v-loading="loading" border :data="qualificationRiskMonitorList" @selection-change="handleSelectionChange" class="data-table">
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
            <!-- 风险等级状态标签 -->
            <el-tag v-if="field.prop === 'riskLevel'" :type="getRiskLevelTagType(scope.row[field.prop])" size="small">
              {{ getRiskLevelLabel(scope.row[field.prop]) }}
            </el-tag>
            <!-- 处理状态标签 -->
            <el-tag v-else-if="field.prop === 'handlingStatus'" :type="getHandlingStatusTagType(scope.row[field.prop])" size="small">
              {{ getHandlingStatusLabel(scope.row[field.prop]) }}
            </el-tag>
            <!-- 日期格式化 -->
            <span v-else-if="field.prop === 'riskDate' || field.prop === 'handleTime'">{{ parseTime(scope.row[field.prop], '{y}-{m}-{d}') }}</span>
            <!-- 默认显示 -->
            <span v-else>{{ scope.row[field.prop] }}</span>
          </template>
        </el-table-column>
        <el-table-column label="操作" align="center" fixed="right" class-name="small-padding fixed-width" width="120">
          <template #default="scope">
            <!-- 操作按钮根据需要添加 -->
          </template>
        </el-table-column>
      </el-table>

      <div class="pagination-container">
        <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
      </div>
    </el-card>

    <!-- 添加或修改资质风险监测对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="700px" append-to-body>
      <el-form ref="qualificationRiskMonitorFormRef" :model="form" :rules="rules" label-width="120px" class="dialog-form">
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="风险编号" prop="riskNo">
              <el-input v-model="form.riskNo" placeholder="请输入风险编号" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="人员ID" prop="staffId">
              <el-input v-model="form.staffId" placeholder="请输入人员ID" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="人员姓名" prop="staffName">
              <el-input v-model="form.staffName" placeholder="请输入人员姓名" />
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
            <el-form-item label="资质名称" prop="qualificationName">
              <el-input v-model="form.qualificationName" placeholder="请输入资质名称" />
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="风险类型" prop="riskType">
              <el-select v-model="form.riskType" placeholder="请选择风险类型" style="width: 100%">
                <el-option label="操作风险" value="操作风险" />
                <el-option label="资质过期风险" value="资质过期风险" />
                <el-option label="考核不合格风险" value="考核不合格风险" />
                <el-option label="违规操作风险" value="违规操作风险" />
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="风险等级" prop="riskLevel">
              <el-select v-model="form.riskLevel" placeholder="请选择风险等级" style="width: 100%">
                <el-option label="高" value="高" />
                <el-option label="中" value="中" />
                <el-option label="低" value="低" />
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="处理状态" prop="handlingStatus">
              <el-select v-model="form.handlingStatus" placeholder="请选择处理状态" style="width: 100%">
                <el-option label="待处理" value="待处理" />
                <el-option label="处理中" value="处理中" />
                <el-option label="已处理" value="已处理" />
                <el-option label="已关闭" value="已关闭" />
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>
        <el-form-item label="风险描述" prop="riskDescription">
          <el-input v-model="form.riskDescription" type="textarea" :rows="3" placeholder="请输入风险描述" />
        </el-form-item>
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="风险发生时间" prop="riskDate">
              <el-date-picker
                clearable
                v-model="form.riskDate"
                type="datetime"
                value-format="YYYY-MM-DD HH:mm:ss"
                placeholder="请选择风险发生时间"
                style="width: 100%"
              >
              </el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="关联患者ID" prop="relatedPatientId">
              <el-input v-model="form.relatedPatientId" placeholder="请输入关联患者ID" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="关联事件ID" prop="relatedEventId">
              <el-input v-model="form.relatedEventId" placeholder="请输入关联事件ID" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="处理人" prop="handler">
              <el-input v-model="form.handler" placeholder="请输入处理人" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="处理时间" prop="handleTime">
              <el-date-picker
                clearable
                v-model="form.handleTime"
                type="datetime"
                value-format="YYYY-MM-DD HH:mm:ss"
                placeholder="请选择处理时间"
                style="width: 100%"
              >
              </el-date-picker>
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
        <el-form-item label="处理结果" prop="handleResult">
          <el-input v-model="form.handleResult" type="textarea" :rows="4" placeholder="请输入处理结果" />
        </el-form-item>
      </el-form>
      <template #footer>
        <div class="dialog-footer">
          <el-button :loading="buttonLoading" type="primary" @click="submitForm">确 定</el-button>
          <el-button @click="cancel">取 消</el-button>
        </div>
      </template>
    </el-dialog>

    <FieldConfigDialog v-model:visible="showFieldConfig" :field-config-manager="fieldConfigManager" @confirm="handleFieldConfigConfirm" />
    <SearchConfigDialog v-model="showSearchConfig" :search-config-manager="searchConfigManager" @confirm="handleSearchConfigConfirm" />
  </div>
</template>

<script setup name="QualificationRiskMonitor" lang="ts">
import {
  listQualificationRiskMonitor,
  getQualificationRiskMonitor,
  delQualificationRiskMonitor,
  addQualificationRiskMonitor,
  updateQualificationRiskMonitor
} from '@/api/qualification/qualificationRiskMonitor';
import {
  QualificationRiskMonitorVO,
  QualificationRiskMonitorQuery,
  QualificationRiskMonitorForm
} from '@/api/qualification/qualificationRiskMonitor/types';
import { FieldConfigManager } from '@/utils/configs/fieldConfigManager';
import { createQualificationRiskMonitorFieldConfig } from '@/utils/configs/qualification/qualificationFieldConfigs';
import { SearchConfigManager } from '@/utils/configs/searchConfigManager';
import { createQualificationRiskMonitorSearchConfig } from '@/utils/configs/qualification/qualificationSearchConfigs';
import DynamicSearchForm from '@/components/DynamicSearchForm.vue';
import FieldConfigDialog from '@/components/FieldConfigDialog.vue';
import SearchConfigDialog from '@/components/SearchConfigDialog.vue';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const qualificationRiskMonitorList = ref<QualificationRiskMonitorVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const showFieldConfig = ref(false);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const fieldConfigManager = createQualificationRiskMonitorFieldConfig();
const searchConfigManager = createQualificationRiskMonitorSearchConfig();

const queryFormRef = ref<ElFormInstance>();
const qualificationRiskMonitorFormRef = ref<ElFormInstance>();

// 搜索和字段配置相关
const showSearchConfig = ref(false);
const visibleSearchFields = computed(() => searchConfigManager.getVisibleFields());

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: QualificationRiskMonitorForm = {
  id: undefined,
  riskNo: undefined,
  staffId: undefined,
  staffName: undefined,
  qualificationId: undefined,
  qualificationName: undefined,
  riskType: undefined,
  riskLevel: undefined,
  riskDescription: undefined,
  riskDate: undefined,
  relatedPatientId: undefined,
  relatedEventId: undefined,
  handlingStatus: undefined,
  handler: undefined,
  handleTime: undefined,
  handleResult: undefined,
  delFlag: undefined,
  tenantId: undefined
};
const data = reactive<PageData<QualificationRiskMonitorForm, QualificationRiskMonitorQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    riskNo: undefined,
    staffId: undefined,
    staffName: undefined,
    qualificationId: undefined,
    qualificationName: undefined,
    riskType: undefined,
    riskLevel: undefined,
    riskDescription: undefined,
    riskDate: undefined,
    relatedPatientId: undefined,
    relatedEventId: undefined,
    handlingStatus: undefined,
    handler: undefined,
    handleTime: undefined,
    handleResult: undefined,
    delFlag: undefined,
    params: {}
  },
  rules: {
    riskNo: [{ required: true, message: '风险编号不能为空', trigger: 'blur' }],
    staffId: [{ required: true, message: '人员ID不能为空', trigger: 'blur' }]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 切换搜索配置对话框 */
const toggleSearchConfig = () => {
  showSearchConfig.value = !showSearchConfig.value;
};

/** 切换字段配置对话框 */
const toggleFieldConfig = () => {
  showFieldConfig.value = !showFieldConfig.value;
};

/** 获取风险等级标签类型 */
const getRiskLevelTagType = (value: string) => {
  if (value === '高') return 'danger';
  if (value === '中') return 'warning';
  if (value === '低') return 'success';
  return 'info';
};

/** 获取风险等级标签文本 */
const getRiskLevelLabel = (value: string) => {
  return value || '未知';
};

/** 获取处理状态标签类型 */
const getHandlingStatusTagType = (value: string) => {
  if (value === '待处理') return 'warning';
  if (value === '处理中') return 'primary';
  if (value === '已处理') return 'success';
  if (value === '已关闭') return 'info';
  return 'info';
};

/** 获取处理状态标签文本 */
const getHandlingStatusLabel = (value: string) => {
  return value || '未知';
};

/** 查看详情 */
const handleView = (row: QualificationRiskMonitorVO) => {
  // 实现查看详情逻辑
  (proxy?.$modal as any).info({
    title: '资质风险监测详情',
    content: `查看资质风险监测：${row.riskNo}`,
    confirmText: '确定'
  });
};

/** 查询资质风险监测列表 */
const getList = async () => {
  loading.value = true;
  const res = await listQualificationRiskMonitor(queryParams.value);
  qualificationRiskMonitorList.value = res.rows;
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
  qualificationRiskMonitorFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: QualificationRiskMonitorVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加资质风险监测';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: QualificationRiskMonitorVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getQualificationRiskMonitor(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改资质风险监测';
};

/** 提交按钮 */
const submitForm = () => {
  qualificationRiskMonitorFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateQualificationRiskMonitor(form.value).finally(() => (buttonLoading.value = false));
      } else {
        await addQualificationRiskMonitor(form.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: QualificationRiskMonitorVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除资质风险监测编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delQualificationRiskMonitor(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导入按钮操作 */
const handleImport = () => {
  (proxy.$modal as any).upload({
    url: '/dev-api/qualification/qualificationRiskMonitor/importData',
    success: () => {
      proxy.$modal.msgSuccess('导入成功');
      getList();
    }
  });
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/qualificationRiskMonitor/export',
    {
      ...queryParams.value
    },
    `qualificationRiskMonitor_${new Date().getTime()}.xlsx`
  );
};

/** 字段配置确认 */
const handleFieldConfigConfirm = () => {
  showFieldConfig.value = false;
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
    font-size: 14px;
    line-height: 1.5;
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
