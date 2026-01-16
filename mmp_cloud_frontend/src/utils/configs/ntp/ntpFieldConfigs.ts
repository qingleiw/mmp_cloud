
import { FieldConfigManager, FieldGroup } from '../fieldConfigManager';

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

  return fieldGroups;
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

  return fieldGroups;
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

  return fieldGroups;
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
export function createNewTechnologyProjectFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'input', width: '80', group: 'basic' },
        { prop: 'projectNo', label: '项目编号', visible: true, required: true, type: 'input', group: 'basic' },
        { prop: 'projectName', label: '项目名称', visible: true, required: true, type: 'input', group: 'basic' },
        { prop: 'projectType', label: '项目类型', visible: true, type: 'select', group: 'basic' },
        { prop: 'technologyCategory', label: '技术分类', visible: true, type: 'input', group: 'basic' },
        { prop: 'riskLevel', label: '风险等级', visible: true, type: 'select', group: 'basic' }
      ]
    },
    {
      name: 'department',
      label: '科室信息',
      fields: [
        { prop: 'applyDepartmentId', label: '申请科室ID', visible: false, type: 'input', group: 'department' },
        { prop: 'applyDepartmentName', label: '申请科室名称', visible: true, type: 'input', group: 'department' }
      ]
    },
    {
      name: 'team',
      label: '团队信息',
      fields: [
        { prop: 'projectLeader', label: '项目负责人', visible: true, type: 'input', group: 'team' },
        { prop: 'projectTeam', label: '项目团队成员', visible: true, type: 'textarea', group: 'team' }
      ]
    },
    {
      name: 'source',
      label: '技术来源',
      fields: [
        { prop: 'technologySource', label: '技术来源', visible: true, type: 'input', group: 'source' },
        { prop: 'applyReason', label: '申请理由', visible: true, type: 'textarea', group: 'source' }
      ]
    },
    {
      name: 'description',
      label: '技术描述',
      fields: [
        { prop: 'technologyDescription', label: '技术描述', visible: true, type: 'textarea', group: 'description' },
        { prop: 'indication', label: '适应症', visible: true, type: 'textarea', group: 'description' },
        { prop: 'contraindication', label: '禁忌症', visible: true, type: 'textarea', group: 'description' },
        { prop: 'expectedEffect', label: '预期效果', visible: true, type: 'textarea', group: 'description' }
      ]
    },
    {
      name: 'risk',
      label: '风险评估',
      fields: [
        { prop: 'potentialRisk', label: '潜在风险', visible: true, type: 'textarea', group: 'risk' },
        { prop: 'riskControlMeasure', label: '风险控制措施', visible: true, type: 'textarea', group: 'risk' }
      ]
    },
    {
      name: 'support',
      label: '支撑材料',
      fields: [
        { prop: 'literatureSupport', label: '文献支持', visible: true, type: 'textarea', group: 'support' },
        { prop: 'attachmentUrls', label: '附件URLs', visible: true, type: 'textarea', group: 'support' }
      ]
    },
    {
      name: 'cycle',
      label: '周期信息',
      fields: [
        { prop: 'operationCycleDays', label: '运行周期(天)', visible: true, type: 'input', width: '120', group: 'cycle' },
        { prop: 'progressReportCycle', label: '进展报告周期', visible: true, type: 'select', group: 'cycle' }
      ]
    },
    {
      name: 'timeline',
      label: '时间信息',
      fields: [
        { prop: 'approveDate', label: '批准日期', visible: true, type: 'date', width: '120', group: 'timeline' },
        { prop: 'startDate', label: '开始日期', visible: true, type: 'date', width: '120', group: 'timeline' },
        { prop: 'endDate', label: '预计结束日期', visible: true, type: 'date', width: '120', group: 'timeline' },
        { prop: 'actualEndDate', label: '实际结束日期', visible: true, type: 'date', width: '120', group: 'timeline' }
      ]
    },
    {
      name: 'status',
      label: '状态信息',
      fields: [
        { prop: 'projectStatus', label: '项目状态', visible: true, type: 'select', group: 'status' },
        { prop: 'approvalStatus', label: '审批状态', visible: true, type: 'select', group: 'status' },
        { prop: 'conclusionType', label: '结题类型', visible: true, type: 'select', group: 'status' }
      ]
    },
    {
      name: 'workflow',
      label: '工作流信息',
      fields: [
        { prop: 'workflowInstanceId', label: '工作流实例ID', visible: false, type: 'input', group: 'workflow' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'isDeleted', label: '是否删除', visible: true, type: 'switch', width: '80', group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: false, type: 'datetime', width: '160', group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: false, type: 'datetime', width: '160', group: 'system' }
      ]
    }
  ];

  return fieldGroups;
}
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
export function createNewTechnologyProjectAssessmentFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'input', width: '80', group: 'basic' },
        { prop: 'projectId', label: '项目ID', visible: true, type: 'input', group: 'basic' },
        { prop: 'assessmentYear', label: '考核年份', visible: true, type: 'input', width: '100', group: 'basic' },
        { prop: 'assessmentType', label: '考核类型', visible: true, type: 'select', group: 'basic' },
        { prop: 'assessmentDate', label: '考核日期', visible: true, type: 'date', width: '120', group: 'basic' },
        { prop: 'assessor', label: '考核人', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'result',
      label: '考核结果',
      fields: [
        { prop: 'assessmentResult', label: '考核结果', visible: true, type: 'select', group: 'result' },
        { prop: 'score', label: '评分', visible: true, type: 'input', width: '100', group: 'result' },
        { prop: 'assessmentOpinion', label: '考核意见', visible: true, type: 'textarea', group: 'result' },
        { prop: 'improvementMeasures', label: '改进措施', visible: true, type: 'textarea', group: 'result' }
      ]
    },
    {
      name: 'status',
      label: '状态信息',
      fields: [
        { prop: 'status', label: '状态', visible: true, type: 'select', group: 'status' }
      ]
    },
    {
      name: 'remark',
      label: '备注信息',
      fields: [
        { prop: 'remark', label: '备注', visible: true, type: 'textarea', group: 'remark' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'createTime', label: '创建时间', visible: false, type: 'datetime', width: '160', group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: false, type: 'datetime', width: '160', group: 'system' }
      ]
    }
  ];

  return fieldGroups;
}

