export interface NatdssB031InpatientInfoVO {
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
   * 就诊卡号
   */
  visitCardNo: string;

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
   * 姓名
   */
  name: string;

  /**
   * 入院时间
   */
  admissionDatetime: string;

  /**
   * 当前科室代码
   */
  currentDeptCode: string;

  /**
   * 当前科室名称
   */
  currentDeptName: string;

  /**
   * 当前病房名称
   */
  currentWardName: string;

  /**
   * 当前床位名称
   */
  currentBedName: string;

  /**
   * 管床医生代码
   */
  visitDoctorNo: string;

  /**
   * 出院时间
   */
  dischargeDatetime: string;

  /**
   * 出院科室编码
   */
  dischargeDeptCode: string;

  /**
   * 出院科室名称
   */
  dischargeDeptName: string;

  /**
   * 扩展字段1:出院状态
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

export interface NatdssB031InpatientInfoForm extends BaseEntity {
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
   * 就诊卡号
   */
  visitCardNo?: string;

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
   * 姓名
   */
  name?: string;

  /**
   * 入院时间
   */
  admissionDatetime?: string;

  /**
   * 当前科室代码
   */
  currentDeptCode?: string;

  /**
   * 当前科室名称
   */
  currentDeptName?: string;

  /**
   * 当前病房名称
   */
  currentWardName?: string;

  /**
   * 当前床位名称
   */
  currentBedName?: string;

  /**
   * 管床医生代码
   */
  visitDoctorNo?: string;

  /**
   * 出院时间
   */
  dischargeDatetime?: string;

  /**
   * 出院科室编码
   */
  dischargeDeptCode?: string;

  /**
   * 出院科室名称
   */
  dischargeDeptName?: string;

  /**
   * 扩展字段1:出院状态
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

export interface NatdssB031InpatientInfoQuery extends PageQuery {

  /**
   * 患者ID
   */
  patientId?: string | number;

  /**
   * 单次就诊唯一标识号
   */
  visitSn?: string;

  /**
   * 就诊卡号
   */
  visitCardNo?: string;

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
   * 姓名
   */
  name?: string;

  /**
   * 入院时间
   */
  admissionDatetime?: string;

  /**
   * 当前科室代码
   */
  currentDeptCode?: string;

  /**
   * 当前科室名称
   */
  currentDeptName?: string;

  /**
   * 当前病房名称
   */
  currentWardName?: string;

  /**
   * 当前床位名称
   */
  currentBedName?: string;

  /**
   * 管床医生代码
   */
  visitDoctorNo?: string;

  /**
   * 出院时间
   */
  dischargeDatetime?: string;

  /**
   * 出院科室编码
   */
  dischargeDeptCode?: string;

  /**
   * 出院科室名称
   */
  dischargeDeptName?: string;

  /**
   * 扩展字段1:出院状态
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



