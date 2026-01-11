export interface QcQualityIndicatorVO {
  /**
   * 指标编码
   */
  indicatorCode: string;

  /**
   * 指标名称
   */
  indicatorName: string;

  /**
   * 指标层级
   */
  indicatorLevel: number;

  /**
   * 定义
   */
  definition: string;

  /**
   * 计算公式
   */
  formula: string;

  /**
   * 意义
   */
  significance: string;

  /**
   * 说明
   */
  remark: string;

  /**
   * 单位
   */
  unit: string;

  /**
   * 数据类型：rate-比率，count-计数，ratio-比值
   */
  dataType: string;

  /**
   * 标准值
   */
  standardValue: number;

  /**
   * 满分分值
   */
  maxScore: number;

  /**
   * 排序
   */
  sortOrder: number;

  /**
   * 状态：1-启用，0-禁用
   */
  status: number;

  /**
   * 是否删除
   */
  delFlag?: string;
}

export interface QcQualityIndicatorForm extends BaseEntity {
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
   * 所属专业ID
   */
  categoryId?: string | number;

  /**
   * 父指标ID（用于分级指标）
   */
  parentId?: string | number;

  /**
   * 指标层级
   */
  indicatorLevel?: number;

  /**
   * 定义
   */
  definition?: string;

  /**
   * 计算公式
   */
  formula?: string;

  /**
   * 意义
   */
  significance?: string;

  /**
   * 说明
   */
  remark?: string;

  /**
   * 单位
   */
  unit?: string;

  /**
   * 数据类型：rate-比率，count-计数，ratio-比值
   */
  dataType?: string;

  /**
   * 标准值
   */
  standardValue?: number;

  /**
   * 满分分值
   */
  maxScore?: number;

  /**
   * 排序
   */
  sortOrder?: number;

  /**
   * 状态：1-启用，0-禁用
   */
  status?: number;

  /**
   * 是否删除
   */
  delFlag?: string;
}

export interface QcQualityIndicatorQuery extends PageQuery {
  /**
   * 指标编码
   */
  indicatorCode?: string;

  /**
   * 指标名称
   */
  indicatorName?: string;

  /**
   * 指标层级
   */
  indicatorLevel?: number;

  /**
   * 定义
   */
  definition?: string;

  /**
   * 计算公式
   */
  formula?: string;

  /**
   * 意义
   */
  significance?: string;

  /**
   * 单位
   */
  unit?: string;

  /**
   * 数据类型：rate-比率，count-计数，ratio-比值
   */
  dataType?: string;

  /**
   * 标准值
   */
  standardValue?: number;

  /**
   * 满分分值
   */
  maxScore?: number;

  /**
   * 排序
   */
  sortOrder?: number;

  /**
   * 状态：1-启用，0-禁用
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
