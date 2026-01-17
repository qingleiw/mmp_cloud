import { SearchConfigManager, SearchFieldGroup } from '../searchConfigManager';

// emergencyDrillPlan搜索配置
export function createEmergencyDrillPlanSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'planCode', label: '计划编码', type: 'input', visible: true, placeholder: '请输入计划编码' },
        { prop: 'planName', label: '计划名称', type: 'input', visible: true, placeholder: '请输入计划名称' },
        { prop: 'drillType', label: '演练类型', type: 'input', visible: true, placeholder: '请输入演练类型' },
        { prop: 'status', label: '状态：planned-已计划，executing-执行中，completed-已完成', type: 'input', visible: false, placeholder: '请输入状态：planned-已计划，executing-执行中，completed-已完成' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'drillScenario', label: '演练场景', type: 'input', visible: false, placeholder: '请输入演练场景' },
        { prop: 'plannedDate', label: '计划日期', type: 'daterange', visible: false, placeholder: '请输入计划日期', startProp: 'plannedDateStart', endProp: 'plannedDateEnd' },
        { prop: 'actualDate', label: '实际日期', type: 'daterange', visible: false, placeholder: '请输入实际日期', startProp: 'actualDateStart', endProp: 'actualDateEnd' },
        { prop: 'location', label: '演练地点', type: 'input', visible: false, placeholder: '请输入演练地点' },
        { prop: 'organizer', label: '组织者', type: 'input', visible: false, placeholder: '请输入组织者' },
        { prop: 'participants', label: '参与人员', type: 'input', visible: false, placeholder: '请输入参与人员' },
        { prop: 'objectives', label: '演练目标', type: 'input', visible: false, placeholder: '请输入演练目标' },
        { prop: 'procedures', label: '演练流程', type: 'input', visible: false, placeholder: '请输入演练流程' },
        { prop: 'evaluationCriteria', label: '评估标准', type: 'input', visible: false, placeholder: '请输入评估标准' },
        { prop: 'drillResult', label: '演练结果', type: 'input', visible: false, placeholder: '请输入演练结果' },
        { prop: 'lessonsLearned', label: '经验教训', type: 'input', visible: false, placeholder: '请输入经验教训' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', type: 'select', visible: false, placeholder: '请输入是否删除' },
        { prop: 'createDept', label: '创建部门', type: 'number', visible: false, placeholder: '请输入创建部门' },
        { prop: 'createTime', label: '创建时间', type: 'daterange', visible: false, placeholder: '请输入创建时间', startProp: 'createTimeStart', endProp: 'createTimeEnd' },
        { prop: 'createBy', label: '创建人', type: 'number', visible: false, placeholder: '请输入创建人' },
        { prop: 'updateTime', label: '更新时间', type: 'daterange', visible: false, placeholder: '请输入更新时间', startProp: 'updateTimeStart', endProp: 'updateTimeEnd' },
        { prop: 'updateBy', label: '更新人', type: 'number', visible: false, placeholder: '请输入更新人' },
        { prop: 'remark', label: '备注', type: 'input', visible: false, placeholder: '请输入备注' }
      ]
    }
  ];

  return new SearchConfigManager('emergencyDrillPlan', searchFieldGroups);
}


