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
            <el-form-item label="分子病理号" prop="molPathoNo">
              <el-input v-model="queryParams.molPathoNo" placeholder="请输入分子病理号" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="检测流水号" prop="labSn">
              <el-input v-model="queryParams.labSn" placeholder="请输入检测流水号" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="检测时间" prop="examDatetime">
              <el-date-picker clearable
                v-model="queryParams.examDatetime"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择检测时间"
              />
            </el-form-item>
            <el-form-item label="标本编号" prop="sampleNo">
              <el-input v-model="queryParams.sampleNo" placeholder="请输入标本编号" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="检测平台" prop="testPlatform">
              <el-input v-model="queryParams.testPlatform" placeholder="请输入检测平台" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="检测项目" prop="testItem">
              <el-input v-model="queryParams.testItem" placeholder="请输入检测项目" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="检测方法" prop="testMethod">
              <el-input v-model="queryParams.testMethod" placeholder="请输入检测方法" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="检测结果" prop="testResult">
              <el-input v-model="queryParams.testResult" placeholder="请输入检测结果" clearable @keyup.enter="handleQuery" />
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
            <el-form-item label="外显子" prop="testExon">
              <el-input v-model="queryParams.testExon" placeholder="请输入外显子" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="位点" prop="testLocus">
              <el-input v-model="queryParams.testLocus" placeholder="请输入位点" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="检测基因" prop="testGene">
              <el-input v-model="queryParams.testGene" placeholder="请输入检测基因" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="转录本" prop="transcript">
              <el-input v-model="queryParams.transcript" placeholder="请输入转录本" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="核苷酸改变" prop="nucleAlt">
              <el-input v-model="queryParams.nucleAlt" placeholder="请输入核苷酸改变" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="氨基酸改变" prop="aminoAcidAlt">
              <el-input v-model="queryParams.aminoAcidAlt" placeholder="请输入氨基酸改变" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="丰度" prop="mutAbundance">
              <el-input v-model="queryParams.mutAbundance" placeholder="请输入丰度" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="变异解读" prop="mutInterpretation">
              <el-input v-model="queryParams.mutInterpretation" placeholder="请输入变异解读" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="取材部位" prop="samplingSite">
              <el-input v-model="queryParams.samplingSite" placeholder="请输入取材部位" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="测序深度" prop="geneSequencingDepth">
              <el-input v-model="queryParams.geneSequencingDepth" placeholder="请输入测序深度" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="肿瘤突变负荷" prop="tmb">
              <el-input v-model="queryParams.tmb" placeholder="请输入肿瘤突变负荷" clearable @keyup.enter="handleQuery" />
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
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['natdss:natdssB16-3MolecularPathologyExamRecord:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="success" plain icon="Edit" :disabled="single" @click="handleUpdate()" v-hasPermi="['natdss:natdssB16-3MolecularPathologyExamRecord:edit']">修改</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="danger" plain icon="Delete" :disabled="multiple" @click="handleDelete()" v-hasPermi="['natdss:natdssB16-3MolecularPathologyExamRecord:remove']">删除</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['natdss:natdssB16-3MolecularPathologyExamRecord:export']">导出</el-button>
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" border :data="natdssB16-3MolecularPathologyExamRecordList" @selection-change="handleSelectionChange">
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
        <el-table-column label="分子病理号" align="center" prop="molPathoNo" />
        <el-table-column label="检测流水号" align="center" prop="labSn" />
        <el-table-column label="检测时间" align="center" prop="examDatetime" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.examDatetime, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="标本编号" align="center" prop="sampleNo" />
        <el-table-column label="标本类型" align="center" prop="sampleType" />
        <el-table-column label="检测平台" align="center" prop="testPlatform" />
        <el-table-column label="检测项目" align="center" prop="testItem" />
        <el-table-column label="检测方法" align="center" prop="testMethod" />
        <el-table-column label="检测内容" align="center" prop="testContent" />
        <el-table-column label="检测结果" align="center" prop="testResult" />
        <el-table-column label="报告单号" align="center" prop="reportNo" />
        <el-table-column label="报告时间" align="center" prop="reportDatetime" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.reportDatetime, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="外显子" align="center" prop="testExon" />
        <el-table-column label="位点" align="center" prop="testLocus" />
        <el-table-column label="检测基因" align="center" prop="testGene" />
        <el-table-column label="转录本" align="center" prop="transcript" />
        <el-table-column label="核苷酸改变" align="center" prop="nucleAlt" />
        <el-table-column label="氨基酸改变" align="center" prop="aminoAcidAlt" />
        <el-table-column label="丰度" align="center" prop="mutAbundance" />
        <el-table-column label="变异类型" align="center" prop="variationType" />
        <el-table-column label="变异解读" align="center" prop="mutInterpretation" />
        <el-table-column label="基因型" align="center" prop="genoType" />
        <el-table-column label="取材部位" align="center" prop="samplingSite" />
        <el-table-column label="测序深度" align="center" prop="geneSequencingDepth" />
        <el-table-column label="肿瘤突变负荷" align="center" prop="tmb" />
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
              <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['natdss:natdssB16-3MolecularPathologyExamRecord:edit']"></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)" v-hasPermi="['natdss:natdssB16-3MolecularPathologyExamRecord:remove']"></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改B16-3 分子病理检测记录对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="natdssB16-3MolecularPathologyExamRecordFormRef" :model="form" :rules="rules" label-width="80px">
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
        <el-form-item label="分子病理号" prop="molPathoNo">
          <el-input v-model="form.molPathoNo" placeholder="请输入分子病理号" />
        </el-form-item>
        <el-form-item label="检测流水号" prop="labSn">
          <el-input v-model="form.labSn" placeholder="请输入检测流水号" />
        </el-form-item>
        <el-form-item label="检测时间" prop="examDatetime">
          <el-date-picker clearable
            v-model="form.examDatetime"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择检测时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="标本编号" prop="sampleNo">
          <el-input v-model="form.sampleNo" placeholder="请输入标本编号" />
        </el-form-item>
        <el-form-item label="检测平台" prop="testPlatform">
          <el-input v-model="form.testPlatform" placeholder="请输入检测平台" />
        </el-form-item>
        <el-form-item label="检测项目" prop="testItem">
          <el-input v-model="form.testItem" placeholder="请输入检测项目" />
        </el-form-item>
        <el-form-item label="检测方法" prop="testMethod">
          <el-input v-model="form.testMethod" placeholder="请输入检测方法" />
        </el-form-item>
        <el-form-item label="检测内容">
          <editor v-model="form.testContent" :min-height="192"/>
        </el-form-item>
        <el-form-item label="检测结果" prop="testResult">
            <el-input v-model="form.testResult" type="textarea" placeholder="请输入内容" />
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
        <el-form-item label="外显子" prop="testExon">
          <el-input v-model="form.testExon" placeholder="请输入外显子" />
        </el-form-item>
        <el-form-item label="位点" prop="testLocus">
          <el-input v-model="form.testLocus" placeholder="请输入位点" />
        </el-form-item>
        <el-form-item label="检测基因" prop="testGene">
          <el-input v-model="form.testGene" placeholder="请输入检测基因" />
        </el-form-item>
        <el-form-item label="转录本" prop="transcript">
          <el-input v-model="form.transcript" placeholder="请输入转录本" />
        </el-form-item>
        <el-form-item label="核苷酸改变" prop="nucleAlt">
          <el-input v-model="form.nucleAlt" placeholder="请输入核苷酸改变" />
        </el-form-item>
        <el-form-item label="氨基酸改变" prop="aminoAcidAlt">
          <el-input v-model="form.aminoAcidAlt" placeholder="请输入氨基酸改变" />
        </el-form-item>
        <el-form-item label="丰度" prop="mutAbundance">
          <el-input v-model="form.mutAbundance" placeholder="请输入丰度" />
        </el-form-item>
        <el-form-item label="变异解读" prop="mutInterpretation">
          <el-input v-model="form.mutInterpretation" placeholder="请输入变异解读" />
        </el-form-item>
        <el-form-item label="取材部位" prop="samplingSite">
          <el-input v-model="form.samplingSite" placeholder="请输入取材部位" />
        </el-form-item>
        <el-form-item label="测序深度" prop="geneSequencingDepth">
          <el-input v-model="form.geneSequencingDepth" placeholder="请输入测序深度" />
        </el-form-item>
        <el-form-item label="肿瘤突变负荷" prop="tmb">
          <el-input v-model="form.tmb" placeholder="请输入肿瘤突变负荷" />
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

<script setup name="NatdssB16-3MolecularPathologyExamRecord" lang="ts">
import { listNatdssB16-3MolecularPathologyExamRecord, getNatdssB16-3MolecularPathologyExamRecord, delNatdssB16-3MolecularPathologyExamRecord, addNatdssB16-3MolecularPathologyExamRecord, updateNatdssB16-3MolecularPathologyExamRecord } from '@/api/natdss/natdssB16-3MolecularPathologyExamRecord';
import { NatdssB16-3MolecularPathologyExamRecordVO, NatdssB16-3MolecularPathologyExamRecordQuery, NatdssB16-3MolecularPathologyExamRecordForm } from '@/api/natdss/natdssB16-3MolecularPathologyExamRecord/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const natdssB16-3MolecularPathologyExamRecordList = ref<NatdssB16-3MolecularPathologyExamRecordVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const natdssB16-3MolecularPathologyExamRecordFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: NatdssB16-3MolecularPathologyExamRecordForm = {
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
  molPathoNo: undefined,
  labSn: undefined,
  examDatetime: undefined,
  sampleNo: undefined,
  sampleType: undefined,
  testPlatform: undefined,
  testItem: undefined,
  testMethod: undefined,
  testContent: undefined,
  testResult: undefined,
  reportNo: undefined,
  reportDatetime: undefined,
  testExon: undefined,
  testLocus: undefined,
  testGene: undefined,
  transcript: undefined,
  nucleAlt: undefined,
  aminoAcidAlt: undefined,
  mutAbundance: undefined,
  variationType: undefined,
  mutInterpretation: undefined,
  genoType: undefined,
  samplingSite: undefined,
  geneSequencingDepth: undefined,
  tmb: undefined,
  extendData1: undefined,
  extendData2: undefined,
  recordStatus: undefined,
  createdTime: undefined,
  updatedTime: undefined
}
const data = reactive<PageData<NatdssB16-3MolecularPathologyExamRecordForm, NatdssB16-3MolecularPathologyExamRecordQuery>>({
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
    molPathoNo: undefined,
    labSn: undefined,
    examDatetime: undefined,
    sampleNo: undefined,
    sampleType: undefined,
    testPlatform: undefined,
    testItem: undefined,
    testMethod: undefined,
    testContent: undefined,
    testResult: undefined,
    reportNo: undefined,
    reportDatetime: undefined,
    testExon: undefined,
    testLocus: undefined,
    testGene: undefined,
    transcript: undefined,
    nucleAlt: undefined,
    aminoAcidAlt: undefined,
    mutAbundance: undefined,
    variationType: undefined,
    mutInterpretation: undefined,
    genoType: undefined,
    samplingSite: undefined,
    geneSequencingDepth: undefined,
    tmb: undefined,
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
    labSn: [
      { required: true, message: "检测流水号不能为空", trigger: "blur" }
    ],
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询B16-3 分子病理检测记录列表 */
const getList = async () => {
  loading.value = true;
  const res = await listNatdssB16-3MolecularPathologyExamRecord(queryParams.value);
  natdssB16-3MolecularPathologyExamRecordList.value = res.rows;
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
  natdssB16-3MolecularPathologyExamRecordFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: NatdssB16-3MolecularPathologyExamRecordVO[]) => {
  ids.value = selection.map(item => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
}

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = "添加B16-3 分子病理检测记录";
}

/** 修改按钮操作 */
const handleUpdate = async (row?: NatdssB16-3MolecularPathologyExamRecordVO) => {
  reset();
  const _id = row?.id || ids.value[0]
  const res = await getNatdssB16-3MolecularPathologyExamRecord(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = "修改B16-3 分子病理检测记录";
}

/** 提交按钮 */
const submitForm = () => {
  natdssB16-3MolecularPathologyExamRecordFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateNatdssB16-3MolecularPathologyExamRecord(form.value).finally(() =>  buttonLoading.value = false);
      } else {
        await addNatdssB16-3MolecularPathologyExamRecord(form.value).finally(() =>  buttonLoading.value = false);
      }
      proxy?.$modal.msgSuccess("操作成功");
      dialog.visible = false;
      await getList();
    }
  });
}

/** 删除按钮操作 */
const handleDelete = async (row?: NatdssB16-3MolecularPathologyExamRecordVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除B16-3 分子病理检测记录编号为"' + _ids + '"的数据项？').finally(() => loading.value = false);
  await delNatdssB16-3MolecularPathologyExamRecord(_ids);
  proxy?.$modal.msgSuccess("删除成功");
  await getList();
}

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download('natdss/natdssB16-3MolecularPathologyExamRecord/export', {
    ...queryParams.value
  }, `natdssB16-3MolecularPathologyExamRecord_${new Date().getTime()}.xlsx`)
}

onMounted(() => {
  getList();
});
</script>
