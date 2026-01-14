<template>
  <div class="app-container">
    <!-- 页面标题 -->
    <div class="page-header mb-4">
      <h2 class="page-title">
        <i-ep-pie-chart class="title-icon"></i-ep-pie-chart>
        手术记录统计仪表板
      </h2>
      <p class="page-description">按科室、手术级别和医生统计手术数据概览</p>
    </div>

    <!-- 统计卡片 -->
    <el-row :gutter="20" class="mb-4" v-loading="loading">
      <el-col :xs="24" :sm="12" :md="6">
        <el-card shadow="hover" class="stat-card">
          <div class="stat-content">
            <div class="stat-icon">
              <i-ep-office-building></i-ep-office-building>
            </div>
            <div class="stat-info">
              <div class="stat-value">{{ totalStats.departments }}</div>
              <div class="stat-label">参与科室</div>
            </div>
          </div>
        </el-card>
      </el-col>
      <el-col :xs="24" :sm="12" :md="6">
        <el-card shadow="hover" class="stat-card">
          <div class="stat-content">
            <div class="stat-icon">
              <i-ep-user></i-ep-user>
            </div>
            <div class="stat-info">
              <div class="stat-value">{{ totalStats.doctors }}</div>
              <div class="stat-label">手术医生</div>
            </div>
          </div>
        </el-card>
      </el-col>
      <el-col :xs="24" :sm="12" :md="6">
        <el-card shadow="hover" class="stat-card">
          <div class="stat-content">
            <div class="stat-icon">
              <i-ep-first-aid-kit></i-ep-first-aid-kit>
            </div>
            <div class="stat-info">
              <div class="stat-value">{{ totalStats.totalSurgeries }}</div>
              <div class="stat-label">总手术数</div>
            </div>
          </div>
        </el-card>
      </el-col>
      <el-col :xs="24" :sm="12" :md="6">
        <el-card shadow="hover" class="stat-card">
          <div class="stat-content">
            <div class="stat-icon">
              <i-ep-timer></i-ep-timer>
            </div>
            <div class="stat-info">
              <div class="stat-value">{{ totalStats.avgDuration }}分钟</div>
              <div class="stat-label">平均时长</div>
            </div>
          </div>
        </el-card>
      </el-col>
    </el-row>

    <!-- 图表区域 -->
    <el-row :gutter="20">
      <!-- 按科室统计 -->
      <el-col :xs="24" :lg="12">
        <el-card shadow="hover" class="chart-card">
          <template #header>
            <span class="card-title">
              <i-ep-office-building class="card-icon"></i-ep-office-building>
              按科室统计
            </span>
          </template>
          <div class="chart-container">
            <div id="departmentChart" class="chart"></div>
          </div>
        </el-card>
      </el-col>

      <!-- 按手术级别统计 -->
      <el-col :xs="24" :lg="12">
        <el-card shadow="hover" class="chart-card">
          <template #header>
            <span class="card-title">
              <i-ep-price-tag class="card-icon"></i-ep-price-tag>
              按手术级别统计
            </span>
          </template>
          <div class="chart-container">
            <div id="levelChart" class="chart"></div>
          </div>
        </el-card>
      </el-col>
    </el-row>

    <!-- 详细数据表格 -->
    <el-card shadow="hover" class="table-card mt-4">
      <template #header>
        <span class="card-title">
          <i-ep-data-analysis class="card-icon"></i-ep-data-analysis>
          详细统计数据
        </span>
      </template>
      <el-table :data="summaryData" border style="width: 100%" v-loading="loading">
        <el-table-column prop="departmentName" label="科室名称" width="150" align="center" />
        <el-table-column prop="surgeryLevel" label="手术级别" width="120" align="center" />
        <el-table-column prop="doctorName" label="医生姓名" width="120" align="center" />
        <el-table-column prop="surgeryCount" label="手术数量" width="100" align="center" />
        <el-table-column prop="avgDuration" label="平均时长(分钟)" width="140" align="center">
          <template #default="scope">
            {{ scope.row.avgDuration ? scope.row.avgDuration.toFixed(1) : '-' }}
          </template>
        </el-table-column>
        <el-table-column prop="totalDuration" label="总时长(分钟)" width="120" align="center" />
      </el-table>
    </el-card>
  </div>
</template>

<script setup lang="ts" name="SurgeryRecordDashboard">
import { ref, reactive, onMounted, nextTick, onUnmounted } from 'vue';
import * as echarts from 'echarts';
import { getSurgeryRecordSummary } from '@/api/surgery/surgeryRecord';
import { SurgeryRecordSummaryVO } from '@/api/surgery/surgeryRecord/types';

// 数据
const loading = ref(false);
const summaryData = ref<SurgeryRecordSummaryVO[]>([]);
const totalStats = reactive({
  departments: 0,
  doctors: 0,
  totalSurgeries: 0,
  avgDuration: 0
});