// emergencyDrillSummary搜索配置
export function createEmergencyDrillSummarySearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'planId', label: '计划ID', type: 'number', visible: true, placeholder: '请输入计划ID' },
        { prop: 'evaluatorId', label: '评价人ID', type: 'number', visible: true, placeholder: '请输入评价人ID' },
        { prop: 'evaluatorName', label: '评价人姓名', type: 'input', visible: true, placeholder: '请输入评价人姓名' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'actualStartTime', label: '实际开始时间', type: 'daterange', visible: false, placeholder: '请输入实际开始时间', startProp: 'actualStartTimeStart', endProp: 'actualStartTimeEnd' },
        { prop: 'actualEndTime', label: '实际结束时间', type: 'daterange', visible: false, placeholder: '请输入实际结束时间', startProp: 'actualEndTimeStart', endProp: 'actualEndTimeEnd' },
        { prop: 'participantsCount', label: '实际参与人数', type: 'number', visible: false, placeholder: '请输入实际参与人数' },
        { prop: 'drillProcess', label: '演练过程描述', type: 'input', visible: false, placeholder: '请输入演练过程描述' },
        { prop: 'problemsFound', label: '发现的问题', type: 'input', visible: false, placeholder: '请输入发现的问题' },
        { prop: 'lessonsLearned', label: '经验教训', type: 'input', visible: false, placeholder: '请输入经验教训' },
        { prop: 'improvementMeasures', label: '改进措施', type: 'input', visible: false, placeholder: '请输入改进措施' },
        { prop: 'evaluationScore', label: '评价分数', type: 'number', visible: false, placeholder: '请输入评价分数' },
        { prop: 'evaluationTime', label: '评价时间', type: 'daterange', visible: false, placeholder: '请输入评价时间', startProp: 'evaluationTimeStart', endProp: 'evaluationTimeEnd' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', type: 'select', visible: false, placeholder: '请输入是否删除' },
        { prop: 'createDept', label: '创建部门', type: 'number', visible: false, placeholder: '请输入创建部门' },
        { prop: 'createTime', label: '创建时间', type: 'daterange', visible: false, placeholder: '请输入创建时间', startProp: 'createTimeStart', endProp: 'createTimeEnd' },
        { prop: 'createBy', label: '创建人', type: 'number', visible: false, placeholder: '请输入创建人' },
        { prop: 'updateTime', label: '更新时间', type: 'daterange', visible: false, placeholder: '请输入更新时间', startProp: 'updateTimeStart', endProp: 'updateTimeEnd' },
        { prop: 'updateBy', label: '更新人', type: 'number', visible: false, placeholder: '请输入更新人' },
        { prop: 'remark', label: '备注', type: 'input', visible: false, placeholder: '请输入备注' }
      ]
    }
  ];

  return new SearchConfigManager('emergencyDrillSummary', searchFieldGroups);
}


// emergencyEvent搜索配置
export function createEmergencyEventSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'eventCode', label: '事件编码', type: 'input', visible: true, placeholder: '请输入事件编码' },
        { prop: 'eventTitle', label: '事件标题', type: 'input', visible: true, placeholder: '请输入事件标题' },
        { prop: 'eventType', label: '事件类型', type: 'input', visible: true, placeholder: '请输入事件类型' },
        { prop: 'eventLevel', label: '事件等级', type: 'input', visible: false, placeholder: '请输入事件等级' },
        { prop: 'status', label: '状态', type: 'input', visible: false, placeholder: '请输入状态' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'occurrenceTime', label: '发生时间', type: 'daterange', visible: false, placeholder: '请输入发生时间', startProp: 'occurrenceTimeStart', endProp: 'occurrenceTimeEnd' },
        { prop: 'discoveryTime', label: '发现时间', type: 'daterange', visible: false, placeholder: '请输入发现时间', startProp: 'discoveryTimeStart', endProp: 'discoveryTimeEnd' },
        { prop: 'reportTime', label: '报告时间', type: 'daterange', visible: false, placeholder: '请输入报告时间', startProp: 'reportTimeStart', endProp: 'reportTimeEnd' },
        { prop: 'reporter', label: '报告人', type: 'input', visible: false, placeholder: '请输入报告人' },
        { prop: 'location', label: '发生地点', type: 'input', visible: false, placeholder: '请输入发生地点' },
        { prop: 'affectedPersons', label: '受影响人员', type: 'input', visible: false, placeholder: '请输入受影响人员' },
        { prop: 'eventDescription', label: '事件描述', type: 'input', visible: false, placeholder: '请输入事件描述' },
        { prop: 'immediateMeasures', label: '立即措施', type: 'input', visible: false, placeholder: '请输入立即措施' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', type: 'select', visible: false, placeholder: '请输入是否删除' },
        { prop: 'createDept', label: '创建部门', type: 'number', visible: false, placeholder: '请输入创建部门' },
        { prop: 'createTime', label: '创建时间', type: 'daterange', visible: false, placeholder: '请输入创建时间', startProp: 'createTimeStart', endProp: 'createTimeEnd' },
        { prop: 'createBy', label: '创建人', type: 'number', visible: false, placeholder: '请输入创建人' },
        { prop: 'updateTime', label: '更新时间', type: 'daterange', visible: false, placeholder: '请输入更新时间', startProp: 'updateTimeStart', endProp: 'updateTimeEnd' },
        { prop: 'updateBy', label: '更新人', type: 'number', visible: false, placeholder: '请输入更新人' },
        { prop: 'remark', label: '备注', type: 'input', visible: false, placeholder: '请输入备注' }
      ]
    }
  ];

  return new SearchConfigManager('emergencyEvent', searchFieldGroups);
}


