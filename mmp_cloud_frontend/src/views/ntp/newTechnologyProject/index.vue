<template>
  <div class="app-container">
    <!-- 页面标题 -->
    <div class="page-header mb-4">
      <h2 class="page-title">
        <i-ep-setting class="title-icon"></i-ep-setting>
        新技术项目管理
      </h2>
      <p class="page-description">管理系统新技术项目的申请、审批、实施和评估等全流程</p>
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
            <span>新技术项目列表</span>
            <el-tag type="info" size="small" class="ml-2">{{ total }} 条记录</el-tag>
          </div>
          <div class="table-actions">
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['ntp:newTechnologyProject:add']" size="small"
              >新增</el-button
            >
            <el-button
              type="success"
              plain
              icon="Edit"
              :disabled="single"
              @click="handleUpdate()"
              v-hasPermi="['ntp:newTechnologyProject:edit']"
              size="small"
              >修改</el-button
            >
            <el-button
              type="danger"
              plain
              icon="Delete"
              :disabled="multiple"
              @click="handleDelete()"
              v-hasPermi="['ntp:newTechnologyProject:remove']"
              size="small"
              >删除</el-button
            >
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['ntp:newTechnologyProject:export']" size="small"
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

      <el-table v-loading="loading" border :data="newTechnologyProjectList" @selection-change="handleSelectionChange" class="new-technology-project-table">
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
            <span v-if="field.prop === 'approveDate' || field.prop === 'startDate' || field.prop === 'endDate' || field.prop === 'actualEndDate'">
              {{ parseTime(scope.row[field.prop], '{y}-{m}-{d}') }}
            </span>
            <!-- 删除标志字段 -->
            <el-tag v-else-if="field.prop === 'isDeleted'" :type="scope.row[field.prop] === '0' ? 'success' : 'danger'">
              {{ scope.row[field.prop] === '0' ? '未删除' : '已删除' }}
            </el-tag>
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
                v-hasPermi="['ntp:newTechnologyProject:edit']"
              ></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button
                link
                type="primary"
                icon="Delete"
                @click="handleDelete(scope.row)"
                v-hasPermi="['ntp:newTechnologyProject:remove']"
              ></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>

    <!-- 添加或修改新技术项目对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="700px" append-to-body>
      <el-form ref="newTechnologyProjectFormRef" :model="form" :rules="rules" label-width="100px">
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="项目编号" prop="projectNo">
              <el-input v-model="form.projectNo" placeholder="请输入项目编号" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="项目名称" prop="projectName">
              <el-input v-model="form.projectName" placeholder="请输入项目名称" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="技术分类" prop="technologyCategory">
              <el-input v-model="form.technologyCategory" placeholder="请输入技术分类" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="风险等级" prop="riskLevel">
              <el-select v-model="form.riskLevel" placeholder="请选择风险等级" style="width: 100%">
                <el-option label="低风险" :value="'低风险'" />
                <el-option label="中风险" :value="'中风险'" />
                <el-option label="高风险" :value="'高风险'" />
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="申请科室ID" prop="applyDepartmentId">
              <el-input v-model="form.applyDepartmentId" placeholder="请输入申请科室ID" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="申请科室名称" prop="applyDepartmentName">
              <el-input v-model="form.applyDepartmentName" placeholder="请输入申请科室名称" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="项目负责人" prop="projectLeader">
              <el-input v-model="form.projectLeader" placeholder="请输入项目负责人" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="项目团队成员" prop="projectTeam">
              <el-input v-model="form.projectTeam" placeholder="请输入项目团队成员" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="技术来源" prop="technologySource">
              <el-input v-model="form.technologySource" placeholder="请输入技术来源" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="运行周期(天)" prop="operationCycleDays">
              <el-input-number v-model="form.operationCycleDays" :min="1" :max="3650" style="width: 100%" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="进展报告周期" prop="progressReportCycle">
              <el-select v-model="form.progressReportCycle" placeholder="请选择进展报告周期" style="width: 100%">
                <el-option label="月度" :value="'月度'" />
                <el-option label="季度" :value="'季度'" />
                <el-option label="半年度" :value="'半年度'" />
                <el-option label="年度" :value="'年度'" />
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="批准日期" prop="approveDate">
              <el-date-picker
                clearable
                v-model="form.approveDate"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择批准日期"
                style="width: 100%"
              >
              </el-date-picker>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="开始日期" prop="startDate">
              <el-date-picker
                clearable
                v-model="form.startDate"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择开始日期"
                style="width: 100%"
              >
              </el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="预计结束日期" prop="endDate">
              <el-date-picker
                clearable
                v-model="form.endDate"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择预计结束日期"
                style="width: 100%"
              >
              </el-date-picker>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="实际结束日期" prop="actualEndDate">
              <el-date-picker
                clearable
                v-model="form.actualEndDate"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择实际结束日期"
                style="width: 100%"
              >
              </el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="是否删除" prop="isDeleted">
              <el-select v-model="form.isDeleted" placeholder="请选择状态" style="width: 100%">
                <el-option label="未删除" :value="'0'" />
                <el-option label="已删除" :value="'1'" />
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="20">
          <el-col :span="24">
            <el-form-item label="申请理由" prop="applyReason">
              <el-input v-model="form.applyReason" type="textarea" :rows="3" placeholder="请输入申请理由" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="20">
          <el-col :span="24">
            <el-form-item label="技术描述" prop="technologyDescription">
              <el-input v-model="form.technologyDescription" type="textarea" :rows="3" placeholder="请输入技术描述" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="适应症" prop="indication">
              <el-input v-model="form.indication" type="textarea" :rows="3" placeholder="请输入适应症" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="禁忌症" prop="contraindication">
              <el-input v-model="form.contraindication" type="textarea" :rows="3" placeholder="请输入禁忌症" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="预期效果" prop="expectedEffect">
              <el-input v-model="form.expectedEffect" type="textarea" :rows="3" placeholder="请输入预期效果" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="潜在风险" prop="potentialRisk">
              <el-input v-model="form.potentialRisk" type="textarea" :rows="3" placeholder="请输入潜在风险" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="风险控制措施" prop="riskControlMeasure">
              <el-input v-model="form.riskControlMeasure" type="textarea" :rows="3" placeholder="请输入风险控制措施" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="文献支持" prop="literatureSupport">
              <el-input v-model="form.literatureSupport" type="textarea" :rows="3" placeholder="请输入文献支持" />
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
    <SearchConfigDialog v-model:visible="searchConfigVisible" :search-config-manager="searchConfigManager" />
  </div>
