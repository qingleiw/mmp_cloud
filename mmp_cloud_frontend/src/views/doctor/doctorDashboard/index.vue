<template>
  <div class="p-2">
    <!-- 医师概览卡片 -->
    <el-card shadow="hover" class="mb-[10px]">
      <template #header>
        <div class="flex items-center justify-between">
          <span>医师概览</span>
          <el-button type="primary" size="small" icon="Refresh" @click="renderDashboard">刷新</el-button>
        </div>
      </template>
      <el-row :gutter="12">
        <el-col :xs="24" :sm="24" :md="12">
          <div id="ageBarChart" class="chart-container"></div>
        </el-col>
        <el-col :xs="24" :sm="12" :md="12">
          <div id="genderDonutChart" class="chart-container"></div>
        </el-col>
      </el-row>
      <el-row :gutter="12" class="mt-2">
        <el-col :xs="24" :sm="12" :md="12">
          <div id="departmentRoseChart" class="chart-container"></div>
        </el-col>
        <el-col :xs="24" :sm="12" :md="12">
          <div id="titleChordChart" class="chart-container"></div>
        </el-col>
      </el-row>
    </el-card>
  </div>
</template>

<script setup name="DoctorDashboard" lang="ts">
import { listDoctorBasicInfo } from '@/api/doctor/doctorBasicInfo';
import { DoctorBasicInfoVO, DoctorBasicInfoQuery } from '@/api/doctor/doctorBasicInfo/types';
import * as echarts from 'echarts';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

