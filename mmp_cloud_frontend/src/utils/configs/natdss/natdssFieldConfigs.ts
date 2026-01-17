import { FieldConfigManager, FieldGroup } from '../fieldConfigManager';

// natdssB011DrugPurchase字段配置
export function createNatdssB011DrugPurchaseFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '系统自增主键', visible: true, type: 'number', group: 'basic' },
        { prop: 'hosDrugCode', label: '本院药品编码', visible: true, type: 'input', group: 'basic' },
        { prop: 'genericName', label: '药品通用名', visible: true, type: 'input', group: 'basic' },
        { prop: 'tradeName', label: '药品商品名', visible: true, type: 'input', group: 'basic' },
        { prop: 'approvalNo', label: '批准文号', visible: true, type: 'input', group: 'basic' },
        { prop: 'insuranceType', label: '费用类型', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'purSn', label: '药品入库明细流水号', visible: true, type: 'input', group: 'detail' },
        { prop: 'manufac', label: '生产厂家', visible: true, type: 'input', group: 'detail' },
        { prop: 'form', label: '药品剂型', visible: true, type: 'input', group: 'detail' },
        { prop: 'spec', label: '药品规格', visible: true, type: 'input', group: 'detail' },
        { prop: 'packingQuantity', label: '包装数量', visible: true, type: 'input', group: 'detail' },
        { prop: 'packingUnit', label: '包装单位', visible: true, type: 'input', group: 'detail' },
        { prop: 'purUnitPrice', label: '药品单价', visible: true, type: 'number', group: 'detail' },
        { prop: 'purQuantity', label: '采购数量', visible: true, type: 'number', group: 'detail' },
        { prop: 'purTotalPrice', label: '采购金额', visible: true, type: 'number', group: 'detail' },
        { prop: 'purDate', label: '采购时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'createdTime', label: '创建时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'updatedTime', label: '更新时间', visible: true, type: 'datetime', group: 'detail' }
      ]
    }
  ];

  return new FieldConfigManager('natdssB011DrugPurchase', fieldGroups);
}


// natdssB012DrugUse字段配置
export function createNatdssB012DrugUseFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '系统自增主键', visible: true, type: 'number', group: 'basic' },
        { prop: 'hosDrugCode', label: '本院药品编码', visible: true, type: 'input', group: 'basic' },
        { prop: 'genericName', label: '药品通用名', visible: true, type: 'input', group: 'basic' },
        { prop: 'tradeName', label: '药品商品名', visible: true, type: 'input', group: 'basic' },
        { prop: 'approvalNo', label: '批准文号', visible: true, type: 'input', group: 'basic' },
        { prop: 'insuranceType', label: '费用类型', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'presSn', label: '药品使用流水号', visible: true, type: 'input', group: 'detail' },
        { prop: 'manufac', label: '生产厂家', visible: true, type: 'input', group: 'detail' },
        { prop: 'form', label: '药品剂型', visible: true, type: 'input', group: 'detail' },
        { prop: 'spec', label: '药品规格', visible: true, type: 'input', group: 'detail' },
        { prop: 'packingQuantity', label: '包装数量', visible: true, type: 'input', group: 'detail' },
        { prop: 'packingUnit', label: '包装单位', visible: true, type: 'input', group: 'detail' },
        { prop: 'presUnitPrice', label: '药品单价', visible: true, type: 'number', group: 'detail' },
        { prop: 'presQuantity', label: '使用数量', visible: true, type: 'number', group: 'detail' },
        { prop: 'presTotalPrice', label: '使用金额', visible: true, type: 'number', group: 'detail' },
        { prop: 'presOrigin', label: '来源:门诊/住院', visible: true, type: 'input', group: 'detail' },
        { prop: 'presDate', label: '收费时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'createdTime', label: '创建时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'updatedTime', label: '更新时间', visible: true, type: 'datetime', group: 'detail' }
      ]
    }
  ];

  return new FieldConfigManager('natdssB012DrugUse', fieldGroups);
}


// natdssB021PatientInfo字段配置
export function createNatdssB021PatientInfoFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '系统自增主键', visible: true, type: 'number', group: 'basic' },
        { prop: 'patientId', label: '患者ID-患者在本院信息系统内的唯一标识', visible: true, type: 'input', group: 'basic' },
        { prop: 'visitType', label: '就诊类型:住院、门诊', visible: true, type: 'input', group: 'basic' },
        { prop: 'visitCardNo', label: '就诊卡号', visible: true, type: 'input', group: 'basic' },
        { prop: 'outpatientNo', label: '门诊号', visible: true, type: 'input', group: 'basic' },
        { prop: 'medicalRecordNo', label: '病案号', visible: true, type: 'input', group: 'basic' },
        { prop: 'inpatientNo', label: '住院号', visible: true, type: 'input', group: 'basic' },
        { prop: 'visitDoctorNo', label: '就诊医生代码', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'visitSn', label: '单次就诊唯一标识号', visible: true, type: 'input', group: 'detail' },
        { prop: 'visitTimes', label: '就诊次数', visible: true, type: 'number', group: 'detail' },
        { prop: 'visitDatetime', label: '就诊时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'hospitalizationTimes', label: '住院次数', visible: true, type: 'input', group: 'detail' },
        { prop: 'admissionDatetime', label: '入院时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'dischargeDatetime', label: '出院时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'name', label: '姓名', visible: true, type: 'input', group: 'detail' },
        { prop: 'gender', label: '性别:男、女、未知', visible: true, type: 'input', group: 'detail' },
        { prop: 'dateOfBirth', label: '出生日期', visible: true, type: 'date', group: 'detail' },
        { prop: 'occupationCode', label: '职业类别代码', visible: true, type: 'input', group: 'detail' },
        { prop: 'occupationName', label: '职业类别名称', visible: true, type: 'input', group: 'detail' },
        { prop: 'nationality', label: '国籍', visible: true, type: 'input', group: 'detail' },
        { prop: 'ethnicity', label: '民族', visible: true, type: 'input', group: 'detail' },
        { prop: 'education', label: '文化程度', visible: true, type: 'input', group: 'detail' },
        { prop: 'maritalStatus', label: '婚姻状况类别', visible: true, type: 'input', group: 'detail' },
        { prop: 'newbronMark', label: '是否新生儿', visible: true, type: 'input', group: 'detail' },
        { prop: 'certificateType', label: '证件类型', visible: true, type: 'input', group: 'detail' },
        { prop: 'certificateNo', label: '证件号码', visible: true, type: 'input', group: 'detail' },
        { prop: 'healthCardType', label: '健康卡类型', visible: true, type: 'input', group: 'detail' },
        { prop: 'healthCardNo', label: '健康卡号', visible: true, type: 'input', group: 'detail' },
        { prop: 'insuranceType', label: '医保类型', visible: true, type: 'input', group: 'detail' },
        { prop: 'insuranceNo', label: '医保卡号', visible: true, type: 'input', group: 'detail' },
        { prop: 'residenceProvince', label: '户籍地址-省名称', visible: true, type: 'input', group: 'detail' },
        { prop: 'residenceCity', label: '户籍地址-市名称', visible: true, type: 'input', group: 'detail' },
        { prop: 'residenceCounty', label: '户籍地址-县名称', visible: true, type: 'input', group: 'detail' },
        { prop: 'currentAddress', label: '现住址', visible: true, type: 'input', group: 'detail' },
        { prop: 'phoneNo', label: '联系电话', visible: true, type: 'input', group: 'detail' },
        { prop: 'phoneNo2', label: '联系电话2', visible: true, type: 'input', group: 'detail' },
        { prop: 'email', label: '邮箱', visible: true, type: 'input', group: 'detail' },
        { prop: 'weixin', label: '微信', visible: true, type: 'input', group: 'detail' },
        { prop: 'contactPerson1', label: '紧急联系人1', visible: true, type: 'input', group: 'detail' },
        { prop: 'contactPhoneNo1', label: '紧急联系人电话1', visible: true, type: 'input', group: 'detail' },
        { prop: 'contactPerson2', label: '紧急联系人2', visible: true, type: 'input', group: 'detail' },
        { prop: 'contactPhoneNo2', label: '紧急联系人电话2', visible: true, type: 'input', group: 'detail' },
        { prop: 'aboBloodType', label: 'ABO血型', visible: true, type: 'input', group: 'detail' },
        { prop: 'rhBloodType', label: 'Rh血型', visible: true, type: 'input', group: 'detail' },
        { prop: 'extendData1', label: '扩展字段1', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'extendData2', label: '扩展字段2', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'recordStatus', label: '记录状态:1正常 0作废', visible: true, type: 'number', group: 'detail' },
        { prop: 'createdTime', label: '创建时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'updatedTime', label: '更新时间', visible: true, type: 'datetime', group: 'detail' }
      ]
    }
  ];

  return new FieldConfigManager('natdssB021PatientInfo', fieldGroups);
}


