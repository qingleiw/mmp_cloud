export interface SupervisionPlanVO {
  /**
   * 计划编码
   */
  planCode: string;

  /**
   * 计划名称
   */
  planName: string;

  /**
   * 计划类型
   */
  planType: string;

  /**
   * 督导周期
   */
  supervisionPeriod: string;

  /**
   * 开始日期
   */
  startDate: string;

  /**
   * 结束日期
   */
  endDate: string;

  /**
   * 负责人
   */
  responsiblePerson: string;

  /**
   * 状态：draft-草稿，published-已发布，executing-执行中，completed-已完成
   */
  status: string;

  /**
   * 备注
   */
  remark: string;
}

export interface SupervisionPlanForm extends BaseEntity {
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
   * 项目ID
   */
  projectId?: string | number;

  /**
   * 计划类型
   */
  planType?: string;

  /**
   * 督导周期
   */
  supervisionPeriod?: string;

  /**
   * 开始日期
   */
  startDate?: string;

  /**
   * 结束日期
   */
  endDate?: string;

  /**
   * 负责人
   */
  responsiblePerson?: string;

  /**
   * 状态：draft-草稿，published-已发布，executing-执行中，completed-已完成
   */
  status?: string;

  /**
   * 备注
   */
  remark?: string;
}

export interface SupervisionPlanQuery extends PageQuery {
  /**
   * 计划编码
   */
  planCode?: string;

  /**
   * 计划名称
   */
  planName?: string;

  /**
   * 计划类型
   */
  planType?: string;

  /**
   * 督导周期
   */
  supervisionPeriod?: string;

  /**
   * 开始日期
   */
  startDate?: string;

  /**
   * 结束日期
   */
  endDate?: string;

  /**
   * 负责人
   */
  responsiblePerson?: string;

  /**
   * 状态：draft-草稿，published-已发布，executing-执行中，completed-已完成
   */
  status?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
