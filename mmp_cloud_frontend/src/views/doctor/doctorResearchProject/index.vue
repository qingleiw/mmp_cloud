<template>
  <div class="app-container">
    <!-- 页面标题 -->
    <div class="page-header mb-4">
      <h2 class="page-title">
        <i-ep-data-analysis class="title-icon"></i-ep-data-analysis>
        医师研究项目管理
      </h2>
      <p class="page-description">管理医师科研项目申报与执行情况，包括项目申报、经费管理、成果产出等</p>
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
        </el-card>
      </div>
    </transition>

    <!-- 数据表格 -->
    <el-card shadow="never" class="table-card">
      <template #header>
        <div class="table-header">
          <div class="table-title">
            <i-ep-list class="table-icon"></i-ep-list>
            <span>研究项目列表</span>
            <el-tag type="info" size="small" class="ml-2">{{ total }} 条记录</el-tag>
          </div>
          <div class="table-actions">
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['doctor:doctorResearchProject:add']" size="small">新增</el-button>
            <el-button
              type="success"
              plain
              icon="Edit"
              :disabled="single"
              @click="handleUpdate()"
              v-hasPermi="['doctor:doctorResearchProject:edit']"
              size="small">修改</el-button>
            <el-button
              type="danger"
              plain
              icon="Delete"
              :disabled="multiple"
              @click="handleDelete()"
              v-hasPermi="['doctor:doctorResearchProject:remove']"
              size="small">删除</el-button>
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['doctor:doctorResearchProject:export']" size="small">导出</el-button>
            <el-button type="primary" plain icon="Upload" @click="handleImport" v-hasPermi="['doctor:doctorResearchProject:import']" size="small">导入</el-button>
            <el-button text type="primary" @click="showFieldConfig = true" class="config-btn">
              <i-ep-setting class="btn-icon"></i-ep-setting>
              字段配置
            </el-button>
            <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
          </div>
        </div>
      </template>

      <el-table v-loading="loading" border :data="doctorResearchProjectList" @selection-change="handleSelectionChange">
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
            <span v-if="field.prop === 'startDate' || field.prop === 'endDate'">
              {{ parseTime(scope.row[field.prop], '{y}-{m}-{d}') }}
            </span>
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
              <el-button
                link
                type="primary"
                icon="Edit"
                @click="handleUpdate(scope.row)"
                v-hasPermi="['doctor:doctorResearchProject:edit']"
              ></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button
                link
                type="primary"
                icon="Delete"
                @click="handleDelete(scope.row)"
                v-hasPermi="['doctor:doctorResearchProject:remove']"
              ></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
  </div>
  <!-- 添加或修改科研项目对话框 -->
  <el-dialog :title="dialog.title" v-model="dialog.visible" width="700px" append-to-body>
    <el-form ref="doctorResearchProjectFormRef" :model="form" :rules="rules" label-width="120px">
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="医生" prop="doctorId">
            <el-select v-model="form.doctorId" placeholder="请选择医生" filterable clearable style="width: 100%">
              <el-option v-for="doctor in doctorOptions" :key="doctor.doctorId" :label="doctor.doctorName" :value="doctor.doctorId" />
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="项目编号" prop="projectNo">
            <el-input v-model="form.projectNo" placeholder="请输入项目编号" />
          </el-form-item>
        </el-col>
      </el-row>
      <el-form-item label="项目名称" prop="projectName">
        <el-input v-model="form.projectName" placeholder="请输入项目名称" />
      </el-form-item>
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="项目级别" prop="projectLevel">
            <el-select v-model="form.projectLevel" placeholder="请选择项目级别" style="width: 100%">
              <el-option label="国家级" value="国家级" />
              <el-option label="省级" value="省级" />
              <el-option label="市级" value="市级" />
              <el-option label="院级" value="院级" />
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="承担角色" prop="role">
            <el-select v-model="form.role" placeholder="请选择承担角色" style="width: 100%">
              <el-option label="主持人" value="主持人" />
              <el-option label="参与人" value="参与人" />
            </el-select>
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
            />
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="结束日期" prop="endDate">
            <el-date-picker clearable v-model="form.endDate" type="date" value-format="YYYY-MM-DD" placeholder="请选择结束日期" style="width: 100%" />
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="资助金额" prop="fundingAmount">
            <el-input-number v-model="form.fundingAmount" :min="0" :precision="2" placeholder="请输入资助金额" style="width: 100%" />
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="删除标志" prop="delFlag">
            <el-select v-model="form.delFlag" placeholder="请选择删除标志" style="width: 100%">
              <el-option label="正常" value="0" />
              <el-option label="已删除" value="1" />
            </el-select>
          </el-form-item>
        </el-col>
      </el-row>
      <el-form-item label="备注" prop="remark">
        <el-input v-model="form.remark" type="textarea" :rows="3" placeholder="请输入备注" />
      </el-form-item>
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
</template>

