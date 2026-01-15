import { SearchConfigManager, SearchFieldGroup } from '../../searchConfig';

// 急诊分诊记录搜索配置
export function createEmergencyTriageRecordSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'patientName', label: '患者姓名', type: 'input', placeholder: '请输入患者姓名' },
        { prop: 'triageNo', label: '分诊号', type: 'input', placeholder: '请输入分诊号' }
      ]
    },
    {
      name: 'triage',
      label: '分诊信息',
      fields: [
        { prop: 'triageLevel', label: '分诊级别', type: 'select', placeholder: '请选择分诊级别' },
        { prop: 'triageDoctor', label: '分诊医生', type: 'input', placeholder: '请输入分诊医生' }
      ]
    },
    {
      name: 'time',
      label: '时间范围',
      fields: [
        { prop: 'arrivalTime', label: '到达时间', type: 'daterange', placeholder: '请选择到达时间范围' },
        { prop: 'triageTime', label: '分诊时间', type: 'daterange', placeholder: '请选择分诊时间范围' }
      ]
    },
    {
      name: 'treatment',
      label: '治疗信息',
      fields: [
        { prop: 'treatmentArea', label: '治疗区域', type: 'input', placeholder: '请输入治疗区域' },
        { prop: 'treatmentDoctor', label: '治疗医生', type: 'input', placeholder: '请输入治疗医生' }
      ]
    }
  ];

  return new SearchConfigManager('emergencyTriageRecord', searchFieldGroups);
}

// 急诊抢救记录搜索配置
export function createEmergencyRescueRecordSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'patientName', label: '患者姓名', type: 'input', placeholder: '请输入患者姓名' },
        { prop: 'rescueNo', label: '抢救编号', type: 'input', placeholder: '请输入抢救编号' }
      ]
    },
    {
      name: 'team',
      label: '抢救团队',
      fields: [
        { prop: 'rescueLeader', label: '抢救组长', type: 'input', placeholder: '请输入抢救组长' }
      ]
    },
    {
      name: 'condition',
      label: '病情信息',
      fields: [
        { prop: 'criticalLevel', label: '危重程度', type: 'select', placeholder: '请选择危重程度' }
      ]
    },
    {
      name: 'time',
      label: '时间范围',
      fields: [
        { prop: 'rescueStartTime', label: '抢救开始时间', type: 'daterange', placeholder: '请选择抢救时间范围' }
      ]
    },
    {
      name: 'outcome',
      label: '抢救结局',
      fields: [
        { prop: 'rescueResult', label: '抢救结果', type: 'select', placeholder: '请选择抢救结果' }
      ]
    }
  ];

  return new SearchConfigManager('emergencyRescueRecord', searchFieldGroups);
}

// 急诊转诊记录搜索配置
export function createEmergencyTransferRecordSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'patientName', label: '患者姓名', type: 'input', placeholder: '请输入患者姓名' },
        { prop: 'transferNo', label: '转诊编号', type: 'input', placeholder: '请输入转诊编号' }
      ]
    },
    {
      name: 'transfer',
      label: '转诊信息',
      fields: [
        { prop: 'transferFrom', label: '转出医院', type: 'input', placeholder: '请输入转出医院' },
        { prop: 'transferTo', label: '转入医院', type: 'input', placeholder: '请输入转入医院' },
        { prop: 'transferLevel', label: '转诊级别', type: 'select', placeholder: '请选择转诊级别' }
      ]
    },
    {
      name: 'time',
      label: '时间范围',
      fields: [
        { prop: 'transferTime', label: '转诊时间', type: 'daterange', placeholder: '请选择转诊时间范围' }
      ]
    },
    {
      name: 'transport',
      label: '转运信息',
      fields: [
        { prop: 'transportMethod', label: '转运方式', type: 'select', placeholder: '请选择转运方式' }
      ]
    }
  ];

  return new SearchConfigManager('emergencyTransferRecord', searchFieldGroups);
}

// 急诊死亡记录搜索配置
export function createEmergencyDeathRecordSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'patientName', label: '患者姓名', type: 'input', placeholder: '请输入患者姓名' },
        { prop: 'deathNo', label: '死亡编号', type: 'input', placeholder: '请输入死亡编号' }
      ]
    },
    {
      name: 'diagnosis',
      label: '诊断信息',
      fields: [
        { prop: 'deathDiagnosis', label: '死亡诊断', type: 'input', placeholder: '请输入死亡诊断' },
        { prop: 'underlyingCause', label: '根本死因', type: 'input', placeholder: '请输入根本死因' }
      ]
    },
    {
      name: 'circumstances',
      label: '死亡情况',
      fields: [
        { prop: 'deathPlace', label: '死亡地点', type: 'input', placeholder: '请输入死亡地点' },
        { prop: 'autopsyRequired', label: '是否需要尸检', type: 'select', placeholder: '请选择是否需要尸检' }
      ]
    },
    {
      name: 'time',
      label: '时间范围',
      fields: [
        { prop: 'deathTime', label: '死亡时间', type: 'daterange', placeholder: '请选择死亡时间范围' }
      ]
    }
  ];

  return new SearchConfigManager('emergencyDeathRecord', searchFieldGroups);
}

// 急诊工作量统计搜索配置
export function createEmergencyWorkloadStatisticsSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'departmentName', label: '科室名称', type: 'input', placeholder: '请输入科室名称' }
      ]
    },
    {
      name: 'time',
      label: '时间范围',
      fields: [
        { prop: 'statisticsDate', label: '统计日期', type: 'daterange', placeholder: '请选择统计日期范围' }
      ]
    },
    {
      name: 'workload',
      label: '工作量范围',
      fields: [
        { prop: 'totalPatients', label: '总就诊人数', type: 'numberrange', placeholder: '请输入总就诊人数范围' },
        { prop: 'emergencyPatients', label: '急诊患者数', type: 'numberrange', placeholder: '请输入急诊患者数范围' }
      ]
    }
  ];

  return new SearchConfigManager('emergencyWorkloadStatistics', searchFieldGroups);
}

// 急诊质量监控搜索配置
export function createEmergencyQualityMonitorSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'monitorNo', label: '监控编号', type: 'input', placeholder: '请输入监控编号' },
        { prop: 'monitorType', label: '监控类型', type: 'select', placeholder: '请选择监控类型' }
      ]
    },
    {
      name: 'time',
      label: '时间范围',
      fields: [
        { prop: 'monitorDate', label: '监控日期', type: 'daterange', placeholder: '请选择监控日期范围' }
      ]
    },
    {
      name: 'evaluation',
      label: '评价信息',
      fields: [
        { prop: 'overallScore', label: '总体评分', type: 'numberrange', placeholder: '请输入总体评分范围' },
        { prop: 'evaluator', label: '评价人', type: 'input', placeholder: '请输入评价人' }
      ]
    },
    {
      name: 'issues',
      label: '问题记录',
      fields: [
        { prop: 'issuesFound', label: '发现问题数', type: 'numberrange', placeholder: '请输入发现问题数范围' },
        { prop: 'criticalIssues', label: '严重问题数', type: 'numberrange', placeholder: '请输入严重问题数范围' }
      ]
    }
  ];

  return new SearchConfigManager('emergencyQualityMonitor', searchFieldGroups);
}