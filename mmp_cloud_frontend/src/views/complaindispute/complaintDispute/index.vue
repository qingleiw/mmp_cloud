<template>
  <div class="app-container">
    <!-- 页面头部 -->
    <div class="page-header">
      <h1>投诉纠纷管理</h1>
      <p>管理系统中的投诉纠纷信息，包括投诉处理、纠纷确认等功能</p>
      <div class="flex gap-2">
        <el-button type="primary" icon="i-ep:Plus" @click="handleAdd" v-hasPermi="['system:complaintDispute:add']">新增</el-button>
        <el-button type="success" icon="i-ep:Edit" :disabled="single" @click="handleUpdate()" v-hasPermi="['system:complaintDispute:edit']"
          >修改</el-button
        >
        <el-button type="danger" icon="i-ep:Delete" :disabled="multiple" @click="handleDelete()" v-hasPermi="['system:complaintDispute:remove']"
          >删除</el-button
        >
        <el-button type="warning" icon="i-ep:Download" @click="handleExport" v-hasPermi="['system:complaintDispute:export']">导出</el-button>
        <el-button type="info" icon="i-ep:Upload" @click="handleImport" v-hasPermi="['system:complaintDispute:import']">导入</el-button>
        <el-button type="primary" icon="i-ep:Setting" @click="showFieldConfig = true">字段配置</el-button>
        <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
      </div>
    </div>

    <!-- 搜索区域 -->
    <div class="search-card" v-show="showSearch">
      <el-form ref="queryFormRef" :model="queryParams" :inline="true">
        <el-form-item label="投诉编号" prop="complaintNo">
          <el-input v-model="queryParams.complaintNo" placeholder="请输入投诉编号" clearable @keyup.enter="handleQuery" />
        </el-form-item>
        <el-form-item label="投诉来源" prop="complaintSource">
          <el-input v-model="queryParams.complaintSource" placeholder="请输入投诉来源" clearable @keyup.enter="handleQuery" />
        </el-form-item>
        <el-form-item label="投诉人姓名" prop="complainantName">
          <el-input v-model="queryParams.complainantName" placeholder="请输入投诉人姓名" clearable @keyup.enter="handleQuery" />
        </el-form-item>
        <el-form-item label="投诉人联系方式" prop="complainantContact">
          <el-input v-model="queryParams.complainantContact" placeholder="请输入投诉人联系方式" clearable @keyup.enter="handleQuery" />
        </el-form-item>
        <el-form-item label="患者姓名" prop="patientName">
          <el-input v-model="queryParams.patientName" placeholder="请输入患者姓名" clearable @keyup.enter="handleQuery" />
        </el-form-item>
        <el-form-item label="涉及医师姓名" prop="doctorName">
          <el-input v-model="queryParams.doctorName" placeholder="请输入涉及医师姓名" clearable @keyup.enter="handleQuery" />
        </el-form-item>
        <el-form-item label="涉及科室名称" prop="departmentName">
          <el-input v-model="queryParams.departmentName" placeholder="请输入涉及科室名称" clearable @keyup.enter="handleQuery" />
        </el-form-item>
        <el-form-item label="投诉时间" prop="complaintTime">
          <el-date-picker clearable v-model="queryParams.complaintTime" type="date" value-format="YYYY-MM-DD" placeholder="请选择投诉时间" />
        </el-form-item>
        <el-form-item label="优先级" prop="priorityLevel">
          <el-select v-model="queryParams.priorityLevel" placeholder="请选择优先级" clearable style="width: 120px">
            <el-option label="低" value="低" />
            <el-option label="中" value="中" />
            <el-option label="高" value="高" />
            <el-option label="紧急" value="紧急" />
          </el-select>
        </el-form-item>
        <el-form-item label="是否构成纠纷" prop="isDispute">
          <el-select v-model="queryParams.isDispute" placeholder="请选择是否构成纠纷" clearable style="width: 120px">
            <el-option label="是" value="1" />
            <el-option label="否" value="0" />
          </el-select>
        </el-form-item>
        <el-form-item label="纠纷确认说明" prop="disputeConfirmation">
          <el-input v-model="queryParams.disputeConfirmation" placeholder="请输入纠纷确认说明" clearable @keyup.enter="handleQuery" />
        </el-form-item>
        <el-form-item label="最终处理结果" prop="finalResult">
          <el-input v-model="queryParams.finalResult" placeholder="请输入最终处理结果" clearable @keyup.enter="handleQuery" />
        </el-form-item>
        <el-form-item label="删除标志" prop="delFlag">
          <el-input v-model="queryParams.delFlag" placeholder="请输入删除标志" clearable @keyup.enter="handleQuery" />
        </el-form-item>
        <el-form-item>
          <el-button type="primary" icon="i-ep:Search" @click="handleQuery">搜索</el-button>
          <el-button icon="i-ep:Refresh" @click="resetQuery">重置</el-button>
        </el-form-item>
      </el-form>
    </div>

    <!-- 表格区域 -->
    <div class="table-card">
      <el-table v-loading="loading" border :data="complaintDisputeList" @selection-change="handleSelectionChange" class="modern-table">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="主键ID" align="center" prop="id" v-if="false" />
        <el-table-column
          v-if="fieldConfigManager.getFieldConfig('complaintNo').visible"
          :label="fieldConfigManager.getFieldConfig('complaintNo').label"
          align="center"
          prop="complaintNo"
          :min-width="fieldConfigManager.getFieldConfig('complaintNo').width"
          resizable
        />
        <el-table-column
          v-if="fieldConfigManager.getFieldConfig('complaintType').visible"
          :label="fieldConfigManager.getFieldConfig('complaintType').label"
          align="center"
          prop="complaintType"
          :min-width="fieldConfigManager.getFieldConfig('complaintType').width"
          resizable
        />
        <el-table-column
          v-if="fieldConfigManager.getFieldConfig('complaintSource').visible"
          :label="fieldConfigManager.getFieldConfig('complaintSource').label"
          align="center"
          prop="complaintSource"
          :min-width="fieldConfigManager.getFieldConfig('complaintSource').width"
          resizable
        />
        <el-table-column
          v-if="fieldConfigManager.getFieldConfig('complainantName').visible"
          :label="fieldConfigManager.getFieldConfig('complainantName').label"
          align="center"
          prop="complainantName"
          :min-width="fieldConfigManager.getFieldConfig('complainantName').width"
          resizable
        />
        <el-table-column
          v-if="fieldConfigManager.getFieldConfig('complainantContact').visible"
          :label="fieldConfigManager.getFieldConfig('complainantContact').label"
          align="center"
          prop="complainantContact"
          :min-width="fieldConfigManager.getFieldConfig('complainantContact').width"
          resizable
        />
        <el-table-column
          v-if="fieldConfigManager.getFieldConfig('patientName').visible"
          :label="fieldConfigManager.getFieldConfig('patientName').label"
          align="center"
          prop="patientName"
          :min-width="fieldConfigManager.getFieldConfig('patientName').width"
          resizable
        />
        <el-table-column
          v-if="fieldConfigManager.getFieldConfig('doctorName').visible"
          :label="fieldConfigManager.getFieldConfig('doctorName').label"
          align="center"
          prop="doctorName"
          :min-width="fieldConfigManager.getFieldConfig('doctorName').width"
          resizable
        />
        <el-table-column
          v-if="fieldConfigManager.getFieldConfig('departmentName').visible"
          :label="fieldConfigManager.getFieldConfig('departmentName').label"
          align="center"
          prop="departmentName"
          :min-width="fieldConfigManager.getFieldConfig('departmentName').width"
          resizable
        />
        <el-table-column
          v-if="fieldConfigManager.getFieldConfig('complaintContent').visible"
          :label="fieldConfigManager.getFieldConfig('complaintContent').label"
          align="center"
          prop="complaintContent"
          :min-width="fieldConfigManager.getFieldConfig('complaintContent').width"
          resizable
        />
        <el-table-column
          v-if="fieldConfigManager.getFieldConfig('complaintTime').visible"
          :label="fieldConfigManager.getFieldConfig('complaintTime').label"
          align="center"
          prop="complaintTime"
          :min-width="fieldConfigManager.getFieldConfig('complaintTime').width"
          resizable
        >
          <template #default="scope">
            <span>{{ parseTime(scope.row.complaintTime, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column
          v-if="fieldConfigManager.getFieldConfig('currentStatus').visible"
          :label="fieldConfigManager.getFieldConfig('currentStatus').label"
          align="center"
          prop="currentStatus"
          :min-width="fieldConfigManager.getFieldConfig('currentStatus').width"
          resizable
        />
        <el-table-column
          v-if="fieldConfigManager.getFieldConfig('priorityLevel').visible"
          :label="fieldConfigManager.getFieldConfig('priorityLevel').label"
          align="center"
          prop="priorityLevel"
          :min-width="fieldConfigManager.getFieldConfig('priorityLevel').width"
          resizable
        />
        <el-table-column
          v-if="fieldConfigManager.getFieldConfig('isDispute').visible"
          :label="fieldConfigManager.getFieldConfig('isDispute').label"
          align="center"
          prop="isDispute"
          :min-width="fieldConfigManager.getFieldConfig('isDispute').width"
          resizable
        >
          <template #default="scope">
            <el-tag :type="scope.row.isDispute === '1' ? 'danger' : 'success'">
              {{ scope.row.isDispute === '1' ? '是' : '否' }}
            </el-tag>
          </template>
        </el-table-column>
        <el-table-column
          v-if="fieldConfigManager.getFieldConfig('disputeConfirmation').visible"
          :label="fieldConfigManager.getFieldConfig('disputeConfirmation').label"
          align="center"
          prop="disputeConfirmation"
          :min-width="fieldConfigManager.getFieldConfig('disputeConfirmation').width"
          resizable
        />
        <el-table-column
          v-if="fieldConfigManager.getFieldConfig('finalResult').visible"
          :label="fieldConfigManager.getFieldConfig('finalResult').label"
          align="center"
          prop="finalResult"
          :min-width="fieldConfigManager.getFieldConfig('finalResult').width"
          resizable
        />
        <el-table-column
          v-if="fieldConfigManager.getFieldConfig('delFlag').visible"
          :label="fieldConfigManager.getFieldConfig('delFlag').label"
          align="center"
          prop="delFlag"
          :min-width="fieldConfigManager.getFieldConfig('delFlag').width"
          resizable
        />
        <el-table-column label="操作" align="center" fixed="right" class-name="small-padding fixed-width" width="120">
          <template #default="scope">
            <div class="flex items-center justify-center space-x-1">
              <el-tooltip content="修改" placement="top">
                <el-button
                  link
                  type="primary"
                  icon="i-ep:Edit"
                  @click="handleUpdate(scope.row)"
                  v-hasPermi="['system:complaintDispute:edit']"
                  size="small"
                ></el-button>
              </el-tooltip>
              <el-tooltip content="删除" placement="top">
                <el-button
                  link
                  type="danger"
                  icon="i-ep:Delete"
                  @click="handleDelete(scope.row)"
                  v-hasPermi="['system:complaintDispute:remove']"
                  size="small"
                ></el-button>
              </el-tooltip>
            </div>
          </template>
        </el-table-column>
      </el-table>

      <div class="pagination-container mt-4">
        <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
      </div>
    </div>

    <el-table v-loading="loading" border :data="complaintDisputeList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="主键ID" align="center" prop="id" v-if="false" />
      <el-table-column
        v-if="fieldConfigManager.getFieldConfig('complaintNo').visible"
        :label="fieldConfigManager.getFieldConfig('complaintNo').label"
        align="center"
        prop="complaintNo"
        :min-width="fieldConfigManager.getFieldConfig('complaintNo').width"
        resizable
      />
      <el-table-column
        v-if="fieldConfigManager.getFieldConfig('complaintType').visible"
        :label="fieldConfigManager.getFieldConfig('complaintType').label"
        align="center"
        prop="complaintType"
        :min-width="fieldConfigManager.getFieldConfig('complaintType').width"
        resizable
      />
      <el-table-column
        v-if="fieldConfigManager.getFieldConfig('complaintSource').visible"
        :label="fieldConfigManager.getFieldConfig('complaintSource').label"
        align="center"
        prop="complaintSource"
        :min-width="fieldConfigManager.getFieldConfig('complaintSource').width"
        resizable
      />
      <el-table-column
        v-if="fieldConfigManager.getFieldConfig('complainantName').visible"
        :label="fieldConfigManager.getFieldConfig('complainantName').label"
        align="center"
        prop="complainantName"
        :min-width="fieldConfigManager.getFieldConfig('complainantName').width"
        resizable
      />
      <el-table-column
        v-if="fieldConfigManager.getFieldConfig('complainantContact').visible"
        :label="fieldConfigManager.getFieldConfig('complainantContact').label"
        align="center"
        prop="complainantContact"
        :min-width="fieldConfigManager.getFieldConfig('complainantContact').width"
        resizable
      />
      <el-table-column
        v-if="fieldConfigManager.getFieldConfig('patientName').visible"
        :label="fieldConfigManager.getFieldConfig('patientName').label"
        align="center"
        prop="patientName"
        :min-width="fieldConfigManager.getFieldConfig('patientName').width"
        resizable
      />
      <el-table-column
        v-if="fieldConfigManager.getFieldConfig('doctorName').visible"
        :label="fieldConfigManager.getFieldConfig('doctorName').label"
        align="center"
        prop="doctorName"
        :min-width="fieldConfigManager.getFieldConfig('doctorName').width"
        resizable
      />
      <el-table-column
        v-if="fieldConfigManager.getFieldConfig('departmentName').visible"
        :label="fieldConfigManager.getFieldConfig('departmentName').label"
        align="center"
        prop="departmentName"
        :min-width="fieldConfigManager.getFieldConfig('departmentName').width"
        resizable
      />
      <el-table-column
        v-if="fieldConfigManager.getFieldConfig('complaintContent').visible"
        :label="fieldConfigManager.getFieldConfig('complaintContent').label"
        align="center"
        prop="complaintContent"
        :min-width="fieldConfigManager.getFieldConfig('complaintContent').width"
        resizable
      />
      <el-table-column
        v-if="fieldConfigManager.getFieldConfig('complaintTime').visible"
        :label="fieldConfigManager.getFieldConfig('complaintTime').label"
        align="center"
        prop="complaintTime"
        :min-width="fieldConfigManager.getFieldConfig('complaintTime').width"
        resizable
      >
        <template #default="scope">
          <span>{{ parseTime(scope.row.complaintTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column
        v-if="fieldConfigManager.getFieldConfig('currentStatus').visible"
        :label="fieldConfigManager.getFieldConfig('currentStatus').label"
        align="center"
        prop="currentStatus"
        :min-width="fieldConfigManager.getFieldConfig('currentStatus').width"
        resizable
      />
      <el-table-column
        v-if="fieldConfigManager.getFieldConfig('priorityLevel').visible"
        :label="fieldConfigManager.getFieldConfig('priorityLevel').label"
        align="center"
        prop="priorityLevel"
        :min-width="fieldConfigManager.getFieldConfig('priorityLevel').width"
        resizable
      />
      <el-table-column
        v-if="fieldConfigManager.getFieldConfig('isDispute').visible"
        :label="fieldConfigManager.getFieldConfig('isDispute').label"
        align="center"
        prop="isDispute"
        :min-width="fieldConfigManager.getFieldConfig('isDispute').width"
        resizable
      >
        <template #default="scope">
          <el-tag :type="scope.row.isDispute === '1' ? 'danger' : 'success'">
            {{ scope.row.isDispute === '1' ? '是' : '否' }}
          </el-tag>
        </template>
      </el-table-column>
      <el-table-column
        v-if="fieldConfigManager.getFieldConfig('disputeConfirmation').visible"
        :label="fieldConfigManager.getFieldConfig('disputeConfirmation').label"
        align="center"
        prop="disputeConfirmation"
        :min-width="fieldConfigManager.getFieldConfig('disputeConfirmation').width"
        resizable
      />
      <el-table-column
        v-if="fieldConfigManager.getFieldConfig('finalResult').visible"
        :label="fieldConfigManager.getFieldConfig('finalResult').label"
        align="center"
        prop="finalResult"
        :min-width="fieldConfigManager.getFieldConfig('finalResult').width"
        resizable
      />
      <el-table-column
        v-if="fieldConfigManager.getFieldConfig('delFlag').visible"
        :label="fieldConfigManager.getFieldConfig('delFlag').label"
        align="center"
        prop="delFlag"
        :min-width="fieldConfigManager.getFieldConfig('delFlag').width"
        resizable
      />
      <el-table-column label="操作" align="center" fixed="right" class-name="small-padding fixed-width">
        <template #default="scope">
          <el-tooltip content="修改" placement="top">
            <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['system:complaintDispute:edit']"></el-button>
          </el-tooltip>
          <el-tooltip content="删除" placement="top">
            <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)" v-hasPermi="['system:complaintDispute:remove']"></el-button>
          </el-tooltip>
        </template>
      </el-table-column>
    </el-table>

    <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
  </div>
  <!-- 添加或修改投诉纠纷主对话框 -->
  <el-dialog :title="dialog.title" v-model="dialog.visible" width="700px" append-to-body>
    <el-form ref="complaintDisputeFormRef" :model="form" :rules="rules" label-width="120px">
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="投诉编号" prop="complaintNo">
            <el-input v-model="form.complaintNo" placeholder="请输入投诉编号" />
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="投诉来源" prop="complaintSource">
            <el-input v-model="form.complaintSource" placeholder="请输入投诉来源" />
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="投诉人姓名" prop="complainantName">
            <el-input v-model="form.complainantName" placeholder="请输入投诉人姓名" />
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="投诉人联系方式" prop="complainantContact">
            <el-input v-model="form.complainantContact" placeholder="请输入投诉人联系方式" />
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="患者姓名" prop="patientName">
            <el-input v-model="form.patientName" placeholder="请输入患者姓名" />
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="患者ID" prop="patientId">
            <el-input v-model="form.patientId" placeholder="请输入患者ID" />
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="涉及医师ID" prop="doctorId">
            <el-input v-model="form.doctorId" placeholder="请输入涉及医师ID" />
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="涉及医师姓名" prop="doctorName">
            <el-input v-model="form.doctorName" placeholder="请输入涉及医师姓名" />
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="涉及科室ID" prop="departmentId">
            <el-input v-model="form.departmentId" placeholder="请输入涉及科室ID" />
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="涉及科室名称" prop="departmentName">
            <el-input v-model="form.departmentName" placeholder="请输入涉及科室名称" />
          </el-form-item>
        </el-col>
      </el-row>
      <el-form-item label="投诉内容">
        <editor v-model="form.complaintContent" :min-height="192" />
      </el-form-item>
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="投诉时间" prop="complaintTime">
            <el-date-picker
              clearable
              v-model="form.complaintTime"
              type="datetime"
              value-format="YYYY-MM-DD HH:mm:ss"
              placeholder="请选择投诉时间"
              style="width: 100%"
            >
            </el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="优先级" prop="priorityLevel">
            <el-select v-model="form.priorityLevel" placeholder="请选择优先级" style="width: 100%">
              <el-option label="低" value="低" />
              <el-option label="中" value="中" />
              <el-option label="高" value="高" />
              <el-option label="紧急" value="紧急" />
            </el-select>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="8">
          <el-form-item label="是否构成纠纷" prop="isDispute">
            <el-select v-model="form.isDispute" placeholder="请选择是否构成纠纷" style="width: 100%">
              <el-option label="是" value="1" />
              <el-option label="否" value="0" />
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="8">
          <el-form-item label="当前状态" prop="currentStatus">
            <el-select v-model="form.currentStatus" placeholder="请选择当前状态" style="width: 100%">
              <el-option label="待处理" value="待处理" />
              <el-option label="处理中" value="处理中" />
              <el-option label="已完成" value="已完成" />
              <el-option label="已关闭" value="已关闭" />
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="8">
          <el-form-item label="删除标志" prop="delFlag">
            <el-select v-model="form.delFlag" placeholder="请选择删除标志" style="width: 100%">
              <el-option label="正常" value="0" />
              <el-option label="已删除" value="1" />
            </el-select>
          </el-form-item>
        </el-col>
      </el-row>
      <el-form-item label="纠纷确认说明" prop="disputeConfirmation">
        <el-input v-model="form.disputeConfirmation" type="textarea" :rows="3" placeholder="请输入纠纷确认说明" />
      </el-form-item>
      <el-form-item label="最终处理结果" prop="finalResult">
        <el-input v-model="form.finalResult" type="textarea" :rows="3" placeholder="请输入最终处理结果" />
      </el-form-item>
    </el-form>
    <template #footer>
      <div class="dialog-footer">
        <el-button :loading="buttonLoading" type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </template>
  </el-dialog>

  <!-- 字段配置对话框 -->
  <FieldConfigDialog v-model:visible="showFieldConfig" :field-config-manager="fieldConfigManager" />
</template>

<script setup name="ComplaintDispute" lang="ts">
import {
  listComplaintDispute,
  getComplaintDispute,
  delComplaintDispute,
  addComplaintDispute,
  updateComplaintDispute
} from '@/api/complaindispute/complaintDispute';
import { ComplaintDisputeVO, ComplaintDisputeQuery, ComplaintDisputeForm } from '@/api/complaindispute/complaintDispute/types';
import { createComplaintDisputeFieldConfig } from '@/utils/fieldConfig';
import FieldConfigDialog from '@/components/FieldConfigDialog.vue';
import { ref, reactive, toRefs, onMounted, getCurrentInstance, type ComponentInternalInstance } from 'vue';
import { FormInstance } from 'element-plus';
import { parseTime } from '@/utils/ruoyi';

// 本地类型定义
interface DialogOption {
  visible: boolean;
  title: string;
}

interface PageData<T, Q> {
  form: T;
  queryParams: Q;
  rules: Record<string, any>;
}

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const complaintDisputeList = ref<ComplaintDisputeVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const showFieldConfig = ref(false);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

// 字段配置管理器
const fieldConfigManager = createComplaintDisputeFieldConfig();

const queryFormRef = ref<FormInstance>();
const complaintDisputeFormRef = ref<FormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: ComplaintDisputeForm = {
  id: undefined,
  complaintNo: undefined,
  complaintType: undefined,
  complaintSource: undefined,
  complainantName: undefined,
  complainantContact: undefined,
  patientName: undefined,
  patientId: undefined,
  doctorId: undefined,
  doctorName: undefined,
  departmentId: undefined,
  departmentName: undefined,
  complaintContent: undefined,
  complaintTime: undefined,
  currentStatus: undefined,
  priorityLevel: undefined,
  isDispute: undefined,
  disputeConfirmation: undefined,
  finalResult: undefined,
  delFlag: undefined
};
const data = reactive<PageData<ComplaintDisputeForm, ComplaintDisputeQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    complaintNo: undefined,
    complaintType: undefined,
    complaintSource: undefined,
    complainantName: undefined,
    complainantContact: undefined,
    patientName: undefined,
    doctorName: undefined,
    departmentName: undefined,
    complaintContent: undefined,
    complaintTime: undefined,
    currentStatus: undefined,
    priorityLevel: undefined,
    isDispute: undefined,
    disputeConfirmation: undefined,
    finalResult: undefined,
    delFlag: undefined,
    params: {}
  },
  rules: {
    complaintNo: [{ required: true, message: '投诉编号不能为空', trigger: 'blur' }],
    complaintType: [{ required: true, message: '投诉类型不能为空', trigger: 'change' }],
    complaintContent: [{ required: true, message: '投诉内容不能为空', trigger: 'blur' }],
    complaintTime: [{ required: true, message: '投诉时间不能为空', trigger: 'blur' }],
    currentStatus: [{ required: true, message: '当前状态不能为空', trigger: 'change' }]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询投诉纠纷主列表 */
const getList = async () => {
  loading.value = true;
  const res = await listComplaintDispute(queryParams.value);
  complaintDisputeList.value = res.rows;
  total.value = res.total;
  loading.value = false;
};

/** 取消按钮 */
const cancel = () => {
  reset();
  dialog.visible = false;
};

/** 表单重置 */
const reset = () => {
  form.value = { ...initFormData };
  complaintDisputeFormRef.value?.resetFields();
};

/** 搜索按钮操作 */
const handleQuery = () => {
  queryParams.value.pageNum = 1;
  getList();
};

/** 重置按钮操作 */
const resetQuery = () => {
  queryFormRef.value?.resetFields();
  handleQuery();
};

/** 多选框选中数据 */
const handleSelectionChange = (selection: ComplaintDisputeVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加投诉纠纷主';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: ComplaintDisputeVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getComplaintDispute(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改投诉纠纷主';
};

/** 提交按钮 */
const submitForm = () => {
  complaintDisputeFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateComplaintDispute(form.value).finally(() => (buttonLoading.value = false));
      } else {
        await addComplaintDispute(form.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: ComplaintDisputeVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除投诉纠纷主编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delComplaintDispute(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/complaintDispute/export',
    {
      ...queryParams.value
    },
    `complaintDispute_${new Date().getTime()}.xlsx`
  );
};

/** 导入按钮操作 */
const handleImport = () => {
  proxy?.upload({
    url: 'system/complaintDispute/importData',
    accept: '.xlsx,.xls',
    onSuccess: () => {
      proxy?.$modal.msgSuccess('导入成功');
      getList();
    }
  });
};

onMounted(() => {
  getList();
});
</script>

<style scoped>
.app-container {
  background-color: #f5f5f5;
  min-height: 100vh;
  padding: 20px;
}

.page-header {
  margin-bottom: 20px;
}

.page-header h1 {
  color: #1d2129;
  font-size: 1.5rem;
  font-weight: 600;
  margin-bottom: 8px;
}

.page-header p {
  color: #666;
  margin: 0;
}

.search-card {
  background: white;
  border-radius: 8px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
  padding: 20px;
  margin-bottom: 20px;
  transition: box-shadow 0.3s ease;
}

.search-card:hover {
  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.15);
}

.table-card {
  background: white;
  border-radius: 8px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
  overflow: hidden;
}

.modern-table {
  border-radius: 8px;
  overflow: hidden;
}

.modern-table .el-table__header {
  background-color: #fafafa;
}

.modern-table .el-table__row {
  transition: background-color 0.3s ease;
}

.modern-table .el-table__row:hover {
  background-color: #f5f5f5;
}

.pagination-container {
  display: flex;
  justify-content: center;
  padding: 20px 0;
}

/* 响应式设计 */
@media (max-width: 768px) {
  .app-container {
    padding: 10px;
  }

  .page-header {
    text-align: center;
  }

  .page-header .flex {
    flex-direction: column;
    align-items: center;
    gap: 16px;
  }

  .search-form {
    flex-direction: column;
  }

  .search-form .el-form-item {
    width: 100%;
  }
}

@media (max-width: 480px) {
  .app-container {
    padding: 5px;
  }

  .page-header h1 {
    font-size: 1.25rem;
  }
}
</style>
