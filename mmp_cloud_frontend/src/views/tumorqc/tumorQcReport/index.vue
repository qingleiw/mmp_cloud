<template>
  <div class="p-2">
    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <div v-show="showSearch" class="mb-[10px]">
        <el-card shadow="hover">
          <el-form ref="queryFormRef" :model="queryParams" :inline="true">
            <el-form-item label="报告编码" prop="reportCode">
              <el-input v-model="queryParams.reportCode" placeholder="请输入报告编码" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="报告标题" prop="reportTitle">
              <el-input v-model="queryParams.reportTitle" placeholder="请输入报告标题" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="报告周期开始" prop="periodStart">
              <el-date-picker clearable v-model="queryParams.periodStart" type="date" value-format="YYYY-MM-DD" placeholder="请选择报告周期开始" />
            </el-form-item>
            <el-form-item label="报告周期结束" prop="periodEnd">
              <el-date-picker clearable v-model="queryParams.periodEnd" type="date" value-format="YYYY-MM-DD" placeholder="请选择报告周期结束" />
            </el-form-item>
            <el-form-item label="报告摘要" prop="summary">
              <el-input v-model="queryParams.summary" placeholder="请输入报告摘要" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="建议措施" prop="recommendations">
              <el-input v-model="queryParams.recommendations" placeholder="请输入建议措施" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="发布时间" prop="publishTime">
              <el-date-picker clearable v-model="queryParams.publishTime" type="date" value-format="YYYY-MM-DD" placeholder="请选择发布时间" />
            </el-form-item>
            <el-form-item label="删除标志" prop="isDeleted">
              <el-input v-model="queryParams.isDeleted" placeholder="请输入删除标志" clearable @keyup.enter="handleQuery" />
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
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['tumorqc:tumorQcReport:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="success" plain icon="Edit" :disabled="single" @click="handleUpdate()" v-hasPermi="['tumorqc:tumorQcReport:edit']"
              >修改</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button type="danger" plain icon="Delete" :disabled="multiple" @click="handleDelete()" v-hasPermi="['tumorqc:tumorQcReport:remove']"
              >删除</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['tumorqc:tumorQcReport:export']">导出</el-button>
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" border :data="tumorQcReportList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="主键ID" align="center" prop="id" v-if="false" />
        <el-table-column label="报告编码" align="center" prop="reportCode" />
        <el-table-column label="报告标题" align="center" prop="reportTitle" />
        <el-table-column label="报告类型" align="center" prop="reportType" />
        <el-table-column label="报告周期开始" align="center" prop="periodStart" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.periodStart, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="报告周期结束" align="center" prop="periodEnd" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.periodEnd, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="报告内容" align="center" prop="reportContent" />
        <el-table-column label="报告摘要" align="center" prop="summary" />
        <el-table-column label="建议措施" align="center" prop="recommendations" />
        <el-table-column label="状态" align="center" prop="status" />
        <el-table-column label="发布时间" align="center" prop="publishTime" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.publishTime, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="删除标志" align="center" prop="isDeleted" />
        <el-table-column label="操作" align="center" fixed="right" class-name="small-padding fixed-width">
          <template #default="scope">
            <el-tooltip content="修改" placement="top">
              <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['tumorqc:tumorQcReport:edit']"></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)" v-hasPermi="['tumorqc:tumorQcReport:remove']"></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改肿瘤质控报告对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="tumorQcReportFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="报告编码" prop="reportCode">
          <el-input v-model="form.reportCode" placeholder="请输入报告编码" />
        </el-form-item>
        <el-form-item label="报告标题" prop="reportTitle">
          <el-input v-model="form.reportTitle" placeholder="请输入报告标题" />
        </el-form-item>
        <el-form-item label="关联方案ID" prop="planId">
          <el-input v-model="form.planId" placeholder="请输入关联方案ID" />
        </el-form-item>
        <el-form-item label="报告周期开始" prop="periodStart">
          <el-date-picker clearable v-model="form.periodStart" type="datetime" value-format="YYYY-MM-DD HH:mm:ss" placeholder="请选择报告周期开始">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="报告周期结束" prop="periodEnd">
          <el-date-picker clearable v-model="form.periodEnd" type="datetime" value-format="YYYY-MM-DD HH:mm:ss" placeholder="请选择报告周期结束">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="报告内容">
          <editor v-model="form.reportContent" :min-height="192" />
        </el-form-item>
        <el-form-item label="报告摘要" prop="summary">
          <el-input v-model="form.summary" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="建议措施" prop="recommendations">
          <el-input v-model="form.recommendations" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="发布时间" prop="publishTime">
          <el-date-picker clearable v-model="form.publishTime" type="datetime" value-format="YYYY-MM-DD HH:mm:ss" placeholder="请选择发布时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="删除标志" prop="isDeleted">
          <el-input v-model="form.isDeleted" placeholder="请输入删除标志" />
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

<script setup name="TumorQcReport" lang="ts">
import { listTumorQcReport, getTumorQcReport, delTumorQcReport, addTumorQcReport, updateTumorQcReport } from '@/api/tumorqc/tumorQcReport';
import { TumorQcReportVO, TumorQcReportQuery, TumorQcReportForm } from '@/api/tumorqc/tumorQcReport/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const tumorQcReportList = ref<TumorQcReportVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const tumorQcReportFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: TumorQcReportForm = {
  id: undefined,
  reportCode: undefined,
  reportTitle: undefined,
  reportType: undefined,
  planId: undefined,
  periodStart: undefined,
  periodEnd: undefined,
  reportContent: undefined,
  summary: undefined,
  recommendations: undefined,
  status: undefined,
  publishTime: undefined,
  isDeleted: undefined
};
const data = reactive<PageData<TumorQcReportForm, TumorQcReportQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    reportCode: undefined,
    reportTitle: undefined,
    reportType: undefined,
    periodStart: undefined,
    periodEnd: undefined,
    reportContent: undefined,
    summary: undefined,
    recommendations: undefined,
    status: undefined,
    publishTime: undefined,
    isDeleted: undefined,
    params: {}
  },
  rules: {
    id: [{ required: true, message: '主键ID不能为空', trigger: 'blur' }],
    reportCode: [{ required: true, message: '报告编码不能为空', trigger: 'blur' }],
    reportTitle: [{ required: true, message: '报告标题不能为空', trigger: 'blur' }]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询肿瘤质控报告列表 */
const getList = async () => {
  loading.value = true;
  try {
    const res = await listTumorQcReport(queryParams.value);
    tumorQcReportList.value = res.rows;
    total.value = res.total;
  } catch (error) {
    console.error('获取肿瘤质控报告列表失败:', error);
    tumorQcReportList.value = [];
    total.value = 0;
  } finally {
    loading.value = false;
  }
};

/** 取消按钮 */
const cancel = () => {
  reset();
  dialog.visible = false;
};

/** 表单重置 */
const reset = () => {
  form.value = { ...initFormData };
  tumorQcReportFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: TumorQcReportVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加肿瘤质控报告';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: TumorQcReportVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getTumorQcReport(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改肿瘤质控报告';
};

/** 提交按钮 */
const submitForm = () => {
  tumorQcReportFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateTumorQcReport(form.value).finally(() => (buttonLoading.value = false));
      } else {
        await addTumorQcReport(form.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: TumorQcReportVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除肿瘤质控报告编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delTumorQcReport(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/tumorQcReport/export',
    {
      ...queryParams.value
    },
    `tumorQcReport_${new Date().getTime()}.xlsx`
  );
};

onMounted(() => {
  getList();
});
</script>
