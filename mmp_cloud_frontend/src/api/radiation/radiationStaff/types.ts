export interface RadiationStaffVO {
  /**
   * 姓名
   */
  userName: string;

  /**
   * 员工编码
   */
  employeeCode: string;

  /**
   * 所在部门名称
   */
  departmentName: string;

  /**
   * 工作岗位
   */
  position: string;

  /**
   * 入职日期
   */
  hireDate: string;

  /**
   * 放射工作年限
   */
  radiationWorkYears: number;

  /**
   * 放射资质
   */
  radiationQualification: string;

  /**
   * 资质证书
   */
  qualificationCertificate: string;

  /**
   * 证书编号
   */
  certificateNumber: string;

  /**
   * 证书发证日期
   */
  certificateIssueDate: string;

  /**
   * 证书到期日期
   */
  certificateExpiryDate: string;

  /**
   * 培训记录
   */
  trainingRecords: string;

  /**
   * 体检记录
   */
  healthExamRecords: string;

  /**
   * 状态：active-在职，inactive-离职
   */
  status: string;

  /**
   * 备注
   */
  remark: string;
}

export interface RadiationStaffForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 用户ID
   */
  userId?: string | number;

  /**
   * 姓名
   */
  userName?: string;

  /**
   * 员工编码
   */
  employeeCode?: string;

  /**
   * 所在部门ID
   */
  departmentId?: string | number;

  /**
   * 所在部门名称
   */
  departmentName?: string;

  /**
   * 工作岗位
   */
  position?: string;

  /**
   * 入职日期
   */
  hireDate?: string;

  /**
   * 放射工作年限
   */
  radiationWorkYears?: number;

  /**
   * 放射资质
   */
  radiationQualification?: string;

  /**
   * 资质证书
   */
  qualificationCertificate?: string;

  /**
   * 证书编号
   */
  certificateNumber?: string;

  /**
   * 证书发证日期
   */
  certificateIssueDate?: string;

  /**
   * 证书到期日期
   */
  certificateExpiryDate?: string;

  /**
   * 培训记录
   */
  trainingRecords?: string;

  /**
   * 体检记录
   */
  healthExamRecords?: string;

  /**
   * 状态：active-在职，inactive-离职
   */
  status?: string;

  /**
   * 备注
   */
  remark?: string;
}

export interface RadiationStaffQuery extends PageQuery {
  /**
   * 姓名
   */
  userName?: string;

  /**
   * 员工编码
   */
  employeeCode?: string;

  /**
   * 所在部门名称
   */
  departmentName?: string;

  /**
   * 工作岗位
   */
  position?: string;

  /**
   * 入职日期
   */
  hireDate?: string;

  /**
   * 放射工作年限
   */
  radiationWorkYears?: number;

  /**
   * 放射资质
   */
  radiationQualification?: string;

  /**
   * 资质证书
   */
  qualificationCertificate?: string;

  /**
   * 证书编号
   */
  certificateNumber?: string;

  /**
   * 证书发证日期
   */
  certificateIssueDate?: string;

  /**
   * 证书到期日期
   */
  certificateExpiryDate?: string;

  /**
   * 培训记录
   */
  trainingRecords?: string;

  /**
   * 体检记录
   */
  healthExamRecords?: string;

  /**
   * 状态：active-在职，inactive-离职
   */
  status?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
