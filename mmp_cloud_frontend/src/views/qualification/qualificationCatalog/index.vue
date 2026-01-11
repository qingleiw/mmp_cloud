<template>
  <div class="p-2">
    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <div v-show="showSearch" class="mb-[10px]">
        <el-card shadow="hover">
          <el-form ref="queryFormRef" :model="queryParams" :inline="true">
            <el-form-item label="医生姓名" prop="doctorName">
              <el-input v-model="queryParams.doctorName" placeholder="请输入医生姓名" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="科室" prop="department">
              <el-input v-model="queryParams.department" placeholder="请输入科室" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="职务" prop="position">
              <el-input v-model="queryParams.position" placeholder="请输入职务" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="职称" prop="title">
              <el-input v-model="queryParams.title" placeholder="请输入职称" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="所授权手术级别" prop="authorizedLevel">
              <el-input v-model="queryParams.authorizedLevel" placeholder="请输入所授权手术级别" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="一级手术授权" prop="level1">
              <el-input v-model="queryParams.level1" placeholder="请输入一级手术授权" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="二级手术授权" prop="level2">
              <el-input v-model="queryParams.level2" placeholder="请输入二级手术授权" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="三级手术授权" prop="level3">
              <el-input v-model="queryParams.level3" placeholder="请输入三级手术授权" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="四级手术授权" prop="level4">
              <el-input v-model="queryParams.level4" placeholder="请输入四级手术授权" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="手术名称" prop="surgeryName">
              <el-input v-model="queryParams.surgeryName" placeholder="请输入手术名称" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="手术代码" prop="surgeryCode">
              <el-input v-model="queryParams.surgeryCode" placeholder="请输入手术代码" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="手术级别" prop="surgeryLevel">
              <el-input v-model="queryParams.surgeryLevel" placeholder="请输入手术级别" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="有效期开始" prop="validStartDate">
              <el-date-picker clearable v-model="queryParams.validStartDate" type="date" value-format="YYYY-MM-DD" placeholder="请选择有效期开始" />
            </el-form-item>
            <el-form-item label="有效期结束" prop="validEndDate">
              <el-date-picker clearable v-model="queryParams.validEndDate" type="date" value-format="YYYY-MM-DD" placeholder="请选择有效期结束" />
            </el-form-item>
            <el-form-item label="数据来源" prop="dataSource">
              <el-input v-model="queryParams.dataSource" placeholder="请输入数据来源" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="是否删除" prop="delFlag">
              <el-input v-model="queryParams.delFlag" placeholder="请输入是否删除" clearable @keyup.enter="handleQuery" />
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
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['system:qualificationCatalog:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="success" plain icon="Edit" :disabled="single" @click="handleUpdate()" v-hasPermi="['system:qualificationCatalog:edit']"
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
              v-hasPermi="['system:qualificationCatalog:remove']"
              >删除</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['system:qualificationCatalog:export']">导出</el-button>
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" border :data="qualificationCatalogList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="主键ID" align="center" prop="id" v-if="false" />
        <el-table-column label="医生姓名" align="center" prop="doctorName" />
        <el-table-column label="科室" align="center" prop="department" />
        <el-table-column label="职务" align="center" prop="position" />
        <el-table-column label="职称" align="center" prop="title" />
        <el-table-column label="所授权手术级别" align="center" prop="authorizedLevel" />
        <el-table-column label="一级手术授权" align="center" prop="level1" />
        <el-table-column label="二级手术授权" align="center" prop="level2" />
        <el-table-column label="三级手术授权" align="center" prop="level3" />
        <el-table-column label="四级手术授权" align="center" prop="level4" />
        <el-table-column label="手术名称" align="center" prop="surgeryName" />
        <el-table-column label="手术代码" align="center" prop="surgeryCode" />
        <el-table-column label="手术级别" align="center" prop="surgeryLevel" />
        <el-table-column label="资质类型" align="center" prop="qualificationType" />
        <el-table-column label="有效期开始" align="center" prop="validStartDate" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.validStartDate, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="有效期结束" align="center" prop="validEndDate" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.validEndDate, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="状态" align="center" prop="status" />
        <el-table-column label="数据来源" align="center" prop="dataSource" />
        <el-table-column label="是否删除" align="center" prop="delFlag" />
        <el-table-column label="操作" align="center" fixed="right" class-name="small-padding fixed-width">
          <template #default="scope">
            <el-tooltip content="修改" placement="top">
              <el-button
                link
                type="primary"
                icon="Edit"
                @click="handleUpdate(scope.row)"
                v-hasPermi="['system:qualificationCatalog:edit']"
              ></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button
                link
                type="primary"
                icon="Delete"
                @click="handleDelete(scope.row)"
                v-hasPermi="['system:qualificationCatalog:remove']"
              ></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改医生手术授权目录对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="qualificationCatalogFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="医生ID" prop="doctorId">
          <el-input v-model="form.doctorId" placeholder="请输入医生ID" />
        </el-form-item>
        <el-form-item label="医生姓名" prop="doctorName">
          <el-input v-model="form.doctorName" placeholder="请输入医生姓名" />
        </el-form-item>
        <el-form-item label="科室" prop="department">
          <el-input v-model="form.department" placeholder="请输入科室" />
        </el-form-item>
        <el-form-item label="职务" prop="position">
          <el-input v-model="form.position" placeholder="请输入职务" />
        </el-form-item>
        <el-form-item label="职称" prop="title">
          <el-input v-model="form.title" placeholder="请输入职称" />
        </el-form-item>
        <el-form-item label="所授权手术级别" prop="authorizedLevel">
          <el-input v-model="form.authorizedLevel" placeholder="请输入所授权手术级别" />
        </el-form-item>
        <el-form-item label="一级手术授权" prop="level1">
          <el-input v-model="form.level1" placeholder="请输入一级手术授权" />
        </el-form-item>
        <el-form-item label="二级手术授权" prop="level2">
          <el-input v-model="form.level2" placeholder="请输入二级手术授权" />
        </el-form-item>
        <el-form-item label="三级手术授权" prop="level3">
          <el-input v-model="form.level3" placeholder="请输入三级手术授权" />
        </el-form-item>
        <el-form-item label="四级手术授权" prop="level4">
          <el-input v-model="form.level4" placeholder="请输入四级手术授权" />
        </el-form-item>
        <el-form-item label="手术名称" prop="surgeryName">
          <el-input v-model="form.surgeryName" placeholder="请输入手术名称" />
        </el-form-item>
        <el-form-item label="手术代码" prop="surgeryCode">
          <el-input v-model="form.surgeryCode" placeholder="请输入手术代码" />
        </el-form-item>
        <el-form-item label="手术级别" prop="surgeryLevel">
          <el-input v-model="form.surgeryLevel" placeholder="请输入手术级别" />
        </el-form-item>
        <el-form-item label="有效期开始" prop="validStartDate">
          <el-date-picker clearable v-model="form.validStartDate" type="datetime" value-format="YYYY-MM-DD HH:mm:ss" placeholder="请选择有效期开始">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="有效期结束" prop="validEndDate">
          <el-date-picker clearable v-model="form.validEndDate" type="datetime" value-format="YYYY-MM-DD HH:mm:ss" placeholder="请选择有效期结束">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="数据来源" prop="dataSource">
          <el-input v-model="form.dataSource" placeholder="请输入数据来源" />
        </el-form-item>
        <el-form-item label="是否删除" prop="delFlag">
          <el-input v-model="form.delFlag" placeholder="请输入是否删除" />
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

<script setup name="QualificationCatalog" lang="ts">
import {
  listQualificationCatalog,
  getQualificationCatalog,
  delQualificationCatalog,
  addQualificationCatalog,
  updateQualificationCatalog
} from '@/api/system/qualificationCatalog';
import { QualificationCatalogVO, QualificationCatalogQuery, QualificationCatalogForm } from '@/api/system/qualificationCatalog/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const qualificationCatalogList = ref<QualificationCatalogVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const qualificationCatalogFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: QualificationCatalogForm = {
  id: undefined,
  doctorId: undefined,
  doctorName: undefined,
  department: undefined,
  position: undefined,
  title: undefined,
  authorizedLevel: undefined,
  level1: undefined,
  level2: undefined,
  level3: undefined,
  level4: undefined,
  surgeryName: undefined,
  surgeryCode: undefined,
  surgeryLevel: undefined,
  qualificationType: undefined,
  validStartDate: undefined,
  validEndDate: undefined,
  status: undefined,
  dataSource: undefined,
  delFlag: undefined
};
const data = reactive<PageData<QualificationCatalogForm, QualificationCatalogQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    doctorName: undefined,
    department: undefined,
    position: undefined,
    title: undefined,
    authorizedLevel: undefined,
    level1: undefined,
    level2: undefined,
    level3: undefined,
    level4: undefined,
    surgeryName: undefined,
    surgeryCode: undefined,
    surgeryLevel: undefined,
    qualificationType: undefined,
    validStartDate: undefined,
    validEndDate: undefined,
    status: undefined,
    dataSource: undefined,
    delFlag: undefined,
    params: {}
  },
  rules: {
    id: [{ required: true, message: '主键ID不能为空', trigger: 'blur' }],
    doctorId: [{ required: true, message: '医生ID不能为空', trigger: 'blur' }],
    doctorName: [{ required: true, message: '医生姓名不能为空', trigger: 'blur' }]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询医生手术授权目录列表 */
const getList = async () => {
  loading.value = true;
  const res = await listQualificationCatalog(queryParams.value);
  qualificationCatalogList.value = res.rows;
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
  qualificationCatalogFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: QualificationCatalogVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加医生手术授权目录';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: QualificationCatalogVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getQualificationCatalog(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改医生手术授权目录';
};

/** 提交按钮 */
const submitForm = () => {
  qualificationCatalogFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateQualificationCatalog(form.value).finally(() => (buttonLoading.value = false));
      } else {
        await addQualificationCatalog(form.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: QualificationCatalogVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除医生手术授权目录编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delQualificationCatalog(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/qualificationCatalog/export',
    {
      ...queryParams.value
    },
    `qualificationCatalog_${new Date().getTime()}.xlsx`
  );
};

onMounted(() => {
  getList();
});
</script>
