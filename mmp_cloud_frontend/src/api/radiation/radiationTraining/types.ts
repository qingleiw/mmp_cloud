export interface RadiationTrainingVO {
  /**
   * 培训编码
   */
  trainingCode: string;

  /**
   * 培训名称
   */
  trainingName: string;

  /**
   * 培训类型
   */
  trainingType: string;

  /**
   * 培训日期
   */
  trainingDate: string;

  /**
   * 培训师
   */
  trainer: string;

  /**
   * 参与人员
   */
  participants: string;

  /**
   * 培训内容
   */
  trainingContent: string;

  /**
   * 培训学时
   */
  trainingHours: number;

  /**
   * 评估结果
   */
  evaluationResults: string;

  /**
   * 状态
   */
  status: string;

  /**
   * 备注
   */
  remark: string;
}

export interface RadiationTrainingForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 培训编码
   */
  trainingCode?: string;

  /**
   * 培训名称
   */
  trainingName?: string;

  /**
   * 培训类型
   */
  trainingType?: string;

  /**
   * 培训日期
   */
  trainingDate?: string;

  /**
   * 培训师
   */
  trainer?: string;

  /**
   * 参与人员
   */
  participants?: string;

  /**
   * 培训内容
   */
  trainingContent?: string;

  /**
   * 培训学时
   */
  trainingHours?: number;

  /**
   * 评估结果
   */
  evaluationResults?: string;

  /**
   * 状态
   */
  status?: string;

  /**
   * 备注
   */
  remark?: string;
}

export interface RadiationTrainingQuery extends PageQuery {
  /**
   * 培训编码
   */
  trainingCode?: string;

  /**
   * 培训名称
   */
  trainingName?: string;

  /**
   * 培训类型
   */
  trainingType?: string;

  /**
   * 培训日期
   */
  trainingDate?: string;

  /**
   * 培训师
   */
  trainer?: string;

  /**
   * 参与人员
   */
  participants?: string;

  /**
   * 培训内容
   */
  trainingContent?: string;

  /**
   * 培训学时
   */
  trainingHours?: number;

  /**
   * 评估结果
   */
  evaluationResults?: string;

  /**
   * 状态
   */
  status?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
