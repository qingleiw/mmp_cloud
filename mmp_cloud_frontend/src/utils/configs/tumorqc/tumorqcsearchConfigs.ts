import { SearchConfigManager, SearchFieldGroup } from '../searchConfigManager';

// tumorQcIndicatorConfig搜索配置
export function createTumorQcIndicatorConfigSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'indicatorCode', label: '指标编码', type: 'input', visible: true, placeholder: '请输入指标编码' },
        { prop: 'indicatorName', label: '指标名称', type: 'input', visible: true, placeholder: '请输入指标名称' },
        { prop: 'tumorType', label: '肿瘤类型', type: 'input', visible: true, placeholder: '请输入肿瘤类型' },
        { prop: 'indicatorType', label: '指标类型 强制性/推荐性', type: 'input', visible: false, placeholder: '请输入指标类型 强制性/推荐性' },
        { prop: 'policyLevel', label: '政策级别 国家级/省级/市级', type: 'input', visible: false, placeholder: '请输入政策级别 国家级/省级/市级' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'indicatorCategory', label: '指标分类', type: 'input', visible: false, placeholder: '请输入指标分类' },
        { prop: 'calculationFormula', label: '计算公式', type: 'input', visible: false, placeholder: '请输入计算公式' },
        { prop: 'dataSource', label: '数据来源', type: 'input', visible: false, placeholder: '请输入数据来源' },
        { prop: 'collectionFrequency', label: '采集频率 实时/每日/每周/每月', type: 'input', visible: false, placeholder: '请输入采集频率 实时/每日/每周/每月' },
        { prop: 'standardValue', label: '标准值', type: 'input', visible: false, placeholder: '请输入标准值' },
        { prop: 'targetValue', label: '目标值', type: 'input', visible: false, placeholder: '请输入目标值' },
        { prop: 'version', label: '指标版本', type: 'input', visible: false, placeholder: '请输入指标版本' },
        { prop: 'effectiveDate', label: '生效日期', type: 'daterange', visible: false, placeholder: '请输入生效日期', startProp: 'effectiveDateStart', endProp: 'effectiveDateEnd' },
        { prop: 'policySource', label: '政策来源', type: 'input', visible: false, placeholder: '请输入政策来源' },
        { prop: 'isEnabled', label: '是否启用', type: 'number', visible: false, placeholder: '请输入是否启用' }
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

  return new SearchConfigManager('tumorQcIndicatorConfig', searchFieldGroups);
}


// tumorQcIndicatorDetail搜索配置
export function createTumorQcIndicatorDetailSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'recordId', label: '监测记录ID', type: 'number', visible: true, placeholder: '请输入监测记录ID' },
        { prop: 'indicatorId', label: '指标ID', type: 'number', visible: true, placeholder: '请输入指标ID' },
        { prop: 'patientId', label: '患者ID', type: 'number', visible: true, placeholder: '请输入患者ID' },
        { prop: 'patientName', label: '患者姓名', type: 'input', visible: false, placeholder: '请输入患者姓名' },
        { prop: 'visitNo', label: '就诊号', type: 'input', visible: false, placeholder: '请输入就诊号' },
        { prop: 'diagnosis', label: '诊断', type: 'input', visible: false, placeholder: '请输入诊断' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'indicatorResult', label: '指标结果 达标/不达标/不适用', type: 'input', visible: false, placeholder: '请输入指标结果 达标/不达标/不适用' },
        { prop: 'resultDescription', label: '结果说明', type: 'input', visible: false, placeholder: '请输入结果说明' },
        { prop: 'relatedData', label: '相关数据JSON', type: 'input', visible: false, placeholder: '请输入相关数据JSON' }
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

  return new SearchConfigManager('tumorQcIndicatorDetail', searchFieldGroups);
}


