export interface NatdssB181RadInfoVO {
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
   * 性别
   */
  gender: string;

  /**
   * 年龄(岁)
   */
  age: number;

  /**
   * 出生日期
   */
  dateOfBirth: string;

  /**
   * 放疗流水号
   */
  radioSn: string;

  /**
   * 疗程号
   */
  courseSn: string;

  /**
   * 放疗开始日期
   */
  radioStartTime: string;

  /**
   * 放疗结束日期
   */
  radioEndTime: string;

  /**
   * 放疗技术
   */
  radioTech: string;

  /**
   * 放疗部位
   */
  radioSite: string;

  /**
   * 靶区部位
   */
  targetVolume: string;

  /**
   * 处方天数
   */
  presDays: number;

  /**
   * 处方总剂量
   */
  presTotalDose: string;

  /**
   * 处方放疗次数
   */
  presRadioCount: number;

  /**
   * 处方分次剂量
   */
  radioSingleDose: string;

  /**
   * 是否同步化疗
   */
  synChemoMark: string;

  /**
   * 同步化疗方案
   */
  synChemoScheme: string;

  /**
   * 是否同步其他药物治疗
   */
  synOtherSchemeMark: string;

  /**
   * 其他同步治疗方案
   */
  synOtherScheme: string;

  /**
   * 疗效评价日期
   */
  effectEvalTime: string;

  /**
   * 疗效评价
   */
  effectEval: string;

  /**
   * 不良反应
   */
  adverseDrugReaction: string;

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
   * 治疗目的
   */
  therapeuticPurposes: string;

  /**
   * 创建时间
   */
  createdTime: string;

  /**
   * 更新时间
   */
  updatedTime: string;

}

export interface NatdssB181RadInfoForm extends BaseEntity {
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
   * 性别
   */
  gender?: string;

  /**
   * 年龄(岁)
   */
  age?: number;

  /**
   * 出生日期
   */
  dateOfBirth?: string;

  /**
   * 放疗流水号
   */
  radioSn?: string;

  /**
   * 疗程号
   */
  courseSn?: string;

  /**
   * 放疗开始日期
   */
  radioStartTime?: string;

  /**
   * 放疗结束日期
   */
  radioEndTime?: string;

  /**
   * 放疗技术
   */
  radioTech?: string;

  /**
   * 放疗部位
   */
  radioSite?: string;

  /**
   * 靶区部位
   */
  targetVolume?: string;

  /**
   * 处方天数
   */
  presDays?: number;

  /**
   * 处方总剂量
   */
  presTotalDose?: string;

  /**
   * 处方放疗次数
   */
  presRadioCount?: number;

  /**
   * 处方分次剂量
   */
  radioSingleDose?: string;

  /**
   * 是否同步化疗
   */
  synChemoMark?: string;

  /**
   * 同步化疗方案
   */
  synChemoScheme?: string;

  /**
   * 是否同步其他药物治疗
   */
  synOtherSchemeMark?: string;

  /**
   * 其他同步治疗方案
   */
  synOtherScheme?: string;

  /**
   * 疗效评价日期
   */
  effectEvalTime?: string;

  /**
   * 疗效评价
   */
  effectEval?: string;

  /**
   * 不良反应
   */
  adverseDrugReaction?: string;

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
   * 治疗目的
   */
  therapeuticPurposes?: string;

  /**
   * 创建时间
   */
  createdTime?: string;

  /**
   * 更新时间
   */
  updatedTime?: string;

}

export interface NatdssB181RadInfoQuery extends PageQuery {

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
   * 性别
   */
  gender?: string;

  /**
   * 年龄(岁)
   */
  age?: number;

  /**
   * 出生日期
   */
  dateOfBirth?: string;

  /**
   * 放疗流水号
   */
  radioSn?: string;

  /**
   * 疗程号
   */
  courseSn?: string;

  /**
   * 放疗开始日期
   */
  radioStartTime?: string;

  /**
   * 放疗结束日期
   */
  radioEndTime?: string;

  /**
   * 放疗技术
   */
  radioTech?: string;

  /**
   * 放疗部位
   */
  radioSite?: string;

  /**
   * 靶区部位
   */
  targetVolume?: string;

  /**
   * 处方天数
   */
  presDays?: number;

  /**
   * 处方总剂量
   */
  presTotalDose?: string;

  /**
   * 处方放疗次数
   */
  presRadioCount?: number;

  /**
   * 处方分次剂量
   */
  radioSingleDose?: string;

  /**
   * 是否同步化疗
   */
  synChemoMark?: string;

  /**
   * 同步化疗方案
   */
  synChemoScheme?: string;

  /**
   * 是否同步其他药物治疗
   */
  synOtherSchemeMark?: string;

  /**
   * 其他同步治疗方案
   */
  synOtherScheme?: string;

  /**
   * 疗效评价日期
   */
  effectEvalTime?: string;

  /**
   * 疗效评价
   */
  effectEval?: string;

  /**
   * 不良反应
   */
  adverseDrugReaction?: string;

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
   * 治疗目的
   */
  therapeuticPurposes?: string;

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



