export interface SupervisionProjectVO {
  id: string | number;
  /**
   * 项目编码
   */
  projectCode: string;

  /**
   * 项目名称
   */
  projectName: string;

  /**
   * 项目类型
   */
  projectType: string;

  /**
   * 项目描述
   */
  projectDescription: string;

  /**
   * 督导部门
   */
  supervisionDepartment: string;

  /**
   * 负责人
   */
  responsiblePerson: string;

  /**
   * 联系方式
   */
  contactInfo: string;

  /**
   * 督导频次
   */
  supervisionFrequency: string;

  /**
   * 状态：active-启用，inactive-停用
   */
  status: string;

  /**
   * 备注
   */
  remark: string;
}

export interface SupervisionProjectForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 项目编码
   */
  projectCode?: string;

  /**
   * 项目名称
   */
  projectName?: string;

  /**
   * 项目类型
   */
  projectType?: string;

  /**
   * 项目描述
   */
  projectDescription?: string;

  /**
   * 督导部门
   */
  supervisionDepartment?: string;

  /**
   * 负责人
   */
  responsiblePerson?: string;

  /**
   * 联系方式
   */
  contactInfo?: string;

  /**
   * 督导频次
   */
  supervisionFrequency?: string;

  /**
   * 状态：active-启用，inactive-停用
   */
  status?: string;

  /**
   * 备注
   */
  remark?: string;
}

export interface SupervisionProjectQuery extends PageQuery {
  /**
   * 项目编码
   */
  projectCode?: string;

  /**
   * 项目名称
   */
  projectName?: string;

  /**
   * 项目类型
   */
  projectType?: string;

  /**
   * 项目描述
   */
  projectDescription?: string;

  /**
   * 督导部门
   */
  supervisionDepartment?: string;

  /**
   * 负责人
   */
  responsiblePerson?: string;

  /**
   * 联系方式
   */
  contactInfo?: string;

  /**
   * 督导频次
   */
  supervisionFrequency?: string;

  /**
   * 状态：active-启用，inactive-停用
   */
  status?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
