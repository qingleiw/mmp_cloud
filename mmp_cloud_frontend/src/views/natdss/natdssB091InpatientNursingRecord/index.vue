<template>
  <div class="p-2">
    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <div v-show="showSearch" class="mb-[10px]">
        <el-card shadow="hover">
          <el-form ref="queryFormRef" :model="queryParams" :inline="true">
            <el-form-item label="患者ID" prop="patientId">
              <el-input v-model="queryParams.patientId" placeholder="请输入患者ID" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="单次就诊唯一标识号" prop="visitSn">
              <el-input v-model="queryParams.visitSn" placeholder="请输入单次就诊唯一标识号" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="病案号" prop="medicalRecordNo">
              <el-input v-model="queryParams.medicalRecordNo" placeholder="请输入病案号" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="住院号" prop="inpatientNo">
              <el-input v-model="queryParams.inpatientNo" placeholder="请输入住院号" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="住院次数" prop="hospitalizationTimes">
              <el-input v-model="queryParams.hospitalizationTimes" placeholder="请输入住院次数" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="护理记录流水号" prop="recordSn">
              <el-input v-model="queryParams.recordSn" placeholder="请输入护理记录流水号" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="科室代码" prop="deptCode">
              <el-input v-model="queryParams.deptCode" placeholder="请输入科室代码" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="科室名称" prop="deptName">
              <el-input v-model="queryParams.deptName" placeholder="请输入科室名称" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="床号" prop="bedNo">
              <el-input v-model="queryParams.bedNo" placeholder="请输入床号" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="护理记录时间" prop="recordDatetime">
              <el-date-picker clearable
                v-model="queryParams.recordDatetime"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择护理记录时间"
              />
            </el-form-item>
            <el-form-item label="护理测量时间" prop="testDatetime">
              <el-date-picker clearable
                v-model="queryParams.testDatetime"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择护理测量时间"
              />
            </el-form-item>
            <el-form-item label="测量方式" prop="testMethod">
              <el-input v-model="queryParams.testMethod" placeholder="请输入测量方式" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="测量项目代码" prop="itemCode">
              <el-input v-model="queryParams.itemCode" placeholder="请输入测量项目代码" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="测量项目名称" prop="itemName">
              <el-input v-model="queryParams.itemName" placeholder="请输入测量项目名称" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="疼痛评分" prop="painScores">
              <el-input v-model="queryParams.painScores" placeholder="请输入疼痛评分" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="测量结果值1" prop="itemResultValue1">
              <el-input v-model="queryParams.itemResultValue1" placeholder="请输入测量结果值1" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="测量结果单位1" prop="itemResultUnit1">
              <el-input v-model="queryParams.itemResultUnit1" placeholder="请输入测量结果单位1" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="测量结果值2" prop="itemResultValue2">
              <el-input v-model="queryParams.itemResultValue2" placeholder="请输入测量结果值2" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="测量结果单位2" prop="itemResultUnit2">
              <el-input v-model="queryParams.itemResultUnit2" placeholder="请输入测量结果单位2" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="病情观察及措施" prop="observationMeasures">
              <el-input v-model="queryParams.observationMeasures" placeholder="请输入病情观察及措施" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="扩展字段1" prop="extendData1">
              <el-input v-model="queryParams.extendData1" placeholder="请输入扩展字段1" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="扩展字段2" prop="extendData2">
              <el-input v-model="queryParams.extendData2" placeholder="请输入扩展字段2" clearable @keyup.enter="handleQuery" />
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
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['natdss:natdssB091InpatientNursingRecord:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="success" plain icon="Edit" :disabled="single" @click="handleUpdate()" v-hasPermi="['natdss:natdssB091InpatientNursingRecord:edit']">修改</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="danger" plain icon="Delete" :disabled="multiple" @click="handleDelete()" v-hasPermi="['natdss:natdssB091InpatientNursingRecord:remove']">删除</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['natdss:natdssB091InpatientNursingRecord:export']">导出</el-button>
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" border :data="natdssB091InpatientNursingRecordList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="系统自增主键" align="center" prop="id" v-if="true" />
        <el-table-column label="患者ID" align="center" prop="patientId" />
        <el-table-column label="单次就诊唯一标识号" align="center" prop="visitSn" />
        <el-table-column label="病案号" align="center" prop="medicalRecordNo" />
        <el-table-column label="住院号" align="center" prop="inpatientNo" />
        <el-table-column label="住院次数" align="center" prop="hospitalizationTimes" />
        <el-table-column label="护理记录流水号" align="center" prop="recordSn" />
        <el-table-column label="科室代码" align="center" prop="deptCode" />
        <el-table-column label="科室名称" align="center" prop="deptName" />
        <el-table-column label="床号" align="center" prop="bedNo" />
        <el-table-column label="护理记录时间" align="center" prop="recordDatetime" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.recordDatetime, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="护理测量时间" align="center" prop="testDatetime" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.testDatetime, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="测量方式" align="center" prop="testMethod" />
        <el-table-column label="测量项目代码" align="center" prop="itemCode" />
        <el-table-column label="测量项目名称" align="center" prop="itemName" />
        <el-table-column label="疼痛评分" align="center" prop="painScores" />
        <el-table-column label="测量结果值1" align="center" prop="itemResultValue1" />
        <el-table-column label="测量结果单位1" align="center" prop="itemResultUnit1" />
        <el-table-column label="测量结果值2" align="center" prop="itemResultValue2" />
        <el-table-column label="测量结果单位2" align="center" prop="itemResultUnit2" />
        <el-table-column label="病情观察及措施" align="center" prop="observationMeasures" />
        <el-table-column label="扩展字段1" align="center" prop="extendData1" />
        <el-table-column label="扩展字段2" align="center" prop="extendData2" />
        <el-table-column label="记录状态:1正常 0作废" align="center" prop="recordStatus" />
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
              <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['natdss:natdssB091InpatientNursingRecord:edit']"></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)" v-hasPermi="['natdss:natdssB091InpatientNursingRecord:remove']"></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改B09-1 住院护理记录对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="natdssB091InpatientNursingRecordFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="患者ID" prop="patientId">
          <el-input v-model="form.patientId" placeholder="请输入患者ID" />
        </el-form-item>
        <el-form-item label="单次就诊唯一标识号" prop="visitSn">
          <el-input v-model="form.visitSn" placeholder="请输入单次就诊唯一标识号" />
        </el-form-item>
        <el-form-item label="病案号" prop="medicalRecordNo">
          <el-input v-model="form.medicalRecordNo" placeholder="请输入病案号" />
        </el-form-item>
        <el-form-item label="住院号" prop="inpatientNo">
          <el-input v-model="form.inpatientNo" placeholder="请输入住院号" />
        </el-form-item>
        <el-form-item label="住院次数" prop="hospitalizationTimes">
          <el-input v-model="form.hospitalizationTimes" placeholder="请输入住院次数" />
        </el-form-item>
        <el-form-item label="护理记录流水号" prop="recordSn">
          <el-input v-model="form.recordSn" placeholder="请输入护理记录流水号" />
        </el-form-item>
        <el-form-item label="科室代码" prop="deptCode">
          <el-input v-model="form.deptCode" placeholder="请输入科室代码" />
        </el-form-item>
        <el-form-item label="科室名称" prop="deptName">
          <el-input v-model="form.deptName" placeholder="请输入科室名称" />
        </el-form-item>
        <el-form-item label="床号" prop="bedNo">
          <el-input v-model="form.bedNo" placeholder="请输入床号" />
        </el-form-item>
        <el-form-item label="护理记录时间" prop="recordDatetime">
          <el-date-picker clearable
            v-model="form.recordDatetime"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择护理记录时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="护理测量时间" prop="testDatetime">
          <el-date-picker clearable
            v-model="form.testDatetime"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择护理测量时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="测量方式" prop="testMethod">
          <el-input v-model="form.testMethod" placeholder="请输入测量方式" />
        </el-form-item>
        <el-form-item label="测量项目代码" prop="itemCode">
          <el-input v-model="form.itemCode" placeholder="请输入测量项目代码" />
        </el-form-item>
        <el-form-item label="测量项目名称" prop="itemName">
          <el-input v-model="form.itemName" placeholder="请输入测量项目名称" />
        </el-form-item>
        <el-form-item label="疼痛评分" prop="painScores">
          <el-input v-model="form.painScores" placeholder="请输入疼痛评分" />
        </el-form-item>
        <el-form-item label="测量结果值1" prop="itemResultValue1">
          <el-input v-model="form.itemResultValue1" placeholder="请输入测量结果值1" />
        </el-form-item>
        <el-form-item label="测量结果单位1" prop="itemResultUnit1">
          <el-input v-model="form.itemResultUnit1" placeholder="请输入测量结果单位1" />
        </el-form-item>
        <el-form-item label="测量结果值2" prop="itemResultValue2">
          <el-input v-model="form.itemResultValue2" placeholder="请输入测量结果值2" />
        </el-form-item>
        <el-form-item label="测量结果单位2" prop="itemResultUnit2">
          <el-input v-model="form.itemResultUnit2" placeholder="请输入测量结果单位2" />
        </el-form-item>
        <el-form-item label="病情观察及措施" prop="observationMeasures">
            <el-input v-model="form.observationMeasures" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="扩展字段1" prop="extendData1">
            <el-input v-model="form.extendData1" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="扩展字段2" prop="extendData2">
            <el-input v-model="form.extendData2" type="textarea" placeholder="请输入内容" />
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

<script setup name="NatdssB091InpatientNursingRecord" lang="ts">
import { listNatdssB091InpatientNursingRecord, getNatdssB091InpatientNursingRecord, delNatdssB091InpatientNursingRecord, addNatdssB091InpatientNursingRecord, updateNatdssB091InpatientNursingRecord } from '@/api/natdss/natdssB091InpatientNursingRecord';
import { NatdssB091InpatientNursingRecordVO, NatdssB091InpatientNursingRecordQuery, NatdssB091InpatientNursingRecordForm } from '@/api/natdss/natdssB091InpatientNursingRecord/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const natdssB091InpatientNursingRecordList = ref<NatdssB091InpatientNursingRecordVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const natdssB091InpatientNursingRecordFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: NatdssB091InpatientNursingRecordForm = {
  id: undefined,
  patientId: undefined,
  visitSn: undefined,
  medicalRecordNo: undefined,
  inpatientNo: undefined,
  hospitalizationTimes: undefined,
  recordSn: undefined,
  deptCode: undefined,
  deptName: undefined,
  bedNo: undefined,
  recordDatetime: undefined,
  testDatetime: undefined,
  testMethod: undefined,
  itemCode: undefined,
  itemName: undefined,
  painScores: undefined,
  itemResultValue1: undefined,
  itemResultUnit1: undefined,
  itemResultValue2: undefined,
  itemResultUnit2: undefined,
  observationMeasures: undefined,
  extendData1: undefined,
  extendData2: undefined,
  recordStatus: undefined,
  createdTime: undefined,
  updatedTime: undefined
}
const data = reactive<PageData<NatdssB091InpatientNursingRecordForm, NatdssB091InpatientNursingRecordQuery>>({
  form: {...initFormData},
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    patientId: undefined,
    visitSn: undefined,
    medicalRecordNo: undefined,
    inpatientNo: undefined,
    hospitalizationTimes: undefined,
    recordSn: undefined,
    deptCode: undefined,
    deptName: undefined,
    bedNo: undefined,
    recordDatetime: undefined,
    testDatetime: undefined,
    testMethod: undefined,
    itemCode: undefined,
    itemName: undefined,
    painScores: undefined,
    itemResultValue1: undefined,
    itemResultUnit1: undefined,
    itemResultValue2: undefined,
    itemResultUnit2: undefined,
    observationMeasures: undefined,
    extendData1: undefined,
    extendData2: undefined,
    recordStatus: undefined,
    createdTime: undefined,
    updatedTime: undefined,
    params: {
    }
  },
  rules: {
    id: [
      { required: true, message: "系统自增主键不能为空", trigger: "blur" }
    ],
    patientId: [
      { required: true, message: "患者ID不能为空", trigger: "blur" }
    ],
    visitSn: [
      { required: true, message: "单次就诊唯一标识号不能为空", trigger: "blur" }
    ],
    recordSn: [
      { required: true, message: "护理记录流水号不能为空", trigger: "blur" }
    ],
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询B09-1 住院护理记录列表 */
const getList = async () => {
  loading.value = true;
  const res = await listNatdssB091InpatientNursingRecord(queryParams.value);
  natdssB091InpatientNursingRecordList.value = res.rows;
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
  natdssB091InpatientNursingRecordFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: NatdssB091InpatientNursingRecordVO[]) => {
  ids.value = selection.map(item => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
}

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = "添加B09-1 住院护理记录";
}

/** 修改按钮操作 */
const handleUpdate = async (row?: NatdssB091InpatientNursingRecordVO) => {
  reset();
  const _id = row?.id || ids.value[0]
  const res = await getNatdssB091InpatientNursingRecord(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = "修改B09-1 住院护理记录";
}

/** 提交按钮 */
const submitForm = () => {
  natdssB091InpatientNursingRecordFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateNatdssB091InpatientNursingRecord(form.value).finally(() =>  buttonLoading.value = false);
      } else {
        await addNatdssB091InpatientNursingRecord(form.value).finally(() =>  buttonLoading.value = false);
      }
      proxy?.$modal.msgSuccess("操作成功");
      dialog.visible = false;
      await getList();
    }
  });
}

/** 删除按钮操作 */
const handleDelete = async (row?: NatdssB091InpatientNursingRecordVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除B09-1 住院护理记录编号为"' + _ids + '"的数据项？').finally(() => loading.value = false);
  await delNatdssB091InpatientNursingRecord(_ids);
  proxy?.$modal.msgSuccess("删除成功");
  await getList();
}

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download('natdss/natdssB091InpatientNursingRecord/export', {
    ...queryParams.value
  }, `natdssB091InpatientNursingRecord_${new Date().getTime()}.xlsx`)
}

onMounted(() => {
  getList();
});
</script>
