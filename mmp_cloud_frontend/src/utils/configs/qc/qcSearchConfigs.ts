import { SearchConfigManager, SearchFieldGroup } from '../searchConfigManager';

// 质量指标搜索配置
export function createQcQualityIndicatorSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'indicatorCode', label: '指标编码', type: 'input', visible: true, placeholder: '请输入指标编码', group: 'basic' },
        { prop: 'indicatorName', label: '指标名称', type: 'input', visible: true, placeholder: '请输入指标名称', group: 'basic' },
        { prop: 'indicatorLevel', label: '指标层级', type: 'select', visible: true, placeholder: '请选择指标层级', options: [
          { label: '全部', value: '' },
          { label: '1级', value: 1 },
          { label: '2级', value: 2 },
          { label: '3级', value: 3 }
        ], group: 'basic' },
        { prop: 'dataType', label: '数据类型', type: 'select', visible: true, placeholder: '请选择数据类型', options: [
          { label: '全部', value: '' },
          { label: '比率', value: 'rate' },
          { label: '计数', value: 'count' },
          { label: '比值', value: 'ratio' }
        ], group: 'basic' },
        { prop: 'unit', label: '单位', type: 'input', visible: false, placeholder: '请输入单位', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'definition', label: '定义', type: 'input', visible: false, placeholder: '请输入定义关键词', group: 'detail' },
        { prop: 'significance', label: '意义', type: 'input', visible: false, placeholder: '请输入意义关键词', group: 'detail' }
      ]
    },
    {
      name: 'standard',
      label: '标准信息',
      fields: [
        { prop: 'standardValueRange', label: '标准值范围', type: 'numberrange', visible: false, startProp: 'minStandardValue', endProp: 'maxStandardValue', group: 'standard' },
        { prop: 'maxScoreRange', label: '满分分值范围', type: 'numberrange', visible: false, startProp: 'minMaxScore', endProp: 'maxMaxScore', group: 'standard' }
      ]
    },
    {
      name: 'status',
      label: '状态信息',
      fields: [
        { prop: 'status', label: '状态', type: 'select', visible: true, placeholder: '请选择状态', options: [
          { label: '全部', value: '' },
          { label: '禁用', value: 0 },
          { label: '启用', value: 1 }
        ], group: 'status' }
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
        { prop: 'indicatorId', label: '指标ID', type: 'input', visible: false, placeholder: '请输入指标ID' },
        { prop: 'indicatorValue', label: '指标值', type: 'numberrange', visible: false, placeholder: '请输入指标值范围' },
        { prop: 'standardValue', label: '标准值', type: 'numberrange', visible: false, placeholder: '请输入标准值范围' }
      ]
    },
    {
      name: 'scoring',
      label: '评分信息',
      fields: [
        { prop: 'indicatorId', label: '指标ID', type: 'input', visible: false, placeholder: '请输入指标ID' },
        { prop: 'actualScore', label: '实际得分', type: 'numberrange', visible: false, placeholder: '请输入实际得分范围' },
        { prop: 'scoreRate', label: '得分率', type: 'numberrange', visible: false, placeholder: '请输入得分率范围' },
        { prop: 'evaluationLevel', label: '评价等级', type: 'select', visible: false, placeholder: '请选择评价等级' }
      ]
    },
    {
      name: 'time',
      label: '时间范围',
      fields: [
        { prop: 'calculateTime', label: '计算时间', type: 'daterange', visible: false, placeholder: '请选择计算时间范围' }
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
        { prop: 'departmentName', label: '科室名称', type: 'input', visible: true, placeholder: '请输入科室名称', group: 'basic' },
        { prop: 'collector', label: '采集人', type: 'input', visible: false, placeholder: '请输入采集人', group: 'basic' },
        { prop: 'collectionPeriod', label: '统计周期', type: 'select', visible: true, placeholder: '请选择统计周期', options: [
          { label: '全部', value: '' },
          { label: '月度', value: 'monthly' },
          { label: '季度', value: 'quarterly' },
          { label: '年度', value: 'yearly' }
        ], group: 'basic' }
      ]
    },
    {
      name: 'time',
      label: '时间信息',
      fields: [
        { prop: 'collectionYear', label: '统计年份', type: 'number', visible: false, placeholder: '请输入统计年份', group: 'time' },
        { prop: 'collectionMonth', label: '统计月份', type: 'number', visible: false, placeholder: '请输入统计月份', group: 'time' },
        { prop: 'collectionQuarter', label: '统计季度', type: 'number', visible: false, placeholder: '请输入统计季度', group: 'time' },
        { prop: 'collectionTimeRange', label: '采集时间范围', type: 'daterange', visible: false, startProp: 'startCollectionTime', endProp: 'endCollectionTime', group: 'time' },
        { prop: 'reviewTimeRange', label: '审核时间范围', type: 'daterange', visible: false, startProp: 'startReviewTime', endProp: 'endReviewTime', group: 'time' }
      ]
    },
    {
      name: 'data',
      label: '数据信息',
      fields: [
        { prop: 'numeratorValueRange', label: '分子值范围', type: 'numberrange', visible: false, startProp: 'minNumeratorValue', endProp: 'maxNumeratorValue', group: 'data' },
        { prop: 'denominatorValueRange', label: '分母值范围', type: 'numberrange', visible: false, startProp: 'minDenominatorValue', endProp: 'maxDenominatorValue', group: 'data' },
        { prop: 'indicatorValueRange', label: '指标值范围', type: 'numberrange', visible: false, startProp: 'minIndicatorValue', endProp: 'maxIndicatorValue', group: 'data' }
      ]
    },
    {
      name: 'status',
      label: '状态信息',
      fields: [
        { prop: 'dataStatus', label: '数据状态', type: 'select', visible: true, placeholder: '请选择数据状态', options: [
          { label: '全部', value: '' },
          { label: '草稿', value: 0 },
          { label: '已提交', value: 1 },
          { label: '已审核', value: 2 }
        ], group: 'status' },
        { prop: 'reviewer', label: '审核人', type: 'input', visible: false, placeholder: '请输入审核人', group: 'status' }
      ]
    }
  ];

  return searchFieldGroups;
}

