<template>
  <div class="p-2">
    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <div v-show="showSearch" class="mb-[10px]">
        <el-card shadow="hover">
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

    <el-card shadow="never">
      <template #header>
        <el-row :gutter="10" class="mb8">
          <el-col :span="1.5">
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['system:qcIndicatorCollectionConfig:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button
              type="success"
              plain
              icon="Edit"
              :disabled="single"
              @click="handleUpdate()"
              v-hasPermi="['system:qcIndicatorCollectionConfig:edit']"
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
              v-hasPermi="['system:qcIndicatorCollectionConfig:remove']"
              >删除</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['system:qcIndicatorCollectionConfig:export']"
              >导出</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Setting" @click="showFieldConfig = true">字段配置</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="info" plain icon="Setting" @click="handleSearchConfig">搜索项配置</el-button>
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" border :data="qcIndicatorCollectionConfigList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column
          v-for="field in fieldConfigManager.visibleFields"
          :key="field.prop"
          :label="field.label"
          :prop="field.prop"
          :width="field.width"
          align="center"
        >
          <template #default="scope">
            <span v-if="field.prop === 'isRequired'">{{ scope.row.isRequired === '1' || scope.row.isRequired === 1 ? '是' : '否' }}</span>
            <span v-else-if="field.prop === 'delFlag'">{{ scope.row.delFlag === '1' || scope.row.delFlag === 1 ? '是' : '否' }}</span>
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
                v-hasPermi="['system:qcIndicatorCollectionConfig:edit']"
              ></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button
                link
                type="primary"
                icon="Delete"
                @click="handleDelete(scope.row)"
                v-hasPermi="['system:qcIndicatorCollectionConfig:remove']"
              ></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改质控指标数据采集配置对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="qcIndicatorCollectionConfigFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="指标ID" prop="indicatorId">
          <el-input v-model="form.indicatorId" placeholder="请输入指标ID" />
        </el-form-item>
        <el-form-item label="来源系统 HIS/EMR/LIS/PACS等" prop="sourceSystem">
          <el-input v-model="form.sourceSystem" placeholder="请输入来源系统 HIS/EMR/LIS/PACS等" />
        </el-form-item>
        <el-form-item label="来源表" prop="sourceTable">
          <el-input v-model="form.sourceTable" placeholder="请输入来源表" />
        </el-form-item>
        <el-form-item label="来源字段" prop="sourceField">
          <el-input v-model="form.sourceField" placeholder="请输入来源字段" />
        </el-form-item>
        <el-form-item label="提取规则" prop="extractionRule">
          <el-input v-model="form.extractionRule" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="是否必需 1-是 0-否" prop="isRequired">
          <el-select v-model="form.isRequired" placeholder="请选择是否必需">
            <el-option label="是" :value="1" />
            <el-option label="否" :value="0" />
          </el-select>
        </el-form-item>
        <el-form-item label="默认值" prop="defaultValue">
          <el-input v-model="form.defaultValue" placeholder="请输入默认值" />
        </el-form-item>
        <el-form-item label="校验规则" prop="validationRule">
          <el-input v-model="form.validationRule" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="是否删除" prop="delFlag">
          <el-select v-model="form.delFlag" placeholder="请选择是否删除">
            <el-option label="是" :value="1" />
            <el-option label="否" :value="0" />
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
    <SearchConfigDialog v-model="searchConfigVisible" :search-config-manager="searchConfigManager" @confirm="handleSearchConfigConfirm" />
    <FieldConfigDialog v-model="showFieldConfig" :field-config-manager="fieldConfigManager" @confirm="handleFieldConfigConfirm" />
  </div>
</template>

<script setup name="QcIndicatorCollectionConfig" lang="ts">
import {
  listQcIndicatorCollectionConfig,
  getQcIndicatorCollectionConfig,
  delQcIndicatorCollectionConfig,
  addQcIndicatorCollectionConfig,
  updateQcIndicatorCollectionConfig
} from '@/api/qc/qcIndicatorCollectionConfig';
import {
  QcIndicatorCollectionConfigVO,
  QcIndicatorCollectionConfigQuery,
  QcIndicatorCollectionConfigForm
} from '@/api/qc/qcIndicatorCollectionConfig/types';
import SearchConfigDialog from '@/components/SearchConfigDialog.vue';
import { createQcIndicatorCollectionConfigSearchConfig } from '@/utils/mmpSearchConfigs';
import FieldConfigDialog from '@/components/FieldConfigDialog.vue';
import { createQcIndicatorCollectionConfigFieldConfig } from '@/utils/mmpFieldConfigs';
import DynamicSearchForm from '@/components/DynamicSearchForm.vue';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const qcIndicatorCollectionConfigList = ref<QcIndicatorCollectionConfigVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref();
const qcIndicatorCollectionConfigFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});
const searchConfigManager = createQcIndicatorCollectionConfigSearchConfig();
const searchConfigVisible = ref(false);
const showFieldConfig = ref(false);
const fieldConfigManager = createQcIndicatorCollectionConfigFieldConfig();
const visibleSearchFields = computed(() => searchConfigManager.getVisibleFields());

const initFormData: QcIndicatorCollectionConfigForm = {
  id: undefined,
  indicatorId: undefined,
  sourceSystem: undefined,
  sourceTable: undefined,
  sourceField: undefined,
  extractionRule: undefined,
  dataType: undefined,
  isRequired: undefined,
  defaultValue: undefined,
  validationRule: undefined,
  delFlag: undefined
};
const data = reactive<PageData<QcIndicatorCollectionConfigForm, QcIndicatorCollectionConfigQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    indicatorId: undefined,
    sourceSystem: undefined,
    sourceTable: undefined,
    sourceField: undefined,
    extractionRule: undefined,
    dataType: undefined,
    isRequired: undefined,
    defaultValue: undefined,
    validationRule: undefined,
    delFlag: undefined,
    params: {}
  },
  rules: {
    id: [{ required: true, message: '主键ID不能为空', trigger: 'blur' }],
    indicatorId: [{ required: true, message: '指标ID不能为空', trigger: 'blur' }]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询质控指标数据采集配置列表 */
const getList = async () => {
  loading.value = true;
  const res = await listQcIndicatorCollectionConfig(queryParams.value);
  qcIndicatorCollectionConfigList.value = res.rows;
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
  qcIndicatorCollectionConfigFormRef.value?.resetFields();
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
const handleSearchConfig = () => {
  searchConfigVisible.value = true;
};
const handleSearchConfigConfirm = () => {
  searchConfigVisible.value = false;
};
const handleFieldConfigConfirm = () => {
  showFieldConfig.value = false;
};

/** 多选框选中数据 */
const handleSelectionChange = (selection: QcIndicatorCollectionConfigVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加质控指标数据采集配置';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: QcIndicatorCollectionConfigVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getQcIndicatorCollectionConfig(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改质控指标数据采集配置';
};

/** 提交按钮 */
const submitForm = () => {
  qcIndicatorCollectionConfigFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateQcIndicatorCollectionConfig(form.value).finally(() => (buttonLoading.value = false));
      } else {
        await addQcIndicatorCollectionConfig(form.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: QcIndicatorCollectionConfigVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除质控指标数据采集配置编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delQcIndicatorCollectionConfig(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/qcIndicatorCollectionConfig/export',
    {
      ...queryParams.value
    },
    `qcIndicatorCollectionConfig_${new Date().getTime()}.xlsx`
  );
};

onMounted(() => {
  getList();
});
</script>
