<template>
  <div class="p-2">
    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <div v-show="showSearch" class="mb-[10px]">
        <el-card shadow="hover">
          <el-form ref="queryFormRef" :model="queryParams" :inline="true">
            <el-form-item label="项目编码" prop="projectCode">
              <el-input v-model="queryParams.projectCode" placeholder="请输入项目编码" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="项目名称" prop="projectName">
              <el-input v-model="queryParams.projectName" placeholder="请输入项目名称" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="项目描述" prop="projectDescription">
              <el-input v-model="queryParams.projectDescription" placeholder="请输入项目描述" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="督导部门" prop="supervisionDepartment">
              <el-input v-model="queryParams.supervisionDepartment" placeholder="请输入督导部门" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="负责人" prop="responsiblePerson">
              <el-input v-model="queryParams.responsiblePerson" placeholder="请输入负责人" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="联系方式" prop="contactInfo">
              <el-input v-model="queryParams.contactInfo" placeholder="请输入联系方式" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="督导频次" prop="supervisionFrequency">
              <el-input v-model="queryParams.supervisionFrequency" placeholder="请输入督导频次" clearable @keyup.enter="handleQuery" />
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
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['supervision:supervisionProject:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button
              type="success"
              plain
              icon="Edit"
              :disabled="single"
              @click="handleUpdate()"
              v-hasPermi="['supervision:supervisionProject:edit']"
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
              v-hasPermi="['supervision:supervisionProject:remove']"
              >删除</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['supervision:supervisionProject:export']"
              >导出</el-button
            >
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" border :data="supervisionProjectList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="主键ID" align="center" prop="id" v-if="false" />
        <el-table-column label="项目编码" align="center" prop="projectCode" />
        <el-table-column label="项目名称" align="center" prop="projectName" />
        <el-table-column label="项目类型" align="center" prop="projectType" />
        <el-table-column label="项目描述" align="center" prop="projectDescription" />
        <el-table-column label="督导部门" align="center" prop="supervisionDepartment" />
        <el-table-column label="负责人" align="center" prop="responsiblePerson" />
        <el-table-column label="联系方式" align="center" prop="contactInfo" />
        <el-table-column label="督导频次" align="center" prop="supervisionFrequency" />
        <el-table-column label="状态：active-启用，inactive-停用" align="center" prop="status" />
        <el-table-column label="备注" align="center" prop="remark" />
        <el-table-column label="操作" align="center" fixed="right" class-name="small-padding fixed-width">
          <template #default="scope">
            <el-tooltip content="修改" placement="top">
              <el-button
                link
                type="primary"
                icon="Edit"
                @click="handleUpdate(scope.row)"
                v-hasPermi="['supervision:supervisionProject:edit']"
              ></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button
                link
                type="primary"
                icon="Delete"
                @click="handleDelete(scope.row)"
                v-hasPermi="['supervision:supervisionProject:remove']"
              ></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改督查项目对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="supervisionProjectFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="项目编码" prop="projectCode">
          <el-input v-model="form.projectCode" placeholder="请输入项目编码" />
        </el-form-item>
        <el-form-item label="项目名称" prop="projectName">
          <el-input v-model="form.projectName" placeholder="请输入项目名称" />
        </el-form-item>
        <el-form-item label="项目描述" prop="projectDescription">
          <el-input v-model="form.projectDescription" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="督导部门" prop="supervisionDepartment">
          <el-input v-model="form.supervisionDepartment" placeholder="请输入督导部门" />
        </el-form-item>
        <el-form-item label="负责人" prop="responsiblePerson">
          <el-input v-model="form.responsiblePerson" placeholder="请输入负责人" />
        </el-form-item>
        <el-form-item label="联系方式" prop="contactInfo">
          <el-input v-model="form.contactInfo" placeholder="请输入联系方式" />
        </el-form-item>
        <el-form-item label="督导频次" prop="supervisionFrequency">
          <el-input v-model="form.supervisionFrequency" placeholder="请输入督导频次" />
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

<script setup name="SupervisionProject" lang="ts">
import {
  listSupervisionProject,
  getSupervisionProject,
  delSupervisionProject,
  addSupervisionProject,
  updateSupervisionProject
} from '@/api/supervision/supervisionProject';
import { SupervisionProjectVO, SupervisionProjectQuery, SupervisionProjectForm } from '@/api/supervision/supervisionProject/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const supervisionProjectList = ref<SupervisionProjectVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const supervisionProjectFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: SupervisionProjectForm = {
  id: undefined,
  projectCode: undefined,
  projectName: undefined,
  projectType: undefined,
  projectDescription: undefined,
  supervisionDepartment: undefined,
  responsiblePerson: undefined,
  contactInfo: undefined,
  supervisionFrequency: undefined,
  status: undefined,
  remark: undefined
};
const data = reactive<PageData<SupervisionProjectForm, SupervisionProjectQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    projectCode: undefined,
    projectName: undefined,
    projectType: undefined,
    projectDescription: undefined,
    supervisionDepartment: undefined,
    responsiblePerson: undefined,
    contactInfo: undefined,
    supervisionFrequency: undefined,
    status: undefined,
    params: {}
  },
  rules: {
    id: [{ required: true, message: '主键ID不能为空', trigger: 'blur' }],
    projectCode: [{ required: true, message: '项目编码不能为空', trigger: 'blur' }],
    projectName: [{ required: true, message: '项目名称不能为空', trigger: 'blur' }]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询督查项目列表 */
const getList = async () => {
  loading.value = true;
  const res = await listSupervisionProject(queryParams.value);
  supervisionProjectList.value = res.rows;
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
  supervisionProjectFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: SupervisionProjectVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加督查项目';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: SupervisionProjectVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getSupervisionProject(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改督查项目';
};

/** 提交按钮 */
const submitForm = () => {
  supervisionProjectFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateSupervisionProject(form.value).finally(() => (buttonLoading.value = false));
      } else {
        await addSupervisionProject(form.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: SupervisionProjectVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除督查项目编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delSupervisionProject(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/supervisionProject/export',
    {
      ...queryParams.value
    },
    `supervisionProject_${new Date().getTime()}.xlsx`
  );
};

onMounted(() => {
  getList();
});
</script>
