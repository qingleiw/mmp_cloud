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
            <el-form-item label="指标层级" prop="indicatorLevel">
              <el-input v-model="queryParams.indicatorLevel" placeholder="请输入指标层级" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="定义" prop="definition">
              <el-input v-model="queryParams.definition" placeholder="请输入定义" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="计算公式" prop="formula">
              <el-input v-model="queryParams.formula" placeholder="请输入计算公式" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="意义" prop="significance">
              <el-input v-model="queryParams.significance" placeholder="请输入意义" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="单位" prop="unit">
              <el-input v-model="queryParams.unit" placeholder="请输入单位" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="标准值" prop="standardValue">
              <el-input v-model="queryParams.standardValue" placeholder="请输入标准值" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="满分分值" prop="maxScore">
              <el-input v-model="queryParams.maxScore" placeholder="请输入满分分值" clearable @keyup.enter="handleQuery" />
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
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['system:qcQualityIndicator:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="success" plain icon="Edit" :disabled="single" @click="handleUpdate()" v-hasPermi="['system:qcQualityIndicator:edit']"
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
              v-hasPermi="['system:qcQualityIndicator:remove']"
              >删除</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['system:qcQualityIndicator:export']">导出</el-button>
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" border :data="qcQualityIndicatorList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="主键ID" align="center" prop="id" v-if="false" />
        <el-table-column label="指标编码" align="center" prop="indicatorCode" />
        <el-table-column label="指标名称" align="center" prop="indicatorName" />
        <el-table-column label="指标层级" align="center" prop="indicatorLevel" />
        <el-table-column label="定义" align="center" prop="definition" />
        <el-table-column label="计算公式" align="center" prop="formula" />
        <el-table-column label="意义" align="center" prop="significance" />
        <el-table-column label="说明" align="center" prop="remark" />
        <el-table-column label="单位" align="center" prop="unit" />
        <el-table-column label="数据类型：rate-比率，count-计数，ratio-比值" align="center" prop="dataType" />
        <el-table-column label="标准值" align="center" prop="standardValue" />
        <el-table-column label="满分分值" align="center" prop="maxScore" />
        <el-table-column label="排序" align="center" prop="sortOrder" />
        <el-table-column label="状态：1-启用，0-禁用" align="center" prop="status" />
        <el-table-column label="是否删除" align="center" prop="delFlag" />
        <el-table-column label="操作" align="center" fixed="right" class-name="small-padding fixed-width">
          <template #default="scope">
            <el-tooltip content="修改" placement="top">
              <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['system:qcQualityIndicator:edit']"></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button
                link
                type="primary"
                icon="Delete"
                @click="handleDelete(scope.row)"
                v-hasPermi="['system:qcQualityIndicator:remove']"
              ></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改质量指标对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="qcQualityIndicatorFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="指标编码" prop="indicatorCode">
          <el-input v-model="form.indicatorCode" placeholder="请输入指标编码" />
        </el-form-item>
        <el-form-item label="指标名称" prop="indicatorName">
          <el-input v-model="form.indicatorName" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="所属专业ID" prop="categoryId">
          <el-input v-model="form.categoryId" placeholder="请输入所属专业ID" />
        </el-form-item>
        <el-form-item label="父指标ID" prop="parentId">
          <el-input v-model="form.parentId" placeholder="请输入父指标ID" />
        </el-form-item>
        <el-form-item label="指标层级" prop="indicatorLevel">
          <el-input v-model="form.indicatorLevel" placeholder="请输入指标层级" />
        </el-form-item>
        <el-form-item label="定义" prop="definition">
          <el-input v-model="form.definition" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="计算公式" prop="formula">
          <el-input v-model="form.formula" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="意义" prop="significance">
          <el-input v-model="form.significance" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="说明" prop="remark">
          <el-input v-model="form.remark" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="单位" prop="unit">
          <el-input v-model="form.unit" placeholder="请输入单位" />
        </el-form-item>
        <el-form-item label="标准值" prop="standardValue">
          <el-input v-model="form.standardValue" placeholder="请输入标准值" />
        </el-form-item>
        <el-form-item label="满分分值" prop="maxScore">
          <el-input v-model="form.maxScore" placeholder="请输入满分分值" />
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

<script setup name="QcQualityIndicator" lang="ts">
import {
  listQcQualityIndicator,
  getQcQualityIndicator,
  delQcQualityIndicator,
  addQcQualityIndicator,
  updateQcQualityIndicator
} from '@/api/qc/qcQualityIndicator';
import { QcQualityIndicatorVO, QcQualityIndicatorQuery, QcQualityIndicatorForm } from '@/api/qc/qcQualityIndicator/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const qcQualityIndicatorList = ref<QcQualityIndicatorVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const qcQualityIndicatorFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: QcQualityIndicatorForm = {
  id: undefined,
  indicatorCode: undefined,
  indicatorName: undefined,
  categoryId: undefined,
  parentId: undefined,
  indicatorLevel: undefined,
  definition: undefined,
  formula: undefined,
  significance: undefined,
  remark: undefined,
  unit: undefined,
  dataType: undefined,
  standardValue: undefined,
  maxScore: undefined,
  sortOrder: undefined,
  status: undefined,
  delFlag: undefined
};
const data = reactive<PageData<QcQualityIndicatorForm, QcQualityIndicatorQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    indicatorCode: undefined,
    indicatorName: undefined,
    indicatorLevel: undefined,
    definition: undefined,
    formula: undefined,
    significance: undefined,
    unit: undefined,
    dataType: undefined,
    standardValue: undefined,
    maxScore: undefined,
    sortOrder: undefined,
    status: undefined,
    delFlag: undefined,
    params: {}
  },
  rules: {
    id: [{ required: true, message: '主键ID不能为空', trigger: 'blur' }],
    indicatorCode: [{ required: true, message: '指标编码不能为空', trigger: 'blur' }],
    indicatorName: [{ required: true, message: '指标名称不能为空', trigger: 'blur' }],
    categoryId: [{ required: true, message: '所属专业ID不能为空', trigger: 'blur' }]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询质量指标列表 */
const getList = async () => {
  loading.value = true;
  const res = await listQcQualityIndicator(queryParams.value);
  qcQualityIndicatorList.value = res.rows;
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
  qcQualityIndicatorFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: QcQualityIndicatorVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加质量指标';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: QcQualityIndicatorVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getQcQualityIndicator(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改质量指标';
};

/** 提交按钮 */
const submitForm = () => {
  qcQualityIndicatorFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateQcQualityIndicator(form.value).finally(() => (buttonLoading.value = false));
      } else {
        await addQcQualityIndicator(form.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: QcQualityIndicatorVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除质量指标编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delQcQualityIndicator(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/qcQualityIndicator/export',
    {
      ...queryParams.value
    },
    `qcQualityIndicator_${new Date().getTime()}.xlsx`
  );
};

onMounted(() => {
  getList();
});
</script>
