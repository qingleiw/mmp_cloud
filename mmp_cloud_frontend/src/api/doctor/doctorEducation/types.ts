export interface DoctorEducationVO extends BaseEntity {
  /**
   * 主键ID
   */
  id: string | number;

  /**
   * 医生ID
   */
  doctorId: string | number;

  /**
   * 学校名称
   */
  schoolName: string;

  /**
   * 专业
   */
  major: string;

  /**
   * 学历 本科/硕士/博士
   */
  educationLevel: string;

  /**
   * 学位
   */
  degree: string;

  /**
   * 开始日期
   */
  startDate: string;

  /**
   * 结束日期
   */
  endDate: string;

  /**
   * 是否全日制 1-是 0-否
   */
  isFullTime: number;

  /**
   * 证书编号
   */
  certificateNo: string;

  /**
   * 证书附件URL
   */
  certificateUrl: string;

  /**
   * 备注
   */
  remark: string;

  /**
   * 是否删除
   */
  delFlag?: string;
}

export interface DoctorEducationForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 医生ID
   */
  doctorId?: string | number;

  /**
   * 学校名称
   */
  schoolName?: string;

  /**
   * 专业
   */
  major?: string;

  /**
   * 学历 本科/硕士/博士
   */
  educationLevel?: string;

  /**
   * 学位
   */
  degree?: string;

  /**
   * 开始日期
   */
  startDate?: string;

  /**
   * 结束日期
   */
  endDate?: string;

  /**
   * 是否全日制 1-是 0-否
   */
  isFullTime?: number;

  /**
   * 证书编号
   */
  certificateNo?: string;

  /**
   * 证书附件URL
   */
  certificateUrl?: string;

  /**
   * 备注
   */
  remark?: string;

  /**
   * 是否删除
   */
  delFlag?: string;
}

export interface DoctorEducationQuery extends PageQuery {
  /**
   * 医生ID
   */
  doctorId?: string | number;

  /**
   * 学校名称
   */
  schoolName?: string;

  /**
   * 专业
   */
  major?: string;

  /**
   * 学历 本科/硕士/博士
   */
  educationLevel?: string;

  /**
   * 学位
   */
  degree?: string;

  /**
   * 开始日期
   */
  startDate?: string;

  /**
   * 结束日期
   */
  endDate?: string;

  /**
   * 是否全日制 1-是 0-否
   */
  isFullTime?: number;

  /**
   * 证书编号
   */
  certificateNo?: string;

  /**
   * 证书附件URL
   */
  certificateUrl?: string;

  /**
   * 是否删除
   */
  delFlag?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
