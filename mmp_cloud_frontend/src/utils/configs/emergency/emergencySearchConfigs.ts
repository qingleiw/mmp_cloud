import { SearchConfigManager, SearchFieldGroup } from '../searchConfigManager';

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

// 突发事件记录搜索配置
export function createEmergencyEventSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'eventCode', label: '事件编码', type: 'input', placeholder: '请输入事件编码' },
        { prop: 'eventTitle', label: '事件标题', type: 'input', placeholder: '请输入事件标题' },
        { prop: 'eventType', label: '事件类型', type: 'select', placeholder: '请选择事件类型' },
        { prop: 'eventLevel', label: '事件等级', type: 'select', placeholder: '请选择事件等级' }
      ]
    },
    {
      name: 'time',
      label: '时间范围',
      fields: [
        { prop: 'occurrenceTime', label: '发生时间', type: 'daterange', placeholder: '请选择发生时间范围' },
        { prop: 'discoveryTime', label: '发现时间', type: 'daterange', placeholder: '请选择发现时间范围' },
        { prop: 'reportTime', label: '报告时间', type: 'daterange', placeholder: '请选择报告时间范围' }
      ]
    },
    {
      name: 'personnel',
      label: '人员信息',
      fields: [
        { prop: 'reporter', label: '报告人', type: 'input', placeholder: '请输入报告人' },
        { prop: 'location', label: '发生地点', type: 'input', placeholder: '请输入发生地点' }
      ]
    },
    {
      name: 'content',
      label: '内容信息',
      fields: [
        { prop: 'affectedPersons', label: '受影响人员', type: 'input', placeholder: '请输入受影响人员' },
        { prop: 'eventDescription', label: '事件描述', type: 'input', placeholder: '请输入事件描述' },
        { prop: 'immediateMeasures', label: '立即措施', type: 'input', placeholder: '请输入立即措施' },
        { prop: 'status', label: '状态', type: 'select', placeholder: '请选择状态' }
      ]
    }
  ];

  return new SearchConfigManager('emergencyEvent', searchFieldGroups);
}

// 突发事件记录搜索配置
export function createEmergencyIncidentSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'incidentCode', label: '事件编码', type: 'input', placeholder: '请输入事件编码' },
        { prop: 'incidentTitle', label: '事件标题', type: 'input', placeholder: '请输入事件标题' },
        { prop: 'incidentType', label: '事件类型', type: 'select', placeholder: '请选择事件类型' },
        { prop: 'incidentLevel', label: '事件等级', type: 'select', placeholder: '请选择事件等级' }
      ]
    },
    {
      name: 'time',
      label: '时间范围',
      fields: [
        { prop: 'occurrenceTime', label: '发生时间', type: 'daterange', placeholder: '请选择发生时间范围' },
        { prop: 'resolutionTime', label: '解决时间', type: 'daterange', placeholder: '请选择解决时间范围' }
      ]
    },
    {
      name: 'location',
      label: '地点信息',
      fields: [
        { prop: 'location', label: '发生地点', type: 'input', placeholder: '请输入发生地点' }
      ]
    },
    {
      name: 'response',
      label: '响应信息',
      fields: [
        { prop: 'responseTeam', label: '响应队伍', type: 'input', placeholder: '请输入响应队伍' },
        { prop: 'status', label: '状态', type: 'select', placeholder: '请选择状态' }
      ]
    }
  ];

  return new SearchConfigManager('emergencyIncident', searchFieldGroups);
}

// 应急预案搜索配置
export function createEmergencyPlanSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'planCode', label: '预案编码', type: 'input', placeholder: '请输入预案编码' },
        { prop: 'planName', label: '预案名称', type: 'input', placeholder: '请输入预案名称' },
        { prop: 'planType', label: '预案类型', type: 'select', placeholder: '请选择预案类型' },
        { prop: 'status', label: '状态', type: 'select', placeholder: '请选择状态' }
      ]
    },
    {
      name: 'dates',
      label: '日期范围',
      fields: [
        { prop: 'effectiveDate', label: '生效日期', type: 'daterange', placeholder: '请选择生效日期范围' },
        { prop: 'reviewDate', label: '审核日期', type: 'daterange', placeholder: '请选择审核日期范围' },
        { prop: 'nextReviewDate', label: '下次审核日期', type: 'daterange', placeholder: '请选择下次审核日期范围' }
      ]
    },
    {
      name: 'file',
      label: '文件信息',
      fields: [
        { prop: 'fileName', label: '文件名称', type: 'input', placeholder: '请输入文件名称' },
        { prop: 'uploadBy', label: '上传者', type: 'input', placeholder: '请输入上传者' }
      ]
    },
    {
      name: 'approval',
      label: '批准信息',
      fields: [
        { prop: 'approveBy', label: '批准人', type: 'input', placeholder: '请输入批准人' },
        { prop: 'keywords', label: '关键词', type: 'input', placeholder: '请输入关键词' }
      ]
    }
  ];

  return new SearchConfigManager('emergencyPlan', searchFieldGroups);
}

