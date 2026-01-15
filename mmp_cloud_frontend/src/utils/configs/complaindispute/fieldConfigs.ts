import { FieldConfigManager, FieldGroup } from '../../fieldConfigManager';

// 投诉纠纷字段配置
export function createComplaintDisputeFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'complaintNo', label: '投诉编号', visible: true, required: true, group: 'basic' },
        { prop: 'complaintType', label: '投诉类型', visible: true, required: true, group: 'basic' },
        { prop: 'complaintSource', label: '投诉来源', visible: true, group: 'basic' },
        { prop: 'complaintTime', label: '投诉时间', visible: true, width: '160', group: 'basic' },
        { prop: 'currentStatus', label: '当前状态', visible: true, group: 'basic' },
        { prop: 'priorityLevel', label: '优先级', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'complainant',
      label: '投诉人信息',
      fields: [
        { prop: 'complainantName', label: '投诉人姓名', visible: true, required: true, group: 'complainant' },
        { prop: 'complainantContact', label: '投诉人联系方式', visible: true, group: 'complainant' }
      ]
    },
    {
      name: 'patient',
      label: '患者信息',
      fields: [
        { prop: 'patientName', label: '患者姓名', visible: true, group: 'patient' },
        { prop: 'doctorName', label: '涉及医师姓名', visible: true, group: 'patient' },
        { prop: 'departmentName', label: '涉及科室名称', visible: true, group: 'patient' }
      ]
    },
    {
      name: 'content',
      label: '投诉内容',
      fields: [
        { prop: 'complaintContent', label: '投诉内容', visible: true, type: 'textarea', group: 'content' }
      ]
    },
    {
      name: 'dispute',
      label: '纠纷信息',
      fields: [
        { prop: 'isDispute', label: '是否构成纠纷', visible: true, group: 'dispute' },
        { prop: 'disputeConfirmation', label: '纠纷确认说明', visible: true, type: 'textarea', group: 'dispute' },
        { prop: 'finalResult', label: '最终处理结果', visible: true, type: 'textarea', group: 'dispute' }
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

  return new FieldConfigManager(fieldGroups);
}

// 投诉处理字段配置
export function createComplaintHandlingFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'complaintId', label: '投诉ID', visible: true, required: true, group: 'basic' },
        { prop: 'handlerName', label: '处理人姓名', visible: true, required: true, group: 'basic' },
        { prop: 'handlingTime', label: '处理时间', visible: true, width: '160', group: 'basic' }
      ]
    },
    {
      name: 'handling',
      label: '处理信息',
      fields: [
        { prop: 'handlingMeasure', label: '处理措施', visible: true, type: 'textarea', group: 'handling' },
        { prop: 'handlingResult', label: '处理结果', visible: true, type: 'textarea', group: 'handling' }
      ]
    },
    {
      name: 'feedback',
      label: '反馈信息',
      fields: [
        { prop: 'feedbackContent', label: '反馈内容', visible: true, type: 'textarea', group: 'feedback' },
        { prop: 'feedbackTime', label: '反馈时间', visible: true, width: '160', group: 'feedback' }
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

  return new FieldConfigManager(fieldGroups);
}

// 投诉调查字段配置
export function createComplaintInvestigationFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'complaintId', label: '投诉ID', visible: true, required: true, group: 'basic' },
        { prop: 'investigatorName', label: '调查人姓名', visible: true, required: true, group: 'basic' },
        { prop: 'investigationTime', label: '调查时间', visible: true, width: '160', group: 'basic' }
      ]
    },
    {
      name: 'investigation',
      label: '调查信息',
      fields: [
        { prop: 'investigationContent', label: '调查内容', visible: true, type: 'textarea', group: 'investigation' },
        { prop: 'investigationResult', label: '调查结果', visible: true, type: 'textarea', group: 'investigation' },
        { prop: 'attachments', label: '附件', visible: true, group: 'investigation' }
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

  return new FieldConfigManager(fieldGroups);
}