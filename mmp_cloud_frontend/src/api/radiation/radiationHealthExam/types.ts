export interface RadiationHealthExamVO {
  /**
   * 体检日期
   */
  examDate: string;

  /**
   * 体检类型
   */
  examType: string;

  /**
   * 体检医院
   */
  examHospital: string;

  /**
   * 体检医生
   */
  examDoctor: string;

  /**
   * 体检结果
   */
  examResults: string;

  /**
   * 诊断结果
   */
  diagnosis: string;

  /**
   * 建议
   */
  recommendations: string;

  /**
   * 需要随访：0-否，1-是
   */
  followUpRequired: string;

  /**
   * 下次体检日期
   */
  nextExamDate: string;

  /**
   * 状态
   */
  status: string;

  /**
   * 备注
   */
  remark: string;
}

export interface RadiationHealthExamForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 工作人员ID
   */
  workerId?: string | number;

  /**
   * 体检日期
   */
  examDate?: string;

  /**
   * 体检类型
   */
  examType?: string;

  /**
   * 体检医院
   */
  examHospital?: string;

  /**
   * 体检医生
   */
  examDoctor?: string;

  /**
   * 体检结果
   */
  examResults?: string;

  /**
   * 诊断结果
   */
  diagnosis?: string;

  /**
   * 建议
   */
  recommendations?: string;

  /**
   * 需要随访：0-否，1-是
   */
  followUpRequired?: string;

  /**
   * 下次体检日期
   */
  nextExamDate?: string;

  /**
   * 状态
   */
  status?: string;

  /**
   * 备注
   */
  remark?: string;
}

export interface RadiationHealthExamQuery extends PageQuery {
  /**
   * 体检日期
   */
  examDate?: string;

  /**
   * 体检类型
   */
  examType?: string;

  /**
   * 体检医院
   */
  examHospital?: string;

  /**
   * 体检医生
   */
  examDoctor?: string;

  /**
   * 体检结果
   */
  examResults?: string;

  /**
   * 诊断结果
   */
  diagnosis?: string;

  /**
   * 建议
   */
  recommendations?: string;

  /**
   * 需要随访：0-否，1-是
   */
  followUpRequired?: string;

  /**
   * 下次体检日期
   */
  nextExamDate?: string;

  /**
   * 状态
   */
  status?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
