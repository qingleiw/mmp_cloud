<template>
  <div class="p-2">
    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <div v-show="showSearch" class="mb-[10px]">
        <el-card shadow="hover">
          <el-form ref="queryFormRef" :model="queryParams" :inline="true">
            <el-form-item label="统计周期：monthly-月度，quarterly-季度，yearly-年度" prop="collectionPeriod">
              <el-input
                v-model="queryParams.collectionPeriod"
                placeholder="请输入统计周期：monthly-月度，quarterly-季度，yearly-年度"
                clearable
                @keyup.enter="handleQuery"
              />
            </el-form-item>
            <el-form-item label="统计年份" prop="collectionYear">
              <el-input v-model="queryParams.collectionYear" placeholder="请输入统计年份" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="统计月份" prop="collectionMonth">
              <el-input v-model="queryParams.collectionMonth" placeholder="请输入统计月份" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="统计季度" prop="collectionQuarter">
              <el-input v-model="queryParams.collectionQuarter" placeholder="请输入统计季度" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="科室名称" prop="departmentName">
              <el-input v-model="queryParams.departmentName" placeholder="请输入科室名称" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="分子值" prop="numeratorValue">
              <el-input v-model="queryParams.numeratorValue" placeholder="请输入分子值" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="分母值" prop="denominatorValue">
              <el-input v-model="queryParams.denominatorValue" placeholder="请输入分母值" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="指标值" prop="indicatorValue">
              <el-input v-model="queryParams.indicatorValue" placeholder="请输入指标值" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="采集人" prop="collector">
              <el-input v-model="queryParams.collector" placeholder="请输入采集人" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="审核人" prop="reviewer">
              <el-input v-model="queryParams.reviewer" placeholder="请输入审核人" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="采集时间" prop="collectionTime">
              <el-date-picker clearable v-model="queryParams.collectionTime" type="date" value-format="YYYY-MM-DD" placeholder="请选择采集时间" />
            </el-form-item>
            <el-form-item label="审核时间" prop="reviewTime">
              <el-date-picker clearable v-model="queryParams.reviewTime" type="date" value-format="YYYY-MM-DD" placeholder="请选择审核时间" />
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
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['system:qcDataCollection:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="success" plain icon="Edit" :disabled="single" @click="handleUpdate()" v-hasPermi="['system:qcDataCollection:edit']"
              >修改</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button type="danger" plain icon="Delete" :disabled="multiple" @click="handleDelete()" v-hasPermi="['system:qcDataCollection:remove']"
              >删除</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['system:qcDataCollection:export']">导出</el-button>
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" border :data="qcDataCollectionList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="主键ID" align="center" prop="id" v-if="false" />
        <el-table-column label="统计周期：monthly-月度，quarterly-季度，yearly-年度" align="center" prop="collectionPeriod" />
        <el-table-column label="统计年份" align="center" prop="collectionYear" />
        <el-table-column label="统计月份" align="center" prop="collectionMonth" />
        <el-table-column label="统计季度" align="center" prop="collectionQuarter" />
        <el-table-column label="科室名称" align="center" prop="departmentName" />
        <el-table-column label="分子值" align="center" prop="numeratorValue" />
        <el-table-column label="分母值" align="center" prop="denominatorValue" />
        <el-table-column label="指标值" align="center" prop="indicatorValue" />
        <el-table-column label="数据状态：0-草稿，1-已提交，2-已审核" align="center" prop="dataStatus" />
        <el-table-column label="采集人" align="center" prop="collector" />
        <el-table-column label="审核人" align="center" prop="reviewer" />
        <el-table-column label="采集时间" align="center" prop="collectionTime" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.collectionTime, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="审核时间" align="center" prop="reviewTime" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.reviewTime, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="备注" align="center" prop="remark" />
        <el-table-column label="是否删除" align="center" prop="delFlag" />
        <el-table-column label="操作" align="center" fixed="right" class-name="small-padding fixed-width">
          <template #default="scope">
            <el-tooltip content="修改" placement="top">
              <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['system:qcDataCollection:edit']"></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button
                link
                type="primary"
                icon="Delete"
                @click="handleDelete(scope.row)"
                v-hasPermi="['system:qcDataCollection:remove']"
              ></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改数据采集记录对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="qcDataCollectionFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="指标ID" prop="indicatorId">
          <el-input v-model="form.indicatorId" placeholder="请输入指标ID" />
        </el-form-item>
        <el-form-item label="统计周期：monthly-月度，quarterly-季度，yearly-年度" prop="collectionPeriod">
          <el-input v-model="form.collectionPeriod" placeholder="请输入统计周期：monthly-月度，quarterly-季度，yearly-年度" />
        </el-form-item>
        <el-form-item label="统计年份" prop="collectionYear">
          <el-input v-model="form.collectionYear" placeholder="请输入统计年份" />
        </el-form-item>
        <el-form-item label="统计月份" prop="collectionMonth">
          <el-input v-model="form.collectionMonth" placeholder="请输入统计月份" />
        </el-form-item>
        <el-form-item label="统计季度" prop="collectionQuarter">
          <el-input v-model="form.collectionQuarter" placeholder="请输入统计季度" />
        </el-form-item>
        <el-form-item label="科室ID" prop="departmentId">
          <el-input v-model="form.departmentId" placeholder="请输入科室ID" />
        </el-form-item>
        <el-form-item label="科室名称" prop="departmentName">
          <el-input v-model="form.departmentName" placeholder="请输入科室名称" />
        </el-form-item>
        <el-form-item label="分子值" prop="numeratorValue">
          <el-input v-model="form.numeratorValue" placeholder="请输入分子值" />
        </el-form-item>
        <el-form-item label="分母值" prop="denominatorValue">
          <el-input v-model="form.denominatorValue" placeholder="请输入分母值" />
        </el-form-item>
        <el-form-item label="指标值" prop="indicatorValue">
          <el-input v-model="form.indicatorValue" placeholder="请输入指标值" />
        </el-form-item>
        <el-form-item label="采集人" prop="collector">
          <el-input v-model="form.collector" placeholder="请输入采集人" />
        </el-form-item>
        <el-form-item label="审核人" prop="reviewer">
          <el-input v-model="form.reviewer" placeholder="请输入审核人" />
        </el-form-item>
        <el-form-item label="采集时间" prop="collectionTime">
          <el-date-picker clearable v-model="form.collectionTime" type="datetime" value-format="YYYY-MM-DD HH:mm:ss" placeholder="请选择采集时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="审核时间" prop="reviewTime">
          <el-date-picker clearable v-model="form.reviewTime" type="datetime" value-format="YYYY-MM-DD HH:mm:ss" placeholder="请选择审核时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" type="textarea" placeholder="请输入内容" />
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

<script setup name="QcDataCollection" lang="ts">
import {
  listQcDataCollection,
  getQcDataCollection,
  delQcDataCollection,
  addQcDataCollection,
  updateQcDataCollection
} from '@/api/qc/qcDataCollection';
import { QcDataCollectionVO, QcDataCollectionQuery, QcDataCollectionForm } from '@/api/qc/qcDataCollection/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const qcDataCollectionList = ref<QcDataCollectionVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const qcDataCollectionFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: QcDataCollectionForm = {
  id: undefined,
  indicatorId: undefined,
  collectionPeriod: undefined,
  collectionYear: undefined,
  collectionMonth: undefined,
  collectionQuarter: undefined,
  departmentId: undefined,
  departmentName: undefined,
  numeratorValue: undefined,
  denominatorValue: undefined,
  indicatorValue: undefined,
  dataStatus: undefined,
  collector: undefined,
  reviewer: undefined,
  collectionTime: undefined,
  reviewTime: undefined,
  remark: undefined,
  delFlag: undefined
};
const data = reactive<PageData<QcDataCollectionForm, QcDataCollectionQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    collectionPeriod: undefined,
    collectionYear: undefined,
    collectionMonth: undefined,
    collectionQuarter: undefined,
    departmentName: undefined,
    numeratorValue: undefined,
    denominatorValue: undefined,
    indicatorValue: undefined,
    dataStatus: undefined,
    collector: undefined,
    reviewer: undefined,
    collectionTime: undefined,
    reviewTime: undefined,
    delFlag: undefined,
    params: {}
  },
  rules: {
    id: [{ required: true, message: '主键ID不能为空', trigger: 'blur' }],
    indicatorId: [{ required: true, message: '指标ID不能为空', trigger: 'blur' }],
    collectionPeriod: [{ required: true, message: '统计周期：monthly-月度，quarterly-季度，yearly-年度不能为空', trigger: 'blur' }],
    collectionYear: [{ required: true, message: '统计年份不能为空', trigger: 'blur' }]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询数据采集记录列表 */
const getList = async () => {
  loading.value = true;
  const res = await listQcDataCollection(queryParams.value);
  qcDataCollectionList.value = res.rows;
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
  qcDataCollectionFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: QcDataCollectionVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加数据采集记录';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: QcDataCollectionVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getQcDataCollection(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改数据采集记录';
};

/** 提交按钮 */
const submitForm = () => {
  qcDataCollectionFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateQcDataCollection(form.value).finally(() => (buttonLoading.value = false));
      } else {
        await addQcDataCollection(form.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: QcDataCollectionVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除数据采集记录编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delQcDataCollection(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/qcDataCollection/export',
    {
      ...queryParams.value
    },
    `qcDataCollection_${new Date().getTime()}.xlsx`
  );
};

onMounted(() => {
  getList();
});
</script>