// 应急演练计划搜索配置
export function createEmergencyDrillPlanSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'planCode', label: '计划编码', type: 'input', placeholder: '请输入计划编码' },
        { prop: 'planName', label: '计划名称', type: 'input', placeholder: '请输入计划名称' },
        { prop: 'drillType', label: '演练类型', type: 'select', placeholder: '请选择演练类型' },
        { prop: 'drillScenario', label: '演练场景', type: 'input', placeholder: '请输入演练场景' },
        { prop: 'status', label: '状态', type: 'select', placeholder: '请选择状态' }
      ]
    },
    {
      name: 'dates',
      label: '日期范围',
      fields: [
        { prop: 'plannedDate', label: '计划日期', type: 'daterange', placeholder: '请选择计划日期范围' },
        { prop: 'actualDate', label: '实际日期', type: 'daterange', placeholder: '请选择实际日期范围' }
      ]
    },
    {
      name: 'organization',
      label: '组织信息',
      fields: [
        { prop: 'location', label: '演练地点', type: 'input', placeholder: '请输入演练地点' },
        { prop: 'organizer', label: '组织者', type: 'input', placeholder: '请输入组织者' },
        { prop: 'participants', label: '参与人员', type: 'input', placeholder: '请输入参与人员' }
      ]
    },
    {
      name: 'content',
      label: '内容信息',
      fields: [
        { prop: 'objectives', label: '演练目标', type: 'input', placeholder: '请输入演练目标' },
        { prop: 'drillResult', label: '演练结果', type: 'input', placeholder: '请输入演练结果' }
      ]
    }
  ];

  return new SearchConfigManager('emergencyDrillPlan', searchFieldGroups);
}

// 应急演练总结搜索配置
export function createEmergencyDrillSummarySearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'execution',
      label: '执行信息',
      fields: [
        { prop: 'actualStartTime', label: '实际开始时间', type: 'daterange', placeholder: '请选择实际开始时间范围' },
        { prop: 'actualEndTime', label: '实际结束时间', type: 'daterange', placeholder: '请选择实际结束时间范围' },
        { prop: 'participantsCount', label: '实际参与人数', type: 'input', placeholder: '请输入实际参与人数' }
      ]
    },
    {
      name: 'process',
      label: '过程信息',
      fields: [
        { prop: 'drillProcess', label: '演练过程描述', type: 'input', placeholder: '请输入演练过程描述' },
        { prop: 'problemsFound', label: '发现的问题', type: 'input', placeholder: '请输入发现的问题' }
      ]
    },
    {
      name: 'result',
      label: '结果信息',
      fields: [
        { prop: 'lessonsLearned', label: '经验教训', type: 'input', placeholder: '请输入经验教训' },
        { prop: 'improvementMeasures', label: '改进措施', type: 'input', placeholder: '请输入改进措施' }
      ]
    },
    {
      name: 'evaluation',
      label: '评价信息',
      fields: [
        { prop: 'evaluationScore', label: '评价分数', type: 'input', placeholder: '请输入评价分数' },
        { prop: 'evaluatorName', label: '评价人姓名', type: 'input', placeholder: '请输入评价人姓名' },
        { prop: 'evaluationTime', label: '评价时间', type: 'daterange', placeholder: '请选择评价时间范围' }
      ]
    }
  ];

  return new SearchConfigManager('emergencyDrillSummary', searchFieldGroups);
}

// 应急事件响应搜索配置
export function createEmergencyEventResponseSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'responseTeam', label: '响应队伍', type: 'input', placeholder: '请输入响应队伍' },
        { prop: 'responsiblePerson', label: '责任人', type: 'input', placeholder: '请输入责任人' }
      ]
    },
    {
      name: 'time',
      label: '时间范围',
      fields: [
        { prop: 'responseStartTime', label: '响应开始时间', type: 'daterange', placeholder: '请选择响应开始时间范围' },
        { prop: 'responseEndTime', label: '响应结束时间', type: 'daterange', placeholder: '请选择响应结束时间范围' }
      ]
    },
    {
      name: 'response',
      label: '响应信息',
      fields: [
        { prop: 'responseMeasures', label: '响应措施', type: 'input', placeholder: '请输入响应措施' }
      ]
    }
  ];

  return new SearchConfigManager('emergencyEventResponse', searchFieldGroups);
}

// 突发事件治疗搜索配置
export function createEmergencyEventTreatmentSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'patientName', label: '患者姓名', type: 'input', placeholder: '请输入患者姓名' },
        { prop: 'treatmentDoctor', label: '治疗医生', type: 'input', placeholder: '请输入治疗医生' },
        { prop: 'treatmentType', label: '治疗类型', type: 'select', placeholder: '请选择治疗类型' }
      ]
    },
    {
      name: 'time',
      label: '时间范围',
      fields: [
        { prop: 'treatmentStartTime', label: '治疗开始时间', type: 'daterange', placeholder: '请选择治疗开始时间范围' },
        { prop: 'treatmentEndTime', label: '治疗结束时间', type: 'daterange', placeholder: '请选择治疗结束时间范围' }
      ]
    },
    {
      name: 'outcome',
      label: '治疗结果',
      fields: [
        { prop: 'treatmentResult', label: '治疗结果', type: 'select', placeholder: '请选择治疗结果' },
        { prop: 'followUpRequired', label: '是否需要随访', type: 'select', placeholder: '请选择是否需要随访' }
      ]
    }
  ];

  return new SearchConfigManager('emergencyEventTreatment', searchFieldGroups);
}

