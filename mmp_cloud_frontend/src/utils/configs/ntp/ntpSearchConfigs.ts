import { SearchConfigManager, SearchFieldGroup } from '../searchConfigManager';

// 新技术案例搜索配置
export function createNewTechnologyCaseSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'caseTitle', label: '案例标题', type: 'input', placeholder: '请输入案例标题' },
        { prop: 'caseCode', label: '案例编码', type: 'input', placeholder: '请输入案例编码' },
        { prop: 'technologyType', label: '技术类型', type: 'select', placeholder: '请选择技术类型' },
        { prop: 'difficultyLevel', label: '难度等级', type: 'select', placeholder: '请选择难度等级' }
      ]
    },
    {
      name: 'operator',
      label: '操作信息',
      fields: [
        { prop: 'operator', label: '操作医生', type: 'input', placeholder: '请输入操作医生' }
      ]
    },
    {
      name: 'time',
      label: '时间范围',
      fields: [
        { prop: 'operationDate', label: '操作日期', type: 'daterange', placeholder: '请选择操作日期范围' }
      ]
    }
  ];

  return new SearchConfigManager('newTechnologyCase', searchFieldGroups);
}

// 新技术目录搜索配置
export function createNewTechnologyCatalogSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'catalogName', label: '目录名称', type: 'input', placeholder: '请输入目录名称' },
        { prop: 'catalogCode', label: '目录编码', type: 'input', placeholder: '请输入目录编码' },
        { prop: 'technologyCategory', label: '技术类别', type: 'select', placeholder: '请选择技术类别' }
      ]
    },
    {
      name: 'status',
      label: '状态信息',
      fields: [
        { prop: 'status', label: '状态', type: 'select', placeholder: '请选择状态' },
        { prop: 'approvalStatus', label: '审批状态', type: 'select', placeholder: '请选择审批状态' }
      ]
    }
  ];

  return new SearchConfigManager('newTechnologyCatalog', searchFieldGroups);
}

// 新技术扩展申请搜索配置
export function createNewTechnologyExtensionApplySearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'applyNo', label: '申请编号', type: 'input', placeholder: '请输入申请编号' },
        { prop: 'technologyName', label: '技术名称', type: 'input', placeholder: '请输入技术名称' },
        { prop: 'applicantName', label: '申请人姓名', type: 'input', placeholder: '请输入申请人姓名' }
      ]
    },
    {
      name: 'approval',
      label: '审批信息',
      fields: [
        { prop: 'approvalStatus', label: '审批状态', type: 'select', placeholder: '请选择审批状态' },
        { prop: 'approverName', label: '审批人姓名', type: 'input', placeholder: '请输入审批人姓名' }
      ]
    },
    {
      name: 'time',
      label: '时间范围',
      fields: [
        { prop: 'approvalTime', label: '审批时间', type: 'daterange', placeholder: '请选择审批时间范围' }
      ]
    }
  ];

  return new SearchConfigManager('newTechnologyExtensionApply', searchFieldGroups);
}

// 新技术映射搜索配置
export function createNewTechnologyMappingSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'technologyName', label: '技术名称', type: 'input', placeholder: '请输入技术名称' },
        { prop: 'mappingType', label: '映射类型', type: 'select', placeholder: '请选择映射类型' }
      ]
    },
    {
      name: 'mapping',
      label: '映射信息',
      fields: [
        { prop: 'sourceSystem', label: '源系统', type: 'input', placeholder: '请输入源系统' },
        { prop: 'targetSystem', label: '目标系统', type: 'input', placeholder: '请输入目标系统' }
      ]
    },
    {
      name: 'status',
      label: '状态信息',
      fields: [
        { prop: 'status', label: '状态', type: 'select', placeholder: '请选择状态' },
        { prop: 'isActive', label: '是否激活', type: 'select', placeholder: '请选择激活状态' }
      ]
    }
  ];

  return new SearchConfigManager('newTechnologyMapping', searchFieldGroups);
}

// 新技术进度报告搜索配置
export function createNewTechnologyProgressReportSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'reportNo', label: '报告编号', type: 'input', placeholder: '请输入报告编号' },
        { prop: 'technologyName', label: '技术名称', type: 'input', placeholder: '请输入技术名称' },
        { prop: 'reportPeriod', label: '报告周期', type: 'select', placeholder: '请选择报告周期' }
      ]
    },
    {
      name: 'progress',
      label: '进度信息',
      fields: [
        { prop: 'progressPercentage', label: '进度百分比', type: 'numberrange', placeholder: '请输入进度百分比范围' }
      ]
    }
  ];

  return new SearchConfigManager('newTechnologyProgressReport', searchFieldGroups);
}