// 图表实例
let departmentChart: echarts.ECharts | null = null;
let levelChart: echarts.ECharts | null = null;

// 获取汇总数据
const getSummaryData = async () => {
  try {
    loading.value = true;
    const response = await getSurgeryRecordSummary();
    summaryData.value = response.data;

    // 计算总统计
    calculateTotalStats();

    // 生成图表数据
    generateCharts();
  } catch (error) {
    console.error('获取汇总数据失败:', error);
  } finally {
    loading.value = false;
  }
};

// 计算总统计
const calculateTotalStats = () => {
  const departments = new Set();
  const doctors = new Set();
  let totalSurgeries = 0;
  let totalDuration = 0;

  summaryData.value.forEach((item) => {
    departments.add(item.departmentName);
    doctors.add(item.doctorName);
    totalSurgeries += item.surgeryCount;
    totalDuration += item.totalDuration;
  });

  totalStats.departments = departments.size;
  totalStats.doctors = doctors.size;
  totalStats.totalSurgeries = totalSurgeries;
  totalStats.avgDuration = totalSurgeries > 0 ? Math.round(totalDuration / totalSurgeries) : 0;
};

// 生成图表
const generateCharts = () => {
  nextTick(() => {
    // 按科室统计
    const departmentData = summaryData.value.reduce(
      (acc, item) => {
        if (!acc[item.departmentName]) {
          acc[item.departmentName] = 0;
        }
        acc[item.departmentName] += item.surgeryCount;
        return acc;
      },
      {} as Record<string, number>
    );

    const departmentChartDom = document.getElementById('departmentChart');
    if (departmentChartDom) {
      departmentChart = echarts.init(departmentChartDom);
      const departmentOption = {
        tooltip: {
          trigger: 'item',
          formatter: '{a} <br/>{b}: {c} ({d}%)'
        },
        legend: {
          orient: 'vertical',
          left: 'left'
        },
        series: [
          {
            name: '手术数量',
            type: 'pie',
            radius: '50%',
            data: Object.entries(departmentData).map(([name, value]) => ({
              name,
              value
            })),
            emphasis: {
              itemStyle: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
              }
            }
          }
        ]
      };
      departmentChart.setOption(departmentOption);
    }

    // 按手术级别统计
    const levelData = summaryData.value.reduce(
      (acc, item) => {
        if (!acc[item.surgeryLevel]) {
          acc[item.surgeryLevel] = 0;
        }
        acc[item.surgeryLevel] += item.surgeryCount;
        return acc;
      },
      {} as Record<string, number>
    );

    const levelChartDom = document.getElementById('levelChart');
    if (levelChartDom) {
      levelChart = echarts.init(levelChartDom);
      const levelOption = {
        tooltip: {
          trigger: 'axis',
          axisPointer: {
            type: 'shadow'
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
          data: Object.keys(levelData)
        },
        yAxis: {
          type: 'value'
        },
        series: [
          {
            name: '手术数量',
            type: 'bar',
            data: Object.values(levelData),
            itemStyle: {
              color: '#409EFF'
            }
          }
        ]
      };
      levelChart.setOption(levelOption);
    }
  });
};

onMounted(() => {
  getSummaryData();
  window.addEventListener('resize', handleResize);
});

onUnmounted(() => {
  window.removeEventListener('resize', handleResize);
  if (departmentChart) {
    departmentChart.dispose();
  }
  if (levelChart) {
    levelChart.dispose();
  }
});

// 窗口大小改变处理
const handleResize = () => {
  if (departmentChart) {
    departmentChart.resize();
  }
  if (levelChart) {
    levelChart.resize();
  }
};
</script>

<style scoped>
.app-container {
  padding: 20px;
}

.page-header {
  text-align: center;
}

.page-title {
  font-size: 24px;
  font-weight: bold;
  color: #303133;
  margin-bottom: 8px;
}

.title-icon {
  margin-right: 8px;
  color: #409eff;
}

.page-description {
  color: #909399;
  font-size: 14px;
}

.stat-card {
  height: 100px;
  display: flex;
  align-items: center;
  justify-content: center;
}

.stat-content {
  display: flex;
  align-items: center;
  gap: 16px;
}

.stat-icon {
  font-size: 32px;
  color: #409eff;
}

.stat-info {
  text-align: center;
}

.stat-value {
  font-size: 24px;
  font-weight: bold;
  color: #303133;
  margin-bottom: 4px;
}

.stat-label {
  font-size: 12px;
  color: #909399;
}

.chart-card {
  height: 400px;
}

.card-title {
  font-weight: bold;
  color: #303133;
}

.card-icon {
  margin-right: 8px;
  color: #409eff;
}

.chart-container {
  height: 320px;
}

.chart {
  height: 100%;
  width: 100%;
}

.table-card {
  margin-top: 20px;
}
</style>
