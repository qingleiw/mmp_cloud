<template>
  <div class="app-container">
    <!-- 页面标题 -->
    <div class="page-header mb-4">
      <h2 class="page-title">
        <i-ep-alarm-light class="title-icon"></i-ep-alarm-light>
        突发事件管理
      </h2>
      <p class="page-description">管理系统突发事件的报告、处理和跟踪等全流程</p>
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
            <span>突发事件列表</span>
            <el-tag type="info" size="small" class="ml-2">{{ total }} 条记录</el-tag>
          </div>
          <div class="table-actions">
            <el-button type="primary" icon="Plus" @click="handleAdd" v-hasPermi="['emergency:emergencyEvent:add']" class="action-btn">
              <span>新增</span>
            </el-button>
            <el-button type="success" icon="Edit" :disabled="single" @click="handleUpdate()" v-hasPermi="['emergency:emergencyEvent:edit']" class="action-btn">
              <span>修改</span>
            </el-button>
            <el-button type="danger" icon="Delete" :disabled="multiple" @click="handleDelete()" v-hasPermi="['emergency:emergencyEvent:remove']" class="action-btn">
              <span>删除</span>
            </el-button>
            <el-button type="warning" icon="Download" @click="handleExport" v-hasPermi="['emergency:emergencyEvent:export']" class="action-btn">
              <span>导出</span>
            </el-button>
            <el-button text type="primary" @click="handleFieldConfig" class="config-btn">
              <i-ep-setting class="btn-icon"></i-ep-setting>
              字段配置
            </el-button>
            <el-button text type="primary" @click="handleSearchConfig" class="config-btn">
              <i-ep-setting class="btn-icon"></i-ep-setting>
              搜索项配置
            </el-button>
            <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
          </div>
        </div>
      </template>

      <!-- 动态表格 -->
      <el-table
        v-loading="loading"
        border
        :data="emergencyEventList"
        @selection-change="handleSelectionChange"
        class="dynamic-table"
      >
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column
          v-for="field in visibleTableFields"
          :key="field.prop"
          :label="field.label"
          :prop="field.prop"
          :width="field.width"
          align="center"
          :show-overflow-tooltip="true"
        >
          <template #default="scope">
            <span v-if="field.type === 'datetime'">
              {{ parseTime(scope.row[field.prop], '{y}-{m}-{d} {h}:{i}') }}
            </span>
            <span v-else-if="field.type === 'date'">
              {{ parseTime(scope.row[field.prop], '{y}-{m}-{d}') }}
            </span>
            <span v-else>
              {{ scope.row[field.prop] }}
            </span>
          </template>
        </el-table-column>
        <el-table-column label="操作" align="center" fixed="right" class-name="small-padding fixed-width" width="120">
          <template #default="scope">
            <el-tooltip content="修改" placement="top">
              <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['emergency:emergencyEvent:edit']"></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button
                link
                type="primary"
                icon="Delete"
                @click="handleDelete(scope.row)"
                v-hasPermi="['emergency:emergencyEvent:remove']"
              ></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>

    <!-- 动态表单对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="800px" append-to-body class="dynamic-dialog">
      <DynamicForm
        ref="formRef"
        :model="form"
        :visible-fields="visibleFormFields"
        :rules="rules"
        @submit="submitForm"
        @cancel="cancel"
      />
    </el-dialog>

    <!-- 搜索配置对话框 -->
    <SearchConfigDialog
      v-model:visible="searchConfigVisible"
      :config-manager="searchConfigManager"
      @confirm="handleSearchConfigConfirm"
    />

    <!-- 字段配置对话框 -->
    <FieldConfigDialog
      v-model:visible="fieldConfigVisible"
      :config-manager="fieldConfigManager"
      @confirm="handleFieldConfigConfirm"
    />
  </div>
</template>

<script setup name="EmergencyEvent" lang="ts">
import { listEmergencyEvent, getEmergencyEvent, delEmergencyEvent, addEmergencyEvent, updateEmergencyEvent } from '@/api/emergency/emergencyEvent';
import { EmergencyEventVO, EmergencyEventQuery, EmergencyEventForm } from '@/api/emergency/emergencyEvent/types';
import { createEmergencyEventFieldConfig } from '@/utils/configs/emergency/emergencyFieldConfigs';
import FieldConfigDialog from '@/components/FieldConfigDialog.vue';
import DynamicSearchForm from '@/components/DynamicSearchForm.vue';
import SearchConfigDialog from '@/components/SearchConfigDialog.vue';
import { createEmergencyEventSearchConfig } from '@/utils/configs/emergency/emergencySearchConfigs';
import type { FormInstance } from 'element-plus';
import type { DialogOption } from '@/types/global';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const emergencyEventList = ref<EmergencyEventVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<FormInstance>();
const formRef = ref<FormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

// 字段配置相关变量
const fieldConfigManager = createEmergencyEventFieldConfig();
fieldConfigManager.clearConfig();
const fieldConfigVisible = ref(false);
const searchConfigManager = createEmergencyEventSearchConfig();
const searchConfigVisible = ref(false);

