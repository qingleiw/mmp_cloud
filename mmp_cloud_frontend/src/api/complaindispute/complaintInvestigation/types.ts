export interface ComplaintInvestigationVO {
  /**
   * 主键ID
   */
  id: string | number;

  /**
   * 调查人姓名
   */
  investigatorName: string;

  /**
   * 调查内容
   */
  investigationContent: string;

  /**
   * 调查结果
   */
  investigationResult: string;

  /**
   * 调查时间
   */
  investigationTime: string;

  /**
   * 附件（JSON格式）
   */
  attachments: string;

  /**
   * 删除标志（0代表存在 1代表删除）
   */
  delFlag: string;
}

export interface ComplaintInvestigationForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 投诉ID
   */
  complaintId?: string | number;

  /**
   * 调查人ID
   */
  investigatorId?: string | number;

  /**
   * 调查人姓名
   */
  investigatorName?: string;

  /**
   * 调查内容
   */
  investigationContent?: string;

  /**
   * 调查结果
   */
  investigationResult?: string;

  /**
   * 调查时间
   */
  investigationTime?: string;

  /**
   * 附件（JSON格式）
   */
  attachments?: string;

  /**
   * 删除标志（0代表存在 1代表删除）
   */
  delFlag?: string;
}

export interface ComplaintInvestigationQuery extends PageQuery {
  /**
   * 调查人姓名
   */
  investigatorName?: string;

  /**
   * 调查内容
   */
  investigationContent?: string;

  /**
   * 调查结果
   */
  investigationResult?: string;

  /**
   * 调查时间
   */
  investigationTime?: string;

  /**
   * 附件（JSON格式）
   */
  attachments?: string;

  /**
   * 删除标志（0代表存在 1代表删除）
   */
  delFlag?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
