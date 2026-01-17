<template>
  <div class="app-container">
    <!-- 页面标题 -->
    <div class="page-header mb-4">
      <h2 class="page-title">
        <i-ep-document-checked class="title-icon"></i-ep-document-checked>
        新技术项目考核评估
      </h2>
      <p class="page-description">管理新技术项目的考核评估信息，包括考核结果、评分和改进措施等</p>
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
            <span>考核评估列表</span>
            <el-tag type="info" size="small" class="ml-2">{{ total }} 条记录</el-tag>
          </div>
          <div class="table-actions">
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['ntp:newTechnologyProjectAssessment:add']" size="small"
              >新增</el-button
            >
            <el-button
              type="success"
              plain
              icon="Edit"
              :disabled="single"
              @click="handleUpdate()"
              v-hasPermi="['ntp:newTechnologyProjectAssessment:edit']"
              size="small"
              >修改</el-button
            >
            <el-button
              type="danger"
              plain
              icon="Delete"
              :disabled="multiple"
              @click="handleDelete()"
              v-hasPermi="['ntp:newTechnologyProjectAssessment:remove']"
              size="small"
              >删除</el-button
            >
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['ntp:newTechnologyProjectAssessment:export']" size="small"
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

      <el-table v-loading="loading" border :data="newTechnologyProjectAssessmentList" @selection-change="handleSelectionChange" class="new-technology-project-assessment-table">
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
            <span v-if="field.prop === 'assessmentDate'">
              {{ parseTime(scope.row[field.prop], '{y}-{m}-{d}') }}
            </span>

            <!-- 时间字段格式化 -->
            <span v-else-if="field.prop === 'createTime' || field.prop === 'updateTime'">
              {{ parseTime(scope.row[field.prop], '{y}-{m}-{d} {h}:{i}') }}
            </span>

            <!-- 考核结果标签 -->
            <el-tag v-else-if="field.prop === 'assessmentResult'" :type="getAssessmentResultTagType(scope.row[field.prop])">
              {{ getAssessmentResultLabel(scope.row[field.prop]) }}
            </el-tag>

            <!-- 考核类型标签 -->
            <el-tag v-else-if="field.prop === 'assessmentType'" type="info">
              {{ getAssessmentTypeLabel(scope.row[field.prop]) }}
            </el-tag>

            <!-- 状态标签 -->
            <el-tag v-else-if="field.prop === 'status'" :type="getStatusTagType(scope.row[field.prop])">
              {{ getStatusLabel(scope.row[field.prop]) }}
            </el-tag>

            <!-- 评分显示 -->
            <span v-else-if="field.prop === 'score'">
              {{ scope.row[field.prop] }}/100
            </span>

            <!-- 删除标志字段 -->
            <el-tag v-else-if="field.prop === 'isDeleted'" :type="scope.row[field.prop] === '0' ? 'success' : 'danger'">
              {{ scope.row[field.prop] === '0' ? '未删除' : '已删除' }}
            </el-tag>

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
                v-hasPermi="['ntp:newTechnologyProjectAssessment:edit']"
              ></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button
                link
                type="primary"
                icon="Delete"
                @click="handleDelete(scope.row)"
                v-hasPermi="['ntp:newTechnologyProjectAssessment:remove']"
              ></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>

    <!-- 字段配置对话框 -->
    <FieldConfigDialog
      v-model:visible="showFieldConfig"
      :field-config-manager="fieldConfigManager"
      @confirm="handleFieldConfigConfirm"
    />

    <!-- 搜索配置对话框 -->
    <SearchConfigDialog
      v-model:visible="showSearchConfig"
      :search-config-manager="searchConfigManager"
      @confirm="handleSearchConfigConfirm"
    />

    <!-- 添加或修改项目考核评估对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="700px" append-to-body>
      <el-form ref="newTechnologyProjectAssessmentFormRef" :model="form" :rules="rules" label-width="100px">
        <el-row :gutter="20">
          <el-col
            v-for="field in fieldConfigManager.getVisibleFields()"
            :key="field.prop"
            :span="field.type === 'textarea' ? 24 : 12"
          >
            <el-form-item :label="field.label" :prop="field.prop" v-if="field.prop !== 'createTime' && field.prop !== 'updateTime'">
              <!-- 下拉选择框 -->
              <el-select v-if="field.prop === 'assessmentType'" v-model="form.assessmentType" placeholder="请选择考核类型" style="width: 100%">
                <el-option label="中期考核" value="midterm" />
                <el-option label="结题考核" value="final" />
                <el-option label="年度考核" value="annual" />
              </el-select>
              <el-select v-else-if="field.prop === 'assessmentResult'" v-model="form.assessmentResult" placeholder="请选择考核结果" style="width: 100%">
                <el-option label="优秀" value="excellent" />
                <el-option label="良好" value="good" />
                <el-option label="合格" value="qualified" />
                <el-option label="不合格" value="unqualified" />
              </el-select>
              <el-select v-else-if="field.prop === 'status'" v-model="form.status" placeholder="请选择状态" style="width: 100%">
                <el-option label="草稿" value="0" />
                <el-option label="已提交" value="1" />
                <el-option label="审核中" value="2" />
                <el-option label="已通过" value="3" />
                <el-option label="已驳回" value="4" />
              </el-select>

              <!-- 数字输入框 -->
              <el-input-number
                v-else-if="field.prop === 'score'"
                v-model="form.score"
                :min="0"
                :max="100"
                placeholder="请输入评分"
                style="width: 100%"
              />

              <!-- 日期选择器 -->
              <el-date-picker
                v-else-if="field.prop === 'assessmentDate'"
                clearable
                v-model="form.assessmentDate"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择考核日期"
                style="width: 100%"
              />

              <!-- 文本域 -->
              <el-input
                v-else-if="field.prop === 'assessmentOpinion'"
                v-model="form.assessmentOpinion"
                type="textarea"
                placeholder="请输入考核意见"
                :maxlength="500"
                :show-word-limit="true"
                :rows="3"
                style="width: 100%"
              />
              <el-input
                v-else-if="field.prop === 'improvementMeasures'"
                v-model="form.improvementMeasures"
                type="textarea"
                placeholder="请输入改进措施"
                :maxlength="500"
                :show-word-limit="true"
                :rows="3"
                style="width: 100%"
              />
              <el-input
                v-else-if="field.prop === 'remark'"
                v-model="form.remark"
                type="textarea"
                placeholder="请输入备注"
                :maxlength="200"
                :show-word-limit="true"
                :rows="2"
                style="width: 100%"
              />

              <!-- 默认文本输入框 -->
              <el-input
                v-else
                v-model="form[field.prop]"
                :placeholder="`请输入${field.label}`"
                style="width: 100%"
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
  </div>
