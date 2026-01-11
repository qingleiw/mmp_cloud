export interface SurgeryApprovalFormVO {
  id: string | number;
  /**
   * 申报科室
   */
  deptName: string;

  /**
   * 申报日期
   */
  reportDate: string;

  /**
   * 患者姓名
   */
  patientName: string;

  /**
   * 性别
   */
  gender: string;

  /**
   * 年龄
   */
  age: number;

  /**
   * 住院号
   */
  hospitalNumber: string;

  /**
   * 术前诊断
   */
  preoperativeDiagnosis: string;

  /**
   * 手术名称
   */
  surgeryName: string;

  /**
   * 手术级别
   */
  surgeryLevel: string;

  /**
   * 麻醉方式
   */
  anesthesiaMethod: string;

  /**
   * 术者及职称
   */
  surgeon: string;

  /**
   * 助手及职称
   */
  assistant: string;

  /**
   * 术前讨论结果
   */
  discussionResult: string;

  /**
   * 报告医师
   */
  reportingPhysician: string;

  /**
   * 报告日期
   */
  reportingDate: string;

  /**
   * 患者或授权委托人知情同意情况
   */
  informedConsent: string;

  /**
   * 科室主任签字
   */
  departmentDirector: string;

  /**
   * 科室签字日期
   */
  departmentDate: string;

  /**
   * 医务部主任签字
   */
  medicalDirector: string;

  /**
   * 审批状态
   */
  status: string;

  /**
   * 删除标志（0代表存在 1代表删除）
   */
  delFlag?: string;
}

export interface SurgeryApprovalFormForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 申报科室
   */
  deptName?: string;

  /**
   * 申报日期
   */
  reportDate?: string;

  /**
   * 患者姓名
   */
  patientName?: string;

  /**
   * 性别
   */
  gender?: string;

  /**
   * 年龄
   */
  age?: number;

  /**
   * 住院号
   */
  hospitalNumber?: string;

  /**
   * 术前诊断
   */
  preoperativeDiagnosis?: string;

  /**
   * 手术名称
   */
  surgeryName?: string;

  /**
   * 手术级别
   */
  surgeryLevel?: string;

  /**
   * 麻醉方式
   */
  anesthesiaMethod?: string;

  /**
   * 术者及职称
   */
  surgeon?: string;

  /**
   * 助手及职称
   */
  assistant?: string;

  /**
   * 术前讨论结果
   */
  discussionResult?: string;

  /**
   * 报告医师
   */
  reportingPhysician?: string;

  /**
   * 报告日期
   */
  reportingDate?: string;

  /**
   * 患者或授权委托人知情同意情况
   */
  informedConsent?: string;

  /**
   * 科室主任签字
   */
  departmentDirector?: string;

  /**
   * 科室签字日期
   */
  departmentDate?: string;

  /**
   * 医务部主任签字
   */
  medicalDirector?: string;

  /**
   * 审批状态
   */
  status?: string;

  /**
   * 删除标志（0代表存在 1代表删除）
   */
  delFlag?: string;
}

export interface SurgeryApprovalFormQuery extends PageQuery {
  /**
   * 申报科室
   */
  deptName?: string;

  /**
   * 申报日期
   */
  reportDate?: string;

  /**
   * 患者姓名
   */
  patientName?: string;

  /**
   * 性别
   */
  gender?: string;

  /**
   * 年龄
   */
  age?: number;

  /**
   * 住院号
   */
  hospitalNumber?: string;

  /**
   * 术前诊断
   */
  preoperativeDiagnosis?: string;

  /**
   * 手术名称
   */
  surgeryName?: string;

  /**
   * 手术级别
   */
  surgeryLevel?: string;

  /**
   * 麻醉方式
   */
  anesthesiaMethod?: string;

  /**
   * 术者及职称
   */
  surgeon?: string;

  /**
   * 助手及职称
   */
  assistant?: string;

  /**
   * 术前讨论结果
   */
  discussionResult?: string;

  /**
   * 报告医师
   */
  reportingPhysician?: string;

  /**
   * 报告日期
   */
  reportingDate?: string;

  /**
   * 患者或授权委托人知情同意情况
   */
  informedConsent?: string;

  /**
   * 科室主任签字
   */
  departmentDirector?: string;

  /**
   * 科室签字日期
   */
  departmentDate?: string;

  /**
   * 医务部主任签字
   */
  medicalDirector?: string;

  /**
   * 审批状态
   */
  status?: string;

  /**
   * 删除标志（0代表存在 1代表删除）
   */
  delFlag?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
