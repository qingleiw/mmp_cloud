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
            <el-form-item label="就诊卡号" prop="visitCardNo">
              <el-input v-model="queryParams.visitCardNo" placeholder="请输入就诊卡号" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="门诊号" prop="outpatientNo">
              <el-input v-model="queryParams.outpatientNo" placeholder="请输入门诊号" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="就诊次数" prop="visitTimes">
              <el-input v-model="queryParams.visitTimes" placeholder="请输入就诊次数" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="患者姓名" prop="name">
              <el-input v-model="queryParams.name" placeholder="请输入患者姓名" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="挂号流水号" prop="regisSn">
              <el-input v-model="queryParams.regisSn" placeholder="请输入挂号流水号" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="挂号时间" prop="regisDatetime">
              <el-date-picker clearable
                v-model="queryParams.regisDatetime"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择挂号时间"
              />
            </el-form-item>
            <el-form-item label="就诊时间" prop="visitDatetime">
              <el-date-picker clearable
                v-model="queryParams.visitDatetime"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择就诊时间"
              />
            </el-form-item>
            <el-form-item label="是否初诊" prop="firstVisitMark">
              <el-input v-model="queryParams.firstVisitMark" placeholder="请输入是否初诊" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="挂号渠道代码" prop="regisMethodCode">
              <el-input v-model="queryParams.regisMethodCode" placeholder="请输入挂号渠道代码" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="挂号渠道名称" prop="regisMethod">
              <el-input v-model="queryParams.regisMethod" placeholder="请输入挂号渠道名称" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="挂号类型代码" prop="regisTypeCode">
              <el-input v-model="queryParams.regisTypeCode" placeholder="请输入挂号类型代码" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="挂号金额(元)" prop="regisChargePrice">
              <el-input v-model="queryParams.regisChargePrice" placeholder="请输入挂号金额(元)" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="实付金额(元)" prop="regisPaidPrice">
              <el-input v-model="queryParams.regisPaidPrice" placeholder="请输入实付金额(元)" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="挂号科室代码" prop="regisDeptCode">
              <el-input v-model="queryParams.regisDeptCode" placeholder="请输入挂号科室代码" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="挂号科室名称" prop="regisDeptName">
              <el-input v-model="queryParams.regisDeptName" placeholder="请输入挂号科室名称" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="就诊医生代码" prop="visitDoctorNo">
              <el-input v-model="queryParams.visitDoctorNo" placeholder="请输入就诊医生代码" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="医师职称名称" prop="technicalTitle">
              <el-input v-model="queryParams.technicalTitle" placeholder="请输入医师职称名称" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="医师职务名称" prop="jobTitle">
              <el-input v-model="queryParams.jobTitle" placeholder="请输入医师职务名称" clearable @keyup.enter="handleQuery" />
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
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['natdss:natdssB121OutpatientInfo:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="success" plain icon="Edit" :disabled="single" @click="handleUpdate()" v-hasPermi="['natdss:natdssB121OutpatientInfo:edit']">修改</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="danger" plain icon="Delete" :disabled="multiple" @click="handleDelete()" v-hasPermi="['natdss:natdssB121OutpatientInfo:remove']">删除</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['natdss:natdssB121OutpatientInfo:export']">导出</el-button>
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" border :data="natdssB121OutpatientInfoList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="系统自增主键" align="center" prop="id" v-if="true" />
        <el-table-column label="患者ID" align="center" prop="patientId" />
        <el-table-column label="单次就诊唯一标识号" align="center" prop="visitSn" />
        <el-table-column label="就诊类型:门诊、急诊" align="center" prop="visitType" />
        <el-table-column label="就诊卡号" align="center" prop="visitCardNo" />
        <el-table-column label="门诊号" align="center" prop="outpatientNo" />
        <el-table-column label="就诊次数" align="center" prop="visitTimes" />
        <el-table-column label="患者姓名" align="center" prop="name" />
        <el-table-column label="挂号流水号" align="center" prop="regisSn" />
        <el-table-column label="挂号时间" align="center" prop="regisDatetime" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.regisDatetime, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="就诊时间" align="center" prop="visitDatetime" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.visitDatetime, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="是否初诊" align="center" prop="firstVisitMark" />
        <el-table-column label="挂号渠道代码" align="center" prop="regisMethodCode" />
        <el-table-column label="挂号渠道名称" align="center" prop="regisMethod" />
        <el-table-column label="挂号类型代码" align="center" prop="regisTypeCode" />
        <el-table-column label="挂号类型" align="center" prop="regisType" />
        <el-table-column label="挂号金额(元)" align="center" prop="regisChargePrice" />
        <el-table-column label="实付金额(元)" align="center" prop="regisPaidPrice" />
        <el-table-column label="挂号科室代码" align="center" prop="regisDeptCode" />
        <el-table-column label="挂号科室名称" align="center" prop="regisDeptName" />
        <el-table-column label="就诊医生代码" align="center" prop="visitDoctorNo" />
        <el-table-column label="医师职称名称" align="center" prop="technicalTitle" />
        <el-table-column label="医师职务名称" align="center" prop="jobTitle" />
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
              <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['natdss:natdssB121OutpatientInfo:edit']"></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)" v-hasPermi="['natdss:natdssB121OutpatientInfo:remove']"></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改B12-1 门诊患者信息对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="natdssB121OutpatientInfoFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="患者ID" prop="patientId">
          <el-input v-model="form.patientId" placeholder="请输入患者ID" />
        </el-form-item>
        <el-form-item label="单次就诊唯一标识号" prop="visitSn">
          <el-input v-model="form.visitSn" placeholder="请输入单次就诊唯一标识号" />
        </el-form-item>
        <el-form-item label="就诊卡号" prop="visitCardNo">
          <el-input v-model="form.visitCardNo" placeholder="请输入就诊卡号" />
        </el-form-item>
        <el-form-item label="门诊号" prop="outpatientNo">
          <el-input v-model="form.outpatientNo" placeholder="请输入门诊号" />
        </el-form-item>
        <el-form-item label="就诊次数" prop="visitTimes">
          <el-input v-model="form.visitTimes" placeholder="请输入就诊次数" />
        </el-form-item>
        <el-form-item label="患者姓名" prop="name">
          <el-input v-model="form.name" placeholder="请输入患者姓名" />
        </el-form-item>
        <el-form-item label="挂号流水号" prop="regisSn">
          <el-input v-model="form.regisSn" placeholder="请输入挂号流水号" />
        </el-form-item>
        <el-form-item label="挂号时间" prop="regisDatetime">
          <el-date-picker clearable
            v-model="form.regisDatetime"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择挂号时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="就诊时间" prop="visitDatetime">
          <el-date-picker clearable
            v-model="form.visitDatetime"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择就诊时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="是否初诊" prop="firstVisitMark">
          <el-input v-model="form.firstVisitMark" placeholder="请输入是否初诊" />
        </el-form-item>
        <el-form-item label="挂号渠道代码" prop="regisMethodCode">
          <el-input v-model="form.regisMethodCode" placeholder="请输入挂号渠道代码" />
        </el-form-item>
        <el-form-item label="挂号渠道名称" prop="regisMethod">
          <el-input v-model="form.regisMethod" placeholder="请输入挂号渠道名称" />
        </el-form-item>
        <el-form-item label="挂号类型代码" prop="regisTypeCode">
          <el-input v-model="form.regisTypeCode" placeholder="请输入挂号类型代码" />
        </el-form-item>
        <el-form-item label="挂号金额(元)" prop="regisChargePrice">
          <el-input v-model="form.regisChargePrice" placeholder="请输入挂号金额(元)" />
        </el-form-item>
        <el-form-item label="实付金额(元)" prop="regisPaidPrice">
          <el-input v-model="form.regisPaidPrice" placeholder="请输入实付金额(元)" />
        </el-form-item>
        <el-form-item label="挂号科室代码" prop="regisDeptCode">
          <el-input v-model="form.regisDeptCode" placeholder="请输入挂号科室代码" />
        </el-form-item>
        <el-form-item label="挂号科室名称" prop="regisDeptName">
          <el-input v-model="form.regisDeptName" placeholder="请输入挂号科室名称" />
        </el-form-item>
        <el-form-item label="就诊医生代码" prop="visitDoctorNo">
          <el-input v-model="form.visitDoctorNo" placeholder="请输入就诊医生代码" />
        </el-form-item>
        <el-form-item label="医师职称名称" prop="technicalTitle">
          <el-input v-model="form.technicalTitle" placeholder="请输入医师职称名称" />
        </el-form-item>
        <el-form-item label="医师职务名称" prop="jobTitle">
          <el-input v-model="form.jobTitle" placeholder="请输入医师职务名称" />
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

<script setup name="NatdssB121OutpatientInfo" lang="ts">
import { listNatdssB121OutpatientInfo, getNatdssB121OutpatientInfo, delNatdssB121OutpatientInfo, addNatdssB121OutpatientInfo, updateNatdssB121OutpatientInfo } from '@/api/natdss/natdssB121OutpatientInfo';
import { NatdssB121OutpatientInfoVO, NatdssB121OutpatientInfoQuery, NatdssB121OutpatientInfoForm } from '@/api/natdss/natdssB121OutpatientInfo/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const natdssB121OutpatientInfoList = ref<NatdssB121OutpatientInfoVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const natdssB121OutpatientInfoFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: NatdssB121OutpatientInfoForm = {
  id: undefined,
  patientId: undefined,
  visitSn: undefined,
  visitType: undefined,
  visitCardNo: undefined,
  outpatientNo: undefined,
  visitTimes: undefined,
  name: undefined,
  regisSn: undefined,
  regisDatetime: undefined,
  visitDatetime: undefined,
  firstVisitMark: undefined,
  regisMethodCode: undefined,
  regisMethod: undefined,
  regisTypeCode: undefined,
  regisType: undefined,
  regisChargePrice: undefined,
  regisPaidPrice: undefined,
  regisDeptCode: undefined,
  regisDeptName: undefined,
  visitDoctorNo: undefined,
  technicalTitle: undefined,
  jobTitle: undefined,
  extendData1: undefined,
  extendData2: undefined,
  recordStatus: undefined,
  createdTime: undefined,
  updatedTime: undefined
}
const data = reactive<PageData<NatdssB121OutpatientInfoForm, NatdssB121OutpatientInfoQuery>>({
  form: {...initFormData},
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    patientId: undefined,
    visitSn: undefined,
    visitType: undefined,
    visitCardNo: undefined,
    outpatientNo: undefined,
    visitTimes: undefined,
    name: undefined,
    regisSn: undefined,
    regisDatetime: undefined,
    visitDatetime: undefined,
    firstVisitMark: undefined,
    regisMethodCode: undefined,
    regisMethod: undefined,
    regisTypeCode: undefined,
    regisType: undefined,
    regisChargePrice: undefined,
    regisPaidPrice: undefined,
    regisDeptCode: undefined,
    regisDeptName: undefined,
    visitDoctorNo: undefined,
    technicalTitle: undefined,
    jobTitle: undefined,
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
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询B12-1 门诊患者信息列表 */
const getList = async () => {
  loading.value = true;
  const res = await listNatdssB121OutpatientInfo(queryParams.value);
  natdssB121OutpatientInfoList.value = res.rows;
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
  natdssB121OutpatientInfoFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: NatdssB121OutpatientInfoVO[]) => {
  ids.value = selection.map(item => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
}

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = "添加B12-1 门诊患者信息";
}

/** 修改按钮操作 */
const handleUpdate = async (row?: NatdssB121OutpatientInfoVO) => {
  reset();
  const _id = row?.id || ids.value[0]
  const res = await getNatdssB121OutpatientInfo(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = "修改B12-1 门诊患者信息";
}

/** 提交按钮 */
const submitForm = () => {
  natdssB121OutpatientInfoFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateNatdssB121OutpatientInfo(form.value).finally(() =>  buttonLoading.value = false);
      } else {
        await addNatdssB121OutpatientInfo(form.value).finally(() =>  buttonLoading.value = false);
      }
      proxy?.$modal.msgSuccess("操作成功");
      dialog.visible = false;
      await getList();
    }
  });
}

/** 删除按钮操作 */
const handleDelete = async (row?: NatdssB121OutpatientInfoVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除B12-1 门诊患者信息编号为"' + _ids + '"的数据项？').finally(() => loading.value = false);
  await delNatdssB121OutpatientInfo(_ids);
  proxy?.$modal.msgSuccess("删除成功");
  await getList();
}

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download('natdss/natdssB121OutpatientInfo/export', {
    ...queryParams.value
  }, `natdssB121OutpatientInfo_${new Date().getTime()}.xlsx`)
}

onMounted(() => {
  getList();
});
</script>