// natdssB022AdrInfo字段配置
export function createNatdssB022AdrInfoFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '系统自增主键', visible: true, type: 'number', group: 'basic' },
        { prop: 'patientId', label: '患者ID', visible: true, type: 'input', group: 'basic' },
        { prop: 'visitType', label: '就诊类型:住院、门诊', visible: true, type: 'input', group: 'basic' },
        { prop: 'visitCardNo', label: '就诊卡号', visible: true, type: 'input', group: 'basic' },
        { prop: 'medicalRecordNo', label: '病案号', visible: true, type: 'input', group: 'basic' },
        { prop: 'outpatientNo', label: '门诊号', visible: true, type: 'input', group: 'basic' },
        { prop: 'inpatientNo', label: '住院号', visible: true, type: 'input', group: 'basic' },
        { prop: 'name', label: '姓名', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'visitSn', label: '单次就诊唯一标识号', visible: true, type: 'input', group: 'detail' },
        { prop: 'visitTimes', label: '就诊次数', visible: true, type: 'number', group: 'detail' },
        { prop: 'hospitalizationTimes', label: '住院次数', visible: true, type: 'input', group: 'detail' },
        { prop: 'adrEventSn', label: '药品不良反应流水号', visible: true, type: 'input', group: 'detail' },
        { prop: 'adrReportStatus', label: '药品不良反应报告状态', visible: true, type: 'input', group: 'detail' },
        { prop: 'adrReportType', label: '药品不良反应报告类型', visible: true, type: 'input', group: 'detail' },
        { prop: 'adrReportTime', label: '报告时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'adrOriginalDisease', label: '患者原患疾病', visible: true, type: 'input', group: 'detail' },
        { prop: 'adrDiseaseInfluence', label: '对原患疾病的影响', visible: true, type: 'input', group: 'detail' },
        { prop: 'adrFamilyStatus', label: '家族药品不良反应', visible: true, type: 'input', group: 'detail' },
        { prop: 'adrPastStatus', label: '既往药品不良反应', visible: true, type: 'input', group: 'detail' },
        { prop: 'adrPastOther', label: '其他既往信息', visible: true, type: 'input', group: 'detail' },
        { prop: 'adrEventName', label: '药品不良反应事件名称', visible: true, type: 'input', group: 'detail' },
        { prop: 'adrEventTime', label: '不良事件发生时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'adrEventContent', label: '不良事件过程描述', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'adrEventResult', label: '不良反应结果', visible: true, type: 'input', group: 'detail' },
        { prop: 'adrStopStatus', label: '停药或减药后是否减轻或消失', visible: true, type: 'input', group: 'detail' },
        { prop: 'adrReuseStatus', label: '再次使用药物后是否出现同样反应', visible: true, type: 'input', group: 'detail' },
        { prop: 'suspectDrugApprovalNo', label: '怀疑药品批准文号', visible: true, type: 'input', group: 'detail' },
        { prop: 'suspectDrugCode', label: '怀疑药品编码', visible: true, type: 'input', group: 'detail' },
        { prop: 'suspectDrugTradeName', label: '怀疑药品商品名', visible: true, type: 'input', group: 'detail' },
        { prop: 'suspectDrugGenericName', label: '怀疑药品通用名', visible: true, type: 'input', group: 'detail' },
        { prop: 'suspectDrugManufac', label: '怀疑药品生产厂商', visible: true, type: 'input', group: 'detail' },
        { prop: 'suspectDrugBatchNo', label: '怀疑药品生产批号', visible: true, type: 'input', group: 'detail' },
        { prop: 'suspectDrugDosage', label: '怀疑药品用量', visible: true, type: 'input', group: 'detail' },
        { prop: 'suspectDrugMethod', label: '怀疑药品给药途径', visible: true, type: 'input', group: 'detail' },
        { prop: 'suspectDrugStartTime', label: '怀疑药品开始时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'suspectDrugEndTime', label: '怀疑药品结束时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'suspectDrugReason', label: '怀疑药品用药原因', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'concomitantDrugApprovalNo', label: '合并药品批准文号', visible: true, type: 'input', group: 'detail' },
        { prop: 'concomitantDrugCode', label: '合并药品编码', visible: true, type: 'input', group: 'detail' },
        { prop: 'concomitantDrugTradeName', label: '合并药品商品名', visible: true, type: 'input', group: 'detail' },
        { prop: 'concomitantDrugGenericName', label: '合并药品通用名', visible: true, type: 'input', group: 'detail' },
        { prop: 'concomitantDrugManufac', label: '合并药品生产厂商', visible: true, type: 'input', group: 'detail' },
        { prop: 'concomitantDrugBatchNo', label: '合并药品生产批号', visible: true, type: 'input', group: 'detail' },
        { prop: 'concomitantDrugDosage', label: '合并药品用量', visible: true, type: 'input', group: 'detail' },
        { prop: 'concomitantDrugMethod', label: '合并药品给药途径', visible: true, type: 'input', group: 'detail' },
        { prop: 'concomitantDrugStartTime', label: '合并药品开始时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'concomitantDrugEndTime', label: '合并药品结束时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'concomitantDrugReason', label: '合并药品用药原因', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'adrReporterAppraise', label: '关联性报告人评价', visible: true, type: 'input', group: 'detail' },
        { prop: 'adrReportUnitAppraise', label: '关联性报告单位评价', visible: true, type: 'input', group: 'detail' },
        { prop: 'extendData1', label: '扩展字段1:填写怀疑用药或并用药品', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'extendData2', label: '扩展字段2', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'recordStatus', label: '记录状态:1正常 0作废', visible: true, type: 'number', group: 'detail' },
        { prop: 'createdTime', label: '创建时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'updatedTime', label: '更新时间', visible: true, type: 'datetime', group: 'detail' }
      ]
    }
  ];

  return new FieldConfigManager('natdssB022AdrInfo', fieldGroups);
}


// natdssB023DiagInfo字段配置
export function createNatdssB023DiagInfoFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '系统自增主键', visible: true, type: 'number', group: 'basic' },
        { prop: 'patientId', label: '患者ID', visible: true, type: 'input', group: 'basic' },
        { prop: 'visitType', label: '就诊类型:住院、门诊', visible: true, type: 'input', group: 'basic' },
        { prop: 'visitCardNo', label: '就诊卡号', visible: true, type: 'input', group: 'basic' },
        { prop: 'medicalRecordNo', label: '病案号', visible: true, type: 'input', group: 'basic' },
        { prop: 'outpatientNo', label: '门诊号', visible: true, type: 'input', group: 'basic' },
        { prop: 'inpatientNo', label: '住院号', visible: true, type: 'input', group: 'basic' },
        { prop: 'name', label: '患者姓名', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'visitSn', label: '单次就诊唯一标识号', visible: true, type: 'input', group: 'detail' },
        { prop: 'visitTimes', label: '就诊次数', visible: true, type: 'number', group: 'detail' },
        { prop: 'hospitalizationTimes', label: '住院次数', visible: true, type: 'input', group: 'detail' },
        { prop: 'diagId', label: '诊断ID号', visible: true, type: 'input', group: 'detail' },
        { prop: 'diagSerialNumber', label: '诊断序号', visible: true, type: 'input', group: 'detail' },
        { prop: 'diagType', label: '诊断类型:门诊诊断、入院诊断、出院诊断、其他诊断', visible: true, type: 'input', group: 'detail' },
        { prop: 'diagCode', label: '诊断编码', visible: true, type: 'input', group: 'detail' },
        { prop: 'diagName', label: '诊断名称', visible: true, type: 'input', group: 'detail' },
        { prop: 'diagExplanation', label: '诊断说明', visible: true, type: 'input', group: 'detail' },
        { prop: 'diagDatetime', label: '诊断时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'confirmedDiagMark', label: '是否明确诊断', visible: true, type: 'input', group: 'detail' },
        { prop: 'maindiagMark', label: '是否主要诊断', visible: true, type: 'input', group: 'detail' },
        { prop: 'diagDoctorNo', label: '诊断医生代码', visible: true, type: 'input', group: 'detail' },
        { prop: 'extendData1', label: '扩展字段1', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'extendData2', label: '扩展字段2', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'recordStatus', label: '记录状态:1正常 0作废', visible: true, type: 'number', group: 'detail' },
        { prop: 'createdTime', label: '创建时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'updatedTime', label: '更新时间', visible: true, type: 'datetime', group: 'detail' }
      ]
    }
  ];

  return new FieldConfigManager('natdssB023DiagInfo', fieldGroups);
}


// natdssB031InpatientInfo字段配置
export function createNatdssB031InpatientInfoFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '系统自增主键', visible: true, type: 'number', group: 'basic' },
        { prop: 'patientId', label: '患者ID', visible: true, type: 'input', group: 'basic' },
        { prop: 'visitCardNo', label: '就诊卡号', visible: true, type: 'input', group: 'basic' },
        { prop: 'medicalRecordNo', label: '病案号', visible: true, type: 'input', group: 'basic' },
        { prop: 'inpatientNo', label: '住院号', visible: true, type: 'input', group: 'basic' },
        { prop: 'name', label: '姓名', visible: true, type: 'input', group: 'basic' },
        { prop: 'currentDeptCode', label: '当前科室代码', visible: true, type: 'input', group: 'basic' },
        { prop: 'currentDeptName', label: '当前科室名称', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'visitSn', label: '单次就诊唯一标识号', visible: true, type: 'input', group: 'detail' },
        { prop: 'hospitalizationTimes', label: '住院次数', visible: true, type: 'input', group: 'detail' },
        { prop: 'admissionDatetime', label: '入院时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'currentWardName', label: '当前病房名称', visible: true, type: 'input', group: 'detail' },
        { prop: 'currentBedName', label: '当前床位名称', visible: true, type: 'input', group: 'detail' },
        { prop: 'visitDoctorNo', label: '管床医生代码', visible: true, type: 'input', group: 'detail' },
        { prop: 'dischargeDatetime', label: '出院时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'dischargeDeptCode', label: '出院科室编码', visible: true, type: 'input', group: 'detail' },
        { prop: 'dischargeDeptName', label: '出院科室名称', visible: true, type: 'input', group: 'detail' },
        { prop: 'extendData1', label: '扩展字段1:出院状态', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'extendData2', label: '扩展字段2', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'recordStatus', label: '记录状态:1正常 0作废', visible: true, type: 'number', group: 'detail' },
        { prop: 'createdTime', label: '创建时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'updatedTime', label: '更新时间', visible: true, type: 'datetime', group: 'detail' }
      ]
    }
  ];

  return new FieldConfigManager('natdssB031InpatientInfo', fieldGroups);
}


