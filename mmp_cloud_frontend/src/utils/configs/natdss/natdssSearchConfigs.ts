import { SearchConfigManager, SearchFieldGroup } from '../searchConfigManager';

// natdssB011DrugPurchase搜索配置
export function createNatdssB011DrugPurchaseSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '系统自增主键', type: 'number', visible: true, placeholder: '请输入系统自增主键' },
        { prop: 'hosDrugCode', label: '本院药品编码', type: 'input', visible: true, placeholder: '请输入本院药品编码' },
        { prop: 'genericName', label: '药品通用名', type: 'input', visible: true, placeholder: '请输入药品通用名' },
        { prop: 'tradeName', label: '药品商品名', type: 'input', visible: true, placeholder: '请输入药品商品名' },
        { prop: 'approvalNo', label: '批准文号', type: 'input', visible: true, placeholder: '请输入批准文号' },
        { prop: 'insuranceType', label: '费用类型', type: 'input', visible: false, placeholder: '请输入费用类型' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'purSn', label: '药品入库明细流水号', type: 'input', visible: false, placeholder: '请输入药品入库明细流水号' },
        { prop: 'manufac', label: '生产厂家', type: 'input', visible: false, placeholder: '请输入生产厂家' },
        { prop: 'form', label: '药品剂型', type: 'input', visible: false, placeholder: '请输入药品剂型' },
        { prop: 'spec', label: '药品规格', type: 'input', visible: false, placeholder: '请输入药品规格' },
        { prop: 'packingQuantity', label: '包装数量', type: 'input', visible: false, placeholder: '请输入包装数量' },
        { prop: 'packingUnit', label: '包装单位', type: 'input', visible: false, placeholder: '请输入包装单位' },
        { prop: 'purUnitPrice', label: '药品单价', type: 'number', visible: false, placeholder: '请输入药品单价' },
        { prop: 'purQuantity', label: '采购数量', type: 'number', visible: false, placeholder: '请输入采购数量' },
        { prop: 'purTotalPrice', label: '采购金额', type: 'number', visible: false, placeholder: '请输入采购金额' },
        { prop: 'purDate', label: '采购时间', type: 'daterange', visible: false, placeholder: '请输入采购时间', startProp: 'purDateStart', endProp: 'purDateEnd' },
        { prop: 'createdTime', label: '创建时间', type: 'daterange', visible: false, placeholder: '请输入创建时间', startProp: 'createdTimeStart', endProp: 'createdTimeEnd' },
        { prop: 'updatedTime', label: '更新时间', type: 'daterange', visible: false, placeholder: '请输入更新时间', startProp: 'updatedTimeStart', endProp: 'updatedTimeEnd' }
      ]
    }
  ];

  return new SearchConfigManager('natdssB011DrugPurchase', searchFieldGroups);
}


// natdssB012DrugUse搜索配置
export function createNatdssB012DrugUseSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '系统自增主键', type: 'number', visible: true, placeholder: '请输入系统自增主键' },
        { prop: 'hosDrugCode', label: '本院药品编码', type: 'input', visible: true, placeholder: '请输入本院药品编码' },
        { prop: 'genericName', label: '药品通用名', type: 'input', visible: true, placeholder: '请输入药品通用名' },
        { prop: 'tradeName', label: '药品商品名', type: 'input', visible: true, placeholder: '请输入药品商品名' },
        { prop: 'approvalNo', label: '批准文号', type: 'input', visible: true, placeholder: '请输入批准文号' },
        { prop: 'insuranceType', label: '费用类型', type: 'input', visible: false, placeholder: '请输入费用类型' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'presSn', label: '药品使用流水号', type: 'input', visible: false, placeholder: '请输入药品使用流水号' },
        { prop: 'manufac', label: '生产厂家', type: 'input', visible: false, placeholder: '请输入生产厂家' },
        { prop: 'form', label: '药品剂型', type: 'input', visible: false, placeholder: '请输入药品剂型' },
        { prop: 'spec', label: '药品规格', type: 'input', visible: false, placeholder: '请输入药品规格' },
        { prop: 'packingQuantity', label: '包装数量', type: 'input', visible: false, placeholder: '请输入包装数量' },
        { prop: 'packingUnit', label: '包装单位', type: 'input', visible: false, placeholder: '请输入包装单位' },
        { prop: 'presUnitPrice', label: '药品单价', type: 'number', visible: false, placeholder: '请输入药品单价' },
        { prop: 'presQuantity', label: '使用数量', type: 'number', visible: false, placeholder: '请输入使用数量' },
        { prop: 'presTotalPrice', label: '使用金额', type: 'number', visible: false, placeholder: '请输入使用金额' },
        { prop: 'presOrigin', label: '来源:门诊/住院', type: 'input', visible: false, placeholder: '请输入来源:门诊/住院' },
        { prop: 'presDate', label: '收费时间', type: 'daterange', visible: false, placeholder: '请输入收费时间', startProp: 'presDateStart', endProp: 'presDateEnd' },
        { prop: 'createdTime', label: '创建时间', type: 'daterange', visible: false, placeholder: '请输入创建时间', startProp: 'createdTimeStart', endProp: 'createdTimeEnd' },
        { prop: 'updatedTime', label: '更新时间', type: 'daterange', visible: false, placeholder: '请输入更新时间', startProp: 'updatedTimeStart', endProp: 'updatedTimeEnd' }
      ]
    }
  ];

  return new SearchConfigManager('natdssB012DrugUse', searchFieldGroups);
}


// natdssB021PatientInfo搜索配置
export function createNatdssB021PatientInfoSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '系统自增主键', type: 'number', visible: true, placeholder: '请输入系统自增主键' },
        { prop: 'patientId', label: '患者ID-患者在本院信息系统内的唯一标识', type: 'input', visible: true, placeholder: '请输入患者ID-患者在本院信息系统内的唯一标识' },
        { prop: 'visitType', label: '就诊类型:住院、门诊', type: 'input', visible: true, placeholder: '请输入就诊类型:住院、门诊' },
        { prop: 'visitCardNo', label: '就诊卡号', type: 'input', visible: true, placeholder: '请输入就诊卡号' },
        { prop: 'outpatientNo', label: '门诊号', type: 'input', visible: true, placeholder: '请输入门诊号' },
        { prop: 'medicalRecordNo', label: '病案号', type: 'input', visible: false, placeholder: '请输入病案号' },
        { prop: 'inpatientNo', label: '住院号', type: 'input', visible: false, placeholder: '请输入住院号' },
        { prop: 'visitDoctorNo', label: '就诊医生代码', type: 'input', visible: false, placeholder: '请输入就诊医生代码' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'visitSn', label: '单次就诊唯一标识号', type: 'input', visible: false, placeholder: '请输入单次就诊唯一标识号' },
        { prop: 'visitTimes', label: '就诊次数', type: 'number', visible: false, placeholder: '请输入就诊次数' },
        { prop: 'visitDatetime', label: '就诊时间', type: 'daterange', visible: false, placeholder: '请输入就诊时间', startProp: 'visitDatetimeStart', endProp: 'visitDatetimeEnd' },
        { prop: 'hospitalizationTimes', label: '住院次数', type: 'input', visible: false, placeholder: '请输入住院次数' },
        { prop: 'admissionDatetime', label: '入院时间', type: 'daterange', visible: false, placeholder: '请输入入院时间', startProp: 'admissionDatetimeStart', endProp: 'admissionDatetimeEnd' },
        { prop: 'dischargeDatetime', label: '出院时间', type: 'daterange', visible: false, placeholder: '请输入出院时间', startProp: 'dischargeDatetimeStart', endProp: 'dischargeDatetimeEnd' },
        { prop: 'name', label: '姓名', type: 'input', visible: false, placeholder: '请输入姓名' },
        { prop: 'gender', label: '性别:男、女、未知', type: 'input', visible: false, placeholder: '请输入性别:男、女、未知' },
        { prop: 'dateOfBirth', label: '出生日期', type: 'daterange', visible: false, placeholder: '请输入出生日期', startProp: 'dateOfBirthStart', endProp: 'dateOfBirthEnd' },
        { prop: 'occupationCode', label: '职业类别代码', type: 'input', visible: false, placeholder: '请输入职业类别代码' },
        { prop: 'occupationName', label: '职业类别名称', type: 'input', visible: false, placeholder: '请输入职业类别名称' },
        { prop: 'nationality', label: '国籍', type: 'input', visible: false, placeholder: '请输入国籍' },
        { prop: 'ethnicity', label: '民族', type: 'input', visible: false, placeholder: '请输入民族' },
        { prop: 'education', label: '文化程度', type: 'input', visible: false, placeholder: '请输入文化程度' },
        { prop: 'maritalStatus', label: '婚姻状况类别', type: 'input', visible: false, placeholder: '请输入婚姻状况类别' },
        { prop: 'newbronMark', label: '是否新生儿', type: 'input', visible: false, placeholder: '请输入是否新生儿' },
        { prop: 'certificateType', label: '证件类型', type: 'input', visible: false, placeholder: '请输入证件类型' },
        { prop: 'certificateNo', label: '证件号码', type: 'input', visible: false, placeholder: '请输入证件号码' },
        { prop: 'healthCardType', label: '健康卡类型', type: 'input', visible: false, placeholder: '请输入健康卡类型' },
        { prop: 'healthCardNo', label: '健康卡号', type: 'input', visible: false, placeholder: '请输入健康卡号' },
        { prop: 'insuranceType', label: '医保类型', type: 'input', visible: false, placeholder: '请输入医保类型' },
        { prop: 'insuranceNo', label: '医保卡号', type: 'input', visible: false, placeholder: '请输入医保卡号' },
        { prop: 'residenceProvince', label: '户籍地址-省名称', type: 'input', visible: false, placeholder: '请输入户籍地址-省名称' },
        { prop: 'residenceCity', label: '户籍地址-市名称', type: 'input', visible: false, placeholder: '请输入户籍地址-市名称' },
        { prop: 'residenceCounty', label: '户籍地址-县名称', type: 'input', visible: false, placeholder: '请输入户籍地址-县名称' },
        { prop: 'currentAddress', label: '现住址', type: 'input', visible: false, placeholder: '请输入现住址' },
        { prop: 'phoneNo', label: '联系电话', type: 'input', visible: false, placeholder: '请输入联系电话' },
        { prop: 'phoneNo2', label: '联系电话2', type: 'input', visible: false, placeholder: '请输入联系电话2' },
        { prop: 'email', label: '邮箱', type: 'input', visible: false, placeholder: '请输入邮箱' },
        { prop: 'weixin', label: '微信', type: 'input', visible: false, placeholder: '请输入微信' },
        { prop: 'contactPerson1', label: '紧急联系人1', type: 'input', visible: false, placeholder: '请输入紧急联系人1' },
        { prop: 'contactPhoneNo1', label: '紧急联系人电话1', type: 'input', visible: false, placeholder: '请输入紧急联系人电话1' },
        { prop: 'contactPerson2', label: '紧急联系人2', type: 'input', visible: false, placeholder: '请输入紧急联系人2' },
        { prop: 'contactPhoneNo2', label: '紧急联系人电话2', type: 'input', visible: false, placeholder: '请输入紧急联系人电话2' },
        { prop: 'aboBloodType', label: 'ABO血型', type: 'input', visible: false, placeholder: '请输入ABO血型' },
        { prop: 'rhBloodType', label: 'Rh血型', type: 'input', visible: false, placeholder: '请输入Rh血型' },
        { prop: 'extendData1', label: '扩展字段1', type: 'input', visible: false, placeholder: '请输入扩展字段1' },
        { prop: 'extendData2', label: '扩展字段2', type: 'input', visible: false, placeholder: '请输入扩展字段2' },
        { prop: 'recordStatus', label: '记录状态:1正常 0作废', type: 'number', visible: false, placeholder: '请输入记录状态:1正常 0作废' },
        { prop: 'createdTime', label: '创建时间', type: 'daterange', visible: false, placeholder: '请输入创建时间', startProp: 'createdTimeStart', endProp: 'createdTimeEnd' },
        { prop: 'updatedTime', label: '更新时间', type: 'daterange', visible: false, placeholder: '请输入更新时间', startProp: 'updatedTimeStart', endProp: 'updatedTimeEnd' }
      ]
    }
  ];

  return new SearchConfigManager('natdssB021PatientInfo', searchFieldGroups);
}


