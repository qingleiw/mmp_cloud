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
        </el-card>
      </div>
    </transition>

    <el-card shadow="never">
      <template #header>
        <div class="mb8 flex items-center gap-2 flex-nowrap">
          <el-icon><List /></el-icon>
          <span class="font-medium">资质授权记录列表</span>
          <span class="text-[12px] text-gray-500">{{ total }} 条记录</span>
          <div class="ml-auto flex items-center gap-2">
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['qualification:qualificationAuthorizationRecord:add']"
              >新增</el-button
            >
            <el-button
              type="success"
              plain
              icon="Edit"
              :disabled="single"
              @click="handleUpdate()"
              v-hasPermi="['qualification:qualificationAuthorizationRecord:edit']"
              >修改</el-button
            >
            <el-button
              type="danger"
              plain
              icon="Delete"
              :disabled="multiple"
              @click="handleDelete()"
              v-hasPermi="['qualification:qualificationAuthorizationRecord:remove']"
              >删除</el-button
            >
            <el-button
              type="warning"
              plain
              icon="Download"
              @click="handleExport"
              v-hasPermi="['qualification:qualificationAuthorizationRecord:export']"
              >导出</el-button
            >
            <el-button type="info" plain icon="Setting" @click="showFieldConfig = true">字段配置</el-button>
            <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
          </div>
        </div>
      </template>

      <el-table v-loading="loading" border :data="qualificationAuthorizationRecordList" @selection-change="handleSelectionChange">
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
            <span v-if="field.prop === 'validStartDate' || field.prop === 'validEndDate'">
              {{ parseTime(scope.row[field.prop], '{y}-{m}-{d}') }}
            </span>
            <span v-else>
              {{ scope.row[field.prop] }}
            </span>
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
                v-hasPermi="['qualification:qualificationAuthorizationRecord:edit']"
              ></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button
                link
                type="primary"
                icon="Delete"
                @click="handleDelete(scope.row)"
                v-hasPermi="['qualification:qualificationAuthorizationRecord:remove']"
              ></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改资质授权记录对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="qualificationAuthorizationRecordFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="授权编号" prop="authorizationNo">
          <el-input v-model="form.authorizationNo" placeholder="请输入授权编号" />
        </el-form-item>
        <el-form-item label="人员ID" prop="staffId">
          <el-input v-model="form.staffId" placeholder="请输入人员ID" />
        </el-form-item>
        <el-form-item label="人员姓名" prop="staffName">
          <el-input v-model="form.staffName" placeholder="请输入人员姓名" />
        </el-form-item>
        <el-form-item label="资质ID" prop="qualificationId">
          <el-input v-model="form.qualificationId" placeholder="请输入资质ID" />
        </el-form-item>
        <el-form-item label="资质编码" prop="qualificationCode">
          <el-input v-model="form.qualificationCode" placeholder="请输入资质编码" />
        </el-form-item>
        <el-form-item label="资质名称" prop="qualificationName">
          <el-input v-model="form.qualificationName" placeholder="请输入资质名称" />
        </el-form-item>
        <el-form-item label="授权级别" prop="authorizationLevel">
          <el-input v-model="form.authorizationLevel" placeholder="请输入授权级别" />
        </el-form-item>
        <el-form-item label="有效期开始" prop="validStartDate">
          <el-date-picker clearable v-model="form.validStartDate" type="datetime" value-format="YYYY-MM-DD HH:mm:ss" placeholder="请选择有效期开始">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="有效期结束" prop="validEndDate">
          <el-date-picker clearable v-model="form.validEndDate" type="datetime" value-format="YYYY-MM-DD HH:mm:ss" placeholder="请选择有效期结束">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="关联申请ID" prop="applyId">
          <el-input v-model="form.applyId" placeholder="请输入关联申请ID" />
        </el-form-item>
        <el-form-item label="特殊限制条件" prop="specialCondition">
          <el-input v-model="form.specialCondition" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="限定患者ID(紧急授权)" prop="patientId">
          <el-input v-model="form.patientId" placeholder="请输入限定患者ID(紧急授权)" />
        </el-form-item>
        <el-form-item label="授权理由" prop="authorizationReason">
          <el-input v-model="form.authorizationReason" type="textarea" placeholder="请输入内容" />
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
    <FieldConfigDialog v-model:visible="showFieldConfig" :field-config-manager="fieldConfigManager" @confirm="handleFieldConfigConfirm" />
    <SearchConfigDialog v-model="searchConfigVisible" :search-config-manager="searchConfigManager" @confirm="handleSearchConfigConfirm" />
  </div>
