import { SearchConfigManager, SearchFieldGroup } from '../searchConfigManager';

// 科室资格目录搜索配置
export function createDepartmentQualificationDirectorySearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'departmentName', label: '科室名称', type: 'input', placeholder: '请输入科室名称' },
        { prop: 'qualificationName', label: '资格名称', type: 'input', placeholder: '请输入资格名称' },
        { prop: 'qualificationCode', label: '资格编码', type: 'input', placeholder: '请输入资格编码' }
      ]
    },
    {
      name: 'status',
      label: '状态信息',
      fields: [
        { prop: 'status', label: '状态', type: 'select', placeholder: '请选择状态' },
        { prop: 'isActive', label: '是否激活', type: 'select', placeholder: '请选择激活状态' }
      ]
    },
    {
      name: 'time',
      label: '时间范围',
      fields: [
        { prop: 'createTime', label: '创建时间', type: 'daterange', placeholder: '请选择创建时间范围' }
      ]
    }
  ];

  return new SearchConfigManager('departmentQualificationCatalog', searchFieldGroups);
}

// 资质准入条件搜索配置
export function createQualificationAdmissionConditionSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'qualificationType', label: '资质类型', type: 'select', placeholder: '请选择资质类型' },
        { prop: 'conditionType', label: '条件类型', type: 'select', placeholder: '请选择条件类型' }
      ]
    },
    {
      name: 'condition',
      label: '条件信息',
      fields: [
        { prop: 'conditionOperator', label: '条件运算符', type: 'select', placeholder: '请选择运算符' },
        { prop: 'isRequired', label: '是否必须', type: 'select', placeholder: '请选择是否必须' }
      ]
    }
  ];

  return new SearchConfigManager('qualificationAdmissionCondition', searchFieldGroups);
}

// 资质授权申请搜索配置
export function createQualificationAuthorizationApplySearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'applyNo', label: '申请单号', type: 'input', placeholder: '请输入申请单号' },
        { prop: 'applicantName', label: '申请人姓名', type: 'input', placeholder: '请输入申请人姓名' },
        { prop: 'applicantType', label: '申请人类型', type: 'select', placeholder: '请选择申请人类型' }
      ]
    },
    {
      name: 'department',
      label: '科室信息',
      fields: [
        { prop: 'departmentName', label: '科室名称', type: 'input', placeholder: '请输入科室名称' }
      ]
    },
    {
      name: 'status',
      label: '状态信息',
      fields: [
        { prop: 'applyStatus', label: '申请状态', type: 'select', placeholder: '请选择申请状态' },
        { prop: 'currentNode', label: '当前审批节点', type: 'input', placeholder: '请输入当前审批节点' }
      ]
    },
    {
      name: 'time',
      label: '时间范围',
      fields: [
        { prop: 'createTime', label: '创建时间', type: 'daterange', placeholder: '请选择创建时间范围' }
      ]
    }
  ];

  return new SearchConfigManager('qualificationAuthorizationApply', searchFieldGroups);
}

// 资质授权记录搜索配置
export function createQualificationAuthorizationRecordSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'authorizationNo', label: '授权编号', type: 'input', placeholder: '请输入授权编号' },
        { prop: 'staffName', label: '人员姓名', type: 'input', placeholder: '请输入人员姓名' },
        { prop: 'staffType', label: '人员类型', type: 'select', placeholder: '请选择人员类型' }
      ]
    },
    {
      name: 'qualification',
      label: '资质信息',
      fields: [
        { prop: 'qualificationName', label: '资质名称', type: 'input', placeholder: '请输入资质名称' },
        { prop: 'qualificationCode', label: '资质编码', type: 'input', placeholder: '请输入资质编码' }
      ]
    },
    {
      name: 'authorization',
      label: '授权信息',
      fields: [
        { prop: 'authorizationType', label: '授权类型', type: 'select', placeholder: '请选择授权类型' },
        { prop: 'authorizationLevel', label: '授权级别', type: 'select', placeholder: '请选择授权级别' },
        { prop: 'authorizationStatus', label: '授权状态', type: 'select', placeholder: '请选择授权状态' }
      ]
    },
    {
      name: 'time',
      label: '时间范围',
      fields: [
        { prop: 'validStartDate', label: '有效期开始', type: 'daterange', placeholder: '请选择有效期范围' },
        { prop: 'createTime', label: '创建时间', type: 'daterange', placeholder: '请选择创建时间范围' }
      ]
    }
  ];

  return new SearchConfigManager('qualificationAuthorizationRecord', searchFieldGroups);
}

