<template>
  <div class="p-2">
    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <div v-show="showSearch" class="mb-[10px]">
        <el-card shadow="hover">
          <el-form ref="queryFormRef" :model="queryParams" :inline="true">
            <el-form-item label="指标值" prop="indicatorValue">
              <el-input v-model="queryParams.indicatorValue" placeholder="请输入指标值" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="标准值" prop="standardValue">
              <el-input v-model="queryParams.standardValue" placeholder="请输入标准值" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="满分" prop="maxScore">
              <el-input v-model="queryParams.maxScore" placeholder="请输入满分" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="实际得分" prop="actualScore">
              <el-input v-model="queryParams.actualScore" placeholder="请输入实际得分" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="得分率" prop="scoreRate">
              <el-input v-model="queryParams.scoreRate" placeholder="请输入得分率" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="评价等级：excellent-优秀，good-良好，qualified-合格，unqualified-不合格" prop="evaluationLevel">
              <el-input
                v-model="queryParams.evaluationLevel"
                placeholder="请输入评价等级：excellent-优秀，good-良好，qualified-合格，unqualified-不合格"
                clearable
                @keyup.enter="handleQuery"
              />
            </el-form-item>
            <el-form-item label="计算时间" prop="calculateTime">
              <el-date-picker clearable v-model="queryParams.calculateTime" type="date" value-format="YYYY-MM-DD" placeholder="请选择计算时间" />
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
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['system:qcScoringResult:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="success" plain icon="Edit" :disabled="single" @click="handleUpdate()" v-hasPermi="['system:qcScoringResult:edit']"
              >修改</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button type="danger" plain icon="Delete" :disabled="multiple" @click="handleDelete()" v-hasPermi="['system:qcScoringResult:remove']"
              >删除</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['system:qcScoringResult:export']">导出</el-button>
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" border :data="qcScoringResultList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="主键ID" align="center" prop="id" v-if="false" />
        <el-table-column label="指标值" align="center" prop="indicatorValue" />
        <el-table-column label="标准值" align="center" prop="standardValue" />
        <el-table-column label="满分" align="center" prop="maxScore" />
        <el-table-column label="实际得分" align="center" prop="actualScore" />
        <el-table-column label="得分率" align="center" prop="scoreRate" />
        <el-table-column label="评价等级：excellent-优秀，good-良好，qualified-合格，unqualified-不合格" align="center" prop="evaluationLevel" />
        <el-table-column label="计算时间" align="center" prop="calculateTime" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.calculateTime, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="是否删除" align="center" prop="delFlag" />
        <el-table-column label="操作" align="center" fixed="right" class-name="small-padding fixed-width">
          <template #default="scope">
            <el-tooltip content="修改" placement="top">
              <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['system:qcScoringResult:edit']"></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button
                link
                type="primary"
                icon="Delete"
                @click="handleDelete(scope.row)"
                v-hasPermi="['system:qcScoringResult:remove']"
              ></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改评分结果对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="qcScoringResultFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="采集记录ID" prop="collectionId">
          <el-input v-model="form.collectionId" placeholder="请输入采集记录ID" />
        </el-form-item>
        <el-form-item label="指标ID" prop="indicatorId">
          <el-input v-model="form.indicatorId" placeholder="请输入指标ID" />
        </el-form-item>
        <el-form-item label="指标值" prop="indicatorValue">
          <el-input v-model="form.indicatorValue" placeholder="请输入指标值" />
        </el-form-item>
        <el-form-item label="标准值" prop="standardValue">
          <el-input v-model="form.standardValue" placeholder="请输入标准值" />
        </el-form-item>
        <el-form-item label="满分" prop="maxScore">
          <el-input v-model="form.maxScore" placeholder="请输入满分" />
        </el-form-item>
        <el-form-item label="实际得分" prop="actualScore">
          <el-input v-model="form.actualScore" placeholder="请输入实际得分" />
        </el-form-item>
        <el-form-item label="得分率" prop="scoreRate">
          <el-input v-model="form.scoreRate" placeholder="请输入得分率" />
        </el-form-item>
        <el-form-item label="评价等级：excellent-优秀，good-良好，qualified-合格，unqualified-不合格" prop="evaluationLevel">
          <el-input v-model="form.evaluationLevel" placeholder="请输入评价等级：excellent-优秀，good-良好，qualified-合格，unqualified-不合格" />
        </el-form-item>
        <el-form-item label="计算时间" prop="calculateTime">
          <el-date-picker clearable v-model="form.calculateTime" type="datetime" value-format="YYYY-MM-DD HH:mm:ss" placeholder="请选择计算时间">
          </el-date-picker>
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

<script setup name="QcScoringResult" lang="ts">
import { listQcScoringResult, getQcScoringResult, delQcScoringResult, addQcScoringResult, updateQcScoringResult } from '@/api/qc/qcScoringResult';
import { QcScoringResultVO, QcScoringResultQuery, QcScoringResultForm } from '@/api/qc/qcScoringResult/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const qcScoringResultList = ref<QcScoringResultVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const qcScoringResultFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: QcScoringResultForm = {
  id: undefined,
  collectionId: undefined,
  indicatorId: undefined,
  indicatorValue: undefined,
  standardValue: undefined,
  maxScore: undefined,
  actualScore: undefined,
  scoreRate: undefined,
  evaluationLevel: undefined,
  calculateTime: undefined,
  delFlag: undefined
};
const data = reactive<PageData<QcScoringResultForm, QcScoringResultQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    indicatorValue: undefined,
    standardValue: undefined,
    maxScore: undefined,
    actualScore: undefined,
    scoreRate: undefined,
    evaluationLevel: undefined,
    calculateTime: undefined,
    delFlag: undefined,
    params: {}
  },
  rules: {
    id: [{ required: true, message: '主键ID不能为空', trigger: 'blur' }],
    collectionId: [{ required: true, message: '采集记录ID不能为空', trigger: 'blur' }],
    indicatorId: [{ required: true, message: '指标ID不能为空', trigger: 'blur' }]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询评分结果列表 */
const getList = async () => {
  loading.value = true;
  const res = await listQcScoringResult(queryParams.value);
  qcScoringResultList.value = res.rows;
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
  qcScoringResultFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: QcScoringResultVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加评分结果';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: QcScoringResultVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getQcScoringResult(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改评分结果';
};

/** 提交按钮 */
const submitForm = () => {
  qcScoringResultFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateQcScoringResult(form.value).finally(() => (buttonLoading.value = false));
      } else {
        await addQcScoringResult(form.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: QcScoringResultVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除评分结果编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delQcScoringResult(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/qcScoringResult/export',
    {
      ...queryParams.value
    },
    `qcScoringResult_${new Date().getTime()}.xlsx`
  );
};

onMounted(() => {
  getList();
});
</script>
