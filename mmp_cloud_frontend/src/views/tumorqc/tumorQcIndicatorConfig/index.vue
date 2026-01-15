<template>
  <div class="app-container">
    <!-- 页面标题 -->
    <div class="page-header mb-4">
      <h2 class="page-title">
        <i-ep-setting class="title-icon"></i-ep-setting>
        肿瘤质控指标配置管理
      </h2>
      <p class="page-description">管理系统肿瘤质控指标的配置信息，包括指标名称、权重、计算规则和预警阈值等</p>
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
            <span>指标配置列表</span>
            <el-tag type="info" size="small" class="ml-2">{{ total }} 条记录</el-tag>
          </div>
          <div class="table-actions">
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['tumorqc:tumorQcIndicatorConfig:add']" size="small"
              >新增</el-button
            >
            <el-button
              type="success"
              plain
              icon="Edit"
              :disabled="single"
              @click="handleUpdate()"
              v-hasPermi="['tumorqc:tumorQcIndicatorConfig:edit']"
              size="small"
              >修改</el-button
            >
            <el-button
              type="danger"
              plain
              icon="Delete"
              :disabled="multiple"
              @click="handleDelete()"
              v-hasPermi="['tumorqc:tumorQcIndicatorConfig:remove']"
              size="small"
              >删除</el-button
            >
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['tumorqc:tumorQcIndicatorConfig:export']" size="small"
              >导出</el-button
            >
            <el-button type="info" plain icon="Upload" @click="handleImport" v-hasPermi="['tumorqc:tumorQcIndicatorConfig:import']" size="small"
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

      <el-table v-loading="loading" border :data="tumorQcIndicatorConfigList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column
          v-for="field in visibleColumns"
          :key="field.prop"
          :label="field.label"
          :prop="field.prop"
          :width="field.width"
          :min-width="field.minWidth || 120"
          resizable
          align="center"
        >
          <template #default="scope">
            <span v-if="field.prop === 'effectiveDate'">{{ parseTime(scope.row[field.prop], '{y}-{m}-{d}') }}</span>
            <el-tag v-else-if="field.prop === 'isEnabled'" :type="scope.row[field.prop] == 1 ? 'success' : 'danger'">
              {{ scope.row[field.prop] == 1 ? '启用' : '禁用' }}
            </el-tag>
            <el-tag v-else-if="field.prop === 'delFlag'" :type="scope.row[field.prop] == 1 ? 'danger' : 'success'">
              {{ scope.row[field.prop] == 1 ? '已删除' : '未删除' }}
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
                v-hasPermi="['tumorqc:tumorQcIndicatorConfig:edit']"
              ></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button
                link
                type="primary"
                icon="Delete"
                @click="handleDelete(scope.row)"
                v-hasPermi="['tumorqc:tumorQcIndicatorConfig:remove']"
              ></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改肿瘤质控指标配置对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="800px" append-to-body>
      <el-form ref="tumorQcIndicatorConfigFormRef" :model="form" :rules="rules" label-width="120px">
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
            <el-form-item label="指标分类" prop="indicatorCategory">
              <el-select v-model="form.indicatorCategory" placeholder="请选择指标分类" filterable clearable style="width: 100%">
                <el-option label="医疗质量" value="医疗质量" />
                <el-option label="医疗安全" value="医疗安全" />
                <el-option label="医疗效率" value="医疗效率" />
                <el-option label="患者满意度" value="患者满意度" />
                <el-option label="其他" value="其他" />
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="肿瘤类型" prop="tumorType">
              <el-select v-model="form.tumorType" placeholder="请选择肿瘤类型" filterable clearable style="width: 100%">
                <el-option label="肺癌" value="肺癌" />
                <el-option label="肝癌" value="肝癌" />
                <el-option label="胃癌" value="胃癌" />
                <el-option label="乳腺癌" value="乳腺癌" />
                <el-option label="结直肠癌" value="结直肠癌" />
                <el-option label="其他" value="其他" />
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="指标类型" prop="indicatorType">
              <el-select v-model="form.indicatorType" placeholder="请选择指标类型" filterable clearable style="width: 100%">
                <el-option label="比率指标" value="比率指标" />
                <el-option label="率指标" value="率指标" />
                <el-option label="均值指标" value="均值指标" />
                <el-option label="计数指标" value="计数指标" />
                <el-option label="其他" value="其他" />
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="采集频率" prop="collectionFrequency">
              <el-select v-model="form.collectionFrequency" placeholder="请选择采集频率" style="width: 100%">
                <el-option label="实时" value="实时" />
                <el-option label="每日" value="每日" />
                <el-option label="每周" value="每周" />
                <el-option label="每月" value="每月" />
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="标准值" prop="standardValue">
              <el-input-number v-model="form.standardValue" :precision="2" placeholder="请输入标准值" style="width: 100%" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="目标值" prop="targetValue">
              <el-input-number v-model="form.targetValue" :precision="2" placeholder="请输入目标值" style="width: 100%" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="生效日期" prop="effectiveDate">
              <el-date-picker
                clearable
                v-model="form.effectiveDate"
                type="datetime"
                value-format="YYYY-MM-DD HH:mm:ss"
                placeholder="请选择生效日期"
                style="width: 100%"
              />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="政策级别" prop="policyLevel">
              <el-select v-model="form.policyLevel" placeholder="请选择政策级别" style="width: 100%">
                <el-option label="国家级" value="国家级" />
                <el-option label="省级" value="省级" />
                <el-option label="市级" value="市级" />
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>
        <el-form-item label="计算公式" prop="calculationFormula">
          <el-input v-model="form.calculationFormula" type="textarea" :rows="4" placeholder="请输入计算公式" />
        </el-form-item>
        <el-form-item label="数据来源" prop="dataSource">
          <el-input v-model="form.dataSource" type="textarea" :rows="4" placeholder="请输入数据来源" />
        </el-form-item>
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="政策来源" prop="policySource">
              <el-input v-model="form.policySource" placeholder="请输入政策来源" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="是否启用" prop="isEnabled">
              <el-select v-model="form.isEnabled" placeholder="请选择是否启用" style="width: 100%">
                <el-option label="是" value="1" />
                <el-option label="否" value="0" />
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="是否删除" prop="delFlag">
              <el-select v-model="form.delFlag" placeholder="请选择是否删除" style="width: 100%">
                <el-option label="正常" value="0" />
                <el-option label="已删除" value="1" />
              </el-select>
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

    <FieldConfigDialog v-model:visible="showFieldConfig" :field-config-manager="fieldConfigManager" @confirm="handleFieldConfigConfirm" />
    <SearchConfigDialog v-model="searchConfigVisible" :search-config-manager="searchConfigManager" @confirm="handleSearchConfigConfirm" />
  </div>