</template>

<script setup name="NewTechnologyProjectAssessment" lang="ts">
import {
  listNewTechnologyProjectAssessment,
  getNewTechnologyProjectAssessment,
  delNewTechnologyProjectAssessment,
  addNewTechnologyProjectAssessment,
  updateNewTechnologyProjectAssessment
} from '@/api/ntp/newTechnologyProjectAssessment';
import {
  NewTechnologyProjectAssessmentVO,
  NewTechnologyProjectAssessmentQuery,
  NewTechnologyProjectAssessmentForm
} from '@/api/ntp/newTechnologyProjectAssessment/types';
import { FieldConfigManager } from '@/utils/configs/fieldConfigManager';
import { SearchConfigManager } from '@/utils/configs/searchConfigManager';
import { createNewTechnologyProjectAssessmentFieldConfig } from '@/utils/configs/ntp/ntpFieldConfigs'
import { createNewTechnologyProjectAssessmentSearchConfig } from '@/utils/configs/ntp/ntpSearchConfigs'

import DynamicSearchForm from '@/components/DynamicSearchForm.vue'
import FieldConfigDialog from '@/components/FieldConfigDialog.vue'
import SearchConfigDialog from '@/components/SearchConfigDialog.vue'

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

// 字段配置管理器
const fieldConfigManager = createNewTechnologyProjectAssessmentFieldConfig();
const searchConfigManager = createNewTechnologyProjectAssessmentSearchConfig()

// 可见字段配置
const visibleFields = ref(fieldConfigManager.getVisibleFields())
const visibleSearchFields = ref(searchConfigManager.getVisibleFields())

// 配置对话框显示状态
const showFieldConfig = ref(false)
const showSearchConfig = ref(false)

