<template>
  <div class="p-2">
    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <div v-show="showSearch" class="mb-[10px]">
        <el-card shadow="hover">
          <el-form ref="queryFormRef" :model="queryParams" :inline="true">
            <el-form-item label="因子名称" prop="factorName">
              <el-input v-model="queryParams.factorName" placeholder="请输入因子名称" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="因子代码" prop="factorCode">
              <el-input v-model="queryParams.factorCode" placeholder="请输入因子代码" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="因子描述" prop="description">
              <el-input v-model="queryParams.description" placeholder="请输入因子描述" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="数据来源" prop="dataSource">
              <el-input v-model="queryParams.dataSource" placeholder="请输入数据来源" clearable @keyup.enter="handleQuery" />
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
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['system:qcIndicatorFactor:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="success" plain icon="Edit" :disabled="single" @click="handleUpdate()" v-hasPermi="['system:qcIndicatorFactor:edit']"
              >修改</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button type="danger" plain icon="Delete" :disabled="multiple" @click="handleDelete()" v-hasPermi="['system:qcIndicatorFactor:remove']"
              >删除</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['system:qcIndicatorFactor:export']">导出</el-button>
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" border :data="qcIndicatorFactorList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="主键ID" align="center" prop="id" v-if="false" />
        <el-table-column label="因子类型：numerator-分子，denominator-分母" align="center" prop="factorType" />
        <el-table-column label="因子名称" align="center" prop="factorName" />
        <el-table-column label="因子代码" align="center" prop="factorCode" />
        <el-table-column label="因子描述" align="center" prop="description" />
        <el-table-column label="数据来源" align="center" prop="dataSource" />
        <el-table-column label="排序" align="center" prop="sortOrder" />
        <el-table-column label="是否删除" align="center" prop="delFlag" />
        <el-table-column label="操作" align="center" fixed="right" class-name="small-padding fixed-width">
          <template #default="scope">
            <el-tooltip content="修改" placement="top">
              <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['system:qcIndicatorFactor:edit']"></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button
                link
                type="primary"
                icon="Delete"
                @click="handleDelete(scope.row)"
                v-hasPermi="['system:qcIndicatorFactor:remove']"
              ></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改指标计算因子对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="qcIndicatorFactorFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="指标ID" prop="indicatorId">
          <el-input v-model="form.indicatorId" placeholder="请输入指标ID" />
        </el-form-item>
        <el-form-item label="因子名称" prop="factorName">
          <el-input v-model="form.factorName" placeholder="请输入因子名称" />
        </el-form-item>
        <el-form-item label="因子代码" prop="factorCode">
          <el-input v-model="form.factorCode" placeholder="请输入因子代码" />
        </el-form-item>
        <el-form-item label="因子描述" prop="description">
          <el-input v-model="form.description" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="数据来源" prop="dataSource">
          <el-input v-model="form.dataSource" placeholder="请输入数据来源" />
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

<script setup name="QcIndicatorFactor" lang="ts">
import {
  listQcIndicatorFactor,
  getQcIndicatorFactor,
  delQcIndicatorFactor,
  addQcIndicatorFactor,
  updateQcIndicatorFactor
} from '@/api/system/qcIndicatorFactor';
import { QcIndicatorFactorVO, QcIndicatorFactorQuery, QcIndicatorFactorForm } from '@/api/system/qcIndicatorFactor/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const qcIndicatorFactorList = ref<QcIndicatorFactorVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const qcIndicatorFactorFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: QcIndicatorFactorForm = {
  id: undefined,
  indicatorId: undefined,
  factorType: undefined,
  factorName: undefined,
  factorCode: undefined,
  description: undefined,
  dataSource: undefined,
  sortOrder: undefined,
  delFlag: undefined
};
const data = reactive<PageData<QcIndicatorFactorForm, QcIndicatorFactorQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    factorType: undefined,
    factorName: undefined,
    factorCode: undefined,
    description: undefined,
    dataSource: undefined,
    sortOrder: undefined,
    delFlag: undefined,
    params: {}
  },
  rules: {
    id: [{ required: true, message: '主键ID不能为空', trigger: 'blur' }],
    indicatorId: [{ required: true, message: '指标ID不能为空', trigger: 'blur' }],
    factorType: [{ required: true, message: '因子类型：numerator-分子，denominator-分母不能为空', trigger: 'change' }],
    factorName: [{ required: true, message: '因子名称不能为空', trigger: 'blur' }]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询指标计算因子列表 */
const getList = async () => {
  loading.value = true;
  const res = await listQcIndicatorFactor(queryParams.value);
  qcIndicatorFactorList.value = res.rows;
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
  qcIndicatorFactorFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: QcIndicatorFactorVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加指标计算因子';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: QcIndicatorFactorVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getQcIndicatorFactor(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改指标计算因子';
};

/** 提交按钮 */
const submitForm = () => {
  qcIndicatorFactorFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateQcIndicatorFactor(form.value).finally(() => (buttonLoading.value = false));
      } else {
        await addQcIndicatorFactor(form.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: QcIndicatorFactorVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除指标计算因子编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delQcIndicatorFactor(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/qcIndicatorFactor/export',
    {
      ...queryParams.value
    },
    `qcIndicatorFactor_${new Date().getTime()}.xlsx`
  );
};

onMounted(() => {
  getList();
});
</script>
