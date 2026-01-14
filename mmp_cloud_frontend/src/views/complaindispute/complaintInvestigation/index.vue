<template>
  <div class="app-container">
    <!-- 页面头部 -->
    <div class="page-header">
      <h1>投诉调查管理</h1>
      <p>管理系统中的投诉调查记录，包括调查内容、结果和附件等功能</p>
      <div class="flex gap-2">
        <el-button type="primary" icon="i-ep:Plus" @click="handleAdd" v-hasPermi="['system:complaintInvestigation:add']">新增</el-button>
        <el-button type="success" icon="i-ep:Edit" :disabled="single" @click="handleUpdate()" v-hasPermi="['system:complaintInvestigation:edit']"
          >修改</el-button
        >
        <el-button type="danger" icon="i-ep:Delete" :disabled="multiple" @click="handleDelete()" v-hasPermi="['system:complaintInvestigation:remove']"
          >删除</el-button
        >
        <el-button type="warning" icon="i-ep:Download" @click="handleExport" v-hasPermi="['system:complaintInvestigation:export']">导出</el-button>
        <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
      </div>
    </div>

    <!-- 搜索区域 -->
    <div class="search-card" v-show="showSearch">
      <el-form ref="queryFormRef" :model="queryParams" :inline="true">
        <el-form-item label="调查人姓名" prop="investigatorName">
          <el-input v-model="queryParams.investigatorName" placeholder="请输入调查人姓名" clearable @keyup.enter="handleQuery" />
        </el-form-item>
        <el-form-item label="调查结果" prop="investigationResult">
          <el-input v-model="queryParams.investigationResult" placeholder="请输入调查结果" clearable @keyup.enter="handleQuery" />
        </el-form-item>
        <el-form-item label="调查时间" prop="investigationTime">
          <el-date-picker clearable v-model="queryParams.investigationTime" type="date" value-format="YYYY-MM-DD" placeholder="请选择调查时间" />
        </el-form-item>
        <el-form-item label="附件" prop="attachments">
          <el-input v-model="queryParams.attachments" placeholder="请输入附件" clearable @keyup.enter="handleQuery" />
        </el-form-item>
        <el-form-item label="删除标志" prop="delFlag">
          <el-select v-model="queryParams.delFlag" placeholder="请选择删除标志" clearable style="width: 120px">
            <el-option label="正常" value="0" />
            <el-option label="已删除" value="1" />
          </el-select>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" icon="i-ep:Search" @click="handleQuery">搜索</el-button>
          <el-button icon="i-ep:Refresh" @click="resetQuery">重置</el-button>
        </el-form-item>
      </el-form>
    </div>

    <!-- 表格区域 -->
    <div class="table-card">
      <el-table v-loading="loading" border :data="complaintInvestigationList" @selection-change="handleSelectionChange" class="modern-table">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="主键ID" align="center" prop="id" v-if="false" />
        <el-table-column label="租户编号" align="center" prop="tenantId" />
        <el-table-column label="投诉ID" align="center" prop="complaintId" />
        <el-table-column label="调查人ID" align="center" prop="investigatorId" />
        <el-table-column label="调查人姓名" align="center" prop="investigatorName" />
        <el-table-column label="调查内容" align="center" prop="investigationContent" />
        <el-table-column label="调查结果" align="center" prop="investigationResult" />
        <el-table-column label="调查时间" align="center" prop="investigationTime" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.investigationTime, '{y}-{m}-{d} {h}:{i}:{s}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="附件" align="center" prop="attachments" />
        <el-table-column label="是否删除" align="center" prop="delFlag" />
        <el-table-column label="创建时间" align="center" prop="createTime" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.createTime, '{y}-{m}-{d} {h}:{i}:{s}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="创建人" align="center" prop="createBy" />
        <el-table-column label="创建部门" align="center" prop="createDept" />
        <el-table-column label="更新时间" align="center" prop="updateTime" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.updateTime, '{y}-{m}-{d} {h}:{i}:{s}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="更新人" align="center" prop="updateBy" />
        <el-table-column label="备注" align="center" prop="remark" />
        <el-table-column label="操作" align="center" fixed="right" class-name="small-padding fixed-width" width="120">
          <template #default="scope">
            <div class="flex items-center justify-center space-x-1">
              <el-tooltip content="修改" placement="top">
                <el-button
                  link
                  type="primary"
                  icon="i-ep:Edit"
                  @click="handleUpdate(scope.row)"
                  v-hasPermi="['system:complaintInvestigation:edit']"
                  size="small"
                ></el-button>
              </el-tooltip>
              <el-tooltip content="删除" placement="top">
                <el-button
                  link
                  type="danger"
                  icon="i-ep:Delete"
                  @click="handleDelete(scope.row)"
                  v-hasPermi="['system:complaintInvestigation:remove']"
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

    <el-table v-loading="loading" border :data="complaintInvestigationList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="主键ID" align="center" prop="id" v-if="false" />
      <el-table-column label="调查人姓名" align="center" prop="investigatorName" />
      <el-table-column label="调查内容" align="center" prop="investigationContent" />
      <el-table-column label="调查结果" align="center" prop="investigationResult" />
      <el-table-column label="调查时间" align="center" prop="investigationTime" width="180">
        <template #default="scope">
          <span>{{ parseTime(scope.row.investigationTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="附件" align="center" prop="attachments" />
      <el-table-column label="删除标志" align="center" prop="delFlag" />
      <el-table-column label="操作" align="center" fixed="right" class-name="small-padding fixed-width">
        <template #default="scope">
          <el-tooltip content="修改" placement="top">
            <el-button
              link
              type="primary"
              icon="i-ep:Edit"
              @click="handleUpdate(scope.row)"
              v-hasPermi="['system:complaintInvestigation:edit']"
            ></el-button>
          </el-tooltip>
          <el-tooltip content="删除" placement="top">
            <el-button
              link
              type="primary"
              icon="i-ep:Delete"
              @click="handleDelete(scope.row)"
              v-hasPermi="['system:complaintInvestigation:remove']"
            ></el-button>
          </el-tooltip>
        </template>
      </el-table-column>
    </el-table>

    <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    <!-- 添加或修改投诉调查记录对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="700px" append-to-body>
      <el-form ref="complaintInvestigationFormRef" :model="form" :rules="rules" label-width="120px">
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="投诉ID" prop="complaintId">
              <el-input v-model="form.complaintId" placeholder="请输入投诉ID" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="调查人ID" prop="investigatorId">
              <el-input v-model="form.investigatorId" placeholder="请输入调查人ID" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="调查人姓名" prop="investigatorName">
              <el-input v-model="form.investigatorName" placeholder="请输入调查人姓名" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="调查时间" prop="investigationTime">
              <el-date-picker
                clearable
                v-model="form.investigationTime"
                type="datetime"
                value-format="YYYY-MM-DD HH:mm:ss"
                placeholder="请选择调查时间"
                style="width: 100%"
              >
              </el-date-picker>
            </el-form-item>
          </el-col>
        </el-row>
        <el-form-item label="调查内容">
          <editor v-model="form.investigationContent" :min-height="192" />
        </el-form-item>
        <el-form-item label="调查结果" prop="investigationResult">
          <el-input v-model="form.investigationResult" type="textarea" :rows="3" placeholder="请输入调查结果" />
        </el-form-item>
        <el-form-item label="附件" prop="attachments">
          <el-input v-model="form.attachments" type="textarea" :rows="3" placeholder="请输入附件" />
        </el-form-item>
        <el-row :gutter="20">
          <el-col :span="24">
            <el-form-item label="删除标志" prop="delFlag">
              <el-select v-model="form.delFlag" placeholder="请选择删除标志" style="width: 200px">
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
  </div>
</template>

<script setup name="ComplaintInvestigation" lang="ts">
import {
  listComplaintInvestigation,
  getComplaintInvestigation,
  delComplaintInvestigation,
  addComplaintInvestigation,
  updateComplaintInvestigation
} from '@/api/complaindispute/complaintInvestigation';
import { ComplaintInvestigationVO, ComplaintInvestigationQuery, ComplaintInvestigationForm } from '@/api/complaindispute/complaintInvestigation/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const complaintInvestigationList = ref<ComplaintInvestigationVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const complaintInvestigationFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: ComplaintInvestigationForm = {
  id: undefined,
  complaintId: undefined,
  investigatorId: undefined,
  investigatorName: undefined,
  investigationContent: undefined,
  investigationResult: undefined,
  investigationTime: undefined,
  attachments: undefined,
  delFlag: undefined
};
const data = reactive<PageData<ComplaintInvestigationForm, ComplaintInvestigationQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    investigatorName: undefined,
    investigationContent: undefined,
    investigationResult: undefined,
    investigationTime: undefined,
    attachments: undefined,
    delFlag: undefined,
    params: {}
  },
  rules: {
    complaintId: [{ required: true, message: '投诉ID不能为空', trigger: 'blur' }],
    investigatorId: [{ required: true, message: '调查人ID不能为空', trigger: 'blur' }],
    investigatorName: [{ required: true, message: '调查人姓名不能为空', trigger: 'blur' }],
    investigationContent: [{ required: true, message: '调查内容不能为空', trigger: 'blur' }],
    investigationTime: [{ required: true, message: '调查时间不能为空', trigger: 'blur' }]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询投诉调查记录列表 */
const getList = async () => {
  loading.value = true;
  const res = await listComplaintInvestigation(queryParams.value);
  complaintInvestigationList.value = res.rows;
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
  complaintInvestigationFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: ComplaintInvestigationVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加投诉调查记录';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: ComplaintInvestigationVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getComplaintInvestigation(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改投诉调查记录';
};

/** 提交按钮 */
const submitForm = () => {
  complaintInvestigationFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateComplaintInvestigation(form.value).finally(() => (buttonLoading.value = false));
      } else {
        await addComplaintInvestigation(form.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: ComplaintInvestigationVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除投诉调查记录编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delComplaintInvestigation(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/complaintInvestigation/export',
    {
      ...queryParams.value
    },
    `complaintInvestigation_${new Date().getTime()}.xlsx`
  );
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