// tumorQcIndicatorRecord搜索配置
export function createTumorQcIndicatorRecordSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'departmentId', label: '科室ID', type: 'number', visible: true, placeholder: '请输入科室ID' },
        { prop: 'departmentName', label: '科室名称', type: 'input', visible: true, placeholder: '请输入科室名称' },
        { prop: 'indicatorId', label: '指标ID', type: 'number', visible: true, placeholder: '请输入指标ID' },
        { prop: 'indicatorCode', label: '指标编码', type: 'input', visible: false, placeholder: '请输入指标编码' },
        { prop: 'indicatorName', label: '指标名称', type: 'input', visible: false, placeholder: '请输入指标名称' },
        { prop: 'denominator', label: '分母', type: 'number', visible: false, placeholder: '请输入分母' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'recordDate', label: '记录日期', type: 'daterange', visible: false, placeholder: '请输入记录日期', startProp: 'recordDateStart', endProp: 'recordDateEnd' },
        { prop: 'calculationCycle', label: '计算周期', type: 'input', visible: false, placeholder: '请输入计算周期' },
        { prop: 'numerator', label: '分子', type: 'number', visible: false, placeholder: '请输入分子' },
        { prop: 'indicatorValue', label: '指标值', type: 'number', visible: false, placeholder: '请输入指标值' },
        { prop: 'targetValue', label: '目标值', type: 'input', visible: false, placeholder: '请输入目标值' },
        { prop: 'complianceStatus', label: '达标状态 达标/不达标', type: 'input', visible: false, placeholder: '请输入达标状态 达标/不达标' },
        { prop: 'completionRate', label: '完成率', type: 'number', visible: false, placeholder: '请输入完成率' },
        { prop: 'rankInHospital', label: '院内排名', type: 'number', visible: false, placeholder: '请输入院内排名' },
        { prop: 'trendDirection', label: '趋势方向', type: 'input', visible: false, placeholder: '请输入趋势方向' },
        { prop: 'isAbnormal', label: '是否异常 1-是 0-否', type: 'number', visible: false, placeholder: '请输入是否异常 1-是 0-否' },
        { prop: 'dataSource', label: '数据来源说明', type: 'input', visible: false, placeholder: '请输入数据来源说明' },
        { prop: 'isManual', label: '是否人工录入 1-是 0-否', type: 'number', visible: false, placeholder: '请输入是否人工录入 1-是 0-否' }
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

  return new SearchConfigManager('tumorQcIndicatorRecord', searchFieldGroups);
}


// tumorQcInspection搜索配置
export function createTumorQcInspectionSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'inspectionCode', label: '检查编码', type: 'input', visible: true, placeholder: '请输入检查编码' },
        { prop: 'planId', label: '关联方案ID', type: 'number', visible: true, placeholder: '请输入关联方案ID' },
        { prop: 'inspectorId', label: '检查人ID', type: 'number', visible: true, placeholder: '请输入检查人ID' },
        { prop: 'inspectorName', label: '检查人姓名', type: 'input', visible: false, placeholder: '请输入检查人姓名' },
        { prop: 'departmentId', label: '检查科室ID', type: 'number', visible: false, placeholder: '请输入检查科室ID' },
        { prop: 'departmentName', label: '检查科室名称', type: 'input', visible: false, placeholder: '请输入检查科室名称' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'inspectionDate', label: '检查日期', type: 'daterange', visible: false, placeholder: '请输入检查日期', startProp: 'inspectionDateStart', endProp: 'inspectionDateEnd' },
        { prop: 'inspectionType', label: '检查类型', type: 'input', visible: false, placeholder: '请输入检查类型' },
        { prop: 'inspectionResult', label: '检查结果', type: 'input', visible: false, placeholder: '请输入检查结果' },
        { prop: 'problemDescription', label: '问题描述', type: 'input', visible: false, placeholder: '请输入问题描述' },
        { prop: 'suggestion', label: '整改建议', type: 'input', visible: false, placeholder: '请输入整改建议' },
        { prop: 'status', label: '状态（0待整改 1已整改）', type: 'select', visible: false, placeholder: '请输入状态（0待整改 1已整改）' }
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

  return new SearchConfigManager('tumorQcInspection', searchFieldGroups);
}


// tumorQcPlan搜索配置
export function createTumorQcPlanSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'planCode', label: '方案编码', type: 'input', visible: true, placeholder: '请输入方案编码' },
        { prop: 'planName', label: '方案名称', type: 'input', visible: true, placeholder: '请输入方案名称' },
        { prop: 'planType', label: '方案类型', type: 'input', visible: true, placeholder: '请输入方案类型' },
        { prop: 'status', label: '状态（0正常 1停用）', type: 'select', visible: false, placeholder: '请输入状态（0正常 1停用）' },
        { prop: 'approvalStatus', label: '审批状态（0待审批 1已审批 2驳回）', type: 'select', visible: false, placeholder: '请输入审批状态（0待审批 1已审批 2驳回）' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'description', label: '方案描述', type: 'input', visible: false, placeholder: '请输入方案描述' },
        { prop: 'startDate', label: '开始日期', type: 'daterange', visible: false, placeholder: '请输入开始日期', startProp: 'startDateStart', endProp: 'startDateEnd' },
        { prop: 'endDate', label: '结束日期', type: 'daterange', visible: false, placeholder: '请输入结束日期', startProp: 'endDateStart', endProp: 'endDateEnd' }
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

  return new SearchConfigManager('tumorQcPlan', searchFieldGroups);
}


