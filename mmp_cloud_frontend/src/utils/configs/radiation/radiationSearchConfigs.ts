import { SearchConfigManager, SearchFieldGroup } from '../searchConfigManager';

// radiationDoseAlert搜索配置
export function createRadiationDoseAlertSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'alertType', label: '预警类型：monthly-月度预警，quarterly-季度预警，yearly-年度预警', type: 'input', visible: true, placeholder: '请输入预警类型：monthly-月度预警，quarterly-季度预警，yearly-年度预警' },
        { prop: 'alertLevel', label: '预警级别：low-低，medium-中，high-高', type: 'input', visible: true, placeholder: '请输入预警级别：low-低，medium-中，high-高' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'thresholdValue', label: '阈值', type: 'number', visible: true, placeholder: '请输入阈值' },
        { prop: 'isActive', label: '是否启用：0-否，1-是', type: 'select', visible: false, placeholder: '请输入是否启用：0-否，1-是' }
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

  return new SearchConfigManager('radiationDoseAlert', searchFieldGroups);
}


// radiationDoseAlertRecord搜索配置
export function createRadiationDoseAlertRecordSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'staffId', label: '工作人员ID', type: 'number', visible: true, placeholder: '请输入工作人员ID' },
        { prop: 'staffName', label: '工作人员姓名', type: 'input', visible: true, placeholder: '请输入工作人员姓名' },
        { prop: 'alertType', label: '预警类型', type: 'input', visible: true, placeholder: '请输入预警类型' },
        { prop: 'alertLevel', label: '预警级别', type: 'input', visible: false, placeholder: '请输入预警级别' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'alertDate', label: '预警日期', type: 'daterange', visible: false, placeholder: '请输入预警日期', startProp: 'alertDateStart', endProp: 'alertDateEnd' },
        { prop: 'currentDose', label: '当前剂量', type: 'number', visible: false, placeholder: '请输入当前剂量' },
        { prop: 'thresholdValue', label: '阈值', type: 'number', visible: false, placeholder: '请输入阈值' },
        { prop: 'alertMessage', label: '预警信息', type: 'input', visible: false, placeholder: '请输入预警信息' },
        { prop: 'isHandled', label: '是否已处理：0-否，1-是', type: 'select', visible: false, placeholder: '请输入是否已处理：0-否，1-是' },
        { prop: 'handler', label: '处理人', type: 'input', visible: false, placeholder: '请输入处理人' },
        { prop: 'handleTime', label: '处理时间', type: 'daterange', visible: false, placeholder: '请输入处理时间', startProp: 'handleTimeStart', endProp: 'handleTimeEnd' },
        { prop: 'handleResult', label: '处理结果', type: 'input', visible: false, placeholder: '请输入处理结果' }
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

  return new SearchConfigManager('radiationDoseAlertRecord', searchFieldGroups);
}


// radiationDoseMonitoring搜索配置
export function createRadiationDoseMonitoringSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'workerId', label: '工作人员ID', type: 'number', visible: true, placeholder: '请输入工作人员ID' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'monitoringDate', label: '监测日期', type: 'daterange', visible: true, placeholder: '请输入监测日期', startProp: 'monitoringDateStart', endProp: 'monitoringDateEnd' },
        { prop: 'monitoringPeriod', label: '监测周期', type: 'input', visible: true, placeholder: '请输入监测周期' },
        { prop: 'doseValue', label: '剂量值', type: 'number', visible: false, placeholder: '请输入剂量值' },
        { prop: 'doseUnit', label: '剂量单位', type: 'input', visible: false, placeholder: '请输入剂量单位' },
        { prop: 'monitoringMethod', label: '监测方法', type: 'input', visible: false, placeholder: '请输入监测方法' },
        { prop: 'monitoringDevice', label: '监测设备', type: 'input', visible: false, placeholder: '请输入监测设备' },
        { prop: 'monitoringPerson', label: '监测人员', type: 'input', visible: false, placeholder: '请输入监测人员' },
        { prop: 'isExceeded', label: '是否超标：0-否，1-是', type: 'select', visible: false, placeholder: '请输入是否超标：0-否，1-是' },
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

  return new SearchConfigManager('radiationDoseMonitoring', searchFieldGroups);
}


