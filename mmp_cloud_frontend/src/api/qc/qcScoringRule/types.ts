export interface QcScoringRuleVO {
  /**
   * 规则类型：range-区间，threshold-阈值
   */
  ruleType: string;

  /**
   * 最小值
   */
  minValue: number;

  /**
   * 最大值
   */
  maxValue: number;

  /**
   * 得分
   */
  score: number;

  /**
   * 得分率
   */
  scoreRate: number;

  /**
   * 规则描述
   */
  description: string;

  /**
   * 排序
   */
  sortOrder: number;

  /**
   * 状态
   */
  status: number;

  /**
   * 是否删除
   */
  delFlag?: string;
}

export interface QcScoringRuleForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 指标ID
   */
  indicatorId?: string | number;

  /**
   * 规则类型：range-区间，threshold-阈值
   */
  ruleType?: string;

  /**
   * 最小值
   */
  minValue?: number;

  /**
   * 最大值
   */
  maxValue?: number;

  /**
   * 得分
   */
  score?: number;

  /**
   * 得分率
   */
  scoreRate?: number;

  /**
   * 规则描述
   */
  description?: string;

  /**
   * 排序
   */
  sortOrder?: number;

  /**
   * 状态
   */
  status?: number;

  /**
   * 是否删除
   */
  delFlag?: string;
}

export interface QcScoringRuleQuery extends PageQuery {
  /**
   * 规则类型：range-区间，threshold-阈值
   */
  ruleType?: string;

  /**
   * 最小值
   */
  minValue?: number;

  /**
   * 最大值
   */
  maxValue?: number;

  /**
   * 得分
   */
  score?: number;

  /**
   * 得分率
   */
  scoreRate?: number;

  /**
   * 规则描述
   */
  description?: string;

  /**
   * 排序
   */
  sortOrder?: number;

  /**
   * 状态
   */
  status?: number;

  /**
   * 是否删除
   */
  delFlag?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
