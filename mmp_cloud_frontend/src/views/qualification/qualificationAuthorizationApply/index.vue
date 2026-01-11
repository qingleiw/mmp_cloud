<template>
  <div class="p-2">
    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <div v-show="showSearch" class="mb-[10px]">
        <el-card shadow="hover">
          <template #header>
            <div class="flex items-center justify-between">
              <div class="flex items-center gap-2">
                <el-icon><Search /></el-icon>
                <span>搜索条件</span>
              </div>
              <el-button type="info" text :icon="Setting" @click="handleSearchConfig">搜索项配置</el-button>
            </div>
          </template>
          <DynamicSearchForm
            ref="queryFormRef"
            :query="queryParams"
            :visible-fields="visibleSearchFields"
            @search="handleQuery"
            @reset="resetQuery"
          />
          <!-- 原查询表单已替换 -->
          <!--
          <el-form ref="queryFormRef" :model="queryParams" :inline="true">
            <el-form-item label="申请单号" prop="applyNo">
              <el-input v-model="queryParams.applyNo" placeholder="请输入申请单号" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="申请人ID" prop="applicantId">
              <el-input v-model="queryParams.applicantId" placeholder="请输入申请人ID" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="申请人姓名" prop="applicantName">
              <el-input v-model="queryParams.applicantName" placeholder="请输入申请人姓名" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="科室ID" prop="departmentId">
              <el-input v-model="queryParams.departmentId" placeholder="请输入科室ID" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="科室名称" prop="departmentName">
              <el-input v-model="queryParams.departmentName" placeholder="请输入科室名称" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="资质ID列表(逗号分隔)" prop="qualificationIds">
              <el-input v-model="queryParams.qualificationIds" placeholder="请输入资质ID列表(逗号分隔)" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="申请理由" prop="applyReason">
              <el-input v-model="queryParams.applyReason" placeholder="请输入申请理由" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="关联证书ID" prop="certificateIds">
              <el-input v-model="queryParams.certificateIds" placeholder="请输入关联证书ID" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="考核成绩" prop="examScore">
              <el-input v-model="queryParams.examScore" placeholder="请输入考核成绩" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="工作量数据JSON" prop="workQuantity">
              <el-input v-model="queryParams.workQuantity" placeholder="请输入工作量数据JSON" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="工作质量数据JSON" prop="workQuality">
              <el-input v-model="queryParams.workQuality" placeholder="请输入工作质量数据JSON" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="当前审批节点" prop="currentNode">
              <el-input v-model="queryParams.currentNode" placeholder="请输入当前审批节点" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="工作流实例ID" prop="workflowInstanceId">
              <el-input v-model="queryParams.workflowInstanceId" placeholder="请输入工作流实例ID" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="是否删除" prop="delFlag">
              <el-input v-model="queryParams.delFlag" placeholder="请输入是否删除" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item>
              <el-button type="primary" icon="Search" @click="handleQuery">搜索</el-button>
              <el-button icon="Refresh" @click="resetQuery">重置</el-button>
            </el-form-item>
          </el-form>
          -->
        </el-card>
      </div>
    </transition>

    <el-card shadow="never">
      <template #header>
        <div class="mb8 flex items-center gap-2 flex-nowrap">
          <el-icon><List /></el-icon>
          <span class="font-medium">申请记录列表</span>
          <span class="text-[12px] text-gray-500">{{ total }} 条记录</span>
          <div class="ml-auto flex items-center gap-2">
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['system:qualificationAuthorizationApply:add']"
              >新增</el-button
            >
            <el-button
              type="success"
              plain
              icon="Edit"
              :disabled="single"
              @click="handleUpdate()"
              v-hasPermi="['system:qualificationAuthorizationApply:edit']"
              >修改</el-button
            >
            <el-button
              type="danger"
              plain
              icon="Delete"
              :disabled="multiple"
              @click="handleDelete()"
              v-hasPermi="['system:qualificationAuthorizationApply:remove']"
              >删除</el-button
            >
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['system:qualificationAuthorizationApply:export']"
              >导出</el-button
            >
            <el-button type="info" plain icon="Setting" @click="showFieldConfig = true">字段配置</el-button>
            <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
          </div>
        </div>
      </template>

      <el-table v-loading="loading" border :data="qualificationAuthorizationApplyList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column
          v-for="field in visibleColumns"
          :key="field.prop"
          :label="field.label"
          align="center"
          :prop="field.prop"
          :width="field.width || undefined"
        >
          <template #default="scope">
            <span>{{ scope.row[field.prop] }}</span>
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
                v-hasPermi="['system:qualificationAuthorizationApply:edit']"
              ></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button
                link
                type="primary"
                icon="Delete"
                @click="handleDelete(scope.row)"
                v-hasPermi="['system:qualificationAuthorizationApply:remove']"
              ></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改资质授权申请对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="qualificationAuthorizationApplyFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="申请单号" prop="applyNo">
          <el-input v-model="form.applyNo" placeholder="请输入申请单号" />
        </el-form-item>
        <el-form-item label="申请人ID" prop="applicantId">
          <el-input v-model="form.applicantId" placeholder="请输入申请人ID" />
        </el-form-item>
        <el-form-item label="申请人姓名" prop="applicantName">
          <el-input v-model="form.applicantName" placeholder="请输入申请人姓名" />
        </el-form-item>
        <el-form-item label="科室ID" prop="departmentId">
          <el-input v-model="form.departmentId" placeholder="请输入科室ID" />
        </el-form-item>
        <el-form-item label="科室名称" prop="departmentName">
          <el-input v-model="form.departmentName" placeholder="请输入科室名称" />
        </el-form-item>
        <el-form-item label="资质ID列表(逗号分隔)" prop="qualificationIds">
          <el-input v-model="form.qualificationIds" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="申请理由" prop="applyReason">
          <el-input v-model="form.applyReason" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="关联证书ID" prop="certificateIds">
          <el-input v-model="form.certificateIds" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="考核成绩" prop="examScore">
          <el-input v-model="form.examScore" placeholder="请输入考核成绩" />
        </el-form-item>
        <el-form-item label="工作量数据JSON" prop="workQuantity">
          <el-input v-model="form.workQuantity" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="工作质量数据JSON" prop="workQuality">
          <el-input v-model="form.workQuality" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="当前审批节点" prop="currentNode">
          <el-input v-model="form.currentNode" placeholder="请输入当前审批节点" />
        </el-form-item>
        <el-form-item label="工作流实例ID" prop="workflowInstanceId">
          <el-input v-model="form.workflowInstanceId" placeholder="请输入工作流实例ID" />
        </el-form-item>
        <el-form-item label="是否删除" prop="delFlag">
          <el-input v-model="form.delFlag" placeholder="请输入是否删除" />
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
    <FieldConfigDialog v-model:visible="showFieldConfig" :field-config-manager="fieldConfigManager" @confirm="handleFieldConfigConfirm" />
    <SearchConfigDialog v-model="searchConfigVisible" :search-config-manager="searchConfigManager" @confirm="handleSearchConfigConfirm" />
  </div>