// natdssB051EmrAdmission字段配置
export function createNatdssB051EmrAdmissionFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '系统自增主键', visible: true, type: 'number', group: 'basic' },
        { prop: 'patientId', label: '患者ID', visible: true, type: 'input', group: 'basic' },
        { prop: 'medicalRecordNo', label: '病案号', visible: true, type: 'input', group: 'basic' },
        { prop: 'inpatientNo', label: '住院号', visible: true, type: 'input', group: 'basic' },
        { prop: 'admissionMaindiagCode1', label: '入院主要诊断编码', visible: true, type: 'input', group: 'basic' },
        { prop: 'admissionMaindiagName1', label: '入院主要诊断名称', visible: true, type: 'input', group: 'basic' },
        { prop: 'admissionDiagCode2', label: '入院诊断编码-2', visible: true, type: 'input', group: 'basic' },
        { prop: 'admissionDiagName2', label: '入院诊断名称-2', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'visitSn', label: '单次就诊唯一标识号', visible: true, type: 'input', group: 'detail' },
        { prop: 'hospitalizationTimes', label: '住院次数', visible: true, type: 'input', group: 'detail' },
        { prop: 'recordSn', label: '入院记录流水号', visible: true, type: 'input', group: 'detail' },
        { prop: 'recordDatetime', label: '入院记录创建时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'kpsScore', label: 'KPS评分', visible: true, type: 'input', group: 'detail' },
        { prop: 'ecogScore', label: 'ECOG PS评分', visible: true, type: 'input', group: 'detail' },
        { prop: 'recordText', label: '文书内容', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'chiefComplaint', label: '主诉', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'currentMedhistory', label: '现病史', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'pastMedhistory', label: '既往史', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'personalMedhistory', label: '个人史', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'familyHistory', label: '家族史', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'marriageBirthHistory', label: '婚育史', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'menstrualHistory', label: '月经史', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'systolicPressure', label: '收缩压', visible: true, type: 'input', group: 'detail' },
        { prop: 'diastolicPressure', label: '舒张压', visible: true, type: 'input', group: 'detail' },
        { prop: 'respiratoryRate', label: '呼吸', visible: true, type: 'input', group: 'detail' },
        { prop: 'bodyTemperature', label: '体温', visible: true, type: 'input', group: 'detail' },
        { prop: 'heartRate', label: '心率', visible: true, type: 'input', group: 'detail' },
        { prop: 'height', label: '身高', visible: true, type: 'input', group: 'detail' },
        { prop: 'weight', label: '体重', visible: true, type: 'input', group: 'detail' },
        { prop: 'bodySurfaceArea', label: '体表面积', visible: true, type: 'input', group: 'detail' },
        { prop: 'physicalExam', label: '体格检查', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'specialExam', label: '专科检查', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'auxiliaryExam', label: '辅助检查', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'admissionDiagCode3', label: '入院诊断编码-3', visible: true, type: 'input', group: 'detail' },
        { prop: 'admissionDiagName3', label: '入院诊断名称-3', visible: true, type: 'input', group: 'detail' },
        { prop: 'admissionDiagCode4', label: '入院诊断编码-4', visible: true, type: 'input', group: 'detail' },
        { prop: 'admissionDiagName4', label: '入院诊断名称-4', visible: true, type: 'input', group: 'detail' },
        { prop: 'admissionDiagCode5', label: '入院诊断编码-5', visible: true, type: 'input', group: 'detail' },
        { prop: 'admissionDiagName5', label: '入院诊断名称-5', visible: true, type: 'input', group: 'detail' },
        { prop: 'admissionDiagCoden', label: '入院诊断编码-N', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'admissionDiagNamen', label: '入院诊断名称-N', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'extendData1', label: '扩展字段1', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'extendData2', label: '扩展字段2', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'recordStatus', label: '记录状态:1正常 0作废', visible: true, type: 'number', group: 'detail' },
        { prop: 'createdTime', label: '创建时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'updatedTime', label: '更新时间', visible: true, type: 'datetime', group: 'detail' }
      ]
    }
  ];

  return new FieldConfigManager('natdssB051EmrAdmission', fieldGroups);
}


// natdssB061EmrProgressNotes字段配置
export function createNatdssB061EmrProgressNotesFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '系统自增主键', visible: true, type: 'number', group: 'basic' },
        { prop: 'patientId', label: '患者ID', visible: true, type: 'input', group: 'basic' },
        { prop: 'medicalRecordNo', label: '病案号', visible: true, type: 'input', group: 'basic' },
        { prop: 'patientNo', label: '住院号', visible: true, type: 'input', group: 'basic' },
        { prop: 'recordTitleCode', label: '病程记录类型代码', visible: true, type: 'input', group: 'basic' },
        { prop: 'recordTitle', label: '病程记录类型', visible: true, type: 'input', group: 'basic' },
        { prop: 'recordStatus', label: '记录状态:1正常 0作废', visible: true, type: 'number', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'visitSn', label: '单次就诊唯一标识号', visible: true, type: 'input', group: 'detail' },
        { prop: 'hospitalizationTimes', label: '住院次数', visible: true, type: 'input', group: 'detail' },
        { prop: 'recordSn', label: '病程记录流水号', visible: true, type: 'input', group: 'detail' },
        { prop: 'recordDatetime', label: '病程记录时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'recordContent', label: '病程记录', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'extendData1', label: '扩展字段1', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'extendData2', label: '扩展字段2', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'createdTime', label: '创建时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'updatedTime', label: '更新时间', visible: true, type: 'datetime', group: 'detail' }
      ]
    }
  ];

  return new FieldConfigManager('natdssB061EmrProgressNotes', fieldGroups);
}


// natdssB071EmrDischarge字段配置
export function createNatdssB071EmrDischargeFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '系统自增主键', visible: true, type: 'number', group: 'basic' },
        { prop: 'patientId', label: '患者ID', visible: true, type: 'input', group: 'basic' },
        { prop: 'medicalRecordNo', label: '病案号', visible: true, type: 'input', group: 'basic' },
        { prop: 'inpatientNo', label: '住院号', visible: true, type: 'input', group: 'basic' },
        { prop: 'admissionMaindiagCode1', label: '入院主要诊断编码', visible: true, type: 'input', group: 'basic' },
        { prop: 'admissionMaindiagName1', label: '入院主要诊断名称', visible: true, type: 'input', group: 'basic' },
        { prop: 'admissionDiagCode2', label: '入院诊断编码-2', visible: true, type: 'input', group: 'basic' },
        { prop: 'admissionDiagName2', label: '入院诊断名称-2', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'visitSn', label: '单次就诊唯一标识号', visible: true, type: 'input', group: 'detail' },
        { prop: 'hospitalizationTimes', label: '住院次数', visible: true, type: 'input', group: 'detail' },
        { prop: 'recordSn', label: '出院记录流水号', visible: true, type: 'input', group: 'detail' },
        { prop: 'recordDatetime', label: '出院记录创建时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'admissionDatetime', label: '入院时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'dischargeOrder', label: '出院医嘱', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'dischargeDatetime', label: '出院时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'lengthOfStay', label: '实际住院天数', visible: true, type: 'number', group: 'detail' },
        { prop: 'kpsScore', label: 'KPS评分', visible: true, type: 'input', group: 'detail' },
        { prop: 'ecogScore', label: 'ECOG PS评分', visible: true, type: 'input', group: 'detail' },
        { prop: 'recordText', label: '文书内容', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'admissionCondition', label: '入院情况', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'treatmentInfo', label: '诊疗经过', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'dischargeCondition', label: '出院情况', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'admissionDiagCode3', label: '入院诊断编码-3', visible: true, type: 'input', group: 'detail' },
        { prop: 'admissionDiagName3', label: '入院诊断名称-3', visible: true, type: 'input', group: 'detail' },
        { prop: 'admissionDiagCode4', label: '入院诊断编码-4', visible: true, type: 'input', group: 'detail' },
        { prop: 'admissionDiagName4', label: '入院诊断名称-4', visible: true, type: 'input', group: 'detail' },
        { prop: 'admissionDiagCode5', label: '入院诊断编码-5', visible: true, type: 'input', group: 'detail' },
        { prop: 'admissionDiagName5', label: '入院诊断名称-5', visible: true, type: 'input', group: 'detail' },
        { prop: 'admissionDiagCoden', label: '入院诊断编码-N', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'admissionDiagNamen', label: '入院诊断名称-N', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'dischargeMaindiagCode1', label: '出院主要诊断编码', visible: true, type: 'input', group: 'detail' },
        { prop: 'dischargeMaindiagName1', label: '出院主要诊断名称', visible: true, type: 'input', group: 'detail' },
        { prop: 'dischargeDiagCode2', label: '出院诊断编码-2', visible: true, type: 'input', group: 'detail' },
        { prop: 'dischargeDiagName2', label: '出院诊断名称-2', visible: true, type: 'input', group: 'detail' },
        { prop: 'dischargeDiagCode3', label: '出院诊断编码-3', visible: true, type: 'input', group: 'detail' },
        { prop: 'dischargeDiagName3', label: '出院诊断名称-3', visible: true, type: 'input', group: 'detail' },
        { prop: 'dischargeDiagCode4', label: '出院诊断编码-4', visible: true, type: 'input', group: 'detail' },
        { prop: 'dischargeDiagName4', label: '出院诊断名称-4', visible: true, type: 'input', group: 'detail' },
        { prop: 'dischargeDiagCode5', label: '出院诊断编码-5', visible: true, type: 'input', group: 'detail' },
        { prop: 'dischargeDiagName5', label: '出院诊断名称-5', visible: true, type: 'input', group: 'detail' },
        { prop: 'dischargeDiagCoden', label: '出院诊断编码-N', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'dischargeDiagNamen', label: '出院诊断名称-N', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'extendData1', label: '扩展字段1', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'extendData2', label: '扩展字段2', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'recordStatus', label: '记录状态:1正常 0作废', visible: true, type: 'number', group: 'detail' },
        { prop: 'createdTime', label: '创建时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'updatedTime', label: '更新时间', visible: true, type: 'datetime', group: 'detail' }
      ]
    }
  ];

  return new FieldConfigManager('natdssB071EmrDischarge', fieldGroups);
}