// emergencyEventResponse搜索配置
export function createEmergencyEventResponseSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'eventId', label: '事件ID', type: 'number', visible: true, placeholder: '请输入事件ID' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'responseTeam', label: '响应队伍', type: 'input', visible: true, placeholder: '请输入响应队伍' },
        { prop: 'responseStartTime', label: '响应开始时间', type: 'daterange', visible: true, placeholder: '请输入响应开始时间', startProp: 'responseStartTimeStart', endProp: 'responseStartTimeEnd' },
        { prop: 'responseEndTime', label: '响应结束时间', type: 'daterange', visible: false, placeholder: '请输入响应结束时间', startProp: 'responseEndTimeStart', endProp: 'responseEndTimeEnd' },
        { prop: 'responseMeasures', label: '响应措施', type: 'input', visible: false, placeholder: '请输入响应措施' },
        { prop: 'responsiblePerson', label: '责任人', type: 'input', visible: false, placeholder: '请输入责任人' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', type: 'select', visible: false, placeholder: '请输入是否删除' },
        { prop: 'createDept', label: '创建部门', type: 'number', visible: false, placeholder: '请输入创建部门' },
        { prop: 'createTime', label: '创建时间', type: 'daterange', visible: false, placeholder: '请输入创建时间', startProp: 'createTimeStart', endProp: 'createTimeEnd' },
        { prop: 'createBy', label: '创建人', type: 'number', visible: false, placeholder: '请输入创建人' },
        { prop: 'updateTime', label: '更新时间', type: 'daterange', visible: false, placeholder: '请输入更新时间', startProp: 'updateTimeStart', endProp: 'updateTimeEnd' },
        { prop: 'updateBy', label: '更新人', type: 'number', visible: false, placeholder: '请输入更新人' },
        { prop: 'remark', label: '备注', type: 'input', visible: false, placeholder: '请输入备注' }
      ]
    }
  ];

  return new SearchConfigManager('emergencyEventResponse', searchFieldGroups);
}


