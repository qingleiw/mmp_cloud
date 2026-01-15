import { FieldConfigManager, FieldGroup } from '../../fieldConfigManager';

// 急诊分诊记录字段配置
export function createEmergencyTriageRecordFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'patientId', label: '患者ID', visible: true, group: 'basic' },
        { prop: 'patientName', label: '患者姓名', visible: true, required: true, group: 'basic' },
        { prop: 'triageNo', label: '分诊号', visible: true, required: true, group: 'basic' },
        { prop: 'arrivalTime', label: '到达时间', visible: true, required: true, width: '180', group: 'basic' }
      ]
    },
    {
      name: 'triage',
      label: '分诊信息',
      fields: [
        { prop: 'triageLevel', label: '分诊级别', visible: true, required: true, group: 'triage' },
        { prop: 'triageDoctor', label: '分诊医生', visible: true, required: true, group: 'triage' },
        { prop: 'triageTime', label: '分诊时间', visible: true, required: true, width: '180', group: 'triage' },
        { prop: 'triageReason', label: '分诊理由', visible: true, group: 'triage' }
      ]
    },
    {
      name: 'symptoms',
      label: '症状信息',
      fields: [
        { prop: 'chiefComplaint', label: '主诉', visible: true, group: 'symptoms' },
        { prop: 'presentIllness', label: '现病史', visible: true, group: 'symptoms' },
        { prop: 'vitalSigns', label: '生命体征', visible: true, group: 'symptoms' }
      ]
    },
    {
      name: 'treatment',
      label: '治疗信息',
      fields: [
        { prop: 'treatmentArea', label: '治疗区域', visible: true, group: 'treatment' },
        { prop: 'treatmentDoctor', label: '治疗医生', visible: true, group: 'treatment' },
        { prop: 'treatmentStartTime', label: '治疗开始时间', visible: true, width: '180', group: 'treatment' },
        { prop: 'treatmentEndTime', label: '治疗结束时间', visible: true, width: '180', group: 'treatment' }
      ]
    },
    {
      name: 'outcome',
      label: '结局信息',
      fields: [
        { prop: 'outcome', label: '结局', visible: true, group: 'outcome' },
        { prop: 'dischargeTime', label: '出院时间', visible: true, width: '180', group: 'outcome' },
        { prop: 'dischargeDiagnosis', label: '出院诊断', visible: true, group: 'outcome' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '删除标志', visible: true, group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, group: 'system' },
        { prop: 'createBy', label: '创建者', visible: true, group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, group: 'system' },
        { prop: 'updateBy', label: '更新者', visible: true, group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('emergencyTriageRecord', fieldGroups);
}

// 急诊抢救记录字段配置
export function createEmergencyRescueRecordFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'patientId', label: '患者ID', visible: true, group: 'basic' },
        { prop: 'patientName', label: '患者姓名', visible: true, required: true, group: 'basic' },
        { prop: 'rescueNo', label: '抢救编号', visible: true, required: true, group: 'basic' },
        { prop: 'rescueStartTime', label: '抢救开始时间', visible: true, required: true, width: '180', group: 'basic' }
      ]
    },
    {
      name: 'team',
      label: '抢救团队',
      fields: [
        { prop: 'rescueLeader', label: '抢救组长', visible: true, required: true, group: 'team' },
        { prop: 'teamMembers', label: '团队成员', visible: true, group: 'team' },
        { prop: 'specialists', label: '参与专科医生', visible: true, group: 'team' }
      ]
    },
    {
      name: 'condition',
      label: '病情信息',
      fields: [
        { prop: 'initialCondition', label: '初始病情', visible: true, group: 'condition' },
        { prop: 'diagnosis', label: '诊断', visible: true, group: 'condition' },
        { prop: 'criticalLevel', label: '危重程度', visible: true, group: 'condition' }
      ]
    },
    {
      name: 'measures',
      label: '抢救措施',
      fields: [
        { prop: 'measures', label: '抢救措施', visible: true, group: 'measures' },
        { prop: 'medications', label: '用药情况', visible: true, group: 'measures' },
        { prop: 'procedures', label: '操作记录', visible: true, group: 'measures' }
      ]
    },
    {
      name: 'outcome',
      label: '抢救结局',
      fields: [
        { prop: 'rescueEndTime', label: '抢救结束时间', visible: true, width: '180', group: 'outcome' },
        { prop: 'rescueResult', label: '抢救结果', visible: true, group: 'outcome' },
        { prop: 'outcomeDescription', label: '结局描述', visible: true, group: 'outcome' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '删除标志', visible: true, group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, group: 'system' },
        { prop: 'createBy', label: '创建者', visible: true, group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, group: 'system' },
        { prop: 'updateBy', label: '更新者', visible: true, group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('emergencyRescueRecord', fieldGroups);
}

// 急诊转诊记录字段配置
export function createEmergencyTransferRecordFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'patientId', label: '患者ID', visible: true, group: 'basic' },
        { prop: 'patientName', label: '患者姓名', visible: true, required: true, group: 'basic' },
        { prop: 'transferNo', label: '转诊编号', visible: true, required: true, group: 'basic' },
        { prop: 'transferTime', label: '转诊时间', visible: true, required: true, width: '180', group: 'basic' }
      ]
    },
    {
      name: 'transfer',
      label: '转诊信息',
      fields: [
        { prop: 'transferFrom', label: '转出医院', visible: true, required: true, group: 'transfer' },
        { prop: 'transferTo', label: '转入医院', visible: true, required: true, group: 'transfer' },
        { prop: 'transferReason', label: '转诊原因', visible: true, required: true, group: 'transfer' },
        { prop: 'transferLevel', label: '转诊级别', visible: true, group: 'transfer' }
      ]
    },
    {
      name: 'diagnosis',
      label: '诊断信息',
      fields: [
        { prop: 'diagnosis', label: '诊断结果', visible: true, group: 'diagnosis' },
        { prop: 'treatmentHistory', label: '治疗经过', visible: true, group: 'diagnosis' },
        { prop: 'currentCondition', label: '当前病情', visible: true, group: 'diagnosis' }
      ]
    },
    {
      name: 'transport',
      label: '转运信息',
      fields: [
        { prop: 'transportMethod', label: '转运方式', visible: true, group: 'transport' },
        { prop: 'transportPersonnel', label: '转运人员', visible: true, group: 'transport' },
        { prop: 'transportEquipment', label: '转运设备', visible: true, group: 'transport' }
      ]
    },
    {
      name: 'outcome',
      label: '转诊结局',
      fields: [
        { prop: 'arrivalTime', label: '到达时间', visible: true, width: '180', group: 'outcome' },
        { prop: 'receivingDoctor', label: '接收医生', visible: true, group: 'outcome' },
        { prop: 'transferOutcome', label: '转诊结局', visible: true, group: 'outcome' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '删除标志', visible: true, group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, group: 'system' },
        { prop: 'createBy', label: '创建者', visible: true, group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, group: 'system' },
        { prop: 'updateBy', label: '更新者', visible: true, group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('emergencyTransferRecord', fieldGroups);
}

// 急诊死亡记录字段配置
export function createEmergencyDeathRecordFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'patientId', label: '患者ID', visible: true, group: 'basic' },
        { prop: 'patientName', label: '患者姓名', visible: true, required: true, group: 'basic' },
        { prop: 'deathNo', label: '死亡编号', visible: true, required: true, group: 'basic' },
        { prop: 'deathTime', label: '死亡时间', visible: true, required: true, width: '180', group: 'basic' }
      ]
    },
    {
      name: 'diagnosis',
      label: '诊断信息',
      fields: [
        { prop: 'admissionDiagnosis', label: '入院诊断', visible: true, group: 'diagnosis' },
        { prop: 'deathDiagnosis', label: '死亡诊断', visible: true, required: true, group: 'diagnosis' },
        { prop: 'underlyingCause', label: '根本死因', visible: true, group: 'diagnosis' },
        { prop: 'immediateCause', label: '直接死因', visible: true, group: 'diagnosis' }
      ]
    },
    {
      name: 'treatment',
      label: '治疗信息',
      fields: [
        { prop: 'treatmentProcess', label: '治疗经过', visible: true, group: 'treatment' },
        { prop: 'lastTreatment', label: '最后治疗', visible: true, group: 'treatment' },
        { prop: 'treatmentDoctor', label: '治疗医生', visible: true, group: 'treatment' }
      ]
    },
    {
      name: 'circumstances',
      label: '死亡情况',
      fields: [
        { prop: 'deathPlace', label: '死亡地点', visible: true, group: 'circumstances' },
        { prop: 'deathCircumstances', label: '死亡经过', visible: true, group: 'circumstances' },
        { prop: 'autopsyRequired', label: '是否需要尸检', visible: true, group: 'circumstances' },
        { prop: 'autopsyResult', label: '尸检结果', visible: true, group: 'circumstances' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '删除标志', visible: true, group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, group: 'system' },
        { prop: 'createBy', label: '创建者', visible: true, group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, group: 'system' },
        { prop: 'updateBy', label: '更新者', visible: true, group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('emergencyDeathRecord', fieldGroups);
}

// 急诊工作量统计字段配置
export function createEmergencyWorkloadStatisticsFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'statisticsDate', label: '统计日期', visible: true, required: true, width: '120', group: 'basic' },
        { prop: 'departmentId', label: '科室ID', visible: true, group: 'basic' },
        { prop: 'departmentName', label: '科室名称', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'workload',
      label: '工作量统计',
      fields: [
        { prop: 'totalPatients', label: '总就诊人数', visible: true, group: 'workload' },
        { prop: 'emergencyPatients', label: '急诊患者数', visible: true, group: 'workload' },
        { prop: 'criticalPatients', label: '危重患者数', visible: true, group: 'workload' },
        { prop: 'admittedPatients', label: '住院患者数', visible: true, group: 'workload' },
        { prop: 'transferredPatients', label: '转诊患者数', visible: true, group: 'workload' }
      ]
    },
    {
      name: 'treatment',
      label: '治疗统计',
      fields: [
        { prop: 'rescueCases', label: '抢救病例数', visible: true, group: 'treatment' },
        { prop: 'successfulRescues', label: '抢救成功数', visible: true, group: 'treatment' },
        { prop: 'deathCases', label: '死亡病例数', visible: true, group: 'treatment' },
        { prop: 'majorOperations', label: '重大手术数', visible: true, group: 'treatment' }
      ]
    },
    {
      name: 'efficiency',
      label: '效率指标',
      fields: [
        { prop: 'averageWaitTime', label: '平均等待时间', visible: true, group: 'efficiency' },
        { prop: 'averageTreatmentTime', label: '平均治疗时间', visible: true, group: 'efficiency' },
        { prop: 'bedOccupancyRate', label: '床位占用率', visible: true, group: 'efficiency' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '删除标志', visible: true, group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, group: 'system' },
        { prop: 'createBy', label: '创建者', visible: true, group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, group: 'system' },
        { prop: 'updateBy', label: '更新者', visible: true, group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('emergencyWorkloadStatistics', fieldGroups);
}

// 急诊质量监控字段配置
export function createEmergencyQualityMonitorFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'monitorNo', label: '监控编号', visible: true, required: true, group: 'basic' },
        { prop: 'monitorDate', label: '监控日期', visible: true, required: true, width: '120', group: 'basic' },
        { prop: 'monitorType', label: '监控类型', visible: true, required: true, group: 'basic' }
      ]
    },
    {
      name: 'indicators',
      label: '质量指标',
      fields: [
        { prop: 'triageAccuracy', label: '分诊准确率', visible: true, group: 'indicators' },
        { prop: 'waitTimeCompliance', label: '等待时间达标率', visible: true, group: 'indicators' },
        { prop: 'treatmentQuality', label: '治疗质量评分', visible: true, group: 'indicators' },
        { prop: 'patientSatisfaction', label: '患者满意度', visible: true, group: 'indicators' }
      ]
    },
    {
      name: 'issues',
      label: '问题记录',
      fields: [
        { prop: 'issuesFound', label: '发现问题数', visible: true, group: 'issues' },
        { prop: 'criticalIssues', label: '严重问题数', visible: true, group: 'issues' },
        { prop: 'issueDescriptions', label: '问题描述', visible: true, group: 'issues' },
        { prop: 'correctiveActions', label: '纠正措施', visible: true, group: 'issues' }
      ]
    },
    {
      name: 'evaluation',
      label: '评价信息',
      fields: [
        { prop: 'overallScore', label: '总体评分', visible: true, group: 'evaluation' },
        { prop: 'evaluator', label: '评价人', visible: true, group: 'evaluation' },
        { prop: 'evaluationTime', label: '评价时间', visible: true, width: '180', group: 'evaluation' },
        { prop: 'recommendations', label: '改进建议', visible: true, group: 'evaluation' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '删除标志', visible: true, group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, group: 'system' },
        { prop: 'createBy', label: '创建者', visible: true, group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, group: 'system' },
        { prop: 'updateBy', label: '更新者', visible: true, group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('emergencyQualityMonitor', fieldGroups);
}