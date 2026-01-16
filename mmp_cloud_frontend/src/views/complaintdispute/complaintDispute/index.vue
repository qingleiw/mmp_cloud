<template>
  <div class="app-container">
    <!-- 页面标题 -->
    <div class="page-header mb-4">
      <h2 class="page-title">
        <i-ep-setting class="title-icon"></i-ep-setting>
        投诉纠纷管理
      </h2>
      <p class="page-description">管理系统中的投诉纠纷信息，包括投诉处理、纠纷确认等功能</p>
    </div>

    <!-- 动态搜索表单 -->
    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <div v-show="showSearch" class="search-container mb-4">
        <el-card shadow="hover" class="search-card">
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

    <!-- 数据表格 -->
    <el-card shadow="never" class="table-card">
      <template #header>
        <div class="table-header">
          <div class="table-title">
            <i-ep-list class="table-icon"></i-ep-list>
            <span>投诉纠纷列表</span>
            <el-tag type="info" size="small" class="ml-2">{{ total }} 条记录</el-tag>
          </div>
          <div class="table-actions">
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['system:complaintDispute:add']" size="small"
              >新增</el-button
            >
            <el-button
              type="success"
              plain
              icon="Edit"
              :disabled="single"
              @click="handleUpdate()"
              v-hasPermi="['system:complaintDispute:edit']"
              size="small"
              >修改</el-button
            >
            <el-button
              type="danger"
              plain
              icon="Delete"
              :disabled="multiple"
              @click="handleDelete()"
              v-hasPermi="['system:complaintDispute:remove']"
              size="small"
              >删除</el-button
            >
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['system:complaintDispute:export']" size="small"
              >导出</el-button
            >
            <el-button text type="primary" @click="handleFieldConfig" class="config-btn">
              <i-ep-setting class="btn-icon"></i-ep-setting>
              字段配置
            </el-button>
            <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
          </div>
        </div>
      </template>

      <el-table v-loading="loading" border :data="complaintDisputeList" @selection-change="handleSelectionChange" class="complaint-dispute-table">
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
            <!-- 投诉类型标签 -->
            <el-tag v-if="field.prop === 'complaintType'" :type="getComplaintTypeTagType(scope.row.complaintType)">
              {{ scope.row.complaintType }}
            </el-tag>
            <!-- 当前状态标签 -->
            <el-tag v-else-if="field.prop === 'currentStatus'" :type="getCurrentStatusTagType(scope.row.currentStatus)">
              {{ scope.row.currentStatus }}
            </el-tag>
            <!-- 优先级标签 -->
            <el-tag v-else-if="field.prop === 'priorityLevel'" :type="getPriorityLevelTagType(scope.row.priorityLevel)">
              {{ scope.row.priorityLevel }}
            </el-tag>
            <!-- 是否构成纠纷标签 -->
            <el-tag v-else-if="field.prop === 'isDispute'" :type="scope.row.isDispute === '1' ? 'danger' : 'success'">
              {{ scope.row.isDispute === '1' ? '是' : '否' }}
            </el-tag>
            <!-- 删除标志字段 -->
            <el-tag v-else-if="field.prop === 'delFlag'" :type="scope.row.delFlag === '0' ? 'success' : 'danger'">
              {{ scope.row.delFlag === '0' ? '未删除' : '已删除' }}
            </el-tag>
            <!-- 日期字段格式化 -->
            <span v-else-if="field.prop === 'complaintTime'">
              {{ parseTime(scope.row.complaintTime, '{y}-{m}-{d}') }}
            </span>
            <!-- 时间字段格式化 -->
            <span v-else-if="field.prop === 'createTime' || field.prop === 'updateTime'">
              {{ parseTime(scope.row[field.prop], '{y}-{m}-{d} {h}:{i}') }}
            </span>
            <!-- 默认显示 -->
            <span v-else>{{ scope.row[field.prop] }}</span>
          </template>
        </el-table-column>
        <el-table-column label="操作" align="center" fixed="right" class-name="small-padding fixed-width">
          <template #default="scope">
            <el-tooltip content="修改" placement="top">
              <el-button
                link
                type="primary"
                icon="Edit"
                @click="handleUpdate(scope.row)"
                v-hasPermi="['system:complaintDispute:edit']"
              ></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button
                link
                type="primary"
                icon="Delete"
                @click="handleDelete(scope.row)"
                v-hasPermi="['system:complaintDispute:remove']"
              ></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>

    <!-- 添加或修改投诉纠纷对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="700px" append-to-body>
      <el-form ref="complaintDisputeFormRef" :model="form" :rules="rules" label-width="120px">
        <el-row :gutter="20">
          <el-col
            v-for="field in fieldConfigManager.getFormFields()"
            :key="field.prop"
            :span="field.colSpan || 12"
          >
            <el-form-item :label="field.label" :prop="field.prop" :rules="field.rules">
              <!-- 投诉类型选择框 -->
              <el-select v-if="field.prop === 'complaintType'" v-model="form.complaintType" placeholder="请选择投诉类型" clearable style="width: 100%">
                <el-option label="医疗质量" value="医疗质量" />
                <el-option label="服务态度" value="服务态度" />
                <el-option label="费用问题" value="费用问题" />
                <el-option label="其他" value="其他" />
              </el-select>
              <!-- 当前状态选择框 -->
              <el-select v-else-if="field.prop === 'currentStatus'" v-model="form.currentStatus" placeholder="请选择当前状态" clearable style="width: 100%">
                <el-option label="待处理" value="待处理" />
                <el-option label="处理中" value="处理中" />
                <el-option label="已完成" value="已完成" />
                <el-option label="已关闭" value="已关闭" />
              </el-select>
              <!-- 优先级选择框 -->
              <el-select v-else-if="field.prop === 'priorityLevel'" v-model="form.priorityLevel" placeholder="请选择优先级" clearable style="width: 100%">
                <el-option label="低" value="低" />
                <el-option label="中" value="中" />
                <el-option label="高" value="高" />
                <el-option label="紧急" value="紧急" />
              </el-select>
              <!-- 是否构成纠纷选择框 -->
              <el-select v-else-if="field.prop === 'isDispute'" v-model="form.isDispute" placeholder="请选择是否构成纠纷" clearable style="width: 100%">
                <el-option label="是" value="1" />
                <el-option label="否" value="0" />
              </el-select>
              <!-- 删除标志选择框 -->
              <el-select v-else-if="field.prop === 'delFlag'" v-model="form.delFlag" placeholder="请选择状态" clearable style="width: 100%">
                <el-option label="未删除" value="0" />
                <el-option label="已删除" value="1" />
              </el-select>
              <!-- 日期时间选择器 -->
              <el-date-picker
                v-else-if="field.prop === 'complaintTime'"
                clearable
                v-model="form.complaintTime"
                type="datetime"
                value-format="YYYY-MM-DD HH:mm:ss"
                placeholder="请选择投诉时间"
                style="width: 100%"
              />
              <!-- 文本域 -->
              <el-input
                v-else-if="field.type === 'textarea'"
                v-model="form[field.prop]"
                type="textarea"
                :placeholder="field.placeholder || `请输入${field.label}`"
                :maxlength="field.maxlength"
                :show-word-limit="field.showWordLimit"
                :rows="field.rows || 3"
              />
              <!-- 默认文本输入框 -->
              <el-input
                v-else
                v-model="form[field.prop]"
                :placeholder="field.placeholder || `请输入${field.label}`"
              />
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
    <FieldConfigDialog v-model:visible="showFieldConfig" :field-config-manager="fieldConfigManager" @confirm="handleFieldConfigConfirm" />
    <!-- 搜索配置对话框 -->
    <SearchConfigDialog v-model:visible="searchConfigVisible" :search-config-manager="searchConfigManager" @confirm="handleSearchConfigConfirm" />
  </div>
