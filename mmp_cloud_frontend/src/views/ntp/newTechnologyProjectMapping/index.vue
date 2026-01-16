<template>
  <div class="app-container">
    <!-- 页面标题 -->
    <div class="page-header mb-4">
      <h2 class="page-title">
        <i-ep-link class="title-icon"></i-ep-link>
        新技术项目对码管理
      </h2>
      <p class="page-description">管理新技术项目的对码信息，包括源编码、源名称、目标系统等映射关系</p>
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
            ref="queryFormRef"
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
            <span>对码列表</span>
            <el-tag type="info" size="small" class="ml-2">{{ total }} 条记录</el-tag>
          </div>
          <div class="table-actions">
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['ntp:newTechnologyProjectMapping:add']" size="small"
              >新增</el-button
            >
            <el-button
              type="success"
              plain
              icon="Edit"
              :disabled="single"
              @click="handleUpdate()"
              v-hasPermi="['ntp:newTechnologyProjectMapping:edit']"
              size="small"
              >修改</el-button
            >
            <el-button
              type="danger"
              plain
              icon="Delete"
              :disabled="multiple"
              @click="handleDelete()"
              v-hasPermi="['ntp:newTechnologyProjectMapping:remove']"
              size="small"
              >删除</el-button
            >
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['ntp:newTechnologyProjectMapping:export']" size="small"
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

      <el-table v-loading="loading" border :data="newTechnologyProjectMappingList" @selection-change="handleSelectionChange" class="new-technology-project-mapping-table">
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
            <!-- 时间字段格式化 -->
            <span v-if="field.prop === 'createTime' || field.prop === 'updateTime'">
              {{ parseTime(scope.row[field.prop], '{y}-{m}-{d} {h}:{i}') }}
            </span>
            <!-- 对码类型标签 -->
            <el-tag v-else-if="field.prop === 'mappingType'" :type="getMappingTypeTagType(scope.row[field.prop]) as 'primary' | 'success' | 'warning' | 'info' | 'danger'">
              {{ getMappingTypeLabel(scope.row[field.prop]) }}
            </el-tag>
            <!-- 目标系统标签 -->
            <el-tag v-else-if="field.prop === 'targetSystem'" :type="getTargetSystemTagType(scope.row[field.prop]) as 'primary' | 'success' | 'warning' | 'info' | 'danger'">
              {{ scope.row[field.prop] }}
            </el-tag>
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
                v-hasPermi="['ntp:newTechnologyProjectMapping:edit']"
              ></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button
                link
                type="primary"
                icon="Delete"
                @click="handleDelete(scope.row)"
                v-hasPermi="['ntp:newTechnologyProjectMapping:remove']"
              ></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改新技术项目对码对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="600px" append-to-body>
      <el-form ref="newTechnologyProjectMappingFormRef" :model="form" :rules="rules" label-width="100px">
        <el-row :gutter="20">
          <el-col
            v-for="field in fieldConfigManager.getVisibleFields()"
            :key="field.prop"
            :span="field.type === 'textarea' ? 24 : 12"
          >
            <el-form-item :label="field.label" :prop="field.prop">
              <!-- 文本输入框 -->
              <el-input
                v-if="field.type === 'input' || !field.type"
                v-model="form[field.prop]"
                :placeholder="`请输入${field.label}`"
              />
              <!-- 文本域 -->
              <el-input
                v-else-if="field.type === 'textarea'"
                v-model="form[field.prop]"
                type="textarea"
                :placeholder="`请输入${field.label}`"
                :rows="3"
              />
              <!-- 日期选择器 -->
              <el-date-picker
                v-else-if="field.type === 'date'"
                clearable
                v-model="form[field.prop]"
                type="date"
                value-format="YYYY-MM-DD"
                :placeholder="`请选择${field.label}`"
              />
              <!-- 日期时间选择器 -->
              <el-date-picker
                v-else-if="field.type === 'datetime'"
                clearable
                v-model="form[field.prop]"
                type="datetime"
                value-format="YYYY-MM-DD HH:mm:ss"
                :placeholder="`请选择${field.label}`"
              />
              <!-- 数字输入框 -->
              <el-input-number
                v-else-if="field.type === 'number'"
                v-model="form[field.prop]"
                :placeholder="`请输入${field.label}`"
              />
              <!-- 默认输入框 -->
              <el-input
                v-else
                v-model="form[field.prop]"
                :placeholder="`请输入${field.label}`"
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

<script setup name="NewTechnologyProjectMapping" lang="ts">
import {
  listNewTechnologyProjectMapping,
  getNewTechnologyProjectMapping,
  delNewTechnologyProjectMapping,
  addNewTechnologyProjectMapping,
  updateNewTechnologyProjectMapping
} from '@/api/ntp/newTechnologyProjectMapping';
import {
  NewTechnologyProjectMappingVO,
  NewTechnologyProjectMappingQuery,
  NewTechnologyProjectMappingForm
} from '@/api/ntp/newTechnologyProjectMapping/types';