// 新技术项目案例字段配置
// 新技术项目案例字段配置
export function createNewTechnologyProjectCaseFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: false, type: 'input', width: '80', group: 'basic' },
        { prop: 'projectId', label: '项目ID', visible: false, type: 'input', width: '100', group: 'basic' },
        { prop: 'patientId', label: '患者ID', visible: false, type: 'input', width: '100', group: 'basic' },
        { prop: 'patientName', label: '患者姓名', visible: true, type: 'input', width: '120', group: 'basic' },
        { prop: 'visitType', label: '就诊类型', visible: true, type: 'select', width: '100', group: 'basic' },
        { prop: 'visitNo', label: '就诊号', visible: true, type: 'input', width: '120', group: 'basic' }
      ]
    },
    {
      name: 'visit',
      label: '就诊信息',
      fields: [
        { prop: 'visitDepartmentId', label: '就诊科室ID', visible: false, type: 'input', width: '100', group: 'visit' },
        { prop: 'visitDepartmentName', label: '就诊科室名称', visible: true, type: 'input', width: '140', group: 'visit' },
        { prop: 'diagnosis', label: '诊断', visible: true, type: 'textarea', group: 'visit' }
      ]
    },
    {
      name: 'operation',
      label: '操作信息',
      fields: [
        { prop: 'operator', label: '操作医生', visible: true, type: 'input', width: '120', group: 'operation' },
        { prop: 'effectEvaluation', label: '效果评价', visible: true, type: 'textarea', group: 'operation' }
      ]
    },
    {
      name: 'complication',
      label: '并发症信息',
      fields: [
        { prop: 'complication', label: '并发症', visible: true, type: 'textarea', group: 'complication' },
        { prop: 'adverseReaction', label: '不良反应', visible: true, type: 'textarea', group: 'complication' }
      ]
    },
    {
      name: 'followup',
      label: '随访信息',
      fields: [
        { prop: 'followUpStatus', label: '随访状态', visible: true, type: 'select', width: '100', group: 'followup' },
        { prop: 'followUpResult', label: '随访结果', visible: true, type: 'textarea', group: 'followup' }
      ]
    },
    {
      name: 'report',
      label: '报备信息',
      fields: [
        { prop: 'isReported', label: '是否已报备', visible: true, type: 'select', width: '100', group: 'report' }
      ]
    },
    {
      name: 'time',
      label: '时间信息',
      fields: [
        { prop: 'visitDate', label: '就诊日期', visible: true, type: 'date', width: '120', group: 'time' },
        { prop: 'operationDate', label: '操作时间', visible: true, type: 'date', width: '120', group: 'time' },
        { prop: 'reportTime', label: '报备时间', visible: true, type: 'datetime', width: '160', group: 'time' }
      ]
    },
    {
      name: 'remark',
      label: '备注信息',
      fields: [
        { prop: 'remark', label: '备注', visible: true, type: 'textarea', group: 'remark' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'isDeleted', label: '是否删除', visible: false, type: 'select', width: '100', group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: false, type: 'datetime', width: '160', group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: false, type: 'datetime', width: '160', group: 'system' },
        { prop: 'createBy', label: '创建人', visible: false, type: 'input', width: '120', group: 'system' },
        { prop: 'updateBy', label: '更新人', visible: false, type: 'input', width: '120', group: 'system' }
      ]
    }
  ];

  return fieldGroups;
}