// natdssB022AdrInfo搜索配置
export function createNatdssB022AdrInfoSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '系统自增主键', type: 'number', visible: true, placeholder: '请输入系统自增主键' },
        { prop: 'patientId', label: '患者ID', type: 'input', visible: true, placeholder: '请输入患者ID' },
        { prop: 'visitType', label: '就诊类型:住院、门诊', type: 'input', visible: true, placeholder: '请输入就诊类型:住院、门诊' },
        { prop: 'visitCardNo', label: '就诊卡号', type: 'input', visible: true, placeholder: '请输入就诊卡号' },
        { prop: 'medicalRecordNo', label: '病案号', type: 'input', visible: true, placeholder: '请输入病案号' },
        { prop: 'outpatientNo', label: '门诊号', type: 'input', visible: false, placeholder: '请输入门诊号' },
        { prop: 'inpatientNo', label: '住院号', type: 'input', visible: false, placeholder: '请输入住院号' },
        { prop: 'name', label: '姓名', type: 'input', visible: false, placeholder: '请输入姓名' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'visitSn', label: '单次就诊唯一标识号', type: 'input', visible: false, placeholder: '请输入单次就诊唯一标识号' },
        { prop: 'visitTimes', label: '就诊次数', type: 'number', visible: false, placeholder: '请输入就诊次数' },
        { prop: 'hospitalizationTimes', label: '住院次数', type: 'input', visible: false, placeholder: '请输入住院次数' },
        { prop: 'adrEventSn', label: '药品不良反应流水号', type: 'input', visible: false, placeholder: '请输入药品不良反应流水号' },
        { prop: 'adrReportStatus', label: '药品不良反应报告状态', type: 'input', visible: false, placeholder: '请输入药品不良反应报告状态' },
        { prop: 'adrReportType', label: '药品不良反应报告类型', type: 'input', visible: false, placeholder: '请输入药品不良反应报告类型' },
        { prop: 'adrReportTime', label: '报告时间', type: 'daterange', visible: false, placeholder: '请输入报告时间', startProp: 'adrReportTimeStart', endProp: 'adrReportTimeEnd' },
        { prop: 'adrOriginalDisease', label: '患者原患疾病', type: 'input', visible: false, placeholder: '请输入患者原患疾病' },
        { prop: 'adrDiseaseInfluence', label: '对原患疾病的影响', type: 'input', visible: false, placeholder: '请输入对原患疾病的影响' },
        { prop: 'adrFamilyStatus', label: '家族药品不良反应', type: 'input', visible: false, placeholder: '请输入家族药品不良反应' },
        { prop: 'adrPastStatus', label: '既往药品不良反应', type: 'input', visible: false, placeholder: '请输入既往药品不良反应' },
        { prop: 'adrPastOther', label: '其他既往信息', type: 'input', visible: false, placeholder: '请输入其他既往信息' },
        { prop: 'adrEventName', label: '药品不良反应事件名称', type: 'input', visible: false, placeholder: '请输入药品不良反应事件名称' },
        { prop: 'adrEventTime', label: '不良事件发生时间', type: 'daterange', visible: false, placeholder: '请输入不良事件发生时间', startProp: 'adrEventTimeStart', endProp: 'adrEventTimeEnd' },
        { prop: 'adrEventContent', label: '不良事件过程描述', type: 'input', visible: false, placeholder: '请输入不良事件过程描述' },
        { prop: 'adrEventResult', label: '不良反应结果', type: 'input', visible: false, placeholder: '请输入不良反应结果' },
        { prop: 'adrStopStatus', label: '停药或减药后是否减轻或消失', type: 'input', visible: false, placeholder: '请输入停药或减药后是否减轻或消失' },
        { prop: 'adrReuseStatus', label: '再次使用药物后是否出现同样反应', type: 'input', visible: false, placeholder: '请输入再次使用药物后是否出现同样反应' },
        { prop: 'suspectDrugApprovalNo', label: '怀疑药品批准文号', type: 'input', visible: false, placeholder: '请输入怀疑药品批准文号' },
        { prop: 'suspectDrugCode', label: '怀疑药品编码', type: 'input', visible: false, placeholder: '请输入怀疑药品编码' },
        { prop: 'suspectDrugTradeName', label: '怀疑药品商品名', type: 'input', visible: false, placeholder: '请输入怀疑药品商品名' },
        { prop: 'suspectDrugGenericName', label: '怀疑药品通用名', type: 'input', visible: false, placeholder: '请输入怀疑药品通用名' },
        { prop: 'suspectDrugManufac', label: '怀疑药品生产厂商', type: 'input', visible: false, placeholder: '请输入怀疑药品生产厂商' },
        { prop: 'suspectDrugBatchNo', label: '怀疑药品生产批号', type: 'input', visible: false, placeholder: '请输入怀疑药品生产批号' },
        { prop: 'suspectDrugDosage', label: '怀疑药品用量', type: 'input', visible: false, placeholder: '请输入怀疑药品用量' },
        { prop: 'suspectDrugMethod', label: '怀疑药品给药途径', type: 'input', visible: false, placeholder: '请输入怀疑药品给药途径' },
        { prop: 'suspectDrugStartTime', label: '怀疑药品开始时间', type: 'daterange', visible: false, placeholder: '请输入怀疑药品开始时间', startProp: 'suspectDrugStartTimeStart', endProp: 'suspectDrugStartTimeEnd' },
        { prop: 'suspectDrugEndTime', label: '怀疑药品结束时间', type: 'daterange', visible: false, placeholder: '请输入怀疑药品结束时间', startProp: 'suspectDrugEndTimeStart', endProp: 'suspectDrugEndTimeEnd' },
        { prop: 'suspectDrugReason', label: '怀疑药品用药原因', type: 'input', visible: false, placeholder: '请输入怀疑药品用药原因' },
        { prop: 'concomitantDrugApprovalNo', label: '合并药品批准文号', type: 'input', visible: false, placeholder: '请输入合并药品批准文号' },
        { prop: 'concomitantDrugCode', label: '合并药品编码', type: 'input', visible: false, placeholder: '请输入合并药品编码' },
        { prop: 'concomitantDrugTradeName', label: '合并药品商品名', type: 'input', visible: false, placeholder: '请输入合并药品商品名' },
        { prop: 'concomitantDrugGenericName', label: '合并药品通用名', type: 'input', visible: false, placeholder: '请输入合并药品通用名' },
        { prop: 'concomitantDrugManufac', label: '合并药品生产厂商', type: 'input', visible: false, placeholder: '请输入合并药品生产厂商' },
        { prop: 'concomitantDrugBatchNo', label: '合并药品生产批号', type: 'input', visible: false, placeholder: '请输入合并药品生产批号' },
        { prop: 'concomitantDrugDosage', label: '合并药品用量', type: 'input', visible: false, placeholder: '请输入合并药品用量' },
        { prop: 'concomitantDrugMethod', label: '合并药品给药途径', type: 'input', visible: false, placeholder: '请输入合并药品给药途径' },
        { prop: 'concomitantDrugStartTime', label: '合并药品开始时间', type: 'daterange', visible: false, placeholder: '请输入合并药品开始时间', startProp: 'concomitantDrugStartTimeStart', endProp: 'concomitantDrugStartTimeEnd' },
        { prop: 'concomitantDrugEndTime', label: '合并药品结束时间', type: 'daterange', visible: false, placeholder: '请输入合并药品结束时间', startProp: 'concomitantDrugEndTimeStart', endProp: 'concomitantDrugEndTimeEnd' },
        { prop: 'concomitantDrugReason', label: '合并药品用药原因', type: 'input', visible: false, placeholder: '请输入合并药品用药原因' },
        { prop: 'adrReporterAppraise', label: '关联性报告人评价', type: 'input', visible: false, placeholder: '请输入关联性报告人评价' },
        { prop: 'adrReportUnitAppraise', label: '关联性报告单位评价', type: 'input', visible: false, placeholder: '请输入关联性报告单位评价' },
        { prop: 'extendData1', label: '扩展字段1:填写怀疑用药或并用药品', type: 'input', visible: false, placeholder: '请输入扩展字段1:填写怀疑用药或并用药品' },
        { prop: 'extendData2', label: '扩展字段2', type: 'input', visible: false, placeholder: '请输入扩展字段2' },
        { prop: 'recordStatus', label: '记录状态:1正常 0作废', type: 'number', visible: false, placeholder: '请输入记录状态:1正常 0作废' },
        { prop: 'createdTime', label: '创建时间', type: 'daterange', visible: false, placeholder: '请输入创建时间', startProp: 'createdTimeStart', endProp: 'createdTimeEnd' },
        { prop: 'updatedTime', label: '更新时间', type: 'daterange', visible: false, placeholder: '请输入更新时间', startProp: 'updatedTimeStart', endProp: 'updatedTimeEnd' }
      ]
    }
  ];

  return new SearchConfigManager('natdssB022AdrInfo', searchFieldGroups);
}


// natdssB023DiagInfo搜索配置
export function createNatdssB023DiagInfoSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '系统自增主键', type: 'number', visible: true, placeholder: '请输入系统自增主键' },
        { prop: 'patientId', label: '患者ID', type: 'input', visible: true, placeholder: '请输入患者ID' },
        { prop: 'visitType', label: '就诊类型:住院、门诊', type: 'input', visible: true, placeholder: '请输入就诊类型:住院、门诊' },
        { prop: 'visitCardNo', label: '就诊卡号', type: 'input', visible: true, placeholder: '请输入就诊卡号' },
        { prop: 'medicalRecordNo', label: '病案号', type: 'input', visible: true, placeholder: '请输入病案号' },
        { prop: 'outpatientNo', label: '门诊号', type: 'input', visible: false, placeholder: '请输入门诊号' },
        { prop: 'inpatientNo', label: '住院号', type: 'input', visible: false, placeholder: '请输入住院号' },
        { prop: 'name', label: '患者姓名', type: 'input', visible: false, placeholder: '请输入患者姓名' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'visitSn', label: '单次就诊唯一标识号', type: 'input', visible: false, placeholder: '请输入单次就诊唯一标识号' },
        { prop: 'visitTimes', label: '就诊次数', type: 'number', visible: false, placeholder: '请输入就诊次数' },
        { prop: 'hospitalizationTimes', label: '住院次数', type: 'input', visible: false, placeholder: '请输入住院次数' },
        { prop: 'diagId', label: '诊断ID号', type: 'input', visible: false, placeholder: '请输入诊断ID号' },
        { prop: 'diagSerialNumber', label: '诊断序号', type: 'input', visible: false, placeholder: '请输入诊断序号' },
        { prop: 'diagType', label: '诊断类型:门诊诊断、入院诊断、出院诊断、其他诊断', type: 'input', visible: false, placeholder: '请输入诊断类型:门诊诊断、入院诊断、出院诊断、其他诊断' },
        { prop: 'diagCode', label: '诊断编码', type: 'input', visible: false, placeholder: '请输入诊断编码' },
        { prop: 'diagName', label: '诊断名称', type: 'input', visible: false, placeholder: '请输入诊断名称' },
        { prop: 'diagExplanation', label: '诊断说明', type: 'input', visible: false, placeholder: '请输入诊断说明' },
        { prop: 'diagDatetime', label: '诊断时间', type: 'daterange', visible: false, placeholder: '请输入诊断时间', startProp: 'diagDatetimeStart', endProp: 'diagDatetimeEnd' },
        { prop: 'confirmedDiagMark', label: '是否明确诊断', type: 'input', visible: false, placeholder: '请输入是否明确诊断' },
        { prop: 'maindiagMark', label: '是否主要诊断', type: 'input', visible: false, placeholder: '请输入是否主要诊断' },
        { prop: 'diagDoctorNo', label: '诊断医生代码', type: 'input', visible: false, placeholder: '请输入诊断医生代码' },
        { prop: 'extendData1', label: '扩展字段1', type: 'input', visible: false, placeholder: '请输入扩展字段1' },
        { prop: 'extendData2', label: '扩展字段2', type: 'input', visible: false, placeholder: '请输入扩展字段2' },
        { prop: 'recordStatus', label: '记录状态:1正常 0作废', type: 'number', visible: false, placeholder: '请输入记录状态:1正常 0作废' },
        { prop: 'createdTime', label: '创建时间', type: 'daterange', visible: false, placeholder: '请输入创建时间', startProp: 'createdTimeStart', endProp: 'createdTimeEnd' },
        { prop: 'updatedTime', label: '更新时间', type: 'daterange', visible: false, placeholder: '请输入更新时间', startProp: 'updatedTimeStart', endProp: 'updatedTimeEnd' }
      ]
    }
  ];

  return new SearchConfigManager('natdssB023DiagInfo', searchFieldGroups);
}


// natdssB031InpatientInfo搜索配置
export function createNatdssB031InpatientInfoSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '系统自增主键', type: 'number', visible: true, placeholder: '请输入系统自增主键' },
        { prop: 'patientId', label: '患者ID', type: 'input', visible: true, placeholder: '请输入患者ID' },
        { prop: 'visitCardNo', label: '就诊卡号', type: 'input', visible: true, placeholder: '请输入就诊卡号' },
        { prop: 'medicalRecordNo', label: '病案号', type: 'input', visible: true, placeholder: '请输入病案号' },
        { prop: 'inpatientNo', label: '住院号', type: 'input', visible: true, placeholder: '请输入住院号' },
        { prop: 'name', label: '姓名', type: 'input', visible: false, placeholder: '请输入姓名' },
        { prop: 'currentDeptCode', label: '当前科室代码', type: 'input', visible: false, placeholder: '请输入当前科室代码' },
        { prop: 'currentDeptName', label: '当前科室名称', type: 'input', visible: false, placeholder: '请输入当前科室名称' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'visitSn', label: '单次就诊唯一标识号', type: 'input', visible: false, placeholder: '请输入单次就诊唯一标识号' },
        { prop: 'hospitalizationTimes', label: '住院次数', type: 'input', visible: false, placeholder: '请输入住院次数' },
        { prop: 'admissionDatetime', label: '入院时间', type: 'daterange', visible: false, placeholder: '请输入入院时间', startProp: 'admissionDatetimeStart', endProp: 'admissionDatetimeEnd' },
        { prop: 'currentWardName', label: '当前病房名称', type: 'input', visible: false, placeholder: '请输入当前病房名称' },
        { prop: 'currentBedName', label: '当前床位名称', type: 'input', visible: false, placeholder: '请输入当前床位名称' },
        { prop: 'visitDoctorNo', label: '管床医生代码', type: 'input', visible: false, placeholder: '请输入管床医生代码' },
        { prop: 'dischargeDatetime', label: '出院时间', type: 'daterange', visible: false, placeholder: '请输入出院时间', startProp: 'dischargeDatetimeStart', endProp: 'dischargeDatetimeEnd' },
        { prop: 'dischargeDeptCode', label: '出院科室编码', type: 'input', visible: false, placeholder: '请输入出院科室编码' },
        { prop: 'dischargeDeptName', label: '出院科室名称', type: 'input', visible: false, placeholder: '请输入出院科室名称' },
        { prop: 'extendData1', label: '扩展字段1:出院状态', type: 'input', visible: false, placeholder: '请输入扩展字段1:出院状态' },
        { prop: 'extendData2', label: '扩展字段2', type: 'input', visible: false, placeholder: '请输入扩展字段2' },
        { prop: 'recordStatus', label: '记录状态:1正常 0作废', type: 'number', visible: false, placeholder: '请输入记录状态:1正常 0作废' },
        { prop: 'createdTime', label: '创建时间', type: 'daterange', visible: false, placeholder: '请输入创建时间', startProp: 'createdTimeStart', endProp: 'createdTimeEnd' },
        { prop: 'updatedTime', label: '更新时间', type: 'daterange', visible: false, placeholder: '请输入更新时间', startProp: 'updatedTimeStart', endProp: 'updatedTimeEnd' }
      ]
    }
  ];

  return new SearchConfigManager('natdssB031InpatientInfo', searchFieldGroups);
}


