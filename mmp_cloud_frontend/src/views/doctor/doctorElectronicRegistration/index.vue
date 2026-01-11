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
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['system:doctorElectronicRegistration:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button
              type="success"
              plain
              icon="Edit"
              :disabled="single"
              @click="handleUpdate()"
              v-hasPermi="['system:doctorElectronicRegistration:edit']"
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
              v-hasPermi="['system:doctorElectronicRegistration:remove']"
              >删除</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['system:doctorElectronicRegistration:export']"
              >导出</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button type="info" plain icon="Setting" @click="handleSearchConfig">搜索项配置</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="info" plain @click="toggleFieldConfig">
              <template #icon><i-ep-setting /></template>
              字段配置
            </el-button>
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" border :data="doctorElectronicRegistrationList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column
          v-for="field in visibleColumns"
          :key="field.prop"
          :prop="field.prop"
          :label="field.label"
          :width="field.width"
          align="center"
          :sortable="field.sortable"
        >
          <template #default="scope">
            <!-- 时间字段 -->
            <template v-if="field.prop === 'issueDate' || field.prop === 'validDate'">
              <span>{{ parseTime(scope.row[field.prop], '{y}-{m}-{d}') }}</span>
            </template>
            <template v-else-if="field.prop === 'createTime' || field.prop === 'updateTime'">
              <span>{{ parseTime(scope.row[field.prop], '{y}-{m}-{d} {h}:{i}') }}</span>
            </template>
            <!-- 默认显示 -->
            <template v-else>
              {{ scope.row[field.prop] }}
            </template>
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
                v-hasPermi="['system:doctorElectronicRegistration:edit']"
              ></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button
                link
                type="primary"
                icon="Delete"
                @click="handleDelete(scope.row)"
                v-hasPermi="['system:doctorElectronicRegistration:remove']"
              ></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改医师电子化注册对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="doctorElectronicRegistrationFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="医生ID" prop="doctorId">
          <el-input v-model="form.doctorId" placeholder="请输入医生ID" />
        </el-form-item>
        <el-form-item label="注册编号" prop="registrationNo">
          <el-input v-model="form.registrationNo" placeholder="请输入注册编号" />
        </el-form-item>
        <el-form-item label="执业类别" prop="practiceCategory">
          <el-input v-model="form.practiceCategory" placeholder="请输入执业类别" />
        </el-form-item>
        <el-form-item label="执业范围" prop="practiceScope">
          <el-input v-model="form.practiceScope" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="执业地点" prop="practiceLocation">
          <el-input v-model="form.practiceLocation" placeholder="请输入执业地点" />
        </el-form-item>
        <el-form-item label="发证日期" prop="issueDate">
          <el-date-picker clearable v-model="form.issueDate" type="datetime" value-format="YYYY-MM-DD HH:mm:ss" placeholder="请选择发证日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="有效期至" prop="validDate">
          <el-date-picker clearable v-model="form.validDate" type="datetime" value-format="YYYY-MM-DD HH:mm:ss" placeholder="请选择有效期至">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="注册机关" prop="registrationAuthority">
          <el-input v-model="form.registrationAuthority" placeholder="请输入注册机关" />
        </el-form-item>
        <el-form-item label="是否多机构备案 1-是 0-否" prop="multiInstitutionFlag">
          <el-input v-model="form.multiInstitutionFlag" placeholder="请输入是否多机构备案 1-是 0-否" />
        </el-form-item>
        <el-form-item label="证书附件URL" prop="certificateUrl">
          <el-input v-model="form.certificateUrl" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" type="textarea" placeholder="请输入内容" />
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
    <SearchConfigDialog v-model="searchConfigVisible" :search-config-manager="searchConfigManager" @confirm="handleSearchConfigConfirm" />
    <FieldConfigDialog v-model:visible="fieldConfigVisible" :field-config-manager="fieldConfigManager" @confirm="handleFieldConfigConfirm" />
  </div>
</template>

<script setup name="DoctorElectronicRegistration" lang="ts">
import {
  listDoctorElectronicRegistration,
  getDoctorElectronicRegistration,
  delDoctorElectronicRegistration,
  addDoctorElectronicRegistration,
  updateDoctorElectronicRegistration
} from '@/api/system/doctorElectronicRegistration';
import {
  DoctorElectronicRegistrationVO,
  DoctorElectronicRegistrationQuery,
  DoctorElectronicRegistrationForm
} from '@/api/system/doctorElectronicRegistration/types';
import { createDoctorElectronicRegistrationSearchConfig } from '@/utils/mmpSearchConfigs';
import { createDoctorElectronicRegistrationFieldConfig } from '@/utils/mmpFieldConfigs';
import FieldConfigDialog from '@/components/FieldConfigDialog.vue';

// Simple parseTime implementation
const parseTime = (time: any, pattern?: string) => {
  if (!time) return '';
  const date = new Date(time);
  if (pattern === '{y}-{m}-{d}') {
    return date.toLocaleDateString();
  }
  if (pattern === '{y}-{m}-{d} {h}:{i}') {
    return date.toLocaleString();
  }
  return date.toLocaleString();
};

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const doctorElectronicRegistrationList = ref<DoctorElectronicRegistrationVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const doctorElectronicRegistrationFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: DoctorElectronicRegistrationForm = {
  id: undefined,
  doctorId: undefined,
  registrationNo: undefined,
  registrationType: undefined,
  practiceCategory: undefined,
  practiceScope: undefined,
  practiceLocation: undefined,
  issueDate: undefined,
  validDate: undefined,
  registrationAuthority: undefined,
  registrationStatus: undefined,
  multiInstitutionFlag: undefined,
  certificateUrl: undefined,
  remark: undefined,
  delFlag: undefined
};
const data = reactive<PageData<DoctorElectronicRegistrationForm, DoctorElectronicRegistrationQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    doctorId: undefined,
    registrationNo: undefined,
    registrationType: undefined,
    practiceCategory: undefined,
    practiceScope: undefined,
    practiceLocation: undefined,
    issueDate: undefined,
    validDate: undefined,
    registrationAuthority: undefined,
    registrationStatus: undefined,
    multiInstitutionFlag: undefined,
    certificateUrl: undefined,
    delFlag: undefined,
    params: {}
  },
  rules: {
    id: [{ required: true, message: '主键ID不能为空', trigger: 'blur' }],
    doctorId: [{ required: true, message: '医生ID不能为空', trigger: 'blur' }]
  }
});

