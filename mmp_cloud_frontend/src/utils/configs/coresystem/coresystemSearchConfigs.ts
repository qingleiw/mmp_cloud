import { SearchConfigManager, SearchFieldGroup } from '../searchConfigManager';

// coreSystemAssessmentRecord搜索配置
export function createCoreSystemAssessmentRecordSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'assessmentId', label: '考核ID', type: 'input', visible: true, placeholder: '请输入考核ID' },
        { prop: 'systemId', label: '制度ID', type: 'number', visible: true, placeholder: '请输入制度ID' },
        { prop: 'systemName', label: '制度名称', type: 'input', visible: true, placeholder: '请输入制度名称' },
        { prop: 'assessorId', label: '考核人ID', type: 'number', visible: false, placeholder: '请输入考核人ID' },
        { prop: 'assessorName', label: '考核人名称', type: 'input', visible: false, placeholder: '请输入考核人名称' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'assessmentTime', label: '考核时间', type: 'daterange', visible: false, placeholder: '请输入考核时间', startProp: 'assessmentTimeStart', endProp: 'assessmentTimeEnd' },
        { prop: 'assessmentCycle', label: '考核周期', type: 'input', visible: false, placeholder: '请输入考核周期' },
        { prop: 'assessmentScore', label: '考核分数', type: 'number', visible: false, placeholder: '请输入考核分数' },
        { prop: 'assessmentGrade', label: '考核等级', type: 'select', visible: false, placeholder: '请输入考核等级' },
        { prop: 'assessmentResult', label: '考核结果', type: 'input', visible: false, placeholder: '请输入考核结果' },
        { prop: 'assessmentOpinion', label: '考核意见', type: 'input', visible: false, placeholder: '请输入考核意见' }
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

  return new SearchConfigManager('coreSystemAssessmentRecord', searchFieldGroups);
}


// coreSystemConfig搜索配置
export function createCoreSystemConfigSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'systemCode', label: '制度编码', type: 'input', visible: true, placeholder: '请输入制度编码' },
        { prop: 'systemName', label: '制度名称', type: 'input', visible: true, placeholder: '请输入制度名称' },
        { prop: 'systemType', label: '制度类型', type: 'input', visible: true, placeholder: '请输入制度类型' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'systemDescription', label: '制度描述', type: 'input', visible: false, placeholder: '请输入制度描述' },
        { prop: 'totalScore', label: '制度总分', type: 'number', visible: false, placeholder: '请输入制度总分' },
        { prop: 'weight', label: '权重', type: 'number', visible: false, placeholder: '请输入权重' },
        { prop: 'isEnabled', label: '是否启用', type: 'number', visible: false, placeholder: '请输入是否启用' },
        { prop: 'isCustom', label: '是否自定义 1-是 0-否', type: 'number', visible: false, placeholder: '请输入是否自定义 1-是 0-否' }
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

  return new SearchConfigManager('coreSystemConfig', searchFieldGroups);
}


// coreSystemExecutionRecord搜索配置
export function createCoreSystemExecutionRecordSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '执行ID', type: 'number', visible: true, placeholder: '请输入执行ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'systemId', label: '制度ID', type: 'number', visible: true, placeholder: '请输入制度ID' },
        { prop: 'systemName', label: '制度名称', type: 'input', visible: true, placeholder: '请输入制度名称' },
        { prop: 'executorId', label: '执行人ID', type: 'number', visible: true, placeholder: '请输入执行人ID' },
        { prop: 'executorName', label: '执行人姓名', type: 'input', visible: false, placeholder: '请输入执行人姓名' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'executionTime', label: '执行时间', type: 'daterange', visible: false, placeholder: '请输入执行时间', startProp: 'executionTimeStart', endProp: 'executionTimeEnd' },
        { prop: 'executionResult', label: '执行结果 1-成功 0-失败', type: 'select', visible: false, placeholder: '请输入执行结果 1-成功 0-失败' }
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

  return new SearchConfigManager('coreSystemExecutionRecord', searchFieldGroups);
}


