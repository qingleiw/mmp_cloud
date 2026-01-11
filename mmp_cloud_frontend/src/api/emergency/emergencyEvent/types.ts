export interface EmergencyEventVO {
  id: string | number;
  /**
   * 事件编码
   */
  eventCode: string;

  /**
   * 事件标题
   */
  eventTitle: string;

  /**
   * 事件类型
   */
  eventType: string;

  /**
   * 事件等级
   */
  eventLevel: string;

  /**
   * 发生时间
   */
  occurrenceTime: string;

  /**
   * 发现时间
   */
  discoveryTime: string;

  /**
   * 报告时间
   */
  reportTime: string;

  /**
   * 报告人
   */
  reporter: string;

  /**
   * 发生地点
   */
  location: string;

  /**
   * 受影响人员
   */
  affectedPersons: string;

  /**
   * 事件描述
   */
  eventDescription: string;

  /**
   * 立即措施
   */
  immediateMeasures: string;

  /**
   * 状态
   */
  status: string;

  /**
   * 备注
   */
  remark: string;
}

export interface EmergencyEventForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 事件编码
   */
  eventCode?: string;

  /**
   * 事件标题
   */
  eventTitle?: string;

  /**
   * 事件类型
   */
  eventType?: string;

  /**
   * 事件等级
   */
  eventLevel?: string;

  /**
   * 发生时间
   */
  occurrenceTime?: string;

  /**
   * 发现时间
   */
  discoveryTime?: string;

  /**
   * 报告时间
   */
  reportTime?: string;

  /**
   * 报告人
   */
  reporter?: string;

  /**
   * 发生地点
   */
  location?: string;

  /**
   * 受影响人员
   */
  affectedPersons?: string;

  /**
   * 事件描述
   */
  eventDescription?: string;

  /**
   * 立即措施
   */
  immediateMeasures?: string;

  /**
   * 状态
   */
  status?: string;

  /**
   * 备注
   */
  remark?: string;
}

export interface EmergencyEventQuery extends PageQuery {
  /**
   * 事件编码
   */
  eventCode?: string;

  /**
   * 事件标题
   */
  eventTitle?: string;

  /**
   * 事件类型
   */
  eventType?: string;

  /**
   * 事件等级
   */
  eventLevel?: string;

  /**
   * 发生时间
   */
  occurrenceTime?: string;

  /**
   * 发现时间
   */
  discoveryTime?: string;

  /**
   * 报告时间
   */
  reportTime?: string;

  /**
   * 报告人
   */
  reporter?: string;

  /**
   * 发生地点
   */
  location?: string;

  /**
   * 受影响人员
   */
  affectedPersons?: string;

  /**
   * 事件描述
   */
  eventDescription?: string;

  /**
   * 立即措施
   */
  immediateMeasures?: string;

  /**
   * 状态
   */
  status?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
