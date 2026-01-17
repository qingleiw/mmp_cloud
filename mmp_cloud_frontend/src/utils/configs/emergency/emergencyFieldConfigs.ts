import { FieldConfigManager, FieldGroup } from '../fieldConfigManager';

// emergencyDrillPlan字段配置
export function createEmergencyDrillPlanFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'planCode', label: '计划编码', visible: true, type: 'input', group: 'basic' },
        { prop: 'planName', label: '计划名称', visible: true, type: 'input', group: 'basic' },
        { prop: 'drillType', label: '演练类型', visible: true, type: 'input', group: 'basic' },
        { prop: 'status', label: '状态：planned-已计划，executing-执行中，completed-已完成', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'drillScenario', label: '演练场景', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'plannedDate', label: '计划日期', visible: true, type: 'date', group: 'detail' },
        { prop: 'actualDate', label: '实际日期', visible: true, type: 'date', group: 'detail' },
        { prop: 'location', label: '演练地点', visible: true, type: 'input', group: 'detail' },
        { prop: 'organizer', label: '组织者', visible: true, type: 'input', group: 'detail' },
        { prop: 'participants', label: '参与人员', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'objectives', label: '演练目标', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'procedures', label: '演练流程', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'evaluationCriteria', label: '评估标准', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'drillResult', label: '演练结果', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'lessonsLearned', label: '经验教训', visible: true, type: 'textarea', group: 'detail' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', visible: true, type: 'select', group: 'system' },
        { prop: 'createDept', label: '创建部门', visible: true, type: 'number', group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'createBy', label: '创建人', visible: true, type: 'number', group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'updateBy', label: '更新人', visible: true, type: 'number', group: 'system' },
        { prop: 'remark', label: '备注', visible: true, type: 'input', group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('emergencyDrillPlan', fieldGroups);
}


// emergencyDrillSummary字段配置
export function createEmergencyDrillSummaryFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'planId', label: '计划ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'evaluatorId', label: '评价人ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'evaluatorName', label: '评价人姓名', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'actualStartTime', label: '实际开始时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'actualEndTime', label: '实际结束时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'participantsCount', label: '实际参与人数', visible: true, type: 'number', group: 'detail' },
        { prop: 'drillProcess', label: '演练过程描述', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'problemsFound', label: '发现的问题', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'lessonsLearned', label: '经验教训', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'improvementMeasures', label: '改进措施', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'evaluationScore', label: '评价分数', visible: true, type: 'number', group: 'detail' },
        { prop: 'evaluationTime', label: '评价时间', visible: true, type: 'datetime', group: 'detail' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', visible: true, type: 'select', group: 'system' },
        { prop: 'createDept', label: '创建部门', visible: true, type: 'number', group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'createBy', label: '创建人', visible: true, type: 'number', group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'updateBy', label: '更新人', visible: true, type: 'number', group: 'system' },
        { prop: 'remark', label: '备注', visible: true, type: 'input', group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('emergencyDrillSummary', fieldGroups);
}


// emergencyEvent字段配置
export function createEmergencyEventFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'eventCode', label: '事件编码', visible: true, type: 'input', group: 'basic' },
        { prop: 'eventTitle', label: '事件标题', visible: true, type: 'input', group: 'basic' },
        { prop: 'eventType', label: '事件类型', visible: true, type: 'input', group: 'basic' },
        { prop: 'eventLevel', label: '事件等级', visible: true, type: 'input', group: 'basic' },
        { prop: 'status', label: '状态', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'occurrenceTime', label: '发生时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'discoveryTime', label: '发现时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'reportTime', label: '报告时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'reporter', label: '报告人', visible: true, type: 'input', group: 'detail' },
        { prop: 'location', label: '发生地点', visible: true, type: 'input', group: 'detail' },
        { prop: 'affectedPersons', label: '受影响人员', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'eventDescription', label: '事件描述', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'immediateMeasures', label: '立即措施', visible: true, type: 'textarea', group: 'detail' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', visible: true, type: 'select', group: 'system' },
        { prop: 'createDept', label: '创建部门', visible: true, type: 'number', group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'createBy', label: '创建人', visible: true, type: 'number', group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'updateBy', label: '更新人', visible: true, type: 'number', group: 'system' },
        { prop: 'remark', label: '备注', visible: true, type: 'input', group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('emergencyEvent', fieldGroups);
}


// emergencyEventResponse字段配置
export function createEmergencyEventResponseFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'eventId', label: '事件ID', visible: true, type: 'number', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'responseTeam', label: '响应队伍', visible: true, type: 'input', group: 'detail' },
        { prop: 'responseStartTime', label: '响应开始时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'responseEndTime', label: '响应结束时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'responseMeasures', label: '响应措施', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'responsiblePerson', label: '责任人', visible: true, type: 'input', group: 'detail' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', visible: true, type: 'select', group: 'system' },
        { prop: 'createDept', label: '创建部门', visible: true, type: 'number', group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'createBy', label: '创建人', visible: true, type: 'number', group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'updateBy', label: '更新人', visible: true, type: 'number', group: 'system' },
        { prop: 'remark', label: '备注', visible: true, type: 'input', group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('emergencyEventResponse', fieldGroups);
}


// emergencyEventTreatment字段配置
export function createEmergencyEventTreatmentFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'eventId', label: '事件ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'patientId', label: '患者ID', visible: true, type: 'input', group: 'basic' },
        { prop: 'patientName', label: '患者姓名', visible: true, type: 'input', group: 'basic' },
        { prop: 'diagnosis', label: '诊断', visible: true, type: 'textarea', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'treatmentMeasures', label: '救治措施', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'treatmentResult', label: '救治结果', visible: true, type: 'input', group: 'detail' },
        { prop: 'treatingPhysician', label: '救治医师', visible: true, type: 'input', group: 'detail' },
        { prop: 'treatmentTime', label: '救治时间', visible: true, type: 'datetime', group: 'detail' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', visible: true, type: 'select', group: 'system' },
        { prop: 'createDept', label: '创建部门', visible: true, type: 'number', group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'createBy', label: '创建人', visible: true, type: 'number', group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'updateBy', label: '更新人', visible: true, type: 'number', group: 'system' },
        { prop: 'remark', label: '备注', visible: true, type: 'input', group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('emergencyEventTreatment', fieldGroups);
}


// emergencyIncident字段配置
export function createEmergencyIncidentFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'incidentCode', label: '事件编码', visible: true, type: 'input', group: 'basic' },
        { prop: 'incidentTitle', label: '事件标题', visible: true, type: 'input', group: 'basic' },
        { prop: 'incidentType', label: '事件类型', visible: true, type: 'input', group: 'basic' },
        { prop: 'incidentLevel', label: '事件等级', visible: true, type: 'input', group: 'basic' },
        { prop: 'economicLoss', label: '经济损失', visible: true, type: 'number', group: 'basic' },
        { prop: 'status', label: '状态', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'occurrenceTime', label: '发生时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'location', label: '发生地点', visible: true, type: 'input', group: 'detail' },
        { prop: 'description', label: '事件描述', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'affectedPersons', label: '受影响人员', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'responseTeam', label: '响应队伍', visible: true, type: 'input', group: 'detail' },
        { prop: 'responseMeasures', label: '响应措施', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'resolutionTime', label: '解决时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'casualties', label: '伤亡情况', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'lessonsLearned', label: '经验教训', visible: true, type: 'textarea', group: 'detail' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', visible: true, type: 'select', group: 'system' },
        { prop: 'createDept', label: '创建部门', visible: true, type: 'number', group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'createBy', label: '创建人', visible: true, type: 'number', group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'updateBy', label: '更新人', visible: true, type: 'number', group: 'system' },
        { prop: 'remark', label: '备注', visible: true, type: 'input', group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('emergencyIncident', fieldGroups);
}


// emergencyMedicalSupport字段配置
export function createEmergencyMedicalSupportFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'resourceCode', label: '资源编码', visible: true, type: 'input', group: 'basic' },
        { prop: 'resourceName', label: '资源名称', visible: true, type: 'input', group: 'basic' },
        { prop: 'resourceType', label: '资源类型', visible: true, type: 'input', group: 'basic' },
        { prop: 'status', label: '状态', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'department', label: '所属部门', visible: true, type: 'input', group: 'detail' },
        { prop: 'location', label: '存放地点', visible: true, type: 'input', group: 'detail' },
        { prop: 'quantity', label: '数量', visible: true, type: 'number', group: 'detail' },
        { prop: 'unit', label: '单位', visible: true, type: 'input', group: 'detail' },
        { prop: 'contactPerson', label: '联系人', visible: true, type: 'input', group: 'detail' },
        { prop: 'contactInfo', label: '联系方式', visible: true, type: 'input', group: 'detail' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', visible: true, type: 'select', group: 'system' },
        { prop: 'createDept', label: '创建部门', visible: true, type: 'number', group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'createBy', label: '创建人', visible: true, type: 'number', group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'updateBy', label: '更新人', visible: true, type: 'number', group: 'system' },
        { prop: 'remark', label: '备注', visible: true, type: 'input', group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('emergencyMedicalSupport', fieldGroups);
}


// emergencyPlan字段配置
export function createEmergencyPlanFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'planCode', label: '预案编码', visible: true, type: 'input', group: 'basic' },
        { prop: 'planName', label: '预案名称', visible: true, type: 'input', group: 'basic' },
        { prop: 'planType', label: '预案类型：fire-消防预案，medical-医疗应急预案，disaster-灾害预案，infection-感染控制预案', visible: true, type: 'input', group: 'basic' },
        { prop: 'status', label: '状态：draft-草稿，review-审核中，approved-已批准，archived-已归档', visible: true, type: 'input', group: 'basic' },
        { prop: 'fileName', label: '文件名称', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'version', label: '版本号', visible: true, type: 'input', group: 'detail' },
        { prop: 'effectiveDate', label: '生效日期', visible: true, type: 'date', group: 'detail' },
        { prop: 'reviewDate', label: '审核日期', visible: true, type: 'date', group: 'detail' },
        { prop: 'nextReviewDate', label: '下次审核日期', visible: true, type: 'date', group: 'detail' },
        { prop: 'keywords', label: '关键词', visible: true, type: 'input', group: 'detail' },
        { prop: 'filePath', label: '文件路径', visible: true, type: 'input', group: 'detail' },
        { prop: 'fileSize', label: '文件大小', visible: true, type: 'number', group: 'detail' },
        { prop: 'uploadBy', label: '上传者', visible: true, type: 'input', group: 'detail' },
        { prop: 'uploadTime', label: '上传时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'approveBy', label: '批准人', visible: true, type: 'input', group: 'detail' },
        { prop: 'approveTime', label: '批准时间', visible: true, type: 'datetime', group: 'detail' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', visible: true, type: 'select', group: 'system' },
        { prop: 'createDept', label: '创建部门', visible: true, type: 'number', group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'createBy', label: '创建人', visible: true, type: 'number', group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'updateBy', label: '更新人', visible: true, type: 'number', group: 'system' },
        { prop: 'remark', label: '备注', visible: true, type: 'input', group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('emergencyPlan', fieldGroups);
}


// emergencyPlanApproval字段配置
export function createEmergencyPlanApprovalFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'planId', label: '预案ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'approverId', label: '审批人ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'approverName', label: '审批人姓名', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'approvalStage', label: '审批阶段', visible: true, type: 'input', group: 'detail' },
        { prop: 'approvalOpinion', label: '审批意见', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'approvalResult', label: '审批结果：approved-通过，rejected-驳回', visible: true, type: 'input', group: 'detail' },
        { prop: 'approvalTime', label: '审批时间', visible: true, type: 'datetime', group: 'detail' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', visible: true, type: 'select', group: 'system' },
        { prop: 'createDept', label: '创建部门', visible: true, type: 'number', group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'createBy', label: '创建人', visible: true, type: 'number', group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'updateBy', label: '更新人', visible: true, type: 'number', group: 'system' },
        { prop: 'remark', label: '备注', visible: true, type: 'input', group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('emergencyPlanApproval', fieldGroups);
}


// emergencyTeam字段配置
export function createEmergencyTeamFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'teamCode', label: '队伍编码', visible: true, type: 'input', group: 'basic' },
        { prop: 'teamName', label: '队伍名称', visible: true, type: 'input', group: 'basic' },
        { prop: 'teamType', label: '队伍类型', visible: true, type: 'input', group: 'basic' },
        { prop: 'status', label: '状态', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'specialty', label: '专业特长', visible: true, type: 'input', group: 'detail' },
        { prop: 'leader', label: '队长', visible: true, type: 'input', group: 'detail' },
        { prop: 'contactInfo', label: '联系方式', visible: true, type: 'input', group: 'detail' },
        { prop: 'memberCount', label: '成员数量', visible: true, type: 'number', group: 'detail' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', visible: true, type: 'select', group: 'system' },
        { prop: 'createDept', label: '创建部门', visible: true, type: 'number', group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'createBy', label: '创建人', visible: true, type: 'number', group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'updateBy', label: '更新人', visible: true, type: 'number', group: 'system' },
        { prop: 'remark', label: '备注', visible: true, type: 'input', group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('emergencyTeam', fieldGroups);
}


// emergencyTeamMember字段配置
export function createEmergencyTeamMemberFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'teamId', label: '队伍ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'memberName', label: '成员姓名', visible: true, type: 'input', group: 'basic' },
        { prop: 'memberType', label: '成员类型', visible: true, type: 'input', group: 'basic' },
        { prop: 'status', label: '状态', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'department', label: '所在部门', visible: true, type: 'input', group: 'detail' },
        { prop: 'position', label: '职位', visible: true, type: 'input', group: 'detail' },
        { prop: 'specialty', label: '专业特长', visible: true, type: 'input', group: 'detail' },
        { prop: 'contactInfo', label: '联系方式', visible: true, type: 'input', group: 'detail' },
        { prop: 'emergencyContact', label: '紧急联系人', visible: true, type: 'input', group: 'detail' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', visible: true, type: 'select', group: 'system' },
        { prop: 'createDept', label: '创建部门', visible: true, type: 'number', group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'createBy', label: '创建人', visible: true, type: 'number', group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'updateBy', label: '更新人', visible: true, type: 'number', group: 'system' },
        { prop: 'remark', label: '备注', visible: true, type: 'input', group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('emergencyTeamMember', fieldGroups);
}


// importantMedicalEvent字段配置
export function createImportantMedicalEventFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'eventNo', label: '事件编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'eventType', label: '事件类型 death-死亡/unplanned_surgery-非计划手术/major_surgery-重大手术/critical_value-危急值等', visible: true, type: 'input', group: 'basic' },
        { prop: 'patientId', label: '患者ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'patientName', label: '患者姓名', visible: true, type: 'input', group: 'basic' },
        { prop: 'visitNo', label: '就诊号', visible: true, type: 'input', group: 'basic' },
        { prop: 'departmentId', label: '科室ID', visible: true, type: 'number', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'departmentName', label: '科室名称', visible: true, type: 'input', group: 'detail' },
        { prop: 'responsibleDoctor', label: '责任医生', visible: true, type: 'input', group: 'detail' },
        { prop: 'eventTime', label: '事件时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'eventDescription', label: '事件描述', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'eventLevel', label: '事件级别', visible: true, type: 'input', group: 'detail' },
        { prop: 'notifyUsers', label: '通知人员列表JSON', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'sourceSystem', label: '来源系统', visible: true, type: 'input', group: 'detail' },
        { prop: 'isNotified', label: '是否已通知 1-是 0-否', visible: true, type: 'number', group: 'detail' },
        { prop: 'notifyTime', label: '通知时间', visible: true, type: 'datetime', group: 'detail' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', visible: true, type: 'select', group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'createBy', label: '创建人', visible: true, type: 'number', group: 'system' },
        { prop: 'createDept', label: '创建部门', visible: true, type: 'number', group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'updateBy', label: '更新人', visible: true, type: 'number', group: 'system' },
        { prop: 'remark', label: '备注', visible: true, type: 'input', group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('importantMedicalEvent', fieldGroups);
}
