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
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['system:doctorEducation:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="success" plain icon="Edit" :disabled="single" @click="handleUpdate()" v-hasPermi="['system:doctorEducation:edit']"
              >修改</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button type="danger" plain icon="Delete" :disabled="multiple" @click="handleDelete()" v-hasPermi="['system:doctorEducation:remove']"
              >删除</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['system:doctorEducation:export']">导出</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="info" plain icon="Setting" @click="handleFieldConfig">字段配置</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="info" plain icon="Setting" @click="handleSearchConfig">搜索项配置</el-button>
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" border :data="doctorEducationList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column
          v-for="field in visibleColumns"
          :key="field.prop"
          :label="field.label"
          align="center"
          :prop="field.prop"
          :width="field.width || undefined"
        >
          <template
            #default="scope"
            v-if="field.prop === 'startDate' || field.prop === 'endDate' || field.prop === 'createTime' || field.prop === 'updateTime'"
          >
            <span>{{ parseTime(scope.row[field.prop], '{y}-{m}-{d} {h}:{i}:{s}') }}</span>
          </template>
          <template #default="scope" v-else-if="field.prop === 'delFlag'">
            <el-tag :type="scope.row[field.prop] === 0 ? 'success' : 'danger'">
              {{ scope.row[field.prop] === 0 ? '否' : '是' }}
            </el-tag>
          </template>
          <template #default="scope" v-else-if="field.prop === 'isFullTime'">
            <el-tag :type="scope.row[field.prop] === 1 ? 'success' : 'info'">
              {{ scope.row[field.prop] === 1 ? '全日制' : '非全日制' }}
            </el-tag>
          </template>
          <template #default="scope" v-else-if="field.prop === 'certificateUrl'">
            <el-link v-if="scope.row[field.prop]" :href="scope.row[field.prop]" target="_blank" type="primary">查看附件</el-link>
            <span v-else>无</span>
          </template>
          <template #default="scope" v-else>
            {{ scope.row[field.prop] }}
          </template>
        </el-table-column>
        <el-table-column label="操作" align="center" fixed="right" class-name="small-padding fixed-width">
          <template #default="scope">
            <el-tooltip content="修改" placement="top">
              <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['system:doctorEducation:edit']"></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button
                link
                type="primary"
                icon="Delete"
                @click="handleDelete(scope.row)"
                v-hasPermi="['system:doctorEducation:remove']"
              ></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改教育经历对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="doctorEducationFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="医生ID" prop="doctorId">
          <el-input v-model="form.doctorId" placeholder="请输入医生ID" />
        </el-form-item>
        <el-form-item label="学校名称" prop="schoolName">
          <el-input v-model="form.schoolName" placeholder="请输入学校名称" />
        </el-form-item>
        <el-form-item label="专业" prop="major">
          <el-input v-model="form.major" placeholder="请输入专业" />
        </el-form-item>
        <el-form-item label="学历" prop="educationLevel">
          <el-select v-model="form.educationLevel" placeholder="请选择学历" style="width: 100%">
            <el-option label="本科" value="本科" />
            <el-option label="硕士" value="硕士" />
            <el-option label="博士" value="博士" />
            <el-option label="专科" value="专科" />
            <el-option label="高中" value="高中" />
            <el-option label="初中" value="初中" />
            <el-option label="小学" value="小学" />
          </el-select>
        </el-form-item>
        <el-form-item label="学位" prop="degree">
          <el-select v-model="form.degree" placeholder="请选择学位" style="width: 100%">
            <el-option label="学士" value="学士" />
            <el-option label="硕士" value="硕士" />
            <el-option label="博士" value="博士" />
            <el-option label="无" value="无" />
          </el-select>
        </el-form-item>
        <el-form-item label="开始日期" prop="startDate">
          <el-date-picker clearable v-model="form.startDate" type="datetime" value-format="YYYY-MM-DD HH:mm:ss" placeholder="请选择开始日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="结束日期" prop="endDate">
          <el-date-picker clearable v-model="form.endDate" type="datetime" value-format="YYYY-MM-DD HH:mm:ss" placeholder="请选择结束日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="是否全日制" prop="isFullTime">
          <el-select v-model="form.isFullTime" placeholder="请选择是否全日制" style="width: 100%">
            <el-option label="是" :value="1" />
            <el-option label="否" :value="0" />
          </el-select>
        </el-form-item>
        <el-form-item label="证书编号" prop="certificateNo">
          <el-input v-model="form.certificateNo" placeholder="请输入证书编号" />
        </el-form-item>
        <el-form-item label="证书附件URL" prop="certificateUrl">
          <el-input v-model="form.certificateUrl" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="是否删除" prop="delFlag">
          <el-select v-model="form.delFlag" placeholder="请选择状态" style="width: 100%">
            <el-option label="正常" :value="0" />
            <el-option label="已删除" :value="1" />
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
    <!-- 字段配置对话框 -->
    <FieldConfigDialog v-model:visible="fieldConfigVisible" :field-config-manager="fieldConfigManager" @confirm="handleFieldConfigConfirm" />
    <SearchConfigDialog v-model="searchConfigVisible" :search-config-manager="searchConfigManager" @confirm="handleSearchConfigConfirm" />
  </div>
</template>

<script setup name="DoctorEducation" lang="ts">
import { listDoctorEducation, getDoctorEducation, delDoctorEducation, addDoctorEducation, updateDoctorEducation } from '@/api/doctor/doctorEducation';
import { DoctorEducationVO, DoctorEducationQuery, DoctorEducationForm } from '@/api/doctor/doctorEducation/types';
import { createDoctorEducationFieldConfig } from '@/utils/mmpFieldConfigs';
import FieldConfigDialog from '@/components/FieldConfigDialog.vue';
import DynamicSearchForm from '@/components/DynamicSearchForm.vue';
import SearchConfigDialog from '@/components/SearchConfigDialog.vue';
import RightToolbar from '@/components/RightToolbar/index.vue';
import Pagination from '@/components/Pagination/index.vue';
import { createDoctorEducationSearchConfig } from '@/utils/mmpSearchConfigs';
import { parseTime } from '@/utils/ruoyi';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const doctorEducationList = ref<DoctorEducationVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const doctorEducationFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: DoctorEducationForm = {
  id: undefined,
  doctorId: undefined,
  schoolName: undefined,
  major: undefined,
  educationLevel: undefined,
  degree: undefined,
  startDate: undefined,
  endDate: undefined,
  isFullTime: undefined,
  certificateNo: undefined,
  certificateUrl: undefined,
  remark: undefined,
  delFlag: undefined
};
const data = reactive<PageData<DoctorEducationForm, DoctorEducationQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    doctorId: undefined,
    schoolName: undefined,
    major: undefined,
    educationLevel: undefined,
    degree: undefined,
    startDate: undefined,
    endDate: undefined,
    isFullTime: undefined,
    certificateNo: undefined,
    certificateUrl: undefined,
    delFlag: undefined,
    params: {}
  },
  rules: {
    id: [{ required: true, message: '主键ID不能为空', trigger: 'blur' }],
    doctorId: [{ required: true, message: '医生ID不能为空', trigger: 'blur' }]
  }
});

