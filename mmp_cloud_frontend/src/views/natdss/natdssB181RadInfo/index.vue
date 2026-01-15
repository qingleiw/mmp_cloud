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
            <el-form-item label="性别" prop="gender">
              <el-input v-model="queryParams.gender" placeholder="请输入性别" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="年龄(岁)" prop="age">
              <el-input v-model="queryParams.age" placeholder="请输入年龄(岁)" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出生日期" prop="dateOfBirth">
              <el-date-picker clearable
                v-model="queryParams.dateOfBirth"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择出生日期"
              />
            </el-form-item>
            <el-form-item label="放疗流水号" prop="radioSn">
              <el-input v-model="queryParams.radioSn" placeholder="请输入放疗流水号" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="疗程号" prop="courseSn">
              <el-input v-model="queryParams.courseSn" placeholder="请输入疗程号" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="放疗开始日期" prop="radioStartTime">
              <el-date-picker clearable
                v-model="queryParams.radioStartTime"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择放疗开始日期"
              />
            </el-form-item>
            <el-form-item label="放疗结束日期" prop="radioEndTime">
              <el-date-picker clearable
                v-model="queryParams.radioEndTime"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择放疗结束日期"
              />
            </el-form-item>
            <el-form-item label="放疗技术" prop="radioTech">
              <el-input v-model="queryParams.radioTech" placeholder="请输入放疗技术" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="放疗部位" prop="radioSite">
              <el-input v-model="queryParams.radioSite" placeholder="请输入放疗部位" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="靶区部位" prop="targetVolume">
              <el-input v-model="queryParams.targetVolume" placeholder="请输入靶区部位" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="处方天数" prop="presDays">
              <el-input v-model="queryParams.presDays" placeholder="请输入处方天数" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="处方总剂量" prop="presTotalDose">
              <el-input v-model="queryParams.presTotalDose" placeholder="请输入处方总剂量" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="处方放疗次数" prop="presRadioCount">
              <el-input v-model="queryParams.presRadioCount" placeholder="请输入处方放疗次数" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="处方分次剂量" prop="radioSingleDose">
              <el-input v-model="queryParams.radioSingleDose" placeholder="请输入处方分次剂量" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="是否同步化疗" prop="synChemoMark">
              <el-input v-model="queryParams.synChemoMark" placeholder="请输入是否同步化疗" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="同步化疗方案" prop="synChemoScheme">
              <el-input v-model="queryParams.synChemoScheme" placeholder="请输入同步化疗方案" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="是否同步其他药物治疗" prop="synOtherSchemeMark">
              <el-input v-model="queryParams.synOtherSchemeMark" placeholder="请输入是否同步其他药物治疗" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他同步治疗方案" prop="synOtherScheme">
              <el-input v-model="queryParams.synOtherScheme" placeholder="请输入其他同步治疗方案" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="疗效评价日期" prop="effectEvalTime">
              <el-date-picker clearable
                v-model="queryParams.effectEvalTime"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择疗效评价日期"
              />
            </el-form-item>
            <el-form-item label="疗效评价" prop="effectEval">
              <el-input v-model="queryParams.effectEval" placeholder="请输入疗效评价" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="不良反应" prop="adverseDrugReaction">
              <el-input v-model="queryParams.adverseDrugReaction" placeholder="请输入不良反应" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="扩展字段1" prop="extendData1">
              <el-input v-model="queryParams.extendData1" placeholder="请输入扩展字段1" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="扩展字段2" prop="extendData2">
              <el-input v-model="queryParams.extendData2" placeholder="请输入扩展字段2" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="治疗目的" prop="therapeuticPurposes">
              <el-input v-model="queryParams.therapeuticPurposes" placeholder="请输入治疗目的" clearable @keyup.enter="handleQuery" />
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
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['natdss:natdssB181RadInfo:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="success" plain icon="Edit" :disabled="single" @click="handleUpdate()" v-hasPermi="['natdss:natdssB181RadInfo:edit']">修改</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="danger" plain icon="Delete" :disabled="multiple" @click="handleDelete()" v-hasPermi="['natdss:natdssB181RadInfo:remove']">删除</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['natdss:natdssB181RadInfo:export']">导出</el-button>
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" border :data="natdssB181RadInfoList" @selection-change="handleSelectionChange">
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
        <el-table-column label="性别" align="center" prop="gender" />
        <el-table-column label="年龄(岁)" align="center" prop="age" />
        <el-table-column label="出生日期" align="center" prop="dateOfBirth" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.dateOfBirth, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="放疗流水号" align="center" prop="radioSn" />
        <el-table-column label="疗程号" align="center" prop="courseSn" />
        <el-table-column label="放疗开始日期" align="center" prop="radioStartTime" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.radioStartTime, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="放疗结束日期" align="center" prop="radioEndTime" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.radioEndTime, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="放疗技术" align="center" prop="radioTech" />
        <el-table-column label="放疗部位" align="center" prop="radioSite" />
        <el-table-column label="靶区部位" align="center" prop="targetVolume" />
        <el-table-column label="处方天数" align="center" prop="presDays" />
        <el-table-column label="处方总剂量" align="center" prop="presTotalDose" />
        <el-table-column label="处方放疗次数" align="center" prop="presRadioCount" />
        <el-table-column label="处方分次剂量" align="center" prop="radioSingleDose" />
        <el-table-column label="是否同步化疗" align="center" prop="synChemoMark" />
        <el-table-column label="同步化疗方案" align="center" prop="synChemoScheme" />
        <el-table-column label="是否同步其他药物治疗" align="center" prop="synOtherSchemeMark" />
        <el-table-column label="其他同步治疗方案" align="center" prop="synOtherScheme" />
        <el-table-column label="疗效评价日期" align="center" prop="effectEvalTime" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.effectEvalTime, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="疗效评价" align="center" prop="effectEval" />
        <el-table-column label="不良反应" align="center" prop="adverseDrugReaction" />
        <el-table-column label="扩展字段1" align="center" prop="extendData1" />
        <el-table-column label="扩展字段2" align="center" prop="extendData2" />
        <el-table-column label="记录状态:1正常 0作废" align="center" prop="recordStatus" />
        <el-table-column label="治疗目的" align="center" prop="therapeuticPurposes" />
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
              <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['natdss:natdssB181RadInfo:edit']"></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)" v-hasPermi="['natdss:natdssB181RadInfo:remove']"></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改B18-1 临床放疗记录对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="natdssB181RadInfoFormRef" :model="form" :rules="rules" label-width="80px">
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
        <el-form-item label="性别" prop="gender">
          <el-input v-model="form.gender" placeholder="请输入性别" />
        </el-form-item>
        <el-form-item label="年龄(岁)" prop="age">
          <el-input v-model="form.age" placeholder="请输入年龄(岁)" />
        </el-form-item>
        <el-form-item label="出生日期" prop="dateOfBirth">
          <el-date-picker clearable
            v-model="form.dateOfBirth"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择出生日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="放疗流水号" prop="radioSn">
          <el-input v-model="form.radioSn" placeholder="请输入放疗流水号" />
        </el-form-item>
        <el-form-item label="疗程号" prop="courseSn">
          <el-input v-model="form.courseSn" placeholder="请输入疗程号" />
        </el-form-item>
        <el-form-item label="放疗开始日期" prop="radioStartTime">
          <el-date-picker clearable
            v-model="form.radioStartTime"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择放疗开始日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="放疗结束日期" prop="radioEndTime">
          <el-date-picker clearable
            v-model="form.radioEndTime"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择放疗结束日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="放疗技术" prop="radioTech">
          <el-input v-model="form.radioTech" placeholder="请输入放疗技术" />
        </el-form-item>
        <el-form-item label="放疗部位" prop="radioSite">
          <el-input v-model="form.radioSite" placeholder="请输入放疗部位" />
        </el-form-item>
        <el-form-item label="靶区部位" prop="targetVolume">
          <el-input v-model="form.targetVolume" placeholder="请输入靶区部位" />
        </el-form-item>
        <el-form-item label="处方天数" prop="presDays">
          <el-input v-model="form.presDays" placeholder="请输入处方天数" />
        </el-form-item>
        <el-form-item label="处方总剂量" prop="presTotalDose">
          <el-input v-model="form.presTotalDose" placeholder="请输入处方总剂量" />
        </el-form-item>
        <el-form-item label="处方放疗次数" prop="presRadioCount">
          <el-input v-model="form.presRadioCount" placeholder="请输入处方放疗次数" />
        </el-form-item>
        <el-form-item label="处方分次剂量" prop="radioSingleDose">
          <el-input v-model="form.radioSingleDose" placeholder="请输入处方分次剂量" />
        </el-form-item>
        <el-form-item label="是否同步化疗" prop="synChemoMark">
          <el-input v-model="form.synChemoMark" placeholder="请输入是否同步化疗" />
        </el-form-item>
        <el-form-item label="同步化疗方案" prop="synChemoScheme">
          <el-input v-model="form.synChemoScheme" placeholder="请输入同步化疗方案" />
        </el-form-item>
        <el-form-item label="是否同步其他药物治疗" prop="synOtherSchemeMark">
          <el-input v-model="form.synOtherSchemeMark" placeholder="请输入是否同步其他药物治疗" />
        </el-form-item>
        <el-form-item label="其他同步治疗方案" prop="synOtherScheme">
          <el-input v-model="form.synOtherScheme" placeholder="请输入其他同步治疗方案" />
        </el-form-item>
        <el-form-item label="疗效评价日期" prop="effectEvalTime">
          <el-date-picker clearable
            v-model="form.effectEvalTime"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择疗效评价日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="疗效评价" prop="effectEval">
            <el-input v-model="form.effectEval" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="不良反应" prop="adverseDrugReaction">
            <el-input v-model="form.adverseDrugReaction" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="扩展字段1" prop="extendData1">
            <el-input v-model="form.extendData1" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="扩展字段2" prop="extendData2">
            <el-input v-model="form.extendData2" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="治疗目的" prop="therapeuticPurposes">
          <el-input v-model="form.therapeuticPurposes" placeholder="请输入治疗目的" />
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

<script setup name="NatdssB181RadInfo" lang="ts">
import { listNatdssB181RadInfo, getNatdssB181RadInfo, delNatdssB181RadInfo, addNatdssB181RadInfo, updateNatdssB181RadInfo } from '@/api/natdss/natdssB181RadInfo';
import { NatdssB181RadInfoVO, NatdssB181RadInfoQuery, NatdssB181RadInfoForm } from '@/api/natdss/natdssB181RadInfo/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const natdssB181RadInfoList = ref<NatdssB181RadInfoVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const natdssB181RadInfoFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: NatdssB181RadInfoForm = {
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
  gender: undefined,
  age: undefined,
  dateOfBirth: undefined,
  radioSn: undefined,
  courseSn: undefined,
  radioStartTime: undefined,
  radioEndTime: undefined,
  radioTech: undefined,
  radioSite: undefined,
  targetVolume: undefined,
  presDays: undefined,
  presTotalDose: undefined,
  presRadioCount: undefined,
  radioSingleDose: undefined,
  synChemoMark: undefined,
  synChemoScheme: undefined,
  synOtherSchemeMark: undefined,
  synOtherScheme: undefined,
  effectEvalTime: undefined,
  effectEval: undefined,
  adverseDrugReaction: undefined,
  extendData1: undefined,
  extendData2: undefined,
  recordStatus: undefined,
  therapeuticPurposes: undefined,
  createdTime: undefined,
  updatedTime: undefined
}
const data = reactive<PageData<NatdssB181RadInfoForm, NatdssB181RadInfoQuery>>({
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
    gender: undefined,
    age: undefined,
    dateOfBirth: undefined,
    radioSn: undefined,
    courseSn: undefined,
    radioStartTime: undefined,
    radioEndTime: undefined,
    radioTech: undefined,
    radioSite: undefined,
    targetVolume: undefined,
    presDays: undefined,
    presTotalDose: undefined,
    presRadioCount: undefined,
    radioSingleDose: undefined,
    synChemoMark: undefined,
    synChemoScheme: undefined,
    synOtherSchemeMark: undefined,
    synOtherScheme: undefined,
    effectEvalTime: undefined,
    effectEval: undefined,
    adverseDrugReaction: undefined,
    extendData1: undefined,
    extendData2: undefined,
    recordStatus: undefined,
    therapeuticPurposes: undefined,
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
    radioSn: [
      { required: true, message: "放疗流水号不能为空", trigger: "blur" }
    ],
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询B18-1 临床放疗记录列表 */
const getList = async () => {
  loading.value = true;
  const res = await listNatdssB181RadInfo(queryParams.value);
  natdssB181RadInfoList.value = res.rows;
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
  natdssB181RadInfoFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: NatdssB181RadInfoVO[]) => {
  ids.value = selection.map(item => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
}

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = "添加B18-1 临床放疗记录";
}

/** 修改按钮操作 */
const handleUpdate = async (row?: NatdssB181RadInfoVO) => {
  reset();
  const _id = row?.id || ids.value[0]
  const res = await getNatdssB181RadInfo(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = "修改B18-1 临床放疗记录";
}

/** 提交按钮 */
const submitForm = () => {
  natdssB181RadInfoFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateNatdssB181RadInfo(form.value).finally(() =>  buttonLoading.value = false);
      } else {
        await addNatdssB181RadInfo(form.value).finally(() =>  buttonLoading.value = false);
      }
      proxy?.$modal.msgSuccess("操作成功");
      dialog.visible = false;
      await getList();
    }
  });
}

/** 删除按钮操作 */
const handleDelete = async (row?: NatdssB181RadInfoVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除B18-1 临床放疗记录编号为"' + _ids + '"的数据项？').finally(() => loading.value = false);
  await delNatdssB181RadInfo(_ids);
  proxy?.$modal.msgSuccess("删除成功");
  await getList();
}

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download('natdss/natdssB181RadInfo/export', {
    ...queryParams.value
  }, `natdssB181RadInfo_${new Date().getTime()}.xlsx`)
}

onMounted(() => {
  getList();
});
</script>
