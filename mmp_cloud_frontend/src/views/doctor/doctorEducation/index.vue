<template>
  <div class="app-container">
    <!-- 页面标题 -->
    <div class="page-header mb-4">
      <h2 class="page-title">
        <i-ep-school class="title-icon"></i-ep-school>
        医师学历管理
      </h2>
      <p class="page-description">管理医师学历信息、教育背景、专业资格等基础教育数据</p>
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
            <span>学历信息列表</span>
            <el-tag type="info" size="small" class="ml-2">{{ total }} 条记录</el-tag>
          </div>
          <div class="table-actions">
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['doctor:doctorEducation:add']" size="small">新增</el-button>
            <el-button
              type="success"
              plain
              icon="Edit"
              :disabled="single"
              @click="handleUpdate()"
              v-hasPermi="['doctor:doctorEducation:edit']"
              size="small">修改</el-button>
            <el-button
              type="danger"
              plain
              icon="Delete"
              :disabled="multiple"
              @click="handleDelete()"
              v-hasPermi="['doctor:doctorEducation:remove']"
              size="small">删除</el-button>
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['doctor:doctorEducation:export']" size="small">导出</el-button>
            <el-button type="primary" plain icon="Upload" @click="handleImport" v-hasPermi="['doctor:doctorEducation:import']" size="small">导入</el-button>
            <el-button text type="primary" @click="handleFieldConfig" class="config-btn">
              <i-ep-setting class="btn-icon"></i-ep-setting>
              字段配置
            </el-button>
            <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
          </div>
        </div>
      </template>

      <el-table v-loading="loading" border :data="doctorEducationList" @selection-change="handleSelectionChange" class="doctor-education-table">
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
          <template
            #default="scope"
            v-if="field.prop === 'startDate' || field.prop === 'endDate' || field.prop === 'createTime' || field.prop === 'updateTime'"
          >
            <span>{{ parseTime(scope.row[field.prop], '{y}-{m}-{d} {h}:{i}:{s}') }}</span>
          </template>
          <template #default="scope" v-else-if="field.prop === 'delFlag'">
            <el-tag :type="scope.row[field.prop] === 0 ? 'success' : 'danger'">
              {{ scope.row[field.prop] === 0 ? '否' : '是' }}
            </el-tag>
          </template>
          <template #default="scope" v-else-if="field.prop === 'isFullTime'">
            <el-tag :type="scope.row[field.prop] === 1 ? 'success' : 'info'">
              {{ scope.row[field.prop] === 1 ? '全日制' : '非全日制' }}
            </el-tag>
          </template>
          <template #default="scope" v-else-if="field.prop === 'certificateUrl'">
            <el-link v-if="scope.row[field.prop]" :href="scope.row[field.prop]" target="_blank" type="primary">查看附件</el-link>
            <span v-else>无</span>
          </template>
          <template #default="scope" v-else-if="field.prop === 'doctorId'">
            <span>{{ getDoctorName(scope.row.doctorId) }}</span>
          </template>
          <template #default="scope" v-else>
            {{ scope.row[field.prop] }}
          </template>
        </el-table-column>
        <el-table-column label="操作" align="center" fixed="right" class-name="small-padding fixed-width">
          <template #default="scope">
            <el-tooltip content="修改" placement="top">
              <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['doctor:doctorEducation:edit']"></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button
                link
                type="primary"
                icon="Delete"
                @click="handleDelete(scope.row)"
                v-hasPermi="['doctor:doctorEducation:remove']"
              ></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改教育经历对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="doctorEducationFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="医生ID" prop="doctorId">
          <el-input v-model="form.doctorId" placeholder="请输入医生ID" />
        </el-form-item>
        <el-form-item label="学校名称" prop="schoolName">
          <el-input v-model="form.schoolName" placeholder="请输入学校名称" />
        </el-form-item>
        <el-form-item label="专业" prop="major">
          <el-input v-model="form.major" placeholder="请输入专业" />
        </el-form-item>
        <el-form-item label="学历" prop="educationLevel">
          <el-select v-model="form.educationLevel" placeholder="请选择学历" style="width: 100%">
            <el-option label="本科" value="本科" />
            <el-option label="硕士" value="硕士" />
            <el-option label="博士" value="博士" />
            <el-option label="专科" value="专科" />
            <el-option label="高中" value="高中" />
            <el-option label="初中" value="初中" />
            <el-option label="小学" value="小学" />
          </el-select>
        </el-form-item>
        <el-form-item label="学位" prop="degree">
          <el-select v-model="form.degree" placeholder="请选择学位" style="width: 100%">
            <el-option label="学士" value="学士" />
            <el-option label="硕士" value="硕士" />
            <el-option label="博士" value="博士" />
            <el-option label="无" value="无" />
          </el-select>
        </el-form-item>
        <el-form-item label="开始日期" prop="startDate">
          <el-date-picker clearable v-model="form.startDate" type="datetime" value-format="YYYY-MM-DD HH:mm:ss" placeholder="请选择开始日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="结束日期" prop="endDate">
          <el-date-picker clearable v-model="form.endDate" type="datetime" value-format="YYYY-MM-DD HH:mm:ss" placeholder="请选择结束日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="是否全日制" prop="isFullTime">
          <el-select v-model="form.isFullTime" placeholder="请选择是否全日制" style="width: 100%">
            <el-option label="是" :value="1" />
            <el-option label="否" :value="0" />
          </el-select>
        </el-form-item>
        <el-form-item label="证书编号" prop="certificateNo">
          <el-input v-model="form.certificateNo" placeholder="请输入证书编号" />
        </el-form-item>
        <el-form-item label="证书附件URL" prop="certificateUrl">
          <el-input v-model="form.certificateUrl" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="是否删除" prop="delFlag">
          <el-select v-model="form.delFlag" placeholder="请选择状态" style="width: 100%">
            <el-option label="正常" :value="0" />
            <el-option label="已删除" :value="1" />
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
    <!-- 字段配置对话框 -->
    <FieldConfigDialog v-model:visible="fieldConfigVisible" :field-config-manager="fieldConfigManager" @confirm="handleFieldConfigConfirm" />
    <!-- 搜索配置对话框 -->
    <SearchConfigDialog v-model:visible="searchConfigVisible" :search-config-manager="searchConfigManager" @confirm="handleSearchConfigConfirm" />
  </div>
