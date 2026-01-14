<template>
  <div class="app-container home" :style="{ color: textColor, padding: sidebarOpened ? '20px' : '20px 20px 20px 120px' }">
    <!-- 欢迎区域 -->
    <div class="welcome-section">
      <h2>欢迎使用北京积水潭医院医务管理平台</h2>
      <p class="welcome-time">{{ currentTime }}</p>
    </div>

    <!-- 统计数据卡片 -->
    <el-row :gutter="20" class="stats-row">
      <el-col :xs="24" :sm="12" :md="6">
        <el-card class="stats-card" shadow="hover">
          <div class="stats-content">
            <div class="stats-icon">
              <el-icon size="32" color="#409EFF"><Calendar /></el-icon>
            </div>
            <div class="stats-info">
              <div class="stats-number">{{ stats.todaySurgeries }}</div>
              <div class="stats-label">今日手术</div>
            </div>
          </div>
        </el-card>
      </el-col>
      <el-col :xs="24" :sm="12" :md="6">
        <el-card class="stats-card" shadow="hover">
          <div class="stats-content">
            <div class="stats-icon">
              <el-icon size="32" color="#67C23A"><User /></el-icon>
            </div>
            <div class="stats-info">
              <div class="stats-number">{{ stats.totalDoctors }}</div>
              <div class="stats-label">医生总数</div>
            </div>
          </div>
        </el-card>
      </el-col>
      <el-col :xs="24" :sm="12" :md="6">
        <el-card class="stats-card" shadow="hover">
          <div class="stats-content">
            <div class="stats-icon">
              <el-icon size="32" color="#E6A23C"><Monitor /></el-icon>
            </div>
            <div class="stats-info">
              <div class="stats-number">{{ stats.bedOccupancy }}%</div>
              <div class="stats-label">床位占用率</div>
            </div>
          </div>
        </el-card>
      </el-col>
      <el-col :xs="24" :sm="12" :md="6">
        <el-card class="stats-card" shadow="hover">
          <div class="stats-content">
            <div class="stats-icon">
              <el-icon size="32" color="#F56C6C"><Bell /></el-icon>
            </div>
            <div class="stats-info">
              <div class="stats-number">{{ stats.pendingTasks }}</div>
              <div class="stats-label">待处理任务</div>
            </div>
          </div>
        </el-card>
      </el-col>
    </el-row>

    <!-- 医疗仪表板 - 手术室状态监控 -->
    <el-row :gutter="20" class="dashboard-row">
      <el-col :xs="24" :lg="12">
        <el-card class="dashboard-card" shadow="never">
          <template #header>
            <div class="card-header">
              <el-icon><Monitor /></el-icon>
              <span>手术室状态监控</span>
            </div>
          </template>
          <div class="operating-rooms">
            <div v-for="(room, index) in operatingRooms" :key="index" class="room-item">
              <div class="room-info">
                <span class="room-name">{{ room.name }}</span>
                <el-tag :type="room.status === 'occupied' ? 'warning' : room.status === 'available' ? 'success' : 'info'"
                        size="small">
                  {{ room.statusText }}
                </el-tag>
              </div>
              <div class="room-details">
                <span v-if="room.patient">{{ room.patient }}</span>
                <span v-if="room.surgeon">{{ room.surgeon }}</span>
              </div>
            </div>
          </div>
        </el-card>
      </el-col>

      <el-col :xs="24" :lg="12">
        <el-card class="dashboard-card" shadow="never">
          <template #header>
            <div class="card-header">
              <el-icon><TrendCharts /></el-icon>
              <span>今日患者流量统计</span>
            </div>
          </template>
          <div class="patient-flow">
            <div class="flow-item">
              <div class="flow-label">今日入院</div>
              <div class="flow-value">{{ patientFlow.admissions }}</div>
              <div class="flow-change positive">+12%</div>
            </div>
            <div class="flow-item">
              <div class="flow-label">今日出院</div>
              <div class="flow-value">{{ patientFlow.discharges }}</div>
              <div class="flow-change negative">-5%</div>
            </div>
            <div class="flow-item">
              <div class="flow-label">当前在院</div>
              <div class="flow-value">{{ patientFlow.current }}</div>
              <div class="flow-change neutral">+2%</div>
            </div>
          </div>
        </el-card>
      </el-col>
    </el-row>

    <!-- 医疗仪表板 - 科室工作量统计 -->
    <el-row :gutter="20" class="dashboard-row">
      <el-col :xs="24" :lg="8">
        <el-card class="dashboard-card" shadow="never">
          <template #header>
            <div class="card-header">
              <el-icon><PieChart /></el-icon>
              <span>科室工作量统计</span>
            </div>
          </template>
          <div class="department-workload">
            <div v-for="(dept, index) in departmentWorkload" :key="index" class="workload-item">
              <div class="dept-name">{{ dept.name }}</div>
              <el-progress :percentage="dept.percentage" :stroke-width="8" :show-text="false" />
              <div class="workload-count">{{ dept.count }}人</div>
            </div>
          </div>
        </el-card>
      </el-col>

      <el-col :xs="24" :lg="8">
        <el-card class="dashboard-card" shadow="never">
          <template #header>
            <div class="card-header">
              <el-icon><Calendar /></el-icon>
              <span>今日排班概览</span>
            </div>
          </template>
          <div class="schedule-overview">
            <div class="shift-item">
              <div class="shift-time">早班 (8:00-16:00)</div>
              <div class="shift-count">{{ scheduleOverview.morning }}人</div>
            </div>
            <div class="shift-item">
              <div class="shift-time">晚班 (16:00-24:00)</div>
              <div class="shift-count">{{ scheduleOverview.evening }}人</div>
            </div>
            <div class="shift-item">
              <div class="shift-time">夜班 (24:00-8:00)</div>
              <div class="shift-count">{{ scheduleOverview.night }}人</div>
            </div>
          </div>
        </el-card>
      </el-col>

      <el-col :xs="24" :lg="8">
        <el-card class="dashboard-card" shadow="never">
          <template #header>
            <div class="card-header">
              <el-icon><Warning /></el-icon>
              <span>紧急提醒</span>
            </div>
          </template>
          <div class="emergency-alerts">
            <div v-for="(alert, index) in emergencyAlerts" :key="index" class="alert-item">
              <el-tag :type="alert.level" size="small">{{ alert.levelText }}</el-tag>
              <span class="alert-message">{{ alert.message }}</span>
              <span class="alert-time">{{ alert.time }}</span>
            </div>
          </div>
        </el-card>
      </el-col>
    </el-row>

    <!-- 医疗仪表板 - 设备状态监控 -->
    <el-row :gutter="20" class="dashboard-row">
      <el-col :xs="24">
        <el-card class="dashboard-card" shadow="never">
          <template #header>
            <div class="card-header">
              <el-icon><Setting /></el-icon>
              <span>医疗设备状态监控</span>
            </div>
          </template>
          <div class="equipment-grid">
            <div v-for="(equipment, index) in equipmentStatus" :key="index" class="equipment-item">
              <div class="equipment-icon">
                <el-icon :size="24" :color="equipment.status === 'normal' ? '#67C23A' : equipment.status === 'warning' ? '#E6A23C' : '#F56C6C'">
                  <component :is="equipment.icon" />
                </el-icon>
              </div>
              <div class="equipment-info">
                <div class="equipment-name">{{ equipment.name }}</div>
                <div class="equipment-location">{{ equipment.location }}</div>
              </div>
              <el-tag :type="equipment.status === 'normal' ? 'success' : equipment.status === 'warning' ? 'warning' : 'danger'"
                      size="small">
                {{ equipment.statusText }}
              </el-tag>
            </div>
          </div>
        </el-card>
      </el-col>
    </el-row>

    <!-- 公告通知和最新动态 -->
    <el-row :gutter="20" class="bottom-row">
      <el-col :xs="24" :md="12">
        <el-card class="notice-card" shadow="never">
          <template #header>
            <div class="card-header">
              <el-icon><Bell /></el-icon>
              <span>系统公告</span>
            </div>
          </template>
          <div class="notice-list">
            <div v-for="(notice, index) in notices" :key="index" class="notice-item">
              <el-tag :type="notice.type" size="small">{{ notice.category }}</el-tag>
              <span class="notice-title">{{ notice.title }}</span>
              <span class="notice-time">{{ notice.time }}</span>
            </div>
          </div>
        </el-card>
      </el-col>
      <el-col :xs="24" :md="12">
        <el-card class="activity-card" shadow="never">
          <template #header>
            <div class="card-header">
              <el-icon><Clock /></el-icon>
              <span>最新动态</span>
            </div>
          </template>
          <div class="activity-list">
            <div v-for="(activity, index) in activities" :key="index" class="activity-item">
              <div class="activity-avatar">
                <el-avatar :size="32" :src="activity.avatar">{{ activity.user[0] }}</el-avatar>
              </div>
              <div class="activity-content">
                <div class="activity-text">
                  <span class="activity-user">{{ activity.user }}</span>
                  {{ activity.action }}
                  <span class="activity-target">{{ activity.target }}</span>
                </div>
                <div class="activity-time">{{ activity.time }}</div>
              </div>
            </div>
          </div>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script setup name="Index" lang="ts">
