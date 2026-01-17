export interface ExamRecordVO {
  /**
   * 主键ID
   */
  id: string | number;

  /**
   * 考试安排ID
   */
  examId: string | number;

  /**
   * 考生ID
   */
  examineeId: string | number;

  /**
   * 考生姓名
   */
  examineeName: string;

  /**
   * 试卷ID
   */
  paperId: string | number;

  /**
   * 开始时间
   */
  startTime: string;

  /**
   * 提交时间
   */
  submitTime: string;

  /**
   * 答题卡JSON
   */
  answerSheet: string;

  /**
   * 客观题得分
   */
  objectiveScore: number;

  /**
   * 主观题得分
   */
  subjectiveScore: number;

  /**
   * 总分
   */
  totalScore: number;

  /**
   * 考试结果 及格/不及格
   */
  examResult: string;

  /**
   * 阅卷状态
   */
  markingStatus: string;

  /**
   * 阅卷人
   */
  marker: string;

  /**
   * 阅卷时间
   */
  markingTime: string;
}

export interface ExamRecordForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 考试安排ID
   */
  examId?: string | number;

  /**
   * 考生ID
   */
  examineeId?: string | number;

  /**
   * 考生姓名
   */
  examineeName?: string;

  /**
   * 试卷ID
   */
  paperId?: string | number;

  /**
   * 开始时间
   */
  startTime?: string;

  /**
   * 提交时间
   */
  submitTime?: string;

  /**
   * 答题卡JSON
   */
  answerSheet?: string;

  /**
   * 客观题得分
   */
  objectiveScore?: number;

  /**
   * 主观题得分
   */
  subjectiveScore?: number;

  /**
   * 总分
   */
  totalScore?: number;

  /**
   * 考试结果 及格/不及格
   */
  examResult?: string;

  /**
   * 阅卷状态
   */
  markingStatus?: string;

  /**
   * 阅卷人
   */
  marker?: string;

  /**
   * 阅卷时间
   */
  markingTime?: string;
}

export interface ExamRecordQuery extends PageQuery {
  /**
   * 考试安排ID
   */
  examId?: string | number;

  /**
   * 考生ID
   */
  examineeId?: string | number;

  /**
   * 考生姓名
   */
  examineeName?: string;

  /**
   * 试卷ID
   */
  paperId?: string | number;

  /**
   * 开始时间
   */
  startTime?: string;

  /**
   * 提交时间
   */
  submitTime?: string;

  /**
   * 答题卡JSON
   */
  answerSheet?: string;

  /**
   * 客观题得分
   */
  objectiveScore?: number;

  /**
   * 主观题得分
   */
  subjectiveScore?: number;

  /**
   * 总分
   */
  totalScore?: number;

  /**
   * 考试结果 及格/不及格
   */
  examResult?: string;

  /**
   * 阅卷状态
   */
  markingStatus?: string;

  /**
   * 阅卷人
   */
  marker?: string;

  /**
   * 阅卷时间
   */
  markingTime?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
