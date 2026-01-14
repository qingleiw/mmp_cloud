<template>
  <div class="app-container">
    <!-- 页面标题 -->
    <div class="page-header mb-4">
      <h2 class="page-title">
        <i-ep-pie-chart class="title-icon"></i-ep-pie-chart>
        医疗仪表板
      </h2>
      <p class="page-description">实时展示医院医疗数据统计、患者状态监控和关键指标概览</p>
    </div>

    <!-- 今日概况 -->
    <el-card shadow="hover" class="stats-card mb-4">
      <template #header>
        <div class="flex items-center justify-between">
          <span class="card-title">
            <i-ep-data-analysis class="card-icon"></i-ep-data-analysis>
            今日概况
          </span>
          <div class="flex items-center gap-2">
            <el-select v-model="queryParams.deptId" placeholder="请选择科室" clearable size="small" style="width: 150px">
              <el-option v-for="dept in deptOptions" :key="dept.deptId" :label="dept.deptName" :value="dept.deptId" />
            </el-select>
            <el-date-picker
              v-model="queryParams.queryDate"
              type="date"
              placeholder="选择日期"
              format="YYYY-MM-DD"
              value-format="YYYY-MM-DD"
              size="small"
              style="width: 150px"
            />
            <el-button type="primary" size="small" icon="Refresh" @click="handleQuery">刷新</el-button>
          </div>
        </div>
      </template>
      <el-row :gutter="20" v-loading="loading">
        <!-- 第一行 -->
        <el-col :span="4">
          <div class="stat-card">
            <el-statistic title="新入" :value="medicalStats.newAdmissions" />
          </div>
        </el-col>
        <el-col :span="4">
          <div class="stat-card">
            <el-statistic title="在区" :value="medicalStats.inWard" />
          </div>
        </el-col>
        <el-col :span="4">
          <div class="stat-card">
            <el-statistic title="危重" :value="medicalStats.critical" />
          </div>
        </el-col>
        <el-col :span="4">
          <div class="stat-card">
            <el-statistic title="出区" :value="medicalStats.discharged" />
          </div>
        </el-col>
        <el-col :span="4">
          <div class="stat-card clickable" @click="handleDeathClick">
            <el-statistic title="死亡" :value="medicalStats.deaths" />
          </div>
        </el-col>

        <!-- 第二行 -->
        <el-col :span="4">
          <div class="stat-card">
            <el-statistic title="转入" :value="medicalStats.transfersIn" />
          </div>
        </el-col>
        <el-col :span="4">
          <div class="stat-card">
            <el-statistic title="转出" :value="medicalStats.transfersOut" />
          </div>
        </el-col>
        <el-col :span="4">
          <div class="stat-card">
            <el-statistic title="关注患者" :value="medicalStats.attentionPatients" />
          </div>
        </el-col>
        <el-col :span="4">
          <div class="stat-card">
            <el-statistic title="抢救" :value="medicalStats.rescues" />
          </div>
        </el-col>
        <el-col :span="4">
          <div class="stat-card">
            <el-statistic title="危急值" :value="medicalStats.criticalValues" />
          </div>
        </el-col>

        <!-- 第三行 -->
        <el-col :span="4">
          <div class="stat-card">
            <el-statistic title="病危" :value="medicalStats.criticallyIll" />
          </div>
        </el-col>
        <el-col :span="4">
          <div class="stat-card">
            <el-statistic title="病重" :value="medicalStats.seriouslyIll" />
          </div>
        </el-col>
        <el-col :span="4">
          <div class="stat-card">
            <el-statistic title="会诊" :value="medicalStats.consultations" />
          </div>
        </el-col>
        <el-col :span="4">
          <div class="stat-card">
            <el-statistic title="住院超30天" :value="medicalStats.longStayPatients" />
          </div>
        </el-col>
        <el-col :span="4">
          <div class="stat-card">
            <el-statistic title="三级手术" :value="medicalStats.level3Surgeries" />
          </div>
        </el-col>

        <!-- 第四行 -->
        <el-col :span="4">
          <div class="stat-card">
            <el-statistic title="四级手术" :value="medicalStats.level4Surgeries" />
          </div>
        </el-col>
        <el-col :span="4">
          <div class="stat-card">
            <el-statistic title="输血" :value="medicalStats.bloodTransfusions" />
          </div>
        </el-col>
        <el-col :span="4">
          <div class="stat-card">
            <el-statistic title="入径" :value="medicalStats.pathwayEntries" />
          </div>
        </el-col>
        <el-col :span="4">
          <div class="stat-card">
            <el-statistic title="抗菌药物" :value="medicalStats.antibioticUsage" />
          </div>
        </el-col>
        <el-col :span="4">
          <div class="stat-card">
            <el-statistic title="二次手术" :value="medicalStats.secondarySurgeries" />
          </div>
        </el-col>
      </el-row>
    </el-card>

    <!-- 待办任务和通知公告 -->
    <el-row :gutter="20">
      <!-- 待办任务 -->
      <el-col :xs="24" :md="12">
        <el-card shadow="hover" class="mb-[10px]">
          <template #header>
            <div class="flex items-center justify-between">
              <span>待办任务</span>
              <el-button type="primary" size="small" icon="Refresh" @click="loadTodoTasks">刷新</el-button>
            </div>
          </template>
          <div class="task-list">
            <div v-if="todoTasks.length === 0" class="no-data">
              <el-empty description="暂无待办任务"></el-empty>
            </div>
            <div v-else class="task-item" v-for="task in todoTasks" :key="task.id">
              <div class="task-content">
                <div class="task-title">{{ task.taskTitle }}</div>
                <div class="task-desc">{{ task.taskDescription }}</div>
                <div class="task-time">{{ task.assignTime }}</div>
              </div>
              <div class="task-actions">
                <el-button type="primary" size="small" @click="handleTask(task)">处理</el-button>
              </div>
            </div>
          </div>
        </el-card>
      </el-col>

      <!-- 通知公告 -->
      <el-col :xs="24" :md="12">
        <el-card shadow="hover" class="mb-[10px]">
          <template #header>
            <div class="flex items-center justify-between">
              <span>通知公告</span>
              <el-button type="primary" size="small" icon="Refresh" @click="loadAnnouncements">刷新</el-button>
            </div>
          </template>
          <div class="announcement-list">
            <div v-if="announcements.length === 0" class="no-data">
              <el-empty description="暂无通知公告"></el-empty>
            </div>
            <div v-else class="announcement-item" v-for="announcement in announcements" :key="announcement.id">
              <div class="announcement-content">
                <div class="announcement-title">{{ announcement.announcementTitle }}</div>
                <div class="announcement-desc">{{ announcement.announcementContent }}</div>
                <div class="announcement-time">{{ announcement.publishTime }}</div>
              </div>
              <div class="announcement-actions">
                <el-button type="primary" size="small" @click="viewAnnouncement(announcement)">查看</el-button>
              </div>
            </div>
          </div>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script setup name="MedicalDashboard" lang="ts">
