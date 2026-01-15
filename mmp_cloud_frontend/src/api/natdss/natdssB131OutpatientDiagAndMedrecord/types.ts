export interface NatdssB131OutpatientDiagAndMedrecordVO {
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
   * 就诊类型:门诊、急诊
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
   * 病历记录流水号
   */
  recordSn: string;

  /**
   * 病历记录时间
   */
  recordDatetime: string;

  /**
   * 病历文书内容
   */
  recordText: string;

  /**
   * 诊疗经过
   */
  treatmentInfo: string;

  /**
   * 操作记录
   */
  operationInfo: string;

  /**
   * 主诉
   */
  chiefComplaint: string;

  /**
   * 现病史
   */
  currentMedhistory: string;

  /**
   * 既往史
   */
  pastMedhistory: string;

  /**
   * 个人史
   */
  personalMedhistory: string;

  /**
   * 家族史
   */
  familyHistory: string;

  /**
   * 婚育史
   */
  marriageBirthHistory: string;

  /**
   * 月经史
   */
  menstrualHistory: string;

  /**
   * 体格检查
   */
  physicalExam: string;

  /**
   * 中医病名
   */
  tcmDiseaseName: string;

  /**
   * 中医证候
   */
  tcmSyndromeName: string;

  /**
   * 诊断时间
   */
  diagnoseDatetime: string;

  /**
   * 主要诊断编码
   */
  maindiagCode1: string;

  /**
   * 主要诊断名称
   */
  maindiagName1: string;

  /**
   * 诊断编码-2
   */
  diagCode2: string;

  /**
   * 诊断名称-2
   */
  diagName2: string;

  /**
   * 诊断编码-3
   */
  diagCode3: string;

  /**
   * 诊断名称-3
   */
  diagName3: string;

  /**
   * 诊断编码-4
   */
  diagCode4: string;

  /**
   * 诊断名称-4
   */
  diagName4: string;

  /**
   * 诊断编码-5
   */
  diagCode5: string;

  /**
   * 诊断名称-5
   */
  diagName5: string;

  /**
   * 诊断编码-6
   */
  diagCode6: string;

  /**
   * 诊断名称-6
   */
  diagName6: string;

  /**
   * 诊断编码-7
   */
  diagCode7: string;

  /**
   * 诊断名称-7
   */
  diagName7: string;

  /**
   * 诊断编码-8
   */
  diagCode8: string;

  /**
   * 诊断名称-8
   */
  diagName8: string;

  /**
   * 诊断编码-9
   */
  diagCode9: string;

  /**
   * 诊断名称-9
   */
  diagName9: string;

  /**
   * 诊断编码-10
   */
  diagCode10: string;

  /**
   * 诊断名称-10
   */
  diagName10: string;

  /**
   * 诊断编码-N
   */
  diagCoden: string;

  /**
   * 诊断名称-N
   */
  diagNamen: string;

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

export interface NatdssB131OutpatientDiagAndMedrecordForm extends BaseEntity {
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
   * 就诊类型:门诊、急诊
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
   * 病历记录流水号
   */
  recordSn?: string;

  /**
   * 病历记录时间
   */
  recordDatetime?: string;

  /**
   * 病历文书内容
   */
  recordText?: string;

  /**
   * 诊疗经过
   */
  treatmentInfo?: string;

  /**
   * 操作记录
   */
  operationInfo?: string;

  /**
   * 主诉
   */
  chiefComplaint?: string;

  /**
   * 现病史
   */
  currentMedhistory?: string;

  /**
   * 既往史
   */
  pastMedhistory?: string;

  /**
   * 个人史
   */
  personalMedhistory?: string;

  /**
   * 家族史
   */
  familyHistory?: string;

  /**
   * 婚育史
   */
  marriageBirthHistory?: string;

  /**
   * 月经史
   */
  menstrualHistory?: string;

  /**
   * 体格检查
   */
  physicalExam?: string;

  /**
   * 中医病名
   */
  tcmDiseaseName?: string;

  /**
   * 中医证候
   */
  tcmSyndromeName?: string;

  /**
   * 诊断时间
   */
  diagnoseDatetime?: string;

  /**
   * 主要诊断编码
   */
  maindiagCode1?: string;

  /**
   * 主要诊断名称
   */
  maindiagName1?: string;

  /**
   * 诊断编码-2
   */
  diagCode2?: string;

  /**
   * 诊断名称-2
   */
  diagName2?: string;

  /**
   * 诊断编码-3
   */
  diagCode3?: string;

  /**
   * 诊断名称-3
   */
  diagName3?: string;

  /**
   * 诊断编码-4
   */
  diagCode4?: string;

  /**
   * 诊断名称-4
   */
  diagName4?: string;

  /**
   * 诊断编码-5
   */
  diagCode5?: string;

  /**
   * 诊断名称-5
   */
  diagName5?: string;

  /**
   * 诊断编码-6
   */
  diagCode6?: string;

  /**
   * 诊断名称-6
   */
  diagName6?: string;

  /**
   * 诊断编码-7
   */
  diagCode7?: string;

  /**
   * 诊断名称-7
   */
  diagName7?: string;

  /**
   * 诊断编码-8
   */
  diagCode8?: string;

  /**
   * 诊断名称-8
   */
  diagName8?: string;

  /**
   * 诊断编码-9
   */
  diagCode9?: string;

  /**
   * 诊断名称-9
   */
  diagName9?: string;

  /**
   * 诊断编码-10
   */
  diagCode10?: string;

  /**
   * 诊断名称-10
   */
  diagName10?: string;

  /**
   * 诊断编码-N
   */
  diagCoden?: string;

  /**
   * 诊断名称-N
   */
  diagNamen?: string;

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

export interface NatdssB131OutpatientDiagAndMedrecordQuery extends PageQuery {

  /**
   * 患者ID
   */
  patientId?: string | number;

  /**
   * 单次就诊唯一标识号
   */
  visitSn?: string;

  /**
   * 就诊类型:门诊、急诊
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
   * 病历记录流水号
   */
  recordSn?: string;

  /**
   * 病历记录时间
   */
  recordDatetime?: string;

  /**
   * 病历文书内容
   */
  recordText?: string;

  /**
   * 诊疗经过
   */
  treatmentInfo?: string;

  /**
   * 操作记录
   */
  operationInfo?: string;

  /**
   * 主诉
   */
  chiefComplaint?: string;

  /**
   * 现病史
   */
  currentMedhistory?: string;

  /**
   * 既往史
   */
  pastMedhistory?: string;

  /**
   * 个人史
   */
  personalMedhistory?: string;

  /**
   * 家族史
   */
  familyHistory?: string;

  /**
   * 婚育史
   */
  marriageBirthHistory?: string;

  /**
   * 月经史
   */
  menstrualHistory?: string;

  /**
   * 体格检查
   */
  physicalExam?: string;

  /**
   * 中医病名
   */
  tcmDiseaseName?: string;

  /**
   * 中医证候
   */
  tcmSyndromeName?: string;

  /**
   * 诊断时间
   */
  diagnoseDatetime?: string;

  /**
   * 主要诊断编码
   */
  maindiagCode1?: string;

  /**
   * 主要诊断名称
   */
  maindiagName1?: string;

  /**
   * 诊断编码-2
   */
  diagCode2?: string;

  /**
   * 诊断名称-2
   */
  diagName2?: string;

  /**
   * 诊断编码-3
   */
  diagCode3?: string;

  /**
   * 诊断名称-3
   */
  diagName3?: string;

  /**
   * 诊断编码-4
   */
  diagCode4?: string;

  /**
   * 诊断名称-4
   */
  diagName4?: string;

  /**
   * 诊断编码-5
   */
  diagCode5?: string;

  /**
   * 诊断名称-5
   */
  diagName5?: string;

  /**
   * 诊断编码-6
   */
  diagCode6?: string;

  /**
   * 诊断名称-6
   */
  diagName6?: string;

  /**
   * 诊断编码-7
   */
  diagCode7?: string;

  /**
   * 诊断名称-7
   */
  diagName7?: string;

  /**
   * 诊断编码-8
   */
  diagCode8?: string;

  /**
   * 诊断名称-8
   */
  diagName8?: string;

  /**
   * 诊断编码-9
   */
  diagCode9?: string;

  /**
   * 诊断名称-9
   */
  diagName9?: string;

  /**
   * 诊断编码-10
   */
  diagCode10?: string;

  /**
   * 诊断名称-10
   */
  diagName10?: string;

  /**
   * 诊断编码-N
   */
  diagCoden?: string;

  /**
   * 诊断名称-N
   */
  diagNamen?: string;

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



