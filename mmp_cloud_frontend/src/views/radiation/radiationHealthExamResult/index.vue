<template>
  <div class="p-2">
    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <div v-show="showSearch" class="mb-[10px]">
        <el-card shadow="hover">
          <el-form ref="queryFormRef" :model="queryParams" :inline="true">
            <el-form-item label="工作人员姓名" prop="staffName">
              <el-input v-model="queryParams.staffName" placeholder="请输入工作人员姓名" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="体检日期" prop="examDate">
              <el-date-picker clearable v-model="queryParams.examDate" type="date" value-format="YYYY-MM-DD" placeholder="请选择体检日期" />
            </el-form-item>
            <el-form-item label="体检结果：normal-正常，abnormal-异常" prop="examResult">
              <el-input
                v-model="queryParams.examResult"
                placeholder="请输入体检结果：normal-正常，abnormal-异常"
                clearable
                @keyup.enter="handleQuery"
              />
            </el-form-item>
            <el-form-item label="体检报告文件名" prop="examReportName">
              <el-input v-model="queryParams.examReportName" placeholder="请输入体检报告文件名" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主要发现" prop="keyFindings">
              <el-input v-model="queryParams.keyFindings" placeholder="请输入主要发现" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="建议措施" prop="recommendations">
              <el-input v-model="queryParams.recommendations" placeholder="请输入建议措施" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="是否需要随访：0-否，1-是" prop="followUpRequired">
              <el-input v-model="queryParams.followUpRequired" placeholder="请输入是否需要随访：0-否，1-是" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="随访日期" prop="followUpDate">
              <el-date-picker clearable v-model="queryParams.followUpDate" type="date" value-format="YYYY-MM-DD" placeholder="请选择随访日期" />
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
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['radiation:radiationHealthExamResult:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button
              type="success"
              plain
              icon="Edit"
              :disabled="single"
              @click="handleUpdate()"
              v-hasPermi="['radiation:radiationHealthExamResult:edit']"
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
              v-hasPermi="['radiation:radiationHealthExamResult:remove']"
              >删除</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['radiation:radiationHealthExamResult:export']"
              >导出</el-button
            >
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" border :data="radiationHealthExamResultList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="主键ID" align="center" prop="id" v-if="false" />
        <el-table-column label="工作人员姓名" align="center" prop="staffName" />
        <el-table-column label="体检日期" align="center" prop="examDate" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.examDate, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="体检结果：normal-正常，abnormal-异常" align="center" prop="examResult" />
        <el-table-column label="体检报告文件路径" align="center" prop="examReportFile" />
        <el-table-column label="体检报告文件名" align="center" prop="examReportName" />
        <el-table-column label="主要发现" align="center" prop="keyFindings" />
        <el-table-column label="建议措施" align="center" prop="recommendations" />
        <el-table-column label="是否需要随访：0-否，1-是" align="center" prop="followUpRequired" />
        <el-table-column label="随访日期" align="center" prop="followUpDate" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.followUpDate, '{y}-{m}-{d}') }}</span>
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
                v-hasPermi="['radiation:radiationHealthExamResult:edit']"
              ></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button
                link
                type="primary"
                icon="Delete"
                @click="handleDelete(scope.row)"
                v-hasPermi="['radiation:radiationHealthExamResult:remove']"
              ></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改体检结果记录对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="radiationHealthExamResultFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="体检计划ID" prop="planId">
          <el-input v-model="form.planId" placeholder="请输入体检计划ID" />
        </el-form-item>
        <el-form-item label="工作人员ID" prop="staffId">
          <el-input v-model="form.staffId" placeholder="请输入工作人员ID" />
        </el-form-item>
        <el-form-item label="工作人员姓名" prop="staffName">
          <el-input v-model="form.staffName" placeholder="请输入工作人员姓名" />
        </el-form-item>
        <el-form-item label="体检日期" prop="examDate">
          <el-date-picker clearable v-model="form.examDate" type="datetime" value-format="YYYY-MM-DD HH:mm:ss" placeholder="请选择体检日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="体检结果：normal-正常，abnormal-异常" prop="examResult">
          <el-input v-model="form.examResult" placeholder="请输入体检结果：normal-正常，abnormal-异常" />
        </el-form-item>
        <el-form-item label="体检报告文件路径" prop="examReportFile">
          <file-upload v-model="form.examReportFile" />
        </el-form-item>
        <el-form-item label="体检报告文件名" prop="examReportName">
          <el-input v-model="form.examReportName" placeholder="请输入体检报告文件名" />
        </el-form-item>
        <el-form-item label="主要发现" prop="keyFindings">
          <el-input v-model="form.keyFindings" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="建议措施" prop="recommendations">
          <el-input v-model="form.recommendations" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="是否需要随访：0-否，1-是" prop="followUpRequired">
          <el-input v-model="form.followUpRequired" placeholder="请输入是否需要随访：0-否，1-是" />
        </el-form-item>
        <el-form-item label="随访日期" prop="followUpDate">
          <el-date-picker clearable v-model="form.followUpDate" type="datetime" value-format="YYYY-MM-DD HH:mm:ss" placeholder="请选择随访日期">
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