// 资质考试安排搜索配置
export function createQualificationExamArrangementSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'examCode', label: '考试编号', type: 'input', placeholder: '请输入考试编号' },
        { prop: 'examName', label: '考试名称', type: 'input', placeholder: '请输入考试名称' }
      ]
    },
    {
      name: 'time',
      label: '时间信息',
      fields: [
        { prop: 'examStartTime', label: '考试时间', type: 'daterange', placeholder: '请选择考试时间范围' }
      ]
    },
    {
      name: 'status',
      label: '状态信息',
      fields: [
        { prop: 'examStatus', label: '考试状态', type: 'select', placeholder: '请选择考试状态' }
      ]
    }
  ];

  return new SearchConfigManager('qualificationExamArrangement', searchFieldGroups);
}

// 资质风险监控搜索配置
export function createQualificationRiskMonitorSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'riskNo', label: '风险编号', type: 'input', placeholder: '请输入风险编号' },
        { prop: 'staffName', label: '人员姓名', type: 'input', placeholder: '请输入人员姓名' },
        { prop: 'qualificationName', label: '资质名称', type: 'input', placeholder: '请输入资质名称' }
      ]
    },
    {
      name: 'risk',
      label: '风险信息',
      fields: [
        { prop: 'riskType', label: '风险类型', type: 'select', placeholder: '请选择风险类型' },
        { prop: 'riskLevel', label: '风险等级', type: 'select', placeholder: '请选择风险等级' }
      ]
    },
    {
      name: 'time',
      label: '时间范围',
      fields: [
        { prop: 'riskDate', label: '风险发生时间', type: 'daterange', placeholder: '请选择风险发生时间范围' },
        { prop: 'handleTime', label: '处理时间', type: 'daterange', placeholder: '请选择处理时间范围' }
      ]
    },
    {
      name: 'handle',
      label: '处理信息',
      fields: [
        { prop: 'handlingStatus', label: '处理状态', type: 'select', placeholder: '请选择处理状态' },
        { prop: 'handler', label: '处理人', type: 'input', placeholder: '请输入处理人' }
      ]
    }
  ];

  return new SearchConfigManager('qualificationRiskMonitor', searchFieldGroups);
}

// 资质使用记录搜索配置
export function createQualificationUsageRecordSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'doctorName', label: '医生姓名', type: 'input', placeholder: '请输入医生姓名' },
        { prop: 'qualificationName', label: '资质名称', type: 'input', placeholder: '请输入资质名称' }
      ]
    },
    {
      name: 'usage',
      label: '使用信息',
      fields: [
        { prop: 'usageType', label: '使用类型', type: 'select', placeholder: '请选择使用类型' },
        { prop: 'usageLocation', label: '使用地点', type: 'input', placeholder: '请输入使用地点' },
        { prop: 'patientId', label: '患者ID', type: 'input', placeholder: '请输入患者ID' }
      ]
    },
    {
      name: 'result',
      label: '结果信息',
      fields: [
        { prop: 'outcome', label: '结果', type: 'select', placeholder: '请选择结果' },
        { prop: 'status', label: '状态', type: 'select', placeholder: '请选择状态' },
        { prop: 'supervisor', label: '监督人', type: 'input', placeholder: '请输入监督人' }
      ]
    },
    {
      name: 'time',
      label: '时间范围',
      fields: [
        { prop: 'usageDate', label: '使用日期', type: 'daterange', placeholder: '请选择使用日期范围' },
        { prop: 'createTime', label: '创建时间', type: 'daterange', placeholder: '请选择创建时间范围' }
      ]
    }
  ];

  return new SearchConfigManager('qualificationUsageRecord', searchFieldGroups);
}

