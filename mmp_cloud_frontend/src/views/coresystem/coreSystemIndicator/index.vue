<template>
  <div class="app-container">
    <!-- 页面标题 -->
    <div class="page-header mb-4">
      <h2 class="page-title">
        <i-ep-data-analysis class="title-icon"></i-ep-data-analysis>
        核心制度指标管理
      </h2>
      <p class="page-description">管理系统核心制度的考核指标，包括指标名称、权重、计算规则等信息</p>
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
            <span>指标列表</span>
            <el-tag type="info" size="small" class="ml-2">{{ total }} 条记录</el-tag>
          </div>
          <div class="table-actions">
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['coresystem:coreSystemIndicator:add']" size="small"
              >新增</el-button
            >
            <el-button
              type="success"
              plain
              icon="Edit"
              :disabled="single"
              @click="handleUpdate()"
              v-hasPermi="['coresystem:coreSystemIndicator:edit']"
              size="small"
              >修改</el-button
            >
            <el-button
              type="danger"
              plain
              icon="Delete"
              :disabled="multiple"
              @click="handleDelete()"
              v-hasPermi="['coresystem:coreSystemIndicator:remove']"
              size="small"
              >删除</el-button
            >
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['coresystem:coreSystemIndicator:export']" size="small"
              >导出</el-button
            >
            <el-button type="info" plain icon="Upload" @click="handleImport" v-hasPermi="['coresystem:coreSystemIndicator:import']" size="small"
              >导入</el-button
            >
            <el-button text type="primary" @click="showFieldConfig = true" class="config-btn">
              <i-ep-setting class="btn-icon"></i-ep-setting>
              字段配置
            </el-button>
            <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
          </div>
        </div>
      </template>

      <el-table v-loading="loading" border :data="coreSystemIndicatorList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column
          v-for="field in fieldConfigManager.getVisibleFields()"
          :key="field.prop"
          :label="field.label"
          :prop="field.prop"
          :width="field.width"
          :min-width="field.minWidth || 120"
          resizable
          align="center"
        >
          <template #default="scope">
            <el-tag v-if="field.prop === 'isReverse'" :type="scope.row[field.prop] === '1' ? 'warning' : 'success'">
              {{ scope.row[field.prop] === '1' ? '是' : '否' }}
            </el-tag>
            <el-tag v-else-if="field.prop === 'isEnabled'" :type="scope.row[field.prop] === '1' ? 'success' : 'danger'">
              {{ scope.row[field.prop] === '1' ? '启用' : '禁用' }}
            </el-tag>
            <el-tag v-else-if="field.prop === 'isCustom'" :type="scope.row[field.prop] === '1' ? 'info' : 'success'">
              {{ scope.row[field.prop] === '1' ? '是' : '否' }}
            </el-tag>
            <el-tag v-else-if="field.prop === 'delFlag'" :type="scope.row[field.prop] === '0' ? 'success' : 'danger'">
              {{ scope.row[field.prop] === '0' ? '正常' : '已删除' }}
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
                v-hasPermi="['coresystem:coreSystemIndicator:edit']"
              ></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button
                link
                type="primary"
                icon="Delete"
                @click="handleDelete(scope.row)"
                v-hasPermi="['coresystem:coreSystemIndicator:remove']"
              ></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改核心制度指标对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="700px" append-to-body>
      <el-form ref="coreSystemIndicatorFormRef" :model="form" :rules="rules" label-width="120px">
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="指标编码" prop="indicatorCode">
              <el-input v-model="form.indicatorCode" placeholder="请输入指标编码" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="指标名称" prop="indicatorName">
              <el-input v-model="form.indicatorName" placeholder="请输入指标名称" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="所属制度ID" prop="systemId">
              <el-input v-model="form.systemId" placeholder="请输入所属制度ID" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="父指标ID" prop="parentId">
              <el-input v-model="form.parentId" placeholder="请输入父指标ID" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="计算周期" prop="calculationCycle">
              <el-select v-model="form.calculationCycle" placeholder="请选择计算周期" style="width: 100%">
                <el-option label="日" value="日" />
                <el-option label="周" value="周" />
                <el-option label="月" value="月" />
                <el-option label="季度" value="季度" />
                <el-option label="年" value="年" />
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="目标值" prop="targetValue">
              <el-input-number v-model="form.targetValue" :precision="2" :min="0" placeholder="请输入目标值" style="width: 100%" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="指标分值" prop="indicatorScore">
              <el-input-number v-model="form.indicatorScore" :precision="1" :min="0" :max="100" placeholder="请输入指标分值" style="width: 100%" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="预警阈值" prop="alertThreshold">
              <el-input-number v-model="form.alertThreshold" :precision="2" :min="0" :max="100" placeholder="请输入预警阈值" style="width: 100%" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="20">
          <el-col :span="8">
            <el-form-item label="是否反向指标" prop="isReverse">
              <el-select v-model="form.isReverse" placeholder="请选择是否反向指标" style="width: 100%">
                <el-option label="是" value="1" />
                <el-option label="否" value="0" />
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="是否启用" prop="isEnabled">
              <el-select v-model="form.isEnabled" placeholder="请选择是否启用" style="width: 100%">
                <el-option label="是" value="1" />
                <el-option label="否" value="0" />
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="是否自定义" prop="isCustom">
              <el-select v-model="form.isCustom" placeholder="请选择是否自定义" style="width: 100%">
                <el-option label="是" value="1" />
                <el-option label="否" value="0" />
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="20">
          <el-col :span="24">
            <el-form-item label="是否删除" prop="delFlag">
              <el-select v-model="form.delFlag" placeholder="请选择是否删除" style="width: 200px">
                <el-option label="正常" value="0" />
                <el-option label="已删除" value="1" />
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>
        <el-form-item label="计算公式" prop="calculationFormula">
          <el-input v-model="form.calculationFormula" type="textarea" :rows="3" placeholder="请输入计算公式" />
        </el-form-item>
        <el-form-item label="数据来源" prop="dataSource">
          <el-input v-model="form.dataSource" type="textarea" :rows="3" placeholder="请输入数据来源" />
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
    <SearchConfigDialog v-model="searchConfigVisible" :search-config-manager="searchConfigManager" @confirm="handleSearchConfigConfirm" />
  </div>
