import { SearchConfigManager, SearchFieldGroup } from '../searchConfigManager';

// supervisionExpertGroup搜索配置
export function createSupervisionExpertGroupSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'groupCode', label: '专家组编码', type: 'input', visible: true, placeholder: '请输入专家组编码' },
        { prop: 'groupName', label: '专家组名称', type: 'input', visible: true, placeholder: '请输入专家组名称' },
        { prop: 'groupType', label: '专家组类型', type: 'input', visible: true, placeholder: '请输入专家组类型' },
        { prop: 'status', label: '状态', type: 'input', visible: false, placeholder: '请输入状态' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'specialty', label: '专业领域', type: 'input', visible: false, placeholder: '请输入专业领域' },
        { prop: 'description', label: '描述', type: 'input', visible: false, placeholder: '请输入描述' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', type: 'select', visible: false, placeholder: '请输入是否删除' },
        { prop: 'createDept', label: '创建部门', type: 'number', visible: false, placeholder: '请输入创建部门' },
        { prop: 'createTime', label: '创建时间', type: 'daterange', visible: false, placeholder: '请输入创建时间', startProp: 'createTimeStart', endProp: 'createTimeEnd' },
        { prop: 'createBy', label: '创建人', type: 'number', visible: false, placeholder: '请输入创建人' },
        { prop: 'updateTime', label: '更新时间', type: 'daterange', visible: false, placeholder: '请输入更新时间', startProp: 'updateTimeStart', endProp: 'updateTimeEnd' },
        { prop: 'updateBy', label: '更新人', type: 'number', visible: false, placeholder: '请输入更新人' },
        { prop: 'remark', label: '备注', type: 'input', visible: false, placeholder: '请输入备注' }
      ]
    }
  ];

  return new SearchConfigManager('supervisionExpertGroup', searchFieldGroups);
}


// supervisionExpertMember搜索配置
export function createSupervisionExpertMemberSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'groupId', label: '专家组ID', type: 'number', visible: true, placeholder: '请输入专家组ID' },
        { prop: 'expertName', label: '专家姓名', type: 'input', visible: true, placeholder: '请输入专家姓名' },
        { prop: 'expertTitle', label: '专家职称', type: 'input', visible: true, placeholder: '请输入专家职称' },
        { prop: 'status', label: '状态', type: 'input', visible: false, placeholder: '请输入状态' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'hospital', label: '所在医院', type: 'input', visible: false, placeholder: '请输入所在医院' },
        { prop: 'specialty', label: '专业特长', type: 'input', visible: false, placeholder: '请输入专业特长' },
        { prop: 'contactInfo', label: '联系方式', type: 'input', visible: false, placeholder: '请输入联系方式' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', type: 'select', visible: false, placeholder: '请输入是否删除' },
        { prop: 'createDept', label: '创建部门', type: 'number', visible: false, placeholder: '请输入创建部门' },
        { prop: 'createTime', label: '创建时间', type: 'daterange', visible: false, placeholder: '请输入创建时间', startProp: 'createTimeStart', endProp: 'createTimeEnd' },
        { prop: 'createBy', label: '创建人', type: 'number', visible: false, placeholder: '请输入创建人' },
        { prop: 'updateTime', label: '更新时间', type: 'daterange', visible: false, placeholder: '请输入更新时间', startProp: 'updateTimeStart', endProp: 'updateTimeEnd' },
        { prop: 'updateBy', label: '更新人', type: 'number', visible: false, placeholder: '请输入更新人' },
        { prop: 'remark', label: '备注', type: 'input', visible: false, placeholder: '请输入备注' }
      ]
    }
  ];

  return new SearchConfigManager('supervisionExpertMember', searchFieldGroups);
}