// radiationDoseRecord搜索配置
export function createRadiationDoseRecordSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'staffId', label: '工作人员ID', type: 'number', visible: true, placeholder: '请输入工作人员ID' },
        { prop: 'staffName', label: '工作人员姓名', type: 'input', visible: true, placeholder: '请输入工作人员姓名' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'recordDate', label: '记录日期', type: 'daterange', visible: true, placeholder: '请输入记录日期', startProp: 'recordDateStart', endProp: 'recordDateEnd' },
        { prop: 'recordPeriod', label: '记录周期：daily-日，monthly-月，quarterly-季度，yearly-年', type: 'input', visible: false, placeholder: '请输入记录周期：daily-日，monthly-月，quarterly-季度，yearly-年' },
        { prop: 'doseValue', label: '剂量值', type: 'number', visible: false, placeholder: '请输入剂量值' },
        { prop: 'doseUnit', label: '剂量单位', type: 'input', visible: false, placeholder: '请输入剂量单位' },
        { prop: 'measurementMethod', label: '测量方法', type: 'input', visible: false, placeholder: '请输入测量方法' },
        { prop: 'measurementDevice', label: '测量设备', type: 'input', visible: false, placeholder: '请输入测量设备' },
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

  return new SearchConfigManager('radiationDoseRecord', searchFieldGroups);
}


// radiationEquipmentInspection搜索配置
export function createRadiationEquipmentInspectionSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'equipmentId', label: '设备ID', type: 'number', visible: true, placeholder: '请输入设备ID' },
        { prop: 'inspectorName', label: '检测人员', type: 'input', visible: true, placeholder: '请输入检测人员' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'inspectionDate', label: '检测日期', type: 'daterange', visible: true, placeholder: '请输入检测日期', startProp: 'inspectionDateStart', endProp: 'inspectionDateEnd' },
        { prop: 'inspectionAgency', label: '检测机构', type: 'input', visible: false, placeholder: '请输入检测机构' },
        { prop: 'inspectionResult', label: '检测结果：pass-合格，fail-不合格', type: 'input', visible: false, placeholder: '请输入检测结果：pass-合格，fail-不合格' },
        { prop: 'inspectionReport', label: '检测报告', type: 'input', visible: false, placeholder: '请输入检测报告' },
        { prop: 'nextInspectionDate', label: '下次检测日期', type: 'daterange', visible: false, placeholder: '请输入下次检测日期', startProp: 'nextInspectionDateStart', endProp: 'nextInspectionDateEnd' }
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

  return new SearchConfigManager('radiationEquipmentInspection', searchFieldGroups);
}


// radiationHealthExam搜索配置
export function createRadiationHealthExamSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'workerId', label: '工作人员ID', type: 'number', visible: true, placeholder: '请输入工作人员ID' },
        { prop: 'examType', label: '体检类型', type: 'input', visible: true, placeholder: '请输入体检类型' },
        { prop: 'diagnosis', label: '诊断结果', type: 'input', visible: true, placeholder: '请输入诊断结果' },
        { prop: 'status', label: '状态', type: 'input', visible: false, placeholder: '请输入状态' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'examDate', label: '体检日期', type: 'daterange', visible: false, placeholder: '请输入体检日期', startProp: 'examDateStart', endProp: 'examDateEnd' },
        { prop: 'examHospital', label: '体检医院', type: 'input', visible: false, placeholder: '请输入体检医院' },
        { prop: 'examDoctor', label: '体检医生', type: 'input', visible: false, placeholder: '请输入体检医生' },
        { prop: 'examResults', label: '体检结果', type: 'input', visible: false, placeholder: '请输入体检结果' },
        { prop: 'recommendations', label: '建议', type: 'input', visible: false, placeholder: '请输入建议' },
        { prop: 'followUpRequired', label: '需要随访：0-否，1-是', type: 'select', visible: false, placeholder: '请输入需要随访：0-否，1-是' },
        { prop: 'nextExamDate', label: '下次体检日期', type: 'daterange', visible: false, placeholder: '请输入下次体检日期', startProp: 'nextExamDateStart', endProp: 'nextExamDateEnd' }
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

  return new SearchConfigManager('radiationHealthExam', searchFieldGroups);
}


