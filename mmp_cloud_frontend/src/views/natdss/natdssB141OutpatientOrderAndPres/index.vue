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
            <el-form-item label="医嘱流水号" prop="orderSn">
              <el-input v-model="queryParams.orderSn" placeholder="请输入医嘱流水号" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="医技申请单号" prop="requestNo">
              <el-input v-model="queryParams.requestNo" placeholder="请输入医技申请单号" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="医嘱开具时间" prop="orderGivenTime">
              <el-date-picker clearable
                v-model="queryParams.orderGivenTime"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择医嘱开具时间"
              />
            </el-form-item>
            <el-form-item label="就诊科室代码" prop="visitDeptCode">
              <el-input v-model="queryParams.visitDeptCode" placeholder="请输入就诊科室代码" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="就诊科室名称" prop="visitDeptName">
              <el-input v-model="queryParams.visitDeptName" placeholder="请输入就诊科室名称" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="医嘱下达科室代码" prop="orderDeptCode">
              <el-input v-model="queryParams.orderDeptCode" placeholder="请输入医嘱下达科室代码" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="医嘱下达科室名称" prop="orderDeptName">
              <el-input v-model="queryParams.orderDeptName" placeholder="请输入医嘱下达科室名称" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="医嘱开单医生代码" prop="orderDoctorNo">
              <el-input v-model="queryParams.orderDoctorNo" placeholder="请输入医嘱开单医生代码" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="职称名称" prop="technicalTitle">
              <el-input v-model="queryParams.technicalTitle" placeholder="请输入职称名称" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="职务名称" prop="jobTitle">
              <el-input v-model="queryParams.jobTitle" placeholder="请输入职务名称" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="医嘱执行科室代码" prop="executiveDeptCode">
              <el-input v-model="queryParams.executiveDeptCode" placeholder="请输入医嘱执行科室代码" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="医嘱执行科室名称" prop="executiveDeptName">
              <el-input v-model="queryParams.executiveDeptName" placeholder="请输入医嘱执行科室名称" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="处方分类代码" prop="prescriptionClassCode">
              <el-input v-model="queryParams.prescriptionClassCode" placeholder="请输入处方分类代码" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="处方分类名称" prop="prescriptionClassName">
              <el-input v-model="queryParams.prescriptionClassName" placeholder="请输入处方分类名称" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="医嘱分类代码" prop="orderClassCode">
              <el-input v-model="queryParams.orderClassCode" placeholder="请输入医嘱分类代码" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="医嘱分类名称" prop="orderClassName">
              <el-input v-model="queryParams.orderClassName" placeholder="请输入医嘱分类名称" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="医嘱项目代码" prop="orderItemCode">
              <el-input v-model="queryParams.orderItemCode" placeholder="请输入医嘱项目代码" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="医嘱项目名称" prop="orderItemName">
              <el-input v-model="queryParams.orderItemName" placeholder="请输入医嘱项目名称" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="医嘱组号" prop="orderGroupNo">
              <el-input v-model="queryParams.orderGroupNo" placeholder="请输入医嘱组号" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="单次剂量" prop="dose">
              <el-input v-model="queryParams.dose" placeholder="请输入单次剂量" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="剂量单位" prop="doseUnit">
              <el-input v-model="queryParams.doseUnit" placeholder="请输入剂量单位" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="药品剂型" prop="form">
              <el-input v-model="queryParams.form" placeholder="请输入药品剂型" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="规格" prop="spec">
              <el-input v-model="queryParams.spec" placeholder="请输入规格" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="使用频率代码" prop="frequencyCode">
              <el-input v-model="queryParams.frequencyCode" placeholder="请输入使用频率代码" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="使用频率" prop="frequency">
              <el-input v-model="queryParams.frequency" placeholder="请输入使用频率" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="给药途径" prop="administrationRoute">
              <el-input v-model="queryParams.administrationRoute" placeholder="请输入给药途径" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="液体配置" prop="liquidConfiguration">
              <el-input v-model="queryParams.liquidConfiguration" placeholder="请输入液体配置" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="用药顺序" prop="drugOrder">
              <el-input v-model="queryParams.drugOrder" placeholder="请输入用药顺序" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="用药配伍" prop="drugCompatibility">
              <el-input v-model="queryParams.drugCompatibility" placeholder="请输入用药配伍" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="输液时长" prop="infusionDuration">
              <el-input v-model="queryParams.infusionDuration" placeholder="请输入输液时长" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="使用天数" prop="daysOfMedication">
              <el-input v-model="queryParams.daysOfMedication" placeholder="请输入使用天数" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="药品使用总剂量" prop="totalDose">
              <el-input v-model="queryParams.totalDose" placeholder="请输入药品使用总剂量" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="总量单位" prop="totalDoseUnit">
              <el-input v-model="queryParams.totalDoseUnit" placeholder="请输入总量单位" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="医嘱数量" prop="numOfOrders">
              <el-input v-model="queryParams.numOfOrders" placeholder="请输入医嘱数量" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="医嘱数量单位" prop="numOfOrdersUnit">
              <el-input v-model="queryParams.numOfOrdersUnit" placeholder="请输入医嘱数量单位" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="医嘱备注" prop="orderNote">
              <el-input v-model="queryParams.orderNote" placeholder="请输入医嘱备注" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="草药备注" prop="herbalNote">
              <el-input v-model="queryParams.herbalNote" placeholder="请输入草药备注" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="是否药品" prop="drugFlag">
              <el-input v-model="queryParams.drugFlag" placeholder="请输入是否药品" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="生产厂家" prop="manufac">
              <el-input v-model="queryParams.manufac" placeholder="请输入生产厂家" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="药品商品名" prop="tradeName">
              <el-input v-model="queryParams.tradeName" placeholder="请输入药品商品名" clearable @keyup.enter="handleQuery" />
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
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['natdss:natdssB141OutpatientOrderAndPres:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="success" plain icon="Edit" :disabled="single" @click="handleUpdate()" v-hasPermi="['natdss:natdssB141OutpatientOrderAndPres:edit']">修改</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="danger" plain icon="Delete" :disabled="multiple" @click="handleDelete()" v-hasPermi="['natdss:natdssB141OutpatientOrderAndPres:remove']">删除</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['natdss:natdssB141OutpatientOrderAndPres:export']">导出</el-button>
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" border :data="natdssB141OutpatientOrderAndPresList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="系统自增主键" align="center" prop="id" v-if="true" />
        <el-table-column label="患者ID" align="center" prop="patientId" />
        <el-table-column label="单次就诊唯一标识号" align="center" prop="visitSn" />
        <el-table-column label="就诊类型:门诊、急诊" align="center" prop="visitType" />
        <el-table-column label="就诊卡号" align="center" prop="visitCardNo" />
        <el-table-column label="门诊号" align="center" prop="outpatientNo" />
        <el-table-column label="就诊次数" align="center" prop="visitTimes" />
        <el-table-column label="医嘱流水号" align="center" prop="orderSn" />
        <el-table-column label="医技申请单号" align="center" prop="requestNo" />
        <el-table-column label="医嘱开具时间" align="center" prop="orderGivenTime" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.orderGivenTime, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="就诊科室代码" align="center" prop="visitDeptCode" />
        <el-table-column label="就诊科室名称" align="center" prop="visitDeptName" />
        <el-table-column label="医嘱下达科室代码" align="center" prop="orderDeptCode" />
        <el-table-column label="医嘱下达科室名称" align="center" prop="orderDeptName" />
        <el-table-column label="医嘱开单医生代码" align="center" prop="orderDoctorNo" />
        <el-table-column label="职称名称" align="center" prop="technicalTitle" />
        <el-table-column label="职务名称" align="center" prop="jobTitle" />
        <el-table-column label="医嘱执行科室代码" align="center" prop="executiveDeptCode" />
        <el-table-column label="医嘱执行科室名称" align="center" prop="executiveDeptName" />
        <el-table-column label="处方分类代码" align="center" prop="prescriptionClassCode" />
        <el-table-column label="处方分类名称" align="center" prop="prescriptionClassName" />
        <el-table-column label="医嘱分类代码" align="center" prop="orderClassCode" />
        <el-table-column label="医嘱分类名称" align="center" prop="orderClassName" />
        <el-table-column label="医嘱项目代码" align="center" prop="orderItemCode" />
        <el-table-column label="医嘱项目名称" align="center" prop="orderItemName" />
        <el-table-column label="医嘱组号" align="center" prop="orderGroupNo" />
        <el-table-column label="单次剂量" align="center" prop="dose" />
        <el-table-column label="剂量单位" align="center" prop="doseUnit" />
        <el-table-column label="药品剂型" align="center" prop="form" />
        <el-table-column label="规格" align="center" prop="spec" />
        <el-table-column label="使用频率代码" align="center" prop="frequencyCode" />
        <el-table-column label="使用频率" align="center" prop="frequency" />
        <el-table-column label="给药途径" align="center" prop="administrationRoute" />
        <el-table-column label="液体配置" align="center" prop="liquidConfiguration" />
        <el-table-column label="注射方式" align="center" prop="injectionType" />
        <el-table-column label="用药顺序" align="center" prop="drugOrder" />
        <el-table-column label="用药配伍" align="center" prop="drugCompatibility" />
        <el-table-column label="输液时长" align="center" prop="infusionDuration" />
        <el-table-column label="使用天数" align="center" prop="daysOfMedication" />
        <el-table-column label="药品使用总剂量" align="center" prop="totalDose" />
        <el-table-column label="总量单位" align="center" prop="totalDoseUnit" />
        <el-table-column label="医嘱数量" align="center" prop="numOfOrders" />
        <el-table-column label="医嘱数量单位" align="center" prop="numOfOrdersUnit" />
        <el-table-column label="医嘱备注" align="center" prop="orderNote" />
        <el-table-column label="草药备注" align="center" prop="herbalNote" />
        <el-table-column label="是否药品" align="center" prop="drugFlag" />
        <el-table-column label="生产厂家" align="center" prop="manufac" />
        <el-table-column label="药品商品名" align="center" prop="tradeName" />
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
              <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['natdss:natdssB141OutpatientOrderAndPres:edit']"></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)" v-hasPermi="['natdss:natdssB141OutpatientOrderAndPres:remove']"></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改B14-1 门诊医嘱处方记录对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="natdssB141OutpatientOrderAndPresFormRef" :model="form" :rules="rules" label-width="80px">
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
        <el-form-item label="医嘱流水号" prop="orderSn">
          <el-input v-model="form.orderSn" placeholder="请输入医嘱流水号" />
        </el-form-item>
        <el-form-item label="医技申请单号" prop="requestNo">
          <el-input v-model="form.requestNo" placeholder="请输入医技申请单号" />
        </el-form-item>
        <el-form-item label="医嘱开具时间" prop="orderGivenTime">
          <el-date-picker clearable
            v-model="form.orderGivenTime"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择医嘱开具时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="就诊科室代码" prop="visitDeptCode">
          <el-input v-model="form.visitDeptCode" placeholder="请输入就诊科室代码" />
        </el-form-item>
        <el-form-item label="就诊科室名称" prop="visitDeptName">
          <el-input v-model="form.visitDeptName" placeholder="请输入就诊科室名称" />
        </el-form-item>
        <el-form-item label="医嘱下达科室代码" prop="orderDeptCode">
          <el-input v-model="form.orderDeptCode" placeholder="请输入医嘱下达科室代码" />
        </el-form-item>
        <el-form-item label="医嘱下达科室名称" prop="orderDeptName">
          <el-input v-model="form.orderDeptName" placeholder="请输入医嘱下达科室名称" />
        </el-form-item>
        <el-form-item label="医嘱开单医生代码" prop="orderDoctorNo">
          <el-input v-model="form.orderDoctorNo" placeholder="请输入医嘱开单医生代码" />
        </el-form-item>
        <el-form-item label="职称名称" prop="technicalTitle">
          <el-input v-model="form.technicalTitle" placeholder="请输入职称名称" />
        </el-form-item>
        <el-form-item label="职务名称" prop="jobTitle">
          <el-input v-model="form.jobTitle" placeholder="请输入职务名称" />
        </el-form-item>
        <el-form-item label="医嘱执行科室代码" prop="executiveDeptCode">
          <el-input v-model="form.executiveDeptCode" placeholder="请输入医嘱执行科室代码" />
        </el-form-item>
        <el-form-item label="医嘱执行科室名称" prop="executiveDeptName">
          <el-input v-model="form.executiveDeptName" placeholder="请输入医嘱执行科室名称" />
        </el-form-item>
        <el-form-item label="处方分类代码" prop="prescriptionClassCode">
          <el-input v-model="form.prescriptionClassCode" placeholder="请输入处方分类代码" />
        </el-form-item>
        <el-form-item label="处方分类名称" prop="prescriptionClassName">
          <el-input v-model="form.prescriptionClassName" placeholder="请输入处方分类名称" />
        </el-form-item>
        <el-form-item label="医嘱分类代码" prop="orderClassCode">
          <el-input v-model="form.orderClassCode" placeholder="请输入医嘱分类代码" />
        </el-form-item>
        <el-form-item label="医嘱分类名称" prop="orderClassName">
          <el-input v-model="form.orderClassName" placeholder="请输入医嘱分类名称" />
        </el-form-item>
        <el-form-item label="医嘱项目代码" prop="orderItemCode">
          <el-input v-model="form.orderItemCode" placeholder="请输入医嘱项目代码" />
        </el-form-item>
        <el-form-item label="医嘱项目名称" prop="orderItemName">
          <el-input v-model="form.orderItemName" placeholder="请输入医嘱项目名称" />
        </el-form-item>
        <el-form-item label="医嘱组号" prop="orderGroupNo">
          <el-input v-model="form.orderGroupNo" placeholder="请输入医嘱组号" />
        </el-form-item>
        <el-form-item label="单次剂量" prop="dose">
          <el-input v-model="form.dose" placeholder="请输入单次剂量" />
        </el-form-item>
        <el-form-item label="剂量单位" prop="doseUnit">
          <el-input v-model="form.doseUnit" placeholder="请输入剂量单位" />
        </el-form-item>
        <el-form-item label="药品剂型" prop="form">
          <el-input v-model="form.form" placeholder="请输入药品剂型" />
        </el-form-item>
        <el-form-item label="规格" prop="spec">
          <el-input v-model="form.spec" placeholder="请输入规格" />
        </el-form-item>
        <el-form-item label="使用频率代码" prop="frequencyCode">
          <el-input v-model="form.frequencyCode" placeholder="请输入使用频率代码" />
        </el-form-item>
        <el-form-item label="使用频率" prop="frequency">
          <el-input v-model="form.frequency" placeholder="请输入使用频率" />
        </el-form-item>
        <el-form-item label="给药途径" prop="administrationRoute">
          <el-input v-model="form.administrationRoute" placeholder="请输入给药途径" />
        </el-form-item>
        <el-form-item label="液体配置" prop="liquidConfiguration">
          <el-input v-model="form.liquidConfiguration" placeholder="请输入液体配置" />
        </el-form-item>
        <el-form-item label="用药顺序" prop="drugOrder">
          <el-input v-model="form.drugOrder" placeholder="请输入用药顺序" />
        </el-form-item>
        <el-form-item label="用药配伍" prop="drugCompatibility">
          <el-input v-model="form.drugCompatibility" placeholder="请输入用药配伍" />
        </el-form-item>
        <el-form-item label="输液时长" prop="infusionDuration">
          <el-input v-model="form.infusionDuration" placeholder="请输入输液时长" />
        </el-form-item>
        <el-form-item label="使用天数" prop="daysOfMedication">
          <el-input v-model="form.daysOfMedication" placeholder="请输入使用天数" />
        </el-form-item>
        <el-form-item label="药品使用总剂量" prop="totalDose">
          <el-input v-model="form.totalDose" placeholder="请输入药品使用总剂量" />
        </el-form-item>
        <el-form-item label="总量单位" prop="totalDoseUnit">
          <el-input v-model="form.totalDoseUnit" placeholder="请输入总量单位" />
        </el-form-item>
        <el-form-item label="医嘱数量" prop="numOfOrders">
          <el-input v-model="form.numOfOrders" placeholder="请输入医嘱数量" />
        </el-form-item>
        <el-form-item label="医嘱数量单位" prop="numOfOrdersUnit">
          <el-input v-model="form.numOfOrdersUnit" placeholder="请输入医嘱数量单位" />
        </el-form-item>
        <el-form-item label="医嘱备注" prop="orderNote">
          <el-input v-model="form.orderNote" placeholder="请输入医嘱备注" />
        </el-form-item>
        <el-form-item label="草药备注" prop="herbalNote">
          <el-input v-model="form.herbalNote" placeholder="请输入草药备注" />
        </el-form-item>
        <el-form-item label="是否药品" prop="drugFlag">
          <el-input v-model="form.drugFlag" placeholder="请输入是否药品" />
        </el-form-item>
        <el-form-item label="生产厂家" prop="manufac">
          <el-input v-model="form.manufac" placeholder="请输入生产厂家" />
        </el-form-item>
        <el-form-item label="药品商品名" prop="tradeName">
          <el-input v-model="form.tradeName" placeholder="请输入药品商品名" />
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

<script setup name="NatdssB141OutpatientOrderAndPres" lang="ts">
import { listNatdssB141OutpatientOrderAndPres, getNatdssB141OutpatientOrderAndPres, delNatdssB141OutpatientOrderAndPres, addNatdssB141OutpatientOrderAndPres, updateNatdssB141OutpatientOrderAndPres } from '@/api/natdss/natdssB141OutpatientOrderAndPres';
import { NatdssB141OutpatientOrderAndPresVO, NatdssB141OutpatientOrderAndPresQuery, NatdssB141OutpatientOrderAndPresForm } from '@/api/natdss/natdssB141OutpatientOrderAndPres/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const natdssB141OutpatientOrderAndPresList = ref<NatdssB141OutpatientOrderAndPresVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const natdssB141OutpatientOrderAndPresFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: NatdssB141OutpatientOrderAndPresForm = {
  id: undefined,
  patientId: undefined,
  visitSn: undefined,
  visitType: undefined,
  visitCardNo: undefined,
  outpatientNo: undefined,
  visitTimes: undefined,
  orderSn: undefined,
  requestNo: undefined,
  orderGivenTime: undefined,
  visitDeptCode: undefined,
  visitDeptName: undefined,
  orderDeptCode: undefined,
  orderDeptName: undefined,
  orderDoctorNo: undefined,
  technicalTitle: undefined,
  jobTitle: undefined,
  executiveDeptCode: undefined,
  executiveDeptName: undefined,
  prescriptionClassCode: undefined,
  prescriptionClassName: undefined,
  orderClassCode: undefined,
  orderClassName: undefined,
  orderItemCode: undefined,
  orderItemName: undefined,
  orderGroupNo: undefined,
  dose: undefined,
  doseUnit: undefined,
  form: undefined,
  spec: undefined,
  frequencyCode: undefined,
  frequency: undefined,
  administrationRoute: undefined,
  liquidConfiguration: undefined,
  injectionType: undefined,
  drugOrder: undefined,
  drugCompatibility: undefined,
  infusionDuration: undefined,
  daysOfMedication: undefined,
  totalDose: undefined,
  totalDoseUnit: undefined,
  numOfOrders: undefined,
  numOfOrdersUnit: undefined,
  orderNote: undefined,
  herbalNote: undefined,
  drugFlag: undefined,
  manufac: undefined,
  tradeName: undefined,
  extendData1: undefined,
  extendData2: undefined,
  recordStatus: undefined,
  createdTime: undefined,
  updatedTime: undefined
}
const data = reactive<PageData<NatdssB141OutpatientOrderAndPresForm, NatdssB141OutpatientOrderAndPresQuery>>({
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
    orderSn: undefined,
    requestNo: undefined,
    orderGivenTime: undefined,
    visitDeptCode: undefined,
    visitDeptName: undefined,
    orderDeptCode: undefined,
    orderDeptName: undefined,
    orderDoctorNo: undefined,
    technicalTitle: undefined,
    jobTitle: undefined,
    executiveDeptCode: undefined,
    executiveDeptName: undefined,
    prescriptionClassCode: undefined,
    prescriptionClassName: undefined,
    orderClassCode: undefined,
    orderClassName: undefined,
    orderItemCode: undefined,
    orderItemName: undefined,
    orderGroupNo: undefined,
    dose: undefined,
    doseUnit: undefined,
    form: undefined,
    spec: undefined,
    frequencyCode: undefined,
    frequency: undefined,
    administrationRoute: undefined,
    liquidConfiguration: undefined,
    injectionType: undefined,
    drugOrder: undefined,
    drugCompatibility: undefined,
    infusionDuration: undefined,
    daysOfMedication: undefined,
    totalDose: undefined,
    totalDoseUnit: undefined,
    numOfOrders: undefined,
    numOfOrdersUnit: undefined,
    orderNote: undefined,
    herbalNote: undefined,
    drugFlag: undefined,
    manufac: undefined,
    tradeName: undefined,
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
    orderSn: [
      { required: true, message: "医嘱流水号不能为空", trigger: "blur" }
    ],
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询B14-1 门诊医嘱处方记录列表 */
const getList = async () => {
  loading.value = true;
  const res = await listNatdssB141OutpatientOrderAndPres(queryParams.value);
  natdssB141OutpatientOrderAndPresList.value = res.rows;
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
  natdssB141OutpatientOrderAndPresFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: NatdssB141OutpatientOrderAndPresVO[]) => {
  ids.value = selection.map(item => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
}

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = "添加B14-1 门诊医嘱处方记录";
}

/** 修改按钮操作 */
const handleUpdate = async (row?: NatdssB141OutpatientOrderAndPresVO) => {
  reset();
  const _id = row?.id || ids.value[0]
  const res = await getNatdssB141OutpatientOrderAndPres(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = "修改B14-1 门诊医嘱处方记录";
}

/** 提交按钮 */
const submitForm = () => {
  natdssB141OutpatientOrderAndPresFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateNatdssB141OutpatientOrderAndPres(form.value).finally(() =>  buttonLoading.value = false);
      } else {
        await addNatdssB141OutpatientOrderAndPres(form.value).finally(() =>  buttonLoading.value = false);
      }
      proxy?.$modal.msgSuccess("操作成功");
      dialog.visible = false;
      await getList();
    }
  });
}

/** 删除按钮操作 */
const handleDelete = async (row?: NatdssB141OutpatientOrderAndPresVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除B14-1 门诊医嘱处方记录编号为"' + _ids + '"的数据项？').finally(() => loading.value = false);
  await delNatdssB141OutpatientOrderAndPres(_ids);
  proxy?.$modal.msgSuccess("删除成功");
  await getList();
}

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download('natdss/natdssB141OutpatientOrderAndPres/export', {
    ...queryParams.value
  }, `natdssB141OutpatientOrderAndPres_${new Date().getTime()}.xlsx`)
}

onMounted(() => {
  getList();
});
</script>
