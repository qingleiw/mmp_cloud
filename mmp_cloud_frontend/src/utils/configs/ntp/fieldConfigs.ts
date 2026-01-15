import { FieldConfigManager, FieldGroup } from '../../fieldConfigManager';

// 新技术案例字段配置
export function createNewTechnologyCaseFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'caseTitle', label: '案例标题', visible: true, required: true, group: 'basic' },
        { prop: 'caseCode', label: '案例编码', visible: true, group: 'basic' },
        { prop: 'technologyType', label: '技术类型', visible: true, group: 'basic' },
        { prop: 'difficultyLevel', label: '难度等级', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'caseDescription', label: '案例描述', visible: true, group: 'detail' },
        { prop: 'clinicalApplication', label: '临床应用', visible: true, group: 'detail' },
        { prop: 'technicalFeatures', label: '技术特点', visible: true, group: 'detail' },
        { prop: 'expectedOutcomes', label: '预期结果', visible: true, group: 'detail' }
      ]
    },
    {
      name: 'operator',
      label: '操作信息',
      fields: [
        { prop: 'operator', label: '操作医生', visible: true, group: 'operator' },
        { prop: 'operationDate', label: '操作日期', visible: true, width: '120', group: 'operator' },
        { prop: 'operationTime', label: '操作时间', visible: true, width: '120', group: 'operator' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', visible: true, group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('newTechnologyCase', fieldGroups);
}

// 新技术目录字段配置
export function createNewTechnologyCatalogFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'catalogName', label: '目录名称', visible: true, required: true, group: 'basic' },
        { prop: 'catalogCode', label: '目录编码', visible: true, group: 'basic' },
        { prop: 'technologyCategory', label: '技术类别', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'description', label: '描述', visible: true, group: 'detail' },
        { prop: 'applicableScope', label: '适用范围', visible: true, group: 'detail' },
        { prop: 'technicalRequirements', label: '技术要求', visible: true, group: 'detail' }
      ]
    },
    {
      name: 'status',
      label: '状态信息',
      fields: [
        { prop: 'status', label: '状态', visible: true, group: 'status' },
        { prop: 'approvalStatus', label: '审批状态', visible: true, group: 'status' }
      ]
    }
  ];

  return new FieldConfigManager('newTechnologyCatalog', fieldGroups);
}

// 新技术扩展申请字段配置
export function createNewTechnologyExtensionApplyFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'applyNo', label: '申请编号', visible: true, required: true, group: 'basic' },
        { prop: 'technologyName', label: '技术名称', visible: true, required: true, group: 'basic' },
        { prop: 'applicantName', label: '申请人姓名', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'extensionReason', label: '扩展原因', visible: true, group: 'detail' },
        { prop: 'expectedBenefits', label: '预期效益', visible: true, group: 'detail' },
        { prop: 'riskAssessment', label: '风险评估', visible: true, group: 'detail' }
      ]
    },
    {
      name: 'approval',
      label: '审批信息',
      fields: [
        { prop: 'approvalStatus', label: '审批状态', visible: true, group: 'approval' },
        { prop: 'approverName', label: '审批人姓名', visible: true, group: 'approval' },
        { prop: 'approvalTime', label: '审批时间', visible: true, width: '180', group: 'approval' }
      ]
    }
  ];

  return new FieldConfigManager('newTechnologyExtensionApply', fieldGroups);
}

// 新技术映射字段配置
export function createNewTechnologyMappingFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'technologyId', label: '技术ID', visible: true, required: true, group: 'basic' },
        { prop: 'technologyName', label: '技术名称', visible: true, group: 'basic' },
        { prop: 'mappingType', label: '映射类型', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'mapping',
      label: '映射信息',
      fields: [
        { prop: 'sourceSystem', label: '源系统', visible: true, group: 'mapping' },
        { prop: 'targetSystem', label: '目标系统', visible: true, group: 'mapping' },
        { prop: 'mappingRule', label: '映射规则', visible: true, group: 'mapping' }
      ]
    },
    {
      name: 'status',
      label: '状态信息',
      fields: [
        { prop: 'status', label: '状态', visible: true, group: 'status' },
        { prop: 'isActive', label: '是否激活', visible: true, group: 'status' }
      ]
    }
  ];

  return fieldGroups;
}