// coreSystemIndicator搜索配置
export function createCoreSystemIndicatorSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'indicatorCode', label: '指标编码', type: 'input', visible: true, placeholder: '请输入指标编码' },
        { prop: 'indicatorName', label: '指标名称', type: 'input', visible: true, placeholder: '请输入指标名称' },
        { prop: 'systemId', label: '所属制度ID', type: 'number', visible: true, placeholder: '请输入所属制度ID' },
        { prop: 'parentId', label: '父指标ID', type: 'number', visible: false, placeholder: '请输入父指标ID' },
        { prop: 'indicatorType', label: '指标类型 数量指标/率指标/时间指标', type: 'input', visible: false, placeholder: '请输入指标类型 数量指标/率指标/时间指标' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'calculationFormula', label: '计算公式', type: 'input', visible: false, placeholder: '请输入计算公式' },
        { prop: 'calculationCycle', label: '计算周期 日/周/月/季度/年', type: 'input', visible: false, placeholder: '请输入计算周期 日/周/月/季度/年' },
        { prop: 'dataSource', label: '数据来源', type: 'input', visible: false, placeholder: '请输入数据来源' },
        { prop: 'targetValue', label: '目标值', type: 'input', visible: false, placeholder: '请输入目标值' },
        { prop: 'indicatorScore', label: '指标分值', type: 'number', visible: false, placeholder: '请输入指标分值' },
        { prop: 'isReverse', label: '是否反向指标 1-是 0-否', type: 'number', visible: false, placeholder: '请输入是否反向指标 1-是 0-否' },
        { prop: 'alertThreshold', label: '预警阈值', type: 'input', visible: false, placeholder: '请输入预警阈值' },
        { prop: 'isEnabled', label: '是否启用', type: 'number', visible: false, placeholder: '请输入是否启用' },
        { prop: 'isCustom', label: '是否自定义', type: 'number', visible: false, placeholder: '请输入是否自定义' }
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

  return new SearchConfigManager('coreSystemIndicator', searchFieldGroups);
}


// coreSystemInspectionRecord搜索配置
export function createCoreSystemInspectionRecordSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '检查ID', type: 'number', visible: true, placeholder: '请输入检查ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'systemId', label: '制度ID', type: 'number', visible: true, placeholder: '请输入制度ID' },
        { prop: 'systemName', label: '制度名称', type: 'input', visible: true, placeholder: '请输入制度名称' },
        { prop: 'inspectorId', label: '检查人ID', type: 'number', visible: true, placeholder: '请输入检查人ID' },
        { prop: 'inspectorName', label: '检查人姓名', type: 'input', visible: false, placeholder: '请输入检查人姓名' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'inspectionTime', label: '检查时间', type: 'daterange', visible: false, placeholder: '请输入检查时间', startProp: 'inspectionTimeStart', endProp: 'inspectionTimeEnd' },
        { prop: 'inspectionResult', label: '检查结果 1-合格 0-不合格', type: 'select', visible: false, placeholder: '请输入检查结果 1-合格 0-不合格' },
        { prop: 'inspectionContent', label: '检查内容', type: 'input', visible: false, placeholder: '请输入检查内容' },
        { prop: 'problemDescription', label: '问题描述', type: 'input', visible: false, placeholder: '请输入问题描述' },
        { prop: 'rectificationSuggestion', label: '整改建议', type: 'input', visible: false, placeholder: '请输入整改建议' }
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

  return new SearchConfigManager('coreSystemInspectionRecord', searchFieldGroups);
}


// coreSystemRectificationRecord搜索配置
export function createCoreSystemRectificationRecordSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'rectificationId', label: '整改ID', type: 'input', visible: true, placeholder: '请输入整改ID' },
        { prop: 'systemId', label: '制度ID', type: 'number', visible: true, placeholder: '请输入制度ID' },
        { prop: 'systemName', label: '制度名称', type: 'input', visible: true, placeholder: '请输入制度名称' },
        { prop: 'rectifierId', label: '整改人ID', type: 'number', visible: false, placeholder: '请输入整改人ID' },
        { prop: 'rectifierName', label: '整改人名称', type: 'input', visible: false, placeholder: '请输入整改人名称' },
        { prop: 'rectificationStatus', label: '整改状态', type: 'select', visible: false, placeholder: '请输入整改状态' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'rectificationStartTime', label: '开始时间', type: 'daterange', visible: false, placeholder: '请输入开始时间', startProp: 'rectificationStartTimeStart', endProp: 'rectificationStartTimeEnd' },
        { prop: 'rectificationEndTime', label: '完成时间', type: 'daterange', visible: false, placeholder: '请输入完成时间', startProp: 'rectificationEndTimeStart', endProp: 'rectificationEndTimeEnd' },
        { prop: 'rectificationContent', label: '整改内容', type: 'input', visible: false, placeholder: '请输入整改内容' },
        { prop: 'rectificationMeasures', label: '整改措施', type: 'input', visible: false, placeholder: '请输入整改措施' },
        { prop: 'acceptanceResult', label: '验收结果', type: 'select', visible: false, placeholder: '请输入验收结果' },
        { prop: 'acceptanceOpinion', label: '验收意见', type: 'input', visible: false, placeholder: '请输入验收意见' }
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

  return new SearchConfigManager('coreSystemRectificationRecord', searchFieldGroups);
}