// supervisionForm搜索配置
export function createSupervisionFormSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'formCode', label: '表单编码', type: 'input', visible: true, placeholder: '请输入表单编码' },
        { prop: 'formName', label: '表单名称', type: 'input', visible: true, placeholder: '请输入表单名称' },
        { prop: 'projectId', label: '关联项目ID', type: 'number', visible: true, placeholder: '请输入关联项目ID' },
        { prop: 'status', label: '状态', type: 'input', visible: false, placeholder: '请输入状态' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'formDescription', label: '表单描述', type: 'input', visible: false, placeholder: '请输入表单描述' },
        { prop: 'formConfig', label: '表单配置（JSON格式）', type: 'input', visible: false, placeholder: '请输入表单配置（JSON格式）' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', type: 'select', visible: false, placeholder: '请输入是否删除' },
        { prop: 'createDept', label: '创建部门', type: 'number', visible: false, placeholder: '请输入创建部门' },
        { prop: 'createTime', label: '创建时间', type: 'daterange', visible: false, placeholder: '请输入创建时间', startProp: 'createTimeStart', endProp: 'createTimeEnd' },
        { prop: 'createBy', label: '创建人', type: 'number', visible: false, placeholder: '请输入创建人' },
        { prop: 'updateTime', label: '更新时间', type: 'daterange', visible: false, placeholder: '请输入更新时间', startProp: 'updateTimeStart', endProp: 'updateTimeEnd' },
        { prop: 'updateBy', label: '更新人', type: 'number', visible: false, placeholder: '请输入更新人' },
        { prop: 'remark', label: '备注', type: 'input', visible: false, placeholder: '请输入备注' }
      ]
    }
  ];

  return new SearchConfigManager('supervisionForm', searchFieldGroups);
}


// supervisionFormField搜索配置
export function createSupervisionFormFieldSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'formId', label: '表单ID', type: 'number', visible: true, placeholder: '请输入表单ID' },
        { prop: 'fieldCode', label: '字段编码', type: 'input', visible: true, placeholder: '请输入字段编码' },
        { prop: 'fieldName', label: '字段名称', type: 'input', visible: true, placeholder: '请输入字段名称' },
        { prop: 'fieldType', label: '字段类型', type: 'input', visible: false, placeholder: '请输入字段类型' },
        { prop: 'status', label: '状态', type: 'input', visible: false, placeholder: '请输入状态' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'fieldConfig', label: '字段配置（JSON格式）', type: 'input', visible: false, placeholder: '请输入字段配置（JSON格式）' },
        { prop: 'requiredFlag', label: '是否必填：0-否，1-是', type: 'select', visible: false, placeholder: '请输入是否必填：0-否，1-是' },
        { prop: 'sortOrder', label: '排序', type: 'number', visible: false, placeholder: '请输入排序' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', type: 'select', visible: false, placeholder: '请输入是否删除' },
        { prop: 'createDept', label: '创建部门', type: 'number', visible: false, placeholder: '请输入创建部门' },
        { prop: 'createTime', label: '创建时间', type: 'daterange', visible: false, placeholder: '请输入创建时间', startProp: 'createTimeStart', endProp: 'createTimeEnd' },
        { prop: 'createBy', label: '创建人', type: 'number', visible: false, placeholder: '请输入创建人' },
        { prop: 'updateTime', label: '更新时间', type: 'daterange', visible: false, placeholder: '请输入更新时间', startProp: 'updateTimeStart', endProp: 'updateTimeEnd' },
        { prop: 'updateBy', label: '更新人', type: 'number', visible: false, placeholder: '请输入更新人' },
        { prop: 'remark', label: '备注', type: 'input', visible: false, placeholder: '请输入备注' }
      ]
    }
  ];

  return new SearchConfigManager('supervisionFormField', searchFieldGroups);
}