// 手动数据录入搜索配置
export function createQcManualDataSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'indicatorId', label: '指标ID', type: 'input', visible: false, placeholder: '请输入指标ID' },
        { prop: 'departmentName', label: '科室名称', type: 'input', visible: true, placeholder: '请输入科室名称' }
      ]
    },
    {
      name: 'data',
      label: '数据信息',
      fields: [
        { prop: 'numeratorValue', label: '分子值', type: 'numberrange', visible: false, placeholder: '请输入分子值范围' },
        { prop: 'denominatorValue', label: '分母值', type: 'numberrange', visible: false, placeholder: '请输入分母值范围' },
        { prop: 'calculatedValue', label: '计算值', type: 'numberrange', visible: false, placeholder: '请输入计算值范围' },
        { prop: 'dataSource', label: '数据来源', type: 'input', visible: false, placeholder: '请输入数据来源' }
      ]
    },
    {
      name: 'time',
      label: '时间范围',
      fields: [
        { prop: 'dataDate', label: '数据日期', type: 'daterange', visible: false, placeholder: '请选择数据日期范围' }
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
        { prop: 'indicatorId', label: '指标ID', type: 'input', visible: false, placeholder: '请输入指标ID' },
        { prop: 'indicatorName', label: '指标名称', type: 'input', visible: false, placeholder: '请输入指标名称' },
        { prop: 'collectionType', label: '采集类型', type: 'select', visible: false, placeholder: '请选择采集类型' },
        { prop: 'collectionFrequency', label: '采集频率', type: 'select', visible: false, placeholder: '请选择采集频率' },
        { prop: 'isActive', label: '是否启用', type: 'select', visible: false, placeholder: '请选择启用状态' }
      ]
    },
    {
      name: 'config',
      label: '配置信息',
      fields: [
        { prop: 'dataSource', label: '数据来源', type: 'input', visible: false, placeholder: '请输入数据来源' },
        { prop: 'collectionMethod', label: '采集方式', type: 'select', visible: false, placeholder: '请选择采集方式' },
        { prop: 'responsiblePerson', label: '责任人', type: 'input', visible: false, placeholder: '请输入责任人' }
      ]
    },
    {
      name: 'department',
      label: '科室配置',
      fields: [
        { prop: 'departmentScope', label: '科室范围', type: 'input', visible: false, placeholder: '请输入科室范围' }
      ]
    }
  ];

  return new SearchConfigManager('qcIndicatorCollectionConfig', searchFieldGroups);
}