// 新技术项目文档字段配置
// 新技术项目文档字段配置
export function createNewTechnologyProjectDocumentFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: false, type: 'input', width: '80', group: 'basic' },
        { prop: 'projectId', label: '项目ID', visible: false, type: 'input', width: '100', group: 'basic' },
        { prop: 'documentType', label: '文档类型', visible: true, type: 'select', width: '120', group: 'basic' },
        { prop: 'documentName', label: '文档名称', visible: true, type: 'input', width: '200', group: 'basic' }
      ]
    },
    {
      name: 'file',
      label: '文件信息',
      fields: [
        { prop: 'filePath', label: '文件路径', visible: false, type: 'input', width: '250', group: 'file' },
        { prop: 'fileName', label: '文件名', visible: true, type: 'input', width: '200', group: 'file' },
        { prop: 'fileSize', label: '文件大小', visible: true, type: 'input', width: '100', group: 'file' }
      ]
    },
    {
      name: 'upload',
      label: '上传信息',
      fields: [
        { prop: 'uploadBy', label: '上传人', visible: true, type: 'input', width: '120', group: 'upload' }
      ]
    },
    {
      name: 'time',
      label: '时间信息',
      fields: [
        { prop: 'uploadTime', label: '上传时间', visible: true, type: 'datetime', width: '160', group: 'time' }
      ]
    },
    {
      name: 'status',
      label: '状态信息',
      fields: [
        { prop: 'status', label: '状态', visible: true, type: 'select', width: '100', group: 'status' }
      ]
    },
    {
      name: 'remark',
      label: '备注信息',
      fields: [
        { prop: 'remark', label: '备注', visible: true, type: 'textarea', group: 'remark' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'isDeleted', label: '是否删除', visible: false, type: 'select', width: '100', group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: false, type: 'datetime', width: '160', group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: false, type: 'datetime', width: '160', group: 'system' },
        { prop: 'createBy', label: '创建人', visible: false, type: 'input', width: '120', group: 'system' },
        { prop: 'updateBy', label: '更新人', visible: false, type: 'input', width: '120', group: 'system' }
      ]
    }
  ];

  return fieldGroups;
}

