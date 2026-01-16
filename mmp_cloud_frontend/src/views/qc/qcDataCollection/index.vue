<template>
  <div class="app-container">
    <!-- 页面标题 -->
    <div class="page-header mb-4">
      <h2 class="page-title">
        <i-ep-data-analysis class="title-icon"></i-ep-data-analysis>
        数据采集管理
      </h2>
      <p class="page-description">管理系统数据采集记录，包括指标数据录入、审核等功能</p>
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
            <span>数据采集列表</span>
            <el-tag type="info" size="small" class="ml-2">{{ total }} 条记录</el-tag>
          </div>
          <div class="table-actions">
            <el-button type="primary" icon="Plus" @click="handleAdd" class="action-btn">
              <i-ep-plus class="btn-icon"></i-ep-plus>
              新增
            </el-button>
            <el-button type="success" icon="Edit" :disabled="single" @click="handleUpdate()" class="action-btn">
              <i-ep-edit class="btn-icon"></i-ep-edit>
              修改
            </el-button>
            <el-button type="danger" icon="Delete" :disabled="multiple" @click="handleDelete()" class="action-btn">
              <i-ep-delete class="btn-icon"></i-ep-delete>
              删除
            </el-button>
            <el-button type="warning" icon="Download" @click="handleExport" class="action-btn">
              <i-ep-download class="btn-icon"></i-ep-download>
              导出
            </el-button>
            <el-button text type="primary" @click="handleFieldConfig" class="config-btn">
              <i-ep-setting class="btn-icon"></i-ep-setting>
              字段配置
            </el-button>
            <el-button text type="primary" @click="toggleSearch" class="config-btn">
              <i-ep-search v-if="!showSearch" class="btn-icon"></i-ep-search>
              <i-ep-fold v-else class="btn-icon"></i-ep-fold>
              {{ showSearch ? '隐藏搜索' : '显示搜索' }}
            </el-button>
          </div>
        </div>
      </template>

      <el-table
        v-loading="loading"
        border
        :data="qcDataCollectionList"
        @selection-change="handleSelectionChange"
        class="data-table"
      >
        <el-table-column type="selection" width="55" align="center" />
        <template v-for="field in visibleTableFields" :key="field.prop">
          <el-table-column
            :label="field.label"
            :prop="field.prop"
            :width="field.width"
            :min-width="field.minWidth"
            align="center"
            v-if="field.visible"
          >
            <template #default="scope">
              <!-- 日期时间字段 -->
              <span v-if="field.prop === 'collectionTime' || field.prop === 'reviewTime' || field.prop === 'createTime' || field.prop === 'updateTime'">
                {{ parseTime(scope.row[field.prop], '{y}-{m}-{d} {h}:{i}') }}
              </span>
              
              <!-- 选择字段 -->
              <el-tag v-else-if="field.prop === 'dataStatus'" :type="getTagType(scope.row[field.prop])" size="small">
                {{ getOptionLabel(field.options, scope.row[field.prop]) }}
              </el-tag>
              
              <!-- 删除标志字段 -->
              <el-tag v-else-if="field.prop === 'delFlag'" :type="scope.row[field.prop] === '0' ? 'success' : 'danger'" size="small">
                {{ scope.row[field.prop] === '0' ? '未删除' : '已删除' }}
              </el-tag>
              
              <!-- 默认显示 -->
              <span v-else>{{ scope.row[field.prop] }}</span>
            </template>
          </el-table-column>
        </template>
        <el-table-column label="操作" align="center" fixed="right" width="120" class-name="small-padding">
          <template #default="scope">
            <el-tooltip content="修改" placement="top">
              <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)"></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button link type="danger" icon="Delete" @click="handleDelete(scope.row)"></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination
        v-show="total > 0"
        :total="total"
        v-model:page="queryParams.pageNum"
        v-model:limit="queryParams.pageSize"
        @pagination="getList"
        class="pagination-wrapper"
      />
    </el-card>

    <!-- 添加或修改数据采集记录对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="600px" append-to-body class="form-dialog">
      <el-form ref="qcDataCollectionFormRef" :model="form" :rules="rules" label-width="100px" class="form-content">
        <el-row :gutter="20">
          <template v-for="field in visibleFormFields" :key="field.prop">
            <el-col :span="field.type === 'textarea' ? 24 : 12" v-if="field.formVisible">
              <el-form-item :label="field.label" :prop="field.prop" :rules="field.rules">
                <!-- 文本输入框 -->
                <el-input
                  v-if="field.type === 'input'"
                  v-model="form[field.prop]"
                  :placeholder="field.placeholder || `请输入${field.label}`"
                  style="width: 100%"
                />
                <!-- 数字输入框 -->
                <el-input-number
                  v-else-if="field.type === 'number'"
                  v-model="form[field.prop]"
                  :placeholder="field.placeholder || `请输入${field.label}`"
                  style="width: 100%"
                />
                <!-- 下拉选择框 -->
                <el-select
                  v-else-if="field.type === 'select'"
                  v-model="form[field.prop]"
                  :placeholder="field.placeholder || `请选择${field.label}`"
                  clearable
                  style="width: 100%"
                  v-bind="field.componentProps"
                >
                  <el-option
                    v-for="opt in field.options || []"
                    :key="opt.value"
                    :label="opt.label"
                    :value="opt.value"
                  />
                </el-select>
                <!-- 日期选择器 -->
                <el-date-picker
                  v-else-if="field.type === 'date' || field.type === 'datetime'"
                  v-model="form[field.prop]"
                  :type="field.componentProps?.type || (field.type === 'datetime' ? 'datetime' : 'date')"
                  :value-format="field.componentProps?.valueFormat"
                  :placeholder="field.placeholder || `请选择${field.label}`"
                  clearable
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
                  style="width: 100%"
                />
                <!-- 默认文本输入框 -->
                <el-input
                  v-else
                  v-model="form[field.prop]"
                  :placeholder="field.placeholder || `请输入${field.label}`"
                  style="width: 100%"
                />
              </el-form-item>
            </el-col>
          </template>
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
    <FieldConfigDialog
      :visible="showFieldConfig"
      :field-config-manager="fieldConfigManager"
      @update:visible="showFieldConfig = $event"
      @confirm="handleFieldConfigConfirm"
    />

    <!-- 搜索配置对话框 -->
    <SearchConfigDialog
      :visible="showSearchConfig"
      :search-config-manager="searchConfigManager"
      @update:visible="showSearchConfig = $event"
      @confirm="handleSearchConfigConfirm"
    />
  </div>