// radiationHealthExamPlan搜索配置
export function createRadiationHealthExamPlanSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'planCode', label: '计划编码', type: 'input', visible: true, placeholder: '请输入计划编码' },
        { prop: 'planName', label: '计划名称', type: 'input', visible: true, placeholder: '请输入计划名称' },
        { prop: 'examType', label: '体检类型：annual-年度体检，special-专项体检', type: 'input', visible: true, placeholder: '请输入体检类型：annual-年度体检，special-专项体检' },
        { prop: 'status', label: '状态：planned-已计划，ongoing-进行中，completed-已完成，cancelled-已取消', type: 'input', visible: false, placeholder: '请输入状态：planned-已计划，ongoing-进行中，completed-已完成，cancelled-已取消' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'plannedDate', label: '计划日期', type: 'daterange', visible: false, placeholder: '请输入计划日期', startProp: 'plannedDateStart', endProp: 'plannedDateEnd' },
        { prop: 'location', label: '体检地点', type: 'input', visible: false, placeholder: '请输入体检地点' },
        { prop: 'examAgency', label: '体检机构', type: 'input', visible: false, placeholder: '请输入体检机构' },
        { prop: 'targetStaff', label: '体检对象', type: 'input', visible: false, placeholder: '请输入体检对象' },
        { prop: 'reminderSent', label: '是否已发送提醒：0-否，1-是', type: 'select', visible: false, placeholder: '请输入是否已发送提醒：0-否，1-是' },
        { prop: 'reminderTime', label: '提醒时间', type: 'daterange', visible: false, placeholder: '请输入提醒时间', startProp: 'reminderTimeStart', endProp: 'reminderTimeEnd' }
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

  return new SearchConfigManager('radiationHealthExamPlan', searchFieldGroups);
}


// radiationHealthExamResult搜索配置
export function createRadiationHealthExamResultSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'planId', label: '体检计划ID', type: 'number', visible: true, placeholder: '请输入体检计划ID' },
        { prop: 'staffId', label: '工作人员ID', type: 'number', visible: true, placeholder: '请输入工作人员ID' },
        { prop: 'staffName', label: '工作人员姓名', type: 'input', visible: true, placeholder: '请输入工作人员姓名' },
        { prop: 'examReportName', label: '体检报告文件名', type: 'input', visible: false, placeholder: '请输入体检报告文件名' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'examDate', label: '体检日期', type: 'daterange', visible: false, placeholder: '请输入体检日期', startProp: 'examDateStart', endProp: 'examDateEnd' },
        { prop: 'examResult', label: '体检结果：normal-正常，abnormal-异常', type: 'input', visible: false, placeholder: '请输入体检结果：normal-正常，abnormal-异常' },
        { prop: 'examReportFile', label: '体检报告文件路径', type: 'input', visible: false, placeholder: '请输入体检报告文件路径' },
        { prop: 'keyFindings', label: '主要发现', type: 'input', visible: false, placeholder: '请输入主要发现' },
        { prop: 'recommendations', label: '建议措施', type: 'input', visible: false, placeholder: '请输入建议措施' },
        { prop: 'followUpRequired', label: '是否需要随访：0-否，1-是', type: 'select', visible: false, placeholder: '请输入是否需要随访：0-否，1-是' },
        { prop: 'followUpDate', label: '随访日期', type: 'daterange', visible: false, placeholder: '请输入随访日期', startProp: 'followUpDateStart', endProp: 'followUpDateEnd' }
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

  return new SearchConfigManager('radiationHealthExamResult', searchFieldGroups);
}


