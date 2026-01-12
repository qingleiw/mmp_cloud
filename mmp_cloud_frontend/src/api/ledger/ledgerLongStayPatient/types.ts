export interface LedgerLongStayPatientVO {
  /**
   * 患者姓名
   */
  patientName: string;

  /**
   * 入院日期
   */
  admissionDate: string;

  /**
   * 出院日期
   */
  dischargeDate: string;

  /**
   * 住院天数
   */
  hospitalDays: number;

  /**
   * 所在科室
   */
  department: string;

  /**
   * 诊断
   */
  diagnosis: string;

  /**
   * 治疗方案
   */
  treatmentPlan: string;

  /**
   * 并发症
   */
  complications: string;

  /**
   * 特殊原因
   */
  specialReasons: string;

  /**
   * 医疗评价
   */
  medicalEvaluation: string;

  /**
   * 状态
   */
  status: string;

  /**
   * 备注
   */
  remark: string;

}

export interface LedgerLongStayPatientForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 患者ID
   */
  patientId?: string | number;

  /**
   * 患者姓名
   */
  patientName?: string;

  /**
   * 入院日期
   */
  admissionDate?: string;

  /**
   * 出院日期
   */
  dischargeDate?: string;

  /**
   * 住院天数
   */
  hospitalDays?: number;

  /**
   * 所在科室
   */
  department?: string;

  /**
   * 诊断
   */
  diagnosis?: string;

  /**
   * 治疗方案
   */
  treatmentPlan?: string;

  /**
   * 并发症
   */
  complications?: string;

  /**
   * 特殊原因
   */
  specialReasons?: string;

  /**
   * 医疗评价
   */
  medicalEvaluation?: string;

  /**
   * 状态
   */
  status?: string;

  /**
   * 备注
   */
  remark?: string;

}

export interface LedgerLongStayPatientQuery extends PageQuery {

  /**
   * 患者姓名
   */
  patientName?: string;

  /**
   * 入院日期
   */
  admissionDate?: string;

  /**
   * 出院日期
   */
  dischargeDate?: string;

  /**
   * 住院天数
   */
  hospitalDays?: number;

  /**
   * 所在科室
   */
  department?: string;

  /**
   * 诊断
   */
  diagnosis?: string;

  /**
   * 治疗方案
   */
  treatmentPlan?: string;

  /**
   * 并发症
   */
  complications?: string;

  /**
   * 特殊原因
   */
  specialReasons?: string;

  /**
   * 医疗评价
   */
  medicalEvaluation?: string;

  /**
   * 状态
   */
  status?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
