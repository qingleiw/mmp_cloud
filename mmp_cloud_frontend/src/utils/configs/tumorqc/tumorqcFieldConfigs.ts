import { FieldConfigManager, FieldGroup } from '../fieldConfigManager';

// 肿瘤质控指标记录字段配置
export function createTumorQcIndicatorRecordFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'tenantId', label: '租户ID', visible: true, group: 'basic' },
        { prop: 'indicatorId', label: '指标ID', visible: true, group: 'basic' },
        { prop: 'indicatorName', label: '指标名称', visible: true, group: 'basic' },
        { prop: 'indicatorCode', label: '指标编码', visible: true, group: 'basic' },
        { prop: 'recordDate', label: '记录日期', visible: true, width: '120', group: 'basic' },
        { prop: 'calculationCycle', label: '计算周期', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'data',
      label: '数据信息',
      fields: [
        { prop: 'indicatorValue', label: '指标值', visible: true, group: 'data' },
        { prop: 'targetValue', label: '目标值', visible: true, group: 'data' },
        { prop: 'numerator', label: '分子', visible: true, group: 'data' },
        { prop: 'denominator', label: '分母', visible: true, group: 'data' },
        { prop: 'completionRate', label: '完成率', visible: true, group: 'data' }
      ]
    },
    {
      name: 'status',
      label: '状态信息',
      fields: [
        { prop: 'complianceStatus', label: '达标状态', visible: true, group: 'status' },
        { prop: 'isAbnormal', label: '是否异常', visible: true, group: 'status' },
        { prop: 'rankInHospital', label: '医院排名', visible: true, group: 'status' },
        { prop: 'trendDirection', label: '趋势方向', visible: true, group: 'status' }
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
      name: 'source',
      label: '数据来源',
      fields: [
        { prop: 'dataSource', label: '数据来源', visible: true, group: 'source' },
        { prop: 'isManual', label: '是否手动录入', visible: true, group: 'source' }
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

  return new FieldConfigManager('tumorQcIndicatorRecord', fieldGroups);
}

// 肿瘤质控报告字段配置
export function createTumorQcReportFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'tenantId', label: '租户ID', visible: true, group: 'basic' },
        { prop: 'reportCode', label: '报告编码', visible: true, required: true, group: 'basic' },
        { prop: 'reportTitle', label: '报告标题', visible: true, group: 'basic' },
        { prop: 'reportType', label: '报告类型', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'period',
      label: '周期',
      fields: [
        { prop: 'periodStart', label: '报告周期开始', visible: true, width: '120', group: 'period' },
        { prop: 'periodEnd', label: '报告周期结束', visible: true, width: '120', group: 'period' }
      ]
    },
    {
      name: 'content',
      label: '内容',
      fields: [
        { prop: 'reportContent', label: '报告内容', visible: true, group: 'content' },
        { prop: 'summary', label: '报告摘要', visible: true, group: 'content' },
        { prop: 'recommendations', label: '建议措施', visible: true, group: 'content' }
      ]
    },
    {
      name: 'status',
      label: '状态',
      fields: [
        { prop: 'status', label: '状态', visible: true, group: 'status' },
        { prop: 'publishTime', label: '发布时间', visible: true, width: '120', group: 'status' }
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

  return new FieldConfigManager('tumorQcReport', fieldGroups);
}

// 肿瘤质控方案字段配置
export function createTumorQcPlanFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'tenantId', label: '租户ID', visible: true, group: 'basic' },
        { prop: 'planCode', label: '方案编码', visible: true, required: true, group: 'basic' },
        { prop: 'planName', label: '方案名称', visible: true, group: 'basic' },
        { prop: 'planType', label: '方案类型', visible: true, group: 'basic' },
        { prop: 'description', label: '方案描述', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'time',
      label: '时间',
      fields: [
        { prop: 'startDate', label: '开始日期', visible: true, width: '120', group: 'time' },
        { prop: 'endDate', label: '结束日期', visible: true, width: '120', group: 'time' }
      ]
    },
    {
      name: 'status',
      label: '状态',
      fields: [
        { prop: 'status', label: '状态', visible: true, group: 'status' },
        { prop: 'approvalStatus', label: '审批状态', visible: true, group: 'status' }
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
  return new FieldConfigManager('tumorQcPlan', fieldGroups);
}

// 肿瘤质控检查字段配置
export function createTumorQcInspectionFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'tenantId', label: '租户ID', visible: true, group: 'basic' },
        { prop: 'inspectionCode', label: '检查编码', visible: true, required: true, group: 'basic' },
        { prop: 'inspectionDate', label: '检查日期', visible: true, width: '120', group: 'basic' },
        { prop: 'inspectorName', label: '检查人姓名', visible: true, group: 'basic' },
        { prop: 'departmentName', label: '检查科室名称', visible: true, group: 'basic' },
        { prop: 'inspectionType', label: '检查类型', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'result',
      label: '结果',
      fields: [
        { prop: 'inspectionResult', label: '检查结果', visible: true, group: 'result' },
        { prop: 'problemDescription', label: '问题描述', visible: true, group: 'result' },
        { prop: 'suggestion', label: '整改建议', visible: true, group: 'result' }
      ]
    },
    {
      name: 'status',
      label: '状态',
      fields: [{ prop: 'status', label: '状态', visible: true, group: 'status' }]
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
  return new FieldConfigManager('tumorQcInspection', fieldGroups);
}

// 肿瘤质控整改字段配置
export function createTumorQcRectificationFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'rectificationCode', label: '整改编码', visible: true, required: true, group: 'basic' },
        { prop: 'problemDescription', label: '问题描述', visible: true, group: 'basic' },
        { prop: 'rectificationMeasures', label: '整改措施', visible: true, group: 'basic' },
        { prop: 'responsiblePersonName', label: '负责人姓名', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'time',
      label: '时间',
      fields: [
        { prop: 'deadline', label: '整改期限', visible: true, width: '120', group: 'time' },
        { prop: 'completionTime', label: '完成时间', visible: true, width: '120', group: 'time' }
      ]
    },
    {
      name: 'result',
      label: '结果',
      fields: [
        { prop: 'rectificationResult', label: '整改结果', visible: true, group: 'result' },
        { prop: 'verificationStatus', label: '验证状态', visible: true, group: 'result' }
      ]
    },
    {
      name: 'status',
      label: '状态',
      fields: [
        { prop: 'status', label: '状态', visible: true, group: 'status' },
        { prop: 'delFlag', label: '删除标志', visible: true, group: 'status' }
      ]
    }
  ];
  return new FieldConfigManager('tumorQcRectification', fieldGroups);
}

