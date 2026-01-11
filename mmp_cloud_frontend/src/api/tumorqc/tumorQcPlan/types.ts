export interface TumorQcPlanVO {
  /**
   * 方案编码
   */
  planCode: string;

  /**
   * 方案名称
   */
  planName: string;

  /**
   * 方案类型
   */
  planType: string;

  /**
   * 方案描述
   */
  description: string;

  /**
   * 开始日期
   */
  startDate: string;

  /**
   * 结束日期
   */
  endDate: string;

  /**
   * 状态（0正常 1停用）
   */
  status: string;

  /**
   * 审批状态（0待审批 1已审批 2驳回）
   */
  approvalStatus: string;

  /**
   * 删除标志（0代表存在 1代表删除）
   */
  delFlag: string;
}

export interface TumorQcPlanForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 方案编码
   */
  planCode?: string;

  /**
   * 方案名称
   */
  planName?: string;

  /**
   * 方案类型
   */
  planType?: string;

  /**
   * 方案描述
   */
  description?: string;

  /**
   * 开始日期
   */
  startDate?: string;

  /**
   * 结束日期
   */
  endDate?: string;

  /**
   * 状态（0正常 1停用）
   */
  status?: string;

  /**
   * 审批状态（0待审批 1已审批 2驳回）
   */
  approvalStatus?: string;

  /**
   * 删除标志（0代表存在 1代表删除）
   */
  delFlag?: string;
}

export interface TumorQcPlanQuery extends PageQuery {
  /**
   * 方案编码
   */
  planCode?: string;

  /**
   * 方案名称
   */
  planName?: string;

  /**
   * 方案类型
   */
  planType?: string;

  /**
   * 方案描述
   */
  description?: string;

  /**
   * 开始日期
   */
  startDate?: string;

  /**
   * 结束日期
   */
  endDate?: string;

  /**
   * 状态（0正常 1停用）
   */
  status?: string;

  /**
   * 审批状态（0待审批 1已审批 2驳回）
   */
  approvalStatus?: string;

  /**
   * 删除标志（0代表存在 1代表删除）
   */
  delFlag?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
