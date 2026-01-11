<template>
  <div class="app-container">
    <!-- 页面标题 -->
    <div class="page-header mb-4">
      <h2 class="page-title">
        <i-ep-document-checked class="title-icon"></i-ep-document-checked>
        核心制度评估记录管理
      </h2>
      <p class="page-description">管理系统核心制度的评估记录，包括考核分数、等级、结果和意见等信息</p>
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
                <el-button text type="primary" @click="toggleSearchConfig" class="config-btn">
                  <i-ep-setting class="btn-icon"></i-ep-setting>
                  搜索配置
                </el-button>
              </div>
            </div>
          </template>
          <DynamicSearchForm
            ref="searchFormRef"
            :query="queryParams"
            :visibleFields="searchConfig.getVisibleFields()"
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
            <span>评估记录列表</span>
            <el-tag type="info" size="small" class="ml-2">{{ total }} 条记录</el-tag>
          </div>
          <div class="table-actions">
            <el-button type="primary" plain @click="handleAdd" v-hasPermi="['system:coreSystemAssessmentRecord:add']"><i-ep-plus />新增</el-button>
            <el-button type="success" plain :disabled="single" @click="handleUpdate()" v-hasPermi="['system:coreSystemAssessmentRecord:edit']"
              ><i-ep-edit />修改</el-button
            >
            <el-button type="danger" plain :disabled="multiple" @click="handleDelete()" v-hasPermi="['system:coreSystemAssessmentRecord:remove']"
              ><i-ep-delete />删除</el-button
            >
            <el-button type="warning" plain @click="handleExport" v-hasPermi="['system:coreSystemAssessmentRecord:export']"
              ><i-ep-download />导出</el-button
            >
            <el-button text type="primary" @click="toggleFieldConfig" class="config-btn">
              <i-ep-setting class="btn-icon"></i-ep-setting>
              字段配置
            </el-button>
            <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
          </div>
        </div>
      </template>

      <el-table
        v-loading="loading"
        border
        :data="coreSystemAssessmentRecordList"
        @selection-change="handleSelectionChange"
        class="assessment-table"
        :default-sort="{ prop: 'assessmentTime', order: 'descending' }"
      >
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column
          v-for="field in visibleFields"
          :key="field.prop"
          :label="field.label"
          :prop="field.prop"
          :width="field.width"
          :align="field.align || 'center'"
          :show-overflow-tooltip="field.showOverflowTooltip"
          :sortable="field.sortable"
          :resizable="true"
        >
          <template #default="scope">
            <!-- 考核时间格式化 -->
            <span v-if="field.prop === 'assessmentTime'">
              {{ parseTime(scope.row.assessmentTime, '{y}-{m}-{d}') }}
            </span>
            <!-- 考核等级状态标签 -->
            <el-tag v-else-if="field.prop === 'assessmentGrade'" :type="getGradeTagType(scope.row.assessmentGrade)" size="small">
              {{ getGradeLabel(scope.row.assessmentGrade) }}
            </el-tag>
            <!-- 删除标志状态标签 -->
            <el-tag v-else-if="field.prop === 'delFlag'" :type="scope.row.delFlag === 0 ? 'success' : 'danger'" size="small">
              {{ scope.row.delFlag === 0 ? '正常' : '已删除' }}
            </el-tag>
            <!-- 默认显示 -->
            <span v-else>{{ scope.row[field.prop] }}</span>
          </template>
        </el-table-column>
        <el-table-column label="操作" align="center" fixed="right" width="120" class-name="small-padding fixed-width">
          <template #default="scope">
            <el-tooltip content="修改" placement="top">
              <el-button link type="primary" @click="handleUpdate(scope.row)" v-hasPermi="['system:coreSystemAssessmentRecord:edit']"
                ><i-ep-edit
              /></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button link type="danger" @click="handleDelete(scope.row)" v-hasPermi="['system:coreSystemAssessmentRecord:remove']"
                ><i-ep-delete
              /></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>

    <!-- 添加或修改制度考核记录对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="600px" append-to-body class="assessment-dialog">
      <el-form ref="coreSystemAssessmentRecordFormRef" :model="form" :rules="rules" label-width="100px">
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="制度名称" prop="systemName">
              <el-input v-model="form.systemName" placeholder="请输入制度名称" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="考核人名称" prop="assessorName">
              <el-input v-model="form.assessorName" placeholder="请输入考核人名称" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="考核时间" prop="assessmentTime">
              <el-date-picker
                clearable
                v-model="form.assessmentTime"
                type="datetime"
                value-format="YYYY-MM-DD HH:mm:ss"
                placeholder="请选择考核时间"
                class="w-full"
              />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="考核周期" prop="assessmentCycle">
              <el-select v-model="form.assessmentCycle" placeholder="请选择考核周期" class="w-full">
                <el-option label="月度" value="月度" />
                <el-option label="季度" value="季度" />
                <el-option label="年度" value="年度" />
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="考核分数" prop="assessmentScore">
              <el-input-number
                v-model="form.assessmentScore"
                :min="0"
                :max="100"
                :precision="1"
                controls-position="right"
                placeholder="请输入考核分数"
                class="w-full"
              />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="考核等级" prop="assessmentGrade">
              <el-select v-model="form.assessmentGrade" placeholder="请选择考核等级" class="w-full">
                <el-option label="优秀" value="优秀" />
                <el-option label="良好" value="良好" />
                <el-option label="合格" value="合格" />
                <el-option label="不合格" value="不合格" />
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>
        <el-form-item label="考核结果" prop="assessmentResult">
          <el-input v-model="form.assessmentResult" type="textarea" :rows="3" placeholder="请输入考核结果" />
        </el-form-item>
        <el-form-item label="考核意见" prop="assessmentOpinion">
          <el-input v-model="form.assessmentOpinion" type="textarea" :rows="3" placeholder="请输入考核意见" />
        </el-form-item>
      </el-form>
      <template #footer>
        <div class="dialog-footer">
          <el-button :loading="buttonLoading" type="primary" @click="submitForm"><i-ep-check />确 定</el-button>
          <el-button @click="cancel"><i-ep-close />取 消</el-button>
        </div>
      </template>
    </el-dialog>

    <!-- 字段配置对话框 -->
    <FieldConfigDialog v-model:visible="fieldConfigVisible" :fieldConfigManager="fieldConfig" @confirm="handleFieldConfigConfirm" />

    <!-- 搜索配置对话框 -->
    <SearchConfigDialog v-model="searchConfigVisible" :searchConfigManager="searchConfig" @confirm="handleSearchConfigConfirm" />
  </div>
