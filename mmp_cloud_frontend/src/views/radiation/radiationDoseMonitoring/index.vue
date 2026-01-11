<template>
  <div class="p-2">
    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <div v-show="showSearch" class="mb-[10px]">
        <el-card shadow="hover">
          <el-form ref="queryFormRef" :model="queryParams" :inline="true">
            <el-form-item label="监测日期" prop="monitoringDate">
              <el-date-picker clearable v-model="queryParams.monitoringDate" type="date" value-format="YYYY-MM-DD" placeholder="请选择监测日期" />
            </el-form-item>
            <el-form-item label="监测周期" prop="monitoringPeriod">
              <el-input v-model="queryParams.monitoringPeriod" placeholder="请输入监测周期" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="剂量值" prop="doseValue">
              <el-input v-model="queryParams.doseValue" placeholder="请输入剂量值" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="剂量单位" prop="doseUnit">
              <el-input v-model="queryParams.doseUnit" placeholder="请输入剂量单位" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="监测方法" prop="monitoringMethod">
              <el-input v-model="queryParams.monitoringMethod" placeholder="请输入监测方法" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="监测设备" prop="monitoringDevice">
              <el-input v-model="queryParams.monitoringDevice" placeholder="请输入监测设备" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="监测人员" prop="monitoringPerson">
              <el-input v-model="queryParams.monitoringPerson" placeholder="请输入监测人员" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="是否超标：0-否，1-是" prop="isExceeded">
              <el-input v-model="queryParams.isExceeded" placeholder="请输入是否超标：0-否，1-是" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="备注" prop="remarks">
              <el-input v-model="queryParams.remarks" placeholder="请输入备注" clearable @keyup.enter="handleQuery" />
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
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['system:radiationDoseMonitoring:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button
              type="success"
              plain
              icon="Edit"
              :disabled="single"
              @click="handleUpdate()"
              v-hasPermi="['system:radiationDoseMonitoring:edit']"
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
              v-hasPermi="['system:radiationDoseMonitoring:remove']"
              >删除</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['system:radiationDoseMonitoring:export']"
              >导出</el-button
            >
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" border :data="radiationDoseMonitoringList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="主键ID" align="center" prop="id" v-if="false" />
        <el-table-column label="监测日期" align="center" prop="monitoringDate" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.monitoringDate, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="监测周期" align="center" prop="monitoringPeriod" />
        <el-table-column label="剂量值" align="center" prop="doseValue" />
        <el-table-column label="剂量单位" align="center" prop="doseUnit" />
        <el-table-column label="监测方法" align="center" prop="monitoringMethod" />
        <el-table-column label="监测设备" align="center" prop="monitoringDevice" />
        <el-table-column label="监测人员" align="center" prop="monitoringPerson" />
        <el-table-column label="是否超标：0-否，1-是" align="center" prop="isExceeded" />
        <el-table-column label="备注" align="center" prop="remarks" />
        <el-table-column label="备注" align="center" prop="remark" />
        <el-table-column label="操作" align="center" fixed="right" class-name="small-padding fixed-width">
          <template #default="scope">
            <el-tooltip content="修改" placement="top">
              <el-button
                link
                type="primary"
                icon="Edit"
                @click="handleUpdate(scope.row)"
                v-hasPermi="['system:radiationDoseMonitoring:edit']"
              ></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button
                link
                type="primary"
                icon="Delete"
                @click="handleDelete(scope.row)"
                v-hasPermi="['system:radiationDoseMonitoring:remove']"
              ></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改个人剂量监测对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="radiationDoseMonitoringFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="工作人员ID" prop="workerId">
          <el-input v-model="form.workerId" placeholder="请输入工作人员ID" />
        </el-form-item>
        <el-form-item label="监测日期" prop="monitoringDate">
          <el-date-picker clearable v-model="form.monitoringDate" type="datetime" value-format="YYYY-MM-DD HH:mm:ss" placeholder="请选择监测日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="监测周期" prop="monitoringPeriod">
          <el-input v-model="form.monitoringPeriod" placeholder="请输入监测周期" />
        </el-form-item>
        <el-form-item label="剂量值" prop="doseValue">
          <el-input v-model="form.doseValue" placeholder="请输入剂量值" />
        </el-form-item>
        <el-form-item label="剂量单位" prop="doseUnit">
          <el-input v-model="form.doseUnit" placeholder="请输入剂量单位" />
        </el-form-item>
        <el-form-item label="监测方法" prop="monitoringMethod">
          <el-input v-model="form.monitoringMethod" placeholder="请输入监测方法" />
        </el-form-item>
        <el-form-item label="监测设备" prop="monitoringDevice">
          <el-input v-model="form.monitoringDevice" placeholder="请输入监测设备" />
        </el-form-item>
        <el-form-item label="监测人员" prop="monitoringPerson">
          <el-input v-model="form.monitoringPerson" placeholder="请输入监测人员" />
        </el-form-item>
        <el-form-item label="是否超标：0-否，1-是" prop="isExceeded">
          <el-input v-model="form.isExceeded" placeholder="请输入是否超标：0-否，1-是" />
        </el-form-item>
        <el-form-item label="备注" prop="remarks">
          <el-input v-model="form.remarks" type="textarea" placeholder="请输入内容" />
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

<script setup name="RadiationDoseMonitoring" lang="ts">
import {
  listRadiationDoseMonitoring,
  getRadiationDoseMonitoring,
  delRadiationDoseMonitoring,
  addRadiationDoseMonitoring,
  updateRadiationDoseMonitoring
} from '@/api/radiation/radiationDoseMonitoring';
import { RadiationDoseMonitoringVO, RadiationDoseMonitoringQuery, RadiationDoseMonitoringForm } from '@/api/radiation/radiationDoseMonitoring/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const radiationDoseMonitoringList = ref<RadiationDoseMonitoringVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const radiationDoseMonitoringFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: RadiationDoseMonitoringForm = {
  id: undefined,
  workerId: undefined,
  monitoringDate: undefined,
  monitoringPeriod: undefined,
  doseValue: undefined,
  doseUnit: undefined,
  monitoringMethod: undefined,
  monitoringDevice: undefined,
  monitoringPerson: undefined,
  isExceeded: undefined,
  remarks: undefined,
  remark: undefined
};
const data = reactive<PageData<RadiationDoseMonitoringForm, RadiationDoseMonitoringQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    monitoringDate: undefined,
    monitoringPeriod: undefined,
    doseValue: undefined,
    doseUnit: undefined,
    monitoringMethod: undefined,
    monitoringDevice: undefined,
    monitoringPerson: undefined,
    isExceeded: undefined,
    remarks: undefined,
    params: {}
  },
  rules: {
    id: [{ required: true, message: '主键ID不能为空', trigger: 'blur' }],
    workerId: [{ required: true, message: '工作人员ID不能为空', trigger: 'blur' }],
    monitoringDate: [{ required: true, message: '监测日期不能为空', trigger: 'blur' }]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询个人剂量监测列表 */
const getList = async () => {
  loading.value = true;
  const res = await listRadiationDoseMonitoring(queryParams.value);
  radiationDoseMonitoringList.value = res.rows;
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
  radiationDoseMonitoringFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: RadiationDoseMonitoringVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加个人剂量监测';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: RadiationDoseMonitoringVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getRadiationDoseMonitoring(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改个人剂量监测';
};

/** 提交按钮 */
const submitForm = () => {
  radiationDoseMonitoringFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateRadiationDoseMonitoring(form.value).finally(() => (buttonLoading.value = false));
      } else {
        await addRadiationDoseMonitoring(form.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: RadiationDoseMonitoringVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除个人剂量监测编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delRadiationDoseMonitoring(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/radiationDoseMonitoring/export',
    {
      ...queryParams.value
    },
    `radiationDoseMonitoring_${new Date().getTime()}.xlsx`
  );
};

onMounted(() => {
  getList();
});
</script>
