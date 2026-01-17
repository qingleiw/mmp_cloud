import { SearchConfigManager, SearchFieldGroup } from '../searchConfigManager';

// qcDataCollection搜索配置
export function createQcDataCollectionSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'indicatorId', label: '指标ID', type: 'number', visible: true, placeholder: '请输入指标ID' },
        { prop: 'departmentId', label: '科室ID', type: 'number', visible: true, placeholder: '请输入科室ID' },
        { prop: 'departmentName', label: '科室名称', type: 'input', visible: true, placeholder: '请输入科室名称' },
        { prop: 'denominatorValue', label: '分母值', type: 'number', visible: false, placeholder: '请输入分母值' },
        { prop: 'dataStatus', label: '数据状态：0-草稿，1-已提交，2-已审核', type: 'number', visible: false, placeholder: '请输入数据状态：0-草稿，1-已提交，2-已审核' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'collectionPeriod', label: '统计周期：monthly-月度，quarterly-季度，yearly-年度', type: 'input', visible: false, placeholder: '请输入统计周期：monthly-月度，quarterly-季度，yearly-年度' },
        { prop: 'collectionYear', label: '统计年份', type: 'number', visible: false, placeholder: '请输入统计年份' },
        { prop: 'collectionMonth', label: '统计月份', type: 'number', visible: false, placeholder: '请输入统计月份' },
        { prop: 'collectionQuarter', label: '统计季度', type: 'number', visible: false, placeholder: '请输入统计季度' },
        { prop: 'numeratorValue', label: '分子值', type: 'number', visible: false, placeholder: '请输入分子值' },
        { prop: 'indicatorValue', label: '指标值（计算结果）', type: 'number', visible: false, placeholder: '请输入指标值（计算结果）' },
        { prop: 'collector', label: '采集人', type: 'input', visible: false, placeholder: '请输入采集人' },
        { prop: 'reviewer', label: '审核人', type: 'input', visible: false, placeholder: '请输入审核人' },
        { prop: 'collectionTime', label: '采集时间', type: 'daterange', visible: false, placeholder: '请输入采集时间', startProp: 'collectionTimeStart', endProp: 'collectionTimeEnd' },
        { prop: 'reviewTime', label: '审核时间', type: 'daterange', visible: false, placeholder: '请输入审核时间', startProp: 'reviewTimeStart', endProp: 'reviewTimeEnd' }
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

  return new SearchConfigManager('qcDataCollection', searchFieldGroups);
}


// qcIndicatorCollectionConfig搜索配置
export function createQcIndicatorCollectionConfigSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'indicatorId', label: '指标ID', type: 'number', visible: true, placeholder: '请输入指标ID' },
        { prop: 'dataType', label: '数据类型', type: 'input', visible: true, placeholder: '请输入数据类型' },
        { prop: 'validationRule', label: '校验规则', type: 'input', visible: true, placeholder: '请输入校验规则' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'sourceSystem', label: '来源系统 HIS/EMR/LIS/PACS等', type: 'input', visible: false, placeholder: '请输入来源系统 HIS/EMR/LIS/PACS等' },
        { prop: 'sourceTable', label: '来源表', type: 'input', visible: false, placeholder: '请输入来源表' },
        { prop: 'sourceField', label: '来源字段', type: 'input', visible: false, placeholder: '请输入来源字段' },
        { prop: 'extractionRule', label: '提取规则', type: 'input', visible: false, placeholder: '请输入提取规则' },
        { prop: 'isRequired', label: '是否必需 1-是 0-否', type: 'number', visible: false, placeholder: '请输入是否必需 1-是 0-否' },
        { prop: 'defaultValue', label: '默认值', type: 'input', visible: false, placeholder: '请输入默认值' }
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

  return new SearchConfigManager('qcIndicatorCollectionConfig', searchFieldGroups);
}


