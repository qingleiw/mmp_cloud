<template>
  <div class="p-2">
    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <div v-show="showSearch" class="mb-[10px]">
        <el-card shadow="hover">
          <el-form ref="queryFormRef" :model="queryParams" :inline="true">
            <el-form-item label="患者ID-患者在本院信息系统内的唯一标识" prop="patientId">
              <el-input v-model="queryParams.patientId" placeholder="请输入患者ID-患者在本院信息系统内的唯一标识" clearable @keyup.enter="handleQuery" />
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
            <el-form-item label="病案号" prop="medicalRecordNo">
              <el-input v-model="queryParams.medicalRecordNo" placeholder="请输入病案号" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="住院号" prop="inpatientNo">
              <el-input v-model="queryParams.inpatientNo" placeholder="请输入住院号" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="住院次数" prop="hospitalizationTimes">
              <el-input v-model="queryParams.hospitalizationTimes" placeholder="请输入住院次数" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="入院时间" prop="admissionDatetime">
              <el-date-picker clearable
                v-model="queryParams.admissionDatetime"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择入院时间"
              />
            </el-form-item>
            <el-form-item label="出院时间" prop="dischargeDatetime">
              <el-date-picker clearable
                v-model="queryParams.dischargeDatetime"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择出院时间"
              />
            </el-form-item>
            <el-form-item label="就诊医生代码" prop="visitDoctorNo">
              <el-input v-model="queryParams.visitDoctorNo" placeholder="请输入就诊医生代码" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="姓名" prop="name">
              <el-input v-model="queryParams.name" placeholder="请输入姓名" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="性别:男、女、未知" prop="gender">
              <el-input v-model="queryParams.gender" placeholder="请输入性别:男、女、未知" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出生日期" prop="dateOfBirth">
              <el-date-picker clearable
                v-model="queryParams.dateOfBirth"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择出生日期"
              />
            </el-form-item>
            <el-form-item label="职业类别代码" prop="occupationCode">
              <el-input v-model="queryParams.occupationCode" placeholder="请输入职业类别代码" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="职业类别名称" prop="occupationName">
              <el-input v-model="queryParams.occupationName" placeholder="请输入职业类别名称" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="国籍" prop="nationality">
              <el-input v-model="queryParams.nationality" placeholder="请输入国籍" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="民族" prop="ethnicity">
              <el-input v-model="queryParams.ethnicity" placeholder="请输入民族" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="文化程度" prop="education">
              <el-input v-model="queryParams.education" placeholder="请输入文化程度" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="是否新生儿" prop="newbronMark">
              <el-input v-model="queryParams.newbronMark" placeholder="请输入是否新生儿" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="证件号码" prop="certificateNo">
              <el-input v-model="queryParams.certificateNo" placeholder="请输入证件号码" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="健康卡号" prop="healthCardNo">
              <el-input v-model="queryParams.healthCardNo" placeholder="请输入健康卡号" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="医保卡号" prop="insuranceNo">
              <el-input v-model="queryParams.insuranceNo" placeholder="请输入医保卡号" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="户籍地址-省名称" prop="residenceProvince">
              <el-input v-model="queryParams.residenceProvince" placeholder="请输入户籍地址-省名称" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="户籍地址-市名称" prop="residenceCity">
              <el-input v-model="queryParams.residenceCity" placeholder="请输入户籍地址-市名称" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="户籍地址-县名称" prop="residenceCounty">
              <el-input v-model="queryParams.residenceCounty" placeholder="请输入户籍地址-县名称" clearable @keyup.enter="handleQuery" />
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
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['natdss:natdssB021PatientInfo:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="success" plain icon="Edit" :disabled="single" @click="handleUpdate()" v-hasPermi="['natdss:natdssB021PatientInfo:edit']">修改</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="danger" plain icon="Delete" :disabled="multiple" @click="handleDelete()" v-hasPermi="['natdss:natdssB021PatientInfo:remove']">删除</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['natdss:natdssB021PatientInfo:export']">导出</el-button>
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" border :data="natdssB021PatientInfoList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="系统自增主键" align="center" prop="id" v-if="true" />
        <el-table-column label="患者ID-患者在本院信息系统内的唯一标识" align="center" prop="patientId" />
        <el-table-column label="单次就诊唯一标识号" align="center" prop="visitSn" />
        <el-table-column label="就诊类型:住院、门诊" align="center" prop="visitType" />
        <el-table-column label="就诊卡号" align="center" prop="visitCardNo" />
        <el-table-column label="门诊号" align="center" prop="outpatientNo" />
        <el-table-column label="就诊次数" align="center" prop="visitTimes" />
        <el-table-column label="就诊时间" align="center" prop="visitDatetime" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.visitDatetime, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="病案号" align="center" prop="medicalRecordNo" />
        <el-table-column label="住院号" align="center" prop="inpatientNo" />
        <el-table-column label="住院次数" align="center" prop="hospitalizationTimes" />
        <el-table-column label="入院时间" align="center" prop="admissionDatetime" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.admissionDatetime, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="出院时间" align="center" prop="dischargeDatetime" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.dischargeDatetime, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="就诊医生代码" align="center" prop="visitDoctorNo" />
        <el-table-column label="姓名" align="center" prop="name" />
        <el-table-column label="性别:男、女、未知" align="center" prop="gender" />
        <el-table-column label="出生日期" align="center" prop="dateOfBirth" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.dateOfBirth, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="职业类别代码" align="center" prop="occupationCode" />
        <el-table-column label="职业类别名称" align="center" prop="occupationName" />
        <el-table-column label="国籍" align="center" prop="nationality" />
        <el-table-column label="民族" align="center" prop="ethnicity" />
        <el-table-column label="文化程度" align="center" prop="education" />
        <el-table-column label="婚姻状况类别" align="center" prop="maritalStatus" />
        <el-table-column label="是否新生儿" align="center" prop="newbronMark" />
        <el-table-column label="证件类型" align="center" prop="certificateType" />
        <el-table-column label="证件号码" align="center" prop="certificateNo" />
        <el-table-column label="健康卡类型" align="center" prop="healthCardType" />
        <el-table-column label="健康卡号" align="center" prop="healthCardNo" />
        <el-table-column label="医保类型" align="center" prop="insuranceType" />
        <el-table-column label="医保卡号" align="center" prop="insuranceNo" />
        <el-table-column label="户籍地址-省名称" align="center" prop="residenceProvince" />
        <el-table-column label="户籍地址-市名称" align="center" prop="residenceCity" />
        <el-table-column label="户籍地址-县名称" align="center" prop="residenceCounty" />
        <el-table-column label="现住址" align="center" prop="currentAddress" />
        <el-table-column label="联系电话" align="center" prop="phoneNo" />
        <el-table-column label="联系电话2" align="center" prop="phoneNo2" />
        <el-table-column label="邮箱" align="center" prop="email" />
        <el-table-column label="微信" align="center" prop="weixin" />
        <el-table-column label="紧急联系人1" align="center" prop="contactPerson1" />
        <el-table-column label="紧急联系人电话1" align="center" prop="contactPhoneNo1" />
        <el-table-column label="紧急联系人2" align="center" prop="contactPerson2" />
        <el-table-column label="紧急联系人电话2" align="center" prop="contactPhoneNo2" />
        <el-table-column label="ABO血型" align="center" prop="aboBloodType" />
        <el-table-column label="Rh血型" align="center" prop="rhBloodType" />
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
              <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['natdss:natdssB021PatientInfo:edit']"></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)" v-hasPermi="['natdss:natdssB021PatientInfo:remove']"></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改B02-1 患者就诊基本信息对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="natdssB021PatientInfoFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="患者ID-患者在本院信息系统内的唯一标识" prop="patientId">
          <el-input v-model="form.patientId" placeholder="请输入患者ID-患者在本院信息系统内的唯一标识" />
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
        <el-form-item label="病案号" prop="medicalRecordNo">
          <el-input v-model="form.medicalRecordNo" placeholder="请输入病案号" />
        </el-form-item>
        <el-form-item label="住院号" prop="inpatientNo">
          <el-input v-model="form.inpatientNo" placeholder="请输入住院号" />
        </el-form-item>
        <el-form-item label="住院次数" prop="hospitalizationTimes">
          <el-input v-model="form.hospitalizationTimes" placeholder="请输入住院次数" />
        </el-form-item>
        <el-form-item label="入院时间" prop="admissionDatetime">
          <el-date-picker clearable
            v-model="form.admissionDatetime"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择入院时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="出院时间" prop="dischargeDatetime">
          <el-date-picker clearable
            v-model="form.dischargeDatetime"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择出院时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="就诊医生代码" prop="visitDoctorNo">
          <el-input v-model="form.visitDoctorNo" placeholder="请输入就诊医生代码" />
        </el-form-item>
        <el-form-item label="姓名" prop="name">
          <el-input v-model="form.name" placeholder="请输入姓名" />
        </el-form-item>
        <el-form-item label="性别:男、女、未知" prop="gender">
          <el-input v-model="form.gender" placeholder="请输入性别:男、女、未知" />
        </el-form-item>
        <el-form-item label="出生日期" prop="dateOfBirth">
          <el-date-picker clearable
            v-model="form.dateOfBirth"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择出生日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="职业类别代码" prop="occupationCode">
          <el-input v-model="form.occupationCode" placeholder="请输入职业类别代码" />
        </el-form-item>
        <el-form-item label="职业类别名称" prop="occupationName">
          <el-input v-model="form.occupationName" placeholder="请输入职业类别名称" />
        </el-form-item>
        <el-form-item label="国籍" prop="nationality">
          <el-input v-model="form.nationality" placeholder="请输入国籍" />
        </el-form-item>
        <el-form-item label="民族" prop="ethnicity">
          <el-input v-model="form.ethnicity" placeholder="请输入民族" />
        </el-form-item>
        <el-form-item label="文化程度" prop="education">
          <el-input v-model="form.education" placeholder="请输入文化程度" />
        </el-form-item>
        <el-form-item label="是否新生儿" prop="newbronMark">
          <el-input v-model="form.newbronMark" placeholder="请输入是否新生儿" />
        </el-form-item>
        <el-form-item label="证件号码" prop="certificateNo">
          <el-input v-model="form.certificateNo" placeholder="请输入证件号码" />
        </el-form-item>
        <el-form-item label="健康卡号" prop="healthCardNo">
          <el-input v-model="form.healthCardNo" placeholder="请输入健康卡号" />
        </el-form-item>
        <el-form-item label="医保卡号" prop="insuranceNo">
          <el-input v-model="form.insuranceNo" placeholder="请输入医保卡号" />
        </el-form-item>
        <el-form-item label="户籍地址-省名称" prop="residenceProvince">
          <el-input v-model="form.residenceProvince" placeholder="请输入户籍地址-省名称" />
        </el-form-item>
        <el-form-item label="户籍地址-市名称" prop="residenceCity">
          <el-input v-model="form.residenceCity" placeholder="请输入户籍地址-市名称" />
        </el-form-item>
        <el-form-item label="户籍地址-县名称" prop="residenceCounty">
          <el-input v-model="form.residenceCounty" placeholder="请输入户籍地址-县名称" />
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

<script setup name="NatdssB021PatientInfo" lang="ts">
import { listNatdssB021PatientInfo, getNatdssB021PatientInfo, delNatdssB021PatientInfo, addNatdssB021PatientInfo, updateNatdssB021PatientInfo } from '@/api/natdss/natdssB021PatientInfo';
import { NatdssB021PatientInfoVO, NatdssB021PatientInfoQuery, NatdssB021PatientInfoForm } from '@/api/natdss/natdssB021PatientInfo/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const natdssB021PatientInfoList = ref<NatdssB021PatientInfoVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const natdssB021PatientInfoFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: NatdssB021PatientInfoForm = {
  id: undefined,
  patientId: undefined,
  visitSn: undefined,
  visitType: undefined,
  visitCardNo: undefined,
  outpatientNo: undefined,
  visitTimes: undefined,
  visitDatetime: undefined,
  medicalRecordNo: undefined,
  inpatientNo: undefined,
  hospitalizationTimes: undefined,
  admissionDatetime: undefined,
  dischargeDatetime: undefined,
  visitDoctorNo: undefined,
  name: undefined,
  gender: undefined,
  dateOfBirth: undefined,
  occupationCode: undefined,
  occupationName: undefined,
  nationality: undefined,
  ethnicity: undefined,
  education: undefined,
  maritalStatus: undefined,
  newbronMark: undefined,
  certificateType: undefined,
  certificateNo: undefined,
  healthCardType: undefined,
  healthCardNo: undefined,
  insuranceType: undefined,
  insuranceNo: undefined,
  residenceProvince: undefined,
  residenceCity: undefined,
  residenceCounty: undefined,
  currentAddress: undefined,
  phoneNo: undefined,
  phoneNo2: undefined,
  email: undefined,
  weixin: undefined,
  contactPerson1: undefined,
  contactPhoneNo1: undefined,
  contactPerson2: undefined,
  contactPhoneNo2: undefined,
  aboBloodType: undefined,
  rhBloodType: undefined,
  extendData1: undefined,
  extendData2: undefined,
  recordStatus: undefined,
  createdTime: undefined,
  updatedTime: undefined
}
const data = reactive<PageData<NatdssB021PatientInfoForm, NatdssB021PatientInfoQuery>>({
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
    medicalRecordNo: undefined,
    inpatientNo: undefined,
    hospitalizationTimes: undefined,
    admissionDatetime: undefined,
    dischargeDatetime: undefined,
    visitDoctorNo: undefined,
    name: undefined,
    gender: undefined,
    dateOfBirth: undefined,
    occupationCode: undefined,
    occupationName: undefined,
    nationality: undefined,
    ethnicity: undefined,
    education: undefined,
    maritalStatus: undefined,
    newbronMark: undefined,
    certificateType: undefined,
    certificateNo: undefined,
    healthCardType: undefined,
    healthCardNo: undefined,
    insuranceType: undefined,
    insuranceNo: undefined,
    residenceProvince: undefined,
    residenceCity: undefined,
    residenceCounty: undefined,
    currentAddress: undefined,
    phoneNo: undefined,
    phoneNo2: undefined,
    email: undefined,
    weixin: undefined,
    contactPerson1: undefined,
    contactPhoneNo1: undefined,
    contactPerson2: undefined,
    contactPhoneNo2: undefined,
    aboBloodType: undefined,
    rhBloodType: undefined,
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
      { required: true, message: "患者ID-患者在本院信息系统内的唯一标识不能为空", trigger: "blur" }
    ],
    visitSn: [
      { required: true, message: "单次就诊唯一标识号不能为空", trigger: "blur" }
    ],
    visitType: [
      { required: true, message: "就诊类型:住院、门诊不能为空", trigger: "change" }
    ],
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询B02-1 患者就诊基本信息列表 */
const getList = async () => {
  loading.value = true;
  const res = await listNatdssB021PatientInfo(queryParams.value);
  natdssB021PatientInfoList.value = res.rows;
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
  natdssB021PatientInfoFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: NatdssB021PatientInfoVO[]) => {
  ids.value = selection.map(item => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
}

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = "添加B02-1 患者就诊基本信息";
}

/** 修改按钮操作 */
const handleUpdate = async (row?: NatdssB021PatientInfoVO) => {
  reset();
  const _id = row?.id || ids.value[0]
  const res = await getNatdssB021PatientInfo(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = "修改B02-1 患者就诊基本信息";
}

/** 提交按钮 */
const submitForm = () => {
  natdssB021PatientInfoFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateNatdssB021PatientInfo(form.value).finally(() =>  buttonLoading.value = false);
      } else {
        await addNatdssB021PatientInfo(form.value).finally(() =>  buttonLoading.value = false);
      }
      proxy?.$modal.msgSuccess("操作成功");
      dialog.visible = false;
      await getList();
    }
  });
}

/** 删除按钮操作 */
const handleDelete = async (row?: NatdssB021PatientInfoVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除B02-1 患者就诊基本信息编号为"' + _ids + '"的数据项？').finally(() => loading.value = false);
  await delNatdssB021PatientInfo(_ids);
  proxy?.$modal.msgSuccess("删除成功");
  await getList();
}

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download('natdss/natdssB021PatientInfo/export', {
    ...queryParams.value
  }, `natdssB021PatientInfo_${new Date().getTime()}.xlsx`)
}

onMounted(() => {
  getList();
});
</script>