/** 仪表盘渲染 */
const renderDashboard = async () => {
  // 拉取更多数据用于统计
  let rows: DoctorBasicInfoVO[] = [];
  try {
    const res = await listDoctorBasicInfo({ pageNum: 1, pageSize: 1000 });
    rows = (res as any).rows || [];
  } catch (e) {
    rows = [];
  }
  // 性别统计与年龄分布
  const maleCount = rows.filter((d: any) => String(d.gender) === '1').length;
  const femaleCount = rows.filter((d: any) => String(d.gender) === '2').length;
  const ageMapMale = new Map<number, number>();
  const ageMapFemale = new Map<number, number>();
  const calcAge = (birth: any) => {
    if (!birth) return 0;
    const d = new Date(birth);
    const now = new Date();
    let age = now.getFullYear() - d.getFullYear();
    const m = now.getMonth() - d.getMonth();
    if (m < 0 || (m === 0 && now.getDate() < d.getDate())) age--;
    return Math.max(0, age);
  };
  rows.forEach((d: any) => {
    const age = calcAge(d.birthDate);
    if (String(d.gender) === '1') {
      ageMapMale.set(age, (ageMapMale.get(age) || 0) + 1);
    } else if (String(d.gender) === '2') {
      ageMapFemale.set(age, (ageMapFemale.get(age) || 0) + 1);
    }
  });
  const ageBins = [
    { label: '0-19', min: 0, max: 19 },
    { label: '20-29', min: 20, max: 29 },
    { label: '30-39', min: 30, max: 39 },
    { label: '40-49', min: 40, max: 49 },
    { label: '50-59', min: 50, max: 59 },
    { label: '60-69', min: 60, max: 69 },
    { label: '70+', min: 70, max: Infinity }
  ];
  const maleSeries = ageBins.map((bin) => {
    let count = 0;
    ageMapMale.forEach((v, k) => {
      if (k >= bin.min && k <= bin.max) count += v;
    });
    return count;
  });
  const femaleSeries = ageBins.map((bin) => {
    let count = 0;
    ageMapFemale.forEach((v, k) => {
      if (k >= bin.min && k <= bin.max) count += v;
    });
    return count;
  });

  // 科室玫瑰图
  const deptMap = new Map<string, number>();
  rows.forEach((d: any) => {
    const name = d.departmentName || '未知';
    deptMap.set(name, (deptMap.get(name) || 0) + 1);
  });
  const deptData = Array.from(deptMap.entries())
    .map(([name, value]) => ({ name, value }))
    .sort((a, b) => b.value - a.value)
    .slice(0, 12);

  // 职称“和弦图”（采用graph环形辐射展示）
  const titleMap = new Map<string, number>();
  rows.forEach((d: any) => {
    const t = d.title || '其他';
    titleMap.set(t, (titleMap.get(t) || 0) + 1);
  });
  const titleNodes = [{ name: '职称', symbolSize: 40, itemStyle: { color: '#409EFF' } }];
  const titleLinks: any[] = [];
  Array.from(titleMap.entries())
    .sort((a, b) => b[1] - a[1])
    .forEach(([t, count]) => {
      titleNodes.push({ name: `${t}(${count})`, symbolSize: Math.min(30, 10 + count), itemStyle: { color: '#67C23A' } });
      titleLinks.push({ source: '职称', target: `${t}(${count})`, value: count, lineStyle: { width: Math.min(8, 2 + count / 10) } });
    });

  // 渲染图表
  const ageDom = document.getElementById('ageBarChart');
  if (ageDom) {
    const chart = echarts.init(ageDom);
    chart.setOption({
      tooltip: { trigger: 'axis' },
      legend: { data: ['男', '女'] },
      grid: { left: '3%', right: '4%', bottom: '3%', containLabel: true },
      xAxis: { type: 'category', data: ageBins.map((b) => b.label) },
      yAxis: { type: 'value' },
      series: [
        { name: '男', type: 'bar', data: maleSeries, itemStyle: { color: '#409EFF' } },
        { name: '女', type: 'bar', data: femaleSeries, itemStyle: { color: '#F56C6C' } }
      ]
    });
  }
  const genderDom = document.getElementById('genderDonutChart');
  if (genderDom) {
    const chart = echarts.init(genderDom);
    chart.setOption({
      tooltip: { trigger: 'item' },
      legend: { bottom: 0 },
      series: [
        {
          name: '性别',
          type: 'pie',
          radius: ['50%', '70%'],
          itemStyle: { borderRadius: 8, borderColor: '#fff', borderWidth: 2 },
          label: { formatter: '{b}: {d}%' },
          data: [
            { value: maleCount, name: '男', itemStyle: { color: '#409EFF' } },
            { value: femaleCount, name: '女', itemStyle: { color: '#F56C6C' } }
          ]
        }
      ]
    });
  }
  const deptDom = document.getElementById('departmentRoseChart');
  if (deptDom) {
    const chart = echarts.init(deptDom);
    const colors = [
      '#409EFF',
      '#67C23A',
      '#E6A23C',
      '#F56C6C',
      '#13c2c2',
      '#9254de',
      '#eb2f96',
      '#fa8c16',
      '#2f54eb',
      '#52c41a',
      '#fa541c',
      '#722ed1'
    ];
    const deptChildren = deptData.map((d, i) => ({ ...d, itemStyle: { color: colors[i % colors.length] } }));
    chart.setOption({
      tooltip: { trigger: 'item' },
      series: [
        {
          type: 'treemap',
          roam: false,
          breadcrumb: { show: false },
          label: { show: true, formatter: '{b}\n{c}' },
          itemStyle: { borderColor: '#fff', borderWidth: 2, borderRadius: 8 },
          levels: [{ itemStyle: { borderRadius: 8, gapWidth: 4 } }],
          data: [
            {
              name: '科室',
              children: deptChildren
            }
          ]
        }
      ]
    });
  }
  const titleDom = document.getElementById('titleChordChart');
  if (titleDom) {
    const chart = echarts.init(titleDom);
    const titles = Array.from(titleMap.entries()).sort((a, b) => b[1] - a[1]);
    const sunburstData = titles.map(([name, value]) => ({ name, value }));
    chart.setOption({
      tooltip: { trigger: 'item' },
      series: [
        {
          type: 'sunburst',
          radius: ['10%', '85%'],
          sort: null,
          emphasis: { focus: 'ancestor' },
          label: { rotate: 'radial' },
          data: sunburstData
        }
      ]
    });
  }
};

onMounted(() => {
  renderDashboard();
});
</script>

<style scoped>
.stat-card {
  text-align: center;
  padding: 20px;
  background-color: #ffffff;
  border-radius: 8px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
  border: 1px solid #e4e7ed;
}

.stat-card.clickable {
  cursor: pointer;
}

.click-hint {
  font-size: 12px;
  color: #909399;
  margin-top: 8px;
  opacity: 0.7;
}

.stat-card.clickable:hover .click-hint {
  opacity: 1;
  color: #409eff;
}

.chart-container {
  width: 100%;
  height: 260px;
}
.mt-2 {
  margin-top: 8px;
}
</style>
