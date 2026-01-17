import { FieldConfigManager, FieldGroup } from '../fieldConfigManager';

// tumorQcIndicatorConfig字段配置
export function createTumorQcIndicatorConfigFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'indicatorCode', label: '指标编码', visible: true, type: 'input', group: 'basic' },
        { prop: 'indicatorName', label: '指标名称', visible: true, type: 'input', group: 'basic' },
        { prop: 'tumorType', label: '肿瘤类型', visible: true, type: 'input', group: 'basic' },
        { prop: 'indicatorType', label: '指标类型 强制性/推荐性', visible: true, type: 'input', group: 'basic' },
        { prop: 'policyLevel', label: '政策级别 国家级/省级/市级', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'indicatorCategory', label: '指标分类', visible: true, type: 'input', group: 'detail' },
        { prop: 'calculationFormula', label: '计算公式', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'dataSource', label: '数据来源', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'collectionFrequency', label: '采集频率 实时/每日/每周/每月', visible: true, type: 'input', group: 'detail' },
        { prop: 'standardValue', label: '标准值', visible: true, type: 'input', group: 'detail' },
        { prop: 'targetValue', label: '目标值', visible: true, type: 'input', group: 'detail' },
        { prop: 'version', label: '指标版本', visible: true, type: 'input', group: 'detail' },
        { prop: 'effectiveDate', label: '生效日期', visible: true, type: 'date', group: 'detail' },
        { prop: 'policySource', label: '政策来源', visible: true, type: 'input', group: 'detail' },
        { prop: 'isEnabled', label: '是否启用', visible: true, type: 'number', group: 'detail' }
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

  return new FieldConfigManager('tumorQcIndicatorConfig', fieldGroups);
}


// tumorQcIndicatorDetail字段配置
export function createTumorQcIndicatorDetailFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'recordId', label: '监测记录ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'indicatorId', label: '指标ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'patientId', label: '患者ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'patientName', label: '患者姓名', visible: true, type: 'input', group: 'basic' },
        { prop: 'visitNo', label: '就诊号', visible: true, type: 'input', group: 'basic' },
        { prop: 'diagnosis', label: '诊断', visible: true, type: 'textarea', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'indicatorResult', label: '指标结果 达标/不达标/不适用', visible: true, type: 'input', group: 'detail' },
        { prop: 'resultDescription', label: '结果说明', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'relatedData', label: '相关数据JSON', visible: true, type: 'textarea', group: 'detail' }
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

  return new FieldConfigManager('tumorQcIndicatorDetail', fieldGroups);
}


// tumorQcIndicatorRecord字段配置
export function createTumorQcIndicatorRecordFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'departmentId', label: '科室ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'departmentName', label: '科室名称', visible: true, type: 'input', group: 'basic' },
        { prop: 'indicatorId', label: '指标ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'indicatorCode', label: '指标编码', visible: true, type: 'input', group: 'basic' },
        { prop: 'indicatorName', label: '指标名称', visible: true, type: 'input', group: 'basic' },
        { prop: 'denominator', label: '分母', visible: true, type: 'number', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'recordDate', label: '记录日期', visible: true, type: 'date', group: 'detail' },
        { prop: 'calculationCycle', label: '计算周期', visible: true, type: 'input', group: 'detail' },
        { prop: 'numerator', label: '分子', visible: true, type: 'number', group: 'detail' },
        { prop: 'indicatorValue', label: '指标值', visible: true, type: 'number', group: 'detail' },
        { prop: 'targetValue', label: '目标值', visible: true, type: 'input', group: 'detail' },
        { prop: 'complianceStatus', label: '达标状态 达标/不达标', visible: true, type: 'input', group: 'detail' },
        { prop: 'completionRate', label: '完成率', visible: true, type: 'number', group: 'detail' },
        { prop: 'rankInHospital', label: '院内排名', visible: true, type: 'number', group: 'detail' },
        { prop: 'trendDirection', label: '趋势方向', visible: true, type: 'input', group: 'detail' },
        { prop: 'isAbnormal', label: '是否异常 1-是 0-否', visible: true, type: 'number', group: 'detail' },
        { prop: 'dataSource', label: '数据来源说明', visible: true, type: 'input', group: 'detail' },
        { prop: 'isManual', label: '是否人工录入 1-是 0-否', visible: true, type: 'number', group: 'detail' }
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

  return new FieldConfigManager('tumorQcIndicatorRecord', fieldGroups);
}