import { useSettingsStore } from '@/store/modules/settings';
import { useAppStore } from '@/store/modules/app';
import { Calendar, User, Monitor, Bell, Plus, Document, Clock, TrendCharts, PieChart, Warning, Setting } from '@element-plus/icons-vue';

const settingsStore = useSettingsStore();
const appStore = useAppStore();
const sideTheme = computed(() => settingsStore.sideTheme);
const sidebarOpened = computed(() => appStore.sidebar.opened);

const textColor = computed(() => (sideTheme.value === 'theme-dark' ? '#bfcbd9' : 'rgba(0, 0, 0, 0.7)'));

// 当前时间
const currentTime = ref('');
const updateTime = () => {
  const now = new Date();
  currentTime.value = now.toLocaleString('zh-CN', {
    year: 'numeric',
    month: 'long',
    day: 'numeric',
    weekday: 'long',
    hour: '2-digit',
    minute: '2-digit'
  });
};

// 统计数据
const stats = reactive({
  todaySurgeries: 12,
  totalDoctors: 156,
  bedOccupancy: 78,
  pendingTasks: 8
});

// 手术室状态
const operatingRooms = ref([
  { name: '手术室A01', status: 'occupied', statusText: '手术中', patient: '张三', surgeon: '李主任' },
  { name: '手术室A02', status: 'available', statusText: '空闲', patient: '', surgeon: '' },
  { name: '手术室A03', status: 'preparing', statusText: '准备中', patient: '王五', surgeon: '赵医生' },
  { name: '手术室B01', status: 'occupied', statusText: '手术中', patient: '刘六', surgeon: '陈主任' }
]);

