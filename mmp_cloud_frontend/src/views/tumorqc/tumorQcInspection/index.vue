<template>
  <div class="p-2">
    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <div v-show="showSearch" class="mb-[10px]">
        <el-card shadow="hover">
          <el-form ref="queryFormRef" :model="queryParams" :inline="true">
            <el-form-item label="检查编码" prop="inspectionCode">
              <el-input v-model="queryParams.inspectionCode" placeholder="请输入检查编码" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="检查日期" prop="inspectionDate">
              <el-date-picker clearable
                v-model="queryParams.inspectionDate"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择检查日期"
              />
            </el-form-item>
            <el-form-item label="检查人姓名" prop="inspectorName">
              <el-input v-model="queryParams.inspectorName" placeholder="请输入检查人姓名" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="检查科室名称" prop="departmentName">
              <el-input v-model="queryParams.departmentName" placeholder="请输入检查科室名称" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="检查结果" prop="inspectionResult">
              <el-input v-model="queryParams.inspectionResult" placeholder="请输入检查结果" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="问题描述" prop="problemDescription">
              <el-input v-model="queryParams.problemDescription" placeholder="请输入问题描述" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="整改建议" prop="suggestion">
              <el-input v-model="queryParams.suggestion" placeholder="请输入整改建议" clearable @keyup.enter="handleQuery" />
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
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['tumorqc:tumorQcInspection:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="success" plain icon="Edit" :disabled="single" @click="handleUpdate()" v-hasPermi="['tumorqc:tumorQcInspection:edit']">修改</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="danger" plain icon="Delete" :disabled="multiple" @click="handleDelete()" v-hasPermi="['tumorqc:tumorQcInspection:remove']">删除</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['tumorqc:tumorQcInspection:export']">导出</el-button>
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" border :data="tumorQcInspectionList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="主键ID" align="center" prop="id" v-if="false" />
        <el-table-column label="检查编码" align="center" prop="inspectionCode" />
        <el-table-column label="检查日期" align="center" prop="inspectionDate" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.inspectionDate, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="检查人姓名" align="center" prop="inspectorName" />
        <el-table-column label="检查科室名称" align="center" prop="departmentName" />
        <el-table-column label="检查类型" align="center" prop="inspectionType" />
        <el-table-column label="检查结果" align="center" prop="inspectionResult" />
        <el-table-column label="问题描述" align="center" prop="problemDescription" />
        <el-table-column label="整改建议" align="center" prop="suggestion" />
        <el-table-column label="状态" align="center" prop="status" />
        <el-table-column label="删除标志" align="center" prop="isDeleted" />
        <el-table-column label="操作" align="center" fixed="right"  class-name="small-padding fixed-width">
          <template #default="scope">
            <el-tooltip content="修改" placement="top">
              <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['tumorqc:tumorQcInspection:edit']"></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)" v-hasPermi="['tumorqc:tumorQcInspection:remove']"></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改肿瘤质控检查对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="tumorQcInspectionFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="检查编码" prop="inspectionCode">
          <el-input v-model="form.inspectionCode" placeholder="请输入检查编码" />
        </el-form-item>
        <el-form-item label="关联方案ID" prop="planId">
          <el-input v-model="form.planId" placeholder="请输入关联方案ID" />
        </el-form-item>
        <el-form-item label="检查日期" prop="inspectionDate">
          <el-date-picker clearable
            v-model="form.inspectionDate"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择检查日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="检查人ID" prop="inspectorId">
          <el-input v-model="form.inspectorId" placeholder="请输入检查人ID" />
        </el-form-item>
        <el-form-item label="检查人姓名" prop="inspectorName">
          <el-input v-model="form.inspectorName" placeholder="请输入检查人姓名" />
        </el-form-item>
        <el-form-item label="检查科室ID" prop="departmentId">
          <el-input v-model="form.departmentId" placeholder="请输入检查科室ID" />
        </el-form-item>
        <el-form-item label="检查科室名称" prop="departmentName">
          <el-input v-model="form.departmentName" placeholder="请输入检查科室名称" />
        </el-form-item>
        <el-form-item label="检查结果" prop="inspectionResult">
            <el-input v-model="form.inspectionResult" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="问题描述" prop="problemDescription">
            <el-input v-model="form.problemDescription" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="整改建议" prop="suggestion">
            <el-input v-model="form.suggestion" type="textarea" placeholder="请输入内容" />
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

<script setup name="TumorQcInspection" lang="ts">
import { listTumorQcInspection, getTumorQcInspection, delTumorQcInspection, addTumorQcInspection, updateTumorQcInspection } from '@/api/tumorqc/tumorQcInspection';
import { TumorQcInspectionVO, TumorQcInspectionQuery, TumorQcInspectionForm } from '@/api/tumorqc/tumorQcInspection/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const tumorQcInspectionList = ref<TumorQcInspectionVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const tumorQcInspectionFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: TumorQcInspectionForm = {
  id: undefined,
  inspectionCode: undefined,
  planId: undefined,
  inspectionDate: undefined,
  inspectorId: undefined,
  inspectorName: undefined,
  departmentId: undefined,
  departmentName: undefined,
  inspectionType: undefined,
  inspectionResult: undefined,
  problemDescription: undefined,
  suggestion: undefined,
  status: undefined,
  isDeleted: undefined
}
const data = reactive<PageData<TumorQcInspectionForm, TumorQcInspectionQuery>>({
  form: {...initFormData},
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    inspectionCode: undefined,
    inspectionDate: undefined,
    inspectorName: undefined,
    departmentName: undefined,
    inspectionType: undefined,
    inspectionResult: undefined,
    problemDescription: undefined,
    suggestion: undefined,
    status: undefined,
    isDeleted: undefined,
    params: {
    }
  },
  rules: {
    id: [
      { required: true, message: "主键ID不能为空", trigger: "blur" }
    ],
    inspectionCode: [
      { required: true, message: "检查编码不能为空", trigger: "blur" }
    ],
    inspectionDate: [
      { required: true, message: "检查日期不能为空", trigger: "blur" }
    ],
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询肿瘤质控检查列表 */
const getList = async () => {
  loading.value = true;
  try {
    const res = await listTumorQcInspection(queryParams.value);
    tumorQcInspectionList.value = res.rows;
    total.value = res.total;
  } catch (error) {
    console.error('获取肿瘤质控检查列表失败:', error);
    tumorQcInspectionList.value = [];
    total.value = 0;
  } finally {
    loading.value = false;
  }
}

/** 取消按钮 */
const cancel = () => {
  reset();
  dialog.visible = false;
}

/** 表单重置 */
const reset = () => {
  form.value = {...initFormData};
  tumorQcInspectionFormRef.value?.resetFields();
}

/** 搜索按钮操作 */
const handleQuery = () => {
  queryParams.value.pageNum = 1;
  getList();
}

/** 重置按钮操作 */
const resetQuery = () => {
  queryFormRef.value?.resetFields();
  handleQuery();
}

/** 多选框选中数据 */
const handleSelectionChange = (selection: TumorQcInspectionVO[]) => {
  ids.value = selection.map(item => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
}

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = "添加肿瘤质控检查";
}

/** 修改按钮操作 */
const handleUpdate = async (row?: TumorQcInspectionVO) => {
  reset();
  const _id = row?.id || ids.value[0]
  const res = await getTumorQcInspection(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = "修改肿瘤质控检查";
}

/** 提交按钮 */
const submitForm = () => {
  tumorQcInspectionFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateTumorQcInspection(form.value).finally(() =>  buttonLoading.value = false);
      } else {
        await addTumorQcInspection(form.value).finally(() =>  buttonLoading.value = false);
      }
      proxy?.$modal.msgSuccess("操作成功");
      dialog.visible = false;
      await getList();
    }
  });
}

/** 删除按钮操作 */
const handleDelete = async (row?: TumorQcInspectionVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除肿瘤质控检查编号为"' + _ids + '"的数据项？').finally(() => loading.value = false);
  await delTumorQcInspection(_ids);
  proxy?.$modal.msgSuccess("删除成功");
  await getList();
}

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download('system/tumorQcInspection/export', {
    ...queryParams.value
  }, `tumorQcInspection_${new Date().getTime()}.xlsx`)
}

onMounted(() => {
  getList();
});
</script>
