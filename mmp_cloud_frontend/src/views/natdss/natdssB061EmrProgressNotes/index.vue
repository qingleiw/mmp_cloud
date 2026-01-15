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
            <el-form-item label="住院号" prop="patientNo">
              <el-input v-model="queryParams.patientNo" placeholder="请输入住院号" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="住院次数" prop="hospitalizationTimes">
              <el-input v-model="queryParams.hospitalizationTimes" placeholder="请输入住院次数" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="病程记录流水号" prop="recordSn">
              <el-input v-model="queryParams.recordSn" placeholder="请输入病程记录流水号" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="病程记录时间" prop="recordDatetime">
              <el-date-picker clearable
                v-model="queryParams.recordDatetime"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择病程记录时间"
              />
            </el-form-item>
            <el-form-item label="病程记录类型代码" prop="recordTitleCode">
              <el-input v-model="queryParams.recordTitleCode" placeholder="请输入病程记录类型代码" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="病程记录类型" prop="recordTitle">
              <el-input v-model="queryParams.recordTitle" placeholder="请输入病程记录类型" clearable @keyup.enter="handleQuery" />
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
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['natdss:natdssB061EmrProgressNotes:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="success" plain icon="Edit" :disabled="single" @click="handleUpdate()" v-hasPermi="['natdss:natdssB061EmrProgressNotes:edit']">修改</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="danger" plain icon="Delete" :disabled="multiple" @click="handleDelete()" v-hasPermi="['natdss:natdssB061EmrProgressNotes:remove']">删除</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['natdss:natdssB061EmrProgressNotes:export']">导出</el-button>
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" border :data="natdssB061EmrProgressNotesList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="系统自增主键" align="center" prop="id" v-if="true" />
        <el-table-column label="患者ID" align="center" prop="patientId" />
        <el-table-column label="单次就诊唯一标识号" align="center" prop="visitSn" />
        <el-table-column label="病案号" align="center" prop="medicalRecordNo" />
        <el-table-column label="住院号" align="center" prop="patientNo" />
        <el-table-column label="住院次数" align="center" prop="hospitalizationTimes" />
        <el-table-column label="病程记录流水号" align="center" prop="recordSn" />
        <el-table-column label="病程记录时间" align="center" prop="recordDatetime" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.recordDatetime, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="病程记录类型代码" align="center" prop="recordTitleCode" />
        <el-table-column label="病程记录类型" align="center" prop="recordTitle" />
        <el-table-column label="病程记录" align="center" prop="recordContent" />
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
              <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['natdss:natdssB061EmrProgressNotes:edit']"></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)" v-hasPermi="['natdss:natdssB061EmrProgressNotes:remove']"></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改B06-1 病程记录对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="natdssB061EmrProgressNotesFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="患者ID" prop="patientId">
          <el-input v-model="form.patientId" placeholder="请输入患者ID" />
        </el-form-item>
        <el-form-item label="单次就诊唯一标识号" prop="visitSn">
          <el-input v-model="form.visitSn" placeholder="请输入单次就诊唯一标识号" />
        </el-form-item>
        <el-form-item label="病案号" prop="medicalRecordNo">
          <el-input v-model="form.medicalRecordNo" placeholder="请输入病案号" />
        </el-form-item>
        <el-form-item label="住院号" prop="patientNo">
          <el-input v-model="form.patientNo" placeholder="请输入住院号" />
        </el-form-item>
        <el-form-item label="住院次数" prop="hospitalizationTimes">
          <el-input v-model="form.hospitalizationTimes" placeholder="请输入住院次数" />
        </el-form-item>
        <el-form-item label="病程记录流水号" prop="recordSn">
          <el-input v-model="form.recordSn" placeholder="请输入病程记录流水号" />
        </el-form-item>
        <el-form-item label="病程记录时间" prop="recordDatetime">
          <el-date-picker clearable
            v-model="form.recordDatetime"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择病程记录时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="病程记录类型代码" prop="recordTitleCode">
          <el-input v-model="form.recordTitleCode" placeholder="请输入病程记录类型代码" />
        </el-form-item>
        <el-form-item label="病程记录类型" prop="recordTitle">
          <el-input v-model="form.recordTitle" placeholder="请输入病程记录类型" />
        </el-form-item>
        <el-form-item label="病程记录">
          <editor v-model="form.recordContent" :min-height="192"/>
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

<script setup name="NatdssB061EmrProgressNotes" lang="ts">
import { listNatdssB061EmrProgressNotes, getNatdssB061EmrProgressNotes, delNatdssB061EmrProgressNotes, addNatdssB061EmrProgressNotes, updateNatdssB061EmrProgressNotes } from '@/api/natdss/natdssB061EmrProgressNotes';
import { NatdssB061EmrProgressNotesVO, NatdssB061EmrProgressNotesQuery, NatdssB061EmrProgressNotesForm } from '@/api/natdss/natdssB061EmrProgressNotes/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const natdssB061EmrProgressNotesList = ref<NatdssB061EmrProgressNotesVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const natdssB061EmrProgressNotesFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: NatdssB061EmrProgressNotesForm = {
  id: undefined,
  patientId: undefined,
  visitSn: undefined,
  medicalRecordNo: undefined,
  patientNo: undefined,
  hospitalizationTimes: undefined,
  recordSn: undefined,
  recordDatetime: undefined,
  recordTitleCode: undefined,
  recordTitle: undefined,
  recordContent: undefined,
  extendData1: undefined,
  extendData2: undefined,
  recordStatus: undefined,
  createdTime: undefined,
  updatedTime: undefined
}
const data = reactive<PageData<NatdssB061EmrProgressNotesForm, NatdssB061EmrProgressNotesQuery>>({
  form: {...initFormData},
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    patientId: undefined,
    visitSn: undefined,
    medicalRecordNo: undefined,
    patientNo: undefined,
    hospitalizationTimes: undefined,
    recordSn: undefined,
    recordDatetime: undefined,
    recordTitleCode: undefined,
    recordTitle: undefined,
    recordContent: undefined,
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
      { required: true, message: "病程记录流水号不能为空", trigger: "blur" }
    ],
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询B06-1 病程记录列表 */
const getList = async () => {
  loading.value = true;
  const res = await listNatdssB061EmrProgressNotes(queryParams.value);
  natdssB061EmrProgressNotesList.value = res.rows;
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
  natdssB061EmrProgressNotesFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: NatdssB061EmrProgressNotesVO[]) => {
  ids.value = selection.map(item => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
}

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = "添加B06-1 病程记录";
}

/** 修改按钮操作 */
const handleUpdate = async (row?: NatdssB061EmrProgressNotesVO) => {
  reset();
  const _id = row?.id || ids.value[0]
  const res = await getNatdssB061EmrProgressNotes(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = "修改B06-1 病程记录";
}

/** 提交按钮 */
const submitForm = () => {
  natdssB061EmrProgressNotesFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateNatdssB061EmrProgressNotes(form.value).finally(() =>  buttonLoading.value = false);
      } else {
        await addNatdssB061EmrProgressNotes(form.value).finally(() =>  buttonLoading.value = false);
      }
      proxy?.$modal.msgSuccess("操作成功");
      dialog.visible = false;
      await getList();
    }
  });
}

/** 删除按钮操作 */
const handleDelete = async (row?: NatdssB061EmrProgressNotesVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除B06-1 病程记录编号为"' + _ids + '"的数据项？').finally(() => loading.value = false);
  await delNatdssB061EmrProgressNotes(_ids);
  proxy?.$modal.msgSuccess("删除成功");
  await getList();
}

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download('natdss/natdssB061EmrProgressNotes/export', {
    ...queryParams.value
  }, `natdssB061EmrProgressNotes_${new Date().getTime()}.xlsx`)
}

onMounted(() => {
  getList();
});
</script>
