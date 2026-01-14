<template>
  <div class="p-2">
    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <div v-show="showSearch" class="mb-[10px]">
        <el-card shadow="hover">
          <el-form ref="queryFormRef" :model="queryParams" :inline="true">
            <el-form-item label="问题描述" prop="issueDescription">
              <el-input v-model="queryParams.issueDescription" placeholder="请输入问题描述" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="严重程度" prop="severity">
              <el-input v-model="queryParams.severity" placeholder="请输入严重程度" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="责任人" prop="responsiblePerson">
              <el-input v-model="queryParams.responsiblePerson" placeholder="请输入责任人" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="整改期限" prop="rectificationDeadline">
              <el-date-picker
                clearable
                v-model="queryParams.rectificationDeadline"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择整改期限"
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
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['supervision:supervisionIssue:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="success" plain icon="Edit" :disabled="single" @click="handleUpdate()" v-hasPermi="['supervision:supervisionIssue:edit']"
              >修改</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button type="danger" plain icon="Delete" :disabled="multiple" @click="handleDelete()" v-hasPermi="['supervision:supervisionIssue:remove']"
              >删除</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['supervision:supervisionIssue:export']">导出</el-button>
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" border :data="supervisionIssueList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="主键ID" align="center" prop="id" v-if="false" />
        <el-table-column label="问题类型" align="center" prop="issueType" />
        <el-table-column label="问题描述" align="center" prop="issueDescription" />
        <el-table-column label="严重程度" align="center" prop="severity" />
        <el-table-column label="责任人" align="center" prop="responsiblePerson" />
        <el-table-column label="整改期限" align="center" prop="rectificationDeadline" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.rectificationDeadline, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="状态：pending-待整改，rectifying-整改中，completed-已完成" align="center" prop="status" />
        <el-table-column label="备注" align="center" prop="remark" />
        <el-table-column label="操作" align="center" fixed="right" class-name="small-padding fixed-width">
          <template #default="scope">
            <el-tooltip content="修改" placement="top">
              <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['supervision:supervisionIssue:edit']"></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button
                link
                type="primary"
                icon="Delete"
                @click="handleDelete(scope.row)"
                v-hasPermi="['supervision:supervisionIssue:remove']"
              ></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改督导问题对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="supervisionIssueFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="结果ID" prop="resultId">
          <el-input v-model="form.resultId" placeholder="请输入结果ID" />
        </el-form-item>
        <el-form-item label="问题描述" prop="issueDescription">
          <el-input v-model="form.issueDescription" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="严重程度" prop="severity">
          <el-input v-model="form.severity" placeholder="请输入严重程度" />
        </el-form-item>
        <el-form-item label="责任人" prop="responsiblePerson">
          <el-input v-model="form.responsiblePerson" placeholder="请输入责任人" />
        </el-form-item>
        <el-form-item label="整改期限" prop="rectificationDeadline">
          <el-date-picker
            clearable
            v-model="form.rectificationDeadline"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择整改期限"
          >
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

<script setup name="SupervisionIssue" lang="ts">
import {
  listSupervisionIssue,
  getSupervisionIssue,
  delSupervisionIssue,
  addSupervisionIssue,
  updateSupervisionIssue
} from '@/api/supervision/supervisionIssue';
import { SupervisionIssueVO, SupervisionIssueQuery, SupervisionIssueForm } from '@/api/supervision/supervisionIssue/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const supervisionIssueList = ref<SupervisionIssueVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const supervisionIssueFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: SupervisionIssueForm = {
  id: undefined,
  resultId: undefined,
  issueType: undefined,
  issueDescription: undefined,
  severity: undefined,
  responsiblePerson: undefined,
  rectificationDeadline: undefined,
  status: undefined,
  remark: undefined
};
const data = reactive<PageData<SupervisionIssueForm, SupervisionIssueQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    issueType: undefined,
    issueDescription: undefined,
    severity: undefined,
    responsiblePerson: undefined,
    rectificationDeadline: undefined,
    status: undefined,
    params: {}
  },
  rules: {
    id: [{ required: true, message: '主键ID不能为空', trigger: 'blur' }],
    resultId: [{ required: true, message: '结果ID不能为空', trigger: 'blur' }],
    issueDescription: [{ required: true, message: '问题描述不能为空', trigger: 'blur' }]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询督导问题列表 */
const getList = async () => {
  loading.value = true;
  const res = await listSupervisionIssue(queryParams.value);
  supervisionIssueList.value = res.rows;
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
  supervisionIssueFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: SupervisionIssueVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加督导问题';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: SupervisionIssueVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getSupervisionIssue(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改督导问题';
};

/** 提交按钮 */
const submitForm = () => {
  supervisionIssueFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateSupervisionIssue(form.value).finally(() => (buttonLoading.value = false));
      } else {
        await addSupervisionIssue(form.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: SupervisionIssueVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除督导问题编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delSupervisionIssue(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/supervisionIssue/export',
    {
      ...queryParams.value
    },
    `supervisionIssue_${new Date().getTime()}.xlsx`
  );
};

onMounted(() => {
  getList();
});
</script>