// qcIndicatorFactor搜索配置
export function createQcIndicatorFactorSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'indicatorId', label: '指标ID', type: 'number', visible: true, placeholder: '请输入指标ID' },
        { prop: 'factorType', label: '因子类型：numerator-分子，denominator-分母', type: 'input', visible: true, placeholder: '请输入因子类型：numerator-分子，denominator-分母' },
        { prop: 'factorName', label: '因子名称', type: 'input', visible: true, placeholder: '请输入因子名称' },
        { prop: 'factorCode', label: '因子代码', type: 'input', visible: false, placeholder: '请输入因子代码' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'description', label: '因子描述', type: 'input', visible: false, placeholder: '请输入因子描述' },
        { prop: 'dataSource', label: '数据来源', type: 'input', visible: false, placeholder: '请输入数据来源' },
        { prop: 'sortOrder', label: '排序', type: 'number', visible: false, placeholder: '请输入排序' }
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

  return new SearchConfigManager('qcIndicatorFactor', searchFieldGroups);
}


// qcManualData搜索配置
export function createQcManualDataSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'indicatorId', label: '指标ID', type: 'number', visible: true, placeholder: '请输入指标ID' },
        { prop: 'patientId', label: '患者ID', type: 'number', visible: true, placeholder: '请输入患者ID' },
        { prop: 'visitNo', label: '就诊号', type: 'input', visible: true, placeholder: '请输入就诊号' },
        { prop: 'dataType', label: '数据类型', type: 'input', visible: false, placeholder: '请输入数据类型' },
        { prop: 'operationType', label: '操作类型 新增/修正', type: 'input', visible: false, placeholder: '请输入操作类型 新增/修正' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'dataField', label: '数据字段', type: 'input', visible: false, placeholder: '请输入数据字段' },
        { prop: 'dataValue', label: '数据值', type: 'input', visible: false, placeholder: '请输入数据值' },
        { prop: 'dataDate', label: '数据日期', type: 'daterange', visible: false, placeholder: '请输入数据日期', startProp: 'dataDateStart', endProp: 'dataDateEnd' },
        { prop: 'originalValue', label: '原始值', type: 'input', visible: false, placeholder: '请输入原始值' },
        { prop: 'modifyReason', label: '修改原因', type: 'input', visible: false, placeholder: '请输入修改原因' }
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

  return new SearchConfigManager('qcManualData', searchFieldGroups);
}


// qcQualityIndicator搜索配置
export function createQcQualityIndicatorSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'indicatorCode', label: '指标编码', type: 'input', visible: true, placeholder: '请输入指标编码' },
        { prop: 'indicatorName', label: '指标名称', type: 'input', visible: true, placeholder: '请输入指标名称' },
        { prop: 'categoryId', label: '所属专业ID', type: 'number', visible: true, placeholder: '请输入所属专业ID' },
        { prop: 'parentId', label: '父指标ID（用于分级指标）', type: 'number', visible: false, placeholder: '请输入父指标ID（用于分级指标）' },
        { prop: 'indicatorLevel', label: '指标层级', type: 'number', visible: false, placeholder: '请输入指标层级' },
        { prop: 'dataType', label: '数据类型：rate-比率，count-计数，ratio-比值', type: 'input', visible: false, placeholder: '请输入数据类型：rate-比率，count-计数，ratio-比值' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'definition', label: '定义', type: 'input', visible: false, placeholder: '请输入定义' },
        { prop: 'formula', label: '计算公式', type: 'input', visible: false, placeholder: '请输入计算公式' },
        { prop: 'significance', label: '意义', type: 'input', visible: false, placeholder: '请输入意义' },
        { prop: 'unit', label: '单位', type: 'input', visible: false, placeholder: '请输入单位' },
        { prop: 'standardValue', label: '标准值', type: 'number', visible: false, placeholder: '请输入标准值' },
        { prop: 'maxScore', label: '满分分值', type: 'number', visible: false, placeholder: '请输入满分分值' },
        { prop: 'sortOrder', label: '排序', type: 'number', visible: false, placeholder: '请输入排序' },
        { prop: 'status', label: '状态：1-启用，0-禁用', type: 'number', visible: false, placeholder: '请输入状态：1-启用，0-禁用' }
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

  return new SearchConfigManager('qcQualityIndicator', searchFieldGroups);
}


