<template>
  <div class="app-container">
    <!-- 页面标题 -->
    <div class="page-header mb-4">
      <h2 class="page-title">
        <i-ep-data-analysis class="title-icon"></i-ep-data-analysis>
        手术工作量统计
      </h2>
      <p class="page-description">统计和管理手术工作量数据，包括医师手术数量、主刀次数、一助次数等统计信息</p>
    </div>

    <!-- 手术工作量概览 -->
    <el-card shadow="hover" class="dashboard-card mb-4">
      <template #header>
        <div class="card-header">
          <span class="card-title">
            <i-ep-pie-chart class="card-icon"></i-ep-pie-chart>
            手术工作量概览
          </span>
          <div class="card-actions">
            <el-button type="primary" size="small" @click="renderDashboard">
              <i-ep-refresh class="btn-icon"></i-ep-refresh>
              刷新
            </el-button>
          </div>
        </div>
      </template>
      <el-row :gutter="16">
        <el-col :xs="24" :sm="24" :md="8">
          <div class="chart-wrapper">
            <h4 class="chart-title">
              <i-ep-user class="chart-icon"></i-ep-user>
              按医师统计
            </h4>
            <div id="doctorStatistics" class="chart-container"></div>
          </div>
        </el-col>
        <el-col :xs="24" :sm="24" :md="8">
          <div class="chart-wrapper">
            <h4 class="chart-title">
              <i-ep-data-analysis class="chart-icon"></i-ep-data-analysis>
              按手术类型统计
            </h4>
            <div id="surgeryTypeStatistics" class="chart-container"></div>
          </div>
        </el-col>
        <el-col :xs="24" :sm="24" :md="8">
          <div class="chart-wrapper">
            <h4 class="chart-title">
              <i-ep-calendar class="chart-icon"></i-ep-calendar>
              按月份统计
            </h4>
            <div id="monthlyStatistics" class="chart-container"></div>
          </div>
        </el-col>
      </el-row>
    </el-card>

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

    <!-- 数据表格 -->
    <el-card shadow="hover" class="table-card">
      <template #header>
        <div class="table-header">
          <div class="table-title">
            <i-ep-list class="table-icon"></i-ep-list>
            手术工作量统计列表
            <span class="record-count">{{ total }} 条记录</span>
          </div>
          <div class="table-actions">
            <el-button type="primary" plain @click="handleAdd" v-hasPermi="['surgery:surgeryWorkloadStatistics:add']">
              <i-ep-plus class="btn-icon"></i-ep-plus>
              新增
            </el-button>
            <el-button type="success" plain :disabled="single" @click="handleUpdate()" v-hasPermi="['surgery:surgeryWorkloadStatistics:edit']">
              <i-ep-edit class="btn-icon"></i-ep-edit>
              修改
            </el-button>
            <el-button type="danger" plain :disabled="multiple" @click="handleDelete()" v-hasPermi="['surgery:surgeryWorkloadStatistics:remove']">
              <i-ep-delete class="btn-icon"></i-ep-delete>
              删除
            </el-button>
            <el-button type="warning" plain @click="handleExport" v-hasPermi="['surgery:surgeryWorkloadStatistics:export']">
              <i-ep-download class="btn-icon"></i-ep-download>
              导出
            </el-button>
            <el-button text type="primary" @click="showFieldConfig = true" class="config-btn">
              <i-ep-setting class="btn-icon"></i-ep-setting>
              字段配置
            </el-button>
            <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
          </div>
        </div>
      </template>

      <el-table v-loading="loading" border :data="surgeryWorkloadStatisticsList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="主键ID" align="center" prop="id" v-if="false" />
        <el-table-column
          v-if="fieldConfigManager.getFieldConfig('doctorName').visible"
          :label="fieldConfigManager.getFieldConfig('doctorName').label"
          align="center"
          prop="doctorName"
          :min-width="fieldConfigManager.getFieldConfig('doctorName').width"
          resizable
        />
        <el-table-column
          v-if="fieldConfigManager.getFieldConfig('surgeryName').visible"
          :label="fieldConfigManager.getFieldConfig('surgeryName').label"
          align="center"
          prop="surgeryName"
          :min-width="fieldConfigManager.getFieldConfig('surgeryName').width"
          resizable
        />
        <el-table-column
          v-if="fieldConfigManager.getFieldConfig('surgeryLevel').visible"
          :label="fieldConfigManager.getFieldConfig('surgeryLevel').label"
          align="center"
          prop="surgeryLevel"
          :min-width="fieldConfigManager.getFieldConfig('surgeryLevel').width"
          resizable
        >
          <template #default="scope">
            <el-tag :type="getSurgeryLevelTagType(scope.row.surgeryLevel)">
              {{ scope.row.surgeryLevel || '未知' }}
            </el-tag>
          </template>
        </el-table-column>
        <el-table-column
          v-if="fieldConfigManager.getFieldConfig('surgeryCount').visible"
          :label="fieldConfigManager.getFieldConfig('surgeryCount').label"
          align="center"
          prop="surgeryCount"
          :min-width="fieldConfigManager.getFieldConfig('surgeryCount').width"
          resizable
        >
          <template #default="scope">
            <span class="count-number">{{ scope.row.surgeryCount }}</span>
          </template>
        </el-table-column>
        <el-table-column
          v-if="fieldConfigManager.getFieldConfig('mainOperatorCount').visible"
          :label="fieldConfigManager.getFieldConfig('mainOperatorCount').label"
          align="center"
          prop="mainOperatorCount"
          :min-width="fieldConfigManager.getFieldConfig('mainOperatorCount').width"
          resizable
        >
          <template #default="scope">
            <span class="count-number">{{ scope.row.mainOperatorCount }}</span>
          </template>
        </el-table-column>
        <el-table-column
          v-if="fieldConfigManager.getFieldConfig('firstAssistantCount').visible"
          :label="fieldConfigManager.getFieldConfig('firstAssistantCount').label"
          align="center"
          prop="firstAssistantCount"
          :min-width="fieldConfigManager.getFieldConfig('firstAssistantCount').width"
          resizable
        >
          <template #default="scope">
            <span class="count-number">{{ scope.row.firstAssistantCount }}</span>
          </template>
        </el-table-column>
        <el-table-column
          v-if="fieldConfigManager.getFieldConfig('statisticsYear').visible"
          :label="fieldConfigManager.getFieldConfig('statisticsYear').label"
          align="center"
          prop="statisticsYear"
          :min-width="fieldConfigManager.getFieldConfig('statisticsYear').width"
          resizable
        />
        <el-table-column
          v-if="fieldConfigManager.getFieldConfig('statisticsMonth').visible"
          :label="fieldConfigManager.getFieldConfig('statisticsMonth').label"
          align="center"
          prop="statisticsMonth"
          :min-width="fieldConfigManager.getFieldConfig('statisticsMonth').width"
          resizable
        >
          <template #default="scope"> {{ scope.row.statisticsMonth }}月 </template>
        </el-table-column>
        <el-table-column label="操作" align="center" fixed="right" class-name="small-padding fixed-width" width="120">
          <template #default="scope">
            <el-tooltip content="修改" placement="top">
              <el-button
                link
                type="primary"
                icon="Edit"
                @click="handleUpdate(scope.row)"
                v-hasPermi="['surgery:surgeryWorkloadStatistics:edit']"
              ></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button
                link
                type="primary"
                icon="Delete"
                @click="handleDelete(scope.row)"
                v-hasPermi="['surgery:surgeryWorkloadStatistics:remove']"
              ></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改手术工作量统计对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="600px" append-to-body>
      <el-form ref="surgeryWorkloadStatisticsFormRef" :model="form" :rules="rules" label-width="100px">
        <el-row :gutter="16">
          <el-col :span="12">
            <el-form-item label="医师姓名" prop="doctorName">
              <el-input v-model="form.doctorName" placeholder="请输入医师姓名" clearable />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="手术名称" prop="surgeryName">
              <el-input v-model="form.surgeryName" placeholder="请输入手术名称" clearable />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="16">
          <el-col :span="12">
            <el-form-item label="手术级别" prop="surgeryLevel">
              <el-select v-model="form.surgeryLevel" placeholder="请选择手术级别" clearable style="width: 100%">
                <el-option label="一级" value="一级" />
                <el-option label="二级" value="二级" />
                <el-option label="三级" value="三级" />
                <el-option label="四级" value="四级" />
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="手术编码" prop="surgeryCode">
              <el-input v-model="form.surgeryCode" placeholder="请输入手术编码" clearable />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="16">
          <el-col :span="8">
            <el-form-item label="手术数量" prop="surgeryCount">
              <el-input-number v-model="form.surgeryCount" :min="0" :max="999" controls-position="right" style="width: 100%" />
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="主刀次数" prop="mainOperatorCount">
              <el-input-number v-model="form.mainOperatorCount" :min="0" :max="999" controls-position="right" style="width: 100%" />
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="一助次数" prop="firstAssistantCount">
              <el-input-number v-model="form.firstAssistantCount" :min="0" :max="999" controls-position="right" style="width: 100%" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="16">
          <el-col :span="12">
            <el-form-item label="统计年份" prop="statisticsYear">
              <el-date-picker
                v-model="form.statisticsYear"
                type="year"
                placeholder="选择年份"
                format="YYYY"
                value-format="YYYY"
                style="width: 100%"
              />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="统计月份" prop="statisticsMonth">
              <el-select v-model="form.statisticsMonth" placeholder="请选择月份" style="width: 100%">
                <el-option v-for="month in 12" :key="month" :label="`${month}月`" :value="month" />
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>
      </el-form>
      <template #footer>
        <div class="dialog-footer">
          <el-button :loading="buttonLoading" type="primary" @click="submitForm">
            <i-ep-check class="btn-icon"></i-ep-check>
            确 定
          </el-button>
          <el-button @click="cancel">
            <i-ep-close class="btn-icon"></i-ep-close>
            取 消
          </el-button>
        </div>
      </template>
    </el-dialog>
    <SearchConfigDialog v-model="searchConfigVisible" :search-config-manager="searchConfigManager" @confirm="() => (searchConfigVisible = false)" />
    <FieldConfigDialog v-model:visible="showFieldConfig" :field-config-manager="fieldConfigManager" @confirm="() => (showFieldConfig = false)" />
  </div>
