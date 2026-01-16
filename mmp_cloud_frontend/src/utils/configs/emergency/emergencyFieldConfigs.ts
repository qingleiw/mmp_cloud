import { FieldConfigManager, FieldGroup } from '../fieldConfigManager';

// 急诊分诊记录字段配置
export function createEmergencyTriageRecordFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'patientId', label: '患者ID', visible: true, type: 'input', group: 'basic' },
        { prop: 'patientName', label: '患者姓名', visible: true, required: true, type: 'input', group: 'basic' },
        { prop: 'triageNo', label: '分诊号', visible: true, required: true, type: 'input', group: 'basic' },
        { prop: 'arrivalTime', label: '到达时间', visible: true, required: true, type: 'datetime', width: '180', group: 'basic' }
      ]
    },
    {
      name: 'triage',
      label: '分诊信息',
      fields: [
        { prop: 'triageLevel', label: '分诊级别', visible: true, required: true, type: 'select', group: 'triage' },
        { prop: 'triageDoctor', label: '分诊医生', visible: true, required: true, type: 'input', group: 'triage' },
        { prop: 'triageTime', label: '分诊时间', visible: true, required: true, type: 'datetime', width: '180', group: 'triage' },
        { prop: 'triageReason', label: '分诊理由', visible: true, type: 'textarea', group: 'triage' }
      ]
    },
    {
      name: 'symptoms',
      label: '症状信息',
      fields: [
        { prop: 'chiefComplaint', label: '主诉', visible: true, type: 'textarea', group: 'symptoms' },
        { prop: 'presentIllness', label: '现病史', visible: true, type: 'textarea', group: 'symptoms' },
        { prop: 'vitalSigns', label: '生命体征', visible: true, type: 'textarea', group: 'symptoms' }
      ]
    },
    {
      name: 'treatment',
      label: '治疗信息',
      fields: [
        { prop: 'treatmentArea', label: '治疗区域', visible: true, type: 'input', group: 'treatment' },
        { prop: 'treatmentDoctor', label: '治疗医生', visible: true, type: 'input', group: 'treatment' },
        { prop: 'treatmentStartTime', label: '治疗开始时间', visible: true, type: 'datetime', width: '180', group: 'treatment' },
        { prop: 'treatmentEndTime', label: '治疗结束时间', visible: true, type: 'datetime', width: '180', group: 'treatment' }
      ]
    },
    {
      name: 'outcome',
      label: '结局信息',
      fields: [
        { prop: 'outcome', label: '结局', visible: true, type: 'select', group: 'outcome' },
        { prop: 'dischargeTime', label: '出院时间', visible: true, type: 'datetime', width: '180', group: 'outcome' },
        { prop: 'dischargeDiagnosis', label: '出院诊断', visible: true, type: 'textarea', group: 'outcome' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '删除标志', visible: true, type: 'select', group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'createBy', label: '创建者', visible: true, type: 'input', group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'updateBy', label: '更新者', visible: true, type: 'input', group: 'system' }
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
        { prop: 'delFlag', label: '删除标志', visible: true, type: 'select', group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'createBy', label: '创建者', visible: true, type: 'input', group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'updateBy', label: '更新者', visible: true, type: 'input', group: 'system' }
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
        { prop: 'delFlag', label: '删除标志', visible: true, type: 'select', group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'createBy', label: '创建者', visible: true, type: 'input', group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'updateBy', label: '更新者', visible: true, type: 'input', group: 'system' }
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
        { prop: 'delFlag', label: '删除标志', visible: true, type: 'select', group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'createBy', label: '创建者', visible: true, type: 'input', group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'updateBy', label: '更新者', visible: true, type: 'input', group: 'system' }
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
        { prop: 'delFlag', label: '删除标志', visible: true, type: 'select', group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'createBy', label: '创建者', visible: true, type: 'input', group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'updateBy', label: '更新者', visible: true, type: 'input', group: 'system' }
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
        { prop: 'delFlag', label: '删除标志', visible: true, type: 'select', group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'createBy', label: '创建者', visible: true, type: 'input', group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'updateBy', label: '更新者', visible: true, type: 'input', group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('emergencyQualityMonitor', fieldGroups);
}

// 突发事件记录字段配置
export function createEmergencyEventFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: false, type: 'input', group: 'basic' },
        { prop: 'eventCode', label: '事件编码', visible: true, type: 'input', group: 'basic' },
        { prop: 'eventTitle', label: '事件标题', visible: true, type: 'input', group: 'basic' },
        { prop: 'eventType', label: '事件类型', visible: true, type: 'select', group: 'basic' },
        { prop: 'eventLevel', label: '事件等级', visible: true, type: 'select', group: 'basic' }
      ]
    },
    {
      name: 'time',
      label: '时间信息',
      fields: [
        { prop: 'occurrenceTime', label: '发生时间', visible: true, type: 'datetime', width: '180', group: 'time' },
        { prop: 'discoveryTime', label: '发现时间', visible: true, type: 'datetime', width: '180', group: 'time' },
        { prop: 'reportTime', label: '报告时间', visible: true, type: 'datetime', width: '180', group: 'time' }
      ]
    },
    {
      name: 'personnel',
      label: '人员信息',
      fields: [
        { prop: 'reporter', label: '报告人', visible: true, type: 'input', group: 'personnel' },
        { prop: 'location', label: '发生地点', visible: true, type: 'input', group: 'personnel' }
      ]
    },
    {
      name: 'content',
      label: '内容信息',
      fields: [
        { prop: 'affectedPersons', label: '受影响人员', visible: true, type: 'textarea', group: 'content' },
        { prop: 'eventDescription', label: '事件描述', visible: true, type: 'textarea', group: 'content' },
        { prop: 'immediateMeasures', label: '立即措施', visible: true, type: 'textarea', group: 'content' },
        { prop: 'status', label: '状态', visible: true, type: 'select', group: 'content' },
        { prop: 'remark', label: '备注', visible: true, type: 'textarea', group: 'content' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '删除标志', visible: true, type: 'select', group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'createBy', label: '创建者', visible: true, type: 'input', group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'updateBy', label: '更新者', visible: true, type: 'input', group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('emergencyEvent', fieldGroups);
}

// 突发事件记录字段配置
export function createEmergencyIncidentFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: false, type: 'input', group: 'basic' },
        { prop: 'incidentCode', label: '事件编码', visible: true, type: 'input', group: 'basic' },
        { prop: 'incidentTitle', label: '事件标题', visible: true, type: 'input', group: 'basic' },
        { prop: 'incidentType', label: '事件类型', visible: true, type: 'select', group: 'basic' },
        { prop: 'incidentLevel', label: '事件等级', visible: true, type: 'select', group: 'basic' }
      ]
    },
    {
      name: 'time',
      label: '时间信息',
      fields: [
        { prop: 'occurrenceTime', label: '发生时间', visible: true, type: 'datetime', width: '180', group: 'time' },
        { prop: 'resolutionTime', label: '解决时间', visible: true, type: 'datetime', width: '180', group: 'time' }
      ]
    },
    {
      name: 'location',
      label: '地点信息',
      fields: [
        { prop: 'location', label: '发生地点', visible: true, type: 'input', group: 'location' }
      ]
    },
    {
      name: 'description',
      label: '描述信息',
      fields: [
        { prop: 'description', label: '事件描述', visible: true, type: 'textarea', group: 'description' },
        { prop: 'affectedPersons', label: '受影响人员', visible: true, type: 'textarea', group: 'description' }
      ]
    },
    {
      name: 'response',
      label: '响应信息',
      fields: [
        { prop: 'responseTeam', label: '响应队伍', visible: true, type: 'input', group: 'response' },
        { prop: 'responseMeasures', label: '响应措施', visible: true, type: 'textarea', group: 'response' }
      ]
    },
    {
      name: 'impact',
      label: '影响评估',
      fields: [
        { prop: 'casualties', label: '伤亡情况', visible: true, type: 'textarea', group: 'impact' },
        { prop: 'economicLoss', label: '经济损失', visible: true, type: 'input', group: 'impact' },
        { prop: 'lessonsLearned', label: '经验教训', visible: true, type: 'textarea', group: 'impact' }
      ]
    },
    {
      name: 'status',
      label: '状态信息',
      fields: [
        { prop: 'status', label: '状态', visible: true, type: 'select', group: 'status' },
        { prop: 'remark', label: '备注', visible: true, type: 'textarea', group: 'status' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '删除标志', visible: true, type: 'select', group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'createBy', label: '创建者', visible: true, type: 'input', group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'updateBy', label: '更新者', visible: true, type: 'input', group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('emergencyIncident', fieldGroups);
}

// 应急预案字段配置
export function createEmergencyPlanFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: false, type: 'input', group: 'basic' },
        { prop: 'planCode', label: '预案编码', visible: true, required: true, type: 'input', group: 'basic' },
        { prop: 'planName', label: '预案名称', visible: true, required: true, type: 'input', group: 'basic' },
        { prop: 'planType', label: '预案类型', visible: true, type: 'select', group: 'basic' },
        { prop: 'status', label: '状态', visible: true, type: 'select', group: 'basic' }
      ]
    },
    {
      name: 'dates',
      label: '日期信息',
      fields: [
        { prop: 'effectiveDate', label: '生效日期', visible: true, type: 'datetime', width: '180', group: 'dates' },
        { prop: 'reviewDate', label: '审核日期', visible: true, type: 'datetime', width: '180', group: 'dates' },
        { prop: 'nextReviewDate', label: '下次审核日期', visible: true, type: 'datetime', width: '180', group: 'dates' }
      ]
    },
    {
      name: 'file',
      label: '文件信息',
      fields: [
        { prop: 'filePath', label: '文件路径', visible: true, type: 'textarea', group: 'file' },
        { prop: 'fileName', label: '文件名称', visible: true, type: 'input', group: 'file' },
        { prop: 'fileSize', label: '文件大小', visible: true, type: 'input', group: 'file' }
      ]
    },
    {
      name: 'upload',
      label: '上传信息',
      fields: [
        { prop: 'uploadBy', label: '上传者', visible: true, type: 'input', group: 'upload' },
        { prop: 'uploadTime', label: '上传时间', visible: true, type: 'datetime', width: '180', group: 'upload' }
      ]
    },
    {
      name: 'approval',
      label: '批准信息',
      fields: [
        { prop: 'approveBy', label: '批准人', visible: true, type: 'input', group: 'approval' },
        { prop: 'approveTime', label: '批准时间', visible: true, type: 'datetime', width: '180', group: 'approval' }
      ]
    },
    {
      name: 'other',
      label: '其他信息',
      fields: [
        { prop: 'keywords', label: '关键词', visible: true, type: 'textarea', group: 'other' },
        { prop: 'remark', label: '备注', visible: true, type: 'textarea', group: 'other' }
      ]
    }
  ];

  return new FieldConfigManager('emergencyPlan', fieldGroups);
}

