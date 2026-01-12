export interface LedgerBusinessLearningVO {
  /**
   * 学习日期
   */
  learningDate: string;

  /**
   * 学习主题
   */
  learningTopic: string;

  /**
   * 学习类型
   */
  learningType: string;

  /**
   * 组织者
   */
  organizer: string;

  /**
   * 参与人员
   */
  participants: string;

  /**
   * 学习内容
   */
  learningContent: string;

  /**
   * 学习学时
   */
  learningHours: number;

  /**
   * 授课人
   */
  instructor: string;

  /**
   * 评价结果
   */
  evaluationResults: string;

  /**
   * 附件
   */
  attachments: string;

  /**
   * 状态
   */
  status: string;

  /**
   * 备注
   */
  remark: string;

}

export interface LedgerBusinessLearningForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 学习日期
   */
  learningDate?: string;

  /**
   * 学习主题
   */
  learningTopic?: string;

  /**
   * 学习类型
   */
  learningType?: string;

  /**
   * 组织者
   */
  organizer?: string;

  /**
   * 参与人员
   */
  participants?: string;

  /**
   * 学习内容
   */
  learningContent?: string;

  /**
   * 学习学时
   */
  learningHours?: number;

  /**
   * 授课人
   */
  instructor?: string;

  /**
   * 评价结果
   */
  evaluationResults?: string;

  /**
   * 附件
   */
  attachments?: string;

  /**
   * 状态
   */
  status?: string;

  /**
   * 备注
   */
  remark?: string;

}

export interface LedgerBusinessLearningQuery extends PageQuery {

  /**
   * 学习日期
   */
  learningDate?: string;

  /**
   * 学习主题
   */
  learningTopic?: string;

  /**
   * 学习类型
   */
  learningType?: string;

  /**
   * 组织者
   */
  organizer?: string;

  /**
   * 参与人员
   */
  participants?: string;

  /**
   * 学习内容
   */
  learningContent?: string;

  /**
   * 学习学时
   */
  learningHours?: number;

  /**
   * 授课人
   */
  instructor?: string;

  /**
   * 评价结果
   */
  evaluationResults?: string;

  /**
   * 附件
   */
  attachments?: string;

  /**
   * 状态
   */
  status?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