// 字段配置相关变量
const fieldConfigManager = createDoctorElectronicRegistrationFieldConfig();
const fieldConfigVisible = ref(false);

// 计算属性：可见列
const visibleColumns = computed(() => fieldConfigManager.getVisibleFields());
const searchConfigManager = createDoctorElectronicRegistrationSearchConfig();
const searchConfigVisible = ref(false);
const visibleSearchFields = computed(() => searchConfigManager.getVisibleFields());

const { queryParams, form, rules } = toRefs(data);

/** 查询医师电子化注册列表 */
const getList = async () => {
  loading.value = true;
  const res = await listDoctorElectronicRegistration(queryParams.value);
  doctorElectronicRegistrationList.value = res.rows;
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
  doctorElectronicRegistrationFormRef.value?.resetFields();
};

/** 字段配置相关函数 */
const toggleFieldConfig = () => {
  fieldConfigVisible.value = true;
};

const handleFieldConfigConfirm = () => {
  fieldConfigVisible.value = false;
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
const handleSelectionChange = (selection: DoctorElectronicRegistrationVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加医师电子化注册';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: DoctorElectronicRegistrationVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getDoctorElectronicRegistration(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改医师电子化注册';
};

/** 提交按钮 */
const submitForm = () => {
  doctorElectronicRegistrationFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateDoctorElectronicRegistration(form.value).finally(() => (buttonLoading.value = false));
      } else {
        await addDoctorElectronicRegistration(form.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: DoctorElectronicRegistrationVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除医师电子化注册编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delDoctorElectronicRegistration(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/doctorElectronicRegistration/export',
    {
      ...queryParams.value
    },
    `doctorElectronicRegistration_${new Date().getTime()}.xlsx`
  );
};

const handleSearchConfig = () => {
  searchConfigVisible.value = true;
};
const handleSearchConfigConfirm = (config?: any) => {
  searchConfigVisible.value = false;
};

onMounted(() => {
  getList();
});
</script>
