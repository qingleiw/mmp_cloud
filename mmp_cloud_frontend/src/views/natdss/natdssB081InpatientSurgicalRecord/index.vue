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
            <el-form-item label="手术记录流水号" prop="recordSn">
              <el-input v-model="queryParams.recordSn" placeholder="请输入手术记录流水号" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="手术记录时间" prop="recordDatetime">
              <el-date-picker clearable
                v-model="queryParams.recordDatetime"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择手术记录时间"
              />
            </el-form-item>
            <el-form-item label="主刀医生代码" prop="surgeonNo">
              <el-input v-model="queryParams.surgeonNo" placeholder="请输入主刀医生代码" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="医师职称名称" prop="technicalTitle">
              <el-input v-model="queryParams.technicalTitle" placeholder="请输入医师职称名称" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="医师职务名称" prop="jobTitle">
              <el-input v-model="queryParams.jobTitle" placeholder="请输入医师职务名称" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="手术执行科室编号" prop="executiveDeptCode">
              <el-input v-model="queryParams.executiveDeptCode" placeholder="请输入手术执行科室编号" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="手术执行科室名称" prop="executiveDeptName">
              <el-input v-model="queryParams.executiveDeptName" placeholder="请输入手术执行科室名称" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="手术编码" prop="surgeryCode">
              <el-input v-model="queryParams.surgeryCode" placeholder="请输入手术编码" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="手术名称" prop="surgeryName">
              <el-input v-model="queryParams.surgeryName" placeholder="请输入手术名称" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="手术开始时间" prop="startDatetime">
              <el-date-picker clearable
                v-model="queryParams.startDatetime"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择手术开始时间"
              />
            </el-form-item>
            <el-form-item label="手术结束时间" prop="finishDatetime">
              <el-date-picker clearable
                v-model="queryParams.finishDatetime"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择手术结束时间"
              />
            </el-form-item>
            <el-form-item label="手术级别" prop="surgeryLevel">
              <el-input v-model="queryParams.surgeryLevel" placeholder="请输入手术级别" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="手术入路" prop="surgicalApproach">
              <el-input v-model="queryParams.surgicalApproach" placeholder="请输入手术入路" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="是否预防性使用抗生素" prop="preventiveAntibioticMark">
              <el-input v-model="queryParams.preventiveAntibioticMark" placeholder="请输入是否预防性使用抗生素" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="手术过程描述" prop="proceduresDescription">
              <el-input v-model="queryParams.proceduresDescription" placeholder="请输入手术过程描述" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="麻醉医师代码" prop="asaSurgeonNo">
              <el-input v-model="queryParams.asaSurgeonNo" placeholder="请输入麻醉医师代码" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="麻醉医师职称名称" prop="asaTechnicalTitle">
              <el-input v-model="queryParams.asaTechnicalTitle" placeholder="请输入麻醉医师职称名称" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="麻醉医师职务名称" prop="asaJobTitle">
              <el-input v-model="queryParams.asaJobTitle" placeholder="请输入麻醉医师职务名称" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="麻醉方式代码" prop="anesthesiaTypeCode">
              <el-input v-model="queryParams.anesthesiaTypeCode" placeholder="请输入麻醉方式代码" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="麻醉开始时间" prop="anesthesiaStartTime">
              <el-date-picker clearable
                v-model="queryParams.anesthesiaStartTime"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择麻醉开始时间"
              />
            </el-form-item>
            <el-form-item label="麻醉结束时间" prop="anesthesiaEndTime">
              <el-date-picker clearable
                v-model="queryParams.anesthesiaEndTime"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择麻醉结束时间"
              />
            </el-form-item>
            <el-form-item label="总入量(ml)" prop="intakeVolume">
              <el-input v-model="queryParams.intakeVolume" placeholder="请输入总入量(ml)" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="总出量(ml)" prop="outputVolume">
              <el-input v-model="queryParams.outputVolume" placeholder="请输入总出量(ml)" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="输血血型-ABO" prop="bloodTransAbo">
              <el-input v-model="queryParams.bloodTransAbo" placeholder="请输入输血血型-ABO" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="输血血型-Rh" prop="bloodTransRh">
              <el-input v-model="queryParams.bloodTransRh" placeholder="请输入输血血型-Rh" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="输血成份类型代码" prop="bloodTransComponentCode">
              <el-input v-model="queryParams.bloodTransComponentCode" placeholder="请输入输血成份类型代码" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="输血成份类型" prop="bloodTransComponent">
              <el-input v-model="queryParams.bloodTransComponent" placeholder="请输入输血成份类型" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="输血量(ml)" prop="bloodTransVolume">
              <el-input v-model="queryParams.bloodTransVolume" placeholder="请输入输血量(ml)" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出血量(ml)" prop="bloodLossVolume">
              <el-input v-model="queryParams.bloodLossVolume" placeholder="请输入出血量(ml)" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="尿量(ml)" prop="urineVolume">
              <el-input v-model="queryParams.urineVolume" placeholder="请输入尿量(ml)" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="术前主要诊断编码" prop="presurgeryMaindiagCode1">
              <el-input v-model="queryParams.presurgeryMaindiagCode1" placeholder="请输入术前主要诊断编码" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="术前主要诊断名称" prop="presurgeryMaindiagName1">
              <el-input v-model="queryParams.presurgeryMaindiagName1" placeholder="请输入术前主要诊断名称" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="术前诊断编码-2" prop="presurgeryDiagCode2">
              <el-input v-model="queryParams.presurgeryDiagCode2" placeholder="请输入术前诊断编码-2" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="术前诊断名称-2" prop="presurgeryDiagName2">
              <el-input v-model="queryParams.presurgeryDiagName2" placeholder="请输入术前诊断名称-2" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="术前诊断编码-3" prop="presurgeryDiagCode3">
              <el-input v-model="queryParams.presurgeryDiagCode3" placeholder="请输入术前诊断编码-3" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="术前诊断名称-3" prop="presurgeryDiagName3">
              <el-input v-model="queryParams.presurgeryDiagName3" placeholder="请输入术前诊断名称-3" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="术前诊断编码-4" prop="presurgeryDiagCode4">
              <el-input v-model="queryParams.presurgeryDiagCode4" placeholder="请输入术前诊断编码-4" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="术前诊断名称-4" prop="presurgeryDiagName4">
              <el-input v-model="queryParams.presurgeryDiagName4" placeholder="请输入术前诊断名称-4" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="术前诊断编码-5" prop="presurgeryDiagCode5">
              <el-input v-model="queryParams.presurgeryDiagCode5" placeholder="请输入术前诊断编码-5" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="术前诊断名称-5" prop="presurgeryDiagName5">
              <el-input v-model="queryParams.presurgeryDiagName5" placeholder="请输入术前诊断名称-5" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="术中主要诊断编码" prop="intrasurgeryMaindiagCode1">
              <el-input v-model="queryParams.intrasurgeryMaindiagCode1" placeholder="请输入术中主要诊断编码" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="术中主要诊断名称" prop="intrasurgeryMaindiagName1">
              <el-input v-model="queryParams.intrasurgeryMaindiagName1" placeholder="请输入术中主要诊断名称" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="术中诊断编码-2" prop="intrasurgeryDiagCode2">
              <el-input v-model="queryParams.intrasurgeryDiagCode2" placeholder="请输入术中诊断编码-2" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="术中诊断名称-2" prop="intrasurgeryDiagName2">
              <el-input v-model="queryParams.intrasurgeryDiagName2" placeholder="请输入术中诊断名称-2" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="术中诊断编码-3" prop="intrasurgeryDiagCode3">
              <el-input v-model="queryParams.intrasurgeryDiagCode3" placeholder="请输入术中诊断编码-3" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="术中诊断名称-3" prop="intrasurgeryDiagName3">
              <el-input v-model="queryParams.intrasurgeryDiagName3" placeholder="请输入术中诊断名称-3" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="术中诊断编码-4" prop="intrasurgeryDiagCode4">
              <el-input v-model="queryParams.intrasurgeryDiagCode4" placeholder="请输入术中诊断编码-4" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="术中诊断名称-4" prop="intrasurgeryDiagName4">
              <el-input v-model="queryParams.intrasurgeryDiagName4" placeholder="请输入术中诊断名称-4" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="术中诊断编码-5" prop="intrasurgeryDiagCode5">
              <el-input v-model="queryParams.intrasurgeryDiagCode5" placeholder="请输入术中诊断编码-5" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="术中诊断名称-5" prop="intrasurgeryDiagName5">
              <el-input v-model="queryParams.intrasurgeryDiagName5" placeholder="请输入术中诊断名称-5" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="术后主要诊断编码" prop="postsurgeryMaindiagCode1">
              <el-input v-model="queryParams.postsurgeryMaindiagCode1" placeholder="请输入术后主要诊断编码" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="术后主要诊断名称" prop="postsurgeryMaindiagName1">
              <el-input v-model="queryParams.postsurgeryMaindiagName1" placeholder="请输入术后主要诊断名称" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="术后诊断编码-2" prop="postsurgeryDiagCode2">
              <el-input v-model="queryParams.postsurgeryDiagCode2" placeholder="请输入术后诊断编码-2" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="术后诊断名称-2" prop="postsurgeryDiagName2">
              <el-input v-model="queryParams.postsurgeryDiagName2" placeholder="请输入术后诊断名称-2" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="术后诊断编码-3" prop="postsurgeryDiagCode3">
              <el-input v-model="queryParams.postsurgeryDiagCode3" placeholder="请输入术后诊断编码-3" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="术后诊断名称-3" prop="postsurgeryDiagName3">
              <el-input v-model="queryParams.postsurgeryDiagName3" placeholder="请输入术后诊断名称-3" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="术后诊断编码-4" prop="postsurgeryDiagCode4">
              <el-input v-model="queryParams.postsurgeryDiagCode4" placeholder="请输入术后诊断编码-4" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="术后诊断名称-4" prop="postsurgeryDiagName4">
              <el-input v-model="queryParams.postsurgeryDiagName4" placeholder="请输入术后诊断名称-4" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="术后诊断编码-5" prop="postsurgeryDiagCode5">
              <el-input v-model="queryParams.postsurgeryDiagCode5" placeholder="请输入术后诊断编码-5" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="术后诊断名称-5" prop="postsurgeryDiagName5">
              <el-input v-model="queryParams.postsurgeryDiagName5" placeholder="请输入术后诊断名称-5" clearable @keyup.enter="handleQuery" />
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
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['natdss:natdssB081InpatientSurgicalRecord:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="success" plain icon="Edit" :disabled="single" @click="handleUpdate()" v-hasPermi="['natdss:natdssB081InpatientSurgicalRecord:edit']">修改</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="danger" plain icon="Delete" :disabled="multiple" @click="handleDelete()" v-hasPermi="['natdss:natdssB081InpatientSurgicalRecord:remove']">删除</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['natdss:natdssB081InpatientSurgicalRecord:export']">导出</el-button>
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" border :data="natdssB081InpatientSurgicalRecordList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="系统自增主键" align="center" prop="id" v-if="true" />
        <el-table-column label="患者ID" align="center" prop="patientId" />
        <el-table-column label="单次就诊唯一标识号" align="center" prop="visitSn" />
        <el-table-column label="病案号" align="center" prop="medicalRecordNo" />
        <el-table-column label="住院号" align="center" prop="inpatientNo" />
        <el-table-column label="住院次数" align="center" prop="hospitalizationTimes" />
        <el-table-column label="手术记录流水号" align="center" prop="recordSn" />
        <el-table-column label="手术记录时间" align="center" prop="recordDatetime" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.recordDatetime, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="主刀医生代码" align="center" prop="surgeonNo" />
        <el-table-column label="医师职称名称" align="center" prop="technicalTitle" />
        <el-table-column label="医师职务名称" align="center" prop="jobTitle" />
        <el-table-column label="手术执行科室编号" align="center" prop="executiveDeptCode" />
        <el-table-column label="手术执行科室名称" align="center" prop="executiveDeptName" />
        <el-table-column label="手术编码" align="center" prop="surgeryCode" />
        <el-table-column label="手术名称" align="center" prop="surgeryName" />
        <el-table-column label="手术开始时间" align="center" prop="startDatetime" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.startDatetime, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="手术结束时间" align="center" prop="finishDatetime" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.finishDatetime, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="切口类型" align="center" prop="incisionType" />
        <el-table-column label="手术级别" align="center" prop="surgeryLevel" />
        <el-table-column label="手术入路" align="center" prop="surgicalApproach" />
        <el-table-column label="是否预防性使用抗生素" align="center" prop="preventiveAntibioticMark" />
        <el-table-column label="手术过程描述" align="center" prop="proceduresDescription" />
        <el-table-column label="麻醉医师代码" align="center" prop="asaSurgeonNo" />
        <el-table-column label="麻醉医师职称名称" align="center" prop="asaTechnicalTitle" />
        <el-table-column label="麻醉医师职务名称" align="center" prop="asaJobTitle" />
        <el-table-column label="麻醉方式代码" align="center" prop="anesthesiaTypeCode" />
        <el-table-column label="麻醉方式" align="center" prop="anesthesiaType" />
        <el-table-column label="麻醉评分" align="center" prop="asaPhysicalStatus" />
        <el-table-column label="麻醉开始时间" align="center" prop="anesthesiaStartTime" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.anesthesiaStartTime, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="麻醉结束时间" align="center" prop="anesthesiaEndTime" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.anesthesiaEndTime, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="总入量(ml)" align="center" prop="intakeVolume" />
        <el-table-column label="总出量(ml)" align="center" prop="outputVolume" />
        <el-table-column label="输血血型-ABO" align="center" prop="bloodTransAbo" />
        <el-table-column label="输血血型-Rh" align="center" prop="bloodTransRh" />
        <el-table-column label="输血成份类型代码" align="center" prop="bloodTransComponentCode" />
        <el-table-column label="输血成份类型" align="center" prop="bloodTransComponent" />
        <el-table-column label="输血量(ml)" align="center" prop="bloodTransVolume" />
        <el-table-column label="出血量(ml)" align="center" prop="bloodLossVolume" />
        <el-table-column label="尿量(ml)" align="center" prop="urineVolume" />
        <el-table-column label="术前主要诊断编码" align="center" prop="presurgeryMaindiagCode1" />
        <el-table-column label="术前主要诊断名称" align="center" prop="presurgeryMaindiagName1" />
        <el-table-column label="术前诊断编码-2" align="center" prop="presurgeryDiagCode2" />
        <el-table-column label="术前诊断名称-2" align="center" prop="presurgeryDiagName2" />
        <el-table-column label="术前诊断编码-3" align="center" prop="presurgeryDiagCode3" />
        <el-table-column label="术前诊断名称-3" align="center" prop="presurgeryDiagName3" />
        <el-table-column label="术前诊断编码-4" align="center" prop="presurgeryDiagCode4" />
        <el-table-column label="术前诊断名称-4" align="center" prop="presurgeryDiagName4" />
        <el-table-column label="术前诊断编码-5" align="center" prop="presurgeryDiagCode5" />
        <el-table-column label="术前诊断名称-5" align="center" prop="presurgeryDiagName5" />
        <el-table-column label="术中主要诊断编码" align="center" prop="intrasurgeryMaindiagCode1" />
        <el-table-column label="术中主要诊断名称" align="center" prop="intrasurgeryMaindiagName1" />
        <el-table-column label="术中诊断编码-2" align="center" prop="intrasurgeryDiagCode2" />
        <el-table-column label="术中诊断名称-2" align="center" prop="intrasurgeryDiagName2" />
        <el-table-column label="术中诊断编码-3" align="center" prop="intrasurgeryDiagCode3" />
        <el-table-column label="术中诊断名称-3" align="center" prop="intrasurgeryDiagName3" />
        <el-table-column label="术中诊断编码-4" align="center" prop="intrasurgeryDiagCode4" />
        <el-table-column label="术中诊断名称-4" align="center" prop="intrasurgeryDiagName4" />
        <el-table-column label="术中诊断编码-5" align="center" prop="intrasurgeryDiagCode5" />
        <el-table-column label="术中诊断名称-5" align="center" prop="intrasurgeryDiagName5" />
        <el-table-column label="术后主要诊断编码" align="center" prop="postsurgeryMaindiagCode1" />
        <el-table-column label="术后主要诊断名称" align="center" prop="postsurgeryMaindiagName1" />
        <el-table-column label="术后诊断编码-2" align="center" prop="postsurgeryDiagCode2" />
        <el-table-column label="术后诊断名称-2" align="center" prop="postsurgeryDiagName2" />
        <el-table-column label="术后诊断编码-3" align="center" prop="postsurgeryDiagCode3" />
        <el-table-column label="术后诊断名称-3" align="center" prop="postsurgeryDiagName3" />
        <el-table-column label="术后诊断编码-4" align="center" prop="postsurgeryDiagCode4" />
        <el-table-column label="术后诊断名称-4" align="center" prop="postsurgeryDiagName4" />
        <el-table-column label="术后诊断编码-5" align="center" prop="postsurgeryDiagCode5" />
        <el-table-column label="术后诊断名称-5" align="center" prop="postsurgeryDiagName5" />
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
              <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['natdss:natdssB081InpatientSurgicalRecord:edit']"></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)" v-hasPermi="['natdss:natdssB081InpatientSurgicalRecord:remove']"></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改B08-1 住院手术记录对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="natdssB081InpatientSurgicalRecordFormRef" :model="form" :rules="rules" label-width="80px">
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
        <el-form-item label="手术记录流水号" prop="recordSn">
          <el-input v-model="form.recordSn" placeholder="请输入手术记录流水号" />
        </el-form-item>
        <el-form-item label="手术记录时间" prop="recordDatetime">
          <el-date-picker clearable
            v-model="form.recordDatetime"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择手术记录时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="主刀医生代码" prop="surgeonNo">
          <el-input v-model="form.surgeonNo" placeholder="请输入主刀医生代码" />
        </el-form-item>
        <el-form-item label="医师职称名称" prop="technicalTitle">
          <el-input v-model="form.technicalTitle" placeholder="请输入医师职称名称" />
        </el-form-item>
        <el-form-item label="医师职务名称" prop="jobTitle">
          <el-input v-model="form.jobTitle" placeholder="请输入医师职务名称" />
        </el-form-item>
        <el-form-item label="手术执行科室编号" prop="executiveDeptCode">
          <el-input v-model="form.executiveDeptCode" placeholder="请输入手术执行科室编号" />
        </el-form-item>
        <el-form-item label="手术执行科室名称" prop="executiveDeptName">
          <el-input v-model="form.executiveDeptName" placeholder="请输入手术执行科室名称" />
        </el-form-item>
        <el-form-item label="手术编码" prop="surgeryCode">
          <el-input v-model="form.surgeryCode" placeholder="请输入手术编码" />
        </el-form-item>
        <el-form-item label="手术名称" prop="surgeryName">
          <el-input v-model="form.surgeryName" placeholder="请输入手术名称" />
        </el-form-item>
        <el-form-item label="手术开始时间" prop="startDatetime">
          <el-date-picker clearable
            v-model="form.startDatetime"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择手术开始时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="手术结束时间" prop="finishDatetime">
          <el-date-picker clearable
            v-model="form.finishDatetime"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择手术结束时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="手术级别" prop="surgeryLevel">
          <el-input v-model="form.surgeryLevel" placeholder="请输入手术级别" />
        </el-form-item>
        <el-form-item label="手术入路" prop="surgicalApproach">
          <el-input v-model="form.surgicalApproach" placeholder="请输入手术入路" />
        </el-form-item>
        <el-form-item label="是否预防性使用抗生素" prop="preventiveAntibioticMark">
          <el-input v-model="form.preventiveAntibioticMark" placeholder="请输入是否预防性使用抗生素" />
        </el-form-item>
        <el-form-item label="手术过程描述" prop="proceduresDescription">
            <el-input v-model="form.proceduresDescription" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="麻醉医师代码" prop="asaSurgeonNo">
          <el-input v-model="form.asaSurgeonNo" placeholder="请输入麻醉医师代码" />
        </el-form-item>
        <el-form-item label="麻醉医师职称名称" prop="asaTechnicalTitle">
          <el-input v-model="form.asaTechnicalTitle" placeholder="请输入麻醉医师职称名称" />
        </el-form-item>
        <el-form-item label="麻醉医师职务名称" prop="asaJobTitle">
          <el-input v-model="form.asaJobTitle" placeholder="请输入麻醉医师职务名称" />
        </el-form-item>
        <el-form-item label="麻醉方式代码" prop="anesthesiaTypeCode">
          <el-input v-model="form.anesthesiaTypeCode" placeholder="请输入麻醉方式代码" />
        </el-form-item>
        <el-form-item label="麻醉开始时间" prop="anesthesiaStartTime">
          <el-date-picker clearable
            v-model="form.anesthesiaStartTime"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择麻醉开始时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="麻醉结束时间" prop="anesthesiaEndTime">
          <el-date-picker clearable
            v-model="form.anesthesiaEndTime"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择麻醉结束时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="总入量(ml)" prop="intakeVolume">
          <el-input v-model="form.intakeVolume" placeholder="请输入总入量(ml)" />
        </el-form-item>
        <el-form-item label="总出量(ml)" prop="outputVolume">
          <el-input v-model="form.outputVolume" placeholder="请输入总出量(ml)" />
        </el-form-item>
        <el-form-item label="输血血型-ABO" prop="bloodTransAbo">
          <el-input v-model="form.bloodTransAbo" placeholder="请输入输血血型-ABO" />
        </el-form-item>
        <el-form-item label="输血血型-Rh" prop="bloodTransRh">
          <el-input v-model="form.bloodTransRh" placeholder="请输入输血血型-Rh" />
        </el-form-item>
        <el-form-item label="输血成份类型代码" prop="bloodTransComponentCode">
          <el-input v-model="form.bloodTransComponentCode" placeholder="请输入输血成份类型代码" />
        </el-form-item>
        <el-form-item label="输血成份类型" prop="bloodTransComponent">
          <el-input v-model="form.bloodTransComponent" placeholder="请输入输血成份类型" />
        </el-form-item>
        <el-form-item label="输血量(ml)" prop="bloodTransVolume">
          <el-input v-model="form.bloodTransVolume" placeholder="请输入输血量(ml)" />
        </el-form-item>
        <el-form-item label="出血量(ml)" prop="bloodLossVolume">
          <el-input v-model="form.bloodLossVolume" placeholder="请输入出血量(ml)" />
        </el-form-item>
        <el-form-item label="尿量(ml)" prop="urineVolume">
          <el-input v-model="form.urineVolume" placeholder="请输入尿量(ml)" />
        </el-form-item>
        <el-form-item label="术前主要诊断编码" prop="presurgeryMaindiagCode1">
          <el-input v-model="form.presurgeryMaindiagCode1" placeholder="请输入术前主要诊断编码" />
        </el-form-item>
        <el-form-item label="术前主要诊断名称" prop="presurgeryMaindiagName1">
          <el-input v-model="form.presurgeryMaindiagName1" placeholder="请输入术前主要诊断名称" />
        </el-form-item>
        <el-form-item label="术前诊断编码-2" prop="presurgeryDiagCode2">
          <el-input v-model="form.presurgeryDiagCode2" placeholder="请输入术前诊断编码-2" />
        </el-form-item>
        <el-form-item label="术前诊断名称-2" prop="presurgeryDiagName2">
          <el-input v-model="form.presurgeryDiagName2" placeholder="请输入术前诊断名称-2" />
        </el-form-item>
        <el-form-item label="术前诊断编码-3" prop="presurgeryDiagCode3">
          <el-input v-model="form.presurgeryDiagCode3" placeholder="请输入术前诊断编码-3" />
        </el-form-item>
        <el-form-item label="术前诊断名称-3" prop="presurgeryDiagName3">
          <el-input v-model="form.presurgeryDiagName3" placeholder="请输入术前诊断名称-3" />
        </el-form-item>
        <el-form-item label="术前诊断编码-4" prop="presurgeryDiagCode4">
          <el-input v-model="form.presurgeryDiagCode4" placeholder="请输入术前诊断编码-4" />
        </el-form-item>
        <el-form-item label="术前诊断名称-4" prop="presurgeryDiagName4">
          <el-input v-model="form.presurgeryDiagName4" placeholder="请输入术前诊断名称-4" />
        </el-form-item>
        <el-form-item label="术前诊断编码-5" prop="presurgeryDiagCode5">
          <el-input v-model="form.presurgeryDiagCode5" placeholder="请输入术前诊断编码-5" />
        </el-form-item>
        <el-form-item label="术前诊断名称-5" prop="presurgeryDiagName5">
          <el-input v-model="form.presurgeryDiagName5" placeholder="请输入术前诊断名称-5" />
        </el-form-item>
        <el-form-item label="术中主要诊断编码" prop="intrasurgeryMaindiagCode1">
          <el-input v-model="form.intrasurgeryMaindiagCode1" placeholder="请输入术中主要诊断编码" />
        </el-form-item>
        <el-form-item label="术中主要诊断名称" prop="intrasurgeryMaindiagName1">
          <el-input v-model="form.intrasurgeryMaindiagName1" placeholder="请输入术中主要诊断名称" />
        </el-form-item>
        <el-form-item label="术中诊断编码-2" prop="intrasurgeryDiagCode2">
          <el-input v-model="form.intrasurgeryDiagCode2" placeholder="请输入术中诊断编码-2" />
        </el-form-item>
        <el-form-item label="术中诊断名称-2" prop="intrasurgeryDiagName2">
          <el-input v-model="form.intrasurgeryDiagName2" placeholder="请输入术中诊断名称-2" />
        </el-form-item>
        <el-form-item label="术中诊断编码-3" prop="intrasurgeryDiagCode3">
          <el-input v-model="form.intrasurgeryDiagCode3" placeholder="请输入术中诊断编码-3" />
        </el-form-item>
        <el-form-item label="术中诊断名称-3" prop="intrasurgeryDiagName3">
          <el-input v-model="form.intrasurgeryDiagName3" placeholder="请输入术中诊断名称-3" />
        </el-form-item>
        <el-form-item label="术中诊断编码-4" prop="intrasurgeryDiagCode4">
          <el-input v-model="form.intrasurgeryDiagCode4" placeholder="请输入术中诊断编码-4" />
        </el-form-item>
        <el-form-item label="术中诊断名称-4" prop="intrasurgeryDiagName4">
          <el-input v-model="form.intrasurgeryDiagName4" placeholder="请输入术中诊断名称-4" />
        </el-form-item>
        <el-form-item label="术中诊断编码-5" prop="intrasurgeryDiagCode5">
          <el-input v-model="form.intrasurgeryDiagCode5" placeholder="请输入术中诊断编码-5" />
        </el-form-item>
        <el-form-item label="术中诊断名称-5" prop="intrasurgeryDiagName5">
          <el-input v-model="form.intrasurgeryDiagName5" placeholder="请输入术中诊断名称-5" />
        </el-form-item>
        <el-form-item label="术后主要诊断编码" prop="postsurgeryMaindiagCode1">
          <el-input v-model="form.postsurgeryMaindiagCode1" placeholder="请输入术后主要诊断编码" />
        </el-form-item>
        <el-form-item label="术后主要诊断名称" prop="postsurgeryMaindiagName1">
          <el-input v-model="form.postsurgeryMaindiagName1" placeholder="请输入术后主要诊断名称" />
        </el-form-item>
        <el-form-item label="术后诊断编码-2" prop="postsurgeryDiagCode2">
          <el-input v-model="form.postsurgeryDiagCode2" placeholder="请输入术后诊断编码-2" />
        </el-form-item>
        <el-form-item label="术后诊断名称-2" prop="postsurgeryDiagName2">
          <el-input v-model="form.postsurgeryDiagName2" placeholder="请输入术后诊断名称-2" />
        </el-form-item>
        <el-form-item label="术后诊断编码-3" prop="postsurgeryDiagCode3">
          <el-input v-model="form.postsurgeryDiagCode3" placeholder="请输入术后诊断编码-3" />
        </el-form-item>
        <el-form-item label="术后诊断名称-3" prop="postsurgeryDiagName3">
          <el-input v-model="form.postsurgeryDiagName3" placeholder="请输入术后诊断名称-3" />
        </el-form-item>
        <el-form-item label="术后诊断编码-4" prop="postsurgeryDiagCode4">
          <el-input v-model="form.postsurgeryDiagCode4" placeholder="请输入术后诊断编码-4" />
        </el-form-item>
        <el-form-item label="术后诊断名称-4" prop="postsurgeryDiagName4">
          <el-input v-model="form.postsurgeryDiagName4" placeholder="请输入术后诊断名称-4" />
        </el-form-item>
        <el-form-item label="术后诊断编码-5" prop="postsurgeryDiagCode5">
          <el-input v-model="form.postsurgeryDiagCode5" placeholder="请输入术后诊断编码-5" />
        </el-form-item>
        <el-form-item label="术后诊断名称-5" prop="postsurgeryDiagName5">
          <el-input v-model="form.postsurgeryDiagName5" placeholder="请输入术后诊断名称-5" />
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

<script setup name="NatdssB081InpatientSurgicalRecord" lang="ts">
import { listNatdssB081InpatientSurgicalRecord, getNatdssB081InpatientSurgicalRecord, delNatdssB081InpatientSurgicalRecord, addNatdssB081InpatientSurgicalRecord, updateNatdssB081InpatientSurgicalRecord } from '@/api/natdss/natdssB081InpatientSurgicalRecord';
import { NatdssB081InpatientSurgicalRecordVO, NatdssB081InpatientSurgicalRecordQuery, NatdssB081InpatientSurgicalRecordForm } from '@/api/natdss/natdssB081InpatientSurgicalRecord/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const natdssB081InpatientSurgicalRecordList = ref<NatdssB081InpatientSurgicalRecordVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const natdssB081InpatientSurgicalRecordFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: NatdssB081InpatientSurgicalRecordForm = {
  id: undefined,
  patientId: undefined,
  visitSn: undefined,
  medicalRecordNo: undefined,
  inpatientNo: undefined,
  hospitalizationTimes: undefined,
  recordSn: undefined,
  recordDatetime: undefined,
  surgeonNo: undefined,
  technicalTitle: undefined,
  jobTitle: undefined,
  executiveDeptCode: undefined,
  executiveDeptName: undefined,
  surgeryCode: undefined,
  surgeryName: undefined,
  startDatetime: undefined,
  finishDatetime: undefined,
  incisionType: undefined,
  surgeryLevel: undefined,
  surgicalApproach: undefined,
  preventiveAntibioticMark: undefined,
  proceduresDescription: undefined,
  asaSurgeonNo: undefined,
  asaTechnicalTitle: undefined,
  asaJobTitle: undefined,
  anesthesiaTypeCode: undefined,
  anesthesiaType: undefined,
  asaPhysicalStatus: undefined,
  anesthesiaStartTime: undefined,
  anesthesiaEndTime: undefined,
  intakeVolume: undefined,
  outputVolume: undefined,
  bloodTransAbo: undefined,
  bloodTransRh: undefined,
  bloodTransComponentCode: undefined,
  bloodTransComponent: undefined,
  bloodTransVolume: undefined,
  bloodLossVolume: undefined,
  urineVolume: undefined,
  presurgeryMaindiagCode1: undefined,
  presurgeryMaindiagName1: undefined,
  presurgeryDiagCode2: undefined,
  presurgeryDiagName2: undefined,
  presurgeryDiagCode3: undefined,
  presurgeryDiagName3: undefined,
  presurgeryDiagCode4: undefined,
  presurgeryDiagName4: undefined,
  presurgeryDiagCode5: undefined,
  presurgeryDiagName5: undefined,
  intrasurgeryMaindiagCode1: undefined,
  intrasurgeryMaindiagName1: undefined,
  intrasurgeryDiagCode2: undefined,
  intrasurgeryDiagName2: undefined,
  intrasurgeryDiagCode3: undefined,
  intrasurgeryDiagName3: undefined,
  intrasurgeryDiagCode4: undefined,
  intrasurgeryDiagName4: undefined,
  intrasurgeryDiagCode5: undefined,
  intrasurgeryDiagName5: undefined,
  postsurgeryMaindiagCode1: undefined,
  postsurgeryMaindiagName1: undefined,
  postsurgeryDiagCode2: undefined,
  postsurgeryDiagName2: undefined,
  postsurgeryDiagCode3: undefined,
  postsurgeryDiagName3: undefined,
  postsurgeryDiagCode4: undefined,
  postsurgeryDiagName4: undefined,
  postsurgeryDiagCode5: undefined,
  postsurgeryDiagName5: undefined,
  extendData1: undefined,
  extendData2: undefined,
  recordStatus: undefined,
  createdTime: undefined,
  updatedTime: undefined
}
const data = reactive<PageData<NatdssB081InpatientSurgicalRecordForm, NatdssB081InpatientSurgicalRecordQuery>>({
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
    surgeonNo: undefined,
    technicalTitle: undefined,
    jobTitle: undefined,
    executiveDeptCode: undefined,
    executiveDeptName: undefined,
    surgeryCode: undefined,
    surgeryName: undefined,
    startDatetime: undefined,
    finishDatetime: undefined,
    incisionType: undefined,
    surgeryLevel: undefined,
    surgicalApproach: undefined,
    preventiveAntibioticMark: undefined,
    proceduresDescription: undefined,
    asaSurgeonNo: undefined,
    asaTechnicalTitle: undefined,
    asaJobTitle: undefined,
    anesthesiaTypeCode: undefined,
    anesthesiaType: undefined,
    asaPhysicalStatus: undefined,
    anesthesiaStartTime: undefined,
    anesthesiaEndTime: undefined,
    intakeVolume: undefined,
    outputVolume: undefined,
    bloodTransAbo: undefined,
    bloodTransRh: undefined,
    bloodTransComponentCode: undefined,
    bloodTransComponent: undefined,
    bloodTransVolume: undefined,
    bloodLossVolume: undefined,
    urineVolume: undefined,
    presurgeryMaindiagCode1: undefined,
    presurgeryMaindiagName1: undefined,
    presurgeryDiagCode2: undefined,
    presurgeryDiagName2: undefined,
    presurgeryDiagCode3: undefined,
    presurgeryDiagName3: undefined,
    presurgeryDiagCode4: undefined,
    presurgeryDiagName4: undefined,
    presurgeryDiagCode5: undefined,
    presurgeryDiagName5: undefined,
    intrasurgeryMaindiagCode1: undefined,
    intrasurgeryMaindiagName1: undefined,
    intrasurgeryDiagCode2: undefined,
    intrasurgeryDiagName2: undefined,
    intrasurgeryDiagCode3: undefined,
    intrasurgeryDiagName3: undefined,
    intrasurgeryDiagCode4: undefined,
    intrasurgeryDiagName4: undefined,
    intrasurgeryDiagCode5: undefined,
    intrasurgeryDiagName5: undefined,
    postsurgeryMaindiagCode1: undefined,
    postsurgeryMaindiagName1: undefined,
    postsurgeryDiagCode2: undefined,
    postsurgeryDiagName2: undefined,
    postsurgeryDiagCode3: undefined,
    postsurgeryDiagName3: undefined,
    postsurgeryDiagCode4: undefined,
    postsurgeryDiagName4: undefined,
    postsurgeryDiagCode5: undefined,
    postsurgeryDiagName5: undefined,
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
      { required: true, message: "手术记录流水号不能为空", trigger: "blur" }
    ],
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询B08-1 住院手术记录列表 */
const getList = async () => {
  loading.value = true;
  const res = await listNatdssB081InpatientSurgicalRecord(queryParams.value);
  natdssB081InpatientSurgicalRecordList.value = res.rows;
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
  natdssB081InpatientSurgicalRecordFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: NatdssB081InpatientSurgicalRecordVO[]) => {
  ids.value = selection.map(item => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
}

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = "添加B08-1 住院手术记录";
}

/** 修改按钮操作 */
const handleUpdate = async (row?: NatdssB081InpatientSurgicalRecordVO) => {
  reset();
  const _id = row?.id || ids.value[0]
  const res = await getNatdssB081InpatientSurgicalRecord(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = "修改B08-1 住院手术记录";
}

/** 提交按钮 */
const submitForm = () => {
  natdssB081InpatientSurgicalRecordFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateNatdssB081InpatientSurgicalRecord(form.value).finally(() =>  buttonLoading.value = false);
      } else {
        await addNatdssB081InpatientSurgicalRecord(form.value).finally(() =>  buttonLoading.value = false);
      }
      proxy?.$modal.msgSuccess("操作成功");
      dialog.visible = false;
      await getList();
    }
  });
}

/** 删除按钮操作 */
const handleDelete = async (row?: NatdssB081InpatientSurgicalRecordVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除B08-1 住院手术记录编号为"' + _ids + '"的数据项？').finally(() => loading.value = false);
  await delNatdssB081InpatientSurgicalRecord(_ids);
  proxy?.$modal.msgSuccess("删除成功");
  await getList();
}

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download('natdss/natdssB081InpatientSurgicalRecord/export', {
    ...queryParams.value
  }, `natdssB081InpatientSurgicalRecord_${new Date().getTime()}.xlsx`)
}

onMounted(() => {
  getList();
});
</script>