</template>

<script setup name="TumorQcIndicatorConfig" lang="ts">
import {
  listTumorQcIndicatorConfig,
  getTumorQcIndicatorConfig,
  delTumorQcIndicatorConfig,
  addTumorQcIndicatorConfig,
  updateTumorQcIndicatorConfig
} from '@/api/tumorqc/tumorQcIndicatorConfig';
import { TumorQcIndicatorConfigVO, TumorQcIndicatorConfigQuery, TumorQcIndicatorConfigForm } from '@/api/tumorqc/tumorQcIndicatorConfig/types';
import { createTumorQcIndicatorConfigFieldConfig } from '@/utils/configs/tumorqc/FieldConfigs';
import FieldConfigDialog from '@/components/FieldConfigDialog.vue';
import SearchConfigDialog from '@/components/SearchConfigDialog.vue';
import { createTumorQcIndicatorConfigSearchConfig } from '@/utils/configs/tumorqc/SearchConfigs';
import DynamicSearchForm from '@/components/DynamicSearchForm.vue';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const tumorQcIndicatorConfigList = ref<TumorQcIndicatorConfigVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const showFieldConfig = ref(false);
const searchConfigVisible = ref(false);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const fieldConfigManager = createTumorQcIndicatorConfigFieldConfig();
const searchConfigManager = createTumorQcIndicatorConfigSearchConfig();
const visibleSearchFields = computed(() => searchConfigManager.getVisibleFields());
const visibleColumns = computed(() => fieldConfigManager.visibleFields);

const queryFormRef = ref();
const tumorQcIndicatorConfigFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: TumorQcIndicatorConfigForm = {
  id: undefined,
  indicatorCode: undefined,
  indicatorName: undefined,
  indicatorCategory: undefined,
  tumorType: undefined,
  indicatorType: undefined,
  calculationFormula: undefined,
  dataSource: undefined,
  collectionFrequency: undefined,
  standardValue: undefined,
  targetValue: undefined,
  effectiveDate: undefined,
  policyLevel: undefined,
  policySource: undefined,
  isEnabled: undefined,
  delFlag: undefined
};
const data = reactive<PageData<TumorQcIndicatorConfigForm, TumorQcIndicatorConfigQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    indicatorCode: undefined,
    indicatorName: undefined,
    indicatorCategory: undefined,
    tumorType: undefined,
    indicatorType: undefined,
    calculationFormula: undefined,
    dataSource: undefined,
    collectionFrequency: undefined,
    standardValue: undefined,
    targetValue: undefined,
    effectiveDate: undefined,
    policyLevel: undefined,
    policySource: undefined,
    isEnabled: undefined,
    delFlag: undefined,
    params: {}
  },
  rules: {
    indicatorCode: [{ required: true, message: '指标编码不能为空', trigger: 'blur' }],
    indicatorName: [{ required: true, message: '指标名称不能为空', trigger: 'blur' }],
    indicatorCategory: [{ required: true, message: '指标分类不能为空', trigger: 'change' }],
    indicatorType: [{ required: true, message: '指标类型不能为空', trigger: 'change' }],
    collectionFrequency: [{ required: true, message: '采集频率不能为空', trigger: 'change' }],
    effectiveDate: [{ required: true, message: '生效日期不能为空', trigger: 'blur' }]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询肿瘤质控指标配置列表 */
const getList = async () => {
  loading.value = true;
  const res = await listTumorQcIndicatorConfig(queryParams.value);
  tumorQcIndicatorConfigList.value = res.rows;
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
  tumorQcIndicatorConfigFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: TumorQcIndicatorConfigVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加肿瘤质控指标配置';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: TumorQcIndicatorConfigVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getTumorQcIndicatorConfig(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改肿瘤质控指标配置';
};

/** 提交按钮 */
const submitForm = () => {
  tumorQcIndicatorConfigFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateTumorQcIndicatorConfig(form.value).finally(() => (buttonLoading.value = false));
      } else {
        await addTumorQcIndicatorConfig(form.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: TumorQcIndicatorConfigVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除肿瘤质控指标配置编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delTumorQcIndicatorConfig(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/tumorQcIndicatorConfig/export',
    {
      ...queryParams.value
    },
    `tumorQcIndicatorConfig_${new Date().getTime()}.xlsx`
  );
};

/** 导入按钮操作 */
const handleImport = () => {
  proxy?.$modal.upload('system/tumorQcIndicatorConfig/importData', '肿瘤质控指标配置导入', 'xls,xlsx', (response: any) => {
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

.qc-config-table {
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

.qc-config-dialog {
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

  .qc-config-dialog {
    :deep(.el-dialog) {
      width: 95% !important;
      margin: 5vh auto;
    }
  }
}
</style>
