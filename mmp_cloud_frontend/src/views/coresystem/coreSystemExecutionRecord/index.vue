<template>
  <div class="app-container">
    <!-- 页面标题 -->
    <div class="page-header mb-4">
      <h2 class="page-title">
        <i-ep-setting class="title-icon"></i-ep-setting>
        核心制度执行记录管理
      </h2>
      <p class="page-description">管理系统核心制度的执行记录，包括执行结果、执行时间和执行人等信息</p>
    </div>

    <!-- 动态搜索表单 -->
    <transition :enter-active-class="animate.searchAnimate.enter" :leave-active-class="animate.searchAnimate.leave">
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
            <span>执行记录列表</span>
            <el-tag type="info" size="small" class="ml-2">{{ total }} 条记录</el-tag>
          </div>
          <div class="table-actions">
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['coresystem:coreSystemExecutionRecord:add']" size="small"
              >新增</el-button
            >
            <el-button
              type="success"
              plain
              icon="Edit"
              :disabled="single"
              @click="handleUpdate()"
              v-hasPermi="['coresystem:coreSystemExecutionRecord:edit']"
              size="small"
              >修改</el-button
            >
            <el-button
              type="danger"
              plain
              icon="Delete"
              :disabled="multiple"
              @click="handleDelete()"
              v-hasPermi="['coresystem:coreSystemExecutionRecord:remove']"
              size="small"
              >删除</el-button
            >
            <el-button
              type="warning"
              plain
              icon="Download"
              @click="handleExport"
              v-hasPermi="['coresystem:coreSystemExecutionRecord:export']"
              size="small"
              >导出</el-button
            >
            <el-button text type="primary" @click="showFieldConfig = true" class="config-btn">
              <i-ep-setting class="btn-icon"></i-ep-setting>
              字段配置
            </el-button>
            <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
          </div>
        </div>
      </template>

      <el-table v-loading="loading" border :data="coreSystemExecutionRecordList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column
          v-for="field in visibleColumns"
          :key="field.prop"
          :label="field.label"
          :prop="field.prop"
          :width="field.width"
          :min-width="field.minWidth || 120"
          resizable
          align="center"
        >
          <template #default="scope">
            <span v-if="field.prop === 'executionTime'">{{ parseTime(scope.row[field.prop], '{y}-{m}-{d}') }}</span>
            <el-tag v-else-if="field.prop === 'executionResult'" :type="scope.row[field.prop] === 1 ? 'success' : 'danger'">
              {{ scope.row[field.prop] === 1 ? '成功' : '失败' }}
            </el-tag>
            <el-tag v-else-if="field.prop === 'delFlag'" :type="scope.row[field.prop] === 0 ? 'success' : 'danger'">
              {{ scope.row[field.prop] === 0 ? '未删除' : '已删除' }}
            </el-tag>
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
                v-hasPermi="['coresystem:coreSystemExecutionRecord:edit']"
              ></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button
                link
                type="primary"
                icon="Delete"
                @click="handleDelete(scope.row)"
                v-hasPermi="['coresystem:coreSystemExecutionRecord:remove']"
              ></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改制度执行记录对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="600px" append-to-body>
      <el-form ref="coreSystemExecutionRecordFormRef" :model="form" :rules="rules" label-width="100px">
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
            <el-form-item label="执行人ID" prop="executorId">
              <el-input v-model="form.executorId" placeholder="请输入执行人ID" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="执行人姓名" prop="executorName">
              <el-input v-model="form.executorName" placeholder="请输入执行人姓名" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="执行时间" prop="executionTime">
              <el-date-picker
                clearable
                v-model="form.executionTime"
                type="datetime"
                value-format="YYYY-MM-DD HH:mm:ss"
                placeholder="请选择执行时间"
                style="width: 100%"
              >
              </el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="执行结果" prop="executionResult">
              <el-select v-model="form.executionResult" placeholder="请选择执行结果" style="width: 100%">
                <el-option label="成功" :value="1" />
                <el-option label="失败" :value="0" />
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="20">
          <el-col :span="24">
            <el-form-item label="备注" prop="remark">
              <el-input v-model="form.remark" type="textarea" :rows="4" placeholder="请输入备注内容" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="是否删除" prop="delFlag">
              <el-select v-model="form.delFlag" placeholder="请选择状态" style="width: 100%">
                <el-option label="未删除" :value="0" />
                <el-option label="已删除" :value="1" />
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
    <FieldConfigDialog v-model:visible="showFieldConfig" :field-config-manager="fieldConfigManager" @confirm="() => (showFieldConfig = false)" />
    <!-- 搜索配置对话框 -->
    <SearchConfigDialog v-model="searchConfigVisible" :search-config-manager="searchConfigManager" />
  </div>
