export interface QcIndicatorFactorVO {
  /**
   * 因子类型：numerator-分子，denominator-分母
   */
  factorType: string;

  /**
   * 因子名称
   */
  factorName: string;

  /**
   * 因子代码
   */
  factorCode: string;

  /**
   * 因子描述
   */
  description: string;

  /**
   * 数据来源
   */
  dataSource: string;

  /**
   * 排序
   */
  sortOrder: number;

  /**
   * 是否删除
   */
  delFlag?: string;
}

export interface QcIndicatorFactorForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 指标ID
   */
  indicatorId?: string | number;

  /**
   * 因子类型：numerator-分子，denominator-分母
   */
  factorType?: string;

  /**
   * 因子名称
   */
  factorName?: string;

  /**
   * 因子代码
   */
  factorCode?: string;

  /**
   * 因子描述
   */
  description?: string;

  /**
   * 数据来源
   */
  dataSource?: string;

  /**
   * 排序
   */
  sortOrder?: number;

  /**
   * 是否删除
   */
  delFlag?: string;
}

export interface QcIndicatorFactorQuery extends PageQuery {
  /**
   * 因子类型：numerator-分子，denominator-分母
   */
  factorType?: string;

  /**
   * 因子名称
   */
  factorName?: string;

  /**
   * 因子代码
   */
  factorCode?: string;

  /**
   * 因子描述
   */
  description?: string;

  /**
   * 数据来源
   */
  dataSource?: string;

  /**
   * 排序
   */
  sortOrder?: number;

  /**
   * 是否删除
   */
  delFlag?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