// supervisionIssue搜索配置
export function createSupervisionIssueSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'resultId', label: '结果ID', type: 'number', visible: true, placeholder: '请输入结果ID' },
        { prop: 'issueType', label: '问题类型', type: 'input', visible: true, placeholder: '请输入问题类型' },
        { prop: 'status', label: '状态：pending-待整改，rectifying-整改中，completed-已完成', type: 'input', visible: true, placeholder: '请输入状态：pending-待整改，rectifying-整改中，completed-已完成' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'issueDescription', label: '问题描述', type: 'input', visible: false, placeholder: '请输入问题描述' },
        { prop: 'severity', label: '严重程度', type: 'input', visible: false, placeholder: '请输入严重程度' },
        { prop: 'responsiblePerson', label: '责任人', type: 'input', visible: false, placeholder: '请输入责任人' },
        { prop: 'rectificationDeadline', label: '整改期限', type: 'daterange', visible: false, placeholder: '请输入整改期限', startProp: 'rectificationDeadlineStart', endProp: 'rectificationDeadlineEnd' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', type: 'select', visible: false, placeholder: '请输入是否删除' },
        { prop: 'createDept', label: '创建部门', type: 'number', visible: false, placeholder: '请输入创建部门' },
        { prop: 'createTime', label: '创建时间', type: 'daterange', visible: false, placeholder: '请输入创建时间', startProp: 'createTimeStart', endProp: 'createTimeEnd' },
        { prop: 'createBy', label: '创建人', type: 'number', visible: false, placeholder: '请输入创建人' },
        { prop: 'updateTime', label: '更新时间', type: 'daterange', visible: false, placeholder: '请输入更新时间', startProp: 'updateTimeStart', endProp: 'updateTimeEnd' },
        { prop: 'updateBy', label: '更新人', type: 'number', visible: false, placeholder: '请输入更新人' },
        { prop: 'remark', label: '备注', type: 'input', visible: false, placeholder: '请输入备注' }
      ]
    }
  ];

  return new SearchConfigManager('supervisionIssue', searchFieldGroups);
}


// supervisionPlan搜索配置
export function createSupervisionPlanSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'planCode', label: '计划编码', type: 'input', visible: true, placeholder: '请输入计划编码' },
        { prop: 'planName', label: '计划名称', type: 'input', visible: true, placeholder: '请输入计划名称' },
        { prop: 'projectId', label: '项目ID', type: 'number', visible: true, placeholder: '请输入项目ID' },
        { prop: 'planType', label: '计划类型', type: 'input', visible: false, placeholder: '请输入计划类型' },
        { prop: 'status', label: '状态：draft-草稿，published-已发布，executing-执行中，completed-已完成', type: 'input', visible: false, placeholder: '请输入状态：draft-草稿，published-已发布，executing-执行中，completed-已完成' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'supervisionPeriod', label: '督导周期', type: 'input', visible: false, placeholder: '请输入督导周期' },
        { prop: 'startDate', label: '开始日期', type: 'daterange', visible: false, placeholder: '请输入开始日期', startProp: 'startDateStart', endProp: 'startDateEnd' },
        { prop: 'endDate', label: '结束日期', type: 'daterange', visible: false, placeholder: '请输入结束日期', startProp: 'endDateStart', endProp: 'endDateEnd' },
        { prop: 'responsiblePerson', label: '负责人', type: 'input', visible: false, placeholder: '请输入负责人' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', type: 'select', visible: false, placeholder: '请输入是否删除' },
        { prop: 'createDept', label: '创建部门', type: 'number', visible: false, placeholder: '请输入创建部门' },
        { prop: 'createTime', label: '创建时间', type: 'daterange', visible: false, placeholder: '请输入创建时间', startProp: 'createTimeStart', endProp: 'createTimeEnd' },
        { prop: 'createBy', label: '创建人', type: 'number', visible: false, placeholder: '请输入创建人' },
        { prop: 'updateTime', label: '更新时间', type: 'daterange', visible: false, placeholder: '请输入更新时间', startProp: 'updateTimeStart', endProp: 'updateTimeEnd' },
        { prop: 'updateBy', label: '更新人', type: 'number', visible: false, placeholder: '请输入更新人' },
        { prop: 'remark', label: '备注', type: 'input', visible: false, placeholder: '请输入备注' }
      ]
    }
  ];

  return new SearchConfigManager('supervisionPlan', searchFieldGroups);
}