</template>

<script setup name="CoreSystemAssessmentRecord" lang="ts">
import {
  listCoreSystemAssessmentRecord,
  getCoreSystemAssessmentRecord,
  delCoreSystemAssessmentRecord,
  addCoreSystemAssessmentRecord,
  updateCoreSystemAssessmentRecord
} from '@/api/coresystem/coreSystemAssessmentRecord';
import {
  CoreSystemAssessmentRecordVO,
  CoreSystemAssessmentRecordQuery,
  CoreSystemAssessmentRecordForm
} from '@/api/coresystem/coreSystemAssessmentRecord/types';
import { createCoreSystemAssessmentRecordFieldConfig } from '@/utils/mmpFieldConfigs';
import { createCoreSystemAssessmentRecordSearchConfig } from '@/utils/mmpSearchConfigs';
import DynamicSearchForm from '@/components/DynamicSearchForm.vue';
import FieldConfigDialog from '@/components/FieldConfigDialog.vue';
import SearchConfigDialog from '@/components/SearchConfigDialog.vue';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const coreSystemAssessmentRecordList = ref<CoreSystemAssessmentRecordVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

// 字段配置和搜索配置
const fieldConfigVisible = ref(false);
const searchConfigVisible = ref(false);
const fieldConfig = createCoreSystemAssessmentRecordFieldConfig();
const searchConfig = createCoreSystemAssessmentRecordSearchConfig();
const visibleFields = computed(() => fieldConfig.getVisibleFields());

