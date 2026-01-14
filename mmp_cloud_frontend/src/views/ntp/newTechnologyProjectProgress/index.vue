<template>
  <div class="p-2">
    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <div v-show="showSearch" class="mb-[10px]">
        <el-card shadow="hover">
          <el-form ref="queryFormRef" :model="queryParams" :inline="true">
            <el-form-item label="报告编号" prop="reportNo">
              <el-input v-model="queryParams.reportNo" placeholder="请输入报告编号" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="报告期间" prop="reportPeriod">
              <el-input v-model="queryParams.reportPeriod" placeholder="请输入报告期间" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="报告日期" prop="reportDate">
              <el-date-picker clearable
                v-model="queryParams.reportDate"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择报告日期"
              />
            </el-form-item>
            <el-form-item label="开展病例数" prop="caseCount">
              <el-input v-model="queryParams.caseCount" placeholder="请输入开展病例数" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="成功病例数" prop="successCount">
              <el-input v-model="queryParams.successCount" placeholder="请输入成功病例数" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="并发症例数" prop="complicationCount">
              <el-input v-model="queryParams.complicationCount" placeholder="请输入并发症例数" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="不良反应例数" prop="adverseReactionCount">
              <el-input v-model="queryParams.adverseReactionCount" placeholder="请输入不良反应例数" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="死亡例数" prop="mortalityCount">
              <el-input v-model="queryParams.mortalityCount" placeholder="请输入死亡例数" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="效果评价" prop="effectEvaluation">
              <el-input v-model="queryParams.effectEvaluation" placeholder="请输入效果评价" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="存在问题" prop="existingProblems">
              <el-input v-model="queryParams.existingProblems" placeholder="请输入存在问题" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="改进措施" prop="improvementMeasures">
              <el-input v-model="queryParams.improvementMeasures" placeholder="请输入改进措施" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="下步计划" prop="nextPlan">
              <el-input v-model="queryParams.nextPlan" placeholder="请输入下步计划" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="运行监测指标JSON" prop="monitoringIndicators">
              <el-input v-model="queryParams.monitoringIndicators" placeholder="请输入运行监测指标JSON" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="附件URLs" prop="attachmentUrls">
              <el-input v-model="queryParams.attachmentUrls" placeholder="请输入附件URLs" clearable @keyup.enter="handleQuery" />
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
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['ntp:newTechnologyProjectProgress:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="success" plain icon="Edit" :disabled="single" @click="handleUpdate()" v-hasPermi="['ntp:newTechnologyProjectProgress:edit']">修改</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="danger" plain icon="Delete" :disabled="multiple" @click="handleDelete()" v-hasPermi="['ntp:newTechnologyProjectProgress:remove']">删除</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['ntp:newTechnologyProjectProgress:export']">导出</el-button>
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" border :data="newTechnologyProjectProgressList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="主键ID" align="center" prop="id" v-if="false" />
        <el-table-column label="报告编号" align="center" prop="reportNo" />
        <el-table-column label="报告类型 进展报告/结题报告" align="center" prop="reportType" />
        <el-table-column label="报告期间" align="center" prop="reportPeriod" />
        <el-table-column label="报告日期" align="center" prop="reportDate" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.reportDate, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="开展病例数" align="center" prop="caseCount" />
        <el-table-column label="成功病例数" align="center" prop="successCount" />
        <el-table-column label="并发症例数" align="center" prop="complicationCount" />
        <el-table-column label="不良反应例数" align="center" prop="adverseReactionCount" />
        <el-table-column label="死亡例数" align="center" prop="mortalityCount" />
        <el-table-column label="效果评价" align="center" prop="effectEvaluation" />
        <el-table-column label="存在问题" align="center" prop="existingProblems" />
        <el-table-column label="改进措施" align="center" prop="improvementMeasures" />
        <el-table-column label="下步计划" align="center" prop="nextPlan" />
        <el-table-column label="继续状态 继续开展/终止/暂停" align="center" prop="continueStatus" />
        <el-table-column label="运行监测指标JSON" align="center" prop="monitoringIndicators" />
        <el-table-column label="附件URLs" align="center" prop="attachmentUrls" />
        <el-table-column label="报告状态" align="center" prop="reportStatus" />
        <el-table-column label="备注" align="center" prop="remark" />
        <el-table-column label="操作" align="center" fixed="right"  class-name="small-padding fixed-width">
          <template #default="scope">
            <el-tooltip content="修改" placement="top">
              <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['ntp:newTechnologyProjectProgress:edit']"></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)" v-hasPermi="['ntp:newTechnologyProjectProgress:remove']"></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改新技术进展报告对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="newTechnologyProjectProgressFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="报告编号" prop="reportNo">
          <el-input v-model="form.reportNo" placeholder="请输入报告编号" />
        </el-form-item>
        <el-form-item label="项目ID" prop="projectId">
          <el-input v-model="form.projectId" placeholder="请输入项目ID" />
        </el-form-item>
        <el-form-item label="报告期间" prop="reportPeriod">
          <el-input v-model="form.reportPeriod" placeholder="请输入报告期间" />
        </el-form-item>
        <el-form-item label="报告日期" prop="reportDate">
          <el-date-picker clearable
            v-model="form.reportDate"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择报告日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="开展病例数" prop="caseCount">
          <el-input v-model="form.caseCount" placeholder="请输入开展病例数" />
        </el-form-item>
        <el-form-item label="成功病例数" prop="successCount">
          <el-input v-model="form.successCount" placeholder="请输入成功病例数" />
        </el-form-item>
        <el-form-item label="并发症例数" prop="complicationCount">
          <el-input v-model="form.complicationCount" placeholder="请输入并发症例数" />
        </el-form-item>
        <el-form-item label="不良反应例数" prop="adverseReactionCount">
          <el-input v-model="form.adverseReactionCount" placeholder="请输入不良反应例数" />
        </el-form-item>
        <el-form-item label="死亡例数" prop="mortalityCount">
          <el-input v-model="form.mortalityCount" placeholder="请输入死亡例数" />
        </el-form-item>
        <el-form-item label="效果评价" prop="effectEvaluation">
            <el-input v-model="form.effectEvaluation" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="存在问题" prop="existingProblems">
            <el-input v-model="form.existingProblems" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="改进措施" prop="improvementMeasures">
            <el-input v-model="form.improvementMeasures" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="下步计划" prop="nextPlan">
            <el-input v-model="form.nextPlan" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="运行监测指标JSON" prop="monitoringIndicators">
            <el-input v-model="form.monitoringIndicators" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="附件URLs" prop="attachmentUrls">
            <el-input v-model="form.attachmentUrls" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="工作流实例ID" prop="workflowInstanceId">
          <el-input v-model="form.workflowInstanceId" placeholder="请输入工作流实例ID" />
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

<script setup name="NewTechnologyProjectProgress" lang="ts">
import { listNewTechnologyProjectProgress, getNewTechnologyProjectProgress, delNewTechnologyProjectProgress, addNewTechnologyProjectProgress, updateNewTechnologyProjectProgress } from '@/api/ntp/newTechnologyProjectProgress';
import { NewTechnologyProjectProgressVO, NewTechnologyProjectProgressQuery, NewTechnologyProjectProgressForm } from '@/api/ntp/newTechnologyProjectProgress/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const newTechnologyProjectProgressList = ref<NewTechnologyProjectProgressVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const newTechnologyProjectProgressFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: NewTechnologyProjectProgressForm = {
  id: undefined,
  reportNo: undefined,
  projectId: undefined,
  reportType: undefined,
  reportPeriod: undefined,
  reportDate: undefined,
  caseCount: undefined,
  successCount: undefined,
  complicationCount: undefined,
  adverseReactionCount: undefined,
  mortalityCount: undefined,
  effectEvaluation: undefined,
  existingProblems: undefined,
  improvementMeasures: undefined,
  nextPlan: undefined,
  continueStatus: undefined,
  monitoringIndicators: undefined,
  attachmentUrls: undefined,
  reportStatus: undefined,
  workflowInstanceId: undefined,
  remark: undefined
}
const data = reactive<PageData<NewTechnologyProjectProgressForm, NewTechnologyProjectProgressQuery>>({
  form: {...initFormData},
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    reportNo: undefined,
    reportType: undefined,
    reportPeriod: undefined,
    reportDate: undefined,
    caseCount: undefined,
    successCount: undefined,
    complicationCount: undefined,
    adverseReactionCount: undefined,
    mortalityCount: undefined,
    effectEvaluation: undefined,
    existingProblems: undefined,
    improvementMeasures: undefined,
    nextPlan: undefined,
    continueStatus: undefined,
    monitoringIndicators: undefined,
    attachmentUrls: undefined,
    reportStatus: undefined,
    params: {
    }
  },
  rules: {
    id: [
      { required: true, message: "主键ID不能为空", trigger: "blur" }
    ],
    reportNo: [
      { required: true, message: "报告编号不能为空", trigger: "blur" }
    ],
    projectId: [
      { required: true, message: "项目ID不能为空", trigger: "blur" }
    ],
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询新技术进展报告列表 */
const getList = async () => {
  loading.value = true;
  const res = await listNewTechnologyProjectProgress(queryParams.value);
  newTechnologyProjectProgressList.value = res.rows;
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
  newTechnologyProjectProgressFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: NewTechnologyProjectProgressVO[]) => {
  ids.value = selection.map(item => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
}

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = "添加新技术进展报告";
}

/** 修改按钮操作 */
const handleUpdate = async (row?: NewTechnologyProjectProgressVO) => {
  reset();
  const _id = row?.id || ids.value[0]
  const res = await getNewTechnologyProjectProgress(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = "修改新技术进展报告";
}

/** 提交按钮 */
const submitForm = () => {
  newTechnologyProjectProgressFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateNewTechnologyProjectProgress(form.value).finally(() =>  buttonLoading.value = false);
      } else {
        await addNewTechnologyProjectProgress(form.value).finally(() =>  buttonLoading.value = false);
      }
      proxy?.$modal.msgSuccess("操作成功");
      dialog.visible = false;
      await getList();
    }
  });
}

/** 删除按钮操作 */
const handleDelete = async (row?: NewTechnologyProjectProgressVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除新技术进展报告编号为"' + _ids + '"的数据项？').finally(() => loading.value = false);
  await delNewTechnologyProjectProgress(_ids);
  proxy?.$modal.msgSuccess("删除成功");
  await getList();
}

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download('system/newTechnologyProjectProgress/export', {
    ...queryParams.value
  }, `newTechnologyProjectProgress_${new Date().getTime()}.xlsx`)
}

onMounted(() => {
  getList();
});
</script>
