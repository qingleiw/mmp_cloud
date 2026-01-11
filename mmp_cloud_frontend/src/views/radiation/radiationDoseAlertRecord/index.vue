<template>
  <div class="p-2">
    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <div v-show="showSearch" class="mb-[10px]">
        <el-card shadow="hover">
          <el-form ref="queryFormRef" :model="queryParams" :inline="true">
            <el-form-item label="工作人员姓名" prop="staffName">
              <el-input v-model="queryParams.staffName" placeholder="请输入工作人员姓名" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="预警日期" prop="alertDate">
              <el-date-picker clearable v-model="queryParams.alertDate" type="date" value-format="YYYY-MM-DD" placeholder="请选择预警日期" />
            </el-form-item>
            <el-form-item label="当前剂量" prop="currentDose">
              <el-input v-model="queryParams.currentDose" placeholder="请输入当前剂量" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="阈值" prop="thresholdValue">
              <el-input v-model="queryParams.thresholdValue" placeholder="请输入阈值" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="预警级别" prop="alertLevel">
              <el-input v-model="queryParams.alertLevel" placeholder="请输入预警级别" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="预警信息" prop="alertMessage">
              <el-input v-model="queryParams.alertMessage" placeholder="请输入预警信息" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="是否已处理：0-否，1-是" prop="isHandled">
              <el-input v-model="queryParams.isHandled" placeholder="请输入是否已处理：0-否，1-是" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="处理人" prop="handler">
              <el-input v-model="queryParams.handler" placeholder="请输入处理人" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="处理时间" prop="handleTime">
              <el-date-picker clearable v-model="queryParams.handleTime" type="date" value-format="YYYY-MM-DD" placeholder="请选择处理时间" />
            </el-form-item>
            <el-form-item label="处理结果" prop="handleResult">
              <el-input v-model="queryParams.handleResult" placeholder="请输入处理结果" clearable @keyup.enter="handleQuery" />
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
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['system:radiationDoseAlertRecord:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button
              type="success"
              plain
              icon="Edit"
              :disabled="single"
              @click="handleUpdate()"
              v-hasPermi="['system:radiationDoseAlertRecord:edit']"
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
              v-hasPermi="['system:radiationDoseAlertRecord:remove']"
              >删除</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['system:radiationDoseAlertRecord:export']"
              >导出</el-button
            >
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" border :data="radiationDoseAlertRecordList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="主键ID" align="center" prop="id" v-if="false" />
        <el-table-column label="工作人员姓名" align="center" prop="staffName" />
        <el-table-column label="预警日期" align="center" prop="alertDate" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.alertDate, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="预警类型" align="center" prop="alertType" />
        <el-table-column label="当前剂量" align="center" prop="currentDose" />
        <el-table-column label="阈值" align="center" prop="thresholdValue" />
        <el-table-column label="预警级别" align="center" prop="alertLevel" />
        <el-table-column label="预警信息" align="center" prop="alertMessage" />
        <el-table-column label="是否已处理：0-否，1-是" align="center" prop="isHandled" />
        <el-table-column label="处理人" align="center" prop="handler" />
        <el-table-column label="处理时间" align="center" prop="handleTime" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.handleTime, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="处理结果" align="center" prop="handleResult" />
        <el-table-column label="备注" align="center" prop="remark" />
        <el-table-column label="操作" align="center" fixed="right" class-name="small-padding fixed-width">
          <template #default="scope">
            <el-tooltip content="修改" placement="top">
              <el-button
                link
                type="primary"
                icon="Edit"
                @click="handleUpdate(scope.row)"
                v-hasPermi="['system:radiationDoseAlertRecord:edit']"
              ></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button
                link
                type="primary"
                icon="Delete"
                @click="handleDelete(scope.row)"
                v-hasPermi="['system:radiationDoseAlertRecord:remove']"
              ></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改剂量异常预警记录对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="radiationDoseAlertRecordFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="工作人员ID" prop="staffId">
          <el-input v-model="form.staffId" placeholder="请输入工作人员ID" />
        </el-form-item>
        <el-form-item label="工作人员姓名" prop="staffName">
          <el-input v-model="form.staffName" placeholder="请输入工作人员姓名" />
        </el-form-item>
        <el-form-item label="预警日期" prop="alertDate">
          <el-date-picker clearable v-model="form.alertDate" type="datetime" value-format="YYYY-MM-DD HH:mm:ss" placeholder="请选择预警日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="当前剂量" prop="currentDose">
          <el-input v-model="form.currentDose" placeholder="请输入当前剂量" />
        </el-form-item>
        <el-form-item label="阈值" prop="thresholdValue">
          <el-input v-model="form.thresholdValue" placeholder="请输入阈值" />
        </el-form-item>
        <el-form-item label="预警级别" prop="alertLevel">
          <el-input v-model="form.alertLevel" placeholder="请输入预警级别" />
        </el-form-item>
        <el-form-item label="预警信息" prop="alertMessage">
          <el-input v-model="form.alertMessage" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="是否已处理：0-否，1-是" prop="isHandled">
          <el-input v-model="form.isHandled" placeholder="请输入是否已处理：0-否，1-是" />
        </el-form-item>
        <el-form-item label="处理人" prop="handler">
          <el-input v-model="form.handler" placeholder="请输入处理人" />
        </el-form-item>
        <el-form-item label="处理时间" prop="handleTime">
          <el-date-picker clearable v-model="form.handleTime" type="datetime" value-format="YYYY-MM-DD HH:mm:ss" placeholder="请选择处理时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="处理结果" prop="handleResult">
          <el-input v-model="form.handleResult" type="textarea" placeholder="请输入内容" />
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

<script setup name="RadiationDoseAlertRecord" lang="ts">
import {
  listRadiationDoseAlertRecord,
  getRadiationDoseAlertRecord,
  delRadiationDoseAlertRecord,
  addRadiationDoseAlertRecord,
  updateRadiationDoseAlertRecord
} from '@/api/system/radiationDoseAlertRecord';
import { RadiationDoseAlertRecordVO, RadiationDoseAlertRecordQuery, RadiationDoseAlertRecordForm } from '@/api/system/radiationDoseAlertRecord/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const radiationDoseAlertRecordList = ref<RadiationDoseAlertRecordVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const radiationDoseAlertRecordFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: RadiationDoseAlertRecordForm = {
  id: undefined,
  staffId: undefined,
  staffName: undefined,
  alertDate: undefined,
  alertType: undefined,
  currentDose: undefined,
  thresholdValue: undefined,
  alertLevel: undefined,
  alertMessage: undefined,
  isHandled: undefined,
  handler: undefined,
  handleTime: undefined,
  handleResult: undefined,
  remark: undefined
};
const data = reactive<PageData<RadiationDoseAlertRecordForm, RadiationDoseAlertRecordQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    staffName: undefined,
    alertDate: undefined,
    alertType: undefined,
    currentDose: undefined,
    thresholdValue: undefined,
    alertLevel: undefined,
    alertMessage: undefined,
    isHandled: undefined,
    handler: undefined,
    handleTime: undefined,
    handleResult: undefined,
    params: {}
  },
  rules: {
    id: [{ required: true, message: '主键ID不能为空', trigger: 'blur' }],
    staffId: [{ required: true, message: '工作人员ID不能为空', trigger: 'blur' }],
    alertDate: [{ required: true, message: '预警日期不能为空', trigger: 'blur' }]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询剂量异常预警记录列表 */
const getList = async () => {
  loading.value = true;
  const res = await listRadiationDoseAlertRecord(queryParams.value);
  radiationDoseAlertRecordList.value = res.rows;
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
  radiationDoseAlertRecordFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: RadiationDoseAlertRecordVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加剂量异常预警记录';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: RadiationDoseAlertRecordVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getRadiationDoseAlertRecord(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改剂量异常预警记录';
};

/** 提交按钮 */
const submitForm = () => {
  radiationDoseAlertRecordFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateRadiationDoseAlertRecord(form.value).finally(() => (buttonLoading.value = false));
      } else {
        await addRadiationDoseAlertRecord(form.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: RadiationDoseAlertRecordVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除剂量异常预警记录编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delRadiationDoseAlertRecord(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/radiationDoseAlertRecord/export',
    {
      ...queryParams.value
    },
    `radiationDoseAlertRecord_${new Date().getTime()}.xlsx`
  );
};

onMounted(() => {
  getList();
});
</script>
