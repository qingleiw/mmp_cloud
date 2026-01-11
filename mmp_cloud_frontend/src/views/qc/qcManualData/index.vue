<template>
  <div class="p-2">
    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <div v-show="showSearch" class="mb-[10px]">
        <el-card shadow="hover">
          <el-form ref="queryFormRef" :model="queryParams" :inline="true">
            <el-form-item label="指标ID" prop="indicatorId">
              <el-input v-model="queryParams.indicatorId" placeholder="请输入指标ID" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="患者ID" prop="patientId">
              <el-input v-model="queryParams.patientId" placeholder="请输入患者ID" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="就诊号" prop="visitNo">
              <el-input v-model="queryParams.visitNo" placeholder="请输入就诊号" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="数据字段" prop="dataField">
              <el-input v-model="queryParams.dataField" placeholder="请输入数据字段" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="数据值" prop="dataValue">
              <el-input v-model="queryParams.dataValue" placeholder="请输入数据值" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="数据日期" prop="dataDate">
              <el-date-picker clearable v-model="queryParams.dataDate" type="date" value-format="YYYY-MM-DD" placeholder="请选择数据日期" />
            </el-form-item>
            <el-form-item label="原始值" prop="originalValue">
              <el-input v-model="queryParams.originalValue" placeholder="请输入原始值" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="修改原因" prop="modifyReason">
              <el-input v-model="queryParams.modifyReason" placeholder="请输入修改原因" clearable @keyup.enter="handleQuery" />
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
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['system:qcManualData:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="success" plain icon="Edit" :disabled="single" @click="handleUpdate()" v-hasPermi="['system:qcManualData:edit']"
              >修改</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button type="danger" plain icon="Delete" :disabled="multiple" @click="handleDelete()" v-hasPermi="['system:qcManualData:remove']"
              >删除</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['system:qcManualData:export']">导出</el-button>
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" border :data="qcManualDataList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="主键ID" align="center" prop="id" v-if="true" />
        <el-table-column label="指标ID" align="center" prop="indicatorId" />
        <el-table-column label="患者ID" align="center" prop="patientId" />
        <el-table-column label="就诊号" align="center" prop="visitNo" />
        <el-table-column label="数据类型" align="center" prop="dataType" />
        <el-table-column label="数据字段" align="center" prop="dataField" />
        <el-table-column label="数据值" align="center" prop="dataValue" />
        <el-table-column label="数据日期" align="center" prop="dataDate" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.dataDate, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="操作类型 新增/修正" align="center" prop="operationType" />
        <el-table-column label="原始值" align="center" prop="originalValue" />
        <el-table-column label="修改原因" align="center" prop="modifyReason" />
        <el-table-column label="是否删除" align="center" prop="delFlag" />
        <el-table-column label="操作" align="center" fixed="right" class-name="small-padding fixed-width">
          <template #default="scope">
            <el-tooltip content="修改" placement="top">
              <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['system:qcManualData:edit']"></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)" v-hasPermi="['system:qcManualData:remove']"></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改人工补录数据对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="qcManualDataFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="指标ID" prop="indicatorId">
          <el-input v-model="form.indicatorId" placeholder="请输入指标ID" />
        </el-form-item>
        <el-form-item label="患者ID" prop="patientId">
          <el-input v-model="form.patientId" placeholder="请输入患者ID" />
        </el-form-item>
        <el-form-item label="就诊号" prop="visitNo">
          <el-input v-model="form.visitNo" placeholder="请输入就诊号" />
        </el-form-item>
        <el-form-item label="数据字段" prop="dataField">
          <el-input v-model="form.dataField" placeholder="请输入数据字段" />
        </el-form-item>
        <el-form-item label="数据值" prop="dataValue">
          <el-input v-model="form.dataValue" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="数据日期" prop="dataDate">
          <el-date-picker clearable v-model="form.dataDate" type="datetime" value-format="YYYY-MM-DD HH:mm:ss" placeholder="请选择数据日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="原始值" prop="originalValue">
          <el-input v-model="form.originalValue" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="修改原因" prop="modifyReason">
          <el-input v-model="form.modifyReason" type="textarea" placeholder="请输入内容" />
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

<script setup name="QcManualData" lang="ts">
import { listQcManualData, getQcManualData, delQcManualData, addQcManualData, updateQcManualData } from '@/api/qc/qcManualData';
import { QcManualDataVO, QcManualDataQuery, QcManualDataForm } from '@/api/qc/qcManualData/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const qcManualDataList = ref<QcManualDataVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const qcManualDataFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: QcManualDataForm = {
  id: undefined,
  indicatorId: undefined,
  patientId: undefined,
  visitNo: undefined,
  dataType: undefined,
  dataField: undefined,
  dataValue: undefined,
  dataDate: undefined,
  operationType: undefined,
  originalValue: undefined,
  modifyReason: undefined,
  delFlag: undefined
};
const data = reactive<PageData<QcManualDataForm, QcManualDataQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    indicatorId: undefined,
    patientId: undefined,
    visitNo: undefined,
    dataType: undefined,
    dataField: undefined,
    dataValue: undefined,
    dataDate: undefined,
    operationType: undefined,
    originalValue: undefined,
    modifyReason: undefined,
    delFlag: undefined,
    params: {}
  },
  rules: {
    id: [{ required: true, message: '主键ID不能为空', trigger: 'blur' }],
    indicatorId: [{ required: true, message: '指标ID不能为空', trigger: 'blur' }]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询人工补录数据列表 */
const getList = async () => {
  loading.value = true;
  const res = await listQcManualData(queryParams.value);
  qcManualDataList.value = res.rows;
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
  qcManualDataFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: QcManualDataVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加人工补录数据';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: QcManualDataVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getQcManualData(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改人工补录数据';
};

/** 提交按钮 */
const submitForm = () => {
  qcManualDataFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateQcManualData(form.value).finally(() => (buttonLoading.value = false));
      } else {
        await addQcManualData(form.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: QcManualDataVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除人工补录数据编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delQcManualData(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/qcManualData/export',
    {
      ...queryParams.value
    },
    `qcManualData_${new Date().getTime()}.xlsx`
  );
};

onMounted(() => {
  getList();
});
</script>
