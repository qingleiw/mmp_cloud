<template>
  <div class="p-2">
    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <div v-show="showSearch" class="mb-[10px]">
        <el-card shadow="hover">
          <DynamicSearchForm
            ref="searchFormRef"
            :search-config="searchConfig"
            :query-params="queryParams"
            @search="handleQuery"
            @reset="resetQuery"
          />
        </el-card>
      </div>
    </transition>

    <el-card shadow="never">
      <template #header>
        <el-row :gutter="10" class="mb8">
          <el-col :span="1.5">
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['emergency:emergencyEventTreatment:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button
              type="success"
              plain
              icon="Edit"
              :disabled="single"
              @click="handleUpdate()"
              v-hasPermi="['emergency:emergencyEventTreatment:edit']"
              >修改</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button
              type="danger"
              plain
              icon="Delete"
              :disabled="multiple"
              @click="handleDelete()"
              v-hasPermi="['emergency:emergencyEventTreatment:remove']"
              >删除</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['emergency:emergencyEventTreatment:export']"
              >导出</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button type="info" plain icon="Setting" @click="fieldConfigVisible = true">字段配置</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="info" plain icon="Setting" @click="searchConfigVisible = true">搜索项配置</el-button>
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" border :data="emergencyEventTreatmentList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column
          v-for="field in fieldConfig.getVisibleFields()"
          :key="field.prop"
          :label="field.label"
          :align="'center'"
          :prop="field.prop"
          :width="field.width"
          v-show="field.visible"
        >
          <template #default="scope">
            <span v-if="field.type === 'datetime'">{{ parseTime(scope.row[field.prop], '{y}-{m}-{d}') }}</span>
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
                v-hasPermi="['emergency:emergencyEventTreatment:edit']"
              ></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button
                link
                type="primary"
                icon="Delete"
                @click="handleDelete(scope.row)"
                v-hasPermi="['emergency:emergencyEventTreatment:remove']"
              ></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改突发事件治疗对话框 -->
    <FieldConfigDialog
      :title="dialog.title"
      v-model="dialog.visible"
      :field-config="fieldConfig"
      :form-data="form"
      :rules="rules"
      :loading="buttonLoading"
      @confirm="submitForm"
      @cancel="cancel"
    />

    <!-- 字段配置对话框 -->
    <FieldConfigDialog
      v-model="fieldConfigVisible"
      title="字段配置"
      :field-config="fieldConfig"
      :is-config-mode="true"
      @confirm="() => (fieldConfigVisible = false)"
    />

    <!-- 搜索项配置对话框 -->
    <SearchConfigDialog
      v-model="searchConfigVisible"
      :search-config="searchConfig"
      @confirm="() => (searchConfigVisible = false)"
    />
  </div>
</template>

<script setup name="EmergencyEventTreatment" lang="ts">
import {
  listEmergencyEventTreatment,
  getEmergencyEventTreatment,
  delEmergencyEventTreatment,
  addEmergencyEventTreatment,
  updateEmergencyEventTreatment
} from '@/api/emergency/emergencyEventTreatment';
import { EmergencyEventTreatmentVO, EmergencyEventTreatmentQuery, EmergencyEventTreatmentForm } from '@/api/emergency/emergencyEventTreatment/types';
import { createEmergencyEventTreatmentFieldConfig } from '@/utils/configs/emergency/emergencyFieldConfigs';
import { createEmergencyEventTreatmentSearchConfig } from '@/utils/configs/emergency/emergencySearchConfigs';
import DynamicSearchForm from '@/components/DynamicSearchForm.vue';
import FieldConfigDialog from '@/components/DynamicForm/FieldConfigDialog.vue';
import SearchConfigDialog from '@/components/SearchConfigDialog.vue';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const emergencyEventTreatmentList = ref<EmergencyEventTreatmentVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const searchFormRef = ref();
const fieldConfig = createEmergencyEventTreatmentFieldConfig();
const searchConfig = createEmergencyEventTreatmentSearchConfig();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

// 配置对话框状态
const fieldConfigVisible = ref(false);
const searchConfigVisible = ref(false);

const initFormData: EmergencyEventTreatmentForm = {
  id: undefined,
  eventId: undefined,
  patientId: undefined,
  patientName: undefined,
  diagnosis: undefined,
  treatmentMeasures: undefined,
  treatmentResult: undefined,
  treatingPhysician: undefined,
  treatmentTime: undefined,
  remark: undefined
};

const data = reactive<PageData<EmergencyEventTreatmentForm, EmergencyEventTreatmentQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    patientName: undefined,
    diagnosis: undefined,
    treatmentMeasures: undefined,
    treatmentResult: undefined,
    treatingPhysician: undefined,
    treatmentTime: undefined,
    params: {}
  },
  rules: {
    eventId: [{ required: true, message: '事件ID不能为空', trigger: 'blur' }],
    patientName: [{ required: true, message: '患者姓名不能为空', trigger: 'blur' }]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询突发事件治疗列表 */
const getList = async () => {
  loading.value = true;
  const res = await listEmergencyEventTreatment(queryParams.value);
  emergencyEventTreatmentList.value = res.rows;
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
};

/** 搜索按钮操作 */
const handleQuery = () => {
  queryParams.value.pageNum = 1;
  getList();
};

/** 重置按钮操作 */
const resetQuery = () => {
  searchFormRef.value?.resetFields();
  handleQuery();
};

/** 多选框选中数据 */
const handleSelectionChange = (selection: EmergencyEventTreatmentVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加突发事件治疗';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: EmergencyEventTreatmentVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getEmergencyEventTreatment(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改突发事件治疗';
};

/** 提交按钮 */
const submitForm = () => {
  if (form.value.id) {
    updateEmergencyEventTreatment(form.value).then(() => {
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      getList();
    });
  } else {
    addEmergencyEventTreatment(form.value).then(() => {
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      getList();
    });
  }
};

/** 删除按钮操作 */
const handleDelete = async (row?: EmergencyEventTreatmentVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除突发事件治疗编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delEmergencyEventTreatment(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/emergencyEventTreatment/export',
    {
      ...queryParams.value
    },
    `emergencyEventTreatment_${new Date().getTime()}.xlsx`
  );
};

onMounted(() => {
  getList();
});
</script>
