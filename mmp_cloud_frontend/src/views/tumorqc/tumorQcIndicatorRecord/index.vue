<template>
  <div class="app-container">
    <div class="page-header mb-4">
      <h2 class="page-title">
        <i-ep-data-analysis class="title-icon"></i-ep-data-analysis>
        肿瘤质控指标监测记录管理
      </h2>
      <p class="page-description">管理肿瘤质控指标的监测记录，包括记录日期、科室、指标数值与趋势等</p>
    </div>
    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <div v-show="showSearch" class="mb-[10px]">
        <el-card shadow="hover" class="search-card">
          <template #header>
            <div class="search-header">
              <span class="search-title">
                <i-ep-search class="search-icon"></i-ep-search>
                搜索条件
              </span>
              <div class="search-actions">
                <el-button text type="primary" @click="searchConfigVisible = true" class="config-btn">
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

    <el-card shadow="never" class="table-card">
      <template #header>
        <div class="table-header">
          <div class="table-title">
            <i-ep-list class="table-icon"></i-ep-list>
            监测记录列表
            <el-tag type="info" size="small" class="ml-2">{{ total }} 条记录</el-tag>
          </div>
          <div class="table-actions">
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['system:tumorQcIndicatorRecord:add']">新增</el-button>
            <el-button type="success" plain icon="Edit" :disabled="single" @click="handleUpdate()" v-hasPermi="['system:tumorQcIndicatorRecord:edit']">修改</el-button>
            <el-button type="danger" plain icon="Delete" :disabled="multiple" @click="handleDelete()" v-hasPermi="['system:tumorQcIndicatorRecord:remove']">删除</el-button>
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['system:tumorQcIndicatorRecord:export']">导出</el-button>
            <el-button type="warning" plain icon="Setting" @click="showFieldConfig = true">字段配置</el-button>
            <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
          </div>
        </div>
      </template>

      <el-table v-loading="loading" border :data="tumorQcIndicatorRecordList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column
          v-for="field in fieldConfigManager.getVisibleFields()"
          :key="field.prop"
          :label="field.label"
          :prop="field.prop"
          :width="field.width"
          align="center"
        >
          <template #default="scope">
            <span v-if="field.prop === 'recordDate'">{{ parseTime(scope.row[field.prop], '{y}-{m}-{d}') }}</span>
            <span v-else>{{ scope.row[field.prop] }}</span>
          </template>
        </el-table-column>
        <el-table-column label="操作" align="center" fixed="right" class-name="small-padding fixed-width">
          <template #default="scope">
            <el-tooltip content="修改" placement="top">
              <el-button
                link
                type="primary"
                icon="Edit"
                @click="handleUpdate(scope.row)"
                v-hasPermi="['system:tumorQcIndicatorRecord:edit']"
              ></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button
                link
                type="primary"
                icon="Delete"
                @click="handleDelete(scope.row)"
                v-hasPermi="['system:tumorQcIndicatorRecord:remove']"
              ></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改质控指标监测记录对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="tumorQcIndicatorRecordFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="记录日期" prop="recordDate">
          <el-date-picker clearable v-model="form.recordDate" type="datetime" value-format="YYYY-MM-DD HH:mm:ss" placeholder="请选择记录日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="计算周期" prop="calculationCycle">
          <el-input v-model="form.calculationCycle" placeholder="请输入计算周期" />
        </el-form-item>
        <el-form-item label="科室ID" prop="departmentId">
          <el-input v-model="form.departmentId" placeholder="请输入科室ID" />
        </el-form-item>
        <el-form-item label="科室名称" prop="departmentName">
          <el-input v-model="form.departmentName" placeholder="请输入科室名称" />
        </el-form-item>
        <el-form-item label="指标ID" prop="indicatorId">
          <el-input v-model="form.indicatorId" placeholder="请输入指标ID" />
        </el-form-item>
        <el-form-item label="指标编码" prop="indicatorCode">
          <el-input v-model="form.indicatorCode" placeholder="请输入指标编码" />
        </el-form-item>
        <el-form-item label="指标名称" prop="indicatorName">
          <el-input v-model="form.indicatorName" placeholder="请输入指标名称" />
        </el-form-item>
        <el-form-item label="分子" prop="numerator">
          <el-input v-model="form.numerator" placeholder="请输入分子" />
        </el-form-item>
        <el-form-item label="分母" prop="denominator">
          <el-input v-model="form.denominator" placeholder="请输入分母" />
        </el-form-item>
        <el-form-item label="指标值" prop="indicatorValue">
          <el-input v-model="form.indicatorValue" placeholder="请输入指标值" />
        </el-form-item>
        <el-form-item label="目标值" prop="targetValue">
          <el-input v-model="form.targetValue" placeholder="请输入目标值" />
        </el-form-item>
        <el-form-item label="完成率(%)" prop="completionRate">
          <el-input v-model="form.completionRate" placeholder="请输入完成率(%)" />
        </el-form-item>
        <el-form-item label="院内排名" prop="rankInHospital">
          <el-input v-model="form.rankInHospital" placeholder="请输入院内排名" />
        </el-form-item>
        <el-form-item label="趋势方向" prop="trendDirection">
          <el-input v-model="form.trendDirection" placeholder="请输入趋势方向" />
        </el-form-item>
        <el-form-item label="是否异常 1-是 0-否" prop="isAbnormal">
          <el-input v-model="form.isAbnormal" placeholder="请输入是否异常 1-是 0-否" />
        </el-form-item>
        <el-form-item label="数据来源说明" prop="dataSource">
          <el-input v-model="form.dataSource" placeholder="请输入数据来源说明" />
        </el-form-item>
        <el-form-item label="是否人工录入 1-是 0-否" prop="isManual">
          <el-input v-model="form.isManual" placeholder="请输入是否人工录入 1-是 0-否" />
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

    <FieldConfigDialog v-model:visible="showFieldConfig" :field-config-manager="fieldConfigManager" @confirm="handleFieldConfigConfirm" />
    <SearchConfigDialog v-model="searchConfigVisible" :search-config-manager="searchConfigManager" @confirm="() => (searchConfigVisible = false)" />
  </div>
