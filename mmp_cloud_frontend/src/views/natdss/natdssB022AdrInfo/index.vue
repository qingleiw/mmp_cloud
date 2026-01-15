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
            <el-form-item label="病案号" prop="medicalRecordNo">
              <el-input v-model="queryParams.medicalRecordNo" placeholder="请输入病案号" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="门诊号" prop="outpatientNo">
              <el-input v-model="queryParams.outpatientNo" placeholder="请输入门诊号" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="就诊次数" prop="visitTimes">
              <el-input v-model="queryParams.visitTimes" placeholder="请输入就诊次数" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="住院号" prop="inpatientNo">
              <el-input v-model="queryParams.inpatientNo" placeholder="请输入住院号" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="住院次数" prop="hospitalizationTimes">
              <el-input v-model="queryParams.hospitalizationTimes" placeholder="请输入住院次数" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="姓名" prop="name">
              <el-input v-model="queryParams.name" placeholder="请输入姓名" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="药品不良反应流水号" prop="adrEventSn">
              <el-input v-model="queryParams.adrEventSn" placeholder="请输入药品不良反应流水号" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="报告时间" prop="adrReportTime">
              <el-date-picker clearable
                v-model="queryParams.adrReportTime"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择报告时间"
              />
            </el-form-item>
            <el-form-item label="患者原患疾病" prop="adrOriginalDisease">
              <el-input v-model="queryParams.adrOriginalDisease" placeholder="请输入患者原患疾病" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="对原患疾病的影响" prop="adrDiseaseInfluence">
              <el-input v-model="queryParams.adrDiseaseInfluence" placeholder="请输入对原患疾病的影响" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他既往信息" prop="adrPastOther">
              <el-input v-model="queryParams.adrPastOther" placeholder="请输入其他既往信息" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="药品不良反应事件名称" prop="adrEventName">
              <el-input v-model="queryParams.adrEventName" placeholder="请输入药品不良反应事件名称" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="不良事件发生时间" prop="adrEventTime">
              <el-date-picker clearable
                v-model="queryParams.adrEventTime"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择不良事件发生时间"
              />
            </el-form-item>
            <el-form-item label="不良反应结果" prop="adrEventResult">
              <el-input v-model="queryParams.adrEventResult" placeholder="请输入不良反应结果" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="怀疑药品批准文号" prop="suspectDrugApprovalNo">
              <el-input v-model="queryParams.suspectDrugApprovalNo" placeholder="请输入怀疑药品批准文号" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="怀疑药品编码" prop="suspectDrugCode">
              <el-input v-model="queryParams.suspectDrugCode" placeholder="请输入怀疑药品编码" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="怀疑药品商品名" prop="suspectDrugTradeName">
              <el-input v-model="queryParams.suspectDrugTradeName" placeholder="请输入怀疑药品商品名" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="怀疑药品通用名" prop="suspectDrugGenericName">
              <el-input v-model="queryParams.suspectDrugGenericName" placeholder="请输入怀疑药品通用名" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="怀疑药品生产厂商" prop="suspectDrugManufac">
              <el-input v-model="queryParams.suspectDrugManufac" placeholder="请输入怀疑药品生产厂商" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="怀疑药品生产批号" prop="suspectDrugBatchNo">
              <el-input v-model="queryParams.suspectDrugBatchNo" placeholder="请输入怀疑药品生产批号" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="怀疑药品用量" prop="suspectDrugDosage">
              <el-input v-model="queryParams.suspectDrugDosage" placeholder="请输入怀疑药品用量" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="怀疑药品给药途径" prop="suspectDrugMethod">
              <el-input v-model="queryParams.suspectDrugMethod" placeholder="请输入怀疑药品给药途径" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="怀疑药品开始时间" prop="suspectDrugStartTime">
              <el-date-picker clearable
                v-model="queryParams.suspectDrugStartTime"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择怀疑药品开始时间"
              />
            </el-form-item>
            <el-form-item label="怀疑药品结束时间" prop="suspectDrugEndTime">
              <el-date-picker clearable
                v-model="queryParams.suspectDrugEndTime"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择怀疑药品结束时间"
              />
            </el-form-item>
            <el-form-item label="怀疑药品用药原因" prop="suspectDrugReason">
              <el-input v-model="queryParams.suspectDrugReason" placeholder="请输入怀疑药品用药原因" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="合并药品批准文号" prop="concomitantDrugApprovalNo">
              <el-input v-model="queryParams.concomitantDrugApprovalNo" placeholder="请输入合并药品批准文号" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="合并药品编码" prop="concomitantDrugCode">
              <el-input v-model="queryParams.concomitantDrugCode" placeholder="请输入合并药品编码" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="合并药品商品名" prop="concomitantDrugTradeName">
              <el-input v-model="queryParams.concomitantDrugTradeName" placeholder="请输入合并药品商品名" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="合并药品通用名" prop="concomitantDrugGenericName">
              <el-input v-model="queryParams.concomitantDrugGenericName" placeholder="请输入合并药品通用名" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="合并药品生产厂商" prop="concomitantDrugManufac">
              <el-input v-model="queryParams.concomitantDrugManufac" placeholder="请输入合并药品生产厂商" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="合并药品生产批号" prop="concomitantDrugBatchNo">
              <el-input v-model="queryParams.concomitantDrugBatchNo" placeholder="请输入合并药品生产批号" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="合并药品用量" prop="concomitantDrugDosage">
              <el-input v-model="queryParams.concomitantDrugDosage" placeholder="请输入合并药品用量" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="合并药品给药途径" prop="concomitantDrugMethod">
              <el-input v-model="queryParams.concomitantDrugMethod" placeholder="请输入合并药品给药途径" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="合并药品开始时间" prop="concomitantDrugStartTime">
              <el-date-picker clearable
                v-model="queryParams.concomitantDrugStartTime"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择合并药品开始时间"
              />
            </el-form-item>
            <el-form-item label="合并药品结束时间" prop="concomitantDrugEndTime">
              <el-date-picker clearable
                v-model="queryParams.concomitantDrugEndTime"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择合并药品结束时间"
              />
            </el-form-item>
            <el-form-item label="合并药品用药原因" prop="concomitantDrugReason">
              <el-input v-model="queryParams.concomitantDrugReason" placeholder="请输入合并药品用药原因" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="关联性报告人评价" prop="adrReporterAppraise">
              <el-input v-model="queryParams.adrReporterAppraise" placeholder="请输入关联性报告人评价" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="关联性报告单位评价" prop="adrReportUnitAppraise">
              <el-input v-model="queryParams.adrReportUnitAppraise" placeholder="请输入关联性报告单位评价" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="扩展字段1:填写怀疑用药或并用药品" prop="extendData1">
              <el-input v-model="queryParams.extendData1" placeholder="请输入扩展字段1:填写怀疑用药或并用药品" clearable @keyup.enter="handleQuery" />
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
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['natdss:natdssB022AdrInfo:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="success" plain icon="Edit" :disabled="single" @click="handleUpdate()" v-hasPermi="['natdss:natdssB022AdrInfo:edit']">修改</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="danger" plain icon="Delete" :disabled="multiple" @click="handleDelete()" v-hasPermi="['natdss:natdssB022AdrInfo:remove']">删除</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['natdss:natdssB022AdrInfo:export']">导出</el-button>
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" border :data="natdssB022AdrInfoList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="系统自增主键" align="center" prop="id" v-if="true" />
        <el-table-column label="患者ID" align="center" prop="patientId" />
        <el-table-column label="单次就诊唯一标识号" align="center" prop="visitSn" />
        <el-table-column label="就诊类型:住院、门诊" align="center" prop="visitType" />
        <el-table-column label="就诊卡号" align="center" prop="visitCardNo" />
        <el-table-column label="病案号" align="center" prop="medicalRecordNo" />
        <el-table-column label="门诊号" align="center" prop="outpatientNo" />
        <el-table-column label="就诊次数" align="center" prop="visitTimes" />
        <el-table-column label="住院号" align="center" prop="inpatientNo" />
        <el-table-column label="住院次数" align="center" prop="hospitalizationTimes" />
        <el-table-column label="姓名" align="center" prop="name" />
        <el-table-column label="药品不良反应流水号" align="center" prop="adrEventSn" />
        <el-table-column label="药品不良反应报告状态" align="center" prop="adrReportStatus" />
        <el-table-column label="药品不良反应报告类型" align="center" prop="adrReportType" />
        <el-table-column label="报告时间" align="center" prop="adrReportTime" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.adrReportTime, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="患者原患疾病" align="center" prop="adrOriginalDisease" />
        <el-table-column label="对原患疾病的影响" align="center" prop="adrDiseaseInfluence" />
        <el-table-column label="家族药品不良反应" align="center" prop="adrFamilyStatus" />
        <el-table-column label="既往药品不良反应" align="center" prop="adrPastStatus" />
        <el-table-column label="其他既往信息" align="center" prop="adrPastOther" />
        <el-table-column label="药品不良反应事件名称" align="center" prop="adrEventName" />
        <el-table-column label="不良事件发生时间" align="center" prop="adrEventTime" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.adrEventTime, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="不良事件过程描述" align="center" prop="adrEventContent" />
        <el-table-column label="不良反应结果" align="center" prop="adrEventResult" />
        <el-table-column label="停药或减药后是否减轻或消失" align="center" prop="adrStopStatus" />
        <el-table-column label="再次使用药物后是否出现同样反应" align="center" prop="adrReuseStatus" />
        <el-table-column label="怀疑药品批准文号" align="center" prop="suspectDrugApprovalNo" />
        <el-table-column label="怀疑药品编码" align="center" prop="suspectDrugCode" />
        <el-table-column label="怀疑药品商品名" align="center" prop="suspectDrugTradeName" />
        <el-table-column label="怀疑药品通用名" align="center" prop="suspectDrugGenericName" />
        <el-table-column label="怀疑药品生产厂商" align="center" prop="suspectDrugManufac" />
        <el-table-column label="怀疑药品生产批号" align="center" prop="suspectDrugBatchNo" />
        <el-table-column label="怀疑药品用量" align="center" prop="suspectDrugDosage" />
        <el-table-column label="怀疑药品给药途径" align="center" prop="suspectDrugMethod" />
        <el-table-column label="怀疑药品开始时间" align="center" prop="suspectDrugStartTime" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.suspectDrugStartTime, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="怀疑药品结束时间" align="center" prop="suspectDrugEndTime" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.suspectDrugEndTime, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="怀疑药品用药原因" align="center" prop="suspectDrugReason" />
        <el-table-column label="合并药品批准文号" align="center" prop="concomitantDrugApprovalNo" />
        <el-table-column label="合并药品编码" align="center" prop="concomitantDrugCode" />
        <el-table-column label="合并药品商品名" align="center" prop="concomitantDrugTradeName" />
        <el-table-column label="合并药品通用名" align="center" prop="concomitantDrugGenericName" />
        <el-table-column label="合并药品生产厂商" align="center" prop="concomitantDrugManufac" />
        <el-table-column label="合并药品生产批号" align="center" prop="concomitantDrugBatchNo" />
        <el-table-column label="合并药品用量" align="center" prop="concomitantDrugDosage" />
        <el-table-column label="合并药品给药途径" align="center" prop="concomitantDrugMethod" />
        <el-table-column label="合并药品开始时间" align="center" prop="concomitantDrugStartTime" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.concomitantDrugStartTime, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="合并药品结束时间" align="center" prop="concomitantDrugEndTime" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.concomitantDrugEndTime, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="合并药品用药原因" align="center" prop="concomitantDrugReason" />
        <el-table-column label="关联性报告人评价" align="center" prop="adrReporterAppraise" />
        <el-table-column label="关联性报告单位评价" align="center" prop="adrReportUnitAppraise" />
        <el-table-column label="扩展字段1:填写怀疑用药或并用药品" align="center" prop="extendData1" />
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
              <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['natdss:natdssB022AdrInfo:edit']"></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)" v-hasPermi="['natdss:natdssB022AdrInfo:remove']"></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改B02-2 患者药物不良反应记录对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="natdssB022AdrInfoFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="患者ID" prop="patientId">
          <el-input v-model="form.patientId" placeholder="请输入患者ID" />
        </el-form-item>
        <el-form-item label="单次就诊唯一标识号" prop="visitSn">
          <el-input v-model="form.visitSn" placeholder="请输入单次就诊唯一标识号" />
        </el-form-item>
        <el-form-item label="就诊卡号" prop="visitCardNo">
          <el-input v-model="form.visitCardNo" placeholder="请输入就诊卡号" />
        </el-form-item>
        <el-form-item label="病案号" prop="medicalRecordNo">
          <el-input v-model="form.medicalRecordNo" placeholder="请输入病案号" />
        </el-form-item>
        <el-form-item label="门诊号" prop="outpatientNo">
          <el-input v-model="form.outpatientNo" placeholder="请输入门诊号" />
        </el-form-item>
        <el-form-item label="就诊次数" prop="visitTimes">
          <el-input v-model="form.visitTimes" placeholder="请输入就诊次数" />
        </el-form-item>
        <el-form-item label="住院号" prop="inpatientNo">
          <el-input v-model="form.inpatientNo" placeholder="请输入住院号" />
        </el-form-item>
        <el-form-item label="住院次数" prop="hospitalizationTimes">
          <el-input v-model="form.hospitalizationTimes" placeholder="请输入住院次数" />
        </el-form-item>
        <el-form-item label="姓名" prop="name">
          <el-input v-model="form.name" placeholder="请输入姓名" />
        </el-form-item>
        <el-form-item label="药品不良反应流水号" prop="adrEventSn">
          <el-input v-model="form.adrEventSn" placeholder="请输入药品不良反应流水号" />
        </el-form-item>
        <el-form-item label="报告时间" prop="adrReportTime">
          <el-date-picker clearable
            v-model="form.adrReportTime"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择报告时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="患者原患疾病" prop="adrOriginalDisease">
          <el-input v-model="form.adrOriginalDisease" placeholder="请输入患者原患疾病" />
        </el-form-item>
        <el-form-item label="对原患疾病的影响" prop="adrDiseaseInfluence">
          <el-input v-model="form.adrDiseaseInfluence" placeholder="请输入对原患疾病的影响" />
        </el-form-item>
        <el-form-item label="其他既往信息" prop="adrPastOther">
          <el-input v-model="form.adrPastOther" placeholder="请输入其他既往信息" />
        </el-form-item>
        <el-form-item label="药品不良反应事件名称" prop="adrEventName">
          <el-input v-model="form.adrEventName" placeholder="请输入药品不良反应事件名称" />
        </el-form-item>
        <el-form-item label="不良事件发生时间" prop="adrEventTime">
          <el-date-picker clearable
            v-model="form.adrEventTime"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择不良事件发生时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="不良事件过程描述">
          <editor v-model="form.adrEventContent" :min-height="192"/>
        </el-form-item>
        <el-form-item label="不良反应结果" prop="adrEventResult">
          <el-input v-model="form.adrEventResult" placeholder="请输入不良反应结果" />
        </el-form-item>
        <el-form-item label="怀疑药品批准文号" prop="suspectDrugApprovalNo">
          <el-input v-model="form.suspectDrugApprovalNo" placeholder="请输入怀疑药品批准文号" />
        </el-form-item>
        <el-form-item label="怀疑药品编码" prop="suspectDrugCode">
          <el-input v-model="form.suspectDrugCode" placeholder="请输入怀疑药品编码" />
        </el-form-item>
        <el-form-item label="怀疑药品商品名" prop="suspectDrugTradeName">
          <el-input v-model="form.suspectDrugTradeName" placeholder="请输入怀疑药品商品名" />
        </el-form-item>
        <el-form-item label="怀疑药品通用名" prop="suspectDrugGenericName">
          <el-input v-model="form.suspectDrugGenericName" placeholder="请输入怀疑药品通用名" />
        </el-form-item>
        <el-form-item label="怀疑药品生产厂商" prop="suspectDrugManufac">
          <el-input v-model="form.suspectDrugManufac" placeholder="请输入怀疑药品生产厂商" />
        </el-form-item>
        <el-form-item label="怀疑药品生产批号" prop="suspectDrugBatchNo">
          <el-input v-model="form.suspectDrugBatchNo" placeholder="请输入怀疑药品生产批号" />
        </el-form-item>
        <el-form-item label="怀疑药品用量" prop="suspectDrugDosage">
          <el-input v-model="form.suspectDrugDosage" placeholder="请输入怀疑药品用量" />
        </el-form-item>
        <el-form-item label="怀疑药品给药途径" prop="suspectDrugMethod">
          <el-input v-model="form.suspectDrugMethod" placeholder="请输入怀疑药品给药途径" />
        </el-form-item>
        <el-form-item label="怀疑药品开始时间" prop="suspectDrugStartTime">
          <el-date-picker clearable
            v-model="form.suspectDrugStartTime"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择怀疑药品开始时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="怀疑药品结束时间" prop="suspectDrugEndTime">
          <el-date-picker clearable
            v-model="form.suspectDrugEndTime"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择怀疑药品结束时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="怀疑药品用药原因" prop="suspectDrugReason">
            <el-input v-model="form.suspectDrugReason" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="合并药品批准文号" prop="concomitantDrugApprovalNo">
          <el-input v-model="form.concomitantDrugApprovalNo" placeholder="请输入合并药品批准文号" />
        </el-form-item>
        <el-form-item label="合并药品编码" prop="concomitantDrugCode">
          <el-input v-model="form.concomitantDrugCode" placeholder="请输入合并药品编码" />
        </el-form-item>
        <el-form-item label="合并药品商品名" prop="concomitantDrugTradeName">
          <el-input v-model="form.concomitantDrugTradeName" placeholder="请输入合并药品商品名" />
        </el-form-item>
        <el-form-item label="合并药品通用名" prop="concomitantDrugGenericName">
          <el-input v-model="form.concomitantDrugGenericName" placeholder="请输入合并药品通用名" />
        </el-form-item>
        <el-form-item label="合并药品生产厂商" prop="concomitantDrugManufac">
          <el-input v-model="form.concomitantDrugManufac" placeholder="请输入合并药品生产厂商" />
        </el-form-item>
        <el-form-item label="合并药品生产批号" prop="concomitantDrugBatchNo">
          <el-input v-model="form.concomitantDrugBatchNo" placeholder="请输入合并药品生产批号" />
        </el-form-item>
        <el-form-item label="合并药品用量" prop="concomitantDrugDosage">
          <el-input v-model="form.concomitantDrugDosage" placeholder="请输入合并药品用量" />
        </el-form-item>
        <el-form-item label="合并药品给药途径" prop="concomitantDrugMethod">
          <el-input v-model="form.concomitantDrugMethod" placeholder="请输入合并药品给药途径" />
        </el-form-item>
        <el-form-item label="合并药品开始时间" prop="concomitantDrugStartTime">
          <el-date-picker clearable
            v-model="form.concomitantDrugStartTime"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择合并药品开始时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="合并药品结束时间" prop="concomitantDrugEndTime">
          <el-date-picker clearable
            v-model="form.concomitantDrugEndTime"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择合并药品结束时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="合并药品用药原因" prop="concomitantDrugReason">
            <el-input v-model="form.concomitantDrugReason" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="关联性报告人评价" prop="adrReporterAppraise">
          <el-input v-model="form.adrReporterAppraise" placeholder="请输入关联性报告人评价" />
        </el-form-item>
        <el-form-item label="关联性报告单位评价" prop="adrReportUnitAppraise">
          <el-input v-model="form.adrReportUnitAppraise" placeholder="请输入关联性报告单位评价" />
        </el-form-item>
        <el-form-item label="扩展字段1:填写怀疑用药或并用药品" prop="extendData1">
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

<script setup name="NatdssB022AdrInfo" lang="ts">
import { listNatdssB022AdrInfo, getNatdssB022AdrInfo, delNatdssB022AdrInfo, addNatdssB022AdrInfo, updateNatdssB022AdrInfo } from '@/api/natdss/natdssB022AdrInfo';
import { NatdssB022AdrInfoVO, NatdssB022AdrInfoQuery, NatdssB022AdrInfoForm } from '@/api/natdss/natdssB022AdrInfo/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const natdssB022AdrInfoList = ref<NatdssB022AdrInfoVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const natdssB022AdrInfoFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: NatdssB022AdrInfoForm = {
  id: undefined,
  patientId: undefined,
  visitSn: undefined,
  visitType: undefined,
  visitCardNo: undefined,
  medicalRecordNo: undefined,
  outpatientNo: undefined,
  visitTimes: undefined,
  inpatientNo: undefined,
  hospitalizationTimes: undefined,
  name: undefined,
  adrEventSn: undefined,
  adrReportStatus: undefined,
  adrReportType: undefined,
  adrReportTime: undefined,
  adrOriginalDisease: undefined,
  adrDiseaseInfluence: undefined,
  adrFamilyStatus: undefined,
  adrPastStatus: undefined,
  adrPastOther: undefined,
  adrEventName: undefined,
  adrEventTime: undefined,
  adrEventContent: undefined,
  adrEventResult: undefined,
  adrStopStatus: undefined,
  adrReuseStatus: undefined,
  suspectDrugApprovalNo: undefined,
  suspectDrugCode: undefined,
  suspectDrugTradeName: undefined,
  suspectDrugGenericName: undefined,
  suspectDrugManufac: undefined,
  suspectDrugBatchNo: undefined,
  suspectDrugDosage: undefined,
  suspectDrugMethod: undefined,
  suspectDrugStartTime: undefined,
  suspectDrugEndTime: undefined,
  suspectDrugReason: undefined,
  concomitantDrugApprovalNo: undefined,
  concomitantDrugCode: undefined,
  concomitantDrugTradeName: undefined,
  concomitantDrugGenericName: undefined,
  concomitantDrugManufac: undefined,
  concomitantDrugBatchNo: undefined,
  concomitantDrugDosage: undefined,
  concomitantDrugMethod: undefined,
  concomitantDrugStartTime: undefined,
  concomitantDrugEndTime: undefined,
  concomitantDrugReason: undefined,
  adrReporterAppraise: undefined,
  adrReportUnitAppraise: undefined,
  extendData1: undefined,
  extendData2: undefined,
  recordStatus: undefined,
  createdTime: undefined,
  updatedTime: undefined
}
const data = reactive<PageData<NatdssB022AdrInfoForm, NatdssB022AdrInfoQuery>>({
  form: {...initFormData},
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    patientId: undefined,
    visitSn: undefined,
    visitType: undefined,
    visitCardNo: undefined,
    medicalRecordNo: undefined,
    outpatientNo: undefined,
    visitTimes: undefined,
    inpatientNo: undefined,
    hospitalizationTimes: undefined,
    name: undefined,
    adrEventSn: undefined,
    adrReportStatus: undefined,
    adrReportType: undefined,
    adrReportTime: undefined,
    adrOriginalDisease: undefined,
    adrDiseaseInfluence: undefined,
    adrFamilyStatus: undefined,
    adrPastStatus: undefined,
    adrPastOther: undefined,
    adrEventName: undefined,
    adrEventTime: undefined,
    adrEventContent: undefined,
    adrEventResult: undefined,
    adrStopStatus: undefined,
    adrReuseStatus: undefined,
    suspectDrugApprovalNo: undefined,
    suspectDrugCode: undefined,
    suspectDrugTradeName: undefined,
    suspectDrugGenericName: undefined,
    suspectDrugManufac: undefined,
    suspectDrugBatchNo: undefined,
    suspectDrugDosage: undefined,
    suspectDrugMethod: undefined,
    suspectDrugStartTime: undefined,
    suspectDrugEndTime: undefined,
    suspectDrugReason: undefined,
    concomitantDrugApprovalNo: undefined,
    concomitantDrugCode: undefined,
    concomitantDrugTradeName: undefined,
    concomitantDrugGenericName: undefined,
    concomitantDrugManufac: undefined,
    concomitantDrugBatchNo: undefined,
    concomitantDrugDosage: undefined,
    concomitantDrugMethod: undefined,
    concomitantDrugStartTime: undefined,
    concomitantDrugEndTime: undefined,
    concomitantDrugReason: undefined,
    adrReporterAppraise: undefined,
    adrReportUnitAppraise: undefined,
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
    adrEventSn: [
      { required: true, message: "药品不良反应流水号不能为空", trigger: "blur" }
    ],
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询B02-2 患者药物不良反应记录列表 */
const getList = async () => {
  loading.value = true;
  const res = await listNatdssB022AdrInfo(queryParams.value);
  natdssB022AdrInfoList.value = res.rows;
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
  natdssB022AdrInfoFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: NatdssB022AdrInfoVO[]) => {
  ids.value = selection.map(item => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
}

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = "添加B02-2 患者药物不良反应记录";
}

/** 修改按钮操作 */
const handleUpdate = async (row?: NatdssB022AdrInfoVO) => {
  reset();
  const _id = row?.id || ids.value[0]
  const res = await getNatdssB022AdrInfo(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = "修改B02-2 患者药物不良反应记录";
}

/** 提交按钮 */
const submitForm = () => {
  natdssB022AdrInfoFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateNatdssB022AdrInfo(form.value).finally(() =>  buttonLoading.value = false);
      } else {
        await addNatdssB022AdrInfo(form.value).finally(() =>  buttonLoading.value = false);
      }
      proxy?.$modal.msgSuccess("操作成功");
      dialog.visible = false;
      await getList();
    }
  });
}

/** 删除按钮操作 */
const handleDelete = async (row?: NatdssB022AdrInfoVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除B02-2 患者药物不良反应记录编号为"' + _ids + '"的数据项？').finally(() => loading.value = false);
  await delNatdssB022AdrInfo(_ids);
  proxy?.$modal.msgSuccess("删除成功");
  await getList();
}

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download('natdss/natdssB022AdrInfo/export', {
    ...queryParams.value
  }, `natdssB022AdrInfo_${new Date().getTime()}.xlsx`)
}

onMounted(() => {
  getList();
});
</script>