const newTechnologyProjectAssessmentList = ref<NewTechnologyProjectAssessmentVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const newTechnologyProjectAssessmentFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: NewTechnologyProjectAssessmentForm = {
  id: undefined,
  projectId: undefined,
  assessmentYear: undefined,
  assessmentType: undefined,
  assessmentDate: undefined,
  assessor: undefined,
  assessmentResult: undefined,
  score: undefined,
  assessmentOpinion: undefined,
  improvementMeasures: undefined,
  status: undefined,
  remark: undefined
};
const data = reactive<PageData<NewTechnologyProjectAssessmentForm, NewTechnologyProjectAssessmentQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    assessmentYear: undefined,
    assessmentType: undefined,
    assessmentDate: undefined,
    assessor: undefined,
    assessmentResult: undefined,
    score: undefined,
    assessmentOpinion: undefined,
    improvementMeasures: undefined,
    status: undefined,
    params: {}
  },
  rules: {
    id: [{ required: true, message: '主键ID不能为空', trigger: 'blur' }],
    projectId: [{ required: true, message: '项目ID不能为空', trigger: 'blur' }],
    assessmentYear: [{ required: true, message: '考核年份不能为空', trigger: 'blur' }]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询项目考核评估列表 */
const getList = async () => {
  loading.value = true;
  const res = await listNewTechnologyProjectAssessment(queryParams.value);
  newTechnologyProjectAssessmentList.value = res.rows;
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
  newTechnologyProjectAssessmentFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: NewTechnologyProjectAssessmentVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加项目考核评估';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: NewTechnologyProjectAssessmentVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getNewTechnologyProjectAssessment(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改项目考核评估';
};

/** 提交按钮 */
const submitForm = () => {
  newTechnologyProjectAssessmentFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateNewTechnologyProjectAssessment(form.value).finally(() => (buttonLoading.value = false));
      } else {
        await addNewTechnologyProjectAssessment(form.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: NewTechnologyProjectAssessmentVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除项目考核评估编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delNewTechnologyProjectAssessment(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/newTechnologyProjectAssessment/export',
    {
      ...queryParams.value
    },
    `newTechnologyProjectAssessment_${new Date().getTime()}.xlsx`
  );
};

/** 字段配置 */
const handleFieldConfig = () => {
  showFieldConfig.value = true
}

/** 搜索配置 */
const handleSearchConfig = () => {
  showSearchConfig.value = true
}

/** 字段配置确认 */
const handleFieldConfigConfirm = () => {
  visibleFields.value = fieldConfigManager.getVisibleFields()
}

/** 搜索配置确认 */
const handleSearchConfigConfirm = () => {
  visibleSearchFields.value = searchConfigManager.getVisibleFields()
}

/** 获取考核结果标签类型 */
const getAssessmentResultTagType = (result: string) => {
  switch (result) {
    case 'excellent':
      return 'success';
    case 'good':
      return 'info';
    case 'qualified':
      return 'warning';
    case 'unqualified':
      return 'danger';
    default:
      return 'info';
  }
};

/** 获取考核结果标签文本 */
const getAssessmentResultLabel = (result: string) => {
  switch (result) {
    case 'excellent':
      return '优秀';
    case 'good':
      return '良好';
    case 'qualified':
      return '合格';
    case 'unqualified':
      return '不合格';
    default:
      return result;
  }
};

/** 获取考核类型标签文本 */
const getAssessmentTypeLabel = (type: string) => {
  switch (type) {
    case 'midterm':
      return '中期考核';
    case 'final':
      return '结题考核';
    case 'annual':
      return '年度考核';
    default:
      return type;
  }
};

/** 获取状态标签类型 */
const getStatusTagType = (status: string) => {
  switch (status) {
    case '0':
      return 'info';
    case '1':
      return 'primary';
    case '2':
      return 'warning';
    case '3':
      return 'success';
    case '4':
      return 'danger';
    default:
      return 'info';
  }
};

/** 获取状态标签文本 */
const getStatusLabel = (status: string) => {
  switch (status) {
    case '0':
      return '草稿';
    case '1':
      return '已提交';
    case '2':
      return '审核中';
    case '3':
      return '已通过';
    case '4':
      return '已驳回';
    default:
      return status;
  }
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

/* 表格样式 */
.new-technology-project-assessment-table {
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
