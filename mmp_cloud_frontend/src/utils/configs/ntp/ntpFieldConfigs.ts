import { FieldConfigManager, FieldGroup } from '../fieldConfigManager';

// newTechnologyProject字段配置
export function createNewTechnologyProjectFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'projectNo', label: '项目编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'projectName', label: '项目名称', visible: true, type: 'input', group: 'basic' },
        { prop: 'projectType', label: '项目类型 新技术/新项目', visible: true, type: 'input', group: 'basic' },
        { prop: 'technologyCategory', label: '技术分类', visible: true, type: 'input', group: 'basic' },
        { prop: 'riskLevel', label: '风险等级 低风险/中风险/高风险', visible: true, type: 'input', group: 'basic' },
        { prop: 'applyDepartmentId', label: '申请科室ID', visible: true, type: 'number', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'applyDepartmentName', label: '申请科室名称', visible: true, type: 'input', group: 'detail' },
        { prop: 'projectLeader', label: '项目负责人', visible: true, type: 'input', group: 'detail' },
        { prop: 'projectTeam', label: '项目团队成员', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'technologySource', label: '技术来源', visible: true, type: 'input', group: 'detail' },
        { prop: 'applyReason', label: '申请理由', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'technologyDescription', label: '技术描述', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'indication', label: '适应症', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'contraindication', label: '禁忌症', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'expectedEffect', label: '预期效果', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'potentialRisk', label: '潜在风险', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'riskControlMeasure', label: '风险控制措施', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'literatureSupport', label: '文献支持', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'attachmentUrls', label: '附件URLs', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'operationCycleDays', label: '运行周期', visible: true, type: 'number', group: 'detail' },
        { prop: 'progressReportCycle', label: '进展报告周期 月度/季度/半年度/年度', visible: true, type: 'input', group: 'detail' },
        { prop: 'projectStatus', label: '项目状态', visible: true, type: 'input', group: 'detail' },
        { prop: 'approveDate', label: '批准日期', visible: true, type: 'date', group: 'detail' },
        { prop: 'startDate', label: '开始日期', visible: true, type: 'date', group: 'detail' },
        { prop: 'endDate', label: '预计结束日期', visible: true, type: 'date', group: 'detail' },
        { prop: 'actualEndDate', label: '实际结束日期', visible: true, type: 'date', group: 'detail' },
        { prop: 'conclusionType', label: '结题类型 转常规/终止', visible: true, type: 'input', group: 'detail' },
        { prop: 'workflowInstanceId', label: '工作流实例ID', visible: true, type: 'number', group: 'detail' }
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

  return new FieldConfigManager('newTechnologyProject', fieldGroups);
}


// newTechnologyProjectAssessment字段配置
export function createNewTechnologyProjectAssessmentFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'projectId', label: '项目ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'assessmentType', label: '考核类型：midterm-中期考核，final-结题考核，annual-年度考核', visible: true, type: 'input', group: 'basic' },
        { prop: 'status', label: '状态', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'assessmentYear', label: '考核年份', visible: true, type: 'number', group: 'detail' },
        { prop: 'assessmentDate', label: '考核日期', visible: true, type: 'date', group: 'detail' },
        { prop: 'assessor', label: '考核人', visible: true, type: 'input', group: 'detail' },
        { prop: 'assessmentResult', label: '考核结果：excellent-优秀，good-良好，qualified-合格，unqualified-不合格', visible: true, type: 'input', group: 'detail' },
        { prop: 'score', label: '评分', visible: true, type: 'number', group: 'detail' },
        { prop: 'assessmentOpinion', label: '考核意见', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'improvementMeasures', label: '改进措施', visible: true, type: 'textarea', group: 'detail' }
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

  return new FieldConfigManager('newTechnologyProjectAssessment', fieldGroups);
}


// newTechnologyProjectCase字段配置
export function createNewTechnologyProjectCaseFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'projectId', label: '项目ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'patientId', label: '患者ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'patientName', label: '患者姓名', visible: true, type: 'input', group: 'basic' },
        { prop: 'visitType', label: '就诊类型 门诊/住院', visible: true, type: 'input', group: 'basic' },
        { prop: 'visitNo', label: '就诊号', visible: true, type: 'input', group: 'basic' },
        { prop: 'visitDepartmentId', label: '就诊科室ID', visible: true, type: 'number', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'visitDate', label: '就诊日期', visible: true, type: 'date', group: 'detail' },
        { prop: 'visitDepartmentName', label: '就诊科室名称', visible: true, type: 'input', group: 'detail' },
        { prop: 'diagnosis', label: '诊断', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'operator', label: '操作医生', visible: true, type: 'input', group: 'detail' },
        { prop: 'operationDate', label: '操作时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'effectEvaluation', label: '效果评价', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'complication', label: '并发症', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'adverseReaction', label: '不良反应', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'followUpStatus', label: '随访状态', visible: true, type: 'input', group: 'detail' },
        { prop: 'followUpResult', label: '随访结果', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'isReported', label: '是否已报备 1-是 0-否', visible: true, type: 'number', group: 'detail' },
        { prop: 'reportTime', label: '报备时间', visible: true, type: 'datetime', group: 'detail' }
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

  return new FieldConfigManager('newTechnologyProjectCase', fieldGroups);
}