</template>

<script setup name="ComplaintDispute" lang="ts">
import { ref, reactive, toRefs, computed, onMounted, getCurrentInstance, type ComponentInternalInstance } from 'vue';
import type { FormInstance } from 'element-plus';
import {
  listComplaintDispute,
  getComplaintDispute,
  delComplaintDispute,
  addComplaintDispute,
  updateComplaintDispute
} from '@/api/complaintdispute/complaintDispute';
import { ComplaintDisputeVO, ComplaintDisputeQuery, ComplaintDisputeForm } from '@/api/complaintdispute/complaintDispute/types';
import { FieldConfigManager } from '@/utils/configs/fieldConfigManager';
import { createComplaintDisputeFieldConfig } from '@/utils/configs/complaintdispute/complaintdisputeFieldConfigs';
import { createComplaintDisputeSearchConfig } from '@/utils/configs/complaintdispute/complaintdisputeSearchConfigs';
import FieldConfigDialog from '@/components/FieldConfigDialog.vue';
import DynamicSearchForm from '@/components/DynamicSearchForm.vue';
import SearchConfigDialog from '@/components/SearchConfigDialog.vue';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const complaintDisputeList = ref<ComplaintDisputeVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<FormInstance>();
const complaintDisputeFormRef = ref<FormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

