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
            <el-form-item label="出院记录流水号" prop="recordSn">
              <el-input v-model="queryParams.recordSn" placeholder="请输入出院记录流水号" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院记录创建时间" prop="recordDatetime">
              <el-date-picker clearable
                v-model="queryParams.recordDatetime"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择出院记录创建时间"
              />
            </el-form-item>
            <el-form-item label="入院时间" prop="admissionDatetime">
              <el-date-picker clearable
                v-model="queryParams.admissionDatetime"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择入院时间"
              />
            </el-form-item>
            <el-form-item label="出院医嘱" prop="dischargeOrder">
              <el-input v-model="queryParams.dischargeOrder" placeholder="请输入出院医嘱" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院时间" prop="dischargeDatetime">
              <el-date-picker clearable
                v-model="queryParams.dischargeDatetime"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择出院时间"
              />
            </el-form-item>
            <el-form-item label="实际住院天数" prop="lengthOfStay">
              <el-input v-model="queryParams.lengthOfStay" placeholder="请输入实际住院天数" clearable @keyup.enter="handleQuery" />
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
            <el-form-item label="入院情况" prop="admissionCondition">
              <el-input v-model="queryParams.admissionCondition" placeholder="请输入入院情况" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="诊疗经过" prop="treatmentInfo">
              <el-input v-model="queryParams.treatmentInfo" placeholder="请输入诊疗经过" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院情况" prop="dischargeCondition">
              <el-input v-model="queryParams.dischargeCondition" placeholder="请输入出院情况" clearable @keyup.enter="handleQuery" />
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
            <el-form-item label="出院主要诊断编码" prop="dischargeMaindiagCode1">
              <el-input v-model="queryParams.dischargeMaindiagCode1" placeholder="请输入出院主要诊断编码" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院主要诊断名称" prop="dischargeMaindiagName1">
              <el-input v-model="queryParams.dischargeMaindiagName1" placeholder="请输入出院主要诊断名称" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院诊断编码-2" prop="dischargeDiagCode2">
              <el-input v-model="queryParams.dischargeDiagCode2" placeholder="请输入出院诊断编码-2" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院诊断名称-2" prop="dischargeDiagName2">
              <el-input v-model="queryParams.dischargeDiagName2" placeholder="请输入出院诊断名称-2" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院诊断编码-3" prop="dischargeDiagCode3">
              <el-input v-model="queryParams.dischargeDiagCode3" placeholder="请输入出院诊断编码-3" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院诊断名称-3" prop="dischargeDiagName3">
              <el-input v-model="queryParams.dischargeDiagName3" placeholder="请输入出院诊断名称-3" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院诊断编码-4" prop="dischargeDiagCode4">
              <el-input v-model="queryParams.dischargeDiagCode4" placeholder="请输入出院诊断编码-4" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院诊断名称-4" prop="dischargeDiagName4">
              <el-input v-model="queryParams.dischargeDiagName4" placeholder="请输入出院诊断名称-4" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院诊断编码-5" prop="dischargeDiagCode5">
              <el-input v-model="queryParams.dischargeDiagCode5" placeholder="请输入出院诊断编码-5" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院诊断名称-5" prop="dischargeDiagName5">
              <el-input v-model="queryParams.dischargeDiagName5" placeholder="请输入出院诊断名称-5" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院诊断编码-N" prop="dischargeDiagCoden">
              <el-input v-model="queryParams.dischargeDiagCoden" placeholder="请输入出院诊断编码-N" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院诊断名称-N" prop="dischargeDiagNamen">
              <el-input v-model="queryParams.dischargeDiagNamen" placeholder="请输入出院诊断名称-N" clearable @keyup.enter="handleQuery" />
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
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['natdss:natdssB071EmrDischarge:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="success" plain icon="Edit" :disabled="single" @click="handleUpdate()" v-hasPermi="['natdss:natdssB071EmrDischarge:edit']">修改</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="danger" plain icon="Delete" :disabled="multiple" @click="handleDelete()" v-hasPermi="['natdss:natdssB071EmrDischarge:remove']">删除</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['natdss:natdssB071EmrDischarge:export']">导出</el-button>
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" border :data="natdssB071EmrDischargeList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="系统自增主键" align="center" prop="id" v-if="true" />
        <el-table-column label="患者ID" align="center" prop="patientId" />
        <el-table-column label="单次就诊唯一标识号" align="center" prop="visitSn" />
        <el-table-column label="病案号" align="center" prop="medicalRecordNo" />
        <el-table-column label="住院号" align="center" prop="inpatientNo" />
        <el-table-column label="住院次数" align="center" prop="hospitalizationTimes" />
        <el-table-column label="出院记录流水号" align="center" prop="recordSn" />
        <el-table-column label="出院记录创建时间" align="center" prop="recordDatetime" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.recordDatetime, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="入院时间" align="center" prop="admissionDatetime" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.admissionDatetime, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="出院医嘱" align="center" prop="dischargeOrder" />
        <el-table-column label="出院时间" align="center" prop="dischargeDatetime" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.dischargeDatetime, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="实际住院天数" align="center" prop="lengthOfStay" />
        <el-table-column label="KPS评分" align="center" prop="kpsScore" />
        <el-table-column label="ECOG PS评分" align="center" prop="ecogScore" />
        <el-table-column label="文书内容" align="center" prop="recordText" />
        <el-table-column label="入院情况" align="center" prop="admissionCondition" />
        <el-table-column label="诊疗经过" align="center" prop="treatmentInfo" />
        <el-table-column label="出院情况" align="center" prop="dischargeCondition" />
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
        <el-table-column label="出院主要诊断编码" align="center" prop="dischargeMaindiagCode1" />
        <el-table-column label="出院主要诊断名称" align="center" prop="dischargeMaindiagName1" />
        <el-table-column label="出院诊断编码-2" align="center" prop="dischargeDiagCode2" />
        <el-table-column label="出院诊断名称-2" align="center" prop="dischargeDiagName2" />
        <el-table-column label="出院诊断编码-3" align="center" prop="dischargeDiagCode3" />
        <el-table-column label="出院诊断名称-3" align="center" prop="dischargeDiagName3" />
        <el-table-column label="出院诊断编码-4" align="center" prop="dischargeDiagCode4" />
        <el-table-column label="出院诊断名称-4" align="center" prop="dischargeDiagName4" />
        <el-table-column label="出院诊断编码-5" align="center" prop="dischargeDiagCode5" />
        <el-table-column label="出院诊断名称-5" align="center" prop="dischargeDiagName5" />
        <el-table-column label="出院诊断编码-N" align="center" prop="dischargeDiagCoden" />
        <el-table-column label="出院诊断名称-N" align="center" prop="dischargeDiagNamen" />
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
              <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['natdss:natdssB071EmrDischarge:edit']"></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)" v-hasPermi="['natdss:natdssB071EmrDischarge:remove']"></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改B07-1 出院记录对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="natdssB071EmrDischargeFormRef" :model="form" :rules="rules" label-width="80px">
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
        <el-form-item label="出院记录流水号" prop="recordSn">
          <el-input v-model="form.recordSn" placeholder="请输入出院记录流水号" />
        </el-form-item>
        <el-form-item label="出院记录创建时间" prop="recordDatetime">
          <el-date-picker clearable
            v-model="form.recordDatetime"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择出院记录创建时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="入院时间" prop="admissionDatetime">
          <el-date-picker clearable
            v-model="form.admissionDatetime"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择入院时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="出院医嘱" prop="dischargeOrder">
            <el-input v-model="form.dischargeOrder" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="出院时间" prop="dischargeDatetime">
          <el-date-picker clearable
            v-model="form.dischargeDatetime"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择出院时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="实际住院天数" prop="lengthOfStay">
          <el-input v-model="form.lengthOfStay" placeholder="请输入实际住院天数" />
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
        <el-form-item label="入院情况" prop="admissionCondition">
            <el-input v-model="form.admissionCondition" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="诊疗经过" prop="treatmentInfo">
            <el-input v-model="form.treatmentInfo" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="出院情况" prop="dischargeCondition">
            <el-input v-model="form.dischargeCondition" type="textarea" placeholder="请输入内容" />
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
        <el-form-item label="出院主要诊断编码" prop="dischargeMaindiagCode1">
          <el-input v-model="form.dischargeMaindiagCode1" placeholder="请输入出院主要诊断编码" />
        </el-form-item>
        <el-form-item label="出院主要诊断名称" prop="dischargeMaindiagName1">
          <el-input v-model="form.dischargeMaindiagName1" placeholder="请输入出院主要诊断名称" />
        </el-form-item>
        <el-form-item label="出院诊断编码-2" prop="dischargeDiagCode2">
          <el-input v-model="form.dischargeDiagCode2" placeholder="请输入出院诊断编码-2" />
        </el-form-item>
        <el-form-item label="出院诊断名称-2" prop="dischargeDiagName2">
          <el-input v-model="form.dischargeDiagName2" placeholder="请输入出院诊断名称-2" />
        </el-form-item>
        <el-form-item label="出院诊断编码-3" prop="dischargeDiagCode3">
          <el-input v-model="form.dischargeDiagCode3" placeholder="请输入出院诊断编码-3" />
        </el-form-item>
        <el-form-item label="出院诊断名称-3" prop="dischargeDiagName3">
          <el-input v-model="form.dischargeDiagName3" placeholder="请输入出院诊断名称-3" />
        </el-form-item>
        <el-form-item label="出院诊断编码-4" prop="dischargeDiagCode4">
          <el-input v-model="form.dischargeDiagCode4" placeholder="请输入出院诊断编码-4" />
        </el-form-item>
        <el-form-item label="出院诊断名称-4" prop="dischargeDiagName4">
          <el-input v-model="form.dischargeDiagName4" placeholder="请输入出院诊断名称-4" />
        </el-form-item>
        <el-form-item label="出院诊断编码-5" prop="dischargeDiagCode5">
          <el-input v-model="form.dischargeDiagCode5" placeholder="请输入出院诊断编码-5" />
        </el-form-item>
        <el-form-item label="出院诊断名称-5" prop="dischargeDiagName5">
          <el-input v-model="form.dischargeDiagName5" placeholder="请输入出院诊断名称-5" />
        </el-form-item>
        <el-form-item label="出院诊断编码-N" prop="dischargeDiagCoden">
            <el-input v-model="form.dischargeDiagCoden" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="出院诊断名称-N" prop="dischargeDiagNamen">
            <el-input v-model="form.dischargeDiagNamen" type="textarea" placeholder="请输入内容" />
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

<script setup name="NatdssB071EmrDischarge" lang="ts">
import { listNatdssB071EmrDischarge, getNatdssB071EmrDischarge, delNatdssB071EmrDischarge, addNatdssB071EmrDischarge, updateNatdssB071EmrDischarge } from '@/api/natdss/natdssB071EmrDischarge';
import { NatdssB071EmrDischargeVO, NatdssB071EmrDischargeQuery, NatdssB071EmrDischargeForm } from '@/api/natdss/natdssB071EmrDischarge/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const natdssB071EmrDischargeList = ref<NatdssB071EmrDischargeVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const natdssB071EmrDischargeFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: NatdssB071EmrDischargeForm = {
  id: undefined,
  patientId: undefined,
  visitSn: undefined,
  medicalRecordNo: undefined,
  inpatientNo: undefined,
  hospitalizationTimes: undefined,
  recordSn: undefined,
  recordDatetime: undefined,
  admissionDatetime: undefined,
  dischargeOrder: undefined,
  dischargeDatetime: undefined,
  lengthOfStay: undefined,
  kpsScore: undefined,
  ecogScore: undefined,
  recordText: undefined,
  admissionCondition: undefined,
  treatmentInfo: undefined,
  dischargeCondition: undefined,
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
  dischargeMaindiagCode1: undefined,
  dischargeMaindiagName1: undefined,
  dischargeDiagCode2: undefined,
  dischargeDiagName2: undefined,
  dischargeDiagCode3: undefined,
  dischargeDiagName3: undefined,
  dischargeDiagCode4: undefined,
  dischargeDiagName4: undefined,
  dischargeDiagCode5: undefined,
  dischargeDiagName5: undefined,
  dischargeDiagCoden: undefined,
  dischargeDiagNamen: undefined,
  extendData1: undefined,
  extendData2: undefined,
  recordStatus: undefined,
  createdTime: undefined,
  updatedTime: undefined
}
const data = reactive<PageData<NatdssB071EmrDischargeForm, NatdssB071EmrDischargeQuery>>({
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
    admissionDatetime: undefined,
    dischargeOrder: undefined,
    dischargeDatetime: undefined,
    lengthOfStay: undefined,
    kpsScore: undefined,
    ecogScore: undefined,
    recordText: undefined,
    admissionCondition: undefined,
    treatmentInfo: undefined,
    dischargeCondition: undefined,
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
    dischargeMaindiagCode1: undefined,
    dischargeMaindiagName1: undefined,
    dischargeDiagCode2: undefined,
    dischargeDiagName2: undefined,
    dischargeDiagCode3: undefined,
    dischargeDiagName3: undefined,
    dischargeDiagCode4: undefined,
    dischargeDiagName4: undefined,
    dischargeDiagCode5: undefined,
    dischargeDiagName5: undefined,
    dischargeDiagCoden: undefined,
    dischargeDiagNamen: undefined,
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
      { required: true, message: "出院记录流水号不能为空", trigger: "blur" }
    ],
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询B07-1 出院记录列表 */
const getList = async () => {
  loading.value = true;
  const res = await listNatdssB071EmrDischarge(queryParams.value);
  natdssB071EmrDischargeList.value = res.rows;
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
  natdssB071EmrDischargeFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: NatdssB071EmrDischargeVO[]) => {
  ids.value = selection.map(item => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
}

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = "添加B07-1 出院记录";
}

/** 修改按钮操作 */
const handleUpdate = async (row?: NatdssB071EmrDischargeVO) => {
  reset();
  const _id = row?.id || ids.value[0]
  const res = await getNatdssB071EmrDischarge(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = "修改B07-1 出院记录";
}

/** 提交按钮 */
const submitForm = () => {
  natdssB071EmrDischargeFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateNatdssB071EmrDischarge(form.value).finally(() =>  buttonLoading.value = false);
      } else {
        await addNatdssB071EmrDischarge(form.value).finally(() =>  buttonLoading.value = false);
      }
      proxy?.$modal.msgSuccess("操作成功");
      dialog.visible = false;
      await getList();
    }
  });
}

/** 删除按钮操作 */
const handleDelete = async (row?: NatdssB071EmrDischargeVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除B07-1 出院记录编号为"' + _ids + '"的数据项？').finally(() => loading.value = false);
  await delNatdssB071EmrDischarge(_ids);
  proxy?.$modal.msgSuccess("删除成功");
  await getList();
}

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download('natdss/natdssB071EmrDischarge/export', {
    ...queryParams.value
  }, `natdssB071EmrDischarge_${new Date().getTime()}.xlsx`)
}

onMounted(() => {
  getList();
});
</script>
