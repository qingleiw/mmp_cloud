<template>
  <div class="app-container">
    <!-- 页面标题 -->
    <div class="page-header mb-4">
      <h2 class="page-title">
        <i-ep-search class="title-icon"></i-ep-search>
        核心制度检查记录管理
      </h2>
      <p class="page-description">管理系统核心制度的检查记录，包括检查结果、问题描述和整改建议等</p>
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
            <span>检查记录列表</span>
            <el-tag type="info" size="small" class="ml-2">{{ total }} 条记录</el-tag>
          </div>
          <div class="table-actions">
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['system:coreSystemInspectionRecord:add']" size="small"
              >新增</el-button
            >
            <el-button
              type="success"
              plain
              icon="Edit"
              :disabled="single"
              @click="handleUpdate()"
              v-hasPermi="['system:coreSystemInspectionRecord:edit']"
              size="small"
              >修改</el-button
            >
            <el-button
              type="danger"
              plain
              icon="Delete"
              :disabled="multiple"
              @click="handleDelete()"
              v-hasPermi="['system:coreSystemInspectionRecord:remove']"
              size="small"
              >删除</el-button
            >
            <el-button
              type="warning"
              plain
              icon="Download"
              @click="handleExport"
              v-hasPermi="['system:coreSystemInspectionRecord:export']"
              size="small"
              >导出</el-button
            >
            <el-button type="info" plain icon="Setting" @click="handleFieldConfig" size="small">字段配置</el-button>
            <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
          </div>
        </div>
      </template>

      <el-table v-loading="loading" border :data="coreSystemInspectionRecordList" @selection-change="handleSelectionChange">
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
            <span v-if="field.prop === 'inspectionTime'">
              {{ parseTime(scope.row[field.prop], '{y}-{m}-{d}') }}
            </span>
            <!-- 检查结果字段 -->
            <el-tag v-else-if="field.prop === 'inspectionResult'" :type="scope.row[field.prop] === '1' ? 'success' : 'danger'">
              {{ scope.row[field.prop] === '1' ? '合格' : '不合格' }}
            </el-tag>
            <!-- 删除标志字段 -->
            <el-tag v-else-if="field.prop === 'delFlag'" :type="scope.row[field.prop] === '0' ? 'success' : 'danger'">
              {{ scope.row[field.prop] === '0' ? '未删除' : '已删除' }}
            </el-tag>
            <!-- 时间字段格式化 -->
            <span v-else-if="field.prop === 'createTime' || field.prop === 'updateTime'">
              {{ parseTime(scope.row[field.prop], '{y}-{m}-{d} {h}:{i}') }}
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
                v-hasPermi="['system:coreSystemInspectionRecord:edit']"
              ></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button
                link
                type="primary"
                icon="Delete"
                @click="handleDelete(scope.row)"
                v-hasPermi="['system:coreSystemInspectionRecord:remove']"
              ></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改制度检查记录对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="700px" append-to-body>
      <el-form ref="coreSystemInspectionRecordFormRef" :model="form" :rules="rules" label-width="100px">
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="制度ID" prop="systemId">
              <el-input v-model="form.systemId" placeholder="请输入制度ID" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="制度名称" prop="systemName">
              <el-input v-model="form.systemName" placeholder="请输入制度名称" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="检查人ID" prop="inspectorId">
              <el-input v-model="form.inspectorId" placeholder="请输入检查人ID" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="检查人姓名" prop="inspectorName">
              <el-input v-model="form.inspectorName" placeholder="请输入检查人姓名" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="检查时间" prop="inspectionTime">
              <el-date-picker
                clearable
                v-model="form.inspectionTime"
                type="datetime"
                value-format="YYYY-MM-DD HH:mm:ss"
                placeholder="请选择检查时间"
                style="width: 100%"
              >
              </el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="检查结果" prop="inspectionResult">
              <el-select v-model="form.inspectionResult" placeholder="请选择检查结果" style="width: 100%">
                <el-option label="合格" :value="'1'" />
                <el-option label="不合格" :value="'0'" />
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="问题描述" prop="problemDescription">
              <el-input v-model="form.problemDescription" type="textarea" :rows="4" placeholder="请输入问题描述" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="整改建议" prop="rectificationSuggestion">
              <el-input v-model="form.rectificationSuggestion" type="textarea" :rows="4" placeholder="请输入整改建议" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="是否删除" prop="delFlag">
              <el-select v-model="form.delFlag" placeholder="请选择状态" style="width: 100%">
                <el-option label="未删除" :value="'0'" />
                <el-option label="已删除" :value="'1'" />
              </el-select>
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
    <SearchConfigDialog v-model="searchConfigVisible" :search-config-manager="searchConfigManager" />
  </div>
</template>

