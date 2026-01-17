import { FieldConfigManager, FieldGroup } from '../fieldConfigManager';

// complaintDispute字段配置
export function createComplaintDisputeFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'complaintNo', label: '投诉编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'complaintType', label: '投诉类型', visible: true, type: 'input', group: 'basic' },
        { prop: 'complainantName', label: '投诉人姓名', visible: true, type: 'input', group: 'basic' },
        { prop: 'patientName', label: '患者姓名', visible: true, type: 'input', group: 'basic' },
        { prop: 'patientId', label: '患者ID', visible: true, type: 'input', group: 'basic' },
        { prop: 'doctorId', label: '涉及医师ID', visible: true, type: 'number', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'complaintSource', label: '投诉来源', visible: true, type: 'input', group: 'detail' },
        { prop: 'complainantContact', label: '投诉人联系方式', visible: true, type: 'input', group: 'detail' },
        { prop: 'doctorName', label: '涉及医师姓名', visible: true, type: 'input', group: 'detail' },
        { prop: 'departmentId', label: '涉及科室ID', visible: true, type: 'number', group: 'detail' },
        { prop: 'departmentName', label: '涉及科室名称', visible: true, type: 'input', group: 'detail' },
        { prop: 'complaintContent', label: '投诉内容', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'complaintTime', label: '投诉时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'currentStatus', label: '当前状态', visible: true, type: 'input', group: 'detail' },
        { prop: 'priorityLevel', label: '优先级', visible: true, type: 'input', group: 'detail' },
        { prop: 'isDispute', label: '是否构成纠纷', visible: true, type: 'number', group: 'detail' },
        { prop: 'disputeConfirmation', label: '纠纷确认说明', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'finalResult', label: '最终处理结果', visible: true, type: 'textarea', group: 'detail' }
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

  return new FieldConfigManager('complaintDispute', fieldGroups);
}


// complaintHandling字段配置
export function createComplaintHandlingFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'complaintId', label: '投诉ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'handlerId', label: '处理人ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'handlerName', label: '处理人姓名', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'handlingMeasure', label: '处理措施', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'handlingResult', label: '处理结果', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'handlingTime', label: '处理时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'feedbackContent', label: '反馈内容', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'feedbackTime', label: '反馈时间', visible: true, type: 'datetime', group: 'detail' }
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

  return new FieldConfigManager('complaintHandling', fieldGroups);
}


// complaintInvestigation字段配置
export function createComplaintInvestigationFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'complaintId', label: '投诉ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'investigatorId', label: '调查人ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'investigatorName', label: '调查人姓名', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'investigationContent', label: '调查内容', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'investigationResult', label: '调查结果', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'investigationTime', label: '调查时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'attachments', label: '附件（JSON格式）', visible: true, type: 'textarea', group: 'detail' }
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

  return new FieldConfigManager('complaintInvestigation', fieldGroups);
}
