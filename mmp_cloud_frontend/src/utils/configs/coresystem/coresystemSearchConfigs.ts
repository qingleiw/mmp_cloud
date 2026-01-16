import { SearchConfigManager, SearchFieldGroup } from '../searchConfigManager';

// 系统指标监控记录搜索配置
export function createSystemIndicatorMonitorRecordSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'indicatorName', label: '指标名称', type: 'input', placeholder: '请输入指标名称' },
        { prop: 'indicatorId', label: '指标ID', type: 'input', placeholder: '请输入指标ID' },
        { prop: 'calculationCycle', label: '计算周期', type: 'select', placeholder: '请选择计算周期' }
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
      name: 'data',
      label: '数据信息',
      fields: [
        { prop: 'currentValue', label: '当前值', type: 'numberrange', placeholder: '请输入当前值范围' },
        { prop: 'targetValue', label: '目标值', type: 'numberrange', placeholder: '请输入目标值范围' },
        { prop: 'completionRate', label: '完成率(%)', type: 'numberrange', placeholder: '请输入完成率范围' }
      ]
    },
    {
      name: 'alert',
      label: '告警信息',
      fields: [
        { prop: 'alertLevel', label: '告警级别', type: 'select', placeholder: '请选择告警级别' },
        { prop: 'isResolved', label: '是否已解决', type: 'select', placeholder: '请选择解决状态' },
        { prop: 'isAlert', label: '是否预警', type: 'select', placeholder: '请选择预警状态' }
      ]
    },
    {
      name: 'system',
      label: '制度信息',
      fields: [
        { prop: 'systemName', label: '制度名称', type: 'input', placeholder: '请输入制度名称' },
        { prop: 'systemCode', label: '制度编码', type: 'input', placeholder: '请输入制度编码' }
      ]
    },
    {
      name: 'time',
      label: '时间范围',
      fields: [
        { prop: 'recordDate', label: '记录日期', type: 'daterange', placeholder: '请选择记录日期范围' }
      ]
    }
  ];

  return new SearchConfigManager('systemIndicatorMonitorRecord', searchFieldGroups);
}

// 质控指标采集配置搜索配置
export function createQcIndicatorCollectionConfigSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'indicatorId', label: '指标ID', type: 'input', placeholder: '请输入指标ID' },
        { prop: 'sourceSystem', label: '来源系统', type: 'input', placeholder: '请输入来源系统' },
        { prop: 'sourceTable', label: '来源表', type: 'input', placeholder: '请输入来源表' },
        { prop: 'sourceField', label: '来源字段', type: 'input', placeholder: '请输入来源字段' }
      ]
    },
    {
      name: 'rule',
      label: '规则信息',
      fields: [
        { prop: 'dataType', label: '数据类型', type: 'select', placeholder: '请选择数据类型' },
        { prop: 'isRequired', label: '是否必需', type: 'select', placeholder: '请选择是否必需' }
      ]
    }
  ];

  return new SearchConfigManager('qcIndicatorCollectionConfig', searchFieldGroups);
}

// 核心制度指标搜索配置
export function createCoreSystemIndicatorSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'indicatorCode', label: '指标编码', type: 'input', placeholder: '请输入指标编码' },
        { prop: 'indicatorName', label: '指标名称', type: 'input', placeholder: '请输入指标名称' },
        { prop: 'indicatorType', label: '指标类型', type: 'select', placeholder: '请选择指标类型' }
      ]
    },
    {
      name: 'calculation',
      label: '计算信息',
      fields: [
        { prop: 'calculationCycle', label: '计算周期', type: 'select', placeholder: '请选择计算周期' },
        { prop: 'targetValue', label: '目标值', type: 'numberrange', placeholder: '请输入目标值范围' },
        { prop: 'weight', label: '权重', type: 'numberrange', placeholder: '请输入权重范围' }
      ]
    },
    {
      name: 'status',
      label: '状态信息',
      fields: [
        { prop: 'status', label: '状态', type: 'select', placeholder: '请选择状态' }
      ]
    }
  ];

  return new SearchConfigManager('coreSystemIndicator', searchFieldGroups);
}

// 核心制度考核记录搜索配置
export function createCoreSystemAssessmentRecordSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'systemName', label: '制度名称', type: 'input', placeholder: '请输入制度名称' },
        { prop: 'assessorName', label: '考核人名称', type: 'input', placeholder: '请输入考核人名称' }
      ]
    },
    {
      name: 'assessment',
      label: '考核信息',
      fields: [
        { prop: 'assessmentCycle', label: '考核周期', type: 'select', placeholder: '请选择考核周期' },
        { prop: 'assessmentScore', label: '考核分数', type: 'numberrange', placeholder: '请输入考核分数范围' },
        { prop: 'assessmentGrade', label: '考核等级', type: 'select', placeholder: '请选择考核等级' },
        { prop: 'assessmentResult', label: '考核结果', type: 'select', placeholder: '请选择考核结果' },
        { prop: 'assessmentOpinion', label: '考核意见', type: 'input', placeholder: '请输入考核意见' }
      ]
    },
    {
      name: 'time',
      label: '时间范围',
      fields: [
        { prop: 'assessmentTime', label: '考核时间', type: 'daterange', placeholder: '请选择考核时间范围' }
      ]
    },
    {
      name: 'status',
      label: '状态信息',
      fields: [
        { prop: 'delFlag', label: '删除标志', type: 'select', placeholder: '请选择删除状态' }
      ]
    }
  ];

  return new SearchConfigManager('coreSystemAssessmentRecord', searchFieldGroups);
}

