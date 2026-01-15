<template>
  <div class="p-2">
    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <div v-show="showSearch" class="mb-[10px]">
        <el-card shadow="hover">
          <el-form ref="queryFormRef" :model="queryParams" :inline="true">
            <el-form-item label="患者姓名" prop="patientName">
              <el-input v-model="queryParams.patientName" placeholder="请输入患者姓名" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="患者年龄" prop="patientAge">
              <el-input v-model="queryParams.patientAge" placeholder="请输入患者年龄" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="患者性别：1-男，2-女" prop="patientGender">
              <el-input v-model="queryParams.patientGender" placeholder="请输入患者性别：1-男，2-女" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="死亡日期" prop="deathDate">
              <el-date-picker clearable v-model="queryParams.deathDate" type="date" value-format="YYYY-MM-DD" placeholder="请选择死亡日期" />
            </el-form-item>
            <el-form-item label="死亡原因" prop="deathReason">
              <el-input v-model="queryParams.deathReason" placeholder="请输入死亡原因" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="讨论主持人姓名" prop="moderatorName">
              <el-input v-model="queryParams.moderatorName" placeholder="请输入讨论主持人姓名" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="讨论日期" prop="discussionDate">
              <el-date-picker clearable v-model="queryParams.discussionDate" type="date" value-format="YYYY-MM-DD" placeholder="请选择讨论日期" />
            </el-form-item>
            <el-form-item label="参与讨论的人员名单" prop="participants">
              <el-input v-model="queryParams.participants" placeholder="请输入参与讨论的人员名单" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="参与人数" prop="participantCount">
              <el-input v-model="queryParams.participantCount" placeholder="请输入参与人数" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="是否删除 0-否 1-是" prop="isDeleted">
              <el-input v-model="queryParams.isDeleted" placeholder="请输入是否删除 0-否 1-是" clearable @keyup.enter="handleQuery" />
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
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['system:deathCaseDiscussion:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="success" plain icon="Edit" :disabled="single" @click="handleUpdate()" v-hasPermi="['system:deathCaseDiscussion:edit']"
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
              v-hasPermi="['system:deathCaseDiscussion:remove']"
              >删除</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['system:deathCaseDiscussion:export']">导出</el-button>
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" border :data="deathCaseDiscussionList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="主键ID" align="center" prop="id" v-if="false" />
        <el-table-column label="患者姓名" align="center" prop="patientName" />
        <el-table-column label="患者年龄" align="center" prop="patientAge" />
        <el-table-column label="患者性别：1-男，2-女" align="center" prop="patientGender" />
        <el-table-column label="死亡日期" align="center" prop="deathDate" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.deathDate, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="死亡原因" align="center" prop="deathReason" />
        <el-table-column label="讨论主持人姓名" align="center" prop="moderatorName" />
        <el-table-column label="讨论日期" align="center" prop="discussionDate" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.discussionDate, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="讨论内容和结论" align="center" prop="discussionContent" />
        <el-table-column label="参与讨论的人员名单" align="center" prop="participants" />
        <el-table-column label="参与人数" align="center" prop="participantCount" />
        <el-table-column label="状态：0-进行中，1-已完成" align="center" prop="status" />
        <el-table-column label="是否删除 0-否 1-是" align="center" prop="isDeleted" />
        <el-table-column label="操作" align="center" fixed="right" class-name="small-padding fixed-width">
          <template #default="scope">
            <el-tooltip content="修改" placement="top">
              <el-button
                link
                type="primary"
                icon="Edit"
                @click="handleUpdate(scope.row)"
                v-hasPermi="['system:deathCaseDiscussion:edit']"
              ></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button
                link
                type="primary"
                icon="Delete"
                @click="handleDelete(scope.row)"
                v-hasPermi="['system:deathCaseDiscussion:remove']"
              ></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改死亡病例讨论对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="deathCaseDiscussionFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="患者姓名" prop="patientName">
          <el-input v-model="form.patientName" placeholder="请输入患者姓名" />
        </el-form-item>
        <el-form-item label="患者年龄" prop="patientAge">
          <el-input v-model="form.patientAge" placeholder="请输入患者年龄" />
        </el-form-item>
        <el-form-item label="患者性别：1-男，2-女" prop="patientGender">
          <el-input v-model="form.patientGender" placeholder="请输入患者性别：1-男，2-女" />
        </el-form-item>
        <el-form-item label="死亡日期" prop="deathDate">
          <el-date-picker clearable v-model="form.deathDate" type="datetime" value-format="YYYY-MM-DD HH:mm:ss" placeholder="请选择死亡日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="死亡原因" prop="deathReason">
          <el-input v-model="form.deathReason" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="讨论主持人姓名" prop="moderatorName">
          <el-input v-model="form.moderatorName" placeholder="请输入讨论主持人姓名" />
        </el-form-item>
        <el-form-item label="讨论日期" prop="discussionDate">
          <el-date-picker clearable v-model="form.discussionDate" type="datetime" value-format="YYYY-MM-DD HH:mm:ss" placeholder="请选择讨论日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="讨论内容和结论">
          <editor v-model="form.discussionContent" :min-height="192" />
        </el-form-item>
        <el-form-item label="参与讨论的人员名单" prop="participants">
          <el-input v-model="form.participants" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="参与人数" prop="participantCount">
          <el-input v-model="form.participantCount" placeholder="请输入参与人数" />
        </el-form-item>
        <el-form-item label="是否删除 0-否 1-是" prop="isDeleted">
          <el-input v-model="form.isDeleted" placeholder="请输入是否删除 0-否 1-是" />
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

<script setup name="DeathCaseDiscussion" lang="ts">
import {
  listDeathCaseDiscussion,
  getDeathCaseDiscussion,
  delDeathCaseDiscussion,
  addDeathCaseDiscussion,
  updateDeathCaseDiscussion
} from '@/api/ledger/deathCaseDiscussion';
import { DeathCaseDiscussionVO, DeathCaseDiscussionQuery, DeathCaseDiscussionForm } from '@/api/ledger/deathCaseDiscussion/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const deathCaseDiscussionList = ref<DeathCaseDiscussionVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const deathCaseDiscussionFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: DeathCaseDiscussionForm = {
  id: undefined,
  patientName: undefined,
  patientAge: undefined,
  patientGender: undefined,
  deathDate: undefined,
  deathReason: undefined,
  moderatorName: undefined,
  discussionDate: undefined,
  discussionContent: undefined,
  participants: undefined,
  participantCount: undefined,
  status: undefined,
  isDeleted: undefined
};
const data = reactive<PageData<DeathCaseDiscussionForm, DeathCaseDiscussionQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    patientName: undefined,
    patientAge: undefined,
    patientGender: undefined,
    deathDate: undefined,
    deathReason: undefined,
    moderatorName: undefined,
    discussionDate: undefined,
    discussionContent: undefined,
    participants: undefined,
    participantCount: undefined,
    status: undefined,
    isDeleted: undefined,
    params: {}
  },
  rules: {
    id: [{ required: true, message: '主键ID不能为空', trigger: 'blur' }],
    patientName: [{ required: true, message: '患者姓名不能为空', trigger: 'blur' }],
    patientAge: [{ required: true, message: '患者年龄不能为空', trigger: 'blur' }],
    patientGender: [{ required: true, message: '患者性别：1-男，2-女不能为空', trigger: 'blur' }],
    deathDate: [{ required: true, message: '死亡日期不能为空', trigger: 'blur' }],
    deathReason: [{ required: true, message: '死亡原因不能为空', trigger: 'blur' }],
    moderatorName: [{ required: true, message: '讨论主持人姓名不能为空', trigger: 'blur' }],
    discussionDate: [{ required: true, message: '讨论日期不能为空', trigger: 'blur' }],
    discussionContent: [{ required: true, message: '讨论内容和结论不能为空', trigger: 'blur' }]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询死亡病例讨论列表 */
const getList = async () => {
  loading.value = true;
  const res = await listDeathCaseDiscussion(queryParams.value);
  deathCaseDiscussionList.value = res.rows;
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
  deathCaseDiscussionFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: DeathCaseDiscussionVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加死亡病例讨论';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: DeathCaseDiscussionVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getDeathCaseDiscussion(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改死亡病例讨论';
};

/** 提交按钮 */
const submitForm = () => {
  deathCaseDiscussionFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateDeathCaseDiscussion(form.value).finally(() => (buttonLoading.value = false));
      } else {
        await addDeathCaseDiscussion(form.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: DeathCaseDiscussionVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除死亡病例讨论编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delDeathCaseDiscussion(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/deathCaseDiscussion/export',
    {
      ...queryParams.value
    },
    `deathCaseDiscussion_${new Date().getTime()}.xlsx`
  );
};

onMounted(() => {
  getList();
});
</script>
