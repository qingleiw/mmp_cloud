<template>
  <div class="p-2">
    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <div v-show="showSearch" class="mb-[10px]">
        <el-card shadow="hover">
          <el-form ref="queryFormRef" :model="queryParams" :inline="true">
            <el-form-item label="专家组编码" prop="groupCode">
              <el-input v-model="queryParams.groupCode" placeholder="请输入专家组编码" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="专家组名称" prop="groupName">
              <el-input v-model="queryParams.groupName" placeholder="请输入专家组名称" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="专业领域" prop="specialty">
              <el-input v-model="queryParams.specialty" placeholder="请输入专业领域" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="描述" prop="description">
              <el-input v-model="queryParams.description" placeholder="请输入描述" clearable @keyup.enter="handleQuery" />
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
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['system:supervisionExpertGroup:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="success" plain icon="Edit" :disabled="single" @click="handleUpdate()" v-hasPermi="['system:supervisionExpertGroup:edit']"
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
              v-hasPermi="['system:supervisionExpertGroup:remove']"
              >删除</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['system:supervisionExpertGroup:export']"
              >导出</el-button
            >
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" border :data="supervisionExpertGroupList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="主键ID" align="center" prop="id" v-if="false" />
        <el-table-column label="专家组编码" align="center" prop="groupCode" />
        <el-table-column label="专家组名称" align="center" prop="groupName" />
        <el-table-column label="专家组类型" align="center" prop="groupType" />
        <el-table-column label="专业领域" align="center" prop="specialty" />
        <el-table-column label="描述" align="center" prop="description" />
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
                v-hasPermi="['system:supervisionExpertGroup:edit']"
              ></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button
                link
                type="primary"
                icon="Delete"
                @click="handleDelete(scope.row)"
                v-hasPermi="['system:supervisionExpertGroup:remove']"
              ></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改专家组对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="supervisionExpertGroupFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="专家组编码" prop="groupCode">
          <el-input v-model="form.groupCode" placeholder="请输入专家组编码" />
        </el-form-item>
        <el-form-item label="专家组名称" prop="groupName">
          <el-input v-model="form.groupName" placeholder="请输入专家组名称" />
        </el-form-item>
        <el-form-item label="专业领域" prop="specialty">
          <el-input v-model="form.specialty" placeholder="请输入专业领域" />
        </el-form-item>
        <el-form-item label="描述" prop="description">
          <el-input v-model="form.description" type="textarea" placeholder="请输入内容" />
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

<script setup name="SupervisionExpertGroup" lang="ts">
import {
  listSupervisionExpertGroup,
  getSupervisionExpertGroup,
  delSupervisionExpertGroup,
  addSupervisionExpertGroup,
  updateSupervisionExpertGroup
} from '@/api/supervision/supervisionExpertGroup';
import { SupervisionExpertGroupVO, SupervisionExpertGroupQuery, SupervisionExpertGroupForm } from '@/api/supervision/supervisionExpertGroup/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const supervisionExpertGroupList = ref<SupervisionExpertGroupVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const supervisionExpertGroupFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: SupervisionExpertGroupForm = {
  id: undefined,
  groupCode: undefined,
  groupName: undefined,
  groupType: undefined,
  specialty: undefined,
  description: undefined,
  status: undefined,
  remark: undefined
};
const data = reactive<PageData<SupervisionExpertGroupForm, SupervisionExpertGroupQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    groupCode: undefined,
    groupName: undefined,
    groupType: undefined,
    specialty: undefined,
    description: undefined,
    status: undefined,
    params: {}
  },
  rules: {
    id: [{ required: true, message: '主键ID不能为空', trigger: 'blur' }],
    groupCode: [{ required: true, message: '专家组编码不能为空', trigger: 'blur' }],
    groupName: [{ required: true, message: '专家组名称不能为空', trigger: 'blur' }]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询专家组列表 */
const getList = async () => {
  loading.value = true;
  const res = await listSupervisionExpertGroup(queryParams.value);
  supervisionExpertGroupList.value = res.rows;
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
  supervisionExpertGroupFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: SupervisionExpertGroupVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加专家组';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: SupervisionExpertGroupVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getSupervisionExpertGroup(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改专家组';
};

/** 提交按钮 */
const submitForm = () => {
  supervisionExpertGroupFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateSupervisionExpertGroup(form.value).finally(() => (buttonLoading.value = false));
      } else {
        await addSupervisionExpertGroup(form.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: SupervisionExpertGroupVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除专家组编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delSupervisionExpertGroup(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/supervisionExpertGroup/export',
    {
      ...queryParams.value
    },
    `supervisionExpertGroup_${new Date().getTime()}.xlsx`
  );
};

onMounted(() => {
  getList();
});
</script>
