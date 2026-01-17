import { FieldConfigManager, FieldGroup } from '../fieldConfigManager';

// ledgerBusinessLearning字段配置
export function createLedgerBusinessLearningFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'learningType', label: '学习类型', visible: true, type: 'input', group: 'basic' },
        { prop: 'status', label: '状态', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'learningDate', label: '学习日期', visible: true, type: 'date', group: 'detail' },
        { prop: 'learningTopic', label: '学习主题', visible: true, type: 'input', group: 'detail' },
        { prop: 'organizer', label: '组织者', visible: true, type: 'input', group: 'detail' },
        { prop: 'participants', label: '参与人员', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'learningContent', label: '学习内容', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'learningHours', label: '学习学时', visible: true, type: 'number', group: 'detail' },
        { prop: 'instructor', label: '授课人', visible: true, type: 'input', group: 'detail' },
        { prop: 'evaluationResults', label: '评价结果', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'attachments', label: '附件', visible: true, type: 'textarea', group: 'detail' }
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

  return new FieldConfigManager('ledgerBusinessLearning', fieldGroups);
}


// ledgerCriticalPatient字段配置
export function createLedgerCriticalPatientFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'patientId', label: '患者ID', visible: true, type: 'input', group: 'basic' },
        { prop: 'patientName', label: '患者姓名', visible: true, type: 'input', group: 'basic' },
        { prop: 'diagnosis', label: '诊断', visible: true, type: 'textarea', group: 'basic' },
        { prop: 'status', label: '状态', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'admissionDate', label: '入院日期', visible: true, type: 'date', group: 'detail' },
        { prop: 'rescueDate', label: '抢救日期', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'department', label: '抢救科室', visible: true, type: 'input', group: 'detail' },
        { prop: 'rescuePhysician', label: '抢救医师', visible: true, type: 'input', group: 'detail' },
        { prop: 'rescueReason', label: '抢救原因', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'rescueMeasures', label: '抢救措施', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'rescueDuration', label: '抢救时长', visible: true, type: 'number', group: 'detail' },
        { prop: 'rescueOutcome', label: '抢救结局', visible: true, type: 'input', group: 'detail' },
        { prop: 'complications', label: '并发症', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'medicalEvaluation', label: '医疗评价', visible: true, type: 'textarea', group: 'detail' }
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

  return new FieldConfigManager('ledgerCriticalPatient', fieldGroups);
}


// ledgerLongStayPatient字段配置
export function createLedgerLongStayPatientFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'patientId', label: '患者ID', visible: true, type: 'input', group: 'basic' },
        { prop: 'patientName', label: '患者姓名', visible: true, type: 'input', group: 'basic' },
        { prop: 'diagnosis', label: '诊断', visible: true, type: 'textarea', group: 'basic' },
        { prop: 'status', label: '状态', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'admissionDate', label: '入院日期', visible: true, type: 'date', group: 'detail' },
        { prop: 'dischargeDate', label: '出院日期', visible: true, type: 'date', group: 'detail' },
        { prop: 'hospitalDays', label: '住院天数', visible: true, type: 'number', group: 'detail' },
        { prop: 'department', label: '所在科室', visible: true, type: 'input', group: 'detail' },
        { prop: 'treatmentPlan', label: '治疗方案', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'complications', label: '并发症', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'specialReasons', label: '特殊原因', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'medicalEvaluation', label: '医疗评价', visible: true, type: 'textarea', group: 'detail' }
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

  return new FieldConfigManager('ledgerLongStayPatient', fieldGroups);
}


// ledgerMajorSurgery字段配置
export function createLedgerMajorSurgeryFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'patientId', label: '患者ID', visible: true, type: 'input', group: 'basic' },
        { prop: 'patientName', label: '患者姓名', visible: true, type: 'input', group: 'basic' },
        { prop: 'operationName', label: '手术名称', visible: true, type: 'input', group: 'basic' },
        { prop: 'operationLevel', label: '手术等级', visible: true, type: 'input', group: 'basic' },
        { prop: 'preoperativeDiagnosis', label: '术前诊断', visible: true, type: 'textarea', group: 'basic' },
        { prop: 'postoperativeDiagnosis', label: '术后诊断', visible: true, type: 'textarea', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'operationDate', label: '手术日期', visible: true, type: 'date', group: 'detail' },
        { prop: 'department', label: '手术科室', visible: true, type: 'input', group: 'detail' },
        { prop: 'surgeon', label: '主刀医师', visible: true, type: 'input', group: 'detail' },
        { prop: 'operationDuration', label: '手术时长', visible: true, type: 'number', group: 'detail' },
        { prop: 'anesthesiaMethod', label: '麻醉方式', visible: true, type: 'input', group: 'detail' },
        { prop: 'complications', label: '术中并发症', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'outcome', label: '手术结局', visible: true, type: 'input', group: 'detail' },
        { prop: 'followUpResults', label: '随访结果', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'medicalEvaluation', label: '医疗评价', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'status', label: '状态', visible: true, type: 'input', group: 'detail' }
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

  return new FieldConfigManager('ledgerMajorSurgery', fieldGroups);
}


// ledgerPatientFullCycle字段配置
export function createLedgerPatientFullCycleFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'patientId', label: '患者ID', visible: true, type: 'input', group: 'basic' },
        { prop: 'patientName', label: '患者姓名', visible: true, type: 'input', group: 'basic' },
        { prop: 'diagnosis', label: '诊断信息', visible: true, type: 'textarea', group: 'basic' },
        { prop: 'status', label: '状态', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'admissionDate', label: '入院日期', visible: true, type: 'date', group: 'detail' },
        { prop: 'dischargeDate', label: '出院日期', visible: true, type: 'date', group: 'detail' },
        { prop: 'department', label: '就诊科室', visible: true, type: 'input', group: 'detail' },
        { prop: 'attendingPhysician', label: '主治医师', visible: true, type: 'input', group: 'detail' },
        { prop: 'treatmentRecords', label: '治疗记录', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'examinationResults', label: '检查结果', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'medicationRecords', label: '用药记录', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'followUpRecords', label: '随访记录', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'outcome', label: '治疗结局', visible: true, type: 'input', group: 'detail' },
        { prop: 'medicalEvaluation', label: '医疗评价', visible: true, type: 'textarea', group: 'detail' }
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

  return new FieldConfigManager('ledgerPatientFullCycle', fieldGroups);
}


// ledgerUnplannedReoperation字段配置
export function createLedgerUnplannedReoperationFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'patientId', label: '患者ID', visible: true, type: 'input', group: 'basic' },
        { prop: 'patientName', label: '患者姓名', visible: true, type: 'input', group: 'basic' },
        { prop: 'firstOperationName', label: '第一次手术名称', visible: true, type: 'input', group: 'basic' },
        { prop: 'reoperationName', label: '再次手术名称', visible: true, type: 'input', group: 'basic' },
        { prop: 'status', label: '状态', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'firstOperationDate', label: '第一次手术日期', visible: true, type: 'date', group: 'detail' },
        { prop: 'reoperationDate', label: '再次手术日期', visible: true, type: 'date', group: 'detail' },
        { prop: 'department', label: '手术科室', visible: true, type: 'input', group: 'detail' },
        { prop: 'surgeon', label: '手术医师', visible: true, type: 'input', group: 'detail' },
        { prop: 'reoperationReason', label: '再次手术原因', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'complications', label: '并发症', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'medicalEvaluation', label: '医疗评价', visible: true, type: 'textarea', group: 'detail' }
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

  return new FieldConfigManager('ledgerUnplannedReoperation', fieldGroups);
}