// 突发事件医疗支援搜索配置
export function createEmergencyMedicalSupportSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'supportType', label: '支援类型', type: 'select', placeholder: '请选择支援类型' },
        { prop: 'supportUnit', label: '支援单位', type: 'input', placeholder: '请输入支援单位' },
        { prop: 'supportPersonnel', label: '支援人员', type: 'input', placeholder: '请输入支援人员' }
      ]
    },
    {
      name: 'time',
      label: '时间范围',
      fields: [
        { prop: 'supportStartTime', label: '支援开始时间', type: 'daterange', placeholder: '请选择支援开始时间范围' },
        { prop: 'supportEndTime', label: '支援结束时间', type: 'daterange', placeholder: '请选择支援结束时间范围' }
      ]
    },
    {
      name: 'resources',
      label: '资源信息',
      fields: [
        { prop: 'medicalSupplies', label: '医疗物资', type: 'input', placeholder: '请输入医疗物资' },
        { prop: 'transportation', label: '交通工具', type: 'input', placeholder: '请输入交通工具' }
      ]
    }
  ];

  return new SearchConfigManager('emergencyMedicalSupport', searchFieldGroups);
}

// 突发事件预案审批搜索配置
export function createEmergencyPlanApprovalSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'planName', label: '预案名称', type: 'input', placeholder: '请输入预案名称' },
        { prop: 'approvalType', label: '审批类型', type: 'select', placeholder: '请选择审批类型' },
        { prop: 'applicantName', label: '申请人姓名', type: 'input', placeholder: '请输入申请人姓名' }
      ]
    },
    {
      name: 'approval',
      label: '审批信息',
      fields: [
        { prop: 'approvalStatus', label: '审批状态', type: 'select', placeholder: '请选择审批状态' },
        { prop: 'approverName', label: '审批人姓名', type: 'input', placeholder: '请输入审批人姓名' },
        { prop: 'approvalTime', label: '审批时间', type: 'daterange', placeholder: '请选择审批时间范围' }
      ]
    }
  ];

  return new SearchConfigManager('emergencyPlanApproval', searchFieldGroups);
}

// 突发事件应急队伍搜索配置
export function createEmergencyTeamSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'teamName', label: '队伍名称', type: 'input', placeholder: '请输入队伍名称' },
        { prop: 'teamType', label: '队伍类型', type: 'select', placeholder: '请选择队伍类型' },
        { prop: 'teamLeader', label: '队伍负责人', type: 'input', placeholder: '请输入队伍负责人' }
      ]
    },
    {
      name: 'contact',
      label: '联系信息',
      fields: [
        { prop: 'contactPhone', label: '联系电话', type: 'input', placeholder: '请输入联系电话' },
        { prop: 'emergencyContact', label: '紧急联系人', type: 'input', placeholder: '请输入紧急联系人' }
      ]
    }
  ];

  return new SearchConfigManager('emergencyTeam', searchFieldGroups);
}

// 突发事件应急队伍成员搜索配置
export function createEmergencyTeamMemberSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'memberName', label: '成员姓名', type: 'input', placeholder: '请输入成员姓名' },
        { prop: 'memberPosition', label: '成员职位', type: 'input', placeholder: '请输入成员职位' },
        { prop: 'qualificationLevel', label: '资质等级', type: 'select', placeholder: '请选择资质等级' }
      ]
    },
    {
      name: 'contact',
      label: '联系信息',
      fields: [
        { prop: 'phoneNumber', label: '联系电话', type: 'input', placeholder: '请输入联系电话' },
        { prop: 'emergencyContact', label: '紧急联系人', type: 'input', placeholder: '请输入紧急联系人' }
      ]
    }
  ];

  return new SearchConfigManager('emergencyTeamMember', searchFieldGroups);
}

// 重要医疗事件搜索配置
export function createImportantMedicalEventSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'eventTitle', label: '事件标题', type: 'input', placeholder: '请输入事件标题' },
        { prop: 'eventType', label: '事件类型', type: 'select', placeholder: '请选择事件类型' },
        { prop: 'eventLevel', label: '事件等级', type: 'select', placeholder: '请选择事件等级' }
      ]
    },
    {
      name: 'time',
      label: '时间范围',
      fields: [
        { prop: 'occurrenceTime', label: '发生时间', type: 'daterange', placeholder: '请选择发生时间范围' },
        { prop: 'reportTime', label: '报告时间', type: 'daterange', placeholder: '请选择报告时间范围' }
      ]
    },
    {
      name: 'response',
      label: '响应信息',
      fields: [
        { prop: 'responsibleDepartment', label: '责任部门', type: 'input', placeholder: '请输入责任部门' }
      ]
    }
  ];

  return new SearchConfigManager('importantMedicalEvent', searchFieldGroups);
}