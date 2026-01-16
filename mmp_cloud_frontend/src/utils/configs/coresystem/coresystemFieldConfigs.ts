import { FieldConfigManager, FieldGroup } from '../fieldConfigManager';

// 系统指标监控记录字段配置
export function createSystemIndicatorMonitorRecordFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'tenantId', label: '租户ID', visible: true, group: 'basic' },
        { prop: 'indicatorId', label: '指标ID', visible: true, group: 'basic' },
        { prop: 'indicatorName', label: '指标名称', visible: true, required: true, group: 'basic' },
        { prop: 'recordDate', label: '记录日期', visible: true, width: '120', group: 'basic' },
        { prop: 'calculationCycle', label: '计算周期', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'data',
      label: '监控数据',
      fields: [
        { prop: 'currentValue', label: '当前值', visible: true, group: 'data' },
        { prop: 'targetValue', label: '目标值', visible: true, group: 'data' },
        { prop: 'thresholdValue', label: '阈值', visible: true, group: 'data' },
        { prop: 'deviation', label: '偏差', visible: true, group: 'data' },
        { prop: 'completionRate', label: '完成率(%)', visible: true, group: 'data' }
      ]
    },
    {
      name: 'alert',
      label: '告警信息',
      fields: [
        { prop: 'alertLevel', label: '告警级别', visible: true, group: 'alert' },
        { prop: 'alertMessage', label: '告警信息', visible: true, group: 'alert' },
        { prop: 'isResolved', label: '是否已解决', visible: true, group: 'alert' },
        { prop: 'isAlert', label: '是否预警', visible: true, group: 'alert' }
      ]
    },
    {
      name: 'department',
      label: '科室信息',
      fields: [
        { prop: 'departmentId', label: '科室ID', visible: true, group: 'department' },
        { prop: 'departmentName', label: '科室名称', visible: true, group: 'department' }
      ]
    },
    {
      name: 'system',
      label: '制度信息',
      fields: [
        { prop: 'systemId', label: '制度ID', visible: true, group: 'system' },
        { prop: 'systemCode', label: '制度编码', visible: true, group: 'system' },
        { prop: 'systemName', label: '制度名称', visible: true, group: 'system' },
        { prop: 'systemScore', label: '制度得分', visible: true, group: 'system' }
      ]
    },
    {
      name: 'other',
      label: '其他信息',
      fields: [
        { prop: 'indicatorValue', label: '指标值', visible: true, group: 'other' },
        { prop: 'indicatorScore', label: '指标得分', visible: true, group: 'other' },
        { prop: 'defectCount', label: '缺陷数', visible: true, group: 'other' },
        { prop: 'rankInHospital', label: '院内排名', visible: true, group: 'other' },
        { prop: 'trendDirection', label: '趋势方向', visible: true, group: 'other' },
        { prop: 'trendValue', label: '趋势值', visible: true, group: 'other' }
      ]
    },
    {
      name: 'system_fields',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '删除标志', visible: true, group: 'system_fields' },
        { prop: 'createTime', label: '创建时间', visible: true, group: 'system_fields' },
        { prop: 'createBy', label: '创建者', visible: true, group: 'system_fields' },
        { prop: 'createDept', label: '创建部门', visible: true, group: 'system_fields' },
        { prop: 'updateTime', label: '更新时间', visible: true, group: 'system_fields' },
        { prop: 'updateBy', label: '更新者', visible: true, group: 'system_fields' }
      ]
    }
  ];

  return fieldGroups;
}

// 质控指标采集配置字段配置
export function createQcIndicatorCollectionConfigFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础',
      fields: [
        { prop: 'indicatorId', label: '指标ID', visible: true, required: true, group: 'basic' },
        { prop: 'sourceSystem', label: '来源系统', visible: true, group: 'basic' },
        { prop: 'sourceTable', label: '来源表', visible: true, group: 'basic' },
        { prop: 'sourceField', label: '来源字段', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'rule',
      label: '规则',
      fields: [
        { prop: 'extractionRule', label: '提取规则', visible: true, group: 'rule' },
        { prop: 'validationRule', label: '校验规则', visible: true, group: 'rule' },
        { prop: 'dataType', label: '数据类型', visible: true, group: 'rule' },
        { prop: 'defaultValue', label: '默认值', visible: true, group: 'rule' }
      ]
    },
    {
      name: 'status',
      label: '状态',
      fields: [
        { prop: 'isRequired', label: '是否必需', visible: true, group: 'status' },
        { prop: 'delFlag', label: '是否删除', visible: true, group: 'status' }
      ]
    }
  ];
  return fieldGroups;
}

