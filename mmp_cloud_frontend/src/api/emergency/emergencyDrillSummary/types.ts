export interface EmergencyDrillSummaryVO {
  /**
   * 实际开始时间
   */
  actualStartTime: string;

  /**
   * 实际结束时间
   */
  actualEndTime: string;

  /**
   * 实际参与人数
   */
  participantsCount: number;

  /**
   * 演练过程描述
   */
  drillProcess: string;

  /**
   * 发现的问题
   */
  problemsFound: string;

  /**
   * 经验教训
   */
  lessonsLearned: string;

  /**
   * 改进措施
   */
  improvementMeasures: string;

  /**
   * 评价分数
   */
  evaluationScore: number;

  /**
   * 评价人姓名
   */
  evaluatorName: string;

  /**
   * 评价时间
   */
  evaluationTime: string;

  /**
   * 备注
   */
  remark: string;
}

export interface EmergencyDrillSummaryForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 计划ID
   */
  planId?: string | number;

  /**
   * 实际开始时间
   */
  actualStartTime?: string;

  /**
   * 实际结束时间
   */
  actualEndTime?: string;

  /**
   * 实际参与人数
   */
  participantsCount?: number;

  /**
   * 演练过程描述
   */
  drillProcess?: string;

  /**
   * 发现的问题
   */
  problemsFound?: string;

  /**
   * 经验教训
   */
  lessonsLearned?: string;

  /**
   * 改进措施
   */
  improvementMeasures?: string;

  /**
   * 评价分数
   */
  evaluationScore?: number;

  /**
   * 评价人ID
   */
  evaluatorId?: string | number;

  /**
   * 评价人姓名
   */
  evaluatorName?: string;

  /**
   * 评价时间
   */
  evaluationTime?: string;

  /**
   * 备注
   */
  remark?: string;
}

export interface EmergencyDrillSummaryQuery extends PageQuery {
  /**
   * 实际开始时间
   */
  actualStartTime?: string;

  /**
   * 实际结束时间
   */
  actualEndTime?: string;

  /**
   * 实际参与人数
   */
  participantsCount?: number;

  /**
   * 演练过程描述
   */
  drillProcess?: string;

  /**
   * 发现的问题
   */
  problemsFound?: string;

  /**
   * 经验教训
   */
  lessonsLearned?: string;

  /**
   * 改进措施
   */
  improvementMeasures?: string;

  /**
   * 评价分数
   */
  evaluationScore?: number;

  /**
   * 评价人姓名
   */
  evaluatorName?: string;

  /**
   * 评价时间
   */
  evaluationTime?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
