export interface NatdssB023DiagInfoVO {
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
   * 患者姓名
   */
  name: string;

  /**
   * 诊断ID号
   */
  diagId: string | number;

  /**
   * 诊断序号
   */
  diagSerialNumber: string;

  /**
   * 诊断类型:门诊诊断、入院诊断、出院诊断、其他诊断
   */
  diagType: string;

  /**
   * 诊断编码
   */
  diagCode: string;

  /**
   * 诊断名称
   */
  diagName: string;

  /**
   * 诊断说明
   */
  diagExplanation: string;

  /**
   * 诊断时间
   */
  diagDatetime: string;

  /**
   * 是否明确诊断
   */
  confirmedDiagMark: string;

  /**
   * 是否主要诊断
   */
  maindiagMark: string;

  /**
   * 诊断医生代码
   */
  diagDoctorNo: string;

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

export interface NatdssB023DiagInfoForm extends BaseEntity {
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
   * 患者姓名
   */
  name?: string;

  /**
   * 诊断ID号
   */
  diagId?: string | number;

  /**
   * 诊断序号
   */
  diagSerialNumber?: string;

  /**
   * 诊断类型:门诊诊断、入院诊断、出院诊断、其他诊断
   */
  diagType?: string;

  /**
   * 诊断编码
   */
  diagCode?: string;

  /**
   * 诊断名称
   */
  diagName?: string;

  /**
   * 诊断说明
   */
  diagExplanation?: string;

  /**
   * 诊断时间
   */
  diagDatetime?: string;

  /**
   * 是否明确诊断
   */
  confirmedDiagMark?: string;

  /**
   * 是否主要诊断
   */
  maindiagMark?: string;

  /**
   * 诊断医生代码
   */
  diagDoctorNo?: string;

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

export interface NatdssB023DiagInfoQuery extends PageQuery {

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
   * 患者姓名
   */
  name?: string;

  /**
   * 诊断ID号
   */
  diagId?: string | number;

  /**
   * 诊断序号
   */
  diagSerialNumber?: string;

  /**
   * 诊断类型:门诊诊断、入院诊断、出院诊断、其他诊断
   */
  diagType?: string;

  /**
   * 诊断编码
   */
  diagCode?: string;

  /**
   * 诊断名称
   */
  diagName?: string;

  /**
   * 诊断说明
   */
  diagExplanation?: string;

  /**
   * 诊断时间
   */
  diagDatetime?: string;

  /**
   * 是否明确诊断
   */
  confirmedDiagMark?: string;

  /**
   * 是否主要诊断
   */
  maindiagMark?: string;

  /**
   * 诊断医生代码
   */
  diagDoctorNo?: string;

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



