<template>
  <div class="p-2">
    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <div v-show="showSearch" class="mb-[10px]">
        <el-card shadow="hover">
          <el-form ref="queryFormRef" :model="queryParams" :inline="true">
            <el-form-item label="复查日期" prop="reviewDate">
              <el-date-picker clearable v-model="queryParams.reviewDate" type="date" value-format="YYYY-MM-DD" placeholder="请选择复查日期" />
            </el-form-item>
            <el-form-item label="复查人" prop="reviewer">
              <el-input v-model="queryParams.reviewer" placeholder="请输入复查人" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="复查结果：qualified-合格，unqualified-不合格" prop="reviewResult">
              <el-input
                v-model="queryParams.reviewResult"
                placeholder="请输入复查结果：qualified-合格，unqualified-不合格"
                clearable
                @keyup.enter="handleQuery"
              />
            </el-form-item>
            <el-form-item label="复查意见" prop="reviewOpinion">
              <el-input v-model="queryParams.reviewOpinion" placeholder="请输入复查意见" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="下次复查日期" prop="nextReviewDate">
              <el-date-picker clearable v-model="queryParams.nextReviewDate" type="date" value-format="YYYY-MM-DD" placeholder="请选择下次复查日期" />
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
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['system:supervisionReview:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="success" plain icon="Edit" :disabled="single" @click="handleUpdate()" v-hasPermi="['system:supervisionReview:edit']"
              >修改</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button type="danger" plain icon="Delete" :disabled="multiple" @click="handleDelete()" v-hasPermi="['system:supervisionReview:remove']"
              >删除</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['system:supervisionReview:export']">导出</el-button>
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" border :data="supervisionReviewList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="主键ID" align="center" prop="id" v-if="false" />
        <el-table-column label="复查日期" align="center" prop="reviewDate" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.reviewDate, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="复查人" align="center" prop="reviewer" />
        <el-table-column label="复查结果：qualified-合格，unqualified-不合格" align="center" prop="reviewResult" />
        <el-table-column label="复查意见" align="center" prop="reviewOpinion" />
        <el-table-column label="下次复查日期" align="center" prop="nextReviewDate" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.nextReviewDate, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="状态" align="center" prop="status" />
        <el-table-column label="备注" align="center" prop="remark" />
        <el-table-column label="操作" align="center" fixed="right" class-name="small-padding fixed-width">
          <template #default="scope">
            <el-tooltip content="修改" placement="top">
              <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['system:supervisionReview:edit']"></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button
                link
                type="primary"
                icon="Delete"
                @click="handleDelete(scope.row)"
                v-hasPermi="['system:supervisionReview:remove']"
              ></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改整改复查对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="supervisionReviewFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="任务ID" prop="taskId">
          <el-input v-model="form.taskId" placeholder="请输入任务ID" />
        </el-form-item>
        <el-form-item label="复查日期" prop="reviewDate">
          <el-date-picker clearable v-model="form.reviewDate" type="datetime" value-format="YYYY-MM-DD HH:mm:ss" placeholder="请选择复查日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="复查人" prop="reviewer">
          <el-input v-model="form.reviewer" placeholder="请输入复查人" />
        </el-form-item>
        <el-form-item label="复查结果：qualified-合格，unqualified-不合格" prop="reviewResult">
          <el-input v-model="form.reviewResult" placeholder="请输入复查结果：qualified-合格，unqualified-不合格" />
        </el-form-item>
        <el-form-item label="复查意见" prop="reviewOpinion">
          <el-input v-model="form.reviewOpinion" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="下次复查日期" prop="nextReviewDate">
          <el-date-picker clearable v-model="form.nextReviewDate" type="datetime" value-format="YYYY-MM-DD HH:mm:ss" placeholder="请选择下次复查日期">
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

<script setup name="SupervisionReview" lang="ts">
import {
  listSupervisionReview,
  getSupervisionReview,
  delSupervisionReview,
  addSupervisionReview,
  updateSupervisionReview
} from '@/api/supervision/supervisionReview';
import { SupervisionReviewVO, SupervisionReviewQuery, SupervisionReviewForm } from '@/api/supervision/supervisionReview/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const supervisionReviewList = ref<SupervisionReviewVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const supervisionReviewFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: SupervisionReviewForm = {
  id: undefined,
  taskId: undefined,
  reviewDate: undefined,
  reviewer: undefined,
  reviewResult: undefined,
  reviewOpinion: undefined,
  nextReviewDate: undefined,
  status: undefined,
  remark: undefined
};
const data = reactive<PageData<SupervisionReviewForm, SupervisionReviewQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    reviewDate: undefined,
    reviewer: undefined,
    reviewResult: undefined,
    reviewOpinion: undefined,
    nextReviewDate: undefined,
    status: undefined,
    params: {}
  },
  rules: {
    id: [{ required: true, message: '主键ID不能为空', trigger: 'blur' }],
    taskId: [{ required: true, message: '任务ID不能为空', trigger: 'blur' }],
    reviewDate: [{ required: true, message: '复查日期不能为空', trigger: 'blur' }]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询整改复查列表 */
const getList = async () => {
  loading.value = true;
  const res = await listSupervisionReview(queryParams.value);
  supervisionReviewList.value = res.rows;
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
  supervisionReviewFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: SupervisionReviewVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加整改复查';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: SupervisionReviewVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getSupervisionReview(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改整改复查';
};

/** 提交按钮 */
const submitForm = () => {
  supervisionReviewFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateSupervisionReview(form.value).finally(() => (buttonLoading.value = false));
      } else {
        await addSupervisionReview(form.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: SupervisionReviewVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除整改复查编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delSupervisionReview(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/supervisionReview/export',
    {
      ...queryParams.value
    },
    `supervisionReview_${new Date().getTime()}.xlsx`
  );
};

onMounted(() => {
  getList();
});
</script>
