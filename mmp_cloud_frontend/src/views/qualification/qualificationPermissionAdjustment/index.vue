<template>
  <div class="app-container">
    <!-- 页面头部 -->
    <div class="page-header">
      <div class="header-title">
        <i-ep-document-checked />
        资质权限调整历史
      </div>
      <div class="header-desc">管理医师资质权限的调整记录，包括权限级别的变更历史和调整依据</div>
    </div>

    <!-- 搜索区域 -->
    <el-card class="search-card" shadow="hover">
      <template #header>
        <div class="flex items-center justify-between">
          <div class="flex items-center gap-2">
            <i-ep-search />
            <span>搜索条件</span>
          </div>
          <el-button type="info" text icon="Setting" @click="searchConfigVisible = true">搜索配置</el-button>
        </div>
      </template>
      <DynamicSearchForm ref="queryFormRef" :query="queryParams" :visible-fields="visibleSearchFields" @search="handleQuery" @reset="resetQuery" />
    </el-card>

    <!-- 数据表格 -->
    <div class="table-card">
      <div class="mb8 flex items-center gap-2 flex-nowrap">
        <i-ep-list />
        <span class="font-medium">调整记录列表</span>
        <el-tag type="info" size="small" class="ml-2">{{ total }} 条记录</el-tag>
        <div class="ml-auto flex items-center gap-2">
          <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['qualification:qualificationPermissionAdjustment:add']"
            >新增</el-button
          >
          <el-button
            type="success"
            plain
            icon="Edit"
            :disabled="single"
            @click="handleUpdate()"
            v-hasPermi="['qualification:qualificationPermissionAdjustment:edit']"
            >修改</el-button
          >
          <el-button
            type="danger"
            plain
            icon="Delete"
            :disabled="multiple"
            @click="handleDelete()"
            v-hasPermi="['qualification:qualificationPermissionAdjustment:remove']"
            >删除</el-button
          >
          <el-button
            type="warning"
            plain
            icon="Download"
            @click="handleExport"
            v-hasPermi="['qualification:qualificationPermissionAdjustment:export']"
            >导出</el-button
          >
          <el-button type="info" plain icon="Upload" @click="handleImport" v-hasPermi="['qualification:qualificationPermissionAdjustment:import']"
            >导入</el-button
          >
          <el-button type="info" plain icon="Setting" @click="showFieldConfig = true">字段配置</el-button>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </div>
      </div>

      <el-table v-loading="loading" border :data="qualificationPermissionAdjustmentList" @selection-change="handleSelectionChange">
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
            <span v-if="field.prop === 'adjustmentTime'">
              {{ parseTime(scope.row[field.prop], '{y}-{m}-{d}') }}
            </span>
            <el-tag v-else-if="field.prop === 'isAutoAdjustment'" :type="scope.row[field.prop] === '1' ? 'success' : 'info'" size="small">
              {{ scope.row[field.prop] === '1' ? '是' : '否' }}
            </el-tag>
            <span v-else>
              {{ scope.row[field.prop] }}
            </span>
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
                v-hasPermi="['qualification:qualificationPermissionAdjustment:edit']"
              ></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button
                link
                type="primary"
                icon="Delete"
                @click="handleDelete(scope.row)"
                v-hasPermi="['qualification:qualificationPermissionAdjustment:remove']"
              ></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <div class="pagination-container">
        <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
      </div>
    </div>

    <!-- 添加或修改资质权限调整历史对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="700px" append-to-body>
      <el-form ref="qualificationPermissionAdjustmentFormRef" :model="form" :rules="rules" label-width="120px" class="dialog-form">
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="医师ID" prop="doctorId">
              <el-input v-model="form.doctorId" placeholder="请输入医师ID" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="医师姓名" prop="doctorName">
              <el-input v-model="form.doctorName" placeholder="请输入医师姓名" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="20">
          <el-col :span="8">
            <el-form-item label="资质类型" prop="qualificationType">
              <el-select v-model="form.qualificationType" placeholder="请选择资质类型" style="width: 100%">
                <el-option label="医师" value="医师" />
                <el-option label="医技" value="医技" />
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="原权限级别" prop="originalLevel">
              <el-select v-model="form.originalLevel" placeholder="请选择原权限级别" style="width: 100%">
                <el-option label="初级" value="初级" />
                <el-option label="中级" value="中级" />
                <el-option label="高级" value="高级" />
                <el-option label="专家" value="专家" />
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="新权限级别" prop="newLevel">
              <el-select v-model="form.newLevel" placeholder="请选择新权限级别" style="width: 100%">
                <el-option label="初级" value="初级" />
                <el-option label="中级" value="中级" />
                <el-option label="高级" value="高级" />
                <el-option label="专家" value="专家" />
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>
        <el-form-item label="调整原因" prop="adjustmentReason">
          <el-input v-model="form.adjustmentReason" type="textarea" :rows="3" placeholder="请输入调整原因" />
        </el-form-item>
        <el-form-item label="调整依据" prop="adjustmentBasis">
          <el-input v-model="form.adjustmentBasis" type="textarea" :rows="3" placeholder="请输入调整依据" />
        </el-form-item>
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="调整时间" prop="adjustmentTime">
              <el-date-picker
                clearable
                v-model="form.adjustmentTime"
                type="datetime"
                value-format="YYYY-MM-DD HH:mm:ss"
                placeholder="请选择调整时间"
                style="width: 100%"
              >
              </el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="操作人ID" prop="operatorId">
              <el-input v-model="form.operatorId" placeholder="请输入操作人ID" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="20">
          <el-col :span="8">
            <el-form-item label="操作人姓名" prop="operatorName">
              <el-input v-model="form.operatorName" placeholder="请输入操作人姓名" />
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="是否自动调整" prop="isAutoAdjustment">
              <el-select v-model="form.isAutoAdjustment" placeholder="请选择是否自动调整" style="width: 100%">
                <el-option label="是" value="1" />
                <el-option label="否" value="0" />
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
      </el-form>
      <template #footer>
        <div class="dialog-footer">
          <el-button :loading="buttonLoading" type="primary" @click="submitForm">确 定</el-button>
          <el-button @click="cancel">取 消</el-button>
        </div>
      </template>
    </el-dialog>
    <SearchConfigDialog v-model="searchConfigVisible" :search-config-manager="searchConfigManager" @confirm="() => (searchConfigVisible = false)" />
    <FieldConfigDialog v-model:visible="showFieldConfig" :field-config-manager="fieldConfigManager" />
  </div>
