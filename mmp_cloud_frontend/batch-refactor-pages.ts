import fs from 'fs';
import path from 'path';

interface PageConfig {
  directory: string;
  title: string;
  icon: string;
  description: string;
  entityName: string;
  entityNameCap: string;
  permission: string;
}

const qualificationPages: PageConfig[] = [
  {
    directory: 'qualificationAuthorizationRecord',
    title: '资质授权记录管理',
    icon: 'document-checked',
    description: '管理资质授权记录，包括授权时间、授权状态、有效期等信息',
    entityName: 'qualificationAuthorizationRecord',
    entityNameCap: 'QualificationAuthorizationRecord',
    permission: 'qualification:qualificationAuthorizationRecord'
  },
  {
    directory: 'qualificationCatalog',
    title: '资质目录管理',
    icon: 'folder',
    description: '管理资质目录信息，包括资质名称、类别、级别、准入条件等',
    entityName: 'qualificationCatalog',
    entityNameCap: 'QualificationCatalog',
    permission: 'qualification:qualificationCatalog'
  },
  {
    directory: 'qualificationExamArrangement',
    title: '资质考核安排管理',
    icon: 'calendar',
    description: '管理资质考核安排，包括考核时间、地点、参与人员等信息',
    entityName: 'qualificationExamArrangement',
    entityNameCap: 'QualificationExamArrangement',
    permission: 'qualification:qualificationExamArrangement'
  },
  {
    directory: 'qualificationExamPaper',
    title: '资质考核试卷管理',
    icon: 'document',
    description: '管理资质考核试卷，包括试题内容、题型、分值等信息',
    entityName: 'qualificationExamPaper',
    entityNameCap: 'QualificationExamPaper',
    permission: 'qualification:qualificationExamPaper'
  },
  {
    directory: 'qualificationExamQuestion',
    title: '资质考核试题管理',
    icon: 'edit',
    description: '管理资质考核试题库，包括题目内容、选项、答案、难度等信息',
    entityName: 'qualificationExamQuestion',
    entityNameCap: 'QualificationExamQuestion',
    permission: 'qualification:qualificationExamQuestion'
  },
  {
    directory: 'qualificationExamRecord',
    title: '资质考核记录管理',
    icon: 'document-checked',
    description: '管理资质考核记录，包括考核成绩、考核时间、考核结果等信息',
    entityName: 'qualificationExamRecord',
    entityNameCap: 'QualificationExamRecord',
    permission: 'qualification:qualificationExamRecord'
  },
  {
    directory: 'qualificationPermissionAdjustment',
    title: '资质权限调整管理',
    icon: 'setting',
    description: '管理资质权限调整记录，包括调整原因、调整内容、审批状态等',
    entityName: 'qualificationPermissionAdjustment',
    entityNameCap: 'QualificationPermissionAdjustment',
    permission: 'qualification:qualificationPermissionAdjustment'
  },
  {
    directory: 'qualificationRiskMonitor',
    title: '资质风险监控管理',
    icon: 'warning',
    description: '管理资质风险监控记录，包括风险类型、风险等级、处理措施等',
    entityName: 'qualificationRiskMonitor',
    entityNameCap: 'QualificationRiskMonitor',
    permission: 'qualification:qualificationRiskMonitor'
  },
  {
    directory: 'qualificationUsageRecord',
    title: '资质使用记录管理',
    icon: 'tickets',
    description: '管理资质使用记录，包括使用时间、使用场景、使用结果等信息',
    entityName: 'qualificationUsageRecord',
    entityNameCap: 'QualificationUsageRecord',
    permission: 'qualification:qualificationUsageRecord'
  },
  {
    directory: 'technicianQualificationCatalog',
    title: '技师资质目录管理',
    icon: 'folder',
    description: '管理技师资质目录信息，包括资质名称、类别、级别、准入条件等',
    entityName: 'technicianQualificationCatalog',
    entityNameCap: 'TechnicianQualificationCatalog',
    permission: 'qualification:technicianQualificationCatalog'
  }
];

