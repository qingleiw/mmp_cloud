<template>
  <div class="app-container">
    <!-- 页面标题 -->
    <div class="page-header mb-4">
      <h2 class="page-title">
        <i-ep-document class="title-icon"></i-ep-document>
        授权申请管理
      </h2>
      <p class="page-description">管理授权申请和审批</p>
    </div>













    <!-- 动态搜索表单 -->
    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <div v-show="showSearch" class="search-container mb-4" class="search-container mb-4">
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
    
    <!-- 字段配置对话框 -->
    <FieldConfigDialog
      v-model:visible="fieldConfigVisible"
      :config="[]"
      title="列表字段配置"
    />
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
            <span>申请记录列表</span>
            <el-tag type="info" size="small" class="ml-2">{{ total }} 条记录</el-tag>
          </div>
          <div class="table-actions">
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['qualification:qualificationAuthorizationApply:add']" size="small"
              >新增</el-button
            >
            <el-button
              type="success"
              plain
              icon="Edit"
              :disabled="single"
              @click="handleUpdate()"
              v-hasPermi="['qualification:qualificationAuthorizationApply:edit']"
              size="small"
              >修改</el-button
            >
            <el-button
              type="danger"
              plain
              icon="Delete"
              :disabled="multiple"
              @click="handleDelete()"
              v-hasPermi="['qualification:qualificationAuthorizationApply:remove']"
              size="small"
              >删除</el-button
            >
            <el-button
              type="warning"
              plain
              icon="Download"
              @click="handleExport"
              v-hasPermi="['qualification:qualificationAuthorizationApply:export']"
              size="small"
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

      <el-table v-loading="loading" border :data="qualificationAuthorizationApplyList" @selection-change="handleSelectionChange">
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
            <span>{{ scope.row[field.prop] }}</span>
          </template>
        </el-table-column>
        <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
          <template #default="scope">
            <el-button
              link
              size="small"
              icon="Edit"
              @click="handleUpdate(scope.row)"
              v-hasPermi="['qualification:qualificationAuthorizationApply:edit']"
              >修改</el-button
            >
            <el-button
              link
              size="small"
              icon="Delete"
              @click="handleDelete(scope.row)"
              v-hasPermi="['qualification:qualificationAuthorizationApply:remove']"
              >删除</el-button
            >
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改资质授权申请对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="qualificationAuthorizationApplyFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="申请单号" prop="applyNo">
          <el-input v-model="form.applyNo" placeholder="请输入申请单号" />
        </el-form-item>
        <el-form-item label="申请人ID" prop="applicantId">
          <el-input v-model="form.applicantId" placeholder="请输入申请人ID" />
        </el-form-item>
        <el-form-item label="申请人姓名" prop="applicantName">
          <el-input v-model="form.applicantName" placeholder="请输入申请人姓名" />
        </el-form-item>
        <el-form-item label="科室ID" prop="departmentId">
          <el-input v-model="form.departmentId" placeholder="请输入科室ID" />
        </el-form-item>
        <el-form-item label="科室名称" prop="departmentName">
          <el-input v-model="form.departmentName" placeholder="请输入科室名称" />
        </el-form-item>
        <el-form-item label="资质ID列表(逗号分隔)" prop="qualificationIds">
          <el-input v-model="form.qualificationIds" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="申请理由" prop="applyReason">
          <el-input v-model="form.applyReason" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="关联证书ID" prop="certificateIds">
          <el-input v-model="form.certificateIds" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="考核成绩" prop="examScore">
          <el-input v-model="form.examScore" placeholder="请输入考核成绩" />
        </el-form-item>
        <el-form-item label="工作量数据JSON" prop="workQuantity">
          <el-input v-model="form.workQuantity" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="工作质量数据JSON" prop="workQuality">
          <el-input v-model="form.workQuality" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="当前审批节点" prop="currentNode">
          <el-input v-model="form.currentNode" placeholder="请输入当前审批节点" />
        </el-form-item>
        <el-form-item label="工作流实例ID" prop="workflowInstanceId">
          <el-input v-model="form.workflowInstanceId" placeholder="请输入工作流实例ID" />
        </el-form-item>
        <el-form-item label="是否删除" prop="delFlag">
          <el-input v-model="form.delFlag" placeholder="请输入是否删除" />
        </el-form-item>
      </el-form>
      <template #footer>
        <div class="dialog-footer">
          <el-button :loading="buttonLoading" type="primary" @click="submitForm">确 定</el-button>
          <el-button @click="cancel">取 消</el-button>
        </div>
      </template>
    </el-dialog><SearchConfigDialog v-model:visible="searchConfigVisible" :search-config-manager="searchConfigManager" @confirm="handleSearchConfigConfirm" />
  </div>
</template>

