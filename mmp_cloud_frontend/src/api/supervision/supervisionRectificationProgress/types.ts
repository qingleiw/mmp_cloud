export interface SupervisionRectificationProgressVO {
  /**
   * 进度描述
   */
  progressDescription: string;

  /**
   * 进度百分比
   */
  progressPercentage: number;

  /**
   * 附件URL
   */
  attachmentUrls: string;

  /**
   * 状态
   */
  status: string;

  /**
   * 备注
   */
  remark: string;
}

export interface SupervisionRectificationProgressForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 任务ID
   */
  taskId?: string | number;

  /**
   * 进度描述
   */
  progressDescription?: string;

  /**
   * 进度百分比
   */
  progressPercentage?: number;

  /**
   * 附件URL
   */
  attachmentUrls?: string;

  /**
   * 状态
   */
  status?: string;

  /**
   * 备注
   */
  remark?: string;
}

export interface SupervisionRectificationProgressQuery extends PageQuery {
  /**
   * 进度描述
   */
  progressDescription?: string;

  /**
   * 进度百分比
   */
  progressPercentage?: number;

  /**
   * 附件URL
   */
  attachmentUrls?: string;

  /**
   * 状态
   */
  status?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
