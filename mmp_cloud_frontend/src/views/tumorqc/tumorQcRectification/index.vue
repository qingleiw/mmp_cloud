<template>
  <div class="p-2">
    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <div v-show="showSearch" class="mb-[10px]">
        <el-card shadow="hover">
          <el-form ref="queryFormRef" :model="queryParams" :inline="true">
            <el-form-item label="整改编码" prop="rectificationCode">
              <el-input v-model="queryParams.rectificationCode" placeholder="请输入整改编码" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="问题描述" prop="problemDescription">
              <el-input v-model="queryParams.problemDescription" placeholder="请输入问题描述" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="整改措施" prop="rectificationMeasures">
              <el-input v-model="queryParams.rectificationMeasures" placeholder="请输入整改措施" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="负责人姓名" prop="responsiblePersonName">
              <el-input v-model="queryParams.responsiblePersonName" placeholder="请输入负责人姓名" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="整改期限" prop="deadline">
              <el-date-picker clearable
                v-model="queryParams.deadline"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择整改期限"
              />
            </el-form-item>
            <el-form-item label="完成时间" prop="completionTime">
              <el-date-picker clearable
                v-model="queryParams.completionTime"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择完成时间"
              />
            </el-form-item>
            <el-form-item label="整改结果" prop="rectificationResult">
              <el-input v-model="queryParams.rectificationResult" placeholder="请输入整改结果" clearable @keyup.enter="handleQuery" />
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
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['tumorqc:tumorQcRectification:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="success" plain icon="Edit" :disabled="single" @click="handleUpdate()" v-hasPermi="['tumorqc:tumorQcRectification:edit']">修改</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="danger" plain icon="Delete" :disabled="multiple" @click="handleDelete()" v-hasPermi="['tumorqc:tumorQcRectification:remove']">删除</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['tumorqc:tumorQcRectification:export']">导出</el-button>
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" border :data="tumorQcRectificationList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="主键ID" align="center" prop="id" v-if="false" />
        <el-table-column label="整改编码" align="center" prop="rectificationCode" />
        <el-table-column label="问题描述" align="center" prop="problemDescription" />
        <el-table-column label="整改措施" align="center" prop="rectificationMeasures" />
        <el-table-column label="负责人姓名" align="center" prop="responsiblePersonName" />
        <el-table-column label="整改期限" align="center" prop="deadline" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.deadline, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="完成时间" align="center" prop="completionTime" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.completionTime, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="整改结果" align="center" prop="rectificationResult" />
        <el-table-column label="验证状态" align="center" prop="verificationStatus" />
        <el-table-column label="状态" align="center" prop="status" />
        <el-table-column label="删除标志" align="center" prop="isDeleted" />
        <el-table-column label="操作" align="center" fixed="right"  class-name="small-padding fixed-width">
          <template #default="scope">
            <el-tooltip content="修改" placement="top">
              <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['tumorqc:tumorQcRectification:edit']"></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)" v-hasPermi="['tumorqc:tumorQcRectification:remove']"></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改肿瘤质控整改对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="tumorQcRectificationFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="整改编码" prop="rectificationCode">
          <el-input v-model="form.rectificationCode" placeholder="请输入整改编码" />
        </el-form-item>
        <el-form-item label="关联检查ID" prop="inspectionId">
          <el-input v-model="form.inspectionId" placeholder="请输入关联检查ID" />
        </el-form-item>
        <el-form-item label="问题描述" prop="problemDescription">
            <el-input v-model="form.problemDescription" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="整改措施" prop="rectificationMeasures">
            <el-input v-model="form.rectificationMeasures" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="负责人ID" prop="responsiblePersonId">
          <el-input v-model="form.responsiblePersonId" placeholder="请输入负责人ID" />
        </el-form-item>
        <el-form-item label="负责人姓名" prop="responsiblePersonName">
          <el-input v-model="form.responsiblePersonName" placeholder="请输入负责人姓名" />
        </el-form-item>
        <el-form-item label="整改期限" prop="deadline">
          <el-date-picker clearable
            v-model="form.deadline"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择整改期限">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="完成时间" prop="completionTime">
          <el-date-picker clearable
            v-model="form.completionTime"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择完成时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="整改结果" prop="rectificationResult">
            <el-input v-model="form.rectificationResult" type="textarea" placeholder="请输入内容" />
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

<script setup name="TumorQcRectification" lang="ts">
import { listTumorQcRectification, getTumorQcRectification, delTumorQcRectification, addTumorQcRectification, updateTumorQcRectification } from '@/api/tumorqc/tumorQcRectification';
import { TumorQcRectificationVO, TumorQcRectificationQuery, TumorQcRectificationForm } from '@/api/tumorqc/tumorQcRectification/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const tumorQcRectificationList = ref<TumorQcRectificationVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const tumorQcRectificationFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: TumorQcRectificationForm = {
  id: undefined,
  rectificationCode: undefined,
  inspectionId: undefined,
  problemDescription: undefined,
  rectificationMeasures: undefined,
  responsiblePersonId: undefined,
  responsiblePersonName: undefined,
  deadline: undefined,
  completionTime: undefined,
  rectificationResult: undefined,
  verificationStatus: undefined,
  status: undefined,
  isDeleted: undefined
}
const data = reactive<PageData<TumorQcRectificationForm, TumorQcRectificationQuery>>({
  form: {...initFormData},
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    rectificationCode: undefined,
    problemDescription: undefined,
    rectificationMeasures: undefined,
    responsiblePersonName: undefined,
    deadline: undefined,
    completionTime: undefined,
    rectificationResult: undefined,
    verificationStatus: undefined,
    status: undefined,
    isDeleted: undefined,
    params: {
    }
  },
  rules: {
    id: [
      { required: true, message: "主键ID不能为空", trigger: "blur" }
    ],
    rectificationCode: [
      { required: true, message: "整改编码不能为空", trigger: "blur" }
    ],
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询肿瘤质控整改列表 */
const getList = async () => {
  loading.value = true;
  try {
    const res = await listTumorQcRectification(queryParams.value);
    tumorQcRectificationList.value = res.rows;
    total.value = res.total;
  } catch (error) {
    console.error('获取肿瘤质控整改列表失败:', error);
    tumorQcRectificationList.value = [];
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
  tumorQcRectificationFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: TumorQcRectificationVO[]) => {
  ids.value = selection.map(item => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
}

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = "添加肿瘤质控整改";
}

/** 修改按钮操作 */
const handleUpdate = async (row?: TumorQcRectificationVO) => {
  reset();
  const _id = row?.id || ids.value[0]
  const res = await getTumorQcRectification(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = "修改肿瘤质控整改";
}

/** 提交按钮 */
const submitForm = () => {
  tumorQcRectificationFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateTumorQcRectification(form.value).finally(() =>  buttonLoading.value = false);
      } else {
        await addTumorQcRectification(form.value).finally(() =>  buttonLoading.value = false);
      }
      proxy?.$modal.msgSuccess("操作成功");
      dialog.visible = false;
      await getList();
    }
  });
}

/** 删除按钮操作 */
const handleDelete = async (row?: TumorQcRectificationVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除肿瘤质控整改编号为"' + _ids + '"的数据项？').finally(() => loading.value = false);
  await delTumorQcRectification(_ids);
  proxy?.$modal.msgSuccess("删除成功");
  await getList();
}

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download('system/tumorQcRectification/export', {
    ...queryParams.value
  }, `tumorQcRectification_${new Date().getTime()}.xlsx`)
}

onMounted(() => {
  getList();
});
</script>
