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
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['doctor:doctorBasicInfo:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="success" plain icon="Edit" :disabled="single" @click="handleUpdate()" v-hasPermi="['doctor:doctorBasicInfo:edit']"
              >修改</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button type="danger" plain icon="Delete" :disabled="multiple" @click="handleDelete()" v-hasPermi="['doctor:doctorBasicInfo:remove']"
              >删除</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['doctor:doctorBasicInfo:export']">导出</el-button>
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
            <el-button
              type="danger"
              plain
              icon="Delete"
              :disabled="multiple"
              @click="handleDelete()"
              v-hasPermi="['doctor:doctorBasicInfo:remove']"
              size="small"
              >删除</el-button
            >
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['doctor:doctorBasicInfo:export']" size="small"
              >导出</el-button
            >
            <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
          </div>
        </div>
      </template>

      <el-table v-loading="loading" border :data="doctorInfoList" @selection-change="handleSelectionChange">
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
            v-if="field.prop === 'birthDate' || field.prop === 'entryDate' || field.prop === 'createTime' || field.prop === 'updateTime'"
          >
            <span>{{ parseTime(scope.row[field.prop], '{y}-{m}-{d} {h}:{i}:{s}') }}</span>
          </template>
          <template #default="scope" v-else-if="field.prop === 'gender'">
            <el-tag :type="scope.row[field.prop] === '1' ? 'primary' : 'success'">
              {{ scope.row[field.prop] === '1' ? '男' : '女' }}
            </el-tag>
          </template>
          <template #default="scope" v-else-if="field.prop === 'titleLevel'">
            <el-tag :type="getTitleLevelType(scope.row[field.prop])">
              {{ getTitleLevelText(scope.row[field.prop]) }}
            </el-tag>
          </template>
          <template #default="scope" v-else-if="field.prop === 'status'">
            <el-tag :type="getStatusType(scope.row[field.prop])">
              {{ getStatusText(scope.row[field.prop]) }}
            </el-tag>
          </template>
          <template #default="scope" v-else-if="field.prop === 'delFlag'">
            <el-tag :type="scope.row[field.prop] === '0' ? 'success' : 'danger'">
              {{ scope.row[field.prop] === '0' ? '否' : '是' }}
            </el-tag>
          </template>
          <template #default="scope" v-else>
            {{ scope.row[field.prop] }}
          </template>
        </el-table-column>
        <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
          <template #default="scope">
            <el-button link size="small" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['doctor:doctorBasicInfo:edit']"
              >修改</el-button
            >
            <el-button link size="small" icon="Delete" @click="handleDelete(scope.row)" v-hasPermi="['doctor:doctorBasicInfo:remove']"
              >删除</el-button
            >
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>

    <!-- 添加或修改医师基本信息对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="600px" append-to-body>
      <el-form ref="doctorInfoFormRef" :model="form" :rules="rules" label-width="100px">
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="医生工号" prop="doctorCode">
              <el-input v-model="form.doctorCode" placeholder="请输入医生工号" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="医生姓名" prop="doctorName">
              <el-input v-model="form.doctorName" placeholder="请输入医生姓名" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="性别" prop="gender">
              <el-select v-model="form.gender" placeholder="请选择性别">
                <el-option label="男" value="1"></el-option>
                <el-option label="女" value="2"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="出生日期" prop="birthDate">
              <el-date-picker
                clearable
                v-model="form.birthDate"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择出生日期"
                style="width: 100%"
              >
              </el-date-picker>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="身份证号" prop="idCard">
              <el-input v-model="form.idCard" placeholder="请输入身份证号" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="联系电话" prop="phone">
              <el-input v-model="form.phone" placeholder="请输入联系电话" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="电子邮箱" prop="email">
              <el-input v-model="form.email" placeholder="请输入电子邮箱" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="入职日期" prop="entryDate">
              <el-date-picker
                clearable
                v-model="form.entryDate"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择入职日期"
                style="width: 100%"
              >
              </el-date-picker>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="科室名称" prop="departmentName">
              <el-input v-model="form.departmentName" placeholder="请输入科室名称" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="职称" prop="title">
              <el-input v-model="form.title" placeholder="请输入职称" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="职称级别" prop="titleLevel">
              <el-select v-model="form.titleLevel" placeholder="请选择职称级别">
                <el-option label="初级" value="1"></el-option>
                <el-option label="中级" value="2"></el-option>
                <el-option label="副高" value="3"></el-option>
                <el-option label="正高" value="4"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="状态" prop="status">
              <el-select v-model="form.status" placeholder="请选择状态">
                <el-option label="正常" value="0"></el-option>
                <el-option label="停用" value="1"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>
        <el-form-item label="照片URL" prop="photoUrl">
          <el-input v-model="form.photoUrl" type="textarea" placeholder="请输入照片URL" />
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

<script setup name="DoctorBasicInfo" lang="ts">
import { listDoctorBasicInfo, getDoctorBasicInfo, delDoctorBasicInfo, addDoctorBasicInfo, updateDoctorBasicInfo } from '@/api/doctor/doctorBasicInfo';
import { DoctorBasicInfoVO, DoctorBasicInfoQuery, DoctorBasicInfoForm } from '@/api/doctor/doctorBasicInfo/types';
import { createDoctorBasicInfoFieldConfig } from '@/utils/mmpFieldConfigs';
import FieldConfigDialog from '@/components/FieldConfigDialog.vue';
import DynamicSearchForm from '@/components/DynamicSearchForm.vue';
import SearchConfigDialog from '@/components/SearchConfigDialog.vue';
import { createDoctorBasicInfoSearchConfig } from '@/utils/mmpSearchConfigs';
import { parseTime } from '@/utils/ruoyi';
import type { FormInstance } from 'element-plus';
import type { DialogOption, PageData } from '@/types/global';
import type { ComponentInternalInstance } from 'vue';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const doctorInfoList = ref<DoctorBasicInfoVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<FormInstance>();
const doctorInfoFormRef = ref<FormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

// 字段配置相关变量
const fieldConfigManager = createDoctorBasicInfoFieldConfig();

// 初始化时清除之前的字段配置和localStorage缓存，确保新配置生效
fieldConfigManager.clearConfig();
localStorage.removeItem('doctorBasicInfo_field_config');
const showFieldConfig = ref(false);
const searchConfigManager = createDoctorBasicInfoSearchConfig();
const searchConfigVisible = ref(false);
const visibleSearchFields = computed(() => searchConfigManager.getVisibleFields());

// 计算属性：可见列
const visibleColumns = computed(() => fieldConfigManager.getVisibleFields());

const initFormData: DoctorBasicInfoForm = {
  id: undefined,
  doctorCode: undefined,
  doctorName: undefined,
  gender: undefined,
  birthDate: undefined,
  idCard: undefined,
  phone: undefined,
  email: undefined,
  photoUrl: undefined,
  deptId: undefined,
  departmentName: undefined,
  title: undefined,
  titleLevel: undefined,
  status: undefined,
  entryDate: undefined,
  delFlag: undefined,
  tenantId: undefined
};
const data = reactive<PageData<DoctorBasicInfoForm, DoctorBasicInfoQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    doctorCode: undefined,
    doctorName: undefined,
    gender: undefined,
    birthDate: undefined,
    idCard: undefined,
    phone: undefined,
    email: undefined,
    photoUrl: undefined,
    deptId: undefined,
    departmentName: undefined,
    title: undefined,
    titleLevel: undefined,
    status: undefined,
    entryDate: undefined,
    delFlag: undefined,
    params: {}
  },
  rules: {
    id: [{ required: true, message: '主键ID不能为空', trigger: 'blur' }],
    doctorCode: [{ required: true, message: '医生工号不能为空', trigger: 'blur' }],
    doctorName: [{ required: true, message: '医生姓名不能为空', trigger: 'blur' }]
  }
});