// 核心制度执行记录搜索配置
export function createCoreSystemExecutionRecordSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'systemName', label: '制度名称', type: 'input', placeholder: '请输入制度名称' },
        { prop: 'executorName', label: '执行人姓名', type: 'input', placeholder: '请输入执行人姓名' }
      ]
    },
    {
      name: 'execution',
      label: '执行信息',
      fields: [
        { prop: 'executionResult', label: '执行结果', type: 'select', placeholder: '请选择执行结果' }
      ]
    },
    {
      name: 'time',
      label: '时间范围',
      fields: [
        { prop: 'executionTime', label: '执行时间', type: 'daterange', placeholder: '请选择执行时间范围' }
      ]
    },
    {
      name: 'status',
      label: '状态信息',
      fields: [
        { prop: 'delFlag', label: '删除标志', type: 'select', placeholder: '请选择删除状态' }
      ]
    }
  ];

  return new SearchConfigManager('coreSystemExecutionRecord', searchFieldGroups);
}

// 核心制度检查记录搜索配置
export function createCoreSystemInspectionRecordSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'systemName', label: '制度名称', type: 'input', placeholder: '请输入制度名称' },
        { prop: 'inspectorName', label: '检查人姓名', type: 'input', placeholder: '请输入检查人姓名' }
      ]
    },
    {
      name: 'inspection',
      label: '检查信息',
      fields: [
        { prop: 'inspectionResult', label: '检查结果', type: 'select', placeholder: '请选择检查结果' }
      ]
    },
    {
      name: 'time',
      label: '时间范围',
      fields: [
        { prop: 'inspectionTime', label: '检查时间', type: 'daterange', placeholder: '请选择检查时间范围' }
      ]
    }
  ];

  return new SearchConfigManager('coreSystemInspectionRecord', searchFieldGroups);
}

// 核心制度整改记录搜索配置
export function createCoreSystemRectificationRecordSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'rectificationId', label: '整改编号', type: 'input', placeholder: '请输入整改编号' },
        { prop: 'systemName', label: '制度名称', type: 'input', placeholder: '请输入制度名称' },
        { prop: 'rectifierName', label: '整改人名称', type: 'input', placeholder: '请输入整改人名称' }
      ]
    },
    {
      name: 'status',
      label: '整改状态',
      fields: [
        { prop: 'rectificationStatus', label: '整改状态', type: 'select', placeholder: '请选择整改状态' },
        { prop: 'acceptanceResult', label: '验收结果', type: 'select', placeholder: '请选择验收结果' }
      ]
    },
    {
      name: 'content',
      label: '整改内容',
      fields: [
        { prop: 'rectificationContent', label: '整改内容', type: 'input', placeholder: '请输入整改内容' },
        { prop: 'rectificationMeasures', label: '整改措施', type: 'input', placeholder: '请输入整改措施' },
        { prop: 'acceptanceOpinion', label: '验收意见', type: 'input', placeholder: '请输入验收意见' }
      ]
    },
    {
      name: 'time',
      label: '时间范围',
      fields: [
        { prop: 'rectificationStartTime', label: '开始时间', type: 'daterange', placeholder: '请选择开始时间范围' },
        { prop: 'rectificationEndTime', label: '完成时间', type: 'daterange', placeholder: '请选择完成时间范围' }
      ]
    },
    {
      name: 'system',
      label: '系统信息',
      fields: [
        { prop: 'delFlag', label: '删除标志', type: 'select', placeholder: '请选择删除状态' }
      ]
    }
  ];

  return new SearchConfigManager('coreSystemRectificationRecord', searchFieldGroups);
}

// 核心制度配置搜索配置
export function createCoreSystemConfigSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'systemCode', label: '制度编码', type: 'input', placeholder: '请输入制度编码' },
        { prop: 'systemName', label: '制度名称', type: 'input', placeholder: '请输入制度名称' },
        { prop: 'systemType', label: '制度类型', type: 'select', placeholder: '请选择制度类型' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'systemDescription', label: '制度描述', type: 'input', placeholder: '请输入制度描述' },
        { prop: 'totalScore', label: '制度总分', type: 'numberrange', placeholder: '请输入制度总分范围' },
        { prop: 'weight', label: '权重', type: 'numberrange', placeholder: '请输入权重范围' }
      ]
    },
    {
      name: 'status',
      label: '状态信息',
      fields: [
        { prop: 'isEnabled', label: '是否启用', type: 'select', placeholder: '请选择启用状态' },
        { prop: 'isCustom', label: '是否自定义', type: 'select', placeholder: '请选择自定义状态' },
        { prop: 'delFlag', label: '删除标志', type: 'select', placeholder: '请选择删除状态' }
      ]
    }
  ];

  return new SearchConfigManager('coreSystemConfig', searchFieldGroups);
}