</template>

<script setup name="SurgeryWorkloadStatistics" lang="ts">
import {
  listSurgeryWorkloadStatistics,
  getSurgeryWorkloadStatistics,
  delSurgeryWorkloadStatistics,
  addSurgeryWorkloadStatistics,
  updateSurgeryWorkloadStatistics
} from '@/api/surgery/surgeryWorkloadStatistics';
import {
  SurgeryWorkloadStatisticsVO,
  SurgeryWorkloadStatisticsQuery,
  SurgeryWorkloadStatisticsForm
} from '@/api/surgery/surgeryWorkloadStatistics/types';
import DynamicSearchForm from '@/components/DynamicSearchForm.vue';
import SearchConfigDialog from '@/components/SearchConfigDialog.vue';
import { createSurgeryWorkloadStatisticsSearchConfig } from '@/utils/configs/surgery/SearchConfigs';
import FieldConfigDialog from '@/components/FieldConfigDialog.vue';
import { createSurgeryWorkloadStatisticsFieldConfig } from '@/utils/configs/surgery/FieldConfigs';
import { Search, Setting, List, Refresh, Plus, Edit, Delete, Download, Check, Close, PieChart } from '@element-plus/icons-vue';
import * as echarts from 'echarts';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const surgeryWorkloadStatisticsList = ref<SurgeryWorkloadStatisticsVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref();
const surgeryWorkloadStatisticsFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});
const searchConfigVisible = ref(false);
const searchConfigManager = createSurgeryWorkloadStatisticsSearchConfig();
const visibleSearchFields = computed(() => searchConfigManager.getVisibleFields());
const showFieldConfig = ref(false);
const fieldConfigManager = createSurgeryWorkloadStatisticsFieldConfig();

