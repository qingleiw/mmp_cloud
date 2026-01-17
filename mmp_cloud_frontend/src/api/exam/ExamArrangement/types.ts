export interface ExamArrangementVO {
  /**
   * 主键ID
   */
  id: string | number;

  /**
   * 考试编号
   */
  examCode: string;

  /**
   * 考试名称
   */
  examName: string;

  /**
   * 试卷ID
   */
  paperId: string | number;

  /**
   * 资质ID
   */
  qualificationId: string | number;

  /**
   * 考试开始时间
   */
  examStartTime: string;

  /**
   * 考试结束时间
   */
  examEndTime: string;

  /**
   * 考生ID列表
   */
  examineeIds: string | number;

  /**
   * 考试状态 未开始/进行中/已结束
   */
  examStatus: string;

  /**
   * 是否删除
   */
  delFlag?: string;
}

export interface ExamArrangementForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 考试编号
   */
  examCode?: string;

  /**
   * 考试名称
   */
  examName?: string;

  /**
   * 试卷ID
   */
  paperId?: string | number;

  /**
   * 资质ID
   */
  qualificationId?: string | number;

  /**
   * 考试开始时间
   */
  examStartTime?: string;

  /**
   * 考试结束时间
   */
  examEndTime?: string;

  /**
   * 考生ID列表
   */
  examineeIds?: string | number;

  /**
   * 考试状态 未开始/进行中/已结束
   */
  examStatus?: string;

  /**
   * 是否删除
   */
  delFlag?: string;
}

export interface ExamArrangementQuery extends PageQuery {
  /**
   * 考试编号
   */
  examCode?: string;

  /**
   * 考试名称
   */
  examName?: string;

  /**
   * 试卷ID
   */
  paperId?: string | number;

  /**
   * 资质ID
   */
  qualificationId?: string | number;

  /**
   * 考试开始时间
   */
  examStartTime?: string;

  /**
   * 考试结束时间
   */
  examEndTime?: string;

  /**
   * 考生ID列表
   */
  examineeIds?: string | number;

  /**
   * 考试状态 未开始/进行中/已结束
   */
  examStatus?: string;

  /**
   * 是否删除
   */
  delFlag?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
