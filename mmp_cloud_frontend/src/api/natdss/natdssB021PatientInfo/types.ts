export interface NatdssB021PatientInfoVO {
  /**
   * 系统自增主键
   */
  id: string | number;

  /**
   * 患者ID-患者在本院信息系统内的唯一标识
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
   * 就诊时间
   */
  visitDatetime: string;

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
   * 入院时间
   */
  admissionDatetime: string;

  /**
   * 出院时间
   */
  dischargeDatetime: string;

  /**
   * 就诊医生代码
   */
  visitDoctorNo: string;

  /**
   * 姓名
   */
  name: string;

  /**
   * 性别:男、女、未知
   */
  gender: string;

  /**
   * 出生日期
   */
  dateOfBirth: string;

  /**
   * 职业类别代码
   */
  occupationCode: string;

  /**
   * 职业类别名称
   */
  occupationName: string;

  /**
   * 国籍
   */
  nationality: string;

  /**
   * 民族
   */
  ethnicity: string;

  /**
   * 文化程度
   */
  education: string;

  /**
   * 婚姻状况类别
   */
  maritalStatus: string;

  /**
   * 是否新生儿
   */
  newbronMark: string;

  /**
   * 证件类型
   */
  certificateType: string;

  /**
   * 证件号码
   */
  certificateNo: string;

  /**
   * 健康卡类型
   */
  healthCardType: string;

  /**
   * 健康卡号
   */
  healthCardNo: string;

  /**
   * 医保类型
   */
  insuranceType: string;

  /**
   * 医保卡号
   */
  insuranceNo: string;

  /**
   * 户籍地址-省名称
   */
  residenceProvince: string | number;

  /**
   * 户籍地址-市名称
   */
  residenceCity: string | number;

  /**
   * 户籍地址-县名称
   */
  residenceCounty: string | number;

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
   * ABO血型
   */
  aboBloodType: string;

  /**
   * Rh血型
   */
  rhBloodType: string;

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

export interface NatdssB021PatientInfoForm extends BaseEntity {
  /**
   * 系统自增主键
   */
  id?: string | number;

  /**
   * 患者ID-患者在本院信息系统内的唯一标识
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
   * 就诊时间
   */
  visitDatetime?: string;

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
   * 入院时间
   */
  admissionDatetime?: string;

  /**
   * 出院时间
   */
  dischargeDatetime?: string;

  /**
   * 就诊医生代码
   */
  visitDoctorNo?: string;

  /**
   * 姓名
   */
  name?: string;

  /**
   * 性别:男、女、未知
   */
  gender?: string;

  /**
   * 出生日期
   */
  dateOfBirth?: string;

  /**
   * 职业类别代码
   */
  occupationCode?: string;

  /**
   * 职业类别名称
   */
  occupationName?: string;

  /**
   * 国籍
   */
  nationality?: string;

  /**
   * 民族
   */
  ethnicity?: string;

  /**
   * 文化程度
   */
  education?: string;

  /**
   * 婚姻状况类别
   */
  maritalStatus?: string;

  /**
   * 是否新生儿
   */
  newbronMark?: string;

  /**
   * 证件类型
   */
  certificateType?: string;

  /**
   * 证件号码
   */
  certificateNo?: string;

  /**
   * 健康卡类型
   */
  healthCardType?: string;

  /**
   * 健康卡号
   */
  healthCardNo?: string;

  /**
   * 医保类型
   */
  insuranceType?: string;

  /**
   * 医保卡号
   */
  insuranceNo?: string;

  /**
   * 户籍地址-省名称
   */
  residenceProvince?: string | number;

  /**
   * 户籍地址-市名称
   */
  residenceCity?: string | number;

  /**
   * 户籍地址-县名称
   */
  residenceCounty?: string | number;

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
   * ABO血型
   */
  aboBloodType?: string;

  /**
   * Rh血型
   */
  rhBloodType?: string;

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

export interface NatdssB021PatientInfoQuery extends PageQuery {

  /**
   * 患者ID-患者在本院信息系统内的唯一标识
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
   * 就诊时间
   */
  visitDatetime?: string;

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
   * 入院时间
   */
  admissionDatetime?: string;

  /**
   * 出院时间
   */
  dischargeDatetime?: string;

  /**
   * 就诊医生代码
   */
  visitDoctorNo?: string;

  /**
   * 姓名
   */
  name?: string;

  /**
   * 性别:男、女、未知
   */
  gender?: string;

  /**
   * 出生日期
   */
  dateOfBirth?: string;

  /**
   * 职业类别代码
   */
  occupationCode?: string;

  /**
   * 职业类别名称
   */
  occupationName?: string;

  /**
   * 国籍
   */
  nationality?: string;

  /**
   * 民族
   */
  ethnicity?: string;

  /**
   * 文化程度
   */
  education?: string;

  /**
   * 婚姻状况类别
   */
  maritalStatus?: string;

  /**
   * 是否新生儿
   */
  newbronMark?: string;

  /**
   * 证件类型
   */
  certificateType?: string;

  /**
   * 证件号码
   */
  certificateNo?: string;

  /**
   * 健康卡类型
   */
  healthCardType?: string;

  /**
   * 健康卡号
   */
  healthCardNo?: string;

  /**
   * 医保类型
   */
  insuranceType?: string;

  /**
   * 医保卡号
   */
  insuranceNo?: string;

  /**
   * 户籍地址-省名称
   */
  residenceProvince?: string | number;

  /**
   * 户籍地址-市名称
   */
  residenceCity?: string | number;

  /**
   * 户籍地址-县名称
   */
  residenceCounty?: string | number;

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
   * ABO血型
   */
  aboBloodType?: string;

  /**
   * Rh血型
   */
  rhBloodType?: string;

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