</template>

<script setup name="QcDataCollection" lang="ts">
import {
  listQcDataCollection,
  getQcDataCollection,
  delQcDataCollection,
  addQcDataCollection,
  updateQcDataCollection
} from '@/api/qc/qcDataCollection';
import { QcDataCollectionVO, QcDataCollectionQuery, QcDataCollectionForm } from '@/api/qc/qcDataCollection/types';
import { createQcDataCollectionFieldConfig } from '@/utils/configs/qc/qcFieldConfigs';
import { createQcDataCollectionSearchConfig } from '@/utils/configs/qc/qcSearchConfigs';
import { FieldConfigManager } from '@/utils/configs/fieldConfigManager';
import { SearchConfigManager } from '@/utils/configs/searchConfigManager';
import FieldConfigDialog from '@/components/FieldConfigDialog.vue';
import SearchConfigDialog from '@/components/SearchConfigDialog.vue';
import DynamicSearchForm from '@/components/DynamicSearchForm.vue';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

// 动态配置管理器
const fieldConfigManager = new FieldConfigManager('qcDataCollection', createQcDataCollectionFieldConfig());
const searchConfigManager = createQcDataCollectionSearchConfig();

// 计算属性
const visibleTableFields = computed(() => fieldConfigManager.getVisibleFields());
const visibleFormFields = computed(() => fieldConfigManager.getFormFields());
const visibleSearchFields = computed(() => searchConfigManager.getVisibleFields());

