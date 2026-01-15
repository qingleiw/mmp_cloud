import { SearchConfigManager, SearchFieldGroup } from '../../searchConfig';

// 质量指标搜索配置
export function createQcQualityIndicatorSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'indicatorCode', label: '指标编码', type: 'input', placeholder: '请输入指标编码' },
        { prop: 'indicatorName', label: '指标名称', type: 'input', placeholder: '请输入指标名称' },
        { prop: 'indicatorLevel', label: '指标层级', type: 'select', placeholder: '请选择指标层级' },
        { prop: 'dataType', label: '数据类型', type: 'select', placeholder: '请选择数据类型' }
      ]
    },
    {
      name: 'definition',
      label: '指标定义',
      fields: [
        { prop: 'definition', label: '定义', type: 'input', placeholder: '请输入定义关键词' },
        { prop: 'significance', label: '意义', type: 'input', placeholder: '请输入意义关键词' }
      ]
    },
    {
      name: 'standard',
      label: '标准信息',
      fields: [
        { prop: 'standardValue', label: '标准值', type: 'numberrange', placeholder: '请输入标准值范围' },
        { prop: 'unit', label: '单位', type: 'input', placeholder: '请输入单位' }
      ]
    }
  ];

  return new SearchConfigManager('qcQualityIndicator', searchFieldGroups);
}

// 评分结果搜索配置
export function createQcScoringResultSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'indicator',
      label: '指标信息',
      fields: [
        { prop: 'indicatorId', label: '指标ID', type: 'input', placeholder: '请输入指标ID' },
        { prop: 'indicatorValue', label: '指标值', type: 'numberrange', placeholder: '请输入指标值范围' },
        { prop: 'standardValue', label: '标准值', type: 'numberrange', placeholder: '请输入标准值范围' }
      ]
    },
    {
      name: 'scoring',
      label: '评分信息',
      fields: [
        { prop: 'maxScore', label: '满分', type: 'numberrange', placeholder: '请输入满分范围' },
        { prop: 'actualScore', label: '实际得分', type: 'numberrange', placeholder: '请输入实际得分范围' },
        { prop: 'scoreRate', label: '得分率', type: 'numberrange', placeholder: '请输入得分率范围' },
        { prop: 'evaluationLevel', label: '评价等级', type: 'select', placeholder: '请选择评价等级' }
      ]
    },
    {
      name: 'time',
      label: '时间范围',
      fields: [
        { prop: 'calculateTime', label: '计算时间', type: 'daterange', placeholder: '请选择计算时间范围' }
      ]
    }
  ];

  return new SearchConfigManager('qcScoringResult', searchFieldGroups);
}

// 数据采集搜索配置
export function createQcDataCollectionSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'indicatorId', label: '指标ID', type: 'input', placeholder: '请输入指标ID' },
        { prop: 'departmentName', label: '科室名称', type: 'input', placeholder: '请输入科室名称' },
        { prop: 'collectionPeriod', label: '采集周期', type: 'select', placeholder: '请选择采集周期' },
        { prop: 'status', label: '状态', type: 'select', placeholder: '请选择状态' }
      ]
    },
    {
      name: 'data',
      label: '数据信息',
      fields: [
        { prop: 'numeratorValue', label: '分子值', type: 'numberrange', placeholder: '请输入分子值范围' },
        { prop: 'denominatorValue', label: '分母值', type: 'numberrange', placeholder: '请输入分母值范围' },
        { prop: 'indicatorValue', label: '指标值', type: 'numberrange', placeholder: '请输入指标值范围' },
        { prop: 'dataSource', label: '数据来源', type: 'input', placeholder: '请输入数据来源' }
      ]
    },
    {
      name: 'review',
      label: '审核信息',
      fields: [
        { prop: 'reviewStatus', label: '审核状态', type: 'select', placeholder: '请选择审核状态' }
      ]
    },
    {
      name: 'time',
      label: '时间范围',
      fields: [
        { prop: 'collectionDate', label: '采集日期', type: 'daterange', placeholder: '请选择采集日期范围' }
      ]
    }
  ];

  return new SearchConfigManager('qcDataCollection', searchFieldGroups);
}

// 手动数据录入搜索配置
export function createQcManualDataSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'indicatorId', label: '指标ID', type: 'input', placeholder: '请输入指标ID' },
        { prop: 'departmentName', label: '科室名称', type: 'input', placeholder: '请输入科室名称' }
      ]
    },
    {
      name: 'data',
      label: '数据信息',
      fields: [
        { prop: 'numeratorValue', label: '分子值', type: 'numberrange', placeholder: '请输入分子值范围' },
        { prop: 'denominatorValue', label: '分母值', type: 'numberrange', placeholder: '请输入分母值范围' },
        { prop: 'calculatedValue', label: '计算值', type: 'numberrange', placeholder: '请输入计算值范围' },
        { prop: 'dataSource', label: '数据来源', type: 'input', placeholder: '请输入数据来源' }
      ]
    },
    {
      name: 'time',
      label: '时间范围',
      fields: [
        { prop: 'dataDate', label: '数据日期', type: 'daterange', placeholder: '请选择数据日期范围' }
      ]
    }
  ];

  return new SearchConfigManager('qcManualData', searchFieldGroups);
}

// 指标采集配置搜索配置
export function createQcIndicatorCollectionConfigSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'indicatorId', label: '指标ID', type: 'input', placeholder: '请输入指标ID' },
        { prop: 'indicatorName', label: '指标名称', type: 'input', placeholder: '请输入指标名称' },
        { prop: 'collectionType', label: '采集类型', type: 'select', placeholder: '请选择采集类型' },
        { prop: 'collectionFrequency', label: '采集频率', type: 'select', placeholder: '请选择采集频率' },
        { prop: 'isActive', label: '是否启用', type: 'select', placeholder: '请选择启用状态' }
      ]
    },
    {
      name: 'config',
      label: '配置信息',
      fields: [
        { prop: 'dataSource', label: '数据来源', type: 'input', placeholder: '请输入数据来源' },
        { prop: 'collectionMethod', label: '采集方式', type: 'select', placeholder: '请选择采集方式' },
        { prop: 'responsiblePerson', label: '责任人', type: 'input', placeholder: '请输入责任人' }
      ]
    },
    {
      name: 'department',
      label: '科室配置',
      fields: [
        { prop: 'departmentScope', label: '科室范围', type: 'input', placeholder: '请输入科室范围' }
      ]
    }
  ];

  return new SearchConfigManager('qcIndicatorCollectionConfig', searchFieldGroups);
}