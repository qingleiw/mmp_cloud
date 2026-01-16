import { FieldConfigManager, FieldGroup } from '../fieldConfigManager';

// 死亡病例讨论字段配置
export function createDeathCaseDiscussionFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'patient',
      label: '患者信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'patient' },
        { prop: 'patientName', label: '患者姓名', visible: true, required: true, group: 'patient' },
        { prop: 'patientAge', label: '患者年龄', visible: true, group: 'patient' },
        { prop: 'patientGender', label: '患者性别', visible: true, group: 'patient' },
        { prop: 'deathDate', label: '死亡日期', visible: true, width: '120', group: 'patient' },
        { prop: 'deathReason', label: '死亡原因', visible: true, group: 'patient' }
      ]
    },
    {
      name: 'discussion',
      label: '讨论信息',
      fields: [
        { prop: 'moderatorName', label: '讨论主持人姓名', visible: true, required: true, group: 'discussion' },
        { prop: 'discussionDate', label: '讨论日期', visible: true, width: '120', group: 'discussion' },
        { prop: 'discussionContent', label: '讨论内容和结论', visible: true, type: 'textarea', group: 'discussion' },
        { prop: 'participants', label: '参与讨论的人员名单', visible: true, group: 'discussion' },
        { prop: 'participantCount', label: '参与人数', visible: true, group: 'discussion' }
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

// 重大手术台账字段配置
export function createLedgerMajorSurgeryFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'patient',
      label: '患者信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'patient' },
        { prop: 'patientName', label: '患者姓名', visible: true, required: true, group: 'patient' },
        { prop: 'operationDate', label: '手术日期', visible: true, width: '120', group: 'patient' },
        { prop: 'department', label: '手术科室', visible: true, required: true, group: 'patient' }
      ]
    },
    {
      name: 'surgery',
      label: '手术信息',
      fields: [
        { prop: 'surgeon', label: '主刀医师', visible: true, required: true, group: 'surgery' },
        { prop: 'operationName', label: '手术名称', visible: true, required: true, group: 'surgery' },
        { prop: 'operationLevel', label: '手术等级', visible: true, group: 'surgery' },
        { prop: 'operationDuration', label: '手术时长(分钟)', visible: true, group: 'surgery' },
        { prop: 'anesthesiaMethod', label: '麻醉方式', visible: true, group: 'surgery' }
      ]
    },
    {
      name: 'diagnosis',
      label: '诊断信息',
      fields: [
        { prop: 'preoperativeDiagnosis', label: '术前诊断', visible: true, type: 'textarea', group: 'diagnosis' },
        { prop: 'postoperativeDiagnosis', label: '术后诊断', visible: true, type: 'textarea', group: 'diagnosis' }
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

// 危重患者台账字段配置
export function createLedgerCriticalPatientFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'patient',
      label: '患者信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'patient' },
        { prop: 'patientName', label: '患者姓名', visible: true, required: true, group: 'patient' },
        { prop: 'patientAge', label: '患者年龄', visible: true, group: 'patient' },
        { prop: 'patientGender', label: '患者性别', visible: true, group: 'patient' },
        { prop: 'admissionDate', label: '入院日期', visible: true, width: '120', group: 'patient' },
        { prop: 'dischargeDate', label: '出院日期', visible: true, width: '120', group: 'patient' }
      ]
    },
    {
      name: 'condition',
      label: '病情信息',
      fields: [
        { prop: 'diagnosis', label: '诊断', visible: true, required: true, group: 'condition' },
        { prop: 'severityLevel', label: '严重程度', visible: true, group: 'condition' },
        { prop: 'treatmentResult', label: '治疗结果', visible: true, group: 'condition' },
        { prop: 'complications', label: '并发症', visible: true, group: 'condition' }
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

// 患者全周期台账字段配置
export function createLedgerPatientFullCycleFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'patient',
      label: '患者信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'patient' },
        { prop: 'patientName', label: '患者姓名', visible: true, required: true, group: 'patient' },
        { prop: 'patientId', label: '患者ID', visible: true, group: 'patient' },
        { prop: 'admissionDate', label: '入院日期', visible: true, width: '120', group: 'patient' },
        { prop: 'dischargeDate', label: '出院日期', visible: true, width: '120', group: 'patient' }
      ]
    },
    {
      name: 'treatment',
      label: '治疗过程',
      fields: [
        { prop: 'department', label: '就诊科室', visible: true, group: 'treatment' },
        { prop: 'doctorName', label: '主治医师', visible: true, group: 'treatment' },
        { prop: 'diagnosis', label: '诊断结果', visible: true, group: 'treatment' },
        { prop: 'treatmentPlan', label: '治疗方案', visible: true, type: 'textarea', group: 'treatment' },
        { prop: 'treatmentResult', label: '治疗结果', visible: true, group: 'treatment' }
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