// emergencyEventTreatment搜索配置
export function createEmergencyEventTreatmentSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'eventId', label: '事件ID', type: 'number', visible: true, placeholder: '请输入事件ID' },
        { prop: 'patientId', label: '患者ID', type: 'input', visible: true, placeholder: '请输入患者ID' },
        { prop: 'patientName', label: '患者姓名', type: 'input', visible: true, placeholder: '请输入患者姓名' },
        { prop: 'diagnosis', label: '诊断', type: 'input', visible: false, placeholder: '请输入诊断' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'treatmentMeasures', label: '救治措施', type: 'input', visible: false, placeholder: '请输入救治措施' },
        { prop: 'treatmentResult', label: '救治结果', type: 'input', visible: false, placeholder: '请输入救治结果' },
        { prop: 'treatingPhysician', label: '救治医师', type: 'input', visible: false, placeholder: '请输入救治医师' },
        { prop: 'treatmentTime', label: '救治时间', type: 'daterange', visible: false, placeholder: '请输入救治时间', startProp: 'treatmentTimeStart', endProp: 'treatmentTimeEnd' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', type: 'select', visible: false, placeholder: '请输入是否删除' },
        { prop: 'createDept', label: '创建部门', type: 'number', visible: false, placeholder: '请输入创建部门' },
        { prop: 'createTime', label: '创建时间', type: 'daterange', visible: false, placeholder: '请输入创建时间', startProp: 'createTimeStart', endProp: 'createTimeEnd' },
        { prop: 'createBy', label: '创建人', type: 'number', visible: false, placeholder: '请输入创建人' },
        { prop: 'updateTime', label: '更新时间', type: 'daterange', visible: false, placeholder: '请输入更新时间', startProp: 'updateTimeStart', endProp: 'updateTimeEnd' },
        { prop: 'updateBy', label: '更新人', type: 'number', visible: false, placeholder: '请输入更新人' },
        { prop: 'remark', label: '备注', type: 'input', visible: false, placeholder: '请输入备注' }
      ]
    }
  ];

  return new SearchConfigManager('emergencyEventTreatment', searchFieldGroups);
}


// emergencyIncident搜索配置
export function createEmergencyIncidentSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'incidentCode', label: '事件编码', type: 'input', visible: true, placeholder: '请输入事件编码' },
        { prop: 'incidentTitle', label: '事件标题', type: 'input', visible: true, placeholder: '请输入事件标题' },
        { prop: 'incidentType', label: '事件类型', type: 'input', visible: true, placeholder: '请输入事件类型' },
        { prop: 'incidentLevel', label: '事件等级', type: 'input', visible: false, placeholder: '请输入事件等级' },
        { prop: 'economicLoss', label: '经济损失', type: 'number', visible: false, placeholder: '请输入经济损失' },
        { prop: 'status', label: '状态', type: 'input', visible: false, placeholder: '请输入状态' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'occurrenceTime', label: '发生时间', type: 'daterange', visible: false, placeholder: '请输入发生时间', startProp: 'occurrenceTimeStart', endProp: 'occurrenceTimeEnd' },
        { prop: 'location', label: '发生地点', type: 'input', visible: false, placeholder: '请输入发生地点' },
        { prop: 'description', label: '事件描述', type: 'input', visible: false, placeholder: '请输入事件描述' },
        { prop: 'affectedPersons', label: '受影响人员', type: 'input', visible: false, placeholder: '请输入受影响人员' },
        { prop: 'responseTeam', label: '响应队伍', type: 'input', visible: false, placeholder: '请输入响应队伍' },
        { prop: 'responseMeasures', label: '响应措施', type: 'input', visible: false, placeholder: '请输入响应措施' },
        { prop: 'resolutionTime', label: '解决时间', type: 'daterange', visible: false, placeholder: '请输入解决时间', startProp: 'resolutionTimeStart', endProp: 'resolutionTimeEnd' },
        { prop: 'casualties', label: '伤亡情况', type: 'input', visible: false, placeholder: '请输入伤亡情况' },
        { prop: 'lessonsLearned', label: '经验教训', type: 'input', visible: false, placeholder: '请输入经验教训' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', type: 'select', visible: false, placeholder: '请输入是否删除' },
        { prop: 'createDept', label: '创建部门', type: 'number', visible: false, placeholder: '请输入创建部门' },
        { prop: 'createTime', label: '创建时间', type: 'daterange', visible: false, placeholder: '请输入创建时间', startProp: 'createTimeStart', endProp: 'createTimeEnd' },
        { prop: 'createBy', label: '创建人', type: 'number', visible: false, placeholder: '请输入创建人' },
        { prop: 'updateTime', label: '更新时间', type: 'daterange', visible: false, placeholder: '请输入更新时间', startProp: 'updateTimeStart', endProp: 'updateTimeEnd' },
        { prop: 'updateBy', label: '更新人', type: 'number', visible: false, placeholder: '请输入更新人' },
        { prop: 'remark', label: '备注', type: 'input', visible: false, placeholder: '请输入备注' }
      ]
    }
  ];

  return new SearchConfigManager('emergencyIncident', searchFieldGroups);
}


