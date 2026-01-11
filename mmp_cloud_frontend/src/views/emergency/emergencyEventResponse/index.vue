<template>
  <div class="p-2">
    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <div v-show="showSearch" class="mb-[10px]">
        <el-card shadow="hover">
          <el-form ref="queryFormRef" :model="queryParams" :inline="true">
            <el-form-item label="响应队伍" prop="responseTeam">
              <el-input v-model="queryParams.responseTeam" placeholder="请输入响应队伍" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="响应开始时间" prop="responseStartTime">
              <el-date-picker
                clearable
                v-model="queryParams.responseStartTime"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择响应开始时间"
              />
            </el-form-item>
            <el-form-item label="响应结束时间" prop="responseEndTime">
              <el-date-picker
                clearable
                v-model="queryParams.responseEndTime"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择响应结束时间"
              />
            </el-form-item>
            <el-form-item label="响应措施" prop="responseMeasures">
              <el-input v-model="queryParams.responseMeasures" placeholder="请输入响应措施" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="责任人" prop="responsiblePerson">
              <el-input v-model="queryParams.responsiblePerson" placeholder="请输入责任人" clearable @keyup.enter="handleQuery" />
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
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['system:emergencyEventResponse:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="success" plain icon="Edit" :disabled="single" @click="handleUpdate()" v-hasPermi="['system:emergencyEventResponse:edit']"
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
              v-hasPermi="['system:emergencyEventResponse:remove']"
              >删除</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['system:emergencyEventResponse:export']"
              >导出</el-button
            >
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" border :data="emergencyEventResponseList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="主键ID" align="center" prop="id" v-if="false" />
        <el-table-column label="响应队伍" align="center" prop="responseTeam" />
        <el-table-column label="响应开始时间" align="center" prop="responseStartTime" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.responseStartTime, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="响应结束时间" align="center" prop="responseEndTime" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.responseEndTime, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="响应措施" align="center" prop="responseMeasures" />
        <el-table-column label="责任人" align="center" prop="responsiblePerson" />
        <el-table-column label="备注" align="center" prop="remark" />
        <el-table-column label="操作" align="center" fixed="right" class-name="small-padding fixed-width">
          <template #default="scope">
            <el-tooltip content="修改" placement="top">
              <el-button
                link
                type="primary"
                icon="Edit"
                @click="handleUpdate(scope.row)"
                v-hasPermi="['system:emergencyEventResponse:edit']"
              ></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button
                link
                type="primary"
                icon="Delete"
                @click="handleDelete(scope.row)"
                v-hasPermi="['system:emergencyEventResponse:remove']"
              ></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改突发事件响应对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="emergencyEventResponseFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="事件ID" prop="eventId">
          <el-input v-model="form.eventId" placeholder="请输入事件ID" />
        </el-form-item>
        <el-form-item label="响应队伍" prop="responseTeam">
          <el-input v-model="form.responseTeam" placeholder="请输入响应队伍" />
        </el-form-item>
        <el-form-item label="响应开始时间" prop="responseStartTime">
          <el-date-picker
            clearable
            v-model="form.responseStartTime"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择响应开始时间"
          >
          </el-date-picker>
        </el-form-item>
        <el-form-item label="响应结束时间" prop="responseEndTime">
          <el-date-picker
            clearable
            v-model="form.responseEndTime"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择响应结束时间"
          >
          </el-date-picker>
        </el-form-item>
        <el-form-item label="响应措施" prop="responseMeasures">
          <el-input v-model="form.responseMeasures" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="责任人" prop="responsiblePerson">
          <el-input v-model="form.responsiblePerson" placeholder="请输入责任人" />
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

<script setup name="EmergencyEventResponse" lang="ts">
import {
  listEmergencyEventResponse,
  getEmergencyEventResponse,
  delEmergencyEventResponse,
  addEmergencyEventResponse,
  updateEmergencyEventResponse
} from '@/api/system/emergencyEventResponse';
import { EmergencyEventResponseVO, EmergencyEventResponseQuery, EmergencyEventResponseForm } from '@/api/system/emergencyEventResponse/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const emergencyEventResponseList = ref<EmergencyEventResponseVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const emergencyEventResponseFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: EmergencyEventResponseForm = {
  id: undefined,
  eventId: undefined,
  responseTeam: undefined,
  responseStartTime: undefined,
  responseEndTime: undefined,
  responseMeasures: undefined,
  responsiblePerson: undefined,
  remark: undefined
};
const data = reactive<PageData<EmergencyEventResponseForm, EmergencyEventResponseQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    responseTeam: undefined,
    responseStartTime: undefined,
    responseEndTime: undefined,
    responseMeasures: undefined,
    responsiblePerson: undefined,
    params: {}
  },
  rules: {
    id: [{ required: true, message: '主键ID不能为空', trigger: 'blur' }],
    eventId: [{ required: true, message: '事件ID不能为空', trigger: 'blur' }]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询突发事件响应列表 */
const getList = async () => {
  loading.value = true;
  const res = await listEmergencyEventResponse(queryParams.value);
  emergencyEventResponseList.value = res.rows;
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
  emergencyEventResponseFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: EmergencyEventResponseVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加突发事件响应';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: EmergencyEventResponseVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getEmergencyEventResponse(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改突发事件响应';
};

/** 提交按钮 */
const submitForm = () => {
  emergencyEventResponseFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateEmergencyEventResponse(form.value).finally(() => (buttonLoading.value = false));
      } else {
        await addEmergencyEventResponse(form.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: EmergencyEventResponseVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除突发事件响应编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delEmergencyEventResponse(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/emergencyEventResponse/export',
    {
      ...queryParams.value
    },
    `emergencyEventResponse_${new Date().getTime()}.xlsx`
  );
};

onMounted(() => {
  getList();
});
</script>
