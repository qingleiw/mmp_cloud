<template>
  <div class="p-2">
    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <div v-show="showSearch" class="mb-[10px]">
        <el-card shadow="hover">
          <el-form ref="queryFormRef" :model="queryParams" :inline="true">
            <el-form-item label="字段编码" prop="fieldCode">
              <el-input v-model="queryParams.fieldCode" placeholder="请输入字段编码" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="字段名称" prop="fieldName">
              <el-input v-model="queryParams.fieldName" placeholder="请输入字段名称" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="字段配置" prop="fieldConfig">
              <el-input v-model="queryParams.fieldConfig" placeholder="请输入字段配置" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="是否必填：0-否，1-是" prop="requiredFlag">
              <el-input v-model="queryParams.requiredFlag" placeholder="请输入是否必填：0-否，1-是" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="排序" prop="sortOrder">
              <el-input v-model="queryParams.sortOrder" placeholder="请输入排序" clearable @keyup.enter="handleQuery" />
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
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['supervision:supervisionFormField:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button
              type="success"
              plain
              icon="Edit"
              :disabled="single"
              @click="handleUpdate()"
              v-hasPermi="['supervision:supervisionFormField:edit']"
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
              v-hasPermi="['supervision:supervisionFormField:remove']"
              >删除</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['supervision:supervisionFormField:export']"
              >导出</el-button
            >
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" border :data="supervisionFormFieldList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="主键ID" align="center" prop="id" v-if="false" />
        <el-table-column label="字段编码" align="center" prop="fieldCode" />
        <el-table-column label="字段名称" align="center" prop="fieldName" />
        <el-table-column label="字段类型" align="center" prop="fieldType" />
        <el-table-column label="字段配置" align="center" prop="fieldConfig" />
        <el-table-column label="是否必填：0-否，1-是" align="center" prop="requiredFlag" />
        <el-table-column label="排序" align="center" prop="sortOrder" />
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
                v-hasPermi="['supervision:supervisionFormField:edit']"
              ></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button
                link
                type="primary"
                icon="Delete"
                @click="handleDelete(scope.row)"
                v-hasPermi="['supervision:supervisionFormField:remove']"
              ></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改督查单字段对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="supervisionFormFieldFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="表单ID" prop="formId">
          <el-input v-model="form.formId" placeholder="请输入表单ID" />
        </el-form-item>
        <el-form-item label="字段编码" prop="fieldCode">
          <el-input v-model="form.fieldCode" placeholder="请输入字段编码" />
        </el-form-item>
        <el-form-item label="字段名称" prop="fieldName">
          <el-input v-model="form.fieldName" placeholder="请输入字段名称" />
        </el-form-item>
        <el-form-item label="字段配置" prop="fieldConfig">
          <el-input v-model="form.fieldConfig" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="是否必填：0-否，1-是" prop="requiredFlag">
          <el-input v-model="form.requiredFlag" placeholder="请输入是否必填：0-否，1-是" />
        </el-form-item>
        <el-form-item label="排序" prop="sortOrder">
          <el-input v-model="form.sortOrder" placeholder="请输入排序" />
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

<script setup name="SupervisionFormField" lang="ts">
import {
  listSupervisionFormField,
  getSupervisionFormField,
  delSupervisionFormField,
  addSupervisionFormField,
  updateSupervisionFormField
} from '@/api/supervision/supervisionFormField';
import { SupervisionFormFieldVO, SupervisionFormFieldQuery, SupervisionFormFieldForm } from '@/api/supervision/supervisionFormField/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const supervisionFormFieldList = ref<SupervisionFormFieldVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const supervisionFormFieldFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: SupervisionFormFieldForm = {
  id: undefined,
  formId: undefined,
  fieldCode: undefined,
  fieldName: undefined,
  fieldType: undefined,
  fieldConfig: undefined,
  requiredFlag: undefined,
  sortOrder: undefined,
  status: undefined,
  remark: undefined
};
const data = reactive<PageData<SupervisionFormFieldForm, SupervisionFormFieldQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    fieldCode: undefined,
    fieldName: undefined,
    fieldType: undefined,
    fieldConfig: undefined,
    requiredFlag: undefined,
    sortOrder: undefined,
    status: undefined,
    params: {}
  },
  rules: {
    id: [{ required: true, message: '主键ID不能为空', trigger: 'blur' }],
    formId: [{ required: true, message: '表单ID不能为空', trigger: 'blur' }],
    fieldCode: [{ required: true, message: '字段编码不能为空', trigger: 'blur' }],
    fieldName: [{ required: true, message: '字段名称不能为空', trigger: 'blur' }],
    fieldType: [{ required: true, message: '字段类型不能为空', trigger: 'change' }]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询督查单字段列表 */
const getList = async () => {
  loading.value = true;
  const res = await listSupervisionFormField(queryParams.value);
  supervisionFormFieldList.value = res.rows;
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
  supervisionFormFieldFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: SupervisionFormFieldVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加督查单字段';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: SupervisionFormFieldVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getSupervisionFormField(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改督查单字段';
};

/** 提交按钮 */
const submitForm = () => {
  supervisionFormFieldFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateSupervisionFormField(form.value).finally(() => (buttonLoading.value = false));
      } else {
        await addSupervisionFormField(form.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: SupervisionFormFieldVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除督查单字段编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delSupervisionFormField(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/supervisionFormField/export',
    {
      ...queryParams.value
    },
    `supervisionFormField_${new Date().getTime()}.xlsx`
  );
};

onMounted(() => {
  getList();
});
</script>
