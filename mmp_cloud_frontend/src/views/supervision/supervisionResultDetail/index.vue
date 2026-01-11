<template>
  <div class="p-2">
    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <div v-show="showSearch" class="mb-[10px]">
        <el-card shadow="hover">
          <el-form ref="queryFormRef" :model="queryParams" :inline="true">
            <el-form-item label="得分" prop="score">
              <el-input v-model="queryParams.score" placeholder="请输入得分" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="备注" prop="remarks">
              <el-input v-model="queryParams.remarks" placeholder="请输入备注" clearable @keyup.enter="handleQuery" />
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
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['system:supervisionResultDetail:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button
              type="success"
              plain
              icon="Edit"
              :disabled="single"
              @click="handleUpdate()"
              v-hasPermi="['system:supervisionResultDetail:edit']"
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
              v-hasPermi="['system:supervisionResultDetail:remove']"
              >删除</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['system:supervisionResultDetail:export']"
              >导出</el-button
            >
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" border :data="supervisionResultDetailList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="主键ID" align="center" prop="id" v-if="false" />
        <el-table-column label="得分" align="center" prop="score" />
        <el-table-column label="备注" align="center" prop="remarks" />
        <el-table-column label="备注" align="center" prop="remark" />
        <el-table-column label="操作" align="center" fixed="right" class-name="small-padding fixed-width">
          <template #default="scope">
            <el-tooltip content="修改" placement="top">
              <el-button
                link
                type="primary"
                icon="Edit"
                @click="handleUpdate(scope.row)"
                v-hasPermi="['system:supervisionResultDetail:edit']"
              ></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button
                link
                type="primary"
                icon="Delete"
                @click="handleDelete(scope.row)"
                v-hasPermi="['system:supervisionResultDetail:remove']"
              ></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改督查结果明细对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="supervisionResultDetailFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="结果ID" prop="resultId">
          <el-input v-model="form.resultId" placeholder="请输入结果ID" />
        </el-form-item>
        <el-form-item label="指标ID" prop="indicatorId">
          <el-input v-model="form.indicatorId" placeholder="请输入指标ID" />
        </el-form-item>
        <el-form-item label="得分" prop="score">
          <el-input v-model="form.score" placeholder="请输入得分" />
        </el-form-item>
        <el-form-item label="备注" prop="remarks">
          <el-input v-model="form.remarks" type="textarea" placeholder="请输入内容" />
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

<script setup name="SupervisionResultDetail" lang="ts">
import {
  listSupervisionResultDetail,
  getSupervisionResultDetail,
  delSupervisionResultDetail,
  addSupervisionResultDetail,
  updateSupervisionResultDetail
} from '@/api/supervision/supervisionResultDetail';
import { SupervisionResultDetailVO, SupervisionResultDetailQuery, SupervisionResultDetailForm } from '@/api/supervision/supervisionResultDetail/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const supervisionResultDetailList = ref<SupervisionResultDetailVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const supervisionResultDetailFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: SupervisionResultDetailForm = {
  id: undefined,
  resultId: undefined,
  indicatorId: undefined,
  score: undefined,
  remarks: undefined,
  remark: undefined
};
const data = reactive<PageData<SupervisionResultDetailForm, SupervisionResultDetailQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    score: undefined,
    remarks: undefined,
    params: {}
  },
  rules: {
    id: [{ required: true, message: '主键ID不能为空', trigger: 'blur' }],
    resultId: [{ required: true, message: '结果ID不能为空', trigger: 'blur' }],
    indicatorId: [{ required: true, message: '指标ID不能为空', trigger: 'blur' }]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询督查结果明细列表 */
const getList = async () => {
  loading.value = true;
  const res = await listSupervisionResultDetail(queryParams.value);
  supervisionResultDetailList.value = res.rows;
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
  supervisionResultDetailFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: SupervisionResultDetailVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加督查结果明细';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: SupervisionResultDetailVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getSupervisionResultDetail(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改督查结果明细';
};

/** 提交按钮 */
const submitForm = () => {
  supervisionResultDetailFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateSupervisionResultDetail(form.value).finally(() => (buttonLoading.value = false));
      } else {
        await addSupervisionResultDetail(form.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: SupervisionResultDetailVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除督查结果明细编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delSupervisionResultDetail(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/supervisionResultDetail/export',
    {
      ...queryParams.value
    },
    `supervisionResultDetail_${new Date().getTime()}.xlsx`
  );
};

onMounted(() => {
  getList();
});
</script>
