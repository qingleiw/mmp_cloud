<template>
  <div class="app-container">
    <!-- 页面标题 -->
    <div class="page-header mb-4">
      <h2 class="page-title">
        <i-ep-document class="title-icon"></i-ep-document>
        肿瘤质控报告管理
      </h2>
      <p class="page-description">管理系统肿瘤质控报告，包括报告生成、发布和归档等功能</p>
    </div>

    <!-- 动态搜索表单 -->
    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <div v-show="showSearch" class="search-container mb-4">
        <el-card shadow="hover" class="search-card">
          <template #header>
            <div class="search-header">
              <span class="search-title">
                <i-ep-search class="search-icon"></i-ep-search>
                搜索条件
              </span>
              <div class="search-actions">
                <el-button text type="primary" @click="handleSearchConfig" class="config-btn">
                  <i-ep-setting class="btn-icon"></i-ep-setting>
                  搜索配置
                </el-button>
              </div>
            </div>
          </template>
          <DynamicSearchForm
            ref="queryFormRef"
            :query="queryParams"
            :visible-fields="visibleSearchFields"
            @search="handleQuery"
            @reset="resetQuery"
          />
        </el-card>
      </div>
    </transition>

    <!-- 数据表格 -->
    <el-card shadow="never" class="table-card">
      <template #header>
        <div class="table-header">
          <div class="table-title">
            <i-ep-list class="table-icon"></i-ep-list>
            <span>质控报告列表</span>
            <el-tag type="info" size="small" class="ml-2">{{ total }} 条记录</el-tag>
          </div>
          <div class="table-actions">
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['system:tumorQcReport:add']" size="small">新增</el-button>
            <el-button
              type="success"
              plain
              icon="Edit"
              :disabled="single"
              @click="handleUpdate()"
              v-hasPermi="['system:tumorQcReport:edit']"
              size="small"
              >修改</el-button
            >
            <el-button
              type="danger"
              plain
              icon="Delete"
              :disabled="multiple"
              @click="handleDelete()"
              v-hasPermi="['system:tumorQcReport:remove']"
              size="small"
              >删除</el-button
            >
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['system:tumorQcReport:export']" size="small"
              >导出</el-button
            >
            <el-button type="info" plain icon="Upload" @click="handleImport" v-hasPermi="['system:tumorQcReport:import']" size="small"
              >导入</el-button
            >
            <el-button text type="primary" @click="showFieldConfig = true" class="config-btn">
              <i-ep-setting class="btn-icon"></i-ep-setting>
              字段配置
            </el-button>
            <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
          </div>
        </div>
      </template>

      <el-table v-loading="loading" border :data="tumorQcReportList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column
          v-for="field in visibleColumns"
          :key="field.prop"
          :label="field.label"
          :prop="field.prop"
          :width="field.width"
          :min-width="field.minWidth || 120"
          resizable
          align="center"
        >
          <template #default="scope">
            <span v-if="field.prop === 'periodStart' || field.prop === 'periodEnd' || field.prop === 'publishTime'">{{
              parseTime(scope.row[field.prop], '{y}-{m}-{d}')
            }}</span>
            <el-tag v-else-if="field.prop === 'status'" :type="getStatusTagType(scope.row[field.prop])">
              {{ getStatusText(scope.row[field.prop]) }}
            </el-tag>
            <el-tag v-else-if="field.prop === 'delFlag'" :type="scope.row[field.prop] === '0' ? 'success' : 'danger'">
              {{ scope.row[field.prop] === '0' ? '正常' : '已删除' }}
            </el-tag>
            <span v-else>{{ scope.row[field.prop] }}</span>
          </template>
        </el-table-column>
        <el-table-column label="操作" align="center" fixed="right" class-name="small-padding fixed-width">
          <template #default="scope">
            <el-tooltip content="修改" placement="top">
              <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['system:tumorQcReport:edit']"></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)" v-hasPermi="['system:tumorQcReport:remove']"></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改肿瘤质控报告对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="800px" append-to-body>
      <el-form ref="tumorQcReportFormRef" :model="form" :rules="rules" label-width="120px">
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="报告编码" prop="reportCode">
              <el-input v-model="form.reportCode" placeholder="请输入报告编码" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="报告标题" prop="reportTitle">
              <el-input v-model="form.reportTitle" placeholder="请输入报告标题" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="报告类型" prop="reportType">
              <el-select v-model="form.reportType" placeholder="请选择报告类型" filterable clearable style="width: 100%">
                <el-option label="月度报告" value="月度报告" />
                <el-option label="季度报告" value="季度报告" />
                <el-option label="年度报告" value="年度报告" />
                <el-option label="专项报告" value="专项报告" />
                <el-option label="其他" value="其他" />
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="关联方案ID" prop="planId">
              <el-input-number
                :model-value="Number(form.planId) || undefined"
                @update:model-value="form.planId = $event"
                placeholder="请输入关联方案ID"
                style="width: 100%"
              />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="报告周期开始" prop="periodStart">
              <el-date-picker
                clearable
                v-model="form.periodStart"
                type="datetime"
                value-format="YYYY-MM-DD HH:mm:ss"
                placeholder="请选择报告周期开始"
                style="width: 100%"
              />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="报告周期结束" prop="periodEnd">
              <el-date-picker
                clearable
                v-model="form.periodEnd"
                type="datetime"
                value-format="YYYY-MM-DD HH:mm:ss"
                placeholder="请选择报告周期结束"
                style="width: 100%"
              />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="状态" prop="status">
              <el-select v-model="form.status" placeholder="请选择状态" style="width: 100%">
                <el-option label="草稿" value="0" />
                <el-option label="待审核" value="1" />
                <el-option label="已发布" value="2" />
                <el-option label="已归档" value="3" />
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="发布时间" prop="publishTime">
              <el-date-picker
                clearable
                v-model="form.publishTime"
                type="datetime"
                value-format="YYYY-MM-DD HH:mm:ss"
                placeholder="请选择发布时间"
                style="width: 100%"
              />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="删除标志" prop="delFlag">
              <el-select v-model="form.delFlag" placeholder="请选择删除标志" style="width: 100%">
                <el-option label="正常" value="0" />
                <el-option label="已删除" value="1" />
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>
        <el-form-item label="报告内容">
          <editor v-model="form.reportContent" :min-height="192" />
        </el-form-item>
        <el-form-item label="报告摘要" prop="summary">
          <el-input v-model="form.summary" type="textarea" :rows="4" placeholder="请输入报告摘要" />
        </el-form-item>
        <el-form-item label="建议措施" prop="recommendations">
          <el-input v-model="form.recommendations" type="textarea" :rows="4" placeholder="请输入建议措施" />
        </el-form-item>
      </el-form>
      <template #footer>
        <div class="dialog-footer">
          <el-button :loading="buttonLoading" type="primary" @click="submitForm">确 定</el-button>
          <el-button @click="cancel">取 消</el-button>
        </div>
      </template>
    </el-dialog>
    <FieldConfigDialog v-model:visible="showFieldConfig" :field-config-manager="fieldConfigManager" @confirm="() => (showFieldConfig = false)" />
    <SearchConfigDialog v-model="searchConfigVisible" :search-config-manager="searchConfigManager" @confirm="() => (searchConfigVisible = false)" />
  </div>