const { queryParams, form, rules } = toRefs(data);

// 辅助方法：获取职称级别类型
const getTitleLevelType = (level: string) => {
  const types = { '1': 'info', '2': 'success', '3': 'warning', '4': 'danger' };
  return types[level] || 'info';
};

// 辅助方法：获取职称级别文本
const getTitleLevelText = (level: string) => {
  const texts = { '1': '初级', '2': '中级', '3': '副高', '4': '正高' };
  return texts[level] || level;
};

// 辅助方法：获取状态类型
const getStatusType = (status: string) => {
  const types = { '0': 'success', '1': 'danger' };
  return types[status] || 'info';
};

// 辅助方法：获取状态文本
const getStatusText = (status: string) => {
  const texts = { '0': '正常', '1': '停用' };
  return texts[status] || status;
};

/** 查询医师基本信息列表 */
const getList = async () => {
  loading.value = true;
  try {
    const res = await listDoctorBasicInfo(queryParams.value);
    doctorInfoList.value = res.rows;
    total.value = res.total;
  } catch (error) {
    console.error('获取医生列表失败:', error);
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
  form.value = { ...initFormData };
  doctorInfoFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: DoctorBasicInfoVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加医师基本信息';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: DoctorBasicInfoVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getDoctorBasicInfo(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改医师基本信息';
};

/** 提交按钮 */
const submitForm = () => {
  doctorInfoFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateDoctorBasicInfo(form.value).finally(() => (buttonLoading.value = false));
      } else {
        await addDoctorBasicInfo(form.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: DoctorBasicInfoVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除医师基本信息编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delDoctorBasicInfo(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/doctorBasicInfo/export',
    {
      ...queryParams.value
    },
    `doctorBasicInfo_${new Date().getTime()}.xlsx`
  );
};

/** 字段配置按钮操作 */
const handleFieldConfig = () => {
  showFieldConfig.value = true;
};

/** 字段配置确认操作 */
const handleFieldConfigConfirm = () => {
  showFieldConfig.value = false;
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
  localStorage.removeItem('doctorBasicInfo_field_config');
  proxy?.$modal.msgSuccess('字段配置已重置，请刷新页面');
};

onMounted(() => {
  getList();
});
</script>