</template>

<script setup name="NewTechnologyProject" lang="ts">
import { listNewTechnologyProject, getNewTechnologyProject, delNewTechnologyProject, addNewTechnologyProject, updateNewTechnologyProject } from '@/api/ntp/newTechnologyProject';
import { NewTechnologyProjectVO, NewTechnologyProjectQuery, NewTechnologyProjectForm } from '@/api/ntp/newTechnologyProject/types';
import { createNewTechnologyProjectFieldConfig } from '@/utils/configs/ntp/ntpfieldConfigs';
import FieldConfigDialog from '@/components/FieldConfigDialog.vue';
import DynamicSearchForm from '@/components/DynamicSearchForm.vue';
import SearchConfigDialog from '@/components/SearchConfigDialog.vue';
import { createNewTechnologyProjectSearchConfig } from '@/utils/configs/ntp/ntpsearchConfigs';
import type { FormInstance } from 'element-plus';
import type { DialogOption } from '@/types/global';
import { FieldConfigManager } from '@/utils/configs/fieldConfigManager';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const newTechnologyProjectList = ref<NewTechnologyProjectVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<FormInstance>();
const newTechnologyProjectFormRef = ref<FormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

// 字段配置相关变量
const fieldConfigManager = createNewTechnologyProjectFieldConfig();
const showFieldConfig = ref(false);
const searchConfigManager = createNewTechnologyProjectSearchConfig();
const searchConfigVisible = ref(false);
const visibleSearchFields = computed(() => searchConfigManager.getVisibleFields());