// emergencyMedicalSupport搜索配置
export function createEmergencyMedicalSupportSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'resourceCode', label: '资源编码', type: 'input', visible: true, placeholder: '请输入资源编码' },
        { prop: 'resourceName', label: '资源名称', type: 'input', visible: true, placeholder: '请输入资源名称' },
        { prop: 'resourceType', label: '资源类型', type: 'input', visible: true, placeholder: '请输入资源类型' },
        { prop: 'status', label: '状态', type: 'input', visible: false, placeholder: '请输入状态' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'department', label: '所属部门', type: 'input', visible: false, placeholder: '请输入所属部门' },
        { prop: 'location', label: '存放地点', type: 'input', visible: false, placeholder: '请输入存放地点' },
        { prop: 'quantity', label: '数量', type: 'number', visible: false, placeholder: '请输入数量' },
        { prop: 'unit', label: '单位', type: 'input', visible: false, placeholder: '请输入单位' },
        { prop: 'contactPerson', label: '联系人', type: 'input', visible: false, placeholder: '请输入联系人' },
        { prop: 'contactInfo', label: '联系方式', type: 'input', visible: false, placeholder: '请输入联系方式' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', type: 'select', visible: false, placeholder: '请输入是否删除' },
        { prop: 'createDept', label: '创建部门', type: 'number', visible: false, placeholder: '请输入创建部门' },
        { prop: 'createTime', label: '创建时间', type: 'daterange', visible: false, placeholder: '请输入创建时间', startProp: 'createTimeStart', endProp: 'createTimeEnd' },
        { prop: 'createBy', label: '创建人', type: 'number', visible: false, placeholder: '请输入创建人' },
        { prop: 'updateTime', label: '更新时间', type: 'daterange', visible: false, placeholder: '请输入更新时间', startProp: 'updateTimeStart', endProp: 'updateTimeEnd' },
        { prop: 'updateBy', label: '更新人', type: 'number', visible: false, placeholder: '请输入更新人' },
        { prop: 'remark', label: '备注', type: 'input', visible: false, placeholder: '请输入备注' }
      ]
    }
  ];

  return new SearchConfigManager('emergencyMedicalSupport', searchFieldGroups);
}