// qcScoringResult搜索配置
export function createQcScoringResultSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'collectionId', label: '采集记录ID', type: 'number', visible: true, placeholder: '请输入采集记录ID' },
        { prop: 'indicatorId', label: '指标ID', type: 'number', visible: true, placeholder: '请输入指标ID' },
        { prop: 'evaluationLevel', label: '评价等级：excellent-优秀，good-良好，qualified-合格，unqualified-不合格', type: 'input', visible: true, placeholder: '请输入评价等级：excellent-优秀，good-良好，qualified-合格，unqualified-不合格' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'indicatorValue', label: '指标值', type: 'number', visible: false, placeholder: '请输入指标值' },
        { prop: 'standardValue', label: '标准值', type: 'number', visible: false, placeholder: '请输入标准值' },
        { prop: 'maxScore', label: '满分', type: 'number', visible: false, placeholder: '请输入满分' },
        { prop: 'actualScore', label: '实际得分', type: 'number', visible: false, placeholder: '请输入实际得分' },
        { prop: 'scoreRate', label: '得分率', type: 'number', visible: false, placeholder: '请输入得分率' },
        { prop: 'calculateTime', label: '计算时间', type: 'daterange', visible: false, placeholder: '请输入计算时间', startProp: 'calculateTimeStart', endProp: 'calculateTimeEnd' }
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

  return new SearchConfigManager('qcScoringResult', searchFieldGroups);
}


// qcScoringRule搜索配置
export function createQcScoringRuleSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'indicatorId', label: '指标ID', type: 'number', visible: true, placeholder: '请输入指标ID' },
        { prop: 'ruleType', label: '规则类型：range-区间，threshold-阈值', type: 'input', visible: true, placeholder: '请输入规则类型：range-区间，threshold-阈值' },
        { prop: 'status', label: '状态', type: 'number', visible: true, placeholder: '请输入状态' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'minValue', label: '最小值', type: 'number', visible: false, placeholder: '请输入最小值' },
        { prop: 'maxValue', label: '最大值', type: 'number', visible: false, placeholder: '请输入最大值' },
        { prop: 'score', label: '得分', type: 'number', visible: false, placeholder: '请输入得分' },
        { prop: 'scoreRate', label: '得分率', type: 'number', visible: false, placeholder: '请输入得分率' },
        { prop: 'description', label: '规则描述', type: 'input', visible: false, placeholder: '请输入规则描述' },
        { prop: 'sortOrder', label: '排序', type: 'number', visible: false, placeholder: '请输入排序' }
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

  return new SearchConfigManager('qcScoringRule', searchFieldGroups);
}


// qcSpecialtyCategory搜索配置
export function createQcSpecialtyCategorySearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'categoryCode', label: '专业代码', type: 'input', visible: true, placeholder: '请输入专业代码' },
        { prop: 'categoryName', label: '专业名称', type: 'input', visible: true, placeholder: '请输入专业名称' },
        { prop: 'status', label: '状态：1-启用，0-禁用', type: 'number', visible: true, placeholder: '请输入状态：1-启用，0-禁用' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'version', label: '版本号', type: 'input', visible: false, placeholder: '请输入版本号' },
        { prop: 'publishYear', label: '发布年份', type: 'number', visible: false, placeholder: '请输入发布年份' },
        { prop: 'sortOrder', label: '排序', type: 'number', visible: false, placeholder: '请输入排序' }
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

  return new SearchConfigManager('qcSpecialtyCategory', searchFieldGroups);
}
