<template>
  <div class="app-container">
    <!-- 页面标题 -->
    <div class="page-header mb-4">
      <h2 class="page-title">
        <i-ep-document-checked class="title-icon"></i-ep-document-checked>
        资质准入条件管理
      </h2>
      <p class="page-description">管理系统资质准入条件，包括条件运算符、条件值、逻辑关系等信息</p>
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
            <span>准入条件列表</span>
            <el-tag type="info" size="small" class="ml-2">{{ total }} 条记录</el-tag>
          </div>
          <div class="table-actions">
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['qualification:qualificationAdmissionCondition:add']" size="small"
              >新增</el-button
            >
            <el-button
              type="success"
              plain
              icon="Edit"
              :disabled="single"
              @click="handleUpdate()"
              v-hasPermi="['qualification:qualificationAdmissionCondition:edit']"
              size="small"
              >修改</el-button
            >
            <el-button
              type="danger"
              plain
              icon="Delete"
              :disabled="multiple"
              @click="handleDelete()"
              v-hasPermi="['qualification:qualificationAdmissionCondition:remove']"
              size="small"
              >删除</el-button
            >
            <el-button
              type="warning"
              plain
              icon="Download"
              @click="handleExport"
              v-hasPermi="['qualification:qualificationAdmissionCondition:export']"
              size="small"
              >导出</el-button
            >
            <el-button
              type="primary"
              plain
              icon="Upload"
              @click="handleImport"
              v-hasPermi="['qualification:qualificationAdmissionCondition:import']"
              size="small"
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

      <el-table v-loading="loading" border :data="qualificationAdmissionConditionList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column
          v-for="field in visibleColumns"
          :key="field.prop"
          :label="field.label"
          align="center"
          :prop="field.prop"
          :width="field.width || undefined"
          :min-width="field.minWidth || 120"
          resizable
        >
          <template #default="scope">
            <span>{{ scope.row[field.prop] }}</span>
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
                v-hasPermi="['qualification:qualificationAdmissionCondition:edit']"
              ></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button
                link
                type="primary"
                icon="Delete"
                @click="handleDelete(scope.row)"
                v-hasPermi="['qualification:qualificationAdmissionCondition:remove']"
              ></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改资质准入条件对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="700px" append-to-body>
      <el-form ref="qualificationAdmissionConditionFormRef" :model="form" :rules="rules" label-width="120px">
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="资质ID" prop="qualificationId">
              <el-input v-model="form.qualificationId" placeholder="请输入资质ID" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="资质类型" prop="qualificationType">
              <el-select v-model="form.qualificationType" placeholder="请选择资质类型" style="width: 100%">
                <el-option label="医师" value="医师" />
                <el-option label="医技" value="医技" />
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="条件类型" prop="conditionType">
              <el-select v-model="form.conditionType" placeholder="请选择条件类型" style="width: 100%">
                <el-option label="学历" value="学历" />
                <el-option label="职称" value="职称" />
                <el-option label="工作年限" value="工作年限" />
                <el-option label="专业" value="专业" />
                <el-option label="培训" value="培训" />
                <el-option label="考核" value="考核" />
                <el-option label="证书" value="证书" />
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="条件运算符" prop="conditionOperator">
              <el-select v-model="form.conditionOperator" placeholder="请选择条件运算符" style="width: 100%">
                <el-option label="=" value="=" />
                <el-option label=">" value=">" />
                <el-option label="<" value="<" />
                <el-option label=">=" value=">=" />
                <el-option label="<=" value="<=" />
                <el-option label="in" value="in" />
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>
        <el-form-item label="条件值" prop="conditionValue">
          <el-input v-model="form.conditionValue" type="textarea" :rows="3" placeholder="请输入条件值" />
        </el-form-item>
        <el-row :gutter="20">
          <el-col :span="8">
            <el-form-item label="条件单位" prop="conditionUnit">
              <el-input v-model="form.conditionUnit" placeholder="请输入条件单位" />
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="是否必须" prop="isRequired">
              <el-select v-model="form.isRequired" placeholder="请选择是否必须" style="width: 100%">
                <el-option label="是" value="1" />
                <el-option label="否" value="0" />
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="逻辑关系" prop="logicRelation">
              <el-select v-model="form.logicRelation" placeholder="请选择逻辑关系" style="width: 100%">
                <el-option label="AND" value="AND" />
                <el-option label="OR" value="OR" />
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="排序" prop="sortOrder">
              <el-input-number v-model="form.sortOrder" :min="0" placeholder="请输入排序" style="width: 100%" />
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
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" type="textarea" :rows="3" placeholder="请输入备注" />
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
    <SearchConfigDialog v-model="searchConfigVisible" :search-config-manager="searchConfigManager" @confirm="handleSearchConfigConfirm" />
  </div>
