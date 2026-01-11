<template>
  <div class="p-2">
    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <div v-show="showSearch" class="mb-[10px]">
        <el-card shadow="hover">
          <el-form ref="queryFormRef" :model="queryParams" :inline="true">
            <el-form-item label="考核年份" prop="assessmentYear">
              <el-input v-model="queryParams.assessmentYear" placeholder="请输入考核年份" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="考核日期" prop="assessmentDate">
              <el-date-picker clearable
                v-model="queryParams.assessmentDate"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择考核日期"
              />
            </el-form-item>
            <el-form-item label="考核人" prop="assessor">
              <el-input v-model="queryParams.assessor" placeholder="请输入考核人" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="考核结果：excellent-优秀，good-良好，qualified-合格，unqualified-不合格" prop="assessmentResult">
              <el-input v-model="queryParams.assessmentResult" placeholder="请输入考核结果：excellent-优秀，good-良好，qualified-合格，unqualified-不合格" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="评分" prop="score">
              <el-input v-model="queryParams.score" placeholder="请输入评分" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="考核意见" prop="assessmentOpinion">
              <el-input v-model="queryParams.assessmentOpinion" placeholder="请输入考核意见" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="改进措施" prop="improvementMeasures">
              <el-input v-model="queryParams.improvementMeasures" placeholder="请输入改进措施" clearable @keyup.enter="handleQuery" />
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
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['system:newTechnologyProjectAssessment:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="success" plain icon="Edit" :disabled="single" @click="handleUpdate()" v-hasPermi="['system:newTechnologyProjectAssessment:edit']">修改</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="danger" plain icon="Delete" :disabled="multiple" @click="handleDelete()" v-hasPermi="['system:newTechnologyProjectAssessment:remove']">删除</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['system:newTechnologyProjectAssessment:export']">导出</el-button>
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" border :data="newTechnologyProjectAssessmentList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="主键ID" align="center" prop="id" v-if="false" />
        <el-table-column label="考核年份" align="center" prop="assessmentYear" />
        <el-table-column label="考核类型：midterm-中期考核，final-结题考核，annual-年度考核" align="center" prop="assessmentType" />
        <el-table-column label="考核日期" align="center" prop="assessmentDate" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.assessmentDate, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="考核人" align="center" prop="assessor" />
        <el-table-column label="考核结果：excellent-优秀，good-良好，qualified-合格，unqualified-不合格" align="center" prop="assessmentResult" />
        <el-table-column label="评分" align="center" prop="score" />
        <el-table-column label="考核意见" align="center" prop="assessmentOpinion" />
        <el-table-column label="改进措施" align="center" prop="improvementMeasures" />
        <el-table-column label="状态" align="center" prop="status" />
        <el-table-column label="备注" align="center" prop="remark" />
        <el-table-column label="操作" align="center" fixed="right"  class-name="small-padding fixed-width">
          <template #default="scope">
            <el-tooltip content="修改" placement="top">
              <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['system:newTechnologyProjectAssessment:edit']"></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)" v-hasPermi="['system:newTechnologyProjectAssessment:remove']"></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改项目考核评估对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="newTechnologyProjectAssessmentFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="项目ID" prop="projectId">
          <el-input v-model="form.projectId" placeholder="请输入项目ID" />
        </el-form-item>
        <el-form-item label="考核年份" prop="assessmentYear">
          <el-input v-model="form.assessmentYear" placeholder="请输入考核年份" />
        </el-form-item>
        <el-form-item label="考核日期" prop="assessmentDate">
          <el-date-picker clearable
            v-model="form.assessmentDate"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择考核日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="考核人" prop="assessor">
          <el-input v-model="form.assessor" placeholder="请输入考核人" />
        </el-form-item>
        <el-form-item label="考核结果：excellent-优秀，good-良好，qualified-合格，unqualified-不合格" prop="assessmentResult">
          <el-input v-model="form.assessmentResult" placeholder="请输入考核结果：excellent-优秀，good-良好，qualified-合格，unqualified-不合格" />
        </el-form-item>
        <el-form-item label="评分" prop="score">
          <el-input v-model="form.score" placeholder="请输入评分" />
        </el-form-item>
        <el-form-item label="考核意见" prop="assessmentOpinion">
            <el-input v-model="form.assessmentOpinion" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="改进措施" prop="improvementMeasures">
            <el-input v-model="form.improvementMeasures" type="textarea" placeholder="请输入内容" />
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

<script setup name="NewTechnologyProjectAssessment" lang="ts">
import { listNewTechnologyProjectAssessment, getNewTechnologyProjectAssessment, delNewTechnologyProjectAssessment, addNewTechnologyProjectAssessment, updateNewTechnologyProjectAssessment } from '@/api/system/newTechnologyProjectAssessment';
import { NewTechnologyProjectAssessmentVO, NewTechnologyProjectAssessmentQuery, NewTechnologyProjectAssessmentForm } from '@/api/system/newTechnologyProjectAssessment/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const newTechnologyProjectAssessmentList = ref<NewTechnologyProjectAssessmentVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const newTechnologyProjectAssessmentFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: NewTechnologyProjectAssessmentForm = {
  id: undefined,
  projectId: undefined,
  assessmentYear: undefined,
  assessmentType: undefined,
  assessmentDate: undefined,
  assessor: undefined,
  assessmentResult: undefined,
  score: undefined,
  assessmentOpinion: undefined,
  improvementMeasures: undefined,
  status: undefined,
  remark: undefined
}
const data = reactive<PageData<NewTechnologyProjectAssessmentForm, NewTechnologyProjectAssessmentQuery>>({
  form: {...initFormData},
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    assessmentYear: undefined,
    assessmentType: undefined,
    assessmentDate: undefined,
    assessor: undefined,
    assessmentResult: undefined,
    score: undefined,
    assessmentOpinion: undefined,
    improvementMeasures: undefined,
    status: undefined,
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
    assessmentYear: [
      { required: true, message: "考核年份不能为空", trigger: "blur" }
    ],
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询项目考核评估列表 */
const getList = async () => {
  loading.value = true;
  const res = await listNewTechnologyProjectAssessment(queryParams.value);
  newTechnologyProjectAssessmentList.value = res.rows;
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
  newTechnologyProjectAssessmentFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: NewTechnologyProjectAssessmentVO[]) => {
  ids.value = selection.map(item => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
}

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = "添加项目考核评估";
}

/** 修改按钮操作 */
const handleUpdate = async (row?: NewTechnologyProjectAssessmentVO) => {
  reset();
  const _id = row?.id || ids.value[0]
  const res = await getNewTechnologyProjectAssessment(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = "修改项目考核评估";
}

/** 提交按钮 */
const submitForm = () => {
  newTechnologyProjectAssessmentFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateNewTechnologyProjectAssessment(form.value).finally(() =>  buttonLoading.value = false);
      } else {
        await addNewTechnologyProjectAssessment(form.value).finally(() =>  buttonLoading.value = false);
      }
      proxy?.$modal.msgSuccess("操作成功");
      dialog.visible = false;
      await getList();
    }
  });
}

/** 删除按钮操作 */
const handleDelete = async (row?: NewTechnologyProjectAssessmentVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除项目考核评估编号为"' + _ids + '"的数据项？').finally(() => loading.value = false);
  await delNewTechnologyProjectAssessment(_ids);
  proxy?.$modal.msgSuccess("删除成功");
  await getList();
}

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download('system/newTechnologyProjectAssessment/export', {
    ...queryParams.value
  }, `newTechnologyProjectAssessment_${new Date().getTime()}.xlsx`)
}

onMounted(() => {
  getList();
});
</script>
