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
            <el-form-item label="病案号" prop="medicalRecordNo">
              <el-input v-model="queryParams.medicalRecordNo" placeholder="请输入病案号" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="住院号" prop="inpatientNo">
              <el-input v-model="queryParams.inpatientNo" placeholder="请输入住院号" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="姓名" prop="name">
              <el-input v-model="queryParams.name" placeholder="请输入姓名" clearable @keyup.enter="handleQuery" />
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
            <el-form-item label="随访流水号" prop="followupSn">
              <el-input v-model="queryParams.followupSn" placeholder="请输入随访流水号" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="随访方式" prop="followupMethod">
              <el-input v-model="queryParams.followupMethod" placeholder="请输入随访方式" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="初治年龄" prop="firstTreatAge">
              <el-input v-model="queryParams.firstTreatAge" placeholder="请输入初治年龄" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="初治日期" prop="firstTreatDatetime">
              <el-date-picker clearable
                v-model="queryParams.firstTreatDatetime"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择初治日期"
              />
            </el-form-item>
            <el-form-item label="随访周期" prop="followupPeriod">
              <el-input v-model="queryParams.followupPeriod" placeholder="请输入随访周期" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="随访日期" prop="followupDatetime">
              <el-date-picker clearable
                v-model="queryParams.followupDatetime"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择随访日期"
              />
            </el-form-item>
            <el-form-item label="随访状态代码" prop="followupStatusCode">
              <el-input v-model="queryParams.followupStatusCode" placeholder="请输入随访状态代码" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="死亡日期" prop="deathDatetime">
              <el-date-picker clearable
                v-model="queryParams.deathDatetime"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择死亡日期"
              />
            </el-form-item>
            <el-form-item label="死亡原因" prop="causeOfDeath">
              <el-input v-model="queryParams.causeOfDeath" placeholder="请输入死亡原因" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="复发日期" prop="recurDatetime">
              <el-date-picker clearable
                v-model="queryParams.recurDatetime"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择复发日期"
              />
            </el-form-item>
            <el-form-item label="复发诊断编码" prop="recurDiagCode">
              <el-input v-model="queryParams.recurDiagCode" placeholder="请输入复发诊断编码" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="复发诊断名称" prop="recurDiagName">
              <el-input v-model="queryParams.recurDiagName" placeholder="请输入复发诊断名称" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="首次复发转移日期" prop="firstRecurMetsDate">
              <el-date-picker clearable
                v-model="queryParams.firstRecurMetsDate"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择首次复发转移日期"
              />
            </el-form-item>
            <el-form-item label="转移日期" prop="metsDatetime">
              <el-date-picker clearable
                v-model="queryParams.metsDatetime"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择转移日期"
              />
            </el-form-item>
            <el-form-item label="转移部位" prop="metsSite">
              <el-input v-model="queryParams.metsSite" placeholder="请输入转移部位" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="转移诊断编码" prop="metsDiagCode">
              <el-input v-model="queryParams.metsDiagCode" placeholder="请输入转移诊断编码" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="转移诊断名称" prop="metsDiagName">
              <el-input v-model="queryParams.metsDiagName" placeholder="请输入转移诊断名称" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="多原发诊断编码" prop="mulpriDiagCode">
              <el-input v-model="queryParams.mulpriDiagCode" placeholder="请输入多原发诊断编码" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="多原发诊断名称" prop="mulpriDiagName">
              <el-input v-model="queryParams.mulpriDiagName" placeholder="请输入多原发诊断名称" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="随访结论" prop="followupConclusion">
              <el-input v-model="queryParams.followupConclusion" placeholder="请输入随访结论" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="证件号码" prop="certificateNo">
              <el-input v-model="queryParams.certificateNo" placeholder="请输入证件号码" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="现住址" prop="currentAddress">
              <el-input v-model="queryParams.currentAddress" placeholder="请输入现住址" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="联系电话" prop="phoneNo">
              <el-input v-model="queryParams.phoneNo" placeholder="请输入联系电话" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="联系电话2" prop="phoneNo2">
              <el-input v-model="queryParams.phoneNo2" placeholder="请输入联系电话2" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="邮箱" prop="email">
              <el-input v-model="queryParams.email" placeholder="请输入邮箱" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="微信" prop="weixin">
              <el-input v-model="queryParams.weixin" placeholder="请输入微信" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="紧急联系人1" prop="contactPerson1">
              <el-input v-model="queryParams.contactPerson1" placeholder="请输入紧急联系人1" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="紧急联系人电话1" prop="contactPhoneNo1">
              <el-input v-model="queryParams.contactPhoneNo1" placeholder="请输入紧急联系人电话1" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="紧急联系人2" prop="contactPerson2">
              <el-input v-model="queryParams.contactPerson2" placeholder="请输入紧急联系人2" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="紧急联系人电话2" prop="contactPhoneNo2">
              <el-input v-model="queryParams.contactPhoneNo2" placeholder="请输入紧急联系人电话2" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="扩展字段1" prop="extendData1">
              <el-input v-model="queryParams.extendData1" placeholder="请输入扩展字段1" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="扩展字段2" prop="extendData2">
              <el-input v-model="queryParams.extendData2" placeholder="请输入扩展字段2" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="不良反应" prop="adverseReaction">
              <el-input v-model="queryParams.adverseReaction" placeholder="请输入不良反应" clearable @keyup.enter="handleQuery" />
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
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['natdss:natdssB191FollowUp:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="success" plain icon="Edit" :disabled="single" @click="handleUpdate()" v-hasPermi="['natdss:natdssB191FollowUp:edit']">修改</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="danger" plain icon="Delete" :disabled="multiple" @click="handleDelete()" v-hasPermi="['natdss:natdssB191FollowUp:remove']">删除</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['natdss:natdssB191FollowUp:export']">导出</el-button>
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" border :data="natdssB191FollowUpList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="系统自增主键" align="center" prop="id" v-if="true" />
        <el-table-column label="患者ID" align="center" prop="patientId" />
        <el-table-column label="单次就诊唯一标识号" align="center" prop="visitSn" />
        <el-table-column label="就诊类型:住院、门诊" align="center" prop="visitType" />
        <el-table-column label="就诊卡号" align="center" prop="visitCardNo" />
        <el-table-column label="门诊号" align="center" prop="outpatientNo" />
        <el-table-column label="病案号" align="center" prop="medicalRecordNo" />
        <el-table-column label="住院号" align="center" prop="inpatientNo" />
        <el-table-column label="姓名" align="center" prop="name" />
        <el-table-column label="性别" align="center" prop="gender" />
        <el-table-column label="年龄(岁)" align="center" prop="age" />
        <el-table-column label="出生日期" align="center" prop="dateOfBirth" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.dateOfBirth, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="随访流水号" align="center" prop="followupSn" />
        <el-table-column label="随访方式" align="center" prop="followupMethod" />
        <el-table-column label="初治年龄" align="center" prop="firstTreatAge" />
        <el-table-column label="初治日期" align="center" prop="firstTreatDatetime" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.firstTreatDatetime, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="随访周期" align="center" prop="followupPeriod" />
        <el-table-column label="随访日期" align="center" prop="followupDatetime" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.followupDatetime, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="随访状态代码" align="center" prop="followupStatusCode" />
        <el-table-column label="随访状态" align="center" prop="followupStatus" />
        <el-table-column label="身体状况" align="center" prop="healthStatus" />
        <el-table-column label="死亡日期" align="center" prop="deathDatetime" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.deathDatetime, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="死亡原因" align="center" prop="causeOfDeath" />
        <el-table-column label="复发日期" align="center" prop="recurDatetime" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.recurDatetime, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="复发诊断编码" align="center" prop="recurDiagCode" />
        <el-table-column label="复发诊断名称" align="center" prop="recurDiagName" />
        <el-table-column label="首次复发转移日期" align="center" prop="firstRecurMetsDate" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.firstRecurMetsDate, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="转移日期" align="center" prop="metsDatetime" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.metsDatetime, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="转移部位" align="center" prop="metsSite" />
        <el-table-column label="转移诊断编码" align="center" prop="metsDiagCode" />
        <el-table-column label="转移诊断名称" align="center" prop="metsDiagName" />
        <el-table-column label="多原发诊断编码" align="center" prop="mulpriDiagCode" />
        <el-table-column label="多原发诊断名称" align="center" prop="mulpriDiagName" />
        <el-table-column label="随访结论" align="center" prop="followupConclusion" />
        <el-table-column label="证件类型" align="center" prop="certificateType" />
        <el-table-column label="证件号码" align="center" prop="certificateNo" />
        <el-table-column label="现住址" align="center" prop="currentAddress" />
        <el-table-column label="联系电话" align="center" prop="phoneNo" />
        <el-table-column label="联系电话2" align="center" prop="phoneNo2" />
        <el-table-column label="邮箱" align="center" prop="email" />
        <el-table-column label="微信" align="center" prop="weixin" />
        <el-table-column label="紧急联系人1" align="center" prop="contactPerson1" />
        <el-table-column label="紧急联系人电话1" align="center" prop="contactPhoneNo1" />
        <el-table-column label="紧急联系人2" align="center" prop="contactPerson2" />
        <el-table-column label="紧急联系人电话2" align="center" prop="contactPhoneNo2" />
        <el-table-column label="扩展字段1" align="center" prop="extendData1" />
        <el-table-column label="扩展字段2" align="center" prop="extendData2" />
        <el-table-column label="记录状态:1正常 0作废" align="center" prop="recordStatus" />
        <el-table-column label="不良反应" align="center" prop="adverseReaction" />
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
              <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['natdss:natdssB191FollowUp:edit']"></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)" v-hasPermi="['natdss:natdssB191FollowUp:remove']"></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改B19-1 随访记录对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="natdssB191FollowUpFormRef" :model="form" :rules="rules" label-width="80px">
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
        <el-form-item label="病案号" prop="medicalRecordNo">
          <el-input v-model="form.medicalRecordNo" placeholder="请输入病案号" />
        </el-form-item>
        <el-form-item label="住院号" prop="inpatientNo">
          <el-input v-model="form.inpatientNo" placeholder="请输入住院号" />
        </el-form-item>
        <el-form-item label="姓名" prop="name">
          <el-input v-model="form.name" placeholder="请输入姓名" />
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
        <el-form-item label="随访流水号" prop="followupSn">
          <el-input v-model="form.followupSn" placeholder="请输入随访流水号" />
        </el-form-item>
        <el-form-item label="随访方式" prop="followupMethod">
          <el-input v-model="form.followupMethod" placeholder="请输入随访方式" />
        </el-form-item>
        <el-form-item label="初治年龄" prop="firstTreatAge">
          <el-input v-model="form.firstTreatAge" placeholder="请输入初治年龄" />
        </el-form-item>
        <el-form-item label="初治日期" prop="firstTreatDatetime">
          <el-date-picker clearable
            v-model="form.firstTreatDatetime"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择初治日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="随访周期" prop="followupPeriod">
          <el-input v-model="form.followupPeriod" placeholder="请输入随访周期" />
        </el-form-item>
        <el-form-item label="随访日期" prop="followupDatetime">
          <el-date-picker clearable
            v-model="form.followupDatetime"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择随访日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="随访状态代码" prop="followupStatusCode">
          <el-input v-model="form.followupStatusCode" placeholder="请输入随访状态代码" />
        </el-form-item>
        <el-form-item label="死亡日期" prop="deathDatetime">
          <el-date-picker clearable
            v-model="form.deathDatetime"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择死亡日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="死亡原因" prop="causeOfDeath">
          <el-input v-model="form.causeOfDeath" placeholder="请输入死亡原因" />
        </el-form-item>
        <el-form-item label="复发日期" prop="recurDatetime">
          <el-date-picker clearable
            v-model="form.recurDatetime"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择复发日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="复发诊断编码" prop="recurDiagCode">
          <el-input v-model="form.recurDiagCode" placeholder="请输入复发诊断编码" />
        </el-form-item>
        <el-form-item label="复发诊断名称" prop="recurDiagName">
          <el-input v-model="form.recurDiagName" placeholder="请输入复发诊断名称" />
        </el-form-item>
        <el-form-item label="首次复发转移日期" prop="firstRecurMetsDate">
          <el-date-picker clearable
            v-model="form.firstRecurMetsDate"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择首次复发转移日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="转移日期" prop="metsDatetime">
          <el-date-picker clearable
            v-model="form.metsDatetime"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择转移日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="转移部位" prop="metsSite">
          <el-input v-model="form.metsSite" placeholder="请输入转移部位" />
        </el-form-item>
        <el-form-item label="转移诊断编码" prop="metsDiagCode">
          <el-input v-model="form.metsDiagCode" placeholder="请输入转移诊断编码" />
        </el-form-item>
        <el-form-item label="转移诊断名称" prop="metsDiagName">
          <el-input v-model="form.metsDiagName" placeholder="请输入转移诊断名称" />
        </el-form-item>
        <el-form-item label="多原发诊断编码" prop="mulpriDiagCode">
          <el-input v-model="form.mulpriDiagCode" placeholder="请输入多原发诊断编码" />
        </el-form-item>
        <el-form-item label="多原发诊断名称" prop="mulpriDiagName">
          <el-input v-model="form.mulpriDiagName" placeholder="请输入多原发诊断名称" />
        </el-form-item>
        <el-form-item label="随访结论" prop="followupConclusion">
            <el-input v-model="form.followupConclusion" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="证件号码" prop="certificateNo">
          <el-input v-model="form.certificateNo" placeholder="请输入证件号码" />
        </el-form-item>
        <el-form-item label="现住址" prop="currentAddress">
          <el-input v-model="form.currentAddress" placeholder="请输入现住址" />
        </el-form-item>
        <el-form-item label="联系电话" prop="phoneNo">
          <el-input v-model="form.phoneNo" placeholder="请输入联系电话" />
        </el-form-item>
        <el-form-item label="联系电话2" prop="phoneNo2">
          <el-input v-model="form.phoneNo2" placeholder="请输入联系电话2" />
        </el-form-item>
        <el-form-item label="邮箱" prop="email">
          <el-input v-model="form.email" placeholder="请输入邮箱" />
        </el-form-item>
        <el-form-item label="微信" prop="weixin">
          <el-input v-model="form.weixin" placeholder="请输入微信" />
        </el-form-item>
        <el-form-item label="紧急联系人1" prop="contactPerson1">
          <el-input v-model="form.contactPerson1" placeholder="请输入紧急联系人1" />
        </el-form-item>
        <el-form-item label="紧急联系人电话1" prop="contactPhoneNo1">
          <el-input v-model="form.contactPhoneNo1" placeholder="请输入紧急联系人电话1" />
        </el-form-item>
        <el-form-item label="紧急联系人2" prop="contactPerson2">
          <el-input v-model="form.contactPerson2" placeholder="请输入紧急联系人2" />
        </el-form-item>
        <el-form-item label="紧急联系人电话2" prop="contactPhoneNo2">
          <el-input v-model="form.contactPhoneNo2" placeholder="请输入紧急联系人电话2" />
        </el-form-item>
        <el-form-item label="扩展字段1" prop="extendData1">
            <el-input v-model="form.extendData1" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="扩展字段2" prop="extendData2">
            <el-input v-model="form.extendData2" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="不良反应" prop="adverseReaction">
          <el-input v-model="form.adverseReaction" placeholder="请输入不良反应" />
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

<script setup name="NatdssB191FollowUp" lang="ts">
import { listNatdssB191FollowUp, getNatdssB191FollowUp, delNatdssB191FollowUp, addNatdssB191FollowUp, updateNatdssB191FollowUp } from '@/api/natdss/natdssB191FollowUp';
import { NatdssB191FollowUpVO, NatdssB191FollowUpQuery, NatdssB191FollowUpForm } from '@/api/natdss/natdssB191FollowUp/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const natdssB191FollowUpList = ref<NatdssB191FollowUpVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const natdssB191FollowUpFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: NatdssB191FollowUpForm = {
  id: undefined,
  patientId: undefined,
  visitSn: undefined,
  visitType: undefined,
  visitCardNo: undefined,
  outpatientNo: undefined,
  medicalRecordNo: undefined,
  inpatientNo: undefined,
  name: undefined,
  gender: undefined,
  age: undefined,
  dateOfBirth: undefined,
  followupSn: undefined,
  followupMethod: undefined,
  firstTreatAge: undefined,
  firstTreatDatetime: undefined,
  followupPeriod: undefined,
  followupDatetime: undefined,
  followupStatusCode: undefined,
  followupStatus: undefined,
  healthStatus: undefined,
  deathDatetime: undefined,
  causeOfDeath: undefined,
  recurDatetime: undefined,
  recurDiagCode: undefined,
  recurDiagName: undefined,
  firstRecurMetsDate: undefined,
  metsDatetime: undefined,
  metsSite: undefined,
  metsDiagCode: undefined,
  metsDiagName: undefined,
  mulpriDiagCode: undefined,
  mulpriDiagName: undefined,
  followupConclusion: undefined,
  certificateType: undefined,
  certificateNo: undefined,
  currentAddress: undefined,
  phoneNo: undefined,
  phoneNo2: undefined,
  email: undefined,
  weixin: undefined,
  contactPerson1: undefined,
  contactPhoneNo1: undefined,
  contactPerson2: undefined,
  contactPhoneNo2: undefined,
  extendData1: undefined,
  extendData2: undefined,
  recordStatus: undefined,
  adverseReaction: undefined,
  createdTime: undefined,
  updatedTime: undefined
}
const data = reactive<PageData<NatdssB191FollowUpForm, NatdssB191FollowUpQuery>>({
  form: {...initFormData},
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    patientId: undefined,
    visitSn: undefined,
    visitType: undefined,
    visitCardNo: undefined,
    outpatientNo: undefined,
    medicalRecordNo: undefined,
    inpatientNo: undefined,
    name: undefined,
    gender: undefined,
    age: undefined,
    dateOfBirth: undefined,
    followupSn: undefined,
    followupMethod: undefined,
    firstTreatAge: undefined,
    firstTreatDatetime: undefined,
    followupPeriod: undefined,
    followupDatetime: undefined,
    followupStatusCode: undefined,
    followupStatus: undefined,
    healthStatus: undefined,
    deathDatetime: undefined,
    causeOfDeath: undefined,
    recurDatetime: undefined,
    recurDiagCode: undefined,
    recurDiagName: undefined,
    firstRecurMetsDate: undefined,
    metsDatetime: undefined,
    metsSite: undefined,
    metsDiagCode: undefined,
    metsDiagName: undefined,
    mulpriDiagCode: undefined,
    mulpriDiagName: undefined,
    followupConclusion: undefined,
    certificateType: undefined,
    certificateNo: undefined,
    currentAddress: undefined,
    phoneNo: undefined,
    phoneNo2: undefined,
    email: undefined,
    weixin: undefined,
    contactPerson1: undefined,
    contactPhoneNo1: undefined,
    contactPerson2: undefined,
    contactPhoneNo2: undefined,
    extendData1: undefined,
    extendData2: undefined,
    recordStatus: undefined,
    adverseReaction: undefined,
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
    followupSn: [
      { required: true, message: "随访流水号不能为空", trigger: "blur" }
    ],
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询B19-1 随访记录列表 */
const getList = async () => {
  loading.value = true;
  const res = await listNatdssB191FollowUp(queryParams.value);
  natdssB191FollowUpList.value = res.rows;
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
  natdssB191FollowUpFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: NatdssB191FollowUpVO[]) => {
  ids.value = selection.map(item => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
}

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = "添加B19-1 随访记录";
}

/** 修改按钮操作 */
const handleUpdate = async (row?: NatdssB191FollowUpVO) => {
  reset();
  const _id = row?.id || ids.value[0]
  const res = await getNatdssB191FollowUp(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = "修改B19-1 随访记录";
}

/** 提交按钮 */
const submitForm = () => {
  natdssB191FollowUpFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateNatdssB191FollowUp(form.value).finally(() =>  buttonLoading.value = false);
      } else {
        await addNatdssB191FollowUp(form.value).finally(() =>  buttonLoading.value = false);
      }
      proxy?.$modal.msgSuccess("操作成功");
      dialog.visible = false;
      await getList();
    }
  });
}

/** 删除按钮操作 */
const handleDelete = async (row?: NatdssB191FollowUpVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除B19-1 随访记录编号为"' + _ids + '"的数据项？').finally(() => loading.value = false);
  await delNatdssB191FollowUp(_ids);
  proxy?.$modal.msgSuccess("删除成功");
  await getList();
}

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download('natdss/natdssB191FollowUp/export', {
    ...queryParams.value
  }, `natdssB191FollowUp_${new Date().getTime()}.xlsx`)
}

onMounted(() => {
  getList();
});
</script>
