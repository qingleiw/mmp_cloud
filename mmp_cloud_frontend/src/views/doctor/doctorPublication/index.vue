<template>
  <div class="app-container">
    <!-- 页面标题 -->
    <div class="page-header mb-4">
      <h2 class="page-title">
        <i-ep-document-copy class="title-icon"></i-ep-document-copy>
        医师学术成果管理
      </h2>
      <p class="page-description">对医师学术论文、著作等出版物进行管理，包括发表信息、引用情况等</p>
    </div>

    <!-- 搜索表单 -->
    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <el-card v-if="showSearch" shadow="hover" class="search-card mb-4">
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
        <DynamicSearchForm ref="queryFormRef" :query="queryParams" :visible-fields="visibleSearchFields" @search="handleQuery" @reset="resetQuery" />
      </el-card>
    </transition>

    <!-- 数据表格 -->
    <el-card shadow="never" class="table-card">
      <template #header>
        <div class="table-header">
          <div class="table-title">
            <i-ep-list class="table-icon"></i-ep-list>
            <span>学术成果列表</span>
            <el-tag type="info" size="small" class="ml-2">{{ total }} 条记录</el-tag>
          </div>
          <div class="table-actions">
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['doctor:doctorPublication:add']" size="small">新增</el-button>
            <el-button
              type="success"
              plain
              icon="Edit"
              :disabled="single"
              @click="handleUpdate()"
              v-hasPermi="['doctor:doctorPublication:edit']"
              size="small">修改</el-button>
            <el-button
              type="danger"
              plain
              icon="Delete"
              :disabled="multiple"
              @click="handleDelete()"
              v-hasPermi="['doctor:doctorPublication:remove']"
              size="small">删除</el-button>
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['doctor:doctorPublication:export']" size="small">导出</el-button>
            <el-button type="primary" plain icon="Upload" @click="handleImport" v-hasPermi="['doctor:doctorPublication:import']" size="small">导入</el-button>
            <el-button text type="primary" @click="handleFieldConfig" class="config-btn">
              <i-ep-setting class="btn-icon"></i-ep-setting>
              字段配置
            </el-button>
            <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
          </div>
        </div>
      </template>

      <el-table v-loading="loading" border :data="doctorPublicationList" @selection-change="handleSelectionChange" class="doctor-publication-table">
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
          <template #default="scope" v-if="field.prop === 'publishDate' || field.prop === 'createTime' || field.prop === 'updateTime'">
            <span>{{ parseTime(scope.row[field.prop], '{y}-{m}-{d}') }}</span>
          </template>
          <template #default="scope" v-else-if="field.prop === 'delFlag'">
            <el-tag :type="scope.row[field.prop] === '0' ? 'success' : 'danger'">
              {{ scope.row[field.prop] === '0' ? '否' : '是' }}
            </el-tag>
          </template>
          <template #default="scope" v-else>
            {{ scope.row[field.prop] }}
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
                v-hasPermi="['doctor:doctorPublication:edit']"
              ></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button
                link
                type="primary"
                icon="Delete"
                @click="handleDelete(scope.row)"
                v-hasPermi="['doctor:doctorPublication:remove']"
              ></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改医师学术成果对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="800px" append-to-body>
      <DynamicForm ref="formRef" :form-data="form" :field-config="formFieldConfig" :rules="rules" @submit="submitForm" />
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

<script setup name="DoctorPublication" lang="ts">
import {
  listDoctorPublication,
  getDoctorPublication,
  delDoctorPublication,
  addDoctorPublication,
  updateDoctorPublication
} from '@/api/doctor/doctorPublication';
import { listDoctorBasicInfo } from '@/api/doctor/doctorBasicInfo';
import { DoctorBasicInfoVO } from '@/api/doctor/doctorBasicInfo/types';
import { DoctorPublicationVO, DoctorPublicationQuery, DoctorPublicationForm } from '@/api/doctor/doctorPublication/types';
import { createDoctorPublicationFieldConfig } from '@/utils/configs/doctor/doctorFieldConfigs';
import { FieldConfigManager } from '@/utils/configs/fieldConfigManager';
import FieldConfigDialog from '@/components/FieldConfigDialog.vue';
import DynamicSearchForm from '@/components/DynamicSearchForm.vue';
import SearchConfigDialog from '@/components/SearchConfigDialog.vue';
import RightToolbar from '@/components/RightToolbar/index.vue';
import Pagination from '@/components/Pagination/index.vue';
import { createDoctorPublicationSearchConfig } from '@/utils/configs/doctor/doctorSearchConfigs';
import { parseTime } from '@/utils/ruoyi';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const doctorPublicationList = ref<DoctorPublicationVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const showFieldConfig = ref(false);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);
const doctorOptions = ref<DoctorBasicInfoVO[]>([]);

const queryFormRef = ref<ElFormInstance>();
const doctorPublicationFormRef = ref<ElFormInstance>();

// 字段配置相关变量
const fieldConfigManager = createDoctorPublicationFieldConfig();

// 初始化时清除之前的字段配置和localStorage缓存，确保新配置生效
fieldConfigManager.clearConfig();
localStorage.removeItem('doctorPublication_field_config');

// 计算可见列
const visibleColumns = computed(() => {
  return fieldConfigManager.getVisibleFields();
});
const searchConfigManager = createDoctorPublicationSearchConfig();
const searchConfigVisible = ref(false);
const visibleSearchFields = computed(() => searchConfigManager.getVisibleFields());

