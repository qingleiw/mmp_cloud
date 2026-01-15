<template>
  <div class="p-2">
    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <div v-show="showSearch" class="mb-[10px]">
        <el-card shadow="hover">
          <el-form ref="queryFormRef" :model="queryParams" :inline="true">
            <el-form-item label="患者姓名" prop="patientName">
              <el-input v-model="queryParams.patientName" placeholder="请输入患者姓名" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="入院日期" prop="admissionDate">
              <el-date-picker clearable v-model="queryParams.admissionDate" type="date" value-format="YYYY-MM-DD" placeholder="请选择入院日期" />
            </el-form-item>
            <el-form-item label="抢救日期" prop="rescueDate">
              <el-date-picker clearable v-model="queryParams.rescueDate" type="date" value-format="YYYY-MM-DD" placeholder="请选择抢救日期" />
            </el-form-item>
            <el-form-item label="抢救科室" prop="department">
              <el-input v-model="queryParams.department" placeholder="请输入抢救科室" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="抢救医师" prop="rescuePhysician">
              <el-input v-model="queryParams.rescuePhysician" placeholder="请输入抢救医师" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="诊断" prop="diagnosis">
              <el-input v-model="queryParams.diagnosis" placeholder="请输入诊断" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="抢救原因" prop="rescueReason">
              <el-input v-model="queryParams.rescueReason" placeholder="请输入抢救原因" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="抢救措施" prop="rescueMeasures">
              <el-input v-model="queryParams.rescueMeasures" placeholder="请输入抢救措施" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="抢救时长(分钟)" prop="rescueDuration">
              <el-input v-model="queryParams.rescueDuration" placeholder="请输入抢救时长(分钟)" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="抢救结局" prop="rescueOutcome">
              <el-input v-model="queryParams.rescueOutcome" placeholder="请输入抢救结局" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="并发症" prop="complications">
              <el-input v-model="queryParams.complications" placeholder="请输入并发症" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="医疗评价" prop="medicalEvaluation">
              <el-input v-model="queryParams.medicalEvaluation" placeholder="请输入医疗评价" clearable @keyup.enter="handleQuery" />
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
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['ledger:ledgerCriticalPatient:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="success" plain icon="Edit" :disabled="single" @click="handleUpdate()" v-hasPermi="['ledger:ledgerCriticalPatient:edit']"
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
              v-hasPermi="['ledger:ledgerCriticalPatient:remove']"
              >删除</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['ledger:ledgerCriticalPatient:export']"
              >导出</el-button
            >
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" border :data="ledgerCriticalPatientList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="主键ID" align="center" prop="id" v-if="false" />
        <el-table-column label="患者姓名" align="center" prop="patientName" />
        <el-table-column label="入院日期" align="center" prop="admissionDate" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.admissionDate, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="抢救日期" align="center" prop="rescueDate" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.rescueDate, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="抢救科室" align="center" prop="department" />
        <el-table-column label="抢救医师" align="center" prop="rescuePhysician" />
        <el-table-column label="诊断" align="center" prop="diagnosis" />
        <el-table-column label="抢救原因" align="center" prop="rescueReason" />
        <el-table-column label="抢救措施" align="center" prop="rescueMeasures" />
        <el-table-column label="抢救时长(分钟)" align="center" prop="rescueDuration" />
        <el-table-column label="抢救结局" align="center" prop="rescueOutcome" />
        <el-table-column label="并发症" align="center" prop="complications" />
        <el-table-column label="医疗评价" align="center" prop="medicalEvaluation" />
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
                v-hasPermi="['ledger:ledgerCriticalPatient:edit']"
              ></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button
                link
                type="primary"
                icon="Delete"
                @click="handleDelete(scope.row)"
                v-hasPermi="['ledger:ledgerCriticalPatient:remove']"
              ></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改危重病人抢救登记本对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="ledgerCriticalPatientFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="患者ID" prop="patientId">
          <el-input v-model="form.patientId" placeholder="请输入患者ID" />
        </el-form-item>
        <el-form-item label="患者姓名" prop="patientName">
          <el-input v-model="form.patientName" placeholder="请输入患者姓名" />
        </el-form-item>
        <el-form-item label="入院日期" prop="admissionDate">
          <el-date-picker clearable v-model="form.admissionDate" type="datetime" value-format="YYYY-MM-DD HH:mm:ss" placeholder="请选择入院日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="抢救日期" prop="rescueDate">
          <el-date-picker clearable v-model="form.rescueDate" type="datetime" value-format="YYYY-MM-DD HH:mm:ss" placeholder="请选择抢救日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="抢救科室" prop="department">
          <el-input v-model="form.department" placeholder="请输入抢救科室" />
        </el-form-item>
        <el-form-item label="抢救医师" prop="rescuePhysician">
          <el-input v-model="form.rescuePhysician" placeholder="请输入抢救医师" />
        </el-form-item>
        <el-form-item label="诊断" prop="diagnosis">
          <el-input v-model="form.diagnosis" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="抢救原因" prop="rescueReason">
          <el-input v-model="form.rescueReason" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="抢救措施" prop="rescueMeasures">
          <el-input v-model="form.rescueMeasures" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="抢救时长(分钟)" prop="rescueDuration">
          <el-input v-model="form.rescueDuration" placeholder="请输入抢救时长(分钟)" />
        </el-form-item>
        <el-form-item label="抢救结局" prop="rescueOutcome">
          <el-input v-model="form.rescueOutcome" placeholder="请输入抢救结局" />
        </el-form-item>
        <el-form-item label="并发症" prop="complications">
          <el-input v-model="form.complications" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="医疗评价" prop="medicalEvaluation">
          <el-input v-model="form.medicalEvaluation" type="textarea" placeholder="请输入内容" />
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

<script setup name="LedgerCriticalPatient" lang="ts">
import {
  listLedgerCriticalPatient,
  getLedgerCriticalPatient,
  delLedgerCriticalPatient,
  addLedgerCriticalPatient,
  updateLedgerCriticalPatient
} from '@/api/ledger/ledgerCriticalPatient';
import { LedgerCriticalPatientVO, LedgerCriticalPatientQuery, LedgerCriticalPatientForm } from '@/api/ledger/ledgerCriticalPatient/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const ledgerCriticalPatientList = ref<LedgerCriticalPatientVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const ledgerCriticalPatientFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: LedgerCriticalPatientForm = {
  id: undefined,
  patientId: undefined,
  patientName: undefined,
  admissionDate: undefined,
  rescueDate: undefined,
  department: undefined,
  rescuePhysician: undefined,
  diagnosis: undefined,
  rescueReason: undefined,
  rescueMeasures: undefined,
  rescueDuration: undefined,
  rescueOutcome: undefined,
  complications: undefined,
  medicalEvaluation: undefined,
  status: undefined,
  remark: undefined
};
const data = reactive<PageData<LedgerCriticalPatientForm, LedgerCriticalPatientQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    patientName: undefined,
    admissionDate: undefined,
    rescueDate: undefined,
    department: undefined,
    rescuePhysician: undefined,
    diagnosis: undefined,
    rescueReason: undefined,
    rescueMeasures: undefined,
    rescueDuration: undefined,
    rescueOutcome: undefined,
    complications: undefined,
    medicalEvaluation: undefined,
    status: undefined,
    params: {}
  },
  rules: {
    id: [{ required: true, message: '主键ID不能为空', trigger: 'blur' }],
    patientId: [{ required: true, message: '患者ID不能为空', trigger: 'blur' }],
    patientName: [{ required: true, message: '患者姓名不能为空', trigger: 'blur' }],
    admissionDate: [{ required: true, message: '入院日期不能为空', trigger: 'blur' }],
    rescueDate: [{ required: true, message: '抢救日期不能为空', trigger: 'blur' }]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询危重病人抢救登记本列表 */
const getList = async () => {
  loading.value = true;
  const res = await listLedgerCriticalPatient(queryParams.value);
  ledgerCriticalPatientList.value = res.rows;
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
  ledgerCriticalPatientFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: LedgerCriticalPatientVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加危重病人抢救登记本';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: LedgerCriticalPatientVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getLedgerCriticalPatient(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改危重病人抢救登记本';
};

/** 提交按钮 */
const submitForm = () => {
  ledgerCriticalPatientFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateLedgerCriticalPatient(form.value).finally(() => (buttonLoading.value = false));
      } else {
        await addLedgerCriticalPatient(form.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: LedgerCriticalPatientVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除危重病人抢救登记本编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delLedgerCriticalPatient(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'ledger/ledgerCriticalPatient/export',
    {
      ...queryParams.value
    },
    `ledgerCriticalPatient_${new Date().getTime()}.xlsx`
  );
};

onMounted(() => {
  getList();
});
</script>
