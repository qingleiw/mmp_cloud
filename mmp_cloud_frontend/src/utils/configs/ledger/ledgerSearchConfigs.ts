import { SearchConfigManager, SearchFieldGroup } from '../searchConfigManager';

// ledgerBusinessLearning搜索配置
export function createLedgerBusinessLearningSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'learningType', label: '学习类型', type: 'input', visible: true, placeholder: '请输入学习类型' },
        { prop: 'status', label: '状态', type: 'input', visible: true, placeholder: '请输入状态' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'learningDate', label: '学习日期', type: 'daterange', visible: true, placeholder: '请输入学习日期', startProp: 'learningDateStart', endProp: 'learningDateEnd' },
        { prop: 'learningTopic', label: '学习主题', type: 'input', visible: false, placeholder: '请输入学习主题' },
        { prop: 'organizer', label: '组织者', type: 'input', visible: false, placeholder: '请输入组织者' },
        { prop: 'participants', label: '参与人员', type: 'input', visible: false, placeholder: '请输入参与人员' },
        { prop: 'learningContent', label: '学习内容', type: 'input', visible: false, placeholder: '请输入学习内容' },
        { prop: 'learningHours', label: '学习学时', type: 'number', visible: false, placeholder: '请输入学习学时' },
        { prop: 'instructor', label: '授课人', type: 'input', visible: false, placeholder: '请输入授课人' },
        { prop: 'evaluationResults', label: '评价结果', type: 'input', visible: false, placeholder: '请输入评价结果' },
        { prop: 'attachments', label: '附件', type: 'input', visible: false, placeholder: '请输入附件' }
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

  return new SearchConfigManager('ledgerBusinessLearning', searchFieldGroups);
}


// ledgerCriticalPatient搜索配置
export function createLedgerCriticalPatientSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'patientId', label: '患者ID', type: 'input', visible: true, placeholder: '请输入患者ID' },
        { prop: 'patientName', label: '患者姓名', type: 'input', visible: true, placeholder: '请输入患者姓名' },
        { prop: 'diagnosis', label: '诊断', type: 'input', visible: true, placeholder: '请输入诊断' },
        { prop: 'status', label: '状态', type: 'input', visible: false, placeholder: '请输入状态' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'admissionDate', label: '入院日期', type: 'daterange', visible: false, placeholder: '请输入入院日期', startProp: 'admissionDateStart', endProp: 'admissionDateEnd' },
        { prop: 'rescueDate', label: '抢救日期', type: 'daterange', visible: false, placeholder: '请输入抢救日期', startProp: 'rescueDateStart', endProp: 'rescueDateEnd' },
        { prop: 'department', label: '抢救科室', type: 'input', visible: false, placeholder: '请输入抢救科室' },
        { prop: 'rescuePhysician', label: '抢救医师', type: 'input', visible: false, placeholder: '请输入抢救医师' },
        { prop: 'rescueReason', label: '抢救原因', type: 'input', visible: false, placeholder: '请输入抢救原因' },
        { prop: 'rescueMeasures', label: '抢救措施', type: 'input', visible: false, placeholder: '请输入抢救措施' },
        { prop: 'rescueDuration', label: '抢救时长', type: 'number', visible: false, placeholder: '请输入抢救时长' },
        { prop: 'rescueOutcome', label: '抢救结局', type: 'input', visible: false, placeholder: '请输入抢救结局' },
        { prop: 'complications', label: '并发症', type: 'input', visible: false, placeholder: '请输入并发症' },
        { prop: 'medicalEvaluation', label: '医疗评价', type: 'input', visible: false, placeholder: '请输入医疗评价' }
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

  return new SearchConfigManager('ledgerCriticalPatient', searchFieldGroups);
}


// ledgerLongStayPatient搜索配置
export function createLedgerLongStayPatientSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'patientId', label: '患者ID', type: 'input', visible: true, placeholder: '请输入患者ID' },
        { prop: 'patientName', label: '患者姓名', type: 'input', visible: true, placeholder: '请输入患者姓名' },
        { prop: 'diagnosis', label: '诊断', type: 'input', visible: true, placeholder: '请输入诊断' },
        { prop: 'status', label: '状态', type: 'input', visible: false, placeholder: '请输入状态' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'admissionDate', label: '入院日期', type: 'daterange', visible: false, placeholder: '请输入入院日期', startProp: 'admissionDateStart', endProp: 'admissionDateEnd' },
        { prop: 'dischargeDate', label: '出院日期', type: 'daterange', visible: false, placeholder: '请输入出院日期', startProp: 'dischargeDateStart', endProp: 'dischargeDateEnd' },
        { prop: 'hospitalDays', label: '住院天数', type: 'number', visible: false, placeholder: '请输入住院天数' },
        { prop: 'department', label: '所在科室', type: 'input', visible: false, placeholder: '请输入所在科室' },
        { prop: 'treatmentPlan', label: '治疗方案', type: 'input', visible: false, placeholder: '请输入治疗方案' },
        { prop: 'complications', label: '并发症', type: 'input', visible: false, placeholder: '请输入并发症' },
        { prop: 'specialReasons', label: '特殊原因', type: 'input', visible: false, placeholder: '请输入特殊原因' },
        { prop: 'medicalEvaluation', label: '医疗评价', type: 'input', visible: false, placeholder: '请输入医疗评价' }
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

  return new SearchConfigManager('ledgerLongStayPatient', searchFieldGroups);
}


