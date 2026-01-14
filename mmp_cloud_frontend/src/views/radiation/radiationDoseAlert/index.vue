<template>
  <div class="p-2">
    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <div v-show="showSearch" class="mb-[10px]">
        <el-card shadow="hover">
          <el-form ref="queryFormRef" :model="queryParams" :inline="true">
            <el-form-item label="阈值" prop="thresholdValue">
              <el-input v-model="queryParams.thresholdValue" placeholder="请输入阈值" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="预警级别：low-低，medium-中，high-高" prop="alertLevel">
              <el-input
                v-model="queryParams.alertLevel"
                placeholder="请输入预警级别：low-低，medium-中，high-高"
                clearable
                @keyup.enter="handleQuery"
              />
            </el-form-item>
            <el-form-item label="是否启用：0-否，1-是" prop="isActive">
              <el-input v-model="queryParams.isActive" placeholder="请输入是否启用：0-否，1-是" clearable @keyup.enter="handleQuery" />
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
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['radiation:radiationDoseAlert:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="success" plain icon="Edit" :disabled="single" @click="handleUpdate()" v-hasPermi="['radiation:radiationDoseAlert:edit']"
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
              v-hasPermi="['radiation:radiationDoseAlert:remove']"
              >删除</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['radiation:radiationDoseAlert:export']">导出</el-button>
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" border :data="radiationDoseAlertList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="主键ID" align="center" prop="id" v-if="false" />
        <el-table-column label="预警类型：monthly-月度预警，quarterly-季度预警，yearly-年度预警" align="center" prop="alertType" />
        <el-table-column label="阈值" align="center" prop="thresholdValue" />
        <el-table-column label="预警级别：low-低，medium-中，high-高" align="center" prop="alertLevel" />
        <el-table-column label="是否启用：0-否，1-是" align="center" prop="isActive" />
        <el-table-column label="备注" align="center" prop="remark" />
        <el-table-column label="操作" align="center" fixed="right" class-name="small-padding fixed-width">
          <template #default="scope">
            <el-tooltip content="修改" placement="top">
              <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['radiation:radiationDoseAlert:edit']"></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button
                link
                type="primary"
                icon="Delete"
                @click="handleDelete(scope.row)"
                v-hasPermi="['radiation:radiationDoseAlert:remove']"
              ></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改剂量监测预警设置对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="radiationDoseAlertFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="阈值" prop="thresholdValue">
          <el-input v-model="form.thresholdValue" placeholder="请输入阈值" />
        </el-form-item>
        <el-form-item label="预警级别：low-低，medium-中，high-高" prop="alertLevel">
          <el-input v-model="form.alertLevel" placeholder="请输入预警级别：low-低，medium-中，high-高" />
        </el-form-item>
        <el-form-item label="是否启用：0-否，1-是" prop="isActive">
          <el-input v-model="form.isActive" placeholder="请输入是否启用：0-否，1-是" />
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

<script setup name="RadiationDoseAlert" lang="ts">
import {
  listRadiationDoseAlert,
  getRadiationDoseAlert,
  delRadiationDoseAlert,
  addRadiationDoseAlert,
  updateRadiationDoseAlert
} from '@/api/radiation/radiationDoseAlert';
import { RadiationDoseAlertVO, RadiationDoseAlertQuery, RadiationDoseAlertForm } from '@/api/radiation/radiationDoseAlert/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const radiationDoseAlertList = ref<RadiationDoseAlertVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const radiationDoseAlertFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: RadiationDoseAlertForm = {
  id: undefined,
  alertType: undefined,
  thresholdValue: undefined,
  alertLevel: undefined,
  isActive: undefined,
  remark: undefined
};
const data = reactive<PageData<RadiationDoseAlertForm, RadiationDoseAlertQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    alertType: undefined,
    thresholdValue: undefined,
    alertLevel: undefined,
    isActive: undefined,
    params: {}
  },
  rules: {
    id: [{ required: true, message: '主键ID不能为空', trigger: 'blur' }],
    thresholdValue: [{ required: true, message: '阈值不能为空', trigger: 'blur' }]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询剂量监测预警设置列表 */
const getList = async () => {
  loading.value = true;
  const res = await listRadiationDoseAlert(queryParams.value);
  radiationDoseAlertList.value = res.rows;
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
  radiationDoseAlertFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: RadiationDoseAlertVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加剂量监测预警设置';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: RadiationDoseAlertVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getRadiationDoseAlert(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改剂量监测预警设置';
};

/** 提交按钮 */
const submitForm = () => {
  radiationDoseAlertFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateRadiationDoseAlert(form.value).finally(() => (buttonLoading.value = false));
      } else {
        await addRadiationDoseAlert(form.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: RadiationDoseAlertVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除剂量监测预警设置编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delRadiationDoseAlert(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/radiationDoseAlert/export',
    {
      ...queryParams.value
    },
    `radiationDoseAlert_${new Date().getTime()}.xlsx`
  );
};

onMounted(() => {
  getList();
});
</script>