// natdssB081InpatientSurgicalRecord字段配置
export function createNatdssB081InpatientSurgicalRecordFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '系统自增主键', visible: true, type: 'number', group: 'basic' },
        { prop: 'patientId', label: '患者ID', visible: true, type: 'input', group: 'basic' },
        { prop: 'medicalRecordNo', label: '病案号', visible: true, type: 'input', group: 'basic' },
        { prop: 'inpatientNo', label: '住院号', visible: true, type: 'input', group: 'basic' },
        { prop: 'surgeonNo', label: '主刀医生代码', visible: true, type: 'input', group: 'basic' },
        { prop: 'technicalTitle', label: '医师职称名称', visible: true, type: 'input', group: 'basic' },
        { prop: 'jobTitle', label: '医师职务名称', visible: true, type: 'input', group: 'basic' },
        { prop: 'executiveDeptCode', label: '手术执行科室编号', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'visitSn', label: '单次就诊唯一标识号', visible: true, type: 'input', group: 'detail' },
        { prop: 'hospitalizationTimes', label: '住院次数', visible: true, type: 'input', group: 'detail' },
        { prop: 'recordSn', label: '手术记录流水号', visible: true, type: 'input', group: 'detail' },
        { prop: 'recordDatetime', label: '手术记录时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'executiveDeptName', label: '手术执行科室名称', visible: true, type: 'input', group: 'detail' },
        { prop: 'surgeryCode', label: '手术编码', visible: true, type: 'input', group: 'detail' },
        { prop: 'surgeryName', label: '手术名称', visible: true, type: 'input', group: 'detail' },
        { prop: 'startDatetime', label: '手术开始时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'finishDatetime', label: '手术结束时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'incisionType', label: '切口类型', visible: true, type: 'input', group: 'detail' },
        { prop: 'surgeryLevel', label: '手术级别', visible: true, type: 'input', group: 'detail' },
        { prop: 'surgicalApproach', label: '手术入路', visible: true, type: 'input', group: 'detail' },
        { prop: 'preventiveAntibioticMark', label: '是否预防性使用抗生素', visible: true, type: 'input', group: 'detail' },
        { prop: 'proceduresDescription', label: '手术过程描述', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'asaSurgeonNo', label: '麻醉医师代码', visible: true, type: 'input', group: 'detail' },
        { prop: 'asaTechnicalTitle', label: '麻醉医师职称名称', visible: true, type: 'input', group: 'detail' },
        { prop: 'asaJobTitle', label: '麻醉医师职务名称', visible: true, type: 'input', group: 'detail' },
        { prop: 'anesthesiaTypeCode', label: '麻醉方式代码', visible: true, type: 'input', group: 'detail' },
        { prop: 'anesthesiaType', label: '麻醉方式', visible: true, type: 'input', group: 'detail' },
        { prop: 'asaPhysicalStatus', label: '麻醉评分', visible: true, type: 'input', group: 'detail' },
        { prop: 'anesthesiaStartTime', label: '麻醉开始时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'anesthesiaEndTime', label: '麻醉结束时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'intakeVolume', label: '总入量', visible: true, type: 'input', group: 'detail' },
        { prop: 'outputVolume', label: '总出量', visible: true, type: 'input', group: 'detail' },
        { prop: 'bloodTransAbo', label: '输血血型-ABO', visible: true, type: 'input', group: 'detail' },
        { prop: 'bloodTransRh', label: '输血血型-Rh', visible: true, type: 'input', group: 'detail' },
        { prop: 'bloodTransComponentCode', label: '输血成份类型代码', visible: true, type: 'input', group: 'detail' },
        { prop: 'bloodTransComponent', label: '输血成份类型', visible: true, type: 'input', group: 'detail' },
        { prop: 'bloodTransVolume', label: '输血量', visible: true, type: 'input', group: 'detail' },
        { prop: 'bloodLossVolume', label: '出血量', visible: true, type: 'input', group: 'detail' },
        { prop: 'urineVolume', label: '尿量', visible: true, type: 'input', group: 'detail' },
        { prop: 'presurgeryMaindiagCode1', label: '术前主要诊断编码', visible: true, type: 'input', group: 'detail' },
        { prop: 'presurgeryMaindiagName1', label: '术前主要诊断名称', visible: true, type: 'input', group: 'detail' },
        { prop: 'presurgeryDiagCode2', label: '术前诊断编码-2', visible: true, type: 'input', group: 'detail' },
        { prop: 'presurgeryDiagName2', label: '术前诊断名称-2', visible: true, type: 'input', group: 'detail' },
        { prop: 'presurgeryDiagCode3', label: '术前诊断编码-3', visible: true, type: 'input', group: 'detail' },
        { prop: 'presurgeryDiagName3', label: '术前诊断名称-3', visible: true, type: 'input', group: 'detail' },
        { prop: 'presurgeryDiagCode4', label: '术前诊断编码-4', visible: true, type: 'input', group: 'detail' },
        { prop: 'presurgeryDiagName4', label: '术前诊断名称-4', visible: true, type: 'input', group: 'detail' },
        { prop: 'presurgeryDiagCode5', label: '术前诊断编码-5', visible: true, type: 'input', group: 'detail' },
        { prop: 'presurgeryDiagName5', label: '术前诊断名称-5', visible: true, type: 'input', group: 'detail' },
        { prop: 'intrasurgeryMaindiagCode1', label: '术中主要诊断编码', visible: true, type: 'input', group: 'detail' },
        { prop: 'intrasurgeryMaindiagName1', label: '术中主要诊断名称', visible: true, type: 'input', group: 'detail' },
        { prop: 'intrasurgeryDiagCode2', label: '术中诊断编码-2', visible: true, type: 'input', group: 'detail' },
        { prop: 'intrasurgeryDiagName2', label: '术中诊断名称-2', visible: true, type: 'input', group: 'detail' },
        { prop: 'intrasurgeryDiagCode3', label: '术中诊断编码-3', visible: true, type: 'input', group: 'detail' },
        { prop: 'intrasurgeryDiagName3', label: '术中诊断名称-3', visible: true, type: 'input', group: 'detail' },
        { prop: 'intrasurgeryDiagCode4', label: '术中诊断编码-4', visible: true, type: 'input', group: 'detail' },
        { prop: 'intrasurgeryDiagName4', label: '术中诊断名称-4', visible: true, type: 'input', group: 'detail' },
        { prop: 'intrasurgeryDiagCode5', label: '术中诊断编码-5', visible: true, type: 'input', group: 'detail' },
        { prop: 'intrasurgeryDiagName5', label: '术中诊断名称-5', visible: true, type: 'input', group: 'detail' },
        { prop: 'postsurgeryMaindiagCode1', label: '术后主要诊断编码', visible: true, type: 'input', group: 'detail' },
        { prop: 'postsurgeryMaindiagName1', label: '术后主要诊断名称', visible: true, type: 'input', group: 'detail' },
        { prop: 'postsurgeryDiagCode2', label: '术后诊断编码-2', visible: true, type: 'input', group: 'detail' },
        { prop: 'postsurgeryDiagName2', label: '术后诊断名称-2', visible: true, type: 'input', group: 'detail' },
        { prop: 'postsurgeryDiagCode3', label: '术后诊断编码-3', visible: true, type: 'input', group: 'detail' },
        { prop: 'postsurgeryDiagName3', label: '术后诊断名称-3', visible: true, type: 'input', group: 'detail' },
        { prop: 'postsurgeryDiagCode4', label: '术后诊断编码-4', visible: true, type: 'input', group: 'detail' },
        { prop: 'postsurgeryDiagName4', label: '术后诊断名称-4', visible: true, type: 'input', group: 'detail' },
        { prop: 'postsurgeryDiagCode5', label: '术后诊断编码-5', visible: true, type: 'input', group: 'detail' },
        { prop: 'postsurgeryDiagName5', label: '术后诊断名称-5', visible: true, type: 'input', group: 'detail' },
        { prop: 'extendData1', label: '扩展字段1', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'extendData2', label: '扩展字段2', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'recordStatus', label: '记录状态:1正常 0作废', visible: true, type: 'number', group: 'detail' },
        { prop: 'createdTime', label: '创建时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'updatedTime', label: '更新时间', visible: true, type: 'datetime', group: 'detail' }
      ]
    }
  ];

  return new FieldConfigManager('natdssB081InpatientSurgicalRecord', fieldGroups);
}


// natdssB091InpatientNursingRecord字段配置
export function createNatdssB091InpatientNursingRecordFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '系统自增主键', visible: true, type: 'number', group: 'basic' },
        { prop: 'patientId', label: '患者ID', visible: true, type: 'input', group: 'basic' },
        { prop: 'medicalRecordNo', label: '病案号', visible: true, type: 'input', group: 'basic' },
        { prop: 'inpatientNo', label: '住院号', visible: true, type: 'input', group: 'basic' },
        { prop: 'deptCode', label: '科室代码', visible: true, type: 'input', group: 'basic' },
        { prop: 'deptName', label: '科室名称', visible: true, type: 'input', group: 'basic' },
        { prop: 'bedNo', label: '床号', visible: true, type: 'input', group: 'basic' },
        { prop: 'itemCode', label: '测量项目代码', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'visitSn', label: '单次就诊唯一标识号', visible: true, type: 'input', group: 'detail' },
        { prop: 'hospitalizationTimes', label: '住院次数', visible: true, type: 'input', group: 'detail' },
        { prop: 'recordSn', label: '护理记录流水号', visible: true, type: 'input', group: 'detail' },
        { prop: 'recordDatetime', label: '护理记录时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'testDatetime', label: '护理测量时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'testMethod', label: '测量方式', visible: true, type: 'input', group: 'detail' },
        { prop: 'itemName', label: '测量项目名称', visible: true, type: 'input', group: 'detail' },
        { prop: 'painScores', label: '疼痛评分', visible: true, type: 'input', group: 'detail' },
        { prop: 'itemResultValue1', label: '测量结果值1', visible: true, type: 'input', group: 'detail' },
        { prop: 'itemResultUnit1', label: '测量结果单位1', visible: true, type: 'input', group: 'detail' },
        { prop: 'itemResultValue2', label: '测量结果值2', visible: true, type: 'input', group: 'detail' },
        { prop: 'itemResultUnit2', label: '测量结果单位2', visible: true, type: 'input', group: 'detail' },
        { prop: 'observationMeasures', label: '病情观察及措施', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'extendData1', label: '扩展字段1', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'extendData2', label: '扩展字段2', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'recordStatus', label: '记录状态:1正常 0作废', visible: true, type: 'number', group: 'detail' },
        { prop: 'createdTime', label: '创建时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'updatedTime', label: '更新时间', visible: true, type: 'datetime', group: 'detail' }
      ]
    }
  ];

  return new FieldConfigManager('natdssB091InpatientNursingRecord', fieldGroups);
}