// 患者流量统计
const patientFlow = reactive({
  admissions: 24,
  discharges: 18,
  current: 156
});

// 科室工作量统计
const departmentWorkload = ref([
  { name: '骨科', count: 45, percentage: 85 },
  { name: '外科', count: 32, percentage: 72 },
  { name: '内科', count: 28, percentage: 65 },
  { name: '妇产科', count: 22, percentage: 58 }
]);

// 今日排班概览
const scheduleOverview = reactive({
  morning: 89,
  evening: 67,
  night: 34
});

// 紧急提醒
const emergencyAlerts = ref([
  { level: 'danger', levelText: '紧急', message: '手术室A01设备故障', time: '10:30' },
  { level: 'warning', levelText: '警告', message: '药品库存不足提醒', time: '09:15' },
  { level: 'info', levelText: '通知', message: '新患者入院通知', time: '08:45' }
]);

// 医疗设备状态
const equipmentStatus = ref([
  { name: 'CT扫描仪', location: '放射科', status: 'normal', statusText: '正常', icon: 'Monitor' },
  { name: '心电图机', location: '心内科', status: 'normal', statusText: '正常', icon: 'Monitor' },
  { name: '呼吸机', location: 'ICU', status: 'warning', statusText: '维护中', icon: 'Setting' },
  { name: '手术灯', location: '手术室A01', status: 'normal', statusText: '正常', icon: 'Monitor' },
  { name: '监护仪', location: '重症监护室', status: 'error', statusText: '故障', icon: 'Warning' },
  { name: 'X光机', location: '放射科', status: 'normal', statusText: '正常', icon: 'Monitor' }
]);

// 公告通知
const notices = ref([
  {
    category: '系统',
    title: '系统维护通知',
    time: '2024-01-14 10:30',
    type: 'warning'
  },
  {
    category: '医疗',
    title: '新版手术流程上线',
    time: '2024-01-13 15:20',
    type: 'success'
  },
  {
    category: '公告',
    title: '春节放假安排',
    time: '2024-01-12 09:00',
    type: 'info'
  }
]);

