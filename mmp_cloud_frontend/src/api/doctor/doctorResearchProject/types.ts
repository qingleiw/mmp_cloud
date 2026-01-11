export interface DoctorResearchProjectVO {
  /**
   * 主键ID
   */
  id: string | number;

  /**
   * 医生ID
   */
  doctorId: string | number;

  /**
   * 项目名称
   */
  projectName: string;

  /**
   * 项目编号
   */
  projectNo: string;

  /**
   * 项目级别 国家级/省级/市级/院级
   */
  projectLevel: string;

  /**
   * 项目类型
   */
  projectType: string;

  /**
   * 承担角色 主持人/参与人
   */
  role: string;

  /**
   * 开始日期
   */
  startDate: string;

  /**
   * 结束日期
   */
  endDate: string;

  /**
   * 资助金额
   */
  fundingAmount: number;

  /**
   * 项目状态 在研/结题/终止
   */
  status: string;

  /**
   * 备注
   */
  remark: string;

  /**
   * 是否删除
   */
  delFlag?: string;
}

export interface DoctorResearchProjectForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 医生ID
   */
  doctorId?: string | number;

  /**
   * 项目名称
   */
  projectName?: string;

  /**
   * 项目编号
   */
  projectNo?: string;

  /**
   * 项目级别 国家级/省级/市级/院级
   */
  projectLevel?: string;

  /**
   * 项目类型
   */
  projectType?: string;

  /**
   * 承担角色 主持人/参与人
   */
  role?: string;

  /**
   * 开始日期
   */
  startDate?: string;

  /**
   * 结束日期
   */
  endDate?: string;

  /**
   * 资助金额
   */
  fundingAmount?: number;

  /**
   * 项目状态 在研/结题/终止
   */
  status?: string;

  /**
   * 备注
   */
  remark?: string;

  /**
   * 是否删除
   */
  delFlag?: string;
}

export interface DoctorResearchProjectQuery extends PageQuery {
  /**
   * 医生ID
   */
  doctorId?: string | number;

  /**
   * 项目名称
   */
  projectName?: string;

  /**
   * 项目编号
   */
  projectNo?: string;

  /**
   * 项目级别 国家级/省级/市级/院级
   */
  projectLevel?: string;

  /**
   * 项目类型
   */
  projectType?: string;

  /**
   * 承担角色 主持人/参与人
   */
  role?: string;

  /**
   * 开始日期
   */
  startDate?: string;

  /**
   * 结束日期
   */
  endDate?: string;

  /**
   * 资助金额
   */
  fundingAmount?: number;

  /**
   * 项目状态 在研/结题/终止
   */
  status?: string;

  /**
   * 是否删除
   */
  delFlag?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
