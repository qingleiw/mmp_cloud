<template>
  <div class="p-2">
    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <div v-show="showSearch" class="mb-[10px]">
        <el-card shadow="hover">
          <el-form ref="queryFormRef" :model="queryParams" :inline="true">
            <el-form-item label="项目编号" prop="projectNo">
              <el-input v-model="queryParams.projectNo" placeholder="请输入项目编号" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="实施医生" prop="implementDoctor">
              <el-input v-model="queryParams.implementDoctor" placeholder="请输入实施医生" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="实施地点" prop="implementationLocation">
              <el-input v-model="queryParams.implementationLocation" placeholder="请输入实施地点" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="实施日期" prop="implementationDate">
              <el-date-picker clearable
                v-model="queryParams.implementationDate"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择实施日期"
              />
            </el-form-item>
            <el-form-item label="实施结果" prop="implementationResult">
              <el-input v-model="queryParams.implementationResult" placeholder="请输入实施结果" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="是否删除" prop="isDeleted">
              <el-input v-model="queryParams.isDeleted" placeholder="请输入是否删除" clearable @keyup.enter="handleQuery" />
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
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['ntp:newTechnologyProjectImplementation:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="success" plain icon="Edit" :disabled="single" @click="handleUpdate()" v-hasPermi="['ntp:newTechnologyProjectImplementation:edit']">修改</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="danger" plain icon="Delete" :disabled="multiple" @click="handleDelete()" v-hasPermi="['ntp:newTechnologyProjectImplementation:remove']">删除</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['ntp:newTechnologyProjectImplementation:export']">导出</el-button>
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" border :data="newTechnologyProjectImplementationList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="主键ID" align="center" prop="id" v-if="false" />
        <el-table-column label="项目编号" align="center" prop="projectNo" />
        <el-table-column label="实施状态 0-未开始 1-进行中 2-已完成 3-暂停" align="center" prop="implementationStatus" />
        <el-table-column label="实施医生" align="center" prop="implementDoctor" />
        <el-table-column label="实施地点" align="center" prop="implementationLocation" />
        <el-table-column label="实施日期" align="center" prop="implementationDate" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.implementationDate, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="实施结果" align="center" prop="implementationResult" />
        <el-table-column label="备注" align="center" prop="remark" />
        <el-table-column label="是否删除" align="center" prop="isDeleted" />
        <el-table-column label="操作" align="center" fixed="right"  class-name="small-padding fixed-width">
          <template #default="scope">
            <el-tooltip content="修改" placement="top">
              <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['ntp:newTechnologyProjectImplementation:edit']"></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)" v-hasPermi="['ntp:newTechnologyProjectImplementation:remove']"></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改新技术实施对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="newTechnologyProjectImplementationFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="项目编号" prop="projectNo">
          <el-input v-model="form.projectNo" placeholder="请输入项目编号" />
        </el-form-item>
        <el-form-item label="实施医生" prop="implementDoctor">
          <el-input v-model="form.implementDoctor" placeholder="请输入实施医生" />
        </el-form-item>
        <el-form-item label="实施地点" prop="implementationLocation">
          <el-input v-model="form.implementationLocation" placeholder="请输入实施地点" />
        </el-form-item>
        <el-form-item label="实施日期" prop="implementationDate">
          <el-date-picker clearable
            v-model="form.implementationDate"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择实施日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="实施结果" prop="implementationResult">
            <el-input v-model="form.implementationResult" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="备注" prop="remark">
            <el-input v-model="form.remark" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="是否删除" prop="isDeleted">
          <el-input v-model="form.isDeleted" placeholder="请输入是否删除" />
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

<script setup name="NewTechnologyProjectImplementation" lang="ts">
import { listNewTechnologyProjectImplementation, getNewTechnologyProjectImplementation, delNewTechnologyProjectImplementation, addNewTechnologyProjectImplementation, updateNewTechnologyProjectImplementation } from '@/api/ntp/newTechnologyProjectImplementation';
import { NewTechnologyProjectImplementationVO, NewTechnologyProjectImplementationQuery, NewTechnologyProjectImplementationForm } from '@/api/ntp/newTechnologyProjectImplementation/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const newTechnologyProjectImplementationList = ref<NewTechnologyProjectImplementationVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const newTechnologyProjectImplementationFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: NewTechnologyProjectImplementationForm = {
  id: undefined,
  projectNo: undefined,
  implementationStatus: undefined,
  implementDoctor: undefined,
  implementationLocation: undefined,
  implementationDate: undefined,
  implementationResult: undefined,
  remark: undefined,
  isDeleted: undefined,
}
const data = reactive<PageData<NewTechnologyProjectImplementationForm, NewTechnologyProjectImplementationQuery>>({
  form: {...initFormData},
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    projectNo: undefined,
    implementationStatus: undefined,
    implementDoctor: undefined,
    implementationLocation: undefined,
    implementationDate: undefined,
    implementationResult: undefined,
    isDeleted: undefined,
    params: {
    }
  },
  rules: {
    id: [
      { required: true, message: "主键ID不能为空", trigger: "blur" }
    ],
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询新技术实施列表 */
const getList = async () => {
  loading.value = true;
  const res = await listNewTechnologyProjectImplementation(queryParams.value);
  newTechnologyProjectImplementationList.value = res.rows;
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
  newTechnologyProjectImplementationFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: NewTechnologyProjectImplementationVO[]) => {
  ids.value = selection.map(item => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
}

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = "添加新技术实施";
}

/** 修改按钮操作 */
const handleUpdate = async (row?: NewTechnologyProjectImplementationVO) => {
  reset();
  const _id = row?.id || ids.value[0]
  const res = await getNewTechnologyProjectImplementation(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = "修改新技术实施";
}

/** 提交按钮 */
const submitForm = () => {
  newTechnologyProjectImplementationFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateNewTechnologyProjectImplementation(form.value).finally(() =>  buttonLoading.value = false);
      } else {
        await addNewTechnologyProjectImplementation(form.value).finally(() =>  buttonLoading.value = false);
      }
      proxy?.$modal.msgSuccess("操作成功");
      dialog.visible = false;
      await getList();
    }
  });
}

/** 删除按钮操作 */
const handleDelete = async (row?: NewTechnologyProjectImplementationVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除新技术实施编号为"' + _ids + '"的数据项？').finally(() => loading.value = false);
  await delNewTechnologyProjectImplementation(_ids);
  proxy?.$modal.msgSuccess("删除成功");
  await getList();
}

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download('system/newTechnologyProjectImplementation/export', {
    ...queryParams.value
  }, `newTechnologyProjectImplementation_${new Date().getTime()}.xlsx`)
}

onMounted(() => {
  getList();
});
</script>