// 新技术项目搜索配置
export function createNewTechnologyProjectSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'projectNo', label: '项目编号', type: 'input', placeholder: '请输入项目编号' },
        { prop: 'projectName', label: '项目名称', type: 'input', placeholder: '请输入项目名称' },
        { prop: 'projectType', label: '项目类型', type: 'select', placeholder: '请选择项目类型' },
        { prop: 'technologyCategory', label: '技术分类', type: 'input', placeholder: '请输入技术分类' },
        { prop: 'riskLevel', label: '风险等级', type: 'select', placeholder: '请选择风险等级' }
      ]
    },
    {
      name: 'department',
      label: '科室信息',
      fields: [
        { prop: 'applyDepartmentName', label: '申请科室名称', type: 'input', placeholder: '请输入申请科室名称' }
      ]
    },
    {
      name: 'team',
      label: '团队信息',
      fields: [
        { prop: 'projectLeader', label: '项目负责人', type: 'input', placeholder: '请输入项目负责人' },
        { prop: 'projectTeam', label: '项目团队成员', type: 'input', placeholder: '请输入团队成员关键词' }
      ]
    },
    {
      name: 'source',
      label: '技术来源',
      fields: [
        { prop: 'technologySource', label: '技术来源', type: 'input', placeholder: '请输入技术来源' }
      ]
    },
    {
      name: 'status',
      label: '状态信息',
      fields: [
        { prop: 'projectStatus', label: '项目状态', type: 'select', placeholder: '请选择项目状态' },
        { prop: 'approvalStatus', label: '审批状态', type: 'select', placeholder: '请选择审批状态' },
        { prop: 'conclusionType', label: '结题类型', type: 'select', placeholder: '请选择结题类型' }
      ]
    },
    {
      name: 'time',
      label: '时间范围',
      fields: [
        { prop: 'approveDate', label: '批准日期', type: 'daterange', placeholder: '请选择批准日期范围' },
        { prop: 'startDate', label: '开始日期', type: 'daterange', placeholder: '请选择开始日期范围' },
        { prop: 'endDate', label: '预计结束日期', type: 'daterange', placeholder: '请选择预计结束日期范围' },
        { prop: 'actualEndDate', label: '实际结束日期', type: 'daterange', placeholder: '请选择实际结束日期范围' }
      ]
    },
    {
      name: 'cycle',
      label: '周期信息',
      fields: [
        { prop: 'operationCycleDays', label: '运行周期(天)', type: 'numberrange', placeholder: '请输入运行周期范围' },
        { prop: 'progressReportCycle', label: '进展报告周期', type: 'select', placeholder: '请选择进展报告周期' }
      ]
    }
  ];

  return new SearchConfigManager('newTechnologyProject', searchFieldGroups);
}

// 新技术实施搜索配置
export function createNewTechnologyImplementationSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'implementationNo', label: '实施编号', type: 'input', placeholder: '请输入实施编号' },
        { prop: 'technologyName', label: '技术名称', type: 'input', placeholder: '请输入技术名称' },
        { prop: 'implementationPhase', label: '实施阶段', type: 'select', placeholder: '请选择实施阶段' }
      ]
    },
    {
      name: 'progress',
      label: '进度信息',
      fields: [
        { prop: 'progressStatus', label: '进度状态', type: 'select', placeholder: '请选择进度状态' },
        { prop: 'completionPercentage', label: '完成百分比', type: 'numberrange', placeholder: '请输入完成百分比范围' }
      ]
    }
  ];

  return new SearchConfigManager('newTechnologyImplementation', searchFieldGroups);
}