// natdssB101InpatientOrder字段配置
export function createNatdssB101InpatientOrderFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '系统自增主键', visible: true, type: 'number', group: 'basic' },
        { prop: 'patientId', label: '患者ID', visible: true, type: 'input', group: 'basic' },
        { prop: 'medicalRecordNo', label: '病案号', visible: true, type: 'input', group: 'basic' },
        { prop: 'inpatientNo', label: '住院号', visible: true, type: 'input', group: 'basic' },
        { prop: 'requestNo', label: '医技申请单号', visible: true, type: 'input', group: 'basic' },
        { prop: 'orderDeptCode', label: '医嘱下达科室代码', visible: true, type: 'input', group: 'basic' },
        { prop: 'orderDeptName', label: '医嘱下达科室名称', visible: true, type: 'input', group: 'basic' },
        { prop: 'orderDoctorNo', label: '医嘱开单医生代码', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'visitSn', label: '单次就诊唯一标识号', visible: true, type: 'input', group: 'detail' },
        { prop: 'hospitalizationTimes', label: '住院次数', visible: true, type: 'input', group: 'detail' },
        { prop: 'orderSn', label: '医嘱流水号', visible: true, type: 'input', group: 'detail' },
        { prop: 'orderGivenTime', label: '医嘱下达时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'orderConfirmTime', label: '医嘱确认时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'technicalTitle', label: '职称名称', visible: true, type: 'input', group: 'detail' },
        { prop: 'jobTitle', label: '职务名称', visible: true, type: 'input', group: 'detail' },
        { prop: 'visitDeptCode', label: '住院科室代码', visible: true, type: 'input', group: 'detail' },
        { prop: 'visitDeptName', label: '住院科室名称', visible: true, type: 'input', group: 'detail' },
        { prop: 'orderStartDatetime', label: '医嘱开始时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'orderEndDatetime', label: '医嘱停止时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'executiveDeptCode', label: '医嘱执行科室代码', visible: true, type: 'input', group: 'detail' },
        { prop: 'executiveDeptName', label: '医嘱执行科室名称', visible: true, type: 'input', group: 'detail' },
        { prop: 'orderType', label: '医嘱类别:长期医嘱、临时医嘱、出院带药', visible: true, type: 'input', group: 'detail' },
        { prop: 'orderClassCode', label: '医嘱分类代码', visible: true, type: 'input', group: 'detail' },
        { prop: 'orderClassName', label: '医嘱分类名称', visible: true, type: 'input', group: 'detail' },
        { prop: 'orderItemCode', label: '医嘱项目代码', visible: true, type: 'input', group: 'detail' },
        { prop: 'orderItemName', label: '医嘱项目名称', visible: true, type: 'input', group: 'detail' },
        { prop: 'orderGroupNo', label: '医嘱组号', visible: true, type: 'input', group: 'detail' },
        { prop: 'dose', label: '单次剂量', visible: true, type: 'input', group: 'detail' },
        { prop: 'doseUnit', label: '单次剂量单位', visible: true, type: 'input', group: 'detail' },
        { prop: 'form', label: '药品剂型', visible: true, type: 'input', group: 'detail' },
        { prop: 'spec', label: '规格', visible: true, type: 'input', group: 'detail' },
        { prop: 'frequencyCode', label: '使用频率代码', visible: true, type: 'input', group: 'detail' },
        { prop: 'frequencyName', label: '使用频率', visible: true, type: 'input', group: 'detail' },
        { prop: 'administrationRoute', label: '给药途径', visible: true, type: 'input', group: 'detail' },
        { prop: 'liquidConfiguration', label: '液体配置', visible: true, type: 'input', group: 'detail' },
        { prop: 'injectionType', label: '注射方式', visible: true, type: 'input', group: 'detail' },
        { prop: 'drugOrder', label: '用药顺序', visible: true, type: 'input', group: 'detail' },
        { prop: 'drugCompatibility', label: '用药配伍', visible: true, type: 'input', group: 'detail' },
        { prop: 'infusionDuration', label: '输液时长', visible: true, type: 'input', group: 'detail' },
        { prop: 'numOfOrder', label: '医嘱项目数量', visible: true, type: 'input', group: 'detail' },
        { prop: 'numOfOrderUnit', label: '医嘱项目数量单位', visible: true, type: 'input', group: 'detail' },
        { prop: 'herbalNote', label: '草药备注', visible: true, type: 'input', group: 'detail' },
        { prop: 'orderNote', label: '医嘱备注', visible: true, type: 'input', group: 'detail' },
        { prop: 'drugFlag', label: '是否药品', visible: true, type: 'input', group: 'detail' },
        { prop: 'manufac', label: '生产厂家', visible: true, type: 'input', group: 'detail' },
        { prop: 'tradeName', label: '药品商品名', visible: true, type: 'input', group: 'detail' },
        { prop: 'extendData1', label: '扩展字段1', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'extendData2', label: '扩展字段2', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'recordStatus', label: '记录状态:1正常 0作废', visible: true, type: 'number', group: 'detail' },
        { prop: 'createdTime', label: '创建时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'updatedTime', label: '更新时间', visible: true, type: 'datetime', group: 'detail' }
      ]
    }
  ];

  return new FieldConfigManager('natdssB101InpatientOrder', fieldGroups);
}


// natdssB111InpatientExpenseRecord字段配置
export function createNatdssB111InpatientExpenseRecordFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '系统自增主键', visible: true, type: 'number', group: 'basic' },
        { prop: 'patientId', label: '患者ID', visible: true, type: 'input', group: 'basic' },
        { prop: 'medicalRecordNo', label: '病案号', visible: true, type: 'input', group: 'basic' },
        { prop: 'inpatientNo', label: '住院号', visible: true, type: 'input', group: 'basic' },
        { prop: 'receiptNo', label: '收据号', visible: true, type: 'input', group: 'basic' },
        { prop: 'orderType', label: '医嘱类别:长期医嘱、临时医嘱、出院带药', visible: true, type: 'input', group: 'basic' },
        { prop: 'transactionTypeCode', label: '交易类别代码', visible: true, type: 'input', group: 'basic' },
        { prop: 'transactionTypeName', label: '交易类别名称', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'visitSn', label: '单次就诊唯一标识号', visible: true, type: 'input', group: 'detail' },
        { prop: 'hospitalizationTimes', label: '住院次数', visible: true, type: 'input', group: 'detail' },
        { prop: 'expenseSn', label: '费用明细流水号', visible: true, type: 'input', group: 'detail' },
        { prop: 'orderSn', label: '医嘱流水号', visible: true, type: 'input', group: 'detail' },
        { prop: 'expenseDatetime', label: '收费时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'itemTypeCode', label: '收费项目类型代码', visible: true, type: 'input', group: 'detail' },
        { prop: 'itemTypeName', label: '收费项目类型名称', visible: true, type: 'input', group: 'detail' },
        { prop: 'itemCode', label: '收费项目代码', visible: true, type: 'input', group: 'detail' },
        { prop: 'itemName', label: '收费项目名称', visible: true, type: 'input', group: 'detail' },
        { prop: 'itemUnit', label: '收费项目单位', visible: true, type: 'input', group: 'detail' },
        { prop: 'itemUnitPrice', label: '费用明细项目单价', visible: true, type: 'number', group: 'detail' },
        { prop: 'itemAmount', label: '费用明细项目数量', visible: true, type: 'number', group: 'detail' },
        { prop: 'itemTotalPrice', label: '收费项目总金额', visible: true, type: 'number', group: 'detail' },
        { prop: 'extendData1', label: '扩展字段1', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'extendData2', label: '扩展字段2', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'recordStatus', label: '记录状态:1正常 0作废', visible: true, type: 'number', group: 'detail' },
        { prop: 'createdTime', label: '创建时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'updatedTime', label: '更新时间', visible: true, type: 'datetime', group: 'detail' }
      ]
    }
  ];

  return new FieldConfigManager('natdssB111InpatientExpenseRecord', fieldGroups);
}


// natdssB121OutpatientInfo字段配置
export function createNatdssB121OutpatientInfoFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '系统自增主键', visible: true, type: 'number', group: 'basic' },
        { prop: 'patientId', label: '患者ID', visible: true, type: 'input', group: 'basic' },
        { prop: 'visitType', label: '就诊类型:门诊、急诊', visible: true, type: 'input', group: 'basic' },
        { prop: 'visitCardNo', label: '就诊卡号', visible: true, type: 'input', group: 'basic' },
        { prop: 'outpatientNo', label: '门诊号', visible: true, type: 'input', group: 'basic' },
        { prop: 'name', label: '患者姓名', visible: true, type: 'input', group: 'basic' },
        { prop: 'regisMethodCode', label: '挂号渠道代码', visible: true, type: 'input', group: 'basic' },
        { prop: 'regisTypeCode', label: '挂号类型代码', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'visitSn', label: '单次就诊唯一标识号', visible: true, type: 'input', group: 'detail' },
        { prop: 'visitTimes', label: '就诊次数', visible: true, type: 'number', group: 'detail' },
        { prop: 'regisSn', label: '挂号流水号', visible: true, type: 'input', group: 'detail' },
        { prop: 'regisDatetime', label: '挂号时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'visitDatetime', label: '就诊时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'firstVisitMark', label: '是否初诊', visible: true, type: 'input', group: 'detail' },
        { prop: 'regisMethod', label: '挂号渠道名称', visible: true, type: 'input', group: 'detail' },
        { prop: 'regisType', label: '挂号类型', visible: true, type: 'input', group: 'detail' },
        { prop: 'regisChargePrice', label: '挂号金额', visible: true, type: 'number', group: 'detail' },
        { prop: 'regisPaidPrice', label: '实付金额', visible: true, type: 'number', group: 'detail' },
        { prop: 'regisDeptCode', label: '挂号科室代码', visible: true, type: 'input', group: 'detail' },
        { prop: 'regisDeptName', label: '挂号科室名称', visible: true, type: 'input', group: 'detail' },
        { prop: 'visitDoctorNo', label: '就诊医生代码', visible: true, type: 'input', group: 'detail' },
        { prop: 'technicalTitle', label: '医师职称名称', visible: true, type: 'input', group: 'detail' },
        { prop: 'jobTitle', label: '医师职务名称', visible: true, type: 'input', group: 'detail' },
        { prop: 'extendData1', label: '扩展字段1', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'extendData2', label: '扩展字段2', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'recordStatus', label: '记录状态:1正常 0作废', visible: true, type: 'number', group: 'detail' },
        { prop: 'createdTime', label: '创建时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'updatedTime', label: '更新时间', visible: true, type: 'datetime', group: 'detail' }
      ]
    }
  ];

  return new FieldConfigManager('natdssB121OutpatientInfo', fieldGroups);
}


