export interface EmergencyEventTreatmentVO {
  /**
   * 患者姓名
   */
  patientName: string;

  /**
   * 诊断
   */
  diagnosis: string;

  /**
   * 救治措施
   */
  treatmentMeasures: string;

  /**
   * 救治结果
   */
  treatmentResult: string;

  /**
   * 救治医师
   */
  treatingPhysician: string;

  /**
   * 救治时间
   */
  treatmentTime: string;

  /**
   * 备注
   */
  remark: string;
}

export interface EmergencyEventTreatmentForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 事件ID
   */
  eventId?: string | number;

  /**
   * 患者ID
   */
  patientId?: string | number;

  /**
   * 患者姓名
   */
  patientName?: string;

  /**
   * 诊断
   */
  diagnosis?: string;

  /**
   * 救治措施
   */
  treatmentMeasures?: string;

  /**
   * 救治结果
   */
  treatmentResult?: string;

  /**
   * 救治医师
   */
  treatingPhysician?: string;

  /**
   * 救治时间
   */
  treatmentTime?: string;

  /**
   * 备注
   */
  remark?: string;
}

export interface EmergencyEventTreatmentQuery extends PageQuery {
  /**
   * 患者姓名
   */
  patientName?: string;

  /**
   * 诊断
   */
  diagnosis?: string;

  /**
   * 救治措施
   */
  treatmentMeasures?: string;

  /**
   * 救治结果
   */
  treatmentResult?: string;

  /**
   * 救治医师
   */
  treatingPhysician?: string;

  /**
   * 救治时间
   */
  treatmentTime?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