// 新技术项目考核评估搜索配置
export function createNewTechnologyProjectAssessmentSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'assessmentYear', label: '考核年份', type: 'input', placeholder: '请输入考核年份', visible: true },
        { prop: 'assessmentType', label: '考核类型', type: 'select', placeholder: '请选择考核类型', visible: true, options: [
          { label: '全部', value: '' },
          { label: '中期考核', value: 'midterm' },
          { label: '结题考核', value: 'final' },
          { label: '年度考核', value: 'annual' }
        ] },
        { prop: 'assessor', label: '考核人', type: 'input', placeholder: '请输入考核人', visible: true }
      ]
    },
    {
      name: 'result',
      label: '考核结果',
      fields: [
        { prop: 'assessmentResult', label: '考核结果', type: 'select', placeholder: '请选择考核结果', visible: true, options: [
          { label: '全部', value: '' },
          { label: '优秀', value: 'excellent' },
          { label: '良好', value: 'good' },
          { label: '合格', value: 'qualified' },
          { label: '不合格', value: 'unqualified' }
        ] },
        { prop: 'score', label: '评分', type: 'numberrange', placeholder: '请输入评分范围', visible: false, startProp: 'minScore', endProp: 'maxScore' }
      ]
    },
    {
      name: 'time',
      label: '时间信息',
      fields: [
        { prop: 'assessmentDate', label: '考核日期', type: 'daterange', placeholder: '请选择考核日期范围', visible: true, startProp: 'startDate', endProp: 'endDate' }
      ]
    },
    {
      name: 'status',
      label: '状态信息',
      fields: [
        { prop: 'status', label: '状态', type: 'select', placeholder: '请选择状态', visible: true, options: [
          { label: '全部', value: '' },
          { label: '草稿', value: '0' },
          { label: '已提交', value: '1' },
          { label: '审核中', value: '2' },
          { label: '已通过', value: '3' },
          { label: '已驳回', value: '4' }
        ] }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'assessmentOpinion', label: '考核意见', type: 'input', placeholder: '请输入考核意见关键词', visible: false },
        { prop: 'improvementMeasures', label: '改进措施', type: 'input', placeholder: '请输入改进措施关键词', visible: false },
        { prop: 'remark', label: '备注', type: 'input', placeholder: '请输入备注关键词', visible: false }
      ]
    }
  ];

  return new SearchConfigManager('newTechnologyProjectAssessment', searchFieldGroups);
}

// 新技术项目案例搜索配置
export function createNewTechnologyProjectCaseSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'patientName', label: '患者姓名', type: 'input', placeholder: '请输入患者姓名', visible: true },
        { prop: 'visitType', label: '就诊类型', type: 'select', placeholder: '请选择就诊类型', visible: true, options: [
          { label: '全部', value: '' },
          { label: '门诊', value: 'outpatient' },
          { label: '住院', value: 'inpatient' }
        ] },
        { prop: 'visitNo', label: '就诊号', type: 'input', placeholder: '请输入就诊号', visible: true }
      ]
    },
    {
      name: 'visit',
      label: '就诊信息',
      fields: [
        { prop: 'visitDate', label: '就诊日期', type: 'daterange', placeholder: '请选择就诊日期范围', visible: true, startProp: 'startVisitDate', endProp: 'endVisitDate' },
        { prop: 'visitDepartmentName', label: '就诊科室名称', type: 'input', placeholder: '请输入就诊科室名称', visible: false },
        { prop: 'diagnosis', label: '诊断', type: 'input', placeholder: '请输入诊断关键词', visible: false }
      ]
    },
    {
      name: 'operation',
      label: '操作信息',
      fields: [
        { prop: 'operator', label: '操作医生', type: 'input', placeholder: '请输入操作医生', visible: true },
        { prop: 'operationDate', label: '操作时间', type: 'daterange', placeholder: '请选择操作时间范围', visible: false, startProp: 'startOperationDate', endProp: 'endOperationDate' }
      ]
    },
    {
      name: 'followup',
      label: '随访信息',
      fields: [
        { prop: 'followUpStatus', label: '随访状态', type: 'select', placeholder: '请选择随访状态', visible: false, options: [
          { label: '全部', value: '' },
          { label: '未随访', value: 'not_followed' },
          { label: '随访中', value: 'following' },
          { label: '已完成', value: 'completed' }
        ] }
      ]
    },
    {
      name: 'report',
      label: '报备信息',
      fields: [
        { prop: 'isReported', label: '是否已报备', type: 'select', placeholder: '请选择报备状态', visible: false, options: [
          { label: '全部', value: '' },
          { label: '未报备', value: 0 },
          { label: '已报备', value: 1 }
        ] },
        { prop: 'reportTime', label: '报备时间', type: 'daterange', placeholder: '请选择报备时间范围', visible: false, startProp: 'startReportTime', endProp: 'endReportTime' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'effectEvaluation', label: '效果评价', type: 'input', placeholder: '请输入效果评价关键词', visible: false },
        { prop: 'complication', label: '并发症', type: 'input', placeholder: '请输入并发症关键词', visible: false },
        { prop: 'adverseReaction', label: '不良反应', type: 'input', placeholder: '请输入不良反应关键词', visible: false },
        { prop: 'followUpResult', label: '随访结果', type: 'input', placeholder: '请输入随访结果关键词', visible: false },
        { prop: 'remark', label: '备注', type: 'input', placeholder: '请输入备注关键词', visible: false }
      ]
    }
  ];

  return new SearchConfigManager('newTechnologyProjectCase', searchFieldGroups);
}

