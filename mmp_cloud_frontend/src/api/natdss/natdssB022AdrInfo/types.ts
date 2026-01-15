export interface NatdssB022AdrInfoVO {
  /**
   * 系统自增主键
   */
  id: string | number;

  /**
   * 患者ID
   */
  patientId: string | number;

  /**
   * 单次就诊唯一标识号
   */
  visitSn: string;

  /**
   * 就诊类型:住院、门诊
   */
  visitType: string;

  /**
   * 就诊卡号
   */
  visitCardNo: string;

  /**
   * 病案号
   */
  medicalRecordNo: string;

  /**
   * 门诊号
   */
  outpatientNo: string;

  /**
   * 就诊次数
   */
  visitTimes: number;

  /**
   * 住院号
   */
  inpatientNo: string;

  /**
   * 住院次数
   */
  hospitalizationTimes: string;

  /**
   * 姓名
   */
  name: string;

  /**
   * 药品不良反应流水号
   */
  adrEventSn: string;

  /**
   * 药品不良反应报告状态
   */
  adrReportStatus: string;

  /**
   * 药品不良反应报告类型
   */
  adrReportType: string;

  /**
   * 报告时间
   */
  adrReportTime: string;

  /**
   * 患者原患疾病
   */
  adrOriginalDisease: string;

  /**
   * 对原患疾病的影响
   */
  adrDiseaseInfluence: string;

  /**
   * 家族药品不良反应
   */
  adrFamilyStatus: string;

  /**
   * 既往药品不良反应
   */
  adrPastStatus: string;

  /**
   * 其他既往信息
   */
  adrPastOther: string;

  /**
   * 药品不良反应事件名称
   */
  adrEventName: string;

  /**
   * 不良事件发生时间
   */
  adrEventTime: string;

  /**
   * 不良事件过程描述
   */
  adrEventContent: string;

  /**
   * 不良反应结果
   */
  adrEventResult: string;

  /**
   * 停药或减药后是否减轻或消失
   */
  adrStopStatus: string;

  /**
   * 再次使用药物后是否出现同样反应
   */
  adrReuseStatus: string;

  /**
   * 怀疑药品批准文号
   */
  suspectDrugApprovalNo: string;

  /**
   * 怀疑药品编码
   */
  suspectDrugCode: string;

  /**
   * 怀疑药品商品名
   */
  suspectDrugTradeName: string;

  /**
   * 怀疑药品通用名
   */
  suspectDrugGenericName: string;

  /**
   * 怀疑药品生产厂商
   */
  suspectDrugManufac: string;

  /**
   * 怀疑药品生产批号
   */
  suspectDrugBatchNo: string;

  /**
   * 怀疑药品用量
   */
  suspectDrugDosage: string;

  /**
   * 怀疑药品给药途径
   */
  suspectDrugMethod: string;

  /**
   * 怀疑药品开始时间
   */
  suspectDrugStartTime: string;

  /**
   * 怀疑药品结束时间
   */
  suspectDrugEndTime: string;

  /**
   * 怀疑药品用药原因
   */
  suspectDrugReason: string;

  /**
   * 合并药品批准文号
   */
  concomitantDrugApprovalNo: string;

  /**
   * 合并药品编码
   */
  concomitantDrugCode: string;

  /**
   * 合并药品商品名
   */
  concomitantDrugTradeName: string;

  /**
   * 合并药品通用名
   */
  concomitantDrugGenericName: string;

  /**
   * 合并药品生产厂商
   */
  concomitantDrugManufac: string;

  /**
   * 合并药品生产批号
   */
  concomitantDrugBatchNo: string;

  /**
   * 合并药品用量
   */
  concomitantDrugDosage: string;

  /**
   * 合并药品给药途径
   */
  concomitantDrugMethod: string;

  /**
   * 合并药品开始时间
   */
  concomitantDrugStartTime: string;

  /**
   * 合并药品结束时间
   */
  concomitantDrugEndTime: string;

  /**
   * 合并药品用药原因
   */
  concomitantDrugReason: string;

  /**
   * 关联性报告人评价
   */
  adrReporterAppraise: string;

  /**
   * 关联性报告单位评价
   */
  adrReportUnitAppraise: string;

  /**
   * 扩展字段1:填写怀疑用药或并用药品
   */
  extendData1: string;

  /**
   * 扩展字段2
   */
  extendData2: string;

  /**
   * 记录状态:1正常 0作废
   */
  recordStatus: number;

  /**
   * 创建时间
   */
  createdTime: string;

  /**
   * 更新时间
   */
  updatedTime: string;

}

