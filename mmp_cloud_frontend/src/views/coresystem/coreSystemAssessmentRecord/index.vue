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
                <el-button text type="primary" @click="handleSearchConfig" class="config-btn">
                  <i-ep-setting class="btn-icon"></i-ep-setting>
                  搜索配置
                </el-button>
              </div>
            </div>
          </template>
          <DynamicSearchForm
            ref="searchFormRef"
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
            <span>评估记录列表</span>
            <el-tag type="info" size="small" class="ml-2">{{ total }} 条记录</el-tag>
          </div>
          <div class="table-actions">
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['coresystem:coreSystemAssessmentRecord:add']" size="small">新增</el-button>
            <el-button
              type="success"
              plain
              icon="Edit"
              :disabled="single"
              @click="handleUpdate()"
              v-hasPermi="['coresystem:coreSystemAssessmentRecord:edit']"
              size="small">修改</el-button>
            <el-button
              type="danger"
              plain
              icon="Delete"
              :disabled="multiple"
              @click="handleDelete()"
              v-hasPermi="['coresystem:coreSystemAssessmentRecord:remove']"
              size="small">删除</el-button>
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['coresystem:coreSystemAssessmentRecord:export']" size="small">导出</el-button>
            <el-button text type="primary" @click="handleFieldConfig" class="config-btn">
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
            <!-- 考核时间格式化 -->
            <span v-if="field.prop === 'assessmentTime'">
              {{ parseTime(scope.row.assessmentTime, '{y}-{m}-{d}') }}
            </span>
            <!-- 考核等级标签 -->
            <el-tag v-else-if="field.prop === 'assessmentGrade'" :type="getGradeTagType(scope.row.assessmentGrade)" size="small">
              {{ scope.row.assessmentGrade || '未评定' }}
            </el-tag>
            <!-- 考核周期标签 -->
            <el-tag v-else-if="field.prop === 'assessmentCycle'" :type="getCycleTagType(scope.row.assessmentCycle)" size="small">
              {{ scope.row.assessmentCycle }}
            </el-tag>
            <!-- 删除标志字段 -->
            <el-tag v-else-if="field.prop === 'delFlag'" :type="scope.row.delFlag === '0' ? 'success' : 'danger'" size="small">
              {{ scope.row.delFlag === '0' ? '未删除' : '已删除' }}
            </el-tag>
            <!-- 创建和更新时间字段 -->
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
                v-hasPermi="['coresystem:coreSystemAssessmentRecord:edit']"
              ></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button
                link
                type="primary"
                icon="Delete"
                @click="handleDelete(scope.row)"
                v-hasPermi="['coresystem:coreSystemAssessmentRecord:remove']"
              ></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>

    <!-- 添加或修改制度考核记录对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="700px" append-to-body>
      <el-form ref="coreSystemAssessmentRecordFormRef" :model="form" :rules="rules" label-width="120px">
        <el-row :gutter="20">
          <el-col
            v-for="field in fieldConfigManager.getFormFields()"
            :key="field.prop"
            :span="field.colSpan || 12"
          >
            <el-form-item :label="field.label" :prop="field.prop" :rules="field.rules">
              <!-- 考核周期选择框 -->
              <el-select v-if="field.prop === 'assessmentCycle'" v-model="form.assessmentCycle" placeholder="请选择考核周期" clearable style="width: 100%">
                <el-option label="月度" value="月度" />
                <el-option label="季度" value="季度" />
                <el-option label="半年度" value="半年度" />
                <el-option label="年度" value="年度" />
              </el-select>
              <!-- 考核等级选择框 -->
              <el-select v-else-if="field.prop === 'assessmentGrade'" v-model="form.assessmentGrade" placeholder="请选择考核等级" clearable style="width: 100%">
                <el-option label="优秀" value="优秀" />
                <el-option label="良好" value="良好" />
                <el-option label="合格" value="合格" />
                <el-option label="不合格" value="不合格" />
              </el-select>
              <!-- 删除标志选择框 -->
              <el-select v-else-if="field.prop === 'delFlag'" v-model="form.delFlag" placeholder="请选择删除标志" clearable style="width: 100%">
                <el-option label="未删除" value="0" />
                <el-option label="已删除" value="1" />
              </el-select>
              <!-- 考核时间选择器 -->
              <el-date-picker
                v-else-if="field.prop === 'assessmentTime'"
                clearable
                v-model="form.assessmentTime"
                type="datetime"
                value-format="YYYY-MM-DD HH:mm:ss"
                placeholder="请选择考核时间"
                style="width: 100%"
              />
              <!-- 考核分数输入框 -->
              <el-input-number
                v-else-if="field.prop === 'assessmentScore'"
                v-model="form.assessmentScore"
                :min="0"
                :max="100"
                :precision="1"
                controls-position="right"
                placeholder="请输入考核分数"
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
    <FieldConfigDialog v-model:visible="fieldConfigVisible" :field-config-manager="fieldConfigManager" @confirm="handleFieldConfigConfirm" />
    <!-- 搜索配置对话框 -->
    <SearchConfigDialog v-model:visible="searchConfigVisible" :search-config-manager="searchConfigManager" @confirm="handleSearchConfigConfirm" />
  </div>
