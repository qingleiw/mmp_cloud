export interface EmergencyDrillPlanVO {
  /**
   * 计划编码
   */
  planCode: string;

  /**
   * 计划名称
   */
  planName: string;

  /**
   * 演练类型
   */
  drillType: string;

  /**
   * 演练场景
   */
  drillScenario: string;

  /**
   * 计划日期
   */
  plannedDate: string;

  /**
   * 实际日期
   */
  actualDate: string;

  /**
   * 演练地点
   */
  location: string;

  /**
   * 组织者
   */
  organizer: string;

  /**
   * 参与人员
   */
  participants: string;

  /**
   * 演练目标
   */
  objectives: string;

  /**
   * 演练流程
   */
  procedures: string;

  /**
   * 评估标准
   */
  evaluationCriteria: string;

  /**
   * 状态：planned-已计划，executing-执行中，completed-已完成
   */
  status: string;

  /**
   * 演练结果
   */
  drillResult: string;

  /**
   * 经验教训
   */
  lessonsLearned: string;

  /**
   * 备注
   */
  remark: string;
}

export interface EmergencyDrillPlanForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 计划编码
   */
  planCode?: string;

  /**
   * 计划名称
   */
  planName?: string;

  /**
   * 演练类型
   */
  drillType?: string;

  /**
   * 演练场景
   */
  drillScenario?: string;

  /**
   * 计划日期
   */
  plannedDate?: string;

  /**
   * 实际日期
   */
  actualDate?: string;

  /**
   * 演练地点
   */
  location?: string;

  /**
   * 组织者
   */
  organizer?: string;

  /**
   * 参与人员
   */
  participants?: string;

  /**
   * 演练目标
   */
  objectives?: string;

  /**
   * 演练流程
   */
  procedures?: string;

  /**
   * 评估标准
   */
  evaluationCriteria?: string;

  /**
   * 状态：planned-已计划，executing-执行中，completed-已完成
   */
  status?: string;

  /**
   * 演练结果
   */
  drillResult?: string;

  /**
   * 经验教训
   */
  lessonsLearned?: string;

  /**
   * 备注
   */
  remark?: string;
}

export interface EmergencyDrillPlanQuery extends PageQuery {
  /**
   * 计划编码
   */
  planCode?: string;

  /**
   * 计划名称
   */
  planName?: string;

  /**
   * 演练类型
   */
  drillType?: string;

  /**
   * 演练场景
   */
  drillScenario?: string;

  /**
   * 计划日期
   */
  plannedDate?: string;

  /**
   * 实际日期
   */
  actualDate?: string;

  /**
   * 演练地点
   */
  location?: string;

  /**
   * 组织者
   */
  organizer?: string;

  /**
   * 参与人员
   */
  participants?: string;

  /**
   * 演练目标
   */
  objectives?: string;

  /**
   * 演练流程
   */
  procedures?: string;

  /**
   * 评估标准
   */
  evaluationCriteria?: string;

  /**
   * 状态：planned-已计划，executing-执行中，completed-已完成
   */
  status?: string;

  /**
   * 演练结果
   */
  drillResult?: string;

  /**
   * 经验教训
   */
  lessonsLearned?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
