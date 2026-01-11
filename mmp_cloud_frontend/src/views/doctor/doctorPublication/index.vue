<template>
  <div class="p-2">
    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <div v-show="showSearch" class="mb-[10px]">
        <el-card shadow="hover">
          <DynamicSearchForm
            ref="queryFormRef"
            :query="queryParams"
            :visible-fields="visibleSearchFields"
            @search="handleQuery"
            @reset="resetQuery"
          />
          <!--
          <el-form ref="queryFormRef" :model="queryParams" :inline="true">
            <el-form-item label="医生ID" prop="doctorId">
              <el-input v-model="queryParams.doctorId" placeholder="请输入医生ID" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="标题" prop="title">
              <el-input v-model="queryParams.title" placeholder="请输入标题" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="作者" prop="authors">
              <el-input v-model="queryParams.authors" placeholder="请输入作者" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="作者排序" prop="authorOrder">
              <el-input v-model="queryParams.authorOrder" placeholder="请输入作者排序" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="期刊名称/出版社" prop="journalName">
              <el-input v-model="queryParams.journalName" placeholder="请输入期刊名称/出版社" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="发表日期" prop="publishDate">
              <el-date-picker clearable v-model="queryParams.publishDate" type="date" value-format="YYYY-MM-DD" placeholder="请选择发表日期" />
            </el-form-item>
            <el-form-item label="卷号" prop="volume">
              <el-input v-model="queryParams.volume" placeholder="请输入卷号" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="期号" prop="issue">
              <el-input v-model="queryParams.issue" placeholder="请输入期号" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="页码" prop="pages">
              <el-input v-model="queryParams.pages" placeholder="请输入页码" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="DOI" prop="doi">
              <el-input v-model="queryParams.doi" placeholder="请输入DOI" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="影响因子" prop="impactFactor">
              <el-input v-model="queryParams.impactFactor" placeholder="请输入影响因子" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="引用次数" prop="citationCount">
              <el-input v-model="queryParams.citationCount" placeholder="请输入引用次数" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="全文URL" prop="fullTextUrl">
              <el-input v-model="queryParams.fullTextUrl" placeholder="请输入全文URL" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="是否删除" prop="delFlag">
              <el-input v-model="queryParams.delFlag" placeholder="请输入是否删除" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item>
              <el-button type="primary" icon="Search" @click="handleQuery">搜索</el-button>
              <el-button icon="Refresh" @click="resetQuery">重置</el-button>
            </el-form-item>
          </el-form>
          -->
        </el-card>
      </div>
    </transition>

    <el-card shadow="never">
      <template #header>
        <el-row :gutter="10" class="mb8">
          <el-col :span="1.5">
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['system:doctorPublication:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="success" plain icon="Edit" :disabled="single" @click="handleUpdate()" v-hasPermi="['system:doctorPublication:edit']"
              >修改</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button type="danger" plain icon="Delete" :disabled="multiple" @click="handleDelete()" v-hasPermi="['system:doctorPublication:remove']"
              >删除</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['system:doctorPublication:export']">导出</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="info" plain icon="Setting" @click="showFieldConfig = true">字段配置</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="info" plain icon="Setting" @click="handleSearchConfig">搜索项配置</el-button>
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" border :data="doctorPublicationList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column
          v-for="field in visibleColumns"
          :key="field.prop"
          :label="field.label"
          align="center"
          :prop="field.prop"
          :width="field.width || undefined"
        >
          <template #default="scope">
            <span v-if="field.prop === 'publishDate' || field.prop === 'createTime' || field.prop === 'updateTime'">
              {{ parseTime(scope.row[field.prop], '{y}-{m}-{d} {h}:{i}:{s}') }}
            </span>
            <template v-else-if="field.prop === 'delFlag'">
              <el-tag :type="scope.row[field.prop] === 0 ? 'success' : 'danger'">
                {{ scope.row[field.prop] === 0 ? '否' : '是' }}
              </el-tag>
            </template>
            <span v-else>
              {{ scope.row[field.prop] }}
            </span>
          </template>
        </el-table-column>
        <el-table-column label="操作" align="center" fixed="right" class-name="small-padding fixed-width">
          <template #default="scope">
            <el-tooltip content="修改" placement="top">
              <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['system:doctorPublication:edit']"></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button
                link
                type="primary"
                icon="Delete"
                @click="handleDelete(scope.row)"
                v-hasPermi="['system:doctorPublication:remove']"
              ></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改论文论著对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="700px" append-to-body>
      <el-form ref="doctorPublicationFormRef" :model="form" :rules="rules" label-width="120px">
        <el-row :gutter="20">
          <el-col v-for="field in visibleColumns" :key="field.prop" :span="field.formSpan || 24">
            <el-form-item :label="field.label" :prop="field.prop" v-if="field.prop !== 'createTime' && field.prop !== 'updateTime'">
              <el-input v-if="field.type === 'input' || !field.type" v-model="form[field.prop]" :placeholder="`请输入${field.label}`" />
              <el-input
                v-else-if="field.type === 'textarea'"
                v-model="form[field.prop]"
                type="textarea"
                :placeholder="`请输入${field.label}`"
                :rows="3"
              />
              <el-input-number
                v-else-if="field.type === 'number'"
                v-model="form[field.prop]"
                :min="0"
                :precision="2"
                :placeholder="`请输入${field.label}`"
                style="width: 100%"
              />
              <el-date-picker
                v-else-if="field.type === 'datetime'"
                clearable
                v-model="form[field.prop]"
                type="datetime"
                value-format="YYYY-MM-DD HH:mm:ss"
                :placeholder="`请选择${field.label}`"
                style="width: 100%"
              />
              <el-date-picker
                v-else-if="field.type === 'date'"
                clearable
                v-model="form[field.prop]"
                type="date"
                value-format="YYYY-MM-DD"
                :placeholder="`请选择${field.label}`"
                style="width: 100%"
              />
              <el-select v-else-if="field.type === 'select'" v-model="form[field.prop]" :placeholder="`请选择${field.label}`" style="width: 100%">
                <el-option v-for="option in field.options" :key="option.value" :label="option.label" :value="option.value" />
              </el-select>
              <el-switch v-else-if="field.type === 'switch'" v-model="form[field.prop]" active-text="是" inactive-text="否" />
              <span v-else>{{ form[field.prop] }}</span>
            </el-form-item>
          </el-col>
        </el-row>
      </el-form>
      <template #footer>
        <div class="dialog-footer">
          <el-button :loading="buttonLoading" type="primary" @click="submitForm">确 定</el-button>
          <el-button @click="cancel">取 消</el-button>
        </div>
      </template>
    </el-dialog>

    <!-- 字段配置对话框 -->
    <FieldConfigDialog v-model:visible="showFieldConfig" :field-config-manager="fieldConfigManager" @confirm="handleFieldConfigConfirm" />
    <SearchConfigDialog v-model="searchConfigVisible" :search-config-manager="searchConfigManager" @confirm="handleSearchConfigConfirm" />
  </div>
</template>

<script setup name="DoctorPublication" lang="ts">
import {
  listDoctorPublication,
  getDoctorPublication,
  delDoctorPublication,
  addDoctorPublication,
  updateDoctorPublication
} from '@/api/doctor/doctorPublication';
import { DoctorPublicationVO, DoctorPublicationQuery, DoctorPublicationForm } from '@/api/doctor/doctorPublication/types';
import { createDoctorPublicationFieldConfig } from '@/utils/mmpFieldConfigs';
import FieldConfigDialog from '@/components/FieldConfigDialog.vue';
import DynamicSearchForm from '@/components/DynamicSearchForm.vue';
import SearchConfigDialog from '@/components/SearchConfigDialog.vue';
import { createDoctorPublicationSearchConfig } from '@/utils/mmpSearchConfigs';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const doctorPublicationList = ref<DoctorPublicationVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const showFieldConfig = ref(false);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const doctorPublicationFormRef = ref<ElFormInstance>();

// 字段配置相关变量
const fieldConfigManager = createDoctorPublicationFieldConfig();
const visibleColumns = computed(() => fieldConfigManager.getVisibleFields());
const searchConfigManager = createDoctorPublicationSearchConfig();
const searchConfigVisible = ref(false);
const visibleSearchFields = computed(() => searchConfigManager.getVisibleFields());

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: DoctorPublicationForm = {
  id: undefined,
  doctorId: undefined,
  publicationType: undefined,
  title: undefined,
  authors: undefined,
  authorOrder: undefined,
  journalName: undefined,
  publishDate: undefined,
  volume: undefined,
  issue: undefined,
  pages: undefined,
  doi: undefined,
  impactFactor: undefined,
  citationCount: undefined,
  fullTextUrl: undefined,
  delFlag: undefined
};
const data = reactive<PageData<DoctorPublicationForm, DoctorPublicationQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    doctorId: undefined,
    publicationType: undefined,
    title: undefined,
    authors: undefined,
    authorOrder: undefined,
    journalName: undefined,
    publishDate: undefined,
    volume: undefined,
    issue: undefined,
    pages: undefined,
    doi: undefined,
    impactFactor: undefined,
    citationCount: undefined,
    fullTextUrl: undefined,
    delFlag: undefined,
    params: {}
  },
  rules: {
    id: [{ required: true, message: '主键ID不能为空', trigger: 'blur' }],
    doctorId: [{ required: true, message: '医生ID不能为空', trigger: 'blur' }]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询论文论著列表 */
const getList = async () => {
  loading.value = true;
  const res = await listDoctorPublication(queryParams.value);
  doctorPublicationList.value = res.rows;
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
  doctorPublicationFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: DoctorPublicationVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加论文论著';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: DoctorPublicationVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getDoctorPublication(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改论文论著';
};

/** 提交按钮 */
const submitForm = () => {
  doctorPublicationFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateDoctorPublication(form.value).finally(() => (buttonLoading.value = false));
      } else {
        await addDoctorPublication(form.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: DoctorPublicationVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除论文论著编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delDoctorPublication(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/doctorPublication/export',
    {
      ...queryParams.value
    },
    `doctorPublication_${new Date().getTime()}.xlsx`
  );
};

/** 字段配置确认 */
const handleFieldConfigConfirm = () => {
  // 字段配置更新后刷新列表
  getList();
};

const handleSearchConfig = () => {
  searchConfigVisible.value = true;
};
const handleSearchConfigConfirm = () => {
  searchConfigVisible.value = false;
};

onMounted(() => {
  getList();
});
</script>