</template>

<script setup name="CoreSystemAssessmentRecord" lang="ts">
import { ref, reactive, toRefs, computed, onMounted, getCurrentInstance, type ComponentInternalInstance } from 'vue';
import type { FormInstance } from 'element-plus';
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
import { FieldConfigManager } from '@/utils/configs/fieldConfigManager';
import { createCoreSystemAssessmentRecordFieldConfig } from '@/utils/configs/coresystem/coresystemFieldConfigs';
import { createCoreSystemAssessmentRecordSearchConfig } from '@/utils/configs/coresystem/coresystemSearchConfigs';
import FieldConfigDialog from '@/components/FieldConfigDialog.vue';
import DynamicSearchForm from '@/components/DynamicSearchForm.vue';
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

const queryFormRef = ref<FormInstance>();
const coreSystemAssessmentRecordFormRef = ref<FormInstance>();
const searchFormRef = ref();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

// 配置管理器
const fieldConfigManager = createCoreSystemAssessmentRecordFieldConfig();
const searchConfigManager = createCoreSystemAssessmentRecordSearchConfig();
const visibleSearchFields = computed(() => searchConfigManager.getVisibleFields());

// 配置对话框状态
const fieldConfigVisible = ref(false);
const searchConfigVisible = ref(false);

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
    assessmentCycle: [{ required: true, message: '考核周期不能为空', trigger: 'blur' }],
    assessmentScore: [{ required: true, message: '考核分数不能为空', trigger: 'blur' }],
    assessmentGrade: [{ required: true, message: '考核等级不能为空', trigger: 'blur' }],
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

/** 字段配置按钮操作 */
const handleFieldConfig = () => {
  fieldConfigVisible.value = true;
};

/** 搜索配置按钮操作 */
const handleSearchConfig = () => {
  searchConfigVisible.value = true;
};

/** 字段配置确认 */
const handleFieldConfigConfirm = () => {
  fieldConfigVisible.value = false;
};

/** 搜索配置确认 */
const handleSearchConfigConfirm = () => {
  searchConfigVisible.value = false;
};

/** 获取考核等级标签类型 */
const getGradeTagType = (grade: string) => {
  const gradeMap: Record<string, string> = {
    '优秀': 'success',
    '良好': 'primary',
    '合格': 'warning',
    '不合格': 'danger'
  };
  return gradeMap[grade] || 'info';
};

/** 获取考核周期标签类型 */
const getCycleTagType = (cycle: string) => {
  const cycleMap: Record<string, string> = {
    '月度': 'primary',
    '季度': 'success',
    '半年度': 'warning',
    '年度': 'danger'
  };
  return cycleMap[cycle] || 'info';
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