const queryFormRef = ref<ElFormInstance>();
const coreSystemAssessmentRecordFormRef = ref<ElFormInstance>();
const searchFormRef = ref();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: CoreSystemAssessmentRecordForm = {
  id: undefined,
  assessmentId: undefined,
  systemId: undefined,
  systemName: undefined,
  assessorId: undefined,
  assessorName: undefined,
  assessmentTime: undefined,
  assessmentCycle: undefined,
  assessmentScore: undefined,
  assessmentGrade: undefined,
  assessmentResult: undefined,
  assessmentOpinion: undefined,
  delFlag: undefined
};
const data = reactive<PageData<CoreSystemAssessmentRecordForm, CoreSystemAssessmentRecordQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    systemName: undefined,
    assessorName: undefined,
    assessmentTime: undefined,
    assessmentCycle: undefined,
    assessmentScore: undefined,
    assessmentGrade: undefined,
    assessmentResult: undefined,
    assessmentOpinion: undefined,
    delFlag: undefined,
    params: {}
  },
  rules: {
    id: [{ required: true, message: '主键ID不能为空', trigger: 'blur' }],
    assessmentId: [{ required: true, message: '考核ID不能为空', trigger: 'blur' }],
    systemId: [{ required: true, message: '制度ID不能为空', trigger: 'blur' }],
    systemName: [{ required: true, message: '制度名称不能为空', trigger: 'blur' }],
    assessorId: [{ required: true, message: '考核人ID不能为空', trigger: 'blur' }],
    assessorName: [{ required: true, message: '考核人名称不能为空', trigger: 'blur' }],
    assessmentTime: [{ required: true, message: '考核时间不能为空', trigger: 'blur' }],
    assessmentCycle: [{ required: true, message: '考核周期(monthly:月度,quarterly:季度,half-yearly:半年度,yearly:年度)不能为空', trigger: 'blur' }],
    assessmentScore: [{ required: true, message: '考核分数不能为空', trigger: 'blur' }],
    assessmentGrade: [{ required: true, message: '考核等级(A:优秀,B:良好,C:合格,D:不合格)不能为空', trigger: 'blur' }],
    assessmentResult: [{ required: true, message: '考核结果不能为空', trigger: 'blur' }]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询制度考核记录列表 */
const getList = async () => {
  loading.value = true;
  const res = await listCoreSystemAssessmentRecord(queryParams.value);
  coreSystemAssessmentRecordList.value = res.rows;
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
  coreSystemAssessmentRecordFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: CoreSystemAssessmentRecordVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 字段配置相关函数 */
const toggleFieldConfig = () => {
  fieldConfigVisible.value = true;
};

const handleFieldConfigConfirm = () => {
  fieldConfigVisible.value = false;
};

/** 搜索配置相关函数 */
const toggleSearchConfig = () => {
  searchConfigVisible.value = true;
};

const handleSearchConfigConfirm = () => {
  searchConfigVisible.value = false;
};

/** 考核等级标签相关函数 */
const getGradeTagType = (grade: string) => {
  switch (grade) {
    case '优秀':
      return 'success';
    case '良好':
      return 'info';
    case '合格':
      return 'warning';
    case '不合格':
      return 'danger';
    default:
      return 'primary';
  }
};

const getGradeLabel = (grade: string) => {
  return grade || '未评定';
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加制度考核记录';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: CoreSystemAssessmentRecordVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getCoreSystemAssessmentRecord(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改制度考核记录';
};

/** 提交按钮 */
const submitForm = () => {
  coreSystemAssessmentRecordFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateCoreSystemAssessmentRecord(form.value).finally(() => (buttonLoading.value = false));
      } else {
        await addCoreSystemAssessmentRecord(form.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: CoreSystemAssessmentRecordVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除制度考核记录编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delCoreSystemAssessmentRecord(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/coreSystemAssessmentRecord/export',
    {
      ...queryParams.value
    },
    `coreSystemAssessmentRecord_${new Date().getTime()}.xlsx`
  );
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
  margin-bottom: 24px;

  .page-title {
    font-size: 24px;
    font-weight: 600;
    color: #1d2129;
    margin-bottom: 8px;
    display: flex;
    align-items: center;
    gap: 8px;

    .title-icon {
      color: #409eff;
    }
  }

  .page-description {
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
          font-size: 12px;
          padding: 4px 8px;
          height: auto;
          border: none;
          color: #86909c;

          &:hover {
            color: #409eff;
            background-color: #ecf5ff;
          }

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
        font-size: 12px;
        padding: 6px 12px;
        height: auto;
        border: none;
        color: #86909c;

        &:hover {
          color: #409eff;
          background-color: #ecf5ff;
        }

        .btn-icon {
          margin-right: 4px;
        }
      }
    }
  }
}

.assessment-table {
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

.assessment-dialog {
  :deep(.el-dialog__body) {
    padding: 24px;
  }

  .w-full {
    width: 100%;
  }
}

.dialog-footer {
  text-align: right;
  padding-top: 16px;
  border-top: 1px solid #ebeef5;
}

// 响应式设计
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

  .assessment-dialog {
    :deep(.el-dialog) {
      width: 95% !important;
      margin: 5vh auto;
    }
  }
}
</style>
