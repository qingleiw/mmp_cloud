export interface DeathCaseDiscussionVO {
  /**
   * 患者姓名
   */
  patientName: string;

  /**
   * 患者年龄
   */
  patientAge: number;

  /**
   * 患者性别：1-男，2-女
   */
  patientGender: number;

  /**
   * 死亡日期
   */
  deathDate: string;

  /**
   * 死亡原因
   */
  deathReason: string;

  /**
   * 讨论主持人姓名
   */
  moderatorName: string;

  /**
   * 讨论日期
   */
  discussionDate: string;

  /**
   * 讨论内容和结论
   */
  discussionContent: string;

  /**
   * 参与讨论的人员名单
   */
  participants: string;

  /**
   * 参与人数
   */
  participantCount: number;

  /**
   * 状态：0-进行中，1-已完成
   */
  status: number;

  /**
   * 是否删除 0-否 1-是
   */
  isDeleted: number;
}

export interface DeathCaseDiscussionForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 患者姓名
   */
  patientName?: string;

  /**
   * 患者年龄
   */
  patientAge?: number;

  /**
   * 患者性别：1-男，2-女
   */
  patientGender?: number;

  /**
   * 死亡日期
   */
  deathDate?: string;

  /**
   * 死亡原因
   */
  deathReason?: string;

  /**
   * 讨论主持人姓名
   */
  moderatorName?: string;

  /**
   * 讨论日期
   */
  discussionDate?: string;

  /**
   * 讨论内容和结论
   */
  discussionContent?: string;

  /**
   * 参与讨论的人员名单
   */
  participants?: string;

  /**
   * 参与人数
   */
  participantCount?: number;

  /**
   * 状态：0-进行中，1-已完成
   */
  status?: number;

  /**
   * 是否删除 0-否 1-是
   */
  isDeleted?: number;
}

export interface DeathCaseDiscussionQuery extends PageQuery {
  /**
   * 患者姓名
   */
  patientName?: string;

  /**
   * 患者年龄
   */
  patientAge?: number;

  /**
   * 患者性别：1-男，2-女
   */
  patientGender?: number;

  /**
   * 死亡日期
   */
  deathDate?: string;

  /**
   * 死亡原因
   */
  deathReason?: string;

  /**
   * 讨论主持人姓名
   */
  moderatorName?: string;

  /**
   * 讨论日期
   */
  discussionDate?: string;

  /**
   * 讨论内容和结论
   */
  discussionContent?: string;

  /**
   * 参与讨论的人员名单
   */
  participants?: string;

  /**
   * 参与人数
   */
  participantCount?: number;

  /**
   * 状态：0-进行中，1-已完成
   */
  status?: number;

  /**
   * 是否删除 0-否 1-是
   */
  isDeleted?: number;

  /**
   * 日期范围参数
   */
  params?: any;
}
