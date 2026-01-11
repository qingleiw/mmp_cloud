export interface EmergencyIncidentVO {
  /**
   * 事件编码
   */
  incidentCode: string | number;

  /**
   * 事件标题
   */
  incidentTitle: string | number;

  /**
   * 事件类型
   */
  incidentType: string | number;

  /**
   * 事件等级
   */
  incidentLevel: string | number;

  /**
   * 发生时间
   */
  occurrenceTime: string;

  /**
   * 发生地点
   */
  location: string;

  /**
   * 事件描述
   */
  description: string;

  /**
   * 受影响人员
   */
  affectedPersons: string;

  /**
   * 响应队伍
   */
  responseTeam: string;

  /**
   * 响应措施
   */
  responseMeasures: string;

  /**
   * 解决时间
   */
  resolutionTime: string;

  /**
   * 伤亡情况
   */
  casualties: string;

  /**
   * 经济损失
   */
  economicLoss: number;

  /**
   * 经验教训
   */
  lessonsLearned: string;

  /**
   * 状态
   */
  status: string;

  /**
   * 备注
   */
  remark: string;
}

export interface EmergencyIncidentForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 事件编码
   */
  incidentCode?: string | number;

  /**
   * 事件标题
   */
  incidentTitle?: string | number;

  /**
   * 事件类型
   */
  incidentType?: string | number;

  /**
   * 事件等级
   */
  incidentLevel?: string | number;

  /**
   * 发生时间
   */
  occurrenceTime?: string;

  /**
   * 发生地点
   */
  location?: string;

  /**
   * 事件描述
   */
  description?: string;

  /**
   * 受影响人员
   */
  affectedPersons?: string;

  /**
   * 响应队伍
   */
  responseTeam?: string;

  /**
   * 响应措施
   */
  responseMeasures?: string;

  /**
   * 解决时间
   */
  resolutionTime?: string;

  /**
   * 伤亡情况
   */
  casualties?: string;

  /**
   * 经济损失
   */
  economicLoss?: number;

  /**
   * 经验教训
   */
  lessonsLearned?: string;

  /**
   * 状态
   */
  status?: string;

  /**
   * 备注
   */
  remark?: string;
}

export interface EmergencyIncidentQuery extends PageQuery {
  /**
   * 事件编码
   */
  incidentCode?: string | number;

  /**
   * 事件标题
   */
  incidentTitle?: string | number;

  /**
   * 事件类型
   */
  incidentType?: string | number;

  /**
   * 事件等级
   */
  incidentLevel?: string | number;

  /**
   * 发生时间
   */
  occurrenceTime?: string;

  /**
   * 发生地点
   */
  location?: string;

  /**
   * 事件描述
   */
  description?: string;

  /**
   * 受影响人员
   */
  affectedPersons?: string;

  /**
   * 响应队伍
   */
  responseTeam?: string;

  /**
   * 响应措施
   */
  responseMeasures?: string;

  /**
   * 解决时间
   */
  resolutionTime?: string;

  /**
   * 伤亡情况
   */
  casualties?: string;

  /**
   * 经济损失
   */
  economicLoss?: number;

  /**
   * 经验教训
   */
  lessonsLearned?: string;

  /**
   * 状态
   */
  status?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