import { ref, reactive, getCurrentInstance, onMounted, watch } from 'vue';
import { listDept } from '@/api/system/dept';
import { DeptVO } from '@/api/system/dept/types';
import { listTodoTask } from '@/api/system/todoTask';
import { TodoTaskVO } from '@/api/system/todoTask/types';
import { listAnnouncement } from '@/api/system/announcement';
import { AnnouncementVO } from '@/api/system/announcement/types';
import { listMedicalStats } from '@/api/system/medicalStats';
import { MedicalStatsVO } from '@/api/system/medicalStats/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

// 查询参数
const queryParams = reactive({
  deptId: undefined as number | undefined,
  queryDate: undefined as string | undefined
});

// 科室选项
const deptOptions = ref<DeptVO[]>([]);

// 加载状态
const loading = ref(false);

// 医疗统计数据
const medicalStats = reactive({
  newAdmissions: 0, // 新入
  inWard: 0, // 在区
  critical: 0, // 危重
  discharged: 0, // 出区
  deaths: 0, // 死亡
  transfersIn: 0, // 转入
  transfersOut: 0, // 转出
  attentionPatients: 0, // 关注患者
  rescues: 0, // 抢救
  criticalValues: 0, // 危急值
  criticallyIll: 0, // 病危
  seriouslyIll: 0, // 病重
  consultations: 0, // 会诊
  longStayPatients: 0, // 住院超30天
  level3Surgeries: 0, // 三级手术
  level4Surgeries: 0, // 四级手术
  bloodTransfusions: 0, // 输血
  pathwayEntries: 0, // 入径
  antibioticUsage: 0, // 抗菌药物
  secondarySurgeries: 0 // 二次手术
});

