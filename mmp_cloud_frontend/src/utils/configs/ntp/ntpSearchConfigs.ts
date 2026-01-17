import { SearchConfigManager, SearchFieldGroup } from '../searchConfigManager';

// newTechnologyProject搜索配置
export function createNewTechnologyProjectSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'projectNo', label: '项目编号', type: 'input', visible: true, placeholder: '请输入项目编号' },
        { prop: 'projectName', label: '项目名称', type: 'input', visible: true, placeholder: '请输入项目名称' },
        { prop: 'projectType', label: '项目类型 新技术/新项目', type: 'input', visible: true, placeholder: '请输入项目类型 新技术/新项目' },
        { prop: 'technologyCategory', label: '技术分类', type: 'input', visible: false, placeholder: '请输入技术分类' },
        { prop: 'riskLevel', label: '风险等级 低风险/中风险/高风险', type: 'input', visible: false, placeholder: '请输入风险等级 低风险/中风险/高风险' },
        { prop: 'applyDepartmentId', label: '申请科室ID', type: 'number', visible: false, placeholder: '请输入申请科室ID' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'applyDepartmentName', label: '申请科室名称', type: 'input', visible: false, placeholder: '请输入申请科室名称' },
        { prop: 'projectLeader', label: '项目负责人', type: 'input', visible: false, placeholder: '请输入项目负责人' },
        { prop: 'projectTeam', label: '项目团队成员', type: 'input', visible: false, placeholder: '请输入项目团队成员' },
        { prop: 'technologySource', label: '技术来源', type: 'input', visible: false, placeholder: '请输入技术来源' },
        { prop: 'applyReason', label: '申请理由', type: 'input', visible: false, placeholder: '请输入申请理由' },
        { prop: 'technologyDescription', label: '技术描述', type: 'input', visible: false, placeholder: '请输入技术描述' },
        { prop: 'indication', label: '适应症', type: 'input', visible: false, placeholder: '请输入适应症' },
        { prop: 'contraindication', label: '禁忌症', type: 'input', visible: false, placeholder: '请输入禁忌症' },
        { prop: 'expectedEffect', label: '预期效果', type: 'input', visible: false, placeholder: '请输入预期效果' },
        { prop: 'potentialRisk', label: '潜在风险', type: 'input', visible: false, placeholder: '请输入潜在风险' },
        { prop: 'riskControlMeasure', label: '风险控制措施', type: 'input', visible: false, placeholder: '请输入风险控制措施' },
        { prop: 'literatureSupport', label: '文献支持', type: 'input', visible: false, placeholder: '请输入文献支持' },
        { prop: 'attachmentUrls', label: '附件URLs', type: 'input', visible: false, placeholder: '请输入附件URLs' },
        { prop: 'operationCycleDays', label: '运行周期', type: 'number', visible: false, placeholder: '请输入运行周期' },
        { prop: 'progressReportCycle', label: '进展报告周期 月度/季度/半年度/年度', type: 'input', visible: false, placeholder: '请输入进展报告周期 月度/季度/半年度/年度' },
        { prop: 'projectStatus', label: '项目状态', type: 'input', visible: false, placeholder: '请输入项目状态' },
        { prop: 'approveDate', label: '批准日期', type: 'daterange', visible: false, placeholder: '请输入批准日期', startProp: 'approveDateStart', endProp: 'approveDateEnd' },
        { prop: 'startDate', label: '开始日期', type: 'daterange', visible: false, placeholder: '请输入开始日期', startProp: 'startDateStart', endProp: 'startDateEnd' },
        { prop: 'endDate', label: '预计结束日期', type: 'daterange', visible: false, placeholder: '请输入预计结束日期', startProp: 'endDateStart', endProp: 'endDateEnd' },
        { prop: 'actualEndDate', label: '实际结束日期', type: 'daterange', visible: false, placeholder: '请输入实际结束日期', startProp: 'actualEndDateStart', endProp: 'actualEndDateEnd' },
        { prop: 'conclusionType', label: '结题类型 转常规/终止', type: 'input', visible: false, placeholder: '请输入结题类型 转常规/终止' },
        { prop: 'workflowInstanceId', label: '工作流实例ID', type: 'number', visible: false, placeholder: '请输入工作流实例ID' }
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

  return new SearchConfigManager('newTechnologyProject', searchFieldGroups);
}


