export interface DoctorWorkExperienceVO {
  /**
   * 主键ID
   */
  id: string | number;

  /**
   * 医生ID
   */
  doctorId: string | number;

  /**
   * 工作单位
   */
  organization: string;

  /**
   * 部门
   */
  department: string;

  /**
   * 职位
   */
  position: string;

  /**
   * 开始日期
   */
  startDate: string;

  /**
   * 结束日期
   */
  endDate: string;

  /**
   * 工作描述
   */
  jobDescription: string;

  /**
   * 工作业绩
   */
  achievements: string;

  /**
   * 证明人
   */
  references: string;

  /**
   * 是否删除
   */
  delFlag?: string;
}

export interface DoctorWorkExperienceForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 医生ID
   */
  doctorId?: string | number;

  /**
   * 工作单位
   */
  organization?: string;

  /**
   * 部门
   */
  department?: string;

  /**
   * 职位
   */
  position?: string;

  /**
   * 开始日期
   */
  startDate?: string;

  /**
   * 结束日期
   */
  endDate?: string;

  /**
   * 工作描述
   */
  jobDescription?: string;

  /**
   * 工作业绩
   */
  achievements?: string;

  /**
   * 证明人
   */
  references?: string;

  /**
   * 是否删除
   */
  delFlag?: string;
}

export interface DoctorWorkExperienceQuery extends PageQuery {
  /**
   * 医生ID
   */
  doctorId?: string | number;

  /**
   * 工作单位
   */
  organization?: string;

  /**
   * 部门
   */
  department?: string;

  /**
   * 职位
   */
  position?: string;

  /**
   * 开始日期
   */
  startDate?: string;

  /**
   * 结束日期
   */
  endDate?: string;

  /**
   * 工作描述
   */
  jobDescription?: string;

  /**
   * 是否删除
   */
  delFlag?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
