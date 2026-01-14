<template>
  <div class="p-2">
    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <div v-show="showSearch" class="mb-[10px]">
        <el-card shadow="hover">
          <el-form ref="queryFormRef" :model="queryParams" :inline="true">
            <el-form-item label="指标编码" prop="indicatorCode">
              <el-input v-model="queryParams.indicatorCode" placeholder="请输入指标编码" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="指标名称" prop="indicatorName">
              <el-input v-model="queryParams.indicatorName" placeholder="请输入指标名称" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="指标描述" prop="indicatorDescription">
              <el-input v-model="queryParams.indicatorDescription" placeholder="请输入指标描述" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="评分标准" prop="scoringStandard">
              <el-input v-model="queryParams.scoringStandard" placeholder="请输入评分标准" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="权重" prop="weight">
              <el-input v-model="queryParams.weight" placeholder="请输入权重" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="满分值" prop="maxScore">
              <el-input v-model="queryParams.maxScore" placeholder="请输入满分值" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="排序" prop="sortOrder">
              <el-input v-model="queryParams.sortOrder" placeholder="请输入排序" clearable @keyup.enter="handleQuery" />
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
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['supervision:supervisionProjectIndicator:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button
              type="success"
              plain
              icon="Edit"
              :disabled="single"
              @click="handleUpdate()"
              v-hasPermi="['supervision:supervisionProjectIndicator:edit']"
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
              v-hasPermi="['supervision:supervisionProjectIndicator:remove']"
              >删除</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['supervision:supervisionProjectIndicator:export']"
              >导出</el-button
            >
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" border :data="supervisionProjectIndicatorList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="主键ID" align="center" prop="id" v-if="false" />
        <el-table-column label="指标编码" align="center" prop="indicatorCode" />
        <el-table-column label="指标名称" align="center" prop="indicatorName" />
        <el-table-column label="指标类型" align="center" prop="indicatorType" />
        <el-table-column label="指标描述" align="center" prop="indicatorDescription" />
        <el-table-column label="评分标准" align="center" prop="scoringStandard" />
        <el-table-column label="权重" align="center" prop="weight" />
        <el-table-column label="满分值" align="center" prop="maxScore" />
        <el-table-column label="排序" align="center" prop="sortOrder" />
        <el-table-column label="状态" align="center" prop="status" />
        <el-table-column label="备注" align="center" prop="remark" />
        <el-table-column label="操作" align="center" fixed="right" class-name="small-padding fixed-width">
          <template #default="scope">
            <el-tooltip content="修改" placement="top">
              <el-button
                link
                type="primary"
                icon="Edit"
                @click="handleUpdate(scope.row)"
                v-hasPermi="['supervision:supervisionProjectIndicator:edit']"
              ></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button
                link
                type="primary"
                icon="Delete"
                @click="handleDelete(scope.row)"
                v-hasPermi="['supervision:supervisionProjectIndicator:remove']"
              ></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改督查项目指标对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="supervisionProjectIndicatorFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="项目ID" prop="projectId">
          <el-input v-model="form.projectId" placeholder="请输入项目ID" />
        </el-form-item>
        <el-form-item label="指标编码" prop="indicatorCode">
          <el-input v-model="form.indicatorCode" placeholder="请输入指标编码" />
        </el-form-item>
        <el-form-item label="指标名称" prop="indicatorName">
          <el-input v-model="form.indicatorName" placeholder="请输入指标名称" />
        </el-form-item>
        <el-form-item label="指标描述" prop="indicatorDescription">
          <el-input v-model="form.indicatorDescription" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="评分标准" prop="scoringStandard">
          <el-input v-model="form.scoringStandard" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="权重" prop="weight">
          <el-input v-model="form.weight" placeholder="请输入权重" />
        </el-form-item>
        <el-form-item label="满分值" prop="maxScore">
          <el-input v-model="form.maxScore" placeholder="请输入满分值" />
        </el-form-item>
        <el-form-item label="排序" prop="sortOrder">
          <el-input v-model="form.sortOrder" placeholder="请输入排序" />
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

<script setup name="SupervisionProjectIndicator" lang="ts">
import {
  listSupervisionProjectIndicator,
  getSupervisionProjectIndicator,
  delSupervisionProjectIndicator,
  addSupervisionProjectIndicator,
  updateSupervisionProjectIndicator
} from '@/api/supervision/supervisionProjectIndicator';
import {
  SupervisionProjectIndicatorVO,
  SupervisionProjectIndicatorQuery,
  SupervisionProjectIndicatorForm
} from '@/api/supervision/supervisionProjectIndicator/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const supervisionProjectIndicatorList = ref<SupervisionProjectIndicatorVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const supervisionProjectIndicatorFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: SupervisionProjectIndicatorForm = {
  id: undefined,
  projectId: undefined,
  indicatorCode: undefined,
  indicatorName: undefined,
  indicatorType: undefined,
  indicatorDescription: undefined,
  scoringStandard: undefined,
  weight: undefined,
  maxScore: undefined,
  sortOrder: undefined,
  status: undefined,
  remark: undefined
};
const data = reactive<PageData<SupervisionProjectIndicatorForm, SupervisionProjectIndicatorQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    indicatorCode: undefined,
    indicatorName: undefined,
    indicatorType: undefined,
    indicatorDescription: undefined,
    scoringStandard: undefined,
    weight: undefined,
    maxScore: undefined,
    sortOrder: undefined,
    status: undefined,
    params: {}
  },
  rules: {
    id: [{ required: true, message: '主键ID不能为空', trigger: 'blur' }],
    projectId: [{ required: true, message: '项目ID不能为空', trigger: 'blur' }],
    indicatorCode: [{ required: true, message: '指标编码不能为空', trigger: 'blur' }],
    indicatorName: [{ required: true, message: '指标名称不能为空', trigger: 'blur' }]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询督查项目指标列表 */
const getList = async () => {
  loading.value = true;
  const res = await listSupervisionProjectIndicator(queryParams.value);
  supervisionProjectIndicatorList.value = res.rows;
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
  supervisionProjectIndicatorFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: SupervisionProjectIndicatorVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加督查项目指标';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: SupervisionProjectIndicatorVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getSupervisionProjectIndicator(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改督查项目指标';
};

/** 提交按钮 */
const submitForm = () => {
  supervisionProjectIndicatorFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateSupervisionProjectIndicator(form.value).finally(() => (buttonLoading.value = false));
      } else {
        await addSupervisionProjectIndicator(form.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: SupervisionProjectIndicatorVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除督查项目指标编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delSupervisionProjectIndicator(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/supervisionProjectIndicator/export',
    {
      ...queryParams.value
    },
    `supervisionProjectIndicator_${new Date().getTime()}.xlsx`
  );
};

onMounted(() => {
  getList();
});
</script>