const qcDataCollectionList = ref<QcDataCollectionVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const showFieldConfig = ref(false);
const showSearchConfig = ref(false);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const qcDataCollectionFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: QcDataCollectionForm = {
  id: undefined,
  indicatorId: undefined,
  collectionPeriod: undefined,
  collectionYear: undefined,
  collectionMonth: undefined,
  collectionQuarter: undefined,
  departmentId: undefined,
  departmentName: undefined,
  numeratorValue: undefined,
  denominatorValue: undefined,
  indicatorValue: undefined,
  dataStatus: undefined,
  collector: undefined,
  reviewer: undefined,
  collectionTime: undefined,
  reviewTime: undefined,
  remark: undefined,
  delFlag: undefined
};

const data = reactive<PageData<QcDataCollectionForm, QcDataCollectionQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    collectionPeriod: undefined,
    collectionYear: undefined,
    collectionMonth: undefined,
    collectionQuarter: undefined,
    departmentName: undefined,
    numeratorValue: undefined,
    denominatorValue: undefined,
    indicatorValue: undefined,
    dataStatus: undefined,
    collector: undefined,
    reviewer: undefined,
    collectionTime: undefined,
    reviewTime: undefined,
    delFlag: undefined,
    params: {}
  },
  rules: {
    indicatorId: [{ required: true, message: '指标ID不能为空', trigger: 'blur' }],
    collectionPeriod: [{ required: true, message: '统计周期不能为空', trigger: 'blur' }],
    collectionYear: [{ required: true, message: '统计年份不能为空', trigger: 'blur' }],
    departmentName: [{ required: true, message: '科室名称不能为空', trigger: 'blur' }]
  }
});

const { queryParams, form, rules } = toRefs(data);

// 工具函数
const getTagType = (value: any): string => {
  if (value === '0' || value === 0) return 'warning';
  if (value === '1' || value === 1) return 'success';
  if (value === '2' || value === 2) return 'info';
  return 'info';
};

const getOptionLabel = (options: any[], value: any): string => {
  const option = options.find(opt => opt.value === value);
  return option ? option.label : value;
};

/** 查询数据采集记录列表 */
const getList = async () => {
  loading.value = true;
  try {
    const res = await listQcDataCollection(queryParams.value);
    qcDataCollectionList.value = res.rows;
    total.value = res.total;
  } catch (error) {
    console.error('获取数据采集记录列表失败:', error);
    proxy?.$modal.msgError('获取数据失败');
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
  qcDataCollectionFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: QcDataCollectionVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加数据采集记录';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: QcDataCollectionVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  try {
    const res = await getQcDataCollection(_id);
    Object.assign(form.value, res.data);
    dialog.visible = true;
    dialog.title = '修改数据采集记录';
  } catch (error) {
    console.error('获取数据采集记录详情失败:', error);
    proxy?.$modal.msgError('获取数据失败');
  }
};

/** 提交按钮 */
const submitForm = () => {
  qcDataCollectionFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      try {
        if (form.value.id) {
          await updateQcDataCollection(form.value);
          proxy?.$modal.msgSuccess('修改成功');
        } else {
          await addQcDataCollection(form.value);
          proxy?.$modal.msgSuccess('新增成功');
        }
        dialog.visible = false;
        await getList();
      } catch (error) {
        console.error('提交数据采集记录失败:', error);
        proxy?.$modal.msgError('操作失败');
      } finally {
        buttonLoading.value = false;
      }
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: QcDataCollectionVO) => {
  const _ids = row?.id || ids.value;
  try {
    await proxy?.$modal.confirm('是否确认删除选中的数据采集记录？');
    await delQcDataCollection(_ids);
    proxy?.$modal.msgSuccess('删除成功');
    await getList();
  } catch (error) {
    if (error !== 'cancel') {
      console.error('删除数据采集记录失败:', error);
      proxy?.$modal.msgError('删除失败');
    }
  }
};