</template>

<script setup name="DoctorEducation" lang="ts">
import { listDoctorEducation, getDoctorEducation, delDoctorEducation, addDoctorEducation, updateDoctorEducation } from '@/api/doctor/doctorEducation';
import { listDoctorBasicInfo } from '@/api/doctor/doctorBasicInfo';
import { DoctorBasicInfoVO } from '@/api/doctor/doctorBasicInfo/types';
import { DoctorEducationVO, DoctorEducationQuery, DoctorEducationForm } from '@/api/doctor/doctorEducation/types';
import FieldConfigDialog from '@/components/FieldConfigDialog.vue';
import { createDoctorEducationFieldConfig } from '@/utils/configs/doctor/doctorFieldConfigs';
import { FieldConfigManager } from '@/utils/configs/fieldConfigManager';
import DynamicSearchForm from '@/components/DynamicSearchForm.vue';
import SearchConfigDialog from '@/components/SearchConfigDialog.vue';
import RightToolbar from '@/components/RightToolbar/index.vue';
import Pagination from '@/components/Pagination/index.vue';
import { createDoctorEducationSearchConfig } from '@/utils/configs/doctor/doctorSearchConfigs';
import { SearchConfigManager } from '@/utils/configs/searchConfigManager';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const doctorEducationList = ref<DoctorEducationVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const doctorEducationFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: DoctorEducationForm = {
  id: undefined,
  doctorId: undefined,
  schoolName: undefined,
  major: undefined,
  educationLevel: undefined,
  degree: undefined,
  startDate: undefined,
  endDate: undefined,
  isFullTime: undefined,
  certificateNo: undefined,
  certificateUrl: undefined,
  remark: undefined,
  delFlag: undefined
};

const queryParams = reactive<DoctorEducationQuery>({
  pageNum: 1,
  pageSize: 10,
  doctorId: undefined,
  schoolName: undefined,
  major: undefined,
  educationLevel: undefined,
  degree: undefined,
  startDate: undefined,
  endDate: undefined,
  isFullTime: undefined,
  certificateNo: undefined,
  certificateUrl: undefined,
  delFlag: undefined,
  params: {}
});

const form = reactive<DoctorEducationForm>({ ...initFormData });

const rules = {
  doctorId: [{ required: true, message: '医生ID不能为空', trigger: 'change' }]
};

// 医生选项
const doctorOptions = ref<DoctorBasicInfoVO[]>([]);

// 字段配置管理器
const fieldConfigManager = createDoctorEducationFieldConfig();
const searchConfigManager = createDoctorEducationSearchConfig();
const visibleSearchFields = computed(() => searchConfigManager.getVisibleFields());

// 配置对话框状态
const fieldConfigVisible = ref(false);
const searchConfigVisible = ref(false);

/** 查询医师学历列表 */
const getList = async () => {
  loading.value = true;
  try {
    const res = await listDoctorEducation(queryParams);
    doctorEducationList.value = res.rows;
    total.value = res.total;
  } catch (error) {
    console.error('获取教育经历列表失败:', error);
  } finally {
    loading.value = false;
  }
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
  doctorEducationFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: DoctorEducationVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加医师学历';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: DoctorEducationVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getDoctorEducation(_id);
  Object.assign(form, res.data);
  dialog.visible = true;
  dialog.title = '修改医师学历';
};

/** 提交按钮 */
const submitForm = () => {
  doctorEducationFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.id) {
        await updateDoctorEducation(form).finally(() => (buttonLoading.value = false));
      } else {
        await addDoctorEducation(form).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: DoctorEducationVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除医师学历编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delDoctorEducation(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/doctorEducation/export',
    {
      ...queryParams
    },
    `doctorEducation_${new Date().getTime()}.xlsx`
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

.doctor-education-table {
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
