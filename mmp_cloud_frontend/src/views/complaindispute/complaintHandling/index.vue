<template>
  <div class="app-container">
    <!-- 页面头部 -->
    <div class="page-header">
      <h1>投诉处理管理</h1>
      <p>管理系统中的投诉处理记录，包括处理措施、结果和反馈等功能</p>
    </div>

    <!-- 搜索区域 -->
    <div class="search-card" v-show="showSearch">
      <el-form ref="queryFormRef" :model="queryParams" :inline="true">
        <el-form-item label="处理人姓名" prop="handlerName">
          <el-input v-model="queryParams.handlerName" placeholder="请输入处理人姓名" clearable @keyup.enter="handleQuery" />
        </el-form-item>
        <el-form-item label="处理措施" prop="handlingMeasure">
          <el-input v-model="queryParams.handlingMeasure" placeholder="请输入处理措施" clearable @keyup.enter="handleQuery" />
        </el-form-item>
        <el-form-item label="处理结果" prop="handlingResult">
          <el-input v-model="queryParams.handlingResult" placeholder="请输入处理结果" clearable @keyup.enter="handleQuery" />
        </el-form-item>
        <el-form-item label="处理时间" prop="handlingTime">
          <el-date-picker clearable v-model="queryParams.handlingTime" type="date" value-format="YYYY-MM-DD" placeholder="请选择处理时间" />
        </el-form-item>
        <el-form-item label="反馈时间" prop="feedbackTime">
          <el-date-picker clearable v-model="queryParams.feedbackTime" type="date" value-format="YYYY-MM-DD" placeholder="请选择反馈时间" />
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
    <el-card shadow="never" class="table-card">
      <template #header>
        <div class="table-header">
          <div class="table-title">
            <i-ep-list class="table-icon"></i-ep-list>
            <span>项目列表</span>
            <el-tag type="info" size="small" class="ml-2">{{ total }} 条记录</el-tag>
          </div>
          <div class="table-actions">
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['system:newTechnologyProject:add']" size="small"
              >新增</el-button
            >
            <el-button
              type="success"
              plain
              icon="Edit"
              :disabled="single"
              @click="handleUpdate()"
              v-hasPermi="['system:newTechnologyProject:edit']"
              size="small"
              >修改</el-button
            >
            <el-button
              type="danger"
              plain
              icon="Delete"
              :disabled="multiple"
              @click="handleDelete()"
              v-hasPermi="['system:newTechnologyProject:remove']"
              size="small"
              >删除</el-button
            >
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['system:newTechnologyProject:export']" size="small"
              >导出</el-button
            >
            <el-button type="primary" plain icon="Upload" @click="handleImport" v-hasPermi="['system:newTechnologyProject:import']" size="small"
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
      <el-table v-loading="loading" border :data="complaintHandlingList" @selection-change="handleSelectionChange" class="modern-table">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="主键ID" align="center" prop="id" v-if="false" />
        <el-table-column label="租户编号" align="center" prop="tenantId" />
        <el-table-column label="投诉ID" align="center" prop="complaintId" />
        <el-table-column label="处理人ID" align="center" prop="handlerId" />
        <el-table-column label="处理人姓名" align="center" prop="handlerName" />
        <el-table-column label="处理措施" align="center" prop="handlingMeasure" />
        <el-table-column label="处理结果" align="center" prop="handlingResult" />
        <el-table-column label="处理时间" align="center" prop="handlingTime" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.handlingTime, '{y}-{m}-{d} {h}:{i}:{s}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="反馈内容" align="center" prop="feedbackContent" />
        <el-table-column label="反馈时间" align="center" prop="feedbackTime" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.feedbackTime, '{y}-{m}-{d} {h}:{i}:{s}') }}</span>
          </template>
        </el-table-column>
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
                  v-hasPermi="['system:complaintHandling:edit']"
                  size="small"
                ></el-button>
              </el-tooltip>
              <el-tooltip content="删除" placement="top">
                <el-button
                  link
                  type="danger"
                  icon="i-ep:Delete"
                  @click="handleDelete(scope.row)"
                  v-hasPermi="['system:complaintHandling:remove']"
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
    </el-card>
    <!-- 添加或修改投诉处理记录对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="700px" append-to-body>
      <el-form ref="complaintHandlingFormRef" :model="form" :rules="rules" label-width="120px">
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="投诉ID" prop="complaintId">
              <el-input v-model="form.complaintId" placeholder="请输入投诉ID" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="处理人ID" prop="handlerId">
              <el-input v-model="form.handlerId" placeholder="请输入处理人ID" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="处理人姓名" prop="handlerName">
              <el-input v-model="form.handlerName" placeholder="请输入处理人姓名" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="处理时间" prop="handlingTime">
              <el-date-picker
                clearable
                v-model="form.handlingTime"
                type="datetime"
                value-format="YYYY-MM-DD HH:mm:ss"
                placeholder="请选择处理时间"
                style="width: 100%"
              >
              </el-date-picker>
            </el-form-item>
          </el-col>
        </el-row>
        <el-form-item label="处理措施" prop="handlingMeasure">
          <el-input v-model="form.handlingMeasure" type="textarea" :rows="3" placeholder="请输入处理措施" />
        </el-form-item>
        <el-form-item label="处理结果" prop="handlingResult">
          <el-input v-model="form.handlingResult" type="textarea" :rows="3" placeholder="请输入处理结果" />
        </el-form-item>
        <el-form-item label="反馈内容">
          <editor v-model="form.feedbackContent" :min-height="192" />
        </el-form-item>
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="反馈时间" prop="feedbackTime">
              <el-date-picker
                clearable
                v-model="form.feedbackTime"
                type="datetime"
                value-format="YYYY-MM-DD HH:mm:ss"
                placeholder="请选择反馈时间"
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

