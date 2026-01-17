<template>
  <div class="app-container">
    <!-- 页面标题 -->
    <div class="page-header mb-4">
      <h2 class="page-title">
        <i-ep-user class="title-icon"></i-ep-user>
        医师学术职称管理
      </h2>
      <p class="page-description">管理医师的学术职称、学术职务、学术成就等信息</p>
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
            <span>学术职称信息列表</span>
            <el-tag type="info" size="small" class="ml-2">{{ total }} 条记录</el-tag>
          </div>
          <div class="table-actions">
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['doctor:doctorAcademicPosition:add']" size="small">新增</el-button>
            <el-button
              type="success"
              plain
              icon="Edit"
              :disabled="single"
              @click="handleUpdate()"
              v-hasPermi="['doctor:doctorAcademicPosition:edit']"
              size="small">修改</el-button>
            <el-button
              type="danger"
              plain
              icon="Delete"
              :disabled="multiple"
              @click="handleDelete()"
              v-hasPermi="['doctor:doctorAcademicPosition:remove']"
              size="small">删除</el-button>
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['doctor:doctorAcademicPosition:export']" size="small">导出</el-button>
            <el-button type="primary" plain icon="Upload" @click="handleImport" v-hasPermi="['doctor:doctorAcademicPosition:import']" size="small">导入</el-button>
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
        :data="doctorAcademicPositionList"
        @selection-change="handleSelectionChange"
        class="doctor-academic-position-table"
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
            <!-- 日期字段格式化 -->
            <span v-if="field.prop === 'startDate' || field.prop === 'endDate' || field.prop === 'createTime' || field.prop === 'updateTime'">
              {{ parseTime(scope.row[field.prop], '{y}-{m}-{d} {h}:{i}:{s}') }}
            </span>
            <!-- 删除标志字段 -->
            <el-tag v-else-if="field.prop === 'delFlag'" :type="scope.row[field.prop] === 0 ? 'success' : 'danger'">
              {{ scope.row[field.prop] === 0 ? '未删除' : '已删除' }}
            </el-tag>
            <!-- 是否当前字段 -->
            <el-tag v-else-if="field.prop === 'isCurrent'" :type="scope.row[field.prop] === 1 ? 'success' : 'info'">
              {{ scope.row[field.prop] === 1 ? '是' : '否' }}
            </el-tag>
            <!-- 医生ID字段 -->
            <span v-else-if="field.prop === 'doctorId'">
              {{ getDoctorName(scope.row.doctorId) }}
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
                v-hasPermi="['doctor:doctorAcademicPosition:edit']"
              ></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button
                link
                type="primary"
                icon="Delete"
                @click="handleDelete(scope.row)"
                v-hasPermi="['doctor:doctorAcademicPosition:remove']"
              ></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>

    <!-- 添加或修改医师学术职称对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="700px" append-to-body>
      <el-form ref="doctorAcademicPositionFormRef" :model="form" :rules="rules" label-width="120px">
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="医生ID" prop="doctorId">
              <el-select v-model="form.doctorId" placeholder="请选择医生" filterable>
                <el-option v-for="doctor in doctorOptions" :key="doctor.id" :label="doctor.doctorName" :value="doctor.id" />
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="任职机构" prop="organization">
              <el-input v-model="form.organization" placeholder="请输入任职机构" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="学术职务" prop="position">
              <el-input v-model="form.position" placeholder="请输入学术职务" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="职务级别" prop="positionLevel">
              <el-input v-model="form.positionLevel" placeholder="请输入职务级别" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="开始日期" prop="startDate">
              <el-date-picker
                v-model="form.startDate"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择开始日期"
              />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="结束日期" prop="endDate">
              <el-date-picker
                v-model="form.endDate"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择结束日期"
              />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="是否当前" prop="isCurrent">
              <el-switch v-model="form.isCurrent" active-text="是" inactive-text="否" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="任命文件URL" prop="appointmentUrl">
              <el-input v-model="form.appointmentUrl" placeholder="请输入任命文件URL" />
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="备注" prop="remark">
              <el-input v-model="form.remark" type="textarea" placeholder="请输入备注" />
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

<script setup name="DoctorAcademicPosition" lang="ts">
import {
  listDoctorAcademicPosition,
  getDoctorAcademicPosition,
  delDoctorAcademicPosition,
  addDoctorAcademicPosition,
  updateDoctorAcademicPosition
} from '@/api/doctor/doctorAcademicPosition';
import { listDoctorBasicInfo } from '@/api/doctor/doctorBasicInfo';
import { DoctorBasicInfoVO } from '@/api/doctor/doctorBasicInfo/types';
import { DoctorAcademicPositionVO, DoctorAcademicPositionQuery, DoctorAcademicPositionForm } from '@/api/doctor/doctorAcademicPosition/types';
import FieldConfigDialog from '@/components/FieldConfigDialog.vue';
import { createDoctorAcademicPositionFieldConfig } from '@/utils/configs/doctor/doctorFieldConfigs';
import { FieldConfigManager } from '@/utils/configs/fieldConfigManager';
import DynamicSearchForm from '@/components/DynamicSearchForm.vue';
import SearchConfigDialog from '@/components/SearchConfigDialog.vue';
import RightToolbar from '@/components/RightToolbar/index.vue';
import Pagination from '@/components/Pagination/index.vue';
import { createDoctorAcademicPositionSearchConfig } from '@/utils/configs/doctor/doctorSearchConfigs';
import { SearchConfigManager } from '@/utils/configs/searchConfigManager';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const doctorAcademicPositionList = ref<DoctorAcademicPositionVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const doctorAcademicPositionFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: DoctorAcademicPositionForm = {
  id: undefined,
  doctorId: undefined,
  organization: undefined,
  position: undefined,
  positionLevel: undefined,
  startDate: undefined,
  endDate: undefined,
  isCurrent: undefined,
  appointmentUrl: undefined,
  remark: undefined,
  delFlag: undefined,
  tenantId: undefined
};

