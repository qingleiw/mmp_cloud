export interface LedgerPatientFullCycleVO {
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
   * 就诊科室
   */
  department: string;

  /**
   * 主治医师
   */
  attendingPhysician: string;

  /**
   * 诊断信息
   */
  diagnosis: string;

  /**
   * 治疗记录
   */
  treatmentRecords: string;

  /**
   * 检查结果
   */
  examinationResults: string;

  /**
   * 用药记录
   */
  medicationRecords: string;

  /**
   * 随访记录
   */
  followUpRecords: string;

  /**
   * 治疗结局
   */
  outcome: string;

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

export interface LedgerPatientFullCycleForm extends BaseEntity {
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
   * 就诊科室
   */
  department?: string;

  /**
   * 主治医师
   */
  attendingPhysician?: string;

  /**
   * 诊断信息
   */
  diagnosis?: string;

  /**
   * 治疗记录
   */
  treatmentRecords?: string;

  /**
   * 检查结果
   */
  examinationResults?: string;

  /**
   * 用药记录
   */
  medicationRecords?: string;

  /**
   * 随访记录
   */
  followUpRecords?: string;

  /**
   * 治疗结局
   */
  outcome?: string;

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

export interface LedgerPatientFullCycleQuery extends PageQuery {

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
   * 就诊科室
   */
  department?: string;

  /**
   * 主治医师
   */
  attendingPhysician?: string;

  /**
   * 诊断信息
   */
  diagnosis?: string;

  /**
   * 治疗记录
   */
  treatmentRecords?: string;

  /**
   * 检查结果
   */
  examinationResults?: string;

  /**
   * 用药记录
   */
  medicationRecords?: string;

  /**
   * 随访记录
   */
  followUpRecords?: string;

  /**
   * 治疗结局
   */
  outcome?: string;

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
