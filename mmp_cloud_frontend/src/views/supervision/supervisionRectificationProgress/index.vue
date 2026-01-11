<template>
  <div class="p-2">
    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <div v-show="showSearch" class="mb-[10px]">
        <el-card shadow="hover">
          <el-form ref="queryFormRef" :model="queryParams" :inline="true">
            <el-form-item label="进度描述" prop="progressDescription">
              <el-input v-model="queryParams.progressDescription" placeholder="请输入进度描述" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="进度百分比" prop="progressPercentage">
              <el-input v-model="queryParams.progressPercentage" placeholder="请输入进度百分比" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="附件URL" prop="attachmentUrls">
              <el-input v-model="queryParams.attachmentUrls" placeholder="请输入附件URL" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item>
              <el-button type="primary" icon="Search" @click="handleQuery">搜索</el-button>
              <el-button icon="Refresh" @click="resetQuery">重置</el-button>
            </el-form-item>
          </el-form>
        </el-card>
      </div>
    </transition>

    <el-card shadow="never">
      <template #header>
        <el-row :gutter="10" class="mb8">
          <el-col :span="1.5">
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['system:supervisionRectificationProgress:add']"
              >新增</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button
              type="success"
              plain
              icon="Edit"
              :disabled="single"
              @click="handleUpdate()"
              v-hasPermi="['system:supervisionRectificationProgress:edit']"
              >修改</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button
              type="danger"
              plain
              icon="Delete"
              :disabled="multiple"
              @click="handleDelete()"
              v-hasPermi="['system:supervisionRectificationProgress:remove']"
              >删除</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['system:supervisionRectificationProgress:export']"
              >导出</el-button
            >
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" border :data="supervisionRectificationProgressList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="主键ID" align="center" prop="id" v-if="false" />
        <el-table-column label="进度描述" align="center" prop="progressDescription" />
        <el-table-column label="进度百分比" align="center" prop="progressPercentage" />
        <el-table-column label="附件URL" align="center" prop="attachmentUrls" />
        <el-table-column label="状态" align="center" prop="status" />
        <el-table-column label="备注" align="center" prop="remark" />
        <el-table-column label="操作" align="center" fixed="right" class-name="small-padding fixed-width">
          <template #default="scope">
            <el-tooltip content="修改" placement="top">
              <el-button
                link
                type="primary"
                icon="Edit"
                @click="handleUpdate(scope.row)"
                v-hasPermi="['system:supervisionRectificationProgress:edit']"
              ></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button
                link
                type="primary"
                icon="Delete"
                @click="handleDelete(scope.row)"
                v-hasPermi="['system:supervisionRectificationProgress:remove']"
              ></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改整改进度对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="supervisionRectificationProgressFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="任务ID" prop="taskId">
          <el-input v-model="form.taskId" placeholder="请输入任务ID" />
        </el-form-item>
        <el-form-item label="进度描述" prop="progressDescription">
          <el-input v-model="form.progressDescription" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="进度百分比" prop="progressPercentage">
          <el-input v-model="form.progressPercentage" placeholder="请输入进度百分比" />
        </el-form-item>
        <el-form-item label="附件URL" prop="attachmentUrls">
          <el-input v-model="form.attachmentUrls" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" type="textarea" placeholder="请输入内容" />
        </el-form-item>
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

<script setup name="SupervisionRectificationProgress" lang="ts">
import {
  listSupervisionRectificationProgress,
  getSupervisionRectificationProgress,
  delSupervisionRectificationProgress,
  addSupervisionRectificationProgress,
  updateSupervisionRectificationProgress
} from '@/api/system/supervisionRectificationProgress';
import {
  SupervisionRectificationProgressVO,
  SupervisionRectificationProgressQuery,
  SupervisionRectificationProgressForm
} from '@/api/system/supervisionRectificationProgress/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const supervisionRectificationProgressList = ref<SupervisionRectificationProgressVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const supervisionRectificationProgressFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: SupervisionRectificationProgressForm = {
  id: undefined,
  taskId: undefined,
  progressDescription: undefined,
  progressPercentage: undefined,
  attachmentUrls: undefined,
  status: undefined,
  remark: undefined
};
const data = reactive<PageData<SupervisionRectificationProgressForm, SupervisionRectificationProgressQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    progressDescription: undefined,
    progressPercentage: undefined,
    attachmentUrls: undefined,
    status: undefined,
    params: {}
  },
  rules: {
    id: [{ required: true, message: '主键ID不能为空', trigger: 'blur' }],
    taskId: [{ required: true, message: '任务ID不能为空', trigger: 'blur' }]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询整改进度列表 */
const getList = async () => {
  loading.value = true;
  const res = await listSupervisionRectificationProgress(queryParams.value);
  supervisionRectificationProgressList.value = res.rows;
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
  supervisionRectificationProgressFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: SupervisionRectificationProgressVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加整改进度';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: SupervisionRectificationProgressVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getSupervisionRectificationProgress(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改整改进度';
};

/** 提交按钮 */
const submitForm = () => {
  supervisionRectificationProgressFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateSupervisionRectificationProgress(form.value).finally(() => (buttonLoading.value = false));
      } else {
        await addSupervisionRectificationProgress(form.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: SupervisionRectificationProgressVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除整改进度编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delSupervisionRectificationProgress(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/supervisionRectificationProgress/export',
    {
      ...queryParams.value
    },
    `supervisionRectificationProgress_${new Date().getTime()}.xlsx`
  );
};

onMounted(() => {
  getList();
});
</script>
