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
            <el-form-item label="标本类型代码" prop="specimenTypeCode">
              <el-input v-model="queryParams.specimenTypeCode" placeholder="请输入标本类型代码" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="标本类型名称" prop="specimenTypeName">
              <el-input v-model="queryParams.specimenTypeName" placeholder="请输入标本类型名称" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="标本编号" prop="specimenCode">
              <el-input v-model="queryParams.specimenCode" placeholder="请输入标本编号" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="检验流水号" prop="labSn">
              <el-input v-model="queryParams.labSn" placeholder="请输入检验流水号" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="检验时间" prop="testDatetime">
              <el-date-picker clearable
                v-model="queryParams.testDatetime"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择检验时间"
              />
            </el-form-item>
            <el-form-item label="检验方法代码" prop="testMethodCode">
              <el-input v-model="queryParams.testMethodCode" placeholder="请输入检验方法代码" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="检验方法" prop="testMethod">
              <el-input v-model="queryParams.testMethod" placeholder="请输入检验方法" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="组合项目代码" prop="itemGroupCode">
              <el-input v-model="queryParams.itemGroupCode" placeholder="请输入组合项目代码" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="组合项目名称" prop="itemGroupName">
              <el-input v-model="queryParams.itemGroupName" placeholder="请输入组合项目名称" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="明细项目代码" prop="itemCode">
              <el-input v-model="queryParams.itemCode" placeholder="请输入明细项目代码" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="明细项目名称" prop="itemName">
              <el-input v-model="queryParams.itemName" placeholder="请输入明细项目名称" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="明细项目序号" prop="itemNo">
              <el-input v-model="queryParams.itemNo" placeholder="请输入明细项目序号" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="检验-结果(数值)" prop="resultQuantitative">
              <el-input v-model="queryParams.resultQuantitative" placeholder="请输入检验-结果(数值)" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="检验-结果(定性)" prop="resultQualitative">
              <el-input v-model="queryParams.resultQualitative" placeholder="请输入检验-结果(定性)" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="检验-计量单位" prop="resultUnit">
              <el-input v-model="queryParams.resultUnit" placeholder="请输入检验-计量单位" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="参考值" prop="referenceRange">
              <el-input v-model="queryParams.referenceRange" placeholder="请输入参考值" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="参考值提醒" prop="referenceRangeAlert">
              <el-input v-model="queryParams.referenceRangeAlert" placeholder="请输入参考值提醒" clearable @keyup.enter="handleQuery" />
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
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['natdss:natdssB171LabInfo:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="success" plain icon="Edit" :disabled="single" @click="handleUpdate()" v-hasPermi="['natdss:natdssB171LabInfo:edit']">修改</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="danger" plain icon="Delete" :disabled="multiple" @click="handleDelete()" v-hasPermi="['natdss:natdssB171LabInfo:remove']">删除</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['natdss:natdssB171LabInfo:export']">导出</el-button>
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" border :data="natdssB171LabInfoList" @selection-change="handleSelectionChange">
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
        <el-table-column label="标本类型代码" align="center" prop="specimenTypeCode" />
        <el-table-column label="标本类型名称" align="center" prop="specimenTypeName" />
        <el-table-column label="标本编号" align="center" prop="specimenCode" />
        <el-table-column label="检验流水号" align="center" prop="labSn" />
        <el-table-column label="检验时间" align="center" prop="testDatetime" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.testDatetime, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="检验方法代码" align="center" prop="testMethodCode" />
        <el-table-column label="检验方法" align="center" prop="testMethod" />
        <el-table-column label="检验类型" align="center" prop="labType" />
        <el-table-column label="组合项目代码" align="center" prop="itemGroupCode" />
        <el-table-column label="组合项目名称" align="center" prop="itemGroupName" />
        <el-table-column label="明细项目代码" align="center" prop="itemCode" />
        <el-table-column label="明细项目名称" align="center" prop="itemName" />
        <el-table-column label="明细项目序号" align="center" prop="itemNo" />
        <el-table-column label="检验-结果(数值)" align="center" prop="resultQuantitative" />
        <el-table-column label="检验-结果(定性)" align="center" prop="resultQualitative" />
        <el-table-column label="检验-计量单位" align="center" prop="resultUnit" />
        <el-table-column label="参考值" align="center" prop="referenceRange" />
        <el-table-column label="参考值提醒" align="center" prop="referenceRangeAlert" />
        <el-table-column label="报告单号" align="center" prop="reportNo" />
        <el-table-column label="报告时间" align="center" prop="reportDatetime" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.reportDatetime, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
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
              <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['natdss:natdssB171LabInfo:edit']"></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)" v-hasPermi="['natdss:natdssB171LabInfo:remove']"></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改B17-1 常规检验记录对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="natdssB171LabInfoFormRef" :model="form" :rules="rules" label-width="80px">
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
        <el-form-item label="标本类型代码" prop="specimenTypeCode">
          <el-input v-model="form.specimenTypeCode" placeholder="请输入标本类型代码" />
        </el-form-item>
        <el-form-item label="标本类型名称" prop="specimenTypeName">
          <el-input v-model="form.specimenTypeName" placeholder="请输入标本类型名称" />
        </el-form-item>
        <el-form-item label="标本编号" prop="specimenCode">
          <el-input v-model="form.specimenCode" placeholder="请输入标本编号" />
        </el-form-item>
        <el-form-item label="检验流水号" prop="labSn">
          <el-input v-model="form.labSn" placeholder="请输入检验流水号" />
        </el-form-item>
        <el-form-item label="检验时间" prop="testDatetime">
          <el-date-picker clearable
            v-model="form.testDatetime"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择检验时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="检验方法代码" prop="testMethodCode">
          <el-input v-model="form.testMethodCode" placeholder="请输入检验方法代码" />
        </el-form-item>
        <el-form-item label="检验方法" prop="testMethod">
          <el-input v-model="form.testMethod" placeholder="请输入检验方法" />
        </el-form-item>
        <el-form-item label="组合项目代码" prop="itemGroupCode">
          <el-input v-model="form.itemGroupCode" placeholder="请输入组合项目代码" />
        </el-form-item>
        <el-form-item label="组合项目名称" prop="itemGroupName">
          <el-input v-model="form.itemGroupName" placeholder="请输入组合项目名称" />
        </el-form-item>
        <el-form-item label="明细项目代码" prop="itemCode">
          <el-input v-model="form.itemCode" placeholder="请输入明细项目代码" />
        </el-form-item>
        <el-form-item label="明细项目名称" prop="itemName">
          <el-input v-model="form.itemName" placeholder="请输入明细项目名称" />
        </el-form-item>
        <el-form-item label="明细项目序号" prop="itemNo">
          <el-input v-model="form.itemNo" placeholder="请输入明细项目序号" />
        </el-form-item>
        <el-form-item label="检验-结果(数值)" prop="resultQuantitative">
          <el-input v-model="form.resultQuantitative" placeholder="请输入检验-结果(数值)" />
        </el-form-item>
        <el-form-item label="检验-结果(定性)" prop="resultQualitative">
          <el-input v-model="form.resultQualitative" placeholder="请输入检验-结果(定性)" />
        </el-form-item>
        <el-form-item label="检验-计量单位" prop="resultUnit">
          <el-input v-model="form.resultUnit" placeholder="请输入检验-计量单位" />
        </el-form-item>
        <el-form-item label="参考值" prop="referenceRange">
          <el-input v-model="form.referenceRange" placeholder="请输入参考值" />
        </el-form-item>
        <el-form-item label="参考值提醒" prop="referenceRangeAlert">
          <el-input v-model="form.referenceRangeAlert" placeholder="请输入参考值提醒" />
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

<script setup name="NatdssB171LabInfo" lang="ts">
import { listNatdssB171LabInfo, getNatdssB171LabInfo, delNatdssB171LabInfo, addNatdssB171LabInfo, updateNatdssB171LabInfo } from '@/api/natdss/natdssB171LabInfo';
import { NatdssB171LabInfoVO, NatdssB171LabInfoQuery, NatdssB171LabInfoForm } from '@/api/natdss/natdssB171LabInfo/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const natdssB171LabInfoList = ref<NatdssB171LabInfoVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const natdssB171LabInfoFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: NatdssB171LabInfoForm = {
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
  specimenTypeCode: undefined,
  specimenTypeName: undefined,
  specimenCode: undefined,
  labSn: undefined,
  testDatetime: undefined,
  testMethodCode: undefined,
  testMethod: undefined,
  labType: undefined,
  itemGroupCode: undefined,
  itemGroupName: undefined,
  itemCode: undefined,
  itemName: undefined,
  itemNo: undefined,
  resultQuantitative: undefined,
  resultQualitative: undefined,
  resultUnit: undefined,
  referenceRange: undefined,
  referenceRangeAlert: undefined,
  reportNo: undefined,
  reportDatetime: undefined,
  extendData1: undefined,
  extendData2: undefined,
  recordStatus: undefined,
  createdTime: undefined,
  updatedTime: undefined
}
const data = reactive<PageData<NatdssB171LabInfoForm, NatdssB171LabInfoQuery>>({
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
    specimenTypeCode: undefined,
    specimenTypeName: undefined,
    specimenCode: undefined,
    labSn: undefined,
    testDatetime: undefined,
    testMethodCode: undefined,
    testMethod: undefined,
    labType: undefined,
    itemGroupCode: undefined,
    itemGroupName: undefined,
    itemCode: undefined,
    itemName: undefined,
    itemNo: undefined,
    resultQuantitative: undefined,
    resultQualitative: undefined,
    resultUnit: undefined,
    referenceRange: undefined,
    referenceRangeAlert: undefined,
    reportNo: undefined,
    reportDatetime: undefined,
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
    labSn: [
      { required: true, message: "检验流水号不能为空", trigger: "blur" }
    ],
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询B17-1 常规检验记录列表 */
const getList = async () => {
  loading.value = true;
  const res = await listNatdssB171LabInfo(queryParams.value);
  natdssB171LabInfoList.value = res.rows;
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
  natdssB171LabInfoFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: NatdssB171LabInfoVO[]) => {
  ids.value = selection.map(item => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
}

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = "添加B17-1 常规检验记录";
}

/** 修改按钮操作 */
const handleUpdate = async (row?: NatdssB171LabInfoVO) => {
  reset();
  const _id = row?.id || ids.value[0]
  const res = await getNatdssB171LabInfo(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = "修改B17-1 常规检验记录";
}

/** 提交按钮 */
const submitForm = () => {
  natdssB171LabInfoFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateNatdssB171LabInfo(form.value).finally(() =>  buttonLoading.value = false);
      } else {
        await addNatdssB171LabInfo(form.value).finally(() =>  buttonLoading.value = false);
      }
      proxy?.$modal.msgSuccess("操作成功");
      dialog.visible = false;
      await getList();
    }
  });
}

/** 删除按钮操作 */
const handleDelete = async (row?: NatdssB171LabInfoVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除B17-1 常规检验记录编号为"' + _ids + '"的数据项？').finally(() => loading.value = false);
  await delNatdssB171LabInfo(_ids);
  proxy?.$modal.msgSuccess("删除成功");
  await getList();
}

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download('natdss/natdssB171LabInfo/export', {
    ...queryParams.value
  }, `natdssB171LabInfo_${new Date().getTime()}.xlsx`)
}

onMounted(() => {
  getList();
});
</script>