// 导入配置管理器和组件
import { FieldConfigManager } from '@/utils/configs/fieldConfigManager';
import { SearchConfigManager } from '@/utils/configs/searchConfigManager';
import { createNewTechnologyProjectMappingFieldConfig } from '@/utils/configs/ntp/ntpFieldConfigs';
import { createNewTechnologyProjectMappingSearchConfig } from '@/utils/configs/ntp/ntpSearchConfigs';
import FieldConfigDialog from '@/components/FieldConfigDialog.vue';
import SearchConfigDialog from '@/components/SearchConfigDialog.vue';
import DynamicSearchForm from '@/components/DynamicSearchForm.vue';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const newTechnologyProjectMappingList = ref<NewTechnologyProjectMappingVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const newTechnologyProjectMappingFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

// 配置管理器
const fieldConfigManager = new FieldConfigManager('newTechnologyProjectMapping', createNewTechnologyProjectMappingFieldConfig());
const searchConfigManager = createNewTechnologyProjectMappingSearchConfig();

// 配置对话框状态
const fieldConfigDialogVisible = ref(false);
const searchConfigDialogVisible = ref(false);

const initFormData: NewTechnologyProjectMappingForm = {
  id: undefined,
  projectId: undefined,
  mappingType: undefined,
  sourceCode: undefined,
  sourceName: undefined,
  targetSystem: undefined,
  remark: undefined
};
const data = reactive<PageData<NewTechnologyProjectMappingForm, NewTechnologyProjectMappingQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    mappingType: undefined,
    sourceCode: undefined,
    sourceName: undefined,
    targetSystem: undefined,
    params: {}
  },
  rules: {
    id: [{ required: true, message: '主键ID不能为空', trigger: 'blur' }],
    projectId: [{ required: true, message: '项目ID不能为空', trigger: 'blur' }]
  }
});

const { queryParams, form, rules } = toRefs(data);

// 计算属性
const visibleSearchFields = computed(() => searchConfigManager.getVisibleFields());

/** 查询新技术项目对码列表 */
const getList = async () => {
  loading.value = true;
  const res = await listNewTechnologyProjectMapping(queryParams.value);
  newTechnologyProjectMappingList.value = res.rows;
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
  newTechnologyProjectMappingFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: NewTechnologyProjectMappingVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};


const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加新技术项目对码';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: NewTechnologyProjectMappingVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getNewTechnologyProjectMapping(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改新技术项目对码';
};

/** 提交按钮 */
const submitForm = () => {
  newTechnologyProjectMappingFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateNewTechnologyProjectMapping(form.value).finally(() => (buttonLoading.value = false));
      } else {
        await addNewTechnologyProjectMapping(form.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: NewTechnologyProjectMappingVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除新技术项目对码编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delNewTechnologyProjectMapping(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/newTechnologyProjectMapping/export',
    {
      ...queryParams.value
    },
    `newTechnologyProjectMapping_${new Date().getTime()}.xlsx`
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

/** 获取对码类型标签类型 */
const getMappingTypeTagType = (mappingType: string) => {
  const typeMap: Record<string, string> = {
    '医嘱项': 'primary',
    'ICD-9': 'success',
    '收费项': 'warning'
  };
  return typeMap[mappingType] || 'primary';
};

/** 获取对码类型标签文本 */
const getMappingTypeLabel = (mappingType: string) => {
  return mappingType || '未知';
};

/** 获取目标系统标签类型 */
const getTargetSystemTagType = (targetSystem: string) => {
  const typeMap: Record<string, string> = {
    'HIS': 'success',
    '收费系统': 'warning'
  };
  return typeMap[targetSystem] || 'info';
};

onMounted(() => {
  getList();
});
</script>

<style lang="scss" scoped>
.app-container {
  background-color: #f5f5f5;
  min-height: 100vh;
  padding: 20px;

  .page-header {
    background: white;
    padding: 20px;
    border-radius: 8px;
    margin-bottom: 20px;
    box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);

    .page-title {
      font-size: 18px;
      font-weight: 600;
      color: #1d2129;
      margin-bottom: 8px;
      display: flex;
      align-items: center;
      gap: 8px;

      .title-icon {
        color: #409eff;
        font-size: 20px;
      }
    }

    .page-description {
      color: #86909c;
      font-size: 14px;
      line-height: 1.5;
      margin-bottom: 16px;
    }

    .page-actions {
      display: flex;
      gap: 8px;
      align-items: center;
    }
  }

  .search-container {
    margin-bottom: 20px;

    .search-card {
      border-radius: 8px;
      box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);

      .search-header {
        display: flex;
        justify-content: space-between;
        align-items: center;

        .search-title {
          font-size: 16px;
          font-weight: 500;
          color: #1d2129;
          display: flex;
          align-items: center;
          gap: 6px;

          .search-icon {
            color: #409eff;
            font-size: 18px;
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
        font-size: 16px;
        font-weight: 500;
        color: #1d2129;
        display: flex;
        align-items: center;
        gap: 6px;

        .table-icon {
          color: #409eff;
          font-size: 18px;
        }
      }
    }
  }
}

// 响应式设计
@media (max-width: 768px) {
  .app-container {
    padding: 10px;

    .page-header {
      .page-title {
        font-size: 20px;

        .title-icon {
          font-size: 24px;
        }
      }

      .page-actions {
        flex-wrap: wrap;
        justify-content: flex-start;
      }
    }
  }
}
</style>
