<template>
  <div class="p-2">
    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <div v-show="showSearch" class="mb-[10px]">
        <el-card shadow="hover">
          <el-form ref="queryFormRef" :model="queryParams" :inline="true">
            <el-form-item label="文档名称" prop="documentName">
              <el-input v-model="queryParams.documentName" placeholder="请输入文档名称" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="文件路径" prop="filePath">
              <el-input v-model="queryParams.filePath" placeholder="请输入文件路径" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="文件名" prop="fileName">
              <el-input v-model="queryParams.fileName" placeholder="请输入文件名" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="文件大小" prop="fileSize">
              <el-input v-model="queryParams.fileSize" placeholder="请输入文件大小" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="上传人" prop="uploadBy">
              <el-input v-model="queryParams.uploadBy" placeholder="请输入上传人" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="上传时间" prop="uploadTime">
              <el-date-picker clearable
                v-model="queryParams.uploadTime"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择上传时间"
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
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['ntp:newTechnologyProjectDocument:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="success" plain icon="Edit" :disabled="single" @click="handleUpdate()" v-hasPermi="['ntp:newTechnologyProjectDocument:edit']">修改</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="danger" plain icon="Delete" :disabled="multiple" @click="handleDelete()" v-hasPermi="['ntp:newTechnologyProjectDocument:remove']">删除</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['ntp:newTechnologyProjectDocument:export']">导出</el-button>
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" border :data="newTechnologyProjectDocumentList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="主键ID" align="center" prop="id" v-if="false" />
        <el-table-column label="文档类型：application-申报书，approval-批复文件，progress-进展报告，final-结题报告" align="center" prop="documentType" />
        <el-table-column label="文档名称" align="center" prop="documentName" />
        <el-table-column label="文件路径" align="center" prop="filePath" />
        <el-table-column label="文件名" align="center" prop="fileName" />
        <el-table-column label="文件大小" align="center" prop="fileSize" />
        <el-table-column label="上传人" align="center" prop="uploadBy" />
        <el-table-column label="上传时间" align="center" prop="uploadTime" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.uploadTime, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="状态" align="center" prop="status" />
        <el-table-column label="备注" align="center" prop="remark" />
        <el-table-column label="操作" align="center" fixed="right"  class-name="small-padding fixed-width">
          <template #default="scope">
            <el-tooltip content="修改" placement="top">
              <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['ntp:newTechnologyProjectDocument:edit']"></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)" v-hasPermi="['ntp:newTechnologyProjectDocument:remove']"></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改项目文档对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="newTechnologyProjectDocumentFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="项目ID" prop="projectId">
          <el-input v-model="form.projectId" placeholder="请输入项目ID" />
        </el-form-item>
        <el-form-item label="文档名称" prop="documentName">
          <el-input v-model="form.documentName" placeholder="请输入文档名称" />
        </el-form-item>
        <el-form-item label="文件路径" prop="filePath">
            <el-input v-model="form.filePath" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="文件名" prop="fileName">
          <el-input v-model="form.fileName" placeholder="请输入文件名" />
        </el-form-item>
        <el-form-item label="文件大小" prop="fileSize">
          <el-input v-model="form.fileSize" placeholder="请输入文件大小" />
        </el-form-item>
        <el-form-item label="上传人" prop="uploadBy">
          <el-input v-model="form.uploadBy" placeholder="请输入上传人" />
        </el-form-item>
        <el-form-item label="上传时间" prop="uploadTime">
          <el-date-picker clearable
            v-model="form.uploadTime"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择上传时间">
          </el-date-picker>
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

<script setup name="NewTechnologyProjectDocument" lang="ts">
import { listNewTechnologyProjectDocument, getNewTechnologyProjectDocument, delNewTechnologyProjectDocument, addNewTechnologyProjectDocument, updateNewTechnologyProjectDocument } from '@/api/ntp/newTechnologyProjectDocument';
import { NewTechnologyProjectDocumentVO, NewTechnologyProjectDocumentQuery, NewTechnologyProjectDocumentForm } from '@/api/ntp/newTechnologyProjectDocument/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const newTechnologyProjectDocumentList = ref<NewTechnologyProjectDocumentVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const newTechnologyProjectDocumentFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: NewTechnologyProjectDocumentForm = {
  id: undefined,
  projectId: undefined,
  documentType: undefined,
  documentName: undefined,
  filePath: undefined,
  fileName: undefined,
  fileSize: undefined,
  uploadBy: undefined,
  uploadTime: undefined,
  status: undefined,
  remark: undefined
}
const data = reactive<PageData<NewTechnologyProjectDocumentForm, NewTechnologyProjectDocumentQuery>>({
  form: {...initFormData},
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    documentType: undefined,
    documentName: undefined,
    filePath: undefined,
    fileName: undefined,
    fileSize: undefined,
    uploadBy: undefined,
    uploadTime: undefined,
    status: undefined,
    params: {
    }
  },
  rules: {
    id: [
      { required: true, message: "主键ID不能为空", trigger: "blur" }
    ],
    projectId: [
      { required: true, message: "项目ID不能为空", trigger: "blur" }
    ],
    documentName: [
      { required: true, message: "文档名称不能为空", trigger: "blur" }
    ],
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询项目文档列表 */
const getList = async () => {
  loading.value = true;
  const res = await listNewTechnologyProjectDocument(queryParams.value);
  newTechnologyProjectDocumentList.value = res.rows;
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
  newTechnologyProjectDocumentFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: NewTechnologyProjectDocumentVO[]) => {
  ids.value = selection.map(item => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
}

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = "添加项目文档";
}

/** 修改按钮操作 */
const handleUpdate = async (row?: NewTechnologyProjectDocumentVO) => {
  reset();
  const _id = row?.id || ids.value[0]
  const res = await getNewTechnologyProjectDocument(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = "修改项目文档";
}

/** 提交按钮 */
const submitForm = () => {
  newTechnologyProjectDocumentFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateNewTechnologyProjectDocument(form.value).finally(() =>  buttonLoading.value = false);
      } else {
        await addNewTechnologyProjectDocument(form.value).finally(() =>  buttonLoading.value = false);
      }
      proxy?.$modal.msgSuccess("操作成功");
      dialog.visible = false;
      await getList();
    }
  });
}

/** 删除按钮操作 */
const handleDelete = async (row?: NewTechnologyProjectDocumentVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除项目文档编号为"' + _ids + '"的数据项？').finally(() => loading.value = false);
  await delNewTechnologyProjectDocument(_ids);
  proxy?.$modal.msgSuccess("删除成功");
  await getList();
}

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download('system/newTechnologyProjectDocument/export', {
    ...queryParams.value
  }, `newTechnologyProjectDocument_${new Date().getTime()}.xlsx`)
}

onMounted(() => {
  getList();
});
</script>
