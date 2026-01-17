import { FieldConfigManager, FieldGroup } from '../fieldConfigManager';

// qcDataCollection字段配置
export function createQcDataCollectionFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'indicatorId', label: '指标ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'departmentId', label: '科室ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'departmentName', label: '科室名称', visible: true, type: 'input', group: 'basic' },
        { prop: 'denominatorValue', label: '分母值', visible: true, type: 'number', group: 'basic' },
        { prop: 'dataStatus', label: '数据状态：0-草稿，1-已提交，2-已审核', visible: true, type: 'number', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'collectionPeriod', label: '统计周期：monthly-月度，quarterly-季度，yearly-年度', visible: true, type: 'input', group: 'detail' },
        { prop: 'collectionYear', label: '统计年份', visible: true, type: 'number', group: 'detail' },
        { prop: 'collectionMonth', label: '统计月份', visible: true, type: 'number', group: 'detail' },
        { prop: 'collectionQuarter', label: '统计季度', visible: true, type: 'number', group: 'detail' },
        { prop: 'numeratorValue', label: '分子值', visible: true, type: 'number', group: 'detail' },
        { prop: 'indicatorValue', label: '指标值（计算结果）', visible: true, type: 'number', group: 'detail' },
        { prop: 'collector', label: '采集人', visible: true, type: 'input', group: 'detail' },
        { prop: 'reviewer', label: '审核人', visible: true, type: 'input', group: 'detail' },
        { prop: 'collectionTime', label: '采集时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'reviewTime', label: '审核时间', visible: true, type: 'datetime', group: 'detail' }
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

  return new FieldConfigManager('qcDataCollection', fieldGroups);
}


// qcIndicatorCollectionConfig字段配置
export function createQcIndicatorCollectionConfigFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'indicatorId', label: '指标ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'dataType', label: '数据类型', visible: true, type: 'input', group: 'basic' },
        { prop: 'validationRule', label: '校验规则', visible: true, type: 'textarea', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'sourceSystem', label: '来源系统 HIS/EMR/LIS/PACS等', visible: true, type: 'input', group: 'detail' },
        { prop: 'sourceTable', label: '来源表', visible: true, type: 'input', group: 'detail' },
        { prop: 'sourceField', label: '来源字段', visible: true, type: 'input', group: 'detail' },
        { prop: 'extractionRule', label: '提取规则', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'isRequired', label: '是否必需 1-是 0-否', visible: true, type: 'number', group: 'detail' },
        { prop: 'defaultValue', label: '默认值', visible: true, type: 'input', group: 'detail' }
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

  return new FieldConfigManager('qcIndicatorCollectionConfig', fieldGroups);
}


// qcIndicatorFactor字段配置
export function createQcIndicatorFactorFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'indicatorId', label: '指标ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'factorType', label: '因子类型：numerator-分子，denominator-分母', visible: true, type: 'input', group: 'basic' },
        { prop: 'factorName', label: '因子名称', visible: true, type: 'input', group: 'basic' },
        { prop: 'factorCode', label: '因子代码', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'description', label: '因子描述', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'dataSource', label: '数据来源', visible: true, type: 'input', group: 'detail' },
        { prop: 'sortOrder', label: '排序', visible: true, type: 'number', group: 'detail' }
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

  return new FieldConfigManager('qcIndicatorFactor', fieldGroups);
}


// qcManualData字段配置
export function createQcManualDataFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'indicatorId', label: '指标ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'patientId', label: '患者ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'visitNo', label: '就诊号', visible: true, type: 'input', group: 'basic' },
        { prop: 'dataType', label: '数据类型', visible: true, type: 'input', group: 'basic' },
        { prop: 'operationType', label: '操作类型 新增/修正', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'dataField', label: '数据字段', visible: true, type: 'input', group: 'detail' },
        { prop: 'dataValue', label: '数据值', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'dataDate', label: '数据日期', visible: true, type: 'date', group: 'detail' },
        { prop: 'originalValue', label: '原始值', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'modifyReason', label: '修改原因', visible: true, type: 'textarea', group: 'detail' }
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

  return new FieldConfigManager('qcManualData', fieldGroups);
}