</template>

<script setup name="TumorQcReport" lang="ts">
import { listTumorQcReport, getTumorQcReport, delTumorQcReport, addTumorQcReport, updateTumorQcReport } from '@/api/system/tumorQcReport';
import { TumorQcReportVO, TumorQcReportQuery, TumorQcReportForm } from '@/api/system/tumorQcReport/types';
import FieldConfigDialog from '@/components/FieldConfigDialog.vue';
import { createTumorQcReportFieldConfig } from '@/utils/mmpFieldConfigs';
import SearchConfigDialog from '@/components/SearchConfigDialog.vue';
import { createTumorQcReportSearchConfig } from '@/utils/mmpSearchConfigs';
import DynamicSearchForm from '@/components/DynamicSearchForm.vue';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const tumorQcReportList = ref<TumorQcReportVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref();
const tumorQcReportFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});
const showFieldConfig = ref(false);
const fieldConfigManager = createTumorQcReportFieldConfig();
const searchConfigVisible = ref(false);
const searchConfigManager = createTumorQcReportSearchConfig();
const visibleSearchFields = computed(() => searchConfigManager.getVisibleFields());
const visibleColumns = computed(() => fieldConfigManager.getVisibleFields());

const initFormData: TumorQcReportForm = {
  id: undefined,
  reportCode: undefined,
  reportTitle: undefined,
  reportType: undefined,
  planId: undefined,
  periodStart: undefined,
  periodEnd: undefined,
  reportContent: undefined,
  summary: undefined,
  recommendations: undefined,
  status: undefined,
  publishTime: undefined,
  delFlag: undefined,
  tenantId: undefined
};
const data = reactive<PageData<TumorQcReportForm, TumorQcReportQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    reportCode: undefined,
    reportTitle: undefined,
    reportType: undefined,
    periodStart: undefined,
    periodEnd: undefined,
    reportContent: undefined,
    summary: undefined,
    recommendations: undefined,
    status: undefined,
    publishTime: undefined,
    delFlag: undefined,
    params: {}
  },
  rules: {
    reportCode: [{ required: true, message: '报告编码不能为空', trigger: 'blur' }],
    reportTitle: [{ required: true, message: '报告标题不能为空', trigger: 'blur' }],
    reportType: [{ required: true, message: '报告类型不能为空', trigger: 'change' }],
    periodStart: [{ required: true, message: '报告周期开始不能为空', trigger: 'blur' }],
    periodEnd: [{ required: true, message: '报告周期结束不能为空', trigger: 'blur' }]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询肿瘤质控报告列表 */
const getList = async () => {
  loading.value = true;
  const res = await listTumorQcReport(queryParams.value);
  tumorQcReportList.value = res.rows;
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
  tumorQcReportFormRef.value?.resetFields();
};

/** 搜索按钮操作 */
const handleQuery = () => {
  queryParams.value.pageNum = 1;
  getList();
};

/** 搜索配置 */
const handleSearchConfig = () => {
  searchConfigVisible.value = true;
};

/** 重置按钮操作 */
const resetQuery = () => {
  queryFormRef.value?.resetFields();
  handleQuery();
};

/** 多选框选中数据 */
const handleSelectionChange = (selection: TumorQcReportVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加肿瘤质控报告';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: TumorQcReportVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getTumorQcReport(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改肿瘤质控报告';
};

/** 提交按钮 */
const submitForm = () => {
  tumorQcReportFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateTumorQcReport(form.value).finally(() => (buttonLoading.value = false));
      } else {
        await addTumorQcReport(form.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: TumorQcReportVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除肿瘤质控报告编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delTumorQcReport(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/tumorQcReport/export',
    {
      ...queryParams.value
    },
    `tumorQcReport_${new Date().getTime()}.xlsx`
  );
};

/** 导入按钮操作 */
const handleImport = () => {
  (proxy?.$modal as any).upload('system/tumorQcReport/importData', '肿瘤质控报告导入', 'xls,xlsx', (response: any) => {
    proxy?.$modal.msgSuccess('导入成功');
    getList();
  });
};

/** 获取状态标签类型 */
const getStatusTagType = (status: string) => {
  switch (status) {
    case '0':
      return 'info';
    case '1':
      return 'warning';
    case '2':
      return 'success';
    case '3':
      return 'danger';
    default:
      return 'info';
  }
};

/** 获取状态文本 */
const getStatusText = (status: string) => {
  switch (status) {
    case '0':
      return '草稿';
    case '1':
      return '待审核';
    case '2':
      return '已发布';
    case '3':
      return '已归档';
    default:
      return status;
  }
};

onMounted(() => {
  getList();
});
</script>