// newTechnologyProjectDocument字段配置
export function createNewTechnologyProjectDocumentFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'projectId', label: '项目ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'documentType', label: '文档类型：application-申报书，approval-批复文件，progress-进展报告，final-结题报告', visible: true, type: 'input', group: 'basic' },
        { prop: 'documentName', label: '文档名称', visible: true, type: 'input', group: 'basic' },
        { prop: 'fileName', label: '文件名', visible: true, type: 'input', group: 'basic' },
        { prop: 'status', label: '状态', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'filePath', label: '文件路径', visible: true, type: 'input', group: 'detail' },
        { prop: 'fileSize', label: '文件大小', visible: true, type: 'number', group: 'detail' },
        { prop: 'uploadBy', label: '上传人', visible: true, type: 'input', group: 'detail' },
        { prop: 'uploadTime', label: '上传时间', visible: true, type: 'datetime', group: 'detail' }
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

  return new FieldConfigManager('newTechnologyProjectDocument', fieldGroups);
}


// newTechnologyProjectExtension字段配置
export function createNewTechnologyProjectExtensionFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'applyNo', label: '申请编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'projectId', label: '项目ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'applyStatus', label: '申请状态', visible: true, type: 'input', group: 'basic' },
        { prop: 'workflowInstanceId', label: '工作流实例ID', visible: true, type: 'number', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'originalEndDate', label: '原结束日期', visible: true, type: 'date', group: 'detail' },
        { prop: 'extendDays', label: '延期天数', visible: true, type: 'number', group: 'detail' },
        { prop: 'newEndDate', label: '新结束日期', visible: true, type: 'date', group: 'detail' },
        { prop: 'extensionReason', label: '延期理由', visible: true, type: 'textarea', group: 'detail' }
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

  return new FieldConfigManager('newTechnologyProjectExtension', fieldGroups);
}


// newTechnologyProjectImplementation字段配置
export function createNewTechnologyProjectImplementationFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'projectNo', label: '项目编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'implementationStatus', label: '实施状态 0-未开始 1-进行中 2-已完成 3-暂停', visible: true, type: 'number', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'implementDoctor', label: '实施医生', visible: true, type: 'input', group: 'detail' },
        { prop: 'implementationLocation', label: '实施地点', visible: true, type: 'input', group: 'detail' },
        { prop: 'implementationDate', label: '实施日期', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'implementationResult', label: '实施结果', visible: true, type: 'textarea', group: 'detail' }
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
        { prop: 'updateTime', label: '创建时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'updateBy', label: '更新人', visible: true, type: 'number', group: 'system' },
        { prop: 'remark', label: '备注', visible: true, type: 'input', group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('newTechnologyProjectImplementation', fieldGroups);
}


// newTechnologyProjectMapping字段配置
export function createNewTechnologyProjectMappingFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'projectId', label: '项目ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'mappingType', label: '对码类型 医嘱项/ICD-9/收费项', visible: true, type: 'input', group: 'basic' },
        { prop: 'sourceCode', label: '源编码', visible: true, type: 'input', group: 'basic' },
        { prop: 'sourceName', label: '源名称', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'targetSystem', label: '目标系统 HIS/收费系统', visible: true, type: 'input', group: 'detail' }
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

  return new FieldConfigManager('newTechnologyProjectMapping', fieldGroups);
}


// newTechnologyProjectProgress字段配置
export function createNewTechnologyProjectProgressFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'reportNo', label: '报告编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'projectId', label: '项目ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'reportType', label: '报告类型 进展报告/结题报告', visible: true, type: 'input', group: 'basic' },
        { prop: 'continueStatus', label: '继续状态 继续开展/终止/暂停', visible: true, type: 'input', group: 'basic' },
        { prop: 'reportStatus', label: '报告状态', visible: true, type: 'input', group: 'basic' },
        { prop: 'workflowInstanceId', label: '工作流实例ID', visible: true, type: 'number', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'reportPeriod', label: '报告期间', visible: true, type: 'input', group: 'detail' },
        { prop: 'reportDate', label: '报告日期', visible: true, type: 'date', group: 'detail' },
        { prop: 'caseCount', label: '开展病例数', visible: true, type: 'number', group: 'detail' },
        { prop: 'successCount', label: '成功病例数', visible: true, type: 'number', group: 'detail' },
        { prop: 'complicationCount', label: '并发症例数', visible: true, type: 'number', group: 'detail' },
        { prop: 'adverseReactionCount', label: '不良反应例数', visible: true, type: 'number', group: 'detail' },
        { prop: 'mortalityCount', label: '死亡例数', visible: true, type: 'number', group: 'detail' },
        { prop: 'effectEvaluation', label: '效果评价', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'existingProblems', label: '存在问题', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'improvementMeasures', label: '改进措施', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'nextPlan', label: '下步计划', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'monitoringIndicators', label: '运行监测指标JSON', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'attachmentUrls', label: '附件URLs', visible: true, type: 'textarea', group: 'detail' }
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

  return new FieldConfigManager('newTechnologyProjectProgress', fieldGroups);
}
