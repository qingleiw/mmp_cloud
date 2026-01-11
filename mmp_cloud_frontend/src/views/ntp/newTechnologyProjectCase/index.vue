<template>
  <div class="p-2">
    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <div v-show="showSearch" class="mb-[10px]">
        <el-card shadow="hover">
          <el-form ref="queryFormRef" :model="queryParams" :inline="true">
            <el-form-item label="患者姓名" prop="patientName">
              <el-input v-model="queryParams.patientName" placeholder="请输入患者姓名" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="就诊号" prop="visitNo">
              <el-input v-model="queryParams.visitNo" placeholder="请输入就诊号" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="就诊日期" prop="visitDate">
              <el-date-picker clearable
                v-model="queryParams.visitDate"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择就诊日期"
              />
            </el-form-item>
            <el-form-item label="就诊科室名称" prop="visitDepartmentName">
              <el-input v-model="queryParams.visitDepartmentName" placeholder="请输入就诊科室名称" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="诊断" prop="diagnosis">
              <el-input v-model="queryParams.diagnosis" placeholder="请输入诊断" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="操作医生" prop="operator">
              <el-input v-model="queryParams.operator" placeholder="请输入操作医生" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="操作时间" prop="operationDate">
              <el-date-picker clearable
                v-model="queryParams.operationDate"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择操作时间"
              />
            </el-form-item>
            <el-form-item label="效果评价" prop="effectEvaluation">
              <el-input v-model="queryParams.effectEvaluation" placeholder="请输入效果评价" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="并发症" prop="complication">
              <el-input v-model="queryParams.complication" placeholder="请输入并发症" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="不良反应" prop="adverseReaction">
              <el-input v-model="queryParams.adverseReaction" placeholder="请输入不良反应" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="随访结果" prop="followUpResult">
              <el-input v-model="queryParams.followUpResult" placeholder="请输入随访结果" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="是否已报备 1-是 0-否" prop="isReported">
              <el-input v-model="queryParams.isReported" placeholder="请输入是否已报备 1-是 0-否" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="报备时间" prop="reportTime">
              <el-date-picker clearable
                v-model="queryParams.reportTime"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择报备时间"
              />
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
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['system:newTechnologyProjectCase:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="success" plain icon="Edit" :disabled="single" @click="handleUpdate()" v-hasPermi="['system:newTechnologyProjectCase:edit']">修改</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="danger" plain icon="Delete" :disabled="multiple" @click="handleDelete()" v-hasPermi="['system:newTechnologyProjectCase:remove']">删除</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['system:newTechnologyProjectCase:export']">导出</el-button>
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" border :data="newTechnologyProjectCaseList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="主键ID" align="center" prop="id" v-if="false" />
        <el-table-column label="患者姓名" align="center" prop="patientName" />
        <el-table-column label="就诊类型 门诊/住院" align="center" prop="visitType" />
        <el-table-column label="就诊号" align="center" prop="visitNo" />
        <el-table-column label="就诊日期" align="center" prop="visitDate" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.visitDate, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="就诊科室名称" align="center" prop="visitDepartmentName" />
        <el-table-column label="诊断" align="center" prop="diagnosis" />
        <el-table-column label="操作医生" align="center" prop="operator" />
        <el-table-column label="操作时间" align="center" prop="operationDate" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.operationDate, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="效果评价" align="center" prop="effectEvaluation" />
        <el-table-column label="并发症" align="center" prop="complication" />
        <el-table-column label="不良反应" align="center" prop="adverseReaction" />
        <el-table-column label="随访状态" align="center" prop="followUpStatus" />
        <el-table-column label="随访结果" align="center" prop="followUpResult" />
        <el-table-column label="是否已报备 1-是 0-否" align="center" prop="isReported" />
        <el-table-column label="报备时间" align="center" prop="reportTime" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.reportTime, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="备注" align="center" prop="remark" />
        <el-table-column label="操作" align="center" fixed="right"  class-name="small-padding fixed-width">
          <template #default="scope">
            <el-tooltip content="修改" placement="top">
              <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['system:newTechnologyProjectCase:edit']"></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)" v-hasPermi="['system:newTechnologyProjectCase:remove']"></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改新技术病例登记对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="newTechnologyProjectCaseFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="项目ID" prop="projectId">
          <el-input v-model="form.projectId" placeholder="请输入项目ID" />
        </el-form-item>
        <el-form-item label="患者ID" prop="patientId">
          <el-input v-model="form.patientId" placeholder="请输入患者ID" />
        </el-form-item>
        <el-form-item label="患者姓名" prop="patientName">
          <el-input v-model="form.patientName" placeholder="请输入患者姓名" />
        </el-form-item>
        <el-form-item label="就诊号" prop="visitNo">
          <el-input v-model="form.visitNo" placeholder="请输入就诊号" />
        </el-form-item>
        <el-form-item label="就诊日期" prop="visitDate">
          <el-date-picker clearable
            v-model="form.visitDate"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择就诊日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="就诊科室ID" prop="visitDepartmentId">
          <el-input v-model="form.visitDepartmentId" placeholder="请输入就诊科室ID" />
        </el-form-item>
        <el-form-item label="就诊科室名称" prop="visitDepartmentName">
          <el-input v-model="form.visitDepartmentName" placeholder="请输入就诊科室名称" />
        </el-form-item>
        <el-form-item label="诊断" prop="diagnosis">
            <el-input v-model="form.diagnosis" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="操作医生" prop="operator">
          <el-input v-model="form.operator" placeholder="请输入操作医生" />
        </el-form-item>
        <el-form-item label="操作时间" prop="operationDate">
          <el-date-picker clearable
            v-model="form.operationDate"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择操作时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="效果评价" prop="effectEvaluation">
            <el-input v-model="form.effectEvaluation" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="并发症" prop="complication">
            <el-input v-model="form.complication" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="不良反应" prop="adverseReaction">
            <el-input v-model="form.adverseReaction" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="随访结果" prop="followUpResult">
            <el-input v-model="form.followUpResult" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="是否已报备 1-是 0-否" prop="isReported">
          <el-input v-model="form.isReported" placeholder="请输入是否已报备 1-是 0-否" />
        </el-form-item>
        <el-form-item label="报备时间" prop="reportTime">
          <el-date-picker clearable
            v-model="form.reportTime"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择报备时间">
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

<script setup name="NewTechnologyProjectCase" lang="ts">
import { listNewTechnologyProjectCase, getNewTechnologyProjectCase, delNewTechnologyProjectCase, addNewTechnologyProjectCase, updateNewTechnologyProjectCase } from '@/api/system/newTechnologyProjectCase';
import { NewTechnologyProjectCaseVO, NewTechnologyProjectCaseQuery, NewTechnologyProjectCaseForm } from '@/api/system/newTechnologyProjectCase/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const newTechnologyProjectCaseList = ref<NewTechnologyProjectCaseVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const newTechnologyProjectCaseFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: NewTechnologyProjectCaseForm = {
  id: undefined,
  projectId: undefined,
  patientId: undefined,
  patientName: undefined,
  visitType: undefined,
  visitNo: undefined,
  visitDate: undefined,
  visitDepartmentId: undefined,
  visitDepartmentName: undefined,
  diagnosis: undefined,
  operator: undefined,
  operationDate: undefined,
  effectEvaluation: undefined,
  complication: undefined,
  adverseReaction: undefined,
  followUpStatus: undefined,
  followUpResult: undefined,
  isReported: undefined,
  reportTime: undefined,
  remark: undefined
}
const data = reactive<PageData<NewTechnologyProjectCaseForm, NewTechnologyProjectCaseQuery>>({
  form: {...initFormData},
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    patientName: undefined,
    visitType: undefined,
    visitNo: undefined,
    visitDate: undefined,
    visitDepartmentName: undefined,
    diagnosis: undefined,
    operator: undefined,
    operationDate: undefined,
    effectEvaluation: undefined,
    complication: undefined,
    adverseReaction: undefined,
    followUpStatus: undefined,
    followUpResult: undefined,
    isReported: undefined,
    reportTime: undefined,
    params: {
    }
  },
  rules: {
    id: [
      { required: true, message: "主键ID不能为空", trigger: "blur" }
    ],
    projectId: [
      { required: true, message: "项目ID不能为空", trigger: "blur" }
    ],
    patientId: [
      { required: true, message: "患者ID不能为空", trigger: "blur" }
    ],
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询新技术病例登记列表 */
const getList = async () => {
  loading.value = true;
  const res = await listNewTechnologyProjectCase(queryParams.value);
  newTechnologyProjectCaseList.value = res.rows;
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
  newTechnologyProjectCaseFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: NewTechnologyProjectCaseVO[]) => {
  ids.value = selection.map(item => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
}

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = "添加新技术病例登记";
}

/** 修改按钮操作 */
const handleUpdate = async (row?: NewTechnologyProjectCaseVO) => {
  reset();
  const _id = row?.id || ids.value[0]
  const res = await getNewTechnologyProjectCase(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = "修改新技术病例登记";
}

/** 提交按钮 */
const submitForm = () => {
  newTechnologyProjectCaseFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateNewTechnologyProjectCase(form.value).finally(() =>  buttonLoading.value = false);
      } else {
        await addNewTechnologyProjectCase(form.value).finally(() =>  buttonLoading.value = false);
      }
      proxy?.$modal.msgSuccess("操作成功");
      dialog.visible = false;
      await getList();
    }
  });
}

/** 删除按钮操作 */
const handleDelete = async (row?: NewTechnologyProjectCaseVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除新技术病例登记编号为"' + _ids + '"的数据项？').finally(() => loading.value = false);
  await delNewTechnologyProjectCase(_ids);
  proxy?.$modal.msgSuccess("删除成功");
  await getList();
}

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download('system/newTechnologyProjectCase/export', {
    ...queryParams.value
  }, `newTechnologyProjectCase_${new Date().getTime()}.xlsx`)
}

onMounted(() => {
  getList();
});
</script>
