<template>
  <div class="p-2">
    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <div v-show="showSearch" class="mb-[10px]">
        <el-card shadow="hover">
          <el-form ref="queryFormRef" :model="queryParams" :inline="true">
            <el-form-item label="资源编码" prop="resourceCode">
              <el-input v-model="queryParams.resourceCode" placeholder="请输入资源编码" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="资源名称" prop="resourceName">
              <el-input v-model="queryParams.resourceName" placeholder="请输入资源名称" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="所属部门" prop="department">
              <el-input v-model="queryParams.department" placeholder="请输入所属部门" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="存放地点" prop="location">
              <el-input v-model="queryParams.location" placeholder="请输入存放地点" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="数量" prop="quantity">
              <el-input v-model="queryParams.quantity" placeholder="请输入数量" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="单位" prop="unit">
              <el-input v-model="queryParams.unit" placeholder="请输入单位" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="联系人" prop="contactPerson">
              <el-input v-model="queryParams.contactPerson" placeholder="请输入联系人" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="联系方式" prop="contactInfo">
              <el-input v-model="queryParams.contactInfo" placeholder="请输入联系方式" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item>
              <el-button type="primary" icon="Search" @click="handleQuery">搜索</el-button>
              <el-button icon="Refresh" @click="resetQuery">重置</el-button>
            </el-form-item>
          </el-form>
        </el-card>
      </div>
    </transition>

    <el-card shadow="never">
      <template #header>
        <el-row :gutter="10" class="mb8">
          <el-col :span="1.5">
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['emergency:emergencyMedicalSupport:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button
              type="success"
              plain
              icon="Edit"
              :disabled="single"
              @click="handleUpdate()"
              v-hasPermi="['emergency:emergencyMedicalSupport:edit']"
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
              v-hasPermi="['emergency:emergencyMedicalSupport:remove']"
              >删除</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['emergency:emergencyMedicalSupport:export']"
              >导出</el-button
            >
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" border :data="emergencyMedicalSupportList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="主键ID" align="center" prop="id" v-if="false" />
        <el-table-column label="资源编码" align="center" prop="resourceCode" />
        <el-table-column label="资源名称" align="center" prop="resourceName" />
        <el-table-column label="资源类型" align="center" prop="resourceType" />
        <el-table-column label="所属部门" align="center" prop="department" />
        <el-table-column label="存放地点" align="center" prop="location" />
        <el-table-column label="数量" align="center" prop="quantity" />
        <el-table-column label="单位" align="center" prop="unit" />
        <el-table-column label="联系人" align="center" prop="contactPerson" />
        <el-table-column label="联系方式" align="center" prop="contactInfo" />
        <el-table-column label="状态" align="center" prop="status" />
        <el-table-column label="备注" align="center" prop="remark" />
        <el-table-column label="操作" align="center" fixed="right" class-name="small-padding fixed-width">
          <template #default="scope">
            <el-tooltip content="修改" placement="top">
              <el-button
                link
                type="primary"
                icon="Edit"
                @click="handleUpdate(scope.row)"
                v-hasPermi="['emergency:emergencyMedicalSupport:edit']"
              ></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button
                link
                type="primary"
                icon="Delete"
                @click="handleDelete(scope.row)"
                v-hasPermi="['emergency:emergencyMedicalSupport:remove']"
              ></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改医疗保障资源对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="emergencyMedicalSupportFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="资源编码" prop="resourceCode">
          <el-input v-model="form.resourceCode" placeholder="请输入资源编码" />
        </el-form-item>
        <el-form-item label="资源名称" prop="resourceName">
          <el-input v-model="form.resourceName" placeholder="请输入资源名称" />
        </el-form-item>
        <el-form-item label="所属部门" prop="department">
          <el-input v-model="form.department" placeholder="请输入所属部门" />
        </el-form-item>
        <el-form-item label="存放地点" prop="location">
          <el-input v-model="form.location" placeholder="请输入存放地点" />
        </el-form-item>
        <el-form-item label="数量" prop="quantity">
          <el-input v-model="form.quantity" placeholder="请输入数量" />
        </el-form-item>
        <el-form-item label="单位" prop="unit">
          <el-input v-model="form.unit" placeholder="请输入单位" />
        </el-form-item>
        <el-form-item label="联系人" prop="contactPerson">
          <el-input v-model="form.contactPerson" placeholder="请输入联系人" />
        </el-form-item>
        <el-form-item label="联系方式" prop="contactInfo">
          <el-input v-model="form.contactInfo" placeholder="请输入联系方式" />
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" type="textarea" placeholder="请输入内容" />
        </el-form-item>
      </el-form>
      <template #footer>
        <div class="dialog-footer">
          <el-button :loading="buttonLoading" type="primary" @click="submitForm">确 定</el-button>
          <el-button @click="cancel">取 消</el-button>
        </div>
      </template>
    </el-dialog>
  </div>
</template>

<script setup name="EmergencyMedicalSupport" lang="ts">
import {
  listEmergencyMedicalSupport,
  getEmergencyMedicalSupport,
  delEmergencyMedicalSupport,
  addEmergencyMedicalSupport,
  updateEmergencyMedicalSupport
} from '@/api/emergency/emergencyMedicalSupport';
import { EmergencyMedicalSupportVO, EmergencyMedicalSupportQuery, EmergencyMedicalSupportForm } from '@/api/emergency/emergencyMedicalSupport/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const emergencyMedicalSupportList = ref<EmergencyMedicalSupportVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const emergencyMedicalSupportFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: EmergencyMedicalSupportForm = {
  id: undefined,
  resourceCode: undefined,
  resourceName: undefined,
  resourceType: undefined,
  department: undefined,
  location: undefined,
  quantity: undefined,
  unit: undefined,
  contactPerson: undefined,
  contactInfo: undefined,
  status: undefined,
  remark: undefined
};
const data = reactive<PageData<EmergencyMedicalSupportForm, EmergencyMedicalSupportQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    resourceCode: undefined,
    resourceName: undefined,
    resourceType: undefined,
    department: undefined,
    location: undefined,
    quantity: undefined,
    unit: undefined,
    contactPerson: undefined,
    contactInfo: undefined,
    status: undefined,
    params: {}
  },
  rules: {
    id: [{ required: true, message: '主键ID不能为空', trigger: 'blur' }],
    resourceCode: [{ required: true, message: '资源编码不能为空', trigger: 'blur' }],
    resourceName: [{ required: true, message: '资源名称不能为空', trigger: 'blur' }]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询医疗保障资源列表 */
const getList = async () => {
  loading.value = true;
  const res = await listEmergencyMedicalSupport(queryParams.value);
  emergencyMedicalSupportList.value = res.rows;
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
  emergencyMedicalSupportFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: EmergencyMedicalSupportVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加医疗保障资源';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: EmergencyMedicalSupportVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getEmergencyMedicalSupport(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改医疗保障资源';
};

/** 提交按钮 */
const submitForm = () => {
  emergencyMedicalSupportFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateEmergencyMedicalSupport(form.value).finally(() => (buttonLoading.value = false));
      } else {
        await addEmergencyMedicalSupport(form.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: EmergencyMedicalSupportVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除医疗保障资源编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delEmergencyMedicalSupport(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/emergencyMedicalSupport/export',
    {
      ...queryParams.value
    },
    `emergencyMedicalSupport_${new Date().getTime()}.xlsx`
  );
};

onMounted(() => {
  getList();
});
</script>