// newTechnologyProjectAssessment搜索配置
export function createNewTechnologyProjectAssessmentSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'projectId', label: '项目ID', type: 'number', visible: true, placeholder: '请输入项目ID' },
        { prop: 'assessmentType', label: '考核类型：midterm-中期考核，final-结题考核，annual-年度考核', type: 'input', visible: true, placeholder: '请输入考核类型：midterm-中期考核，final-结题考核，annual-年度考核' },
        { prop: 'status', label: '状态', type: 'input', visible: true, placeholder: '请输入状态' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'assessmentYear', label: '考核年份', type: 'number', visible: false, placeholder: '请输入考核年份' },
        { prop: 'assessmentDate', label: '考核日期', type: 'daterange', visible: false, placeholder: '请输入考核日期', startProp: 'assessmentDateStart', endProp: 'assessmentDateEnd' },
        { prop: 'assessor', label: '考核人', type: 'input', visible: false, placeholder: '请输入考核人' },
        { prop: 'assessmentResult', label: '考核结果：excellent-优秀，good-良好，qualified-合格，unqualified-不合格', type: 'input', visible: false, placeholder: '请输入考核结果：excellent-优秀，good-良好，qualified-合格，unqualified-不合格' },
        { prop: 'score', label: '评分', type: 'number', visible: false, placeholder: '请输入评分' },
        { prop: 'assessmentOpinion', label: '考核意见', type: 'input', visible: false, placeholder: '请输入考核意见' },
        { prop: 'improvementMeasures', label: '改进措施', type: 'input', visible: false, placeholder: '请输入改进措施' }
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

  return new SearchConfigManager('newTechnologyProjectAssessment', searchFieldGroups);
}


// newTechnologyProjectCase搜索配置
export function createNewTechnologyProjectCaseSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'projectId', label: '项目ID', type: 'number', visible: true, placeholder: '请输入项目ID' },
        { prop: 'patientId', label: '患者ID', type: 'number', visible: true, placeholder: '请输入患者ID' },
        { prop: 'patientName', label: '患者姓名', type: 'input', visible: true, placeholder: '请输入患者姓名' },
        { prop: 'visitType', label: '就诊类型 门诊/住院', type: 'input', visible: false, placeholder: '请输入就诊类型 门诊/住院' },
        { prop: 'visitNo', label: '就诊号', type: 'input', visible: false, placeholder: '请输入就诊号' },
        { prop: 'visitDepartmentId', label: '就诊科室ID', type: 'number', visible: false, placeholder: '请输入就诊科室ID' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'visitDate', label: '就诊日期', type: 'daterange', visible: false, placeholder: '请输入就诊日期', startProp: 'visitDateStart', endProp: 'visitDateEnd' },
        { prop: 'visitDepartmentName', label: '就诊科室名称', type: 'input', visible: false, placeholder: '请输入就诊科室名称' },
        { prop: 'diagnosis', label: '诊断', type: 'input', visible: false, placeholder: '请输入诊断' },
        { prop: 'operator', label: '操作医生', type: 'input', visible: false, placeholder: '请输入操作医生' },
        { prop: 'operationDate', label: '操作时间', type: 'daterange', visible: false, placeholder: '请输入操作时间', startProp: 'operationDateStart', endProp: 'operationDateEnd' },
        { prop: 'effectEvaluation', label: '效果评价', type: 'input', visible: false, placeholder: '请输入效果评价' },
        { prop: 'complication', label: '并发症', type: 'input', visible: false, placeholder: '请输入并发症' },
        { prop: 'adverseReaction', label: '不良反应', type: 'input', visible: false, placeholder: '请输入不良反应' },
        { prop: 'followUpStatus', label: '随访状态', type: 'input', visible: false, placeholder: '请输入随访状态' },
        { prop: 'followUpResult', label: '随访结果', type: 'input', visible: false, placeholder: '请输入随访结果' },
        { prop: 'isReported', label: '是否已报备 1-是 0-否', type: 'number', visible: false, placeholder: '请输入是否已报备 1-是 0-否' },
        { prop: 'reportTime', label: '报备时间', type: 'daterange', visible: false, placeholder: '请输入报备时间', startProp: 'reportTimeStart', endProp: 'reportTimeEnd' }
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

  return new SearchConfigManager('newTechnologyProjectCase', searchFieldGroups);
}


