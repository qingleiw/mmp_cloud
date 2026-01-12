<template>
  <div class="p-2">
    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <div v-show="showSearch" class="mb-[10px]">
        <el-card shadow="hover">
          <el-form ref="queryFormRef" :model="queryParams" :inline="true">
            <el-form-item label="学习日期" prop="learningDate">
              <el-date-picker clearable
                v-model="queryParams.learningDate"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择学习日期"
              />
            </el-form-item>
            <el-form-item label="学习主题" prop="learningTopic">
              <el-input v-model="queryParams.learningTopic" placeholder="请输入学习主题" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="组织者" prop="organizer">
              <el-input v-model="queryParams.organizer" placeholder="请输入组织者" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="参与人员" prop="participants">
              <el-input v-model="queryParams.participants" placeholder="请输入参与人员" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="学习学时" prop="learningHours">
              <el-input v-model="queryParams.learningHours" placeholder="请输入学习学时" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="授课人" prop="instructor">
              <el-input v-model="queryParams.instructor" placeholder="请输入授课人" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="评价结果" prop="evaluationResults">
              <el-input v-model="queryParams.evaluationResults" placeholder="请输入评价结果" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="附件" prop="attachments">
              <el-input v-model="queryParams.attachments" placeholder="请输入附件" clearable @keyup.enter="handleQuery" />
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
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['ledger:ledgerBusinessLearning:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="success" plain icon="Edit" :disabled="single" @click="handleUpdate()" v-hasPermi="['ledger:ledgerBusinessLearning:edit']">修改</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="danger" plain icon="Delete" :disabled="multiple" @click="handleDelete()" v-hasPermi="['ledger:ledgerBusinessLearning:remove']">删除</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['ledger:ledgerBusinessLearning:export']">导出</el-button>
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" border :data="ledgerBusinessLearningList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="主键ID" align="center" prop="id" v-if="false" />
        <el-table-column label="学习日期" align="center" prop="learningDate" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.learningDate, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="学习主题" align="center" prop="learningTopic" />
        <el-table-column label="学习类型" align="center" prop="learningType" />
        <el-table-column label="组织者" align="center" prop="organizer" />
        <el-table-column label="参与人员" align="center" prop="participants" />
        <el-table-column label="学习内容" align="center" prop="learningContent" />
        <el-table-column label="学习学时" align="center" prop="learningHours" />
        <el-table-column label="授课人" align="center" prop="instructor" />
        <el-table-column label="评价结果" align="center" prop="evaluationResults" />
        <el-table-column label="附件" align="center" prop="attachments" />
        <el-table-column label="状态" align="center" prop="status" />
        <el-table-column label="备注" align="center" prop="remark" />
        <el-table-column label="操作" align="center" fixed="right"  class-name="small-padding fixed-width">
          <template #default="scope">
            <el-tooltip content="修改" placement="top">
              <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['ledger:ledgerBusinessLearning:edit']"></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)" v-hasPermi="['ledger:ledgerBusinessLearning:remove']"></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改业务学习记录本对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="ledgerBusinessLearningFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="学习日期" prop="learningDate">
          <el-date-picker clearable
            v-model="form.learningDate"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择学习日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="学习主题" prop="learningTopic">
          <el-input v-model="form.learningTopic" placeholder="请输入学习主题" />
        </el-form-item>
        <el-form-item label="组织者" prop="organizer">
          <el-input v-model="form.organizer" placeholder="请输入组织者" />
        </el-form-item>
        <el-form-item label="参与人员" prop="participants">
            <el-input v-model="form.participants" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="学习内容">
          <editor v-model="form.learningContent" :min-height="192"/>
        </el-form-item>
        <el-form-item label="学习学时" prop="learningHours">
          <el-input v-model="form.learningHours" placeholder="请输入学习学时" />
        </el-form-item>
        <el-form-item label="授课人" prop="instructor">
          <el-input v-model="form.instructor" placeholder="请输入授课人" />
        </el-form-item>
        <el-form-item label="评价结果" prop="evaluationResults">
            <el-input v-model="form.evaluationResults" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="附件" prop="attachments">
            <el-input v-model="form.attachments" type="textarea" placeholder="请输入内容" />
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

<script setup name="LedgerBusinessLearning" lang="ts">
import { listLedgerBusinessLearning, getLedgerBusinessLearning, delLedgerBusinessLearning, addLedgerBusinessLearning, updateLedgerBusinessLearning } from '@/api/ledger/ledgerBusinessLearning';
import { LedgerBusinessLearningVO, LedgerBusinessLearningQuery, LedgerBusinessLearningForm } from '@/api/ledger/ledgerBusinessLearning/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const ledgerBusinessLearningList = ref<LedgerBusinessLearningVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const ledgerBusinessLearningFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: LedgerBusinessLearningForm = {
  id: undefined,
  learningDate: undefined,
  learningTopic: undefined,
  learningType: undefined,
  organizer: undefined,
  participants: undefined,
  learningContent: undefined,
  learningHours: undefined,
  instructor: undefined,
  evaluationResults: undefined,
  attachments: undefined,
  status: undefined,
  remark: undefined
}
const data = reactive<PageData<LedgerBusinessLearningForm, LedgerBusinessLearningQuery>>({
  form: {...initFormData},
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    learningDate: undefined,
    learningTopic: undefined,
    learningType: undefined,
    organizer: undefined,
    participants: undefined,
    learningContent: undefined,
    learningHours: undefined,
    instructor: undefined,
    evaluationResults: undefined,
    attachments: undefined,
    status: undefined,
    params: {
    }
  },
  rules: {
    id: [
      { required: true, message: "主键ID不能为空", trigger: "blur" }
    ],
    learningDate: [
      { required: true, message: "学习日期不能为空", trigger: "blur" }
    ],
    learningTopic: [
      { required: true, message: "学习主题不能为空", trigger: "blur" }
    ],
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询业务学习记录本列表 */
const getList = async () => {
  loading.value = true;
  const res = await listLedgerBusinessLearning(queryParams.value);
  ledgerBusinessLearningList.value = res.rows;
  total.value = res.total;
  loading.value = false;
}

/** 取消按钮 */
const cancel = () => {
  reset();
  dialog.visible = false;
}

/** 表单重置 */
const reset = () => {
  form.value = {...initFormData};
  ledgerBusinessLearningFormRef.value?.resetFields();
}

/** 搜索按钮操作 */
const handleQuery = () => {
  queryParams.value.pageNum = 1;
  getList();
}

/** 重置按钮操作 */
const resetQuery = () => {
  queryFormRef.value?.resetFields();
  handleQuery();
}

/** 多选框选中数据 */
const handleSelectionChange = (selection: LedgerBusinessLearningVO[]) => {
  ids.value = selection.map(item => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
}

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = "添加业务学习记录本";
}

/** 修改按钮操作 */
const handleUpdate = async (row?: LedgerBusinessLearningVO) => {
  reset();
  const _id = row?.id || ids.value[0]
  const res = await getLedgerBusinessLearning(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = "修改业务学习记录本";
}

/** 提交按钮 */
const submitForm = () => {
  ledgerBusinessLearningFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateLedgerBusinessLearning(form.value).finally(() =>  buttonLoading.value = false);
      } else {
        await addLedgerBusinessLearning(form.value).finally(() =>  buttonLoading.value = false);
      }
      proxy?.$modal.msgSuccess("操作成功");
      dialog.visible = false;
      await getList();
    }
  });
}

/** 删除按钮操作 */
const handleDelete = async (row?: LedgerBusinessLearningVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除业务学习记录本编号为"' + _ids + '"的数据项？').finally(() => loading.value = false);
  await delLedgerBusinessLearning(_ids);
  proxy?.$modal.msgSuccess("删除成功");
  await getList();
}

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download('ledger/ledgerBusinessLearning/export', {
    ...queryParams.value
  }, `ledgerBusinessLearning_${new Date().getTime()}.xlsx`)
}

onMounted(() => {
  getList();
});
</script>
