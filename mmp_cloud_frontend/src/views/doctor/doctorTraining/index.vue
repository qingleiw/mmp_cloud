<template>
  <div class="app-container">
    <!-- 页面标题 -->
    <div class="page-header mb-4">
      <h2 class="page-title">
        <i-ep-school class="title-icon"></i-ep-school>
        医师培训管理
      </h2>
      <p class="page-description">管理医师继续教育、培训记录、专业技能提升等信息</p>
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
            <span>培训记录列表</span>
            <el-tag type="info" size="small" class="ml-2">{{ total }} 条记录</el-tag>
          </div>
          <div class="table-actions">
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['doctor:doctorTraining:add']" size="small">新增</el-button>
            <el-button
              type="success"
              plain
              icon="Edit"
              :disabled="single"
              @click="handleUpdate()"
              v-hasPermi="['doctor:doctorTraining:edit']"
              size="small">修改</el-button>
            <el-button
              type="danger"
              plain
              icon="Delete"
              :disabled="multiple"
              @click="handleDelete()"
              v-hasPermi="['doctor:doctorTraining:remove']"
              size="small">删除</el-button>
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['doctor:doctorTraining:export']" size="small">导出</el-button>
            <el-button type="primary" plain icon="Upload" @click="handleImport" v-hasPermi="['doctor:doctorTraining:import']" size="small">导入</el-button>
            <el-button text type="primary" @click="handleFieldConfig" class="config-btn">
              <i-ep-setting class="btn-icon"></i-ep-setting>
              字段配置
            </el-button>
            <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
          </div>
        </div>
      </template>

      <el-table v-loading="loading" border :data="doctorTrainingList" @selection-change="handleSelectionChange" class="doctor-training-table">
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
            <span v-if="field.prop === 'startDate' || field.prop === 'endDate' || field.prop === 'createTime' || field.prop === 'updateTime'">
              {{ parseTime(scope.row[field.prop], '{y}-{m}-{d} {h}:{i}:{s}') }}
            </span>
            <template v-else-if="field.prop === 'delFlag'">
              <el-tag :type="scope.row[field.prop] === 0 ? 'success' : 'danger'">
                {{ scope.row[field.prop] === 0 ? '否' : '是' }}
              </el-tag>
            </template>
            <template v-else-if="field.prop === 'doctorId'">
              <span>{{ getDoctorName(scope.row.doctorId) }}</span>
            </template>
            <span v-else>
              {{ scope.row[field.prop] }}
            </span>
          </template>
        </el-table-column>
        <el-table-column label="操作" align="center" fixed="right" class-name="small-padding fixed-width">
          <template #default="scope">
            <el-tooltip content="修改" placement="top">
              <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['doctor:doctorTraining:edit']"></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)" v-hasPermi="['doctor:doctorTraining:remove']"></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="700px" append-to-body>
      <el-form ref="doctorTrainingFormRef" :model="form" :rules="rules" label-width="120px">
        <el-row :gutter="20">
          <el-col v-for="field in visibleColumns" :key="field.prop" :span="field.formSpan || 24">
            <el-form-item :label="field.label" :prop="field.prop" v-if="field.prop !== 'createTime' && field.prop !== 'updateTime'">
              <el-select v-if="field.prop === 'doctorId'" v-model="form.doctorId" placeholder="请选择医生" style="width: 100%" filterable>
                <el-option v-for="doctor in doctorOptions" :key="doctor.id" :label="doctor.doctorName" :value="doctor.id" />
              </el-select>
              <el-input v-else-if="field.type === 'input' || !field.type" v-model="form[field.prop]" :placeholder="`请输入${field.label}`" />
              <el-input
                v-else-if="field.type === 'textarea'"
                v-model="form[field.prop]"
                type="textarea"
                :placeholder="`请输入${field.label}`"
                :rows="3"
              />
              <el-input-number
                v-else-if="field.type === 'number'"
                v-model="form[field.prop]"
                :min="0"
                :precision="1"
                :placeholder="`请输入${field.label}`"
                style="width: 100%"
              />
              <el-date-picker
                v-else-if="field.type === 'date'"
                clearable
                v-model="form[field.prop]"
                type="date"
                value-format="YYYY-MM-DD"
                :placeholder="`请选择${field.label}`"
                style="width: 100%"
              />
              <el-select v-else-if="field.type === 'select'" v-model="form[field.prop]" :placeholder="`请选择${field.label}`" style="width: 100%">
                <el-option v-for="option in field.options" :key="option.value" :label="option.label" :value="option.value" />
              </el-select>
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
    <FieldConfigDialog v-model:visible="showFieldConfig" :field-config-manager="fieldConfigManager" @confirm="handleFieldConfigConfirm" />
    <!-- 搜索配置对话框 -->
    <SearchConfigDialog v-model:visible="searchConfigVisible" :search-config-manager="searchConfigManager" @confirm="handleSearchConfigConfirm" />
  </div>
</template>

<script setup name="DoctorTraining" lang="ts">
import { listDoctorTraining, getDoctorTraining, delDoctorTraining, addDoctorTraining, updateDoctorTraining } from '@/api/doctor/doctorTraining';
import { DoctorTrainingVO, DoctorTrainingQuery, DoctorTrainingForm } from '@/api/doctor/doctorTraining/types';
import { listDoctorBasicInfo } from '@/api/doctor/doctorBasicInfo';
import { DoctorBasicInfoVO } from '@/api/doctor/doctorBasicInfo/types';
import { createDoctorTrainingFieldConfig } from '@/utils/configs/doctor/doctorFieldConfigs';
import { FieldConfigManager } from '@/utils/configs/fieldConfigManager';
import FieldConfigDialog from '@/components/FieldConfigDialog.vue';
import DynamicSearchForm from '@/components/DynamicSearchForm.vue';
import SearchConfigDialog from '@/components/SearchConfigDialog.vue';
import { createDoctorTrainingSearchConfig } from '@/utils/configs/doctor/doctorSearchConfigs';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const doctorTrainingList = ref<DoctorTrainingVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const showFieldConfig = ref(false);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const doctorTrainingFormRef = ref<ElFormInstance>();