// 核心制度指标字段配置
export function createCoreSystemIndicatorFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, group: 'basic' },
        { prop: 'indicatorCode', label: '指标编码', visible: true, required: true, group: 'basic', minWidth: 120 },
        { prop: 'indicatorName', label: '指标名称', visible: true, required: true, group: 'basic', minWidth: 150 },
        { prop: 'systemId', label: '所属制度ID', visible: true, group: 'basic' },
        { prop: 'parentId', label: '父指标ID', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'calculation',
      label: '计算信息',
      fields: [
        { prop: 'indicatorType', label: '指标类型', visible: true, group: 'calculation', minWidth: 100 },
        { prop: 'calculationFormula', label: '计算公式', visible: true, group: 'calculation', minWidth: 200 },
        { prop: 'calculationCycle', label: '计算周期', visible: true, group: 'calculation', minWidth: 100 },
        { prop: 'targetValue', label: '目标值', visible: true, group: 'calculation' },
        { prop: 'weight', label: '权重', visible: true, group: 'calculation' }
      ]
    },
    {
      name: 'status',
      label: '状态信息',
      fields: [
        { prop: 'status', label: '状态', visible: true, group: 'status' },
        { prop: 'sortOrder', label: '排序', visible: true, group: 'status' },
        { prop: 'remark', label: '备注', visible: true, group: 'status' }
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

  return fieldGroups;
}

// 核心制度考核记录字段配置
export function createCoreSystemAssessmentRecordFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'systemName', label: '制度名称', visible: true, required: true, group: 'basic' },
        { prop: 'assessorName', label: '考核人名称', visible: true, required: true, group: 'basic' }
      ]
    },
    {
      name: 'assessment',
      label: '考核信息',
      fields: [
        { prop: 'assessmentTime', label: '考核时间', visible: true, required: true, width: '180', group: 'assessment' },
        { prop: 'assessmentCycle', label: '考核周期', visible: true, required: true, group: 'assessment' },
        { prop: 'assessmentScore', label: '考核分数', visible: true, required: true, group: 'assessment' },
        { prop: 'assessmentGrade', label: '考核等级', visible: true, required: true, group: 'assessment' },
        { prop: 'assessmentResult', label: '考核结果', visible: true, required: true, group: 'assessment' },
        { prop: 'assessmentOpinion', label: '考核意见', visible: true, group: 'assessment' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [{ prop: 'remark', label: '备注', visible: true, group: 'detail' }]
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

  return fieldGroups;
}

// 核心制度执行记录字段配置
export function createCoreSystemExecutionRecordFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '执行ID', visible: true, group: 'basic' },
        { prop: 'systemName', label: '制度名称', visible: true, required: true, group: 'basic' },
        { prop: 'executorName', label: '执行人姓名', visible: true, required: true, group: 'basic' }
      ]
    },
    {
      name: 'association',
      label: '关联信息',
      fields: [
        { prop: 'systemId', label: '制度ID', visible: false, required: true, group: 'association' },
        { prop: 'executorId', label: '执行人ID', visible: false, required: true, group: 'association' }
      ]
    },
    {
      name: 'execution',
      label: '执行信息',
      fields: [
        { prop: 'executionTime', label: '执行时间', visible: true, width: '180', group: 'execution' },
        { prop: 'executionResult', label: '执行结果', visible: true, group: 'execution' },
        { prop: 'remark', label: '备注', visible: true, group: 'execution' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '删除标志', visible: false, group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: false, group: 'system' },
        { prop: 'createBy', label: '创建者', visible: false, group: 'system' },
        { prop: 'createDept', label: '创建部门', visible: false, group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: false, group: 'system' },
        { prop: 'updateBy', label: '更新者', visible: false, group: 'system' }
      ]
    }
  ];

  return fieldGroups;
}

// 核心制度检查记录字段配置
export function createCoreSystemInspectionRecordFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'tenantId', label: '租户ID', visible: true, group: 'basic' },
        { prop: 'systemId', label: '制度ID', visible: true, required: true, group: 'basic' },
        { prop: 'systemName', label: '制度名称', visible: true, required: true, group: 'basic' },
        { prop: 'inspectorId', label: '检查人ID', visible: true, required: true, group: 'basic' },
        { prop: 'inspectorName', label: '检查人姓名', visible: true, required: true, group: 'basic' }
      ]
    },
    {
      name: 'inspection',
      label: '检查信息',
      fields: [
        { prop: 'inspectionTime', label: '检查时间', visible: true, width: '180', group: 'inspection' },
        { prop: 'inspectionResult', label: '检查结果', visible: true, group: 'inspection' },
        { prop: 'problemDescription', label: '问题描述', visible: true, group: 'inspection' },
        { prop: 'rectificationSuggestion', label: '整改建议', visible: true, group: 'inspection' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [{ prop: 'remark', label: '备注', visible: true, group: 'detail' }]
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

  return fieldGroups;
}

// 核心制度整改记录字段配置
export function createCoreSystemRectificationRecordFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'rectificationId', label: '整改编号', visible: true, required: true, group: 'basic' },
        { prop: 'systemName', label: '制度名称', visible: true, required: true, group: 'basic' },
        { prop: 'rectifierName', label: '整改人名称', visible: true, required: true, group: 'basic' }
      ]
    },
    {
      name: 'association',
      label: '关联信息',
      fields: [
        { prop: 'systemId', label: '制度ID', visible: false, required: true, group: 'association' },
        { prop: 'rectifierId', label: '整改人ID', visible: false, required: true, group: 'association' }
      ]
    },
    {
      name: 'status',
      label: '整改状态',
      fields: [
        { prop: 'rectificationStatus', label: '整改状态', visible: true, required: true, group: 'status' },
        { prop: 'rectificationStartTime', label: '开始时间', visible: true, width: '180', group: 'status' },
        { prop: 'rectificationEndTime', label: '完成时间', visible: true, width: '180', group: 'status' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'rectificationContent', label: '整改内容', visible: true, group: 'detail' },
        { prop: 'rectificationMeasures', label: '整改措施', visible: true, group: 'detail' }
      ]
    },
    {
      name: 'result',
      label: '验收结果',
      fields: [
        { prop: 'acceptanceResult', label: '验收结果', visible: true, group: 'result' },
        { prop: 'acceptanceOpinion', label: '验收意见', visible: true, group: 'result' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '删除标志', visible: false, group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: false, width: '180', group: 'system' },
        { prop: 'createBy', label: '创建人', visible: false, group: 'system' },
        { prop: 'createDept', label: '创建部门', visible: false, group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: false, width: '180', group: 'system' },
        { prop: 'updateBy', label: '更新人', visible: false, group: 'system' },
        { prop: 'remark', label: '备注', visible: false, group: 'system' }
      ]
    }
  ];

  return fieldGroups;
}