// 应急演练计划字段配置
export function createEmergencyDrillPlanFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: false, type: 'input', group: 'basic' },
        { prop: 'planCode', label: '计划编码', visible: true, required: true, type: 'input', group: 'basic' },
        { prop: 'planName', label: '计划名称', visible: true, required: true, type: 'input', group: 'basic' },
        { prop: 'drillType', label: '演练类型', visible: true, type: 'select', group: 'basic' },
        { prop: 'drillScenario', label: '演练场景', visible: true, type: 'input', group: 'basic' },
        { prop: 'status', label: '状态', visible: true, type: 'select', group: 'basic' }
      ]
    },
    {
      name: 'dates',
      label: '日期信息',
      fields: [
        { prop: 'plannedDate', label: '计划日期', visible: true, type: 'datetime', width: '180', group: 'dates' },
        { prop: 'actualDate', label: '实际日期', visible: true, type: 'datetime', width: '180', group: 'dates' }
      ]
    },
    {
      name: 'organization',
      label: '组织信息',
      fields: [
        { prop: 'location', label: '演练地点', visible: true, type: 'input', group: 'organization' },
        { prop: 'organizer', label: '组织者', visible: true, type: 'input', group: 'organization' },
        { prop: 'participants', label: '参与人员', visible: true, type: 'textarea', group: 'organization' }
      ]
    },
    {
      name: 'content',
      label: '内容信息',
      fields: [
        { prop: 'objectives', label: '演练目标', visible: true, type: 'textarea', group: 'content' },
        { prop: 'procedures', label: '演练流程', visible: true, type: 'textarea', group: 'content' },
        { prop: 'evaluationCriteria', label: '评估标准', visible: true, type: 'textarea', group: 'content' }
      ]
    },
    {
      name: 'result',
      label: '结果信息',
      fields: [
        { prop: 'drillResult', label: '演练结果', visible: true, type: 'textarea', group: 'result' },
        { prop: 'lessonsLearned', label: '经验教训', visible: true, type: 'textarea', group: 'result' }
      ]
    }
  ];

  return new FieldConfigManager('emergencyDrillPlan', fieldGroups);
}

