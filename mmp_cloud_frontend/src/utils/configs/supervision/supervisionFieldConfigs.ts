import { FieldConfigManager, FieldGroup } from '../fieldConfigManager';

// supervisionExpertGroup字段配置
export function createSupervisionExpertGroupFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'groupCode', label: '专家组编码', visible: true, type: 'input', group: 'basic' },
        { prop: 'groupName', label: '专家组名称', visible: true, type: 'input', group: 'basic' },
        { prop: 'groupType', label: '专家组类型', visible: true, type: 'input', group: 'basic' },
        { prop: 'status', label: '状态', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'specialty', label: '专业领域', visible: true, type: 'input', group: 'detail' },
        { prop: 'description', label: '描述', visible: true, type: 'textarea', group: 'detail' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', visible: true, type: 'select', group: 'system' },
        { prop: 'createDept', label: '创建部门', visible: true, type: 'number', group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'createBy', label: '创建人', visible: true, type: 'number', group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'updateBy', label: '更新人', visible: true, type: 'number', group: 'system' },
        { prop: 'remark', label: '备注', visible: true, type: 'input', group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('supervisionExpertGroup', fieldGroups);
}


// supervisionExpertMember字段配置
export function createSupervisionExpertMemberFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'groupId', label: '专家组ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'expertName', label: '专家姓名', visible: true, type: 'input', group: 'basic' },
        { prop: 'expertTitle', label: '专家职称', visible: true, type: 'input', group: 'basic' },
        { prop: 'status', label: '状态', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'hospital', label: '所在医院', visible: true, type: 'input', group: 'detail' },
        { prop: 'specialty', label: '专业特长', visible: true, type: 'input', group: 'detail' },
        { prop: 'contactInfo', label: '联系方式', visible: true, type: 'input', group: 'detail' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', visible: true, type: 'select', group: 'system' },
        { prop: 'createDept', label: '创建部门', visible: true, type: 'number', group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'createBy', label: '创建人', visible: true, type: 'number', group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'updateBy', label: '更新人', visible: true, type: 'number', group: 'system' },
        { prop: 'remark', label: '备注', visible: true, type: 'input', group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('supervisionExpertMember', fieldGroups);
}


// supervisionForm字段配置
export function createSupervisionFormFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'formCode', label: '表单编码', visible: true, type: 'input', group: 'basic' },
        { prop: 'formName', label: '表单名称', visible: true, type: 'input', group: 'basic' },
        { prop: 'projectId', label: '关联项目ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'status', label: '状态', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'formDescription', label: '表单描述', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'formConfig', label: '表单配置（JSON格式）', visible: true, type: 'textarea', group: 'detail' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', visible: true, type: 'select', group: 'system' },
        { prop: 'createDept', label: '创建部门', visible: true, type: 'number', group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'createBy', label: '创建人', visible: true, type: 'number', group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'updateBy', label: '更新人', visible: true, type: 'number', group: 'system' },
        { prop: 'remark', label: '备注', visible: true, type: 'input', group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('supervisionForm', fieldGroups);
}


// supervisionFormField字段配置
export function createSupervisionFormFieldFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'formId', label: '表单ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'fieldCode', label: '字段编码', visible: true, type: 'input', group: 'basic' },
        { prop: 'fieldName', label: '字段名称', visible: true, type: 'input', group: 'basic' },
        { prop: 'fieldType', label: '字段类型', visible: true, type: 'input', group: 'basic' },
        { prop: 'status', label: '状态', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'fieldConfig', label: '字段配置（JSON格式）', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'requiredFlag', label: '是否必填：0-否，1-是', visible: true, type: 'select', group: 'detail' },
        { prop: 'sortOrder', label: '排序', visible: true, type: 'number', group: 'detail' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', visible: true, type: 'select', group: 'system' },
        { prop: 'createDept', label: '创建部门', visible: true, type: 'number', group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'createBy', label: '创建人', visible: true, type: 'number', group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'updateBy', label: '更新人', visible: true, type: 'number', group: 'system' },
        { prop: 'remark', label: '备注', visible: true, type: 'input', group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('supervisionFormField', fieldGroups);
}


// supervisionIssue字段配置
export function createSupervisionIssueFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'resultId', label: '结果ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'issueType', label: '问题类型', visible: true, type: 'input', group: 'basic' },
        { prop: 'status', label: '状态：pending-待整改，rectifying-整改中，completed-已完成', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'issueDescription', label: '问题描述', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'severity', label: '严重程度', visible: true, type: 'input', group: 'detail' },
        { prop: 'responsiblePerson', label: '责任人', visible: true, type: 'input', group: 'detail' },
        { prop: 'rectificationDeadline', label: '整改期限', visible: true, type: 'date', group: 'detail' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', visible: true, type: 'select', group: 'system' },
        { prop: 'createDept', label: '创建部门', visible: true, type: 'number', group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'createBy', label: '创建人', visible: true, type: 'number', group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'updateBy', label: '更新人', visible: true, type: 'number', group: 'system' },
        { prop: 'remark', label: '备注', visible: true, type: 'input', group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('supervisionIssue', fieldGroups);
}


// supervisionPlan字段配置
export function createSupervisionPlanFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'planCode', label: '计划编码', visible: true, type: 'input', group: 'basic' },
        { prop: 'planName', label: '计划名称', visible: true, type: 'input', group: 'basic' },
        { prop: 'projectId', label: '项目ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'planType', label: '计划类型', visible: true, type: 'input', group: 'basic' },
        { prop: 'status', label: '状态：draft-草稿，published-已发布，executing-执行中，completed-已完成', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'supervisionPeriod', label: '督导周期', visible: true, type: 'input', group: 'detail' },
        { prop: 'startDate', label: '开始日期', visible: true, type: 'date', group: 'detail' },
        { prop: 'endDate', label: '结束日期', visible: true, type: 'date', group: 'detail' },
        { prop: 'responsiblePerson', label: '负责人', visible: true, type: 'input', group: 'detail' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', visible: true, type: 'select', group: 'system' },
        { prop: 'createDept', label: '创建部门', visible: true, type: 'number', group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'createBy', label: '创建人', visible: true, type: 'number', group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'updateBy', label: '更新人', visible: true, type: 'number', group: 'system' },
        { prop: 'remark', label: '备注', visible: true, type: 'input', group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('supervisionPlan', fieldGroups);
}


// supervisionPlanDept字段配置
export function createSupervisionPlanDeptFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'planId', label: '计划ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'deptId', label: '科室ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'status', label: '状态：pending-待督导，completed-已完成', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'supervisionDate', label: '督导日期', visible: true, type: 'date', group: 'detail' },
        { prop: 'supervisor', label: '督导人', visible: true, type: 'input', group: 'detail' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', visible: true, type: 'select', group: 'system' },
        { prop: 'createDept', label: '创建部门', visible: true, type: 'number', group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'createBy', label: '创建人', visible: true, type: 'number', group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'updateBy', label: '更新人', visible: true, type: 'number', group: 'system' },
        { prop: 'remark', label: '备注', visible: true, type: 'input', group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('supervisionPlanDept', fieldGroups);
}


// supervisionPlanForm字段配置
export function createSupervisionPlanFormFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'planId', label: '计划ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'formId', label: '表单ID', visible: true, type: 'number', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'sortOrder', label: '排序', visible: true, type: 'number', group: 'detail' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', visible: true, type: 'select', group: 'system' },
        { prop: 'createDept', label: '创建部门', visible: true, type: 'number', group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'createBy', label: '创建人', visible: true, type: 'number', group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'updateBy', label: '更新人', visible: true, type: 'number', group: 'system' },
        { prop: 'remark', label: '备注', visible: true, type: 'input', group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('supervisionPlanForm', fieldGroups);
}


// supervisionProject字段配置
export function createSupervisionProjectFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'projectCode', label: '项目编码', visible: true, type: 'input', group: 'basic' },
        { prop: 'projectName', label: '项目名称', visible: true, type: 'input', group: 'basic' },
        { prop: 'projectType', label: '项目类型', visible: true, type: 'input', group: 'basic' },
        { prop: 'status', label: '状态：active-启用，inactive-停用', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'projectDescription', label: '项目描述', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'supervisionDepartment', label: '督导部门', visible: true, type: 'input', group: 'detail' },
        { prop: 'responsiblePerson', label: '负责人', visible: true, type: 'input', group: 'detail' },
        { prop: 'contactInfo', label: '联系方式', visible: true, type: 'input', group: 'detail' },
        { prop: 'supervisionFrequency', label: '督导频次', visible: true, type: 'input', group: 'detail' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', visible: true, type: 'select', group: 'system' },
        { prop: 'createDept', label: '创建部门', visible: true, type: 'number', group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'createBy', label: '创建人', visible: true, type: 'number', group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'updateBy', label: '更新人', visible: true, type: 'number', group: 'system' },
        { prop: 'remark', label: '备注', visible: true, type: 'input', group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('supervisionProject', fieldGroups);
}


// supervisionProjectIndicator字段配置
export function createSupervisionProjectIndicatorFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'projectId', label: '项目ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'indicatorCode', label: '指标编码', visible: true, type: 'input', group: 'basic' },
        { prop: 'indicatorName', label: '指标名称', visible: true, type: 'input', group: 'basic' },
        { prop: 'indicatorType', label: '指标类型', visible: true, type: 'input', group: 'basic' },
        { prop: 'status', label: '状态', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'indicatorDescription', label: '指标描述', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'scoringStandard', label: '评分标准', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'weight', label: '权重', visible: true, type: 'number', group: 'detail' },
        { prop: 'maxScore', label: '满分值', visible: true, type: 'number', group: 'detail' },
        { prop: 'sortOrder', label: '排序', visible: true, type: 'number', group: 'detail' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', visible: true, type: 'select', group: 'system' },
        { prop: 'createDept', label: '创建部门', visible: true, type: 'number', group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'createBy', label: '创建人', visible: true, type: 'number', group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'updateBy', label: '更新人', visible: true, type: 'number', group: 'system' },
        { prop: 'remark', label: '备注', visible: true, type: 'input', group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('supervisionProjectIndicator', fieldGroups);
}


// supervisionRectificationProgress字段配置
export function createSupervisionRectificationProgressFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'taskId', label: '任务ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'status', label: '状态', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'progressDescription', label: '进度描述', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'progressPercentage', label: '进度百分比', visible: true, type: 'number', group: 'detail' },
        { prop: 'attachmentUrls', label: '附件URL', visible: true, type: 'textarea', group: 'detail' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', visible: true, type: 'select', group: 'system' },
        { prop: 'createDept', label: '创建部门', visible: true, type: 'number', group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'createBy', label: '创建人', visible: true, type: 'number', group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'updateBy', label: '更新人', visible: true, type: 'number', group: 'system' },
        { prop: 'remark', label: '备注', visible: true, type: 'input', group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('supervisionRectificationProgress', fieldGroups);
}


// supervisionRectificationTask字段配置
export function createSupervisionRectificationTaskFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'issueId', label: '问题ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'status', label: '状态', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'taskDescription', label: '任务描述', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'responsibleDept', label: '责任部门', visible: true, type: 'input', group: 'detail' },
        { prop: 'responsiblePerson', label: '责任人', visible: true, type: 'input', group: 'detail' },
        { prop: 'deadline', label: '截止日期', visible: true, type: 'date', group: 'detail' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', visible: true, type: 'select', group: 'system' },
        { prop: 'createDept', label: '创建部门', visible: true, type: 'number', group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'createBy', label: '创建人', visible: true, type: 'number', group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'updateBy', label: '更新人', visible: true, type: 'number', group: 'system' },
        { prop: 'remark', label: '备注', visible: true, type: 'input', group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('supervisionRectificationTask', fieldGroups);
}


// supervisionResult字段配置
export function createSupervisionResultFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'planId', label: '计划ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'deptId', label: '科室ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'expertGroupId', label: '专家组ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'status', label: '状态：draft-草稿，submitted-已提交，reviewed-已审核', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'supervisionDate', label: '督导日期', visible: true, type: 'date', group: 'detail' },
        { prop: 'supervisor', label: '督导人', visible: true, type: 'input', group: 'detail' },
        { prop: 'totalScore', label: '总分', visible: true, type: 'number', group: 'detail' },
        { prop: 'grade', label: '等级', visible: true, type: 'input', group: 'detail' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', visible: true, type: 'select', group: 'system' },
        { prop: 'createDept', label: '创建部门', visible: true, type: 'number', group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'createBy', label: '创建人', visible: true, type: 'number', group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'updateBy', label: '更新人', visible: true, type: 'number', group: 'system' },
        { prop: 'remark', label: '备注', visible: true, type: 'input', group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('supervisionResult', fieldGroups);
}


// supervisionResultDetail字段配置
export function createSupervisionResultDetailFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'resultId', label: '结果ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'indicatorId', label: '指标ID', visible: true, type: 'number', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'score', label: '得分', visible: true, type: 'number', group: 'detail' },
        { prop: 'remarks', label: '备注', visible: true, type: 'textarea', group: 'detail' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', visible: true, type: 'select', group: 'system' },
        { prop: 'createDept', label: '创建部门', visible: true, type: 'number', group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'createBy', label: '创建人', visible: true, type: 'number', group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'updateBy', label: '更新人', visible: true, type: 'number', group: 'system' },
        { prop: 'remark', label: '备注', visible: true, type: 'input', group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('supervisionResultDetail', fieldGroups);
}


// supervisionReview字段配置
export function createSupervisionReviewFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'taskId', label: '任务ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'status', label: '状态', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'reviewDate', label: '复查日期', visible: true, type: 'date', group: 'detail' },
        { prop: 'reviewer', label: '复查人', visible: true, type: 'input', group: 'detail' },
        { prop: 'reviewResult', label: '复查结果：qualified-合格，unqualified-不合格', visible: true, type: 'input', group: 'detail' },
        { prop: 'reviewOpinion', label: '复查意见', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'nextReviewDate', label: '下次复查日期', visible: true, type: 'date', group: 'detail' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', visible: true, type: 'select', group: 'system' },
        { prop: 'createDept', label: '创建部门', visible: true, type: 'number', group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'createBy', label: '创建人', visible: true, type: 'number', group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'updateBy', label: '更新人', visible: true, type: 'number', group: 'system' },
        { prop: 'remark', label: '备注', visible: true, type: 'input', group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('supervisionReview', fieldGroups);
}