const ledgerPages: PageConfig[] = [
  {
    directory: 'ledgerBusinessLearning',
    title: '业务学习记录管理',
    icon: 'reading',
    description: '管理业务学习记录，包括学习主题、学习内容、参与人员等信息',
    entityName: 'ledgerBusinessLearning',
    entityNameCap: 'LedgerBusinessLearning',
    permission: 'ledger:ledgerBusinessLearning'
  },
  {
    directory: 'ledgerCriticalPatient',
    title: '危重患者记录管理',
    icon: 'warning',
    description: '管理危重患者记录，包括患者信息、病情描述、处理措施等',
    entityName: 'ledgerCriticalPatient',
    entityNameCap: 'LedgerCriticalPatient',
    permission: 'ledger:ledgerCriticalPatient'
  },
  {
    directory: 'ledgerLongStayPatient',
    title: '长期住院患者记录管理',
    icon: 'user',
    description: '管理长期住院患者记录，包括住院时长、病情变化、治疗方案等',
    entityName: 'ledgerLongStayPatient',
    entityNameCap: 'LedgerLongStayPatient',
    permission: 'ledger:ledgerLongStayPatient'
  },
  {
    directory: 'ledgerMajorSurgery',
    title: '重大手术记录管理',
    icon: 'operation',
    description: '管理重大手术记录，包括手术类型、手术时间、参与医生等信息',
    entityName: 'ledgerMajorSurgery',
    entityNameCap: 'LedgerMajorSurgery',
    permission: 'ledger:ledgerMajorSurgery'
  },
  {
    directory: 'ledgerPatientFullCycle',
    title: '患者全周期记录管理',
    icon: 'data-line',
    description: '管理患者全周期记录，包括入院、治疗、出院等全流程信息',
    entityName: 'ledgerPatientFullCycle',
    entityNameCap: 'LedgerPatientFullCycle',
    permission: 'ledger:ledgerPatientFullCycle'
  },
  {
    directory: 'ledgerUnplannedReoperation',
    title: '非计划再次手术记录管理',
    icon: 'warning',
    description: '管理非计划再次手术记录，包括原因分析、手术信息、处理结果等',
    entityName: 'ledgerUnplannedReoperation',
    entityNameCap: 'LedgerUnplannedReoperation',
    permission: 'ledger:ledgerUnplannedReoperation'
  }
];

