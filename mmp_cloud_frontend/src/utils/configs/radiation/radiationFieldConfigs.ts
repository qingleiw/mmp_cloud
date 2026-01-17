import { FieldConfigManager, FieldGroup } from '../fieldConfigManager';

// radiationDoseAlert字段配置
export function createRadiationDoseAlertFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'alertType', label: '预警类型：monthly-月度预警，quarterly-季度预警，yearly-年度预警', visible: true, type: 'input', group: 'basic' },
        { prop: 'alertLevel', label: '预警级别：low-低，medium-中，high-高', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'thresholdValue', label: '阈值', visible: true, type: 'number', group: 'detail' },
        { prop: 'isActive', label: '是否启用：0-否，1-是', visible: true, type: 'select', group: 'detail' }
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

  return new FieldConfigManager('radiationDoseAlert', fieldGroups);
}


// radiationDoseAlertRecord字段配置
export function createRadiationDoseAlertRecordFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'staffId', label: '工作人员ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'staffName', label: '工作人员姓名', visible: true, type: 'input', group: 'basic' },
        { prop: 'alertType', label: '预警类型', visible: true, type: 'input', group: 'basic' },
        { prop: 'alertLevel', label: '预警级别', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'alertDate', label: '预警日期', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'currentDose', label: '当前剂量', visible: true, type: 'number', group: 'detail' },
        { prop: 'thresholdValue', label: '阈值', visible: true, type: 'number', group: 'detail' },
        { prop: 'alertMessage', label: '预警信息', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'isHandled', label: '是否已处理：0-否，1-是', visible: true, type: 'select', group: 'detail' },
        { prop: 'handler', label: '处理人', visible: true, type: 'input', group: 'detail' },
        { prop: 'handleTime', label: '处理时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'handleResult', label: '处理结果', visible: true, type: 'textarea', group: 'detail' }
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

  return new FieldConfigManager('radiationDoseAlertRecord', fieldGroups);
}


// radiationDoseMonitoring字段配置
export function createRadiationDoseMonitoringFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'workerId', label: '工作人员ID', visible: true, type: 'number', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'monitoringDate', label: '监测日期', visible: true, type: 'date', group: 'detail' },
        { prop: 'monitoringPeriod', label: '监测周期', visible: true, type: 'input', group: 'detail' },
        { prop: 'doseValue', label: '剂量值', visible: true, type: 'number', group: 'detail' },
        { prop: 'doseUnit', label: '剂量单位', visible: true, type: 'input', group: 'detail' },
        { prop: 'monitoringMethod', label: '监测方法', visible: true, type: 'input', group: 'detail' },
        { prop: 'monitoringDevice', label: '监测设备', visible: true, type: 'input', group: 'detail' },
        { prop: 'monitoringPerson', label: '监测人员', visible: true, type: 'input', group: 'detail' },
        { prop: 'isExceeded', label: '是否超标：0-否，1-是', visible: true, type: 'select', group: 'detail' },
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

  return new FieldConfigManager('radiationDoseMonitoring', fieldGroups);
}


// radiationDoseRecord字段配置
export function createRadiationDoseRecordFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'staffId', label: '工作人员ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'staffName', label: '工作人员姓名', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'recordDate', label: '记录日期', visible: true, type: 'date', group: 'detail' },
        { prop: 'recordPeriod', label: '记录周期：daily-日，monthly-月，quarterly-季度，yearly-年', visible: true, type: 'input', group: 'detail' },
        { prop: 'doseValue', label: '剂量值', visible: true, type: 'number', group: 'detail' },
        { prop: 'doseUnit', label: '剂量单位', visible: true, type: 'input', group: 'detail' },
        { prop: 'measurementMethod', label: '测量方法', visible: true, type: 'input', group: 'detail' },
        { prop: 'measurementDevice', label: '测量设备', visible: true, type: 'input', group: 'detail' },
        { prop: 'remarks', label: '备注', visible: true, type: 'input', group: 'detail' }
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

  return new FieldConfigManager('radiationDoseRecord', fieldGroups);
}


// radiationEquipmentInspection字段配置
export function createRadiationEquipmentInspectionFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'equipmentId', label: '设备ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'inspectorName', label: '检测人员', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'inspectionDate', label: '检测日期', visible: true, type: 'date', group: 'detail' },
        { prop: 'inspectionAgency', label: '检测机构', visible: true, type: 'input', group: 'detail' },
        { prop: 'inspectionResult', label: '检测结果：pass-合格，fail-不合格', visible: true, type: 'input', group: 'detail' },
        { prop: 'inspectionReport', label: '检测报告', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'nextInspectionDate', label: '下次检测日期', visible: true, type: 'date', group: 'detail' }
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

  return new FieldConfigManager('radiationEquipmentInspection', fieldGroups);
}


