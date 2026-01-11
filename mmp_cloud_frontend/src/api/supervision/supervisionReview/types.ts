export interface SupervisionReviewVO {
  /**
   * 复查日期
   */
  reviewDate: string;

  /**
   * 复查人
   */
  reviewer: string;

  /**
   * 复查结果：qualified-合格，unqualified-不合格
   */
  reviewResult: string;

  /**
   * 复查意见
   */
  reviewOpinion: string;

  /**
   * 下次复查日期
   */
  nextReviewDate: string;

  /**
   * 状态
   */
  status: string;

  /**
   * 备注
   */
  remark: string;
}

export interface SupervisionReviewForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 任务ID
   */
  taskId?: string | number;

  /**
   * 复查日期
   */
  reviewDate?: string;

  /**
   * 复查人
   */
  reviewer?: string;

  /**
   * 复查结果：qualified-合格，unqualified-不合格
   */
  reviewResult?: string;

  /**
   * 复查意见
   */
  reviewOpinion?: string;

  /**
   * 下次复查日期
   */
  nextReviewDate?: string;

  /**
   * 状态
   */
  status?: string;

  /**
   * 备注
   */
  remark?: string;
}

export interface SupervisionReviewQuery extends PageQuery {
  /**
   * 复查日期
   */
  reviewDate?: string;

  /**
   * 复查人
   */
  reviewer?: string;

  /**
   * 复查结果：qualified-合格，unqualified-不合格
   */
  reviewResult?: string;

  /**
   * 复查意见
   */
  reviewOpinion?: string;

  /**
   * 下次复查日期
   */
  nextReviewDate?: string;

  /**
   * 状态
   */
  status?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
