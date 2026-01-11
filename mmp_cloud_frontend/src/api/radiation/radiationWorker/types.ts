export interface RadiationWorkerVO {
  /**
   * 工作人员编码
   */
  workerCode: string;

  /**
   * 工作人员姓名
   */
  workerName: string;

  /**
   * 所属部门
   */
  department: string;

  /**
   * 职位
   */
  position: string;

  /**
   * 接触辐射类型
   */
  radiationType: string;

  /**
   * 入职日期
   */
  employmentDate: string;

  /**
   * 联系方式
   */
  contactInfo: string;

  /**
   * 紧急联系人
   */
  emergencyContact: string;

  /**
   * 健康状况
   */
  healthStatus: string;

  /**
   * 状态
   */
  status: string;

  /**
   * 备注
   */
  remark: string;
}

export interface RadiationWorkerForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 工作人员编码
   */
  workerCode?: string;

  /**
   * 工作人员姓名
   */
  workerName?: string;

  /**
   * 所属部门
   */
  department?: string;

  /**
   * 职位
   */
  position?: string;

  /**
   * 接触辐射类型
   */
  radiationType?: string;

  /**
   * 入职日期
   */
  employmentDate?: string;

  /**
   * 联系方式
   */
  contactInfo?: string;

  /**
   * 紧急联系人
   */
  emergencyContact?: string;

  /**
   * 健康状况
   */
  healthStatus?: string;

  /**
   * 状态
   */
  status?: string;

  /**
   * 备注
   */
  remark?: string;
}

export interface RadiationWorkerQuery extends PageQuery {
  /**
   * 工作人员编码
   */
  workerCode?: string;

  /**
   * 工作人员姓名
   */
  workerName?: string;

  /**
   * 所属部门
   */
  department?: string;

  /**
   * 职位
   */
  position?: string;

  /**
   * 接触辐射类型
   */
  radiationType?: string;

  /**
   * 入职日期
   */
  employmentDate?: string;

  /**
   * 联系方式
   */
  contactInfo?: string;

  /**
   * 紧急联系人
   */
  emergencyContact?: string;

  /**
   * 健康状况
   */
  healthStatus?: string;

  /**
   * 状态
   */
  status?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
