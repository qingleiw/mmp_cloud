<template>
  <app-container>
    <page-header title="新技术项目延期申请管理">
      <template #action>
        <el-button type="primary" icon="Plus" @click="handleAdd" v-hasPermi="['ntp:newTechnologyProjectExtension:add']">新增</el-button>
        <el-button
          type="success"
          plain
          icon="Edit"
          :disabled="single"
          @click="handleUpdate()"
          v-hasPermi="['ntp:newTechnologyProjectExtension:edit']"
          >修改</el-button
        >
        <el-button
          type="danger"
          plain
          icon="Delete"
          :disabled="multiple"
          @click="handleDelete()"
          v-hasPermi="['ntp:newTechnologyProjectExtension:remove']"
          >删除</el-button
        >
        <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['ntp:newTechnologyProjectExtension:export']"
          >导出</el-button
        >
      </template>
    </page-header>

    <search-card v-model:show="showSearch" @search="handleQuery" @reset="resetQuery">
      <el-form ref="queryFormRef" :model="queryParams" :inline="true">
        <el-form-item label="申请编号" prop="applyNo">
          <el-input v-model="queryParams.applyNo" placeholder="请输入申请编号" clearable @keyup.enter="handleQuery" />
        </el-form-item>
        <el-form-item label="原结束日期" prop="originalEndDate">
          <el-date-picker clearable v-model="queryParams.originalEndDate" type="date" value-format="YYYY-MM-DD" placeholder="请选择原结束日期" />
        </el-form-item>
        <el-form-item label="延期天数" prop="extendDays">
          <el-input v-model="queryParams.extendDays" placeholder="请输入延期天数" clearable @keyup.enter="handleQuery" />
        </el-form-item>
        <el-form-item label="新结束日期" prop="newEndDate">
          <el-date-picker clearable v-model="queryParams.newEndDate" type="date" value-format="YYYY-MM-DD" placeholder="请选择新结束日期" />
        </el-form-item>
        <el-form-item label="延期理由" prop="extensionReason">
          <el-input v-model="queryParams.extensionReason" placeholder="请输入延期理由" clearable @keyup.enter="handleQuery" />
        </el-form-item>
      </el-form>
    </search-card>

    <table-card v-loading="loading" :data="newTechnologyProjectExtensionList" @selection-change="handleSelectionChange">
      <template #columns>
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="主键ID" align="center" prop="id" v-if="false" />
        <el-table-column label="申请编号" align="center" prop="applyNo" />
        <el-table-column label="原结束日期" align="center" prop="originalEndDate" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.originalEndDate, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="延期天数" align="center" prop="extendDays" />
        <el-table-column label="新结束日期" align="center" prop="newEndDate" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.newEndDate, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="延期理由" align="center" prop="extensionReason" />
        <el-table-column label="申请状态" align="center" prop="applyStatus" />
        <el-table-column label="备注" align="center" prop="remark" />
        <el-table-column label="操作" align="center" fixed="right" class-name="small-padding fixed-width">
          <template #default="scope">
            <el-tooltip content="修改" placement="top">
              <el-button
                link
                type="primary"
                icon="Edit"
                @click="handleUpdate(scope.row)"
                v-hasPermi="['ntp:newTechnologyProjectExtension:edit']"
              ></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button
                link
                type="primary"
                icon="Delete"
                @click="handleDelete(scope.row)"
                v-hasPermi="['ntp:newTechnologyProjectExtension:remove']"
              ></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </template>

      <template #pagination>
        <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
      </template>
    </table-card>

    <!-- 添加或修改新技术延期申请对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="newTechnologyProjectExtensionFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="申请编号" prop="applyNo">
          <el-input v-model="form.applyNo" placeholder="请输入申请编号" />
        </el-form-item>
        <el-form-item label="项目ID" prop="projectId">
          <el-input v-model="form.projectId" placeholder="请输入项目ID" />
        </el-form-item>
        <el-form-item label="原结束日期" prop="originalEndDate">
          <el-date-picker clearable v-model="form.originalEndDate" type="datetime" value-format="YYYY-MM-DD HH:mm:ss" placeholder="请选择原结束日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="延期天数" prop="extendDays">
          <el-input v-model="form.extendDays" placeholder="请输入延期天数" />
        </el-form-item>
        <el-form-item label="新结束日期" prop="newEndDate">
          <el-date-picker clearable v-model="form.newEndDate" type="datetime" value-format="YYYY-MM-DD HH:mm:ss" placeholder="请选择新结束日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="延期理由" prop="extensionReason">
          <el-input v-model="form.extensionReason" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="工作流实例ID" prop="workflowInstanceId">
          <el-input v-model="form.workflowInstanceId" placeholder="请输入工作流实例ID" />
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
  </app-container>
</template>

<script setup name="NewTechnologyProjectExtension" lang="ts">
import {
  listNewTechnologyProjectExtension,
  getNewTechnologyProjectExtension,
  delNewTechnologyProjectExtension,
  addNewTechnologyProjectExtension,
  updateNewTechnologyProjectExtension
} from '@/api/ntp/newTechnologyProjectExtension';
import {
  NewTechnologyProjectExtensionVO,
  NewTechnologyProjectExtensionQuery,
  NewTechnologyProjectExtensionForm
} from '@/api/ntp/newTechnologyProjectExtension/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const newTechnologyProjectExtensionList = ref<NewTechnologyProjectExtensionVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const newTechnologyProjectExtensionFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: NewTechnologyProjectExtensionForm = {
  id: undefined,
  applyNo: undefined,
  projectId: undefined,
  originalEndDate: undefined,
  extendDays: undefined,
  newEndDate: undefined,
  extensionReason: undefined,
  applyStatus: undefined,
  workflowInstanceId: undefined,
  remark: undefined
};
const data = reactive<PageData<NewTechnologyProjectExtensionForm, NewTechnologyProjectExtensionQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    applyNo: undefined,
    originalEndDate: undefined,
    extendDays: undefined,
    newEndDate: undefined,
    extensionReason: undefined,
    applyStatus: undefined,
    params: {}
  },
  rules: {
    id: [{ required: true, message: '主键ID不能为空', trigger: 'blur' }],
    applyNo: [{ required: true, message: '申请编号不能为空', trigger: 'blur' }],
    projectId: [{ required: true, message: '项目ID不能为空', trigger: 'blur' }]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询新技术延期申请列表 */
const getList = async () => {
  loading.value = true;
  const res = await listNewTechnologyProjectExtension(queryParams.value);
  newTechnologyProjectExtensionList.value = res.rows;
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
  newTechnologyProjectExtensionFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: NewTechnologyProjectExtensionVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加新技术延期申请';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: NewTechnologyProjectExtensionVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getNewTechnologyProjectExtension(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改新技术延期申请';
};

/** 提交按钮 */
const submitForm = () => {
  newTechnologyProjectExtensionFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateNewTechnologyProjectExtension(form.value).finally(() => (buttonLoading.value = false));
      } else {
        await addNewTechnologyProjectExtension(form.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: NewTechnologyProjectExtensionVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除新技术延期申请编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delNewTechnologyProjectExtension(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/newTechnologyProjectExtension/export',
    {
      ...queryParams.value
    },
    `newTechnologyProjectExtension_${new Date().getTime()}.xlsx`
  );
};

onMounted(() => {
  getList();
});
</script>