</template>

<script setup name="QualificationAuthorizationRecord" lang="ts">
import {
  listQualificationAuthorizationRecord,
  getQualificationAuthorizationRecord,
  delQualificationAuthorizationRecord,
  addQualificationAuthorizationRecord,
  updateQualificationAuthorizationRecord
} from '@/api/qualification/qualificationAuthorizationRecord';
import {
  QualificationAuthorizationRecordVO,
  QualificationAuthorizationRecordQuery,
  QualificationAuthorizationRecordForm
} from '@/api/qualification/qualificationAuthorizationRecord/types';
import { createQualificationAuthorizationRecordFieldConfig } from '@/utils/fieldConfig';
import DynamicSearchForm from '@/components/DynamicSearchForm.vue';
import SearchConfigDialog from '@/components/SearchConfigDialog.vue';
import { createQualificationAuthorizationRecordSearchConfig } from '@/utils/configs/qualification/SearchConfigs';
import FieldConfigDialog from '@/components/FieldConfigDialog.vue';
import { Search, Setting, List } from '@element-plus/icons-vue';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const qualificationAuthorizationRecordList = ref<QualificationAuthorizationRecordVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref();
const qualificationAuthorizationRecordFormRef = ref<ElFormInstance>();

// 字段配置相关变量
const showFieldConfig = ref(false);
const fieldConfigManager = createQualificationAuthorizationRecordFieldConfig();
const visibleColumns = computed(() => fieldConfigManager.getVisibleFields());
const searchConfigManager = createQualificationAuthorizationRecordSearchConfig();
const searchConfigVisible = ref(false);
const visibleSearchFields = computed(() => searchConfigManager.getVisibleFields());

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: QualificationAuthorizationRecordForm = {
  id: undefined,
  authorizationNo: undefined,
  staffId: undefined,
  staffName: undefined,
  staffType: undefined,
  qualificationId: undefined,
  qualificationCode: undefined,
  qualificationName: undefined,
  authorizationType: undefined,
  authorizationLevel: undefined,
  validStartDate: undefined,
  validEndDate: undefined,
  authorizationStatus: undefined,
  applyId: undefined,
  specialCondition: undefined,
  patientId: undefined,
  authorizationReason: undefined,
  delFlag: undefined
};
const data = reactive<PageData<QualificationAuthorizationRecordForm, QualificationAuthorizationRecordQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    authorizationNo: undefined,
    staffId: undefined,
    staffName: undefined,
    staffType: undefined,
    qualificationId: undefined,
    qualificationCode: undefined,
    qualificationName: undefined,
    authorizationType: undefined,
    authorizationLevel: undefined,
    validStartDate: undefined,
    validEndDate: undefined,
    authorizationStatus: undefined,
    applyId: undefined,
    specialCondition: undefined,
    patientId: undefined,
    authorizationReason: undefined,
    delFlag: undefined,
    params: {}
  },
  rules: {
    id: [{ required: true, message: '主键ID不能为空', trigger: 'blur' }],
    authorizationNo: [{ required: true, message: '授权编号不能为空', trigger: 'blur' }],
    staffId: [{ required: true, message: '人员ID不能为空', trigger: 'blur' }],
    qualificationId: [{ required: true, message: '资质ID不能为空', trigger: 'blur' }]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询资质授权记录列表 */
const getList = async () => {
  loading.value = true;
  const res = await listQualificationAuthorizationRecord(queryParams.value);
  qualificationAuthorizationRecordList.value = res.rows;
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
  qualificationAuthorizationRecordFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: QualificationAuthorizationRecordVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加资质授权记录';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: QualificationAuthorizationRecordVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getQualificationAuthorizationRecord(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改资质授权记录';
};

/** 提交按钮 */
const submitForm = () => {
  qualificationAuthorizationRecordFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateQualificationAuthorizationRecord(form.value).finally(() => (buttonLoading.value = false));
      } else {
        await addQualificationAuthorizationRecord(form.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: QualificationAuthorizationRecordVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除资质授权记录编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delQualificationAuthorizationRecord(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/qualificationAuthorizationRecord/export',
    {
      ...queryParams.value
    },
    `qualificationAuthorizationRecord_${new Date().getTime()}.xlsx`
  );
};

/** 字段配置确认 */
const handleFieldConfigConfirm = () => {
  showFieldConfig.value = false;
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