// natdssB131OutpatientDiagAndMedrecord字段配置
export function createNatdssB131OutpatientDiagAndMedrecordFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '系统自增主键', visible: true, type: 'number', group: 'basic' },
        { prop: 'patientId', label: '患者ID', visible: true, type: 'input', group: 'basic' },
        { prop: 'visitType', label: '就诊类型:门诊、急诊', visible: true, type: 'input', group: 'basic' },
        { prop: 'visitCardNo', label: '就诊卡号', visible: true, type: 'input', group: 'basic' },
        { prop: 'outpatientNo', label: '门诊号', visible: true, type: 'input', group: 'basic' },
        { prop: 'tcmDiseaseName', label: '中医病名', visible: true, type: 'input', group: 'basic' },
        { prop: 'tcmSyndromeName', label: '中医证候', visible: true, type: 'input', group: 'basic' },
        { prop: 'diagnoseDatetime', label: '诊断时间', visible: true, type: 'datetime', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'visitSn', label: '单次就诊唯一标识号', visible: true, type: 'input', group: 'detail' },
        { prop: 'visitTimes', label: '就诊次数', visible: true, type: 'number', group: 'detail' },
        { prop: 'visitDatetime', label: '就诊时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'recordSn', label: '病历记录流水号', visible: true, type: 'input', group: 'detail' },
        { prop: 'recordDatetime', label: '病历记录时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'recordText', label: '病历文书内容', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'treatmentInfo', label: '诊疗经过', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'operationInfo', label: '操作记录', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'chiefComplaint', label: '主诉', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'currentMedhistory', label: '现病史', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'pastMedhistory', label: '既往史', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'personalMedhistory', label: '个人史', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'familyHistory', label: '家族史', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'marriageBirthHistory', label: '婚育史', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'menstrualHistory', label: '月经史', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'physicalExam', label: '体格检查', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'maindiagCode1', label: '主要诊断编码', visible: true, type: 'input', group: 'detail' },
        { prop: 'maindiagName1', label: '主要诊断名称', visible: true, type: 'input', group: 'detail' },
        { prop: 'diagCode2', label: '诊断编码-2', visible: true, type: 'input', group: 'detail' },
        { prop: 'diagName2', label: '诊断名称-2', visible: true, type: 'input', group: 'detail' },
        { prop: 'diagCode3', label: '诊断编码-3', visible: true, type: 'input', group: 'detail' },
        { prop: 'diagName3', label: '诊断名称-3', visible: true, type: 'input', group: 'detail' },
        { prop: 'diagCode4', label: '诊断编码-4', visible: true, type: 'input', group: 'detail' },
        { prop: 'diagName4', label: '诊断名称-4', visible: true, type: 'input', group: 'detail' },
        { prop: 'diagCode5', label: '诊断编码-5', visible: true, type: 'input', group: 'detail' },
        { prop: 'diagName5', label: '诊断名称-5', visible: true, type: 'input', group: 'detail' },
        { prop: 'diagCode6', label: '诊断编码-6', visible: true, type: 'input', group: 'detail' },
        { prop: 'diagName6', label: '诊断名称-6', visible: true, type: 'input', group: 'detail' },
        { prop: 'diagCode7', label: '诊断编码-7', visible: true, type: 'input', group: 'detail' },
        { prop: 'diagName7', label: '诊断名称-7', visible: true, type: 'input', group: 'detail' },
        { prop: 'diagCode8', label: '诊断编码-8', visible: true, type: 'input', group: 'detail' },
        { prop: 'diagName8', label: '诊断名称-8', visible: true, type: 'input', group: 'detail' },
        { prop: 'diagCode9', label: '诊断编码-9', visible: true, type: 'input', group: 'detail' },
        { prop: 'diagName9', label: '诊断名称-9', visible: true, type: 'input', group: 'detail' },
        { prop: 'diagCode10', label: '诊断编码-10', visible: true, type: 'input', group: 'detail' },
        { prop: 'diagName10', label: '诊断名称-10', visible: true, type: 'input', group: 'detail' },
        { prop: 'diagCoden', label: '诊断编码-N', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'diagNamen', label: '诊断名称-N', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'extendData1', label: '扩展字段1', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'extendData2', label: '扩展字段2', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'recordStatus', label: '记录状态:1正常 0作废', visible: true, type: 'number', group: 'detail' },
        { prop: 'createdTime', label: '创建时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'updatedTime', label: '更新时间', visible: true, type: 'datetime', group: 'detail' }
      ]
    }
  ];

  return new FieldConfigManager('natdssB131OutpatientDiagAndMedrecord', fieldGroups);
}


// natdssB141OutpatientOrderAndPres字段配置
export function createNatdssB141OutpatientOrderAndPresFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '系统自增主键', visible: true, type: 'number', group: 'basic' },
        { prop: 'patientId', label: '患者ID', visible: true, type: 'input', group: 'basic' },
        { prop: 'visitType', label: '就诊类型:门诊、急诊', visible: true, type: 'input', group: 'basic' },
        { prop: 'visitCardNo', label: '就诊卡号', visible: true, type: 'input', group: 'basic' },
        { prop: 'outpatientNo', label: '门诊号', visible: true, type: 'input', group: 'basic' },
        { prop: 'requestNo', label: '医技申请单号', visible: true, type: 'input', group: 'basic' },
        { prop: 'visitDeptCode', label: '就诊科室代码', visible: true, type: 'input', group: 'basic' },
        { prop: 'visitDeptName', label: '就诊科室名称', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'visitSn', label: '单次就诊唯一标识号', visible: true, type: 'input', group: 'detail' },
        { prop: 'visitTimes', label: '就诊次数', visible: true, type: 'number', group: 'detail' },
        { prop: 'orderSn', label: '医嘱流水号', visible: true, type: 'input', group: 'detail' },
        { prop: 'orderGivenTime', label: '医嘱开具时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'orderDeptCode', label: '医嘱下达科室代码', visible: true, type: 'input', group: 'detail' },
        { prop: 'orderDeptName', label: '医嘱下达科室名称', visible: true, type: 'input', group: 'detail' },
        { prop: 'orderDoctorNo', label: '医嘱开单医生代码', visible: true, type: 'input', group: 'detail' },
        { prop: 'technicalTitle', label: '职称名称', visible: true, type: 'input', group: 'detail' },
        { prop: 'jobTitle', label: '职务名称', visible: true, type: 'input', group: 'detail' },
        { prop: 'executiveDeptCode', label: '医嘱执行科室代码', visible: true, type: 'input', group: 'detail' },
        { prop: 'executiveDeptName', label: '医嘱执行科室名称', visible: true, type: 'input', group: 'detail' },
        { prop: 'prescriptionClassCode', label: '处方分类代码', visible: true, type: 'input', group: 'detail' },
        { prop: 'prescriptionClassName', label: '处方分类名称', visible: true, type: 'input', group: 'detail' },
        { prop: 'orderClassCode', label: '医嘱分类代码', visible: true, type: 'input', group: 'detail' },
        { prop: 'orderClassName', label: '医嘱分类名称', visible: true, type: 'input', group: 'detail' },
        { prop: 'orderItemCode', label: '医嘱项目代码', visible: true, type: 'input', group: 'detail' },
        { prop: 'orderItemName', label: '医嘱项目名称', visible: true, type: 'input', group: 'detail' },
        { prop: 'orderGroupNo', label: '医嘱组号', visible: true, type: 'input', group: 'detail' },
        { prop: 'dose', label: '单次剂量', visible: true, type: 'number', group: 'detail' },
        { prop: 'doseUnit', label: '剂量单位', visible: true, type: 'input', group: 'detail' },
        { prop: 'form', label: '药品剂型', visible: true, type: 'input', group: 'detail' },
        { prop: 'spec', label: '规格', visible: true, type: 'input', group: 'detail' },
        { prop: 'frequencyCode', label: '使用频率代码', visible: true, type: 'input', group: 'detail' },
        { prop: 'frequency', label: '使用频率', visible: true, type: 'input', group: 'detail' },
        { prop: 'administrationRoute', label: '给药途径', visible: true, type: 'input', group: 'detail' },
        { prop: 'liquidConfiguration', label: '液体配置', visible: true, type: 'input', group: 'detail' },
        { prop: 'injectionType', label: '注射方式', visible: true, type: 'input', group: 'detail' },
        { prop: 'drugOrder', label: '用药顺序', visible: true, type: 'input', group: 'detail' },
        { prop: 'drugCompatibility', label: '用药配伍', visible: true, type: 'input', group: 'detail' },
        { prop: 'infusionDuration', label: '输液时长', visible: true, type: 'input', group: 'detail' },
        { prop: 'daysOfMedication', label: '使用天数', visible: true, type: 'number', group: 'detail' },
        { prop: 'totalDose', label: '药品使用总剂量', visible: true, type: 'number', group: 'detail' },
        { prop: 'totalDoseUnit', label: '总量单位', visible: true, type: 'input', group: 'detail' },
        { prop: 'numOfOrders', label: '医嘱数量', visible: true, type: 'input', group: 'detail' },
        { prop: 'numOfOrdersUnit', label: '医嘱数量单位', visible: true, type: 'input', group: 'detail' },
        { prop: 'orderNote', label: '医嘱备注', visible: true, type: 'input', group: 'detail' },
        { prop: 'herbalNote', label: '草药备注', visible: true, type: 'input', group: 'detail' },
        { prop: 'drugFlag', label: '是否药品', visible: true, type: 'input', group: 'detail' },
        { prop: 'manufac', label: '生产厂家', visible: true, type: 'input', group: 'detail' },
        { prop: 'tradeName', label: '药品商品名', visible: true, type: 'input', group: 'detail' },
        { prop: 'extendData1', label: '扩展字段1', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'extendData2', label: '扩展字段2', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'recordStatus', label: '记录状态:1正常 0作废', visible: true, type: 'number', group: 'detail' },
        { prop: 'createdTime', label: '创建时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'updatedTime', label: '更新时间', visible: true, type: 'datetime', group: 'detail' }
      ]
    }
  ];

  return new FieldConfigManager('natdssB141OutpatientOrderAndPres', fieldGroups);
}


