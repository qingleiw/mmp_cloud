export interface NatdssB061EmrProgressNotesVO {
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
  patientNo: string;

  /**
   * 住院次数
   */
  hospitalizationTimes: string;

  /**
   * 病程记录流水号
   */
  recordSn: string;

  /**
   * 病程记录时间
   */
  recordDatetime: string;

  /**
   * 病程记录类型代码
   */
  recordTitleCode: string;

  /**
   * 病程记录类型
   */
  recordTitle: string;

  /**
   * 病程记录
   */
  recordContent: string;

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

export interface NatdssB061EmrProgressNotesForm extends BaseEntity {
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
  patientNo?: string;

  /**
   * 住院次数
   */
  hospitalizationTimes?: string;

  /**
   * 病程记录流水号
   */
  recordSn?: string;

  /**
   * 病程记录时间
   */
  recordDatetime?: string;

  /**
   * 病程记录类型代码
   */
  recordTitleCode?: string;

  /**
   * 病程记录类型
   */
  recordTitle?: string;

  /**
   * 病程记录
   */
  recordContent?: string;

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

export interface NatdssB061EmrProgressNotesQuery extends PageQuery {

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
  patientNo?: string;

  /**
   * 住院次数
   */
  hospitalizationTimes?: string;

  /**
   * 病程记录流水号
   */
  recordSn?: string;

  /**
   * 病程记录时间
   */
  recordDatetime?: string;

  /**
   * 病程记录类型代码
   */
  recordTitleCode?: string;

  /**
   * 病程记录类型
   */
  recordTitle?: string;

  /**
   * 病程记录
   */
  recordContent?: string;

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