</template>

<script setup name="QualificationPermissionAdjustment" lang="ts">
import {
  listQualificationPermissionAdjustment,
  getQualificationPermissionAdjustment,
  delQualificationPermissionAdjustment,
  addQualificationPermissionAdjustment,
  updateQualificationPermissionAdjustment
} from '@/api/qualification/qualificationPermissionAdjustment';
import {
  QualificationPermissionAdjustmentVO,
  QualificationPermissionAdjustmentQuery,
  QualificationPermissionAdjustmentForm
} from '@/api/qualification/qualificationPermissionAdjustment/types';
import DynamicSearchForm from '@/components/DynamicSearchForm.vue';
import SearchConfigDialog from '@/components/SearchConfigDialog.vue';
import { createQualificationPermissionAdjustmentSearchConfig } from '@/utils/configs/qualification/SearchConfigs';
import FieldConfigDialog from '@/components/FieldConfigDialog.vue';
import { createQualificationPermissionAdjustmentFieldConfig } from '@/utils/configs/qualification/FieldConfigs';
import { Search, Setting } from '@element-plus/icons-vue';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const qualificationPermissionAdjustmentList = ref<QualificationPermissionAdjustmentVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref();
const qualificationPermissionAdjustmentFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: QualificationPermissionAdjustmentForm = {
  id: undefined,
  doctorId: undefined,
  doctorName: undefined,
  qualificationType: undefined,
  originalLevel: undefined,
  newLevel: undefined,
  adjustmentReason: undefined,
  adjustmentBasis: undefined,
  adjustmentTime: undefined,
  operatorId: undefined,
  operatorName: undefined,
  isAutoAdjustment: undefined,
  delFlag: undefined
};
const data = reactive<PageData<QualificationPermissionAdjustmentForm, QualificationPermissionAdjustmentQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    doctorName: undefined,
    qualificationType: undefined,
    originalLevel: undefined,
    newLevel: undefined,
    adjustmentReason: undefined,
    adjustmentBasis: undefined,
    adjustmentTime: undefined,
    operatorName: undefined,
    isAutoAdjustment: undefined,
    delFlag: undefined,
    params: {}
  },
  rules: {
    doctorId: [{ required: true, message: '医师ID不能为空', trigger: 'blur' }],
    qualificationType: [{ required: true, message: '资质类型不能为空', trigger: 'change' }],
    newLevel: [{ required: true, message: '新权限级别不能为空', trigger: 'change' }],
    adjustmentReason: [{ required: true, message: '调整原因不能为空', trigger: 'blur' }],
    adjustmentTime: [{ required: true, message: '调整时间不能为空', trigger: 'blur' }]
  }
});

const { queryParams, form, rules } = toRefs(data);
const searchConfigVisible = ref(false);
const searchConfigManager = createQualificationPermissionAdjustmentSearchConfig();
const visibleSearchFields = computed(() => searchConfigManager.getVisibleFields());
const showFieldConfig = ref(false);
const fieldConfigManager = createQualificationPermissionAdjustmentFieldConfig();
const visibleColumns = computed(() => fieldConfigManager.getVisibleFields());

/** 查询资质权限调整历史列表 */
const getList = async () => {
  loading.value = true;
  const res = await listQualificationPermissionAdjustment(queryParams.value);
  qualificationPermissionAdjustmentList.value = res.rows;
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
  qualificationPermissionAdjustmentFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: QualificationPermissionAdjustmentVO[]) => {
  ids.value = selection.map((item) => (item as any).id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加资质权限调整历史';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: QualificationPermissionAdjustmentVO) => {
  reset();
  const _id = (row as any)?.id || ids.value[0];
  const res = await getQualificationPermissionAdjustment(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改资质权限调整历史';
};

/** 提交按钮 */
const submitForm = () => {
  qualificationPermissionAdjustmentFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateQualificationPermissionAdjustment(form.value).finally(() => (buttonLoading.value = false));
      } else {
        await addQualificationPermissionAdjustment(form.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: QualificationPermissionAdjustmentVO) => {
  const _ids = (row as any)?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除资质权限调整历史编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delQualificationPermissionAdjustment(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导入按钮操作 */
const handleImport = () => {};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/qualificationPermissionAdjustment/export',
    {
      ...queryParams.value
    },
    `qualificationPermissionAdjustment_${new Date().getTime()}.xlsx`
  );
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
