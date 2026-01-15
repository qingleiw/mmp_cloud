export interface NatdssB121OutpatientInfoVO {
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
   * 患者姓名
   */
  name: string;

  /**
   * 挂号流水号
   */
  regisSn: string;

  /**
   * 挂号时间
   */
  regisDatetime: string;

  /**
   * 就诊时间
   */
  visitDatetime: string;

  /**
   * 是否初诊
   */
  firstVisitMark: string;

  /**
   * 挂号渠道代码
   */
  regisMethodCode: string;

  /**
   * 挂号渠道名称
   */
  regisMethod: string;

  /**
   * 挂号类型代码
   */
  regisTypeCode: string;

  /**
   * 挂号类型
   */
  regisType: string;

  /**
   * 挂号金额(元)
   */
  regisChargePrice: number;

  /**
   * 实付金额(元)
   */
  regisPaidPrice: string | number;

  /**
   * 挂号科室代码
   */
  regisDeptCode: string;

  /**
   * 挂号科室名称
   */
  regisDeptName: string;

  /**
   * 就诊医生代码
   */
  visitDoctorNo: string;

  /**
   * 医师职称名称
   */
  technicalTitle: string;

  /**
   * 医师职务名称
   */
  jobTitle: string;

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

export interface NatdssB121OutpatientInfoForm extends BaseEntity {
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
   * 患者姓名
   */
  name?: string;

  /**
   * 挂号流水号
   */
  regisSn?: string;

  /**
   * 挂号时间
   */
  regisDatetime?: string;

  /**
   * 就诊时间
   */
  visitDatetime?: string;

  /**
   * 是否初诊
   */
  firstVisitMark?: string;

  /**
   * 挂号渠道代码
   */
  regisMethodCode?: string;

  /**
   * 挂号渠道名称
   */
  regisMethod?: string;

  /**
   * 挂号类型代码
   */
  regisTypeCode?: string;

  /**
   * 挂号类型
   */
  regisType?: string;

  /**
   * 挂号金额(元)
   */
  regisChargePrice?: number;

  /**
   * 实付金额(元)
   */
  regisPaidPrice?: string | number;

  /**
   * 挂号科室代码
   */
  regisDeptCode?: string;

  /**
   * 挂号科室名称
   */
  regisDeptName?: string;

  /**
   * 就诊医生代码
   */
  visitDoctorNo?: string;

  /**
   * 医师职称名称
   */
  technicalTitle?: string;

  /**
   * 医师职务名称
   */
  jobTitle?: string;

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

export interface NatdssB121OutpatientInfoQuery extends PageQuery {

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
   * 患者姓名
   */
  name?: string;

  /**
   * 挂号流水号
   */
  regisSn?: string;

  /**
   * 挂号时间
   */
  regisDatetime?: string;

  /**
   * 就诊时间
   */
  visitDatetime?: string;

  /**
   * 是否初诊
   */
  firstVisitMark?: string;

  /**
   * 挂号渠道代码
   */
  regisMethodCode?: string;

  /**
   * 挂号渠道名称
   */
  regisMethod?: string;

  /**
   * 挂号类型代码
   */
  regisTypeCode?: string;

  /**
   * 挂号类型
   */
  regisType?: string;

  /**
   * 挂号金额(元)
   */
  regisChargePrice?: number;

  /**
   * 实付金额(元)
   */
  regisPaidPrice?: string | number;

  /**
   * 挂号科室代码
   */
  regisDeptCode?: string;

  /**
   * 挂号科室名称
   */
  regisDeptName?: string;

  /**
   * 就诊医生代码
   */
  visitDoctorNo?: string;

  /**
   * 医师职称名称
   */
  technicalTitle?: string;

  /**
   * 医师职务名称
   */
  jobTitle?: string;

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