const queryParams = reactive<NewTechnologyProjectQuery>({
  pageNum: 1,
  pageSize: 10,
  projectNo: undefined,
  projectName: undefined,
  technologyCategory: undefined,
  riskLevel: undefined,
  applyDepartmentId: undefined,
  applyDepartmentName: undefined,
  projectLeader: undefined,
  projectTeam: undefined,
  technologySource: undefined,
  applyReason: undefined,
  technologyDescription: undefined,
  indication: undefined,
  contraindication: undefined,
  expectedEffect: undefined,
  potentialRisk: undefined,
  riskControlMeasure: undefined,
  literatureSupport: undefined,
  attachmentUrls: undefined,
  operationCycleDays: undefined,
  progressReportCycle: undefined,
  projectStatus: undefined,
  approveDate: undefined,
  startDate: undefined,
  endDate: undefined,
  actualEndDate: undefined,
  conclusionType: undefined,
  workflowInstanceId: undefined,
  isDeleted: undefined,
  params: {}
});

const form = reactive<NewTechnologyProjectForm>({
  id: undefined,
  tenantId: undefined,
  projectNo: undefined,
  projectName: undefined,
  technologyCategory: undefined,
  riskLevel: undefined,
  applyDepartmentId: undefined,
  applyDepartmentName: undefined,
  projectLeader: undefined,
  projectTeam: undefined,
  technologySource: undefined,
  applyReason: undefined,
  technologyDescription: undefined,
  indication: undefined,
  contraindication: undefined,
  expectedEffect: undefined,
  potentialRisk: undefined,
  riskControlMeasure: undefined,
  literatureSupport: undefined,
  attachmentUrls: undefined,
  operationCycleDays: undefined,
  progressReportCycle: undefined,
  projectStatus: undefined,
  approveDate: undefined,
  startDate: undefined,
  endDate: undefined,
  actualEndDate: undefined,
  conclusionType: undefined,
  workflowInstanceId: undefined,
  isDeleted: undefined,
  params: {}
});

const rules = {
  id: [{ required: true, message: '主键ID不能为空', trigger: 'blur' }],
  projectNo: [{ required: true, message: '项目编号不能为空', trigger: 'blur' }],
  projectName: [{ required: true, message: '项目名称不能为空', trigger: 'blur' }]
};

const { queryParams: queryParamsRef, form: formRef } = toRefs(reactive({ queryParams, form }));
const rulesRef = rules;

/** 查询新技术项目基本信息列表 */
const getList = async () => {
  loading.value = true;
  const res = await listNewTechnologyProject(queryParams);
  newTechnologyProjectList.value = res.rows;
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
  formRef.value = { ...form };
  newTechnologyProjectFormRef.value?.resetFields();
};

/** 搜索按钮操作 */
const handleQuery = () => {
  queryParams.pageNum = 1;
  getList();
};

/** 重置按钮操作 */
const resetQuery = () => {
  queryFormRef.value?.resetFields();
  handleQuery();
};

/** 多选框选中数据 */
const handleSelectionChange = (selection: NewTechnologyProjectVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加新技术项目基本信息';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: NewTechnologyProjectVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getNewTechnologyProject(_id);
  Object.assign(formRef.value, res.data);
  dialog.visible = true;
  dialog.title = '修改新技术项目基本信息';
};

/** 提交按钮 */
const submitForm = () => {
  newTechnologyProjectFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (formRef.value.id) {
        await updateNewTechnologyProject(formRef.value).finally(() => (buttonLoading.value = false));
      } else {
        await addNewTechnologyProject(formRef.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: NewTechnologyProjectVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除新技术项目基本信息编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delNewTechnologyProject(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/newTechnologyProject/export',
    {
      ...queryParams
    },
    `newTechnologyProject_${new Date().getTime()}.xlsx`
  );
};

/** 字段配置操作 */
const handleFieldConfig = () => {
  showFieldConfig.value = true;
};

/** 字段配置确认操作 */
const handleFieldConfigConfirm = () => {
  showFieldConfig.value = false;
};

/** 搜索配置操作 */
const handleSearchConfig = () => {
  searchConfigVisible.value = true;
};

/** 搜索配置确认操作 */
const handleSearchConfigConfirm = () => {
  searchConfigVisible.value = false;
};

/** 重置字段配置 */
const handleFieldConfigReset = () => {
  fieldConfigManager.clearConfig();
  // 同时清除localStorage中的缓存
  localStorage.removeItem('newTechnologyProject_field_config');
  proxy?.$modal.msgSuccess('字段配置已重置，请刷新页面');
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

.new-technology-project-table {
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
