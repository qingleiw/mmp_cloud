<template>
  <div class="p-2">
    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <div v-show="showSearch" class="mb-[10px]">
        <el-card shadow="hover">
          <el-form ref="queryFormRef" :model="queryParams" :inline="true">
            <el-form-item label="附加编码" prop="additionalCode">
              <el-input v-model="queryParams.additionalCode" placeholder="请输入附加编码" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="细目代码" prop="detailCode">
              <el-input v-model="queryParams.detailCode" placeholder="请输入细目代码" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="手术操作名称" prop="surgeryName">
              <el-input v-model="queryParams.surgeryName" placeholder="请输入手术操作名称" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="类别" prop="category">
              <el-input v-model="queryParams.category" placeholder="请输入类别" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="手术等级" prop="surgeryLevel">
              <el-input v-model="queryParams.surgeryLevel" placeholder="请输入手术等级" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="是否启用" prop="isEnabled">
              <el-input v-model="queryParams.isEnabled" placeholder="请输入是否启用" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="所属科室" prop="department">
              <el-input v-model="queryParams.department" placeholder="请输入所属科室" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="手术分类" prop="surgeryCategory">
              <el-input v-model="queryParams.surgeryCategory" placeholder="请输入手术分类" clearable @keyup.enter="handleQuery" />
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
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['surgery:surgeryCatalog:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="success" plain icon="Edit" :disabled="single" @click="handleUpdate()" v-hasPermi="['surgery:surgeryCatalog:edit']"
              >修改</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button type="danger" plain icon="Delete" :disabled="multiple" @click="handleDelete()" v-hasPermi="['surgery:surgeryCatalog:remove']"
              >删除</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['surgery:surgeryCatalog:export']">导出</el-button>
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" border :data="surgeryCatalogList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="主键ID" align="center" prop="id" v-if="false" />
        <el-table-column label="附加编码" align="center" prop="additionalCode" />
        <el-table-column label="细目代码" align="center" prop="detailCode" />
        <el-table-column label="手术操作名称" align="center" prop="surgeryName" />
        <el-table-column label="类别" align="center" prop="category" />
        <el-table-column label="手术等级" align="center" prop="surgeryLevel" />
        <el-table-column label="是否启用" align="center" prop="isEnabled" />
        <el-table-column label="所属科室" align="center" prop="department" />
        <el-table-column label="手术分类" align="center" prop="surgeryCategory" />
        <el-table-column label="备注" align="center" prop="remark" />
        <el-table-column label="操作" align="center" fixed="right" class-name="small-padding fixed-width">
          <template #default="scope">
            <el-tooltip content="修改" placement="top">
              <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['surgery:surgeryCatalog:edit']"></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)" v-hasPermi="['surgery:surgeryCatalog:remove']"></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改手术目录对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="surgeryCatalogFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="附加编码" prop="additionalCode">
          <el-input v-model="form.additionalCode" placeholder="请输入附加编码" />
        </el-form-item>
        <el-form-item label="细目代码" prop="detailCode">
          <el-input v-model="form.detailCode" placeholder="请输入细目代码" />
        </el-form-item>
        <el-form-item label="手术操作名称" prop="surgeryName">
          <el-input v-model="form.surgeryName" placeholder="请输入手术操作名称" />
        </el-form-item>
        <el-form-item label="类别" prop="category">
          <el-input v-model="form.category" placeholder="请输入类别" />
        </el-form-item>
        <el-form-item label="手术等级" prop="surgeryLevel">
          <el-input v-model="form.surgeryLevel" placeholder="请输入手术等级" />
        </el-form-item>
        <el-form-item label="是否启用" prop="isEnabled">
          <el-input v-model="form.isEnabled" placeholder="请输入是否启用" />
        </el-form-item>
        <el-form-item label="所属科室" prop="department">
          <el-input v-model="form.department" placeholder="请输入所属科室" />
        </el-form-item>
        <el-form-item label="手术分类" prop="surgeryCategory">
          <el-input v-model="form.surgeryCategory" placeholder="请输入手术分类" />
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

<script setup name="SurgeryCatalog" lang="ts">
import { listSurgeryCatalog, getSurgeryCatalog, delSurgeryCatalog, addSurgeryCatalog, updateSurgeryCatalog } from '@/api/surgery/surgeryCatalog';
import { SurgeryCatalogVO, SurgeryCatalogQuery, SurgeryCatalogForm } from '@/api/surgery/surgeryCatalog/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const surgeryCatalogList = ref<SurgeryCatalogVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const surgeryCatalogFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: SurgeryCatalogForm = {
  id: undefined,
  additionalCode: undefined,
  detailCode: undefined,
  surgeryName: undefined,
  category: undefined,
  surgeryLevel: undefined,
  isEnabled: undefined,
  department: undefined,
  surgeryCategory: undefined,
  remark: undefined
};
const data = reactive<PageData<SurgeryCatalogForm, SurgeryCatalogQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    additionalCode: undefined,
    detailCode: undefined,
    surgeryName: undefined,
    category: undefined,
    surgeryLevel: undefined,
    isEnabled: undefined,
    department: undefined,
    surgeryCategory: undefined,
    params: {}
  },
  rules: {
    id: [{ required: true, message: '主键ID不能为空', trigger: 'blur' }],
    additionalCode: [{ required: true, message: '附加编码不能为空', trigger: 'blur' }],
    detailCode: [{ required: true, message: '细目代码不能为空', trigger: 'blur' }],
    surgeryName: [{ required: true, message: '手术操作名称不能为空', trigger: 'blur' }],
    category: [{ required: true, message: '类别不能为空', trigger: 'blur' }],
    surgeryLevel: [{ required: true, message: '手术等级不能为空', trigger: 'blur' }]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询手术目录列表 */
const getList = async () => {
  loading.value = true;
  try {
    const res = await listSurgeryCatalog(queryParams.value);
    surgeryCatalogList.value = res.rows;
    total.value = res.total;
  } catch (error) {
    console.error('获取手术目录列表失败:', error);
    surgeryCatalogList.value = [];
    total.value = 0;
  } finally {
    loading.value = false;
  }
};

/** 取消按钮 */
const cancel = () => {
  reset();
  dialog.visible = false;
};

/** 表单重置 */
const reset = () => {
  form.value = { ...initFormData };
  surgeryCatalogFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: SurgeryCatalogVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加手术目录';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: SurgeryCatalogVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getSurgeryCatalog(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改手术目录';
};

/** 提交按钮 */
const submitForm = () => {
  surgeryCatalogFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateSurgeryCatalog(form.value).finally(() => (buttonLoading.value = false));
      } else {
        await addSurgeryCatalog(form.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: SurgeryCatalogVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除手术目录编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delSurgeryCatalog(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'surgery/surgeryCatalog/export',
    {
      ...queryParams.value
    },
    `surgeryCatalog_${new Date().getTime()}.xlsx`
  );
};

onMounted(() => {
  getList();
});
</script>