// natdssB151OutpatientExpenseRecord字段配置
export function createNatdssB151OutpatientExpenseRecordFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '系统自增主键', visible: true, type: 'number', group: 'basic' },
        { prop: 'patientId', label: '患者ID', visible: true, type: 'input', group: 'basic' },
        { prop: 'visitType', label: '就诊类型:门诊、急诊', visible: true, type: 'input', group: 'basic' },
        { prop: 'visitCardNo', label: '就诊卡号', visible: true, type: 'input', group: 'basic' },
        { prop: 'outpatientNo', label: '门诊号', visible: true, type: 'input', group: 'basic' },
        { prop: 'receiptNo', label: '收据号', visible: true, type: 'input', group: 'basic' },
        { prop: 'transactionTypeCode', label: '交易类别代码', visible: true, type: 'input', group: 'basic' },
        { prop: 'transactionTypeName', label: '交易类别名称', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'visitSn', label: '单次就诊唯一标识号', visible: true, type: 'input', group: 'detail' },
        { prop: 'visitTimes', label: '就诊次数', visible: true, type: 'number', group: 'detail' },
        { prop: 'expenseSn', label: '收费记录明细流水号', visible: true, type: 'input', group: 'detail' },
        { prop: 'orderSn', label: '医嘱流水号', visible: true, type: 'input', group: 'detail' },
        { prop: 'expenseDatetime', label: '收费时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'itemTypeCode', label: '收费项目类型代码', visible: true, type: 'input', group: 'detail' },
        { prop: 'itemTypeName', label: '收费项目类型名称', visible: true, type: 'input', group: 'detail' },
        { prop: 'itemCode', label: '收费项目代码', visible: true, type: 'input', group: 'detail' },
        { prop: 'itemName', label: '收费项目名称', visible: true, type: 'input', group: 'detail' },
        { prop: 'itemUnit', label: '收费项目单位', visible: true, type: 'input', group: 'detail' },
        { prop: 'itemUnitPrice', label: '费用明细项目单价', visible: true, type: 'number', group: 'detail' },
        { prop: 'itemAmount', label: '费用明细项目数量', visible: true, type: 'number', group: 'detail' },
        { prop: 'itemTotalPrice', label: '费用明细项目金额', visible: true, type: 'number', group: 'detail' },
        { prop: 'extendData1', label: '扩展字段1', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'extendData2', label: '扩展字段2', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'recordStatus', label: '记录状态:1正常 0作废', visible: true, type: 'number', group: 'detail' },
        { prop: 'createdTime', label: '创建时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'updatedTime', label: '更新时间', visible: true, type: 'datetime', group: 'detail' }
      ]
    }
  ];

  return new FieldConfigManager('natdssB151OutpatientExpenseRecord', fieldGroups);
}


// natdssB161ExamInfo字段配置
export function createNatdssB161ExamInfoFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '系统自增主键', visible: true, type: 'number', group: 'basic' },
        { prop: 'patientId', label: '患者ID', visible: true, type: 'input', group: 'basic' },
        { prop: 'visitType', label: '就诊类型:住院、门诊', visible: true, type: 'input', group: 'basic' },
        { prop: 'visitCardNo', label: '就诊卡号', visible: true, type: 'input', group: 'basic' },
        { prop: 'outpatientNo', label: '门诊号', visible: true, type: 'input', group: 'basic' },
        { prop: 'medicalRecordNo', label: '病案号', visible: true, type: 'input', group: 'basic' },
        { prop: 'inpatientNo', label: '住院号', visible: true, type: 'input', group: 'basic' },
        { prop: 'name', label: '患者姓名', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'visitSn', label: '单次就诊唯一标识号', visible: true, type: 'input', group: 'detail' },
        { prop: 'visitTimes', label: '就诊次数', visible: true, type: 'number', group: 'detail' },
        { prop: 'hospitalizationTimes', label: '住院次数', visible: true, type: 'input', group: 'detail' },
        { prop: 'applyNo', label: '申请单号', visible: true, type: 'input', group: 'detail' },
        { prop: 'orderSn', label: '申请医嘱流水号', visible: true, type: 'input', group: 'detail' },
        { prop: 'applyDatetime', label: '申请时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'applyDeptCode', label: '申请科室代码', visible: true, type: 'input', group: 'detail' },
        { prop: 'applyDeptName', label: '申请科室名称', visible: true, type: 'input', group: 'detail' },
        { prop: 'examSn', label: '检查流水号', visible: true, type: 'input', group: 'detail' },
        { prop: 'examDatetime', label: '检查时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'examType', label: '检查类型:心电超声放射', visible: true, type: 'input', group: 'detail' },
        { prop: 'examItemType', label: '检查项目类型', visible: true, type: 'input', group: 'detail' },
        { prop: 'examItemCode', label: '检查项目代码', visible: true, type: 'input', group: 'detail' },
        { prop: 'examItemName', label: '检查项目名称', visible: true, type: 'input', group: 'detail' },
        { prop: 'examSites', label: '检查部位', visible: true, type: 'input', group: 'detail' },
        { prop: 'reportNo', label: '报告单号', visible: true, type: 'input', group: 'detail' },
        { prop: 'reportDatetime', label: '报告时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'reportDeptCode', label: '报告科室代码', visible: true, type: 'input', group: 'detail' },
        { prop: 'reportDeptName', label: '报告科室名称', visible: true, type: 'input', group: 'detail' },
        { prop: 'examDiagDescription', label: '检查所见', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'examDiagConclusion', label: '检查结论', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'extendData1', label: '扩展字段1', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'extendData2', label: '扩展字段2', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'recordStatus', label: '记录状态:1正常 0作废', visible: true, type: 'number', group: 'detail' },
        { prop: 'createdTime', label: '创建时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'updatedTime', label: '更新时间', visible: true, type: 'datetime', group: 'detail' }
      ]
    }
  ];

  return new FieldConfigManager('natdssB161ExamInfo', fieldGroups);
}


// natdssB171LabInfo字段配置
export function createNatdssB171LabInfoFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '系统自增主键', visible: true, type: 'number', group: 'basic' },
        { prop: 'patientId', label: '患者ID', visible: true, type: 'input', group: 'basic' },
        { prop: 'visitType', label: '就诊类型:住院、门诊', visible: true, type: 'input', group: 'basic' },
        { prop: 'visitCardNo', label: '就诊卡号', visible: true, type: 'input', group: 'basic' },
        { prop: 'outpatientNo', label: '门诊号', visible: true, type: 'input', group: 'basic' },
        { prop: 'medicalRecordNo', label: '病案号', visible: true, type: 'input', group: 'basic' },
        { prop: 'inpatientNo', label: '住院号', visible: true, type: 'input', group: 'basic' },
        { prop: 'name', label: '患者姓名', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'visitSn', label: '单次就诊唯一标识号', visible: true, type: 'input', group: 'detail' },
        { prop: 'visitTimes', label: '就诊次数', visible: true, type: 'number', group: 'detail' },
        { prop: 'hospitalizationTimes', label: '住院次数', visible: true, type: 'input', group: 'detail' },
        { prop: 'applyNo', label: '申请单号', visible: true, type: 'input', group: 'detail' },
        { prop: 'orderSn', label: '申请医嘱流水号', visible: true, type: 'input', group: 'detail' },
        { prop: 'applyDatetime', label: '申请时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'specimenTypeCode', label: '标本类型代码', visible: true, type: 'input', group: 'detail' },
        { prop: 'specimenTypeName', label: '标本类型名称', visible: true, type: 'input', group: 'detail' },
        { prop: 'specimenCode', label: '标本编号', visible: true, type: 'input', group: 'detail' },
        { prop: 'labSn', label: '检验流水号', visible: true, type: 'input', group: 'detail' },
        { prop: 'testDatetime', label: '检验时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'testMethodCode', label: '检验方法代码', visible: true, type: 'input', group: 'detail' },
        { prop: 'testMethod', label: '检验方法', visible: true, type: 'input', group: 'detail' },
        { prop: 'labType', label: '检验类型', visible: true, type: 'input', group: 'detail' },
        { prop: 'itemGroupCode', label: '组合项目代码', visible: true, type: 'input', group: 'detail' },
        { prop: 'itemGroupName', label: '组合项目名称', visible: true, type: 'input', group: 'detail' },
        { prop: 'itemCode', label: '明细项目代码', visible: true, type: 'input', group: 'detail' },
        { prop: 'itemName', label: '明细项目名称', visible: true, type: 'input', group: 'detail' },
        { prop: 'itemNo', label: '明细项目序号', visible: true, type: 'input', group: 'detail' },
        { prop: 'resultQuantitative', label: '检验-结果', visible: true, type: 'input', group: 'detail' },
        { prop: 'resultQualitative', label: '检验-结果', visible: true, type: 'input', group: 'detail' },
        { prop: 'resultUnit', label: '检验-计量单位', visible: true, type: 'input', group: 'detail' },
        { prop: 'referenceRange', label: '参考值', visible: true, type: 'input', group: 'detail' },
        { prop: 'referenceRangeAlert', label: '参考值提醒', visible: true, type: 'input', group: 'detail' },
        { prop: 'reportNo', label: '报告单号', visible: true, type: 'input', group: 'detail' },
        { prop: 'reportDatetime', label: '报告时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'extendData1', label: '扩展字段1', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'extendData2', label: '扩展字段2', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'recordStatus', label: '记录状态:1正常 0作废', visible: true, type: 'number', group: 'detail' },
        { prop: 'createdTime', label: '创建时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'updatedTime', label: '更新时间', visible: true, type: 'datetime', group: 'detail' }
      ]
    }
  ];

  return new FieldConfigManager('natdssB171LabInfo', fieldGroups);
}