/** 导出按钮操作 */
const handleExport = () => {
  try {
    proxy?.download(
      'system/qcDataCollection/export',
      {
        ...queryParams.value
      },
      `qcDataCollection_${new Date().getTime()}.xlsx`
    );
  } catch (error) {
    console.error('导出数据采集记录失败:', error);
    proxy?.$modal.msgError('导出失败');
  }
};

/** 字段配置 */
const handleFieldConfig = () => {
  showFieldConfig.value = true;
};

const handleFieldConfigConfirm = () => {
  showFieldConfig.value = false;
  // 配置已自动保存到localStorage
};

/** 搜索配置 */
const handleSearchConfig = () => {
  showSearchConfig.value = true;
};

const handleSearchConfigConfirm = () => {
  showSearchConfig.value = false;
  // 配置已自动保存到localStorage
};

/** 切换搜索显示 */
const toggleSearch = () => {
  showSearch.value = !showSearch.value;
};

onMounted(() => {
  getList();
});
</script>

<style lang="scss" scoped>
.app-container {
  padding: 20px;
  background-color: #f5f5f5;
  min-height: calc(100vh - 84px);
}

.page-header {
  margin-bottom: 20px;

  .page-title {
    font-size: 24px;
    font-weight: 600;
    color: #1d2129;
    margin-bottom: 8px;

    .title-icon {
      margin-right: 8px;
      color: #1890ff;
    }
  }

  .page-description {
    color: #86909c;
    font-size: 14px;
  }
}

.search-container {
  .search-card {
    border-radius: 8px;
    box-shadow: 0 2px 8px rgba(0, 0, 0, 0.06);

    .search-header {
      display: flex;
      justify-content: space-between;
      align-items: center;

      .search-title {
        font-weight: 600;
        color: #1d2129;

        .search-icon {
          margin-right: 6px;
          color: #1890ff;
        }
      }

      .search-actions {
        .config-btn {
          font-size: 12px;
          padding: 4px 8px;

          .btn-icon {
            margin-right: 4px;
          }
        }
      }
    }
  }
}

.table-card {
  border-radius: 8px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.06);

  .table-header {
    display: flex;
    justify-content: space-between;
    align-items: center;
    flex-wrap: wrap;
    gap: 12px;

    .table-title {
      display: flex;
      align-items: center;
      font-weight: 600;
      color: #1d2129;

      .table-icon {
        margin-right: 8px;
        color: #1890ff;
      }
    }

    .table-actions {
      display: flex;
      gap: 8px;
      flex-wrap: wrap;

      .action-btn {
        .btn-icon {
          margin-right: 6px;
        }
      }

      .config-btn {
        font-size: 12px;
        padding: 6px 12px;

        .btn-icon {
          margin-right: 4px;
        }
      }
    }
  }
}

.data-table {
  border-radius: 6px;
  overflow: hidden;

  :deep(.el-table__header-wrapper) {
    background-color: #fafafa;
  }

  :deep(.el-table__row) {
    &:hover {
      background-color: #f0f9ff;
    }
  }
}

.pagination-wrapper {
  margin-top: 20px;
  display: flex;
  justify-content: center;
}

.form-dialog {
  .form-content {
    max-height: 60vh;
    overflow-y: auto;
  }

  .dialog-footer {
    text-align: right;
    padding-top: 20px;
    border-top: 1px solid #ebeef5;
  }
}

// 响应式设计
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
    align-items: stretch;

    .table-actions {
      justify-content: center;
    }
  }

  .search-header {
    flex-direction: column;
    align-items: stretch;
    gap: 12px;
  }
}

// 动画效果
@keyframes fadeIn {
  from {
    opacity: 0;
    transform: translateY(-10px);
  }
  to {
    opacity: 1;
    transform: translateY(0);
  }
}

.search-container,
.table-card {
  animation: fadeIn 0.3s ease-out;
}
</style>