// natdssB051EmrAdmission搜索配置
export function createNatdssB051EmrAdmissionSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '系统自增主键', type: 'number', visible: true, placeholder: '请输入系统自增主键' },
        { prop: 'patientId', label: '患者ID', type: 'input', visible: true, placeholder: '请输入患者ID' },
        { prop: 'medicalRecordNo', label: '病案号', type: 'input', visible: true, placeholder: '请输入病案号' },
        { prop: 'inpatientNo', label: '住院号', type: 'input', visible: true, placeholder: '请输入住院号' },
        { prop: 'admissionMaindiagCode1', label: '入院主要诊断编码', type: 'input', visible: true, placeholder: '请输入入院主要诊断编码' },
        { prop: 'admissionMaindiagName1', label: '入院主要诊断名称', type: 'input', visible: false, placeholder: '请输入入院主要诊断名称' },
        { prop: 'admissionDiagCode2', label: '入院诊断编码-2', type: 'input', visible: false, placeholder: '请输入入院诊断编码-2' },
        { prop: 'admissionDiagName2', label: '入院诊断名称-2', type: 'input', visible: false, placeholder: '请输入入院诊断名称-2' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'visitSn', label: '单次就诊唯一标识号', type: 'input', visible: false, placeholder: '请输入单次就诊唯一标识号' },
        { prop: 'hospitalizationTimes', label: '住院次数', type: 'input', visible: false, placeholder: '请输入住院次数' },
        { prop: 'recordSn', label: '入院记录流水号', type: 'input', visible: false, placeholder: '请输入入院记录流水号' },
        { prop: 'recordDatetime', label: '入院记录创建时间', type: 'daterange', visible: false, placeholder: '请输入入院记录创建时间', startProp: 'recordDatetimeStart', endProp: 'recordDatetimeEnd' },
        { prop: 'kpsScore', label: 'KPS评分', type: 'input', visible: false, placeholder: '请输入KPS评分' },
        { prop: 'ecogScore', label: 'ECOG PS评分', type: 'input', visible: false, placeholder: '请输入ECOG PS评分' },
        { prop: 'recordText', label: '文书内容', type: 'input', visible: false, placeholder: '请输入文书内容' },
        { prop: 'chiefComplaint', label: '主诉', type: 'input', visible: false, placeholder: '请输入主诉' },
        { prop: 'currentMedhistory', label: '现病史', type: 'input', visible: false, placeholder: '请输入现病史' },
        { prop: 'pastMedhistory', label: '既往史', type: 'input', visible: false, placeholder: '请输入既往史' },
        { prop: 'personalMedhistory', label: '个人史', type: 'input', visible: false, placeholder: '请输入个人史' },
        { prop: 'familyHistory', label: '家族史', type: 'input', visible: false, placeholder: '请输入家族史' },
        { prop: 'marriageBirthHistory', label: '婚育史', type: 'input', visible: false, placeholder: '请输入婚育史' },
        { prop: 'menstrualHistory', label: '月经史', type: 'input', visible: false, placeholder: '请输入月经史' },
        { prop: 'systolicPressure', label: '收缩压', type: 'input', visible: false, placeholder: '请输入收缩压' },
        { prop: 'diastolicPressure', label: '舒张压', type: 'input', visible: false, placeholder: '请输入舒张压' },
        { prop: 'respiratoryRate', label: '呼吸', type: 'input', visible: false, placeholder: '请输入呼吸' },
        { prop: 'bodyTemperature', label: '体温', type: 'input', visible: false, placeholder: '请输入体温' },
        { prop: 'heartRate', label: '心率', type: 'input', visible: false, placeholder: '请输入心率' },
        { prop: 'height', label: '身高', type: 'input', visible: false, placeholder: '请输入身高' },
        { prop: 'weight', label: '体重', type: 'input', visible: false, placeholder: '请输入体重' },
        { prop: 'bodySurfaceArea', label: '体表面积', type: 'input', visible: false, placeholder: '请输入体表面积' },
        { prop: 'physicalExam', label: '体格检查', type: 'input', visible: false, placeholder: '请输入体格检查' },
        { prop: 'specialExam', label: '专科检查', type: 'input', visible: false, placeholder: '请输入专科检查' },
        { prop: 'auxiliaryExam', label: '辅助检查', type: 'input', visible: false, placeholder: '请输入辅助检查' },
        { prop: 'admissionDiagCode3', label: '入院诊断编码-3', type: 'input', visible: false, placeholder: '请输入入院诊断编码-3' },
        { prop: 'admissionDiagName3', label: '入院诊断名称-3', type: 'input', visible: false, placeholder: '请输入入院诊断名称-3' },
        { prop: 'admissionDiagCode4', label: '入院诊断编码-4', type: 'input', visible: false, placeholder: '请输入入院诊断编码-4' },
        { prop: 'admissionDiagName4', label: '入院诊断名称-4', type: 'input', visible: false, placeholder: '请输入入院诊断名称-4' },
        { prop: 'admissionDiagCode5', label: '入院诊断编码-5', type: 'input', visible: false, placeholder: '请输入入院诊断编码-5' },
        { prop: 'admissionDiagName5', label: '入院诊断名称-5', type: 'input', visible: false, placeholder: '请输入入院诊断名称-5' },
        { prop: 'admissionDiagCoden', label: '入院诊断编码-N', type: 'input', visible: false, placeholder: '请输入入院诊断编码-N' },
        { prop: 'admissionDiagNamen', label: '入院诊断名称-N', type: 'input', visible: false, placeholder: '请输入入院诊断名称-N' },
        { prop: 'extendData1', label: '扩展字段1', type: 'input', visible: false, placeholder: '请输入扩展字段1' },
        { prop: 'extendData2', label: '扩展字段2', type: 'input', visible: false, placeholder: '请输入扩展字段2' },
        { prop: 'recordStatus', label: '记录状态:1正常 0作废', type: 'number', visible: false, placeholder: '请输入记录状态:1正常 0作废' },
        { prop: 'createdTime', label: '创建时间', type: 'daterange', visible: false, placeholder: '请输入创建时间', startProp: 'createdTimeStart', endProp: 'createdTimeEnd' },
        { prop: 'updatedTime', label: '更新时间', type: 'daterange', visible: false, placeholder: '请输入更新时间', startProp: 'updatedTimeStart', endProp: 'updatedTimeEnd' }
      ]
    }
  ];

  return new SearchConfigManager('natdssB051EmrAdmission', searchFieldGroups);
}


// natdssB061EmrProgressNotes搜索配置
export function createNatdssB061EmrProgressNotesSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '系统自增主键', type: 'number', visible: true, placeholder: '请输入系统自增主键' },
        { prop: 'patientId', label: '患者ID', type: 'input', visible: true, placeholder: '请输入患者ID' },
        { prop: 'medicalRecordNo', label: '病案号', type: 'input', visible: true, placeholder: '请输入病案号' },
        { prop: 'patientNo', label: '住院号', type: 'input', visible: true, placeholder: '请输入住院号' },
        { prop: 'recordTitleCode', label: '病程记录类型代码', type: 'input', visible: true, placeholder: '请输入病程记录类型代码' },
        { prop: 'recordTitle', label: '病程记录类型', type: 'input', visible: false, placeholder: '请输入病程记录类型' },
        { prop: 'recordStatus', label: '记录状态:1正常 0作废', type: 'number', visible: false, placeholder: '请输入记录状态:1正常 0作废' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'visitSn', label: '单次就诊唯一标识号', type: 'input', visible: false, placeholder: '请输入单次就诊唯一标识号' },
        { prop: 'hospitalizationTimes', label: '住院次数', type: 'input', visible: false, placeholder: '请输入住院次数' },
        { prop: 'recordSn', label: '病程记录流水号', type: 'input', visible: false, placeholder: '请输入病程记录流水号' },
        { prop: 'recordDatetime', label: '病程记录时间', type: 'daterange', visible: false, placeholder: '请输入病程记录时间', startProp: 'recordDatetimeStart', endProp: 'recordDatetimeEnd' },
        { prop: 'recordContent', label: '病程记录', type: 'input', visible: false, placeholder: '请输入病程记录' },
        { prop: 'extendData1', label: '扩展字段1', type: 'input', visible: false, placeholder: '请输入扩展字段1' },
        { prop: 'extendData2', label: '扩展字段2', type: 'input', visible: false, placeholder: '请输入扩展字段2' },
        { prop: 'createdTime', label: '创建时间', type: 'daterange', visible: false, placeholder: '请输入创建时间', startProp: 'createdTimeStart', endProp: 'createdTimeEnd' },
        { prop: 'updatedTime', label: '更新时间', type: 'daterange', visible: false, placeholder: '请输入更新时间', startProp: 'updatedTimeStart', endProp: 'updatedTimeEnd' }
      ]
    }
  ];

  return new SearchConfigManager('natdssB061EmrProgressNotes', searchFieldGroups);
}


// natdssB071EmrDischarge搜索配置
export function createNatdssB071EmrDischargeSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '系统自增主键', type: 'number', visible: true, placeholder: '请输入系统自增主键' },
        { prop: 'patientId', label: '患者ID', type: 'input', visible: true, placeholder: '请输入患者ID' },
        { prop: 'medicalRecordNo', label: '病案号', type: 'input', visible: true, placeholder: '请输入病案号' },
        { prop: 'inpatientNo', label: '住院号', type: 'input', visible: true, placeholder: '请输入住院号' },
        { prop: 'admissionMaindiagCode1', label: '入院主要诊断编码', type: 'input', visible: true, placeholder: '请输入入院主要诊断编码' },
        { prop: 'admissionMaindiagName1', label: '入院主要诊断名称', type: 'input', visible: false, placeholder: '请输入入院主要诊断名称' },
        { prop: 'admissionDiagCode2', label: '入院诊断编码-2', type: 'input', visible: false, placeholder: '请输入入院诊断编码-2' },
        { prop: 'admissionDiagName2', label: '入院诊断名称-2', type: 'input', visible: false, placeholder: '请输入入院诊断名称-2' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'visitSn', label: '单次就诊唯一标识号', type: 'input', visible: false, placeholder: '请输入单次就诊唯一标识号' },
        { prop: 'hospitalizationTimes', label: '住院次数', type: 'input', visible: false, placeholder: '请输入住院次数' },
        { prop: 'recordSn', label: '出院记录流水号', type: 'input', visible: false, placeholder: '请输入出院记录流水号' },
        { prop: 'recordDatetime', label: '出院记录创建时间', type: 'daterange', visible: false, placeholder: '请输入出院记录创建时间', startProp: 'recordDatetimeStart', endProp: 'recordDatetimeEnd' },
        { prop: 'admissionDatetime', label: '入院时间', type: 'daterange', visible: false, placeholder: '请输入入院时间', startProp: 'admissionDatetimeStart', endProp: 'admissionDatetimeEnd' },
        { prop: 'dischargeOrder', label: '出院医嘱', type: 'input', visible: false, placeholder: '请输入出院医嘱' },
        { prop: 'dischargeDatetime', label: '出院时间', type: 'daterange', visible: false, placeholder: '请输入出院时间', startProp: 'dischargeDatetimeStart', endProp: 'dischargeDatetimeEnd' },
        { prop: 'lengthOfStay', label: '实际住院天数', type: 'number', visible: false, placeholder: '请输入实际住院天数' },
        { prop: 'kpsScore', label: 'KPS评分', type: 'input', visible: false, placeholder: '请输入KPS评分' },
        { prop: 'ecogScore', label: 'ECOG PS评分', type: 'input', visible: false, placeholder: '请输入ECOG PS评分' },
        { prop: 'recordText', label: '文书内容', type: 'input', visible: false, placeholder: '请输入文书内容' },
        { prop: 'admissionCondition', label: '入院情况', type: 'input', visible: false, placeholder: '请输入入院情况' },
        { prop: 'treatmentInfo', label: '诊疗经过', type: 'input', visible: false, placeholder: '请输入诊疗经过' },
        { prop: 'dischargeCondition', label: '出院情况', type: 'input', visible: false, placeholder: '请输入出院情况' },
        { prop: 'admissionDiagCode3', label: '入院诊断编码-3', type: 'input', visible: false, placeholder: '请输入入院诊断编码-3' },
        { prop: 'admissionDiagName3', label: '入院诊断名称-3', type: 'input', visible: false, placeholder: '请输入入院诊断名称-3' },
        { prop: 'admissionDiagCode4', label: '入院诊断编码-4', type: 'input', visible: false, placeholder: '请输入入院诊断编码-4' },
        { prop: 'admissionDiagName4', label: '入院诊断名称-4', type: 'input', visible: false, placeholder: '请输入入院诊断名称-4' },
        { prop: 'admissionDiagCode5', label: '入院诊断编码-5', type: 'input', visible: false, placeholder: '请输入入院诊断编码-5' },
        { prop: 'admissionDiagName5', label: '入院诊断名称-5', type: 'input', visible: false, placeholder: '请输入入院诊断名称-5' },
        { prop: 'admissionDiagCoden', label: '入院诊断编码-N', type: 'input', visible: false, placeholder: '请输入入院诊断编码-N' },
        { prop: 'admissionDiagNamen', label: '入院诊断名称-N', type: 'input', visible: false, placeholder: '请输入入院诊断名称-N' },
        { prop: 'dischargeMaindiagCode1', label: '出院主要诊断编码', type: 'input', visible: false, placeholder: '请输入出院主要诊断编码' },
        { prop: 'dischargeMaindiagName1', label: '出院主要诊断名称', type: 'input', visible: false, placeholder: '请输入出院主要诊断名称' },
        { prop: 'dischargeDiagCode2', label: '出院诊断编码-2', type: 'input', visible: false, placeholder: '请输入出院诊断编码-2' },
        { prop: 'dischargeDiagName2', label: '出院诊断名称-2', type: 'input', visible: false, placeholder: '请输入出院诊断名称-2' },
        { prop: 'dischargeDiagCode3', label: '出院诊断编码-3', type: 'input', visible: false, placeholder: '请输入出院诊断编码-3' },
        { prop: 'dischargeDiagName3', label: '出院诊断名称-3', type: 'input', visible: false, placeholder: '请输入出院诊断名称-3' },
        { prop: 'dischargeDiagCode4', label: '出院诊断编码-4', type: 'input', visible: false, placeholder: '请输入出院诊断编码-4' },
        { prop: 'dischargeDiagName4', label: '出院诊断名称-4', type: 'input', visible: false, placeholder: '请输入出院诊断名称-4' },
        { prop: 'dischargeDiagCode5', label: '出院诊断编码-5', type: 'input', visible: false, placeholder: '请输入出院诊断编码-5' },
        { prop: 'dischargeDiagName5', label: '出院诊断名称-5', type: 'input', visible: false, placeholder: '请输入出院诊断名称-5' },
        { prop: 'dischargeDiagCoden', label: '出院诊断编码-N', type: 'input', visible: false, placeholder: '请输入出院诊断编码-N' },
        { prop: 'dischargeDiagNamen', label: '出院诊断名称-N', type: 'input', visible: false, placeholder: '请输入出院诊断名称-N' },
        { prop: 'extendData1', label: '扩展字段1', type: 'input', visible: false, placeholder: '请输入扩展字段1' },
        { prop: 'extendData2', label: '扩展字段2', type: 'input', visible: false, placeholder: '请输入扩展字段2' },
        { prop: 'recordStatus', label: '记录状态:1正常 0作废', type: 'number', visible: false, placeholder: '请输入记录状态:1正常 0作废' },
        { prop: 'createdTime', label: '创建时间', type: 'daterange', visible: false, placeholder: '请输入创建时间', startProp: 'createdTimeStart', endProp: 'createdTimeEnd' },
        { prop: 'updatedTime', label: '更新时间', type: 'daterange', visible: false, placeholder: '请输入更新时间', startProp: 'updatedTimeStart', endProp: 'updatedTimeEnd' }
      ]
    }
  ];

  return new SearchConfigManager('natdssB071EmrDischarge', searchFieldGroups);
}


