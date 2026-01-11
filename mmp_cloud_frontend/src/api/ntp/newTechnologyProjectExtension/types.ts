export interface NewTechnologyProjectExtensionVO {
  /**
   * 申请编号
   */
  applyNo: string;

  /**
   * 原结束日期
   */
  originalEndDate: string;

  /**
   * 延期天数
   */
  extendDays: number;

  /**
   * 新结束日期
   */
  newEndDate: string;

  /**
   * 延期理由
   */
  extensionReason: string;

  /**
   * 申请状态
   */
  applyStatus: string;

  /**
   * 备注
   */
  remark: string;

}

export interface NewTechnologyProjectExtensionForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 申请编号
   */
  applyNo?: string;

  /**
   * 项目ID
   */
  projectId?: string | number;

  /**
   * 原结束日期
   */
  originalEndDate?: string;

  /**
   * 延期天数
   */
  extendDays?: number;

  /**
   * 新结束日期
   */
  newEndDate?: string;

  /**
   * 延期理由
   */
  extensionReason?: string;

  /**
   * 申请状态
   */
  applyStatus?: string;

  /**
   * 工作流实例ID
   */
  workflowInstanceId?: string | number;

  /**
   * 备注
   */
  remark?: string;

}

export interface NewTechnologyProjectExtensionQuery extends PageQuery {

  /**
   * 申请编号
   */
  applyNo?: string;

  /**
   * 原结束日期
   */
  originalEndDate?: string;

  /**
   * 延期天数
   */
  extendDays?: number;

  /**
   * 新结束日期
   */
  newEndDate?: string;

  /**
   * 延期理由
   */
  extensionReason?: string;

  /**
   * 申请状态
   */
  applyStatus?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