const { queryParams, form, rules } = toRefs(data);

// 字段配置相关
const fieldConfigManager = createDoctorEducationFieldConfig();

// 初始化时清除之前的字段配置和localStorage缓存，确保新配置生效
fieldConfigManager.clearConfig();
localStorage.removeItem('doctorEducation_field_config');

const fieldConfigVisible = ref(false);
const visibleColumns = computed(() => fieldConfigManager.getVisibleFields());
const searchConfigManager = createDoctorEducationSearchConfig();
const searchConfigVisible = ref(false);
const visibleSearchFields = computed(() => searchConfigManager.getVisibleFields());

/** 查询教育经历列表 */
const getList = async () => {
  loading.value = true;
  const res = await listDoctorEducation(queryParams.value);
  doctorEducationList.value = res.rows;
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
  doctorEducationFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: DoctorEducationVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加教育经历';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: DoctorEducationVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getDoctorEducation(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改教育经历';
};

/** 提交按钮 */
const submitForm = () => {
  doctorEducationFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateDoctorEducation(form.value).finally(() => (buttonLoading.value = false));
      } else {
        await addDoctorEducation(form.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: DoctorEducationVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除教育经历编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delDoctorEducation(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/doctorEducation/export',
    {
      ...queryParams.value
    },
    `doctorEducation_${new Date().getTime()}.xlsx`
  );
};

/** 字段配置按钮操作 */
const handleFieldConfig = () => {
  fieldConfigVisible.value = true;
};

/** 字段配置确认操作 */
const handleFieldConfigConfirm = () => {
  fieldConfigVisible.value = false;
  // 配置更新后可以在这里添加额外的逻辑，比如重新获取数据等
};

const handleSearchConfig = () => {
  searchConfigVisible.value = true;
};
const handleSearchConfigConfirm = () => {
  searchConfigVisible.value = false;
};

/** 重置字段配置 */
const handleFieldConfigReset = () => {
  fieldConfigManager.clearConfig();
  // 同时清除localStorage中的缓存
  localStorage.removeItem('doctorEducation_field_config');
  proxy?.$modal.msgSuccess('字段配置已重置，请刷新页面');
};

onMounted(() => {
  getList();
});
</script>
