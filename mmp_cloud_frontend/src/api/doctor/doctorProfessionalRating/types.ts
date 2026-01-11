export interface DoctorProfessionalRatingVO {
  /**
   * 主键ID
   */
  id: string | number;

  /**
   * 医师姓名
   */
  doctorName: string;

  /**
   * 评分年份
   */
  ratingYear: number;

  /**
   * 评分季度
   */
  ratingQuarter: number;

  /**
   * 基础分数
   */
  baseScore: number;

  /**
   * 投诉扣分
   */
  complaintDeduction: number;

  /**
   * 医疗质量评分
   */
  medicalQualityScore: number;

  /**
   * 患者满意度
   */
  patientSatisfaction: number;

  /**
   * 最终得分
   */
  finalScore: number;

  /**
   * 评分等级
   */
  ratingLevel: string;

  /**
   * 删除标志（0代表存在 1代表删除）
   */
  delFlag: string;
}

export interface DoctorProfessionalRatingForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 医师ID
   */
  doctorId?: string | number;

  /**
   * 医师姓名
   */
  doctorName?: string;

  /**
   * 评分年份
   */
  ratingYear?: number;

  /**
   * 评分季度
   */
  ratingQuarter?: number;

  /**
   * 基础分数
   */
  baseScore?: number;

  /**
   * 投诉扣分
   */
  complaintDeduction?: number;

  /**
   * 医疗质量评分
   */
  medicalQualityScore?: number;

  /**
   * 患者满意度
   */
  patientSatisfaction?: number;

  /**
   * 最终得分
   */
  finalScore?: number;

  /**
   * 评分等级
   */
  ratingLevel?: string;

  /**
   * 删除标志（0代表存在 1代表删除）
   */
  delFlag?: string;
}

export interface DoctorProfessionalRatingQuery extends PageQuery {
  /**
   * 医师姓名
   */
  doctorName?: string;

  /**
   * 评分年份
   */
  ratingYear?: number;

  /**
   * 评分季度
   */
  ratingQuarter?: number;

  /**
   * 基础分数
   */
  baseScore?: number;

  /**
   * 投诉扣分
   */
  complaintDeduction?: number;

  /**
   * 医疗质量评分
   */
  medicalQualityScore?: number;

  /**
   * 患者满意度
   */
  patientSatisfaction?: number;

  /**
   * 最终得分
   */
  finalScore?: number;

  /**
   * 评分等级
   */
  ratingLevel?: string;

  /**
   * 删除标志（0代表存在 1代表删除）
   */
  delFlag?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