// 生成页面模板的函数
function generatePageTemplate(config: PageConfig, module: 'qualification' | 'ledger'): string {
  return `<template>
  <div class="app-container">
    <!-- 页面标题 -->
    <div class="page-header mb-4">
      <h2 class="page-title">
        <i-ep-${config.icon} class="title-icon"></i-ep-${config.icon}>
        ${config.title}
      </h2>
      <p class="page-description">${config.description}</p>
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
            <span>数据列表</span>
            <el-tag type="info" size="small" class="ml-2">{{ total }} 条记录</el-tag>
          </div>
          <div class="table-actions">
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['${config.permission}:add']" size="small">新增</el-button>
            <el-button
              type="success"
              plain
              icon="Edit"
              :disabled="single"
              @click="handleUpdate()"
              v-hasPermi="['${config.permission}:edit']"
              size="small">修改</el-button>
            <el-button
              type="danger"
              plain
              icon="Delete"
              :disabled="multiple"
              @click="handleDelete()"
              v-hasPermi="['${config.permission}:remove']"
              size="small">删除</el-button>
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['${config.permission}:export']" size="small">导出</el-button>
            <el-button text type="primary" @click="handleFieldConfig" class="config-btn">
              <i-ep-setting class="btn-icon"></i-ep-setting>
              字段配置
            </el-button>
            <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
          </div>
        </div>
      </template>

      <DynamicTable
        :loading="loading"
        :data="${config.entityName}List"
        :field-config-manager="fieldConfigManager"
        @selection-change="handleSelectionChange"
      >
        <template #actions="{ row }">
          <el-button link size="small" icon="Edit" @click="handleUpdate(row)" v-hasPermi="['${config.permission}:edit']">修改</el-button>
          <el-button link size="small" icon="Delete" @click="handleDelete(row)" v-hasPermi="['${config.permission}:remove']">删除</el-button>
        </template>
      </DynamicTable>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>

    <!-- 字段配置对话框 -->
    <FieldConfigDialog v-model:visible="fieldConfigVisible" :field-config-manager="fieldConfigManager" @confirm="handleFieldConfigConfirm" />
    <!-- 搜索配置对话框 -->
    <SearchConfigDialog v-model:visible="searchConfigVisible" :search-config-manager="searchConfigManager" @confirm="handleSearchConfigConfirm" />
  </div>
</template>

<script setup name="${config.entityNameCap}" lang="ts">
import { list${config.entityNameCap}, get${config.entityNameCap}, del${config.entityNameCap}, add${config.entityNameCap}, update${config.entityNameCap} } from '@/api/${module}/${config.entityName}';
import { ${config.entityNameCap}VO, ${config.entityNameCap}Query, ${config.entityNameCap}Form } from '@/api/${module}/${config.entityName}/types';
import { create${config.entityNameCap}FieldConfig } from '@/utils/configs/${module}/${module}FieldConfigs';
import { FieldConfigManager } from '@/utils/configs/fieldConfigManager';
import FieldConfigDialog from '@/components/FieldConfigDialog.vue';
import DynamicSearchForm from '@/components/DynamicSearchForm.vue';
import DynamicTable from '@/components/DynamicTable.vue';
import SearchConfigDialog from '@/components/SearchConfigDialog.vue';
import { create${config.entityNameCap}SearchConfig } from '@/utils/configs/${module}/${module}SearchConfigs';
import type { FormInstance } from 'element-plus';
import type { DialogOption, PageData } from '@/types/global';
import type { ComponentInternalInstance } from 'vue';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const ${config.entityName}List = ref<${config.entityNameCap}VO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<FormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

// 字段配置相关变量
const fieldConfigManager = create${config.entityNameCap}FieldConfig();
const fieldConfigVisible = ref(false);
const searchConfigManager = create${config.entityNameCap}SearchConfig();
const searchConfigVisible = ref(false);
const visibleSearchFields = computed(() => searchConfigManager.getVisibleFields());

/** 查询列表 */
const getList = async () => {
  loading.value = true;
  try {
    const res = await list${config.entityNameCap}(queryParams.value);
    ${config.entityName}List.value = res.rows;
    total.value = res.total;
  } catch (error) {
    console.error('获取列表失败:', error);
  } finally {
    loading.value = false;
  }
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
const handleSelectionChange = (selection: ${config.entityNameCap}VO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  // TODO: 实现新增逻辑
  proxy?.$modal.msgWarning('请保留原有的新增对话框实现');
};

/** 修改按钮操作 */
const handleUpdate = async (row?: ${config.entityNameCap}VO) => {
  // TODO: 实现修改逻辑
  proxy?.$modal.msgWarning('请保留原有的修改对话框实现');
};

/** 删除按钮操作 */
const handleDelete = async (row?: ${config.entityNameCap}VO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm(\`是否确认删除编号为"\${_ids}"的数据项？\`);
  await del${config.entityNameCap}(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/${config.entityName}/export',
    {
      ...queryParams.value
    },
    \`${config.entityName}_\${new Date().getTime()}.xlsx\`
  );
};

/** 字段配置按钮操作 */
const handleFieldConfig = () => {
  fieldConfigVisible.value = true;
};

/** 字段配置确认操作 */
const handleFieldConfigConfirm = () => {
  fieldConfigVisible.value = false;
};

const handleSearchConfig = () => {
  searchConfigVisible.value = true;
};

const handleSearchConfigConfirm = () => {
  searchConfigVisible.value = false;
};

onMounted(() => {
  getList();
});
</script>

<style lang="scss" scoped>
.app-container {
  padding: 20px;
  background-color: #f5f5f5;
  min-height: calc(100vh - 84px);
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

.search-container {
  .search-card {
    border-radius: 8px;
    box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);

    .search-header {
      display: flex;
      justify-content: space-between;
      align-items: center;

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
}

.table-card {
  border-radius: 8px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);

  .table-header {
    display: flex;
    justify-content: space-between;
    align-items: center;

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

// 响应式设计
@media (max-width: 768px) {
  .app-container {
    padding: 12px;
  }

  .page-header {
    .page-title {
      font-size: 16px;
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
`;
}

console.log('批量重构脚本准备就绪');
console.log('需要重构的页面:');
console.log('Qualification模块:', qualificationPages.length, '个页面');
console.log('Ledger模块:', ledgerPages.length, '个页面');
console.log('');
console.log('请手动执行重构操作，因为自动生成的模板需要保留原有的对话框实现');
