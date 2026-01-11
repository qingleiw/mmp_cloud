export interface DoctorAbilityAssessmentVO {
  /**
   * 主键ID
   */
  id: string | number;

  /**
   * 医生ID
   */
  doctorId: string | number;

  /**
   * 评估年度
   */
  assessmentYear: number;

  /**
   * 评估类型
   */
  assessmentType: string;

  /**
   * 临床能力得分
   */
  clinicalAbilityScore: number;

  /**
   * 教学能力得分
   */
  teachingAbilityScore: number;

  /**
   * 科研能力得分
   */
  researchAbilityScore: number;

  /**
   * 管理能力得分
   */
  managementAbilityScore: number;

  /**
   * 总分
   */
  totalScore: number;

  /**
   * 评估结果 优秀/良好/合格/不合格
   */
  assessmentResult: string;

  /**
   * 评估人
   */
  assessor: string;

  /**
   * 评估日期
   */
  assessmentDate: string;

  /**
   * 评估意见
   */
  remark: string;

  /**
   * 是否删除
   */
  delFlag?: string;
}

export interface DoctorAbilityAssessmentForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 医生ID
   */
  doctorId?: string | number;

  /**
   * 评估年度
   */
  assessmentYear?: number;

  /**
   * 评估类型
   */
  assessmentType?: string;

  /**
   * 临床能力得分
   */
  clinicalAbilityScore?: number;

  /**
   * 教学能力得分
   */
  teachingAbilityScore?: number;

  /**
   * 科研能力得分
   */
  researchAbilityScore?: number;

  /**
   * 管理能力得分
   */
  managementAbilityScore?: number;

  /**
   * 总分
   */
  totalScore?: number;

  /**
   * 评估结果 优秀/良好/合格/不合格
   */
  assessmentResult?: string;

  /**
   * 评估人
   */
  assessor?: string;

  /**
   * 评估日期
   */
  assessmentDate?: string;

  /**
   * 评估意见
   */
  remark?: string;

  /**
   * 是否删除
   */
  delFlag?: string;
}

export interface DoctorAbilityAssessmentQuery extends PageQuery {
  /**
   * 医生ID
   */
  doctorId?: string | number;

  /**
   * 评估年度
   */
  assessmentYear?: number;

  /**
   * 评估类型
   */
  assessmentType?: string;

  /**
   * 临床能力得分
   */
  clinicalAbilityScore?: number;

  /**
   * 教学能力得分
   */
  teachingAbilityScore?: number;

  /**
   * 科研能力得分
   */
  researchAbilityScore?: number;

  /**
   * 管理能力得分
   */
  managementAbilityScore?: number;

  /**
   * 总分
   */
  totalScore?: number;

  /**
   * 评估结果 优秀/良好/合格/不合格
   */
  assessmentResult?: string;

  /**
   * 评估人
   */
  assessor?: string;

  /**
   * 评估日期
   */
  assessmentDate?: string;

  /**
   * 是否删除
   */
  delFlag?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
