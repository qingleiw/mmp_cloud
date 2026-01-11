export interface DoctorEthicsEvaluationVO {
  /**
   * 主键ID
   */
  id: string | number;

  /**
   * 医生ID
   */
  doctorId: string | number;

  /**
   * 医生姓名
   */
  doctorName: string;

  /**
   * 考评年度
   */
  evaluationYear: number;

  /**
   * 考评周期
   */
  evaluationCycle: string;

  /**
   * 自评得分
   */
  selfScore: number;

  /**
   * 同行评议得分
   */
  peerScore: number;

  /**
   * 患者评价得分
   */
  patientScore: number;

  /**
   * 科室评价得分
   */
  departmentScore: number;

  /**
   * 医院评价得分
   */
  hospitalScore: number;

  /**
   * 总分
   */
  totalScore: number;

  /**
   * 考评结果 优秀/良好/合格/不合格
   */
  evaluationResult: string;

  /**
   * 奖惩情况
   */
  rewardPunishment: string;

  /**
   * 考评意见
   */
  remark: string;

  /**
   * 是否删除
   */
  delFlag?: string;
}

export interface DoctorEthicsEvaluationForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 医生ID
   */
  doctorId?: string | number;

  /**
   * 考评年度
   */
  evaluationYear?: number;

  /**
   * 考评周期
   */
  evaluationCycle?: string;

  /**
   * 自评得分
   */
  selfScore?: number;

  /**
   * 同行评议得分
   */
  peerScore?: number;

  /**
   * 患者评价得分
   */
  patientScore?: number;

  /**
   * 科室评价得分
   */
  departmentScore?: number;

  /**
   * 医院评价得分
   */
  hospitalScore?: number;

  /**
   * 总分
   */
  totalScore?: number;

  /**
   * 考评结果 优秀/良好/合格/不合格
   */
  evaluationResult?: string;

  /**
   * 奖惩情况
   */
  rewardPunishment?: string;

  /**
   * 考评意见
   */
  remark?: string;

  /**
   * 是否删除
   */
  delFlag?: string;
}

export interface DoctorEthicsEvaluationQuery extends PageQuery {
  /**
   * 医生ID
   */
  doctorId?: string | number;

  /**
   * 考评年度
   */
  evaluationYear?: number;

  /**
   * 考评周期
   */
  evaluationCycle?: string;

  /**
   * 自评得分
   */
  selfScore?: number;

  /**
   * 同行评议得分
   */
  peerScore?: number;

  /**
   * 患者评价得分
   */
  patientScore?: number;

  /**
   * 科室评价得分
   */
  departmentScore?: number;

  /**
   * 医院评价得分
   */
  hospitalScore?: number;

  /**
   * 总分
   */
  totalScore?: number;

  /**
   * 考评结果 优秀/良好/合格/不合格
   */
  evaluationResult?: string;

  /**
   * 奖惩情况
   */
  rewardPunishment?: string;

  /**
   * 是否删除
   */
  delFlag?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