</template>

<script setup name="CoreSystemIndicator" lang="ts">
import {
  listCoreSystemIndicator,
  getCoreSystemIndicator,
  delCoreSystemIndicator,
  addCoreSystemIndicator,
  updateCoreSystemIndicator
} from '@/api/coresystem/coreSystemIndicator';
import { createCoreSystemIndicatorFieldConfig } from '@/utils/configs/coresystem/FieldConfigs';
import FieldConfigDialog from '@/components/FieldConfigDialog.vue';
import SearchConfigDialog from '@/components/SearchConfigDialog.vue';
import { createCoreSystemIndicatorSearchConfig } from '@/utils/configs/coresystem/SearchConfigs';
import DynamicSearchForm from '@/components/DynamicSearchForm.vue';

const coreSystemIndicatorList = ref<CoreSystemIndicatorVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const showFieldConfig = ref(false);
const searchConfigVisible = ref(false);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const fieldConfigManager = createCoreSystemIndicatorFieldConfig();
const searchConfigManager = createCoreSystemIndicatorSearchConfig();
const visibleSearchFields = computed(() => searchConfigManager.getVisibleFields());

const queryFormRef = ref();
const coreSystemIndicatorFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: CoreSystemIndicatorForm = {
  id: undefined,
  indicatorCode: undefined,
  indicatorName: undefined,
  systemId: undefined,
  parentId: undefined,
  indicatorType: undefined,
  calculationFormula: undefined,
  calculationCycle: undefined,
  dataSource: undefined,
  targetValue: undefined,
  indicatorScore: undefined,
  isReverse: undefined,
  alertThreshold: undefined,
  isEnabled: undefined,
  isCustom: undefined,
  delFlag: undefined
};
const data = reactive<PageData<CoreSystemIndicatorForm, CoreSystemIndicatorQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    indicatorCode: undefined,
    indicatorName: undefined,
    systemId: undefined,
    parentId: undefined,
    indicatorType: undefined,
    calculationFormula: undefined,
    calculationCycle: undefined,
    dataSource: undefined,
    targetValue: undefined,
    indicatorScore: undefined,
    isReverse: undefined,
    alertThreshold: undefined,
    isEnabled: undefined,
    isCustom: undefined,
    delFlag: undefined,
    params: {}
  },
  rules: {
    indicatorCode: [{ required: true, message: '指标编码不能为空', trigger: 'blur' }],
    indicatorName: [{ required: true, message: '指标名称不能为空', trigger: 'blur' }],
    systemId: [{ required: true, message: '所属制度ID不能为空', trigger: 'blur' }]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询核心制度指标列表 */
const getList = async () => {
  loading.value = true;
  const res = await listCoreSystemIndicator(queryParams.value);
  coreSystemIndicatorList.value = res.rows;
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
  coreSystemIndicatorFormRef.value?.resetFields();
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

const handleSearchConfig = () => {
  searchConfigVisible.value = true;
};

const handleSearchConfigConfirm = () => {
  searchConfigVisible.value = false;
};

/** 多选框选中数据 */
const handleSelectionChange = (selection: CoreSystemIndicatorVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加核心制度指标';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: CoreSystemIndicatorVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getCoreSystemIndicator(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改核心制度指标';
};

/** 提交按钮 */
const submitForm = () => {
  coreSystemIndicatorFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateCoreSystemIndicator(form.value).finally(() => (buttonLoading.value = false));
      } else {
        await addCoreSystemIndicator(form.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: CoreSystemIndicatorVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除核心制度指标编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delCoreSystemIndicator(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/coreSystemIndicator/export',
    {
      ...queryParams.value
    },
    `coreSystemIndicator_${new Date().getTime()}.xlsx`
  );
};

/** 导入按钮操作 */
const handleImport = () => {
  proxy?.$modal.upload('system/coreSystemIndicator/importData', '核心制度指标导入', 'xls,xlsx', (response: any) => {
    proxy?.$modal.msgSuccess('导入成功');
    getList();
  });
};

/** 字段配置确认 */
const handleFieldConfigConfirm = () => {
  showFieldConfig.value = false;
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
  margin-bottom: 24px;

  .page-title {
    font-size: 24px;
    font-weight: 600;
    color: #1d2129;
    margin-bottom: 8px;
    display: flex;
    align-items: center;
    gap: 8px;

    .title-icon {
      color: #409eff;
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

.indicator-table {
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

.indicator-dialog {
  :deep(.el-dialog__body) {
    padding: 24px;
  }

  .w-full {
    width: 100%;
  }
}

.dialog-footer {
  text-align: right;
  padding-top: 16px;
  border-top: 1px solid #ebeef5;
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
    align-items: flex-start;
    gap: 12px;

    .table-actions {
      width: 100%;
      justify-content: flex-end;
    }
  }

  .indicator-dialog {
    :deep(.el-dialog) {
      width: 95% !important;
      margin: 5vh auto;
    }
  }
}
</style>