// ledgerMajorSurgery搜索配置
export function createLedgerMajorSurgerySearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'patientId', label: '患者ID', type: 'input', visible: true, placeholder: '请输入患者ID' },
        { prop: 'patientName', label: '患者姓名', type: 'input', visible: true, placeholder: '请输入患者姓名' },
        { prop: 'operationName', label: '手术名称', type: 'input', visible: true, placeholder: '请输入手术名称' },
        { prop: 'operationLevel', label: '手术等级', type: 'input', visible: false, placeholder: '请输入手术等级' },
        { prop: 'preoperativeDiagnosis', label: '术前诊断', type: 'input', visible: false, placeholder: '请输入术前诊断' },
        { prop: 'postoperativeDiagnosis', label: '术后诊断', type: 'input', visible: false, placeholder: '请输入术后诊断' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'operationDate', label: '手术日期', type: 'daterange', visible: false, placeholder: '请输入手术日期', startProp: 'operationDateStart', endProp: 'operationDateEnd' },
        { prop: 'department', label: '手术科室', type: 'input', visible: false, placeholder: '请输入手术科室' },
        { prop: 'surgeon', label: '主刀医师', type: 'input', visible: false, placeholder: '请输入主刀医师' },
        { prop: 'operationDuration', label: '手术时长', type: 'number', visible: false, placeholder: '请输入手术时长' },
        { prop: 'anesthesiaMethod', label: '麻醉方式', type: 'input', visible: false, placeholder: '请输入麻醉方式' },
        { prop: 'complications', label: '术中并发症', type: 'input', visible: false, placeholder: '请输入术中并发症' },
        { prop: 'outcome', label: '手术结局', type: 'input', visible: false, placeholder: '请输入手术结局' },
        { prop: 'followUpResults', label: '随访结果', type: 'input', visible: false, placeholder: '请输入随访结果' },
        { prop: 'medicalEvaluation', label: '医疗评价', type: 'input', visible: false, placeholder: '请输入医疗评价' },
        { prop: 'status', label: '状态', type: 'input', visible: false, placeholder: '请输入状态' }
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

  return new SearchConfigManager('ledgerMajorSurgery', searchFieldGroups);
}


// ledgerPatientFullCycle搜索配置
export function createLedgerPatientFullCycleSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'patientId', label: '患者ID', type: 'input', visible: true, placeholder: '请输入患者ID' },
        { prop: 'patientName', label: '患者姓名', type: 'input', visible: true, placeholder: '请输入患者姓名' },
        { prop: 'diagnosis', label: '诊断信息', type: 'input', visible: true, placeholder: '请输入诊断信息' },
        { prop: 'status', label: '状态', type: 'input', visible: false, placeholder: '请输入状态' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'admissionDate', label: '入院日期', type: 'daterange', visible: false, placeholder: '请输入入院日期', startProp: 'admissionDateStart', endProp: 'admissionDateEnd' },
        { prop: 'dischargeDate', label: '出院日期', type: 'daterange', visible: false, placeholder: '请输入出院日期', startProp: 'dischargeDateStart', endProp: 'dischargeDateEnd' },
        { prop: 'department', label: '就诊科室', type: 'input', visible: false, placeholder: '请输入就诊科室' },
        { prop: 'attendingPhysician', label: '主治医师', type: 'input', visible: false, placeholder: '请输入主治医师' },
        { prop: 'treatmentRecords', label: '治疗记录', type: 'input', visible: false, placeholder: '请输入治疗记录' },
        { prop: 'examinationResults', label: '检查结果', type: 'input', visible: false, placeholder: '请输入检查结果' },
        { prop: 'medicationRecords', label: '用药记录', type: 'input', visible: false, placeholder: '请输入用药记录' },
        { prop: 'followUpRecords', label: '随访记录', type: 'input', visible: false, placeholder: '请输入随访记录' },
        { prop: 'outcome', label: '治疗结局', type: 'input', visible: false, placeholder: '请输入治疗结局' },
        { prop: 'medicalEvaluation', label: '医疗评价', type: 'input', visible: false, placeholder: '请输入医疗评价' }
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

  return new SearchConfigManager('ledgerPatientFullCycle', searchFieldGroups);
}


// ledgerUnplannedReoperation搜索配置
export function createLedgerUnplannedReoperationSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'patientId', label: '患者ID', type: 'input', visible: true, placeholder: '请输入患者ID' },
        { prop: 'patientName', label: '患者姓名', type: 'input', visible: true, placeholder: '请输入患者姓名' },
        { prop: 'firstOperationName', label: '第一次手术名称', type: 'input', visible: true, placeholder: '请输入第一次手术名称' },
        { prop: 'reoperationName', label: '再次手术名称', type: 'input', visible: false, placeholder: '请输入再次手术名称' },
        { prop: 'status', label: '状态', type: 'input', visible: false, placeholder: '请输入状态' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'firstOperationDate', label: '第一次手术日期', type: 'daterange', visible: false, placeholder: '请输入第一次手术日期', startProp: 'firstOperationDateStart', endProp: 'firstOperationDateEnd' },
        { prop: 'reoperationDate', label: '再次手术日期', type: 'daterange', visible: false, placeholder: '请输入再次手术日期', startProp: 'reoperationDateStart', endProp: 'reoperationDateEnd' },
        { prop: 'department', label: '手术科室', type: 'input', visible: false, placeholder: '请输入手术科室' },
        { prop: 'surgeon', label: '手术医师', type: 'input', visible: false, placeholder: '请输入手术医师' },
        { prop: 'reoperationReason', label: '再次手术原因', type: 'input', visible: false, placeholder: '请输入再次手术原因' },
        { prop: 'complications', label: '并发症', type: 'input', visible: false, placeholder: '请输入并发症' },
        { prop: 'medicalEvaluation', label: '医疗评价', type: 'input', visible: false, placeholder: '请输入医疗评价' }
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

  return new SearchConfigManager('ledgerUnplannedReoperation', searchFieldGroups);
}