<script setup name="ComplaintHandling" lang="ts">
import {
  listComplaintHandling,
  getComplaintHandling,
  delComplaintHandling,
  addComplaintHandling,
  updateComplaintHandling
} from '@/api/complaindispute/complaintHandling';
import { ComplaintHandlingVO, ComplaintHandlingQuery, ComplaintHandlingForm } from '@/api/complaindispute/complaintHandling/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const complaintHandlingList = ref<ComplaintHandlingVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);
const showFieldConfig = ref(false);

const queryFormRef = ref<ElFormInstance>();
const complaintHandlingFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: ComplaintHandlingForm = {
  id: undefined,
  complaintId: undefined,
  handlerId: undefined,
  handlerName: undefined,
  handlingMeasure: undefined,
  handlingResult: undefined,
  handlingTime: undefined,
  feedbackContent: undefined,
  feedbackTime: undefined,
  delFlag: undefined
};
const data = reactive<PageData<ComplaintHandlingForm, ComplaintHandlingQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    handlerName: undefined,
    handlingMeasure: undefined,
    handlingResult: undefined,
    handlingTime: undefined,
    feedbackContent: undefined,
    feedbackTime: undefined,
    delFlag: undefined,
    params: {}
  },
  rules: {
    complaintId: [{ required: true, message: '投诉ID不能为空', trigger: 'blur' }],
    handlerId: [{ required: true, message: '处理人ID不能为空', trigger: 'blur' }],
    handlerName: [{ required: true, message: '处理人姓名不能为空', trigger: 'blur' }],
    handlingMeasure: [{ required: true, message: '处理措施不能为空', trigger: 'blur' }],
    handlingTime: [{ required: true, message: '处理时间不能为空', trigger: 'blur' }]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询投诉处理记录列表 */
const getList = async () => {
  loading.value = true;
  const res = await listComplaintHandling(queryParams.value);
  complaintHandlingList.value = res.rows;
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
  complaintHandlingFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: ComplaintHandlingVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加投诉处理记录';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: ComplaintHandlingVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getComplaintHandling(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改投诉处理记录';
};

/** 提交按钮 */
const submitForm = () => {
  complaintHandlingFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateComplaintHandling(form.value).finally(() => (buttonLoading.value = false));
      } else {
        await addComplaintHandling(form.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: ComplaintHandlingVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除投诉处理记录编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delComplaintHandling(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/complaintHandling/export',
    {
      ...queryParams.value
    },
    `complaintHandling_${new Date().getTime()}.xlsx`
  );
};

/** 导入按钮操作 */
const handleImport = () => {
  // TODO: 实现导入功能
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
