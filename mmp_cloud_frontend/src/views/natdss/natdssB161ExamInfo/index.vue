<template>
  <div class="p-2">
    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <div v-show="showSearch" class="mb-[10px]">
        <el-card shadow="hover">
          <el-form ref="queryFormRef" :model="queryParams" :inline="true">
            <el-form-item label="患者ID" prop="patientId">
              <el-input v-model="queryParams.patientId" placeholder="请输入患者ID" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="单次就诊唯一标识号" prop="visitSn">
              <el-input v-model="queryParams.visitSn" placeholder="请输入单次就诊唯一标识号" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="就诊卡号" prop="visitCardNo">
              <el-input v-model="queryParams.visitCardNo" placeholder="请输入就诊卡号" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="门诊号" prop="outpatientNo">
              <el-input v-model="queryParams.outpatientNo" placeholder="请输入门诊号" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="就诊次数" prop="visitTimes">
              <el-input v-model="queryParams.visitTimes" placeholder="请输入就诊次数" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="病案号" prop="medicalRecordNo">
              <el-input v-model="queryParams.medicalRecordNo" placeholder="请输入病案号" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="住院号" prop="inpatientNo">
              <el-input v-model="queryParams.inpatientNo" placeholder="请输入住院号" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="住院次数" prop="hospitalizationTimes">
              <el-input v-model="queryParams.hospitalizationTimes" placeholder="请输入住院次数" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="患者姓名" prop="name">
              <el-input v-model="queryParams.name" placeholder="请输入患者姓名" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="申请单号" prop="applyNo">
              <el-input v-model="queryParams.applyNo" placeholder="请输入申请单号" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="申请医嘱流水号" prop="orderSn">
              <el-input v-model="queryParams.orderSn" placeholder="请输入申请医嘱流水号" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="申请时间" prop="applyDatetime">
              <el-date-picker clearable
                v-model="queryParams.applyDatetime"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择申请时间"
              />
            </el-form-item>
            <el-form-item label="申请科室代码" prop="applyDeptCode">
              <el-input v-model="queryParams.applyDeptCode" placeholder="请输入申请科室代码" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="申请科室名称" prop="applyDeptName">
              <el-input v-model="queryParams.applyDeptName" placeholder="请输入申请科室名称" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="检查流水号" prop="examSn">
              <el-input v-model="queryParams.examSn" placeholder="请输入检查流水号" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="检查时间" prop="examDatetime">
              <el-date-picker clearable
                v-model="queryParams.examDatetime"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择检查时间"
              />
            </el-form-item>
            <el-form-item label="检查项目代码" prop="examItemCode">
              <el-input v-model="queryParams.examItemCode" placeholder="请输入检查项目代码" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="检查项目名称" prop="examItemName">
              <el-input v-model="queryParams.examItemName" placeholder="请输入检查项目名称" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="检查部位" prop="examSites">
              <el-input v-model="queryParams.examSites" placeholder="请输入检查部位" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="报告单号" prop="reportNo">
              <el-input v-model="queryParams.reportNo" placeholder="请输入报告单号" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="报告时间" prop="reportDatetime">
              <el-date-picker clearable
                v-model="queryParams.reportDatetime"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择报告时间"
              />
            </el-form-item>
            <el-form-item label="报告科室代码" prop="reportDeptCode">
              <el-input v-model="queryParams.reportDeptCode" placeholder="请输入报告科室代码" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="报告科室名称" prop="reportDeptName">
              <el-input v-model="queryParams.reportDeptName" placeholder="请输入报告科室名称" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="检查所见" prop="examDiagDescription">
              <el-input v-model="queryParams.examDiagDescription" placeholder="请输入检查所见" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="检查结论" prop="examDiagConclusion">
              <el-input v-model="queryParams.examDiagConclusion" placeholder="请输入检查结论" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="扩展字段1" prop="extendData1">
              <el-input v-model="queryParams.extendData1" placeholder="请输入扩展字段1" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="扩展字段2" prop="extendData2">
              <el-input v-model="queryParams.extendData2" placeholder="请输入扩展字段2" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="创建时间" prop="createdTime">
              <el-date-picker clearable
                v-model="queryParams.createdTime"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择创建时间"
              />
            </el-form-item>
            <el-form-item label="更新时间" prop="updatedTime">
              <el-date-picker clearable
                v-model="queryParams.updatedTime"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择更新时间"
              />
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
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['natdss:natdssB161ExamInfo:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="success" plain icon="Edit" :disabled="single" @click="handleUpdate()" v-hasPermi="['natdss:natdssB161ExamInfo:edit']">修改</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="danger" plain icon="Delete" :disabled="multiple" @click="handleDelete()" v-hasPermi="['natdss:natdssB161ExamInfo:remove']">删除</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['natdss:natdssB161ExamInfo:export']">导出</el-button>
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" border :data="natdssB161ExamInfoList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="系统自增主键" align="center" prop="id" v-if="true" />
        <el-table-column label="患者ID" align="center" prop="patientId" />
        <el-table-column label="单次就诊唯一标识号" align="center" prop="visitSn" />
        <el-table-column label="就诊类型:住院、门诊" align="center" prop="visitType" />
        <el-table-column label="就诊卡号" align="center" prop="visitCardNo" />
        <el-table-column label="门诊号" align="center" prop="outpatientNo" />
        <el-table-column label="就诊次数" align="center" prop="visitTimes" />
        <el-table-column label="病案号" align="center" prop="medicalRecordNo" />
        <el-table-column label="住院号" align="center" prop="inpatientNo" />
        <el-table-column label="住院次数" align="center" prop="hospitalizationTimes" />
        <el-table-column label="患者姓名" align="center" prop="name" />
        <el-table-column label="申请单号" align="center" prop="applyNo" />
        <el-table-column label="申请医嘱流水号" align="center" prop="orderSn" />
        <el-table-column label="申请时间" align="center" prop="applyDatetime" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.applyDatetime, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="申请科室代码" align="center" prop="applyDeptCode" />
        <el-table-column label="申请科室名称" align="center" prop="applyDeptName" />
        <el-table-column label="检查流水号" align="center" prop="examSn" />
        <el-table-column label="检查时间" align="center" prop="examDatetime" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.examDatetime, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="检查类型:心电超声放射" align="center" prop="examType" />
        <el-table-column label="检查项目类型" align="center" prop="examItemType" />
        <el-table-column label="检查项目代码" align="center" prop="examItemCode" />
        <el-table-column label="检查项目名称" align="center" prop="examItemName" />
        <el-table-column label="检查部位" align="center" prop="examSites" />
        <el-table-column label="报告单号" align="center" prop="reportNo" />
        <el-table-column label="报告时间" align="center" prop="reportDatetime" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.reportDatetime, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="报告科室代码" align="center" prop="reportDeptCode" />
        <el-table-column label="报告科室名称" align="center" prop="reportDeptName" />
        <el-table-column label="检查所见" align="center" prop="examDiagDescription" />
        <el-table-column label="检查结论" align="center" prop="examDiagConclusion" />
        <el-table-column label="扩展字段1" align="center" prop="extendData1" />
        <el-table-column label="扩展字段2" align="center" prop="extendData2" />
        <el-table-column label="记录状态:1正常 0作废" align="center" prop="recordStatus" />
        <el-table-column label="创建时间" align="center" prop="createdTime" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.createdTime, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="更新时间" align="center" prop="updatedTime" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.updatedTime, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="操作" align="center" fixed="right" class-name="small-padding fixed-width">
          <template #default="scope">
            <el-tooltip content="修改" placement="top">
              <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['natdss:natdssB161ExamInfo:edit']"></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)" v-hasPermi="['natdss:natdssB161ExamInfo:remove']"></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改B16-1 常规检查记录对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="natdssB161ExamInfoFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="患者ID" prop="patientId">
          <el-input v-model="form.patientId" placeholder="请输入患者ID" />
        </el-form-item>
        <el-form-item label="单次就诊唯一标识号" prop="visitSn">
          <el-input v-model="form.visitSn" placeholder="请输入单次就诊唯一标识号" />
        </el-form-item>
        <el-form-item label="就诊卡号" prop="visitCardNo">
          <el-input v-model="form.visitCardNo" placeholder="请输入就诊卡号" />
        </el-form-item>
        <el-form-item label="门诊号" prop="outpatientNo">
          <el-input v-model="form.outpatientNo" placeholder="请输入门诊号" />
        </el-form-item>
        <el-form-item label="就诊次数" prop="visitTimes">
          <el-input v-model="form.visitTimes" placeholder="请输入就诊次数" />
        </el-form-item>
        <el-form-item label="病案号" prop="medicalRecordNo">
          <el-input v-model="form.medicalRecordNo" placeholder="请输入病案号" />
        </el-form-item>
        <el-form-item label="住院号" prop="inpatientNo">
          <el-input v-model="form.inpatientNo" placeholder="请输入住院号" />
        </el-form-item>
        <el-form-item label="住院次数" prop="hospitalizationTimes">
          <el-input v-model="form.hospitalizationTimes" placeholder="请输入住院次数" />
        </el-form-item>
        <el-form-item label="患者姓名" prop="name">
          <el-input v-model="form.name" placeholder="请输入患者姓名" />
        </el-form-item>
        <el-form-item label="申请单号" prop="applyNo">
          <el-input v-model="form.applyNo" placeholder="请输入申请单号" />
        </el-form-item>
        <el-form-item label="申请医嘱流水号" prop="orderSn">
          <el-input v-model="form.orderSn" placeholder="请输入申请医嘱流水号" />
        </el-form-item>
        <el-form-item label="申请时间" prop="applyDatetime">
          <el-date-picker clearable
            v-model="form.applyDatetime"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择申请时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="申请科室代码" prop="applyDeptCode">
          <el-input v-model="form.applyDeptCode" placeholder="请输入申请科室代码" />
        </el-form-item>
        <el-form-item label="申请科室名称" prop="applyDeptName">
          <el-input v-model="form.applyDeptName" placeholder="请输入申请科室名称" />
        </el-form-item>
        <el-form-item label="检查流水号" prop="examSn">
          <el-input v-model="form.examSn" placeholder="请输入检查流水号" />
        </el-form-item>
        <el-form-item label="检查时间" prop="examDatetime">
          <el-date-picker clearable
            v-model="form.examDatetime"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择检查时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="检查项目代码" prop="examItemCode">
          <el-input v-model="form.examItemCode" placeholder="请输入检查项目代码" />
        </el-form-item>
        <el-form-item label="检查项目名称" prop="examItemName">
          <el-input v-model="form.examItemName" placeholder="请输入检查项目名称" />
        </el-form-item>
        <el-form-item label="检查部位" prop="examSites">
            <el-input v-model="form.examSites" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="报告单号" prop="reportNo">
          <el-input v-model="form.reportNo" placeholder="请输入报告单号" />
        </el-form-item>
        <el-form-item label="报告时间" prop="reportDatetime">
          <el-date-picker clearable
            v-model="form.reportDatetime"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择报告时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="报告科室代码" prop="reportDeptCode">
          <el-input v-model="form.reportDeptCode" placeholder="请输入报告科室代码" />
        </el-form-item>
        <el-form-item label="报告科室名称" prop="reportDeptName">
          <el-input v-model="form.reportDeptName" placeholder="请输入报告科室名称" />
        </el-form-item>
        <el-form-item label="检查所见" prop="examDiagDescription">
            <el-input v-model="form.examDiagDescription" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="检查结论" prop="examDiagConclusion">
            <el-input v-model="form.examDiagConclusion" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="扩展字段1" prop="extendData1">
            <el-input v-model="form.extendData1" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="扩展字段2" prop="extendData2">
            <el-input v-model="form.extendData2" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="创建时间" prop="createdTime">
          <el-date-picker clearable
            v-model="form.createdTime"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择创建时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="更新时间" prop="updatedTime">
          <el-date-picker clearable
            v-model="form.updatedTime"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择更新时间">
          </el-date-picker>
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

<script setup name="NatdssB161ExamInfo" lang="ts">
import { listNatdssB161ExamInfo, getNatdssB161ExamInfo, delNatdssB161ExamInfo, addNatdssB161ExamInfo, updateNatdssB161ExamInfo } from '@/api/natdss/natdssB161ExamInfo';
import { NatdssB161ExamInfoVO, NatdssB161ExamInfoQuery, NatdssB161ExamInfoForm } from '@/api/natdss/natdssB161ExamInfo/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const natdssB161ExamInfoList = ref<NatdssB161ExamInfoVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const natdssB161ExamInfoFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: NatdssB161ExamInfoForm = {
  id: undefined,
  patientId: undefined,
  visitSn: undefined,
  visitType: undefined,
  visitCardNo: undefined,
  outpatientNo: undefined,
  visitTimes: undefined,
  medicalRecordNo: undefined,
  inpatientNo: undefined,
  hospitalizationTimes: undefined,
  name: undefined,
  applyNo: undefined,
  orderSn: undefined,
  applyDatetime: undefined,
  applyDeptCode: undefined,
  applyDeptName: undefined,
  examSn: undefined,
  examDatetime: undefined,
  examType: undefined,
  examItemType: undefined,
  examItemCode: undefined,
  examItemName: undefined,
  examSites: undefined,
  reportNo: undefined,
  reportDatetime: undefined,
  reportDeptCode: undefined,
  reportDeptName: undefined,
  examDiagDescription: undefined,
  examDiagConclusion: undefined,
  extendData1: undefined,
  extendData2: undefined,
  recordStatus: undefined,
  createdTime: undefined,
  updatedTime: undefined
}
const data = reactive<PageData<NatdssB161ExamInfoForm, NatdssB161ExamInfoQuery>>({
  form: {...initFormData},
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    patientId: undefined,
    visitSn: undefined,
    visitType: undefined,
    visitCardNo: undefined,
    outpatientNo: undefined,
    visitTimes: undefined,
    medicalRecordNo: undefined,
    inpatientNo: undefined,
    hospitalizationTimes: undefined,
    name: undefined,
    applyNo: undefined,
    orderSn: undefined,
    applyDatetime: undefined,
    applyDeptCode: undefined,
    applyDeptName: undefined,
    examSn: undefined,
    examDatetime: undefined,
    examType: undefined,
    examItemType: undefined,
    examItemCode: undefined,
    examItemName: undefined,
    examSites: undefined,
    reportNo: undefined,
    reportDatetime: undefined,
    reportDeptCode: undefined,
    reportDeptName: undefined,
    examDiagDescription: undefined,
    examDiagConclusion: undefined,
    extendData1: undefined,
    extendData2: undefined,
    recordStatus: undefined,
    createdTime: undefined,
    updatedTime: undefined,
    params: {
    }
  },
  rules: {
    id: [
      { required: true, message: "系统自增主键不能为空", trigger: "blur" }
    ],
    patientId: [
      { required: true, message: "患者ID不能为空", trigger: "blur" }
    ],
    visitSn: [
      { required: true, message: "单次就诊唯一标识号不能为空", trigger: "blur" }
    ],
    examSn: [
      { required: true, message: "检查流水号不能为空", trigger: "blur" }
    ],
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询B16-1 常规检查记录列表 */
const getList = async () => {
  loading.value = true;
  const res = await listNatdssB161ExamInfo(queryParams.value);
  natdssB161ExamInfoList.value = res.rows;
  total.value = res.total;
  loading.value = false;
}

/** 取消按钮 */
const cancel = () => {
  reset();
  dialog.visible = false;
}

/** 表单重置 */
const reset = () => {
  form.value = {...initFormData};
  natdssB161ExamInfoFormRef.value?.resetFields();
}

/** 搜索按钮操作 */
const handleQuery = () => {
  queryParams.value.pageNum = 1;
  getList();
}

/** 重置按钮操作 */
const resetQuery = () => {
  queryFormRef.value?.resetFields();
  handleQuery();
}

/** 多选框选中数据 */
const handleSelectionChange = (selection: NatdssB161ExamInfoVO[]) => {
  ids.value = selection.map(item => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
}

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = "添加B16-1 常规检查记录";
}

/** 修改按钮操作 */
const handleUpdate = async (row?: NatdssB161ExamInfoVO) => {
  reset();
  const _id = row?.id || ids.value[0]
  const res = await getNatdssB161ExamInfo(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = "修改B16-1 常规检查记录";
}

/** 提交按钮 */
const submitForm = () => {
  natdssB161ExamInfoFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateNatdssB161ExamInfo(form.value).finally(() =>  buttonLoading.value = false);
      } else {
        await addNatdssB161ExamInfo(form.value).finally(() =>  buttonLoading.value = false);
      }
      proxy?.$modal.msgSuccess("操作成功");
      dialog.visible = false;
      await getList();
    }
  });
}

/** 删除按钮操作 */
const handleDelete = async (row?: NatdssB161ExamInfoVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除B16-1 常规检查记录编号为"' + _ids + '"的数据项？').finally(() => loading.value = false);
  await delNatdssB161ExamInfo(_ids);
  proxy?.$modal.msgSuccess("删除成功");
  await getList();
}

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download('natdss/natdssB161ExamInfo/export', {
    ...queryParams.value
  }, `natdssB161ExamInfo_${new Date().getTime()}.xlsx`)
}

onMounted(() => {
  getList();
});
</script>