// 待办任务
const todoTasks = ref<TodoTaskVO[]>([]);

// 通知公告
const announcements = ref<AnnouncementVO[]>([]);

/** 加载科室数据 */
const loadDeptOptions = async () => {
  try {
    const res = await listDept();
    deptOptions.value = (res as any).data || [];
  } catch (error) {
    console.error('加载科室数据失败:', error);
  }
};

/** 加载医疗统计数据 */
const loadMedicalStats = async () => {
  try {
    // 构建查询参数
    const query: any = {
      pageNum: 1,
      pageSize: 1000 // 获取所有数据用于汇总
    };

    // 添加科室筛选
    if (queryParams.deptId) {
      query.deptId = queryParams.deptId;
    }

    // 添加日期筛选
    if (queryParams.queryDate) {
      query.statDate = queryParams.queryDate;
    }

    const res = await listMedicalStats(query);
    const statsList: MedicalStatsVO[] = (res as any).rows || [];

    // 如果有筛选条件，直接使用第一条数据
    if (queryParams.deptId || queryParams.queryDate) {
      if (statsList.length > 0) {
        const stats = statsList[0];
        medicalStats.newAdmissions = stats.newAdmissions || 0;
        medicalStats.inWard = stats.inWard || 0;
        medicalStats.critical = stats.critical || 0;
        medicalStats.discharged = stats.discharged || 0;
        medicalStats.deaths = stats.deaths || 0;
        medicalStats.transfersIn = stats.transfersIn || 0;
        medicalStats.transfersOut = stats.transfersOut || 0;
        medicalStats.attentionPatients = stats.attentionPatients || 0;
        medicalStats.rescues = stats.rescues || 0;
        medicalStats.criticalValues = stats.criticalValues || 0;
        medicalStats.criticallyIll = stats.criticallyIll || 0;
        medicalStats.seriouslyIll = stats.seriouslyIll || 0;
        medicalStats.consultations = stats.consultations || 0;
        medicalStats.longStayPatients = stats.longStayPatients || 0;
        medicalStats.level3Surgeries = stats.level3Surgeries || 0;
        medicalStats.level4Surgeries = stats.level4Surgeries || 0;
        medicalStats.bloodTransfusions = stats.bloodTransfusions || 0;
        medicalStats.pathwayEntries = stats.pathwayEntries || 0;
        medicalStats.antibioticUsage = stats.antibioticUsage || 0;
        medicalStats.secondarySurgeries = stats.secondarySurgeries || 0;
      } else {
        // 没有数据时重置为0
        resetMedicalStats();
      }
    } else {
      // 没有筛选条件时，汇总所有数据
      const totalStats = statsList.reduce(
        (acc, curr) => {
          acc.newAdmissions += curr.newAdmissions || 0;
          acc.inWard += curr.inWard || 0;
          acc.critical += curr.critical || 0;
          acc.discharged += curr.discharged || 0;
          acc.deaths += curr.deaths || 0;
          acc.transfersIn += curr.transfersIn || 0;
          acc.transfersOut += curr.transfersOut || 0;
          acc.attentionPatients += curr.attentionPatients || 0;
          acc.rescues += curr.rescues || 0;
          acc.criticalValues += curr.criticalValues || 0;
          acc.criticallyIll += curr.criticallyIll || 0;
          acc.seriouslyIll += curr.seriouslyIll || 0;
          acc.consultations += curr.consultations || 0;
          acc.longStayPatients += curr.longStayPatients || 0;
          acc.level3Surgeries += curr.level3Surgeries || 0;
          acc.level4Surgeries += curr.level4Surgeries || 0;
          acc.bloodTransfusions += curr.bloodTransfusions || 0;
          acc.pathwayEntries += curr.pathwayEntries || 0;
          acc.antibioticUsage += curr.antibioticUsage || 0;
          acc.secondarySurgeries += curr.secondarySurgeries || 0;
          return acc;
        },
        {
          newAdmissions: 0,
          inWard: 0,
          critical: 0,
          discharged: 0,
          deaths: 0,
          transfersIn: 0,
          transfersOut: 0,
          attentionPatients: 0,
          rescues: 0,
          criticalValues: 0,
          criticallyIll: 0,
          seriouslyIll: 0,
          consultations: 0,
          longStayPatients: 0,
          level3Surgeries: 0,
          level4Surgeries: 0,
          bloodTransfusions: 0,
          pathwayEntries: 0,
          antibioticUsage: 0,
          secondarySurgeries: 0
        }
      );

      Object.assign(medicalStats, totalStats);
    }
  } catch (error) {
    console.error('加载医疗统计数据失败:', error);
    // 发生错误时重置为0
    resetMedicalStats();
  }
};

