<template>
  <div class="app-container">
    <!-- 页面标题 -->
    <div class="page-header mb-4">
      <h2 class="page-title">
        <i-ep-document-copy class="title-icon"></i-ep-document-copy>
        医师电子注册管理
      </h2>
      <p class="page-description">管理医师电子注册信息、注册状态、证书编号等相关数据</p>
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
            <span>电子注册信息列表</span>
            <el-tag type="info" size="small" class="ml-2">{{ total }} 条记录</el-tag>
          </div>
          <div class="table-actions">
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['doctor:doctorElectronicRegistration:add']" size="small">新增</el-button>
            <el-button
              type="success"
              plain
              icon="Edit"
              :disabled="single"
              @click="handleUpdate()"
              v-hasPermi="['doctor:doctorElectronicRegistration:edit']"
              size="small"
            >修改</el-button>
            <el-button
              type="danger"
              plain
              icon="Delete"
              :disabled="multiple"
              @click="handleDelete()"
              v-hasPermi="['doctor:doctorElectronicRegistration:remove']"
              size="small"
            >删除</el-button>
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['doctor:doctorElectronicRegistration:export']" size="small">导出</el-button>
            <el-button type="primary" plain icon="Upload" @click="handleImport" v-hasPermi="['doctor:doctorElectronicRegistration:import']" size="small">导入</el-button>
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
        :data="doctorElectronicRegistrationList"
        @selection-change="handleSelectionChange"
        class="doctor-electronic-registration-table"
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
            <span v-if="field.prop === 'issueDate' || field.prop === 'validDate'">
              {{ parseTime(scope.row[field.prop], '{y}-{m}-{d}') }}
            </span>
            <span v-else-if="field.prop === 'createTime' || field.prop === 'updateTime'">
              {{ parseTime(scope.row[field.prop], '{y}-{m}-{d} {h}:{i}') }}
            </span>
            <el-tag v-else-if="field.prop === 'delFlag'" :type="scope.row[field.prop] === '0' ? 'success' : 'danger'">
              {{ scope.row[field.prop] === '0' ? '未删除' : '已删除' }}
            </el-tag>
            <span v-else-if="field.prop === 'doctorId'">
              {{ getDoctorName(scope.row.doctorId) }}
            </span>
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
                v-hasPermi="['doctor:doctorElectronicRegistration:edit']"
              ></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button
                link
                type="primary"
                icon="Delete"
                @click="handleDelete(scope.row)"
                v-hasPermi="['doctor:doctorElectronicRegistration:remove']"
              ></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>

    <!-- 添加或修改医师电子注册对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="700px" append-to-body">
      <el-form ref="doctorElectronicRegistrationFormRef" :model="form" :rules="rules" label-width="120px">
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="医生ID" prop="doctorId">
              <el-select v-model="form.doctorId" placeholder="请选择医生" filterable>
                <el-option v-for="doctor in doctorOptions" :key="doctor.id" :label="doctor.doctorName" :value="doctor.id" />
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="注册编号" prop="registrationNo">
              <el-input v-model="form.registrationNo" placeholder="请输入注册编号" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="注册类型" prop="registrationType">
              <el-input v-model="form.registrationType" placeholder="请输入注册类型" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="执业类别" prop="practiceCategory">
              <el-input v-model="form.practiceCategory" placeholder="请输入执业类别" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="执业范围" prop="practiceScope">
              <el-input v-model="form.practiceScope" placeholder="请输入执业范围" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="执业地点" prop="practiceLocation">
              <el-input v-model="form.practiceLocation" placeholder="请输入执业地点" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="发证日期" prop="issueDate">
              <el-date-picker
                v-model="form.issueDate"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择发证日期"
              />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="有效期至" prop="validDate">
              <el-date-picker
                v-model="form.validDate"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择有效期至"
              />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="注册机关" prop="registrationAuthority">
              <el-input v-model="form.registrationAuthority" placeholder="请输入注册机关" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="注册状态" prop="registrationStatus">
              <el-input v-model="form.registrationStatus" placeholder="请输入注册状态" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="多机构执业标志" prop="multiInstitutionFlag">
              <el-input v-model="form.multiInstitutionFlag" placeholder="请输入多机构执业标志" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="证书URL" prop="certificateUrl">
              <el-input v-model="form.certificateUrl" placeholder="请输入证书URL" />
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