// 应急演练总结字段配置
export function createEmergencyDrillSummaryFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: false, type: 'input', group: 'basic' },
        { prop: 'planId', label: '计划ID', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'execution',
      label: '执行信息',
      fields: [
        { prop: 'actualStartTime', label: '实际开始时间', visible: true, type: 'datetime', width: '180', group: 'execution' },
        { prop: 'actualEndTime', label: '实际结束时间', visible: true, type: 'datetime', width: '180', group: 'execution' },
        { prop: 'participantsCount', label: '实际参与人数', visible: true, type: 'input', group: 'execution' }
      ]
    },
    {
      name: 'process',
      label: '过程信息',
      fields: [
        { prop: 'drillProcess', label: '演练过程描述', visible: true, type: 'textarea', group: 'process' },
        { prop: 'problemsFound', label: '发现的问题', visible: true, type: 'textarea', group: 'process' }
      ]
    },
    {
      name: 'result',
      label: '结果信息',
      fields: [
        { prop: 'lessonsLearned', label: '经验教训', visible: true, type: 'textarea', group: 'result' },
        { prop: 'improvementMeasures', label: '改进措施', visible: true, type: 'textarea', group: 'result' }
      ]
    },
    {
      name: 'evaluation',
      label: '评价信息',
      fields: [
        { prop: 'evaluationScore', label: '评价分数', visible: true, type: 'input', group: 'evaluation' },
        { prop: 'evaluatorName', label: '评价人姓名', visible: true, type: 'input', group: 'evaluation' },
        { prop: 'evaluationTime', label: '评价时间', visible: true, type: 'datetime', width: '180', group: 'evaluation' }
      ]
    },
    {
      name: 'other',
      label: '其他信息',
      fields: [
        { prop: 'remark', label: '备注', visible: true, type: 'textarea', group: 'other' }
      ]
    }
  ];

  return new FieldConfigManager('emergencyDrillSummary', fieldGroups);
}

