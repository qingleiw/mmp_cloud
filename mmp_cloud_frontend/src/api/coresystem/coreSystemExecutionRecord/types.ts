export interface CoreSystemExecutionRecordVO {
  /**
   * 制度名称
   */
  systemName: string;

  /**
   * 执行人姓名
   */
  executorName: string;

  /**
   * 执行时间
   */
  executionTime: string;

  /**
   * 执行结果 1-成功 0-失败
   */
  executionResult: string;

  /**
   * 备注
   */
  remark: string;

  /**
   * 是否删除 0-未删除 1-已删除
   */
  delFlag: string;
}

export interface CoreSystemExecutionRecordForm extends BaseEntity {
  /**
   * 执行ID
   */
  id?: string | number;

  /**
   * 制度ID
   */
  systemId?: string | number;

  /**
   * 制度名称
   */
  systemName?: string;

  /**
   * 执行人ID
   */
  executorId?: string | number;

  /**
   * 执行人姓名
   */
  executorName?: string;

  /**
   * 执行时间
   */
  executionTime?: string;

  /**
   * 执行结果 1-成功 0-失败
   */
  executionResult?: string;

  /**
   * 备注
   */
  remark?: string;

  /**
   * 是否删除 0-未删除 1-已删除
   */
  delFlag?: string;
}

export interface CoreSystemExecutionRecordQuery extends PageQuery {
  /**
   * 制度名称
   */
  systemName?: string;

  /**
   * 执行人姓名
   */
  executorName?: string;

  /**
   * 执行时间
   */
  executionTime?: string;

  /**
   * 执行结果 1-成功 0-失败
   */
  executionResult?: string;

  /**
   * 是否删除 0-未删除 1-已删除
   */
  delFlag?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