// natdssB081InpatientSurgicalRecord搜索配置
export function createNatdssB081InpatientSurgicalRecordSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '系统自增主键', type: 'number', visible: true, placeholder: '请输入系统自增主键' },
        { prop: 'patientId', label: '患者ID', type: 'input', visible: true, placeholder: '请输入患者ID' },
        { prop: 'medicalRecordNo', label: '病案号', type: 'input', visible: true, placeholder: '请输入病案号' },
        { prop: 'inpatientNo', label: '住院号', type: 'input', visible: true, placeholder: '请输入住院号' },
        { prop: 'surgeonNo', label: '主刀医生代码', type: 'input', visible: true, placeholder: '请输入主刀医生代码' },
        { prop: 'technicalTitle', label: '医师职称名称', type: 'input', visible: false, placeholder: '请输入医师职称名称' },
        { prop: 'jobTitle', label: '医师职务名称', type: 'input', visible: false, placeholder: '请输入医师职务名称' },
        { prop: 'executiveDeptCode', label: '手术执行科室编号', type: 'input', visible: false, placeholder: '请输入手术执行科室编号' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'visitSn', label: '单次就诊唯一标识号', type: 'input', visible: false, placeholder: '请输入单次就诊唯一标识号' },
        { prop: 'hospitalizationTimes', label: '住院次数', type: 'input', visible: false, placeholder: '请输入住院次数' },
        { prop: 'recordSn', label: '手术记录流水号', type: 'input', visible: false, placeholder: '请输入手术记录流水号' },
        { prop: 'recordDatetime', label: '手术记录时间', type: 'daterange', visible: false, placeholder: '请输入手术记录时间', startProp: 'recordDatetimeStart', endProp: 'recordDatetimeEnd' },
        { prop: 'executiveDeptName', label: '手术执行科室名称', type: 'input', visible: false, placeholder: '请输入手术执行科室名称' },
        { prop: 'surgeryCode', label: '手术编码', type: 'input', visible: false, placeholder: '请输入手术编码' },
        { prop: 'surgeryName', label: '手术名称', type: 'input', visible: false, placeholder: '请输入手术名称' },
        { prop: 'startDatetime', label: '手术开始时间', type: 'daterange', visible: false, placeholder: '请输入手术开始时间', startProp: 'startDatetimeStart', endProp: 'startDatetimeEnd' },
        { prop: 'finishDatetime', label: '手术结束时间', type: 'daterange', visible: false, placeholder: '请输入手术结束时间', startProp: 'finishDatetimeStart', endProp: 'finishDatetimeEnd' },
        { prop: 'incisionType', label: '切口类型', type: 'input', visible: false, placeholder: '请输入切口类型' },
        { prop: 'surgeryLevel', label: '手术级别', type: 'input', visible: false, placeholder: '请输入手术级别' },
        { prop: 'surgicalApproach', label: '手术入路', type: 'input', visible: false, placeholder: '请输入手术入路' },
        { prop: 'preventiveAntibioticMark', label: '是否预防性使用抗生素', type: 'input', visible: false, placeholder: '请输入是否预防性使用抗生素' },
        { prop: 'proceduresDescription', label: '手术过程描述', type: 'input', visible: false, placeholder: '请输入手术过程描述' },
        { prop: 'asaSurgeonNo', label: '麻醉医师代码', type: 'input', visible: false, placeholder: '请输入麻醉医师代码' },
        { prop: 'asaTechnicalTitle', label: '麻醉医师职称名称', type: 'input', visible: false, placeholder: '请输入麻醉医师职称名称' },
        { prop: 'asaJobTitle', label: '麻醉医师职务名称', type: 'input', visible: false, placeholder: '请输入麻醉医师职务名称' },
        { prop: 'anesthesiaTypeCode', label: '麻醉方式代码', type: 'input', visible: false, placeholder: '请输入麻醉方式代码' },
        { prop: 'anesthesiaType', label: '麻醉方式', type: 'input', visible: false, placeholder: '请输入麻醉方式' },
        { prop: 'asaPhysicalStatus', label: '麻醉评分', type: 'input', visible: false, placeholder: '请输入麻醉评分' },
        { prop: 'anesthesiaStartTime', label: '麻醉开始时间', type: 'daterange', visible: false, placeholder: '请输入麻醉开始时间', startProp: 'anesthesiaStartTimeStart', endProp: 'anesthesiaStartTimeEnd' },
        { prop: 'anesthesiaEndTime', label: '麻醉结束时间', type: 'daterange', visible: false, placeholder: '请输入麻醉结束时间', startProp: 'anesthesiaEndTimeStart', endProp: 'anesthesiaEndTimeEnd' },
        { prop: 'intakeVolume', label: '总入量', type: 'input', visible: false, placeholder: '请输入总入量' },
        { prop: 'outputVolume', label: '总出量', type: 'input', visible: false, placeholder: '请输入总出量' },
        { prop: 'bloodTransAbo', label: '输血血型-ABO', type: 'input', visible: false, placeholder: '请输入输血血型-ABO' },
        { prop: 'bloodTransRh', label: '输血血型-Rh', type: 'input', visible: false, placeholder: '请输入输血血型-Rh' },
        { prop: 'bloodTransComponentCode', label: '输血成份类型代码', type: 'input', visible: false, placeholder: '请输入输血成份类型代码' },
        { prop: 'bloodTransComponent', label: '输血成份类型', type: 'input', visible: false, placeholder: '请输入输血成份类型' },
        { prop: 'bloodTransVolume', label: '输血量', type: 'input', visible: false, placeholder: '请输入输血量' },
        { prop: 'bloodLossVolume', label: '出血量', type: 'input', visible: false, placeholder: '请输入出血量' },
        { prop: 'urineVolume', label: '尿量', type: 'input', visible: false, placeholder: '请输入尿量' },
        { prop: 'presurgeryMaindiagCode1', label: '术前主要诊断编码', type: 'input', visible: false, placeholder: '请输入术前主要诊断编码' },
        { prop: 'presurgeryMaindiagName1', label: '术前主要诊断名称', type: 'input', visible: false, placeholder: '请输入术前主要诊断名称' },
        { prop: 'presurgeryDiagCode2', label: '术前诊断编码-2', type: 'input', visible: false, placeholder: '请输入术前诊断编码-2' },
        { prop: 'presurgeryDiagName2', label: '术前诊断名称-2', type: 'input', visible: false, placeholder: '请输入术前诊断名称-2' },
        { prop: 'presurgeryDiagCode3', label: '术前诊断编码-3', type: 'input', visible: false, placeholder: '请输入术前诊断编码-3' },
        { prop: 'presurgeryDiagName3', label: '术前诊断名称-3', type: 'input', visible: false, placeholder: '请输入术前诊断名称-3' },
        { prop: 'presurgeryDiagCode4', label: '术前诊断编码-4', type: 'input', visible: false, placeholder: '请输入术前诊断编码-4' },
        { prop: 'presurgeryDiagName4', label: '术前诊断名称-4', type: 'input', visible: false, placeholder: '请输入术前诊断名称-4' },
        { prop: 'presurgeryDiagCode5', label: '术前诊断编码-5', type: 'input', visible: false, placeholder: '请输入术前诊断编码-5' },
        { prop: 'presurgeryDiagName5', label: '术前诊断名称-5', type: 'input', visible: false, placeholder: '请输入术前诊断名称-5' },
        { prop: 'intrasurgeryMaindiagCode1', label: '术中主要诊断编码', type: 'input', visible: false, placeholder: '请输入术中主要诊断编码' },
        { prop: 'intrasurgeryMaindiagName1', label: '术中主要诊断名称', type: 'input', visible: false, placeholder: '请输入术中主要诊断名称' },
        { prop: 'intrasurgeryDiagCode2', label: '术中诊断编码-2', type: 'input', visible: false, placeholder: '请输入术中诊断编码-2' },
        { prop: 'intrasurgeryDiagName2', label: '术中诊断名称-2', type: 'input', visible: false, placeholder: '请输入术中诊断名称-2' },
        { prop: 'intrasurgeryDiagCode3', label: '术中诊断编码-3', type: 'input', visible: false, placeholder: '请输入术中诊断编码-3' },
        { prop: 'intrasurgeryDiagName3', label: '术中诊断名称-3', type: 'input', visible: false, placeholder: '请输入术中诊断名称-3' },
        { prop: 'intrasurgeryDiagCode4', label: '术中诊断编码-4', type: 'input', visible: false, placeholder: '请输入术中诊断编码-4' },
        { prop: 'intrasurgeryDiagName4', label: '术中诊断名称-4', type: 'input', visible: false, placeholder: '请输入术中诊断名称-4' },
        { prop: 'intrasurgeryDiagCode5', label: '术中诊断编码-5', type: 'input', visible: false, placeholder: '请输入术中诊断编码-5' },
        { prop: 'intrasurgeryDiagName5', label: '术中诊断名称-5', type: 'input', visible: false, placeholder: '请输入术中诊断名称-5' },
        { prop: 'postsurgeryMaindiagCode1', label: '术后主要诊断编码', type: 'input', visible: false, placeholder: '请输入术后主要诊断编码' },
        { prop: 'postsurgeryMaindiagName1', label: '术后主要诊断名称', type: 'input', visible: false, placeholder: '请输入术后主要诊断名称' },
        { prop: 'postsurgeryDiagCode2', label: '术后诊断编码-2', type: 'input', visible: false, placeholder: '请输入术后诊断编码-2' },
        { prop: 'postsurgeryDiagName2', label: '术后诊断名称-2', type: 'input', visible: false, placeholder: '请输入术后诊断名称-2' },
        { prop: 'postsurgeryDiagCode3', label: '术后诊断编码-3', type: 'input', visible: false, placeholder: '请输入术后诊断编码-3' },
        { prop: 'postsurgeryDiagName3', label: '术后诊断名称-3', type: 'input', visible: false, placeholder: '请输入术后诊断名称-3' },
        { prop: 'postsurgeryDiagCode4', label: '术后诊断编码-4', type: 'input', visible: false, placeholder: '请输入术后诊断编码-4' },
        { prop: 'postsurgeryDiagName4', label: '术后诊断名称-4', type: 'input', visible: false, placeholder: '请输入术后诊断名称-4' },
        { prop: 'postsurgeryDiagCode5', label: '术后诊断编码-5', type: 'input', visible: false, placeholder: '请输入术后诊断编码-5' },
        { prop: 'postsurgeryDiagName5', label: '术后诊断名称-5', type: 'input', visible: false, placeholder: '请输入术后诊断名称-5' },
        { prop: 'extendData1', label: '扩展字段1', type: 'input', visible: false, placeholder: '请输入扩展字段1' },
        { prop: 'extendData2', label: '扩展字段2', type: 'input', visible: false, placeholder: '请输入扩展字段2' },
        { prop: 'recordStatus', label: '记录状态:1正常 0作废', type: 'number', visible: false, placeholder: '请输入记录状态:1正常 0作废' },
        { prop: 'createdTime', label: '创建时间', type: 'daterange', visible: false, placeholder: '请输入创建时间', startProp: 'createdTimeStart', endProp: 'createdTimeEnd' },
        { prop: 'updatedTime', label: '更新时间', type: 'daterange', visible: false, placeholder: '请输入更新时间', startProp: 'updatedTimeStart', endProp: 'updatedTimeEnd' }
      ]
    }
  ];

  return new SearchConfigManager('natdssB081InpatientSurgicalRecord', searchFieldGroups);
}


// natdssB091InpatientNursingRecord搜索配置
export function createNatdssB091InpatientNursingRecordSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '系统自增主键', type: 'number', visible: true, placeholder: '请输入系统自增主键' },
        { prop: 'patientId', label: '患者ID', type: 'input', visible: true, placeholder: '请输入患者ID' },
        { prop: 'medicalRecordNo', label: '病案号', type: 'input', visible: true, placeholder: '请输入病案号' },
        { prop: 'inpatientNo', label: '住院号', type: 'input', visible: true, placeholder: '请输入住院号' },
        { prop: 'deptCode', label: '科室代码', type: 'input', visible: true, placeholder: '请输入科室代码' },
        { prop: 'deptName', label: '科室名称', type: 'input', visible: false, placeholder: '请输入科室名称' },
        { prop: 'bedNo', label: '床号', type: 'input', visible: false, placeholder: '请输入床号' },
        { prop: 'itemCode', label: '测量项目代码', type: 'input', visible: false, placeholder: '请输入测量项目代码' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'visitSn', label: '单次就诊唯一标识号', type: 'input', visible: false, placeholder: '请输入单次就诊唯一标识号' },
        { prop: 'hospitalizationTimes', label: '住院次数', type: 'input', visible: false, placeholder: '请输入住院次数' },
        { prop: 'recordSn', label: '护理记录流水号', type: 'input', visible: false, placeholder: '请输入护理记录流水号' },
        { prop: 'recordDatetime', label: '护理记录时间', type: 'daterange', visible: false, placeholder: '请输入护理记录时间', startProp: 'recordDatetimeStart', endProp: 'recordDatetimeEnd' },
        { prop: 'testDatetime', label: '护理测量时间', type: 'daterange', visible: false, placeholder: '请输入护理测量时间', startProp: 'testDatetimeStart', endProp: 'testDatetimeEnd' },
        { prop: 'testMethod', label: '测量方式', type: 'input', visible: false, placeholder: '请输入测量方式' },
        { prop: 'itemName', label: '测量项目名称', type: 'input', visible: false, placeholder: '请输入测量项目名称' },
        { prop: 'painScores', label: '疼痛评分', type: 'input', visible: false, placeholder: '请输入疼痛评分' },
        { prop: 'itemResultValue1', label: '测量结果值1', type: 'input', visible: false, placeholder: '请输入测量结果值1' },
        { prop: 'itemResultUnit1', label: '测量结果单位1', type: 'input', visible: false, placeholder: '请输入测量结果单位1' },
        { prop: 'itemResultValue2', label: '测量结果值2', type: 'input', visible: false, placeholder: '请输入测量结果值2' },
        { prop: 'itemResultUnit2', label: '测量结果单位2', type: 'input', visible: false, placeholder: '请输入测量结果单位2' },
        { prop: 'observationMeasures', label: '病情观察及措施', type: 'input', visible: false, placeholder: '请输入病情观察及措施' },
        { prop: 'extendData1', label: '扩展字段1', type: 'input', visible: false, placeholder: '请输入扩展字段1' },
        { prop: 'extendData2', label: '扩展字段2', type: 'input', visible: false, placeholder: '请输入扩展字段2' },
        { prop: 'recordStatus', label: '记录状态:1正常 0作废', type: 'number', visible: false, placeholder: '请输入记录状态:1正常 0作废' },
        { prop: 'createdTime', label: '创建时间', type: 'daterange', visible: false, placeholder: '请输入创建时间', startProp: 'createdTimeStart', endProp: 'createdTimeEnd' },
        { prop: 'updatedTime', label: '更新时间', type: 'daterange', visible: false, placeholder: '请输入更新时间', startProp: 'updatedTimeStart', endProp: 'updatedTimeEnd' }
      ]
    }
  ];

  return new SearchConfigManager('natdssB091InpatientNursingRecord', searchFieldGroups);
}