</template>

<script setup name="QualificationAdmissionCondition" lang="ts">
import {
  listQualificationAdmissionCondition,
  getQualificationAdmissionCondition,
  delQualificationAdmissionCondition,
  addQualificationAdmissionCondition,
  updateQualificationAdmissionCondition
} from '@/api/qualification/qualificationAdmissionCondition';
import {
  QualificationAdmissionConditionVO,
  QualificationAdmissionConditionQuery,
  QualificationAdmissionConditionForm
} from '@/api/qualification/qualificationAdmissionCondition/types';
import { createQualificationAdmissionConditionFieldConfig } from '@/utils/mmpFieldConfigs';
import FieldConfigDialog from '@/components/FieldConfigDialog.vue';
import DynamicSearchForm from '@/components/DynamicSearchForm.vue';
import SearchConfigDialog from '@/components/SearchConfigDialog.vue';
import { createQualificationAdmissionConditionSearchConfig } from '@/utils/mmpSearchConfigs';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const qualificationAdmissionConditionList = ref<QualificationAdmissionConditionVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const showFieldConfig = ref(false);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const qualificationAdmissionConditionFormRef = ref<ElFormInstance>();

// 字段配置相关变量
const fieldConfigManager = createQualificationAdmissionConditionFieldConfig();
const visibleColumns = computed(() => fieldConfigManager.getVisibleFields());
const searchConfigManager = createQualificationAdmissionConditionSearchConfig();
const searchConfigVisible = ref(false);
const visibleSearchFields = computed(() => searchConfigManager.getVisibleFields());

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: QualificationAdmissionConditionForm = {
  id: undefined,
  qualificationId: undefined,
  qualificationType: undefined,
  conditionType: undefined,
  conditionOperator: undefined,
  conditionValue: undefined,
  conditionUnit: undefined,
  isRequired: undefined,
  logicRelation: undefined,
  sortOrder: undefined,
  remark: undefined,
  delFlag: undefined
};
const data = reactive<PageData<QualificationAdmissionConditionForm, QualificationAdmissionConditionQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    qualificationId: undefined,
    qualificationType: undefined,
    conditionType: undefined,
    conditionOperator: undefined,
    conditionValue: undefined,
    conditionUnit: undefined,
    isRequired: undefined,
    logicRelation: undefined,
    sortOrder: undefined,
    delFlag: undefined,
    params: {}
  },
  rules: {
    qualificationId: [{ required: true, message: '资质ID不能为空', trigger: 'blur' }],
    qualificationType: [{ required: true, message: '资质类型不能为空', trigger: 'change' }],
    conditionType: [{ required: true, message: '条件类型不能为空', trigger: 'change' }]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询资质准入条件列表 */
const getList = async () => {
  loading.value = true;
  const res = await listQualificationAdmissionCondition(queryParams.value);
  qualificationAdmissionConditionList.value = res.rows;
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
  qualificationAdmissionConditionFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: QualificationAdmissionConditionVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加资质准入条件';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: QualificationAdmissionConditionVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getQualificationAdmissionCondition(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改资质准入条件';
};

/** 提交按钮 */
const submitForm = () => {
  qualificationAdmissionConditionFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateQualificationAdmissionCondition(form.value).finally(() => (buttonLoading.value = false));
      } else {
        await addQualificationAdmissionCondition(form.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: QualificationAdmissionConditionVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除资质准入条件编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delQualificationAdmissionCondition(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导入按钮操作 */
const handleImport = () => {
  proxy.$modal.upload({
    url: '/dev-api/qualification/qualificationAdmissionCondition/importData',
    success: () => {
      proxy.$modal.msgSuccess('导入成功');
      getList();
    }
  });
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/qualificationAdmissionCondition/export',
    {
      ...queryParams.value
    },
    `qualificationAdmissionCondition_${new Date().getTime()}.xlsx`
  );
};

/** 字段配置确认 */
const handleFieldConfigConfirm = () => {
  // 字段配置更新后刷新列表
  getList();
};

const handleSearchConfig = () => {
  searchConfigVisible.value = true;
};
const handleSearchConfigConfirm = () => {
  searchConfigVisible.value = false;
};

onMounted(() => {
  getList();
});
</script>

<style lang="scss" scoped>
// 全局样式
.app-container {
  padding: 20px;
  background-color: #f5f5f5;
  min-height: 100vh;
}

// 页面标题区域
.page-header {
  margin-bottom: 20px;

  .page-title {
    display: flex;
    align-items: center;
    font-size: 24px;
    font-weight: 600;
    color: #1d2129;
    margin-bottom: 8px;

    .title-icon {
      margin-right: 8px;
      color: #409eff;
    }
  }

  .page-description {
    color: #86909c;
    font-size: 14px;
    margin: 0;
  }
}

// 搜索区域
.search-container {
  .search-card {
    border-radius: 8px;

    :deep(.el-card__header) {
      padding: 16px 20px;
      border-bottom: 1px solid #ebeef5;
    }

    .search-header {
      display: flex;
      justify-content: space-between;
      align-items: center;
      width: 100%;

      .search-title {
        display: flex;
        align-items: center;
        font-weight: 600;
        color: #1d2129;

        .search-icon {
          margin-right: 8px;
          color: #409eff;
        }
      }

      .search-actions {
        .config-btn {
          font-size: 12px;
          padding: 6px 12px;
          height: auto;
          border: none;
          color: #86909c;

          &:hover {
            color: #409eff;
            background-color: #ecf5ff;
          }

          .btn-icon {
            margin-right: 4px;
          }
        }
      }
    }

    :deep(.el-card__body) {
      padding: 20px;
    }
  }
}

// 表格区域
.table-card {
  border-radius: 8px;

  :deep(.el-card__header) {
    padding: 16px 20px;
    border-bottom: 1px solid #ebeef5;
  }

  .table-header {
    display: flex;
    justify-content: space-between;
    align-items: center;
    width: 100%;

    .table-title {
      display: flex;
      align-items: center;
      font-weight: 600;
      color: #1d2129;

      .table-icon {
        color: #409eff;
      }
    }

    .table-actions {
      display: flex;
      gap: 8px;
      align-items: center;

      .config-btn {
        font-size: 12px;
        padding: 6px 12px;
        height: auto;
        border: none;
        color: #86909c;

        &:hover {
          color: #409eff;
          background-color: #ecf5ff;
        }

        .btn-icon {
          margin-right: 4px;
        }
      }
    }
  }

  :deep(.el-card__body) {
    padding: 0;
  }
}

// 表格样式
:deep(.el-table) {
  .el-table__header {
    th {
      background-color: #fafafa;
      font-weight: 600;
      color: #1d2129;
    }
  }

  .el-table__row {
    &:hover {
      background-color: #f5f7fa;
    }
  }
}

// 对话框样式
:deep(.el-dialog) {
  .el-dialog__body {
    padding: 24px;
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

  :deep(.el-dialog) {
    width: 95% !important;
    margin: 5vh auto;
  }
}
</style>
