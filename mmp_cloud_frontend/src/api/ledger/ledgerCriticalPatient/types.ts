export interface LedgerCriticalPatientVO {
  /**
   * 患者姓名
   */
  patientName: string;

  /**
   * 入院日期
   */
  admissionDate: string;

  /**
   * 抢救日期
   */
  rescueDate: string;

  /**
   * 抢救科室
   */
  department: string;

  /**
   * 抢救医师
   */
  rescuePhysician: string;

  /**
   * 诊断
   */
  diagnosis: string;

  /**
   * 抢救原因
   */
  rescueReason: string;

  /**
   * 抢救措施
   */
  rescueMeasures: string;

  /**
   * 抢救时长(分钟)
   */
  rescueDuration: number;

  /**
   * 抢救结局
   */
  rescueOutcome: string;

  /**
   * 并发症
   */
  complications: string;

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

export interface LedgerCriticalPatientForm extends BaseEntity {
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
   * 抢救日期
   */
  rescueDate?: string;

  /**
   * 抢救科室
   */
  department?: string;

  /**
   * 抢救医师
   */
  rescuePhysician?: string;

  /**
   * 诊断
   */
  diagnosis?: string;

  /**
   * 抢救原因
   */
  rescueReason?: string;

  /**
   * 抢救措施
   */
  rescueMeasures?: string;

  /**
   * 抢救时长(分钟)
   */
  rescueDuration?: number;

  /**
   * 抢救结局
   */
  rescueOutcome?: string;

  /**
   * 并发症
   */
  complications?: string;

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

export interface LedgerCriticalPatientQuery extends PageQuery {

  /**
   * 患者姓名
   */
  patientName?: string;

  /**
   * 入院日期
   */
  admissionDate?: string;

  /**
   * 抢救日期
   */
  rescueDate?: string;

  /**
   * 抢救科室
   */
  department?: string;

  /**
   * 抢救医师
   */
  rescuePhysician?: string;

  /**
   * 诊断
   */
  diagnosis?: string;

  /**
   * 抢救原因
   */
  rescueReason?: string;

  /**
   * 抢救措施
   */
  rescueMeasures?: string;

  /**
   * 抢救时长(分钟)
   */
  rescueDuration?: number;

  /**
   * 抢救结局
   */
  rescueOutcome?: string;

  /**
   * 并发症
   */
  complications?: string;

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
