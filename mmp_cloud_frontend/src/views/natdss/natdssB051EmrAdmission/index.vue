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
            <el-form-item label="病案号" prop="medicalRecordNo">
              <el-input v-model="queryParams.medicalRecordNo" placeholder="请输入病案号" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="住院号" prop="inpatientNo">
              <el-input v-model="queryParams.inpatientNo" placeholder="请输入住院号" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="住院次数" prop="hospitalizationTimes">
              <el-input v-model="queryParams.hospitalizationTimes" placeholder="请输入住院次数" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="入院记录流水号" prop="recordSn">
              <el-input v-model="queryParams.recordSn" placeholder="请输入入院记录流水号" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="入院记录创建时间" prop="recordDatetime">
              <el-date-picker clearable
                v-model="queryParams.recordDatetime"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择入院记录创建时间"
              />
            </el-form-item>
            <el-form-item label="KPS评分" prop="kpsScore">
              <el-input v-model="queryParams.kpsScore" placeholder="请输入KPS评分" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="ECOG PS评分" prop="ecogScore">
              <el-input v-model="queryParams.ecogScore" placeholder="请输入ECOG PS评分" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="文书内容" prop="recordText">
              <el-input v-model="queryParams.recordText" placeholder="请输入文书内容" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主诉" prop="chiefComplaint">
              <el-input v-model="queryParams.chiefComplaint" placeholder="请输入主诉" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="现病史" prop="currentMedhistory">
              <el-input v-model="queryParams.currentMedhistory" placeholder="请输入现病史" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="既往史" prop="pastMedhistory">
              <el-input v-model="queryParams.pastMedhistory" placeholder="请输入既往史" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="个人史" prop="personalMedhistory">
              <el-input v-model="queryParams.personalMedhistory" placeholder="请输入个人史" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="家族史" prop="familyHistory">
              <el-input v-model="queryParams.familyHistory" placeholder="请输入家族史" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="婚育史" prop="marriageBirthHistory">
              <el-input v-model="queryParams.marriageBirthHistory" placeholder="请输入婚育史" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="月经史" prop="menstrualHistory">
              <el-input v-model="queryParams.menstrualHistory" placeholder="请输入月经史" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="收缩压(mmHg)" prop="systolicPressure">
              <el-input v-model="queryParams.systolicPressure" placeholder="请输入收缩压(mmHg)" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="舒张压(mmHg)" prop="diastolicPressure">
              <el-input v-model="queryParams.diastolicPressure" placeholder="请输入舒张压(mmHg)" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="呼吸(次/分)" prop="respiratoryRate">
              <el-input v-model="queryParams.respiratoryRate" placeholder="请输入呼吸(次/分)" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="体温(℃)" prop="bodyTemperature">
              <el-input v-model="queryParams.bodyTemperature" placeholder="请输入体温(℃)" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="心率(次/分)" prop="heartRate">
              <el-input v-model="queryParams.heartRate" placeholder="请输入心率(次/分)" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="身高(cm)" prop="height">
              <el-input v-model="queryParams.height" placeholder="请输入身高(cm)" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="体重(kg)" prop="weight">
              <el-input v-model="queryParams.weight" placeholder="请输入体重(kg)" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="体表面积(m²)" prop="bodySurfaceArea">
              <el-input v-model="queryParams.bodySurfaceArea" placeholder="请输入体表面积(m²)" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="体格检查" prop="physicalExam">
              <el-input v-model="queryParams.physicalExam" placeholder="请输入体格检查" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="专科检查" prop="specialExam">
              <el-input v-model="queryParams.specialExam" placeholder="请输入专科检查" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="辅助检查" prop="auxiliaryExam">
              <el-input v-model="queryParams.auxiliaryExam" placeholder="请输入辅助检查" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="入院主要诊断编码" prop="admissionMaindiagCode1">
              <el-input v-model="queryParams.admissionMaindiagCode1" placeholder="请输入入院主要诊断编码" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="入院主要诊断名称" prop="admissionMaindiagName1">
              <el-input v-model="queryParams.admissionMaindiagName1" placeholder="请输入入院主要诊断名称" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="入院诊断编码-2" prop="admissionDiagCode2">
              <el-input v-model="queryParams.admissionDiagCode2" placeholder="请输入入院诊断编码-2" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="入院诊断名称-2" prop="admissionDiagName2">
              <el-input v-model="queryParams.admissionDiagName2" placeholder="请输入入院诊断名称-2" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="入院诊断编码-3" prop="admissionDiagCode3">
              <el-input v-model="queryParams.admissionDiagCode3" placeholder="请输入入院诊断编码-3" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="入院诊断名称-3" prop="admissionDiagName3">
              <el-input v-model="queryParams.admissionDiagName3" placeholder="请输入入院诊断名称-3" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="入院诊断编码-4" prop="admissionDiagCode4">
              <el-input v-model="queryParams.admissionDiagCode4" placeholder="请输入入院诊断编码-4" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="入院诊断名称-4" prop="admissionDiagName4">
              <el-input v-model="queryParams.admissionDiagName4" placeholder="请输入入院诊断名称-4" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="入院诊断编码-5" prop="admissionDiagCode5">
              <el-input v-model="queryParams.admissionDiagCode5" placeholder="请输入入院诊断编码-5" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="入院诊断名称-5" prop="admissionDiagName5">
              <el-input v-model="queryParams.admissionDiagName5" placeholder="请输入入院诊断名称-5" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="入院诊断编码-N" prop="admissionDiagCoden">
              <el-input v-model="queryParams.admissionDiagCoden" placeholder="请输入入院诊断编码-N" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="入院诊断名称-N" prop="admissionDiagNamen">
              <el-input v-model="queryParams.admissionDiagNamen" placeholder="请输入入院诊断名称-N" clearable @keyup.enter="handleQuery" />
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
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['natdss:natdssB051EmrAdmission:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="success" plain icon="Edit" :disabled="single" @click="handleUpdate()" v-hasPermi="['natdss:natdssB051EmrAdmission:edit']">修改</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="danger" plain icon="Delete" :disabled="multiple" @click="handleDelete()" v-hasPermi="['natdss:natdssB051EmrAdmission:remove']">删除</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['natdss:natdssB051EmrAdmission:export']">导出</el-button>
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" border :data="natdssB051EmrAdmissionList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="系统自增主键" align="center" prop="id" v-if="true" />
        <el-table-column label="患者ID" align="center" prop="patientId" />
        <el-table-column label="单次就诊唯一标识号" align="center" prop="visitSn" />
        <el-table-column label="病案号" align="center" prop="medicalRecordNo" />
        <el-table-column label="住院号" align="center" prop="inpatientNo" />
        <el-table-column label="住院次数" align="center" prop="hospitalizationTimes" />
        <el-table-column label="入院记录流水号" align="center" prop="recordSn" />
        <el-table-column label="入院记录创建时间" align="center" prop="recordDatetime" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.recordDatetime, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="KPS评分" align="center" prop="kpsScore" />
        <el-table-column label="ECOG PS评分" align="center" prop="ecogScore" />
        <el-table-column label="文书内容" align="center" prop="recordText" />
        <el-table-column label="主诉" align="center" prop="chiefComplaint" />
        <el-table-column label="现病史" align="center" prop="currentMedhistory" />
        <el-table-column label="既往史" align="center" prop="pastMedhistory" />
        <el-table-column label="个人史" align="center" prop="personalMedhistory" />
        <el-table-column label="家族史" align="center" prop="familyHistory" />
        <el-table-column label="婚育史" align="center" prop="marriageBirthHistory" />
        <el-table-column label="月经史" align="center" prop="menstrualHistory" />
        <el-table-column label="收缩压(mmHg)" align="center" prop="systolicPressure" />
        <el-table-column label="舒张压(mmHg)" align="center" prop="diastolicPressure" />
        <el-table-column label="呼吸(次/分)" align="center" prop="respiratoryRate" />
        <el-table-column label="体温(℃)" align="center" prop="bodyTemperature" />
        <el-table-column label="心率(次/分)" align="center" prop="heartRate" />
        <el-table-column label="身高(cm)" align="center" prop="height" />
        <el-table-column label="体重(kg)" align="center" prop="weight" />
        <el-table-column label="体表面积(m²)" align="center" prop="bodySurfaceArea" />
        <el-table-column label="体格检查" align="center" prop="physicalExam" />
        <el-table-column label="专科检查" align="center" prop="specialExam" />
        <el-table-column label="辅助检查" align="center" prop="auxiliaryExam" />
        <el-table-column label="入院主要诊断编码" align="center" prop="admissionMaindiagCode1" />
        <el-table-column label="入院主要诊断名称" align="center" prop="admissionMaindiagName1" />
        <el-table-column label="入院诊断编码-2" align="center" prop="admissionDiagCode2" />
        <el-table-column label="入院诊断名称-2" align="center" prop="admissionDiagName2" />
        <el-table-column label="入院诊断编码-3" align="center" prop="admissionDiagCode3" />
        <el-table-column label="入院诊断名称-3" align="center" prop="admissionDiagName3" />
        <el-table-column label="入院诊断编码-4" align="center" prop="admissionDiagCode4" />
        <el-table-column label="入院诊断名称-4" align="center" prop="admissionDiagName4" />
        <el-table-column label="入院诊断编码-5" align="center" prop="admissionDiagCode5" />
        <el-table-column label="入院诊断名称-5" align="center" prop="admissionDiagName5" />
        <el-table-column label="入院诊断编码-N" align="center" prop="admissionDiagCoden" />
        <el-table-column label="入院诊断名称-N" align="center" prop="admissionDiagNamen" />
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
              <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['natdss:natdssB051EmrAdmission:edit']"></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)" v-hasPermi="['natdss:natdssB051EmrAdmission:remove']"></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改B05-1 入院记录对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="natdssB051EmrAdmissionFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="患者ID" prop="patientId">
          <el-input v-model="form.patientId" placeholder="请输入患者ID" />
        </el-form-item>
        <el-form-item label="单次就诊唯一标识号" prop="visitSn">
          <el-input v-model="form.visitSn" placeholder="请输入单次就诊唯一标识号" />
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
        <el-form-item label="入院记录流水号" prop="recordSn">
          <el-input v-model="form.recordSn" placeholder="请输入入院记录流水号" />
        </el-form-item>
        <el-form-item label="入院记录创建时间" prop="recordDatetime">
          <el-date-picker clearable
            v-model="form.recordDatetime"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择入院记录创建时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="KPS评分" prop="kpsScore">
          <el-input v-model="form.kpsScore" placeholder="请输入KPS评分" />
        </el-form-item>
        <el-form-item label="ECOG PS评分" prop="ecogScore">
          <el-input v-model="form.ecogScore" placeholder="请输入ECOG PS评分" />
        </el-form-item>
        <el-form-item label="文书内容" prop="recordText">
            <el-input v-model="form.recordText" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="主诉" prop="chiefComplaint">
            <el-input v-model="form.chiefComplaint" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="现病史" prop="currentMedhistory">
            <el-input v-model="form.currentMedhistory" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="既往史" prop="pastMedhistory">
            <el-input v-model="form.pastMedhistory" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="个人史" prop="personalMedhistory">
            <el-input v-model="form.personalMedhistory" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="家族史" prop="familyHistory">
            <el-input v-model="form.familyHistory" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="婚育史" prop="marriageBirthHistory">
            <el-input v-model="form.marriageBirthHistory" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="月经史" prop="menstrualHistory">
            <el-input v-model="form.menstrualHistory" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="收缩压(mmHg)" prop="systolicPressure">
          <el-input v-model="form.systolicPressure" placeholder="请输入收缩压(mmHg)" />
        </el-form-item>
        <el-form-item label="舒张压(mmHg)" prop="diastolicPressure">
          <el-input v-model="form.diastolicPressure" placeholder="请输入舒张压(mmHg)" />
        </el-form-item>
        <el-form-item label="呼吸(次/分)" prop="respiratoryRate">
          <el-input v-model="form.respiratoryRate" placeholder="请输入呼吸(次/分)" />
        </el-form-item>
        <el-form-item label="体温(℃)" prop="bodyTemperature">
          <el-input v-model="form.bodyTemperature" placeholder="请输入体温(℃)" />
        </el-form-item>
        <el-form-item label="心率(次/分)" prop="heartRate">
          <el-input v-model="form.heartRate" placeholder="请输入心率(次/分)" />
        </el-form-item>
        <el-form-item label="身高(cm)" prop="height">
          <el-input v-model="form.height" placeholder="请输入身高(cm)" />
        </el-form-item>
        <el-form-item label="体重(kg)" prop="weight">
          <el-input v-model="form.weight" placeholder="请输入体重(kg)" />
        </el-form-item>
        <el-form-item label="体表面积(m²)" prop="bodySurfaceArea">
          <el-input v-model="form.bodySurfaceArea" placeholder="请输入体表面积(m²)" />
        </el-form-item>
        <el-form-item label="体格检查" prop="physicalExam">
            <el-input v-model="form.physicalExam" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="专科检查" prop="specialExam">
            <el-input v-model="form.specialExam" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="辅助检查" prop="auxiliaryExam">
            <el-input v-model="form.auxiliaryExam" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="入院主要诊断编码" prop="admissionMaindiagCode1">
          <el-input v-model="form.admissionMaindiagCode1" placeholder="请输入入院主要诊断编码" />
        </el-form-item>
        <el-form-item label="入院主要诊断名称" prop="admissionMaindiagName1">
          <el-input v-model="form.admissionMaindiagName1" placeholder="请输入入院主要诊断名称" />
        </el-form-item>
        <el-form-item label="入院诊断编码-2" prop="admissionDiagCode2">
          <el-input v-model="form.admissionDiagCode2" placeholder="请输入入院诊断编码-2" />
        </el-form-item>
        <el-form-item label="入院诊断名称-2" prop="admissionDiagName2">
          <el-input v-model="form.admissionDiagName2" placeholder="请输入入院诊断名称-2" />
        </el-form-item>
        <el-form-item label="入院诊断编码-3" prop="admissionDiagCode3">
          <el-input v-model="form.admissionDiagCode3" placeholder="请输入入院诊断编码-3" />
        </el-form-item>
        <el-form-item label="入院诊断名称-3" prop="admissionDiagName3">
          <el-input v-model="form.admissionDiagName3" placeholder="请输入入院诊断名称-3" />
        </el-form-item>
        <el-form-item label="入院诊断编码-4" prop="admissionDiagCode4">
          <el-input v-model="form.admissionDiagCode4" placeholder="请输入入院诊断编码-4" />
        </el-form-item>
        <el-form-item label="入院诊断名称-4" prop="admissionDiagName4">
          <el-input v-model="form.admissionDiagName4" placeholder="请输入入院诊断名称-4" />
        </el-form-item>
        <el-form-item label="入院诊断编码-5" prop="admissionDiagCode5">
          <el-input v-model="form.admissionDiagCode5" placeholder="请输入入院诊断编码-5" />
        </el-form-item>
        <el-form-item label="入院诊断名称-5" prop="admissionDiagName5">
          <el-input v-model="form.admissionDiagName5" placeholder="请输入入院诊断名称-5" />
        </el-form-item>
        <el-form-item label="入院诊断编码-N" prop="admissionDiagCoden">
            <el-input v-model="form.admissionDiagCoden" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="入院诊断名称-N" prop="admissionDiagNamen">
            <el-input v-model="form.admissionDiagNamen" type="textarea" placeholder="请输入内容" />
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

<script setup name="NatdssB051EmrAdmission" lang="ts">
import { listNatdssB051EmrAdmission, getNatdssB051EmrAdmission, delNatdssB051EmrAdmission, addNatdssB051EmrAdmission, updateNatdssB051EmrAdmission } from '@/api/natdss/natdssB051EmrAdmission';
import { NatdssB051EmrAdmissionVO, NatdssB051EmrAdmissionQuery, NatdssB051EmrAdmissionForm } from '@/api/natdss/natdssB051EmrAdmission/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const natdssB051EmrAdmissionList = ref<NatdssB051EmrAdmissionVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const natdssB051EmrAdmissionFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: NatdssB051EmrAdmissionForm = {
  id: undefined,
  patientId: undefined,
  visitSn: undefined,
  medicalRecordNo: undefined,
  inpatientNo: undefined,
  hospitalizationTimes: undefined,
  recordSn: undefined,
  recordDatetime: undefined,
  kpsScore: undefined,
  ecogScore: undefined,
  recordText: undefined,
  chiefComplaint: undefined,
  currentMedhistory: undefined,
  pastMedhistory: undefined,
  personalMedhistory: undefined,
  familyHistory: undefined,
  marriageBirthHistory: undefined,
  menstrualHistory: undefined,
  systolicPressure: undefined,
  diastolicPressure: undefined,
  respiratoryRate: undefined,
  bodyTemperature: undefined,
  heartRate: undefined,
  height: undefined,
  weight: undefined,
  bodySurfaceArea: undefined,
  physicalExam: undefined,
  specialExam: undefined,
  auxiliaryExam: undefined,
  admissionMaindiagCode1: undefined,
  admissionMaindiagName1: undefined,
  admissionDiagCode2: undefined,
  admissionDiagName2: undefined,
  admissionDiagCode3: undefined,
  admissionDiagName3: undefined,
  admissionDiagCode4: undefined,
  admissionDiagName4: undefined,
  admissionDiagCode5: undefined,
  admissionDiagName5: undefined,
  admissionDiagCoden: undefined,
  admissionDiagNamen: undefined,
  extendData1: undefined,
  extendData2: undefined,
  recordStatus: undefined,
  createdTime: undefined,
  updatedTime: undefined
}
const data = reactive<PageData<NatdssB051EmrAdmissionForm, NatdssB051EmrAdmissionQuery>>({
  form: {...initFormData},
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    patientId: undefined,
    visitSn: undefined,
    medicalRecordNo: undefined,
    inpatientNo: undefined,
    hospitalizationTimes: undefined,
    recordSn: undefined,
    recordDatetime: undefined,
    kpsScore: undefined,
    ecogScore: undefined,
    recordText: undefined,
    chiefComplaint: undefined,
    currentMedhistory: undefined,
    pastMedhistory: undefined,
    personalMedhistory: undefined,
    familyHistory: undefined,
    marriageBirthHistory: undefined,
    menstrualHistory: undefined,
    systolicPressure: undefined,
    diastolicPressure: undefined,
    respiratoryRate: undefined,
    bodyTemperature: undefined,
    heartRate: undefined,
    height: undefined,
    weight: undefined,
    bodySurfaceArea: undefined,
    physicalExam: undefined,
    specialExam: undefined,
    auxiliaryExam: undefined,
    admissionMaindiagCode1: undefined,
    admissionMaindiagName1: undefined,
    admissionDiagCode2: undefined,
    admissionDiagName2: undefined,
    admissionDiagCode3: undefined,
    admissionDiagName3: undefined,
    admissionDiagCode4: undefined,
    admissionDiagName4: undefined,
    admissionDiagCode5: undefined,
    admissionDiagName5: undefined,
    admissionDiagCoden: undefined,
    admissionDiagNamen: undefined,
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
    recordSn: [
      { required: true, message: "入院记录流水号不能为空", trigger: "blur" }
    ],
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询B05-1 入院记录列表 */
const getList = async () => {
  loading.value = true;
  const res = await listNatdssB051EmrAdmission(queryParams.value);
  natdssB051EmrAdmissionList.value = res.rows;
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
  natdssB051EmrAdmissionFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: NatdssB051EmrAdmissionVO[]) => {
  ids.value = selection.map(item => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
}

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = "添加B05-1 入院记录";
}

/** 修改按钮操作 */
const handleUpdate = async (row?: NatdssB051EmrAdmissionVO) => {
  reset();
  const _id = row?.id || ids.value[0]
  const res = await getNatdssB051EmrAdmission(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = "修改B05-1 入院记录";
}

/** 提交按钮 */
const submitForm = () => {
  natdssB051EmrAdmissionFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateNatdssB051EmrAdmission(form.value).finally(() =>  buttonLoading.value = false);
      } else {
        await addNatdssB051EmrAdmission(form.value).finally(() =>  buttonLoading.value = false);
      }
      proxy?.$modal.msgSuccess("操作成功");
      dialog.visible = false;
      await getList();
    }
  });
}

/** 删除按钮操作 */
const handleDelete = async (row?: NatdssB051EmrAdmissionVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除B05-1 入院记录编号为"' + _ids + '"的数据项？').finally(() => loading.value = false);
  await delNatdssB051EmrAdmission(_ids);
  proxy?.$modal.msgSuccess("删除成功");
  await getList();
}

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download('natdss/natdssB051EmrAdmission/export', {
    ...queryParams.value
  }, `natdssB051EmrAdmission_${new Date().getTime()}.xlsx`)
}

onMounted(() => {
  getList();
});
</script>
