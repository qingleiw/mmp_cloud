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
            <el-form-item label="体检地点" prop="location">
              <el-input v-model="queryParams.location" placeholder="请输入体检地点" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="体检机构" prop="examAgency">
              <el-input v-model="queryParams.examAgency" placeholder="请输入体检机构" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="体检对象" prop="targetStaff">
              <el-input v-model="queryParams.targetStaff" placeholder="请输入体检对象" clearable @keyup.enter="handleQuery" />
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
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['system:radiationHealthExamPlan:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button
              type="success"
              plain
              icon="Edit"
              :disabled="single"
              @click="handleUpdate()"
              v-hasPermi="['system:radiationHealthExamPlan:edit']"
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
              v-hasPermi="['system:radiationHealthExamPlan:remove']"
              >删除</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['system:radiationHealthExamPlan:export']"
              >导出</el-button
            >
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" border :data="radiationHealthExamPlanList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="主键ID" align="center" prop="id" v-if="false" />
        <el-table-column label="计划编码" align="center" prop="planCode" />
        <el-table-column label="计划名称" align="center" prop="planName" />
        <el-table-column label="体检类型：annual-年度体检，special-专项体检" align="center" prop="examType" />
        <el-table-column label="计划日期" align="center" prop="plannedDate" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.plannedDate, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="体检地点" align="center" prop="location" />
        <el-table-column label="体检机构" align="center" prop="examAgency" />
        <el-table-column label="体检对象" align="center" prop="targetStaff" />
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
                v-hasPermi="['system:radiationHealthExamPlan:edit']"
              ></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button
                link
                type="primary"
                icon="Delete"
                @click="handleDelete(scope.row)"
                v-hasPermi="['system:radiationHealthExamPlan:remove']"
              ></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改职业健康体检计划对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="radiationHealthExamPlanFormRef" :model="form" :rules="rules" label-width="80px">
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
        <el-form-item label="体检地点" prop="location">
          <el-input v-model="form.location" placeholder="请输入体检地点" />
        </el-form-item>
        <el-form-item label="体检机构" prop="examAgency">
          <el-input v-model="form.examAgency" placeholder="请输入体检机构" />
        </el-form-item>
        <el-form-item label="体检对象" prop="targetStaff">
          <el-input v-model="form.targetStaff" type="textarea" placeholder="请输入内容" />
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

<script setup name="RadiationHealthExamPlan" lang="ts">
import {
  listRadiationHealthExamPlan,
  getRadiationHealthExamPlan,
  delRadiationHealthExamPlan,
  addRadiationHealthExamPlan,
  updateRadiationHealthExamPlan
} from '@/api/radiation/radiationHealthExamPlan';
import { RadiationHealthExamPlanVO, RadiationHealthExamPlanQuery, RadiationHealthExamPlanForm } from '@/api/radiation/radiationHealthExamPlan/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const radiationHealthExamPlanList = ref<RadiationHealthExamPlanVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const radiationHealthExamPlanFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: RadiationHealthExamPlanForm = {
  id: undefined,
  planCode: undefined,
  planName: undefined,
  examType: undefined,
  plannedDate: undefined,
  location: undefined,
  examAgency: undefined,
  targetStaff: undefined,
  status: undefined,
  reminderSent: undefined,
  reminderTime: undefined,
  remark: undefined
};
const data = reactive<PageData<RadiationHealthExamPlanForm, RadiationHealthExamPlanQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    planCode: undefined,
    planName: undefined,
    examType: undefined,
    plannedDate: undefined,
    location: undefined,
    examAgency: undefined,
    targetStaff: undefined,
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

/** 查询职业健康体检计划列表 */
const getList = async () => {
  loading.value = true;
  const res = await listRadiationHealthExamPlan(queryParams.value);
  radiationHealthExamPlanList.value = res.rows;
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
  radiationHealthExamPlanFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: RadiationHealthExamPlanVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加职业健康体检计划';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: RadiationHealthExamPlanVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getRadiationHealthExamPlan(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改职业健康体检计划';
};

/** 提交按钮 */
const submitForm = () => {
  radiationHealthExamPlanFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateRadiationHealthExamPlan(form.value).finally(() => (buttonLoading.value = false));
      } else {
        await addRadiationHealthExamPlan(form.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: RadiationHealthExamPlanVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除职业健康体检计划编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delRadiationHealthExamPlan(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/radiationHealthExamPlan/export',
    {
      ...queryParams.value
    },
    `radiationHealthExamPlan_${new Date().getTime()}.xlsx`
  );
};

onMounted(() => {
  getList();
});
</script>
