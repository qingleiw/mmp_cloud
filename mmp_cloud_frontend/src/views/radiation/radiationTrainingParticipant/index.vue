<template>
  <div class="p-2">
    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <div v-show="showSearch" class="mb-[10px]">
        <el-card shadow="hover">
          <el-form ref="queryFormRef" :model="queryParams" :inline="true">
            <el-form-item label="工作人员姓名" prop="staffName">
              <el-input v-model="queryParams.staffName" placeholder="请输入工作人员姓名" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="培训成绩" prop="score">
              <el-input v-model="queryParams.score" placeholder="请输入培训成绩" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="评价" prop="evaluation">
              <el-input v-model="queryParams.evaluation" placeholder="请输入评价" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="是否发放证书：0-否，1-是" prop="certificateIssued">
              <el-input v-model="queryParams.certificateIssued" placeholder="请输入是否发放证书：0-否，1-是" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="证书编号" prop="certificateNumber">
              <el-input v-model="queryParams.certificateNumber" placeholder="请输入证书编号" clearable @keyup.enter="handleQuery" />
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
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['system:radiationTrainingParticipant:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button
              type="success"
              plain
              icon="Edit"
              :disabled="single"
              @click="handleUpdate()"
              v-hasPermi="['system:radiationTrainingParticipant:edit']"
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
              v-hasPermi="['system:radiationTrainingParticipant:remove']"
              >删除</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['system:radiationTrainingParticipant:export']"
              >导出</el-button
            >
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" border :data="radiationTrainingParticipantList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="主键ID" align="center" prop="id" v-if="false" />
        <el-table-column label="工作人员姓名" align="center" prop="staffName" />
        <el-table-column label="出席状态：registered-已报名，attended-出席，absent-缺席" align="center" prop="attendanceStatus" />
        <el-table-column label="培训成绩" align="center" prop="score" />
        <el-table-column label="评价" align="center" prop="evaluation" />
        <el-table-column label="是否发放证书：0-否，1-是" align="center" prop="certificateIssued" />
        <el-table-column label="证书编号" align="center" prop="certificateNumber" />
        <el-table-column label="备注" align="center" prop="remark" />
        <el-table-column label="操作" align="center" fixed="right" class-name="small-padding fixed-width">
          <template #default="scope">
            <el-tooltip content="修改" placement="top">
              <el-button
                link
                type="primary"
                icon="Edit"
                @click="handleUpdate(scope.row)"
                v-hasPermi="['system:radiationTrainingParticipant:edit']"
              ></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button
                link
                type="primary"
                icon="Delete"
                @click="handleDelete(scope.row)"
                v-hasPermi="['system:radiationTrainingParticipant:remove']"
              ></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改培训参与记录对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="radiationTrainingParticipantFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="培训计划ID" prop="planId">
          <el-input v-model="form.planId" placeholder="请输入培训计划ID" />
        </el-form-item>
        <el-form-item label="工作人员ID" prop="staffId">
          <el-input v-model="form.staffId" placeholder="请输入工作人员ID" />
        </el-form-item>
        <el-form-item label="工作人员姓名" prop="staffName">
          <el-input v-model="form.staffName" placeholder="请输入工作人员姓名" />
        </el-form-item>
        <el-form-item label="培训成绩" prop="score">
          <el-input v-model="form.score" placeholder="请输入培训成绩" />
        </el-form-item>
        <el-form-item label="评价" prop="evaluation">
          <el-input v-model="form.evaluation" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="是否发放证书：0-否，1-是" prop="certificateIssued">
          <el-input v-model="form.certificateIssued" placeholder="请输入是否发放证书：0-否，1-是" />
        </el-form-item>
        <el-form-item label="证书编号" prop="certificateNumber">
          <el-input v-model="form.certificateNumber" placeholder="请输入证书编号" />
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

<script setup name="RadiationTrainingParticipant" lang="ts">
import {
  listRadiationTrainingParticipant,
  getRadiationTrainingParticipant,
  delRadiationTrainingParticipant,
  addRadiationTrainingParticipant,
  updateRadiationTrainingParticipant
} from '@/api/radiation/radiationTrainingParticipant';
import {
  RadiationTrainingParticipantVO,
  RadiationTrainingParticipantQuery,
  RadiationTrainingParticipantForm
} from '@/api/radiation/radiationTrainingParticipant/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const radiationTrainingParticipantList = ref<RadiationTrainingParticipantVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const radiationTrainingParticipantFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: RadiationTrainingParticipantForm = {
  id: undefined,
  planId: undefined,
  staffId: undefined,
  staffName: undefined,
  attendanceStatus: undefined,
  score: undefined,
  evaluation: undefined,
  certificateIssued: undefined,
  certificateNumber: undefined,
  remark: undefined
};
const data = reactive<PageData<RadiationTrainingParticipantForm, RadiationTrainingParticipantQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    staffName: undefined,
    attendanceStatus: undefined,
    score: undefined,
    evaluation: undefined,
    certificateIssued: undefined,
    certificateNumber: undefined,
    params: {}
  },
  rules: {
    id: [{ required: true, message: '主键ID不能为空', trigger: 'blur' }],
    planId: [{ required: true, message: '培训计划ID不能为空', trigger: 'blur' }],
    staffId: [{ required: true, message: '工作人员ID不能为空', trigger: 'blur' }]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询培训参与记录列表 */
const getList = async () => {
  loading.value = true;
  const res = await listRadiationTrainingParticipant(queryParams.value);
  radiationTrainingParticipantList.value = res.rows;
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
  radiationTrainingParticipantFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: RadiationTrainingParticipantVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加培训参与记录';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: RadiationTrainingParticipantVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getRadiationTrainingParticipant(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改培训参与记录';
};

/** 提交按钮 */
const submitForm = () => {
  radiationTrainingParticipantFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateRadiationTrainingParticipant(form.value).finally(() => (buttonLoading.value = false));
      } else {
        await addRadiationTrainingParticipant(form.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: RadiationTrainingParticipantVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除培训参与记录编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delRadiationTrainingParticipant(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/radiationTrainingParticipant/export',
    {
      ...queryParams.value
    },
    `radiationTrainingParticipant_${new Date().getTime()}.xlsx`
  );
};

onMounted(() => {
  getList();
});
</script>
