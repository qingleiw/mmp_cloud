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
            <el-form-item label="微生物检验流水号" prop="labSn">
              <el-input v-model="queryParams.labSn" placeholder="请输入微生物检验流水号" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="检验时间" prop="testDatetime">
              <el-date-picker clearable
                v-model="queryParams.testDatetime"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择检验时间"
              />
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
            <el-form-item label="标本编号" prop="specimenCode">
              <el-input v-model="queryParams.specimenCode" placeholder="请输入标本编号" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="检验方法代码" prop="testMethodCode">
              <el-input v-model="queryParams.testMethodCode" placeholder="请输入检验方法代码" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="检验方法" prop="testMethod">
              <el-input v-model="queryParams.testMethod" placeholder="请输入检验方法" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="培养结果" prop="cultivationResult">
              <el-input v-model="queryParams.cultivationResult" placeholder="请输入培养结果" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="结果代码" prop="resultCode">
              <el-input v-model="queryParams.resultCode" placeholder="请输入结果代码" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="结果阴阳性" prop="resultPosNeg">
              <el-input v-model="queryParams.resultPosNeg" placeholder="请输入结果阴阳性" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="药敏方法" prop="sensTestMethod">
              <el-input v-model="queryParams.sensTestMethod" placeholder="请输入药敏方法" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="耐药机制" prop="resisMechanism">
              <el-input v-model="queryParams.resisMechanism" placeholder="请输入耐药机制" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="检测抗生素编码" prop="antibioticsCode">
              <el-input v-model="queryParams.antibioticsCode" placeholder="请输入检测抗生素编码" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="检测抗生素名称" prop="antibiotics">
              <el-input v-model="queryParams.antibiotics" placeholder="请输入检测抗生素名称" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="抗生素检测结果" prop="antibioResult">
              <el-input v-model="queryParams.antibioResult" placeholder="请输入抗生素检测结果" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="药敏结果" prop="sensitivityResult">
              <el-input v-model="queryParams.sensitivityResult" placeholder="请输入药敏结果" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="结果参考值" prop="resultReference">
              <el-input v-model="queryParams.resultReference" placeholder="请输入结果参考值" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="多重耐药名称" prop="mdroName">
              <el-input v-model="queryParams.mdroName" placeholder="请输入多重耐药名称" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="扩展字段1" prop="extendData1">
              <el-input v-model="queryParams.extendData1" placeholder="请输入扩展字段1" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="扩展字段2" prop="extendData2">
              <el-input v-model="queryParams.extendData2" placeholder="请输入扩展字段2" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="培养代码" prop="cultivationCode">
              <el-input v-model="queryParams.cultivationCode" placeholder="请输入培养代码" clearable @keyup.enter="handleQuery" />
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
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['natdss:natdssB17-2LabMicrobiologicalInfo:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="success" plain icon="Edit" :disabled="single" @click="handleUpdate()" v-hasPermi="['natdss:natdssB17-2LabMicrobiologicalInfo:edit']">修改</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="danger" plain icon="Delete" :disabled="multiple" @click="handleDelete()" v-hasPermi="['natdss:natdssB17-2LabMicrobiologicalInfo:remove']">删除</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['natdss:natdssB17-2LabMicrobiologicalInfo:export']">导出</el-button>
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" border :data="natdssB17-2LabMicrobiologicalInfoList" @selection-change="handleSelectionChange">
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
        <el-table-column label="微生物检验流水号" align="center" prop="labSn" />
        <el-table-column label="检验时间" align="center" prop="testDatetime" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.testDatetime, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="报告单号" align="center" prop="reportNo" />
        <el-table-column label="报告时间" align="center" prop="reportDatetime" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.reportDatetime, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="标本编号" align="center" prop="specimenCode" />
        <el-table-column label="标本来源" align="center" prop="sampleType" />
        <el-table-column label="检验方法代码" align="center" prop="testMethodCode" />
        <el-table-column label="检验方法" align="center" prop="testMethod" />
        <el-table-column label="培养结果" align="center" prop="cultivationResult" />
        <el-table-column label="结果代码" align="center" prop="resultCode" />
        <el-table-column label="结果阴阳性" align="center" prop="resultPosNeg" />
        <el-table-column label="药敏方法" align="center" prop="sensTestMethod" />
        <el-table-column label="耐药机制" align="center" prop="resisMechanism" />
        <el-table-column label="检测抗生素编码" align="center" prop="antibioticsCode" />
        <el-table-column label="检测抗生素名称" align="center" prop="antibiotics" />
        <el-table-column label="抗生素检测结果" align="center" prop="antibioResult" />
        <el-table-column label="药敏结果" align="center" prop="sensitivityResult" />
        <el-table-column label="结果参考值" align="center" prop="resultReference" />
        <el-table-column label="多重耐药名称" align="center" prop="mdroName" />
        <el-table-column label="扩展字段1" align="center" prop="extendData1" />
        <el-table-column label="扩展字段2" align="center" prop="extendData2" />
        <el-table-column label="记录状态:1正常 0作废" align="center" prop="recordStatus" />
        <el-table-column label="培养代码" align="center" prop="cultivationCode" />
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
              <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['natdss:natdssB17-2LabMicrobiologicalInfo:edit']"></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)" v-hasPermi="['natdss:natdssB17-2LabMicrobiologicalInfo:remove']"></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改B17-2 微生物检验记录对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="natdssB17-2LabMicrobiologicalInfoFormRef" :model="form" :rules="rules" label-width="80px">
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
        <el-form-item label="微生物检验流水号" prop="labSn">
          <el-input v-model="form.labSn" placeholder="请输入微生物检验流水号" />
        </el-form-item>
        <el-form-item label="检验时间" prop="testDatetime">
          <el-date-picker clearable
            v-model="form.testDatetime"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择检验时间">
          </el-date-picker>
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
        <el-form-item label="标本编号" prop="specimenCode">
          <el-input v-model="form.specimenCode" placeholder="请输入标本编号" />
        </el-form-item>
        <el-form-item label="检验方法代码" prop="testMethodCode">
          <el-input v-model="form.testMethodCode" placeholder="请输入检验方法代码" />
        </el-form-item>
        <el-form-item label="检验方法" prop="testMethod">
          <el-input v-model="form.testMethod" placeholder="请输入检验方法" />
        </el-form-item>
        <el-form-item label="培养结果" prop="cultivationResult">
          <el-input v-model="form.cultivationResult" placeholder="请输入培养结果" />
        </el-form-item>
        <el-form-item label="结果代码" prop="resultCode">
          <el-input v-model="form.resultCode" placeholder="请输入结果代码" />
        </el-form-item>
        <el-form-item label="结果阴阳性" prop="resultPosNeg">
          <el-input v-model="form.resultPosNeg" placeholder="请输入结果阴阳性" />
        </el-form-item>
        <el-form-item label="药敏方法" prop="sensTestMethod">
          <el-input v-model="form.sensTestMethod" placeholder="请输入药敏方法" />
        </el-form-item>
        <el-form-item label="耐药机制" prop="resisMechanism">
          <el-input v-model="form.resisMechanism" placeholder="请输入耐药机制" />
        </el-form-item>
        <el-form-item label="检测抗生素编码" prop="antibioticsCode">
          <el-input v-model="form.antibioticsCode" placeholder="请输入检测抗生素编码" />
        </el-form-item>
        <el-form-item label="检测抗生素名称" prop="antibiotics">
          <el-input v-model="form.antibiotics" placeholder="请输入检测抗生素名称" />
        </el-form-item>
        <el-form-item label="抗生素检测结果" prop="antibioResult">
          <el-input v-model="form.antibioResult" placeholder="请输入抗生素检测结果" />
        </el-form-item>
        <el-form-item label="药敏结果" prop="sensitivityResult">
          <el-input v-model="form.sensitivityResult" placeholder="请输入药敏结果" />
        </el-form-item>
        <el-form-item label="结果参考值" prop="resultReference">
          <el-input v-model="form.resultReference" placeholder="请输入结果参考值" />
        </el-form-item>
        <el-form-item label="多重耐药名称" prop="mdroName">
          <el-input v-model="form.mdroName" placeholder="请输入多重耐药名称" />
        </el-form-item>
        <el-form-item label="扩展字段1" prop="extendData1">
            <el-input v-model="form.extendData1" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="扩展字段2" prop="extendData2">
            <el-input v-model="form.extendData2" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="培养代码" prop="cultivationCode">
          <el-input v-model="form.cultivationCode" placeholder="请输入培养代码" />
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

<script setup name="NatdssB17-2LabMicrobiologicalInfo" lang="ts">
import { listNatdssB17-2LabMicrobiologicalInfo, getNatdssB17-2LabMicrobiologicalInfo, delNatdssB17-2LabMicrobiologicalInfo, addNatdssB17-2LabMicrobiologicalInfo, updateNatdssB17-2LabMicrobiologicalInfo } from '@/api/natdss/natdssB17-2LabMicrobiologicalInfo';
import { NatdssB17-2LabMicrobiologicalInfoVO, NatdssB17-2LabMicrobiologicalInfoQuery, NatdssB17-2LabMicrobiologicalInfoForm } from '@/api/natdss/natdssB17-2LabMicrobiologicalInfo/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const natdssB17-2LabMicrobiologicalInfoList = ref<NatdssB17-2LabMicrobiologicalInfoVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const natdssB17-2LabMicrobiologicalInfoFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: NatdssB17-2LabMicrobiologicalInfoForm = {
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
  labSn: undefined,
  testDatetime: undefined,
  reportNo: undefined,
  reportDatetime: undefined,
  specimenCode: undefined,
  sampleType: undefined,
  testMethodCode: undefined,
  testMethod: undefined,
  cultivationResult: undefined,
  resultCode: undefined,
  resultPosNeg: undefined,
  sensTestMethod: undefined,
  resisMechanism: undefined,
  antibioticsCode: undefined,
  antibiotics: undefined,
  antibioResult: undefined,
  sensitivityResult: undefined,
  resultReference: undefined,
  mdroName: undefined,
  extendData1: undefined,
  extendData2: undefined,
  recordStatus: undefined,
  cultivationCode: undefined,
  createdTime: undefined,
  updatedTime: undefined
}
const data = reactive<PageData<NatdssB17-2LabMicrobiologicalInfoForm, NatdssB17-2LabMicrobiologicalInfoQuery>>({
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
    labSn: undefined,
    testDatetime: undefined,
    reportNo: undefined,
    reportDatetime: undefined,
    specimenCode: undefined,
    sampleType: undefined,
    testMethodCode: undefined,
    testMethod: undefined,
    cultivationResult: undefined,
    resultCode: undefined,
    resultPosNeg: undefined,
    sensTestMethod: undefined,
    resisMechanism: undefined,
    antibioticsCode: undefined,
    antibiotics: undefined,
    antibioResult: undefined,
    sensitivityResult: undefined,
    resultReference: undefined,
    mdroName: undefined,
    extendData1: undefined,
    extendData2: undefined,
    recordStatus: undefined,
    cultivationCode: undefined,
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
      { required: true, message: "微生物检验流水号不能为空", trigger: "blur" }
    ],
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询B17-2 微生物检验记录列表 */
const getList = async () => {
  loading.value = true;
  const res = await listNatdssB17-2LabMicrobiologicalInfo(queryParams.value);
  natdssB17-2LabMicrobiologicalInfoList.value = res.rows;
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
  natdssB17-2LabMicrobiologicalInfoFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: NatdssB17-2LabMicrobiologicalInfoVO[]) => {
  ids.value = selection.map(item => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
}

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = "添加B17-2 微生物检验记录";
}

/** 修改按钮操作 */
const handleUpdate = async (row?: NatdssB17-2LabMicrobiologicalInfoVO) => {
  reset();
  const _id = row?.id || ids.value[0]
  const res = await getNatdssB17-2LabMicrobiologicalInfo(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = "修改B17-2 微生物检验记录";
}

/** 提交按钮 */
const submitForm = () => {
  natdssB17-2LabMicrobiologicalInfoFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateNatdssB17-2LabMicrobiologicalInfo(form.value).finally(() =>  buttonLoading.value = false);
      } else {
        await addNatdssB17-2LabMicrobiologicalInfo(form.value).finally(() =>  buttonLoading.value = false);
      }
      proxy?.$modal.msgSuccess("操作成功");
      dialog.visible = false;
      await getList();
    }
  });
}

/** 删除按钮操作 */
const handleDelete = async (row?: NatdssB17-2LabMicrobiologicalInfoVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除B17-2 微生物检验记录编号为"' + _ids + '"的数据项？').finally(() => loading.value = false);
  await delNatdssB17-2LabMicrobiologicalInfo(_ids);
  proxy?.$modal.msgSuccess("删除成功");
  await getList();
}

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download('natdss/natdssB17-2LabMicrobiologicalInfo/export', {
    ...queryParams.value
  }, `natdssB17-2LabMicrobiologicalInfo_${new Date().getTime()}.xlsx`)
}

onMounted(() => {
  getList();
});
</script>