// natdssB101InpatientOrder搜索配置
export function createNatdssB101InpatientOrderSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '系统自增主键', type: 'number', visible: true, placeholder: '请输入系统自增主键' },
        { prop: 'patientId', label: '患者ID', type: 'input', visible: true, placeholder: '请输入患者ID' },
        { prop: 'medicalRecordNo', label: '病案号', type: 'input', visible: true, placeholder: '请输入病案号' },
        { prop: 'inpatientNo', label: '住院号', type: 'input', visible: true, placeholder: '请输入住院号' },
        { prop: 'requestNo', label: '医技申请单号', type: 'input', visible: true, placeholder: '请输入医技申请单号' },
        { prop: 'orderDeptCode', label: '医嘱下达科室代码', type: 'input', visible: false, placeholder: '请输入医嘱下达科室代码' },
        { prop: 'orderDeptName', label: '医嘱下达科室名称', type: 'input', visible: false, placeholder: '请输入医嘱下达科室名称' },
        { prop: 'orderDoctorNo', label: '医嘱开单医生代码', type: 'input', visible: false, placeholder: '请输入医嘱开单医生代码' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'visitSn', label: '单次就诊唯一标识号', type: 'input', visible: false, placeholder: '请输入单次就诊唯一标识号' },
        { prop: 'hospitalizationTimes', label: '住院次数', type: 'input', visible: false, placeholder: '请输入住院次数' },
        { prop: 'orderSn', label: '医嘱流水号', type: 'input', visible: false, placeholder: '请输入医嘱流水号' },
        { prop: 'orderGivenTime', label: '医嘱下达时间', type: 'daterange', visible: false, placeholder: '请输入医嘱下达时间', startProp: 'orderGivenTimeStart', endProp: 'orderGivenTimeEnd' },
        { prop: 'orderConfirmTime', label: '医嘱确认时间', type: 'daterange', visible: false, placeholder: '请输入医嘱确认时间', startProp: 'orderConfirmTimeStart', endProp: 'orderConfirmTimeEnd' },
        { prop: 'technicalTitle', label: '职称名称', type: 'input', visible: false, placeholder: '请输入职称名称' },
        { prop: 'jobTitle', label: '职务名称', type: 'input', visible: false, placeholder: '请输入职务名称' },
        { prop: 'visitDeptCode', label: '住院科室代码', type: 'input', visible: false, placeholder: '请输入住院科室代码' },
        { prop: 'visitDeptName', label: '住院科室名称', type: 'input', visible: false, placeholder: '请输入住院科室名称' },
        { prop: 'orderStartDatetime', label: '医嘱开始时间', type: 'daterange', visible: false, placeholder: '请输入医嘱开始时间', startProp: 'orderStartDatetimeStart', endProp: 'orderStartDatetimeEnd' },
        { prop: 'orderEndDatetime', label: '医嘱停止时间', type: 'daterange', visible: false, placeholder: '请输入医嘱停止时间', startProp: 'orderEndDatetimeStart', endProp: 'orderEndDatetimeEnd' },
        { prop: 'executiveDeptCode', label: '医嘱执行科室代码', type: 'input', visible: false, placeholder: '请输入医嘱执行科室代码' },
        { prop: 'executiveDeptName', label: '医嘱执行科室名称', type: 'input', visible: false, placeholder: '请输入医嘱执行科室名称' },
        { prop: 'orderType', label: '医嘱类别:长期医嘱、临时医嘱、出院带药', type: 'input', visible: false, placeholder: '请输入医嘱类别:长期医嘱、临时医嘱、出院带药' },
        { prop: 'orderClassCode', label: '医嘱分类代码', type: 'input', visible: false, placeholder: '请输入医嘱分类代码' },
        { prop: 'orderClassName', label: '医嘱分类名称', type: 'input', visible: false, placeholder: '请输入医嘱分类名称' },
        { prop: 'orderItemCode', label: '医嘱项目代码', type: 'input', visible: false, placeholder: '请输入医嘱项目代码' },
        { prop: 'orderItemName', label: '医嘱项目名称', type: 'input', visible: false, placeholder: '请输入医嘱项目名称' },
        { prop: 'orderGroupNo', label: '医嘱组号', type: 'input', visible: false, placeholder: '请输入医嘱组号' },
        { prop: 'dose', label: '单次剂量', type: 'input', visible: false, placeholder: '请输入单次剂量' },
        { prop: 'doseUnit', label: '单次剂量单位', type: 'input', visible: false, placeholder: '请输入单次剂量单位' },
        { prop: 'form', label: '药品剂型', type: 'input', visible: false, placeholder: '请输入药品剂型' },
        { prop: 'spec', label: '规格', type: 'input', visible: false, placeholder: '请输入规格' },
        { prop: 'frequencyCode', label: '使用频率代码', type: 'input', visible: false, placeholder: '请输入使用频率代码' },
        { prop: 'frequencyName', label: '使用频率', type: 'input', visible: false, placeholder: '请输入使用频率' },
        { prop: 'administrationRoute', label: '给药途径', type: 'input', visible: false, placeholder: '请输入给药途径' },
        { prop: 'liquidConfiguration', label: '液体配置', type: 'input', visible: false, placeholder: '请输入液体配置' },
        { prop: 'injectionType', label: '注射方式', type: 'input', visible: false, placeholder: '请输入注射方式' },
        { prop: 'drugOrder', label: '用药顺序', type: 'input', visible: false, placeholder: '请输入用药顺序' },
        { prop: 'drugCompatibility', label: '用药配伍', type: 'input', visible: false, placeholder: '请输入用药配伍' },
        { prop: 'infusionDuration', label: '输液时长', type: 'input', visible: false, placeholder: '请输入输液时长' },
        { prop: 'numOfOrder', label: '医嘱项目数量', type: 'input', visible: false, placeholder: '请输入医嘱项目数量' },
        { prop: 'numOfOrderUnit', label: '医嘱项目数量单位', type: 'input', visible: false, placeholder: '请输入医嘱项目数量单位' },
        { prop: 'herbalNote', label: '草药备注', type: 'input', visible: false, placeholder: '请输入草药备注' },
        { prop: 'orderNote', label: '医嘱备注', type: 'input', visible: false, placeholder: '请输入医嘱备注' },
        { prop: 'drugFlag', label: '是否药品', type: 'input', visible: false, placeholder: '请输入是否药品' },
        { prop: 'manufac', label: '生产厂家', type: 'input', visible: false, placeholder: '请输入生产厂家' },
        { prop: 'tradeName', label: '药品商品名', type: 'input', visible: false, placeholder: '请输入药品商品名' },
        { prop: 'extendData1', label: '扩展字段1', type: 'input', visible: false, placeholder: '请输入扩展字段1' },
        { prop: 'extendData2', label: '扩展字段2', type: 'input', visible: false, placeholder: '请输入扩展字段2' },
        { prop: 'recordStatus', label: '记录状态:1正常 0作废', type: 'number', visible: false, placeholder: '请输入记录状态:1正常 0作废' },
        { prop: 'createdTime', label: '创建时间', type: 'daterange', visible: false, placeholder: '请输入创建时间', startProp: 'createdTimeStart', endProp: 'createdTimeEnd' },
        { prop: 'updatedTime', label: '更新时间', type: 'daterange', visible: false, placeholder: '请输入更新时间', startProp: 'updatedTimeStart', endProp: 'updatedTimeEnd' }
      ]
    }
  ];

  return new SearchConfigManager('natdssB101InpatientOrder', searchFieldGroups);
}


// natdssB111InpatientExpenseRecord搜索配置
export function createNatdssB111InpatientExpenseRecordSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '系统自增主键', type: 'number', visible: true, placeholder: '请输入系统自增主键' },
        { prop: 'patientId', label: '患者ID', type: 'input', visible: true, placeholder: '请输入患者ID' },
        { prop: 'medicalRecordNo', label: '病案号', type: 'input', visible: true, placeholder: '请输入病案号' },
        { prop: 'inpatientNo', label: '住院号', type: 'input', visible: true, placeholder: '请输入住院号' },
        { prop: 'receiptNo', label: '收据号', type: 'input', visible: true, placeholder: '请输入收据号' },
        { prop: 'orderType', label: '医嘱类别:长期医嘱、临时医嘱、出院带药', type: 'input', visible: false, placeholder: '请输入医嘱类别:长期医嘱、临时医嘱、出院带药' },
        { prop: 'transactionTypeCode', label: '交易类别代码', type: 'input', visible: false, placeholder: '请输入交易类别代码' },
        { prop: 'transactionTypeName', label: '交易类别名称', type: 'input', visible: false, placeholder: '请输入交易类别名称' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'visitSn', label: '单次就诊唯一标识号', type: 'input', visible: false, placeholder: '请输入单次就诊唯一标识号' },
        { prop: 'hospitalizationTimes', label: '住院次数', type: 'input', visible: false, placeholder: '请输入住院次数' },
        { prop: 'expenseSn', label: '费用明细流水号', type: 'input', visible: false, placeholder: '请输入费用明细流水号' },
        { prop: 'orderSn', label: '医嘱流水号', type: 'input', visible: false, placeholder: '请输入医嘱流水号' },
        { prop: 'expenseDatetime', label: '收费时间', type: 'daterange', visible: false, placeholder: '请输入收费时间', startProp: 'expenseDatetimeStart', endProp: 'expenseDatetimeEnd' },
        { prop: 'itemTypeCode', label: '收费项目类型代码', type: 'input', visible: false, placeholder: '请输入收费项目类型代码' },
        { prop: 'itemTypeName', label: '收费项目类型名称', type: 'input', visible: false, placeholder: '请输入收费项目类型名称' },
        { prop: 'itemCode', label: '收费项目代码', type: 'input', visible: false, placeholder: '请输入收费项目代码' },
        { prop: 'itemName', label: '收费项目名称', type: 'input', visible: false, placeholder: '请输入收费项目名称' },
        { prop: 'itemUnit', label: '收费项目单位', type: 'input', visible: false, placeholder: '请输入收费项目单位' },
        { prop: 'itemUnitPrice', label: '费用明细项目单价', type: 'number', visible: false, placeholder: '请输入费用明细项目单价' },
        { prop: 'itemAmount', label: '费用明细项目数量', type: 'number', visible: false, placeholder: '请输入费用明细项目数量' },
        { prop: 'itemTotalPrice', label: '收费项目总金额', type: 'number', visible: false, placeholder: '请输入收费项目总金额' },
        { prop: 'extendData1', label: '扩展字段1', type: 'input', visible: false, placeholder: '请输入扩展字段1' },
        { prop: 'extendData2', label: '扩展字段2', type: 'input', visible: false, placeholder: '请输入扩展字段2' },
        { prop: 'recordStatus', label: '记录状态:1正常 0作废', type: 'number', visible: false, placeholder: '请输入记录状态:1正常 0作废' },
        { prop: 'createdTime', label: '创建时间', type: 'daterange', visible: false, placeholder: '请输入创建时间', startProp: 'createdTimeStart', endProp: 'createdTimeEnd' },
        { prop: 'updatedTime', label: '更新时间', type: 'daterange', visible: false, placeholder: '请输入更新时间', startProp: 'updatedTimeStart', endProp: 'updatedTimeEnd' }
      ]
    }
  ];

  return new SearchConfigManager('natdssB111InpatientExpenseRecord', searchFieldGroups);
}


