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
            <el-form-item label="计划日期" prop="plannedDate">
              <el-date-picker clearable v-model="queryParams.plannedDate" type="date" value-format="YYYY-MM-DD" placeholder="请选择计划日期" />
            </el-form-item>
            <el-form-item label="计划时间" prop="plannedTime">
              <el-date-picker clearable v-model="queryParams.plannedTime" type="date" value-format="YYYY-MM-DD" placeholder="请选择计划时间" />
            </el-form-item>
            <el-form-item label="培训地点" prop="location">
              <el-input v-model="queryParams.location" placeholder="请输入培训地点" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="培训师" prop="trainer">
              <el-input v-model="queryParams.trainer" placeholder="请输入培训师" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="培训对象" prop="targetAudience">
              <el-input v-model="queryParams.targetAudience" placeholder="请输入培训对象" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="是否已发送提醒：0-否，1-是" prop="reminderSent">
              <el-input v-model="queryParams.reminderSent" placeholder="请输入是否已发送提醒：0-否，1-是" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="提醒时间" prop="reminderTime">
              <el-date-picker clearable v-model="queryParams.reminderTime" type="date" value-format="YYYY-MM-DD" placeholder="请选择提醒时间" />
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
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['system:radiationTrainingPlan:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="success" plain icon="Edit" :disabled="single" @click="handleUpdate()" v-hasPermi="['system:radiationTrainingPlan:edit']"
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
              v-hasPermi="['system:radiationTrainingPlan:remove']"
              >删除</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['system:radiationTrainingPlan:export']"
              >导出</el-button
            >
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" border :data="radiationTrainingPlanList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="主键ID" align="center" prop="id" v-if="false" />
        <el-table-column label="计划编码" align="center" prop="planCode" />
        <el-table-column label="计划名称" align="center" prop="planName" />
        <el-table-column label="培训类型：radiation-放射防护，safety-安全培训，emergency-应急培训" align="center" prop="trainingType" />
        <el-table-column label="计划日期" align="center" prop="plannedDate" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.plannedDate, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="计划时间" align="center" prop="plannedTime" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.plannedTime, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="培训地点" align="center" prop="location" />
        <el-table-column label="培训师" align="center" prop="trainer" />
        <el-table-column label="培训内容" align="center" prop="trainingContent" />
        <el-table-column label="培训对象" align="center" prop="targetAudience" />
        <el-table-column label="状态：planned-已计划，ongoing-进行中，completed-已完成，cancelled-已取消" align="center" prop="status" />
        <el-table-column label="是否已发送提醒：0-否，1-是" align="center" prop="reminderSent" />
        <el-table-column label="提醒时间" align="center" prop="reminderTime" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.reminderTime, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="备注" align="center" prop="remark" />
        <el-table-column label="操作" align="center" fixed="right" class-name="small-padding fixed-width">
          <template #default="scope">
            <el-tooltip content="修改" placement="top">
              <el-button
                link
                type="primary"
                icon="Edit"
                @click="handleUpdate(scope.row)"
                v-hasPermi="['system:radiationTrainingPlan:edit']"
              ></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button
                link
                type="primary"
                icon="Delete"
                @click="handleDelete(scope.row)"
                v-hasPermi="['system:radiationTrainingPlan:remove']"
              ></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改职业健康培训计划对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="radiationTrainingPlanFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="计划编码" prop="planCode">
          <el-input v-model="form.planCode" placeholder="请输入计划编码" />
        </el-form-item>
        <el-form-item label="计划名称" prop="planName">
          <el-input v-model="form.planName" placeholder="请输入计划名称" />
        </el-form-item>
        <el-form-item label="计划日期" prop="plannedDate">
          <el-date-picker clearable v-model="form.plannedDate" type="datetime" value-format="YYYY-MM-DD HH:mm:ss" placeholder="请选择计划日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="计划时间" prop="plannedTime">
          <el-date-picker clearable v-model="form.plannedTime" type="datetime" value-format="YYYY-MM-DD HH:mm:ss" placeholder="请选择计划时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="培训地点" prop="location">
          <el-input v-model="form.location" placeholder="请输入培训地点" />
        </el-form-item>
        <el-form-item label="培训师" prop="trainer">
          <el-input v-model="form.trainer" placeholder="请输入培训师" />
        </el-form-item>
        <el-form-item label="培训内容">
          <editor v-model="form.trainingContent" :min-height="192" />
        </el-form-item>
        <el-form-item label="培训对象" prop="targetAudience">
          <el-input v-model="form.targetAudience" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="是否已发送提醒：0-否，1-是" prop="reminderSent">
          <el-input v-model="form.reminderSent" placeholder="请输入是否已发送提醒：0-否，1-是" />
        </el-form-item>
        <el-form-item label="提醒时间" prop="reminderTime">
          <el-date-picker clearable v-model="form.reminderTime" type="datetime" value-format="YYYY-MM-DD HH:mm:ss" placeholder="请选择提醒时间">
          </el-date-picker>
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

<script setup name="RadiationTrainingPlan" lang="ts">
import {
  listRadiationTrainingPlan,
  getRadiationTrainingPlan,
  delRadiationTrainingPlan,
  addRadiationTrainingPlan,
  updateRadiationTrainingPlan
} from '@/api/system/radiationTrainingPlan';
import { RadiationTrainingPlanVO, RadiationTrainingPlanQuery, RadiationTrainingPlanForm } from '@/api/system/radiationTrainingPlan/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const radiationTrainingPlanList = ref<RadiationTrainingPlanVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const radiationTrainingPlanFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: RadiationTrainingPlanForm = {
  id: undefined,
  planCode: undefined,
  planName: undefined,
  trainingType: undefined,
  plannedDate: undefined,
  plannedTime: undefined,
  location: undefined,
  trainer: undefined,
  trainingContent: undefined,
  targetAudience: undefined,
  status: undefined,
  reminderSent: undefined,
  reminderTime: undefined,
  remark: undefined
};
const data = reactive<PageData<RadiationTrainingPlanForm, RadiationTrainingPlanQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    planCode: undefined,
    planName: undefined,
    trainingType: undefined,
    plannedDate: undefined,
    plannedTime: undefined,
    location: undefined,
    trainer: undefined,
    trainingContent: undefined,
    targetAudience: undefined,
    status: undefined,
    reminderSent: undefined,
    reminderTime: undefined,
    params: {}
  },
  rules: {
    id: [{ required: true, message: '主键ID不能为空', trigger: 'blur' }],
    planCode: [{ required: true, message: '计划编码不能为空', trigger: 'blur' }],
    planName: [{ required: true, message: '计划名称不能为空', trigger: 'blur' }],
    plannedDate: [{ required: true, message: '计划日期不能为空', trigger: 'blur' }]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询职业健康培训计划列表 */
const getList = async () => {
  loading.value = true;
  const res = await listRadiationTrainingPlan(queryParams.value);
  radiationTrainingPlanList.value = res.rows;
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
  radiationTrainingPlanFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: RadiationTrainingPlanVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加职业健康培训计划';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: RadiationTrainingPlanVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getRadiationTrainingPlan(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改职业健康培训计划';
};

/** 提交按钮 */
const submitForm = () => {
  radiationTrainingPlanFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateRadiationTrainingPlan(form.value).finally(() => (buttonLoading.value = false));
      } else {
        await addRadiationTrainingPlan(form.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: RadiationTrainingPlanVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除职业健康培训计划编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delRadiationTrainingPlan(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/radiationTrainingPlan/export',
    {
      ...queryParams.value
    },
    `radiationTrainingPlan_${new Date().getTime()}.xlsx`
  );
};

onMounted(() => {
  getList();
});
</script>
