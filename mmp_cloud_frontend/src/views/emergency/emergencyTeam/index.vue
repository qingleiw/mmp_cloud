<template>
  <div class="p-2">
    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <div v-show="showSearch" class="mb-[10px]">
        <el-card shadow="hover">
          <el-form ref="queryFormRef" :model="queryParams" :inline="true">
            <el-form-item label="队伍编码" prop="teamCode">
              <el-input v-model="queryParams.teamCode" placeholder="请输入队伍编码" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="队伍名称" prop="teamName">
              <el-input v-model="queryParams.teamName" placeholder="请输入队伍名称" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="专业特长" prop="specialty">
              <el-input v-model="queryParams.specialty" placeholder="请输入专业特长" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="队长" prop="leader">
              <el-input v-model="queryParams.leader" placeholder="请输入队长" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="联系方式" prop="contactInfo">
              <el-input v-model="queryParams.contactInfo" placeholder="请输入联系方式" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="成员数量" prop="memberCount">
              <el-input v-model="queryParams.memberCount" placeholder="请输入成员数量" clearable @keyup.enter="handleQuery" />
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
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['emergency:emergencyTeam:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="success" plain icon="Edit" :disabled="single" @click="handleUpdate()" v-hasPermi="['emergency:emergencyTeam:edit']"
              >修改</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button type="danger" plain icon="Delete" :disabled="multiple" @click="handleDelete()" v-hasPermi="['emergency:emergencyTeam:remove']"
              >删除</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['emergency:emergencyTeam:export']">导出</el-button>
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" border :data="emergencyTeamList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="主键ID" align="center" prop="id" v-if="false" />
        <el-table-column label="队伍编码" align="center" prop="teamCode" />
        <el-table-column label="队伍名称" align="center" prop="teamName" />
        <el-table-column label="队伍类型" align="center" prop="teamType" />
        <el-table-column label="专业特长" align="center" prop="specialty" />
        <el-table-column label="队长" align="center" prop="leader" />
        <el-table-column label="联系方式" align="center" prop="contactInfo" />
        <el-table-column label="成员数量" align="center" prop="memberCount" />
        <el-table-column label="状态" align="center" prop="status" />
        <el-table-column label="备注" align="center" prop="remark" />
        <el-table-column label="操作" align="center" fixed="right" class-name="small-padding fixed-width">
          <template #default="scope">
            <el-tooltip content="修改" placement="top">
              <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['emergency:emergencyTeam:edit']"></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)" v-hasPermi="['emergency:emergencyTeam:remove']"></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改应急队伍对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="emergencyTeamFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="队伍编码" prop="teamCode">
          <el-input v-model="form.teamCode" placeholder="请输入队伍编码" />
        </el-form-item>
        <el-form-item label="队伍名称" prop="teamName">
          <el-input v-model="form.teamName" placeholder="请输入队伍名称" />
        </el-form-item>
        <el-form-item label="专业特长" prop="specialty">
          <el-input v-model="form.specialty" placeholder="请输入专业特长" />
        </el-form-item>
        <el-form-item label="队长" prop="leader">
          <el-input v-model="form.leader" placeholder="请输入队长" />
        </el-form-item>
        <el-form-item label="联系方式" prop="contactInfo">
          <el-input v-model="form.contactInfo" placeholder="请输入联系方式" />
        </el-form-item>
        <el-form-item label="成员数量" prop="memberCount">
          <el-input v-model="form.memberCount" placeholder="请输入成员数量" />
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

<script setup name="EmergencyTeam" lang="ts">
import { listEmergencyTeam, getEmergencyTeam, delEmergencyTeam, addEmergencyTeam, updateEmergencyTeam } from '@/api/emergency/emergencyTeam';
import { EmergencyTeamVO, EmergencyTeamQuery, EmergencyTeamForm } from '@/api/emergency/emergencyTeam/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const emergencyTeamList = ref<EmergencyTeamVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const emergencyTeamFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: EmergencyTeamForm = {
  id: undefined,
  teamCode: undefined,
  teamName: undefined,
  teamType: undefined,
  specialty: undefined,
  leader: undefined,
  contactInfo: undefined,
  memberCount: undefined,
  status: undefined,
  remark: undefined
};
const data = reactive<PageData<EmergencyTeamForm, EmergencyTeamQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    teamCode: undefined,
    teamName: undefined,
    teamType: undefined,
    specialty: undefined,
    leader: undefined,
    contactInfo: undefined,
    memberCount: undefined,
    status: undefined,
    params: {}
  },
  rules: {
    id: [{ required: true, message: '主键ID不能为空', trigger: 'blur' }],
    teamCode: [{ required: true, message: '队伍编码不能为空', trigger: 'blur' }],
    teamName: [{ required: true, message: '队伍名称不能为空', trigger: 'blur' }]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询应急队伍列表 */
const getList = async () => {
  loading.value = true;
  const res = await listEmergencyTeam(queryParams.value);
  emergencyTeamList.value = res.rows;
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
  emergencyTeamFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: EmergencyTeamVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加应急队伍';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: EmergencyTeamVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getEmergencyTeam(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改应急队伍';
};

/** 提交按钮 */
const submitForm = () => {
  emergencyTeamFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateEmergencyTeam(form.value).finally(() => (buttonLoading.value = false));
      } else {
        await addEmergencyTeam(form.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: EmergencyTeamVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除应急队伍编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delEmergencyTeam(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/emergencyTeam/export',
    {
      ...queryParams.value
    },
    `emergencyTeam_${new Date().getTime()}.xlsx`
  );
};

onMounted(() => {
  getList();
});
</script>