// 计算属性：获取可见的搜索字段
const visibleSearchFields = computed(() => searchConfigManager.getVisibleFields());

// 计算属性：获取可见的表格字段
const visibleTableFields = computed(() => fieldConfigManager.getVisibleFields());

// 计算属性：获取可见的表单字段
const visibleFormFields = computed(() => fieldConfigManager.getVisibleFields());

const queryParams = reactive<EmergencyEventQuery>({
  pageNum: 1,
  pageSize: 10,
  eventCode: undefined,
  eventTitle: undefined,
  eventType: undefined,
  eventLevel: undefined,
  occurrenceTime: undefined,
  discoveryTime: undefined,
  reportTime: undefined,
  reporter: undefined,
  location: undefined,
  affectedPersons: undefined,
  eventDescription: undefined,
  immediateMeasures: undefined,
  status: undefined,
  params: {}
});

const initFormData: EmergencyEventForm = {
  id: undefined,
  eventCode: undefined,
  eventTitle: undefined,
  eventType: undefined,
  eventLevel: undefined,
  occurrenceTime: undefined,
  discoveryTime: undefined,
  reportTime: undefined,
  reporter: undefined,
  location: undefined,
  affectedPersons: undefined,
  eventDescription: undefined,
  immediateMeasures: undefined,
  status: undefined,
  remark: undefined
};

const form = reactive<EmergencyEventForm>({ ...initFormData });

const rules = {
  eventCode: [{ required: true, message: '事件编码不能为空', trigger: 'blur' }],
  eventTitle: [{ required: true, message: '事件标题不能为空', trigger: 'blur' }],
  occurrenceTime: [{ required: true, message: '发生时间不能为空', trigger: 'blur' }],
  eventDescription: [{ required: true, message: '事件描述不能为空', trigger: 'blur' }]
};

/** 查询突发事件记录列表 */
const getList = async () => {
  loading.value = true;
  try {
    const res = await listEmergencyEvent(queryParams);
    emergencyEventList.value = res.rows;
    total.value = res.total;
  } catch (error) {
    console.error('获取突发事件列表失败:', error);
  } finally {
    loading.value = false;
  }
};

/** 取消按钮 */
const cancel = () => {
  reset();
  dialog.visible = false;
};

/** 表单重置 */
const reset = () => {
  Object.assign(form, initFormData);
  formRef.value?.resetFields();
};

/** 搜索按钮操作 */
const handleQuery = () => {
  queryParams.pageNum = 1;
  getList();
};

/** 重置按钮操作 */
const resetQuery = () => {
  queryFormRef.value?.resetFields();
  // 重置查询参数
  Object.keys(queryParams).forEach(key => {
    if (key !== 'pageNum' && key !== 'pageSize' && key !== 'params') {
      (queryParams as any)[key] = undefined;
    }
  });
  handleQuery();
};

/** 多选框选中数据 */
const handleSelectionChange = (selection: EmergencyEventVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length !== 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加突发事件记录';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: EmergencyEventVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  if (_id) {
    try {
      const res = await getEmergencyEvent(_id);
      Object.assign(form, res.data);
      dialog.visible = true;
      dialog.title = '修改突发事件记录';
    } catch (error) {
      console.error('获取突发事件详情失败:', error);
      proxy?.$modal.msgError('获取数据失败');
    }
  }
};

/** 提交按钮 */
const submitForm = async () => {
  try {
    buttonLoading.value = true;
    if (form.id) {
      await updateEmergencyEvent(form);
      proxy?.$modal.msgSuccess('修改成功');
    } else {
      await addEmergencyEvent(form);
      proxy?.$modal.msgSuccess('新增成功');
    }
    dialog.visible = false;
    await getList();
  } catch (error) {
    console.error('提交表单失败:', error);
  } finally {
    buttonLoading.value = false;
  }
};

/** 删除按钮操作 */
const handleDelete = async (row?: EmergencyEventVO) => {
  const _ids = row?.id || ids.value;
  try {
    await proxy?.$modal.confirm('是否确认删除突发事件记录编号为"' + _ids + '"的数据项？');
    await delEmergencyEvent(_ids);
    proxy?.$modal.msgSuccess('删除成功');
    await getList();
  } catch (error) {
    if (error !== 'cancel') {
      console.error('删除失败:', error);
    }
  }
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/emergencyEvent/export',
    {
      ...queryParams
    },
    `emergencyEvent_${new Date().getTime()}.xlsx`
  );
};

/** 搜索配置 */
const handleSearchConfig = () => {
  searchConfigVisible.value = true;
};

/** 字段配置 */
const handleFieldConfig = () => {
  fieldConfigVisible.value = true;
};

/** 搜索配置确认 */
const handleSearchConfigConfirm = () => {
  searchConfigVisible.value = false;
};

/** 字段配置确认 */
const handleFieldConfigConfirm = () => {
  fieldConfigVisible.value = false;
};

onMounted(() => {
  getList();
});
</script>
