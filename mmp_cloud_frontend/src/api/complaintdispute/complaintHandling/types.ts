export interface ComplaintHandlingVO {
  /**
   * 主键ID
   */
  id: string | number;

  /**
   * 处理人姓名
   */
  handlerName: string;

  /**
   * 处理措施
   */
  handlingMeasure: string;

  /**
   * 处理结果
   */
  handlingResult: string;

  /**
   * 处理时间
   */
  handlingTime: string;

  /**
   * 反馈内容
   */
  feedbackContent: string;

  /**
   * 反馈时间
   */
  feedbackTime: string;

  /**
   * 删除标志（0代表存在 1代表删除）
   */
  delFlag: string;
}

export interface ComplaintHandlingForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 投诉ID
   */
  complaintId?: string | number;

  /**
   * 处理人ID
   */
  handlerId?: string | number;

  /**
   * 处理人姓名
   */
  handlerName?: string;

  /**
   * 处理措施
   */
  handlingMeasure?: string;

  /**
   * 处理结果
   */
  handlingResult?: string;

  /**
   * 处理时间
   */
  handlingTime?: string;

  /**
   * 反馈内容
   */
  feedbackContent?: string;

  /**
   * 反馈时间
   */
  feedbackTime?: string;

  /**
   * 删除标志（0代表存在 1代表删除）
   */
  delFlag?: string;
}

export interface ComplaintHandlingQuery extends PageQuery {
  /**
   * 处理人姓名
   */
  handlerName?: string;

  /**
   * 处理措施
   */
  handlingMeasure?: string;

  /**
   * 处理结果
   */
  handlingResult?: string;

  /**
   * 处理时间
   */
  handlingTime?: string;

  /**
   * 反馈内容
   */
  feedbackContent?: string;

  /**
   * 反馈时间
   */
  feedbackTime?: string;

  /**
   * 删除标志（0代表存在 1代表删除）
   */
  delFlag?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