// qcQualityIndicator字段配置
export function createQcQualityIndicatorFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'indicatorCode', label: '指标编码', visible: true, type: 'input', group: 'basic' },
        { prop: 'indicatorName', label: '指标名称', visible: true, type: 'input', group: 'basic' },
        { prop: 'categoryId', label: '所属专业ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'parentId', label: '父指标ID（用于分级指标）', visible: true, type: 'number', group: 'basic' },
        { prop: 'indicatorLevel', label: '指标层级', visible: true, type: 'number', group: 'basic' },
        { prop: 'dataType', label: '数据类型：rate-比率，count-计数，ratio-比值', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'definition', label: '定义', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'formula', label: '计算公式', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'significance', label: '意义', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'unit', label: '单位', visible: true, type: 'input', group: 'detail' },
        { prop: 'standardValue', label: '标准值', visible: true, type: 'number', group: 'detail' },
        { prop: 'maxScore', label: '满分分值', visible: true, type: 'number', group: 'detail' },
        { prop: 'sortOrder', label: '排序', visible: true, type: 'number', group: 'detail' },
        { prop: 'status', label: '状态：1-启用，0-禁用', visible: true, type: 'number', group: 'detail' }
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

  return new FieldConfigManager('qcQualityIndicator', fieldGroups);
}


// qcScoringResult字段配置
export function createQcScoringResultFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'collectionId', label: '采集记录ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'indicatorId', label: '指标ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'evaluationLevel', label: '评价等级：excellent-优秀，good-良好，qualified-合格，unqualified-不合格', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'indicatorValue', label: '指标值', visible: true, type: 'number', group: 'detail' },
        { prop: 'standardValue', label: '标准值', visible: true, type: 'number', group: 'detail' },
        { prop: 'maxScore', label: '满分', visible: true, type: 'number', group: 'detail' },
        { prop: 'actualScore', label: '实际得分', visible: true, type: 'number', group: 'detail' },
        { prop: 'scoreRate', label: '得分率', visible: true, type: 'number', group: 'detail' },
        { prop: 'calculateTime', label: '计算时间', visible: true, type: 'datetime', group: 'detail' }
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

  return new FieldConfigManager('qcScoringResult', fieldGroups);
}


// qcScoringRule字段配置
export function createQcScoringRuleFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'indicatorId', label: '指标ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'ruleType', label: '规则类型：range-区间，threshold-阈值', visible: true, type: 'input', group: 'basic' },
        { prop: 'status', label: '状态', visible: true, type: 'number', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'minValue', label: '最小值', visible: true, type: 'number', group: 'detail' },
        { prop: 'maxValue', label: '最大值', visible: true, type: 'number', group: 'detail' },
        { prop: 'score', label: '得分', visible: true, type: 'number', group: 'detail' },
        { prop: 'scoreRate', label: '得分率', visible: true, type: 'number', group: 'detail' },
        { prop: 'description', label: '规则描述', visible: true, type: 'input', group: 'detail' },
        { prop: 'sortOrder', label: '排序', visible: true, type: 'number', group: 'detail' }
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

  return new FieldConfigManager('qcScoringRule', fieldGroups);
}


// qcSpecialtyCategory字段配置
export function createQcSpecialtyCategoryFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'categoryCode', label: '专业代码', visible: true, type: 'input', group: 'basic' },
        { prop: 'categoryName', label: '专业名称', visible: true, type: 'input', group: 'basic' },
        { prop: 'status', label: '状态：1-启用，0-禁用', visible: true, type: 'number', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'version', label: '版本号', visible: true, type: 'input', group: 'detail' },
        { prop: 'publishYear', label: '发布年份', visible: true, type: 'number', group: 'detail' },
        { prop: 'sortOrder', label: '排序', visible: true, type: 'number', group: 'detail' }
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

  return new FieldConfigManager('qcSpecialtyCategory', fieldGroups);
}