// tumorQcInspection字段配置
export function createTumorQcInspectionFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'inspectionCode', label: '检查编码', visible: true, type: 'input', group: 'basic' },
        { prop: 'planId', label: '关联方案ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'inspectorId', label: '检查人ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'inspectorName', label: '检查人姓名', visible: true, type: 'input', group: 'basic' },
        { prop: 'departmentId', label: '检查科室ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'departmentName', label: '检查科室名称', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'inspectionDate', label: '检查日期', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'inspectionType', label: '检查类型', visible: true, type: 'input', group: 'detail' },
        { prop: 'inspectionResult', label: '检查结果', visible: true, type: 'input', group: 'detail' },
        { prop: 'problemDescription', label: '问题描述', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'suggestion', label: '整改建议', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'status', label: '状态（0待整改 1已整改）', visible: true, type: 'select', group: 'detail' }
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

  return new FieldConfigManager('tumorQcInspection', fieldGroups);
}


// tumorQcPlan字段配置
export function createTumorQcPlanFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'planCode', label: '方案编码', visible: true, type: 'input', group: 'basic' },
        { prop: 'planName', label: '方案名称', visible: true, type: 'input', group: 'basic' },
        { prop: 'planType', label: '方案类型', visible: true, type: 'input', group: 'basic' },
        { prop: 'status', label: '状态（0正常 1停用）', visible: true, type: 'select', group: 'basic' },
        { prop: 'approvalStatus', label: '审批状态（0待审批 1已审批 2驳回）', visible: true, type: 'select', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'description', label: '方案描述', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'startDate', label: '开始日期', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'endDate', label: '结束日期', visible: true, type: 'datetime', group: 'detail' }
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

  return new FieldConfigManager('tumorQcPlan', fieldGroups);
}


// tumorQcRectification字段配置
export function createTumorQcRectificationFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'rectificationCode', label: '整改编码', visible: true, type: 'input', group: 'basic' },
        { prop: 'inspectionId', label: '关联检查ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'responsiblePersonId', label: '负责人ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'responsiblePersonName', label: '负责人姓名', visible: true, type: 'input', group: 'basic' },
        { prop: 'verificationStatus', label: '验证状态（0待验证 1已验证）', visible: true, type: 'select', group: 'basic' },
        { prop: 'status', label: '状态（0进行中 1已完成）', visible: true, type: 'select', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'problemDescription', label: '问题描述', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'rectificationMeasures', label: '整改措施', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'deadline', label: '整改期限', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'completionTime', label: '完成时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'rectificationResult', label: '整改结果', visible: true, type: 'textarea', group: 'detail' }
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

  return new FieldConfigManager('tumorQcRectification', fieldGroups);
}


// tumorQcReport字段配置
export function createTumorQcReportFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'reportCode', label: '报告编码', visible: true, type: 'input', group: 'basic' },
        { prop: 'reportTitle', label: '报告标题', visible: true, type: 'input', group: 'basic' },
        { prop: 'reportType', label: '报告类型', visible: true, type: 'input', group: 'basic' },
        { prop: 'planId', label: '关联方案ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'status', label: '状态（0草稿 1已发布）', visible: true, type: 'select', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'periodStart', label: '报告周期开始', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'periodEnd', label: '报告周期结束', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'reportContent', label: '报告内容', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'summary', label: '报告摘要', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'recommendations', label: '建议措施', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'publishTime', label: '发布时间', visible: true, type: 'datetime', group: 'detail' }
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

  return new FieldConfigManager('tumorQcReport', fieldGroups);
}


// tumorQcResult字段配置
export function createTumorQcResultFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'resultCode', label: '结果编码', visible: true, type: 'input', group: 'basic' },
        { prop: 'planId', label: '关联方案ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'indicatorId', label: '指标ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'indicatorName', label: '指标名称', visible: true, type: 'input', group: 'basic' },
        { prop: 'status', label: '状态（0正常 1异常）', visible: true, type: 'select', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'resultValue', label: '结果值', visible: true, type: 'number', group: 'detail' },
        { prop: 'targetValue', label: '目标值', visible: true, type: 'number', group: 'detail' },
        { prop: 'complianceRate', label: '达标率', visible: true, type: 'number', group: 'detail' },
        { prop: 'analysis', label: '结果分析', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'periodStart', label: '统计周期开始', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'periodEnd', label: '统计周期结束', visible: true, type: 'datetime', group: 'detail' }
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

  return new FieldConfigManager('tumorQcResult', fieldGroups);
}
