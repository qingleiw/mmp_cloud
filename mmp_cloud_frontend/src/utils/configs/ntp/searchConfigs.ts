import { SearchConfigManager, SearchFieldGroup } from '../../searchConfig';

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
        { prop: 'projectType', label: '项目类型', type: 'select', placeholder: '请选择项目类型' }
      ]
    },
    {
      name: 'team',
      label: '团队信息',
      fields: [
        { prop: 'projectLeader', label: '项目负责人', type: 'input', placeholder: '请输入项目负责人' }
      ]
    },
    {
      name: 'status',
      label: '状态信息',
      fields: [
        { prop: 'projectStatus', label: '项目状态', type: 'select', placeholder: '请选择项目状态' },
        { prop: 'approvalStatus', label: '审批状态', type: 'select', placeholder: '请选择审批状态' }
      ]
    },
    {
      name: 'time',
      label: '时间范围',
      fields: [
        { prop: 'startDate', label: '开始日期', type: 'daterange', placeholder: '请选择开始日期范围' },
        { prop: 'endDate', label: '结束日期', type: 'daterange', placeholder: '请选择结束日期范围' }
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
        { prop: 'assessmentYear', label: '考核年份', type: 'input', placeholder: '请输入考核年份' },
        { prop: 'assessmentDate', label: '考核日期', type: 'daterange', placeholder: '请选择考核日期范围' },
        { prop: 'assessor', label: '考核人', type: 'input', placeholder: '请输入考核人' }
      ]
    },
    {
      name: 'result',
      label: '考核结果',
      fields: [
        { prop: 'assessmentResult', label: '考核结果', type: 'select', placeholder: '请选择考核结果' },
        { prop: 'score', label: '评分', type: 'numberrange', placeholder: '请输入评分范围' },
        { prop: 'assessmentOpinion', label: '考核意见', type: 'input', placeholder: '请输入考核意见' },
        { prop: 'improvementMeasures', label: '改进措施', type: 'input', placeholder: '请输入改进措施' }
      ]
    }
  ];

  return new SearchConfigManager('newTechnologyProjectAssessment', searchFieldGroups);
}