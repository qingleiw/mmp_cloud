export interface NatdssB171LabInfoVO {
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
   * 门诊号
   */
  outpatientNo: string;

  /**
   * 就诊次数
   */
  visitTimes: number;

  /**
   * 病案号
   */
  medicalRecordNo: string;

  /**
   * 住院号
   */
  inpatientNo: string;

  /**
   * 住院次数
   */
  hospitalizationTimes: string;

  /**
   * 患者姓名
   */
  name: string;

  /**
   * 申请单号
   */
  applyNo: string;

  /**
   * 申请医嘱流水号
   */
  orderSn: string;

  /**
   * 申请时间
   */
  applyDatetime: string;

  /**
   * 标本类型代码
   */
  specimenTypeCode: string;

  /**
   * 标本类型名称
   */
  specimenTypeName: string;

  /**
   * 标本编号
   */
  specimenCode: string;

  /**
   * 检验流水号
   */
  labSn: string;

  /**
   * 检验时间
   */
  testDatetime: string;

  /**
   * 检验方法代码
   */
  testMethodCode: string;

  /**
   * 检验方法
   */
  testMethod: string;

  /**
   * 检验类型
   */
  labType: string;

  /**
   * 组合项目代码
   */
  itemGroupCode: string;

  /**
   * 组合项目名称
   */
  itemGroupName: string;

  /**
   * 明细项目代码
   */
  itemCode: string;

  /**
   * 明细项目名称
   */
  itemName: string;

  /**
   * 明细项目序号
   */
  itemNo: string;

  /**
   * 检验-结果(数值)
   */
  resultQuantitative: string;

  /**
   * 检验-结果(定性)
   */
  resultQualitative: string;

  /**
   * 检验-计量单位
   */
  resultUnit: string;

  /**
   * 参考值
   */
  referenceRange: string;

  /**
   * 参考值提醒
   */
  referenceRangeAlert: string;

  /**
   * 报告单号
   */
  reportNo: string;

  /**
   * 报告时间
   */
  reportDatetime: string;

  /**
   * 扩展字段1
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

export interface NatdssB171LabInfoForm extends BaseEntity {
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
   * 门诊号
   */
  outpatientNo?: string;

  /**
   * 就诊次数
   */
  visitTimes?: number;

  /**
   * 病案号
   */
  medicalRecordNo?: string;

  /**
   * 住院号
   */
  inpatientNo?: string;

  /**
   * 住院次数
   */
  hospitalizationTimes?: string;

  /**
   * 患者姓名
   */
  name?: string;

  /**
   * 申请单号
   */
  applyNo?: string;

  /**
   * 申请医嘱流水号
   */
  orderSn?: string;

  /**
   * 申请时间
   */
  applyDatetime?: string;

  /**
   * 标本类型代码
   */
  specimenTypeCode?: string;

  /**
   * 标本类型名称
   */
  specimenTypeName?: string;

  /**
   * 标本编号
   */
  specimenCode?: string;

  /**
   * 检验流水号
   */
  labSn?: string;

  /**
   * 检验时间
   */
  testDatetime?: string;

  /**
   * 检验方法代码
   */
  testMethodCode?: string;

  /**
   * 检验方法
   */
  testMethod?: string;

  /**
   * 检验类型
   */
  labType?: string;

  /**
   * 组合项目代码
   */
  itemGroupCode?: string;

  /**
   * 组合项目名称
   */
  itemGroupName?: string;

  /**
   * 明细项目代码
   */
  itemCode?: string;

  /**
   * 明细项目名称
   */
  itemName?: string;

  /**
   * 明细项目序号
   */
  itemNo?: string;

  /**
   * 检验-结果(数值)
   */
  resultQuantitative?: string;

  /**
   * 检验-结果(定性)
   */
  resultQualitative?: string;

  /**
   * 检验-计量单位
   */
  resultUnit?: string;

  /**
   * 参考值
   */
  referenceRange?: string;

  /**
   * 参考值提醒
   */
  referenceRangeAlert?: string;

  /**
   * 报告单号
   */
  reportNo?: string;

  /**
   * 报告时间
   */
  reportDatetime?: string;

  /**
   * 扩展字段1
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

export interface NatdssB171LabInfoQuery extends PageQuery {

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
   * 门诊号
   */
  outpatientNo?: string;

  /**
   * 就诊次数
   */
  visitTimes?: number;

  /**
   * 病案号
   */
  medicalRecordNo?: string;

  /**
   * 住院号
   */
  inpatientNo?: string;

  /**
   * 住院次数
   */
  hospitalizationTimes?: string;

  /**
   * 患者姓名
   */
  name?: string;

  /**
   * 申请单号
   */
  applyNo?: string;

  /**
   * 申请医嘱流水号
   */
  orderSn?: string;

  /**
   * 申请时间
   */
  applyDatetime?: string;

  /**
   * 标本类型代码
   */
  specimenTypeCode?: string;

  /**
   * 标本类型名称
   */
  specimenTypeName?: string;

  /**
   * 标本编号
   */
  specimenCode?: string;

  /**
   * 检验流水号
   */
  labSn?: string;

  /**
   * 检验时间
   */
  testDatetime?: string;

  /**
   * 检验方法代码
   */
  testMethodCode?: string;

  /**
   * 检验方法
   */
  testMethod?: string;

  /**
   * 检验类型
   */
  labType?: string;

  /**
   * 组合项目代码
   */
  itemGroupCode?: string;

  /**
   * 组合项目名称
   */
  itemGroupName?: string;

  /**
   * 明细项目代码
   */
  itemCode?: string;

  /**
   * 明细项目名称
   */
  itemName?: string;

  /**
   * 明细项目序号
   */
  itemNo?: string;

  /**
   * 检验-结果(数值)
   */
  resultQuantitative?: string;

  /**
   * 检验-结果(定性)
   */
  resultQualitative?: string;

  /**
   * 检验-计量单位
   */
  resultUnit?: string;

  /**
   * 参考值
   */
  referenceRange?: string;

  /**
   * 参考值提醒
   */
  referenceRangeAlert?: string;

  /**
   * 报告单号
   */
  reportNo?: string;

  /**
   * 报告时间
   */
  reportDatetime?: string;

  /**
   * 扩展字段1
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



