export interface QcScoringResultVO {
  /**
   * 指标值
   */
  indicatorValue: number;

  /**
   * 标准值
   */
  standardValue: number;

  /**
   * 满分
   */
  maxScore: number;

  /**
   * 实际得分
   */
  actualScore: number;

  /**
   * 得分率
   */
  scoreRate: number;

  /**
   * 评价等级：excellent-优秀，good-良好，qualified-合格，unqualified-不合格
   */
  evaluationLevel: string;

  /**
   * 计算时间
   */
  calculateTime: string;

  /**
   * 是否删除
   */
  delFlag: string;
}

export interface QcScoringResultForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 采集记录ID
   */
  collectionId?: string | number;

  /**
   * 指标ID
   */
  indicatorId?: string | number;

  /**
   * 指标值
   */
  indicatorValue?: number;

  /**
   * 标准值
   */
  standardValue?: number;

  /**
   * 满分
   */
  maxScore?: number;

  /**
   * 实际得分
   */
  actualScore?: number;

  /**
   * 得分率
   */
  scoreRate?: number;

  /**
   * 评价等级：excellent-优秀，good-良好，qualified-合格，unqualified-不合格
   */
  evaluationLevel?: string;

  /**
   * 计算时间
   */
  calculateTime?: string;

  /**
   * 是否删除
   */
  delFlag?: string;
}

export interface QcScoringResultQuery extends PageQuery {
  /**
   * 指标值
   */
  indicatorValue?: number;

  /**
   * 标准值
   */
  standardValue?: number;

  /**
   * 满分
   */
  maxScore?: number;

  /**
   * 实际得分
   */
  actualScore?: number;

  /**
   * 得分率
   */
  scoreRate?: number;

  /**
   * 评价等级：excellent-优秀，good-良好，qualified-合格，unqualified-不合格
   */
  evaluationLevel?: string;

  /**
   * 计算时间
   */
  calculateTime?: string;

  /**
   * 是否删除
   */
  delFlag?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