// radiationStaff搜索配置
export function createRadiationStaffSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'userId', label: '用户ID', type: 'number', visible: true, placeholder: '请输入用户ID' },
        { prop: 'userName', label: '姓名', type: 'input', visible: true, placeholder: '请输入姓名' },
        { prop: 'employeeCode', label: '员工编码', type: 'input', visible: true, placeholder: '请输入员工编码' },
        { prop: 'departmentId', label: '所在部门ID', type: 'number', visible: false, placeholder: '请输入所在部门ID' },
        { prop: 'departmentName', label: '所在部门名称', type: 'input', visible: false, placeholder: '请输入所在部门名称' },
        { prop: 'status', label: '状态：active-在职，inactive-离职', type: 'input', visible: false, placeholder: '请输入状态：active-在职，inactive-离职' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'position', label: '工作岗位', type: 'input', visible: false, placeholder: '请输入工作岗位' },
        { prop: 'hireDate', label: '入职日期', type: 'daterange', visible: false, placeholder: '请输入入职日期', startProp: 'hireDateStart', endProp: 'hireDateEnd' },
        { prop: 'radiationWorkYears', label: '放射工作年限', type: 'number', visible: false, placeholder: '请输入放射工作年限' },
        { prop: 'radiationQualification', label: '放射资质', type: 'input', visible: false, placeholder: '请输入放射资质' },
        { prop: 'qualificationCertificate', label: '资质证书', type: 'input', visible: false, placeholder: '请输入资质证书' },
        { prop: 'certificateNumber', label: '证书编号', type: 'input', visible: false, placeholder: '请输入证书编号' },
        { prop: 'certificateIssueDate', label: '证书发证日期', type: 'daterange', visible: false, placeholder: '请输入证书发证日期', startProp: 'certificateIssueDateStart', endProp: 'certificateIssueDateEnd' },
        { prop: 'certificateExpiryDate', label: '证书到期日期', type: 'daterange', visible: false, placeholder: '请输入证书到期日期', startProp: 'certificateExpiryDateStart', endProp: 'certificateExpiryDateEnd' },
        { prop: 'trainingRecords', label: '培训记录', type: 'input', visible: false, placeholder: '请输入培训记录' },
        { prop: 'healthExamRecords', label: '体检记录', type: 'input', visible: false, placeholder: '请输入体检记录' }
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

  return new SearchConfigManager('radiationStaff', searchFieldGroups);
}


// radiationTraining搜索配置
export function createRadiationTrainingSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'trainingCode', label: '培训编码', type: 'input', visible: true, placeholder: '请输入培训编码' },
        { prop: 'trainingName', label: '培训名称', type: 'input', visible: true, placeholder: '请输入培训名称' },
        { prop: 'trainingType', label: '培训类型', type: 'input', visible: true, placeholder: '请输入培训类型' },
        { prop: 'status', label: '状态', type: 'input', visible: false, placeholder: '请输入状态' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'trainingDate', label: '培训日期', type: 'daterange', visible: false, placeholder: '请输入培训日期', startProp: 'trainingDateStart', endProp: 'trainingDateEnd' },
        { prop: 'trainer', label: '培训师', type: 'input', visible: false, placeholder: '请输入培训师' },
        { prop: 'participants', label: '参与人员', type: 'input', visible: false, placeholder: '请输入参与人员' },
        { prop: 'trainingContent', label: '培训内容', type: 'input', visible: false, placeholder: '请输入培训内容' },
        { prop: 'trainingHours', label: '培训学时', type: 'number', visible: false, placeholder: '请输入培训学时' },
        { prop: 'evaluationResults', label: '评估结果', type: 'input', visible: false, placeholder: '请输入评估结果' }
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

  return new SearchConfigManager('radiationTraining', searchFieldGroups);
}


