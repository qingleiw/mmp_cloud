<template>
  <div class="app-container">
    <!-- 页面标题 -->
    <div class="page-header mb-4">
      <h2 class="page-title">
        <i-ep-document-copy class="title-icon"></i-ep-document-copy>
        新技术项目案例
      </h2>
      <p class="page-description">管理新技术项目的临床应用案例，包括患者信息、诊疗过程和效果评估等</p>
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
            <span>案例列表</span>
            <el-tag type="info" size="small" class="ml-2">{{ total }} 条记录</el-tag>
          </div>
          <div class="table-actions">
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['ntp:newTechnologyProjectCase:add']" size="small"
              >新增</el-button
            >
            <el-button
              type="success"
              plain
              icon="Edit"
              :disabled="single"
              @click="handleUpdate()"
              v-hasPermi="['ntp:newTechnologyProjectCase:edit']"
              size="small"
              >修改</el-button
            >
            <el-button
              type="danger"
              plain
              icon="Delete"
              :disabled="multiple"
              @click="handleDelete()"
              v-hasPermi="['ntp:newTechnologyProjectCase:remove']"
              size="small"
              >删除</el-button
            >
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['ntp:newTechnologyProjectCase:export']" size="small"
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

      <el-table v-loading="loading" border :data="newTechnologyProjectCaseList" @selection-change="handleSelectionChange" class="new-technology-project-case-table">
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
            <span v-if="field.prop === 'visitDate' || field.prop === 'operationDate'">
              {{ parseTime(scope.row[field.prop], '{y}-{m}-{d}') }}
            </span>

            <!-- 时间字段格式化 -->
            <span v-else-if="field.prop === 'createTime' || field.prop === 'updateTime' || field.prop === 'reportTime'">
              {{ parseTime(scope.row[field.prop], '{y}-{m}-{d} {h}:{i}') }}
            </span>

            <!-- 就诊类型标签 -->
            <el-tag v-else-if="field.prop === 'visitType'" :type="getVisitTypeTagType(scope.row[field.prop])">
              {{ getVisitTypeLabel(scope.row[field.prop]) }}
            </el-tag>

            <!-- 随访状态标签 -->
            <el-tag v-else-if="field.prop === 'followUpStatus'" :type="getFollowUpStatusTagType(scope.row[field.prop])">
              {{ getFollowUpStatusLabel(scope.row[field.prop]) }}
            </el-tag>

            <!-- 是否已报备标签 -->
            <el-tag v-else-if="field.prop === 'isReported'" :type="scope.row[field.prop] === 1 ? 'success' : 'warning'">
              {{ scope.row[field.prop] === 1 ? '已报备' : '未报备' }}
            </el-tag>

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
                v-hasPermi="['ntp:newTechnologyProjectCase:edit']"
              ></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button
                link
                type="primary"
                icon="Delete"
                @click="handleDelete(scope.row)"
                v-hasPermi="['ntp:newTechnologyProjectCase:remove']"
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

    <!-- 添加或修改新技术病例登记对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="700px" append-to-body>
      <el-form ref="newTechnologyProjectCaseFormRef" :model="form" :rules="rules" label-width="100px">
        <el-row :gutter="20">
          <el-col
            v-for="field in fieldConfigManager.getVisibleFields()"
            :key="field.prop"
            :span="field.type === 'textarea' ? 24 : 12"
          >
            <el-form-item :label="field.label" :prop="field.prop" v-if="field.prop !== 'createTime' && field.prop !== 'updateTime'">
              <!-- 下拉选择框 -->
              <el-select v-if="field.prop === 'visitType'" v-model="form.visitType" placeholder="请选择就诊类型" style="width: 100%">
                <el-option label="门诊" value="outpatient" />
                <el-option label="住院" value="inpatient" />
              </el-select>
              <el-select v-else-if="field.prop === 'followUpStatus'" v-model="form.followUpStatus" placeholder="请选择随访状态" style="width: 100%">
                <el-option label="未随访" value="not_followed" />
                <el-option label="随访中" value="following" />
                <el-option label="已完成" value="completed" />
              </el-select>
              <el-select v-else-if="field.prop === 'isReported'" v-model="form.isReported" placeholder="请选择报备状态" style="width: 100%">
                <el-option label="未报备" :value="0" />
                <el-option label="已报备" :value="1" />
              </el-select>

              <!-- 日期选择器 -->
              <el-date-picker
                v-else-if="field.prop === 'visitDate'"
                clearable
                v-model="form.visitDate"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择就诊日期"
                style="width: 100%"
              />
              <el-date-picker
                v-else-if="field.prop === 'operationDate'"
                clearable
                v-model="form.operationDate"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择操作时间"
                style="width: 100%"
              />

              <!-- 文本域 -->
              <el-input
                v-else-if="field.prop === 'diagnosis'"
                v-model="form.diagnosis"
                type="textarea"
                placeholder="请输入诊断"
                :maxlength="500"
                :show-word-limit="true"
                :rows="3"
                style="width: 100%"
              />
              <el-input
                v-else-if="field.prop === 'effectEvaluation'"
                v-model="form.effectEvaluation"
                type="textarea"
                placeholder="请输入效果评价"
                :maxlength="500"
                :show-word-limit="true"
                :rows="3"
                style="width: 100%"
              />
              <el-input
                v-else-if="field.prop === 'complication'"
                v-model="form.complication"
                type="textarea"
                placeholder="请输入并发症"
                :maxlength="500"
                :show-word-limit="true"
                :rows="3"
                style="width: 100%"
              />
              <el-input
                v-else-if="field.prop === 'adverseReaction'"
                v-model="form.adverseReaction"
                type="textarea"
                placeholder="请输入不良反应"
                :maxlength="500"
                :show-word-limit="true"
                :rows="3"
                style="width: 100%"
              />
              <el-input
                v-else-if="field.prop === 'followUpResult'"
                v-model="form.followUpResult"
                type="textarea"
                placeholder="请输入随访结果"
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