// supervisionPlanDept搜索配置
export function createSupervisionPlanDeptSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'planId', label: '计划ID', type: 'number', visible: true, placeholder: '请输入计划ID' },
        { prop: 'deptId', label: '科室ID', type: 'number', visible: true, placeholder: '请输入科室ID' },
        { prop: 'status', label: '状态：pending-待督导，completed-已完成', type: 'input', visible: true, placeholder: '请输入状态：pending-待督导，completed-已完成' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'supervisionDate', label: '督导日期', type: 'daterange', visible: false, placeholder: '请输入督导日期', startProp: 'supervisionDateStart', endProp: 'supervisionDateEnd' },
        { prop: 'supervisor', label: '督导人', type: 'input', visible: false, placeholder: '请输入督导人' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', type: 'select', visible: false, placeholder: '请输入是否删除' },
        { prop: 'createDept', label: '创建部门', type: 'number', visible: false, placeholder: '请输入创建部门' },
        { prop: 'createTime', label: '创建时间', type: 'daterange', visible: false, placeholder: '请输入创建时间', startProp: 'createTimeStart', endProp: 'createTimeEnd' },
        { prop: 'createBy', label: '创建人', type: 'number', visible: false, placeholder: '请输入创建人' },
        { prop: 'updateTime', label: '更新时间', type: 'daterange', visible: false, placeholder: '请输入更新时间', startProp: 'updateTimeStart', endProp: 'updateTimeEnd' },
        { prop: 'updateBy', label: '更新人', type: 'number', visible: false, placeholder: '请输入更新人' },
        { prop: 'remark', label: '备注', type: 'input', visible: false, placeholder: '请输入备注' }
      ]
    }
  ];

  return new SearchConfigManager('supervisionPlanDept', searchFieldGroups);
}


// supervisionPlanForm搜索配置
export function createSupervisionPlanFormSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'planId', label: '计划ID', type: 'number', visible: true, placeholder: '请输入计划ID' },
        { prop: 'formId', label: '表单ID', type: 'number', visible: true, placeholder: '请输入表单ID' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'sortOrder', label: '排序', type: 'number', visible: true, placeholder: '请输入排序' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', type: 'select', visible: false, placeholder: '请输入是否删除' },
        { prop: 'createDept', label: '创建部门', type: 'number', visible: false, placeholder: '请输入创建部门' },
        { prop: 'createTime', label: '创建时间', type: 'daterange', visible: false, placeholder: '请输入创建时间', startProp: 'createTimeStart', endProp: 'createTimeEnd' },
        { prop: 'createBy', label: '创建人', type: 'number', visible: false, placeholder: '请输入创建人' },
        { prop: 'updateTime', label: '更新时间', type: 'daterange', visible: false, placeholder: '请输入更新时间', startProp: 'updateTimeStart', endProp: 'updateTimeEnd' },
        { prop: 'updateBy', label: '更新人', type: 'number', visible: false, placeholder: '请输入更新人' },
        { prop: 'remark', label: '备注', type: 'input', visible: false, placeholder: '请输入备注' }
      ]
    }
  ];

  return new SearchConfigManager('supervisionPlanForm', searchFieldGroups);
}


// supervisionProject搜索配置
export function createSupervisionProjectSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'projectCode', label: '项目编码', type: 'input', visible: true, placeholder: '请输入项目编码' },
        { prop: 'projectName', label: '项目名称', type: 'input', visible: true, placeholder: '请输入项目名称' },
        { prop: 'projectType', label: '项目类型', type: 'input', visible: true, placeholder: '请输入项目类型' },
        { prop: 'status', label: '状态：active-启用，inactive-停用', type: 'input', visible: false, placeholder: '请输入状态：active-启用，inactive-停用' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'projectDescription', label: '项目描述', type: 'input', visible: false, placeholder: '请输入项目描述' },
        { prop: 'supervisionDepartment', label: '督导部门', type: 'input', visible: false, placeholder: '请输入督导部门' },
        { prop: 'responsiblePerson', label: '负责人', type: 'input', visible: false, placeholder: '请输入负责人' },
        { prop: 'contactInfo', label: '联系方式', type: 'input', visible: false, placeholder: '请输入联系方式' },
        { prop: 'supervisionFrequency', label: '督导频次', type: 'input', visible: false, placeholder: '请输入督导频次' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', type: 'select', visible: false, placeholder: '请输入是否删除' },
        { prop: 'createDept', label: '创建部门', type: 'number', visible: false, placeholder: '请输入创建部门' },
        { prop: 'createTime', label: '创建时间', type: 'daterange', visible: false, placeholder: '请输入创建时间', startProp: 'createTimeStart', endProp: 'createTimeEnd' },
        { prop: 'createBy', label: '创建人', type: 'number', visible: false, placeholder: '请输入创建人' },
        { prop: 'updateTime', label: '更新时间', type: 'daterange', visible: false, placeholder: '请输入更新时间', startProp: 'updateTimeStart', endProp: 'updateTimeEnd' },
        { prop: 'updateBy', label: '更新人', type: 'number', visible: false, placeholder: '请输入更新人' },
        { prop: 'remark', label: '备注', type: 'input', visible: false, placeholder: '请输入备注' }
      ]
    }
  ];

  return new SearchConfigManager('supervisionProject', searchFieldGroups);
}


