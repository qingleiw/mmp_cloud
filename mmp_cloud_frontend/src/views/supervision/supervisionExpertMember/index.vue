<template>
  <div class="p-2">
    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <div v-show="showSearch" class="mb-[10px]">
        <el-card shadow="hover">
          <el-form ref="queryFormRef" :model="queryParams" :inline="true">
            <el-form-item label="专家姓名" prop="expertName">
              <el-input v-model="queryParams.expertName" placeholder="请输入专家姓名" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="专家职称" prop="expertTitle">
              <el-input v-model="queryParams.expertTitle" placeholder="请输入专家职称" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="所在医院" prop="hospital">
              <el-input v-model="queryParams.hospital" placeholder="请输入所在医院" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="专业特长" prop="specialty">
              <el-input v-model="queryParams.specialty" placeholder="请输入专业特长" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="联系方式" prop="contactInfo">
              <el-input v-model="queryParams.contactInfo" placeholder="请输入联系方式" clearable @keyup.enter="handleQuery" />
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
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['supervision:supervisionExpertMember:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button
              type="success"
              plain
              icon="Edit"
              :disabled="single"
              @click="handleUpdate()"
              v-hasPermi="['supervision:supervisionExpertMember:edit']"
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
              v-hasPermi="['supervision:supervisionExpertMember:remove']"
              >删除</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['supervision:supervisionExpertMember:export']"
              >导出</el-button
            >
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" border :data="supervisionExpertMemberList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="主键ID" align="center" prop="id" v-if="false" />
        <el-table-column label="专家姓名" align="center" prop="expertName" />
        <el-table-column label="专家职称" align="center" prop="expertTitle" />
        <el-table-column label="所在医院" align="center" prop="hospital" />
        <el-table-column label="专业特长" align="center" prop="specialty" />
        <el-table-column label="联系方式" align="center" prop="contactInfo" />
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
                v-hasPermi="['supervision:supervisionExpertMember:edit']"
              ></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button
                link
                type="primary"
                icon="Delete"
                @click="handleDelete(scope.row)"
                v-hasPermi="['supervision:supervisionExpertMember:remove']"
              ></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改专家组成员对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="supervisionExpertMemberFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="专家组ID" prop="groupId">
          <el-input v-model="form.groupId" placeholder="请输入专家组ID" />
        </el-form-item>
        <el-form-item label="专家姓名" prop="expertName">
          <el-input v-model="form.expertName" placeholder="请输入专家姓名" />
        </el-form-item>
        <el-form-item label="专家职称" prop="expertTitle">
          <el-input v-model="form.expertTitle" placeholder="请输入专家职称" />
        </el-form-item>
        <el-form-item label="所在医院" prop="hospital">
          <el-input v-model="form.hospital" placeholder="请输入所在医院" />
        </el-form-item>
        <el-form-item label="专业特长" prop="specialty">
          <el-input v-model="form.specialty" placeholder="请输入专业特长" />
        </el-form-item>
        <el-form-item label="联系方式" prop="contactInfo">
          <el-input v-model="form.contactInfo" placeholder="请输入联系方式" />
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

<script setup name="SupervisionExpertMember" lang="ts">
import {
  listSupervisionExpertMember,
  getSupervisionExpertMember,
  delSupervisionExpertMember,
  addSupervisionExpertMember,
  updateSupervisionExpertMember
} from '@/api/supervision/supervisionExpertMember';
import { SupervisionExpertMemberVO, SupervisionExpertMemberQuery, SupervisionExpertMemberForm } from '@/api/supervision/supervisionExpertMember/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const supervisionExpertMemberList = ref<SupervisionExpertMemberVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const supervisionExpertMemberFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: SupervisionExpertMemberForm = {
  id: undefined,
  groupId: undefined,
  expertName: undefined,
  expertTitle: undefined,
  hospital: undefined,
  specialty: undefined,
  contactInfo: undefined,
  status: undefined,
  remark: undefined
};
const data = reactive<PageData<SupervisionExpertMemberForm, SupervisionExpertMemberQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    expertName: undefined,
    expertTitle: undefined,
    hospital: undefined,
    specialty: undefined,
    contactInfo: undefined,
    status: undefined,
    params: {}
  },
  rules: {
    id: [{ required: true, message: '主键ID不能为空', trigger: 'blur' }],
    groupId: [{ required: true, message: '专家组ID不能为空', trigger: 'blur' }],
    expertName: [{ required: true, message: '专家姓名不能为空', trigger: 'blur' }]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询专家组成员列表 */
const getList = async () => {
  loading.value = true;
  const res = await listSupervisionExpertMember(queryParams.value);
  supervisionExpertMemberList.value = res.rows;
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
  supervisionExpertMemberFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: SupervisionExpertMemberVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加专家组成员';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: SupervisionExpertMemberVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getSupervisionExpertMember(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改专家组成员';
};

/** 提交按钮 */
const submitForm = () => {
  supervisionExpertMemberFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateSupervisionExpertMember(form.value).finally(() => (buttonLoading.value = false));
      } else {
        await addSupervisionExpertMember(form.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: SupervisionExpertMemberVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除专家组成员编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delSupervisionExpertMember(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/supervisionExpertMember/export',
    {
      ...queryParams.value
    },
    `supervisionExpertMember_${new Date().getTime()}.xlsx`
  );
};

onMounted(() => {
  getList();
});
</script>
