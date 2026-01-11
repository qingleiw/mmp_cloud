export interface CoreSystemIndicatorVO {
  /**
   * 主键ID
   */
  id: string | number;

  /**
   * 指标编码
   */
  indicatorCode: string;

  /**
   * 指标名称
   */
  indicatorName: string;

  /**
   * 所属制度ID
   */
  systemId: string | number;

  /**
   * 父指标ID
   */
  parentId: string | number;

  /**
   * 指标类型 数量指标/率指标/时间指标
   */
  indicatorType: string;

  /**
   * 计算公式
   */
  calculationFormula: string;

  /**
   * 计算周期 日/周/月/季度/年
   */
  calculationCycle: string;

  /**
   * 数据来源
   */
  dataSource: string;

  /**
   * 目标值
   */
  targetValue: string;

  /**
   * 指标分值
   */
  indicatorScore: number;

  /**
   * 是否反向指标 1-是 0-否
   */
  isReverse: number;

  /**
   * 预警阈值
   */
  alertThreshold: string;

  /**
   * 是否启用
   */
  isEnabled: number;

  /**
   * 是否自定义
   */
  isCustom: number;

  /**
   * 是否删除
   */
  delFlag?: string;
}

export interface CoreSystemIndicatorForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 指标编码
   */
  indicatorCode?: string;

  /**
   * 指标名称
   */
  indicatorName?: string;

  /**
   * 所属制度ID
   */
  systemId?: string | number;

  /**
   * 父指标ID
   */
  parentId?: string | number;

  /**
   * 指标类型 数量指标/率指标/时间指标
   */
  indicatorType?: string;

  /**
   * 计算公式
   */
  calculationFormula?: string;

  /**
   * 计算周期 日/周/月/季度/年
   */
  calculationCycle?: string;

  /**
   * 数据来源
   */
  dataSource?: string;

  /**
   * 目标值
   */
  targetValue?: string;

  /**
   * 指标分值
   */
  indicatorScore?: number;

  /**
   * 是否反向指标 1-是 0-否
   */
  isReverse?: number;

  /**
   * 预警阈值
   */
  alertThreshold?: string;

  /**
   * 是否启用
   */
  isEnabled?: number;

  /**
   * 是否自定义
   */
  isCustom?: number;

  /**
   * 是否删除
   */
  delFlag?: string;
}

export interface CoreSystemIndicatorQuery extends PageQuery {
  /**
   * 指标编码
   */
  indicatorCode?: string;

  /**
   * 指标名称
   */
  indicatorName?: string;

  /**
   * 所属制度ID
   */
  systemId?: string | number;

  /**
   * 父指标ID
   */
  parentId?: string | number;

  /**
   * 指标类型 数量指标/率指标/时间指标
   */
  indicatorType?: string;

  /**
   * 计算公式
   */
  calculationFormula?: string;

  /**
   * 计算周期 日/周/月/季度/年
   */
  calculationCycle?: string;

  /**
   * 数据来源
   */
  dataSource?: string;

  /**
   * 目标值
   */
  targetValue?: string;

  /**
   * 指标分值
   */
  indicatorScore?: number;

  /**
   * 是否反向指标 1-是 0-否
   */
  isReverse?: number;

  /**
   * 预警阈值
   */
  alertThreshold?: string;

  /**
   * 是否启用
   */
  isEnabled?: number;

  /**
   * 是否自定义
   */
  isCustom?: number;

  /**
   * 是否删除
   */
  delFlag?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