// supervisionProjectIndicator搜索配置
export function createSupervisionProjectIndicatorSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'projectId', label: '项目ID', type: 'number', visible: true, placeholder: '请输入项目ID' },
        { prop: 'indicatorCode', label: '指标编码', type: 'input', visible: true, placeholder: '请输入指标编码' },
        { prop: 'indicatorName', label: '指标名称', type: 'input', visible: true, placeholder: '请输入指标名称' },
        { prop: 'indicatorType', label: '指标类型', type: 'input', visible: false, placeholder: '请输入指标类型' },
        { prop: 'status', label: '状态', type: 'input', visible: false, placeholder: '请输入状态' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'indicatorDescription', label: '指标描述', type: 'input', visible: false, placeholder: '请输入指标描述' },
        { prop: 'scoringStandard', label: '评分标准', type: 'input', visible: false, placeholder: '请输入评分标准' },
        { prop: 'weight', label: '权重', type: 'number', visible: false, placeholder: '请输入权重' },
        { prop: 'maxScore', label: '满分值', type: 'number', visible: false, placeholder: '请输入满分值' },
        { prop: 'sortOrder', label: '排序', type: 'number', visible: false, placeholder: '请输入排序' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', type: 'select', visible: false, placeholder: '请输入是否删除' },
        { prop: 'createDept', label: '创建部门', type: 'number', visible: false, placeholder: '请输入创建部门' },
        { prop: 'createTime', label: '创建时间', type: 'daterange', visible: false, placeholder: '请输入创建时间', startProp: 'createTimeStart', endProp: 'createTimeEnd' },
        { prop: 'createBy', label: '创建人', type: 'number', visible: false, placeholder: '请输入创建人' },
        { prop: 'updateTime', label: '更新时间', type: 'daterange', visible: false, placeholder: '请输入更新时间', startProp: 'updateTimeStart', endProp: 'updateTimeEnd' },
        { prop: 'updateBy', label: '更新人', type: 'number', visible: false, placeholder: '请输入更新人' },
        { prop: 'remark', label: '备注', type: 'input', visible: false, placeholder: '请输入备注' }
      ]
    }
  ];

  return new SearchConfigManager('supervisionProjectIndicator', searchFieldGroups);
}


// supervisionRectificationProgress搜索配置
export function createSupervisionRectificationProgressSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'taskId', label: '任务ID', type: 'number', visible: true, placeholder: '请输入任务ID' },
        { prop: 'status', label: '状态', type: 'input', visible: true, placeholder: '请输入状态' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'progressDescription', label: '进度描述', type: 'input', visible: true, placeholder: '请输入进度描述' },
        { prop: 'progressPercentage', label: '进度百分比', type: 'number', visible: false, placeholder: '请输入进度百分比' },
        { prop: 'attachmentUrls', label: '附件URL', type: 'input', visible: false, placeholder: '请输入附件URL' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', type: 'select', visible: false, placeholder: '请输入是否删除' },
        { prop: 'createDept', label: '创建部门', type: 'number', visible: false, placeholder: '请输入创建部门' },
        { prop: 'createTime', label: '创建时间', type: 'daterange', visible: false, placeholder: '请输入创建时间', startProp: 'createTimeStart', endProp: 'createTimeEnd' },
        { prop: 'createBy', label: '创建人', type: 'number', visible: false, placeholder: '请输入创建人' },
        { prop: 'updateTime', label: '更新时间', type: 'daterange', visible: false, placeholder: '请输入更新时间', startProp: 'updateTimeStart', endProp: 'updateTimeEnd' },
        { prop: 'updateBy', label: '更新人', type: 'number', visible: false, placeholder: '请输入更新人' },
        { prop: 'remark', label: '备注', type: 'input', visible: false, placeholder: '请输入备注' }
      ]
    }
  ];

  return new SearchConfigManager('supervisionRectificationProgress', searchFieldGroups);
}


