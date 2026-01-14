<template>
  <div class="p-2">
    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <div v-show="showSearch" class="mb-[10px]">
        <el-card shadow="hover">
          <el-form ref="queryFormRef" :model="queryParams" :inline="true">
            <el-form-item label="成员姓名" prop="memberName">
              <el-input v-model="queryParams.memberName" placeholder="请输入成员姓名" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="所在部门" prop="department">
              <el-input v-model="queryParams.department" placeholder="请输入所在部门" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="职位" prop="position">
              <el-input v-model="queryParams.position" placeholder="请输入职位" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="专业特长" prop="specialty">
              <el-input v-model="queryParams.specialty" placeholder="请输入专业特长" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="联系方式" prop="contactInfo">
              <el-input v-model="queryParams.contactInfo" placeholder="请输入联系方式" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="紧急联系人" prop="emergencyContact">
              <el-input v-model="queryParams.emergencyContact" placeholder="请输入紧急联系人" clearable @keyup.enter="handleQuery" />
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
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['emergency:emergencyTeamMember:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="success" plain icon="Edit" :disabled="single" @click="handleUpdate()" v-hasPermi="['emergency:emergencyTeamMember:edit']"
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
              v-hasPermi="['emergency:emergencyTeamMember:remove']"
              >删除</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['emergency:emergencyTeamMember:export']">导出</el-button>
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" border :data="emergencyTeamMemberList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="主键ID" align="center" prop="id" v-if="false" />
        <el-table-column label="成员姓名" align="center" prop="memberName" />
        <el-table-column label="成员类型" align="center" prop="memberType" />
        <el-table-column label="所在部门" align="center" prop="department" />
        <el-table-column label="职位" align="center" prop="position" />
        <el-table-column label="专业特长" align="center" prop="specialty" />
        <el-table-column label="联系方式" align="center" prop="contactInfo" />
        <el-table-column label="紧急联系人" align="center" prop="emergencyContact" />
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
                v-hasPermi="['emergency:emergencyTeamMember:edit']"
              ></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button
                link
                type="primary"
                icon="Delete"
                @click="handleDelete(scope.row)"
                v-hasPermi="['emergency:emergencyTeamMember:remove']"
              ></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改应急队伍成员对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="emergencyTeamMemberFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="队伍ID" prop="teamId">
          <el-input v-model="form.teamId" placeholder="请输入队伍ID" />
        </el-form-item>
        <el-form-item label="成员姓名" prop="memberName">
          <el-input v-model="form.memberName" placeholder="请输入成员姓名" />
        </el-form-item>
        <el-form-item label="所在部门" prop="department">
          <el-input v-model="form.department" placeholder="请输入所在部门" />
        </el-form-item>
        <el-form-item label="职位" prop="position">
          <el-input v-model="form.position" placeholder="请输入职位" />
        </el-form-item>
        <el-form-item label="专业特长" prop="specialty">
          <el-input v-model="form.specialty" placeholder="请输入专业特长" />
        </el-form-item>
        <el-form-item label="联系方式" prop="contactInfo">
          <el-input v-model="form.contactInfo" placeholder="请输入联系方式" />
        </el-form-item>
        <el-form-item label="紧急联系人" prop="emergencyContact">
          <el-input v-model="form.emergencyContact" placeholder="请输入紧急联系人" />
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

<script setup name="EmergencyTeamMember" lang="ts">
import {
  listEmergencyTeamMember,
  getEmergencyTeamMember,
  delEmergencyTeamMember,
  addEmergencyTeamMember,
  updateEmergencyTeamMember
} from '@/api/emergency/emergencyTeamMember';
import { EmergencyTeamMemberVO, EmergencyTeamMemberQuery, EmergencyTeamMemberForm } from '@/api/emergency/emergencyTeamMember/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const emergencyTeamMemberList = ref<EmergencyTeamMemberVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const emergencyTeamMemberFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: EmergencyTeamMemberForm = {
  id: undefined,
  teamId: undefined,
  memberName: undefined,
  memberType: undefined,
  department: undefined,
  position: undefined,
  specialty: undefined,
  contactInfo: undefined,
  emergencyContact: undefined,
  status: undefined,
  remark: undefined
};
const data = reactive<PageData<EmergencyTeamMemberForm, EmergencyTeamMemberQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    memberName: undefined,
    memberType: undefined,
    department: undefined,
    position: undefined,
    specialty: undefined,
    contactInfo: undefined,
    emergencyContact: undefined,
    status: undefined,
    params: {}
  },
  rules: {
    id: [{ required: true, message: '主键ID不能为空', trigger: 'blur' }],
    teamId: [{ required: true, message: '队伍ID不能为空', trigger: 'blur' }],
    memberName: [{ required: true, message: '成员姓名不能为空', trigger: 'blur' }]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询应急队伍成员列表 */
const getList = async () => {
  loading.value = true;
  const res = await listEmergencyTeamMember(queryParams.value);
  emergencyTeamMemberList.value = res.rows;
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
  emergencyTeamMemberFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: EmergencyTeamMemberVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加应急队伍成员';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: EmergencyTeamMemberVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getEmergencyTeamMember(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改应急队伍成员';
};

/** 提交按钮 */
const submitForm = () => {
  emergencyTeamMemberFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateEmergencyTeamMember(form.value).finally(() => (buttonLoading.value = false));
      } else {
        await addEmergencyTeamMember(form.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: EmergencyTeamMemberVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除应急队伍成员编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delEmergencyTeamMember(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/emergencyTeamMember/export',
    {
      ...queryParams.value
    },
    `emergencyTeamMember_${new Date().getTime()}.xlsx`
  );
};

onMounted(() => {
  getList();
});
</script>
