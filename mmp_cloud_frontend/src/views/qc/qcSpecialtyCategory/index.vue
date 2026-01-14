<template>
  <div class="p-2">
    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <div v-show="showSearch" class="mb-[10px]">
        <el-card shadow="hover">
          <el-form ref="queryFormRef" :model="queryParams" :inline="true">
            <el-form-item label="专业代码" prop="categoryCode">
              <el-input v-model="queryParams.categoryCode" placeholder="请输入专业代码" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="专业名称" prop="categoryName">
              <el-input v-model="queryParams.categoryName" placeholder="请输入专业名称" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="发布年份" prop="publishYear">
              <el-input v-model="queryParams.publishYear" placeholder="请输入发布年份" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="排序" prop="sortOrder">
              <el-input v-model="queryParams.sortOrder" placeholder="请输入排序" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="是否删除" prop="delFlag">
              <el-input v-model="queryParams.delFlag" placeholder="请输入是否删除" clearable @keyup.enter="handleQuery" />
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
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['qc:qcSpecialtyCategory:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="success" plain icon="Edit" :disabled="single" @click="handleUpdate()" v-hasPermi="['qc:qcSpecialtyCategory:edit']"
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
              v-hasPermi="['qc:qcSpecialtyCategory:remove']"
              >删除</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['qc:qcSpecialtyCategory:export']">导出</el-button>
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" border :data="qcSpecialtyCategoryList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="主键ID" align="center" prop="id" v-if="false" />
        <el-table-column label="专业代码" align="center" prop="categoryCode" />
        <el-table-column label="专业名称" align="center" prop="categoryName" />
        <el-table-column label="发布年份" align="center" prop="publishYear" />
        <el-table-column label="排序" align="center" prop="sortOrder" />
        <el-table-column label="状态：1-启用，0-禁用" align="center" prop="status" />
        <el-table-column label="是否删除" align="center" prop="delFlag" />
        <el-table-column label="操作" align="center" fixed="right" class-name="small-padding fixed-width">
          <template #default="scope">
            <el-tooltip content="修改" placement="top">
              <el-button
                link
                type="primary"
                icon="Edit"
                @click="handleUpdate(scope.row)"
                v-hasPermi="['qc:qcSpecialtyCategory:edit']"
              ></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button
                link
                type="primary"
                icon="Delete"
                @click="handleDelete(scope.row)"
                v-hasPermi="['qc:qcSpecialtyCategory:remove']"
              ></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改专业类别对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="qcSpecialtyCategoryFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="专业代码" prop="categoryCode">
          <el-input v-model="form.categoryCode" placeholder="请输入专业代码" />
        </el-form-item>
        <el-form-item label="专业名称" prop="categoryName">
          <el-input v-model="form.categoryName" placeholder="请输入专业名称" />
        </el-form-item>
        <el-form-item label="发布年份" prop="publishYear">
          <el-input v-model="form.publishYear" placeholder="请输入发布年份" />
        </el-form-item>
        <el-form-item label="排序" prop="sortOrder">
          <el-input v-model="form.sortOrder" placeholder="请输入排序" />
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
    </el-dialog>
  </div>
</template>

<script setup name="QcSpecialtyCategory" lang="ts">
import {
  listQcSpecialtyCategory,
  getQcSpecialtyCategory,
  delQcSpecialtyCategory,
  addQcSpecialtyCategory,
  updateQcSpecialtyCategory
} from '@/api/qc/qcSpecialtyCategory';
import { QcSpecialtyCategoryVO, QcSpecialtyCategoryQuery, QcSpecialtyCategoryForm } from '@/api/qc/qcSpecialtyCategory/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const qcSpecialtyCategoryList = ref<QcSpecialtyCategoryVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const qcSpecialtyCategoryFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: QcSpecialtyCategoryForm = {
  id: undefined,
  categoryCode: undefined,
  categoryName: undefined,
  publishYear: undefined,
  sortOrder: undefined,
  status: undefined,
  delFlag: undefined
};
const data = reactive<PageData<QcSpecialtyCategoryForm, QcSpecialtyCategoryQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    categoryCode: undefined,
    categoryName: undefined,
    publishYear: undefined,
    sortOrder: undefined,
    status: undefined,
    delFlag: undefined,
    params: {}
  },
  rules: {
    id: [{ required: true, message: '主键ID不能为空', trigger: 'blur' }],
    categoryCode: [{ required: true, message: '专业代码不能为空', trigger: 'blur' }],
    categoryName: [{ required: true, message: '专业名称不能为空', trigger: 'blur' }]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询专业类别列表 */
const getList = async () => {
  loading.value = true;
  const res = await listQcSpecialtyCategory(queryParams.value);
  qcSpecialtyCategoryList.value = res.rows;
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
  qcSpecialtyCategoryFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: QcSpecialtyCategoryVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加专业类别';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: QcSpecialtyCategoryVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getQcSpecialtyCategory(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改专业类别';
};

/** 提交按钮 */
const submitForm = () => {
  qcSpecialtyCategoryFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateQcSpecialtyCategory(form.value).finally(() => (buttonLoading.value = false));
      } else {
        await addQcSpecialtyCategory(form.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: QcSpecialtyCategoryVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除专业类别编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delQcSpecialtyCategory(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/qcSpecialtyCategory/export',
    {
      ...queryParams.value
    },
    `qcSpecialtyCategory_${new Date().getTime()}.xlsx`
  );
};

onMounted(() => {
  getList();
});
</script>
