<template>
  <div class="p-2">
    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <div v-show="showSearch" class="mb-[10px]">
        <el-card shadow="hover">
          <el-form ref="queryFormRef" :model="queryParams" :inline="true">
            <el-form-item label="姓名" prop="userName">
              <el-input v-model="queryParams.userName" placeholder="请输入姓名" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="员工编码" prop="employeeCode">
              <el-input v-model="queryParams.employeeCode" placeholder="请输入员工编码" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="所在部门名称" prop="departmentName">
              <el-input v-model="queryParams.departmentName" placeholder="请输入所在部门名称" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="工作岗位" prop="position">
              <el-input v-model="queryParams.position" placeholder="请输入工作岗位" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="入职日期" prop="hireDate">
              <el-date-picker clearable v-model="queryParams.hireDate" type="date" value-format="YYYY-MM-DD" placeholder="请选择入职日期" />
            </el-form-item>
            <el-form-item label="放射工作年限" prop="radiationWorkYears">
              <el-input v-model="queryParams.radiationWorkYears" placeholder="请输入放射工作年限" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="放射资质" prop="radiationQualification">
              <el-input v-model="queryParams.radiationQualification" placeholder="请输入放射资质" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="资质证书" prop="qualificationCertificate">
              <el-input v-model="queryParams.qualificationCertificate" placeholder="请输入资质证书" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="证书编号" prop="certificateNumber">
              <el-input v-model="queryParams.certificateNumber" placeholder="请输入证书编号" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="证书发证日期" prop="certificateIssueDate">
              <el-date-picker
                clearable
                v-model="queryParams.certificateIssueDate"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择证书发证日期"
              />
            </el-form-item>
            <el-form-item label="证书到期日期" prop="certificateExpiryDate">
              <el-date-picker
                clearable
                v-model="queryParams.certificateExpiryDate"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择证书到期日期"
              />
            </el-form-item>
            <el-form-item label="培训记录" prop="trainingRecords">
              <el-input v-model="queryParams.trainingRecords" placeholder="请输入培训记录" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="体检记录" prop="healthExamRecords">
              <el-input v-model="queryParams.healthExamRecords" placeholder="请输入体检记录" clearable @keyup.enter="handleQuery" />
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
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['radiation:radiationStaff:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="success" plain icon="Edit" :disabled="single" @click="handleUpdate()" v-hasPermi="['radiation:radiationStaff:edit']"
              >修改</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button type="danger" plain icon="Delete" :disabled="multiple" @click="handleDelete()" v-hasPermi="['radiation:radiationStaff:remove']"
              >删除</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['radiation:radiationStaff:export']">导出</el-button>
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" border :data="radiationStaffList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="主键ID" align="center" prop="id" v-if="false" />
        <el-table-column label="姓名" align="center" prop="userName" />
        <el-table-column label="员工编码" align="center" prop="employeeCode" />
        <el-table-column label="所在部门名称" align="center" prop="departmentName" />
        <el-table-column label="工作岗位" align="center" prop="position" />
        <el-table-column label="入职日期" align="center" prop="hireDate" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.hireDate, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="放射工作年限" align="center" prop="radiationWorkYears" />
        <el-table-column label="放射资质" align="center" prop="radiationQualification" />
        <el-table-column label="资质证书" align="center" prop="qualificationCertificate" />
        <el-table-column label="证书编号" align="center" prop="certificateNumber" />
        <el-table-column label="证书发证日期" align="center" prop="certificateIssueDate" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.certificateIssueDate, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="证书到期日期" align="center" prop="certificateExpiryDate" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.certificateExpiryDate, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="培训记录" align="center" prop="trainingRecords" />
        <el-table-column label="体检记录" align="center" prop="healthExamRecords" />
        <el-table-column label="状态：active-在职，inactive-离职" align="center" prop="status" />
        <el-table-column label="备注" align="center" prop="remark" />
        <el-table-column label="操作" align="center" fixed="right" class-name="small-padding fixed-width">
          <template #default="scope">
            <el-tooltip content="修改" placement="top">
              <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['radiation:radiationStaff:edit']"></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button
                link
                type="primary"
                icon="Delete"
                @click="handleDelete(scope.row)"
                v-hasPermi="['radiation:radiationStaff:remove']"
              ></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改放射工作人员对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="radiationStaffFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="用户ID" prop="userId">
          <el-input v-model="form.userId" placeholder="请输入用户ID" />
        </el-form-item>
        <el-form-item label="姓名" prop="userName">
          <el-input v-model="form.userName" placeholder="请输入姓名" />
        </el-form-item>
        <el-form-item label="员工编码" prop="employeeCode">
          <el-input v-model="form.employeeCode" placeholder="请输入员工编码" />
        </el-form-item>
        <el-form-item label="所在部门ID" prop="departmentId">
          <el-input v-model="form.departmentId" placeholder="请输入所在部门ID" />
        </el-form-item>
        <el-form-item label="所在部门名称" prop="departmentName">
          <el-input v-model="form.departmentName" placeholder="请输入所在部门名称" />
        </el-form-item>
        <el-form-item label="工作岗位" prop="position">
          <el-input v-model="form.position" placeholder="请输入工作岗位" />
        </el-form-item>
        <el-form-item label="入职日期" prop="hireDate">
          <el-date-picker clearable v-model="form.hireDate" type="datetime" value-format="YYYY-MM-DD HH:mm:ss" placeholder="请选择入职日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="放射工作年限" prop="radiationWorkYears">
          <el-input v-model="form.radiationWorkYears" placeholder="请输入放射工作年限" />
        </el-form-item>
        <el-form-item label="放射资质" prop="radiationQualification">
          <el-input v-model="form.radiationQualification" placeholder="请输入放射资质" />
        </el-form-item>
        <el-form-item label="资质证书" prop="qualificationCertificate">
          <el-input v-model="form.qualificationCertificate" placeholder="请输入资质证书" />
        </el-form-item>
        <el-form-item label="证书编号" prop="certificateNumber">
          <el-input v-model="form.certificateNumber" placeholder="请输入证书编号" />
        </el-form-item>
        <el-form-item label="证书发证日期" prop="certificateIssueDate">
          <el-date-picker
            clearable
            v-model="form.certificateIssueDate"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择证书发证日期"
          >
          </el-date-picker>
        </el-form-item>
        <el-form-item label="证书到期日期" prop="certificateExpiryDate">
          <el-date-picker
            clearable
            v-model="form.certificateExpiryDate"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择证书到期日期"
          >
          </el-date-picker>
        </el-form-item>
        <el-form-item label="培训记录" prop="trainingRecords">
          <el-input v-model="form.trainingRecords" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="体检记录" prop="healthExamRecords">
          <el-input v-model="form.healthExamRecords" type="textarea" placeholder="请输入内容" />
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

<script setup name="RadiationStaff" lang="ts">
import { listRadiationStaff, getRadiationStaff, delRadiationStaff, addRadiationStaff, updateRadiationStaff } from '@/api/radiation/radiationStaff';
import { RadiationStaffVO, RadiationStaffQuery, RadiationStaffForm } from '@/api/radiation/radiationStaff/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const radiationStaffList = ref<RadiationStaffVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const radiationStaffFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: RadiationStaffForm = {
  id: undefined,
  userId: undefined,
  userName: undefined,
  employeeCode: undefined,
  departmentId: undefined,
  departmentName: undefined,
  position: undefined,
  hireDate: undefined,
  radiationWorkYears: undefined,
  radiationQualification: undefined,
  qualificationCertificate: undefined,
  certificateNumber: undefined,
  certificateIssueDate: undefined,
  certificateExpiryDate: undefined,
  trainingRecords: undefined,
  healthExamRecords: undefined,
  status: undefined,
  remark: undefined
};
const data = reactive<PageData<RadiationStaffForm, RadiationStaffQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    userName: undefined,
    employeeCode: undefined,
    departmentName: undefined,
    position: undefined,
    hireDate: undefined,
    radiationWorkYears: undefined,
    radiationQualification: undefined,
    qualificationCertificate: undefined,
    certificateNumber: undefined,
    certificateIssueDate: undefined,
    certificateExpiryDate: undefined,
    trainingRecords: undefined,
    healthExamRecords: undefined,
    status: undefined,
    params: {}
  },
  rules: {
    id: [{ required: true, message: '主键ID不能为空', trigger: 'blur' }],
    userId: [{ required: true, message: '用户ID不能为空', trigger: 'blur' }],
    userName: [{ required: true, message: '姓名不能为空', trigger: 'blur' }]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询放射工作人员列表 */
const getList = async () => {
  loading.value = true;
  const res = await listRadiationStaff(queryParams.value);
  radiationStaffList.value = res.rows;
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
  radiationStaffFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: RadiationStaffVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加放射工作人员';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: RadiationStaffVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getRadiationStaff(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改放射工作人员';
};

/** 提交按钮 */
const submitForm = () => {
  radiationStaffFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateRadiationStaff(form.value).finally(() => (buttonLoading.value = false));
      } else {
        await addRadiationStaff(form.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: RadiationStaffVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除放射工作人员编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delRadiationStaff(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/radiationStaff/export',
    {
      ...queryParams.value
    },
    `radiationStaff_${new Date().getTime()}.xlsx`
  );
};

onMounted(() => {
  getList();
});
</script>