// 应急事件响应字段配置
export function createEmergencyEventResponseFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: false, type: 'input', group: 'basic' },
        { prop: 'eventId', label: '事件ID', visible: true, type: 'input', group: 'basic' },
        { prop: 'responseTeam', label: '响应队伍', visible: true, required: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'time',
      label: '时间信息',
      fields: [
        { prop: 'responseStartTime', label: '响应开始时间', visible: true, type: 'datetime', width: '180', group: 'time' },
        { prop: 'responseEndTime', label: '响应结束时间', visible: true, type: 'datetime', width: '180', group: 'time' }
      ]
    },
    {
      name: 'response',
      label: '响应信息',
      fields: [
        { prop: 'responseMeasures', label: '响应措施', visible: true, type: 'textarea', group: 'response' },
        { prop: 'responsiblePerson', label: '责任人', visible: true, type: 'input', group: 'response' }
      ]
    },
    {
      name: 'other',
      label: '其他信息',
      fields: [
        { prop: 'remark', label: '备注', visible: true, type: 'textarea', group: 'other' }
      ]
    }
  ];

  return new FieldConfigManager('emergencyEventResponse', fieldGroups);
}

// 突发事件治疗字段配置
export function createEmergencyEventTreatmentFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: false, type: 'input', group: 'basic' },
        { prop: 'eventId', label: '事件ID', visible: true, type: 'input', group: 'basic' },
        { prop: 'patientId', label: '患者ID', visible: true, type: 'input', group: 'basic' },
        { prop: 'patientName', label: '患者姓名', visible: true, required: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'treatment',
      label: '治疗信息',
      fields: [
        { prop: 'treatmentType', label: '治疗类型', visible: true, required: true, type: 'select', group: 'treatment' },
        { prop: 'treatmentDoctor', label: '治疗医生', visible: true, required: true, type: 'input', group: 'treatment' },
        { prop: 'treatmentStartTime', label: '治疗开始时间', visible: true, type: 'datetime', width: '180', group: 'treatment' },
        { prop: 'treatmentEndTime', label: '治疗结束时间', visible: true, type: 'datetime', width: '180', group: 'treatment' },
        { prop: 'treatmentMeasures', label: '治疗措施', visible: true, type: 'textarea', group: 'treatment' }
      ]
    },
    {
      name: 'outcome',
      label: '治疗结果',
      fields: [
        { prop: 'treatmentResult', label: '治疗结果', visible: true, type: 'select', group: 'outcome' },
        { prop: 'treatmentCost', label: '治疗费用', visible: true, type: 'number', group: 'outcome' },
        { prop: 'followUpRequired', label: '是否需要随访', visible: true, type: 'select', group: 'outcome' }
      ]
    },
    {
      name: 'other',
      label: '其他信息',
      fields: [
        { prop: 'remark', label: '备注', visible: true, type: 'textarea', group: 'other' }
      ]
    }
  ];

  return new FieldConfigManager('emergencyEventTreatment', fieldGroups);
}

