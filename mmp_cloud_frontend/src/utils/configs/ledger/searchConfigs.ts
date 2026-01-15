import { SearchConfigManager, SearchFieldGroup } from '../../searchConfig';

// 死亡病例讨论搜索配置
export function createDeathCaseDiscussionSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'patient',
      label: '患者信息',
      fields: [
        { prop: 'patientName', label: '患者姓名', type: 'input', placeholder: '请输入患者姓名' },
        { prop: 'patientAge', label: '患者年龄', type: 'numberrange', placeholder: '请输入年龄范围' },
        { prop: 'patientGender', label: '患者性别', type: 'select', placeholder: '请选择性别' },
        { prop: 'deathReason', label: '死亡原因', type: 'input', placeholder: '请输入死亡原因' }
      ]
    },
    {
      name: 'discussion',
      label: '讨论信息',
      fields: [
        { prop: 'moderatorName', label: '讨论主持人姓名', type: 'input', placeholder: '请输入主持人姓名' },
        { prop: 'participants', label: '参与人员', type: 'input', placeholder: '请输入参与人员姓名' },
        { prop: 'participantCount', label: '参与人数', type: 'numberrange', placeholder: '请输入参与人数范围' }
      ]
    },
    {
      name: 'time',
      label: '时间范围',
      fields: [
        { prop: 'deathDate', label: '死亡日期', type: 'daterange', placeholder: '请选择死亡日期范围' },
        { prop: 'discussionDate', label: '讨论日期', type: 'daterange', placeholder: '请选择讨论日期范围' }
      ]
    }
  ];

  return new SearchConfigManager('deathCaseDiscussion', searchFieldGroups);
}

// 重大手术台账搜索配置
export function createLedgerMajorSurgerySearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'patient',
      label: '患者信息',
      fields: [
        { prop: 'patientName', label: '患者姓名', type: 'input', placeholder: '请输入患者姓名' }
      ]
    },
    {
      name: 'surgery',
      label: '手术信息',
      fields: [
        { prop: 'department', label: '手术科室', type: 'input', placeholder: '请输入手术科室' },
        { prop: 'surgeon', label: '主刀医师', type: 'input', placeholder: '请输入主刀医师' },
        { prop: 'operationName', label: '手术名称', type: 'input', placeholder: '请输入手术名称' },
        { prop: 'operationLevel', label: '手术等级', type: 'select', placeholder: '请选择手术等级' },
        { prop: 'anesthesiaMethod', label: '麻醉方式', type: 'select', placeholder: '请选择麻醉方式' },
        { prop: 'operationDuration', label: '手术时长(分钟)', type: 'numberrange', placeholder: '请输入手术时长范围' }
      ]
    },
    {
      name: 'diagnosis',
      label: '诊断信息',
      fields: [
        { prop: 'preoperativeDiagnosis', label: '术前诊断', type: 'input', placeholder: '请输入术前诊断关键词' },
        { prop: 'postoperativeDiagnosis', label: '术后诊断', type: 'input', placeholder: '请输入术后诊断关键词' }
      ]
    },
    {
      name: 'time',
      label: '时间范围',
      fields: [
        { prop: 'operationDate', label: '手术日期', type: 'daterange', placeholder: '请选择手术日期范围' }
      ]
    }
  ];

  return new SearchConfigManager('ledgerMajorSurgery', searchFieldGroups);
}

// 危重患者台账搜索配置
export function createLedgerCriticalPatientSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'patient',
      label: '患者信息',
      fields: [
        { prop: 'patientName', label: '患者姓名', type: 'input', placeholder: '请输入患者姓名' },
        { prop: 'patientAge', label: '患者年龄', type: 'numberrange', placeholder: '请输入年龄范围' },
        { prop: 'patientGender', label: '患者性别', type: 'select', placeholder: '请选择性别' }
      ]
    },
    {
      name: 'condition',
      label: '病情信息',
      fields: [
        { prop: 'diagnosis', label: '诊断', type: 'input', placeholder: '请输入诊断关键词' },
        { prop: 'severityLevel', label: '严重程度', type: 'select', placeholder: '请选择严重程度' },
        { prop: 'treatmentResult', label: '治疗结果', type: 'select', placeholder: '请选择治疗结果' },
        { prop: 'complications', label: '并发症', type: 'input', placeholder: '请输入并发症关键词' }
      ]
    },
    {
      name: 'time',
      label: '时间范围',
      fields: [
        { prop: 'admissionDate', label: '入院日期', type: 'daterange', placeholder: '请选择入院日期范围' },
        { prop: 'dischargeDate', label: '出院日期', type: 'daterange', placeholder: '请选择出院日期范围' }
      ]
    }
  ];

  return new SearchConfigManager('ledgerCriticalPatient', searchFieldGroups);
}

// 患者全周期台账搜索配置
export function createLedgerPatientFullCycleSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'patient',
      label: '患者信息',
      fields: [
        { prop: 'patientName', label: '患者姓名', type: 'input', placeholder: '请输入患者姓名' },
        { prop: 'patientId', label: '患者ID', type: 'input', placeholder: '请输入患者ID' }
      ]
    },
    {
      name: 'treatment',
      label: '治疗信息',
      fields: [
        { prop: 'department', label: '就诊科室', type: 'input', placeholder: '请输入就诊科室' },
        { prop: 'doctorName', label: '主治医师', type: 'input', placeholder: '请输入主治医师' },
        { prop: 'diagnosis', label: '诊断结果', type: 'input', placeholder: '请输入诊断关键词' },
        { prop: 'treatmentResult', label: '治疗结果', type: 'select', placeholder: '请选择治疗结果' }
      ]
    },
    {
      name: 'time',
      label: '时间范围',
      fields: [
        { prop: 'admissionDate', label: '入院日期', type: 'daterange', placeholder: '请选择入院日期范围' },
        { prop: 'dischargeDate', label: '出院日期', type: 'daterange', placeholder: '请选择出院日期范围' }
      ]
    }
  ];

  return new SearchConfigManager('ledgerPatientFullCycle', searchFieldGroups);
}