// natdssB121OutpatientInfo搜索配置
export function createNatdssB121OutpatientInfoSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '系统自增主键', type: 'number', visible: true, placeholder: '请输入系统自增主键' },
        { prop: 'patientId', label: '患者ID', type: 'input', visible: true, placeholder: '请输入患者ID' },
        { prop: 'visitType', label: '就诊类型:门诊、急诊', type: 'input', visible: true, placeholder: '请输入就诊类型:门诊、急诊' },
        { prop: 'visitCardNo', label: '就诊卡号', type: 'input', visible: true, placeholder: '请输入就诊卡号' },
        { prop: 'outpatientNo', label: '门诊号', type: 'input', visible: true, placeholder: '请输入门诊号' },
        { prop: 'name', label: '患者姓名', type: 'input', visible: false, placeholder: '请输入患者姓名' },
        { prop: 'regisMethodCode', label: '挂号渠道代码', type: 'input', visible: false, placeholder: '请输入挂号渠道代码' },
        { prop: 'regisTypeCode', label: '挂号类型代码', type: 'input', visible: false, placeholder: '请输入挂号类型代码' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'visitSn', label: '单次就诊唯一标识号', type: 'input', visible: false, placeholder: '请输入单次就诊唯一标识号' },
        { prop: 'visitTimes', label: '就诊次数', type: 'number', visible: false, placeholder: '请输入就诊次数' },
        { prop: 'regisSn', label: '挂号流水号', type: 'input', visible: false, placeholder: '请输入挂号流水号' },
        { prop: 'regisDatetime', label: '挂号时间', type: 'daterange', visible: false, placeholder: '请输入挂号时间', startProp: 'regisDatetimeStart', endProp: 'regisDatetimeEnd' },
        { prop: 'visitDatetime', label: '就诊时间', type: 'daterange', visible: false, placeholder: '请输入就诊时间', startProp: 'visitDatetimeStart', endProp: 'visitDatetimeEnd' },
        { prop: 'firstVisitMark', label: '是否初诊', type: 'input', visible: false, placeholder: '请输入是否初诊' },
        { prop: 'regisMethod', label: '挂号渠道名称', type: 'input', visible: false, placeholder: '请输入挂号渠道名称' },
        { prop: 'regisType', label: '挂号类型', type: 'input', visible: false, placeholder: '请输入挂号类型' },
        { prop: 'regisChargePrice', label: '挂号金额', type: 'number', visible: false, placeholder: '请输入挂号金额' },
        { prop: 'regisPaidPrice', label: '实付金额', type: 'number', visible: false, placeholder: '请输入实付金额' },
        { prop: 'regisDeptCode', label: '挂号科室代码', type: 'input', visible: false, placeholder: '请输入挂号科室代码' },
        { prop: 'regisDeptName', label: '挂号科室名称', type: 'input', visible: false, placeholder: '请输入挂号科室名称' },
        { prop: 'visitDoctorNo', label: '就诊医生代码', type: 'input', visible: false, placeholder: '请输入就诊医生代码' },
        { prop: 'technicalTitle', label: '医师职称名称', type: 'input', visible: false, placeholder: '请输入医师职称名称' },
        { prop: 'jobTitle', label: '医师职务名称', type: 'input', visible: false, placeholder: '请输入医师职务名称' },
        { prop: 'extendData1', label: '扩展字段1', type: 'input', visible: false, placeholder: '请输入扩展字段1' },
        { prop: 'extendData2', label: '扩展字段2', type: 'input', visible: false, placeholder: '请输入扩展字段2' },
        { prop: 'recordStatus', label: '记录状态:1正常 0作废', type: 'number', visible: false, placeholder: '请输入记录状态:1正常 0作废' },
        { prop: 'createdTime', label: '创建时间', type: 'daterange', visible: false, placeholder: '请输入创建时间', startProp: 'createdTimeStart', endProp: 'createdTimeEnd' },
        { prop: 'updatedTime', label: '更新时间', type: 'daterange', visible: false, placeholder: '请输入更新时间', startProp: 'updatedTimeStart', endProp: 'updatedTimeEnd' }
      ]
    }
  ];

  return new SearchConfigManager('natdssB121OutpatientInfo', searchFieldGroups);
}


// natdssB131OutpatientDiagAndMedrecord搜索配置
export function createNatdssB131OutpatientDiagAndMedrecordSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '系统自增主键', type: 'number', visible: true, placeholder: '请输入系统自增主键' },
        { prop: 'patientId', label: '患者ID', type: 'input', visible: true, placeholder: '请输入患者ID' },
        { prop: 'visitType', label: '就诊类型:门诊、急诊', type: 'input', visible: true, placeholder: '请输入就诊类型:门诊、急诊' },
        { prop: 'visitCardNo', label: '就诊卡号', type: 'input', visible: true, placeholder: '请输入就诊卡号' },
        { prop: 'outpatientNo', label: '门诊号', type: 'input', visible: true, placeholder: '请输入门诊号' },
        { prop: 'tcmDiseaseName', label: '中医病名', type: 'input', visible: false, placeholder: '请输入中医病名' },
        { prop: 'tcmSyndromeName', label: '中医证候', type: 'input', visible: false, placeholder: '请输入中医证候' },
        { prop: 'diagnoseDatetime', label: '诊断时间', type: 'daterange', visible: false, placeholder: '请输入诊断时间', startProp: 'diagnoseDatetimeStart', endProp: 'diagnoseDatetimeEnd' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'visitSn', label: '单次就诊唯一标识号', type: 'input', visible: false, placeholder: '请输入单次就诊唯一标识号' },
        { prop: 'visitTimes', label: '就诊次数', type: 'number', visible: false, placeholder: '请输入就诊次数' },
        { prop: 'visitDatetime', label: '就诊时间', type: 'daterange', visible: false, placeholder: '请输入就诊时间', startProp: 'visitDatetimeStart', endProp: 'visitDatetimeEnd' },
        { prop: 'recordSn', label: '病历记录流水号', type: 'input', visible: false, placeholder: '请输入病历记录流水号' },
        { prop: 'recordDatetime', label: '病历记录时间', type: 'daterange', visible: false, placeholder: '请输入病历记录时间', startProp: 'recordDatetimeStart', endProp: 'recordDatetimeEnd' },
        { prop: 'recordText', label: '病历文书内容', type: 'input', visible: false, placeholder: '请输入病历文书内容' },
        { prop: 'treatmentInfo', label: '诊疗经过', type: 'input', visible: false, placeholder: '请输入诊疗经过' },
        { prop: 'operationInfo', label: '操作记录', type: 'input', visible: false, placeholder: '请输入操作记录' },
        { prop: 'chiefComplaint', label: '主诉', type: 'input', visible: false, placeholder: '请输入主诉' },
        { prop: 'currentMedhistory', label: '现病史', type: 'input', visible: false, placeholder: '请输入现病史' },
        { prop: 'pastMedhistory', label: '既往史', type: 'input', visible: false, placeholder: '请输入既往史' },
        { prop: 'personalMedhistory', label: '个人史', type: 'input', visible: false, placeholder: '请输入个人史' },
        { prop: 'familyHistory', label: '家族史', type: 'input', visible: false, placeholder: '请输入家族史' },
        { prop: 'marriageBirthHistory', label: '婚育史', type: 'input', visible: false, placeholder: '请输入婚育史' },
        { prop: 'menstrualHistory', label: '月经史', type: 'input', visible: false, placeholder: '请输入月经史' },
        { prop: 'physicalExam', label: '体格检查', type: 'input', visible: false, placeholder: '请输入体格检查' },
        { prop: 'maindiagCode1', label: '主要诊断编码', type: 'input', visible: false, placeholder: '请输入主要诊断编码' },
        { prop: 'maindiagName1', label: '主要诊断名称', type: 'input', visible: false, placeholder: '请输入主要诊断名称' },
        { prop: 'diagCode2', label: '诊断编码-2', type: 'input', visible: false, placeholder: '请输入诊断编码-2' },
        { prop: 'diagName2', label: '诊断名称-2', type: 'input', visible: false, placeholder: '请输入诊断名称-2' },
        { prop: 'diagCode3', label: '诊断编码-3', type: 'input', visible: false, placeholder: '请输入诊断编码-3' },
        { prop: 'diagName3', label: '诊断名称-3', type: 'input', visible: false, placeholder: '请输入诊断名称-3' },
        { prop: 'diagCode4', label: '诊断编码-4', type: 'input', visible: false, placeholder: '请输入诊断编码-4' },
        { prop: 'diagName4', label: '诊断名称-4', type: 'input', visible: false, placeholder: '请输入诊断名称-4' },
        { prop: 'diagCode5', label: '诊断编码-5', type: 'input', visible: false, placeholder: '请输入诊断编码-5' },
        { prop: 'diagName5', label: '诊断名称-5', type: 'input', visible: false, placeholder: '请输入诊断名称-5' },
        { prop: 'diagCode6', label: '诊断编码-6', type: 'input', visible: false, placeholder: '请输入诊断编码-6' },
        { prop: 'diagName6', label: '诊断名称-6', type: 'input', visible: false, placeholder: '请输入诊断名称-6' },
        { prop: 'diagCode7', label: '诊断编码-7', type: 'input', visible: false, placeholder: '请输入诊断编码-7' },
        { prop: 'diagName7', label: '诊断名称-7', type: 'input', visible: false, placeholder: '请输入诊断名称-7' },
        { prop: 'diagCode8', label: '诊断编码-8', type: 'input', visible: false, placeholder: '请输入诊断编码-8' },
        { prop: 'diagName8', label: '诊断名称-8', type: 'input', visible: false, placeholder: '请输入诊断名称-8' },
        { prop: 'diagCode9', label: '诊断编码-9', type: 'input', visible: false, placeholder: '请输入诊断编码-9' },
        { prop: 'diagName9', label: '诊断名称-9', type: 'input', visible: false, placeholder: '请输入诊断名称-9' },
        { prop: 'diagCode10', label: '诊断编码-10', type: 'input', visible: false, placeholder: '请输入诊断编码-10' },
        { prop: 'diagName10', label: '诊断名称-10', type: 'input', visible: false, placeholder: '请输入诊断名称-10' },
        { prop: 'diagCoden', label: '诊断编码-N', type: 'input', visible: false, placeholder: '请输入诊断编码-N' },
        { prop: 'diagNamen', label: '诊断名称-N', type: 'input', visible: false, placeholder: '请输入诊断名称-N' },
        { prop: 'extendData1', label: '扩展字段1', type: 'input', visible: false, placeholder: '请输入扩展字段1' },
        { prop: 'extendData2', label: '扩展字段2', type: 'input', visible: false, placeholder: '请输入扩展字段2' },
        { prop: 'recordStatus', label: '记录状态:1正常 0作废', type: 'number', visible: false, placeholder: '请输入记录状态:1正常 0作废' },
        { prop: 'createdTime', label: '创建时间', type: 'daterange', visible: false, placeholder: '请输入创建时间', startProp: 'createdTimeStart', endProp: 'createdTimeEnd' },
        { prop: 'updatedTime', label: '更新时间', type: 'daterange', visible: false, placeholder: '请输入更新时间', startProp: 'updatedTimeStart', endProp: 'updatedTimeEnd' }
      ]
    }
  ];

  return new SearchConfigManager('natdssB131OutpatientDiagAndMedrecord', searchFieldGroups);
}


// natdssB141OutpatientOrderAndPres搜索配置
export function createNatdssB141OutpatientOrderAndPresSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '系统自增主键', type: 'number', visible: true, placeholder: '请输入系统自增主键' },
        { prop: 'patientId', label: '患者ID', type: 'input', visible: true, placeholder: '请输入患者ID' },
        { prop: 'visitType', label: '就诊类型:门诊、急诊', type: 'input', visible: true, placeholder: '请输入就诊类型:门诊、急诊' },
        { prop: 'visitCardNo', label: '就诊卡号', type: 'input', visible: true, placeholder: '请输入就诊卡号' },
        { prop: 'outpatientNo', label: '门诊号', type: 'input', visible: true, placeholder: '请输入门诊号' },
        { prop: 'requestNo', label: '医技申请单号', type: 'input', visible: false, placeholder: '请输入医技申请单号' },
        { prop: 'visitDeptCode', label: '就诊科室代码', type: 'input', visible: false, placeholder: '请输入就诊科室代码' },
        { prop: 'visitDeptName', label: '就诊科室名称', type: 'input', visible: false, placeholder: '请输入就诊科室名称' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'visitSn', label: '单次就诊唯一标识号', type: 'input', visible: false, placeholder: '请输入单次就诊唯一标识号' },
        { prop: 'visitTimes', label: '就诊次数', type: 'number', visible: false, placeholder: '请输入就诊次数' },
        { prop: 'orderSn', label: '医嘱流水号', type: 'input', visible: false, placeholder: '请输入医嘱流水号' },
        { prop: 'orderGivenTime', label: '医嘱开具时间', type: 'daterange', visible: false, placeholder: '请输入医嘱开具时间', startProp: 'orderGivenTimeStart', endProp: 'orderGivenTimeEnd' },
        { prop: 'orderDeptCode', label: '医嘱下达科室代码', type: 'input', visible: false, placeholder: '请输入医嘱下达科室代码' },
        { prop: 'orderDeptName', label: '医嘱下达科室名称', type: 'input', visible: false, placeholder: '请输入医嘱下达科室名称' },
        { prop: 'orderDoctorNo', label: '医嘱开单医生代码', type: 'input', visible: false, placeholder: '请输入医嘱开单医生代码' },
        { prop: 'technicalTitle', label: '职称名称', type: 'input', visible: false, placeholder: '请输入职称名称' },
        { prop: 'jobTitle', label: '职务名称', type: 'input', visible: false, placeholder: '请输入职务名称' },
        { prop: 'executiveDeptCode', label: '医嘱执行科室代码', type: 'input', visible: false, placeholder: '请输入医嘱执行科室代码' },
        { prop: 'executiveDeptName', label: '医嘱执行科室名称', type: 'input', visible: false, placeholder: '请输入医嘱执行科室名称' },
        { prop: 'prescriptionClassCode', label: '处方分类代码', type: 'input', visible: false, placeholder: '请输入处方分类代码' },
        { prop: 'prescriptionClassName', label: '处方分类名称', type: 'input', visible: false, placeholder: '请输入处方分类名称' },
        { prop: 'orderClassCode', label: '医嘱分类代码', type: 'input', visible: false, placeholder: '请输入医嘱分类代码' },
        { prop: 'orderClassName', label: '医嘱分类名称', type: 'input', visible: false, placeholder: '请输入医嘱分类名称' },
        { prop: 'orderItemCode', label: '医嘱项目代码', type: 'input', visible: false, placeholder: '请输入医嘱项目代码' },
        { prop: 'orderItemName', label: '医嘱项目名称', type: 'input', visible: false, placeholder: '请输入医嘱项目名称' },
        { prop: 'orderGroupNo', label: '医嘱组号', type: 'input', visible: false, placeholder: '请输入医嘱组号' },
        { prop: 'dose', label: '单次剂量', type: 'number', visible: false, placeholder: '请输入单次剂量' },
        { prop: 'doseUnit', label: '剂量单位', type: 'input', visible: false, placeholder: '请输入剂量单位' },
        { prop: 'form', label: '药品剂型', type: 'input', visible: false, placeholder: '请输入药品剂型' },
        { prop: 'spec', label: '规格', type: 'input', visible: false, placeholder: '请输入规格' },
        { prop: 'frequencyCode', label: '使用频率代码', type: 'input', visible: false, placeholder: '请输入使用频率代码' },
        { prop: 'frequency', label: '使用频率', type: 'input', visible: false, placeholder: '请输入使用频率' },
        { prop: 'administrationRoute', label: '给药途径', type: 'input', visible: false, placeholder: '请输入给药途径' },
        { prop: 'liquidConfiguration', label: '液体配置', type: 'input', visible: false, placeholder: '请输入液体配置' },
        { prop: 'injectionType', label: '注射方式', type: 'input', visible: false, placeholder: '请输入注射方式' },
        { prop: 'drugOrder', label: '用药顺序', type: 'input', visible: false, placeholder: '请输入用药顺序' },
        { prop: 'drugCompatibility', label: '用药配伍', type: 'input', visible: false, placeholder: '请输入用药配伍' },
        { prop: 'infusionDuration', label: '输液时长', type: 'input', visible: false, placeholder: '请输入输液时长' },
        { prop: 'daysOfMedication', label: '使用天数', type: 'number', visible: false, placeholder: '请输入使用天数' },
        { prop: 'totalDose', label: '药品使用总剂量', type: 'number', visible: false, placeholder: '请输入药品使用总剂量' },
        { prop: 'totalDoseUnit', label: '总量单位', type: 'input', visible: false, placeholder: '请输入总量单位' },
        { prop: 'numOfOrders', label: '医嘱数量', type: 'input', visible: false, placeholder: '请输入医嘱数量' },
        { prop: 'numOfOrdersUnit', label: '医嘱数量单位', type: 'input', visible: false, placeholder: '请输入医嘱数量单位' },
        { prop: 'orderNote', label: '医嘱备注', type: 'input', visible: false, placeholder: '请输入医嘱备注' },
        { prop: 'herbalNote', label: '草药备注', type: 'input', visible: false, placeholder: '请输入草药备注' },
        { prop: 'drugFlag', label: '是否药品', type: 'input', visible: false, placeholder: '请输入是否药品' },
        { prop: 'manufac', label: '生产厂家', type: 'input', visible: false, placeholder: '请输入生产厂家' },
        { prop: 'tradeName', label: '药品商品名', type: 'input', visible: false, placeholder: '请输入药品商品名' },
        { prop: 'extendData1', label: '扩展字段1', type: 'input', visible: false, placeholder: '请输入扩展字段1' },
        { prop: 'extendData2', label: '扩展字段2', type: 'input', visible: false, placeholder: '请输入扩展字段2' },
        { prop: 'recordStatus', label: '记录状态:1正常 0作废', type: 'number', visible: false, placeholder: '请输入记录状态:1正常 0作废' },
        { prop: 'createdTime', label: '创建时间', type: 'daterange', visible: false, placeholder: '请输入创建时间', startProp: 'createdTimeStart', endProp: 'createdTimeEnd' },
        { prop: 'updatedTime', label: '更新时间', type: 'daterange', visible: false, placeholder: '请输入更新时间', startProp: 'updatedTimeStart', endProp: 'updatedTimeEnd' }
      ]
    }
  ];

  return new SearchConfigManager('natdssB141OutpatientOrderAndPres', searchFieldGroups);
}