// 突发事件医疗支援字段配置
export function createEmergencyMedicalSupportFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: false, type: 'input', group: 'basic' },
        { prop: 'eventId', label: '事件ID', visible: true, type: 'input', group: 'basic' },
        { prop: 'supportType', label: '支援类型', visible: true, required: true, type: 'select', group: 'basic' },
        { prop: 'supportUnit', label: '支援单位', visible: true, required: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'support',
      label: '支援信息',
      fields: [
        { prop: 'supportPersonnel', label: '支援人员', visible: true, type: 'input', group: 'support' },
        { prop: 'supportEquipment', label: '支援设备', visible: true, type: 'textarea', group: 'support' },
        { prop: 'supportStartTime', label: '支援开始时间', visible: true, type: 'datetime', width: '180', group: 'support' },
        { prop: 'supportEndTime', label: '支援结束时间', visible: true, type: 'datetime', width: '180', group: 'support' }
      ]
    },
    {
      name: 'resources',
      label: '资源信息',
      fields: [
        { prop: 'medicalSupplies', label: '医疗物资', visible: true, type: 'textarea', group: 'resources' },
        { prop: 'transportation', label: '交通工具', visible: true, type: 'input', group: 'resources' },
        { prop: 'coordinationUnit', label: '协调单位', visible: true, type: 'input', group: 'resources' }
      ]
    },
    {
      name: 'other',
      label: '其他信息',
      fields: [
        { prop: 'remark', label: '备注', visible: true, type: 'textarea', group: 'other' }
      ]
    }
  ];

  return new FieldConfigManager('emergencyMedicalSupport', fieldGroups);
}

// 突发事件预案审批字段配置
export function createEmergencyPlanApprovalFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: false, type: 'input', group: 'basic' },
        { prop: 'planId', label: '预案ID', visible: true, type: 'input', group: 'basic' },
        { prop: 'planName', label: '预案名称', visible: true, required: true, type: 'input', group: 'basic' },
        { prop: 'approvalType', label: '审批类型', visible: true, required: true, type: 'select', group: 'basic' }
      ]
    },
    {
      name: 'approval',
      label: '审批信息',
      fields: [
        { prop: 'applicantId', label: '申请人ID', visible: true, type: 'input', group: 'approval' },
        { prop: 'applicantName', label: '申请人姓名', visible: true, required: true, type: 'input', group: 'approval' },
        { prop: 'approvalStatus', label: '审批状态', visible: true, required: true, type: 'select', group: 'approval' },
        { prop: 'approvalTime', label: '审批时间', visible: true, type: 'datetime', width: '180', group: 'approval' },
        { prop: 'approverId', label: '审批人ID', visible: true, type: 'input', group: 'approval' },
        { prop: 'approverName', label: '审批人姓名', visible: true, type: 'input', group: 'approval' }
      ]
    },
    {
      name: 'content',
      label: '审批内容',
      fields: [
        { prop: 'approvalOpinion', label: '审批意见', visible: true, type: 'textarea', group: 'content' },
        { prop: 'approvalRequirements', label: '审批要求', visible: true, type: 'textarea', group: 'content' }
      ]
    },
    {
      name: 'other',
      label: '其他信息',
      fields: [
        { prop: 'remark', label: '备注', visible: true, type: 'textarea', group: 'other' }
      ]
    }
  ];

  return new FieldConfigManager('emergencyPlanApproval', fieldGroups);
}

