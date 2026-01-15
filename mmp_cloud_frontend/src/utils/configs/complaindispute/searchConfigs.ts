import { SearchConfigManager, SearchFieldGroup } from '../../searchConfig';

// 投诉纠纷搜索配置
export function createComplaintDisputeSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'complaintNo', label: '投诉编号', type: 'input', placeholder: '请输入投诉编号' },
        { prop: 'complaintType', label: '投诉类型', type: 'select', placeholder: '请选择投诉类型' },
        { prop: 'complaintSource', label: '投诉来源', type: 'select', placeholder: '请选择投诉来源' },
        { prop: 'currentStatus', label: '当前状态', type: 'select', placeholder: '请选择当前状态' },
        { prop: 'priorityLevel', label: '优先级', type: 'select', placeholder: '请选择优先级' }
      ]
    },
    {
      name: 'complainant',
      label: '投诉人信息',
      fields: [
        { prop: 'complainantName', label: '投诉人姓名', type: 'input', placeholder: '请输入投诉人姓名' },
        { prop: 'complainantContact', label: '投诉人联系方式', type: 'input', placeholder: '请输入投诉人联系方式' }
      ]
    },
    {
      name: 'patient',
      label: '患者信息',
      fields: [
        { prop: 'patientName', label: '患者姓名', type: 'input', placeholder: '请输入患者姓名' },
        { prop: 'doctorName', label: '涉及医师姓名', type: 'input', placeholder: '请输入涉及医师姓名' },
        { prop: 'departmentName', label: '涉及科室名称', type: 'input', placeholder: '请输入涉及科室名称' }
      ]
    },
    {
      name: 'dispute',
      label: '纠纷信息',
      fields: [
        { prop: 'isDispute', label: '是否构成纠纷', type: 'select', placeholder: '请选择是否构成纠纷' }
      ]
    },
    {
      name: 'time',
      label: '时间范围',
      fields: [
        { prop: 'complaintTime', label: '投诉时间', type: 'daterange', placeholder: '请选择投诉时间范围' }
      ]
    }
  ];

  return new SearchConfigManager('complaintDispute', searchFieldGroups);
}

// 投诉处理搜索配置
export function createComplaintHandlingSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'complaintId', label: '投诉ID', type: 'input', placeholder: '请输入投诉ID' },
        { prop: 'handlerName', label: '处理人姓名', type: 'input', placeholder: '请输入处理人姓名' }
      ]
    },
    {
      name: 'handling',
      label: '处理信息',
      fields: [
        { prop: 'handlingMeasure', label: '处理措施', type: 'input', placeholder: '请输入处理措施关键词' },
        { prop: 'handlingResult', label: '处理结果', type: 'input', placeholder: '请输入处理结果关键词' }
      ]
    },
    {
      name: 'feedback',
      label: '反馈信息',
      fields: [
        { prop: 'feedbackContent', label: '反馈内容', type: 'input', placeholder: '请输入反馈内容关键词' }
      ]
    },
    {
      name: 'time',
      label: '时间范围',
      fields: [
        { prop: 'handlingTime', label: '处理时间', type: 'daterange', placeholder: '请选择处理时间范围' },
        { prop: 'feedbackTime', label: '反馈时间', type: 'daterange', placeholder: '请选择反馈时间范围' }
      ]
    }
  ];

  return new SearchConfigManager('complaintHandling', searchFieldGroups);
}

// 投诉调查搜索配置
export function createComplaintInvestigationSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'complaintId', label: '投诉ID', type: 'input', placeholder: '请输入投诉ID' },
        { prop: 'investigatorName', label: '调查人姓名', type: 'input', placeholder: '请输入调查人姓名' }
      ]
    },
    {
      name: 'investigation',
      label: '调查信息',
      fields: [
        { prop: 'investigationContent', label: '调查内容', type: 'input', placeholder: '请输入调查内容关键词' },
        { prop: 'investigationResult', label: '调查结果', type: 'input', placeholder: '请输入调查结果关键词' }
      ]
    },
    {
      name: 'time',
      label: '时间范围',
      fields: [
        { prop: 'investigationTime', label: '调查时间', type: 'daterange', placeholder: '请选择调查时间范围' }
      ]
    }
  ];

  return new SearchConfigManager('complaintInvestigation', searchFieldGroups);
}