</template>

<script setup name="QualificationAuthorizationApply" lang="ts">
import {
  listQualificationAuthorizationApply,
  getQualificationAuthorizationApply,
  delQualificationAuthorizationApply,
  addQualificationAuthorizationApply,
  updateQualificationAuthorizationApply
} from '@/api/qualification/qualificationAuthorizationApply';
import {
  QualificationAuthorizationApplyVO,
  QualificationAuthorizationApplyQuery,
  QualificationAuthorizationApplyForm
} from '@/api/qualification/qualificationAuthorizationApply/types';
import { createQualificationAuthorizationApplyFieldConfig } from '@/utils/fieldConfig';
import FieldConfigDialog from '@/components/FieldConfigDialog.vue';
import DynamicSearchForm from '@/components/DynamicSearchForm.vue';
import SearchConfigDialog from '@/components/SearchConfigDialog.vue';
import { createQualificationAuthorizationApplySearchConfig } from '@/utils/mmpSearchConfigs';
import { Search, Setting, List } from '@element-plus/icons-vue';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const qualificationAuthorizationApplyList = ref<QualificationAuthorizationApplyVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const showFieldConfig = ref(false);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const qualificationAuthorizationApplyFormRef = ref<ElFormInstance>();

// 字段配置相关变量
const fieldConfigManager = createQualificationAuthorizationApplyFieldConfig();
const visibleColumns = computed(() => fieldConfigManager.getVisibleFields());
const searchConfigManager = createQualificationAuthorizationApplySearchConfig();
const searchConfigVisible = ref(false);
const visibleSearchFields = computed(() => searchConfigManager.getVisibleFields());

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: QualificationAuthorizationApplyForm = {
  id: undefined,
  applyNo: undefined,
  applicantId: undefined,
  applicantName: undefined,
  applicantType: undefined,
  departmentId: undefined,
  departmentName: undefined,
  qualificationIds: undefined,
  applyReason: undefined,
  certificateIds: undefined,
  examScore: undefined,
  workQuantity: undefined,
  workQuality: undefined,
  applyStatus: undefined,
  currentNode: undefined,
  workflowInstanceId: undefined,
  delFlag: undefined
};
const data = reactive<PageData<QualificationAuthorizationApplyForm, QualificationAuthorizationApplyQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    applyNo: undefined,
    applicantId: undefined,
    applicantName: undefined,
    applicantType: undefined,
    departmentId: undefined,
    departmentName: undefined,
    qualificationIds: undefined,
    applyReason: undefined,
    certificateIds: undefined,
    examScore: undefined,
    workQuantity: undefined,
    workQuality: undefined,
    applyStatus: undefined,
    currentNode: undefined,
    workflowInstanceId: undefined,
    delFlag: undefined,
    params: {}
  },
  rules: {
    id: [{ required: true, message: '主键ID不能为空', trigger: 'blur' }],
    applyNo: [{ required: true, message: '申请单号不能为空', trigger: 'blur' }],
    applicantId: [{ required: true, message: '申请人ID不能为空', trigger: 'blur' }]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询资质授权申请列表 */
const getList = async () => {
  loading.value = true;
  const res = await listQualificationAuthorizationApply(queryParams.value);
  qualificationAuthorizationApplyList.value = res.rows;
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
  qualificationAuthorizationApplyFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: QualificationAuthorizationApplyVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加资质授权申请';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: QualificationAuthorizationApplyVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getQualificationAuthorizationApply(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改资质授权申请';
};

/** 提交按钮 */
const submitForm = () => {
  qualificationAuthorizationApplyFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateQualificationAuthorizationApply(form.value).finally(() => (buttonLoading.value = false));
      } else {
        await addQualificationAuthorizationApply(form.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: QualificationAuthorizationApplyVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除资质授权申请编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delQualificationAuthorizationApply(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/qualificationAuthorizationApply/export',
    {
      ...queryParams.value
    },
    `qualificationAuthorizationApply_${new Date().getTime()}.xlsx`
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

onMounted(() => {
  getList();
});
</script>
