<template>
  <div class="p-2">
    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <div v-show="showSearch" class="mb-[10px]">
        <el-card shadow="hover">
          <el-form ref="queryFormRef" :model="queryParams" :inline="true">
            <el-form-item label="任务描述" prop="taskDescription">
              <el-input v-model="queryParams.taskDescription" placeholder="请输入任务描述" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="责任部门" prop="responsibleDept">
              <el-input v-model="queryParams.responsibleDept" placeholder="请输入责任部门" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="责任人" prop="responsiblePerson">
              <el-input v-model="queryParams.responsiblePerson" placeholder="请输入责任人" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="截止日期" prop="deadline">
              <el-date-picker clearable v-model="queryParams.deadline" type="date" value-format="YYYY-MM-DD" placeholder="请选择截止日期" />
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
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['supervision:supervisionRectificationTask:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button
              type="success"
              plain
              icon="Edit"
              :disabled="single"
              @click="handleUpdate()"
              v-hasPermi="['supervision:supervisionRectificationTask:edit']"
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
              v-hasPermi="['supervision:supervisionRectificationTask:remove']"
              >删除</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['supervision:supervisionRectificationTask:export']"
              >导出</el-button
            >
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" border :data="supervisionRectificationTaskList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="主键ID" align="center" prop="id" v-if="false" />
        <el-table-column label="任务描述" align="center" prop="taskDescription" />
        <el-table-column label="责任部门" align="center" prop="responsibleDept" />
        <el-table-column label="责任人" align="center" prop="responsiblePerson" />
        <el-table-column label="截止日期" align="center" prop="deadline" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.deadline, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
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
                v-hasPermi="['supervision:supervisionRectificationTask:edit']"
              ></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button
                link
                type="primary"
                icon="Delete"
                @click="handleDelete(scope.row)"
                v-hasPermi="['supervision:supervisionRectificationTask:remove']"
              ></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改整改任务对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="supervisionRectificationTaskFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="问题ID" prop="issueId">
          <el-input v-model="form.issueId" placeholder="请输入问题ID" />
        </el-form-item>
        <el-form-item label="任务描述" prop="taskDescription">
          <el-input v-model="form.taskDescription" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="责任部门" prop="responsibleDept">
          <el-input v-model="form.responsibleDept" placeholder="请输入责任部门" />
        </el-form-item>
        <el-form-item label="责任人" prop="responsiblePerson">
          <el-input v-model="form.responsiblePerson" placeholder="请输入责任人" />
        </el-form-item>
        <el-form-item label="截止日期" prop="deadline">
          <el-date-picker clearable v-model="form.deadline" type="datetime" value-format="YYYY-MM-DD HH:mm:ss" placeholder="请选择截止日期">
          </el-date-picker>
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

<script setup name="SupervisionRectificationTask" lang="ts">
import {
  listSupervisionRectificationTask,
  getSupervisionRectificationTask,
  delSupervisionRectificationTask,
  addSupervisionRectificationTask,
  updateSupervisionRectificationTask
} from '@/api/supervision/supervisionRectificationTask';
import {
  SupervisionRectificationTaskVO,
  SupervisionRectificationTaskQuery,
  SupervisionRectificationTaskForm
} from '@/api/supervision/supervisionRectificationTask/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const supervisionRectificationTaskList = ref<SupervisionRectificationTaskVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const supervisionRectificationTaskFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: SupervisionRectificationTaskForm = {
  id: undefined,
  issueId: undefined,
  taskDescription: undefined,
  responsibleDept: undefined,
  responsiblePerson: undefined,
  deadline: undefined,
  status: undefined,
  remark: undefined
};
const data = reactive<PageData<SupervisionRectificationTaskForm, SupervisionRectificationTaskQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    taskDescription: undefined,
    responsibleDept: undefined,
    responsiblePerson: undefined,
    deadline: undefined,
    status: undefined,
    params: {}
  },
  rules: {
    id: [{ required: true, message: '主键ID不能为空', trigger: 'blur' }],
    issueId: [{ required: true, message: '问题ID不能为空', trigger: 'blur' }],
    taskDescription: [{ required: true, message: '任务描述不能为空', trigger: 'blur' }]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询整改任务列表 */
const getList = async () => {
  loading.value = true;
  const res = await listSupervisionRectificationTask(queryParams.value);
  supervisionRectificationTaskList.value = res.rows;
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
  supervisionRectificationTaskFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: SupervisionRectificationTaskVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加整改任务';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: SupervisionRectificationTaskVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getSupervisionRectificationTask(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改整改任务';
};

/** 提交按钮 */
const submitForm = () => {
  supervisionRectificationTaskFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateSupervisionRectificationTask(form.value).finally(() => (buttonLoading.value = false));
      } else {
        await addSupervisionRectificationTask(form.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: SupervisionRectificationTaskVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除整改任务编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delSupervisionRectificationTask(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/supervisionRectificationTask/export',
    {
      ...queryParams.value
    },
    `supervisionRectificationTask_${new Date().getTime()}.xlsx`
  );
};

onMounted(() => {
  getList();
});
</script>
