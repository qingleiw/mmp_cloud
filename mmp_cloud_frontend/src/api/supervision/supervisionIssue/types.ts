export interface SupervisionIssueVO {
  /**
   * 问题类型
   */
  issueType: string;

  /**
   * 问题描述
   */
  issueDescription: string;

  /**
   * 严重程度
   */
  severity: string;

  /**
   * 责任人
   */
  responsiblePerson: string;

  /**
   * 整改期限
   */
  rectificationDeadline: string;

  /**
   * 状态：pending-待整改，rectifying-整改中，completed-已完成
   */
  status: string;

  /**
   * 备注
   */
  remark: string;
}

export interface SupervisionIssueForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 结果ID
   */
  resultId?: string | number;

  /**
   * 问题类型
   */
  issueType?: string;

  /**
   * 问题描述
   */
  issueDescription?: string;

  /**
   * 严重程度
   */
  severity?: string;

  /**
   * 责任人
   */
  responsiblePerson?: string;

  /**
   * 整改期限
   */
  rectificationDeadline?: string;

  /**
   * 状态：pending-待整改，rectifying-整改中，completed-已完成
   */
  status?: string;

  /**
   * 备注
   */
  remark?: string;
}

export interface SupervisionIssueQuery extends PageQuery {
  /**
   * 问题类型
   */
  issueType?: string;

  /**
   * 问题描述
   */
  issueDescription?: string;

  /**
   * 严重程度
   */
  severity?: string;

  /**
   * 责任人
   */
  responsiblePerson?: string;

  /**
   * 整改期限
   */
  rectificationDeadline?: string;

  /**
   * 状态：pending-待整改，rectifying-整改中，completed-已完成
   */
  status?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