// 新技术项目文档搜索配置
export function createNewTechnologyProjectDocumentSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'documentType', label: '文档类型', type: 'select', placeholder: '请选择文档类型', visible: true, options: [
          { label: '全部', value: '' },
          { label: '申报书', value: 'application' },
          { label: '批复文件', value: 'approval' },
          { label: '进展报告', value: 'progress' },
          { label: '结题报告', value: 'final' }
        ] },
        { prop: 'documentName', label: '文档名称', type: 'input', placeholder: '请输入文档名称', visible: true }
      ]
    },
    {
      name: 'file',
      label: '文件信息',
      fields: [
        { prop: 'fileName', label: '文件名', type: 'input', placeholder: '请输入文件名', visible: false },
        { prop: 'uploadBy', label: '上传人', type: 'input', placeholder: '请输入上传人', visible: true }
      ]
    },
    {
      name: 'time',
      label: '时间信息',
      fields: [
        { prop: 'uploadTime', label: '上传时间', type: 'daterange', placeholder: '请选择上传时间范围', visible: false, startProp: 'startUploadTime', endProp: 'endUploadTime' }
      ]
    },
    {
      name: 'status',
      label: '状态信息',
      fields: [
        { prop: 'status', label: '状态', type: 'select', placeholder: '请选择状态', visible: true, options: [
          { label: '全部', value: '' },
          { label: '草稿', value: '0' },
          { label: '已提交', value: '1' },
          { label: '审核中', value: '2' },
          { label: '已通过', value: '3' },
          { label: '已驳回', value: '4' }
        ] }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'remark', label: '备注', type: 'input', placeholder: '请输入备注关键词', visible: false }
      ]
    }
  ];

  return new SearchConfigManager('newTechnologyProjectDocument', searchFieldGroups);
}

// 新技术项目延期申请搜索配置
export function createNewTechnologyProjectExtensionSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        {
          prop: 'applyNo',
          label: '申请编号',
          type: 'input',
          visible: true,
          placeholder: '请输入申请编号',
          span: 6
        },
        {
          prop: 'projectId',
          label: '项目ID',
          type: 'input',
          visible: true,
          placeholder: '请输入项目ID',
          span: 6
        }
      ]
    },
    {
      name: 'extension',
      label: '延期信息',
      fields: [
        {
          prop: 'extendDays',
          label: '延期天数',
          type: 'numberrange',
          visible: true,
          placeholder: '请选择延期天数范围',
          span: 6
        },
        {
          prop: 'extensionReason',
          label: '延期理由',
          type: 'input',
          visible: true,
          placeholder: '请输入延期理由',
          span: 6
        }
      ]
    },
    {
      name: 'time',
      label: '时间范围',
      fields: [
        {
          prop: 'originalEndDate',
          label: '原结束日期',
          type: 'daterange',
          visible: true,
          placeholder: '请选择原结束日期范围',
          span: 12
        },
        {
          prop: 'newEndDate',
          label: '新结束日期',
          type: 'daterange',
          visible: true,
          placeholder: '请选择新结束日期范围',
          span: 12
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
          placeholder: '请选择申请状态',
          span: 6,
          options: [
            { label: '待审核', value: '待审核' },
            { label: '已审核', value: '已审核' },
            { label: '已驳回', value: '已驳回' },
            { label: '草稿', value: '草稿' }
          ]
        }
      ]
    }
  ];

  return new SearchConfigManager('newTechnologyProjectExtension', searchFieldGroups);
}

