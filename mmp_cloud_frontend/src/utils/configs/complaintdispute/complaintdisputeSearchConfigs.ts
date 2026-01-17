import { SearchConfigManager, SearchFieldGroup } from '../searchConfigManager';

// complaintDispute搜索配置
export function createComplaintDisputeSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'complaintNo', label: '投诉编号', type: 'input', visible: true, placeholder: '请输入投诉编号' },
        { prop: 'complaintType', label: '投诉类型', type: 'input', visible: true, placeholder: '请输入投诉类型' },
        { prop: 'complainantName', label: '投诉人姓名', type: 'input', visible: true, placeholder: '请输入投诉人姓名' },
        { prop: 'patientName', label: '患者姓名', type: 'input', visible: false, placeholder: '请输入患者姓名' },
        { prop: 'patientId', label: '患者ID', type: 'input', visible: false, placeholder: '请输入患者ID' },
        { prop: 'doctorId', label: '涉及医师ID', type: 'number', visible: false, placeholder: '请输入涉及医师ID' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'complaintSource', label: '投诉来源', type: 'input', visible: false, placeholder: '请输入投诉来源' },
        { prop: 'complainantContact', label: '投诉人联系方式', type: 'input', visible: false, placeholder: '请输入投诉人联系方式' },
        { prop: 'doctorName', label: '涉及医师姓名', type: 'input', visible: false, placeholder: '请输入涉及医师姓名' },
        { prop: 'departmentId', label: '涉及科室ID', type: 'number', visible: false, placeholder: '请输入涉及科室ID' },
        { prop: 'departmentName', label: '涉及科室名称', type: 'input', visible: false, placeholder: '请输入涉及科室名称' },
        { prop: 'complaintContent', label: '投诉内容', type: 'input', visible: false, placeholder: '请输入投诉内容' },
        { prop: 'complaintTime', label: '投诉时间', type: 'daterange', visible: false, placeholder: '请输入投诉时间', startProp: 'complaintTimeStart', endProp: 'complaintTimeEnd' },
        { prop: 'currentStatus', label: '当前状态', type: 'input', visible: false, placeholder: '请输入当前状态' },
        { prop: 'priorityLevel', label: '优先级', type: 'input', visible: false, placeholder: '请输入优先级' },
        { prop: 'isDispute', label: '是否构成纠纷', type: 'number', visible: false, placeholder: '请输入是否构成纠纷' },
        { prop: 'disputeConfirmation', label: '纠纷确认说明', type: 'input', visible: false, placeholder: '请输入纠纷确认说明' },
        { prop: 'finalResult', label: '最终处理结果', type: 'input', visible: false, placeholder: '请输入最终处理结果' }
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

  return new SearchConfigManager('complaintDispute', searchFieldGroups);
}


// complaintHandling搜索配置
export function createComplaintHandlingSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'complaintId', label: '投诉ID', type: 'number', visible: true, placeholder: '请输入投诉ID' },
        { prop: 'handlerId', label: '处理人ID', type: 'number', visible: true, placeholder: '请输入处理人ID' },
        { prop: 'handlerName', label: '处理人姓名', type: 'input', visible: true, placeholder: '请输入处理人姓名' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'handlingMeasure', label: '处理措施', type: 'input', visible: false, placeholder: '请输入处理措施' },
        { prop: 'handlingResult', label: '处理结果', type: 'input', visible: false, placeholder: '请输入处理结果' },
        { prop: 'handlingTime', label: '处理时间', type: 'daterange', visible: false, placeholder: '请输入处理时间', startProp: 'handlingTimeStart', endProp: 'handlingTimeEnd' },
        { prop: 'feedbackContent', label: '反馈内容', type: 'input', visible: false, placeholder: '请输入反馈内容' },
        { prop: 'feedbackTime', label: '反馈时间', type: 'daterange', visible: false, placeholder: '请输入反馈时间', startProp: 'feedbackTimeStart', endProp: 'feedbackTimeEnd' }
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

  return new SearchConfigManager('complaintHandling', searchFieldGroups);
}


// complaintInvestigation搜索配置
export function createComplaintInvestigationSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'complaintId', label: '投诉ID', type: 'number', visible: true, placeholder: '请输入投诉ID' },
        { prop: 'investigatorId', label: '调查人ID', type: 'number', visible: true, placeholder: '请输入调查人ID' },
        { prop: 'investigatorName', label: '调查人姓名', type: 'input', visible: true, placeholder: '请输入调查人姓名' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'investigationContent', label: '调查内容', type: 'input', visible: false, placeholder: '请输入调查内容' },
        { prop: 'investigationResult', label: '调查结果', type: 'input', visible: false, placeholder: '请输入调查结果' },
        { prop: 'investigationTime', label: '调查时间', type: 'daterange', visible: false, placeholder: '请输入调查时间', startProp: 'investigationTimeStart', endProp: 'investigationTimeEnd' },
        { prop: 'attachments', label: '附件（JSON格式）', type: 'input', visible: false, placeholder: '请输入附件（JSON格式）' }
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

  return new SearchConfigManager('complaintInvestigation', searchFieldGroups);
}
