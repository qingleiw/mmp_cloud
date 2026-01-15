<template>
  <div class="p-2">
    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <div v-show="showSearch" class="mb-[10px]">
        <el-card shadow="hover">
          <el-form ref="queryFormRef" :model="queryParams" :inline="true">
            <el-form-item label="预案编码" prop="planCode">
              <el-input v-model="queryParams.planCode" placeholder="请输入预案编码" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="预案名称" prop="planName">
              <el-input v-model="queryParams.planName" placeholder="请输入预案名称" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="生效日期" prop="effectiveDate">
              <el-date-picker clearable v-model="queryParams.effectiveDate" type="date" value-format="YYYY-MM-DD" placeholder="请选择生效日期" />
            </el-form-item>
            <el-form-item label="审核日期" prop="reviewDate">
              <el-date-picker clearable v-model="queryParams.reviewDate" type="date" value-format="YYYY-MM-DD" placeholder="请选择审核日期" />
            </el-form-item>
            <el-form-item label="下次审核日期" prop="nextReviewDate">
              <el-date-picker clearable v-model="queryParams.nextReviewDate" type="date" value-format="YYYY-MM-DD" placeholder="请选择下次审核日期" />
            </el-form-item>
            <el-form-item label="关键词" prop="keywords">
              <el-input v-model="queryParams.keywords" placeholder="请输入关键词" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="文件路径" prop="filePath">
              <el-input v-model="queryParams.filePath" placeholder="请输入文件路径" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="文件名称" prop="fileName">
              <el-input v-model="queryParams.fileName" placeholder="请输入文件名称" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="文件大小" prop="fileSize">
              <el-input v-model="queryParams.fileSize" placeholder="请输入文件大小" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="上传者" prop="uploadBy">
              <el-input v-model="queryParams.uploadBy" placeholder="请输入上传者" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="上传时间" prop="uploadTime">
              <el-date-picker clearable v-model="queryParams.uploadTime" type="date" value-format="YYYY-MM-DD" placeholder="请选择上传时间" />
            </el-form-item>
            <el-form-item label="批准人" prop="approveBy">
              <el-input v-model="queryParams.approveBy" placeholder="请输入批准人" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="批准时间" prop="approveTime">
              <el-date-picker clearable v-model="queryParams.approveTime" type="date" value-format="YYYY-MM-DD" placeholder="请选择批准时间" />
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
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['emergency:emergencyPlan:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="success" plain icon="Edit" :disabled="single" @click="handleUpdate()" v-hasPermi="['emergency:emergencyPlan:edit']"
              >修改</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button type="danger" plain icon="Delete" :disabled="multiple" @click="handleDelete()" v-hasPermi="['emergency:emergencyPlan:remove']"
              >删除</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['emergency:emergencyPlan:export']">导出</el-button>
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" border :data="emergencyPlanList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="主键ID" align="center" prop="id" v-if="false" />
        <el-table-column label="预案编码" align="center" prop="planCode" />
        <el-table-column label="预案名称" align="center" prop="planName" />
        <el-table-column
          label="预案类型：fire-消防预案，medical-医疗应急预案，disaster-灾害预案，infection-感染控制预案"
          align="center"
          prop="planType"
        />
        <el-table-column label="状态：draft-草稿，review-审核中，approved-已批准，archived-已归档" align="center" prop="status" />
        <el-table-column label="生效日期" align="center" prop="effectiveDate" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.effectiveDate, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="审核日期" align="center" prop="reviewDate" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.reviewDate, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="下次审核日期" align="center" prop="nextReviewDate" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.nextReviewDate, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="关键词" align="center" prop="keywords" />
        <el-table-column label="文件路径" align="center" prop="filePath" />
        <el-table-column label="文件名称" align="center" prop="fileName" />
        <el-table-column label="文件大小" align="center" prop="fileSize" />
        <el-table-column label="上传者" align="center" prop="uploadBy" />
        <el-table-column label="上传时间" align="center" prop="uploadTime" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.uploadTime, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="批准人" align="center" prop="approveBy" />
        <el-table-column label="批准时间" align="center" prop="approveTime" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.approveTime, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="备注" align="center" prop="remark" />
        <el-table-column label="操作" align="center" fixed="right" class-name="small-padding fixed-width">
          <template #default="scope">
            <el-tooltip content="修改" placement="top">
              <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['emergency:emergencyPlan:edit']"></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button
                link
                type="primary"
                icon="Delete"
                @click="handleDelete(scope.row)"
                v-hasPermi="['emergency:emergencyPlan:remove']"
              ></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改应急预案对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="emergencyPlanFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="预案编码" prop="planCode">
          <el-input v-model="form.planCode" placeholder="请输入预案编码" />
        </el-form-item>
        <el-form-item label="预案名称" prop="planName">
          <el-input v-model="form.planName" placeholder="请输入预案名称" />
        </el-form-item>
        <el-form-item label="生效日期" prop="effectiveDate">
          <el-date-picker clearable v-model="form.effectiveDate" type="datetime" value-format="YYYY-MM-DD HH:mm:ss" placeholder="请选择生效日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="审核日期" prop="reviewDate">
          <el-date-picker clearable v-model="form.reviewDate" type="datetime" value-format="YYYY-MM-DD HH:mm:ss" placeholder="请选择审核日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="下次审核日期" prop="nextReviewDate">
          <el-date-picker clearable v-model="form.nextReviewDate" type="datetime" value-format="YYYY-MM-DD HH:mm:ss" placeholder="请选择下次审核日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="关键词" prop="keywords">
          <el-input v-model="form.keywords" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="文件路径" prop="filePath">
          <el-input v-model="form.filePath" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="文件名称" prop="fileName">
          <el-input v-model="form.fileName" placeholder="请输入文件名称" />
        </el-form-item>
        <el-form-item label="文件大小" prop="fileSize">
          <el-input v-model="form.fileSize" placeholder="请输入文件大小" />
        </el-form-item>
        <el-form-item label="上传者" prop="uploadBy">
          <el-input v-model="form.uploadBy" placeholder="请输入上传者" />
        </el-form-item>
        <el-form-item label="上传时间" prop="uploadTime">
          <el-date-picker clearable v-model="form.uploadTime" type="datetime" value-format="YYYY-MM-DD HH:mm:ss" placeholder="请选择上传时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="批准人" prop="approveBy">
          <el-input v-model="form.approveBy" placeholder="请输入批准人" />
        </el-form-item>
        <el-form-item label="批准时间" prop="approveTime">
          <el-date-picker clearable v-model="form.approveTime" type="datetime" value-format="YYYY-MM-DD HH:mm:ss" placeholder="请选择批准时间">
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

<script setup name="EmergencyPlan" lang="ts">
import { listEmergencyPlan, getEmergencyPlan, delEmergencyPlan, addEmergencyPlan, updateEmergencyPlan } from '@/api/emergency/emergencyPlan';
import { EmergencyPlanVO, EmergencyPlanQuery, EmergencyPlanForm } from '@/api/emergency/emergencyPlan/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const emergencyPlanList = ref<EmergencyPlanVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const emergencyPlanFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: EmergencyPlanForm = {
  id: undefined,
  planCode: undefined,
  planName: undefined,
  planType: undefined,
  status: undefined,
  effectiveDate: undefined,
  reviewDate: undefined,
  nextReviewDate: undefined,
  keywords: undefined,
  filePath: undefined,
  fileName: undefined,
  fileSize: undefined,
  uploadBy: undefined,
  uploadTime: undefined,
  approveBy: undefined,
  approveTime: undefined,
  remark: undefined
};
const data = reactive<PageData<EmergencyPlanForm, EmergencyPlanQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    planCode: undefined,
    planName: undefined,
    planType: undefined,
    status: undefined,
    effectiveDate: undefined,
    reviewDate: undefined,
    nextReviewDate: undefined,
    keywords: undefined,
    filePath: undefined,
    fileName: undefined,
    fileSize: undefined,
    uploadBy: undefined,
    uploadTime: undefined,
    approveBy: undefined,
    approveTime: undefined,
    params: {}
  },
  rules: {
    id: [{ required: true, message: '主键ID不能为空', trigger: 'blur' }],
    planCode: [{ required: true, message: '预案编码不能为空', trigger: 'blur' }],
    planName: [{ required: true, message: '预案名称不能为空', trigger: 'blur' }]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询应急预案列表 */
const getList = async () => {
  loading.value = true;
  const res = await listEmergencyPlan(queryParams.value);
  emergencyPlanList.value = res.rows;
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
  emergencyPlanFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: EmergencyPlanVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加应急预案';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: EmergencyPlanVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getEmergencyPlan(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改应急预案';
};

/** 提交按钮 */
const submitForm = () => {
  emergencyPlanFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateEmergencyPlan(form.value).finally(() => (buttonLoading.value = false));
      } else {
        await addEmergencyPlan(form.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: EmergencyPlanVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除应急预案编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delEmergencyPlan(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/emergencyPlan/export',
    {
      ...queryParams.value
    },
    `emergencyPlan_${new Date().getTime()}.xlsx`
  );
};

onMounted(() => {
  getList();
});
</script>