</template>

<script setup name="TumorQcIndicatorRecord" lang="ts">
import {
  listTumorQcIndicatorRecord,
  getTumorQcIndicatorRecord,
  delTumorQcIndicatorRecord,
  addTumorQcIndicatorRecord,
  updateTumorQcIndicatorRecord
} from '@/api/tumorqc/tumorQcIndicatorRecord';
import { TumorQcIndicatorRecordVO, TumorQcIndicatorRecordQuery, TumorQcIndicatorRecordForm } from '@/api/tumorqc/tumorQcIndicatorRecord/types';
import { createTumorQcIndicatorRecordFieldConfig } from '@/utils/mmpFieldConfigs';
import SearchConfigDialog from '@/components/SearchConfigDialog.vue';
import { createTumorQcIndicatorRecordSearchConfig } from '@/utils/mmpSearchConfigs';
import DynamicSearchForm from '@/components/DynamicSearchForm.vue';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const tumorQcIndicatorRecordList = ref<TumorQcIndicatorRecordVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const showFieldConfig = ref(false);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const fieldConfigManager = createTumorQcIndicatorRecordFieldConfig();
const searchConfigManager = createTumorQcIndicatorRecordSearchConfig();
const searchConfigVisible = ref(false);
const visibleSearchFields = computed(() => searchConfigManager.getVisibleFields());

const queryFormRef = ref();
const tumorQcIndicatorRecordFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: TumorQcIndicatorRecordForm = {
  id: undefined,
  recordDate: undefined,
  calculationCycle: undefined,
  departmentId: undefined,
  departmentName: undefined,
  indicatorId: undefined,
  indicatorCode: undefined,
  indicatorName: undefined,
  numerator: undefined,
  denominator: undefined,
  indicatorValue: undefined,
  targetValue: undefined,
  complianceStatus: undefined,
  completionRate: undefined,
  rankInHospital: undefined,
  trendDirection: undefined,
  isAbnormal: undefined,
  dataSource: undefined,
  isManual: undefined,
  remark: undefined
};
const data = reactive<PageData<TumorQcIndicatorRecordForm, TumorQcIndicatorRecordQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    recordDate: undefined,
    calculationCycle: undefined,
    departmentId: undefined,
    departmentName: undefined,
    indicatorId: undefined,
    indicatorCode: undefined,
    indicatorName: undefined,
    numerator: undefined,
    denominator: undefined,
    indicatorValue: undefined,
    targetValue: undefined,
    complianceStatus: undefined,
    completionRate: undefined,
    rankInHospital: undefined,
    trendDirection: undefined,
    isAbnormal: undefined,
    dataSource: undefined,
    isManual: undefined,
    params: {}
  },
  rules: {
    id: [{ required: true, message: '主键ID不能为空', trigger: 'blur' }],
    recordDate: [{ required: true, message: '记录日期不能为空', trigger: 'blur' }],
    indicatorId: [{ required: true, message: '指标ID不能为空', trigger: 'blur' }]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询质控指标监测记录列表 */
const getList = async () => {
  loading.value = true;
  const res = await listTumorQcIndicatorRecord(queryParams.value);
  tumorQcIndicatorRecordList.value = res.rows;
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
  tumorQcIndicatorRecordFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: TumorQcIndicatorRecordVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加质控指标监测记录';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: TumorQcIndicatorRecordVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getTumorQcIndicatorRecord(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改质控指标监测记录';
};

/** 提交按钮 */
const submitForm = () => {
  tumorQcIndicatorRecordFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateTumorQcIndicatorRecord(form.value).finally(() => (buttonLoading.value = false));
      } else {
        await addTumorQcIndicatorRecord(form.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: TumorQcIndicatorRecordVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除质控指标监测记录编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delTumorQcIndicatorRecord(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/tumorQcIndicatorRecord/export',
    {
      ...queryParams.value
    },
    `tumorQcIndicatorRecord_${new Date().getTime()}.xlsx`
  );
};

/** 字段配置确认 */
const handleFieldConfigConfirm = () => {
  showFieldConfig.value = false;
};

onMounted(() => {
  getList();
});
</script>
<style scoped>
.page-header .page-description {
  font-size: 13px;
  color: #86909c;
  line-height: 1.6;
}
.search-card .search-header {
  display: flex;
  align-items: center;
  justify-content: space-between;
  min-height: 44px;
}
.search-card .search-title {
  display: inline-flex;
  align-items: center;
  gap: 8px;
}
.table-card {
  background: #fff;
  border-radius: 8px;
  padding: 12px;
}
.table-header {
  display: flex;
  align-items: center;
  gap: 12px;
  min-height: 44px;
  padding: 6px 8px;
}
.table-title {
  display: inline-flex;
  align-items: center;
  gap: 8px;
}
.table-actions {
  margin-left: auto;
  display: inline-flex;
  align-items: center;
  gap: 8px;
  flex-wrap: nowrap;
}
</style>
