export interface DoctorAdverseRecordVO {
  /**
   * 主键ID
   */
  id: string | number;

  /**
   * 医生ID
   */
  doctorId: string | number;

  /**
   * 医生姓名
   */
  doctorName: string;

  /**
   * 记录类型 医疗事故/差错/违规
   */
  recordType: string;

  /**
   * 记录标题
   */
  recordTitle: string;

  /**
   * 发生日期
   */
  occurDate: string;

  /**
   * 事件描述
   */
  description: string;

  /**
   * 后果
   */
  consequence: string;

  /**
   * 处理措施
   */
  handlingMeasure: string;

  /**
   * 处罚情况
   */
  punishment: string;

  /**
   * 记录状态 待处理/处理中/已处理
   */
  recordStatus: string;

  /**
   * 是否删除
   */
  delFlag?: string;
}

export interface DoctorAdverseRecordForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 医生ID
   */
  doctorId?: string | number;

  /**
   * 记录类型 医疗事故/差错/违规
   */
  recordType?: string;

  /**
   * 记录标题
   */
  recordTitle?: string;

  /**
   * 发生日期
   */
  occurDate?: string;

  /**
   * 事件描述
   */
  description?: string;

  /**
   * 后果
   */
  consequence?: string;

  /**
   * 处理措施
   */
  handlingMeasure?: string;

  /**
   * 处罚情况
   */
  punishment?: string;

  /**
   * 记录状态 待处理/处理中/已处理
   */
  recordStatus?: string;

  /**
   * 是否删除
   */
  delFlag?: string;
}

export interface DoctorAdverseRecordQuery extends PageQuery {
  /**
   * 医生ID
   */
  doctorId?: string | number;

  /**
   * 记录类型 医疗事故/差错/违规
   */
  recordType?: string;

  /**
   * 记录标题
   */
  recordTitle?: string;

  /**
   * 发生日期
   */
  occurDate?: string;

  /**
   * 事件描述
   */
  description?: string;

  /**
   * 后果
   */
  consequence?: string;

  /**
   * 处理措施
   */
  handlingMeasure?: string;

  /**
   * 处罚情况
   */
  punishment?: string;

  /**
   * 记录状态 待处理/处理中/已处理
   */
  recordStatus?: string;

  /**
   * 是否删除
   */
  delFlag?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