/** 重置医疗统计数据 */
const resetMedicalStats = () => {
  medicalStats.newAdmissions = 0;
  medicalStats.inWard = 0;
  medicalStats.critical = 0;
  medicalStats.discharged = 0;
  medicalStats.deaths = 0;
  medicalStats.transfersIn = 0;
  medicalStats.transfersOut = 0;
  medicalStats.attentionPatients = 0;
  medicalStats.rescues = 0;
  medicalStats.criticalValues = 0;
  medicalStats.criticallyIll = 0;
  medicalStats.seriouslyIll = 0;
  medicalStats.consultations = 0;
  medicalStats.longStayPatients = 0;
  medicalStats.level3Surgeries = 0;
  medicalStats.level4Surgeries = 0;
  medicalStats.bloodTransfusions = 0;
  medicalStats.pathwayEntries = 0;
  medicalStats.antibioticUsage = 0;
  medicalStats.secondarySurgeries = 0;
};

/** 加载待办任务 */
const loadTodoTasks = async () => {
  try {
    const query: any = { pageNum: 1, pageSize: 10 };

    // 如果选择了科室，可以按科室筛选任务（如果后端支持）
    // 这里暂时不过滤，显示所有任务
    const res = await listTodoTask(query);
    todoTasks.value = (res as any).rows || [];
  } catch (error) {
    console.error('加载待办任务失败:', error);
    todoTasks.value = [];
  }
};

/** 加载通知公告 */
const loadAnnouncements = async () => {
  try {
    const query: any = { pageNum: 1, pageSize: 10 };

    // 如果选择了科室，可以按科室筛选公告（如果后端支持）
    // 这里暂时不过滤，显示所有公告
    const res = await listAnnouncement(query);
    announcements.value = (res as any).rows || [];
  } catch (error) {
    console.error('加载通知公告失败:', error);
    announcements.value = [];
  }
};

/** 查询 */
const handleQuery = async () => {
  loading.value = true;
  try {
    await Promise.all([loadMedicalStats(), loadTodoTasks(), loadAnnouncements()]);
  } finally {
    loading.value = false;
  }
};

/** 处理任务 */
const handleTask = (task: TodoTaskVO) => {
  // 根据任务类型跳转到相应页面
  proxy?.$router.push('/system/todo-task');
};

/** 查看公告 */
const viewAnnouncement = (announcement: AnnouncementVO) => {
  proxy?.$router.push('/system/announcement');
};

/** 处理死亡病例点击 */
const handleDeathClick = () => {
  proxy?.$router.push('/system/death-case-discussion');
};

// 监听查询参数变化，自动筛选数据
watch(
  () => queryParams.deptId,
  async (newVal, oldVal) => {
    if (newVal !== oldVal) {
      // 添加小延迟避免过于频繁的API调用
      setTimeout(async () => {
        await handleQuery();
      }, 300);
    }
  }
);

watch(
  () => queryParams.queryDate,
  async (newVal, oldVal) => {
    if (newVal !== oldVal) {
      // 添加小延迟避免过于频繁的API调用
      setTimeout(async () => {
        await handleQuery();
      }, 300);
    }
  }
);

