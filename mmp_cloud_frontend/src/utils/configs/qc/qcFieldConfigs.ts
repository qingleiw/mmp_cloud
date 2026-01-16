import { FieldConfigManager, FieldGroup } from '../fieldConfigManager';

// 质量指标字段配置
export function createQcQualityIndicatorFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'input', width: 80, visible: true, formVisible: false, searchable: false, group: 'basic' },
        { prop: 'indicatorCode', label: '指标编码', type: 'input', width: 120, visible: true, formVisible: true, searchable: true, group: 'basic' },
        { prop: 'indicatorName', label: '指标名称', type: 'input', width: 150, visible: true, formVisible: true, searchable: true, group: 'basic' },
        { prop: 'categoryId', label: '所属专业ID', type: 'input', width: 100, visible: false, formVisible: true, searchable: true, group: 'basic' },
        { prop: 'parentId', label: '父指标ID', type: 'input', width: 100, visible: false, formVisible: true, searchable: true, group: 'basic' },
        { prop: 'indicatorLevel', label: '指标层级', type: 'number', width: 100, visible: true, formVisible: true, searchable: true, group: 'basic' },
        { prop: 'dataType', label: '数据类型', type: 'select', width: 120, visible: true, formVisible: true, searchable: true, options: [
          { label: '比率', value: 'rate' },
          { label: '计数', value: 'count' },
          { label: '比值', value: 'ratio' }
        ], group: 'basic' },
        { prop: 'unit', label: '单位', type: 'input', width: 80, visible: true, formVisible: true, searchable: true, group: 'basic' },
        { prop: 'sortOrder', label: '排序', type: 'number', width: 80, visible: true, formVisible: true, searchable: true, group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'definition', label: '定义', type: 'textarea', minWidth: 200, visible: true, formVisible: true, searchable: true, rows: 3, group: 'detail' },
        { prop: 'formula', label: '计算公式', type: 'textarea', minWidth: 200, visible: true, formVisible: true, searchable: true, rows: 3, group: 'detail' },
        { prop: 'significance', label: '意义', type: 'textarea', minWidth: 200, visible: true, formVisible: true, searchable: true, rows: 3, group: 'detail' },
        { prop: 'remark', label: '说明', type: 'textarea', minWidth: 200, visible: true, formVisible: true, searchable: true, rows: 3, group: 'detail' }
      ]
    },
    {
      name: 'standard',
      label: '标准信息',
      fields: [
        { prop: 'standardValue', label: '标准值', type: 'number', width: 100, visible: true, formVisible: true, searchable: true, group: 'standard' },
        { prop: 'maxScore', label: '满分分值', type: 'number', width: 100, visible: true, formVisible: true, searchable: true, group: 'standard' }
      ]
    },
    {
      name: 'status',
      label: '状态信息',
      fields: [
        { prop: 'status', label: '状态', type: 'select', width: 100, visible: true, formVisible: true, searchable: true, options: [
          { label: '禁用', value: 0 },
          { label: '启用', value: 1 }
        ], group: 'status' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '删除标志', type: 'select', width: 100, visible: false, formVisible: true, searchable: false, options: [
          { label: '未删除', value: '0' },
          { label: '已删除', value: '1' }
        ], group: 'system' },
        { prop: 'createTime', label: '创建时间', type: 'datetime', width: 160, visible: false, formVisible: false, searchable: false, group: 'system' },
        { prop: 'createBy', label: '创建者', type: 'input', width: 100, visible: false, formVisible: false, searchable: false, group: 'system' },
        { prop: 'createDept', label: '创建部门', type: 'input', width: 100, visible: false, formVisible: false, searchable: false, group: 'system' },
        { prop: 'updateTime', label: '更新时间', type: 'datetime', width: 160, visible: false, formVisible: false, searchable: false, group: 'system' },
        { prop: 'updateBy', label: '更新者', type: 'input', width: 100, visible: false, formVisible: false, searchable: false, group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('qcQualityIndicator', fieldGroups);
}

// 评分结果字段配置
export function createQcScoringResultFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'input', width: 80, visible: true, formVisible: false, searchable: false, group: 'basic' },
        { prop: 'indicatorId', label: '指标ID', type: 'input', width: 100, visible: false, formVisible: true, searchable: true, group: 'basic' },
        { prop: 'collectionId', label: '采集记录ID', type: 'input', width: 120, visible: false, formVisible: true, searchable: true, group: 'basic' },
        { prop: 'calculateTime', label: '计算时间', type: 'datetime', width: 160, visible: true, formVisible: true, searchable: true, group: 'basic' }
      ]
    },
    {
      name: 'scoring',
      label: '评分信息',
      fields: [
        { prop: 'indicatorValue', label: '指标值', type: 'number', width: 100, visible: true, formVisible: true, searchable: true, group: 'scoring' },
        { prop: 'standardValue', label: '标准值', type: 'number', width: 100, visible: true, formVisible: true, searchable: true, group: 'scoring' },
        { prop: 'maxScore', label: '满分', type: 'number', width: 80, visible: true, formVisible: true, searchable: true, group: 'scoring' },
        { prop: 'actualScore', label: '实际得分', type: 'number', width: 100, visible: true, formVisible: true, searchable: true, group: 'scoring' },
        { prop: 'scoreRate', label: '得分率', type: 'number', width: 80, visible: true, formVisible: true, searchable: true, group: 'scoring' },
        { prop: 'evaluationLevel', label: '评价等级', type: 'select', width: 120, visible: true, formVisible: true, searchable: true, options: [
          { label: '优秀', value: 'excellent' },
          { label: '良好', value: 'good' },
          { label: '合格', value: 'qualified' },
          { label: '不合格', value: 'unqualified' }
        ], group: 'scoring' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'remark', label: '备注', type: 'textarea', minWidth: 200, visible: true, formVisible: true, searchable: true, rows: 3, group: 'detail' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '删除标志', type: 'select', width: 100, visible: false, formVisible: true, searchable: false, options: [
          { label: '未删除', value: '0' },
          { label: '已删除', value: '1' }
        ], group: 'system' },
        { prop: 'createTime', label: '创建时间', type: 'datetime', width: 160, visible: false, formVisible: false, searchable: false, group: 'system' },
        { prop: 'createBy', label: '创建者', type: 'input', width: 100, visible: false, formVisible: false, searchable: false, group: 'system' },
        { prop: 'createDept', label: '创建部门', type: 'input', width: 100, visible: false, formVisible: false, searchable: false, group: 'system' },
        { prop: 'updateTime', label: '更新时间', type: 'datetime', width: 160, visible: false, formVisible: false, searchable: false, group: 'system' },
        { prop: 'updateBy', label: '更新者', type: 'input', width: 100, visible: false, formVisible: false, searchable: false, group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager(pageKey, fieldGroups);
}

// 数据采集字段配置
export function createQcDataCollectionFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'input', width: 80, visible: true, formVisible: false, searchable: false, group: 'basic' },
        { prop: 'indicatorId', label: '指标ID', type: 'input', width: 100, visible: false, formVisible: true, searchable: true, group: 'basic' },
        { prop: 'departmentId', label: '科室ID', type: 'input', width: 100, visible: false, formVisible: true, searchable: true, group: 'basic' },
        { prop: 'departmentName', label: '科室名称', type: 'input', width: 120, visible: true, formVisible: true, searchable: true, group: 'basic' },
        { prop: 'collector', label: '采集人', type: 'input', width: 100, visible: true, formVisible: true, searchable: true, group: 'basic' },
        { prop: 'collectionPeriod', label: '统计周期', type: 'select', width: 120, visible: true, formVisible: true, searchable: true, options: [
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
        { prop: 'collectionYear', label: '统计年份', type: 'number', width: 100, visible: true, formVisible: true, searchable: true, group: 'time' },
        { prop: 'collectionMonth', label: '统计月份', type: 'number', width: 100, visible: true, formVisible: true, searchable: true, group: 'time' },
        { prop: 'collectionQuarter', label: '统计季度', type: 'number', width: 100, visible: true, formVisible: true, searchable: true, group: 'time' },
        { prop: 'collectionTime', label: '采集时间', type: 'datetime', width: 160, visible: true, formVisible: true, searchable: true, group: 'time' },
        { prop: 'reviewTime', label: '审核时间', type: 'datetime', width: 160, visible: true, formVisible: false, searchable: true, group: 'time' }
      ]
    },
    {
      name: 'data',
      label: '数据信息',
      fields: [
        { prop: 'numeratorValue', label: '分子值', type: 'number', width: 100, visible: true, formVisible: true, searchable: true, group: 'data' },
        { prop: 'denominatorValue', label: '分母值', type: 'number', width: 100, visible: true, formVisible: true, searchable: true, group: 'data' },
        { prop: 'indicatorValue', label: '指标值', type: 'number', width: 100, visible: true, formVisible: true, searchable: true, group: 'data' }
      ]
    },
    {
      name: 'status',
      label: '状态信息',
      fields: [
        { prop: 'dataStatus', label: '数据状态', type: 'select', width: 100, visible: true, formVisible: true, searchable: true, options: [
          { label: '草稿', value: 0 },
          { label: '已提交', value: 1 },
          { label: '已审核', value: 2 }
        ], group: 'status' },
        { prop: 'reviewer', label: '审核人', type: 'input', width: 100, visible: true, formVisible: true, searchable: true, group: 'status' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'remark', label: '备注', type: 'textarea', minWidth: 200, visible: true, formVisible: true, searchable: true, rows: 3, group: 'detail' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '删除标志', type: 'select', width: 100, visible: false, formVisible: true, searchable: false, options: [
          { label: '未删除', value: '0' },
          { label: '已删除', value: '1' }
        ], group: 'system' },
        { prop: 'createTime', label: '创建时间', type: 'datetime', width: 160, visible: false, formVisible: false, searchable: false, group: 'system' },
        { prop: 'createBy', label: '创建者', type: 'input', width: 100, visible: false, formVisible: false, searchable: false, group: 'system' },
        { prop: 'createDept', label: '创建部门', type: 'input', width: 100, visible: false, formVisible: false, searchable: false, group: 'system' },
        { prop: 'updateTime', label: '更新时间', type: 'datetime', width: 160, visible: false, formVisible: false, searchable: false, group: 'system' },
        { prop: 'updateBy', label: '更新者', type: 'input', width: 100, visible: false, formVisible: false, searchable: false, group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager(pageKey, fieldGroups);
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

  return new FieldConfigManager('qcManualData', fieldGroups);
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