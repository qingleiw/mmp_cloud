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
            <el-form-item label="病理号" prop="pathologyNo">
              <el-input v-model="queryParams.pathologyNo" placeholder="请输入病理号" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="病理检查流水号" prop="pathologySn">
              <el-input v-model="queryParams.pathologySn" placeholder="请输入病理检查流水号" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="检查时间" prop="examDatetime">
              <el-date-picker clearable
                v-model="queryParams.examDatetime"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择检查时间"
              />
            </el-form-item>
            <el-form-item label="病理检查类型代码" prop="pathologyTestTypeCode">
              <el-input v-model="queryParams.pathologyTestTypeCode" placeholder="请输入病理检查类型代码" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="标本部位" prop="specimenSite">
              <el-input v-model="queryParams.specimenSite" placeholder="请输入标本部位" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="标本来源" prop="specimenObtainMethod">
              <el-input v-model="queryParams.specimenObtainMethod" placeholder="请输入标本来源" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="标本编号" prop="specimenCode">
              <el-input v-model="queryParams.specimenCode" placeholder="请输入标本编号" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="标本采集时间" prop="collectedDatetime">
              <el-date-picker clearable
                v-model="queryParams.collectedDatetime"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择标本采集时间"
              />
            </el-form-item>
            <el-form-item label="标本接收时间" prop="receivedDatetime">
              <el-date-picker clearable
                v-model="queryParams.receivedDatetime"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择标本接收时间"
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
            <el-form-item label="TNM分期版本" prop="stagingVersion">
              <el-input v-model="queryParams.stagingVersion" placeholder="请输入TNM分期版本" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="病理分期" prop="clinicalStage">
              <el-input v-model="queryParams.clinicalStage" placeholder="请输入病理分期" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="pT分期" prop="pathoTStaging">
              <el-input v-model="queryParams.pathoTStaging" placeholder="请输入pT分期" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="pN分期" prop="pathoNStaging">
              <el-input v-model="queryParams.pathoNStaging" placeholder="请输入pN分期" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="pM分期" prop="pathoMStaging">
              <el-input v-model="queryParams.pathoMStaging" placeholder="请输入pM分期" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="肉眼所见" prop="grossDescription">
              <el-input v-model="queryParams.grossDescription" placeholder="请输入肉眼所见" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="镜下所见" prop="microDescription">
              <el-input v-model="queryParams.microDescription" placeholder="请输入镜下所见" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="病理诊断结论" prop="pathoDiagConclusion">
              <el-input v-model="queryParams.pathoDiagConclusion" placeholder="请输入病理诊断结论" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="免疫组化检测结果" prop="ihcResults">
              <el-input v-model="queryParams.ihcResults" placeholder="请输入免疫组化检测结果" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="有无分子检测" prop="molTestMark">
              <el-input v-model="queryParams.molTestMark" placeholder="请输入有无分子检测" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="分子检测项目及方法" prop="molTestGeneAndMethod">
              <el-input v-model="queryParams.molTestGeneAndMethod" placeholder="请输入分子检测项目及方法" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="分子检测结果" prop="molTestResult">
              <el-input v-model="queryParams.molTestResult" placeholder="请输入分子检测结果" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="分化程度" prop="differentiationDegree">
              <el-input v-model="queryParams.differentiationDegree" placeholder="请输入分化程度" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="血管浸润" prop="bloodVesselInfil">
              <el-input v-model="queryParams.bloodVesselInfil" placeholder="请输入血管浸润" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="淋巴浸润" prop="lymphInfilt">
              <el-input v-model="queryParams.lymphInfilt" placeholder="请输入淋巴浸润" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="淋巴结转移" prop="lymphMet">
              <el-input v-model="queryParams.lymphMet" placeholder="请输入淋巴结转移" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="脉管瘤栓" prop="vascTumourThrombus">
              <el-input v-model="queryParams.vascTumourThrombus" placeholder="请输入脉管瘤栓" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="神经侵犯" prop="nerveInvasion">
              <el-input v-model="queryParams.nerveInvasion" placeholder="请输入神经侵犯" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="扩展字段1" prop="extendData1">
              <el-input v-model="queryParams.extendData1" placeholder="请输入扩展字段1" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="扩展字段2" prop="extendData2">
              <el-input v-model="queryParams.extendData2" placeholder="请输入扩展字段2" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="术中冰冻结果" prop="intraoperativeFreezingResult">
              <el-input v-model="queryParams.intraoperativeFreezingResult" placeholder="请输入术中冰冻结果" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="记录人1" prop="recorder1">
              <el-input v-model="queryParams.recorder1" placeholder="请输入记录人1" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="记录人2" prop="recorder2">
              <el-input v-model="queryParams.recorder2" placeholder="请输入记录人2" clearable @keyup.enter="handleQuery" />
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
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['natdss:natdssB16-2PathologicalExamRecord:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="success" plain icon="Edit" :disabled="single" @click="handleUpdate()" v-hasPermi="['natdss:natdssB16-2PathologicalExamRecord:edit']">修改</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="danger" plain icon="Delete" :disabled="multiple" @click="handleDelete()" v-hasPermi="['natdss:natdssB16-2PathologicalExamRecord:remove']">删除</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['natdss:natdssB16-2PathologicalExamRecord:export']">导出</el-button>
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" border :data="natdssB16-2PathologicalExamRecordList" @selection-change="handleSelectionChange">
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
        <el-table-column label="申请单号" align="center" prop="applyNo" />
        <el-table-column label="申请医嘱流水号" align="center" prop="orderSn" />
        <el-table-column label="申请时间" align="center" prop="applyDatetime" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.applyDatetime, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="病理号" align="center" prop="pathologyNo" />
        <el-table-column label="病理检查流水号" align="center" prop="pathologySn" />
        <el-table-column label="检查时间" align="center" prop="examDatetime" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.examDatetime, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="病理检查类型代码" align="center" prop="pathologyTestTypeCode" />
        <el-table-column label="病理检查类型" align="center" prop="pathologyTestType" />
        <el-table-column label="标本部位" align="center" prop="specimenSite" />
        <el-table-column label="标本来源" align="center" prop="specimenObtainMethod" />
        <el-table-column label="标本类型" align="center" prop="specimenType" />
        <el-table-column label="标本编号" align="center" prop="specimenCode" />
        <el-table-column label="标本采集时间" align="center" prop="collectedDatetime" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.collectedDatetime, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="标本接收时间" align="center" prop="receivedDatetime" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.receivedDatetime, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="报告单号" align="center" prop="reportNo" />
        <el-table-column label="报告时间" align="center" prop="reportDatetime" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.reportDatetime, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="TNM分期版本" align="center" prop="stagingVersion" />
        <el-table-column label="病理分期" align="center" prop="clinicalStage" />
        <el-table-column label="pT分期" align="center" prop="pathoTStaging" />
        <el-table-column label="pN分期" align="center" prop="pathoNStaging" />
        <el-table-column label="pM分期" align="center" prop="pathoMStaging" />
        <el-table-column label="肉眼所见" align="center" prop="grossDescription" />
        <el-table-column label="镜下所见" align="center" prop="microDescription" />
        <el-table-column label="病理诊断结论" align="center" prop="pathoDiagConclusion" />
        <el-table-column label="免疫组化检测结果" align="center" prop="ihcResults" />
        <el-table-column label="有无分子检测" align="center" prop="molTestMark" />
        <el-table-column label="分子检测项目及方法" align="center" prop="molTestGeneAndMethod" />
        <el-table-column label="分子检测结果" align="center" prop="molTestResult" />
        <el-table-column label="分化程度" align="center" prop="differentiationDegree" />
        <el-table-column label="血管浸润" align="center" prop="bloodVesselInfil" />
        <el-table-column label="淋巴浸润" align="center" prop="lymphInfilt" />
        <el-table-column label="淋巴结转移" align="center" prop="lymphMet" />
        <el-table-column label="脉管瘤栓" align="center" prop="vascTumourThrombus" />
        <el-table-column label="神经侵犯" align="center" prop="nerveInvasion" />
        <el-table-column label="扩展字段1" align="center" prop="extendData1" />
        <el-table-column label="扩展字段2" align="center" prop="extendData2" />
        <el-table-column label="记录状态:1正常 0作废" align="center" prop="recordStatus" />
        <el-table-column label="术中冰冻结果" align="center" prop="intraoperativeFreezingResult" />
        <el-table-column label="记录人1" align="center" prop="recorder1" />
        <el-table-column label="记录人2" align="center" prop="recorder2" />
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
              <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['natdss:natdssB16-2PathologicalExamRecord:edit']"></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)" v-hasPermi="['natdss:natdssB16-2PathologicalExamRecord:remove']"></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改B16-2 病理检查记录对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="natdssB16-2PathologicalExamRecordFormRef" :model="form" :rules="rules" label-width="80px">
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
        <el-form-item label="病理号" prop="pathologyNo">
          <el-input v-model="form.pathologyNo" placeholder="请输入病理号" />
        </el-form-item>
        <el-form-item label="病理检查流水号" prop="pathologySn">
          <el-input v-model="form.pathologySn" placeholder="请输入病理检查流水号" />
        </el-form-item>
        <el-form-item label="检查时间" prop="examDatetime">
          <el-date-picker clearable
            v-model="form.examDatetime"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择检查时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="病理检查类型代码" prop="pathologyTestTypeCode">
          <el-input v-model="form.pathologyTestTypeCode" placeholder="请输入病理检查类型代码" />
        </el-form-item>
        <el-form-item label="标本部位" prop="specimenSite">
          <el-input v-model="form.specimenSite" placeholder="请输入标本部位" />
        </el-form-item>
        <el-form-item label="标本来源" prop="specimenObtainMethod">
          <el-input v-model="form.specimenObtainMethod" placeholder="请输入标本来源" />
        </el-form-item>
        <el-form-item label="标本编号" prop="specimenCode">
          <el-input v-model="form.specimenCode" placeholder="请输入标本编号" />
        </el-form-item>
        <el-form-item label="标本采集时间" prop="collectedDatetime">
          <el-date-picker clearable
            v-model="form.collectedDatetime"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择标本采集时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="标本接收时间" prop="receivedDatetime">
          <el-date-picker clearable
            v-model="form.receivedDatetime"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择标本接收时间">
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
        <el-form-item label="TNM分期版本" prop="stagingVersion">
          <el-input v-model="form.stagingVersion" placeholder="请输入TNM分期版本" />
        </el-form-item>
        <el-form-item label="病理分期" prop="clinicalStage">
          <el-input v-model="form.clinicalStage" placeholder="请输入病理分期" />
        </el-form-item>
        <el-form-item label="pT分期" prop="pathoTStaging">
          <el-input v-model="form.pathoTStaging" placeholder="请输入pT分期" />
        </el-form-item>
        <el-form-item label="pN分期" prop="pathoNStaging">
          <el-input v-model="form.pathoNStaging" placeholder="请输入pN分期" />
        </el-form-item>
        <el-form-item label="pM分期" prop="pathoMStaging">
          <el-input v-model="form.pathoMStaging" placeholder="请输入pM分期" />
        </el-form-item>
        <el-form-item label="肉眼所见" prop="grossDescription">
            <el-input v-model="form.grossDescription" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="镜下所见" prop="microDescription">
            <el-input v-model="form.microDescription" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="病理诊断结论" prop="pathoDiagConclusion">
            <el-input v-model="form.pathoDiagConclusion" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="免疫组化检测结果" prop="ihcResults">
            <el-input v-model="form.ihcResults" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="有无分子检测" prop="molTestMark">
          <el-input v-model="form.molTestMark" placeholder="请输入有无分子检测" />
        </el-form-item>
        <el-form-item label="分子检测项目及方法" prop="molTestGeneAndMethod">
            <el-input v-model="form.molTestGeneAndMethod" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="分子检测结果" prop="molTestResult">
            <el-input v-model="form.molTestResult" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="分化程度" prop="differentiationDegree">
          <el-input v-model="form.differentiationDegree" placeholder="请输入分化程度" />
        </el-form-item>
        <el-form-item label="血管浸润" prop="bloodVesselInfil">
          <el-input v-model="form.bloodVesselInfil" placeholder="请输入血管浸润" />
        </el-form-item>
        <el-form-item label="淋巴浸润" prop="lymphInfilt">
          <el-input v-model="form.lymphInfilt" placeholder="请输入淋巴浸润" />
        </el-form-item>
        <el-form-item label="淋巴结转移" prop="lymphMet">
          <el-input v-model="form.lymphMet" placeholder="请输入淋巴结转移" />
        </el-form-item>
        <el-form-item label="脉管瘤栓" prop="vascTumourThrombus">
          <el-input v-model="form.vascTumourThrombus" placeholder="请输入脉管瘤栓" />
        </el-form-item>
        <el-form-item label="神经侵犯" prop="nerveInvasion">
          <el-input v-model="form.nerveInvasion" placeholder="请输入神经侵犯" />
        </el-form-item>
        <el-form-item label="扩展字段1" prop="extendData1">
            <el-input v-model="form.extendData1" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="扩展字段2" prop="extendData2">
            <el-input v-model="form.extendData2" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="术中冰冻结果" prop="intraoperativeFreezingResult">
          <el-input v-model="form.intraoperativeFreezingResult" placeholder="请输入术中冰冻结果" />
        </el-form-item>
        <el-form-item label="记录人1" prop="recorder1">
          <el-input v-model="form.recorder1" placeholder="请输入记录人1" />
        </el-form-item>
        <el-form-item label="记录人2" prop="recorder2">
          <el-input v-model="form.recorder2" placeholder="请输入记录人2" />
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

<script setup name="NatdssB16-2PathologicalExamRecord" lang="ts">
import { listNatdssB16-2PathologicalExamRecord, getNatdssB16-2PathologicalExamRecord, delNatdssB16-2PathologicalExamRecord, addNatdssB16-2PathologicalExamRecord, updateNatdssB16-2PathologicalExamRecord } from '@/api/natdss/natdssB16-2PathologicalExamRecord';
import { NatdssB16-2PathologicalExamRecordVO, NatdssB16-2PathologicalExamRecordQuery, NatdssB16-2PathologicalExamRecordForm } from '@/api/natdss/natdssB16-2PathologicalExamRecord/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const natdssB16-2PathologicalExamRecordList = ref<NatdssB16-2PathologicalExamRecordVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const natdssB16-2PathologicalExamRecordFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: NatdssB16-2PathologicalExamRecordForm = {
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
  applyNo: undefined,
  orderSn: undefined,
  applyDatetime: undefined,
  pathologyNo: undefined,
  pathologySn: undefined,
  examDatetime: undefined,
  pathologyTestTypeCode: undefined,
  pathologyTestType: undefined,
  specimenSite: undefined,
  specimenObtainMethod: undefined,
  specimenType: undefined,
  specimenCode: undefined,
  collectedDatetime: undefined,
  receivedDatetime: undefined,
  reportNo: undefined,
  reportDatetime: undefined,
  stagingVersion: undefined,
  clinicalStage: undefined,
  pathoTStaging: undefined,
  pathoNStaging: undefined,
  pathoMStaging: undefined,
  grossDescription: undefined,
  microDescription: undefined,
  pathoDiagConclusion: undefined,
  ihcResults: undefined,
  molTestMark: undefined,
  molTestGeneAndMethod: undefined,
  molTestResult: undefined,
  differentiationDegree: undefined,
  bloodVesselInfil: undefined,
  lymphInfilt: undefined,
  lymphMet: undefined,
  vascTumourThrombus: undefined,
  nerveInvasion: undefined,
  extendData1: undefined,
  extendData2: undefined,
  recordStatus: undefined,
  intraoperativeFreezingResult: undefined,
  recorder1: undefined,
  recorder2: undefined,
  createdTime: undefined,
  updatedTime: undefined
}
const data = reactive<PageData<NatdssB16-2PathologicalExamRecordForm, NatdssB16-2PathologicalExamRecordQuery>>({
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
    applyNo: undefined,
    orderSn: undefined,
    applyDatetime: undefined,
    pathologyNo: undefined,
    pathologySn: undefined,
    examDatetime: undefined,
    pathologyTestTypeCode: undefined,
    pathologyTestType: undefined,
    specimenSite: undefined,
    specimenObtainMethod: undefined,
    specimenType: undefined,
    specimenCode: undefined,
    collectedDatetime: undefined,
    receivedDatetime: undefined,
    reportNo: undefined,
    reportDatetime: undefined,
    stagingVersion: undefined,
    clinicalStage: undefined,
    pathoTStaging: undefined,
    pathoNStaging: undefined,
    pathoMStaging: undefined,
    grossDescription: undefined,
    microDescription: undefined,
    pathoDiagConclusion: undefined,
    ihcResults: undefined,
    molTestMark: undefined,
    molTestGeneAndMethod: undefined,
    molTestResult: undefined,
    differentiationDegree: undefined,
    bloodVesselInfil: undefined,
    lymphInfilt: undefined,
    lymphMet: undefined,
    vascTumourThrombus: undefined,
    nerveInvasion: undefined,
    extendData1: undefined,
    extendData2: undefined,
    recordStatus: undefined,
    intraoperativeFreezingResult: undefined,
    recorder1: undefined,
    recorder2: undefined,
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
    pathologySn: [
      { required: true, message: "病理检查流水号不能为空", trigger: "blur" }
    ],
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询B16-2 病理检查记录列表 */
const getList = async () => {
  loading.value = true;
  const res = await listNatdssB16-2PathologicalExamRecord(queryParams.value);
  natdssB16-2PathologicalExamRecordList.value = res.rows;
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
  natdssB16-2PathologicalExamRecordFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: NatdssB16-2PathologicalExamRecordVO[]) => {
  ids.value = selection.map(item => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
}

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = "添加B16-2 病理检查记录";
}

/** 修改按钮操作 */
const handleUpdate = async (row?: NatdssB16-2PathologicalExamRecordVO) => {
  reset();
  const _id = row?.id || ids.value[0]
  const res = await getNatdssB16-2PathologicalExamRecord(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = "修改B16-2 病理检查记录";
}

/** 提交按钮 */
const submitForm = () => {
  natdssB16-2PathologicalExamRecordFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateNatdssB16-2PathologicalExamRecord(form.value).finally(() =>  buttonLoading.value = false);
      } else {
        await addNatdssB16-2PathologicalExamRecord(form.value).finally(() =>  buttonLoading.value = false);
      }
      proxy?.$modal.msgSuccess("操作成功");
      dialog.visible = false;
      await getList();
    }
  });
}

/** 删除按钮操作 */
const handleDelete = async (row?: NatdssB16-2PathologicalExamRecordVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除B16-2 病理检查记录编号为"' + _ids + '"的数据项？').finally(() => loading.value = false);
  await delNatdssB16-2PathologicalExamRecord(_ids);
  proxy?.$modal.msgSuccess("删除成功");
  await getList();
}

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download('natdss/natdssB16-2PathologicalExamRecord/export', {
    ...queryParams.value
  }, `natdssB16-2PathologicalExamRecord_${new Date().getTime()}.xlsx`)
}

onMounted(() => {
  getList();
});
</script>