</template>

<script setup name="CoreSystemExecutionRecord" lang="ts">
import {
  listCoreSystemExecutionRecord,
  getCoreSystemExecutionRecord,
  delCoreSystemExecutionRecord,
  addCoreSystemExecutionRecord,
  updateCoreSystemExecutionRecord
} from '@/api/coresystem/coreSystemExecutionRecord';
import {
  CoreSystemExecutionRecordVO,
  CoreSystemExecutionRecordQuery,
  CoreSystemExecutionRecordForm
} from '@/api/coresystem/coreSystemExecutionRecord/types';
import { createCoreSystemExecutionRecordFieldConfig } from '@/utils/configs/coresystem/FieldConfigs';
import FieldConfigDialog from '@/components/FieldConfigDialog.vue';
import SearchConfigDialog from '@/components/SearchConfigDialog.vue';
import { createCoreSystemExecutionRecordSearchConfig } from '@/utils/configs/coresystem/SearchConfigs';
import DynamicSearchForm from '@/components/DynamicSearchForm.vue';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;
const animate = proxy.animate;

const coreSystemExecutionRecordList = ref<CoreSystemExecutionRecordVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const coreSystemExecutionRecordFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});
const showFieldConfig = ref(false);
const fieldConfigManager = createCoreSystemExecutionRecordFieldConfig();
const searchConfigVisible = ref(false);
const searchConfigManager = createCoreSystemExecutionRecordSearchConfig();
const visibleSearchFields = computed(() => searchConfigManager.getVisibleFields());
const visibleColumns = computed(() => fieldConfigManager.getVisibleFields());

const initFormData: CoreSystemExecutionRecordForm = {
  executionId: undefined,
  systemId: undefined,
  systemName: undefined,
  executorId: undefined,
  executorName: undefined,
  executionTime: undefined,
  executionResult: undefined,
  remark: undefined,
  delFlag: undefined
};
const data = reactive<PageData<CoreSystemExecutionRecordForm, CoreSystemExecutionRecordQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    systemName: undefined,
    executorName: undefined,
    executionTime: undefined,
    executionResult: undefined,
    delFlag: undefined,
    params: {}
  },
  rules: {
    systemId: [{ required: true, message: '制度ID不能为空', trigger: 'blur' }],
    systemName: [{ required: true, message: '制度名称不能为空', trigger: 'blur' }],
    executorId: [{ required: true, message: '执行人ID不能为空', trigger: 'blur' }],
    executorName: [{ required: true, message: '执行人姓名不能为空', trigger: 'blur' }],
    executionTime: [{ required: true, message: '执行时间不能为空', trigger: 'blur' }],
    executionResult: [{ required: true, message: '执行结果不能为空', trigger: 'blur' }]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询制度执行记录列表 */
const getList = async () => {
  loading.value = true;
  const res = await listCoreSystemExecutionRecord(queryParams.value);
  coreSystemExecutionRecordList.value = res.rows;
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
  coreSystemExecutionRecordFormRef.value?.resetFields();
};

/** 搜索按钮操作 */
const handleQuery = () => {
  queryParams.value.pageNum = 1;
  getList();
};

/** 搜索配置 */
const handleSearchConfig = () => {
  searchConfigVisible.value = true;
};

/** 重置按钮操作 */
const resetQuery = () => {
  queryFormRef.value?.resetFields();
  handleQuery();
};

/** 多选框选中数据 */
const handleSelectionChange = (selection: CoreSystemExecutionRecordVO[]) => {
  ids.value = selection.map((item) => item.executionId);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加制度执行记录';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: CoreSystemExecutionRecordVO) => {
  reset();
  const _executionId = row?.executionId || ids.value[0];
  const res = await getCoreSystemExecutionRecord(_executionId);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改制度执行记录';
};

/** 提交按钮 */
const submitForm = () => {
  coreSystemExecutionRecordFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.executionId) {
        await updateCoreSystemExecutionRecord(form.value).finally(() => (buttonLoading.value = false));
      } else {
        await addCoreSystemExecutionRecord(form.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: CoreSystemExecutionRecordVO) => {
  const _executionIds = row?.executionId || ids.value;
  await proxy?.$modal.confirm('是否确认删除制度执行记录编号为"' + _executionIds + '"的数据项？').finally(() => (loading.value = false));
  await delCoreSystemExecutionRecord(_executionIds);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/coreSystemExecutionRecord/export',
    {
      ...queryParams.value
    },
    `coreSystemExecutionRecord_${new Date().getTime()}.xlsx`
  );
};

onMounted(() => {
  getList();
});
</script>