// 新技术项目延期申请字段配置
export function createNewTechnologyProjectExtensionFieldConfig(): FieldGroup[] {
  return [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        {
          prop: 'id',
          label: '主键ID',
          type: 'input',
          visible: false,
          showInTable: false,
          showInForm: true,
          showInSearch: false,
          group: 'basic',
          formSpan: 24,
          required: false,
          readonly: true
        },
        {
          prop: 'applyNo',
          label: '申请编号',
          type: 'input',
          visible: true,
          showInTable: true,
          showInForm: true,
          showInSearch: true,
          group: 'basic',
          width: 150,
          minWidth: 120,
          formSpan: 12,
          required: true,
          placeholder: '请输入申请编号'
        },
        {
          prop: 'projectId',
          label: '项目ID',
          type: 'input',
          visible: true,
          showInTable: true,
          showInForm: true,
          showInSearch: true,
          group: 'basic',
          width: 120,
          minWidth: 100,
          formSpan: 12,
          required: true,
          placeholder: '请输入项目ID'
        }
      ]
    },
    {
      name: 'extension',
      label: '延期信息',
      fields: [
        {
          prop: 'originalEndDate',
          label: '原结束日期',
          type: 'datetime',
          visible: true,
          showInTable: true,
          showInForm: true,
          showInSearch: true,
          group: 'extension',
          width: 160,
          minWidth: 140,
          formSpan: 12,
          required: true,
          placeholder: '请选择原结束日期'
        },
        {
          prop: 'extendDays',
          label: '延期天数',
          type: 'number',
          visible: true,
          showInTable: true,
          showInForm: true,
          showInSearch: true,
          group: 'extension',
          width: 100,
          minWidth: 80,
          formSpan: 12,
          required: true,
          placeholder: '请输入延期天数',
          min: 1,
          max: 365
        },
        {
          prop: 'newEndDate',
          label: '新结束日期',
          type: 'datetime',
          visible: true,
          showInTable: true,
          showInForm: true,
          showInSearch: true,
          group: 'extension',
          width: 160,
          minWidth: 140,
          formSpan: 12,
          required: true,
          placeholder: '请选择新结束日期'
        },
        {
          prop: 'extensionReason',
          label: '延期理由',
          type: 'textarea',
          visible: true,
          showInTable: false,
          showInForm: true,
          showInSearch: false,
          group: 'extension',
          formSpan: 24,
          required: true,
          placeholder: '请输入延期理由',
          rows: 3
        }
      ]
    },
    {
      name: 'status',
      label: '状态信息',
      fields: [
        {
          prop: 'applyStatus',
          label: '申请状态',
          type: 'select',
          visible: true,
          showInTable: true,
          showInForm: true,
          showInSearch: true,
          group: 'status',
          width: 100,
          minWidth: 80,
          formSpan: 12,
          required: true,
          options: [
            { label: '待审核', value: '待审核' },
            { label: '已审核', value: '已审核' },
            { label: '已驳回', value: '已驳回' },
            { label: '草稿', value: '草稿' }
          ]
        }
      ]
    },
    {
      name: 'workflow',
      label: '工作流信息',
      fields: [
        {
          prop: 'workflowInstanceId',
          label: '工作流实例ID',
          type: 'input',
          visible: false,
          showInTable: false,
          showInForm: false,
          showInSearch: false,
          group: 'workflow',
          readonly: true
        }
      ]
    },
    {
      name: 'remark',
      label: '备注信息',
      fields: [
        {
          prop: 'remark',
          label: '备注',
          type: 'textarea',
          visible: true,
          showInTable: false,
          showInForm: true,
          showInSearch: false,
          group: 'remark',
          formSpan: 24,
          required: false,
          placeholder: '请输入备注',
          rows: 2
        }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        {
          prop: 'createTime',
          label: '创建时间',
          type: 'datetime',
          visible: false,
          showInTable: false,
          showInForm: false,
          showInSearch: false,
          group: 'system',
          readonly: true
        },
        {
          prop: 'updateTime',
          label: '更新时间',
          type: 'datetime',
          visible: false,
          showInTable: false,
          showInForm: false,
          showInSearch: false,
          group: 'system',
          readonly: true
        }
      ]
    }
  ];
}

