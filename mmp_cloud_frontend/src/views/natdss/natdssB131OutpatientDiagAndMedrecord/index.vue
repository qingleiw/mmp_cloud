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
            <el-form-item label="就诊时间" prop="visitDatetime">
              <el-date-picker clearable
                v-model="queryParams.visitDatetime"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择就诊时间"
              />
            </el-form-item>
            <el-form-item label="病历记录流水号" prop="recordSn">
              <el-input v-model="queryParams.recordSn" placeholder="请输入病历记录流水号" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="病历记录时间" prop="recordDatetime">
              <el-date-picker clearable
                v-model="queryParams.recordDatetime"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择病历记录时间"
              />
            </el-form-item>
            <el-form-item label="病历文书内容" prop="recordText">
              <el-input v-model="queryParams.recordText" placeholder="请输入病历文书内容" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="诊疗经过" prop="treatmentInfo">
              <el-input v-model="queryParams.treatmentInfo" placeholder="请输入诊疗经过" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="操作记录" prop="operationInfo">
              <el-input v-model="queryParams.operationInfo" placeholder="请输入操作记录" clearable @keyup.enter="handleQuery" />
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
            <el-form-item label="体格检查" prop="physicalExam">
              <el-input v-model="queryParams.physicalExam" placeholder="请输入体格检查" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="中医病名" prop="tcmDiseaseName">
              <el-input v-model="queryParams.tcmDiseaseName" placeholder="请输入中医病名" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="中医证候" prop="tcmSyndromeName">
              <el-input v-model="queryParams.tcmSyndromeName" placeholder="请输入中医证候" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="诊断时间" prop="diagnoseDatetime">
              <el-date-picker clearable
                v-model="queryParams.diagnoseDatetime"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择诊断时间"
              />
            </el-form-item>
            <el-form-item label="主要诊断编码" prop="maindiagCode1">
              <el-input v-model="queryParams.maindiagCode1" placeholder="请输入主要诊断编码" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主要诊断名称" prop="maindiagName1">
              <el-input v-model="queryParams.maindiagName1" placeholder="请输入主要诊断名称" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="诊断编码-2" prop="diagCode2">
              <el-input v-model="queryParams.diagCode2" placeholder="请输入诊断编码-2" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="诊断名称-2" prop="diagName2">
              <el-input v-model="queryParams.diagName2" placeholder="请输入诊断名称-2" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="诊断编码-3" prop="diagCode3">
              <el-input v-model="queryParams.diagCode3" placeholder="请输入诊断编码-3" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="诊断名称-3" prop="diagName3">
              <el-input v-model="queryParams.diagName3" placeholder="请输入诊断名称-3" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="诊断编码-4" prop="diagCode4">
              <el-input v-model="queryParams.diagCode4" placeholder="请输入诊断编码-4" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="诊断名称-4" prop="diagName4">
              <el-input v-model="queryParams.diagName4" placeholder="请输入诊断名称-4" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="诊断编码-5" prop="diagCode5">
              <el-input v-model="queryParams.diagCode5" placeholder="请输入诊断编码-5" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="诊断名称-5" prop="diagName5">
              <el-input v-model="queryParams.diagName5" placeholder="请输入诊断名称-5" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="诊断编码-6" prop="diagCode6">
              <el-input v-model="queryParams.diagCode6" placeholder="请输入诊断编码-6" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="诊断名称-6" prop="diagName6">
              <el-input v-model="queryParams.diagName6" placeholder="请输入诊断名称-6" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="诊断编码-7" prop="diagCode7">
              <el-input v-model="queryParams.diagCode7" placeholder="请输入诊断编码-7" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="诊断名称-7" prop="diagName7">
              <el-input v-model="queryParams.diagName7" placeholder="请输入诊断名称-7" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="诊断编码-8" prop="diagCode8">
              <el-input v-model="queryParams.diagCode8" placeholder="请输入诊断编码-8" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="诊断名称-8" prop="diagName8">
              <el-input v-model="queryParams.diagName8" placeholder="请输入诊断名称-8" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="诊断编码-9" prop="diagCode9">
              <el-input v-model="queryParams.diagCode9" placeholder="请输入诊断编码-9" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="诊断名称-9" prop="diagName9">
              <el-input v-model="queryParams.diagName9" placeholder="请输入诊断名称-9" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="诊断编码-10" prop="diagCode10">
              <el-input v-model="queryParams.diagCode10" placeholder="请输入诊断编码-10" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="诊断名称-10" prop="diagName10">
              <el-input v-model="queryParams.diagName10" placeholder="请输入诊断名称-10" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="诊断编码-N" prop="diagCoden">
              <el-input v-model="queryParams.diagCoden" placeholder="请输入诊断编码-N" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="诊断名称-N" prop="diagNamen">
              <el-input v-model="queryParams.diagNamen" placeholder="请输入诊断名称-N" clearable @keyup.enter="handleQuery" />
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
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['natdss:natdssB131OutpatientDiagAndMedrecord:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="success" plain icon="Edit" :disabled="single" @click="handleUpdate()" v-hasPermi="['natdss:natdssB131OutpatientDiagAndMedrecord:edit']">修改</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="danger" plain icon="Delete" :disabled="multiple" @click="handleDelete()" v-hasPermi="['natdss:natdssB131OutpatientDiagAndMedrecord:remove']">删除</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['natdss:natdssB131OutpatientDiagAndMedrecord:export']">导出</el-button>
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" border :data="natdssB131OutpatientDiagAndMedrecordList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="系统自增主键" align="center" prop="id" v-if="true" />
        <el-table-column label="患者ID" align="center" prop="patientId" />
        <el-table-column label="单次就诊唯一标识号" align="center" prop="visitSn" />
        <el-table-column label="就诊类型:门诊、急诊" align="center" prop="visitType" />
        <el-table-column label="就诊卡号" align="center" prop="visitCardNo" />
        <el-table-column label="门诊号" align="center" prop="outpatientNo" />
        <el-table-column label="就诊次数" align="center" prop="visitTimes" />
        <el-table-column label="就诊时间" align="center" prop="visitDatetime" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.visitDatetime, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="病历记录流水号" align="center" prop="recordSn" />
        <el-table-column label="病历记录时间" align="center" prop="recordDatetime" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.recordDatetime, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="病历文书内容" align="center" prop="recordText" />
        <el-table-column label="诊疗经过" align="center" prop="treatmentInfo" />
        <el-table-column label="操作记录" align="center" prop="operationInfo" />
        <el-table-column label="主诉" align="center" prop="chiefComplaint" />
        <el-table-column label="现病史" align="center" prop="currentMedhistory" />
        <el-table-column label="既往史" align="center" prop="pastMedhistory" />
        <el-table-column label="个人史" align="center" prop="personalMedhistory" />
        <el-table-column label="家族史" align="center" prop="familyHistory" />
        <el-table-column label="婚育史" align="center" prop="marriageBirthHistory" />
        <el-table-column label="月经史" align="center" prop="menstrualHistory" />
        <el-table-column label="体格检查" align="center" prop="physicalExam" />
        <el-table-column label="中医病名" align="center" prop="tcmDiseaseName" />
        <el-table-column label="中医证候" align="center" prop="tcmSyndromeName" />
        <el-table-column label="诊断时间" align="center" prop="diagnoseDatetime" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.diagnoseDatetime, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="主要诊断编码" align="center" prop="maindiagCode1" />
        <el-table-column label="主要诊断名称" align="center" prop="maindiagName1" />
        <el-table-column label="诊断编码-2" align="center" prop="diagCode2" />
        <el-table-column label="诊断名称-2" align="center" prop="diagName2" />
        <el-table-column label="诊断编码-3" align="center" prop="diagCode3" />
        <el-table-column label="诊断名称-3" align="center" prop="diagName3" />
        <el-table-column label="诊断编码-4" align="center" prop="diagCode4" />
        <el-table-column label="诊断名称-4" align="center" prop="diagName4" />
        <el-table-column label="诊断编码-5" align="center" prop="diagCode5" />
        <el-table-column label="诊断名称-5" align="center" prop="diagName5" />
        <el-table-column label="诊断编码-6" align="center" prop="diagCode6" />
        <el-table-column label="诊断名称-6" align="center" prop="diagName6" />
        <el-table-column label="诊断编码-7" align="center" prop="diagCode7" />
        <el-table-column label="诊断名称-7" align="center" prop="diagName7" />
        <el-table-column label="诊断编码-8" align="center" prop="diagCode8" />
        <el-table-column label="诊断名称-8" align="center" prop="diagName8" />
        <el-table-column label="诊断编码-9" align="center" prop="diagCode9" />
        <el-table-column label="诊断名称-9" align="center" prop="diagName9" />
        <el-table-column label="诊断编码-10" align="center" prop="diagCode10" />
        <el-table-column label="诊断名称-10" align="center" prop="diagName10" />
        <el-table-column label="诊断编码-N" align="center" prop="diagCoden" />
        <el-table-column label="诊断名称-N" align="center" prop="diagNamen" />
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
              <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['natdss:natdssB131OutpatientDiagAndMedrecord:edit']"></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)" v-hasPermi="['natdss:natdssB131OutpatientDiagAndMedrecord:remove']"></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改B13-1 门诊病历记录对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="natdssB131OutpatientDiagAndMedrecordFormRef" :model="form" :rules="rules" label-width="80px">
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
        <el-form-item label="就诊时间" prop="visitDatetime">
          <el-date-picker clearable
            v-model="form.visitDatetime"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择就诊时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="病历记录流水号" prop="recordSn">
          <el-input v-model="form.recordSn" placeholder="请输入病历记录流水号" />
        </el-form-item>
        <el-form-item label="病历记录时间" prop="recordDatetime">
          <el-date-picker clearable
            v-model="form.recordDatetime"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择病历记录时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="病历文书内容" prop="recordText">
            <el-input v-model="form.recordText" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="诊疗经过" prop="treatmentInfo">
            <el-input v-model="form.treatmentInfo" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="操作记录" prop="operationInfo">
            <el-input v-model="form.operationInfo" type="textarea" placeholder="请输入内容" />
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
        <el-form-item label="体格检查" prop="physicalExam">
            <el-input v-model="form.physicalExam" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="中医病名" prop="tcmDiseaseName">
          <el-input v-model="form.tcmDiseaseName" placeholder="请输入中医病名" />
        </el-form-item>
        <el-form-item label="中医证候" prop="tcmSyndromeName">
          <el-input v-model="form.tcmSyndromeName" placeholder="请输入中医证候" />
        </el-form-item>
        <el-form-item label="诊断时间" prop="diagnoseDatetime">
          <el-date-picker clearable
            v-model="form.diagnoseDatetime"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择诊断时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="主要诊断编码" prop="maindiagCode1">
          <el-input v-model="form.maindiagCode1" placeholder="请输入主要诊断编码" />
        </el-form-item>
        <el-form-item label="主要诊断名称" prop="maindiagName1">
          <el-input v-model="form.maindiagName1" placeholder="请输入主要诊断名称" />
        </el-form-item>
        <el-form-item label="诊断编码-2" prop="diagCode2">
          <el-input v-model="form.diagCode2" placeholder="请输入诊断编码-2" />
        </el-form-item>
        <el-form-item label="诊断名称-2" prop="diagName2">
          <el-input v-model="form.diagName2" placeholder="请输入诊断名称-2" />
        </el-form-item>
        <el-form-item label="诊断编码-3" prop="diagCode3">
          <el-input v-model="form.diagCode3" placeholder="请输入诊断编码-3" />
        </el-form-item>
        <el-form-item label="诊断名称-3" prop="diagName3">
          <el-input v-model="form.diagName3" placeholder="请输入诊断名称-3" />
        </el-form-item>
        <el-form-item label="诊断编码-4" prop="diagCode4">
          <el-input v-model="form.diagCode4" placeholder="请输入诊断编码-4" />
        </el-form-item>
        <el-form-item label="诊断名称-4" prop="diagName4">
          <el-input v-model="form.diagName4" placeholder="请输入诊断名称-4" />
        </el-form-item>
        <el-form-item label="诊断编码-5" prop="diagCode5">
          <el-input v-model="form.diagCode5" placeholder="请输入诊断编码-5" />
        </el-form-item>
        <el-form-item label="诊断名称-5" prop="diagName5">
          <el-input v-model="form.diagName5" placeholder="请输入诊断名称-5" />
        </el-form-item>
        <el-form-item label="诊断编码-6" prop="diagCode6">
          <el-input v-model="form.diagCode6" placeholder="请输入诊断编码-6" />
        </el-form-item>
        <el-form-item label="诊断名称-6" prop="diagName6">
          <el-input v-model="form.diagName6" placeholder="请输入诊断名称-6" />
        </el-form-item>
        <el-form-item label="诊断编码-7" prop="diagCode7">
          <el-input v-model="form.diagCode7" placeholder="请输入诊断编码-7" />
        </el-form-item>
        <el-form-item label="诊断名称-7" prop="diagName7">
          <el-input v-model="form.diagName7" placeholder="请输入诊断名称-7" />
        </el-form-item>
        <el-form-item label="诊断编码-8" prop="diagCode8">
          <el-input v-model="form.diagCode8" placeholder="请输入诊断编码-8" />
        </el-form-item>
        <el-form-item label="诊断名称-8" prop="diagName8">
          <el-input v-model="form.diagName8" placeholder="请输入诊断名称-8" />
        </el-form-item>
        <el-form-item label="诊断编码-9" prop="diagCode9">
          <el-input v-model="form.diagCode9" placeholder="请输入诊断编码-9" />
        </el-form-item>
        <el-form-item label="诊断名称-9" prop="diagName9">
          <el-input v-model="form.diagName9" placeholder="请输入诊断名称-9" />
        </el-form-item>
        <el-form-item label="诊断编码-10" prop="diagCode10">
          <el-input v-model="form.diagCode10" placeholder="请输入诊断编码-10" />
        </el-form-item>
        <el-form-item label="诊断名称-10" prop="diagName10">
          <el-input v-model="form.diagName10" placeholder="请输入诊断名称-10" />
        </el-form-item>
        <el-form-item label="诊断编码-N" prop="diagCoden">
            <el-input v-model="form.diagCoden" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="诊断名称-N" prop="diagNamen">
            <el-input v-model="form.diagNamen" type="textarea" placeholder="请输入内容" />
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

<script setup name="NatdssB131OutpatientDiagAndMedrecord" lang="ts">
import { listNatdssB131OutpatientDiagAndMedrecord, getNatdssB131OutpatientDiagAndMedrecord, delNatdssB131OutpatientDiagAndMedrecord, addNatdssB131OutpatientDiagAndMedrecord, updateNatdssB131OutpatientDiagAndMedrecord } from '@/api/natdss/natdssB131OutpatientDiagAndMedrecord';
import { NatdssB131OutpatientDiagAndMedrecordVO, NatdssB131OutpatientDiagAndMedrecordQuery, NatdssB131OutpatientDiagAndMedrecordForm } from '@/api/natdss/natdssB131OutpatientDiagAndMedrecord/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const natdssB131OutpatientDiagAndMedrecordList = ref<NatdssB131OutpatientDiagAndMedrecordVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const natdssB131OutpatientDiagAndMedrecordFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: NatdssB131OutpatientDiagAndMedrecordForm = {
  id: undefined,
  patientId: undefined,
  visitSn: undefined,
  visitType: undefined,
  visitCardNo: undefined,
  outpatientNo: undefined,
  visitTimes: undefined,
  visitDatetime: undefined,
  recordSn: undefined,
  recordDatetime: undefined,
  recordText: undefined,
  treatmentInfo: undefined,
  operationInfo: undefined,
  chiefComplaint: undefined,
  currentMedhistory: undefined,
  pastMedhistory: undefined,
  personalMedhistory: undefined,
  familyHistory: undefined,
  marriageBirthHistory: undefined,
  menstrualHistory: undefined,
  physicalExam: undefined,
  tcmDiseaseName: undefined,
  tcmSyndromeName: undefined,
  diagnoseDatetime: undefined,
  maindiagCode1: undefined,
  maindiagName1: undefined,
  diagCode2: undefined,
  diagName2: undefined,
  diagCode3: undefined,
  diagName3: undefined,
  diagCode4: undefined,
  diagName4: undefined,
  diagCode5: undefined,
  diagName5: undefined,
  diagCode6: undefined,
  diagName6: undefined,
  diagCode7: undefined,
  diagName7: undefined,
  diagCode8: undefined,
  diagName8: undefined,
  diagCode9: undefined,
  diagName9: undefined,
  diagCode10: undefined,
  diagName10: undefined,
  diagCoden: undefined,
  diagNamen: undefined,
  extendData1: undefined,
  extendData2: undefined,
  recordStatus: undefined,
  createdTime: undefined,
  updatedTime: undefined
}
const data = reactive<PageData<NatdssB131OutpatientDiagAndMedrecordForm, NatdssB131OutpatientDiagAndMedrecordQuery>>({
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
    visitDatetime: undefined,
    recordSn: undefined,
    recordDatetime: undefined,
    recordText: undefined,
    treatmentInfo: undefined,
    operationInfo: undefined,
    chiefComplaint: undefined,
    currentMedhistory: undefined,
    pastMedhistory: undefined,
    personalMedhistory: undefined,
    familyHistory: undefined,
    marriageBirthHistory: undefined,
    menstrualHistory: undefined,
    physicalExam: undefined,
    tcmDiseaseName: undefined,
    tcmSyndromeName: undefined,
    diagnoseDatetime: undefined,
    maindiagCode1: undefined,
    maindiagName1: undefined,
    diagCode2: undefined,
    diagName2: undefined,
    diagCode3: undefined,
    diagName3: undefined,
    diagCode4: undefined,
    diagName4: undefined,
    diagCode5: undefined,
    diagName5: undefined,
    diagCode6: undefined,
    diagName6: undefined,
    diagCode7: undefined,
    diagName7: undefined,
    diagCode8: undefined,
    diagName8: undefined,
    diagCode9: undefined,
    diagName9: undefined,
    diagCode10: undefined,
    diagName10: undefined,
    diagCoden: undefined,
    diagNamen: undefined,
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
      { required: true, message: "病历记录流水号不能为空", trigger: "blur" }
    ],
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询B13-1 门诊病历记录列表 */
const getList = async () => {
  loading.value = true;
  const res = await listNatdssB131OutpatientDiagAndMedrecord(queryParams.value);
  natdssB131OutpatientDiagAndMedrecordList.value = res.rows;
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
  natdssB131OutpatientDiagAndMedrecordFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: NatdssB131OutpatientDiagAndMedrecordVO[]) => {
  ids.value = selection.map(item => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
}

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = "添加B13-1 门诊病历记录";
}

/** 修改按钮操作 */
const handleUpdate = async (row?: NatdssB131OutpatientDiagAndMedrecordVO) => {
  reset();
  const _id = row?.id || ids.value[0]
  const res = await getNatdssB131OutpatientDiagAndMedrecord(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = "修改B13-1 门诊病历记录";
}

/** 提交按钮 */
const submitForm = () => {
  natdssB131OutpatientDiagAndMedrecordFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateNatdssB131OutpatientDiagAndMedrecord(form.value).finally(() =>  buttonLoading.value = false);
      } else {
        await addNatdssB131OutpatientDiagAndMedrecord(form.value).finally(() =>  buttonLoading.value = false);
      }
      proxy?.$modal.msgSuccess("操作成功");
      dialog.visible = false;
      await getList();
    }
  });
}

/** 删除按钮操作 */
const handleDelete = async (row?: NatdssB131OutpatientDiagAndMedrecordVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除B13-1 门诊病历记录编号为"' + _ids + '"的数据项？').finally(() => loading.value = false);
  await delNatdssB131OutpatientDiagAndMedrecord(_ids);
  proxy?.$modal.msgSuccess("删除成功");
  await getList();
}

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download('natdss/natdssB131OutpatientDiagAndMedrecord/export', {
    ...queryParams.value
  }, `natdssB131OutpatientDiagAndMedrecord_${new Date().getTime()}.xlsx`)
}

onMounted(() => {
  getList();
});
</script>
