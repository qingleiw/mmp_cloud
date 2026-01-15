import { FieldConfigManager, FieldGroup } from '../../fieldConfigManager';

// 质量指标字段配置
export function createQcQualityIndicatorFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'indicatorCode', label: '指标编码', visible: true, required: true, group: 'basic' },
        { prop: 'indicatorName', label: '指标名称', visible: true, required: true, group: 'basic' },
        { prop: 'indicatorLevel', label: '指标层级', visible: true, group: 'basic' },
        { prop: 'dataType', label: '数据类型', visible: true, group: 'basic' },
        { prop: 'unit', label: '单位', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'definition',
      label: '指标定义',
      fields: [
        { prop: 'definition', label: '定义', visible: true, type: 'textarea', group: 'definition' },
        { prop: 'formula', label: '计算公式', visible: true, type: 'textarea', group: 'definition' },
        { prop: 'significance', label: '意义', visible: true, type: 'textarea', group: 'definition' },
        { prop: 'remark', label: '说明', visible: true, type: 'textarea', group: 'definition' }
      ]
    },
    {
      name: 'standard',
      label: '标准信息',
      fields: [
        { prop: 'standardValue', label: '标准值', visible: true, group: 'standard' },
        { prop: 'benchmarkValue', label: '基准值', visible: true, group: 'standard' },
        { prop: 'targetValue', label: '目标值', visible: true, group: 'standard' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '删除标志', visible: true, group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, group: 'system' },
        { prop: 'createBy', label: '创建者', visible: true, group: 'system' },
        { prop: 'createDept', label: '创建部门', visible: true, group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, group: 'system' },
        { prop: 'updateBy', label: '更新者', visible: true, group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager(fieldGroups);
}

// 评分结果字段配置
export function createQcScoringResultFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'indicatorId', label: '指标ID', visible: true, required: true, group: 'basic' },
        { prop: 'collectionRecordId', label: '采集记录ID', visible: true, group: 'basic' },
        { prop: 'calculateTime', label: '计算时间', visible: true, width: '160', group: 'basic' }
      ]
    },
    {
      name: 'scoring',
      label: '评分信息',
      fields: [
        { prop: 'indicatorValue', label: '指标值', visible: true, group: 'scoring' },
        { prop: 'standardValue', label: '标准值', visible: true, group: 'scoring' },
        { prop: 'maxScore', label: '满分', visible: true, group: 'scoring' },
        { prop: 'actualScore', label: '实际得分', visible: true, group: 'scoring' },
        { prop: 'scoreRate', label: '得分率', visible: true, group: 'scoring' },
        { prop: 'evaluationLevel', label: '评价等级', visible: true, group: 'scoring' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '删除标志', visible: true, group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, group: 'system' },
        { prop: 'createBy', label: '创建者', visible: true, group: 'system' },
        { prop: 'createDept', label: '创建部门', visible: true, group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, group: 'system' },
        { prop: 'updateBy', label: '更新者', visible: true, group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager(fieldGroups);
}

// 数据采集字段配置
export function createQcDataCollectionFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'indicatorId', label: '指标ID', visible: true, required: true, group: 'basic' },
        { prop: 'departmentId', label: '科室ID', visible: true, group: 'basic' },
        { prop: 'departmentName', label: '科室名称', visible: true, group: 'basic' },
        { prop: 'collectionDate', label: '采集日期', visible: true, width: '120', group: 'basic' },
        { prop: 'collectionPeriod', label: '采集周期', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'data',
      label: '数据信息',
      fields: [
        { prop: 'numeratorValue', label: '分子值', visible: true, group: 'data' },
        { prop: 'denominatorValue', label: '分母值', visible: true, group: 'data' },
        { prop: 'indicatorValue', label: '指标值', visible: true, group: 'data' },
        { prop: 'dataSource', label: '数据来源', visible: true, group: 'data' },
        { prop: 'collectionMethod', label: '采集方式', visible: true, group: 'data' }
      ]
    },
    {
      name: 'status',
      label: '状态信息',
      fields: [
        { prop: 'status', label: '状态', visible: true, group: 'status' },
        { prop: 'reviewStatus', label: '审核状态', visible: true, group: 'status' },
        { prop: 'reviewComments', label: '审核意见', visible: true, type: 'textarea', group: 'status' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '删除标志', visible: true, group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, group: 'system' },
        { prop: 'createBy', label: '创建者', visible: true, group: 'system' },
        { prop: 'createDept', label: '创建部门', visible: true, group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, group: 'system' },
        { prop: 'updateBy', label: '更新者', visible: true, group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager(fieldGroups);
}

// 手动数据录入字段配置
export function createQcManualDataFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'indicatorId', label: '指标ID', visible: true, required: true, group: 'basic' },
        { prop: 'dataDate', label: '数据日期', visible: true, width: '120', group: 'basic' },
        { prop: 'departmentId', label: '科室ID', visible: true, group: 'basic' },
        { prop: 'departmentName', label: '科室名称', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'data',
      label: '数据信息',
      fields: [
        { prop: 'numeratorValue', label: '分子值', visible: true, required: true, group: 'data' },
        { prop: 'denominatorValue', label: '分母值', visible: true, group: 'data' },
        { prop: 'calculatedValue', label: '计算值', visible: true, group: 'data' },
        { prop: 'dataSource', label: '数据来源', visible: true, group: 'data' },
        { prop: 'remarks', label: '备注', visible: true, type: 'textarea', group: 'data' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '删除标志', visible: true, group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, group: 'system' },
        { prop: 'createBy', label: '创建者', visible: true, group: 'system' },
        { prop: 'createDept', label: '创建部门', visible: true, group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, group: 'system' },
        { prop: 'updateBy', label: '更新者', visible: true, group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager(fieldGroups);
}

// 指标采集配置字段配置
export function createQcIndicatorCollectionConfigFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'indicatorId', label: '指标ID', visible: true, required: true, group: 'basic' },
        { prop: 'indicatorName', label: '指标名称', visible: true, group: 'basic' },
        { prop: 'collectionType', label: '采集类型', visible: true, group: 'basic' },
        { prop: 'collectionFrequency', label: '采集频率', visible: true, group: 'basic' },
        { prop: 'isActive', label: '是否启用', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'config',
      label: '配置信息',
      fields: [
        { prop: 'dataSource', label: '数据来源', visible: true, group: 'config' },
        { prop: 'collectionMethod', label: '采集方式', visible: true, group: 'config' },
        { prop: 'calculationFormula', label: '计算公式', visible: true, type: 'textarea', group: 'config' },
        { prop: 'validationRules', label: '验证规则', visible: true, type: 'textarea', group: 'config' },
        { prop: 'alertThreshold', label: '告警阈值', visible: true, group: 'config' }
      ]
    },
    {
      name: 'department',
      label: '科室配置',
      fields: [
        { prop: 'departmentScope', label: '科室范围', visible: true, group: 'department' },
        { prop: 'responsiblePerson', label: '责任人', visible: true, group: 'department' },
        { prop: 'contactInfo', label: '联系方式', visible: true, group: 'department' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '删除标志', visible: true, group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, group: 'system' },
        { prop: 'createBy', label: '创建者', visible: true, group: 'system' },
        { prop: 'createDept', label: '创建部门', visible: true, group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, group: 'system' },
        { prop: 'updateBy', label: '更新者', visible: true, group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('qcIndicatorCollectionConfig', fieldGroups);
}