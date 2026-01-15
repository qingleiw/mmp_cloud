export interface NatdssB17-2LabMicrobiologicalInfoVO {
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
   * 微生物检验流水号
   */
  labSn: string;

  /**
   * 检验时间
   */
  testDatetime: string;

  /**
   * 报告单号
   */
  reportNo: string;

  /**
   * 报告时间
   */
  reportDatetime: string;

  /**
   * 标本编号
   */
  specimenCode: string;

  /**
   * 标本来源
   */
  sampleType: string;

  /**
   * 检验方法代码
   */
  testMethodCode: string;

  /**
   * 检验方法
   */
  testMethod: string;

  /**
   * 培养结果
   */
  cultivationResult: string;

  /**
   * 结果代码
   */
  resultCode: string;

  /**
   * 结果阴阳性
   */
  resultPosNeg: string;

  /**
   * 药敏方法
   */
  sensTestMethod: string;

  /**
   * 耐药机制
   */
  resisMechanism: string;

  /**
   * 检测抗生素编码
   */
  antibioticsCode: string;

  /**
   * 检测抗生素名称
   */
  antibiotics: string;

  /**
   * 抗生素检测结果
   */
  antibioResult: string;

  /**
   * 药敏结果
   */
  sensitivityResult: string;

  /**
   * 结果参考值
   */
  resultReference: string;

  /**
   * 多重耐药名称
   */
  mdroName: string;

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
   * 培养代码
   */
  cultivationCode: string;

  /**
   * 创建时间
   */
  createdTime: string;

  /**
   * 更新时间
   */
  updatedTime: string;

}

export interface NatdssB17-2LabMicrobiologicalInfoForm extends BaseEntity {
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
   * 微生物检验流水号
   */
  labSn?: string;

  /**
   * 检验时间
   */
  testDatetime?: string;

  /**
   * 报告单号
   */
  reportNo?: string;

  /**
   * 报告时间
   */
  reportDatetime?: string;

  /**
   * 标本编号
   */
  specimenCode?: string;

  /**
   * 标本来源
   */
  sampleType?: string;

  /**
   * 检验方法代码
   */
  testMethodCode?: string;

  /**
   * 检验方法
   */
  testMethod?: string;

  /**
   * 培养结果
   */
  cultivationResult?: string;

  /**
   * 结果代码
   */
  resultCode?: string;

  /**
   * 结果阴阳性
   */
  resultPosNeg?: string;

  /**
   * 药敏方法
   */
  sensTestMethod?: string;

  /**
   * 耐药机制
   */
  resisMechanism?: string;

  /**
   * 检测抗生素编码
   */
  antibioticsCode?: string;

  /**
   * 检测抗生素名称
   */
  antibiotics?: string;

  /**
   * 抗生素检测结果
   */
  antibioResult?: string;

  /**
   * 药敏结果
   */
  sensitivityResult?: string;

  /**
   * 结果参考值
   */
  resultReference?: string;

  /**
   * 多重耐药名称
   */
  mdroName?: string;

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
   * 培养代码
   */
  cultivationCode?: string;

  /**
   * 创建时间
   */
  createdTime?: string;

  /**
   * 更新时间
   */
  updatedTime?: string;

}

export interface NatdssB17-2LabMicrobiologicalInfoQuery extends PageQuery {

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
   * 微生物检验流水号
   */
  labSn?: string;

  /**
   * 检验时间
   */
  testDatetime?: string;

  /**
   * 报告单号
   */
  reportNo?: string;

  /**
   * 报告时间
   */
  reportDatetime?: string;

  /**
   * 标本编号
   */
  specimenCode?: string;

  /**
   * 标本来源
   */
  sampleType?: string;

  /**
   * 检验方法代码
   */
  testMethodCode?: string;

  /**
   * 检验方法
   */
  testMethod?: string;

  /**
   * 培养结果
   */
  cultivationResult?: string;

  /**
   * 结果代码
   */
  resultCode?: string;

  /**
   * 结果阴阳性
   */
  resultPosNeg?: string;

  /**
   * 药敏方法
   */
  sensTestMethod?: string;

  /**
   * 耐药机制
   */
  resisMechanism?: string;

  /**
   * 检测抗生素编码
   */
  antibioticsCode?: string;

  /**
   * 检测抗生素名称
   */
  antibiotics?: string;

  /**
   * 抗生素检测结果
   */
  antibioResult?: string;

  /**
   * 药敏结果
   */
  sensitivityResult?: string;

  /**
   * 结果参考值
   */
  resultReference?: string;

  /**
   * 多重耐药名称
   */
  mdroName?: string;

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
   * 培养代码
   */
  cultivationCode?: string;

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



