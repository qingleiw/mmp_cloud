<template>
  <div class="p-2">
    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <div v-show="showSearch" class="mb-[10px]">
        <el-card shadow="hover">
          <el-form ref="queryFormRef" :model="queryParams" :inline="true">
            <el-form-item label="项目编号" prop="projectNo">
              <el-input v-model="queryParams.projectNo" placeholder="请输入项目编号" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="项目名称" prop="projectName">
              <el-input v-model="queryParams.projectName" placeholder="请输入项目名称" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="技术分类" prop="technologyCategory">
              <el-input v-model="queryParams.technologyCategory" placeholder="请输入技术分类" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="风险等级 低风险/中风险/高风险" prop="riskLevel">
              <el-input v-model="queryParams.riskLevel" placeholder="请输入风险等级 低风险/中风险/高风险" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="申请科室ID" prop="applyDepartmentId">
              <el-input v-model="queryParams.applyDepartmentId" placeholder="请输入申请科室ID" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="申请科室名称" prop="applyDepartmentName">
              <el-input v-model="queryParams.applyDepartmentName" placeholder="请输入申请科室名称" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="项目负责人" prop="projectLeader">
              <el-input v-model="queryParams.projectLeader" placeholder="请输入项目负责人" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="项目团队成员" prop="projectTeam">
              <el-input v-model="queryParams.projectTeam" placeholder="请输入项目团队成员" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="技术来源" prop="technologySource">
              <el-input v-model="queryParams.technologySource" placeholder="请输入技术来源" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="申请理由" prop="applyReason">
              <el-input v-model="queryParams.applyReason" placeholder="请输入申请理由" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="技术描述" prop="technologyDescription">
              <el-input v-model="queryParams.technologyDescription" placeholder="请输入技术描述" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="适应症" prop="indication">
              <el-input v-model="queryParams.indication" placeholder="请输入适应症" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="禁忌症" prop="contraindication">
              <el-input v-model="queryParams.contraindication" placeholder="请输入禁忌症" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="预期效果" prop="expectedEffect">
              <el-input v-model="queryParams.expectedEffect" placeholder="请输入预期效果" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="潜在风险" prop="potentialRisk">
              <el-input v-model="queryParams.potentialRisk" placeholder="请输入潜在风险" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="风险控制措施" prop="riskControlMeasure">
              <el-input v-model="queryParams.riskControlMeasure" placeholder="请输入风险控制措施" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="文献支持" prop="literatureSupport">
              <el-input v-model="queryParams.literatureSupport" placeholder="请输入文献支持" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="附件URLs" prop="attachmentUrls">
              <el-input v-model="queryParams.attachmentUrls" placeholder="请输入附件URLs" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="运行周期(天)" prop="operationCycleDays">
              <el-input v-model="queryParams.operationCycleDays" placeholder="请输入运行周期(天)" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="进展报告周期 月度/季度/半年度/年度" prop="progressReportCycle">
              <el-input v-model="queryParams.progressReportCycle" placeholder="请输入进展报告周期 月度/季度/半年度/年度" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="批准日期" prop="approveDate">
              <el-date-picker clearable
                v-model="queryParams.approveDate"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择批准日期"
              />
            </el-form-item>
            <el-form-item label="开始日期" prop="startDate">
              <el-date-picker clearable
                v-model="queryParams.startDate"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择开始日期"
              />
            </el-form-item>
            <el-form-item label="预计结束日期" prop="endDate">
              <el-date-picker clearable
                v-model="queryParams.endDate"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择预计结束日期"
              />
            </el-form-item>
            <el-form-item label="实际结束日期" prop="actualEndDate">
              <el-date-picker clearable
                v-model="queryParams.actualEndDate"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择实际结束日期"
              />
            </el-form-item>
            <el-form-item label="工作流实例ID" prop="workflowInstanceId">
              <el-input v-model="queryParams.workflowInstanceId" placeholder="请输入工作流实例ID" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="是否删除" prop="isDeleted">
              <el-input v-model="queryParams.isDeleted" placeholder="请输入是否删除" clearable @keyup.enter="handleQuery" />
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
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['system:newTechnologyProject:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="success" plain icon="Edit" :disabled="single" @click="handleUpdate()" v-hasPermi="['system:newTechnologyProject:edit']">修改</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="danger" plain icon="Delete" :disabled="multiple" @click="handleDelete()" v-hasPermi="['system:newTechnologyProject:remove']">删除</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['system:newTechnologyProject:export']">导出</el-button>
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" border :data="newTechnologyProjectList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="主键ID" align="center" prop="id" v-if="true" />
        <el-table-column label="项目编号" align="center" prop="projectNo" />
        <el-table-column label="项目名称" align="center" prop="projectName" />
        <el-table-column label="项目类型 新技术/新项目" align="center" prop="projectType" />
        <el-table-column label="技术分类" align="center" prop="technologyCategory" />
        <el-table-column label="风险等级 低风险/中风险/高风险" align="center" prop="riskLevel" />
        <el-table-column label="申请科室ID" align="center" prop="applyDepartmentId" />
        <el-table-column label="申请科室名称" align="center" prop="applyDepartmentName" />
        <el-table-column label="项目负责人" align="center" prop="projectLeader" />
        <el-table-column label="项目团队成员" align="center" prop="projectTeam" />
        <el-table-column label="技术来源" align="center" prop="technologySource" />
        <el-table-column label="申请理由" align="center" prop="applyReason" />
        <el-table-column label="技术描述" align="center" prop="technologyDescription" />
        <el-table-column label="适应症" align="center" prop="indication" />
        <el-table-column label="禁忌症" align="center" prop="contraindication" />
        <el-table-column label="预期效果" align="center" prop="expectedEffect" />
        <el-table-column label="潜在风险" align="center" prop="potentialRisk" />
        <el-table-column label="风险控制措施" align="center" prop="riskControlMeasure" />
        <el-table-column label="文献支持" align="center" prop="literatureSupport" />
        <el-table-column label="附件URLs" align="center" prop="attachmentUrls" />
        <el-table-column label="运行周期(天)" align="center" prop="operationCycleDays" />
        <el-table-column label="进展报告周期 月度/季度/半年度/年度" align="center" prop="progressReportCycle" />
        <el-table-column label="项目状态" align="center" prop="projectStatus" />
        <el-table-column label="批准日期" align="center" prop="approveDate" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.approveDate, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="开始日期" align="center" prop="startDate" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.startDate, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="预计结束日期" align="center" prop="endDate" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.endDate, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="实际结束日期" align="center" prop="actualEndDate" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.actualEndDate, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="结题类型 转常规/终止" align="center" prop="conclusionType" />
        <el-table-column label="工作流实例ID" align="center" prop="workflowInstanceId" />
        <el-table-column label="是否删除" align="center" prop="isDeleted" />
        <el-table-column label="操作" align="center" fixed="right"  class-name="small-padding fixed-width">
          <template #default="scope">
            <el-tooltip content="修改" placement="top">
              <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['system:newTechnologyProject:edit']"></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)" v-hasPermi="['system:newTechnologyProject:remove']"></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改新技术项目基本信息对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="newTechnologyProjectFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="项目编号" prop="projectNo">
          <el-input v-model="form.projectNo" placeholder="请输入项目编号" />
        </el-form-item>
        <el-form-item label="项目名称" prop="projectName">
          <el-input v-model="form.projectName" placeholder="请输入项目名称" />
        </el-form-item>
        <el-form-item label="技术分类" prop="technologyCategory">
          <el-input v-model="form.technologyCategory" placeholder="请输入技术分类" />
        </el-form-item>
        <el-form-item label="风险等级 低风险/中风险/高风险" prop="riskLevel">
          <el-input v-model="form.riskLevel" placeholder="请输入风险等级 低风险/中风险/高风险" />
        </el-form-item>
        <el-form-item label="申请科室ID" prop="applyDepartmentId">
          <el-input v-model="form.applyDepartmentId" placeholder="请输入申请科室ID" />
        </el-form-item>
        <el-form-item label="申请科室名称" prop="applyDepartmentName">
          <el-input v-model="form.applyDepartmentName" placeholder="请输入申请科室名称" />
        </el-form-item>
        <el-form-item label="项目负责人" prop="projectLeader">
          <el-input v-model="form.projectLeader" placeholder="请输入项目负责人" />
        </el-form-item>
        <el-form-item label="项目团队成员" prop="projectTeam">
            <el-input v-model="form.projectTeam" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="技术来源" prop="technologySource">
          <el-input v-model="form.technologySource" placeholder="请输入技术来源" />
        </el-form-item>
        <el-form-item label="申请理由" prop="applyReason">
            <el-input v-model="form.applyReason" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="技术描述" prop="technologyDescription">
            <el-input v-model="form.technologyDescription" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="适应症" prop="indication">
            <el-input v-model="form.indication" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="禁忌症" prop="contraindication">
            <el-input v-model="form.contraindication" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="预期效果" prop="expectedEffect">
            <el-input v-model="form.expectedEffect" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="潜在风险" prop="potentialRisk">
            <el-input v-model="form.potentialRisk" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="风险控制措施" prop="riskControlMeasure">
            <el-input v-model="form.riskControlMeasure" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="文献支持" prop="literatureSupport">
            <el-input v-model="form.literatureSupport" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="附件URLs" prop="attachmentUrls">
            <el-input v-model="form.attachmentUrls" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="运行周期(天)" prop="operationCycleDays">
          <el-input v-model="form.operationCycleDays" placeholder="请输入运行周期(天)" />
        </el-form-item>
        <el-form-item label="进展报告周期 月度/季度/半年度/年度" prop="progressReportCycle">
          <el-input v-model="form.progressReportCycle" placeholder="请输入进展报告周期 月度/季度/半年度/年度" />
        </el-form-item>
        <el-form-item label="批准日期" prop="approveDate">
          <el-date-picker clearable
            v-model="form.approveDate"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择批准日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="开始日期" prop="startDate">
          <el-date-picker clearable
            v-model="form.startDate"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择开始日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="预计结束日期" prop="endDate">
          <el-date-picker clearable
            v-model="form.endDate"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择预计结束日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="实际结束日期" prop="actualEndDate">
          <el-date-picker clearable
            v-model="form.actualEndDate"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择实际结束日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="工作流实例ID" prop="workflowInstanceId">
          <el-input v-model="form.workflowInstanceId" placeholder="请输入工作流实例ID" />
        </el-form-item>
        <el-form-item label="是否删除" prop="isDeleted">
          <el-input v-model="form.isDeleted" placeholder="请输入是否删除" />
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

<script setup name="NewTechnologyProject" lang="ts">
import { listNewTechnologyProject, getNewTechnologyProject, delNewTechnologyProject, addNewTechnologyProject, updateNewTechnologyProject } from '@/api/ntp/newTechnologyProject';
import { NewTechnologyProjectVO, NewTechnologyProjectQuery, NewTechnologyProjectForm } from '@/api/ntp/newTechnologyProject/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const newTechnologyProjectList = ref<NewTechnologyProjectVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const newTechnologyProjectFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: NewTechnologyProjectForm = {
  id: undefined,
  projectNo: undefined,
  projectName: undefined,
  projectType: undefined,
  technologyCategory: undefined,
  riskLevel: undefined,
  applyDepartmentId: undefined,
  applyDepartmentName: undefined,
  projectLeader: undefined,
  projectTeam: undefined,
  technologySource: undefined,
  applyReason: undefined,
  technologyDescription: undefined,
  indication: undefined,
  contraindication: undefined,
  expectedEffect: undefined,
  potentialRisk: undefined,
  riskControlMeasure: undefined,
  literatureSupport: undefined,
  attachmentUrls: undefined,
  operationCycleDays: undefined,
  progressReportCycle: undefined,
  projectStatus: undefined,
  approveDate: undefined,
  startDate: undefined,
  endDate: undefined,
  actualEndDate: undefined,
  conclusionType: undefined,
  workflowInstanceId: undefined,
  isDeleted: undefined,
}
const data = reactive<PageData<NewTechnologyProjectForm, NewTechnologyProjectQuery>>({
  form: {...initFormData},
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    projectNo: undefined,
    projectName: undefined,
    projectType: undefined,
    technologyCategory: undefined,
    riskLevel: undefined,
    applyDepartmentId: undefined,
    applyDepartmentName: undefined,
    projectLeader: undefined,
    projectTeam: undefined,
    technologySource: undefined,
    applyReason: undefined,
    technologyDescription: undefined,
    indication: undefined,
    contraindication: undefined,
    expectedEffect: undefined,
    potentialRisk: undefined,
    riskControlMeasure: undefined,
    literatureSupport: undefined,
    attachmentUrls: undefined,
    operationCycleDays: undefined,
    progressReportCycle: undefined,
    projectStatus: undefined,
    approveDate: undefined,
    startDate: undefined,
    endDate: undefined,
    actualEndDate: undefined,
    conclusionType: undefined,
    workflowInstanceId: undefined,
    isDeleted: undefined,
    params: {
    }
  },
  rules: {
    id: [
      { required: true, message: "主键ID不能为空", trigger: "blur" }
    ],
    projectNo: [
      { required: true, message: "项目编号不能为空", trigger: "blur" }
    ],
    projectName: [
      { required: true, message: "项目名称不能为空", trigger: "blur" }
    ],
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询新技术项目基本信息列表 */
const getList = async () => {
  loading.value = true;
  const res = await listNewTechnologyProject(queryParams.value);
  newTechnologyProjectList.value = res.rows;
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
  newTechnologyProjectFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: NewTechnologyProjectVO[]) => {
  ids.value = selection.map(item => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
}

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = "添加新技术项目基本信息";
}

/** 修改按钮操作 */
const handleUpdate = async (row?: NewTechnologyProjectVO) => {
  reset();
  const _id = row?.id || ids.value[0]
  const res = await getNewTechnologyProject(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = "修改新技术项目基本信息";
}

/** 提交按钮 */
const submitForm = () => {
  newTechnologyProjectFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateNewTechnologyProject(form.value).finally(() =>  buttonLoading.value = false);
      } else {
        await addNewTechnologyProject(form.value).finally(() =>  buttonLoading.value = false);
      }
      proxy?.$modal.msgSuccess("操作成功");
      dialog.visible = false;
      await getList();
    }
  });
}

/** 删除按钮操作 */
const handleDelete = async (row?: NewTechnologyProjectVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除新技术项目基本信息编号为"' + _ids + '"的数据项？').finally(() => loading.value = false);
  await delNewTechnologyProject(_ids);
  proxy?.$modal.msgSuccess("删除成功");
  await getList();
}

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download('system/newTechnologyProject/export', {
    ...queryParams.value
  }, `newTechnologyProject_${new Date().getTime()}.xlsx`)
}

onMounted(() => {
  getList();
});
</script>