// 技师资质目录搜索配置
export function createTechnicianQualificationCatalogSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'catalogCode', label: '资质编码', type: 'input', placeholder: '请输入资质编码' },
        { prop: 'catalogName', label: '资质名称', type: 'input', placeholder: '请输入资质名称' },
        { prop: 'catalogType', label: '资质类型', type: 'select', placeholder: '请选择资质类型' }
      ]
    },
    {
      name: 'status',
      label: '状态信息',
      fields: [
        { prop: 'isEnabled', label: '是否启用', type: 'select', placeholder: '请选择启用状态' }
      ]
    }
  ];

  return new SearchConfigManager('technicianQualificationCatalog', searchFieldGroups);
}

// 资质考核试卷搜索配置
export function createQualificationExamPaperSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'paperCode', label: '试卷编号', type: 'input', placeholder: '请输入试卷编号' },
        { prop: 'paperName', label: '试卷名称', type: 'input', placeholder: '请输入试卷名称' }
      ]
    },
    {
      name: 'settings',
      label: '设置信息',
      fields: [
        { prop: 'isEnabled', label: '是否启用', type: 'select', placeholder: '请选择启用状态' },
        { prop: 'isRandom', label: '是否随机抽题', type: 'select', placeholder: '请选择是否随机抽题' }
      ]
    }
  ];

  return new SearchConfigManager('qualificationExamPaper', searchFieldGroups);
}

// 资质考试题目搜索配置
export function createQualificationExamQuestionSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'questionCode', label: '题目编号', type: 'input', placeholder: '请输入题目编号' },
        { prop: 'questionType', label: '题型', type: 'select', placeholder: '请选择题型' },
        { prop: 'questionContent', label: '题目内容', type: 'input', placeholder: '请输入题目内容关键词' }
      ]
    },
    {
      name: 'answer',
      label: '答案信息',
      fields: [
        { prop: 'correctAnswer', label: '正确答案', type: 'input', placeholder: '请输入正确答案' }
      ]
    },
    {
      name: 'settings',
      label: '题目设置',
      fields: [
        { prop: 'difficultyLevel', label: '难度级别', type: 'select', placeholder: '请选择难度级别' },
        { prop: 'isEnabled', label: '是否启用', type: 'select', placeholder: '请选择启用状态' }
      ]
    },
    {
      name: 'time',
      label: '时间范围',
      fields: [
        { prop: 'createTime', label: '创建时间', type: 'daterange', placeholder: '请选择创建时间范围' }
      ]
    }
  ];

  return new SearchConfigManager('qualificationExamQuestion', searchFieldGroups);
}

// 资质权限调整搜索配置
export function createQualificationPermissionAdjustmentSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'doctorName', label: '医师姓名', type: 'input', placeholder: '请输入医师姓名' },
        { prop: 'qualificationType', label: '资质类型', type: 'select', placeholder: '请选择资质类型' },
        { prop: 'originalLevel', label: '原权限级别', type: 'select', placeholder: '请选择原权限级别' },
        { prop: 'newLevel', label: '新权限级别', type: 'select', placeholder: '请选择新权限级别' }
      ]
    },
    {
      name: 'operator',
      label: '操作信息',
      fields: [
        { prop: 'operatorName', label: '操作人姓名', type: 'input', placeholder: '请输入操作人姓名' },
        { prop: 'isAutoAdjustment', label: '是否自动调整', type: 'select', placeholder: '请选择是否自动调整' }
      ]
    },
    {
      name: 'time',
      label: '时间范围',
      fields: [
        { prop: 'adjustmentTime', label: '调整时间', type: 'daterange', placeholder: '请选择调整时间范围' },
        { prop: 'createTime', label: '创建时间', type: 'daterange', placeholder: '请选择创建时间范围' }
      ]
    }
  ];

  return new SearchConfigManager('qualificationPermissionAdjustment', searchFieldGroups);
}