// 表单字段配置
const formFieldConfig = computed(() => fieldConfigManager.getFieldGroups().flatMap((group) => group.fields));

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: DoctorPublicationForm = {
  id: undefined,
  doctorId: undefined,
  publicationType: undefined,
  title: undefined,
  authors: undefined,
  authorOrder: undefined,
  journalName: undefined,
  publishDate: undefined,
  volume: undefined,
  issue: undefined,
  pages: undefined,
  doi: undefined,
  impactFactor: undefined,
  citationCount: undefined,
  fullTextUrl: undefined,
  delFlag: undefined
};
const data = reactive<PageData<DoctorPublicationForm, DoctorPublicationQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    doctorId: undefined,
    publicationType: undefined,
    title: undefined,
    authors: undefined,
    authorOrder: undefined,
    journalName: undefined,
    publishDate: undefined,
    volume: undefined,
    issue: undefined,
    pages: undefined,
    doi: undefined,
    impactFactor: undefined,
    citationCount: undefined,
    fullTextUrl: undefined,
    delFlag: undefined,
    params: {}
  },
  rules: {
    id: [{ required: true, message: '主键ID不能为空', trigger: 'blur' }],
    doctorId: [{ required: true, message: '医生ID不能为空', trigger: 'blur' }]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 加载医生选项 */
const loadDoctorOptions = async () => {
  try {
    const res = await listDoctorBasicInfo({});
    doctorOptions.value = res.rows;
  } catch (error) {
    console.error('加载医生选项失败:', error);
  }
};

/** 获取医生姓名 */
const getDoctorName = (doctorId: number | string | undefined): string => {
  if (!doctorId) return '';
  const doctor = doctorOptions.value.find((d) => d.id === doctorId);
  return doctor ? doctor.doctorName : `医生ID: ${doctorId}`;
};

/** 查询论文论著列表 */
const getList = async () => {
  loading.value = true;
  const res = await listDoctorPublication(queryParams.value);
  doctorPublicationList.value = res.rows;
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
  doctorPublicationFormRef.value?.resetFields();
};

/** 搜索按钮操作 */
const handleQuery = () => {
  // 处理daterange字段
  if (queryParams.publicationDate && Array.isArray(queryParams.publicationDate)) {
    queryParams.publicationDateStart = queryParams.publicationDate[0];
    queryParams.publicationDateEnd = queryParams.publicationDate[1];
  } else {
    queryParams.publicationDateStart = undefined;
    queryParams.publicationDateEnd = undefined;
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
const handleSelectionChange = (selection: DoctorPublicationVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加论文论著';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: DoctorPublicationVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getDoctorPublication(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改论文论著';
};

/** 提交按钮 */
const submitForm = async () => {
  buttonLoading.value = true;
  try {
    if (form.value.id) {
      await updateDoctorPublication(form.value);
    } else {
      await addDoctorPublication(form.value);
    }
    proxy?.$modal.msgSuccess('操作成功');
    dialog.visible = false;
    await getList();
  } catch (error) {
    console.error('提交失败:', error);
  } finally {
    buttonLoading.value = false;
  }
};

/** 删除按钮操作 */
const handleDelete = async (row?: DoctorPublicationVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除论文论著编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delDoctorPublication(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/doctorPublication/export',
    {
      ...queryParams.value
    },
    `doctorPublication_${new Date().getTime()}.xlsx`
  );
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

/** 字段配置按钮操作 */
const handleFieldConfig = () => {
  showFieldConfig.value = true;
};

/** 导入按钮操作 */
const handleImport = () => {
  proxy?.$modal.msgInfo('导入功能开发中...');
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

// 页面标题样式
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

// 搜索卡片样式
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
      color: #303133;
      display: flex;
      align-items: center;
      gap: 6px;

      .search-icon {
        color: #409eff;
        font-size: 18px;
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

  :deep(.el-card__header) {
    background-color: #fafafa;
    border-bottom: 1px solid #ebeef5;
    padding: 16px 20px;
  }

  :deep(.el-card__body) {
    padding: 20px;
  }
}

// 表格卡片样式
.table-card {
  border-radius: 8px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);

  .table-header {
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 16px 20px;
    background-color: #fafafa;
    border-bottom: 1px solid #ebeef5;

    .table-title {
      display: flex;
      align-items: center;
      gap: 8px;
      font-size: 16px;
      font-weight: 500;
      color: #303133;

      .table-icon {
        color: #67c23a;
        font-size: 18px;
      }

      .ml-2 {
        margin-left: 8px;
      }
    }

    .table-actions {
      display: flex;
      gap: 8px;
      align-items: center;
    }
  }

  :deep(.el-card__body) {
    padding: 0;
  }
}

// 表格样式
:deep(.el-table) {
  .el-table__header th {
    background-color: #fafafa;
    font-weight: 600;
    color: #1d2129;
  }

  .el-table__row {
    &:hover {
      background-color: #f5f7fa;
    }
  }
}

// 按钮样式
:deep(.el-button) {
  border-radius: 4px;
}

// 表单样式
:deep(.el-form-item) {
  margin-bottom: 20px;

  .el-form-item__label {
    font-weight: 500;
    color: #606266;
  }
}

// 响应式设计
@media (max-width: 768px) {
  .app-container {
    padding: 10px;
  }

  .page-header {
    .page-title {
      font-size: 20px;
    }
  }

  .table-header {
    flex-direction: column;
    gap: 12px;
    align-items: flex-start !important;

    .table-actions {
      flex-wrap: wrap;
      width: 100%;

      .el-button {
        flex: 1;
        min-width: 80px;
      }
    }
  }

  .search-card :deep(.el-card__body) {
    padding: 16px;
  }
}
</style>