// 新技术项目实施搜索配置
export function createNewTechnologyProjectImplementationSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        {
          prop: 'projectNo',
          label: '项目编号',
          type: 'input',
          visible: true,
          placeholder: '请输入项目编号',
          span: 6
        },
        {
          prop: 'implementDoctor',
          label: '实施医生',
          type: 'input',
          visible: true,
          placeholder: '请输入实施医生',
          span: 6
        },
        {
          prop: 'implementationLocation',
          label: '实施地点',
          type: 'input',
          visible: true,
          placeholder: '请输入实施地点',
          span: 6
        }
      ]
    },
    {
      name: 'implementation',
      label: '实施信息',
      fields: [
        {
          prop: 'implementationResult',
          label: '实施结果',
          type: 'input',
          visible: true,
          placeholder: '请输入实施结果',
          span: 6
        }
      ]
    },
    {
      name: 'time',
      label: '时间范围',
      fields: [
        {
          prop: 'implementationDate',
          label: '实施日期',
          type: 'daterange',
          visible: true,
          placeholder: '请选择实施日期范围',
          span: 12
        }
      ]
    },
    {
      name: 'status',
      label: '状态信息',
      fields: [
        {
          prop: 'implementationStatus',
          label: '实施状态',
          type: 'select',
          visible: true,
          placeholder: '请选择实施状态',
          span: 6,
          options: [
            { label: '未开始', value: 0 },
            { label: '进行中', value: 1 },
            { label: '已完成', value: 2 },
            { label: '暂停', value: 3 }
          ]
        }
      ]
    }
  ];

  return new SearchConfigManager('newTechnologyProjectImplementation', searchFieldGroups);
}

// 新技术项目对码搜索配置
export function createNewTechnologyProjectMappingSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        {
          prop: 'projectId',
          label: '项目ID',
          type: 'input',
          visible: true,
          placeholder: '请输入项目ID',
          span: 6
        },
        {
          prop: 'sourceCode',
          label: '源编码',
          type: 'input',
          visible: true,
          placeholder: '请输入源编码',
          span: 6
        },
        {
          prop: 'sourceName',
          label: '源名称',
          type: 'input',
          visible: true,
          placeholder: '请输入源名称',
          span: 6
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
          placeholder: '请选择对码类型',
          span: 6,
          options: [
            { label: '医嘱项', value: '医嘱项' },
            { label: 'ICD-9', value: 'ICD-9' },
            { label: '收费项', value: '收费项' }
          ]
        },
        {
          prop: 'targetSystem',
          label: '目标系统',
          type: 'select',
          visible: true,
          placeholder: '请选择目标系统',
          span: 6,
          options: [
            { label: 'HIS', value: 'HIS' },
            { label: '收费系统', value: '收费系统' }
          ]
        }
      ]
    }
  ];

  return new SearchConfigManager('newTechnologyProjectMapping', searchFieldGroups);
}

// 新技术项目进展搜索配置
export function createNewTechnologyProjectProgressSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'reportNo', label: '报告编号', type: 'input', placeholder: '请输入报告编号' },
        { prop: 'reportPeriod', label: '报告期间', type: 'input', placeholder: '请输入报告期间' }
      ]
    },
    {
      name: 'report',
      label: '报告信息',
      fields: [
        { prop: 'reportType', label: '报告类型', type: 'select', placeholder: '请选择报告类型' },
        { prop: 'reportStatus', label: '报告状态', type: 'select', placeholder: '请选择报告状态' }
      ]
    },
    {
      name: 'statistics',
      label: '统计数据',
      fields: [
        { prop: 'caseCount', label: '开展病例数', type: 'number', placeholder: '请输入开展病例数' },
        { prop: 'successCount', label: '成功病例数', type: 'number', placeholder: '请输入成功病例数' }
      ]
    },
    {
      name: 'time',
      label: '时间范围',
      fields: [
        { prop: 'reportDate', label: '报告日期', type: 'daterange', placeholder: '请选择报告日期范围' }
      ]
    },
    {
      name: 'status',
      label: '状态信息',
      fields: [
        { prop: 'continueStatus', label: '继续状态', type: 'select', placeholder: '请选择继续状态' }
      ]
    }
  ];

  return new SearchConfigManager('newTechnologyProjectProgress', searchFieldGroups);
}