export function createNewTechnologyProjectImplementationFieldConfig(): FieldGroup[] {
  return [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        {
          prop: 'id',
          label: '主键ID',
          type: 'input',
          visible: false,
          showInTable: false,
          showInForm: true,
          showInSearch: false,
          group: 'basic',
          formSpan: 24,
          required: false,
          readonly: true
        },
        {
          prop: 'projectNo',
          label: '项目编号',
          type: 'input',
          visible: true,
          showInTable: true,
          showInForm: true,
          showInSearch: true,
          group: 'basic',
          width: 150,
          minWidth: 120,
          formSpan: 12,
          required: true,
          placeholder: '请输入项目编号'
        }
      ]
    },
    {
      name: 'implementation',
      label: '实施信息',
      fields: [
        {
          prop: 'implementationStatus',
          label: '实施状态',
          type: 'select',
          visible: true,
          showInTable: true,
          showInForm: true,
          showInSearch: true,
          group: 'implementation',
          width: 100,
          minWidth: 80,
          formSpan: 12,
          required: true,
          options: [
            { label: '未开始', value: 0 },
            { label: '进行中', value: 1 },
            { label: '已完成', value: 2 },
            { label: '暂停', value: 3 }
          ]
        },
        {
          prop: 'implementDoctor',
          label: '实施医生',
          type: 'input',
          visible: true,
          showInTable: true,
          showInForm: true,
          showInSearch: true,
          group: 'implementation',
          width: 120,
          minWidth: 100,
          formSpan: 12,
          required: true,
          placeholder: '请输入实施医生'
        },
        {
          prop: 'implementationLocation',
          label: '实施地点',
          type: 'input',
          visible: true,
          showInTable: true,
          showInForm: true,
          showInSearch: true,
          group: 'implementation',
          width: 150,
          minWidth: 120,
          formSpan: 12,
          required: true,
          placeholder: '请输入实施地点'
        },
        {
          prop: 'implementationDate',
          label: '实施日期',
          type: 'datetime',
          visible: true,
          showInTable: true,
          showInForm: true,
          showInSearch: true,
          group: 'implementation',
          width: 160,
          minWidth: 140,
          formSpan: 12,
          required: true,
          placeholder: '请选择实施日期'
        },
        {
          prop: 'implementationResult',
          label: '实施结果',
          type: 'textarea',
          visible: true,
          showInTable: false,
          showInForm: true,
          showInSearch: false,
          group: 'implementation',
          formSpan: 24,
          required: false,
          placeholder: '请输入实施结果',
          rows: 3
        }
      ]
    },
    {
      name: 'remark',
      label: '备注信息',
      fields: [
        {
          prop: 'remark',
          label: '备注',
          type: 'textarea',
          visible: true,
          showInTable: false,
          showInForm: true,
          showInSearch: false,
          group: 'remark',
          formSpan: 24,
          required: false,
          placeholder: '请输入备注',
          rows: 2
        }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        {
          prop: 'isDeleted',
          label: '是否删除',
          type: 'select',
          visible: false,
          showInTable: false,
          showInForm: false,
          showInSearch: false,
          group: 'system',
          options: [
            { label: '未删除', value: 0 },
            { label: '已删除', value: 1 }
          ],
          readonly: true
        },
        {
          prop: 'createTime',
          label: '创建时间',
          type: 'datetime',
          visible: false,
          showInTable: false,
          showInForm: false,
          showInSearch: false,
          group: 'system',
          readonly: true
        },
        {
          prop: 'updateTime',
          label: '更新时间',
          type: 'datetime',
          visible: false,
          showInTable: false,
          showInForm: false,
          showInSearch: false,
          group: 'system',
          readonly: true
        }
      ]
    }
  ];
}

export function createNewTechnologyProjectMappingFieldConfig(): FieldGroup[] {
  return [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        {
          prop: 'id',
          label: '主键ID',
          type: 'input',
          visible: false,
          showInTable: false,
          showInForm: true,
          showInSearch: false,
          group: 'basic',
          formSpan: 24,
          required: false,
          readonly: true
        },
        {
          prop: 'projectId',
          label: '项目ID',
          type: 'input',
          visible: true,
          showInTable: true,
          showInForm: true,
          showInSearch: true,
          group: 'basic',
          width: 120,
          minWidth: 100,
          formSpan: 12,
          required: true,
          placeholder: '请输入项目ID'
        }
      ]
    },
    {
      name: 'mapping',
      label: '对码信息',
      fields: [
        {
          prop: 'mappingType',
          label: '对码类型',
          type: 'select',
          visible: true,
          showInTable: true,
          showInForm: true,
          showInSearch: true,
          group: 'mapping',
          width: 100,
          minWidth: 80,
          formSpan: 12,
          required: true,
          options: [
            { label: '医嘱项', value: '医嘱项' },
            { label: 'ICD-9', value: 'ICD-9' },
            { label: '收费项', value: '收费项' }
          ]
        },
        {
          prop: 'sourceCode',
          label: '源编码',
          type: 'input',
          visible: true,
          showInTable: true,
          showInForm: true,
          showInSearch: true,
          group: 'mapping',
          width: 120,
          minWidth: 100,
          formSpan: 12,
          required: true,
          placeholder: '请输入源编码'
        },
        {
          prop: 'sourceName',
          label: '源名称',
          type: 'input',
          visible: true,
          showInTable: true,
          showInForm: true,
          showInSearch: true,
          group: 'mapping',
          width: 150,
          minWidth: 120,
          formSpan: 12,
          required: true,
          placeholder: '请输入源名称'
        },
        {
          prop: 'targetSystem',
          label: '目标系统',
          type: 'select',
          visible: true,
          showInTable: true,
          showInForm: true,
          showInSearch: true,
          group: 'mapping',
          width: 120,
          minWidth: 100,
          formSpan: 12,
          required: true,
          options: [
            { label: 'HIS', value: 'HIS' },
            { label: '收费系统', value: '收费系统' }
          ]
        }
      ]
    },
    {
      name: 'remark',
      label: '备注信息',
      fields: [
        {
          prop: 'remark',
          label: '备注',
          type: 'textarea',
          visible: true,
          showInTable: false,
          showInForm: true,
          showInSearch: false,
          group: 'remark',
          formSpan: 24,
          required: false,
          placeholder: '请输入备注',
          rows: 2
        }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        {
          prop: 'createTime',
          label: '创建时间',
          type: 'datetime',
          visible: false,
          showInTable: false,
          showInForm: false,
          showInSearch: false,
          group: 'system',
          readonly: true
        },
        {
          prop: 'updateTime',
          label: '更新时间',
          type: 'datetime',
          visible: false,
          showInTable: false,
          showInForm: false,
          showInSearch: false,
          group: 'system',
          readonly: true
        }
      ]
    }
  ];
}