const queryParams = reactive<DoctorAcademicPositionQuery>({
  pageNum: 1,
  pageSize: 10,
  doctorId: undefined,
  organization: undefined,
  position: undefined,
  positionLevel: undefined,
  startDate: undefined,
  endDate: undefined,
  isCurrent: undefined,
  appointmentUrl: undefined,
  delFlag: undefined,
  params: {}
});

const form = reactive<DoctorAcademicPositionForm>({ ...initFormData });

const rules = {
  doctorId: [{ required: true, message: '医生ID不能为空', trigger: 'change' }]
};

// 医生选项
const doctorOptions = ref<DoctorBasicInfoVO[]>([]);

// 字段配置管理器
const fieldConfigManager = createDoctorAcademicPositionFieldConfig();
const searchConfigManager = createDoctorAcademicPositionSearchConfig();
const visibleSearchFields = computed(() => searchConfigManager.getVisibleFields());

// 配置对话框状态
const fieldConfigVisible = ref(false);
const searchConfigVisible = ref(false);

/** 查询医师学术职称列表 */
const getList = async () => {
  loading.value = true;
  const res = await listDoctorAcademicPosition(queryParams);
  doctorAcademicPositionList.value = res.rows;
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
  Object.assign(form, initFormData);
  doctorAcademicPositionFormRef.value?.resetFields();
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

  queryParams.pageNum = 1;
  getList();
};

/** 重置按钮操作 */
const resetQuery = () => {
  queryFormRef.value?.resetFields();
  handleQuery();
};

/** 多选框选中数据 */
const handleSelectionChange = (selection: DoctorAcademicPositionVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加医师学术职称';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: DoctorAcademicPositionVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getDoctorAcademicPosition(_id);
  Object.assign(form, res.data);
  dialog.visible = true;
  dialog.title = '修改医师学术职称';
};

/** 提交按钮 */
const submitForm = () => {
  doctorAcademicPositionFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.id) {
        await updateDoctorAcademicPosition(form).finally(() => (buttonLoading.value = false));
      } else {
        await addDoctorAcademicPosition(form).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: DoctorAcademicPositionVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除医师学术职称编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delDoctorAcademicPosition(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/doctorAcademicPosition/export',
    {
      ...queryParams
    },
    `doctorAcademicPosition_${new Date().getTime()}.xlsx`
  );
};

/** 导入按钮操作 */
const handleImport = () => {
  // 导入逻辑
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

onMounted(() => {
  getList();
  loadDoctorOptions();
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
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);

  .page-title {
    font-size: 24px;
    font-weight: 600;
    color: #1d2129;
    margin: 0 0 8px 0;
    display: flex;
    align-items: center;
    gap: 12px;

    .title-icon {
      color: #409eff;
      font-size: 28px;
    }
  }

  .page-description {
    color: #86909c;
    font-size: 14px;
    margin: 0;
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
        font-size: 16px;
        font-weight: 500;
        color: #1d2129;
        display: flex;
        align-items: center;
        gap: 8px;

        .search-icon {
          color: #409eff;
        }
      }

      .search-actions {
        display: flex;
        gap: 8px;

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
      font-size: 16px;
      font-weight: 500;
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
      flex-wrap: wrap;

      .config-btn {
        color: #409eff;

        .btn-icon {
          margin-right: 4px;
        }
      }
    }
  }
}

.doctor-academic-position-table {
  .el-table {
    border-radius: 6px;
  }

  .el-table th {
    background-color: #fafafa;
    color: #1d2129;
    font-weight: 600;
  }

  .el-table td {
    color: #1d2129;
  }

  .el-table--border {
    border-radius: 6px;
  }
}

.dialog-footer {
  text-align: right;
}

/*  响应式设计 */
@media (max-width: 768px) {
  .app-container {
    padding: 10px;
  }

  .page-header {
    padding: 16px;

    .page-title {
      font-size: 20px;

      .title-icon {
        font-size: 24px;
      }
    }
  }

  .table-header {
    flex-direction: column;
    align-items: flex-start;
    gap: 12px;

    .table-actions {
      width: 100%;
      justify-content: flex-start;
    }
  }

  .search-header {
    flex-direction: column;
    align-items: flex-start;
    gap: 12px;

    .search-actions {
      width: 100%;
      justify-content: flex-start;
    }
  }
}
</style>