// tumorQcRectification搜索配置
export function createTumorQcRectificationSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'rectificationCode', label: '整改编码', type: 'input', visible: true, placeholder: '请输入整改编码' },
        { prop: 'inspectionId', label: '关联检查ID', type: 'number', visible: true, placeholder: '请输入关联检查ID' },
        { prop: 'responsiblePersonId', label: '负责人ID', type: 'number', visible: true, placeholder: '请输入负责人ID' },
        { prop: 'responsiblePersonName', label: '负责人姓名', type: 'input', visible: false, placeholder: '请输入负责人姓名' },
        { prop: 'verificationStatus', label: '验证状态（0待验证 1已验证）', type: 'select', visible: false, placeholder: '请输入验证状态（0待验证 1已验证）' },
        { prop: 'status', label: '状态（0进行中 1已完成）', type: 'select', visible: false, placeholder: '请输入状态（0进行中 1已完成）' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'problemDescription', label: '问题描述', type: 'input', visible: false, placeholder: '请输入问题描述' },
        { prop: 'rectificationMeasures', label: '整改措施', type: 'input', visible: false, placeholder: '请输入整改措施' },
        { prop: 'deadline', label: '整改期限', type: 'daterange', visible: false, placeholder: '请输入整改期限', startProp: 'deadlineStart', endProp: 'deadlineEnd' },
        { prop: 'completionTime', label: '完成时间', type: 'daterange', visible: false, placeholder: '请输入完成时间', startProp: 'completionTimeStart', endProp: 'completionTimeEnd' },
        { prop: 'rectificationResult', label: '整改结果', type: 'input', visible: false, placeholder: '请输入整改结果' }
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

  return new SearchConfigManager('tumorQcRectification', searchFieldGroups);
}


// tumorQcReport搜索配置
export function createTumorQcReportSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'reportCode', label: '报告编码', type: 'input', visible: true, placeholder: '请输入报告编码' },
        { prop: 'reportTitle', label: '报告标题', type: 'input', visible: true, placeholder: '请输入报告标题' },
        { prop: 'reportType', label: '报告类型', type: 'input', visible: true, placeholder: '请输入报告类型' },
        { prop: 'planId', label: '关联方案ID', type: 'number', visible: false, placeholder: '请输入关联方案ID' },
        { prop: 'status', label: '状态（0草稿 1已发布）', type: 'select', visible: false, placeholder: '请输入状态（0草稿 1已发布）' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'periodStart', label: '报告周期开始', type: 'daterange', visible: false, placeholder: '请输入报告周期开始', startProp: 'periodStartStart', endProp: 'periodStartEnd' },
        { prop: 'periodEnd', label: '报告周期结束', type: 'daterange', visible: false, placeholder: '请输入报告周期结束', startProp: 'periodEndStart', endProp: 'periodEndEnd' },
        { prop: 'reportContent', label: '报告内容', type: 'input', visible: false, placeholder: '请输入报告内容' },
        { prop: 'summary', label: '报告摘要', type: 'input', visible: false, placeholder: '请输入报告摘要' },
        { prop: 'recommendations', label: '建议措施', type: 'input', visible: false, placeholder: '请输入建议措施' },
        { prop: 'publishTime', label: '发布时间', type: 'daterange', visible: false, placeholder: '请输入发布时间', startProp: 'publishTimeStart', endProp: 'publishTimeEnd' }
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

  return new SearchConfigManager('tumorQcReport', searchFieldGroups);
}


// tumorQcResult搜索配置
export function createTumorQcResultSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'resultCode', label: '结果编码', type: 'input', visible: true, placeholder: '请输入结果编码' },
        { prop: 'planId', label: '关联方案ID', type: 'number', visible: true, placeholder: '请输入关联方案ID' },
        { prop: 'indicatorId', label: '指标ID', type: 'number', visible: true, placeholder: '请输入指标ID' },
        { prop: 'indicatorName', label: '指标名称', type: 'input', visible: false, placeholder: '请输入指标名称' },
        { prop: 'status', label: '状态（0正常 1异常）', type: 'select', visible: false, placeholder: '请输入状态（0正常 1异常）' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'resultValue', label: '结果值', type: 'number', visible: false, placeholder: '请输入结果值' },
        { prop: 'targetValue', label: '目标值', type: 'number', visible: false, placeholder: '请输入目标值' },
        { prop: 'complianceRate', label: '达标率', type: 'number', visible: false, placeholder: '请输入达标率' },
        { prop: 'analysis', label: '结果分析', type: 'input', visible: false, placeholder: '请输入结果分析' },
        { prop: 'periodStart', label: '统计周期开始', type: 'daterange', visible: false, placeholder: '请输入统计周期开始', startProp: 'periodStartStart', endProp: 'periodStartEnd' },
        { prop: 'periodEnd', label: '统计周期结束', type: 'daterange', visible: false, placeholder: '请输入统计周期结束', startProp: 'periodEndStart', endProp: 'periodEndEnd' }
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

  return new SearchConfigManager('tumorQcResult', searchFieldGroups);
}
