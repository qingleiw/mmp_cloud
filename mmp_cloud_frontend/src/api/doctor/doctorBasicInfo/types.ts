export interface DoctorBasicInfoVO extends BaseEntity {
  /**
   * 主键ID
   */
  id: string | number;

  /**
   * 医生工号
   */
  doctorCode: string;

  /**
   * 医生姓名
   */
  doctorName: string;

  /**
   * 性别 1-男 2-女
   */
  gender: number;

  /**
   * 出生日期
   */
  birthDate: string;

  /**
   * 身份证号
   */
  idCard: string | number;

  /**
   * 联系电话
   */
  phone: string;

  /**
   * 电子邮箱
   */
  email: string;

  /**
   * 照片URL
   */
  photoUrl: string;

  /**
   * 科室ID
   */
  deptId: string | number;

  /**
   * 科室名称
   */
  departmentName: string;

  /**
   * 职称
   */
  title: string;

  /**
   * 职称级别 1-初级 2-中级 3-副高 4-正高
   */
  titleLevel: number;

  /**
   * 状态 1-在职 2-离职 3-退休
   */
  status: number;

  /**
   * 入职日期
   */
  entryDate: string;

  /**
   * 是否删除 0-否 1-是
   */
  delFlag: string;
}

export interface DoctorBasicInfoForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 医生工号
   */
  doctorCode?: string;

  /**
   * 医生姓名
   */
  doctorName?: string;

  /**
   * 性别 1-男 2-女
   */
  gender?: number;

  /**
   * 出生日期
   */
  birthDate?: string;

  /**
   * 身份证号
   */
  idCard?: string | number;

  /**
   * 联系电话
   */
  phone?: string;

  /**
   * 电子邮箱
   */
  email?: string;

  /**
   * 照片URL
   */
  photoUrl?: string;

  /**
   * 科室ID
   */
  deptId?: string | number;

  /**
   * 科室名称
   */
  departmentName?: string;

  /**
   * 职称
   */
  title?: string;

  /**
   * 职称级别 1-初级 2-中级 3-副高 4-正高
   */
  titleLevel?: number;

  /**
   * 状态 1-在职 2-离职 3-退休
   */
  status?: number;

  /**
   * 入职日期
   */
  entryDate?: string;

  /**
   * 是否删除 0-否 1-是
   */
  delFlag?: string;
}

export interface DoctorBasicInfoQuery extends PageQuery {
  /**
   * 医生工号
   */
  doctorCode?: string;

  /**
   * 医生姓名
   */
  doctorName?: string;

  /**
   * 性别 1-男 2-女
   */
  gender?: number;

  /**
   * 出生日期
   */
  birthDate?: string;

  /**
   * 身份证号
   */
  idCard?: string | number;

  /**
   * 联系电话
   */
  phone?: string;

  /**
   * 电子邮箱
   */
  email?: string;

  /**
   * 照片URL
   */
  photoUrl?: string;

  /**
   * 科室ID
   */
  deptId?: string | number;

  /**
   * 科室名称
   */
  departmentName?: string;

  /**
   * 职称
   */
  title?: string;

  /**
   * 职称级别 1-初级 2-中级 3-副高 4-正高
   */
  titleLevel?: number;

  /**
   * 状态 1-在职 2-离职 3-退休
   */
  status?: number;

  /**
   * 入职日期
   */
  entryDate?: string;

  /**
   * 是否删除 0-否 1-是
   */
  delFlag?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}

export interface DoctorEvaluationVO extends BaseEntity {
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
  evaluationPeriod: string;

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
  deptScore: number;

  /**
   * 医院评价得分
   */
  hospitalScore: number;

  /**
   * 总分
   */
  totalScore: number;

  /**
   * 考评结果
   */
  evaluationResult: string;

  /**
   * 奖惩情况
   */
  rewardPunishment: string;

  /**
   * 考评意见
   */
  evaluationOpinion: string;
}
