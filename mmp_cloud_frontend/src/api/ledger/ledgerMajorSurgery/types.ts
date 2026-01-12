export interface LedgerMajorSurgeryVO {
  /**
   * 患者姓名
   */
  patientName: string;

  /**
   * 手术日期
   */
  operationDate: string;

  /**
   * 手术科室
   */
  department: string;

  /**
   * 主刀医师
   */
  surgeon: string;

  /**
   * 手术名称
   */
  operationName: string;

  /**
   * 手术等级
   */
  operationLevel: string;

  /**
   * 术前诊断
   */
  preoperativeDiagnosis: string;

  /**
   * 术后诊断
   */
  postoperativeDiagnosis: string;

  /**
   * 手术时长(分钟)
   */
  operationDuration: number;

  /**
   * 麻醉方式
   */
  anesthesiaMethod: string;

  /**
   * 术中并发症
   */
  complications: string;

  /**
   * 手术结局
   */
  outcome: string;

  /**
   * 随访结果
   */
  followUpResults: string;

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

export interface LedgerMajorSurgeryForm extends BaseEntity {
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
   * 手术日期
   */
  operationDate?: string;

  /**
   * 手术科室
   */
  department?: string;

  /**
   * 主刀医师
   */
  surgeon?: string;

  /**
   * 手术名称
   */
  operationName?: string;

  /**
   * 手术等级
   */
  operationLevel?: string;

  /**
   * 术前诊断
   */
  preoperativeDiagnosis?: string;

  /**
   * 术后诊断
   */
  postoperativeDiagnosis?: string;

  /**
   * 手术时长(分钟)
   */
  operationDuration?: number;

  /**
   * 麻醉方式
   */
  anesthesiaMethod?: string;

  /**
   * 术中并发症
   */
  complications?: string;

  /**
   * 手术结局
   */
  outcome?: string;

  /**
   * 随访结果
   */
  followUpResults?: string;

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

export interface LedgerMajorSurgeryQuery extends PageQuery {

  /**
   * 患者姓名
   */
  patientName?: string;

  /**
   * 手术日期
   */
  operationDate?: string;

  /**
   * 手术科室
   */
  department?: string;

  /**
   * 主刀医师
   */
  surgeon?: string;

  /**
   * 手术名称
   */
  operationName?: string;

  /**
   * 手术等级
   */
  operationLevel?: string;

  /**
   * 术前诊断
   */
  preoperativeDiagnosis?: string;

  /**
   * 术后诊断
   */
  postoperativeDiagnosis?: string;

  /**
   * 手术时长(分钟)
   */
  operationDuration?: number;

  /**
   * 麻醉方式
   */
  anesthesiaMethod?: string;

  /**
   * 术中并发症
   */
  complications?: string;

  /**
   * 手术结局
   */
  outcome?: string;

  /**
   * 随访结果
   */
  followUpResults?: string;

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
