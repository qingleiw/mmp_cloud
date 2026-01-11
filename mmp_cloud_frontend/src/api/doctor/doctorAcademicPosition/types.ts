export interface DoctorAcademicPositionVO {
  /**
   * 主键ID
   */
  id: string | number;

  /**
   * 医生ID
   */
  doctorId: string | number;

  /**
   * 学术组织
   */
  organization: string;

  /**
   * 职务
   */
  position: string;

  /**
   * 职务级别
   */
  positionLevel: string;

  /**
   * 任职开始日期
   */
  startDate: string;

  /**
   * 任职结束日期
   */
  endDate: string;

  /**
   * 是否现任 1-是 0-否
   */
  isCurrent: number;

  /**
   * 任职证明URL
   */
  appointmentUrl: string;

  /**
   * 备注
   */
  remark: string;

  /**
   * 是否删除
   */
  delFlag?: string;
}

export interface DoctorAcademicPositionForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 医生ID
   */
  doctorId?: string | number;

  /**
   * 学术组织
   */
  organization?: string;

  /**
   * 职务
   */
  position?: string;

  /**
   * 职务级别
   */
  positionLevel?: string;

  /**
   * 任职开始日期
   */
  startDate?: string;

  /**
   * 任职结束日期
   */
  endDate?: string;

  /**
   * 是否现任 1-是 0-否
   */
  isCurrent?: number;

  /**
   * 任职证明URL
   */
  appointmentUrl?: string;

  /**
   * 备注
   */
  remark?: string;

  /**
   * 是否删除
   */
  delFlag?: string;
}

export interface DoctorAcademicPositionQuery extends PageQuery {
  /**
   * 医生ID
   */
  doctorId?: string | number;

  /**
   * 学术组织
   */
  organization?: string;

  /**
   * 职务
   */
  position?: string;

  /**
   * 职务级别
   */
  positionLevel?: string;

  /**
   * 任职开始日期
   */
  startDate?: string;

  /**
   * 任职结束日期
   */
  endDate?: string;

  /**
   * 是否现任 1-是 0-否
   */
  isCurrent?: number;

  /**
   * 任职证明URL
   */
  appointmentUrl?: string;

  /**
   * 是否删除
   */
  delFlag?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