// 配置管理器
const fieldConfigManager = new FieldConfigManager('complaintDispute', createComplaintDisputeFieldConfig());
const searchConfigManager = createComplaintDisputeSearchConfig();
const visibleSearchFields = computed(() => searchConfigManager.getVisibleFields());

// 配置对话框状态
const showFieldConfig = ref(false);
const searchConfigVisible = ref(false);

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

/** 查询投诉纠纷列表 */
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
  dialog.title = '添加投诉纠纷';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: ComplaintDisputeVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getComplaintDispute(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改投诉纠纷';
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
  await proxy?.$modal.confirm('是否确认删除投诉纠纷编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
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

/** 字段配置按钮操作 */
const handleFieldConfig = () => {
  showFieldConfig.value = true;
};

/** 搜索配置按钮操作 */
const handleSearchConfig = () => {
  searchConfigVisible.value = true;
};

/** 字段配置确认 */
const handleFieldConfigConfirm = () => {
  showFieldConfig.value = false;
};

/** 搜索配置确认 */
const handleSearchConfigConfirm = () => {
  searchConfigVisible.value = false;
};

/** 获取投诉类型标签类型 */
const getComplaintTypeTagType = (type: string) => {
  const typeMap: Record<string, string> = {
    '医疗质量': 'danger',
    '服务态度': 'warning',
    '费用问题': 'primary',
    '其他': 'info'
  };
  return typeMap[type] || 'info';
};

/** 获取当前状态标签类型 */
const getCurrentStatusTagType = (status: string) => {
  const statusMap: Record<string, string> = {
    '待处理': 'info',
    '处理中': 'warning',
    '已完成': 'success',
    '已关闭': 'danger'
  };
  return statusMap[status] || 'info';
};

/** 获取优先级标签类型 */
const getPriorityLevelTagType = (level: string) => {
  const levelMap: Record<string, string> = {
    '低': 'info',
    '中': 'primary',
    '高': 'warning',
    '紧急': 'danger'
  };
  return levelMap[level] || 'info';
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
  background: white;
  padding: 20px;
  border-radius: 8px;
  margin-bottom: 20px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);

  .page-title {
    display: flex;
    align-items: center;
    gap: 8px;
    margin: 0 0 8px 0;
    color: #1d2129;
    font-size: 18px;
    font-weight: 600;

    .title-icon {
      color: #409eff;
      font-size: 20px;
    }
  }

  .page-description {
    margin: 0;
    color: #86909c;
    font-size: 14px;
  }
}

.search-card {
  background: white;
  border-radius: 8px;
  margin-bottom: 20px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);

  .search-header {
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin-bottom: 16px;

    .search-title {
      font-weight: 600;
      color: #1d2129;
      display: flex;
      align-items: center;
      gap: 6px;

      .search-icon {
        color: #409eff;
      }
    }

    .search-actions {
      .config-btn {
        color: #409eff;

        .btn-icon {
          margin-right: 4px;
        }
      }
    }
  }
}

.table-card {
  border-radius: 8px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);

  .table-header {
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin-bottom: 16px;

    .table-title {
      font-weight: 600;
      color: #1d2129;
      display: flex;
      align-items: center;
      gap: 8px;

      .table-icon {
        color: #409eff;
      }
    }

    .table-actions {
      display: flex;
      gap: 8px;
      align-items: center;

      .config-btn {
        color: #409eff;

        .btn-icon {
          margin-right: 4px;
        }
      }
    }
  }
}

.complaint-dispute-table {
  :deep(.el-table__header) {
    th {
      background-color: #fafafa;
      font-weight: 600;
      color: #1d2129;
    }
  }

  :deep(.el-table__row) {
    &:hover {
      background-color: #f5f7fa;
    }
  }
}

@media (max-width: 768px) {
  .app-container {
    padding: 12px;
  }

  .page-header {
    .page-title {
      font-size: 20px;
    }
  }

  .table-header {
    flex-direction: column;
    align-items: flex-start;
    gap: 12px;

    .table-actions {
      width: 100%;
      justify-content: flex-end;
    }
  }
}
</style>