// 字段配置相关变量
const fieldConfigManager = createDoctorTrainingFieldConfig();
const visibleColumns = computed(() => fieldConfigManager.getVisibleFields());
const searchConfigManager = createDoctorTrainingSearchConfig();
const searchConfigVisible = ref(false);
const visibleSearchFields = computed(() => searchConfigManager.getVisibleFields());

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: DoctorTrainingForm = {
  id: undefined,
  doctorId: undefined,
  trainingType: undefined,
  trainingName: undefined,
  trainingUnit: undefined,
  startDate: undefined,
  endDate: undefined,
  trainingHours: undefined,
  trainingContent: undefined,
  trainingResult: undefined,
  certificateNo: undefined,
  certificateUrl: undefined,
  credits: undefined,
  remark: undefined,
  delFlag: undefined
};
const data = reactive<PageData<DoctorTrainingForm, DoctorTrainingQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    doctorId: undefined,
    trainingType: undefined,
    trainingName: undefined,
    trainingUnit: undefined,
    startDate: undefined,
    endDate: undefined,
    trainingHours: undefined,
    trainingContent: undefined,
    trainingResult: undefined,
    certificateNo: undefined,
    certificateUrl: undefined,
    credits: undefined,
    delFlag: undefined,
    params: {}
  },
  rules: {}
});

const { queryParams, form, rules } = toRefs(data);

// 医生选项
const doctorOptions = ref<DoctorBasicInfoVO[]>([]);

/** 查询培训记录列表 */
const getList = async () => {
  loading.value = true;
  const res = await listDoctorTraining(queryParams.value);
  doctorTrainingList.value = res.rows;
  total.value = res.total;
  loading.value = false;
};

/** 加载医生选项 */
const loadDoctorOptions = async () => {
  try {
    const res = await listDoctorBasicInfo({ pageSize: 1000 });
    doctorOptions.value = res.rows;
  } catch (error) {
    console.error('获取医生列表失败:', error);
    doctorOptions.value = [];
  }
};

/** 获取医生姓名 */
const getDoctorName = (doctorId: string | number) => {
  const doctor = doctorOptions.value.find((d) => d.id === doctorId);
  return doctor ? doctor.doctorName : `医生ID: ${doctorId}`;
};

/** 取消按钮 */
const cancel = () => {
  reset();
  dialog.visible = false;
};

/** 表单重置 */
const reset = () => {
  form.value = { ...initFormData };
  doctorTrainingFormRef.value?.resetFields();
};

/** 搜索按钮操作 */
const handleQuery = () => {
  // 处理daterange字段
  if (queryParams.startDate && Array.isArray(queryParams.startDate)) {
    queryParams.startDateStart = queryParams.startDate[0];
    queryParams.startDateEnd = queryParams.startDate[1];
  } else {
    queryParams.startDateStart = undefined;
    queryParams.startDateEnd = undefined;
  }

  if (queryParams.endDate && Array.isArray(queryParams.endDate)) {
    queryParams.endDateStart = queryParams.endDate[0];
    queryParams.endDateEnd = queryParams.endDate[1];
  } else {
    queryParams.endDateStart = undefined;
    queryParams.endDateEnd = undefined;
  }

  queryParams.pageNum = 1;
  getList();
};

/** 重置按钮操作 */
const resetQuery = () => {
  queryFormRef.value?.resetFields();
  handleQuery();
};

/** 多选框选中数据 */
const handleSelectionChange = (selection: DoctorTrainingVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加培训记录';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: DoctorTrainingVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getDoctorTraining(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改培训记录';
};

/** 提交按钮 */
const submitForm = () => {
  doctorTrainingFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateDoctorTraining(form.value).finally(() => (buttonLoading.value = false));
      } else {
        await addDoctorTraining(form.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: DoctorTrainingVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除培训记录编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delDoctorTraining(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/doctorTraining/export',
    {
      ...queryParams.value
    },
    `doctorTraining_${new Date().getTime()}.xlsx`
  );
};

/** 导入按钮操作 */
const handleImport = () => {
  proxy?.$modal.upload('system/doctorTraining/importData', '医生培训记录导入', 'xls,xlsx', (response: any) => {
    proxy?.$modal.msgSuccess('导入成功');
    getList();
  });
};

/** 字段配置确认 */
const handleFieldConfigConfirm = (config: Record<string, boolean>) => {
  fieldConfigManager.updateConfig(config);
  showFieldConfig.value = false;
};

const handleSearchConfig = () => {
  searchConfigVisible.value = true;
};

const handleSearchConfigConfirm = (config: Record<string, boolean>) => {
  searchConfigManager.updateConfig(config);
  searchConfigVisible.value = false;
};

/** 重置字段配置 */
const resetFieldConfig = () => {
  fieldConfigManager.resetToDefault();
  localStorage.removeItem('doctorTraining_field_config');
  proxy?.$modal.msgSuccess('字段配置已重置');
};

onMounted(() => {
  getList();
  loadDoctorOptions();
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

.doctor-training-table {
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
}
</style>