// supervisionRectificationTask搜索配置
export function createSupervisionRectificationTaskSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'issueId', label: '问题ID', type: 'number', visible: true, placeholder: '请输入问题ID' },
        { prop: 'status', label: '状态', type: 'input', visible: true, placeholder: '请输入状态' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'taskDescription', label: '任务描述', type: 'input', visible: true, placeholder: '请输入任务描述' },
        { prop: 'responsibleDept', label: '责任部门', type: 'input', visible: false, placeholder: '请输入责任部门' },
        { prop: 'responsiblePerson', label: '责任人', type: 'input', visible: false, placeholder: '请输入责任人' },
        { prop: 'deadline', label: '截止日期', type: 'daterange', visible: false, placeholder: '请输入截止日期', startProp: 'deadlineStart', endProp: 'deadlineEnd' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', type: 'select', visible: false, placeholder: '请输入是否删除' },
        { prop: 'createDept', label: '创建部门', type: 'number', visible: false, placeholder: '请输入创建部门' },
        { prop: 'createTime', label: '创建时间', type: 'daterange', visible: false, placeholder: '请输入创建时间', startProp: 'createTimeStart', endProp: 'createTimeEnd' },
        { prop: 'createBy', label: '创建人', type: 'number', visible: false, placeholder: '请输入创建人' },
        { prop: 'updateTime', label: '更新时间', type: 'daterange', visible: false, placeholder: '请输入更新时间', startProp: 'updateTimeStart', endProp: 'updateTimeEnd' },
        { prop: 'updateBy', label: '更新人', type: 'number', visible: false, placeholder: '请输入更新人' },
        { prop: 'remark', label: '备注', type: 'input', visible: false, placeholder: '请输入备注' }
      ]
    }
  ];

  return new SearchConfigManager('supervisionRectificationTask', searchFieldGroups);
}


// supervisionResult搜索配置
export function createSupervisionResultSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'planId', label: '计划ID', type: 'number', visible: true, placeholder: '请输入计划ID' },
        { prop: 'deptId', label: '科室ID', type: 'number', visible: true, placeholder: '请输入科室ID' },
        { prop: 'expertGroupId', label: '专家组ID', type: 'number', visible: true, placeholder: '请输入专家组ID' },
        { prop: 'status', label: '状态：draft-草稿，submitted-已提交，reviewed-已审核', type: 'input', visible: false, placeholder: '请输入状态：draft-草稿，submitted-已提交，reviewed-已审核' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'supervisionDate', label: '督导日期', type: 'daterange', visible: false, placeholder: '请输入督导日期', startProp: 'supervisionDateStart', endProp: 'supervisionDateEnd' },
        { prop: 'supervisor', label: '督导人', type: 'input', visible: false, placeholder: '请输入督导人' },
        { prop: 'totalScore', label: '总分', type: 'number', visible: false, placeholder: '请输入总分' },
        { prop: 'grade', label: '等级', type: 'input', visible: false, placeholder: '请输入等级' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', type: 'select', visible: false, placeholder: '请输入是否删除' },
        { prop: 'createDept', label: '创建部门', type: 'number', visible: false, placeholder: '请输入创建部门' },
        { prop: 'createTime', label: '创建时间', type: 'daterange', visible: false, placeholder: '请输入创建时间', startProp: 'createTimeStart', endProp: 'createTimeEnd' },
        { prop: 'createBy', label: '创建人', type: 'number', visible: false, placeholder: '请输入创建人' },
        { prop: 'updateTime', label: '更新时间', type: 'daterange', visible: false, placeholder: '请输入更新时间', startProp: 'updateTimeStart', endProp: 'updateTimeEnd' },
        { prop: 'updateBy', label: '更新人', type: 'number', visible: false, placeholder: '请输入更新人' },
        { prop: 'remark', label: '备注', type: 'input', visible: false, placeholder: '请输入备注' }
      ]
    }
  ];

  return new SearchConfigManager('supervisionResult', searchFieldGroups);
}