// radiationHealthExam字段配置
export function createRadiationHealthExamFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'workerId', label: '工作人员ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'examType', label: '体检类型', visible: true, type: 'input', group: 'basic' },
        { prop: 'diagnosis', label: '诊断结果', visible: true, type: 'textarea', group: 'basic' },
        { prop: 'status', label: '状态', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'examDate', label: '体检日期', visible: true, type: 'date', group: 'detail' },
        { prop: 'examHospital', label: '体检医院', visible: true, type: 'input', group: 'detail' },
        { prop: 'examDoctor', label: '体检医生', visible: true, type: 'input', group: 'detail' },
        { prop: 'examResults', label: '体检结果', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'recommendations', label: '建议', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'followUpRequired', label: '需要随访：0-否，1-是', visible: true, type: 'select', group: 'detail' },
        { prop: 'nextExamDate', label: '下次体检日期', visible: true, type: 'date', group: 'detail' }
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

  return new FieldConfigManager('radiationHealthExam', fieldGroups);
}


// radiationHealthExamPlan字段配置
export function createRadiationHealthExamPlanFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'planCode', label: '计划编码', visible: true, type: 'input', group: 'basic' },
        { prop: 'planName', label: '计划名称', visible: true, type: 'input', group: 'basic' },
        { prop: 'examType', label: '体检类型：annual-年度体检，special-专项体检', visible: true, type: 'input', group: 'basic' },
        { prop: 'status', label: '状态：planned-已计划，ongoing-进行中，completed-已完成，cancelled-已取消', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'plannedDate', label: '计划日期', visible: true, type: 'date', group: 'detail' },
        { prop: 'location', label: '体检地点', visible: true, type: 'input', group: 'detail' },
        { prop: 'examAgency', label: '体检机构', visible: true, type: 'input', group: 'detail' },
        { prop: 'targetStaff', label: '体检对象', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'reminderSent', label: '是否已发送提醒：0-否，1-是', visible: true, type: 'select', group: 'detail' },
        { prop: 'reminderTime', label: '提醒时间', visible: true, type: 'datetime', group: 'detail' }
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

  return new FieldConfigManager('radiationHealthExamPlan', fieldGroups);
}


// radiationHealthExamResult字段配置
export function createRadiationHealthExamResultFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'planId', label: '体检计划ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'staffId', label: '工作人员ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'staffName', label: '工作人员姓名', visible: true, type: 'input', group: 'basic' },
        { prop: 'examReportName', label: '体检报告文件名', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'examDate', label: '体检日期', visible: true, type: 'date', group: 'detail' },
        { prop: 'examResult', label: '体检结果：normal-正常，abnormal-异常', visible: true, type: 'input', group: 'detail' },
        { prop: 'examReportFile', label: '体检报告文件路径', visible: true, type: 'input', group: 'detail' },
        { prop: 'keyFindings', label: '主要发现', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'recommendations', label: '建议措施', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'followUpRequired', label: '是否需要随访：0-否，1-是', visible: true, type: 'select', group: 'detail' },
        { prop: 'followUpDate', label: '随访日期', visible: true, type: 'date', group: 'detail' }
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

  return new FieldConfigManager('radiationHealthExamResult', fieldGroups);
}


// radiationStaff字段配置
export function createRadiationStaffFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'userId', label: '用户ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'userName', label: '姓名', visible: true, type: 'input', group: 'basic' },
        { prop: 'employeeCode', label: '员工编码', visible: true, type: 'input', group: 'basic' },
        { prop: 'departmentId', label: '所在部门ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'departmentName', label: '所在部门名称', visible: true, type: 'input', group: 'basic' },
        { prop: 'status', label: '状态：active-在职，inactive-离职', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'position', label: '工作岗位', visible: true, type: 'input', group: 'detail' },
        { prop: 'hireDate', label: '入职日期', visible: true, type: 'date', group: 'detail' },
        { prop: 'radiationWorkYears', label: '放射工作年限', visible: true, type: 'number', group: 'detail' },
        { prop: 'radiationQualification', label: '放射资质', visible: true, type: 'input', group: 'detail' },
        { prop: 'qualificationCertificate', label: '资质证书', visible: true, type: 'input', group: 'detail' },
        { prop: 'certificateNumber', label: '证书编号', visible: true, type: 'input', group: 'detail' },
        { prop: 'certificateIssueDate', label: '证书发证日期', visible: true, type: 'date', group: 'detail' },
        { prop: 'certificateExpiryDate', label: '证书到期日期', visible: true, type: 'date', group: 'detail' },
        { prop: 'trainingRecords', label: '培训记录', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'healthExamRecords', label: '体检记录', visible: true, type: 'textarea', group: 'detail' }
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

  return new FieldConfigManager('radiationStaff', fieldGroups);
}


