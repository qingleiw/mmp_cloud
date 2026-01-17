<template>
  <div class="app-container">
    <!-- 页面标题 -->
    <div class="page-header mb-4">
      <h2 class="page-title">
        <i-ep-clock class="title-icon"></i-ep-clock>
        使用记录管理
      </h2>
      <p class="page-description">管理资质使用记录和统计</p>
    </div>













    <!-- 动态搜索表单 -->
    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <div v-show="showSearch" class="search-container mb-4" class="search-container mb-4">
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
          <template #header>
            <div class="flex items-center justify-between">
              <div class="flex items-center gap-2">
                <i-ep-search class="search-icon"></i-ep-search>
                <span>搜索条件</span>
              </div>
              <el-button text type="primary" @click="toggleSearchConfig">
                <i-ep-setting class="btn-icon"></i-ep-setting>
                搜索配置
              </el-button>
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
        <div class="mb8 flex items-center gap-2 flex-nowrap">
          <i-ep-list class="table-icon"></i-ep-list>
          <span class="font-medium">资质使用记录列表</span>
          <el-tag type="info" size="small" class="ml-2">{{ total }} 条记录</el-tag>
          <div class="ml-auto flex items-center gap-2">
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['qualification:qualificationUsageRecord:add']"
              >新增</el-button
            >
            <el-button
              type="success"
              plain
              icon="Edit"
              :disabled="single"
              @click="handleUpdate()"
              v-hasPermi="['qualification:qualificationUsageRecord:edit']"
              >修改</el-button
            >
            <el-button
              type="danger"
              plain
              icon="Delete"
              :disabled="multiple"
              @click="handleDelete()"
              v-hasPermi="['qualification:qualificationUsageRecord:remove']"
              >删除</el-button
            >
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['qualification:qualificationUsageRecord:export']"
              >导出</el-button
            >
            <el-button type="info" plain icon="Setting" @click="toggleFieldConfig">字段配置</el-button>
            <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
          </div>
        </div>
      </template>

      <el-table v-loading="loading" border :data="qualificationUsageRecordList" @selection-change="handleSelectionChange" class="data-table">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column
          v-for="field in fieldConfigManager.visibleFields"
          :key="field.prop"
          :label="field.label"
          :prop="field.prop"
          :width="field.width"
          :min-width="field.minWidth || 120"
          resizable
          align="center"
        >
          <template #default="scope">
            <!-- 使用结果状态标签 -->
            <el-tag v-if="field.prop === 'usageResult'" :type="getUsageResultTagType(scope.row[field.prop])" size="small">
              {{ getUsageResultLabel(scope.row[field.prop]) }}
            </el-tag>
            <!-- 是否超权限状态标签 -->
            <el-tag v-else-if="field.prop === 'isOverAuthority'" :type="getOverAuthorityTagType(scope.row[field.prop])" size="small">
              {{ getOverAuthorityLabel(scope.row[field.prop]) }}
            </el-tag>
            <!-- 日期格式化 -->
            <span v-else-if="field.prop === 'usageDate'">{{ parseTime(scope.row[field.prop], '{y}-{m}-{d}') }}</span>
            <!-- 默认显示 -->
            <span v-else>{{ scope.row[field.prop] }}</span>
          </template>
        </el-table-column>
        <el-table-column label="操作" align="center" fixed="right" class-name="small-padding fixed-width" width="120">
          <template #default="scope">
            <el-tooltip v-if="false" content="修改" placement="top">
              <el-button
                link
                type="primary"
                icon="Edit"
                @click="handleUpdate(scope.row)"
                v-hasPermi="['qualification:qualificationUsageRecord:edit']"
              ></el-button>
            </el-tooltip>
            <el-tooltip v-if="false" content="删除" placement="top">
              <el-button
                link
                type="primary"
                icon="Delete"
                @click="handleDelete(scope.row)"
                v-hasPermi="['qualification:qualificationUsageRecord:remove']"
              ></el-button>
            </el-tooltip>
            <el-button link type="primary" @click="handleView(scope.row)">
              <i-ep-view class="btn-icon"></i-ep-view>
              查看
            </el-button>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改资质使用记录对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="700px" append-to-body>
      <el-form ref="qualificationUsageRecordFormRef" :model="form" :rules="rules" label-width="120px">
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="授权记录ID" prop="authorizationId">
              <el-input v-model="form.authorizationId" placeholder="请输入授权记录ID" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="人员ID" prop="staffId">
              <el-input v-model="form.staffId" placeholder="请输入人员ID" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="资质ID" prop="qualificationId">
              <el-input v-model="form.qualificationId" placeholder="请输入资质ID" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="使用时间" prop="usageDate">
              <el-date-picker
                clearable
                v-model="form.usageDate"
                type="datetime"
                value-format="YYYY-MM-DD HH:mm:ss"
                placeholder="请选择使用时间"
                style="width: 100%"
              >
              </el-date-picker>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="患者ID" prop="patientId">
              <el-input v-model="form.patientId" placeholder="请输入患者ID" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="患者姓名" prop="patientName">
              <el-input v-model="form.patientName" placeholder="请输入患者姓名" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="操作编码" prop="operationCode">
              <el-input v-model="form.operationCode" placeholder="请输入操作编码" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="操作名称" prop="operationName">
              <el-input v-model="form.operationName" placeholder="请输入操作名称" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="20">
          <el-col :span="8">
            <el-form-item label="使用结果" prop="usageResult">
              <el-select v-model="form.usageResult" placeholder="请选择使用结果" style="width: 100%">
                <el-option label="正常" value="正常" />
                <el-option label="异常" value="异常" />
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="是否超权限" prop="isOverAuthority">
              <el-select v-model="form.isOverAuthority" placeholder="请选择是否超权限" style="width: 100%">
                <el-option label="是" value="1" />
                <el-option label="否" value="0" />
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="来源系统" prop="sourceSystem">
              <el-input v-model="form.sourceSystem" placeholder="请输入来源系统" />
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

    <FieldConfigDialog v-model:visible="showFieldConfig" :field-config-manager="fieldConfigManager" @confirm="handleFieldConfigConfirm" />
    <SearchConfigDialog v-model="showSearchConfig" :search-config-manager="searchConfigManager" @confirm="handleSearchConfigConfirm" />
  </div>