// newTechnologyProjectDocument搜索配置
export function createNewTechnologyProjectDocumentSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'projectId', label: '项目ID', type: 'number', visible: true, placeholder: '请输入项目ID' },
        { prop: 'documentType', label: '文档类型：application-申报书，approval-批复文件，progress-进展报告，final-结题报告', type: 'input', visible: true, placeholder: '请输入文档类型：application-申报书，approval-批复文件，progress-进展报告，final-结题报告' },
        { prop: 'documentName', label: '文档名称', type: 'input', visible: true, placeholder: '请输入文档名称' },
        { prop: 'fileName', label: '文件名', type: 'input', visible: false, placeholder: '请输入文件名' },
        { prop: 'status', label: '状态', type: 'input', visible: false, placeholder: '请输入状态' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'filePath', label: '文件路径', type: 'input', visible: false, placeholder: '请输入文件路径' },
        { prop: 'fileSize', label: '文件大小', type: 'number', visible: false, placeholder: '请输入文件大小' },
        { prop: 'uploadBy', label: '上传人', type: 'input', visible: false, placeholder: '请输入上传人' },
        { prop: 'uploadTime', label: '上传时间', type: 'daterange', visible: false, placeholder: '请输入上传时间', startProp: 'uploadTimeStart', endProp: 'uploadTimeEnd' }
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

  return new SearchConfigManager('newTechnologyProjectDocument', searchFieldGroups);
}


// newTechnologyProjectExtension搜索配置
export function createNewTechnologyProjectExtensionSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'applyNo', label: '申请编号', type: 'input', visible: true, placeholder: '请输入申请编号' },
        { prop: 'projectId', label: '项目ID', type: 'number', visible: true, placeholder: '请输入项目ID' },
        { prop: 'applyStatus', label: '申请状态', type: 'input', visible: true, placeholder: '请输入申请状态' },
        { prop: 'workflowInstanceId', label: '工作流实例ID', type: 'number', visible: false, placeholder: '请输入工作流实例ID' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'originalEndDate', label: '原结束日期', type: 'daterange', visible: false, placeholder: '请输入原结束日期', startProp: 'originalEndDateStart', endProp: 'originalEndDateEnd' },
        { prop: 'extendDays', label: '延期天数', type: 'number', visible: false, placeholder: '请输入延期天数' },
        { prop: 'newEndDate', label: '新结束日期', type: 'daterange', visible: false, placeholder: '请输入新结束日期', startProp: 'newEndDateStart', endProp: 'newEndDateEnd' },
        { prop: 'extensionReason', label: '延期理由', type: 'input', visible: false, placeholder: '请输入延期理由' }
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

  return new SearchConfigManager('newTechnologyProjectExtension', searchFieldGroups);
}


// newTechnologyProjectImplementation搜索配置
export function createNewTechnologyProjectImplementationSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'projectNo', label: '项目编号', type: 'input', visible: true, placeholder: '请输入项目编号' },
        { prop: 'implementationStatus', label: '实施状态 0-未开始 1-进行中 2-已完成 3-暂停', type: 'number', visible: true, placeholder: '请输入实施状态 0-未开始 1-进行中 2-已完成 3-暂停' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'implementDoctor', label: '实施医生', type: 'input', visible: true, placeholder: '请输入实施医生' },
        { prop: 'implementationLocation', label: '实施地点', type: 'input', visible: true, placeholder: '请输入实施地点' },
        { prop: 'implementationDate', label: '实施日期', type: 'daterange', visible: false, placeholder: '请输入实施日期', startProp: 'implementationDateStart', endProp: 'implementationDateEnd' },
        { prop: 'implementationResult', label: '实施结果', type: 'input', visible: false, placeholder: '请输入实施结果' }
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
        { prop: 'updateTime', label: '创建时间', type: 'daterange', visible: false, placeholder: '请输入创建时间', startProp: 'updateTimeStart', endProp: 'updateTimeEnd' },
        { prop: 'updateBy', label: '更新人', type: 'number', visible: false, placeholder: '请输入更新人' },
        { prop: 'remark', label: '备注', type: 'input', visible: false, placeholder: '请输入备注' }
      ]
    }
  ];

  return new SearchConfigManager('newTechnologyProjectImplementation', searchFieldGroups);
}


