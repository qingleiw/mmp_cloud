<template>
  <div class="p-2">
    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <div v-show="showSearch" class="mb-[10px]">
        <el-card shadow="hover">
          <el-form ref="queryFormRef" :model="queryParams" :inline="true">
            <el-form-item label="培训编码" prop="trainingCode">
              <el-input v-model="queryParams.trainingCode" placeholder="请输入培训编码" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="培训名称" prop="trainingName">
              <el-input v-model="queryParams.trainingName" placeholder="请输入培训名称" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="培训日期" prop="trainingDate">
              <el-date-picker clearable v-model="queryParams.trainingDate" type="date" value-format="YYYY-MM-DD" placeholder="请选择培训日期" />
            </el-form-item>
            <el-form-item label="培训师" prop="trainer">
              <el-input v-model="queryParams.trainer" placeholder="请输入培训师" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="参与人员" prop="participants">
              <el-input v-model="queryParams.participants" placeholder="请输入参与人员" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="培训学时" prop="trainingHours">
              <el-input v-model="queryParams.trainingHours" placeholder="请输入培训学时" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="评估结果" prop="evaluationResults">
              <el-input v-model="queryParams.evaluationResults" placeholder="请输入评估结果" clearable @keyup.enter="handleQuery" />
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
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['radiation:radiationTraining:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="success" plain icon="Edit" :disabled="single" @click="handleUpdate()" v-hasPermi="['radiation:radiationTraining:edit']"
              >修改</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button type="danger" plain icon="Delete" :disabled="multiple" @click="handleDelete()" v-hasPermi="['radiation:radiationTraining:remove']"
              >删除</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['radiation:radiationTraining:export']">导出</el-button>
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" border :data="radiationTrainingList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="主键ID" align="center" prop="id" v-if="false" />
        <el-table-column label="培训编码" align="center" prop="trainingCode" />
        <el-table-column label="培训名称" align="center" prop="trainingName" />
        <el-table-column label="培训类型" align="center" prop="trainingType" />
        <el-table-column label="培训日期" align="center" prop="trainingDate" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.trainingDate, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="培训师" align="center" prop="trainer" />
        <el-table-column label="参与人员" align="center" prop="participants" />
        <el-table-column label="培训内容" align="center" prop="trainingContent" />
        <el-table-column label="培训学时" align="center" prop="trainingHours" />
        <el-table-column label="评估结果" align="center" prop="evaluationResults" />
        <el-table-column label="状态" align="center" prop="status" />
        <el-table-column label="备注" align="center" prop="remark" />
        <el-table-column label="操作" align="center" fixed="right" class-name="small-padding fixed-width">
          <template #default="scope">
            <el-tooltip content="修改" placement="top">
              <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['radiation:radiationTraining:edit']"></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button
                link
                type="primary"
                icon="Delete"
                @click="handleDelete(scope.row)"
                v-hasPermi="['radiation:radiationTraining:remove']"
              ></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改职业健康培训对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="radiationTrainingFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="培训编码" prop="trainingCode">
          <el-input v-model="form.trainingCode" placeholder="请输入培训编码" />
        </el-form-item>
        <el-form-item label="培训名称" prop="trainingName">
          <el-input v-model="form.trainingName" placeholder="请输入培训名称" />
        </el-form-item>
        <el-form-item label="培训日期" prop="trainingDate">
          <el-date-picker clearable v-model="form.trainingDate" type="datetime" value-format="YYYY-MM-DD HH:mm:ss" placeholder="请选择培训日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="培训师" prop="trainer">
          <el-input v-model="form.trainer" placeholder="请输入培训师" />
        </el-form-item>
        <el-form-item label="参与人员" prop="participants">
          <el-input v-model="form.participants" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="培训内容">
          <editor v-model="form.trainingContent" :min-height="192" />
        </el-form-item>
        <el-form-item label="培训学时" prop="trainingHours">
          <el-input v-model="form.trainingHours" placeholder="请输入培训学时" />
        </el-form-item>
        <el-form-item label="评估结果" prop="evaluationResults">
          <el-input v-model="form.evaluationResults" type="textarea" placeholder="请输入内容" />
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

<script setup name="RadiationTraining" lang="ts">
import {
  listRadiationTraining,
  getRadiationTraining,
  delRadiationTraining,
  addRadiationTraining,
  updateRadiationTraining
} from '@/api/radiation/radiationTraining';
import { RadiationTrainingVO, RadiationTrainingQuery, RadiationTrainingForm } from '@/api/radiation/radiationTraining/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const radiationTrainingList = ref<RadiationTrainingVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const radiationTrainingFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: RadiationTrainingForm = {
  id: undefined,
  trainingCode: undefined,
  trainingName: undefined,
  trainingType: undefined,
  trainingDate: undefined,
  trainer: undefined,
  participants: undefined,
  trainingContent: undefined,
  trainingHours: undefined,
  evaluationResults: undefined,
  status: undefined,
  remark: undefined
};
const data = reactive<PageData<RadiationTrainingForm, RadiationTrainingQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    trainingCode: undefined,
    trainingName: undefined,
    trainingType: undefined,
    trainingDate: undefined,
    trainer: undefined,
    participants: undefined,
    trainingContent: undefined,
    trainingHours: undefined,
    evaluationResults: undefined,
    status: undefined,
    params: {}
  },
  rules: {
    id: [{ required: true, message: '主键ID不能为空', trigger: 'blur' }],
    trainingCode: [{ required: true, message: '培训编码不能为空', trigger: 'blur' }],
    trainingName: [{ required: true, message: '培训名称不能为空', trigger: 'blur' }]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询职业健康培训列表 */
const getList = async () => {
  loading.value = true;
  const res = await listRadiationTraining(queryParams.value);
  radiationTrainingList.value = res.rows;
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
  radiationTrainingFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: RadiationTrainingVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加职业健康培训';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: RadiationTrainingVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getRadiationTraining(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改职业健康培训';
};

/** 提交按钮 */
const submitForm = () => {
  radiationTrainingFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateRadiationTraining(form.value).finally(() => (buttonLoading.value = false));
      } else {
        await addRadiationTraining(form.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: RadiationTrainingVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除职业健康培训编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delRadiationTraining(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/radiationTraining/export',
    {
      ...queryParams.value
    },
    `radiationTraining_${new Date().getTime()}.xlsx`
  );
};

onMounted(() => {
  getList();
});
</script>