// natdssB151OutpatientExpenseRecord搜索配置
export function createNatdssB151OutpatientExpenseRecordSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '系统自增主键', type: 'number', visible: true, placeholder: '请输入系统自增主键' },
        { prop: 'patientId', label: '患者ID', type: 'input', visible: true, placeholder: '请输入患者ID' },
        { prop: 'visitType', label: '就诊类型:门诊、急诊', type: 'input', visible: true, placeholder: '请输入就诊类型:门诊、急诊' },
        { prop: 'visitCardNo', label: '就诊卡号', type: 'input', visible: true, placeholder: '请输入就诊卡号' },
        { prop: 'outpatientNo', label: '门诊号', type: 'input', visible: true, placeholder: '请输入门诊号' },
        { prop: 'receiptNo', label: '收据号', type: 'input', visible: false, placeholder: '请输入收据号' },
        { prop: 'transactionTypeCode', label: '交易类别代码', type: 'input', visible: false, placeholder: '请输入交易类别代码' },
        { prop: 'transactionTypeName', label: '交易类别名称', type: 'input', visible: false, placeholder: '请输入交易类别名称' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'visitSn', label: '单次就诊唯一标识号', type: 'input', visible: false, placeholder: '请输入单次就诊唯一标识号' },
        { prop: 'visitTimes', label: '就诊次数', type: 'number', visible: false, placeholder: '请输入就诊次数' },
        { prop: 'expenseSn', label: '收费记录明细流水号', type: 'input', visible: false, placeholder: '请输入收费记录明细流水号' },
        { prop: 'orderSn', label: '医嘱流水号', type: 'input', visible: false, placeholder: '请输入医嘱流水号' },
        { prop: 'expenseDatetime', label: '收费时间', type: 'daterange', visible: false, placeholder: '请输入收费时间', startProp: 'expenseDatetimeStart', endProp: 'expenseDatetimeEnd' },
        { prop: 'itemTypeCode', label: '收费项目类型代码', type: 'input', visible: false, placeholder: '请输入收费项目类型代码' },
        { prop: 'itemTypeName', label: '收费项目类型名称', type: 'input', visible: false, placeholder: '请输入收费项目类型名称' },
        { prop: 'itemCode', label: '收费项目代码', type: 'input', visible: false, placeholder: '请输入收费项目代码' },
        { prop: 'itemName', label: '收费项目名称', type: 'input', visible: false, placeholder: '请输入收费项目名称' },
        { prop: 'itemUnit', label: '收费项目单位', type: 'input', visible: false, placeholder: '请输入收费项目单位' },
        { prop: 'itemUnitPrice', label: '费用明细项目单价', type: 'number', visible: false, placeholder: '请输入费用明细项目单价' },
        { prop: 'itemAmount', label: '费用明细项目数量', type: 'number', visible: false, placeholder: '请输入费用明细项目数量' },
        { prop: 'itemTotalPrice', label: '费用明细项目金额', type: 'number', visible: false, placeholder: '请输入费用明细项目金额' },
        { prop: 'extendData1', label: '扩展字段1', type: 'input', visible: false, placeholder: '请输入扩展字段1' },
        { prop: 'extendData2', label: '扩展字段2', type: 'input', visible: false, placeholder: '请输入扩展字段2' },
        { prop: 'recordStatus', label: '记录状态:1正常 0作废', type: 'number', visible: false, placeholder: '请输入记录状态:1正常 0作废' },
        { prop: 'createdTime', label: '创建时间', type: 'daterange', visible: false, placeholder: '请输入创建时间', startProp: 'createdTimeStart', endProp: 'createdTimeEnd' },
        { prop: 'updatedTime', label: '更新时间', type: 'daterange', visible: false, placeholder: '请输入更新时间', startProp: 'updatedTimeStart', endProp: 'updatedTimeEnd' }
      ]
    }
  ];

  return new SearchConfigManager('natdssB151OutpatientExpenseRecord', searchFieldGroups);
}


// natdssB161ExamInfo搜索配置
export function createNatdssB161ExamInfoSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '系统自增主键', type: 'number', visible: true, placeholder: '请输入系统自增主键' },
        { prop: 'patientId', label: '患者ID', type: 'input', visible: true, placeholder: '请输入患者ID' },
        { prop: 'visitType', label: '就诊类型:住院、门诊', type: 'input', visible: true, placeholder: '请输入就诊类型:住院、门诊' },
        { prop: 'visitCardNo', label: '就诊卡号', type: 'input', visible: true, placeholder: '请输入就诊卡号' },
        { prop: 'outpatientNo', label: '门诊号', type: 'input', visible: true, placeholder: '请输入门诊号' },
        { prop: 'medicalRecordNo', label: '病案号', type: 'input', visible: false, placeholder: '请输入病案号' },
        { prop: 'inpatientNo', label: '住院号', type: 'input', visible: false, placeholder: '请输入住院号' },
        { prop: 'name', label: '患者姓名', type: 'input', visible: false, placeholder: '请输入患者姓名' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'visitSn', label: '单次就诊唯一标识号', type: 'input', visible: false, placeholder: '请输入单次就诊唯一标识号' },
        { prop: 'visitTimes', label: '就诊次数', type: 'number', visible: false, placeholder: '请输入就诊次数' },
        { prop: 'hospitalizationTimes', label: '住院次数', type: 'input', visible: false, placeholder: '请输入住院次数' },
        { prop: 'applyNo', label: '申请单号', type: 'input', visible: false, placeholder: '请输入申请单号' },
        { prop: 'orderSn', label: '申请医嘱流水号', type: 'input', visible: false, placeholder: '请输入申请医嘱流水号' },
        { prop: 'applyDatetime', label: '申请时间', type: 'daterange', visible: false, placeholder: '请输入申请时间', startProp: 'applyDatetimeStart', endProp: 'applyDatetimeEnd' },
        { prop: 'applyDeptCode', label: '申请科室代码', type: 'input', visible: false, placeholder: '请输入申请科室代码' },
        { prop: 'applyDeptName', label: '申请科室名称', type: 'input', visible: false, placeholder: '请输入申请科室名称' },
        { prop: 'examSn', label: '检查流水号', type: 'input', visible: false, placeholder: '请输入检查流水号' },
        { prop: 'examDatetime', label: '检查时间', type: 'daterange', visible: false, placeholder: '请输入检查时间', startProp: 'examDatetimeStart', endProp: 'examDatetimeEnd' },
        { prop: 'examType', label: '检查类型:心电超声放射', type: 'input', visible: false, placeholder: '请输入检查类型:心电超声放射' },
        { prop: 'examItemType', label: '检查项目类型', type: 'input', visible: false, placeholder: '请输入检查项目类型' },
        { prop: 'examItemCode', label: '检查项目代码', type: 'input', visible: false, placeholder: '请输入检查项目代码' },
        { prop: 'examItemName', label: '检查项目名称', type: 'input', visible: false, placeholder: '请输入检查项目名称' },
        { prop: 'examSites', label: '检查部位', type: 'input', visible: false, placeholder: '请输入检查部位' },
        { prop: 'reportNo', label: '报告单号', type: 'input', visible: false, placeholder: '请输入报告单号' },
        { prop: 'reportDatetime', label: '报告时间', type: 'daterange', visible: false, placeholder: '请输入报告时间', startProp: 'reportDatetimeStart', endProp: 'reportDatetimeEnd' },
        { prop: 'reportDeptCode', label: '报告科室代码', type: 'input', visible: false, placeholder: '请输入报告科室代码' },
        { prop: 'reportDeptName', label: '报告科室名称', type: 'input', visible: false, placeholder: '请输入报告科室名称' },
        { prop: 'examDiagDescription', label: '检查所见', type: 'input', visible: false, placeholder: '请输入检查所见' },
        { prop: 'examDiagConclusion', label: '检查结论', type: 'input', visible: false, placeholder: '请输入检查结论' },
        { prop: 'extendData1', label: '扩展字段1', type: 'input', visible: false, placeholder: '请输入扩展字段1' },
        { prop: 'extendData2', label: '扩展字段2', type: 'input', visible: false, placeholder: '请输入扩展字段2' },
        { prop: 'recordStatus', label: '记录状态:1正常 0作废', type: 'number', visible: false, placeholder: '请输入记录状态:1正常 0作废' },
        { prop: 'createdTime', label: '创建时间', type: 'daterange', visible: false, placeholder: '请输入创建时间', startProp: 'createdTimeStart', endProp: 'createdTimeEnd' },
        { prop: 'updatedTime', label: '更新时间', type: 'daterange', visible: false, placeholder: '请输入更新时间', startProp: 'updatedTimeStart', endProp: 'updatedTimeEnd' }
      ]
    }
  ];

  return new SearchConfigManager('natdssB161ExamInfo', searchFieldGroups);
}


// natdssB171LabInfo搜索配置
export function createNatdssB171LabInfoSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '系统自增主键', type: 'number', visible: true, placeholder: '请输入系统自增主键' },
        { prop: 'patientId', label: '患者ID', type: 'input', visible: true, placeholder: '请输入患者ID' },
        { prop: 'visitType', label: '就诊类型:住院、门诊', type: 'input', visible: true, placeholder: '请输入就诊类型:住院、门诊' },
        { prop: 'visitCardNo', label: '就诊卡号', type: 'input', visible: true, placeholder: '请输入就诊卡号' },
        { prop: 'outpatientNo', label: '门诊号', type: 'input', visible: true, placeholder: '请输入门诊号' },
        { prop: 'medicalRecordNo', label: '病案号', type: 'input', visible: false, placeholder: '请输入病案号' },
        { prop: 'inpatientNo', label: '住院号', type: 'input', visible: false, placeholder: '请输入住院号' },
        { prop: 'name', label: '患者姓名', type: 'input', visible: false, placeholder: '请输入患者姓名' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'visitSn', label: '单次就诊唯一标识号', type: 'input', visible: false, placeholder: '请输入单次就诊唯一标识号' },
        { prop: 'visitTimes', label: '就诊次数', type: 'number', visible: false, placeholder: '请输入就诊次数' },
        { prop: 'hospitalizationTimes', label: '住院次数', type: 'input', visible: false, placeholder: '请输入住院次数' },
        { prop: 'applyNo', label: '申请单号', type: 'input', visible: false, placeholder: '请输入申请单号' },
        { prop: 'orderSn', label: '申请医嘱流水号', type: 'input', visible: false, placeholder: '请输入申请医嘱流水号' },
        { prop: 'applyDatetime', label: '申请时间', type: 'daterange', visible: false, placeholder: '请输入申请时间', startProp: 'applyDatetimeStart', endProp: 'applyDatetimeEnd' },
        { prop: 'specimenTypeCode', label: '标本类型代码', type: 'input', visible: false, placeholder: '请输入标本类型代码' },
        { prop: 'specimenTypeName', label: '标本类型名称', type: 'input', visible: false, placeholder: '请输入标本类型名称' },
        { prop: 'specimenCode', label: '标本编号', type: 'input', visible: false, placeholder: '请输入标本编号' },
        { prop: 'labSn', label: '检验流水号', type: 'input', visible: false, placeholder: '请输入检验流水号' },
        { prop: 'testDatetime', label: '检验时间', type: 'daterange', visible: false, placeholder: '请输入检验时间', startProp: 'testDatetimeStart', endProp: 'testDatetimeEnd' },
        { prop: 'testMethodCode', label: '检验方法代码', type: 'input', visible: false, placeholder: '请输入检验方法代码' },
        { prop: 'testMethod', label: '检验方法', type: 'input', visible: false, placeholder: '请输入检验方法' },
        { prop: 'labType', label: '检验类型', type: 'input', visible: false, placeholder: '请输入检验类型' },
        { prop: 'itemGroupCode', label: '组合项目代码', type: 'input', visible: false, placeholder: '请输入组合项目代码' },
        { prop: 'itemGroupName', label: '组合项目名称', type: 'input', visible: false, placeholder: '请输入组合项目名称' },
        { prop: 'itemCode', label: '明细项目代码', type: 'input', visible: false, placeholder: '请输入明细项目代码' },
        { prop: 'itemName', label: '明细项目名称', type: 'input', visible: false, placeholder: '请输入明细项目名称' },
        { prop: 'itemNo', label: '明细项目序号', type: 'input', visible: false, placeholder: '请输入明细项目序号' },
        { prop: 'resultQuantitative', label: '检验-结果', type: 'input', visible: false, placeholder: '请输入检验-结果' },
        { prop: 'resultQualitative', label: '检验-结果', type: 'input', visible: false, placeholder: '请输入检验-结果' },
        { prop: 'resultUnit', label: '检验-计量单位', type: 'input', visible: false, placeholder: '请输入检验-计量单位' },
        { prop: 'referenceRange', label: '参考值', type: 'input', visible: false, placeholder: '请输入参考值' },
        { prop: 'referenceRangeAlert', label: '参考值提醒', type: 'input', visible: false, placeholder: '请输入参考值提醒' },
        { prop: 'reportNo', label: '报告单号', type: 'input', visible: false, placeholder: '请输入报告单号' },
        { prop: 'reportDatetime', label: '报告时间', type: 'daterange', visible: false, placeholder: '请输入报告时间', startProp: 'reportDatetimeStart', endProp: 'reportDatetimeEnd' },
        { prop: 'extendData1', label: '扩展字段1', type: 'input', visible: false, placeholder: '请输入扩展字段1' },
        { prop: 'extendData2', label: '扩展字段2', type: 'input', visible: false, placeholder: '请输入扩展字段2' },
        { prop: 'recordStatus', label: '记录状态:1正常 0作废', type: 'number', visible: false, placeholder: '请输入记录状态:1正常 0作废' },
        { prop: 'createdTime', label: '创建时间', type: 'daterange', visible: false, placeholder: '请输入创建时间', startProp: 'createdTimeStart', endProp: 'createdTimeEnd' },
        { prop: 'updatedTime', label: '更新时间', type: 'daterange', visible: false, placeholder: '请输入更新时间', startProp: 'updatedTimeStart', endProp: 'updatedTimeEnd' }
      ]
    }
  ];

  return new SearchConfigManager('natdssB171LabInfo', searchFieldGroups);
}


