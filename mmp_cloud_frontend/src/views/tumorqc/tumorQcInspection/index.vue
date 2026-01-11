<template>
  <div class="app-container">
    <div class="page-header mb-4">
      <h2 class="page-title">
        <i-ep-search class="title-icon"></i-ep-search>
        肿瘤质控检查记录管理
      </h2>
      <p class="page-description">管理肿瘤质控检查记录，包括检查时间、检查人、结果与问题描述等</p>
    </div>
    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <div v-show="showSearch" class="mb-[10px]">
        <el-card shadow="hover" class="search-card">
          <template #header>
            <div class="search-header">
              <span class="search-title">
                <i-ep-search class="search-icon"></i-ep-search>
                搜索条件
              </span>
              <div class="search-actions">
                <el-button text type="primary" @click="searchConfigVisible = true" class="config-btn">
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

    <el-card shadow="never" class="table-card">
      <template #header>
        <div class="table-header">
          <div class="table-title">
            <i-ep-list class="table-icon"></i-ep-list>
            检查记录列表
            <el-tag type="info" size="small" class="ml-2">{{ total }} 条记录</el-tag>
          </div>
          <div class="table-actions">
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['system:tumorQcInspection:add']">新增</el-button>
            <el-button type="success" plain icon="Edit" :disabled="single" @click="handleUpdate()" v-hasPermi="['system:tumorQcInspection:edit']">修改</el-button>
            <el-button type="danger" plain icon="Delete" :disabled="multiple" @click="handleDelete()" v-hasPermi="['system:tumorQcInspection:remove']">删除</el-button>
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['system:tumorQcInspection:export']">导出</el-button>
            <el-button type="warning" plain icon="Setting" @click="showFieldConfig = true">字段配置</el-button>
            <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
          </div>
        </div>
      </template>

      <el-table v-loading="loading" border :data="tumorQcInspectionList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column
          v-for="field in fieldConfigManager.getVisibleFields()"
          :key="field.prop"
          :label="field.label"
          :prop="field.prop"
          :width="field.width"
          align="center"
        >
          <template #default="scope">
            <span v-if="field.prop === 'inspectionDate'">{{ parseTime(scope.row[field.prop], '{y}-{m}-{d}') }}</span>
            <span v-else>{{ scope.row[field.prop] }}</span>
          </template>
        </el-table-column>
        <el-table-column label="操作" align="center" fixed="right"  class-name="small-padding fixed-width">
          <template #default="scope">
            <el-tooltip content="修改" placement="top">
              <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['system:tumorQcInspection:edit']"></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)" v-hasPermi="['system:tumorQcInspection:remove']"></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改肿瘤质控检查对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="tumorQcInspectionFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="检查编码" prop="inspectionCode">
          <el-input v-model="form.inspectionCode" placeholder="请输入检查编码" />
        </el-form-item>
        <el-form-item label="关联方案ID" prop="planId">
          <el-input v-model="form.planId" placeholder="请输入关联方案ID" />
        </el-form-item>
        <el-form-item label="检查日期" prop="inspectionDate">
          <el-date-picker clearable
            v-model="form.inspectionDate"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择检查日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="检查人ID" prop="inspectorId">
          <el-input v-model="form.inspectorId" placeholder="请输入检查人ID" />
        </el-form-item>
        <el-form-item label="检查人姓名" prop="inspectorName">
          <el-input v-model="form.inspectorName" placeholder="请输入检查人姓名" />
        </el-form-item>
        <el-form-item label="检查科室ID" prop="departmentId">
          <el-input v-model="form.departmentId" placeholder="请输入检查科室ID" />
        </el-form-item>
        <el-form-item label="检查科室名称" prop="departmentName">
          <el-input v-model="form.departmentName" placeholder="请输入检查科室名称" />
        </el-form-item>
        <el-form-item label="检查结果" prop="inspectionResult">
            <el-input v-model="form.inspectionResult" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="问题描述" prop="problemDescription">
            <el-input v-model="form.problemDescription" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="整改建议" prop="suggestion">
            <el-input v-model="form.suggestion" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="删除标志" prop="delFlag">
          <el-input v-model="form.delFlag" placeholder="请输入删除标志" />
        </el-form-item>
      </el-form>
      <template #footer>
        <div class="dialog-footer">
          <el-button :loading="buttonLoading" type="primary" @click="submitForm">确 定</el-button>
          <el-button @click="cancel">取 消</el-button>
        </div>
      </template>
    </el-dialog>
    <FieldConfigDialog v-model:visible="showFieldConfig" :field-config-manager="fieldConfigManager" @confirm="() => (showFieldConfig = false)" />
    <SearchConfigDialog v-model="searchConfigVisible" :search-config-manager="searchConfigManager" @confirm="() => (searchConfigVisible = false)" />
  </div>
</template>

