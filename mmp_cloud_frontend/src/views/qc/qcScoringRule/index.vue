<template>
  <div class="p-2">
    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <div v-show="showSearch" class="mb-[10px]">
        <el-card shadow="hover">
          <el-form ref="queryFormRef" :model="queryParams" :inline="true">
            <el-form-item label="最小值" prop="minValue">
              <el-input v-model="queryParams.minValue" placeholder="请输入最小值" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="最大值" prop="maxValue">
              <el-input v-model="queryParams.maxValue" placeholder="请输入最大值" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="得分" prop="score">
              <el-input v-model="queryParams.score" placeholder="请输入得分" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="得分率" prop="scoreRate">
              <el-input v-model="queryParams.scoreRate" placeholder="请输入得分率" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="规则描述" prop="description">
              <el-input v-model="queryParams.description" placeholder="请输入规则描述" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="排序" prop="sortOrder">
              <el-input v-model="queryParams.sortOrder" placeholder="请输入排序" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="是否删除" prop="delFlag">
              <el-input v-model="queryParams.delFlag" placeholder="请输入是否删除" clearable @keyup.enter="handleQuery" />
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
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['system:qcScoringRule:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="success" plain icon="Edit" :disabled="single" @click="handleUpdate()" v-hasPermi="['system:qcScoringRule:edit']"
              >修改</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button type="danger" plain icon="Delete" :disabled="multiple" @click="handleDelete()" v-hasPermi="['system:qcScoringRule:remove']"
              >删除</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['system:qcScoringRule:export']">导出</el-button>
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" border :data="qcScoringRuleList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="主键ID" align="center" prop="id" v-if="false" />
        <el-table-column label="规则类型：range-区间，threshold-阈值" align="center" prop="ruleType" />
        <el-table-column label="最小值" align="center" prop="minValue" />
        <el-table-column label="最大值" align="center" prop="maxValue" />
        <el-table-column label="得分" align="center" prop="score" />
        <el-table-column label="得分率" align="center" prop="scoreRate" />
        <el-table-column label="规则描述" align="center" prop="description" />
        <el-table-column label="排序" align="center" prop="sortOrder" />
        <el-table-column label="状态" align="center" prop="status" />
        <el-table-column label="是否删除" align="center" prop="delFlag" />
        <el-table-column label="操作" align="center" fixed="right" class-name="small-padding fixed-width">
          <template #default="scope">
            <el-tooltip content="修改" placement="top">
              <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['system:qcScoringRule:edit']"></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)" v-hasPermi="['system:qcScoringRule:remove']"></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改评分规则对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="qcScoringRuleFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="指标ID" prop="indicatorId">
          <el-input v-model="form.indicatorId" placeholder="请输入指标ID" />
        </el-form-item>
        <el-form-item label="最小值" prop="minValue">
          <el-input v-model="form.minValue" placeholder="请输入最小值" />
        </el-form-item>
        <el-form-item label="最大值" prop="maxValue">
          <el-input v-model="form.maxValue" placeholder="请输入最大值" />
        </el-form-item>
        <el-form-item label="得分" prop="score">
          <el-input v-model="form.score" placeholder="请输入得分" />
        </el-form-item>
        <el-form-item label="得分率" prop="scoreRate">
          <el-input v-model="form.scoreRate" placeholder="请输入得分率" />
        </el-form-item>
        <el-form-item label="规则描述" prop="description">
          <el-input v-model="form.description" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="排序" prop="sortOrder">
          <el-input v-model="form.sortOrder" placeholder="请输入排序" />
        </el-form-item>
        <el-form-item label="是否删除" prop="delFlag">
          <el-input v-model="form.delFlag" placeholder="请输入是否删除" />
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

<script setup name="QcScoringRule" lang="ts">
import { listQcScoringRule, getQcScoringRule, delQcScoringRule, addQcScoringRule, updateQcScoringRule } from '@/api/system/qcScoringRule';
import { QcScoringRuleVO, QcScoringRuleQuery, QcScoringRuleForm } from '@/api/system/qcScoringRule/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const qcScoringRuleList = ref<QcScoringRuleVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const qcScoringRuleFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: QcScoringRuleForm = {
  id: undefined,
  indicatorId: undefined,
  ruleType: undefined,
  minValue: undefined,
  maxValue: undefined,
  score: undefined,
  scoreRate: undefined,
  description: undefined,
  sortOrder: undefined,
  status: undefined,
  delFlag: undefined
};
const data = reactive<PageData<QcScoringRuleForm, QcScoringRuleQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    ruleType: undefined,
    minValue: undefined,
    maxValue: undefined,
    score: undefined,
    scoreRate: undefined,
    description: undefined,
    sortOrder: undefined,
    status: undefined,
    delFlag: undefined,
    params: {}
  },
  rules: {
    id: [{ required: true, message: '主键ID不能为空', trigger: 'blur' }],
    indicatorId: [{ required: true, message: '指标ID不能为空', trigger: 'blur' }],
    ruleType: [{ required: true, message: '规则类型：range-区间，threshold-阈值不能为空', trigger: 'change' }]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询评分规则列表 */
const getList = async () => {
  loading.value = true;
  const res = await listQcScoringRule(queryParams.value);
  qcScoringRuleList.value = res.rows;
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
  qcScoringRuleFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: QcScoringRuleVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加评分规则';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: QcScoringRuleVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getQcScoringRule(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改评分规则';
};

/** 提交按钮 */
const submitForm = () => {
  qcScoringRuleFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateQcScoringRule(form.value).finally(() => (buttonLoading.value = false));
      } else {
        await addQcScoringRule(form.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: QcScoringRuleVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除评分规则编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delQcScoringRule(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/qcScoringRule/export',
    {
      ...queryParams.value
    },
    `qcScoringRule_${new Date().getTime()}.xlsx`
  );
};

onMounted(() => {
  getList();
});
</script>