// emergencyPlan搜索配置
export function createEmergencyPlanSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'planCode', label: '预案编码', type: 'input', visible: true, placeholder: '请输入预案编码' },
        { prop: 'planName', label: '预案名称', type: 'input', visible: true, placeholder: '请输入预案名称' },
        { prop: 'planType', label: '预案类型：fire-消防预案，medical-医疗应急预案，disaster-灾害预案，infection-感染控制预案', type: 'input', visible: true, placeholder: '请输入预案类型：fire-消防预案，medical-医疗应急预案，disaster-灾害预案，infection-感染控制预案' },
        { prop: 'status', label: '状态：draft-草稿，review-审核中，approved-已批准，archived-已归档', type: 'input', visible: false, placeholder: '请输入状态：draft-草稿，review-审核中，approved-已批准，archived-已归档' },
        { prop: 'fileName', label: '文件名称', type: 'input', visible: false, placeholder: '请输入文件名称' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'version', label: '版本号', type: 'input', visible: false, placeholder: '请输入版本号' },
        { prop: 'effectiveDate', label: '生效日期', type: 'daterange', visible: false, placeholder: '请输入生效日期', startProp: 'effectiveDateStart', endProp: 'effectiveDateEnd' },
        { prop: 'reviewDate', label: '审核日期', type: 'daterange', visible: false, placeholder: '请输入审核日期', startProp: 'reviewDateStart', endProp: 'reviewDateEnd' },
        { prop: 'nextReviewDate', label: '下次审核日期', type: 'daterange', visible: false, placeholder: '请输入下次审核日期', startProp: 'nextReviewDateStart', endProp: 'nextReviewDateEnd' },
        { prop: 'keywords', label: '关键词', type: 'input', visible: false, placeholder: '请输入关键词' },
        { prop: 'filePath', label: '文件路径', type: 'input', visible: false, placeholder: '请输入文件路径' },
        { prop: 'fileSize', label: '文件大小', type: 'number', visible: false, placeholder: '请输入文件大小' },
        { prop: 'uploadBy', label: '上传者', type: 'input', visible: false, placeholder: '请输入上传者' },
        { prop: 'uploadTime', label: '上传时间', type: 'daterange', visible: false, placeholder: '请输入上传时间', startProp: 'uploadTimeStart', endProp: 'uploadTimeEnd' },
        { prop: 'approveBy', label: '批准人', type: 'input', visible: false, placeholder: '请输入批准人' },
        { prop: 'approveTime', label: '批准时间', type: 'daterange', visible: false, placeholder: '请输入批准时间', startProp: 'approveTimeStart', endProp: 'approveTimeEnd' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', type: 'select', visible: false, placeholder: '请输入是否删除' },
        { prop: 'createDept', label: '创建部门', type: 'number', visible: false, placeholder: '请输入创建部门' },
        { prop: 'createTime', label: '创建时间', type: 'daterange', visible: false, placeholder: '请输入创建时间', startProp: 'createTimeStart', endProp: 'createTimeEnd' },
        { prop: 'createBy', label: '创建人', type: 'number', visible: false, placeholder: '请输入创建人' },
        { prop: 'updateTime', label: '更新时间', type: 'daterange', visible: false, placeholder: '请输入更新时间', startProp: 'updateTimeStart', endProp: 'updateTimeEnd' },
        { prop: 'updateBy', label: '更新人', type: 'number', visible: false, placeholder: '请输入更新人' },
        { prop: 'remark', label: '备注', type: 'input', visible: false, placeholder: '请输入备注' }
      ]
    }
  ];

  return new SearchConfigManager('emergencyPlan', searchFieldGroups);
}


// emergencyPlanApproval搜索配置
export function createEmergencyPlanApprovalSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'planId', label: '预案ID', type: 'number', visible: true, placeholder: '请输入预案ID' },
        { prop: 'approverId', label: '审批人ID', type: 'number', visible: true, placeholder: '请输入审批人ID' },
        { prop: 'approverName', label: '审批人姓名', type: 'input', visible: true, placeholder: '请输入审批人姓名' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'approvalStage', label: '审批阶段', type: 'input', visible: false, placeholder: '请输入审批阶段' },
        { prop: 'approvalOpinion', label: '审批意见', type: 'input', visible: false, placeholder: '请输入审批意见' },
        { prop: 'approvalResult', label: '审批结果：approved-通过，rejected-驳回', type: 'input', visible: false, placeholder: '请输入审批结果：approved-通过，rejected-驳回' },
        { prop: 'approvalTime', label: '审批时间', type: 'daterange', visible: false, placeholder: '请输入审批时间', startProp: 'approvalTimeStart', endProp: 'approvalTimeEnd' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', type: 'select', visible: false, placeholder: '请输入是否删除' },
        { prop: 'createDept', label: '创建部门', type: 'number', visible: false, placeholder: '请输入创建部门' },
        { prop: 'createTime', label: '创建时间', type: 'daterange', visible: false, placeholder: '请输入创建时间', startProp: 'createTimeStart', endProp: 'createTimeEnd' },
        { prop: 'createBy', label: '创建人', type: 'number', visible: false, placeholder: '请输入创建人' },
        { prop: 'updateTime', label: '更新时间', type: 'daterange', visible: false, placeholder: '请输入更新时间', startProp: 'updateTimeStart', endProp: 'updateTimeEnd' },
        { prop: 'updateBy', label: '更新人', type: 'number', visible: false, placeholder: '请输入更新人' },
        { prop: 'remark', label: '备注', type: 'input', visible: false, placeholder: '请输入备注' }
      ]
    }
  ];

  return new SearchConfigManager('emergencyPlanApproval', searchFieldGroups);
}


