<template>
  <div class="p-2">
    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <div v-show="showSearch" class="mb-[10px]">
        <el-card shadow="hover">
          <el-form ref="queryFormRef" :model="queryParams" :inline="true">
            <el-form-item label="表单编码" prop="formCode">
              <el-input v-model="queryParams.formCode" placeholder="请输入表单编码" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="表单名称" prop="formName">
              <el-input v-model="queryParams.formName" placeholder="请输入表单名称" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="表单描述" prop="formDescription">
              <el-input v-model="queryParams.formDescription" placeholder="请输入表单描述" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="表单配置" prop="formConfig">
              <el-input v-model="queryParams.formConfig" placeholder="请输入表单配置" clearable @keyup.enter="handleQuery" />
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
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['supervision:supervisionForm:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="success" plain icon="Edit" :disabled="single" @click="handleUpdate()" v-hasPermi="['supervision:supervisionForm:edit']"
              >修改</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button type="danger" plain icon="Delete" :disabled="multiple" @click="handleDelete()" v-hasPermi="['supervision:supervisionForm:remove']"
              >删除</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['supervision:supervisionForm:export']">导出</el-button>
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" border :data="supervisionFormList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="主键ID" align="center" prop="id" v-if="false" />
        <el-table-column label="表单编码" align="center" prop="formCode" />
        <el-table-column label="表单名称" align="center" prop="formName" />
        <el-table-column label="表单描述" align="center" prop="formDescription" />
        <el-table-column label="表单配置" align="center" prop="formConfig" />
        <el-table-column label="状态" align="center" prop="status" />
        <el-table-column label="备注" align="center" prop="remark" />
        <el-table-column label="操作" align="center" fixed="right" class-name="small-padding fixed-width">
          <template #default="scope">
            <el-tooltip content="修改" placement="top">
              <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['supervision:supervisionForm:edit']"></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button
                link
                type="primary"
                icon="Delete"
                @click="handleDelete(scope.row)"
                v-hasPermi="['supervision:supervisionForm:remove']"
              ></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改督查单对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="supervisionFormFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="表单编码" prop="formCode">
          <el-input v-model="form.formCode" placeholder="请输入表单编码" />
        </el-form-item>
        <el-form-item label="表单名称" prop="formName">
          <el-input v-model="form.formName" placeholder="请输入表单名称" />
        </el-form-item>
        <el-form-item label="关联项目ID" prop="projectId">
          <el-input v-model="form.projectId" placeholder="请输入关联项目ID" />
        </el-form-item>
        <el-form-item label="表单描述" prop="formDescription">
          <el-input v-model="form.formDescription" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="表单配置" prop="formConfig">
          <el-input v-model="form.formConfig" type="textarea" placeholder="请输入内容" />
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

<script setup name="SupervisionForm" lang="ts">
import { listSupervisionForm, getSupervisionForm, delSupervisionForm, addSupervisionForm, updateSupervisionForm } from '@/api/supervision/supervisionForm';
import { SupervisionFormVO, SupervisionFormQuery, SupervisionFormForm } from '@/api/supervision/supervisionForm/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const supervisionFormList = ref<SupervisionFormVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const supervisionFormFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: SupervisionFormForm = {
  id: undefined,
  formCode: undefined,
  formName: undefined,
  projectId: undefined,
  formDescription: undefined,
  formConfig: undefined,
  status: undefined,
  remark: undefined
};
const data = reactive<PageData<SupervisionFormForm, SupervisionFormQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    formCode: undefined,
    formName: undefined,
    formDescription: undefined,
    formConfig: undefined,
    status: undefined,
    params: {}
  },
  rules: {
    id: [{ required: true, message: '主键ID不能为空', trigger: 'blur' }],
    formCode: [{ required: true, message: '表单编码不能为空', trigger: 'blur' }],
    formName: [{ required: true, message: '表单名称不能为空', trigger: 'blur' }],
    projectId: [{ required: true, message: '关联项目ID不能为空', trigger: 'blur' }]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询督查单列表 */
const getList = async () => {
  loading.value = true;
  const res = await listSupervisionForm(queryParams.value);
  supervisionFormList.value = res.rows;
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
  supervisionFormFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: SupervisionFormVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加督查单';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: SupervisionFormVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getSupervisionForm(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改督查单';
};

/** 提交按钮 */
const submitForm = () => {
  supervisionFormFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateSupervisionForm(form.value).finally(() => (buttonLoading.value = false));
      } else {
        await addSupervisionForm(form.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: SupervisionFormVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除督查单编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delSupervisionForm(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/supervisionForm/export',
    {
      ...queryParams.value
    },
    `supervisionForm_${new Date().getTime()}.xlsx`
  );
};

onMounted(() => {
  getList();
});
</script>
