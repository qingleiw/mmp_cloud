<template>
  <app-container>
    <page-header title="新技术项目对码管理">
      <template #action>
        <el-button type="primary" icon="Plus" @click="handleAdd" v-hasPermi="['ntp:newTechnologyProjectMapping:add']">新增</el-button>
        <el-button
          type="success"
          plain
          icon="Edit"
          :disabled="single"
          @click="handleUpdate()"
          v-hasPermi="['ntp:newTechnologyProjectMapping:edit']"
          >修改</el-button
        >
        <el-button
          type="danger"
          plain
          icon="Delete"
          :disabled="multiple"
          @click="handleDelete()"
          v-hasPermi="['ntp:newTechnologyProjectMapping:remove']"
          >删除</el-button
        >
        <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['ntp:newTechnologyProjectMapping:export']"
          >导出</el-button
        >
      </template>
    </page-header>

    <search-card v-model:show="showSearch" @search="handleQuery" @reset="resetQuery">
      <el-form ref="queryFormRef" :model="queryParams" :inline="true">
        <el-form-item label="源编码" prop="sourceCode">
          <el-input v-model="queryParams.sourceCode" placeholder="请输入源编码" clearable @keyup.enter="handleQuery" />
        </el-form-item>
        <el-form-item label="源名称" prop="sourceName">
          <el-input v-model="queryParams.sourceName" placeholder="请输入源名称" clearable @keyup.enter="handleQuery" />
        </el-form-item>
        <el-form-item label="目标系统 HIS/收费系统" prop="targetSystem">
          <el-input v-model="queryParams.targetSystem" placeholder="请输入目标系统 HIS/收费系统" clearable @keyup.enter="handleQuery" />
        </el-form-item>
      </el-form>
    </search-card>

    <table-card v-loading="loading" :data="newTechnologyProjectMappingList" @selection-change="handleSelectionChange">
      <template #columns>
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="主键ID" align="center" prop="id" v-if="false" />
        <el-table-column label="对码类型 医嘱项/ICD-9/收费项" align="center" prop="mappingType" />
        <el-table-column label="源编码" align="center" prop="sourceCode" />
        <el-table-column label="源名称" align="center" prop="sourceName" />
        <el-table-column label="目标系统 HIS/收费系统" align="center" prop="targetSystem" />
        <el-table-column label="备注" align="center" prop="remark" />
        <el-table-column label="操作" align="center" fixed="right" class-name="small-padding fixed-width">
          <template #default="scope">
            <el-tooltip content="修改" placement="top">
              <el-button
                link
                type="primary"
                icon="Edit"
                @click="handleUpdate(scope.row)"
                v-hasPermi="['ntp:newTechnologyProjectMapping:edit']"
              ></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button
                link
                type="primary"
                icon="Delete"
                @click="handleDelete(scope.row)"
                v-hasPermi="['ntp:newTechnologyProjectMapping:remove']"
              ></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </template>

      <template #pagination>
        <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
      </template>
    </table-card>
    <!-- 添加或修改新技术项目对码对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="newTechnologyProjectMappingFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="项目ID" prop="projectId">
          <el-input v-model="form.projectId" placeholder="请输入项目ID" />
        </el-form-item>
        <el-form-item label="源编码" prop="sourceCode">
          <el-input v-model="form.sourceCode" placeholder="请输入源编码" />
        </el-form-item>
        <el-form-item label="源名称" prop="sourceName">
          <el-input v-model="form.sourceName" placeholder="请输入源名称" />
        </el-form-item>
        <el-form-item label="目标系统 HIS/收费系统" prop="targetSystem">
          <el-input v-model="form.targetSystem" placeholder="请输入目标系统 HIS/收费系统" />
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

<script setup name="NewTechnologyProjectMapping" lang="ts">
import {
  listNewTechnologyProjectMapping,
  getNewTechnologyProjectMapping,
  delNewTechnologyProjectMapping,
  addNewTechnologyProjectMapping,
  updateNewTechnologyProjectMapping
} from '@/api/ntp/newTechnologyProjectMapping';
import {
  NewTechnologyProjectMappingVO,
  NewTechnologyProjectMappingQuery,
  NewTechnologyProjectMappingForm
} from '@/api/ntp/newTechnologyProjectMapping/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const newTechnologyProjectMappingList = ref<NewTechnologyProjectMappingVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const newTechnologyProjectMappingFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: NewTechnologyProjectMappingForm = {
  id: undefined,
  projectId: undefined,
  mappingType: undefined,
  sourceCode: undefined,
  sourceName: undefined,
  targetSystem: undefined,
  remark: undefined
};
const data = reactive<PageData<NewTechnologyProjectMappingForm, NewTechnologyProjectMappingQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    mappingType: undefined,
    sourceCode: undefined,
    sourceName: undefined,
    targetSystem: undefined,
    params: {}
  },
  rules: {
    id: [{ required: true, message: '主键ID不能为空', trigger: 'blur' }],
    projectId: [{ required: true, message: '项目ID不能为空', trigger: 'blur' }]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询新技术项目对码列表 */
const getList = async () => {
  loading.value = true;
  const res = await listNewTechnologyProjectMapping(queryParams.value);
  newTechnologyProjectMappingList.value = res.rows;
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
  newTechnologyProjectMappingFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: NewTechnologyProjectMappingVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加新技术项目对码';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: NewTechnologyProjectMappingVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getNewTechnologyProjectMapping(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改新技术项目对码';
};

/** 提交按钮 */
const submitForm = () => {
  newTechnologyProjectMappingFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateNewTechnologyProjectMapping(form.value).finally(() => (buttonLoading.value = false));
      } else {
        await addNewTechnologyProjectMapping(form.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: NewTechnologyProjectMappingVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除新技术项目对码编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delNewTechnologyProjectMapping(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/newTechnologyProjectMapping/export',
    {
      ...queryParams.value
    },
    `newTechnologyProjectMapping_${new Date().getTime()}.xlsx`
  );
};

onMounted(() => {
  getList();
});
</script>