<script setup name="RadiationHealthExamResult" lang="ts">
import {
  listRadiationHealthExamResult,
  getRadiationHealthExamResult,
  delRadiationHealthExamResult,
  addRadiationHealthExamResult,
  updateRadiationHealthExamResult
} from '@/api/radiation/radiationHealthExamResult';
import {
  RadiationHealthExamResultVO,
  RadiationHealthExamResultQuery,
  RadiationHealthExamResultForm
} from '@/api/radiation/radiationHealthExamResult/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const radiationHealthExamResultList = ref<RadiationHealthExamResultVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const radiationHealthExamResultFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: RadiationHealthExamResultForm = {
  id: undefined,
  planId: undefined,
  staffId: undefined,
  staffName: undefined,
  examDate: undefined,
  examResult: undefined,
  examReportFile: undefined,
  examReportName: undefined,
  keyFindings: undefined,
  recommendations: undefined,
  followUpRequired: undefined,
  followUpDate: undefined,
  remark: undefined
};
const data = reactive<PageData<RadiationHealthExamResultForm, RadiationHealthExamResultQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    staffName: undefined,
    examDate: undefined,
    examResult: undefined,
    examReportFile: undefined,
    examReportName: undefined,
    keyFindings: undefined,
    recommendations: undefined,
    followUpRequired: undefined,
    followUpDate: undefined,
    params: {}
  },
  rules: {
    id: [{ required: true, message: '主键ID不能为空', trigger: 'blur' }],
    planId: [{ required: true, message: '体检计划ID不能为空', trigger: 'blur' }],
    staffId: [{ required: true, message: '工作人员ID不能为空', trigger: 'blur' }],
    examDate: [{ required: true, message: '体检日期不能为空', trigger: 'blur' }]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询体检结果记录列表 */
const getList = async () => {
  loading.value = true;
  const res = await listRadiationHealthExamResult(queryParams.value);
  radiationHealthExamResultList.value = res.rows;
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
  radiationHealthExamResultFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: RadiationHealthExamResultVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加体检结果记录';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: RadiationHealthExamResultVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getRadiationHealthExamResult(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改体检结果记录';
};

/** 提交按钮 */
const submitForm = () => {
  radiationHealthExamResultFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateRadiationHealthExamResult(form.value).finally(() => (buttonLoading.value = false));
      } else {
        await addRadiationHealthExamResult(form.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: RadiationHealthExamResultVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除体检结果记录编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delRadiationHealthExamResult(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/radiationHealthExamResult/export',
    {
      ...queryParams.value
    },
    `radiationHealthExamResult_${new Date().getTime()}.xlsx`
  );
};

onMounted(() => {
  getList();
});
</script>