<script setup name="NewTechnologyProjectCase" lang="ts">
import {
  listNewTechnologyProjectCase,
  getNewTechnologyProjectCase,
  delNewTechnologyProjectCase,
  addNewTechnologyProjectCase,
  updateNewTechnologyProjectCase
} from '@/api/ntp/newTechnologyProjectCase';
import { NewTechnologyProjectCaseVO, NewTechnologyProjectCaseQuery, NewTechnologyProjectCaseForm } from '@/api/ntp/newTechnologyProjectCase/types';
import { FieldConfigManager } from '@/utils/configs/fieldConfigManager';
import { SearchConfigManager } from '@/utils/configs/searchConfigManager';
import { createNewTechnologyProjectCaseFieldConfig } from '@/utils/configs/ntp/ntpFieldConfigs'
import { createNewTechnologyProjectCaseSearchConfig } from '@/utils/configs/ntp/ntpSearchConfigs'
import DynamicSearchForm from '@/components/DynamicSearchForm.vue'
import FieldConfigDialog from '@/components/FieldConfigDialog.vue'
import SearchConfigDialog from '@/components/SearchConfigDialog.vue'

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

// 字段配置管理器
const fieldConfigManager = createNewTechnologyProjectCaseFieldConfig();
const searchConfigManager = createNewTechnologyProjectCaseSearchConfig()

// 可见字段配置
const visibleFields = ref(fieldConfigManager.getVisibleFields())
const visibleSearchFields = ref(searchConfigManager.getVisibleFields())

// 配置对话框显示状态
const showFieldConfig = ref(false)
const showSearchConfig = ref(false)

const newTechnologyProjectCaseList = ref<NewTechnologyProjectCaseVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const newTechnologyProjectCaseFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: NewTechnologyProjectCaseForm = {
  id: undefined,
  projectId: undefined,
  patientId: undefined,
  patientName: undefined,
  visitType: undefined,
  visitNo: undefined,
  visitDate: undefined,
  visitDepartmentId: undefined,
  visitDepartmentName: undefined,
  diagnosis: undefined,
  operator: undefined,
  operationDate: undefined,
  effectEvaluation: undefined,
  complication: undefined,
  adverseReaction: undefined,
  followUpStatus: undefined,
  followUpResult: undefined,
  isReported: undefined,
  reportTime: undefined,
  remark: undefined
};
const data = reactive<PageData<NewTechnologyProjectCaseForm, NewTechnologyProjectCaseQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    patientName: undefined,
    visitType: undefined,
    visitNo: undefined,
    visitDate: undefined,
    visitDepartmentName: undefined,
    diagnosis: undefined,
    operator: undefined,
    operationDate: undefined,
    effectEvaluation: undefined,
    complication: undefined,
    adverseReaction: undefined,
    followUpStatus: undefined,
    followUpResult: undefined,
    isReported: undefined,
    reportTime: undefined,
    params: {}
  },
  rules: {
    id: [{ required: true, message: '主键ID不能为空', trigger: 'blur' }],
    projectId: [{ required: true, message: '项目ID不能为空', trigger: 'blur' }],
    patientId: [{ required: true, message: '患者ID不能为空', trigger: 'blur' }]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询新技术病例登记列表 */
const getList = async () => {
  loading.value = true;
  const res = await listNewTechnologyProjectCase(queryParams.value);
  newTechnologyProjectCaseList.value = res.rows;
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
  newTechnologyProjectCaseFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: NewTechnologyProjectCaseVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加新技术病例登记';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: NewTechnologyProjectCaseVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getNewTechnologyProjectCase(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改新技术病例登记';
};

/** 提交按钮 */
const submitForm = () => {
  newTechnologyProjectCaseFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateNewTechnologyProjectCase(form.value).finally(() => (buttonLoading.value = false));
      } else {
        await addNewTechnologyProjectCase(form.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: NewTechnologyProjectCaseVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除新技术病例登记编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delNewTechnologyProjectCase(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/newTechnologyProjectCase/export',
    {
      ...queryParams.value
    },
    `newTechnologyProjectCase_${new Date().getTime()}.xlsx`
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

/** 获取随访状态标签类型 */
const getFollowUpStatusTagType = (status: string) => {
  switch (status) {
    case 'completed':
      return 'success';
    case 'following':
      return 'primary';
    case 'not_followed':
      return 'warning';
    default:
      return 'info';
  }
};

/** 获取随访状态标签文本 */
const getFollowUpStatusLabel = (status: string) => {
  switch (status) {
    case 'completed':
      return '已完成';
    case 'following':
      return '随访中';
    case 'not_followed':
      return '未随访';
    default:
      return status;
  }
};

/** 获取就诊类型标签类型 */
const getVisitTypeTagType = (type: string) => {
  switch (type) {
    case 'outpatient':
      return 'info';
    case 'inpatient':
      return 'primary';
    default:
      return 'info';
  }
};

/** 获取就诊类型标签文本 */
const getVisitTypeLabel = (type: string) => {
  switch (type) {
    case 'outpatient':
      return '门诊';
    case 'inpatient':
      return '住院';
    default:
      return type;
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
.new-technology-project-case-table {
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