export interface NatdssB022AdrInfoForm extends BaseEntity {
  /**
   * 系统自增主键
   */
  id?: string | number;

  /**
   * 患者ID
   */
  patientId?: string | number;

  /**
   * 单次就诊唯一标识号
   */
  visitSn?: string;

  /**
   * 就诊类型:住院、门诊
   */
  visitType?: string;

  /**
   * 就诊卡号
   */
  visitCardNo?: string;

  /**
   * 病案号
   */
  medicalRecordNo?: string;

  /**
   * 门诊号
   */
  outpatientNo?: string;

  /**
   * 就诊次数
   */
  visitTimes?: number;

  /**
   * 住院号
   */
  inpatientNo?: string;

  /**
   * 住院次数
   */
  hospitalizationTimes?: string;

  /**
   * 姓名
   */
  name?: string;

  /**
   * 药品不良反应流水号
   */
  adrEventSn?: string;

  /**
   * 药品不良反应报告状态
   */
  adrReportStatus?: string;

  /**
   * 药品不良反应报告类型
   */
  adrReportType?: string;

  /**
   * 报告时间
   */
  adrReportTime?: string;

  /**
   * 患者原患疾病
   */
  adrOriginalDisease?: string;

  /**
   * 对原患疾病的影响
   */
  adrDiseaseInfluence?: string;

  /**
   * 家族药品不良反应
   */
  adrFamilyStatus?: string;

  /**
   * 既往药品不良反应
   */
  adrPastStatus?: string;

  /**
   * 其他既往信息
   */
  adrPastOther?: string;

  /**
   * 药品不良反应事件名称
   */
  adrEventName?: string;

  /**
   * 不良事件发生时间
   */
  adrEventTime?: string;

  /**
   * 不良事件过程描述
   */
  adrEventContent?: string;

  /**
   * 不良反应结果
   */
  adrEventResult?: string;

  /**
   * 停药或减药后是否减轻或消失
   */
  adrStopStatus?: string;

  /**
   * 再次使用药物后是否出现同样反应
   */
  adrReuseStatus?: string;

  /**
   * 怀疑药品批准文号
   */
  suspectDrugApprovalNo?: string;

  /**
   * 怀疑药品编码
   */
  suspectDrugCode?: string;

  /**
   * 怀疑药品商品名
   */
  suspectDrugTradeName?: string;

  /**
   * 怀疑药品通用名
   */
  suspectDrugGenericName?: string;

  /**
   * 怀疑药品生产厂商
   */
  suspectDrugManufac?: string;

  /**
   * 怀疑药品生产批号
   */
  suspectDrugBatchNo?: string;

  /**
   * 怀疑药品用量
   */
  suspectDrugDosage?: string;

  /**
   * 怀疑药品给药途径
   */
  suspectDrugMethod?: string;

  /**
   * 怀疑药品开始时间
   */
  suspectDrugStartTime?: string;

  /**
   * 怀疑药品结束时间
   */
  suspectDrugEndTime?: string;

  /**
   * 怀疑药品用药原因
   */
  suspectDrugReason?: string;

  /**
   * 合并药品批准文号
   */
  concomitantDrugApprovalNo?: string;

  /**
   * 合并药品编码
   */
  concomitantDrugCode?: string;

  /**
   * 合并药品商品名
   */
  concomitantDrugTradeName?: string;

  /**
   * 合并药品通用名
   */
  concomitantDrugGenericName?: string;

  /**
   * 合并药品生产厂商
   */
  concomitantDrugManufac?: string;

  /**
   * 合并药品生产批号
   */
  concomitantDrugBatchNo?: string;

  /**
   * 合并药品用量
   */
  concomitantDrugDosage?: string;

  /**
   * 合并药品给药途径
   */
  concomitantDrugMethod?: string;

  /**
   * 合并药品开始时间
   */
  concomitantDrugStartTime?: string;

  /**
   * 合并药品结束时间
   */
  concomitantDrugEndTime?: string;

  /**
   * 合并药品用药原因
   */
  concomitantDrugReason?: string;

  /**
   * 关联性报告人评价
   */
  adrReporterAppraise?: string;

  /**
   * 关联性报告单位评价
   */
  adrReportUnitAppraise?: string;

  /**
   * 扩展字段1:填写怀疑用药或并用药品
   */
  extendData1?: string;

  /**
   * 扩展字段2
   */
  extendData2?: string;

  /**
   * 记录状态:1正常 0作废
   */
  recordStatus?: number;

  /**
   * 创建时间
   */
  createdTime?: string;