// natdssB181RadInfo搜索配置
export function createNatdssB181RadInfoSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '系统自增主键', type: 'number', visible: true, placeholder: '请输入系统自增主键' },
        { prop: 'patientId', label: '患者ID', type: 'input', visible: true, placeholder: '请输入患者ID' },
        { prop: 'visitType', label: '就诊类型:住院、门诊', type: 'input', visible: true, placeholder: '请输入就诊类型:住院、门诊' },
        { prop: 'visitCardNo', label: '就诊卡号', type: 'input', visible: true, placeholder: '请输入就诊卡号' },
        { prop: 'outpatientNo', label: '门诊号', type: 'input', visible: true, placeholder: '请输入门诊号' },
        { prop: 'medicalRecordNo', label: '病案号', type: 'input', visible: false, placeholder: '请输入病案号' },
        { prop: 'inpatientNo', label: '住院号', type: 'input', visible: false, placeholder: '请输入住院号' },
        { prop: 'name', label: '患者姓名', type: 'input', visible: false, placeholder: '请输入患者姓名' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'visitSn', label: '单次就诊唯一标识号', type: 'input', visible: false, placeholder: '请输入单次就诊唯一标识号' },
        { prop: 'visitTimes', label: '就诊次数', type: 'number', visible: false, placeholder: '请输入就诊次数' },
        { prop: 'hospitalizationTimes', label: '住院次数', type: 'input', visible: false, placeholder: '请输入住院次数' },
        { prop: 'gender', label: '性别', type: 'input', visible: false, placeholder: '请输入性别' },
        { prop: 'age', label: '年龄', type: 'number', visible: false, placeholder: '请输入年龄' },
        { prop: 'dateOfBirth', label: '出生日期', type: 'daterange', visible: false, placeholder: '请输入出生日期', startProp: 'dateOfBirthStart', endProp: 'dateOfBirthEnd' },
        { prop: 'radioSn', label: '放疗流水号', type: 'input', visible: false, placeholder: '请输入放疗流水号' },
        { prop: 'courseSn', label: '疗程号', type: 'input', visible: false, placeholder: '请输入疗程号' },
        { prop: 'radioStartTime', label: '放疗开始日期', type: 'daterange', visible: false, placeholder: '请输入放疗开始日期', startProp: 'radioStartTimeStart', endProp: 'radioStartTimeEnd' },
        { prop: 'radioEndTime', label: '放疗结束日期', type: 'daterange', visible: false, placeholder: '请输入放疗结束日期', startProp: 'radioEndTimeStart', endProp: 'radioEndTimeEnd' },
        { prop: 'radioTech', label: '放疗技术', type: 'input', visible: false, placeholder: '请输入放疗技术' },
        { prop: 'radioSite', label: '放疗部位', type: 'input', visible: false, placeholder: '请输入放疗部位' },
        { prop: 'targetVolume', label: '靶区部位', type: 'input', visible: false, placeholder: '请输入靶区部位' },
        { prop: 'presDays', label: '处方天数', type: 'number', visible: false, placeholder: '请输入处方天数' },
        { prop: 'presTotalDose', label: '处方总剂量', type: 'input', visible: false, placeholder: '请输入处方总剂量' },
        { prop: 'presRadioCount', label: '处方放疗次数', type: 'number', visible: false, placeholder: '请输入处方放疗次数' },
        { prop: 'radioSingleDose', label: '处方分次剂量', type: 'input', visible: false, placeholder: '请输入处方分次剂量' },
        { prop: 'synChemoMark', label: '是否同步化疗', type: 'input', visible: false, placeholder: '请输入是否同步化疗' },
        { prop: 'synChemoScheme', label: '同步化疗方案', type: 'input', visible: false, placeholder: '请输入同步化疗方案' },
        { prop: 'synOtherSchemeMark', label: '是否同步其他药物治疗', type: 'input', visible: false, placeholder: '请输入是否同步其他药物治疗' },
        { prop: 'synOtherScheme', label: '其他同步治疗方案', type: 'input', visible: false, placeholder: '请输入其他同步治疗方案' },
        { prop: 'effectEvalTime', label: '疗效评价日期', type: 'daterange', visible: false, placeholder: '请输入疗效评价日期', startProp: 'effectEvalTimeStart', endProp: 'effectEvalTimeEnd' },
        { prop: 'effectEval', label: '疗效评价', type: 'input', visible: false, placeholder: '请输入疗效评价' },
        { prop: 'adverseDrugReaction', label: '不良反应', type: 'input', visible: false, placeholder: '请输入不良反应' },
        { prop: 'extendData1', label: '扩展字段1', type: 'input', visible: false, placeholder: '请输入扩展字段1' },
        { prop: 'extendData2', label: '扩展字段2', type: 'input', visible: false, placeholder: '请输入扩展字段2' },
        { prop: 'recordStatus', label: '记录状态:1正常 0作废', type: 'number', visible: false, placeholder: '请输入记录状态:1正常 0作废' },
        { prop: 'therapeuticPurposes', label: '治疗目的', type: 'input', visible: false, placeholder: '请输入治疗目的' },
        { prop: 'createdTime', label: '创建时间', type: 'daterange', visible: false, placeholder: '请输入创建时间', startProp: 'createdTimeStart', endProp: 'createdTimeEnd' },
        { prop: 'updatedTime', label: '更新时间', type: 'daterange', visible: false, placeholder: '请输入更新时间', startProp: 'updatedTimeStart', endProp: 'updatedTimeEnd' }
      ]
    }
  ];

  return new SearchConfigManager('natdssB181RadInfo', searchFieldGroups);
}


// natdssB191FollowUp搜索配置
export function createNatdssB191FollowUpSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '系统自增主键', type: 'number', visible: true, placeholder: '请输入系统自增主键' },
        { prop: 'patientId', label: '患者ID', type: 'input', visible: true, placeholder: '请输入患者ID' },
        { prop: 'visitType', label: '就诊类型:住院、门诊', type: 'input', visible: true, placeholder: '请输入就诊类型:住院、门诊' },
        { prop: 'visitCardNo', label: '就诊卡号', type: 'input', visible: true, placeholder: '请输入就诊卡号' },
        { prop: 'outpatientNo', label: '门诊号', type: 'input', visible: true, placeholder: '请输入门诊号' },
        { prop: 'medicalRecordNo', label: '病案号', type: 'input', visible: false, placeholder: '请输入病案号' },
        { prop: 'inpatientNo', label: '住院号', type: 'input', visible: false, placeholder: '请输入住院号' },
        { prop: 'name', label: '姓名', type: 'input', visible: false, placeholder: '请输入姓名' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'visitSn', label: '单次就诊唯一标识号', type: 'input', visible: false, placeholder: '请输入单次就诊唯一标识号' },
        { prop: 'gender', label: '性别', type: 'input', visible: false, placeholder: '请输入性别' },
        { prop: 'age', label: '年龄', type: 'number', visible: false, placeholder: '请输入年龄' },
        { prop: 'dateOfBirth', label: '出生日期', type: 'daterange', visible: false, placeholder: '请输入出生日期', startProp: 'dateOfBirthStart', endProp: 'dateOfBirthEnd' },
        { prop: 'followupSn', label: '随访流水号', type: 'input', visible: false, placeholder: '请输入随访流水号' },
        { prop: 'followupMethod', label: '随访方式', type: 'input', visible: false, placeholder: '请输入随访方式' },
        { prop: 'firstTreatAge', label: '初治年龄', type: 'number', visible: false, placeholder: '请输入初治年龄' },
        { prop: 'firstTreatDatetime', label: '初治日期', type: 'daterange', visible: false, placeholder: '请输入初治日期', startProp: 'firstTreatDatetimeStart', endProp: 'firstTreatDatetimeEnd' },
        { prop: 'followupPeriod', label: '随访周期', type: 'input', visible: false, placeholder: '请输入随访周期' },
        { prop: 'followupDatetime', label: '随访日期', type: 'daterange', visible: false, placeholder: '请输入随访日期', startProp: 'followupDatetimeStart', endProp: 'followupDatetimeEnd' },
        { prop: 'followupStatusCode', label: '随访状态代码', type: 'input', visible: false, placeholder: '请输入随访状态代码' },
        { prop: 'followupStatus', label: '随访状态', type: 'input', visible: false, placeholder: '请输入随访状态' },
        { prop: 'healthStatus', label: '身体状况', type: 'input', visible: false, placeholder: '请输入身体状况' },
        { prop: 'deathDatetime', label: '死亡日期', type: 'daterange', visible: false, placeholder: '请输入死亡日期', startProp: 'deathDatetimeStart', endProp: 'deathDatetimeEnd' },
        { prop: 'causeOfDeath', label: '死亡原因', type: 'input', visible: false, placeholder: '请输入死亡原因' },
        { prop: 'recurDatetime', label: '复发日期', type: 'daterange', visible: false, placeholder: '请输入复发日期', startProp: 'recurDatetimeStart', endProp: 'recurDatetimeEnd' },
        { prop: 'recurDiagCode', label: '复发诊断编码', type: 'input', visible: false, placeholder: '请输入复发诊断编码' },
        { prop: 'recurDiagName', label: '复发诊断名称', type: 'input', visible: false, placeholder: '请输入复发诊断名称' },
        { prop: 'firstRecurMetsDate', label: '首次复发转移日期', type: 'daterange', visible: false, placeholder: '请输入首次复发转移日期', startProp: 'firstRecurMetsDateStart', endProp: 'firstRecurMetsDateEnd' },
        { prop: 'metsDatetime', label: '转移日期', type: 'daterange', visible: false, placeholder: '请输入转移日期', startProp: 'metsDatetimeStart', endProp: 'metsDatetimeEnd' },
        { prop: 'metsSite', label: '转移部位', type: 'input', visible: false, placeholder: '请输入转移部位' },
        { prop: 'metsDiagCode', label: '转移诊断编码', type: 'input', visible: false, placeholder: '请输入转移诊断编码' },
        { prop: 'metsDiagName', label: '转移诊断名称', type: 'input', visible: false, placeholder: '请输入转移诊断名称' },
        { prop: 'mulpriDiagCode', label: '多原发诊断编码', type: 'input', visible: false, placeholder: '请输入多原发诊断编码' },
        { prop: 'mulpriDiagName', label: '多原发诊断名称', type: 'input', visible: false, placeholder: '请输入多原发诊断名称' },
        { prop: 'followupConclusion', label: '随访结论', type: 'input', visible: false, placeholder: '请输入随访结论' },
        { prop: 'certificateType', label: '证件类型', type: 'input', visible: false, placeholder: '请输入证件类型' },
        { prop: 'certificateNo', label: '证件号码', type: 'input', visible: false, placeholder: '请输入证件号码' },
        { prop: 'currentAddress', label: '现住址', type: 'input', visible: false, placeholder: '请输入现住址' },
        { prop: 'phoneNo', label: '联系电话', type: 'input', visible: false, placeholder: '请输入联系电话' },
        { prop: 'phoneNo2', label: '联系电话2', type: 'input', visible: false, placeholder: '请输入联系电话2' },
        { prop: 'email', label: '邮箱', type: 'input', visible: false, placeholder: '请输入邮箱' },
        { prop: 'weixin', label: '微信', type: 'input', visible: false, placeholder: '请输入微信' },
        { prop: 'contactPerson1', label: '紧急联系人1', type: 'input', visible: false, placeholder: '请输入紧急联系人1' },
        { prop: 'contactPhoneNo1', label: '紧急联系人电话1', type: 'input', visible: false, placeholder: '请输入紧急联系人电话1' },
        { prop: 'contactPerson2', label: '紧急联系人2', type: 'input', visible: false, placeholder: '请输入紧急联系人2' },
        { prop: 'contactPhoneNo2', label: '紧急联系人电话2', type: 'input', visible: false, placeholder: '请输入紧急联系人电话2' },
        { prop: 'extendData1', label: '扩展字段1', type: 'input', visible: false, placeholder: '请输入扩展字段1' },
        { prop: 'extendData2', label: '扩展字段2', type: 'input', visible: false, placeholder: '请输入扩展字段2' },
        { prop: 'recordStatus', label: '记录状态:1正常 0作废', type: 'number', visible: false, placeholder: '请输入记录状态:1正常 0作废' },
        { prop: 'adverseReaction', label: '不良反应', type: 'input', visible: false, placeholder: '请输入不良反应' },
        { prop: 'createdTime', label: '创建时间', type: 'daterange', visible: false, placeholder: '请输入创建时间', startProp: 'createdTimeStart', endProp: 'createdTimeEnd' },
        { prop: 'updatedTime', label: '更新时间', type: 'daterange', visible: false, placeholder: '请输入更新时间', startProp: 'updatedTimeStart', endProp: 'updatedTimeEnd' }
      ]
    }
  ];

  return new SearchConfigManager('natdssB191FollowUp', searchFieldGroups);
}
