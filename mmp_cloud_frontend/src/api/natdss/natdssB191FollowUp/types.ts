export interface NatdssB191FollowUpVO {
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
   * 病案号
   */
  medicalRecordNo: string;

  /**
   * 住院号
   */
  inpatientNo: string;

  /**
   * 姓名
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
   * 随访流水号
   */
  followupSn: string;

  /**
   * 随访方式
   */
  followupMethod: string;

  /**
   * 初治年龄
   */
  firstTreatAge: number;

  /**
   * 初治日期
   */
  firstTreatDatetime: string;

  /**
   * 随访周期
   */
  followupPeriod: string;

  /**
   * 随访日期
   */
  followupDatetime: string;

  /**
   * 随访状态代码
   */
  followupStatusCode: string;

  /**
   * 随访状态
   */
  followupStatus: string;

  /**
   * 身体状况
   */
  healthStatus: string;

  /**
   * 死亡日期
   */
  deathDatetime: string;

  /**
   * 死亡原因
   */
  causeOfDeath: string;

  /**
   * 复发日期
   */
  recurDatetime: string;

  /**
   * 复发诊断编码
   */
  recurDiagCode: string;

  /**
   * 复发诊断名称
   */
  recurDiagName: string;

  /**
   * 首次复发转移日期
   */
  firstRecurMetsDate: string;

  /**
   * 转移日期
   */
  metsDatetime: string;

  /**
   * 转移部位
   */
  metsSite: string;

  /**
   * 转移诊断编码
   */
  metsDiagCode: string;

  /**
   * 转移诊断名称
   */
  metsDiagName: string;

  /**
   * 多原发诊断编码
   */
  mulpriDiagCode: string;

  /**
   * 多原发诊断名称
   */
  mulpriDiagName: string;

  /**
   * 随访结论
   */
  followupConclusion: string;

  /**
   * 证件类型
   */
  certificateType: string;

  /**
   * 证件号码
   */
  certificateNo: string;

  /**
   * 现住址
   */
  currentAddress: string;

  /**
   * 联系电话
   */
  phoneNo: string;

  /**
   * 联系电话2
   */
  phoneNo2: string;

  /**
   * 邮箱
   */
  email: string;

  /**
   * 微信
   */
  weixin: string;

  /**
   * 紧急联系人1
   */
  contactPerson1: string;

  /**
   * 紧急联系人电话1
   */
  contactPhoneNo1: string;

  /**
   * 紧急联系人2
   */
  contactPerson2: string;

  /**
   * 紧急联系人电话2
   */
  contactPhoneNo2: string;

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
   * 不良反应
   */
  adverseReaction: string;

  /**
   * 创建时间
   */
  createdTime: string;

  /**
   * 更新时间
   */
  updatedTime: string;

}

export interface NatdssB191FollowUpForm extends BaseEntity {
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
   * 病案号
   */
  medicalRecordNo?: string;

  /**
   * 住院号
   */
  inpatientNo?: string;

  /**
   * 姓名
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
   * 随访流水号
   */
  followupSn?: string;

  /**
   * 随访方式
   */
  followupMethod?: string;

  /**
   * 初治年龄
   */
  firstTreatAge?: number;

  /**
   * 初治日期
   */
  firstTreatDatetime?: string;

  /**
   * 随访周期
   */
  followupPeriod?: string;

  /**
   * 随访日期
   */
  followupDatetime?: string;

  /**
   * 随访状态代码
   */
  followupStatusCode?: string;

  /**
   * 随访状态
   */
  followupStatus?: string;

  /**
   * 身体状况
   */
  healthStatus?: string;

  /**
   * 死亡日期
   */
  deathDatetime?: string;

  /**
   * 死亡原因
   */
  causeOfDeath?: string;

  /**
   * 复发日期
   */
  recurDatetime?: string;

  /**
   * 复发诊断编码
   */
  recurDiagCode?: string;

  /**
   * 复发诊断名称
   */
  recurDiagName?: string;

  /**
   * 首次复发转移日期
   */
  firstRecurMetsDate?: string;

  /**
   * 转移日期
   */
  metsDatetime?: string;