<script setup name="QualificationAuthorizationApply" lang="ts">
import {
  listQualificationAuthorizationApply,
  getQualificationAuthorizationApply,
  delQualificationAuthorizationApply,
  addQualificationAuthorizationApply,
  updateQualificationAuthorizationApply
} from '@/api/qualification/qualificationAuthorizationApply';
import {
  QualificationAuthorizationApplyVO,
  QualificationAuthorizationApplyQuery,
  QualificationAuthorizationApplyForm
} from '@/api/qualification/qualificationAuthorizationApply/types';
import { createQualificationAuthorizationApplyFieldConfig } from '@/utils/configs/qualification/qualificationFieldConfigs';
import { FieldConfigManager } from '@/utils/configs/fieldConfigManager';
import FieldConfigDialog from '@/components/FieldConfigDialog.vue';
import DynamicSearchForm from '@/components/DynamicSearchForm.vue';
import SearchConfigDialog from '@/components/SearchConfigDialog.vue';
import { createQualificationAuthorizationApplySearchConfig } from '@/utils/configs/qualification/qualificationSearchConfigs';
import type { FormInstance } from 'element-plus';
import type { DialogOption, PageData } from '@/types/global';
import type { ComponentInternalInstance } from 'vue';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const qualificationAuthorizationApplyList = ref<QualificationAuthorizationApplyVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<FormInstance>();
const qualificationAuthorizationApplyFormRef = ref<FormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

// 字段配置相关变量
const fieldConfigManager = createQualificationAuthorizationApplyFieldConfig();
const fieldConfigVisible = ref(false);
const searchConfigManager = createQualificationAuthorizationApplySearchConfig();
const searchConfigVisible = ref(false);
const visibleSearchFields = computed(() => searchConfigManager.getVisibleFields());

const initFormData: QualificationAuthorizationApplyForm = {
  id: undefined,
  applyNo: undefined,
  applicantId: undefined,
  applicantName: undefined,
  applicantType: undefined,
  departmentId: undefined,
  departmentName: undefined,
  qualificationIds: undefined,
  applyReason: undefined,
  certificateIds: undefined,
  examScore: undefined,
  workQuantity: undefined,
  workQuality: undefined,
  applyStatus: undefined,
  currentNode: undefined,
  workflowInstanceId: undefined,
  delFlag: undefined
};
const data = reactive<PageData<QualificationAuthorizationApplyForm, QualificationAuthorizationApplyQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    applyNo: undefined,
    applicantId: undefined,
    applicantName: undefined,
    applicantType: undefined,
    departmentId: undefined,
    departmentName: undefined,
    qualificationIds: undefined,
    applyReason: undefined,
    certificateIds: undefined,
    examScore: undefined,
    workQuantity: undefined,
    workQuality: undefined,
    applyStatus: undefined,
    currentNode: undefined,
    workflowInstanceId: undefined,
    delFlag: undefined,
    params: {}
  },
  rules: {
    id: [{ required: true, message: '主键ID不能为空', trigger: 'blur' }],
    applyNo: [{ required: true, message: '申请单号不能为空', trigger: 'blur' }],
    applicantId: [{ required: true, message: '申请人ID不能为空', trigger: 'blur' }]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询资质授权申请列表 */
const getList = async () => {
  loading.value = true;
  const res = await listQualificationAuthorizationApply(queryParams.value);
  qualificationAuthorizationApplyList.value = res.rows;
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
  qualificationAuthorizationApplyFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: QualificationAuthorizationApplyVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加资质授权申请';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: QualificationAuthorizationApplyVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getQualificationAuthorizationApply(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改资质授权申请';
};

/** 提交按钮 */
const submitForm = () => {
  qualificationAuthorizationApplyFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateQualificationAuthorizationApply(form.value).finally(() => (buttonLoading.value = false));
      } else {
        await addQualificationAuthorizationApply(form.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: QualificationAuthorizationApplyVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除资质授权申请编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delQualificationAuthorizationApply(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/qualificationAuthorizationApply/export',
    {
      ...queryParams.value
    },
    `qualificationAuthorizationApply_${new Date().getTime()}.xlsx`
  );
};

/** 字段配置按钮操作 */
const handleFieldConfig = () => {
  fieldConfigVisible.value = true;
};

/** 字段配置确认 */
const handleFieldConfigConfirm = () => {
  fieldConfigVisible.value = false;
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
.app-container {
  padding: 20px;
  background-color: #f5f5f5;
  min-height: calc(100vh - 84px);
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
}

.search-container {
  .search-card {
    border-radius: 8px;
    box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);

    .search-header {
      display: flex;
      justify-content: space-between;
      align-items: center;

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

// 响应式设计
@media (max-width: 768px) {
  .app-container {
    padding: 12px;
  }

  .page-header {
    .page-title {
      font-size: 16px;
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