// 新技术进度报告字段配置
export function createNewTechnologyProgressReportFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'reportNo', label: '报告编号', visible: true, required: true, group: 'basic' },
        { prop: 'technologyName', label: '技术名称', visible: true, group: 'basic' },
        { prop: 'reportPeriod', label: '报告周期', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'progress',
      label: '进度信息',
      fields: [
        { prop: 'progressPercentage', label: '进度百分比', visible: true, group: 'progress' },
        { prop: 'completedTasks', label: '已完成任务', visible: true, group: 'progress' },
        { prop: 'remainingTasks', label: '剩余任务', visible: true, group: 'progress' },
        { prop: 'progressDescription', label: '进度描述', visible: true, group: 'progress' }
      ]
    },
    {
      name: 'issues',
      label: '问题信息',
      fields: [
        { prop: 'issuesEncountered', label: '遇到的问题', visible: true, group: 'issues' },
        { prop: 'solutions', label: '解决方案', visible: true, group: 'issues' },
        { prop: 'nextSteps', label: '下一步计划', visible: true, group: 'issues' }
      ]
    }
  ];

  return fieldGroups;
}

// 新技术项目字段配置
export function createNewTechnologyProjectFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'projectNo', label: '项目编号', visible: true, required: true, group: 'basic' },
        { prop: 'projectName', label: '项目名称', visible: true, required: true, group: 'basic' },
        { prop: 'projectType', label: '项目类型', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'projectDescription', label: '项目描述', visible: true, group: 'detail' },
        { prop: 'researchObjectives', label: '研究目标', visible: true, group: 'detail' },
        { prop: 'expectedOutcomes', label: '预期成果', visible: true, group: 'detail' }
      ]
    },
    {
      name: 'team',
      label: '团队信息',
      fields: [
        { prop: 'projectLeader', label: '项目负责人', visible: true, group: 'team' },
        { prop: 'teamMembers', label: '团队成员', visible: true, group: 'team' },
        { prop: 'cooperatingUnits', label: '合作单位', visible: true, group: 'team' }
      ]
    },
    {
      name: 'timeline',
      label: '时间信息',
      fields: [
        { prop: 'startDate', label: '开始日期', visible: true, width: '120', group: 'timeline' },
        { prop: 'endDate', label: '结束日期', visible: true, width: '120', group: 'timeline' },
        { prop: 'milestones', label: '里程碑', visible: true, group: 'timeline' }
      ]
    },
    {
      name: 'status',
      label: '状态信息',
      fields: [
        { prop: 'projectStatus', label: '项目状态', visible: true, group: 'status' },
        { prop: 'approvalStatus', label: '审批状态', visible: true, group: 'status' }
      ]
    }
  ];

  return fieldGroups;
}

// 新技术实施字段配置
export function createNewTechnologyImplementationFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'implementationNo', label: '实施编号', visible: true, required: true, group: 'basic' },
        { prop: 'technologyName', label: '技术名称', visible: true, group: 'basic' },
        { prop: 'implementationPhase', label: '实施阶段', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'implementationPlan', label: '实施计划', visible: true, group: 'detail' },
        { prop: 'resourceRequirements', label: '资源需求', visible: true, group: 'detail' },
        { prop: 'trainingRequirements', label: '培训需求', visible: true, group: 'detail' }
      ]
    },
    {
      name: 'progress',
      label: '进度信息',
      fields: [
        { prop: 'progressStatus', label: '进度状态', visible: true, group: 'progress' },
        { prop: 'completionPercentage', label: '完成百分比', visible: true, group: 'progress' },
        { prop: 'issuesAndSolutions', label: '问题及解决方案', visible: true, group: 'progress' }
      ]
    },
    {
      name: 'evaluation',
      label: '评估信息',
      fields: [
        { prop: 'evaluationResults', label: '评估结果', visible: true, group: 'evaluation' },
        { prop: 'benefitsAchieved', label: '实现效益', visible: true, group: 'evaluation' },
        { prop: 'lessonsLearned', label: '经验教训', visible: true, group: 'evaluation' }
      ]
    }
  ];

  return fieldGroups;
}

// 新技术项目考核评估字段配置
export function createNewTechnologyProjectAssessmentFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: false, group: 'basic' },
        { prop: 'assessmentYear', label: '考核年份', visible: true, group: 'basic' },
        { prop: 'assessmentType', label: '考核类型', visible: true, group: 'basic' },
        { prop: 'assessmentDate', label: '考核日期', visible: true, width: '180', group: 'basic' },
        { prop: 'assessor', label: '考核人', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'result',
      label: '考核结果',
      fields: [
        { prop: 'assessmentResult', label: '考核结果', visible: true, group: 'result' },
        { prop: 'score', label: '评分', visible: true, group: 'result' },
        { prop: 'assessmentOpinion', label: '考核意见', visible: true, group: 'result' },
        { prop: 'improvementMeasures', label: '改进措施', visible: true, group: 'result' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'status', label: '状态', visible: true, group: 'system' },
        { prop: 'remark', label: '备注', visible: true, group: 'system' }
      ]
    }
  ];

  return fieldGroups;
}