<script setup name="CoreSystemInspectionRecord" lang="ts">
import { ref, reactive, computed, onMounted, getCurrentInstance, toRefs } from 'vue';
import { FormInstance } from 'element-plus';
import {
  listCoreSystemInspectionRecord,
  getCoreSystemInspectionRecord,
  delCoreSystemInspectionRecord,
  addCoreSystemInspectionRecord,
  updateCoreSystemInspectionRecord
} from '@/api/system/coreSystemInspectionRecord';
import {
  CoreSystemInspectionRecordVO,
  CoreSystemInspectionRecordQuery,
  CoreSystemInspectionRecordForm
} from '@/api/system/coreSystemInspectionRecord/types';
import { createCoreSystemInspectionRecordFieldConfig } from '@/utils/mmpFieldConfigs';
import FieldConfigDialog from '@/components/FieldConfigDialog.vue';
import SearchConfigDialog from '@/components/SearchConfigDialog.vue';
import DynamicSearchForm from '@/components/DynamicSearchForm.vue';
import { createCoreSystemInspectionRecordSearchConfig } from '@/utils/mmpSearchConfigs';

// Simple parseTime implementation
const parseTime = (time: any, pattern?: string) => {
  if (!time) return '';
  const date = new Date(time);
  if (pattern === '{y}-{m}-{d}') {
    return date.toLocaleDateString();
  }
  return date.toLocaleString();
};

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const coreSystemInspectionRecordList = ref<CoreSystemInspectionRecordVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<FormInstance>();
const coreSystemInspectionRecordFormRef = ref<FormInstance>();

// 字段配置相关
const fieldConfigManager = createCoreSystemInspectionRecordFieldConfig();
const showFieldConfig = ref(false);
// 搜索配置相关
const searchConfigVisible = ref(false);
const searchConfigManager = createCoreSystemInspectionRecordSearchConfig();
const visibleSearchFields = computed(() => searchConfigManager.getVisibleFields());

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: CoreSystemInspectionRecordForm = {
  id: undefined,
  systemId: undefined,
  systemName: undefined,
  inspectorId: undefined,
  inspectorName: undefined,
  inspectionTime: undefined,
  inspectionResult: undefined,
  problemDescription: undefined,
  rectificationSuggestion: undefined,
  delFlag: undefined
};
const data = reactive<PageData<CoreSystemInspectionRecordForm, CoreSystemInspectionRecordQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    systemName: undefined,
    inspectorName: undefined,
    inspectionTime: undefined,
    inspectionResult: undefined,
    problemDescription: undefined,
    rectificationSuggestion: undefined,
    delFlag: undefined,
    params: {}
  },
  rules: {
    systemId: [{ required: true, message: '制度ID不能为空', trigger: 'blur' }],
    systemName: [{ required: true, message: '制度名称不能为空', trigger: 'blur' }],
    inspectorId: [{ required: true, message: '检查人ID不能为空', trigger: 'blur' }],
    inspectorName: [{ required: true, message: '检查人姓名不能为空', trigger: 'blur' }],
    inspectionTime: [{ required: true, message: '检查时间不能为空', trigger: 'blur' }],
    inspectionResult: [{ required: true, message: '检查结果不能为空', trigger: 'blur' }]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询制度检查记录列表 */
const getList = async () => {
  loading.value = true;
  const res = await listCoreSystemInspectionRecord(queryParams.value);
  coreSystemInspectionRecordList.value = res.rows;
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
  coreSystemInspectionRecordFormRef.value?.resetFields();
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
/** 搜索配置 */
const handleSearchConfig = () => {
  searchConfigVisible.value = true;
};

/** 多选框选中数据 */
const handleSelectionChange = (selection: CoreSystemInspectionRecordVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加制度检查记录';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: CoreSystemInspectionRecordVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getCoreSystemInspectionRecord(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改制度检查记录';
};

/** 提交按钮 */
const submitForm = () => {
  coreSystemInspectionRecordFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateCoreSystemInspectionRecord(form.value).finally(() => (buttonLoading.value = false));
      } else {
        await addCoreSystemInspectionRecord(form.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: CoreSystemInspectionRecordVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除制度检查记录编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delCoreSystemInspectionRecord(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/coreSystemInspectionRecord/export',
    {
      ...queryParams.value
    },
    `coreSystemInspectionRecord_${new Date().getTime()}.xlsx`
  );
};

/** 字段配置操作 */
const handleFieldConfig = () => {
  showFieldConfig.value = true;
};

/** 字段配置确认操作 */
const handleFieldConfigConfirm = () => {
  showFieldConfig.value = false;
  // 配置更新后可以在这里添加额外的逻辑，比如重新获取数据等
};

onMounted(() => {
  getList();
});
</script>
