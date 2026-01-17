import { FieldConfigManager, FieldGroup } from '../fieldConfigManager';

// coreSystemAssessmentRecord字段配置
export function createCoreSystemAssessmentRecordFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'assessmentId', label: '考核ID', visible: true, type: 'input', group: 'basic' },
        { prop: 'systemId', label: '制度ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'systemName', label: '制度名称', visible: true, type: 'input', group: 'basic' },
        { prop: 'assessorId', label: '考核人ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'assessorName', label: '考核人名称', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'assessmentTime', label: '考核时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'assessmentCycle', label: '考核周期', visible: true, type: 'input', group: 'detail' },
        { prop: 'assessmentScore', label: '考核分数', visible: true, type: 'number', group: 'detail' },
        { prop: 'assessmentGrade', label: '考核等级', visible: true, type: 'select', group: 'detail' },
        { prop: 'assessmentResult', label: '考核结果', visible: true, type: 'input', group: 'detail' },
        { prop: 'assessmentOpinion', label: '考核意见', visible: true, type: 'textarea', group: 'detail' }
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

  return new FieldConfigManager('coreSystemAssessmentRecord', fieldGroups);
}


// coreSystemConfig字段配置
export function createCoreSystemConfigFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'systemCode', label: '制度编码', visible: true, type: 'input', group: 'basic' },
        { prop: 'systemName', label: '制度名称', visible: true, type: 'input', group: 'basic' },
        { prop: 'systemType', label: '制度类型', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'systemDescription', label: '制度描述', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'totalScore', label: '制度总分', visible: true, type: 'number', group: 'detail' },
        { prop: 'weight', label: '权重', visible: true, type: 'number', group: 'detail' },
        { prop: 'isEnabled', label: '是否启用', visible: true, type: 'number', group: 'detail' },
        { prop: 'isCustom', label: '是否自定义 1-是 0-否', visible: true, type: 'number', group: 'detail' }
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

  return new FieldConfigManager('coreSystemConfig', fieldGroups);
}


// coreSystemExecutionRecord字段配置
export function createCoreSystemExecutionRecordFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '执行ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'systemId', label: '制度ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'systemName', label: '制度名称', visible: true, type: 'input', group: 'basic' },
        { prop: 'executorId', label: '执行人ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'executorName', label: '执行人姓名', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'executionTime', label: '执行时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'executionResult', label: '执行结果 1-成功 0-失败', visible: true, type: 'select', group: 'detail' }
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

  return new FieldConfigManager('coreSystemExecutionRecord', fieldGroups);
}


// coreSystemIndicator字段配置
export function createCoreSystemIndicatorFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'indicatorCode', label: '指标编码', visible: true, type: 'input', group: 'basic' },
        { prop: 'indicatorName', label: '指标名称', visible: true, type: 'input', group: 'basic' },
        { prop: 'systemId', label: '所属制度ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'parentId', label: '父指标ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'indicatorType', label: '指标类型 数量指标/率指标/时间指标', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'calculationFormula', label: '计算公式', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'calculationCycle', label: '计算周期 日/周/月/季度/年', visible: true, type: 'input', group: 'detail' },
        { prop: 'dataSource', label: '数据来源', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'targetValue', label: '目标值', visible: true, type: 'input', group: 'detail' },
        { prop: 'indicatorScore', label: '指标分值', visible: true, type: 'number', group: 'detail' },
        { prop: 'isReverse', label: '是否反向指标 1-是 0-否', visible: true, type: 'number', group: 'detail' },
        { prop: 'alertThreshold', label: '预警阈值', visible: true, type: 'input', group: 'detail' },
        { prop: 'isEnabled', label: '是否启用', visible: true, type: 'number', group: 'detail' },
        { prop: 'isCustom', label: '是否自定义', visible: true, type: 'number', group: 'detail' }
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

  return new FieldConfigManager('coreSystemIndicator', fieldGroups);
}


// coreSystemInspectionRecord字段配置
export function createCoreSystemInspectionRecordFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '检查ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'systemId', label: '制度ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'systemName', label: '制度名称', visible: true, type: 'input', group: 'basic' },
        { prop: 'inspectorId', label: '检查人ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'inspectorName', label: '检查人姓名', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'inspectionTime', label: '检查时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'inspectionResult', label: '检查结果 1-合格 0-不合格', visible: true, type: 'select', group: 'detail' },
        { prop: 'inspectionContent', label: '检查内容', visible: true, type: 'input', group: 'detail' },
        { prop: 'problemDescription', label: '问题描述', visible: true, type: 'input', group: 'detail' },
        { prop: 'rectificationSuggestion', label: '整改建议', visible: true, type: 'input', group: 'detail' }
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

  return new FieldConfigManager('coreSystemInspectionRecord', fieldGroups);
}


// coreSystemRectificationRecord字段配置
export function createCoreSystemRectificationRecordFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'rectificationId', label: '整改ID', visible: true, type: 'input', group: 'basic' },
        { prop: 'systemId', label: '制度ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'systemName', label: '制度名称', visible: true, type: 'input', group: 'basic' },
        { prop: 'rectifierId', label: '整改人ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'rectifierName', label: '整改人名称', visible: true, type: 'input', group: 'basic' },
        { prop: 'rectificationStatus', label: '整改状态', visible: true, type: 'select', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'rectificationStartTime', label: '开始时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'rectificationEndTime', label: '完成时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'rectificationContent', label: '整改内容', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'rectificationMeasures', label: '整改措施', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'acceptanceResult', label: '验收结果', visible: true, type: 'select', group: 'detail' },
        { prop: 'acceptanceOpinion', label: '验收意见', visible: true, type: 'textarea', group: 'detail' }
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

  return new FieldConfigManager('coreSystemRectificationRecord', fieldGroups);
}
