<template>
  <div class="p-2">
    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <div v-show="showSearch" class="mb-[10px]">
        <el-card shadow="hover">
          <el-form ref="queryFormRef" :model="queryParams" :inline="true">
            <el-form-item label="药品使用流水号" prop="presSn">
              <el-input v-model="queryParams.presSn" placeholder="请输入药品使用流水号" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="本院药品编码" prop="hosDrugCode">
              <el-input v-model="queryParams.hosDrugCode" placeholder="请输入本院药品编码" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="药品通用名" prop="genericName">
              <el-input v-model="queryParams.genericName" placeholder="请输入药品通用名" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="药品商品名" prop="tradeName">
              <el-input v-model="queryParams.tradeName" placeholder="请输入药品商品名" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="生产厂家" prop="manufac">
              <el-input v-model="queryParams.manufac" placeholder="请输入生产厂家" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="批准文号" prop="approvalNo">
              <el-input v-model="queryParams.approvalNo" placeholder="请输入批准文号" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="药品剂型" prop="form">
              <el-input v-model="queryParams.form" placeholder="请输入药品剂型" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="药品规格" prop="spec">
              <el-input v-model="queryParams.spec" placeholder="请输入药品规格" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="包装数量" prop="packingQuantity">
              <el-input v-model="queryParams.packingQuantity" placeholder="请输入包装数量" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="包装单位" prop="packingUnit">
              <el-input v-model="queryParams.packingUnit" placeholder="请输入包装单位" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="药品单价" prop="presUnitPrice">
              <el-input v-model="queryParams.presUnitPrice" placeholder="请输入药品单价" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="使用数量" prop="presQuantity">
              <el-input v-model="queryParams.presQuantity" placeholder="请输入使用数量" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="使用金额" prop="presTotalPrice">
              <el-input v-model="queryParams.presTotalPrice" placeholder="请输入使用金额" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="来源:门诊/住院" prop="presOrigin">
              <el-input v-model="queryParams.presOrigin" placeholder="请输入来源:门诊/住院" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="收费时间" prop="presDate">
              <el-date-picker clearable
                v-model="queryParams.presDate"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择收费时间"
              />
            </el-form-item>
            <el-form-item label="创建时间" prop="createdTime">
              <el-date-picker clearable
                v-model="queryParams.createdTime"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择创建时间"
              />
            </el-form-item>
            <el-form-item label="更新时间" prop="updatedTime">
              <el-date-picker clearable
                v-model="queryParams.updatedTime"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择更新时间"
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
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['natdss:natdssB012DrugUse:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="success" plain icon="Edit" :disabled="single" @click="handleUpdate()" v-hasPermi="['natdss:natdssB012DrugUse:edit']">修改</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="danger" plain icon="Delete" :disabled="multiple" @click="handleDelete()" v-hasPermi="['natdss:natdssB012DrugUse:remove']">删除</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['natdss:natdssB012DrugUse:export']">导出</el-button>
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" border :data="natdssB012DrugUseList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="系统自增主键" align="center" prop="id" v-if="true" />
        <el-table-column label="药品使用流水号" align="center" prop="presSn" />
        <el-table-column label="本院药品编码" align="center" prop="hosDrugCode" />
        <el-table-column label="药品通用名" align="center" prop="genericName" />
        <el-table-column label="药品商品名" align="center" prop="tradeName" />
        <el-table-column label="生产厂家" align="center" prop="manufac" />
        <el-table-column label="批准文号" align="center" prop="approvalNo" />
        <el-table-column label="药品剂型" align="center" prop="form" />
        <el-table-column label="药品规格" align="center" prop="spec" />
        <el-table-column label="包装数量" align="center" prop="packingQuantity" />
        <el-table-column label="包装单位" align="center" prop="packingUnit" />
        <el-table-column label="药品单价" align="center" prop="presUnitPrice" />
        <el-table-column label="使用数量" align="center" prop="presQuantity" />
        <el-table-column label="使用金额" align="center" prop="presTotalPrice" />
        <el-table-column label="来源:门诊/住院" align="center" prop="presOrigin" />
        <el-table-column label="收费时间" align="center" prop="presDate" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.presDate, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="费用类型" align="center" prop="insuranceType" />
        <el-table-column label="创建时间" align="center" prop="createdTime" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.createdTime, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="更新时间" align="center" prop="updatedTime" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.updatedTime, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="操作" align="center" fixed="right" class-name="small-padding fixed-width">
          <template #default="scope">
            <el-tooltip content="修改" placement="top">
              <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['natdss:natdssB012DrugUse:edit']"></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)" v-hasPermi="['natdss:natdssB012DrugUse:remove']"></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改B01-2 抗肿瘤药物使用记录对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="natdssB012DrugUseFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="药品使用流水号" prop="presSn">
          <el-input v-model="form.presSn" placeholder="请输入药品使用流水号" />
        </el-form-item>
        <el-form-item label="本院药品编码" prop="hosDrugCode">
          <el-input v-model="form.hosDrugCode" placeholder="请输入本院药品编码" />
        </el-form-item>
        <el-form-item label="药品通用名" prop="genericName">
          <el-input v-model="form.genericName" placeholder="请输入药品通用名" />
        </el-form-item>
        <el-form-item label="药品商品名" prop="tradeName">
          <el-input v-model="form.tradeName" placeholder="请输入药品商品名" />
        </el-form-item>
        <el-form-item label="生产厂家" prop="manufac">
          <el-input v-model="form.manufac" placeholder="请输入生产厂家" />
        </el-form-item>
        <el-form-item label="批准文号" prop="approvalNo">
          <el-input v-model="form.approvalNo" placeholder="请输入批准文号" />
        </el-form-item>
        <el-form-item label="药品剂型" prop="form">
          <el-input v-model="form.form" placeholder="请输入药品剂型" />
        </el-form-item>
        <el-form-item label="药品规格" prop="spec">
          <el-input v-model="form.spec" placeholder="请输入药品规格" />
        </el-form-item>
        <el-form-item label="包装数量" prop="packingQuantity">
          <el-input v-model="form.packingQuantity" placeholder="请输入包装数量" />
        </el-form-item>
        <el-form-item label="包装单位" prop="packingUnit">
          <el-input v-model="form.packingUnit" placeholder="请输入包装单位" />
        </el-form-item>
        <el-form-item label="药品单价" prop="presUnitPrice">
          <el-input v-model="form.presUnitPrice" placeholder="请输入药品单价" />
        </el-form-item>
        <el-form-item label="使用数量" prop="presQuantity">
          <el-input v-model="form.presQuantity" placeholder="请输入使用数量" />
        </el-form-item>
        <el-form-item label="使用金额" prop="presTotalPrice">
          <el-input v-model="form.presTotalPrice" placeholder="请输入使用金额" />
        </el-form-item>
        <el-form-item label="来源:门诊/住院" prop="presOrigin">
          <el-input v-model="form.presOrigin" placeholder="请输入来源:门诊/住院" />
        </el-form-item>
        <el-form-item label="收费时间" prop="presDate">
          <el-date-picker clearable
            v-model="form.presDate"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择收费时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="创建时间" prop="createdTime">
          <el-date-picker clearable
            v-model="form.createdTime"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择创建时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="更新时间" prop="updatedTime">
          <el-date-picker clearable
            v-model="form.updatedTime"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择更新时间">
          </el-date-picker>
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

<script setup name="NatdssB012DrugUse" lang="ts">
import { listNatdssB012DrugUse, getNatdssB012DrugUse, delNatdssB012DrugUse, addNatdssB012DrugUse, updateNatdssB012DrugUse } from '@/api/natdss/natdssB012DrugUse';
import { NatdssB012DrugUseVO, NatdssB012DrugUseQuery, NatdssB012DrugUseForm } from '@/api/natdss/natdssB012DrugUse/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const natdssB012DrugUseList = ref<NatdssB012DrugUseVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const natdssB012DrugUseFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: NatdssB012DrugUseForm = {
  id: undefined,
  presSn: undefined,
  hosDrugCode: undefined,
  genericName: undefined,
  tradeName: undefined,
  manufac: undefined,
  approvalNo: undefined,
  form: undefined,
  spec: undefined,
  packingQuantity: undefined,
  packingUnit: undefined,
  presUnitPrice: undefined,
  presQuantity: undefined,
  presTotalPrice: undefined,
  presOrigin: undefined,
  presDate: undefined,
  insuranceType: undefined,
  createdTime: undefined,
  updatedTime: undefined
}
const data = reactive<PageData<NatdssB012DrugUseForm, NatdssB012DrugUseQuery>>({
  form: {...initFormData},
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    presSn: undefined,
    hosDrugCode: undefined,
    genericName: undefined,
    tradeName: undefined,
    manufac: undefined,
    approvalNo: undefined,
    form: undefined,
    spec: undefined,
    packingQuantity: undefined,
    packingUnit: undefined,
    presUnitPrice: undefined,
    presQuantity: undefined,
    presTotalPrice: undefined,
    presOrigin: undefined,
    presDate: undefined,
    insuranceType: undefined,
    createdTime: undefined,
    updatedTime: undefined,
    params: {
    }
  },
  rules: {
    id: [
      { required: true, message: "系统自增主键不能为空", trigger: "blur" }
    ],
    presSn: [
      { required: true, message: "药品使用流水号不能为空", trigger: "blur" }
    ],
    hosDrugCode: [
      { required: true, message: "本院药品编码不能为空", trigger: "blur" }
    ],
    genericName: [
      { required: true, message: "药品通用名不能为空", trigger: "blur" }
    ],
    presDate: [
      { required: true, message: "收费时间不能为空", trigger: "blur" }
    ],
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询B01-2 抗肿瘤药物使用记录列表 */
const getList = async () => {
  loading.value = true;
  const res = await listNatdssB012DrugUse(queryParams.value);
  natdssB012DrugUseList.value = res.rows;
  total.value = res.total;
  loading.value = false;
}

/** 取消按钮 */
const cancel = () => {
  reset();
  dialog.visible = false;
}

/** 表单重置 */
const reset = () => {
  form.value = {...initFormData};
  natdssB012DrugUseFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: NatdssB012DrugUseVO[]) => {
  ids.value = selection.map(item => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
}

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = "添加B01-2 抗肿瘤药物使用记录";
}

/** 修改按钮操作 */
const handleUpdate = async (row?: NatdssB012DrugUseVO) => {
  reset();
  const _id = row?.id || ids.value[0]
  const res = await getNatdssB012DrugUse(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = "修改B01-2 抗肿瘤药物使用记录";
}

/** 提交按钮 */
const submitForm = () => {
  natdssB012DrugUseFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateNatdssB012DrugUse(form.value).finally(() =>  buttonLoading.value = false);
      } else {
        await addNatdssB012DrugUse(form.value).finally(() =>  buttonLoading.value = false);
      }
      proxy?.$modal.msgSuccess("操作成功");
      dialog.visible = false;
      await getList();
    }
  });
}

/** 删除按钮操作 */
const handleDelete = async (row?: NatdssB012DrugUseVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除B01-2 抗肿瘤药物使用记录编号为"' + _ids + '"的数据项？').finally(() => loading.value = false);
  await delNatdssB012DrugUse(_ids);
  proxy?.$modal.msgSuccess("删除成功");
  await getList();
}

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download('natdss/natdssB012DrugUse/export', {
    ...queryParams.value
  }, `natdssB012DrugUse_${new Date().getTime()}.xlsx`)
}

onMounted(() => {
  getList();
});
</script>