// supervisionResultDetail搜索配置
export function createSupervisionResultDetailSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'resultId', label: '结果ID', type: 'number', visible: true, placeholder: '请输入结果ID' },
        { prop: 'indicatorId', label: '指标ID', type: 'number', visible: true, placeholder: '请输入指标ID' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'score', label: '得分', type: 'number', visible: true, placeholder: '请输入得分' },
        { prop: 'remarks', label: '备注', type: 'input', visible: false, placeholder: '请输入备注' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', type: 'select', visible: false, placeholder: '请输入是否删除' },
        { prop: 'createDept', label: '创建部门', type: 'number', visible: false, placeholder: '请输入创建部门' },
        { prop: 'createTime', label: '创建时间', type: 'daterange', visible: false, placeholder: '请输入创建时间', startProp: 'createTimeStart', endProp: 'createTimeEnd' },
        { prop: 'createBy', label: '创建人', type: 'number', visible: false, placeholder: '请输入创建人' },
        { prop: 'updateTime', label: '更新时间', type: 'daterange', visible: false, placeholder: '请输入更新时间', startProp: 'updateTimeStart', endProp: 'updateTimeEnd' },
        { prop: 'updateBy', label: '更新人', type: 'number', visible: false, placeholder: '请输入更新人' },
        { prop: 'remark', label: '备注', type: 'input', visible: false, placeholder: '请输入备注' }
      ]
    }
  ];

  return new SearchConfigManager('supervisionResultDetail', searchFieldGroups);
}


// supervisionReview搜索配置
export function createSupervisionReviewSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'taskId', label: '任务ID', type: 'number', visible: true, placeholder: '请输入任务ID' },
        { prop: 'status', label: '状态', type: 'input', visible: true, placeholder: '请输入状态' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'reviewDate', label: '复查日期', type: 'daterange', visible: true, placeholder: '请输入复查日期', startProp: 'reviewDateStart', endProp: 'reviewDateEnd' },
        { prop: 'reviewer', label: '复查人', type: 'input', visible: false, placeholder: '请输入复查人' },
        { prop: 'reviewResult', label: '复查结果：qualified-合格，unqualified-不合格', type: 'input', visible: false, placeholder: '请输入复查结果：qualified-合格，unqualified-不合格' },
        { prop: 'reviewOpinion', label: '复查意见', type: 'input', visible: false, placeholder: '请输入复查意见' },
        { prop: 'nextReviewDate', label: '下次复查日期', type: 'daterange', visible: false, placeholder: '请输入下次复查日期', startProp: 'nextReviewDateStart', endProp: 'nextReviewDateEnd' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', type: 'select', visible: false, placeholder: '请输入是否删除' },
        { prop: 'createDept', label: '创建部门', type: 'number', visible: false, placeholder: '请输入创建部门' },
        { prop: 'createTime', label: '创建时间', type: 'daterange', visible: false, placeholder: '请输入创建时间', startProp: 'createTimeStart', endProp: 'createTimeEnd' },
        { prop: 'createBy', label: '创建人', type: 'number', visible: false, placeholder: '请输入创建人' },
        { prop: 'updateTime', label: '更新时间', type: 'daterange', visible: false, placeholder: '请输入更新时间', startProp: 'updateTimeStart', endProp: 'updateTimeEnd' },
        { prop: 'updateBy', label: '更新人', type: 'number', visible: false, placeholder: '请输入更新人' },
        { prop: 'remark', label: '备注', type: 'input', visible: false, placeholder: '请输入备注' }
      ]
    }
  ];

  return new SearchConfigManager('supervisionReview', searchFieldGroups);
}
