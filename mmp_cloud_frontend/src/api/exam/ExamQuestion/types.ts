export interface ExamQuestionVO {
  /**
   * 主键ID
   */
  id: string | number;

  /**
   * 题目编号
   */
  questionCode: string;

  /**
   * 关联资质ID
   */
  qualificationId: string | number;

  /**
   * 题型 单选/多选/判断/简答
   */
  questionType: string;

  /**
   * 题目内容
   */
  questionContent: string;

  /**
   * 选项A
   */
  optionA: string;

  /**
   * 选项B
   */
  optionB: string;

  /**
   * 选项C
   */
  optionC: string;

  /**
   * 选项D
   */
  optionD: string;

  /**
   * 选项E
   */
  optionE: string;

  /**
   * 正确答案
   */
  correctAnswer: string;

  /**
   * 答案解析
   */
  answerAnalysis: string;

  /**
   * 难度级别 1-易 2-中 3-难
   */
  difficultyLevel: number;

  /**
   * 分值
   */
  score: number;

  /**
   * 是否启用
   */
  isEnabled: number;

  /**
   * 是否删除
   */
  delFlag?: string;
}

export interface ExamQuestionForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 题目编号
   */
  questionCode?: string;

  /**
   * 关联资质ID
   */
  qualificationId?: string | number;

  /**
   * 题型 单选/多选/判断/简答
   */
  questionType?: string;

  /**
   * 题目内容
   */
  questionContent?: string;

  /**
   * 选项A
   */
  optionA?: string;

  /**
   * 选项B
   */
  optionB?: string;

  /**
   * 选项C
   */
  optionC?: string;

  /**
   * 选项D
   */
  optionD?: string;

  /**
   * 选项E
   */
  optionE?: string;

  /**
   * 正确答案
   */
  correctAnswer?: string;

  /**
   * 答案解析
   */
  answerAnalysis?: string;

  /**
   * 难度级别 1-易 2-中 3-难
   */
  difficultyLevel?: number;

  /**
   * 分值
   */
  score?: number;

  /**
   * 是否启用
   */
  isEnabled?: number;

  /**
   * 是否删除
   */
  delFlag?: string;
}

export interface ExamQuestionQuery extends PageQuery {
  /**
   * 题目编号
   */
  questionCode?: string;

  /**
   * 关联资质ID
   */
  qualificationId?: string | number;

  /**
   * 题型 单选/多选/判断/简答
   */
  questionType?: string;

  /**
   * 题目内容
   */
  questionContent?: string;

  /**
   * 选项A
   */
  optionA?: string;

  /**
   * 选项B
   */
  optionB?: string;

  /**
   * 选项C
   */
  optionC?: string;

  /**
   * 选项D
   */
  optionD?: string;

  /**
   * 选项E
   */
  optionE?: string;

  /**
   * 正确答案
   */
  correctAnswer?: string;

  /**
   * 答案解析
   */
  answerAnalysis?: string;

  /**
   * 难度级别 1-易 2-中 3-难
   */
  difficultyLevel?: number;

  /**
   * 分值
   */
  score?: number;

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