// radiationTrainingParticipant搜索配置
export function createRadiationTrainingParticipantSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'planId', label: '培训计划ID', type: 'number', visible: true, placeholder: '请输入培训计划ID' },
        { prop: 'staffId', label: '工作人员ID', type: 'number', visible: true, placeholder: '请输入工作人员ID' },
        { prop: 'staffName', label: '工作人员姓名', type: 'input', visible: true, placeholder: '请输入工作人员姓名' },
        { prop: 'attendanceStatus', label: '出席状态：registered-已报名，attended-出席，absent-缺席', type: 'input', visible: false, placeholder: '请输入出席状态：registered-已报名，attended-出席，absent-缺席' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'score', label: '培训成绩', type: 'number', visible: false, placeholder: '请输入培训成绩' },
        { prop: 'evaluation', label: '评价', type: 'input', visible: false, placeholder: '请输入评价' },
        { prop: 'certificateIssued', label: '是否发放证书：0-否，1-是', type: 'select', visible: false, placeholder: '请输入是否发放证书：0-否，1-是' },
        { prop: 'certificateNumber', label: '证书编号', type: 'input', visible: false, placeholder: '请输入证书编号' }
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

  return new SearchConfigManager('radiationTrainingParticipant', searchFieldGroups);
}


// radiationTrainingPlan搜索配置
export function createRadiationTrainingPlanSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'planCode', label: '计划编码', type: 'input', visible: true, placeholder: '请输入计划编码' },
        { prop: 'planName', label: '计划名称', type: 'input', visible: true, placeholder: '请输入计划名称' },
        { prop: 'trainingType', label: '培训类型：radiation-放射防护，safety-安全培训，emergency-应急培训', type: 'input', visible: true, placeholder: '请输入培训类型：radiation-放射防护，safety-安全培训，emergency-应急培训' },
        { prop: 'status', label: '状态：planned-已计划，ongoing-进行中，completed-已完成，cancelled-已取消', type: 'input', visible: false, placeholder: '请输入状态：planned-已计划，ongoing-进行中，completed-已完成，cancelled-已取消' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'plannedDate', label: '计划日期', type: 'daterange', visible: false, placeholder: '请输入计划日期', startProp: 'plannedDateStart', endProp: 'plannedDateEnd' },
        { prop: 'plannedTime', label: '计划时间', type: 'input', visible: false, placeholder: '请输入计划时间' },
        { prop: 'location', label: '培训地点', type: 'input', visible: false, placeholder: '请输入培训地点' },
        { prop: 'trainer', label: '培训师', type: 'input', visible: false, placeholder: '请输入培训师' },
        { prop: 'trainingContent', label: '培训内容', type: 'input', visible: false, placeholder: '请输入培训内容' },
        { prop: 'targetAudience', label: '培训对象', type: 'input', visible: false, placeholder: '请输入培训对象' },
        { prop: 'reminderSent', label: '是否已发送提醒：0-否，1-是', type: 'select', visible: false, placeholder: '请输入是否已发送提醒：0-否，1-是' },
        { prop: 'reminderTime', label: '提醒时间', type: 'daterange', visible: false, placeholder: '请输入提醒时间', startProp: 'reminderTimeStart', endProp: 'reminderTimeEnd' }
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

  return new SearchConfigManager('radiationTrainingPlan', searchFieldGroups);
}


// radiationWorker搜索配置
export function createRadiationWorkerSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'workerCode', label: '工作人员编码', type: 'input', visible: true, placeholder: '请输入工作人员编码' },
        { prop: 'workerName', label: '工作人员姓名', type: 'input', visible: true, placeholder: '请输入工作人员姓名' },
        { prop: 'radiationType', label: '接触辐射类型', type: 'input', visible: true, placeholder: '请输入接触辐射类型' },
        { prop: 'healthStatus', label: '健康状况', type: 'input', visible: false, placeholder: '请输入健康状况' },
        { prop: 'status', label: '状态', type: 'input', visible: false, placeholder: '请输入状态' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'department', label: '所属部门', type: 'input', visible: false, placeholder: '请输入所属部门' },
        { prop: 'position', label: '职位', type: 'input', visible: false, placeholder: '请输入职位' },
        { prop: 'employmentDate', label: '入职日期', type: 'daterange', visible: false, placeholder: '请输入入职日期', startProp: 'employmentDateStart', endProp: 'employmentDateEnd' },
        { prop: 'contactInfo', label: '联系方式', type: 'input', visible: false, placeholder: '请输入联系方式' },
        { prop: 'emergencyContact', label: '紧急联系人', type: 'input', visible: false, placeholder: '请输入紧急联系人' }
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

  return new SearchConfigManager('radiationWorker', searchFieldGroups);
}