</template>

<script setup name="QualificationUsageRecord" lang="ts">
import {
  listQualificationUsageRecord,
  getQualificationUsageRecord,
  delQualificationUsageRecord,
  addQualificationUsageRecord,
  updateQualificationUsageRecord
} from '@/api/qualification/qualificationUsageRecord';
import {
  QualificationUsageRecordVO,
  QualificationUsageRecordQuery,
  QualificationUsageRecordForm
} from '@/api/qualification/qualificationUsageRecord/types';
import { createQualificationUsageRecordFieldConfig } from '@/utils/configs/qualification/FieldConfigs';
import { createQualificationUsageRecordSearchConfig } from '@/utils/configs/qualification/SearchConfigs';
import DynamicSearchForm from '@/components/DynamicSearchForm.vue';
import FieldConfigDialog from '@/components/FieldConfigDialog.vue';
import SearchConfigDialog from '@/components/SearchConfigDialog.vue';


const searchConfigVisible = ref(false);
const fieldConfigVisible = ref(false);



const handleSearchConfig = () => {
  searchConfigVisible.value = true;
};

const handleFieldConfig = () => {
  fieldConfigVisible.value = true;
};

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const qualificationUsageRecordList = ref<QualificationUsageRecordVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const showFieldConfig = ref(false);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const fieldConfigManager = createQualificationUsageRecordFieldConfig();
const searchConfigManager = createQualificationUsageRecordSearchConfig();

const queryFormRef = ref<ElFormInstance>();
const qualificationUsageRecordFormRef = ref<ElFormInstance>();

// 搜索和字段配置相关
const showSearchConfig = ref(false);
const visibleSearchFields = computed(() => searchConfigManager.getVisibleFields());

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: QualificationUsageRecordForm = {
  id: undefined,
  authorizationId: undefined,
  staffId: undefined,
  qualificationId: undefined,
  usageDate: undefined,
  patientId: undefined,
  patientName: undefined,
  operationCode: undefined,
  operationName: undefined,
  usageResult: undefined,
  isOverAuthority: undefined,
  sourceSystem: undefined
};
const data = reactive<PageData<QualificationUsageRecordForm, QualificationUsageRecordQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    authorizationId: undefined,
    staffId: undefined,
    qualificationId: undefined,
    usageDate: undefined,
    patientId: undefined,
    patientName: undefined,
    operationCode: undefined,
    operationName: undefined,
    usageResult: undefined,
    isOverAuthority: undefined,
    sourceSystem: undefined,
    params: {}
  },
  rules: {
    authorizationId: [{ required: true, message: '授权记录ID不能为空', trigger: 'blur' }],
    staffId: [{ required: true, message: '人员ID不能为空', trigger: 'blur' }],
    qualificationId: [{ required: true, message: '资质ID不能为空', trigger: 'blur' }]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 切换搜索配置对话框 */
const toggleSearchConfig = () => {
  showSearchConfig.value = !showSearchConfig.value;
};

/** 切换字段配置对话框 */
const toggleFieldConfig = () => {
  showFieldConfig.value = !showFieldConfig.value;
};

/** 获取使用结果标签类型 */
const getUsageResultTagType = (value: string) => {
  return value === '正常' ? 'success' : 'danger';
};

/** 获取使用结果标签文本 */
const getUsageResultLabel = (value: string) => {
  return value || '未知';
};

/** 获取超权限标签类型 */
const getOverAuthorityTagType = (value: string) => {
  return value === '1' ? 'warning' : 'info';
};

/** 获取超权限标签文本 */
const getOverAuthorityLabel = (value: string) => {
  return value === '1' ? '是' : value === '0' ? '否' : '未知';
};

/** 查看详情 */
const handleView = (row: QualificationUsageRecordVO) => {
  proxy?.$modal.alert(`查看资质使用记录：${row.id}`);
};

/** 查询资质使用记录列表 */
const getList = async () => {
  loading.value = true;
  const res = await listQualificationUsageRecord(queryParams.value);
  qualificationUsageRecordList.value = res.rows;
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
  qualificationUsageRecordFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: QualificationUsageRecordVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加资质使用记录';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: QualificationUsageRecordVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getQualificationUsageRecord(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改资质使用记录';
};

/** 提交按钮 */
const submitForm = () => {
  qualificationUsageRecordFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateQualificationUsageRecord(form.value).finally(() => (buttonLoading.value = false));
      } else {
        await addQualificationUsageRecord(form.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: QualificationUsageRecordVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除资质使用记录编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delQualificationUsageRecord(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导入按钮操作占位 */
const handleImport = () => {};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/qualificationUsageRecord/export',
    {
      ...queryParams.value
    },
    `qualificationUsageRecord_${new Date().getTime()}.xlsx`
  );
};

/** 字段配置确认 */
const handleFieldConfigConfirm = () => {
  showFieldConfig.value = false;
};

/** 搜索配置确认 */
const handleSearchConfigConfirm = () => {
  showSearchConfig.value = false;
};

onMounted(() => {
  getList();
});
</script>
