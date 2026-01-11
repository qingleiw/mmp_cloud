<template>
  <div class="p-2">
    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <div v-show="showSearch" class="mb-[10px]">
        <el-card shadow="hover">
          <el-form ref="queryFormRef" :model="queryParams" :inline="true">
            <el-form-item label="工作人员编码" prop="workerCode">
              <el-input v-model="queryParams.workerCode" placeholder="请输入工作人员编码" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="工作人员姓名" prop="workerName">
              <el-input v-model="queryParams.workerName" placeholder="请输入工作人员姓名" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="所属部门" prop="department">
              <el-input v-model="queryParams.department" placeholder="请输入所属部门" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="职位" prop="position">
              <el-input v-model="queryParams.position" placeholder="请输入职位" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="入职日期" prop="employmentDate">
              <el-date-picker clearable v-model="queryParams.employmentDate" type="date" value-format="YYYY-MM-DD" placeholder="请选择入职日期" />
            </el-form-item>
            <el-form-item label="联系方式" prop="contactInfo">
              <el-input v-model="queryParams.contactInfo" placeholder="请输入联系方式" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="紧急联系人" prop="emergencyContact">
              <el-input v-model="queryParams.emergencyContact" placeholder="请输入紧急联系人" clearable @keyup.enter="handleQuery" />
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
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['system:radiationWorker:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="success" plain icon="Edit" :disabled="single" @click="handleUpdate()" v-hasPermi="['system:radiationWorker:edit']"
              >修改</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button type="danger" plain icon="Delete" :disabled="multiple" @click="handleDelete()" v-hasPermi="['system:radiationWorker:remove']"
              >删除</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['system:radiationWorker:export']">导出</el-button>
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" border :data="radiationWorkerList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="主键ID" align="center" prop="id" v-if="false" />
        <el-table-column label="工作人员编码" align="center" prop="workerCode" />
        <el-table-column label="工作人员姓名" align="center" prop="workerName" />
        <el-table-column label="所属部门" align="center" prop="department" />
        <el-table-column label="职位" align="center" prop="position" />
        <el-table-column label="接触辐射类型" align="center" prop="radiationType" />
        <el-table-column label="入职日期" align="center" prop="employmentDate" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.employmentDate, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="联系方式" align="center" prop="contactInfo" />
        <el-table-column label="紧急联系人" align="center" prop="emergencyContact" />
        <el-table-column label="健康状况" align="center" prop="healthStatus" />
        <el-table-column label="状态" align="center" prop="status" />
        <el-table-column label="备注" align="center" prop="remark" />
        <el-table-column label="操作" align="center" fixed="right" class-name="small-padding fixed-width">
          <template #default="scope">
            <el-tooltip content="修改" placement="top">
              <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['system:radiationWorker:edit']"></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button
                link
                type="primary"
                icon="Delete"
                @click="handleDelete(scope.row)"
                v-hasPermi="['system:radiationWorker:remove']"
              ></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改放射工作人员对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="radiationWorkerFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="工作人员编码" prop="workerCode">
          <el-input v-model="form.workerCode" placeholder="请输入工作人员编码" />
        </el-form-item>
        <el-form-item label="工作人员姓名" prop="workerName">
          <el-input v-model="form.workerName" placeholder="请输入工作人员姓名" />
        </el-form-item>
        <el-form-item label="所属部门" prop="department">
          <el-input v-model="form.department" placeholder="请输入所属部门" />
        </el-form-item>
        <el-form-item label="职位" prop="position">
          <el-input v-model="form.position" placeholder="请输入职位" />
        </el-form-item>
        <el-form-item label="入职日期" prop="employmentDate">
          <el-date-picker clearable v-model="form.employmentDate" type="datetime" value-format="YYYY-MM-DD HH:mm:ss" placeholder="请选择入职日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="联系方式" prop="contactInfo">
          <el-input v-model="form.contactInfo" placeholder="请输入联系方式" />
        </el-form-item>
        <el-form-item label="紧急联系人" prop="emergencyContact">
          <el-input v-model="form.emergencyContact" placeholder="请输入紧急联系人" />
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

<script setup name="RadiationWorker" lang="ts">
import { listRadiationWorker, getRadiationWorker, delRadiationWorker, addRadiationWorker, updateRadiationWorker } from '@/api/system/radiationWorker';
import { RadiationWorkerVO, RadiationWorkerQuery, RadiationWorkerForm } from '@/api/system/radiationWorker/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const radiationWorkerList = ref<RadiationWorkerVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const radiationWorkerFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: RadiationWorkerForm = {
  id: undefined,
  workerCode: undefined,
  workerName: undefined,
  department: undefined,
  position: undefined,
  radiationType: undefined,
  employmentDate: undefined,
  contactInfo: undefined,
  emergencyContact: undefined,
  healthStatus: undefined,
  status: undefined,
  remark: undefined
};
const data = reactive<PageData<RadiationWorkerForm, RadiationWorkerQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    workerCode: undefined,
    workerName: undefined,
    department: undefined,
    position: undefined,
    radiationType: undefined,
    employmentDate: undefined,
    contactInfo: undefined,
    emergencyContact: undefined,
    healthStatus: undefined,
    status: undefined,
    params: {}
  },
  rules: {
    id: [{ required: true, message: '主键ID不能为空', trigger: 'blur' }],
    workerCode: [{ required: true, message: '工作人员编码不能为空', trigger: 'blur' }],
    workerName: [{ required: true, message: '工作人员姓名不能为空', trigger: 'blur' }]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询放射工作人员列表 */
const getList = async () => {
  loading.value = true;
  const res = await listRadiationWorker(queryParams.value);
  radiationWorkerList.value = res.rows;
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
  radiationWorkerFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: RadiationWorkerVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加放射工作人员';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: RadiationWorkerVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getRadiationWorker(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改放射工作人员';
};

/** 提交按钮 */
const submitForm = () => {
  radiationWorkerFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateRadiationWorker(form.value).finally(() => (buttonLoading.value = false));
      } else {
        await addRadiationWorker(form.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: RadiationWorkerVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除放射工作人员编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delRadiationWorker(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/radiationWorker/export',
    {
      ...queryParams.value
    },
    `radiationWorker_${new Date().getTime()}.xlsx`
  );
};

onMounted(() => {
  getList();
});
</script>
