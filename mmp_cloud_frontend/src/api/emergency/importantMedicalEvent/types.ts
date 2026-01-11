export interface ImportantMedicalEventVO {
  /**
   * 主键ID
   */
  id: string | number;

  /**
   * 事件编号
   */
  eventNo: string;

  /**
   * 事件类型 death-死亡/unplanned_surgery-非计划手术/major_surgery-重大手术/critical_value-危急值等
   */
  eventType: string;

  /**
   * 患者ID
   */
  patientId: string | number;

  /**
   * 患者姓名
   */
  patientName: string;

  /**
   * 就诊号
   */
  visitNo: string;

  /**
   * 科室ID
   */
  departmentId: string | number;

  /**
   * 科室名称
   */
  departmentName: string;

  /**
   * 责任医生
   */
  responsibleDoctor: string;

  /**
   * 事件时间
   */
  eventTime: string;

  /**
   * 事件描述
   */
  eventDescription: string;

  /**
   * 事件级别
   */
  eventLevel: string;

  /**
   * 通知人员列表JSON
   */
  notifyUsers: string;

  /**
   * 来源系统
   */
  sourceSystem: string;

  /**
   * 是否已通知 1-是 0-否
   */
  isNotified: number;

  /**
   * 通知时间
   */
  notifyTime: string;
}

export interface ImportantMedicalEventForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 事件编号
   */
  eventNo?: string;

  /**
   * 事件类型 death-死亡/unplanned_surgery-非计划手术/major_surgery-重大手术/critical_value-危急值等
   */
  eventType?: string;

  /**
   * 患者ID
   */
  patientId?: string | number;

  /**
   * 患者姓名
   */
  patientName?: string;

  /**
   * 就诊号
   */
  visitNo?: string;

  /**
   * 科室ID
   */
  departmentId?: string | number;

  /**
   * 科室名称
   */
  departmentName?: string;

  /**
   * 责任医生
   */
  responsibleDoctor?: string;

  /**
   * 事件时间
   */
  eventTime?: string;

  /**
   * 事件描述
   */
  eventDescription?: string;

  /**
   * 事件级别
   */
  eventLevel?: string;

  /**
   * 通知人员列表JSON
   */
  notifyUsers?: string;

  /**
   * 来源系统
   */
  sourceSystem?: string;

  /**
   * 是否已通知 1-是 0-否
   */
  isNotified?: number;

  /**
   * 通知时间
   */
  notifyTime?: string;
}

export interface ImportantMedicalEventQuery extends PageQuery {
  /**
   * 事件编号
   */
  eventNo?: string;

  /**
   * 事件类型 death-死亡/unplanned_surgery-非计划手术/major_surgery-重大手术/critical_value-危急值等
   */
  eventType?: string;

  /**
   * 患者ID
   */
  patientId?: string | number;

  /**
   * 患者姓名
   */
  patientName?: string;

  /**
   * 就诊号
   */
  visitNo?: string;

  /**
   * 科室ID
   */
  departmentId?: string | number;

  /**
   * 科室名称
   */
  departmentName?: string;

  /**
   * 责任医生
   */
  responsibleDoctor?: string;

  /**
   * 事件时间
   */
  eventTime?: string;

  /**
   * 事件描述
   */
  eventDescription?: string;

  /**
   * 事件级别
   */
  eventLevel?: string;

  /**
   * 通知人员列表JSON
   */
  notifyUsers?: string;

  /**
   * 来源系统
   */
  sourceSystem?: string;

  /**
   * 是否已通知 1-是 0-否
   */
  isNotified?: number;

  /**
   * 通知时间
   */
  notifyTime?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