// 最新动态
const activities = ref([
  {
    user: '张医生',
    action: '完成了',
    target: '心脏手术记录',
    time: '5分钟前',
    avatar: ''
  },
  {
    user: '李护士',
    action: '更新了',
    target: '患者信息',
    time: '10分钟前',
    avatar: ''
  },
  {
    user: '王主任',
    action: '审核了',
    target: '手术申请',
    time: '15分钟前',
    avatar: ''
  }
]);

// 快捷操作
const handleQuickAction = (action: string) => {
  switch (action) {
    case 'surgery':
      // 跳转到新增手术页面
      console.log('新增手术');
      break;
    case 'patient':
      // 跳转到患者管理页面
      console.log('患者管理');
      break;
    case 'report':
      // 跳转到报告查询页面
      console.log('报告查询');
      break;
  }
};

const goTarget = (url: string) => {
  window.open(url, '__blank');
};

onMounted(() => {
  updateTime();
  // 每分钟更新一次时间
  setInterval(updateTime, 60000);
});
</script>

<style lang="scss" scoped>
.home {
  font-family: 'open sans', 'Helvetica Neue', Helvetica, Arial, sans-serif;
  color: var(--current-color);

  .welcome-section {
    margin-bottom: 30px;
    text-align: center;

    h2 {
      color: #409EFF;
      font-size: 28px;
      font-weight: 500;
      margin-bottom: 10px;
    }

    .welcome-time {
      color: #666;
      font-size: 16px;
      margin: 0;
    }
  }

  .stats-row {
    margin-bottom: 30px;

    .stats-card {
      height: 120px;
      cursor: pointer;
      transition: all 0.3s ease;

      &:hover {
        transform: translateY(-5px);
        box-shadow: 0 8px 25px rgba(0, 0, 0, 0.15);
      }

      .stats-content {
        display: flex;
        align-items: center;
        height: 100%;

        .stats-icon {
          margin-right: 20px;
        }

        .stats-info {
          .stats-number {
            font-size: 32px;
            font-weight: bold;
            color: #409EFF;
            line-height: 1;
            margin-bottom: 5px;
          }

          .stats-label {
            font-size: 14px;
            color: #666;
            font-weight: 500;
          }
        }
      }
    }
  }

  .quick-actions-row {
    margin-bottom: 30px;

    .action-card {
      height: 120px;
      cursor: pointer;
      transition: all 0.3s ease;

      &:hover {
        transform: translateY(-5px);
        box-shadow: 0 8px 25px rgba(0, 0, 0, 0.15);
      }

      .action-content {
        display: flex;
        align-items: center;
        height: 100%;
        padding: 20px;

        .action-text {
          margin-left: 20px;

          h4 {
            margin: 0 0 8px 0;
            font-size: 18px;
            font-weight: 500;
            color: #303133;
          }

          p {
            margin: 0;
            font-size: 14px;
            color: #909399;
          }
        }
      }
    }
  }

  .bottom-row {
    .notice-card,
    .activity-card {
      height: 400px;

      .card-header {
        display: flex;
        align-items: center;

        .el-icon {
          margin-right: 8px;
          color: #409EFF;
        }

        span {
          font-weight: 500;
          color: #303133;
        }
      }
    }

    .notice-list {
      .notice-item {
        display: flex;
        align-items: center;
        padding: 12px 0;
        border-bottom: 1px solid #f0f0f0;

        &:last-child {
          border-bottom: none;
        }

        .notice-title {
          flex: 1;
          margin-left: 12px;
          font-size: 14px;
          color: #303133;
        }

        .notice-time {
          font-size: 12px;
          color: #909399;
        }
      }
    }

    .activity-list {
      .activity-item {
        display: flex;
        align-items: flex-start;
        padding: 16px 0;
        border-bottom: 1px solid #f0f0f0;

        &:last-child {
          border-bottom: none;
        }

        .activity-avatar {
          margin-right: 12px;
        }

        .activity-content {
          flex: 1;

          .activity-text {
            font-size: 14px;
            color: #303133;
            line-height: 1.5;
            margin-bottom: 4px;

            .activity-user {
              font-weight: 500;
              color: #409EFF;
            }

            .activity-target {
              font-weight: 500;
              color: #67C23A;
            }
          }

          .activity-time {
            font-size: 12px;
            color: #909399;
          }
        }
      }
    }
  }

  // 医疗仪表板样式
  .dashboard-row {
    margin-bottom: 30px;

    .dashboard-card {
      height: 100%;

      .card-header {
        display: flex;
        align-items: center;
        gap: 8px;
        font-weight: 600;
        color: #409EFF;

        .el-icon {
          color: #409EFF;
        }
      }
    }
  }

  // 手术室状态监控
  .operating-rooms {
    .room-item {
      display: flex;
      justify-content: space-between;
      align-items: center;
      padding: 12px 0;
      border-bottom: 1px solid #f0f0f0;

      &:last-child {
        border-bottom: none;
      }

      .room-info {
        display: flex;
        align-items: center;
        gap: 12px;

        .room-name {
          font-weight: 500;
          color: #303133;
        }
      }

      .room-details {
        display: flex;
        flex-direction: column;
        align-items: flex-end;
        font-size: 12px;
        color: #909399;
      }
    }
  }

  // 患者流量统计
  .patient-flow {
    display: flex;
    justify-content: space-around;
    gap: 20px;

    .flow-item {
      text-align: center;
      flex: 1;

      .flow-label {
        font-size: 14px;
        color: #909399;
        margin-bottom: 8px;
      }

      .flow-value {
        font-size: 24px;
        font-weight: bold;
        color: #409EFF;
        margin-bottom: 4px;
      }

      .flow-change {
        font-size: 12px;
        font-weight: 500;

        &.positive {
          color: #67C23A;
        }

        &.negative {
          color: #F56C6C;
        }

        &.neutral {
          color: #E6A23C;
        }
      }
    }
  }

  // 科室工作量统计
  .department-workload {
    .workload-item {
      display: flex;
      align-items: center;
      gap: 12px;
      margin-bottom: 16px;

      &:last-child {
        margin-bottom: 0;
      }

      .dept-name {
        min-width: 60px;
        font-size: 14px;
        color: #303133;
      }

      .workload-count {
        min-width: 40px;
        text-align: right;
        font-size: 14px;
        color: #409EFF;
        font-weight: 500;
      }
    }
  }

  // 今日排班概览
  .schedule-overview {
    .shift-item {
      display: flex;
      justify-content: space-between;
      align-items: center;
      padding: 12px 0;
      border-bottom: 1px solid #f0f0f0;

      &:last-child {
        border-bottom: none;
      }

      .shift-time {
        font-size: 14px;
        color: #303133;
      }

      .shift-count {
        font-size: 16px;
        font-weight: 500;
        color: #409EFF;
      }
    }
  }

  // 紧急提醒
  .emergency-alerts {
    .alert-item {
      display: flex;
      align-items: center;
      gap: 12px;
      padding: 8px 0;
      border-bottom: 1px solid #f0f0f0;

      &:last-child {
        border-bottom: none;
      }

      .alert-message {
        flex: 1;
        font-size: 14px;
        color: #303133;
      }

      .alert-time {
        font-size: 12px;
        color: #909399;
      }
    }
  }

  // 医疗设备状态监控
  .equipment-grid {
    display: grid;
    grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
    gap: 16px;

    .equipment-item {
      display: flex;
      align-items: center;
      gap: 12px;
      padding: 12px;
      border: 1px solid #e4e7ed;
      border-radius: 8px;
      background: #fafafa;

      .equipment-icon {
        flex-shrink: 0;
      }

      .equipment-info {
        flex: 1;

        .equipment-name {
          font-size: 14px;
          font-weight: 500;
          color: #303133;
          margin-bottom: 2px;
        }

        .equipment-location {
          font-size: 12px;
          color: #909399;
        }
      }
    }
  }

  // 响应式设计
  @media (max-width: 768px) {
    .welcome-section h2 {
      font-size: 24px;
    }

    .stats-card,
    .action-card {
      height: 100px;
      margin-bottom: 20px;

      .stats-content,
      .action-content {
        flex-direction: column;
        text-align: center;

        .stats-icon,
        .action-text {
          margin: 0;
        }
      }
    }

    // 医疗仪表板移动端样式
    .patient-flow {
      flex-direction: column;
      gap: 16px;

      .flow-item {
        padding: 12px;
        background: #f8f9fa;
        border-radius: 8px;
      }
    }

    .equipment-grid {
      grid-template-columns: 1fr;
      gap: 12px;

      .equipment-item {
        padding: 10px;
      }
    }

    .operating-rooms .room-item {
      flex-direction: column;
      align-items: flex-start;
      gap: 8px;

      .room-details {
        align-items: flex-start;
      }
    }
  }
}
</style>