// 新技术项目进展字段配置
export function createNewTechnologyProjectProgressFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: false, group: 'basic' },
        { prop: 'reportNo', label: '报告编号', visible: true, required: true, type: 'input', group: 'basic' },
        { prop: 'projectId', label: '项目ID', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'report',
      label: '报告信息',
      fields: [
        { prop: 'reportType', label: '报告类型', visible: true, type: 'select', group: 'report' },
        { prop: 'reportPeriod', label: '报告期间', visible: true, type: 'input', group: 'report' },
        { prop: 'reportDate', label: '报告日期', visible: true, type: 'date', width: '120', group: 'report' },
        { prop: 'reportStatus', label: '报告状态', visible: true, type: 'select', group: 'report' }
      ]
    },
    {
      name: 'statistics',
      label: '统计数据',
      fields: [
        { prop: 'caseCount', label: '开展病例数', visible: true, type: 'number', width: '100', group: 'statistics' },
        { prop: 'successCount', label: '成功病例数', visible: true, type: 'number', width: '100', group: 'statistics' },
        { prop: 'complicationCount', label: '并发症例数', visible: true, type: 'number', width: '100', group: 'statistics' },
        { prop: 'adverseReactionCount', label: '不良反应例数', visible: true, type: 'number', width: '100', group: 'statistics' },
        { prop: 'mortalityCount', label: '死亡例数', visible: true, type: 'number', width: '100', group: 'statistics' }
      ]
    },
    {
      name: 'evaluation',
      label: '评价信息',
      fields: [
        { prop: 'effectEvaluation', label: '效果评价', visible: true, type: 'textarea', group: 'evaluation' },
        { prop: 'existingProblems', label: '存在问题', visible: true, type: 'textarea', group: 'evaluation' },
        { prop: 'improvementMeasures', label: '改进措施', visible: true, type: 'textarea', group: 'evaluation' },
        { prop: 'nextPlan', label: '下步计划', visible: true, type: 'textarea', group: 'evaluation' },
        { prop: 'continueStatus', label: '继续状态', visible: true, type: 'select', group: 'evaluation' }
      ]
    },
    {
      name: 'monitoring',
      label: '监测信息',
      fields: [
        { prop: 'monitoringIndicators', label: '运行监测指标JSON', visible: false, type: 'textarea', group: 'monitoring' },
        { prop: 'attachmentUrls', label: '附件URLs', visible: false, type: 'textarea', group: 'monitoring' }
      ]
    },
    {
      name: 'remark',
      label: '备注信息',
      fields: [
        { prop: 'remark', label: '备注', visible: true, type: 'textarea', group: 'remark' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'createTime', label: '创建时间', visible: false, type: 'datetime', width: '160', group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: false, type: 'datetime', width: '160', group: 'system' }
      ]
    }
  ];

  return fieldGroups;
}