// emergencyTeam搜索配置
export function createEmergencyTeamSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'teamCode', label: '队伍编码', type: 'input', visible: true, placeholder: '请输入队伍编码' },
        { prop: 'teamName', label: '队伍名称', type: 'input', visible: true, placeholder: '请输入队伍名称' },
        { prop: 'teamType', label: '队伍类型', type: 'input', visible: true, placeholder: '请输入队伍类型' },
        { prop: 'status', label: '状态', type: 'input', visible: false, placeholder: '请输入状态' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'specialty', label: '专业特长', type: 'input', visible: false, placeholder: '请输入专业特长' },
        { prop: 'leader', label: '队长', type: 'input', visible: false, placeholder: '请输入队长' },
        { prop: 'contactInfo', label: '联系方式', type: 'input', visible: false, placeholder: '请输入联系方式' },
        { prop: 'memberCount', label: '成员数量', type: 'number', visible: false, placeholder: '请输入成员数量' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', type: 'select', visible: false, placeholder: '请输入是否删除' },
        { prop: 'createDept', label: '创建部门', type: 'number', visible: false, placeholder: '请输入创建部门' },
        { prop: 'createTime', label: '创建时间', type: 'daterange', visible: false, placeholder: '请输入创建时间', startProp: 'createTimeStart', endProp: 'createTimeEnd' },
        { prop: 'createBy', label: '创建人', type: 'number', visible: false, placeholder: '请输入创建人' },
        { prop: 'updateTime', label: '更新时间', type: 'daterange', visible: false, placeholder: '请输入更新时间', startProp: 'updateTimeStart', endProp: 'updateTimeEnd' },
        { prop: 'updateBy', label: '更新人', type: 'number', visible: false, placeholder: '请输入更新人' },
        { prop: 'remark', label: '备注', type: 'input', visible: false, placeholder: '请输入备注' }
      ]
    }
  ];

  return new SearchConfigManager('emergencyTeam', searchFieldGroups);
}


// emergencyTeamMember搜索配置
export function createEmergencyTeamMemberSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'teamId', label: '队伍ID', type: 'number', visible: true, placeholder: '请输入队伍ID' },
        { prop: 'memberName', label: '成员姓名', type: 'input', visible: true, placeholder: '请输入成员姓名' },
        { prop: 'memberType', label: '成员类型', type: 'input', visible: true, placeholder: '请输入成员类型' },
        { prop: 'status', label: '状态', type: 'input', visible: false, placeholder: '请输入状态' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'department', label: '所在部门', type: 'input', visible: false, placeholder: '请输入所在部门' },
        { prop: 'position', label: '职位', type: 'input', visible: false, placeholder: '请输入职位' },
        { prop: 'specialty', label: '专业特长', type: 'input', visible: false, placeholder: '请输入专业特长' },
        { prop: 'contactInfo', label: '联系方式', type: 'input', visible: false, placeholder: '请输入联系方式' },
        { prop: 'emergencyContact', label: '紧急联系人', type: 'input', visible: false, placeholder: '请输入紧急联系人' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', type: 'select', visible: false, placeholder: '请输入是否删除' },
        { prop: 'createDept', label: '创建部门', type: 'number', visible: false, placeholder: '请输入创建部门' },
        { prop: 'createTime', label: '创建时间', type: 'daterange', visible: false, placeholder: '请输入创建时间', startProp: 'createTimeStart', endProp: 'createTimeEnd' },
        { prop: 'createBy', label: '创建人', type: 'number', visible: false, placeholder: '请输入创建人' },
        { prop: 'updateTime', label: '更新时间', type: 'daterange', visible: false, placeholder: '请输入更新时间', startProp: 'updateTimeStart', endProp: 'updateTimeEnd' },
        { prop: 'updateBy', label: '更新人', type: 'number', visible: false, placeholder: '请输入更新人' },
        { prop: 'remark', label: '备注', type: 'input', visible: false, placeholder: '请输入备注' }
      ]
    }
  ];

  return new SearchConfigManager('emergencyTeamMember', searchFieldGroups);
}