// natdssB181RadInfo字段配置
export function createNatdssB181RadInfoFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '系统自增主键', visible: true, type: 'number', group: 'basic' },
        { prop: 'patientId', label: '患者ID', visible: true, type: 'input', group: 'basic' },
        { prop: 'visitType', label: '就诊类型:住院、门诊', visible: true, type: 'input', group: 'basic' },
        { prop: 'visitCardNo', label: '就诊卡号', visible: true, type: 'input', group: 'basic' },
        { prop: 'outpatientNo', label: '门诊号', visible: true, type: 'input', group: 'basic' },
        { prop: 'medicalRecordNo', label: '病案号', visible: true, type: 'input', group: 'basic' },
        { prop: 'inpatientNo', label: '住院号', visible: true, type: 'input', group: 'basic' },
        { prop: 'name', label: '患者姓名', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'visitSn', label: '单次就诊唯一标识号', visible: true, type: 'input', group: 'detail' },
        { prop: 'visitTimes', label: '就诊次数', visible: true, type: 'number', group: 'detail' },
        { prop: 'hospitalizationTimes', label: '住院次数', visible: true, type: 'input', group: 'detail' },
        { prop: 'gender', label: '性别', visible: true, type: 'input', group: 'detail' },
        { prop: 'age', label: '年龄', visible: true, type: 'number', group: 'detail' },
        { prop: 'dateOfBirth', label: '出生日期', visible: true, type: 'date', group: 'detail' },
        { prop: 'radioSn', label: '放疗流水号', visible: true, type: 'input', group: 'detail' },
        { prop: 'courseSn', label: '疗程号', visible: true, type: 'input', group: 'detail' },
        { prop: 'radioStartTime', label: '放疗开始日期', visible: true, type: 'date', group: 'detail' },
        { prop: 'radioEndTime', label: '放疗结束日期', visible: true, type: 'date', group: 'detail' },
        { prop: 'radioTech', label: '放疗技术', visible: true, type: 'input', group: 'detail' },
        { prop: 'radioSite', label: '放疗部位', visible: true, type: 'input', group: 'detail' },
        { prop: 'targetVolume', label: '靶区部位', visible: true, type: 'input', group: 'detail' },
        { prop: 'presDays', label: '处方天数', visible: true, type: 'number', group: 'detail' },
        { prop: 'presTotalDose', label: '处方总剂量', visible: true, type: 'input', group: 'detail' },
        { prop: 'presRadioCount', label: '处方放疗次数', visible: true, type: 'number', group: 'detail' },
        { prop: 'radioSingleDose', label: '处方分次剂量', visible: true, type: 'input', group: 'detail' },
        { prop: 'synChemoMark', label: '是否同步化疗', visible: true, type: 'input', group: 'detail' },
        { prop: 'synChemoScheme', label: '同步化疗方案', visible: true, type: 'input', group: 'detail' },
        { prop: 'synOtherSchemeMark', label: '是否同步其他药物治疗', visible: true, type: 'input', group: 'detail' },
        { prop: 'synOtherScheme', label: '其他同步治疗方案', visible: true, type: 'input', group: 'detail' },
        { prop: 'effectEvalTime', label: '疗效评价日期', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'effectEval', label: '疗效评价', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'adverseDrugReaction', label: '不良反应', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'extendData1', label: '扩展字段1', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'extendData2', label: '扩展字段2', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'recordStatus', label: '记录状态:1正常 0作废', visible: true, type: 'number', group: 'detail' },
        { prop: 'therapeuticPurposes', label: '治疗目的', visible: true, type: 'input', group: 'detail' },
        { prop: 'createdTime', label: '创建时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'updatedTime', label: '更新时间', visible: true, type: 'datetime', group: 'detail' }
      ]
    }
  ];

  return new FieldConfigManager('natdssB181RadInfo', fieldGroups);
}


// natdssB191FollowUp字段配置
export function createNatdssB191FollowUpFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '系统自增主键', visible: true, type: 'number', group: 'basic' },
        { prop: 'patientId', label: '患者ID', visible: true, type: 'input', group: 'basic' },
        { prop: 'visitType', label: '就诊类型:住院、门诊', visible: true, type: 'input', group: 'basic' },
        { prop: 'visitCardNo', label: '就诊卡号', visible: true, type: 'input', group: 'basic' },
        { prop: 'outpatientNo', label: '门诊号', visible: true, type: 'input', group: 'basic' },
        { prop: 'medicalRecordNo', label: '病案号', visible: true, type: 'input', group: 'basic' },
        { prop: 'inpatientNo', label: '住院号', visible: true, type: 'input', group: 'basic' },
        { prop: 'name', label: '姓名', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'visitSn', label: '单次就诊唯一标识号', visible: true, type: 'input', group: 'detail' },
        { prop: 'gender', label: '性别', visible: true, type: 'input', group: 'detail' },
        { prop: 'age', label: '年龄', visible: true, type: 'number', group: 'detail' },
        { prop: 'dateOfBirth', label: '出生日期', visible: true, type: 'date', group: 'detail' },
        { prop: 'followupSn', label: '随访流水号', visible: true, type: 'input', group: 'detail' },
        { prop: 'followupMethod', label: '随访方式', visible: true, type: 'input', group: 'detail' },
        { prop: 'firstTreatAge', label: '初治年龄', visible: true, type: 'number', group: 'detail' },
        { prop: 'firstTreatDatetime', label: '初治日期', visible: true, type: 'date', group: 'detail' },
        { prop: 'followupPeriod', label: '随访周期', visible: true, type: 'input', group: 'detail' },
        { prop: 'followupDatetime', label: '随访日期', visible: true, type: 'date', group: 'detail' },
        { prop: 'followupStatusCode', label: '随访状态代码', visible: true, type: 'input', group: 'detail' },
        { prop: 'followupStatus', label: '随访状态', visible: true, type: 'input', group: 'detail' },
        { prop: 'healthStatus', label: '身体状况', visible: true, type: 'input', group: 'detail' },
        { prop: 'deathDatetime', label: '死亡日期', visible: true, type: 'date', group: 'detail' },
        { prop: 'causeOfDeath', label: '死亡原因', visible: true, type: 'input', group: 'detail' },
        { prop: 'recurDatetime', label: '复发日期', visible: true, type: 'date', group: 'detail' },
        { prop: 'recurDiagCode', label: '复发诊断编码', visible: true, type: 'input', group: 'detail' },
        { prop: 'recurDiagName', label: '复发诊断名称', visible: true, type: 'input', group: 'detail' },
        { prop: 'firstRecurMetsDate', label: '首次复发转移日期', visible: true, type: 'date', group: 'detail' },
        { prop: 'metsDatetime', label: '转移日期', visible: true, type: 'date', group: 'detail' },
        { prop: 'metsSite', label: '转移部位', visible: true, type: 'input', group: 'detail' },
        { prop: 'metsDiagCode', label: '转移诊断编码', visible: true, type: 'input', group: 'detail' },
        { prop: 'metsDiagName', label: '转移诊断名称', visible: true, type: 'input', group: 'detail' },
        { prop: 'mulpriDiagCode', label: '多原发诊断编码', visible: true, type: 'input', group: 'detail' },
        { prop: 'mulpriDiagName', label: '多原发诊断名称', visible: true, type: 'input', group: 'detail' },
        { prop: 'followupConclusion', label: '随访结论', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'certificateType', label: '证件类型', visible: true, type: 'input', group: 'detail' },
        { prop: 'certificateNo', label: '证件号码', visible: true, type: 'input', group: 'detail' },
        { prop: 'currentAddress', label: '现住址', visible: true, type: 'input', group: 'detail' },
        { prop: 'phoneNo', label: '联系电话', visible: true, type: 'input', group: 'detail' },
        { prop: 'phoneNo2', label: '联系电话2', visible: true, type: 'input', group: 'detail' },
        { prop: 'email', label: '邮箱', visible: true, type: 'input', group: 'detail' },
        { prop: 'weixin', label: '微信', visible: true, type: 'input', group: 'detail' },
        { prop: 'contactPerson1', label: '紧急联系人1', visible: true, type: 'input', group: 'detail' },
        { prop: 'contactPhoneNo1', label: '紧急联系人电话1', visible: true, type: 'input', group: 'detail' },
        { prop: 'contactPerson2', label: '紧急联系人2', visible: true, type: 'input', group: 'detail' },
        { prop: 'contactPhoneNo2', label: '紧急联系人电话2', visible: true, type: 'input', group: 'detail' },
        { prop: 'extendData1', label: '扩展字段1', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'extendData2', label: '扩展字段2', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'recordStatus', label: '记录状态:1正常 0作废', visible: true, type: 'number', group: 'detail' },
        { prop: 'adverseReaction', label: '不良反应', visible: true, type: 'input', group: 'detail' },
        { prop: 'createdTime', label: '创建时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'updatedTime', label: '更新时间', visible: true, type: 'datetime', group: 'detail' }
      ]
    }
  ];

  return new FieldConfigManager('natdssB191FollowUp', fieldGroups);
}
