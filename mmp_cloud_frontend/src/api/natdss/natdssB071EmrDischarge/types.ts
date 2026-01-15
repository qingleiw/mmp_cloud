export interface NatdssB071EmrDischargeVO {
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
   * 出院记录流水号
   */
  recordSn: string;

  /**
   * 出院记录创建时间
   */
  recordDatetime: string;

  /**
   * 入院时间
   */
  admissionDatetime: string;

  /**
   * 出院医嘱
   */
  dischargeOrder: string;

  /**
   * 出院时间
   */
  dischargeDatetime: string;

  /**
   * 实际住院天数
   */
  lengthOfStay: number;

  /**
   * KPS评分
   */
  kpsScore: string;

  /**
   * ECOG PS评分
   */
  ecogScore: string;

  /**
   * 文书内容
   */
  recordText: string;

  /**
   * 入院情况
   */
  admissionCondition: string;

  /**
   * 诊疗经过
   */
  treatmentInfo: string;

  /**
   * 出院情况
   */
  dischargeCondition: string;

  /**
   * 入院主要诊断编码
   */
  admissionMaindiagCode1: string;

  /**
   * 入院主要诊断名称
   */
  admissionMaindiagName1: string;

  /**
   * 入院诊断编码-2
   */
  admissionDiagCode2: string;

  /**
   * 入院诊断名称-2
   */
  admissionDiagName2: string;

  /**
   * 入院诊断编码-3
   */
  admissionDiagCode3: string;

  /**
   * 入院诊断名称-3
   */
  admissionDiagName3: string;

  /**
   * 入院诊断编码-4
   */
  admissionDiagCode4: string;

  /**
   * 入院诊断名称-4
   */
  admissionDiagName4: string;

  /**
   * 入院诊断编码-5
   */
  admissionDiagCode5: string;

  /**
   * 入院诊断名称-5
   */
  admissionDiagName5: string;

  /**
   * 入院诊断编码-N
   */
  admissionDiagCoden: string;

  /**
   * 入院诊断名称-N
   */
  admissionDiagNamen: string;

  /**
   * 出院主要诊断编码
   */
  dischargeMaindiagCode1: string;

  /**
   * 出院主要诊断名称
   */
  dischargeMaindiagName1: string;

  /**
   * 出院诊断编码-2
   */
  dischargeDiagCode2: string;

  /**
   * 出院诊断名称-2
   */
  dischargeDiagName2: string;

  /**
   * 出院诊断编码-3
   */
  dischargeDiagCode3: string;

  /**
   * 出院诊断名称-3
   */
  dischargeDiagName3: string;

  /**
   * 出院诊断编码-4
   */
  dischargeDiagCode4: string;

  /**
   * 出院诊断名称-4
   */
  dischargeDiagName4: string;

  /**
   * 出院诊断编码-5
   */
  dischargeDiagCode5: string;

  /**
   * 出院诊断名称-5
   */
  dischargeDiagName5: string;

  /**
   * 出院诊断编码-N
   */
  dischargeDiagCoden: string;

  /**
   * 出院诊断名称-N
   */
  dischargeDiagNamen: string;

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

export interface NatdssB071EmrDischargeForm extends BaseEntity {
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
   * 出院记录流水号
   */
  recordSn?: string;

  /**
   * 出院记录创建时间
   */
  recordDatetime?: string;

  /**
   * 入院时间
   */
  admissionDatetime?: string;

  /**
   * 出院医嘱
   */
  dischargeOrder?: string;

  /**
   * 出院时间
   */
  dischargeDatetime?: string;

  /**
   * 实际住院天数
   */
  lengthOfStay?: number;

  /**
   * KPS评分
   */
  kpsScore?: string;

  /**
   * ECOG PS评分
   */
  ecogScore?: string;

  /**
   * 文书内容
   */
  recordText?: string;

  /**
   * 入院情况
   */
  admissionCondition?: string;

  /**
   * 诊疗经过
   */
  treatmentInfo?: string;

  /**
   * 出院情况
   */
  dischargeCondition?: string;

  /**
   * 入院主要诊断编码
   */
  admissionMaindiagCode1?: string;

  /**
   * 入院主要诊断名称
   */
  admissionMaindiagName1?: string;

  /**
   * 入院诊断编码-2
   */
  admissionDiagCode2?: string;

  /**
   * 入院诊断名称-2
   */
  admissionDiagName2?: string;

  /**
   * 入院诊断编码-3
   */
  admissionDiagCode3?: string;

  /**
   * 入院诊断名称-3
   */
  admissionDiagName3?: string;

  /**
   * 入院诊断编码-4
   */
  admissionDiagCode4?: string;

  /**
   * 入院诊断名称-4
   */
  admissionDiagName4?: string;

  /**
   * 入院诊断编码-5
   */
  admissionDiagCode5?: string;

  /**
   * 入院诊断名称-5
   */
  admissionDiagName5?: string;

  /**
   * 入院诊断编码-N
   */
  admissionDiagCoden?: string;

  /**
   * 入院诊断名称-N
   */
  admissionDiagNamen?: string;

  /**
   * 出院主要诊断编码
   */
  dischargeMaindiagCode1?: string;

  /**
   * 出院主要诊断名称
   */
  dischargeMaindiagName1?: string;

  /**
   * 出院诊断编码-2
   */
  dischargeDiagCode2?: string;

  /**
   * 出院诊断名称-2
   */
  dischargeDiagName2?: string;

  /**
   * 出院诊断编码-3
   */
  dischargeDiagCode3?: string;

  /**
   * 出院诊断名称-3
   */
  dischargeDiagName3?: string;

  /**
   * 出院诊断编码-4
   */
  dischargeDiagCode4?: string;

  /**
   * 出院诊断名称-4
   */
  dischargeDiagName4?: string;

  /**
   * 出院诊断编码-5
   */
  dischargeDiagCode5?: string;

  /**
   * 出院诊断名称-5
   */
  dischargeDiagName5?: string;

  /**
   * 出院诊断编码-N
   */
  dischargeDiagCoden?: string;

  /**
   * 出院诊断名称-N
   */
  dischargeDiagNamen?: string;

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

export interface NatdssB071EmrDischargeQuery extends PageQuery {

  /**
   * 患者ID
   */
  patientId?: string | number;

  /**
   * 单次就诊唯一标识号
   */
  visitSn?: string;

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
   * 出院记录流水号
   */
  recordSn?: string;

  /**
   * 出院记录创建时间
   */
  recordDatetime?: string;

  /**
   * 入院时间
   */
  admissionDatetime?: string;

  /**
   * 出院医嘱
   */
  dischargeOrder?: string;

  /**
   * 出院时间
   */
  dischargeDatetime?: string;

  /**
   * 实际住院天数
   */
  lengthOfStay?: number;

  /**
   * KPS评分
   */
  kpsScore?: string;

  /**
   * ECOG PS评分
   */
  ecogScore?: string;

  /**
   * 文书内容
   */
  recordText?: string;

  /**
   * 入院情况
   */
  admissionCondition?: string;

  /**
   * 诊疗经过
   */
  treatmentInfo?: string;

  /**
   * 出院情况
   */
  dischargeCondition?: string;

  /**
   * 入院主要诊断编码
   */
  admissionMaindiagCode1?: string;

  /**
   * 入院主要诊断名称
   */
  admissionMaindiagName1?: string;

  /**
   * 入院诊断编码-2
   */
  admissionDiagCode2?: string;

  /**
   * 入院诊断名称-2
   */
  admissionDiagName2?: string;

  /**
   * 入院诊断编码-3
   */
  admissionDiagCode3?: string;

  /**
   * 入院诊断名称-3
   */
  admissionDiagName3?: string;

  /**
   * 入院诊断编码-4
   */
  admissionDiagCode4?: string;

  /**
   * 入院诊断名称-4
   */
  admissionDiagName4?: string;

  /**
   * 入院诊断编码-5
   */
  admissionDiagCode5?: string;

  /**
   * 入院诊断名称-5
   */
  admissionDiagName5?: string;

  /**
   * 入院诊断编码-N
   */
  admissionDiagCoden?: string;

  /**
   * 入院诊断名称-N
   */
  admissionDiagNamen?: string;

  /**
   * 出院主要诊断编码
   */
  dischargeMaindiagCode1?: string;

  /**
   * 出院主要诊断名称
   */
  dischargeMaindiagName1?: string;

  /**
   * 出院诊断编码-2
   */
  dischargeDiagCode2?: string;

  /**
   * 出院诊断名称-2
   */
  dischargeDiagName2?: string;

  /**
   * 出院诊断编码-3
   */
  dischargeDiagCode3?: string;

  /**
   * 出院诊断名称-3
   */
  dischargeDiagName3?: string;

  /**
   * 出院诊断编码-4
   */
  dischargeDiagCode4?: string;

  /**
   * 出院诊断名称-4
   */
  dischargeDiagName4?: string;

  /**
   * 出院诊断编码-5
   */
  dischargeDiagCode5?: string;

  /**
   * 出院诊断名称-5
   */
  dischargeDiagName5?: string;

  /**
   * 出院诊断编码-N
   */
  dischargeDiagCoden?: string;

  /**
   * 出院诊断名称-N
   */
  dischargeDiagNamen?: string;

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