<script setup name="TumorQcInspection" lang="ts">
import { listTumorQcInspection, getTumorQcInspection, delTumorQcInspection, addTumorQcInspection, updateTumorQcInspection } from '@/api/tumorqc/tumorQcInspection';
import { TumorQcInspectionVO, TumorQcInspectionQuery, TumorQcInspectionForm } from '@/api/tumorqc/tumorQcInspection/types';
import FieldConfigDialog from '@/components/FieldConfigDialog.vue';
import { createTumorQcInspectionFieldConfig } from '@/utils/mmpFieldConfigs';
import SearchConfigDialog from '@/components/SearchConfigDialog.vue';
import { createTumorQcInspectionSearchConfig } from '@/utils/mmpSearchConfigs';
import DynamicSearchForm from '@/components/DynamicSearchForm.vue';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const tumorQcInspectionList = ref<TumorQcInspectionVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref();
const tumorQcInspectionFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});
const showFieldConfig = ref(false);
const fieldConfigManager = createTumorQcInspectionFieldConfig();
const searchConfigVisible = ref(false);
const searchConfigManager = createTumorQcInspectionSearchConfig();
const visibleSearchFields = computed(() => searchConfigManager.getVisibleFields());

const initFormData: TumorQcInspectionForm = {
  id: undefined,
  inspectionCode: undefined,
  planId: undefined,
  inspectionDate: undefined,
  inspectorId: undefined,
  inspectorName: undefined,
  departmentId: undefined,
  departmentName: undefined,
  inspectionType: undefined,
  inspectionResult: undefined,
  problemDescription: undefined,
  suggestion: undefined,
  status: undefined,
  delFlag: undefined
}
const data = reactive<PageData<TumorQcInspectionForm, TumorQcInspectionQuery>>({
  form: {...initFormData},
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    inspectionCode: undefined,
    inspectionDate: undefined,
    inspectorName: undefined,
    departmentName: undefined,
    inspectionType: undefined,
    inspectionResult: undefined,
    problemDescription: undefined,
    suggestion: undefined,
    status: undefined,
    delFlag: undefined,
    params: {
    }
  },
  rules: {
    id: [
      { required: true, message: "主键ID不能为空", trigger: "blur" }
    ],
    inspectionCode: [
      { required: true, message: "检查编码不能为空", trigger: "blur" }
    ],
    inspectionDate: [
      { required: true, message: "检查日期不能为空", trigger: "blur" }
    ],
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询肿瘤质控检查列表 */
const getList = async () => {
  loading.value = true;
  const res = await listTumorQcInspection(queryParams.value);
  tumorQcInspectionList.value = res.rows;
  total.value = res.total;
  loading.value = false;
}

/** 取消按钮 */
const cancel = () => {
  reset();
  dialog.visible = false;
}

/** 表单重置 */
const reset = () => {
  form.value = {...initFormData};
  tumorQcInspectionFormRef.value?.resetFields();
}

/** 搜索按钮操作 */
const handleQuery = () => {
  queryParams.value.pageNum = 1;
  getList();
}

/** 重置按钮操作 */
const resetQuery = () => {
  queryFormRef.value?.resetFields();
  handleQuery();
}

/** 多选框选中数据 */
const handleSelectionChange = (selection: TumorQcInspectionVO[]) => {
  ids.value = selection.map(item => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
}

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = "添加肿瘤质控检查";
}

/** 修改按钮操作 */
const handleUpdate = async (row?: TumorQcInspectionVO) => {
  reset();
  const _id = row?.id || ids.value[0]
  const res = await getTumorQcInspection(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = "修改肿瘤质控检查";
}

/** 提交按钮 */
const submitForm = () => {
  tumorQcInspectionFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateTumorQcInspection(form.value).finally(() =>  buttonLoading.value = false);
      } else {
        await addTumorQcInspection(form.value).finally(() =>  buttonLoading.value = false);
      }
      proxy?.$modal.msgSuccess("操作成功");
      dialog.visible = false;
      await getList();
    }
  });
}

/** 删除按钮操作 */
const handleDelete = async (row?: TumorQcInspectionVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除肿瘤质控检查编号为"' + _ids + '"的数据项？').finally(() => loading.value = false);
  await delTumorQcInspection(_ids);
  proxy?.$modal.msgSuccess("删除成功");
  await getList();
}

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download('system/tumorQcInspection/export', {
    ...queryParams.value
  }, `tumorQcInspection_${new Date().getTime()}.xlsx`)
}

onMounted(() => {
  getList();
});
</script>
<style scoped>
.page-header .page-description {
  font-size: 13px;
  color: #86909c;
  line-height: 1.6;
}
.search-card .search-header {
  display: flex;
  align-items: center;
  justify-content: space-between;
  min-height: 44px;
}
.search-card .search-title {
  display: inline-flex;
  align-items: center;
  gap: 8px;
}
.table-card {
  background: #fff;
  border-radius: 8px;
  padding: 12px;
}
.table-header {
  display: flex;
  align-items: center;
  gap: 12px;
  min-height: 44px;
  padding: 6px 8px;
}
.table-title {
  display: inline-flex;
  align-items: center;
  gap: 8px;
}
.table-actions {
  margin-left: auto;
  display: inline-flex;
  align-items: center;
  gap: 8px;
  flex-wrap: nowrap;
}
</style>