// 突发事件应急队伍字段配置
export function createEmergencyTeamFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: false, type: 'input', group: 'basic' },
        { prop: 'teamName', label: '队伍名称', visible: true, required: true, type: 'input', group: 'basic' },
        { prop: 'teamType', label: '队伍类型', visible: true, required: true, type: 'select', group: 'basic' },
        { prop: 'teamLeader', label: '队伍负责人', visible: true, required: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'contact',
      label: '联系信息',
      fields: [
        { prop: 'contactPhone', label: '联系电话', visible: true, type: 'input', group: 'contact' },
        { prop: 'contactAddress', label: '联系地址', visible: true, type: 'input', group: 'contact' },
        { prop: 'emergencyContact', label: '紧急联系人', visible: true, type: 'input', group: 'contact' }
      ]
    },
    {
      name: 'capability',
      label: '能力信息',
      fields: [
        { prop: 'teamSize', label: '队伍人数', visible: true, type: 'number', group: 'capability' },
        { prop: 'specialties', label: '专业特长', visible: true, type: 'textarea', group: 'capability' },
        { prop: 'equipment', label: '装备情况', visible: true, type: 'textarea', group: 'capability' }
      ]
    },
    {
      name: 'other',
      label: '其他信息',
      fields: [
        { prop: 'remark', label: '备注', visible: true, type: 'textarea', group: 'other' }
      ]
    }
  ];

  return new FieldConfigManager('emergencyTeam', fieldGroups);
}

// 突发事件应急队伍成员字段配置
export function createEmergencyTeamMemberFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: false, type: 'input', group: 'basic' },
        { prop: 'teamId', label: '队伍ID', visible: true, type: 'input', group: 'basic' },
        { prop: 'memberName', label: '成员姓名', visible: true, required: true, type: 'input', group: 'basic' },
        { prop: 'memberPosition', label: '成员职位', visible: true, required: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'contact',
      label: '联系信息',
      fields: [
        { prop: 'phoneNumber', label: '联系电话', visible: true, type: 'input', group: 'contact' },
        { prop: 'emergencyContact', label: '紧急联系人', visible: true, type: 'input', group: 'contact' },
        { prop: 'emergencyPhone', label: '紧急联系电话', visible: true, type: 'input', group: 'contact' }
      ]
    },
    {
      name: 'qualification',
      label: '资质信息',
      fields: [
        { prop: 'qualificationLevel', label: '资质等级', visible: true, type: 'select', group: 'qualification' },
        { prop: 'specialSkills', label: '特殊技能', visible: true, type: 'textarea', group: 'qualification' },
        { prop: 'trainingRecords', label: '培训记录', visible: true, type: 'textarea', group: 'qualification' }
      ]
    },
    {
      name: 'other',
      label: '其他信息',
      fields: [
        { prop: 'remark', label: '备注', visible: true, type: 'textarea', group: 'other' }
      ]
    }
  ];

  return new FieldConfigManager('emergencyTeamMember', fieldGroups);
}

// 重要医疗事件字段配置
export function createImportantMedicalEventFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: false, type: 'input', group: 'basic' },
        { prop: 'eventTitle', label: '事件标题', visible: true, required: true, type: 'input', group: 'basic' },
        { prop: 'eventType', label: '事件类型', visible: true, required: true, type: 'select', group: 'basic' },
        { prop: 'eventLevel', label: '事件等级', visible: true, required: true, type: 'select', group: 'basic' }
      ]
    },
    {
      name: 'time',
      label: '时间信息',
      fields: [
        { prop: 'occurrenceTime', label: '发生时间', visible: true, required: true, type: 'datetime', width: '180', group: 'time' },
        { prop: 'reportTime', label: '报告时间', visible: true, type: 'datetime', width: '180', group: 'time' },
        { prop: 'resolutionTime', label: '解决时间', visible: true, type: 'datetime', width: '180', group: 'time' }
      ]
    },
    {
      name: 'details',
      label: '事件详情',
      fields: [
        { prop: 'eventDescription', label: '事件描述', visible: true, type: 'textarea', group: 'details' },
        { prop: 'involvedPersonnel', label: '涉及人员', visible: true, type: 'textarea', group: 'details' },
        { prop: 'impactAssessment', label: '影响评估', visible: true, type: 'textarea', group: 'details' }
      ]
    },
    {
      name: 'response',
      label: '响应措施',
      fields: [
        { prop: 'responseMeasures', label: '响应措施', visible: true, type: 'textarea', group: 'response' },
        { prop: 'responsibleDepartment', label: '责任部门', visible: true, type: 'input', group: 'response' },
        { prop: 'followUpActions', label: '后续行动', visible: true, type: 'textarea', group: 'response' }
      ]
    },
    {
      name: 'other',
      label: '其他信息',
      fields: [
        { prop: 'remark', label: '备注', visible: true, type: 'textarea', group: 'other' }
      ]
    }
  ];

  return new FieldConfigManager('importantMedicalEvent', fieldGroups);
}