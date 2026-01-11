export interface SurgeryComplicationRecordVO {
  /**
   * 医师姓名
   */
  doctorName: string;

  /**
   * 手术编码
   */
  surgeryCode: string;

  /**
   * 手术名称
   */
  surgeryName: string;

  /**
   * 并发症类型
   */
  complicationType: string;

  /**
   * 并发症描述
   */
  complicationDescription: string;

  /**
   * 并发症等级
   */
  complicationLevel: string;

  /**
   * 发生时间
   */
  occurrenceTime: string;

  /**
   * 是否为非计划二次手术
   */
  isPlannedSecondary: number;

  /**
   * 删除标志（0代表存在 1代表删除）
   */
  delFlag: string;
}

export interface SurgeryComplicationRecordForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 手术记录ID（HIS系统ID）
   */
  surgeryRecordId?: string | number;

  /**
   * 医师ID
   */
  doctorId?: string | number;

  /**
   * 医师姓名
   */
  doctorName?: string;

  /**
   * 患者ID
   */
  patientId?: string | number;

  /**
   * 手术编码
   */
  surgeryCode?: string;

  /**
   * 手术名称
   */
  surgeryName?: string;

  /**
   * 并发症类型
   */
  complicationType?: string;

  /**
   * 并发症描述
   */
  complicationDescription?: string;

  /**
   * 并发症等级
   */
  complicationLevel?: string;

  /**
   * 发生时间
   */
  occurrenceTime?: string;

  /**
   * 是否为非计划二次手术
   */
  isPlannedSecondary?: number;

  /**
   * 删除标志（0代表存在 1代表删除）
   */
  delFlag?: string;
}

export interface SurgeryComplicationRecordQuery extends PageQuery {
  /**
   * 医师姓名
   */
  doctorName?: string;

  /**
   * 手术编码
   */
  surgeryCode?: string;

  /**
   * 手术名称
   */
  surgeryName?: string;

  /**
   * 并发症类型
   */
  complicationType?: string;

  /**
   * 并发症描述
   */
  complicationDescription?: string;

  /**
   * 并发症等级
   */
  complicationLevel?: string;

  /**
   * 发生时间
   */
  occurrenceTime?: string;

  /**
   * 是否为非计划二次手术
   */
  isPlannedSecondary?: number;

  /**
   * 删除标志（0代表存在 1代表删除）
   */
  delFlag?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
