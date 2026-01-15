export interface NewTechnologyProjectAssessmentVO {
  /**
   * 考核年份
   */
  assessmentYear: number;

  /**
   * 考核类型：midterm-中期考核，final-结题考核，annual-年度考核
   */
  assessmentType: string;

  /**
   * 考核日期
   */
  assessmentDate: string;

  /**
   * 考核人
   */
  assessor: string;

  /**
   * 考核结果：excellent-优秀，good-良好，qualified-合格，unqualified-不合格
   */
  assessmentResult: string;

  /**
   * 评分
   */
  score: number;

  /**
   * 考核意见
   */
  assessmentOpinion: string;

  /**
   * 改进措施
   */
  improvementMeasures: string;

  /**
   * 状态
   */
  status: string;

  /**
   * 备注
   */
  remark: string;
}

export interface NewTechnologyProjectAssessmentForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 项目ID
   */
  projectId?: string | number;

  /**
   * 考核年份
   */
  assessmentYear?: number;

  /**
   * 考核类型：midterm-中期考核，final-结题考核，annual-年度考核
   */
  assessmentType?: string;

  /**
   * 考核日期
   */
  assessmentDate?: string;

  /**
   * 考核人
   */
  assessor?: string;

  /**
   * 考核结果：excellent-优秀，good-良好，qualified-合格，unqualified-不合格
   */
  assessmentResult?: string;

  /**
   * 评分
   */
  score?: number;

  /**
   * 考核意见
   */
  assessmentOpinion?: string;

  /**
   * 改进措施
   */
  improvementMeasures?: string;

  /**
   * 状态
   */
  status?: string;

  /**
   * 备注
   */
  remark?: string;
}

export interface NewTechnologyProjectAssessmentQuery extends PageQuery {
  /**
   * 考核年份
   */
  assessmentYear?: number;

  /**
   * 考核类型：midterm-中期考核，final-结题考核，annual-年度考核
   */
  assessmentType?: string;

  /**
   * 考核日期
   */
  assessmentDate?: string;

  /**
   * 考核人
   */
  assessor?: string;

  /**
   * 考核结果：excellent-优秀，good-良好，qualified-合格，unqualified-不合格
   */
  assessmentResult?: string;

  /**
   * 评分
   */
  score?: number;

  /**
   * 考核意见
   */
  assessmentOpinion?: string;

  /**
   * 改进措施
   */
  improvementMeasures?: string;

  /**
   * 状态
   */
  status?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