  /**
   * 转移部位
   */
  metsSite?: string;

  /**
   * 转移诊断编码
   */
  metsDiagCode?: string;

  /**
   * 转移诊断名称
   */
  metsDiagName?: string;

  /**
   * 多原发诊断编码
   */
  mulpriDiagCode?: string;

  /**
   * 多原发诊断名称
   */
  mulpriDiagName?: string;

  /**
   * 随访结论
   */
  followupConclusion?: string;

  /**
   * 证件类型
   */
  certificateType?: string;

  /**
   * 证件号码
   */
  certificateNo?: string;

  /**
   * 现住址
   */
  currentAddress?: string;

  /**
   * 联系电话
   */
  phoneNo?: string;

  /**
   * 联系电话2
   */
  phoneNo2?: string;

  /**
   * 邮箱
   */
  email?: string;

  /**
   * 微信
   */
  weixin?: string;

  /**
   * 紧急联系人1
   */
  contactPerson1?: string;

  /**
   * 紧急联系人电话1
   */
  contactPhoneNo1?: string;

  /**
   * 紧急联系人2
   */
  contactPerson2?: string;

  /**
   * 紧急联系人电话2
   */
  contactPhoneNo2?: string;

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
   * 不良反应
   */
  adverseReaction?: string;

  /**
   * 创建时间
   */
  createdTime?: string;

  /**
   * 更新时间
   */
  updatedTime?: string;

}

export interface NatdssB191FollowUpQuery extends PageQuery {

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
   * 病案号
   */
  medicalRecordNo?: string;

  /**
   * 住院号
   */
  inpatientNo?: string;

  /**
   * 姓名
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
   * 随访流水号
   */
  followupSn?: string;

  /**
   * 随访方式
   */
  followupMethod?: string;

  /**
   * 初治年龄
   */
  firstTreatAge?: number;

  /**
   * 初治日期
   */
  firstTreatDatetime?: string;

  /**
   * 随访周期
   */
  followupPeriod?: string;

  /**
   * 随访日期
   */
  followupDatetime?: string;

  /**
   * 随访状态代码
   */
  followupStatusCode?: string;

  /**
   * 随访状态
   */
  followupStatus?: string;

  /**
   * 身体状况
   */
  healthStatus?: string;

  /**
   * 死亡日期
   */
  deathDatetime?: string;

  /**
   * 死亡原因
   */
  causeOfDeath?: string;

  /**
   * 复发日期
   */
  recurDatetime?: string;

  /**
   * 复发诊断编码
   */
  recurDiagCode?: string;

  /**
   * 复发诊断名称
   */
  recurDiagName?: string;

  /**
   * 首次复发转移日期
   */
  firstRecurMetsDate?: string;

  /**
   * 转移日期
   */
  metsDatetime?: string;

  /**
   * 转移部位
   */
  metsSite?: string;

  /**
   * 转移诊断编码
   */
  metsDiagCode?: string;

  /**
   * 转移诊断名称
   */
  metsDiagName?: string;

  /**
   * 多原发诊断编码
   */
  mulpriDiagCode?: string;

  /**
   * 多原发诊断名称
   */
  mulpriDiagName?: string;

  /**
   * 随访结论
   */
  followupConclusion?: string;

  /**
   * 证件类型
   */
  certificateType?: string;

  /**
   * 证件号码
   */
  certificateNo?: string;

  /**
   * 现住址
   */
  currentAddress?: string;

  /**
   * 联系电话
   */
  phoneNo?: string;

  /**
   * 联系电话2
   */
  phoneNo2?: string;

  /**
   * 邮箱
   */
  email?: string;

  /**
   * 微信
   */
  weixin?: string;

  /**
   * 紧急联系人1
   */
  contactPerson1?: string;

  /**
   * 紧急联系人电话1
   */
  contactPhoneNo1?: string;

  /**
   * 紧急联系人2
   */
  contactPerson2?: string;

  /**
   * 紧急联系人电话2
   */
  contactPhoneNo2?: string;

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
   * 不良反应
   */
  adverseReaction?: string;

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