// newTechnologyProjectMapping搜索配置
export function createNewTechnologyProjectMappingSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'projectId', label: '项目ID', type: 'number', visible: true, placeholder: '请输入项目ID' },
        { prop: 'mappingType', label: '对码类型 医嘱项/ICD-9/收费项', type: 'input', visible: true, placeholder: '请输入对码类型 医嘱项/ICD-9/收费项' },
        { prop: 'sourceCode', label: '源编码', type: 'input', visible: true, placeholder: '请输入源编码' },
        { prop: 'sourceName', label: '源名称', type: 'input', visible: false, placeholder: '请输入源名称' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'targetSystem', label: '目标系统 HIS/收费系统', type: 'input', visible: false, placeholder: '请输入目标系统 HIS/收费系统' }
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

  return new SearchConfigManager('newTechnologyProjectMapping', searchFieldGroups);
}


// newTechnologyProjectProgress搜索配置
export function createNewTechnologyProjectProgressSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'reportNo', label: '报告编号', type: 'input', visible: true, placeholder: '请输入报告编号' },
        { prop: 'projectId', label: '项目ID', type: 'number', visible: true, placeholder: '请输入项目ID' },
        { prop: 'reportType', label: '报告类型 进展报告/结题报告', type: 'input', visible: true, placeholder: '请输入报告类型 进展报告/结题报告' },
        { prop: 'continueStatus', label: '继续状态 继续开展/终止/暂停', type: 'input', visible: false, placeholder: '请输入继续状态 继续开展/终止/暂停' },
        { prop: 'reportStatus', label: '报告状态', type: 'input', visible: false, placeholder: '请输入报告状态' },
        { prop: 'workflowInstanceId', label: '工作流实例ID', type: 'number', visible: false, placeholder: '请输入工作流实例ID' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'reportPeriod', label: '报告期间', type: 'input', visible: false, placeholder: '请输入报告期间' },
        { prop: 'reportDate', label: '报告日期', type: 'daterange', visible: false, placeholder: '请输入报告日期', startProp: 'reportDateStart', endProp: 'reportDateEnd' },
        { prop: 'caseCount', label: '开展病例数', type: 'number', visible: false, placeholder: '请输入开展病例数' },
        { prop: 'successCount', label: '成功病例数', type: 'number', visible: false, placeholder: '请输入成功病例数' },
        { prop: 'complicationCount', label: '并发症例数', type: 'number', visible: false, placeholder: '请输入并发症例数' },
        { prop: 'adverseReactionCount', label: '不良反应例数', type: 'number', visible: false, placeholder: '请输入不良反应例数' },
        { prop: 'mortalityCount', label: '死亡例数', type: 'number', visible: false, placeholder: '请输入死亡例数' },
        { prop: 'effectEvaluation', label: '效果评价', type: 'input', visible: false, placeholder: '请输入效果评价' },
        { prop: 'existingProblems', label: '存在问题', type: 'input', visible: false, placeholder: '请输入存在问题' },
        { prop: 'improvementMeasures', label: '改进措施', type: 'input', visible: false, placeholder: '请输入改进措施' },
        { prop: 'nextPlan', label: '下步计划', type: 'input', visible: false, placeholder: '请输入下步计划' },
        { prop: 'monitoringIndicators', label: '运行监测指标JSON', type: 'input', visible: false, placeholder: '请输入运行监测指标JSON' },
        { prop: 'attachmentUrls', label: '附件URLs', type: 'input', visible: false, placeholder: '请输入附件URLs' }
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

  return new SearchConfigManager('newTechnologyProjectProgress', searchFieldGroups);
}
