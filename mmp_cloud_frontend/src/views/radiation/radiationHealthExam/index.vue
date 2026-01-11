<template>
  <div class="p-2">
    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <div v-show="showSearch" class="mb-[10px]">
        <el-card shadow="hover">
          <el-form ref="queryFormRef" :model="queryParams" :inline="true">
            <el-form-item label="体检日期" prop="examDate">
              <el-date-picker clearable v-model="queryParams.examDate" type="date" value-format="YYYY-MM-DD" placeholder="请选择体检日期" />
            </el-form-item>
            <el-form-item label="体检医院" prop="examHospital">
              <el-input v-model="queryParams.examHospital" placeholder="请输入体检医院" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="体检医生" prop="examDoctor">
              <el-input v-model="queryParams.examDoctor" placeholder="请输入体检医生" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="体检结果" prop="examResults">
              <el-input v-model="queryParams.examResults" placeholder="请输入体检结果" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="诊断结果" prop="diagnosis">
              <el-input v-model="queryParams.diagnosis" placeholder="请输入诊断结果" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="建议" prop="recommendations">
              <el-input v-model="queryParams.recommendations" placeholder="请输入建议" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="需要随访：0-否，1-是" prop="followUpRequired">
              <el-input v-model="queryParams.followUpRequired" placeholder="请输入需要随访：0-否，1-是" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="下次体检日期" prop="nextExamDate">
              <el-date-picker clearable v-model="queryParams.nextExamDate" type="date" value-format="YYYY-MM-DD" placeholder="请选择下次体检日期" />
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
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['system:radiationHealthExam:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="success" plain icon="Edit" :disabled="single" @click="handleUpdate()" v-hasPermi="['system:radiationHealthExam:edit']"
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
              v-hasPermi="['system:radiationHealthExam:remove']"
              >删除</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['system:radiationHealthExam:export']">导出</el-button>
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" border :data="radiationHealthExamList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="主键ID" align="center" prop="id" v-if="false" />
        <el-table-column label="体检日期" align="center" prop="examDate" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.examDate, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="体检类型" align="center" prop="examType" />
        <el-table-column label="体检医院" align="center" prop="examHospital" />
        <el-table-column label="体检医生" align="center" prop="examDoctor" />
        <el-table-column label="体检结果" align="center" prop="examResults" />
        <el-table-column label="诊断结果" align="center" prop="diagnosis" />
        <el-table-column label="建议" align="center" prop="recommendations" />
        <el-table-column label="需要随访：0-否，1-是" align="center" prop="followUpRequired" />
        <el-table-column label="下次体检日期" align="center" prop="nextExamDate" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.nextExamDate, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
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
                v-hasPermi="['system:radiationHealthExam:edit']"
              ></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button
                link
                type="primary"
                icon="Delete"
                @click="handleDelete(scope.row)"
                v-hasPermi="['system:radiationHealthExam:remove']"
              ></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改职业健康体检对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="radiationHealthExamFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="工作人员ID" prop="workerId">
          <el-input v-model="form.workerId" placeholder="请输入工作人员ID" />
        </el-form-item>
        <el-form-item label="体检日期" prop="examDate">
          <el-date-picker clearable v-model="form.examDate" type="datetime" value-format="YYYY-MM-DD HH:mm:ss" placeholder="请选择体检日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="体检医院" prop="examHospital">
          <el-input v-model="form.examHospital" placeholder="请输入体检医院" />
        </el-form-item>
        <el-form-item label="体检医生" prop="examDoctor">
          <el-input v-model="form.examDoctor" placeholder="请输入体检医生" />
        </el-form-item>
        <el-form-item label="体检结果" prop="examResults">
          <el-input v-model="form.examResults" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="诊断结果" prop="diagnosis">
          <el-input v-model="form.diagnosis" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="建议" prop="recommendations">
          <el-input v-model="form.recommendations" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="需要随访：0-否，1-是" prop="followUpRequired">
          <el-input v-model="form.followUpRequired" placeholder="请输入需要随访：0-否，1-是" />
        </el-form-item>
        <el-form-item label="下次体检日期" prop="nextExamDate">
          <el-date-picker clearable v-model="form.nextExamDate" type="datetime" value-format="YYYY-MM-DD HH:mm:ss" placeholder="请选择下次体检日期">
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

<script setup name="RadiationHealthExam" lang="ts">
import {
  listRadiationHealthExam,
  getRadiationHealthExam,
  delRadiationHealthExam,
  addRadiationHealthExam,
  updateRadiationHealthExam
} from '@/api/radiation/radiationHealthExam';
import { RadiationHealthExamVO, RadiationHealthExamQuery, RadiationHealthExamForm } from '@/api/radiation/radiationHealthExam/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const radiationHealthExamList = ref<RadiationHealthExamVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const radiationHealthExamFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: RadiationHealthExamForm = {
  id: undefined,
  workerId: undefined,
  examDate: undefined,
  examType: undefined,
  examHospital: undefined,
  examDoctor: undefined,
  examResults: undefined,
  diagnosis: undefined,
  recommendations: undefined,
  followUpRequired: undefined,
  nextExamDate: undefined,
  status: undefined,
  remark: undefined
};
const data = reactive<PageData<RadiationHealthExamForm, RadiationHealthExamQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    examDate: undefined,
    examType: undefined,
    examHospital: undefined,
    examDoctor: undefined,
    examResults: undefined,
    diagnosis: undefined,
    recommendations: undefined,
    followUpRequired: undefined,
    nextExamDate: undefined,
    status: undefined,
    params: {}
  },
  rules: {
    id: [{ required: true, message: '主键ID不能为空', trigger: 'blur' }],
    workerId: [{ required: true, message: '工作人员ID不能为空', trigger: 'blur' }],
    examDate: [{ required: true, message: '体检日期不能为空', trigger: 'blur' }]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询职业健康体检列表 */
const getList = async () => {
  loading.value = true;
  const res = await listRadiationHealthExam(queryParams.value);
  radiationHealthExamList.value = res.rows;
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
  radiationHealthExamFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: RadiationHealthExamVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加职业健康体检';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: RadiationHealthExamVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getRadiationHealthExam(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改职业健康体检';
};

/** 提交按钮 */
const submitForm = () => {
  radiationHealthExamFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateRadiationHealthExam(form.value).finally(() => (buttonLoading.value = false));
      } else {
        await addRadiationHealthExam(form.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: RadiationHealthExamVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除职业健康体检编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delRadiationHealthExam(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/radiationHealthExam/export',
    {
      ...queryParams.value
    },
    `radiationHealthExam_${new Date().getTime()}.xlsx`
  );
};

onMounted(() => {
  getList();
});
</script>