<script setup name="DoctorResearchProject" lang="ts">
import {
  listDoctorResearchProject,
  getDoctorResearchProject,
  delDoctorResearchProject,
  addDoctorResearchProject,
  updateDoctorResearchProject
} from '@/api/doctor/doctorResearchProject';
import { listDoctorBasicInfo } from '@/api/doctor/doctorBasicInfo';
import { DoctorResearchProjectVO, DoctorResearchProjectQuery, DoctorResearchProjectForm } from '@/api/doctor/doctorResearchProject/types';
import { createDoctorResearchProjectFieldConfig } from '@/utils/configs/doctor/doctorFieldConfigs';
import { FieldConfigManager } from '@/utils/configs/fieldConfigManager';
import FieldConfigDialog from '@/components/FieldConfigDialog.vue';
import DynamicSearchForm from '@/components/DynamicSearchForm.vue';
import SearchConfigDialog from '@/components/SearchConfigDialog.vue';
import { createDoctorResearchProjectSearchConfig } from '@/utils/configs/doctor/doctorSearchConfigs';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const doctorResearchProjectList = ref<DoctorResearchProjectVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const showFieldConfig = ref(false);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

// 医生选项
const doctorOptions = ref<any[]>([]);

const queryFormRef = ref<ElFormInstance>();
const doctorResearchProjectFormRef = ref<ElFormInstance>();

// 字段配置相关变量
const fieldGroups = createDoctorResearchProjectFieldConfig();
const fieldConfigManager = new FieldConfigManager('doctorResearchProject', fieldGroups);
const searchConfigManager = createDoctorResearchProjectSearchConfig();
const searchConfigVisible = ref(false);
const visibleSearchFields = computed(() => searchConfigManager.getVisibleFields());

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: DoctorResearchProjectForm = {
  id: undefined,
  doctorId: undefined,
  projectName: undefined,
  projectNo: undefined,
  projectLevel: undefined,
  projectType: undefined,
  role: undefined,
  startDate: undefined,
  endDate: undefined,
  fundingAmount: undefined,
  status: undefined,
  remark: undefined,
  delFlag: undefined
};
const data = reactive<PageData<DoctorResearchProjectForm, DoctorResearchProjectQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    doctorId: undefined,
    projectName: undefined,
    projectNo: undefined,
    projectLevel: undefined,
    projectType: undefined,
    role: undefined,
    startDate: undefined,
    endDate: undefined,
    fundingAmount: undefined,
    status: undefined,
    delFlag: undefined,
    params: {}
  },
  rules: {
    doctorId: [{ required: true, message: '医生不能为空', trigger: 'change' }],
    projectName: [{ required: true, message: '项目名称不能为空', trigger: 'blur' }]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 加载医生选项 */
const loadDoctorOptions = async () => {
  try {
    const res = await listDoctorBasicInfo({ pageNum: 1, pageSize: 1000 });
    doctorOptions.value = res.rows || [];
  } catch (error) {
    console.error('加载医生选项失败:', error);
  }
};

/** 获取医生姓名 */
const getDoctorName = (doctorId: string | number) => {
  const doctor = doctorOptions.value.find((d) => d.id === doctorId);
  return doctor ? doctor.doctorName : `医生ID: ${doctorId}`;
};

/** 查询科研项目列表 */
const getList = async () => {
  loading.value = true;
  const res = await listDoctorResearchProject(queryParams.value);
  doctorResearchProjectList.value = res.rows;
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
  doctorResearchProjectFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: DoctorResearchProjectVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加科研项目';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: DoctorResearchProjectVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getDoctorResearchProject(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改科研项目';
};

/** 提交按钮 */
const submitForm = () => {
  doctorResearchProjectFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateDoctorResearchProject(form.value).finally(() => (buttonLoading.value = false));
      } else {
        await addDoctorResearchProject(form.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: DoctorResearchProjectVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除科研项目编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delDoctorResearchProject(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/doctorResearchProject/export',
    {
      ...queryParams.value
    },
    `doctorResearchProject_${new Date().getTime()}.xlsx`
  );
};

/** 导入按钮操作 */
const handleImport = () => {
  proxy?.$modal.upload('system/doctorResearchProject/importData', '医生研究项目导入', 'xls,xlsx', (response: any) => {
    proxy?.$modal.msgSuccess('导入成功');
    getList();
  });
};

/** 字段配置确认 */
const handleFieldConfigConfirm = () => {
  // 字段配置更新后刷新列表
  getList();
};

const handleSearchConfig = () => {
  searchConfigVisible.value = true;
};
const handleSearchConfigConfirm = () => {
  searchConfigVisible.value = false;
};

onMounted(() => {
  loadDoctorOptions();
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

.research-project-table {
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

.research-project-dialog {
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

  .research-project-dialog {
    :deep(.el-dialog) {
      width: 95% !important;
      margin: 5vh auto;
    }
  }
}
</style>
