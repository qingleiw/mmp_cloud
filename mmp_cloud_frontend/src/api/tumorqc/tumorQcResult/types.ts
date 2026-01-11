export interface TumorQcResultVO {
  /**
   * 结果编码
   */
  resultCode: string;

  /**
   * 指标名称
   */
  indicatorName: string;

  /**
   * 结果值
   */
  resultValue: number;

  /**
   * 目标值
   */
  targetValue: number;

  /**
   * 达标率
   */
  complianceRate: number;

  /**
   * 结果分析
   */
  analysis: string;

  /**
   * 统计周期开始
   */
  periodStart: string;

  /**
   * 统计周期结束
   */
  periodEnd: string;

  /**
   * 状态（0正常 1异常）
   */
  status: string;

  /**
   * 删除标志（0代表存在 1代表删除）
   */
  delFlag: string;
}

export interface TumorQcResultForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 结果编码
   */
  resultCode?: string;

  /**
   * 关联方案ID
   */
  planId?: string | number;

  /**
   * 指标ID
   */
  indicatorId?: string | number;

  /**
   * 指标名称
   */
  indicatorName?: string;

  /**
   * 结果值
   */
  resultValue?: number;

  /**
   * 目标值
   */
  targetValue?: number;

  /**
   * 达标率
   */
  complianceRate?: number;

  /**
   * 结果分析
   */
  analysis?: string;

  /**
   * 统计周期开始
   */
  periodStart?: string;

  /**
   * 统计周期结束
   */
  periodEnd?: string;

  /**
   * 状态（0正常 1异常）
   */
  status?: string;

  /**
   * 删除标志（0代表存在 1代表删除）
   */
  delFlag?: string;
}

export interface TumorQcResultQuery extends PageQuery {
  /**
   * 结果编码
   */
  resultCode?: string;

  /**
   * 指标名称
   */
  indicatorName?: string;

  /**
   * 结果值
   */
  resultValue?: number;

  /**
   * 目标值
   */
  targetValue?: number;

  /**
   * 达标率
   */
  complianceRate?: number;

  /**
   * 结果分析
   */
  analysis?: string;

  /**
   * 统计周期开始
   */
  periodStart?: string;

  /**
   * 统计周期结束
   */
  periodEnd?: string;

  /**
   * 状态（0正常 1异常）
   */
  status?: string;

  /**
   * 删除标志（0代表存在 1代表删除）
   */
  delFlag?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
