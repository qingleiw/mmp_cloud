<template>
  <div class="p-2">
    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <div v-show="showSearch" class="mb-[10px]">
        <el-card shadow="hover">
          <el-form ref="queryFormRef" :model="queryParams" :inline="true">
            <el-form-item label="检测日期" prop="inspectionDate">
              <el-date-picker clearable v-model="queryParams.inspectionDate" type="date" value-format="YYYY-MM-DD" placeholder="请选择检测日期" />
            </el-form-item>
            <el-form-item label="检测机构" prop="inspectionAgency">
              <el-input v-model="queryParams.inspectionAgency" placeholder="请输入检测机构" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="检测人员" prop="inspectorName">
              <el-input v-model="queryParams.inspectorName" placeholder="请输入检测人员" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="检测结果：pass-合格，fail-不合格" prop="inspectionResult">
              <el-input
                v-model="queryParams.inspectionResult"
                placeholder="请输入检测结果：pass-合格，fail-不合格"
                clearable
                @keyup.enter="handleQuery"
              />
            </el-form-item>
            <el-form-item label="检测报告" prop="inspectionReport">
              <el-input v-model="queryParams.inspectionReport" placeholder="请输入检测报告" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="下次检测日期" prop="nextInspectionDate">
              <el-date-picker
                clearable
                v-model="queryParams.nextInspectionDate"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择下次检测日期"
              />
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
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['system:radiationEquipmentInspection:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button
              type="success"
              plain
              icon="Edit"
              :disabled="single"
              @click="handleUpdate()"
              v-hasPermi="['system:radiationEquipmentInspection:edit']"
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
              v-hasPermi="['system:radiationEquipmentInspection:remove']"
              >删除</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['system:radiationEquipmentInspection:export']"
              >导出</el-button
            >
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" border :data="radiationEquipmentInspectionList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="主键ID" align="center" prop="id" v-if="false" />
        <el-table-column label="检测日期" align="center" prop="inspectionDate" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.inspectionDate, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="检测机构" align="center" prop="inspectionAgency" />
        <el-table-column label="检测人员" align="center" prop="inspectorName" />
        <el-table-column label="检测结果：pass-合格，fail-不合格" align="center" prop="inspectionResult" />
        <el-table-column label="检测报告" align="center" prop="inspectionReport" />
        <el-table-column label="下次检测日期" align="center" prop="nextInspectionDate" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.nextInspectionDate, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="备注" align="center" prop="remark" />
        <el-table-column label="操作" align="center" fixed="right" class-name="small-padding fixed-width">
          <template #default="scope">
            <el-tooltip content="修改" placement="top">
              <el-button
                link
                type="primary"
                icon="Edit"
                @click="handleUpdate(scope.row)"
                v-hasPermi="['system:radiationEquipmentInspection:edit']"
              ></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button
                link
                type="primary"
                icon="Delete"
                @click="handleDelete(scope.row)"
                v-hasPermi="['system:radiationEquipmentInspection:remove']"
              ></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改放射设备检测记录对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="radiationEquipmentInspectionFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="设备ID" prop="equipmentId">
          <el-input v-model="form.equipmentId" placeholder="请输入设备ID" />
        </el-form-item>
        <el-form-item label="检测日期" prop="inspectionDate">
          <el-date-picker clearable v-model="form.inspectionDate" type="datetime" value-format="YYYY-MM-DD HH:mm:ss" placeholder="请选择检测日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="检测机构" prop="inspectionAgency">
          <el-input v-model="form.inspectionAgency" placeholder="请输入检测机构" />
        </el-form-item>
        <el-form-item label="检测人员" prop="inspectorName">
          <el-input v-model="form.inspectorName" placeholder="请输入检测人员" />
        </el-form-item>
        <el-form-item label="检测结果：pass-合格，fail-不合格" prop="inspectionResult">
          <el-input v-model="form.inspectionResult" placeholder="请输入检测结果：pass-合格，fail-不合格" />
        </el-form-item>
        <el-form-item label="检测报告" prop="inspectionReport">
          <el-input v-model="form.inspectionReport" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="下次检测日期" prop="nextInspectionDate">
          <el-date-picker
            clearable
            v-model="form.nextInspectionDate"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择下次检测日期"
          >
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

<script setup name="RadiationEquipmentInspection" lang="ts">
import {
  listRadiationEquipmentInspection,
  getRadiationEquipmentInspection,
  delRadiationEquipmentInspection,
  addRadiationEquipmentInspection,
  updateRadiationEquipmentInspection
} from '@/api/system/radiationEquipmentInspection';
import {
  RadiationEquipmentInspectionVO,
  RadiationEquipmentInspectionQuery,
  RadiationEquipmentInspectionForm
} from '@/api/system/radiationEquipmentInspection/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const radiationEquipmentInspectionList = ref<RadiationEquipmentInspectionVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const radiationEquipmentInspectionFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: RadiationEquipmentInspectionForm = {
  id: undefined,
  equipmentId: undefined,
  inspectionDate: undefined,
  inspectionAgency: undefined,
  inspectorName: undefined,
  inspectionResult: undefined,
  inspectionReport: undefined,
  nextInspectionDate: undefined,
  remark: undefined
};
const data = reactive<PageData<RadiationEquipmentInspectionForm, RadiationEquipmentInspectionQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    inspectionDate: undefined,
    inspectionAgency: undefined,
    inspectorName: undefined,
    inspectionResult: undefined,
    inspectionReport: undefined,
    nextInspectionDate: undefined,
    params: {}
  },
  rules: {
    id: [{ required: true, message: '主键ID不能为空', trigger: 'blur' }],
    equipmentId: [{ required: true, message: '设备ID不能为空', trigger: 'blur' }],
    inspectionDate: [{ required: true, message: '检测日期不能为空', trigger: 'blur' }]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询放射设备检测记录列表 */
const getList = async () => {
  loading.value = true;
  const res = await listRadiationEquipmentInspection(queryParams.value);
  radiationEquipmentInspectionList.value = res.rows;
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
  radiationEquipmentInspectionFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: RadiationEquipmentInspectionVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加放射设备检测记录';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: RadiationEquipmentInspectionVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getRadiationEquipmentInspection(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改放射设备检测记录';
};

/** 提交按钮 */
const submitForm = () => {
  radiationEquipmentInspectionFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateRadiationEquipmentInspection(form.value).finally(() => (buttonLoading.value = false));
      } else {
        await addRadiationEquipmentInspection(form.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: RadiationEquipmentInspectionVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除放射设备检测记录编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delRadiationEquipmentInspection(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/radiationEquipmentInspection/export',
    {
      ...queryParams.value
    },
    `radiationEquipmentInspection_${new Date().getTime()}.xlsx`
  );
};

onMounted(() => {
  getList();
});
</script>
