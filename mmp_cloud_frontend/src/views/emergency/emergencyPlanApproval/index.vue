<template>
  <div class="p-2">
    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <div v-show="showSearch" class="mb-[10px]">
        <el-card shadow="hover">
          <el-form ref="queryFormRef" :model="queryParams" :inline="true">
            <el-form-item label="审批阶段" prop="approvalStage">
              <el-input v-model="queryParams.approvalStage" placeholder="请输入审批阶段" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="审批人姓名" prop="approverName">
              <el-input v-model="queryParams.approverName" placeholder="请输入审批人姓名" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="审批意见" prop="approvalOpinion">
              <el-input v-model="queryParams.approvalOpinion" placeholder="请输入审批意见" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="审批结果：approved-通过，rejected-驳回" prop="approvalResult">
              <el-input
                v-model="queryParams.approvalResult"
                placeholder="请输入审批结果：approved-通过，rejected-驳回"
                clearable
                @keyup.enter="handleQuery"
              />
            </el-form-item>
            <el-form-item label="审批时间" prop="approvalTime">
              <el-date-picker clearable v-model="queryParams.approvalTime" type="date" value-format="YYYY-MM-DD" placeholder="请选择审批时间" />
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
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['system:emergencyPlanApproval:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="success" plain icon="Edit" :disabled="single" @click="handleUpdate()" v-hasPermi="['system:emergencyPlanApproval:edit']"
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
              v-hasPermi="['system:emergencyPlanApproval:remove']"
              >删除</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['system:emergencyPlanApproval:export']"
              >导出</el-button
            >
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" border :data="emergencyPlanApprovalList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="主键ID" align="center" prop="id" v-if="false" />
        <el-table-column label="审批阶段" align="center" prop="approvalStage" />
        <el-table-column label="审批人姓名" align="center" prop="approverName" />
        <el-table-column label="审批意见" align="center" prop="approvalOpinion" />
        <el-table-column label="审批结果：approved-通过，rejected-驳回" align="center" prop="approvalResult" />
        <el-table-column label="审批时间" align="center" prop="approvalTime" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.approvalTime, '{y}-{m}-{d}') }}</span>
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
                v-hasPermi="['system:emergencyPlanApproval:edit']"
              ></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button
                link
                type="primary"
                icon="Delete"
                @click="handleDelete(scope.row)"
                v-hasPermi="['system:emergencyPlanApproval:remove']"
              ></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改应急预案审批对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="emergencyPlanApprovalFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="预案ID" prop="planId">
          <el-input v-model="form.planId" placeholder="请输入预案ID" />
        </el-form-item>
        <el-form-item label="审批阶段" prop="approvalStage">
          <el-input v-model="form.approvalStage" placeholder="请输入审批阶段" />
        </el-form-item>
        <el-form-item label="审批人ID" prop="approverId">
          <el-input v-model="form.approverId" placeholder="请输入审批人ID" />
        </el-form-item>
        <el-form-item label="审批人姓名" prop="approverName">
          <el-input v-model="form.approverName" placeholder="请输入审批人姓名" />
        </el-form-item>
        <el-form-item label="审批意见" prop="approvalOpinion">
          <el-input v-model="form.approvalOpinion" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="审批结果：approved-通过，rejected-驳回" prop="approvalResult">
          <el-input v-model="form.approvalResult" placeholder="请输入审批结果：approved-通过，rejected-驳回" />
        </el-form-item>
        <el-form-item label="审批时间" prop="approvalTime">
          <el-date-picker clearable v-model="form.approvalTime" type="datetime" value-format="YYYY-MM-DD HH:mm:ss" placeholder="请选择审批时间">
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

<script setup name="EmergencyPlanApproval" lang="ts">
import {
  listEmergencyPlanApproval,
  getEmergencyPlanApproval,
  delEmergencyPlanApproval,
  addEmergencyPlanApproval,
  updateEmergencyPlanApproval
} from '@/api/system/emergencyPlanApproval';
import { EmergencyPlanApprovalVO, EmergencyPlanApprovalQuery, EmergencyPlanApprovalForm } from '@/api/system/emergencyPlanApproval/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const emergencyPlanApprovalList = ref<EmergencyPlanApprovalVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const emergencyPlanApprovalFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: EmergencyPlanApprovalForm = {
  id: undefined,
  planId: undefined,
  approvalStage: undefined,
  approverId: undefined,
  approverName: undefined,
  approvalOpinion: undefined,
  approvalResult: undefined,
  approvalTime: undefined,
  remark: undefined
};
const data = reactive<PageData<EmergencyPlanApprovalForm, EmergencyPlanApprovalQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    approvalStage: undefined,
    approverName: undefined,
    approvalOpinion: undefined,
    approvalResult: undefined,
    approvalTime: undefined,
    params: {}
  },
  rules: {
    id: [{ required: true, message: '主键ID不能为空', trigger: 'blur' }],
    planId: [{ required: true, message: '预案ID不能为空', trigger: 'blur' }]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询应急预案审批列表 */
const getList = async () => {
  loading.value = true;
  const res = await listEmergencyPlanApproval(queryParams.value);
  emergencyPlanApprovalList.value = res.rows;
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
  emergencyPlanApprovalFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: EmergencyPlanApprovalVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加应急预案审批';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: EmergencyPlanApprovalVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getEmergencyPlanApproval(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改应急预案审批';
};

/** 提交按钮 */
const submitForm = () => {
  emergencyPlanApprovalFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateEmergencyPlanApproval(form.value).finally(() => (buttonLoading.value = false));
      } else {
        await addEmergencyPlanApproval(form.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: EmergencyPlanApprovalVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除应急预案审批编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delEmergencyPlanApproval(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/emergencyPlanApproval/export',
    {
      ...queryParams.value
    },
    `emergencyPlanApproval_${new Date().getTime()}.xlsx`
  );
};

onMounted(() => {
  getList();
});
</script>