// 页面初始化
onMounted(() => {
  loadDeptOptions();
  loadMedicalStats();
  loadTodoTasks();
  loadAnnouncements();
});
</script>

<style scoped>
.stat-card {
  border-radius: 8px;
  padding: 20px;
  text-align: center;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
  line-height: 12px;
}

.task-list {
  max-height: 400px;
  overflow-y: auto;
}

.task-item {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 12px;
  border-bottom: 1px solid #f0f0f0;
}

.task-item:hover {
  background-color: #f5f7fa;
}

.task-content {
  flex: 1;
}

.task-title {
  font-weight: 500;
  color: #303133;
  margin-bottom: 4px;
}

.task-desc {
  color: #606266;
  font-size: 14px;
  margin-bottom: 4px;
}

.task-time {
  color: #909399;
  font-size: 12px;
}

.task-actions {
  margin-left: 12px;
}

.announcement-list {
  max-height: 400px;
  overflow-y: auto;
}

.announcement-item {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 12px;
  border-bottom: 1px solid #f0f0f0;
}

.announcement-item:hover {
  background-color: #f5f7fa;
}

.announcement-content {
  flex: 1;
}

.announcement-title {
  font-weight: 500;
  color: #303133;
  margin-bottom: 4px;
}

.announcement-desc {
  color: #606266;
  font-size: 14px;
  margin-bottom: 4px;
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
}

.announcement-time {
  color: #909399;
  font-size: 12px;
}

.announcement-actions {
  margin-left: 12px;
}

.no-data {
  text-align: center;
  padding: 40px 0;
}
</style>

<style lang="scss" scoped>
.app-container {
  padding: 20px;
  background-color: #f5f5f5;
  min-height: calc(100vh - 84px);
}

.page-header {
  margin-bottom: 24px;

  .page-title {
    font-size: 24px;
    font-weight: 600;
    color: #1d2129;
    margin-bottom: 8px;
    display: flex;
    align-items: center;
    gap: 8px;

    .title-icon {
      color: #409eff;
    }
  }

  .page-description {
    color: #86909c;
    font-size: 14px;
  }
}

.stats-card {
  border-radius: 8px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);

  :deep(.el-card__header) {
    .card-title {
      font-weight: 600;
      color: #1d2129;
      display: flex;
      align-items: center;
      gap: 6px;

      .card-icon {
        color: #409eff;
      }
    }
  }
}

.stat-card {
  background-color: #ffffff;
  border-radius: 8px;
  padding: 20px;
  text-align: center;
  color: #1d2129;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
  border: 1px solid #e4e7ed;

  :deep(.el-statistic) {
    .el-statistic__content {
      font-size: 28px;
      font-weight: 600;
      color: #409eff;
    }

    .el-statistic__title {
      font-size: 14px;
      color: #86909c;
    }
  }

  &.clickable {
    cursor: pointer;
    transition: all 0.3s ease;

    &:hover {
      box-shadow: 0 4px 12px rgba(0, 0, 0, 0.15);
      transform: translateY(-2px);
    }
  }
}

.task-card,
.chart-card,
.announcement-card {
  border-radius: 8px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
  height: 400px;

  :deep(.el-card__header) {
    font-weight: 600;
    color: #1d2129;
  }
}

.task-list {
  height: 320px;
  overflow-y: auto;
}

.announcement-list {
  height: 320px;
  overflow-y: auto;
}

// 响应式设计
@media (max-width: 768px) {
  .app-container {
    padding: 12px;
  }

  .page-header {
    .page-title {
      font-size: 20px;
    }
  }

  .stat-card {
    padding: 15px;

    :deep(.el-statistic) {
      .el-statistic__content {
        font-size: 24px;
      }
    }
  }
}

@media (max-width: 576px) {
  // 在超小屏幕上“今日概况”每行显示3个
  .stats-card :deep(.el-col) {
    flex: 0 0 33.333% !important;
    max-width: 33.333% !important;
  }
}

// 强制“今日概况”统计模块为5列布局
.stats-card :deep(.el-row .el-col) {
  flex: 0 0 20% !important;
  max-width: 20% !important;
}
</style>
