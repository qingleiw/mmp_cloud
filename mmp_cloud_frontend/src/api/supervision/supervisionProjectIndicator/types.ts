export interface SupervisionProjectIndicatorVO {
  /**
   * 指标编码
   */
  indicatorCode: string;

  /**
   * 指标名称
   */
  indicatorName: string;

  /**
   * 指标类型
   */
  indicatorType: string;

  /**
   * 指标描述
   */
  indicatorDescription: string;

  /**
   * 评分标准
   */
  scoringStandard: string;

  /**
   * 权重
   */
  weight: number;

  /**
   * 满分值
   */
  maxScore: number;

  /**
   * 排序
   */
  sortOrder: number;

  /**
   * 状态
   */
  status: string;

  /**
   * 备注
   */
  remark: string;
}

export interface SupervisionProjectIndicatorForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 项目ID
   */
  projectId?: string | number;

  /**
   * 指标编码
   */
  indicatorCode?: string;

  /**
   * 指标名称
   */
  indicatorName?: string;

  /**
   * 指标类型
   */
  indicatorType?: string;

  /**
   * 指标描述
   */
  indicatorDescription?: string;

  /**
   * 评分标准
   */
  scoringStandard?: string;

  /**
   * 权重
   */
  weight?: number;

  /**
   * 满分值
   */
  maxScore?: number;

  /**
   * 排序
   */
  sortOrder?: number;

  /**
   * 状态
   */
  status?: string;

  /**
   * 备注
   */
  remark?: string;
}

export interface SupervisionProjectIndicatorQuery extends PageQuery {
  /**
   * 指标编码
   */
  indicatorCode?: string;

  /**
   * 指标名称
   */
  indicatorName?: string;

  /**
   * 指标类型
   */
  indicatorType?: string;

  /**
   * 指标描述
   */
  indicatorDescription?: string;

  /**
   * 评分标准
   */
  scoringStandard?: string;

  /**
   * 权重
   */
  weight?: number;

  /**
   * 满分值
   */
  maxScore?: number;

  /**
   * 排序
   */
  sortOrder?: number;

  /**
   * 状态
   */
  status?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
