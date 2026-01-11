export interface TumorQcReportVO {
  /**
   * 主键ID
   */
  id: string | number;

  /**
   * 报告编码
   */
  reportCode: string;

  /**
   * 报告标题
   */
  reportTitle: string;

  /**
   * 报告类型
   */
  reportType: string;

  /**
   * 报告周期开始
   */
  periodStart: string;

  /**
   * 报告周期结束
   */
  periodEnd: string;

  /**
   * 报告内容
   */
  reportContent: string;

  /**
   * 报告摘要
   */
  summary: string;

  /**
   * 建议措施
   */
  recommendations: string;

  /**
   * 状态（0草稿 1已发布）
   */
  status: string;

  /**
   * 发布时间
   */
  publishTime: string;

  /**
   * 删除标志（0代表存在 1代表删除）
   */
  delFlag: string;
}

export interface TumorQcReportForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 报告编码
   */
  reportCode?: string;

  /**
   * 报告标题
   */
  reportTitle?: string;

  /**
   * 报告类型
   */
  reportType?: string;

  /**
   * 关联方案ID
   */
  planId?: string | number;

  /**
   * 报告周期开始
   */
  periodStart?: string;

  /**
   * 报告周期结束
   */
  periodEnd?: string;

  /**
   * 报告内容
   */
  reportContent?: string;

  /**
   * 报告摘要
   */
  summary?: string;

  /**
   * 建议措施
   */
  recommendations?: string;

  /**
   * 状态（0草稿 1已发布）
   */
  status?: string;

  /**
   * 发布时间
   */
  publishTime?: string;

  /**
   * 删除标志（0代表存在 1代表删除）
   */
  delFlag?: string;
}

export interface TumorQcReportQuery extends PageQuery {
  /**
   * 报告编码
   */
  reportCode?: string;

  /**
   * 报告标题
   */
  reportTitle?: string;

  /**
   * 报告类型
   */
  reportType?: string;

  /**
   * 报告周期开始
   */
  periodStart?: string;

  /**
   * 报告周期结束
   */
  periodEnd?: string;

  /**
   * 报告内容
   */
  reportContent?: string;

  /**
   * 报告摘要
   */
  summary?: string;

  /**
   * 建议措施
   */
  recommendations?: string;

  /**
   * 状态（0草稿 1已发布）
   */
  status?: string;

  /**
   * 发布时间
   */
  publishTime?: string;

  /**
   * 删除标志（0代表存在 1代表删除）
   */
  delFlag?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
