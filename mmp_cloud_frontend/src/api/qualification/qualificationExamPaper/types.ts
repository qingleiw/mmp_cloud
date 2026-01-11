export interface QualificationExamPaperVO {
  /**
   * 主键ID
   */
  id: string | number;

  /**
   * 试卷编号
   */
  paperCode: string;

  /**
   * 试卷名称
   */
  paperName: string;

  /**
   * 关联资质ID
   */
  qualificationId: string | number;

  /**
   * 总分
   */
  totalScore: number;

  /**
   * 及格分
   */
  passScore: number;

  /**
   * 考试时长(分钟)
   */
  examDuration: number;

  /**
   * 题目ID列表JSON
   */
  questionIds: string | number;

  /**
   * 是否随机抽题 1-是 0-否
   */
  isRandom: number;

  /**
   * 随机规则JSON
   */
  randomRule: string;

  /**
   * 是否启用
   */
  isEnabled: number;

  /**
   * 是否删除
   */
  delFlag?: string;
}

export interface QualificationExamPaperForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 试卷编号
   */
  paperCode?: string;

  /**
   * 试卷名称
   */
  paperName?: string;

  /**
   * 关联资质ID
   */
  qualificationId?: string | number;

  /**
   * 总分
   */
  totalScore?: number;

  /**
   * 及格分
   */
  passScore?: number;

  /**
   * 考试时长(分钟)
   */
  examDuration?: number;

  /**
   * 题目ID列表JSON
   */
  questionIds?: string | number;

  /**
   * 是否随机抽题 1-是 0-否
   */
  isRandom?: number;

  /**
   * 随机规则JSON
   */
  randomRule?: string;

  /**
   * 是否启用
   */
  isEnabled?: number;

  /**
   * 是否删除
   */
  delFlag?: string;
}

export interface QualificationExamPaperQuery extends PageQuery {
  /**
   * 试卷编号
   */
  paperCode?: string;

  /**
   * 试卷名称
   */
  paperName?: string;

  /**
   * 关联资质ID
   */
  qualificationId?: string | number;

  /**
   * 总分
   */
  totalScore?: number;

  /**
   * 及格分
   */
  passScore?: number;

  /**
   * 考试时长(分钟)
   */
  examDuration?: number;

  /**
   * 题目ID列表JSON
   */
  questionIds?: string | number;

  /**
   * 是否随机抽题 1-是 0-否
   */
  isRandom?: number;

  /**
   * 随机规则JSON
   */
  randomRule?: string;

  /**
   * 是否启用
   */
  isEnabled?: number;

  /**
   * 是否删除
   */
  delFlag?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