// radiationTraining字段配置
export function createRadiationTrainingFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'trainingCode', label: '培训编码', visible: true, type: 'input', group: 'basic' },
        { prop: 'trainingName', label: '培训名称', visible: true, type: 'input', group: 'basic' },
        { prop: 'trainingType', label: '培训类型', visible: true, type: 'input', group: 'basic' },
        { prop: 'status', label: '状态', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'trainingDate', label: '培训日期', visible: true, type: 'date', group: 'detail' },
        { prop: 'trainer', label: '培训师', visible: true, type: 'input', group: 'detail' },
        { prop: 'participants', label: '参与人员', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'trainingContent', label: '培训内容', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'trainingHours', label: '培训学时', visible: true, type: 'number', group: 'detail' },
        { prop: 'evaluationResults', label: '评估结果', visible: true, type: 'textarea', group: 'detail' }
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

  return new FieldConfigManager('radiationTraining', fieldGroups);
}


// radiationTrainingParticipant字段配置
export function createRadiationTrainingParticipantFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'planId', label: '培训计划ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'staffId', label: '工作人员ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'staffName', label: '工作人员姓名', visible: true, type: 'input', group: 'basic' },
        { prop: 'attendanceStatus', label: '出席状态：registered-已报名，attended-出席，absent-缺席', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'score', label: '培训成绩', visible: true, type: 'number', group: 'detail' },
        { prop: 'evaluation', label: '评价', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'certificateIssued', label: '是否发放证书：0-否，1-是', visible: true, type: 'select', group: 'detail' },
        { prop: 'certificateNumber', label: '证书编号', visible: true, type: 'input', group: 'detail' }
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

  return new FieldConfigManager('radiationTrainingParticipant', fieldGroups);
}


// radiationTrainingPlan字段配置
export function createRadiationTrainingPlanFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'planCode', label: '计划编码', visible: true, type: 'input', group: 'basic' },
        { prop: 'planName', label: '计划名称', visible: true, type: 'input', group: 'basic' },
        { prop: 'trainingType', label: '培训类型：radiation-放射防护，safety-安全培训，emergency-应急培训', visible: true, type: 'input', group: 'basic' },
        { prop: 'status', label: '状态：planned-已计划，ongoing-进行中，completed-已完成，cancelled-已取消', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'plannedDate', label: '计划日期', visible: true, type: 'date', group: 'detail' },
        { prop: 'plannedTime', label: '计划时间', visible: true, type: 'input', group: 'detail' },
        { prop: 'location', label: '培训地点', visible: true, type: 'input', group: 'detail' },
        { prop: 'trainer', label: '培训师', visible: true, type: 'input', group: 'detail' },
        { prop: 'trainingContent', label: '培训内容', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'targetAudience', label: '培训对象', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'reminderSent', label: '是否已发送提醒：0-否，1-是', visible: true, type: 'select', group: 'detail' },
        { prop: 'reminderTime', label: '提醒时间', visible: true, type: 'datetime', group: 'detail' }
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

  return new FieldConfigManager('radiationTrainingPlan', fieldGroups);
}


// radiationWorker字段配置
export function createRadiationWorkerFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'workerCode', label: '工作人员编码', visible: true, type: 'input', group: 'basic' },
        { prop: 'workerName', label: '工作人员姓名', visible: true, type: 'input', group: 'basic' },
        { prop: 'radiationType', label: '接触辐射类型', visible: true, type: 'input', group: 'basic' },
        { prop: 'healthStatus', label: '健康状况', visible: true, type: 'input', group: 'basic' },
        { prop: 'status', label: '状态', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'department', label: '所属部门', visible: true, type: 'input', group: 'detail' },
        { prop: 'position', label: '职位', visible: true, type: 'input', group: 'detail' },
        { prop: 'employmentDate', label: '入职日期', visible: true, type: 'date', group: 'detail' },
        { prop: 'contactInfo', label: '联系方式', visible: true, type: 'input', group: 'detail' },
        { prop: 'emergencyContact', label: '紧急联系人', visible: true, type: 'input', group: 'detail' }
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

  return new FieldConfigManager('radiationWorker', fieldGroups);
}
