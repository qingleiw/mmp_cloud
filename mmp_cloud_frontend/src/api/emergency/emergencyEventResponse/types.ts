export interface EmergencyEventResponseVO {
  /**
   * 响应队伍
   */
  responseTeam: string;

  /**
   * 响应开始时间
   */
  responseStartTime: string;

  /**
   * 响应结束时间
   */
  responseEndTime: string;

  /**
   * 响应措施
   */
  responseMeasures: string;

  /**
   * 责任人
   */
  responsiblePerson: string;

  /**
   * 备注
   */
  remark: string;
}

export interface EmergencyEventResponseForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 事件ID
   */
  eventId?: string | number;

  /**
   * 响应队伍
   */
  responseTeam?: string;

  /**
   * 响应开始时间
   */
  responseStartTime?: string;

  /**
   * 响应结束时间
   */
  responseEndTime?: string;

  /**
   * 响应措施
   */
  responseMeasures?: string;

  /**
   * 责任人
   */
  responsiblePerson?: string;

  /**
   * 备注
   */
  remark?: string;
}

export interface EmergencyEventResponseQuery extends PageQuery {
  /**
   * 响应队伍
   */
  responseTeam?: string;

  /**
   * 响应开始时间
   */
  responseStartTime?: string;

  /**
   * 响应结束时间
   */
  responseEndTime?: string;

  /**
   * 响应措施
   */
  responseMeasures?: string;

  /**
   * 责任人
   */
  responsiblePerson?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
