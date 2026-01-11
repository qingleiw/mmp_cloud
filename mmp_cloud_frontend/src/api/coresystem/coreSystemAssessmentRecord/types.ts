export interface CoreSystemAssessmentRecordVO {
  /**
   * 主键ID
   */
  id: string | number;

  /**
   * 制度名称
   */
  systemName: string;

  /**
   * 考核人名称
   */
  assessorName: string;

  /**
   * 考核时间
   */
  assessmentTime: string;

  /**
   * 考核周期(monthly:月度,quarterly:季度,half-yearly:半年度,yearly:年度)
   */
  assessmentCycle: string;

  /**
   * 考核分数
   */
  assessmentScore: number;

  /**
   * 考核等级(A:优秀,B:良好,C:合格,D:不合格)
   */
  assessmentGrade: string;

  /**
   * 考核结果
   */
  assessmentResult: string;

  /**
   * 考核意见
   */
  assessmentOpinion: string;

  /**
   * 删除标志(0:未删除,1:已删除)
   */
  delFlag: string;
}

export interface CoreSystemAssessmentRecordForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 考核ID
   */
  assessmentId?: string | number;

  /**
   * 制度ID
   */
  systemId?: string | number;

  /**
   * 制度名称
   */
  systemName?: string;

  /**
   * 考核人ID
   */
  assessorId?: string | number;

  /**
   * 考核人名称
   */
  assessorName?: string;

  /**
   * 考核时间
   */
  assessmentTime?: string;

  /**
   * 考核周期(monthly:月度,quarterly:季度,half-yearly:半年度,yearly:年度)
   */
  assessmentCycle?: string;

  /**
   * 考核分数
   */
  assessmentScore?: number;

  /**
   * 考核等级(A:优秀,B:良好,C:合格,D:不合格)
   */
  assessmentGrade?: string;

  /**
   * 考核结果
   */
  assessmentResult?: string;

  /**
   * 考核意见
   */
  assessmentOpinion?: string;

  /**
   * 删除标志(0:未删除,1:已删除)
   */
  delFlag?: string;
}

export interface CoreSystemAssessmentRecordQuery extends PageQuery {
  /**
   * 制度名称
   */
  systemName?: string;

  /**
   * 考核人名称
   */
  assessorName?: string;

  /**
   * 考核时间
   */
  assessmentTime?: string;

  /**
   * 考核周期(monthly:月度,quarterly:季度,half-yearly:半年度,yearly:年度)
   */
  assessmentCycle?: string;

  /**
   * 考核分数
   */
  assessmentScore?: number;

  /**
   * 考核等级(A:优秀,B:良好,C:合格,D:不合格)
   */
  assessmentGrade?: string;

  /**
   * 考核结果
   */
  assessmentResult?: string;

  /**
   * 考核意见
   */
  assessmentOpinion?: string;

  /**
   * 删除标志(0:未删除,1:已删除)
   */
  delFlag?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