// importantMedicalEvent搜索配置
export function createImportantMedicalEventSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'eventNo', label: '事件编号', type: 'input', visible: true, placeholder: '请输入事件编号' },
        { prop: 'eventType', label: '事件类型 death-死亡/unplanned_surgery-非计划手术/major_surgery-重大手术/critical_value-危急值等', type: 'input', visible: true, placeholder: '请输入事件类型 death-死亡/unplanned_surgery-非计划手术/major_surgery-重大手术/critical_value-危急值等' },
        { prop: 'patientId', label: '患者ID', type: 'number', visible: true, placeholder: '请输入患者ID' },
        { prop: 'patientName', label: '患者姓名', type: 'input', visible: false, placeholder: '请输入患者姓名' },
        { prop: 'visitNo', label: '就诊号', type: 'input', visible: false, placeholder: '请输入就诊号' },
        { prop: 'departmentId', label: '科室ID', type: 'number', visible: false, placeholder: '请输入科室ID' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'departmentName', label: '科室名称', type: 'input', visible: false, placeholder: '请输入科室名称' },
        { prop: 'responsibleDoctor', label: '责任医生', type: 'input', visible: false, placeholder: '请输入责任医生' },
        { prop: 'eventTime', label: '事件时间', type: 'daterange', visible: false, placeholder: '请输入事件时间', startProp: 'eventTimeStart', endProp: 'eventTimeEnd' },
        { prop: 'eventDescription', label: '事件描述', type: 'input', visible: false, placeholder: '请输入事件描述' },
        { prop: 'eventLevel', label: '事件级别', type: 'input', visible: false, placeholder: '请输入事件级别' },
        { prop: 'notifyUsers', label: '通知人员列表JSON', type: 'input', visible: false, placeholder: '请输入通知人员列表JSON' },
        { prop: 'sourceSystem', label: '来源系统', type: 'input', visible: false, placeholder: '请输入来源系统' },
        { prop: 'isNotified', label: '是否已通知 1-是 0-否', type: 'number', visible: false, placeholder: '请输入是否已通知 1-是 0-否' },
        { prop: 'notifyTime', label: '通知时间', type: 'daterange', visible: false, placeholder: '请输入通知时间', startProp: 'notifyTimeStart', endProp: 'notifyTimeEnd' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', type: 'select', visible: false, placeholder: '请输入是否删除' },
        { prop: 'createTime', label: '创建时间', type: 'daterange', visible: false, placeholder: '请输入创建时间', startProp: 'createTimeStart', endProp: 'createTimeEnd' },
        { prop: 'createBy', label: '创建人', type: 'number', visible: false, placeholder: '请输入创建人' },
        { prop: 'createDept', label: '创建部门', type: 'number', visible: false, placeholder: '请输入创建部门' },
        { prop: 'updateTime', label: '更新时间', type: 'daterange', visible: false, placeholder: '请输入更新时间', startProp: 'updateTimeStart', endProp: 'updateTimeEnd' },
        { prop: 'updateBy', label: '更新人', type: 'number', visible: false, placeholder: '请输入更新人' },
        { prop: 'remark', label: '备注', type: 'input', visible: false, placeholder: '请输入备注' }
      ]
    }
  ];

  return new SearchConfigManager('importantMedicalEvent', searchFieldGroups);
}
