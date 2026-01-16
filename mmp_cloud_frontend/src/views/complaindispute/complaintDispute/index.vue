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
    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <div class="search-card" v-show="showSearch">
        <el-card shadow="hover">
          <template #header>
            <div class="search-header">
              <span class="search-title">
                <i-ep-search class="search-icon"></i-ep-search>
                搜索条件
              </span>
              <div class="search-actions">
                <el-button text type="primary" @click="handleSearchConfig" class="config-btn">
                  <i-ep-setting class="btn-icon"></i-ep-setting>
                  搜索配置
                </el-button>
              </div>
            </div>
          </template>
          <DynamicSearchForm
            ref="queryFormRef"
            :query="queryParams"
            :visible-fields="visibleSearchFields"
            @search="handleQuery"
            @reset="resetQuery"
          />
        </el-card>
      </div>
    </transition>

    <!-- 表格区域 -->
    <div class="table-card">
      <el-table v-loading="loading" border :data="complaintDisputeList" @selection-change="handleSelectionChange" class="modern-table">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column
          v-for="field in fieldConfigManager.getVisibleFields()"
          :key="field.prop"
          :label="field.label"
          align="center"
          :prop="field.prop"
          :width="field.width"
          :min-width="field.minWidth || 120"
          resizable
        >
          <template #default="scope">
            <!-- 日期字段格式化 -->
            <span v-if="field.prop === 'complaintTime'">
              {{ parseTime(scope.row[field.prop], '{y}-{m}-{d}') }}
            </span>
            <!-- 删除标志字段 -->
            <el-tag v-else-if="field.prop === 'delFlag'" :type="scope.row[field.prop] === '0' ? 'success' : 'danger'">
              {{ scope.row[field.prop] === '0' ? '未删除' : '已删除' }}
            </el-tag>
            <!-- 是否构成纠纷字段 -->
            <el-tag v-else-if="field.prop === 'isDispute'" :type="scope.row[field.prop] === '1' ? 'danger' : 'success'">
              {{ scope.row[field.prop] === '1' ? '是' : '否' }}
            </el-tag>
            <!-- 默认显示 -->
            <span v-else>{{ scope.row[field.prop] }}</span>
          </template>
        </el-table-column>
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
  <!-- 添加或修改投诉纠纷主对话框 -->
  <el-dialog :title="dialog.title" v-model="dialog.visible" width="700px" append-to-body>
    <el-form ref="complaintDisputeFormRef" :model="form" :rules="rules" label-width="120px">
      <el-row :gutter="20">
        <el-col
          v-for="field in fieldConfigManager.getVisibleFields()"
          :key="field.prop"
          :span="field.type === 'textarea' ? 24 : 12"
        >
          <el-form-item :label="field.label" :prop="field.prop" v-if="field.prop !== 'createTime' && field.prop !== 'updateTime'">
            <el-select v-if="field.prop === 'complaintType'" v-model="form.complaintType" placeholder="请选择投诉类型" style="width: 100%">
              <el-option label="医疗质量" value="医疗质量" />
              <el-option label="服务态度" value="服务态度" />
              <el-option label="费用问题" value="费用问题" />
              <el-option label="其他" value="其他" />
            </el-select>
            <el-select v-else-if="field.prop === 'currentStatus'" v-model="form.currentStatus" placeholder="请选择当前状态" style="width: 100%">
              <el-option label="待处理" value="待处理" />
              <el-option label="处理中" value="处理中" />
              <el-option label="已完成" value="已完成" />
              <el-option label="已关闭" value="已关闭" />
            </el-select>
            <el-select v-else-if="field.prop === 'priorityLevel'" v-model="form.priorityLevel" placeholder="请选择优先级" style="width: 100%">
              <el-option label="低" value="低" />
              <el-option label="中" value="中" />
              <el-option label="高" value="高" />
              <el-option label="紧急" value="紧急" />
            </el-select>
            <el-select v-else-if="field.prop === 'isDispute'" v-model="form.isDispute" placeholder="请选择是否构成纠纷" style="width: 100%">
              <el-option label="是" value="1" />
              <el-option label="否" value="0" />
            </el-select>
            <el-input v-else-if="field.type === 'input' || !field.type" v-model="form[field.prop]" :placeholder="`请输入${field.label}`" />
            <el-input
              v-else-if="field.type === 'textarea'"
              v-model="form[field.prop]"
              type="textarea"
              :placeholder="`请输入${field.label}`"
              :rows="3"
            />
            <el-date-picker
              v-else-if="field.type === 'datetime'"
              clearable
              v-model="form[field.prop]"
              type="datetime"
              value-format="YYYY-MM-DD HH:mm:ss"
              :placeholder="`请选择${field.label}`"
              style="width: 100%"
            />
            <el-switch v-else-if="field.type === 'switch'" v-model="form[field.prop]" active-text="是" inactive-text="否" />
            <span v-else>{{ form[field.prop] }}</span>
          </el-form-item>
        </el-col>
      </el-row>
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
  <!-- 搜索配置对话框 -->
  <SearchConfigDialog v-model="searchConfigVisible" :search-config-manager="searchConfigManager" />
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
import { createComplaintDisputeFieldConfig } from '@/utils/configs/complaindispute/complaindisputeFieldConfigs';
import FieldConfigDialog from '@/components/FieldConfigDialog.vue';
import DynamicSearchForm from '@/components/DynamicSearchForm.vue';
import SearchConfigDialog from '@/components/SearchConfigDialog.vue';
import { createComplaintDisputeSearchConfig } from '@/utils/configs/complaindispute/complaindisputeSearchConfigs';
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
const searchConfigManager = createComplaintDisputeSearchConfig();
const searchConfigVisible = ref(false);
const visibleSearchFields = computed(() => searchConfigManager.getVisibleFields());

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

/** 字段配置操作 */
const handleFieldConfig = () => {
  showFieldConfig.value = true;
};

/** 搜索配置操作 */
const handleSearchConfig = () => {
  searchConfigVisible.value = true;
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