<script setup name="DoctorElectronicRegistration" lang="ts">
import {
  listDoctorElectronicRegistration,
  getDoctorElectronicRegistration,
  delDoctorElectronicRegistration,
  addDoctorElectronicRegistration,
  updateDoctorElectronicRegistration
} from '@/api/doctor/doctorElectronicRegistration';
import { listDoctorBasicInfo } from '@/api/doctor/doctorBasicInfo';
import { DoctorBasicInfoVO } from '@/api/doctor/doctorBasicInfo/types';
import {
  DoctorElectronicRegistrationVO,
  DoctorElectronicRegistrationQuery,
  DoctorElectronicRegistrationForm
} from '@/api/doctor/doctorElectronicRegistration/types';
import { FieldConfigManager } from '@/utils/configs/fieldConfigManager';
import { createDoctorElectronicRegistrationFieldConfig } from '@/utils/configs/doctor/doctorFieldConfigs';
import { createDoctorElectronicRegistrationSearchConfig } from '@/utils/configs/doctor/doctorSearchConfigs';
import FieldConfigDialog from '@/components/FieldConfigDialog.vue';
import DynamicSearchForm from '@/components/DynamicSearchForm.vue';
import SearchConfigDialog from '@/components/SearchConfigDialog.vue';
import RightToolbar from '@/components/RightToolbar/index.vue';
import Pagination from '@/components/Pagination/index.vue';
import { parseTime } from '@/utils/ruoyi';
import { getCurrentInstance, type ComponentInternalInstance, onMounted, ref, reactive, computed } from 'vue';
import type { FormInstance as ElFormInstance } from 'element-plus';
import type { DialogOption } from '@/types/global';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const doctorElectronicRegistrationList = ref<DoctorElectronicRegistrationVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const doctorElectronicRegistrationFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const doctorOptions = ref<DoctorBasicInfoVO[]>([]);

const fieldConfigManager = createDoctorElectronicRegistrationFieldConfig();
const searchConfigManager = createDoctorElectronicRegistrationSearchConfig();
const visibleSearchFields = computed(() => searchConfigManager.getVisibleFields());

const fieldConfigVisible = ref(false);
const searchConfigVisible = ref(false);

const initFormData: DoctorElectronicRegistrationForm = {
  id: undefined,
  doctorId: undefined,
  registrationNo: undefined,
  registrationType: undefined,
  practiceCategory: undefined,
  practiceScope: undefined,
  practiceLocation: undefined,
  issueDate: undefined,
  validDate: undefined,
  registrationAuthority: undefined,
  registrationStatus: undefined,
  multiInstitutionFlag: undefined,
  certificateUrl: undefined,
  remark: undefined,
  delFlag: undefined
};

const queryParams = reactive<DoctorElectronicRegistrationQuery>({
  pageNum: 1,
  pageSize: 10,
  doctorId: undefined,
  registrationNo: undefined,
  registrationType: undefined,
  practiceCategory: undefined,
  practiceScope: undefined,
  practiceLocation: undefined,
  issueDate: undefined,
  validDate: undefined,
  registrationAuthority: undefined,
  registrationStatus: undefined,
  multiInstitutionFlag: undefined,
  certificateUrl: undefined,
  delFlag: undefined,
  params: {}
});

const form = reactive<DoctorElectronicRegistrationForm>({ ...initFormData });

const rules = {
  doctorId: [{ required: true, message: '医生ID不能为空', trigger: 'change' }]
};

const getList = async () => {
  loading.value = true;
  const res = await listDoctorElectronicRegistration(queryParams);
  doctorElectronicRegistrationList.value = res.rows;
  total.value = res.total;
  loading.value = false;
};

const loadDoctorOptions = async () => {
  try {
    const res = await listDoctorBasicInfo({ pageSize: 1000 });
    doctorOptions.value = res.rows;
  } catch (error) {
    console.error('获取医生列表失败:', error);
    doctorOptions.value = [];
  }
};

const getDoctorName = (doctorId: string | number) => {
  const doctor = doctorOptions.value.find((d) => d.id === doctorId);
  return doctor ? doctor.doctorName : `医生ID: ${doctorId}`;
};

const cancel = () => {
  reset();
  dialog.visible = false;
};

const reset = () => {
  Object.assign(form, initFormData);
  doctorElectronicRegistrationFormRef.value?.resetFields();
};

const handleQuery = () => {
  if (queryParams.registrationDate && Array.isArray(queryParams.registrationDate)) {
    queryParams.registrationDateStart = queryParams.registrationDate[0];
    queryParams.registrationDateEnd = queryParams.registrationDate[1];
  } else {
    queryParams.registrationDateStart = undefined;
    queryParams.registrationDateEnd = undefined;
  }

  queryParams.pageNum = 1;
  getList();
};

const resetQuery = () => {
  queryFormRef.value?.resetFields();
  handleQuery();
};

const handleSelectionChange = (selection: DoctorElectronicRegistrationVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加医师电子注册';
};

const handleUpdate = async (row?: DoctorElectronicRegistrationVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getDoctorElectronicRegistration(_id);
  Object.assign(form, res.data);
  dialog.visible = true;
  dialog.title = '修改医师电子注册';
};

const submitForm = () => {
  doctorElectronicRegistrationFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.id) {
        await updateDoctorElectronicRegistration(form).finally(() => (buttonLoading.value = false));
      } else {
        await addDoctorElectronicRegistration(form).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

const handleDelete = async (row?: DoctorElectronicRegistrationVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除医师电子注册编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delDoctorElectronicRegistration(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

const handleExport = () => {
  proxy?.download(
    'system/doctorElectronicRegistration/export',
    {
      ...queryParams
    },
    `doctorElectronicRegistration_${new Date().getTime()}.xlsx`
  );
};

const handleImport = () => {
};

const handleFieldConfig = () => {
  fieldConfigVisible.value = true;
};

const handleSearchConfig = () => {
  searchConfigVisible.value = true;
};

const handleFieldConfigConfirm = () => {
  fieldConfigVisible.value = false;
};

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

.doctor-electronic-registration-table {
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
