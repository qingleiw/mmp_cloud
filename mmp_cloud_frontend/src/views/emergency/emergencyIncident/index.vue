<template>
  <div class="p-2">
    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <div v-show="showSearch" class="mb-[10px]">
        <el-card shadow="hover">
          <el-form ref="queryFormRef" :model="queryParams" :inline="true">
            <el-form-item label="事件编码" prop="incidentCode">
              <el-input v-model="queryParams.incidentCode" placeholder="请输入事件编码" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="事件标题" prop="incidentTitle">
              <el-input v-model="queryParams.incidentTitle" placeholder="请输入事件标题" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="事件等级" prop="incidentLevel">
              <el-input v-model="queryParams.incidentLevel" placeholder="请输入事件等级" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="发生时间" prop="occurrenceTime">
              <el-date-picker clearable v-model="queryParams.occurrenceTime" type="date" value-format="YYYY-MM-DD" placeholder="请选择发生时间" />
            </el-form-item>
            <el-form-item label="发生地点" prop="location">
              <el-input v-model="queryParams.location" placeholder="请输入发生地点" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="事件描述" prop="description">
              <el-input v-model="queryParams.description" placeholder="请输入事件描述" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="受影响人员" prop="affectedPersons">
              <el-input v-model="queryParams.affectedPersons" placeholder="请输入受影响人员" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="响应队伍" prop="responseTeam">
              <el-input v-model="queryParams.responseTeam" placeholder="请输入响应队伍" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="响应措施" prop="responseMeasures">
              <el-input v-model="queryParams.responseMeasures" placeholder="请输入响应措施" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="解决时间" prop="resolutionTime">
              <el-date-picker clearable v-model="queryParams.resolutionTime" type="date" value-format="YYYY-MM-DD" placeholder="请选择解决时间" />
            </el-form-item>
            <el-form-item label="伤亡情况" prop="casualties">
              <el-input v-model="queryParams.casualties" placeholder="请输入伤亡情况" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="经济损失" prop="economicLoss">
              <el-input v-model="queryParams.economicLoss" placeholder="请输入经济损失" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="经验教训" prop="lessonsLearned">
              <el-input v-model="queryParams.lessonsLearned" placeholder="请输入经验教训" clearable @keyup.enter="handleQuery" />
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
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['emergency:emergencyIncident:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="success" plain icon="Edit" :disabled="single" @click="handleUpdate()" v-hasPermi="['emergency:emergencyIncident:edit']"
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
              v-hasPermi="['emergency:emergencyIncident:remove']"
              >删除</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['emergency:emergencyIncident:export']">导出</el-button>
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" border :data="emergencyIncidentList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="主键ID" align="center" prop="id" v-if="false" />
        <el-table-column label="事件编码" align="center" prop="incidentCode" />
        <el-table-column label="事件标题" align="center" prop="incidentTitle" />
        <el-table-column label="事件类型" align="center" prop="incidentType" />
        <el-table-column label="事件等级" align="center" prop="incidentLevel" />
        <el-table-column label="发生时间" align="center" prop="occurrenceTime" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.occurrenceTime, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="发生地点" align="center" prop="location" />
        <el-table-column label="事件描述" align="center" prop="description" />
        <el-table-column label="受影响人员" align="center" prop="affectedPersons" />
        <el-table-column label="响应队伍" align="center" prop="responseTeam" />
        <el-table-column label="响应措施" align="center" prop="responseMeasures" />
        <el-table-column label="解决时间" align="center" prop="resolutionTime" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.resolutionTime, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="伤亡情况" align="center" prop="casualties" />
        <el-table-column label="经济损失" align="center" prop="economicLoss" />
        <el-table-column label="经验教训" align="center" prop="lessonsLearned" />
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
                v-hasPermi="['emergency:emergencyIncident:edit']"
              ></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button
                link
                type="primary"
                icon="Delete"
                @click="handleDelete(scope.row)"
                v-hasPermi="['emergency:emergencyIncident:remove']"
              ></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改突发事件记录对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="emergencyIncidentFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="事件编码" prop="incidentCode">
          <el-input v-model="form.incidentCode" placeholder="请输入事件编码" />
        </el-form-item>
        <el-form-item label="事件标题" prop="incidentTitle">
          <el-input v-model="form.incidentTitle" placeholder="请输入事件标题" />
        </el-form-item>
        <el-form-item label="事件等级" prop="incidentLevel">
          <el-input v-model="form.incidentLevel" placeholder="请输入事件等级" />
        </el-form-item>
        <el-form-item label="发生时间" prop="occurrenceTime">
          <el-date-picker clearable v-model="form.occurrenceTime" type="datetime" value-format="YYYY-MM-DD HH:mm:ss" placeholder="请选择发生时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="发生地点" prop="location">
          <el-input v-model="form.location" placeholder="请输入发生地点" />
        </el-form-item>
        <el-form-item label="事件描述" prop="description">
          <el-input v-model="form.description" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="受影响人员" prop="affectedPersons">
          <el-input v-model="form.affectedPersons" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="响应队伍" prop="responseTeam">
          <el-input v-model="form.responseTeam" placeholder="请输入响应队伍" />
        </el-form-item>
        <el-form-item label="响应措施" prop="responseMeasures">
          <el-input v-model="form.responseMeasures" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="解决时间" prop="resolutionTime">
          <el-date-picker clearable v-model="form.resolutionTime" type="datetime" value-format="YYYY-MM-DD HH:mm:ss" placeholder="请选择解决时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="伤亡情况" prop="casualties">
          <el-input v-model="form.casualties" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="经济损失" prop="economicLoss">
          <el-input v-model="form.economicLoss" placeholder="请输入经济损失" />
        </el-form-item>
        <el-form-item label="经验教训" prop="lessonsLearned">
          <el-input v-model="form.lessonsLearned" type="textarea" placeholder="请输入内容" />
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

<script setup name="EmergencyIncident" lang="ts">
import {
  listEmergencyIncident,
  getEmergencyIncident,
  delEmergencyIncident,
  addEmergencyIncident,
  updateEmergencyIncident
} from '@/api/emergency/emergencyIncident';
import { EmergencyIncidentVO, EmergencyIncidentQuery, EmergencyIncidentForm } from '@/api/emergency/emergencyIncident/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const emergencyIncidentList = ref<EmergencyIncidentVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const emergencyIncidentFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: EmergencyIncidentForm = {
  id: undefined,
  incidentCode: undefined,
  incidentTitle: undefined,
  incidentType: undefined,
  incidentLevel: undefined,
  occurrenceTime: undefined,
  location: undefined,
  description: undefined,
  affectedPersons: undefined,
  responseTeam: undefined,
  responseMeasures: undefined,
  resolutionTime: undefined,
  casualties: undefined,
  economicLoss: undefined,
  lessonsLearned: undefined,
  status: undefined,
  remark: undefined
};
const data = reactive<PageData<EmergencyIncidentForm, EmergencyIncidentQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    incidentCode: undefined,
    incidentTitle: undefined,
    incidentType: undefined,
    incidentLevel: undefined,
    occurrenceTime: undefined,
    location: undefined,
    description: undefined,
    affectedPersons: undefined,
    responseTeam: undefined,
    responseMeasures: undefined,
    resolutionTime: undefined,
    casualties: undefined,
    economicLoss: undefined,
    lessonsLearned: undefined,
    status: undefined,
    params: {}
  },
  rules: {
    id: [{ required: true, message: '主键ID不能为空', trigger: 'blur' }],
    incidentCode: [{ required: true, message: '事件编码不能为空', trigger: 'blur' }],
    incidentTitle: [{ required: true, message: '事件标题不能为空', trigger: 'blur' }],
    occurrenceTime: [{ required: true, message: '发生时间不能为空', trigger: 'blur' }]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询突发事件记录列表 */
const getList = async () => {
  loading.value = true;
  const res = await listEmergencyIncident(queryParams.value);
  emergencyIncidentList.value = res.rows;
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
  emergencyIncidentFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: EmergencyIncidentVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加突发事件记录';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: EmergencyIncidentVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getEmergencyIncident(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改突发事件记录';
};

/** 提交按钮 */
const submitForm = () => {
  emergencyIncidentFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateEmergencyIncident(form.value).finally(() => (buttonLoading.value = false));
      } else {
        await addEmergencyIncident(form.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: EmergencyIncidentVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除突发事件记录编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delEmergencyIncident(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/emergencyIncident/export',
    {
      ...queryParams.value
    },
    `emergencyIncident_${new Date().getTime()}.xlsx`
  );
};

onMounted(() => {
  getList();
});
</script>
