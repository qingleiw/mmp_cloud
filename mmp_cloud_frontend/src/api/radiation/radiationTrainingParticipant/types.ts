export interface RadiationTrainingParticipantVO {
  /**
   * 工作人员姓名
   */
  staffName: string;

  /**
   * 出席状态：registered-已报名，attended-出席，absent-缺席
   */
  attendanceStatus: string;

  /**
   * 培训成绩
   */
  score: number;

  /**
   * 评价
   */
  evaluation: string;

  /**
   * 是否发放证书：0-否，1-是
   */
  certificateIssued: string;

  /**
   * 证书编号
   */
  certificateNumber: string;

  /**
   * 备注
   */
  remark: string;
}

export interface RadiationTrainingParticipantForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 培训计划ID
   */
  planId?: string | number;

  /**
   * 工作人员ID
   */
  staffId?: string | number;

  /**
   * 工作人员姓名
   */
  staffName?: string;

  /**
   * 出席状态：registered-已报名，attended-出席，absent-缺席
   */
  attendanceStatus?: string;

  /**
   * 培训成绩
   */
  score?: number;

  /**
   * 评价
   */
  evaluation?: string;

  /**
   * 是否发放证书：0-否，1-是
   */
  certificateIssued?: string;

  /**
   * 证书编号
   */
  certificateNumber?: string;

  /**
   * 备注
   */
  remark?: string;
}

export interface RadiationTrainingParticipantQuery extends PageQuery {
  /**
   * 工作人员姓名
   */
  staffName?: string;

  /**
   * 出席状态：registered-已报名，attended-出席，absent-缺席
   */
  attendanceStatus?: string;

  /**
   * 培训成绩
   */
  score?: number;

  /**
   * 评价
   */
  evaluation?: string;

  /**
   * 是否发放证书：0-否，1-是
   */
  certificateIssued?: string;

  /**
   * 证书编号
   */
  certificateNumber?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
