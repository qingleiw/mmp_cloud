import { SearchConfigManager, SearchFieldGroup } from '../../searchConfig';

// 肿瘤质控指标记录搜索配置
export function createTumorQcIndicatorRecordSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'indicatorName', label: '指标名称', type: 'input', placeholder: '请输入指标名称' },
        { prop: 'indicatorCode', label: '指标编码', type: 'input', placeholder: '请输入指标编码' }
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
        { prop: 'indicatorValue', label: '指标值', type: 'numberrange', placeholder: '请输入指标值范围' },
        { prop: 'complianceStatus', label: '达标状态', type: 'select', placeholder: '请选择达标状态' }
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

  return new SearchConfigManager('tumorQcIndicatorRecord', searchFieldGroups);
}

// 肿瘤质控报告搜索配置
export function createTumorQcReportSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'reportCode', label: '报告编码', type: 'input', placeholder: '请输入报告编码' },
        { prop: 'reportTitle', label: '报告标题', type: 'input', placeholder: '请输入报告标题' },
        { prop: 'reportType', label: '报告类型', type: 'select', placeholder: '请选择报告类型' }
      ]
    },
    {
      name: 'time',
      label: '时间范围',
      fields: [
        { prop: 'periodStart', label: '报告周期开始', type: 'daterange', placeholder: '请选择报告周期范围' },
        { prop: 'publishTime', label: '发布时间', type: 'daterange', placeholder: '请选择发布时间范围' }
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

  return new SearchConfigManager('tumorQcReport', searchFieldGroups);
}

// 肿瘤质控方案搜索配置
export function createTumorQcPlanSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'planCode', label: '方案编码', type: 'input', placeholder: '请输入方案编码' },
        { prop: 'planName', label: '方案名称', type: 'input', placeholder: '请输入方案名称' },
        { prop: 'planType', label: '方案类型', type: 'select', placeholder: '请选择方案类型' }
      ]
    },
    {
      name: 'time',
      label: '时间范围',
      fields: [
        { prop: 'startDate', label: '开始日期', type: 'daterange', placeholder: '请选择开始日期范围' },
        { prop: 'endDate', label: '结束日期', type: 'daterange', placeholder: '请选择结束日期范围' }
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

  return new SearchConfigManager('tumorQcPlan', searchFieldGroups);
}

// 肿瘤质控检查搜索配置
export function createTumorQcInspectionSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'inspectionCode', label: '检查编码', type: 'input', placeholder: '请输入检查编码' },
        { prop: 'inspectorName', label: '检查人姓名', type: 'input', placeholder: '请输入检查人姓名' },
        { prop: 'departmentName', label: '检查科室名称', type: 'input', placeholder: '请输入检查科室名称' },
        { prop: 'inspectionType', label: '检查类型', type: 'select', placeholder: '请选择检查类型' }
      ]
    },
    {
      name: 'time',
      label: '时间范围',
      fields: [
        { prop: 'inspectionDate', label: '检查日期', type: 'daterange', placeholder: '请选择检查日期范围' }
      ]
    },
    {
      name: 'result',
      label: '检查结果',
      fields: [
        { prop: 'inspectionResult', label: '检查结果', type: 'select', placeholder: '请选择检查结果' },
        { prop: 'status', label: '状态', type: 'select', placeholder: '请选择状态' }
      ]
    }
  ];

  return new SearchConfigManager('tumorQcInspection', searchFieldGroups);
}

// 肿瘤质控整改搜索配置
export function createTumorQcRectificationSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'rectificationCode', label: '整改编码', type: 'input', placeholder: '请输入整改编码' },
        { prop: 'responsiblePersonName', label: '负责人姓名', type: 'input', placeholder: '请输入负责人姓名' }
      ]
    },
    {
      name: 'status',
      label: '整改状态',
      fields: [
        { prop: 'status', label: '状态', type: 'select', placeholder: '请选择状态' },
        { prop: 'rectificationResult', label: '整改结果', type: 'select', placeholder: '请选择整改结果' },
        { prop: 'verificationStatus', label: '验证状态', type: 'select', placeholder: '请选择验证状态' }
      ]
    },
    {
      name: 'time',
      label: '时间范围',
      fields: [
        { prop: 'deadline', label: '整改期限', type: 'daterange', placeholder: '请选择整改期限范围' },
        { prop: 'completionTime', label: '完成时间', type: 'daterange', placeholder: '请选择完成时间范围' }
      ]
    }
  ];

  return new SearchConfigManager('tumorQcRectification', searchFieldGroups);
}

// 肿瘤质控指标配置搜索配置
export function createTumorQcIndicatorConfigSearchConfig() {
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
      name: 'standard',
      label: '标准信息',
      fields: [
        { prop: 'targetValue', label: '目标值', type: 'numberrange', placeholder: '请输入目标值范围' }
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
        { prop: 'effectiveDate', label: '生效日期', type: 'daterange', placeholder: '请选择生效日期范围' }
      ]
    }
  ];

  return new SearchConfigManager('tumorQcIndicatorConfig', searchFieldGroups);
}

// 肿瘤质控指标详情搜索配置
export function createTumorQcIndicatorDetailSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'indicatorId', label: '指标ID', type: 'input', placeholder: '请输入指标ID' },
        { prop: 'detailType', label: '详情类型', type: 'select', placeholder: '请选择详情类型' }
      ]
    },
    {
      name: 'data',
      label: '数据信息',
      fields: [
        { prop: 'calculatedValue', label: '计算值', type: 'numberrange', placeholder: '请输入计算值范围' },
        { prop: 'dataSource', label: '数据来源', type: 'select', placeholder: '请选择数据来源' }
      ]
    },
    {
      name: 'status',
      label: '状态信息',
      fields: [
        { prop: 'isValid', label: '是否有效', type: 'select', placeholder: '请选择有效状态' },
        { prop: 'verificationStatus', label: '验证状态', type: 'select', placeholder: '请选择验证状态' }
      ]
    },
    {
      name: 'time',
      label: '时间范围',
      fields: [
        { prop: 'detailDate', label: '详情日期', type: 'daterange', placeholder: '请选择详情日期范围' }
      ]
    }
  ];

  return new SearchConfigManager('tumorQcIndicatorDetail', searchFieldGroups);
}

// 肿瘤质控结果搜索配置
export function createTumorQcResultSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'indicatorName', label: '指标名称', type: 'input', placeholder: '请输入指标名称' }
      ]
    },
    {
      name: 'measurement',
      label: '测量信息',
      fields: [
        { prop: 'measuredValue', label: '测量值', type: 'numberrange', placeholder: '请输入测量值范围' },
        { prop: 'performanceLevel', label: '绩效水平', type: 'select', placeholder: '请选择绩效水平' }
      ]
    },
    {
      name: 'assessment',
      label: '评估信息',
      fields: [
        { prop: 'complianceStatus', label: '合规状态', type: 'select', placeholder: '请选择合规状态' },
        { prop: 'riskLevel', label: '风险等级', type: 'select', placeholder: '请选择风险等级' }
      ]
    },
    {
      name: 'time',
      label: '时间范围',
      fields: [
        { prop: 'resultDate', label: '结果日期', type: 'daterange', placeholder: '请选择结果日期范围' }
      ]
    }
  ];

  return new SearchConfigManager('tumorQcResult', searchFieldGroups);
}