  /**
   * 更新时间
   */
  updatedTime?: string;

}

export interface NatdssB022AdrInfoQuery extends PageQuery {

  /**
   * 患者ID
   */
  patientId?: string | number;

  /**
   * 单次就诊唯一标识号
   */
  visitSn?: string;

  /**
   * 就诊类型:住院、门诊
   */
  visitType?: string;

  /**
   * 就诊卡号
   */
  visitCardNo?: string;

  /**
   * 病案号
   */
  medicalRecordNo?: string;

  /**
   * 门诊号
   */
  outpatientNo?: string;

  /**
   * 就诊次数
   */
  visitTimes?: number;

  /**
   * 住院号
   */
  inpatientNo?: string;

  /**
   * 住院次数
   */
  hospitalizationTimes?: string;

  /**
   * 姓名
   */
  name?: string;

  /**
   * 药品不良反应流水号
   */
  adrEventSn?: string;

  /**
   * 药品不良反应报告状态
   */
  adrReportStatus?: string;

  /**
   * 药品不良反应报告类型
   */
  adrReportType?: string;

  /**
   * 报告时间
   */
  adrReportTime?: string;

  /**
   * 患者原患疾病
   */
  adrOriginalDisease?: string;

  /**
   * 对原患疾病的影响
   */
  adrDiseaseInfluence?: string;

  /**
   * 家族药品不良反应
   */
  adrFamilyStatus?: string;

  /**
   * 既往药品不良反应
   */
  adrPastStatus?: string;

  /**
   * 其他既往信息
   */
  adrPastOther?: string;

  /**
   * 药品不良反应事件名称
   */
  adrEventName?: string;

  /**
   * 不良事件发生时间
   */
  adrEventTime?: string;

  /**
   * 不良事件过程描述
   */
  adrEventContent?: string;

  /**
   * 不良反应结果
   */
  adrEventResult?: string;

  /**
   * 停药或减药后是否减轻或消失
   */
  adrStopStatus?: string;

  /**
   * 再次使用药物后是否出现同样反应
   */
  adrReuseStatus?: string;

  /**
   * 怀疑药品批准文号
   */
  suspectDrugApprovalNo?: string;

  /**
   * 怀疑药品编码
   */
  suspectDrugCode?: string;

  /**
   * 怀疑药品商品名
   */
  suspectDrugTradeName?: string;

  /**
   * 怀疑药品通用名
   */
  suspectDrugGenericName?: string;

  /**
   * 怀疑药品生产厂商
   */
  suspectDrugManufac?: string;

  /**
   * 怀疑药品生产批号
   */
  suspectDrugBatchNo?: string;

  /**
   * 怀疑药品用量
   */
  suspectDrugDosage?: string;

  /**
   * 怀疑药品给药途径
   */
  suspectDrugMethod?: string;

  /**
   * 怀疑药品开始时间
   */
  suspectDrugStartTime?: string;

  /**
   * 怀疑药品结束时间
   */
  suspectDrugEndTime?: string;

  /**
   * 怀疑药品用药原因
   */
  suspectDrugReason?: string;

  /**
   * 合并药品批准文号
   */
  concomitantDrugApprovalNo?: string;

  /**
   * 合并药品编码
   */
  concomitantDrugCode?: string;

  /**
   * 合并药品商品名
   */
  concomitantDrugTradeName?: string;

  /**
   * 合并药品通用名
   */
  concomitantDrugGenericName?: string;

  /**
   * 合并药品生产厂商
   */
  concomitantDrugManufac?: string;

  /**
   * 合并药品生产批号
   */
  concomitantDrugBatchNo?: string;

  /**
   * 合并药品用量
   */
  concomitantDrugDosage?: string;

  /**
   * 合并药品给药途径
   */
  concomitantDrugMethod?: string;

  /**
   * 合并药品开始时间
   */
  concomitantDrugStartTime?: string;

  /**
   * 合并药品结束时间
   */
  concomitantDrugEndTime?: string;

  /**
   * 合并药品用药原因
   */
  concomitantDrugReason?: string;

  /**
   * 关联性报告人评价
   */
  adrReporterAppraise?: string;

  /**
   * 关联性报告单位评价
   */
  adrReportUnitAppraise?: string;

  /**
   * 扩展字段1:填写怀疑用药或并用药品
   */
  extendData1?: string;

  /**
   * 扩展字段2
   */
  extendData2?: string;

  /**
   * 记录状态:1正常 0作废
   */
  recordStatus?: number;

  /**
   * 创建时间
   */
  createdTime?: string;

  /**
   * 更新时间
   */
  updatedTime?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}



