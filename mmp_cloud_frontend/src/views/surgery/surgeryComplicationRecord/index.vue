<template>
  <div class="app-container">
    <!-- 页面标题 -->
    <div class="page-header mb-4">
      <h2 class="page-title">
        <i-ep-document-checked class="title-icon"></i-ep-document-checked>
        手术并发症记录管理
      </h2>
      <p class="page-description">管理系统手术并发症记录，包括并发症描述、等级、处理措施等信息</p>
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
            <span>并发症记录列表</span>
            <el-tag type="info" size="small" class="ml-2">{{ total }} 条记录</el-tag>
          </div>
          <div class="table-actions">
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['surgery:surgeryComplicationRecord:add']" size="small"
              >新增</el-button
            >
            <el-button
              type="success"
              plain
              icon="Edit"
              :disabled="single"
              @click="handleUpdate()"
              v-hasPermi="['surgery:surgeryComplicationRecord:edit']"
              size="small"
              >修改</el-button
            >
            <el-button
              type="danger"
              plain
              icon="Delete"
              :disabled="multiple"
              @click="handleDelete()"
              v-hasPermi="['surgery:surgeryComplicationRecord:remove']"
              size="small"
              >删除</el-button
            >
            <el-button
              type="warning"
              plain
              icon="Download"
              @click="handleExport"
              v-hasPermi="['surgery:surgeryComplicationRecord:export']"
              size="small"
              >导出</el-button
            >
            <el-button type="primary" plain icon="Upload" @click="handleImport" v-hasPermi="['surgery:surgeryComplicationRecord:import']" size="small"
              >导入</el-button
            >
            <el-button text type="primary" @click="showFieldConfig = true" class="config-btn">
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
        :data="surgeryComplicationRecordList"
        @selection-change="handleSelectionChange"
        class="surgery-complication-table"
      >
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="主键ID" align="center" prop="id" v-if="false" />
        <el-table-column
          v-if="fieldConfigManager.getFieldConfig('doctorName').visible"
          :label="fieldConfigManager.getFieldConfig('doctorName').label"
          align="center"
          prop="doctorName"
          :min-width="fieldConfigManager.getFieldConfig('doctorName').width"
          resizable
        />
        <el-table-column
          v-if="fieldConfigManager.getFieldConfig('surgeryCode').visible"
          :label="fieldConfigManager.getFieldConfig('surgeryCode').label"
          align="center"
          prop="surgeryCode"
          :min-width="fieldConfigManager.getFieldConfig('surgeryCode').width"
          resizable
        />
        <el-table-column
          v-if="fieldConfigManager.getFieldConfig('surgeryName').visible"
          :label="fieldConfigManager.getFieldConfig('surgeryName').label"
          align="center"
          prop="surgeryName"
          :min-width="fieldConfigManager.getFieldConfig('surgeryName').width"
          resizable
        />
        <el-table-column
          v-if="fieldConfigManager.getFieldConfig('complicationType').visible"
          :label="fieldConfigManager.getFieldConfig('complicationType').label"
          align="center"
          prop="complicationType"
          :min-width="fieldConfigManager.getFieldConfig('complicationType').width"
          resizable
        />
        <el-table-column
          v-if="fieldConfigManager.getFieldConfig('complicationDescription').visible"
          :label="fieldConfigManager.getFieldConfig('complicationDescription').label"
          align="center"
          prop="complicationDescription"
          :min-width="fieldConfigManager.getFieldConfig('complicationDescription').width"
          resizable
        />
        <el-table-column
          v-if="fieldConfigManager.getFieldConfig('complicationLevel').visible"
          :label="fieldConfigManager.getFieldConfig('complicationLevel').label"
          align="center"
          prop="complicationLevel"
          :min-width="fieldConfigManager.getFieldConfig('complicationLevel').width"
          resizable
        />
        <el-table-column
          v-if="fieldConfigManager.getFieldConfig('occurrenceTime').visible"
          :label="fieldConfigManager.getFieldConfig('occurrenceTime').label"
          align="center"
          prop="occurrenceTime"
          :min-width="fieldConfigManager.getFieldConfig('occurrenceTime').width"
          resizable
        >
          <template #default="scope">
            <span>{{ parseTime(scope.row.occurrenceTime, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column
          v-if="fieldConfigManager.getFieldConfig('isPlannedSecondary').visible"
          :label="fieldConfigManager.getFieldConfig('isPlannedSecondary').label"
          align="center"
          prop="isPlannedSecondary"
          :min-width="fieldConfigManager.getFieldConfig('isPlannedSecondary').width"
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
              <el-button
                link
                type="primary"
                icon="Edit"
                @click="handleUpdate(scope.row)"
                v-hasPermi="['surgery:surgeryComplicationRecord:edit']"
              ></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button
                link
                type="primary"
                icon="Delete"
                @click="handleDelete(scope.row)"
                v-hasPermi="['surgery:surgeryComplicationRecord:remove']"
              ></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改手术并发症记录对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="600px" append-to-body class="surgery-complication-dialog">
      <el-form ref="surgeryComplicationRecordFormRef" :model="form" :rules="rules" label-width="120px">
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="医师" prop="doctorId">
              <el-select v-model="form.doctorId" placeholder="请选择医师" filterable clearable style="width: 100%">
                <el-option v-for="doctor in doctorOptions" :key="doctor.doctorId" :label="doctor.doctorName" :value="doctor.doctorId" />
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="手术编码" prop="surgeryCode">
              <el-input v-model="form.surgeryCode" placeholder="请输入手术编码" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="手术名称" prop="surgeryName">
              <el-input v-model="form.surgeryName" placeholder="请输入手术名称" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="并发症等级" prop="complicationLevel">
              <el-select v-model="form.complicationLevel" placeholder="请选择并发症等级" style="width: 100%">
                <el-option label="轻微" value="轻微" />
                <el-option label="中等" value="中等" />
                <el-option label="严重" value="严重" />
                <el-option label="致命" value="致命" />
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="发生时间" prop="occurrenceTime">
              <el-date-picker
                clearable
                v-model="form.occurrenceTime"
                type="datetime"
                value-format="YYYY-MM-DD HH:mm:ss"
                placeholder="请选择发生时间"
                style="width: 100%"
              >
              </el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="是否为非计划二次手术" prop="isPlannedSecondary">
              <el-select v-model="form.isPlannedSecondary" placeholder="请选择" style="width: 100%">
                <el-option label="是" value="1" />
                <el-option label="否" value="0" />
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>
        <el-form-item label="并发症描述" prop="complicationDescription">
          <el-input v-model="form.complicationDescription" type="textarea" :rows="4" placeholder="请输入并发症描述" />
        </el-form-item>
        <el-form-item label="删除标志" prop="delFlag">
          <el-select v-model="form.delFlag" placeholder="请选择删除标志" style="width: 100%">
            <el-option label="正常" value="0" />
            <el-option label="已删除" value="1" />
          </el-select>
        </el-form-item>
      </el-form>
      <template #footer>
        <div class="dialog-footer">
          <el-button :loading="buttonLoading" type="primary" @click="submitForm">确 定</el-button>
          <el-button @click="cancel">取 消</el-button>
        </div>
      </template>
    </el-dialog>
  </div>

  <!-- 字段配置对话框 -->
  <FieldConfigDialog v-model:visible="showFieldConfig" :field-config-manager="fieldConfigManager" />
  <SearchConfigDialog v-model="searchConfigVisible" :search-config-manager="searchConfigManager" @confirm="() => (searchConfigVisible = false)" />
</template>

<script setup name="SurgeryComplicationRecord" lang="ts">
import {
  listSurgeryComplicationRecord,
  getSurgeryComplicationRecord,
  delSurgeryComplicationRecord,
  addSurgeryComplicationRecord,
  updateSurgeryComplicationRecord
} from '@/api/surgery/surgeryComplicationRecord';
import { listDoctorBasicInfo } from '@/api/doctor/doctorBasicInfo';
import {
  SurgeryComplicationRecordVO,
  SurgeryComplicationRecordQuery,
  SurgeryComplicationRecordForm
} from '@/api/surgery/surgeryComplicationRecord/types';
import { createSurgeryComplicationRecordFieldConfig } from '@/utils/configs/surgery/surgeryFieldConfigs';
import FieldConfigDialog from '@/components/FieldConfigDialog.vue';
import SearchConfigDialog from '@/components/SearchConfigDialog.vue';
import { createSurgeryComplicationRecordSearchConfig } from '@/utils/configs/surgery/surgerySearchConfigs';
import DynamicSearchForm from '@/components/DynamicSearchForm.vue';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const surgeryComplicationRecordList = ref<SurgeryComplicationRecordVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const showFieldConfig = ref(false);
const searchConfigVisible = ref(false);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);
const doctorOptions = ref<any[]>([]);

// 字段配置管理器
const fieldConfigManager = createSurgeryComplicationRecordFieldConfig();
const searchConfigManager = createSurgeryComplicationRecordSearchConfig();
const visibleSearchFields = computed(() => searchConfigManager.getVisibleFields());

const queryFormRef = ref();
const surgeryComplicationRecordFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: SurgeryComplicationRecordForm = {
  id: undefined,
  surgeryRecordId: undefined,
  doctorId: undefined,
  doctorName: undefined,
  patientId: undefined,
  surgeryCode: undefined,
  surgeryName: undefined,
  complicationType: undefined,
  complicationDescription: undefined,
  complicationLevel: undefined,
  occurrenceTime: undefined,
  isPlannedSecondary: undefined,
  delFlag: undefined
};
const data = reactive<PageData<SurgeryComplicationRecordForm, SurgeryComplicationRecordQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    doctorName: undefined,
    surgeryCode: undefined,
    surgeryName: undefined,
    complicationType: undefined,
    complicationDescription: undefined,
    complicationLevel: undefined,
    occurrenceTime: undefined,
    isPlannedSecondary: undefined,
    delFlag: undefined,
    params: {}
  },
  rules: {
    doctorId: [{ required: true, message: '医师不能为空', trigger: 'change' }],
    surgeryCode: [{ required: true, message: '手术编码不能为空', trigger: 'blur' }],
    surgeryName: [{ required: true, message: '手术名称不能为空', trigger: 'blur' }],
    complicationType: [{ required: true, message: '并发症类型不能为空', trigger: 'change' }],
    occurrenceTime: [{ required: true, message: '发生时间不能为空', trigger: 'blur' }]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询手术并发症记录列表 */
const getList = async () => {
  loading.value = true;
  const res = await listSurgeryComplicationRecord(queryParams.value);
  surgeryComplicationRecordList.value = res.rows;
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
  surgeryComplicationRecordFormRef.value?.resetFields();
};

const handleSearchConfig = () => {
  searchConfigVisible.value = true;
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
const handleSelectionChange = (selection: SurgeryComplicationRecordVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加手术并发症记录';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: SurgeryComplicationRecordVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getSurgeryComplicationRecord(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改手术并发症记录';
};

/** 提交按钮 */
const submitForm = () => {
  surgeryComplicationRecordFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateSurgeryComplicationRecord(form.value).finally(() => (buttonLoading.value = false));
      } else {
        await addSurgeryComplicationRecord(form.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: SurgeryComplicationRecordVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除手术并发症记录编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delSurgeryComplicationRecord(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导入按钮操作 */
const handleImport = () => {
  (proxy.$modal as any).upload({
    url: '/dev-api/surgery/surgeryComplicationRecord/importData',
    success: () => {
      proxy.$modal.msgSuccess('导入成功');
      getList();
    }
  });
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'surgery/surgeryComplicationRecord/export',
    {
      ...queryParams.value
    },
    `surgeryComplicationRecord_${new Date().getTime()}.xlsx`
  );
};

/** 加载医师选项 */
const loadDoctorOptions = async () => {
  try {
    const res = await listDoctorInfo({ pageNum: 1, pageSize: 1000 });
    doctorOptions.value = res.rows || [];
  } catch (error) {
    console.error('加载医师选项失败:', error);
  }
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

.surgery-complication-table {
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

.surgery-complication-dialog {
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

  .surgery-complication-dialog {
    :deep(.el-dialog) {
      width: 95% !important;
      margin: 5vh auto;
    }
  }
}
</style>
