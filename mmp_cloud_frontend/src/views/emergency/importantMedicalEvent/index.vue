<template>
  <div class="app-container">
    <!-- 页面头部 -->
    <div class="page-header">
      <h1>重要医疗事件管理</h1>
      <p>管理系统中的重要医疗事件信息，包括事件记录、通知和处理等功能</p>
      <div class="flex gap-2">
        <el-button type="primary" icon="i-ep:Plus" @click="handleAdd" v-hasPermi="['emergency:importantMedicalEvent:add']">新增</el-button>
        <el-button type="success" icon="i-ep:Edit" :disabled="single" @click="handleUpdate()" v-hasPermi="['emergency:importantMedicalEvent:edit']"
          >修改</el-button
        >
        <el-button
          type="danger"
          icon="i-ep:Delete"
          :disabled="multiple"
          @click="handleDelete()"
          v-hasPermi="['emergency:importantMedicalEvent:remove']"
          >删除</el-button
        >
        <el-button type="warning" icon="i-ep:Download" @click="handleExport" v-hasPermi="['emergency:importantMedicalEvent:export']">导出</el-button>
        <el-button type="info" icon="i-ep:Setting" @click="fieldConfigVisible = true">字段配置</el-button>
        <el-button type="info" icon="i-ep:Setting" @click="searchConfigVisible = true">搜索项配置</el-button>
        <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
      </div>
    </div>

    <!-- 搜索区域 -->
    <div class="search-card" v-show="showSearch">
      <DynamicSearchForm
        ref="searchFormRef"
        :search-config="searchConfig"
        :query-params="queryParams"
        @search="handleQuery"
        @reset="resetQuery"
      />
    </div>

    <!-- 表格区域 -->
    <div class="table-card">
      <el-table v-loading="loading" border :data="importantMedicalEventList" @selection-change="handleSelectionChange" class="modern-table">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column
          v-for="field in fieldConfig.getVisibleFields()"
          :key="field.prop"
          :label="field.label"
          :align="'center'"
          :prop="field.prop"
          :width="field.width"
          v-show="field.visible"
        >
          <template #default="scope">
            <span v-if="field.type === 'datetime'">{{ parseTime(scope.row[field.prop], '{y}-{m}-{d}') }}</span>
            <span v-else>{{ scope.row[field.prop] }}</span>
          </template>
        </el-table-column>
        <el-table-column label="操作" align="center" fixed="right" class-name="small-padding fixed-width" width="120">
          <template #default="scope">
            <div class="flex items-center justify-center space-x-1">
              <el-tooltip content="修改" placement="top">
                <el-button
                  link
                  type="primary"
                  icon="i-ep:Edit"
                  @click="handleUpdate(scope.row)"
                  v-hasPermi="['emergency:importantMedicalEvent:edit']"
                  size="small"
                ></el-button>
              </el-tooltip>
              <el-tooltip content="删除" placement="top">
                <el-button
                  link
                  type="danger"
                  icon="i-ep:Delete"
                  @click="handleDelete(scope.row)"
                  v-hasPermi="['emergency:importantMedicalEvent:remove']"
                  size="small"
                ></el-button>
              </el-tooltip>
            </div>
          </template>
        </el-table-column>
      </el-table>

      <div class="pagination-container mt-4">
        <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
      </div>
    </div>

    <el-table v-loading="loading" border :data="importantMedicalEventList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column
        v-for="field in fieldConfigManager.getVisibleFields()"
        :key="field.prop"
        :label="field.label"
        :prop="field.prop"
        :width="field.width"
        align="center"
        :resizable="true"
      >
        <template #default="scope" v-if="field.prop === 'eventTime'">
          <span>{{ parseTime(scope.row[field.prop], '{y}-{m}-{d}') }}</span>
        </template>
        <template #default="scope" v-else-if="field.prop === 'eventType'">
          <span>{{ getEventTypeLabel(scope.row[field.prop]) }}</span>
        </template>
        <template #default="scope" v-else-if="field.prop === 'notifyUsers'">
          <span>{{ formatNotifyUsers(scope.row[field.prop]) }}</span>
        </template>
        <template #default="scope" v-else>
          <span>{{ scope.row[field.prop] }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" fixed="right" class-name="small-padding fixed-width" width="120">
        <template #default="scope">
          <div class="flex items-center justify-center space-x-1">
            <el-tooltip content="修改" placement="top">
              <el-button
                link
                type="primary"
                icon="i-ep:Edit"
                @click="handleUpdate(scope.row)"
                v-hasPermi="['emergency:importantMedicalEvent:edit']"
                size="small"
              ></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button
                link
                type="danger"
                icon="i-ep:Delete"
                @click="handleDelete(scope.row)"
                v-hasPermi="['emergency:importantMedicalEvent:remove']"
                size="small"
              ></el-button>
            </el-tooltip>
          </div>
        </template>
      </el-table-column>
    </el-table>

    <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    <!-- 添加或修改重要医疗事件对话框 -->
    <FieldConfigDialog
      v-model="dialog.visible"
      :title="dialog.title"
      :field-config="fieldConfig"
      :form-data="form"
      :loading="buttonLoading"
      @confirm="submitForm"
      @cancel="cancel"
    />

    <!-- 搜索项配置对话框 -->
    <SearchConfigDialog v-model="searchConfigVisible" :search-config-manager="searchConfigManager" @confirm="() => (searchConfigVisible = false)" />

    <!-- 字段配置对话框 -->
    <FieldConfigDialog
      v-model:visible="fieldConfigVisible"
      :field-config-manager="fieldConfigManager"
      @confirm="() => (fieldConfigVisible = false)"
    />
  </div>
</template>

<script setup name="ImportantMedicalEvent" lang="ts">
import {
  listImportantMedicalEvent,
  getImportantMedicalEvent,
  delImportantMedicalEvent,
  addImportantMedicalEvent,
  updateImportantMedicalEvent
} from '@/api/emergency/importantMedicalEvent';
import { ImportantMedicalEventVO, ImportantMedicalEventQuery, ImportantMedicalEventForm } from '@/api/emergency/importantMedicalEvent/types';
import { getImportantMedicalEventFieldConfig } from '@/utils/configs/emergency/emergencyFieldConfigs';
import { getImportantMedicalEventSearchConfig } from '@/utils/configs/emergency/emergencySearchConfigs';
import DynamicSearchForm from '@/components/DynamicSearchForm.vue';
import SearchConfigDialog from '@/components/SearchConfigDialog.vue';
import FieldConfigDialog from '@/components/DynamicForm/FieldConfigDialog.vue';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

// 初始化动态配置
const fieldConfig = getImportantMedicalEventFieldConfig();
const searchConfig = getImportantMedicalEventSearchConfig();

// 搜索项配置管理器 (保留原有配置对话框功能)
const searchConfigManager = createImportantMedicalEventSearchConfig();
const visibleSearchFields = computed(() => searchConfigManager.getVisibleFields());
const searchConfigVisible = ref(false);

// 字段配置管理器 (保留原有配置对话框功能)
const fieldConfigManager = createImportantMedicalEventFieldConfig();
const fieldConfigVisible = ref(false);

const importantMedicalEventList = ref<ImportantMedicalEventVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const importantMedicalEventFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: ImportantMedicalEventForm = fieldConfig.getDefaultFormData();
const data = reactive<PageData<ImportantMedicalEventForm, ImportantMedicalEventQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    ...searchConfig.getDefaultSearchParams(),
    params: {}
  },
  rules: {
    id: [{ required: true, message: '主键ID不能为空', trigger: 'blur' }],
    eventNo: [{ required: true, message: '事件编号不能为空', trigger: 'blur' }]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询重要医疗事件列表 */
const getList = async () => {
  loading.value = true;
  try {
    const res = await listImportantMedicalEvent(queryParams.value);
    importantMedicalEventList.value = res.rows;
    total.value = res.total;
  } catch (error) {
    console.error('获取重要医疗事件列表失败:', error);
    importantMedicalEventList.value = [];
    total.value = 0;
  } finally {
    loading.value = false;
  }
};

/** 取消按钮 */
const cancel = () => {
  reset();
  dialog.visible = false;
};

/** 表单重置 */
const reset = () => {
  form.value = { ...initFormData };
  importantMedicalEventFormRef.value?.resetFields();
};

/** 搜索按钮操作 */
const handleQuery = () => {
  queryParams.value.pageNum = 1;
  getList();
};

/** 重置按钮操作 */
const resetQuery = () => {
  // 重置查询参数为初始值
  queryParams.value = {
    pageNum: 1,
    pageSize: 10,
    eventNo: undefined,
    eventType: undefined,
    patientId: undefined,
    patientName: undefined,
    visitNo: undefined,
    departmentId: undefined,
    departmentName: undefined,
    responsibleDoctor: undefined,
    eventTime: undefined,
    eventDescription: undefined,
    eventLevel: undefined,
    notifyUsers: undefined,
    sourceSystem: undefined,
    isNotified: undefined,
    notifyTime: undefined,
    params: {}
  };
  handleQuery();
};

/** 多选框选中数据 */
const handleSelectionChange = (selection: ImportantMedicalEventVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加重要医疗事件';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: ImportantMedicalEventVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getImportantMedicalEvent(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改重要医疗事件';
};

/** 提交按钮 */
const submitForm = async () => {
  buttonLoading.value = true;
  try {
    if (form.value.id) {
      await updateImportantMedicalEvent(form.value);
    } else {
      await addImportantMedicalEvent(form.value);
    }
    proxy?.$modal.msgSuccess('操作成功');
    dialog.visible = false;
    await getList();
  } finally {
    buttonLoading.value = false;
  }
};

/** 删除按钮操作 */
const handleDelete = async (row?: ImportantMedicalEventVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除重要医疗事件编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delImportantMedicalEvent(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/importantMedicalEvent/export',
    {
      ...queryParams.value
    },
    `importantMedicalEvent_${new Date().getTime()}.xlsx`
  );
};

/** 获取事件类型标签 */
const getEventTypeLabel = (eventType: string) => {
  const typeMap: Record<string, string> = {
    'death': '死亡',
    'unplanned_surgery': '非计划手术',
    'major_surgery': '重大手术',
    'critical_value': '危急值'
  };
  return typeMap[eventType] || eventType;
};

/** 格式化通知人员列表 */
const formatNotifyUsers = (notifyUsers: string) => {
  if (!notifyUsers) return '-';
  try {
    const users = JSON.parse(notifyUsers);
    if (Array.isArray(users)) {
      return users.map((user) => (typeof user === 'string' ? user : user.name || user)).join(', ');
    }
    return notifyUsers;
  } catch {
    return notifyUsers;
  }
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
  margin-bottom: 20px;
}

.page-header h1 {
  color: #1d2129;
  font-size: 1.5rem;
  font-weight: 600;
  margin-bottom: 8px;
}

.page-header p {
  color: #666;
  margin: 0;
}

.search-card {
  background: white;
  border-radius: 8px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
  padding: 20px;
  margin-bottom: 20px;
  transition: box-shadow 0.3s ease;
}

.search-card:hover {
  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.15);
}

.table-card {
  background: white;
  border-radius: 8px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
  overflow: hidden;
}

.modern-table {
  border-radius: 8px;
  overflow: hidden;
}

.modern-table .el-table__header {
  background-color: #fafafa;
}

.modern-table .el-table__row {
  transition: background-color 0.3s ease;
}

.modern-table .el-table__row:hover {
  background-color: #f5f5f5;
}

.pagination-container {
  display: flex;
  justify-content: center;
  padding: 20px 0;
}

/* 响应式设计 */
@media (max-width: 768px) {
  .app-container {
    padding: 10px;
  }

  .page-header {
    text-align: center;
  }

  .page-header .flex {
    flex-direction: column;
    align-items: center;
    gap: 16px;
  }

  .search-form {
    flex-direction: column;
  }

  .search-form .el-form-item {
    width: 100%;
  }
}

@media (max-width: 480px) {
  .app-container {
    padding: 5px;
  }

  .page-header h1 {
    font-size: 1.25rem;
  }
}
</style>