const initFormData: SurgeryWorkloadStatisticsForm = {
  id: undefined,
  doctorId: undefined,
  doctorName: undefined,
  surgeryCode: undefined,
  surgeryName: undefined,
  surgeryLevel: undefined,
  surgeryCount: undefined,
  mainOperatorCount: undefined,
  firstAssistantCount: undefined,
  statisticsYear: undefined,
  statisticsMonth: undefined
};
const data = reactive<PageData<SurgeryWorkloadStatisticsForm, SurgeryWorkloadStatisticsQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    doctorName: undefined,
    surgeryCode: undefined,
    surgeryName: undefined,
    surgeryLevel: undefined,
    surgeryCount: undefined,
    mainOperatorCount: undefined,
    firstAssistantCount: undefined,
    statisticsYear: undefined,
    statisticsMonth: undefined,
    delFlag: undefined,
    params: {}
  },
  rules: {
    doctorName: [{ required: true, message: '医师姓名不能为空', trigger: 'blur' }],
    surgeryName: [{ required: true, message: '手术名称不能为空', trigger: 'blur' }],
    surgeryCount: [
      { required: true, message: '手术数量不能为空', trigger: 'blur' },
      { type: 'number', min: 0, message: '手术数量不能小于0', trigger: 'blur' }
    ],
    statisticsYear: [{ required: true, message: '统计年份不能为空', trigger: 'blur' }],
    statisticsMonth: [{ required: true, message: '统计月份不能为空', trigger: 'blur' }]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 获取手术级别标签类型 */
const getSurgeryLevelTagType = (level: string) => {
  const levelMap: Record<string, string> = {
    '一级': 'success',
    '二级': 'info',
    '三级': 'warning',
    '四级': 'danger'
  };
  return levelMap[level] || 'primary';
};

/** 查询手术工作量统计列表 */
const getList = async () => {
  loading.value = true;
  try {
    const res = await listSurgeryWorkloadStatistics(queryParams.value);
    surgeryWorkloadStatisticsList.value = res.rows;
    total.value = res.total;
  } catch (error) {
    console.error('获取手术工作量统计列表失败:', error);
    surgeryWorkloadStatisticsList.value = [];
    total.value = 0;
  } finally {
    loading.value = false;
  }
};

/** 取消按钮 */
const cancel = () => {
  reset();
  dialog.visible = false;
};

/** 表单重置 */
const reset = () => {
  form.value = { ...initFormData };
  surgeryWorkloadStatisticsFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: SurgeryWorkloadStatisticsVO[]) => {
  ids.value = selection.map((item) => (item as any).id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加手术工作量统计';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: SurgeryWorkloadStatisticsVO) => {
  reset();
  const _id = (row as any)?.id || ids.value[0];
  const res = await getSurgeryWorkloadStatistics(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改手术工作量统计';
};

/** 提交按钮 */
const submitForm = () => {
  surgeryWorkloadStatisticsFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateSurgeryWorkloadStatistics(form.value).finally(() => (buttonLoading.value = false));
      } else {
        await addSurgeryWorkloadStatistics(form.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: SurgeryWorkloadStatisticsVO) => {
  const _ids = (row as any)?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除手术工作量统计编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delSurgeryWorkloadStatistics(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'surgery/surgeryWorkloadStatistics/export',
    {
      ...queryParams.value
    },
    `surgeryWorkloadStatistics_${new Date().getTime()}.xlsx`
  );
};

onMounted(() => {
  getList();
  renderDashboard();
});

const renderDashboard = async () => {
  let rows: any[] = [];
  try {
    const res = await listSurgeryWorkloadStatistics({ pageNum: 1, pageSize: 1000 } as any);
    rows = (res as any).rows || [];
  } catch {
    rows = (surgeryWorkloadStatisticsList.value as any[]) || [];
  }

  // 按医师统计
  const doctorMap = new Map<string, number>();
  rows.forEach((r: any) => {
    const doctor = r.doctorName || '未知医师';
    doctorMap.set(doctor, (doctorMap.get(doctor) || 0) + Number(r.surgeryCount || 0));
  });
  const doctors = Array.from(doctorMap.keys());
  const doctorData = doctors
    .map((doctor) => ({
      name: doctor,
      value: doctorMap.get(doctor) || 0
    }))
    .sort((a, b) => b.value - a.value)
    .slice(0, 10); // 只显示前10名

  const doctorDom = document.getElementById('doctorStatistics');
  if (doctorDom) {
    const chart = echarts.init(doctorDom);
    chart.setOption({
      tooltip: {
        trigger: 'item',
        formatter: '{a} <br/>{b}: {c} ({d}%)'
      },
      legend: {
        orient: 'vertical',
        left: 'right',
        top: 'center',
        type: 'scroll'
      },
      series: [
        {
          name: '手术数量',
          type: 'pie',
          radius: ['40%', '70%'],
          center: ['35%', '50%'],
          avoidLabelOverlap: false,
          emphasis: {
            itemStyle: {
              shadowBlur: 10,
              shadowOffsetX: 0,
              shadowColor: 'rgba(0, 0, 0, 0.5)'
            }
          },
          data: doctorData
        }
      ]
    });
  }

  // 按手术类型统计
  const surgeryTypeMap = new Map<string, number>();
  rows.forEach((r: any) => {
    const surgeryType = r.surgeryName || '未知类型';
    surgeryTypeMap.set(surgeryType, (surgeryTypeMap.get(surgeryType) || 0) + Number(r.surgeryCount || 0));
  });
  const surgeryTypes = Array.from(surgeryTypeMap.keys());
  const surgeryTypeData = surgeryTypes
    .map((type) => ({
      name: type,
      value: surgeryTypeMap.get(type) || 0
    }))
    .sort((a, b) => b.value - a.value)
    .slice(0, 10); // 只显示前10种

  const surgeryTypeDom = document.getElementById('surgeryTypeStatistics');
  if (surgeryTypeDom) {
    const chart = echarts.init(surgeryTypeDom);
    chart.setOption({
      tooltip: {
        trigger: 'item',
        formatter: '{a} <br/>{b}: {c} ({d}%)'
      },
      legend: {
        orient: 'vertical',
        left: 'right',
        top: 'center',
        type: 'scroll'
      },
      series: [
        {
          name: '手术数量',
          type: 'pie',
          radius: '60%',
          center: ['35%', '50%'],
          data: surgeryTypeData,
          emphasis: {
            itemStyle: {
              shadowBlur: 10,
              shadowOffsetX: 0,
              shadowColor: 'rgba(0, 0, 0, 0.5)'
            }
          }
        }
      ]
    });
  }

  // 按月份统计
  const monthMap = new Map<string, number>();
  rows.forEach((r: any) => {
    const y = r.statisticsYear || new Date().getFullYear();
    const m = String(r.statisticsMonth || 1).padStart(2, '0');
    const key = `${y}-${m}`;
    monthMap.set(key, (monthMap.get(key) || 0) + Number(r.surgeryCount || 0));
  });
  const months = Array.from(monthMap.keys()).sort();
  const monthData = months.map((k) => monthMap.get(k) || 0);

  const monthDom = document.getElementById('monthlyStatistics');
  if (monthDom) {
    const chart = echarts.init(monthDom);
    chart.setOption({
      tooltip: {
        trigger: 'axis',
        axisPointer: {
          type: 'cross',
          label: {
            backgroundColor: '#6a7985'
          }
        }
      },
      grid: {
        left: '3%',
        right: '4%',
        bottom: '3%',
        containLabel: true
      },
      xAxis: {
        type: 'category',
        boundaryGap: false,
        data: months
      },
      yAxis: {
        type: 'value'
      },
      series: [
        {
          name: '手术数量',
          type: 'line',
          stack: 'Total',
          smooth: true,
          areaStyle: {
            opacity: 0.3
          },
          emphasis: {
            focus: 'series'
          },
          data: monthData,
          itemStyle: {
            color: '#13c2c2'
          }
        }
      ]
    });
  }
};
</script>

<style scoped>
.app-container {
  padding: 20px;
}

.page-header {
  margin-bottom: 20px;
}

.page-title {
  display: flex;
  align-items: center;
  font-size: 24px;
  font-weight: 600;
  color: #1f2937;
  margin: 0 0 8px 0;
}

.title-icon {
  margin-right: 12px;
  color: #409eff;
  font-size: 28px;
}

.page-description {
  color: #6b7280;
  font-size: 14px;
  margin: 0;
  line-height: 1.5;
}

.dashboard-card {
  margin-bottom: 20px;
}

.card-header {
  display: flex;
  align-items: center;
  justify-content: space-between;
}

.card-title {
  display: flex;
  align-items: center;
  font-weight: 600;
  color: #1f2937;
}

.card-icon {
  margin-right: 8px;
  color: #409eff;
}

.card-actions {
  display: flex;
  gap: 8px;
}

.chart-wrapper {
  background: #fff;
  border-radius: 8px;
  padding: 16px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
  margin-bottom: 16px;
}

.chart-title {
  display: flex;
  align-items: center;
  font-size: 16px;
  font-weight: 600;
  color: #1f2937;
  margin: 0 0 12px 0;
  padding-bottom: 8px;
  border-bottom: 2px solid #f3f4f6;
}

.chart-icon {
  margin-right: 8px;
  color: #409eff;
  font-size: 18px;
}

.chart-container {
  height: 300px;
  width: 100%;
}

.search-container {
  margin-bottom: 20px;
}

.search-card {
  border-radius: 8px;
}

.search-header {
  display: flex;
  align-items: center;
  justify-content: space-between;
}

.search-title {
  display: flex;
  align-items: center;
  font-weight: 600;
  color: #1f2937;
}

.search-icon {
  margin-right: 8px;
  color: #409eff;
}

.search-actions {
  display: flex;
  gap: 8px;
}

.config-btn {
  font-size: 14px;
}

.table-card {
  border-radius: 8px;
}

.table-header {
  display: flex;
  align-items: center;
  justify-content: space-between;
  flex-wrap: wrap;
  gap: 12px;
}

.table-title {
  display: flex;
  align-items: center;
  font-weight: 600;
  color: #1f2937;
}

.table-icon {
  margin-right: 8px;
  color: #409eff;
}

.record-count {
  margin-left: 12px;
  font-size: 14px;
  color: #6b7280;
  font-weight: normal;
}

.table-actions {
  display: flex;
  align-items: center;
  gap: 8px;
  flex-wrap: wrap;
}

.btn-icon {
  margin-right: 6px;
}

.count-number {
  font-weight: 600;
  color: #1f2937;
}

.chart-container {
  width: 100%;
  height: 280px;
  border-radius: 8px;
}

.dialog-footer {
  display: flex;
  justify-content: flex-end;
  gap: 12px;
}

/* 响应式设计 */
@media (max-width: 768px) {
  .app-container {
    padding: 16px;
  }

  .page-title {
    font-size: 20px;
  }

  .table-header {
    flex-direction: column;
    align-items: flex-start;
  }

  .table-actions {
    width: 100%;
    justify-content: flex-start;
  }

  .card-header {
    flex-direction: column;
    align-items: flex-start;
    gap: 12px;
  }

  .card-actions {
    width: 100%;
    justify-content: flex-start;
  }
}
</style>
