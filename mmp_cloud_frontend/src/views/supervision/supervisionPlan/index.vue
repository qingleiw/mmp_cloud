<template>
  <div class="p-2">
    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <div v-show="showSearch" class="mb-[10px]">
        <el-card shadow="hover">
          <el-form ref="queryFormRef" :model="queryParams" :inline="true">
            <el-form-item label="计划编码" prop="planCode">
              <el-input v-model="queryParams.planCode" placeholder="请输入计划编码" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="计划名称" prop="planName">
              <el-input v-model="queryParams.planName" placeholder="请输入计划名称" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="督导周期" prop="supervisionPeriod">
              <el-input v-model="queryParams.supervisionPeriod" placeholder="请输入督导周期" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="开始日期" prop="startDate">
              <el-date-picker clearable v-model="queryParams.startDate" type="date" value-format="YYYY-MM-DD" placeholder="请选择开始日期" />
            </el-form-item>
            <el-form-item label="结束日期" prop="endDate">
              <el-date-picker clearable v-model="queryParams.endDate" type="date" value-format="YYYY-MM-DD" placeholder="请选择结束日期" />
            </el-form-item>
            <el-form-item label="负责人" prop="responsiblePerson">
              <el-input v-model="queryParams.responsiblePerson" placeholder="请输入负责人" clearable @keyup.enter="handleQuery" />
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
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['system:supervisionPlan:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="success" plain icon="Edit" :disabled="single" @click="handleUpdate()" v-hasPermi="['system:supervisionPlan:edit']"
              >修改</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button type="danger" plain icon="Delete" :disabled="multiple" @click="handleDelete()" v-hasPermi="['system:supervisionPlan:remove']"
              >删除</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['system:supervisionPlan:export']">导出</el-button>
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" border :data="supervisionPlanList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="主键ID" align="center" prop="id" v-if="false" />
        <el-table-column label="计划编码" align="center" prop="planCode" />
        <el-table-column label="计划名称" align="center" prop="planName" />
        <el-table-column label="计划类型" align="center" prop="planType" />
        <el-table-column label="督导周期" align="center" prop="supervisionPeriod" />
        <el-table-column label="开始日期" align="center" prop="startDate" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.startDate, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="结束日期" align="center" prop="endDate" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.endDate, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="负责人" align="center" prop="responsiblePerson" />
        <el-table-column label="状态：draft-草稿，published-已发布，executing-执行中，completed-已完成" align="center" prop="status" />
        <el-table-column label="备注" align="center" prop="remark" />
        <el-table-column label="操作" align="center" fixed="right" class-name="small-padding fixed-width">
          <template #default="scope">
            <el-tooltip content="修改" placement="top">
              <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['system:supervisionPlan:edit']"></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button
                link
                type="primary"
                icon="Delete"
                @click="handleDelete(scope.row)"
                v-hasPermi="['system:supervisionPlan:remove']"
              ></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改督查计划对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="supervisionPlanFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="计划编码" prop="planCode">
          <el-input v-model="form.planCode" placeholder="请输入计划编码" />
        </el-form-item>
        <el-form-item label="计划名称" prop="planName">
          <el-input v-model="form.planName" placeholder="请输入计划名称" />
        </el-form-item>
        <el-form-item label="项目ID" prop="projectId">
          <el-input v-model="form.projectId" placeholder="请输入项目ID" />
        </el-form-item>
        <el-form-item label="督导周期" prop="supervisionPeriod">
          <el-input v-model="form.supervisionPeriod" placeholder="请输入督导周期" />
        </el-form-item>
        <el-form-item label="开始日期" prop="startDate">
          <el-date-picker clearable v-model="form.startDate" type="datetime" value-format="YYYY-MM-DD HH:mm:ss" placeholder="请选择开始日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="结束日期" prop="endDate">
          <el-date-picker clearable v-model="form.endDate" type="datetime" value-format="YYYY-MM-DD HH:mm:ss" placeholder="请选择结束日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="负责人" prop="responsiblePerson">
          <el-input v-model="form.responsiblePerson" placeholder="请输入负责人" />
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

<script setup name="SupervisionPlan" lang="ts">
import { listSupervisionPlan, getSupervisionPlan, delSupervisionPlan, addSupervisionPlan, updateSupervisionPlan } from '@/api/supervision/supervisionPlan';
import { SupervisionPlanVO, SupervisionPlanQuery, SupervisionPlanForm } from '@/api/supervision/supervisionPlan/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const supervisionPlanList = ref<SupervisionPlanVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const supervisionPlanFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: SupervisionPlanForm = {
  id: undefined,
  planCode: undefined,
  planName: undefined,
  projectId: undefined,
  planType: undefined,
  supervisionPeriod: undefined,
  startDate: undefined,
  endDate: undefined,
  responsiblePerson: undefined,
  status: undefined,
  remark: undefined
};
const data = reactive<PageData<SupervisionPlanForm, SupervisionPlanQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    planCode: undefined,
    planName: undefined,
    planType: undefined,
    supervisionPeriod: undefined,
    startDate: undefined,
    endDate: undefined,
    responsiblePerson: undefined,
    status: undefined,
    params: {}
  },
  rules: {
    id: [{ required: true, message: '主键ID不能为空', trigger: 'blur' }],
    planCode: [{ required: true, message: '计划编码不能为空', trigger: 'blur' }],
    planName: [{ required: true, message: '计划名称不能为空', trigger: 'blur' }],
    projectId: [{ required: true, message: '项目ID不能为空', trigger: 'blur' }]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询督查计划列表 */
const getList = async () => {
  loading.value = true;
  const res = await listSupervisionPlan(queryParams.value);
  supervisionPlanList.value = res.rows;
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
  supervisionPlanFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: SupervisionPlanVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加督查计划';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: SupervisionPlanVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getSupervisionPlan(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改督查计划';
};

/** 提交按钮 */
const submitForm = () => {
  supervisionPlanFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateSupervisionPlan(form.value).finally(() => (buttonLoading.value = false));
      } else {
        await addSupervisionPlan(form.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: SupervisionPlanVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除督查计划编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delSupervisionPlan(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/supervisionPlan/export',
    {
      ...queryParams.value
    },
    `supervisionPlan_${new Date().getTime()}.xlsx`
  );
};

onMounted(() => {
  getList();
});
</script>
