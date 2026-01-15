export interface LedgerUnplannedReoperationVO {
  /**
   * 患者姓名
   */
  patientName: string;

  /**
   * 第一次手术日期
   */
  firstOperationDate: string;

  /**
   * 再次手术日期
   */
  reoperationDate: string;

  /**
   * 手术科室
   */
  department: string;

  /**
   * 手术医师
   */
  surgeon: string;

  /**
   * 第一次手术名称
   */
  firstOperationName: string;

  /**
   * 再次手术名称
   */
  reoperationName: string;

  /**
   * 再次手术原因
   */
  reoperationReason: string;

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

export interface LedgerUnplannedReoperationForm extends BaseEntity {
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
   * 第一次手术日期
   */
  firstOperationDate?: string;

  /**
   * 再次手术日期
   */
  reoperationDate?: string;

  /**
   * 手术科室
   */
  department?: string;

  /**
   * 手术医师
   */
  surgeon?: string;

  /**
   * 第一次手术名称
   */
  firstOperationName?: string;

  /**
   * 再次手术名称
   */
  reoperationName?: string;

  /**
   * 再次手术原因
   */
  reoperationReason?: string;

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

export interface LedgerUnplannedReoperationQuery extends PageQuery {
  /**
   * 患者姓名
   */
  patientName?: string;

  /**
   * 第一次手术日期
   */
  firstOperationDate?: string;

  /**
   * 再次手术日期
   */
  reoperationDate?: string;

  /**
   * 手术科室
   */
  department?: string;

  /**
   * 手术医师
   */
  surgeon?: string;

  /**
   * 第一次手术名称
   */
  firstOperationName?: string;

  /**
   * 再次手术名称
   */
  reoperationName?: string;

  /**
   * 再次手术原因
   */
  reoperationReason?: string;

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