// 肿瘤质控指标配置字段配置
export function createTumorQcIndicatorConfigFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'indicatorCode', label: '指标编码', visible: true, required: true, group: 'basic' },
        { prop: 'indicatorName', label: '指标名称', visible: true, required: true, group: 'basic' },
        { prop: 'indicatorType', label: '指标类型', visible: true, group: 'basic' },
        { prop: 'calculationFormula', label: '计算公式', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'standard',
      label: '标准信息',
      fields: [
        { prop: 'targetValue', label: '目标值', visible: true, group: 'standard' },
        { prop: 'upperLimit', label: '上限值', visible: true, group: 'standard' },
        { prop: 'lowerLimit', label: '下限值', visible: true, group: 'standard' }
      ]
    },
    {
      name: 'status',
      label: '状态信息',
      fields: [
        { prop: 'status', label: '状态', visible: true, group: 'status' },
        { prop: 'isActive', label: '是否激活', visible: true, group: 'status' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '删除标志', visible: true, group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, group: 'system' },
        { prop: 'createBy', label: '创建者', visible: true, group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, group: 'system' },
        { prop: 'updateBy', label: '更新者', visible: true, group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('tumorQcIndicatorConfig', fieldGroups);
}

// 肿瘤质控指标详情字段配置
export function createTumorQcIndicatorDetailFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'indicatorId', label: '指标ID', visible: true, required: true, group: 'basic' },
        { prop: 'detailType', label: '详情类型', visible: true, group: 'basic' },
        { prop: 'detailDate', label: '详情日期', visible: true, width: '120', group: 'basic' }
      ]
    },
    {
      name: 'data',
      label: '数据信息',
      fields: [
        { prop: 'calculatedValue', label: '计算值', visible: true, group: 'data' },
        { prop: 'manualValue', label: '手动值', visible: true, group: 'data' },
        { prop: 'dataSource', label: '数据来源', visible: true, group: 'data' }
      ]
    },
    {
      name: 'status',
      label: '状态信息',
      fields: [
        { prop: 'isValid', label: '是否有效', visible: true, group: 'status' },
        { prop: 'verificationStatus', label: '验证状态', visible: true, group: 'status' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '删除标志', visible: true, group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, group: 'system' },
        { prop: 'createBy', label: '创建者', visible: true, group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, group: 'system' },
        { prop: 'updateBy', label: '更新者', visible: true, group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('tumorQcIndicatorDetail', fieldGroups);
}

// 肿瘤质控结果字段配置
export function createTumorQcResultFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'indicatorId', label: '指标ID', visible: true, required: true, group: 'basic' },
        { prop: 'indicatorName', label: '指标名称', visible: true, group: 'basic' },
        { prop: 'resultDate', label: '结果日期', visible: true, width: '120', group: 'basic' }
      ]
    },
    {
      name: 'measurement',
      label: '测量信息',
      fields: [
        { prop: 'measuredValue', label: '测量值', visible: true, group: 'measurement' },
        { prop: 'unit', label: '单位', visible: true, group: 'measurement' },
        { prop: 'measurementMethod', label: '测量方法', visible: true, group: 'measurement' }
      ]
    },
    {
      name: 'assessment',
      label: '评估信息',
      fields: [
        { prop: 'performanceLevel', label: '绩效水平', visible: true, group: 'assessment' },
        { prop: 'complianceStatus', label: '合规状态', visible: true, group: 'assessment' },
        { prop: 'riskLevel', label: '风险等级', visible: true, group: 'assessment' }
      ]
    },
    {
      name: 'analysis',
      label: '分析信息',
      fields: [
        { prop: 'trendAnalysis', label: '趋势分析', visible: true, group: 'analysis' },
        { prop: 'improvementSuggestions', label: '改进建议', visible: true, group: 'analysis' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '删除标志', visible: true, group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, group: 'system' },
        { prop: 'createBy', label: '创建者', visible: true, group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, group: 'system' },
        { prop: 'updateBy', label: '更新者', visible: true, group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('tumorQcResult', fieldGroups);
}