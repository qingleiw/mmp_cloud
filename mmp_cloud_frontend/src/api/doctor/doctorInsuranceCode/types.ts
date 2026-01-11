export interface DoctorInsuranceCodeVO {
  /**
   * 主键ID
   */
  id: string | number;

  /**
   * 医生ID
   */
  doctorId: string | number;

  /**
   * 医保医师码
   */
  insuranceCode: string;

  /**
   * 医保类型 职工医保/居民医保/生育保险
   */
  insuranceType: string;

  /**
   * 有效期至
   */
  validDate: string | number;

  /**
   * 状态 有效/暂停/注销
   */
  status: string;

  /**
   * 申请日期
   */
  applyDate: string;

  /**
   * 审批日期
   */
  approveDate: string;

  /**
   * 备注
   */
  remark: string;

  /**
   * 是否删除
   */
  delFlag?: string;
}

export interface DoctorInsuranceCodeForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 医生ID
   */
  doctorId?: string | number;

  /**
   * 医保医师码
   */
  insuranceCode?: string;

  /**
   * 医保类型 职工医保/居民医保/生育保险
   */
  insuranceType?: string;

  /**
   * 有效期至
   */
  validDate?: string | number;

  /**
   * 状态 有效/暂停/注销
   */
  status?: string;

  /**
   * 申请日期
   */
  applyDate?: string;

  /**
   * 审批日期
   */
  approveDate?: string;

  /**
   * 备注
   */
  remark?: string;

  /**
   * 是否删除
   */
  delFlag?: string;
}

export interface DoctorInsuranceCodeQuery extends PageQuery {
  /**
   * 医生ID
   */
  doctorId?: string | number;

  /**
   * 医保医师码
   */
  insuranceCode?: string;

  /**
   * 医保类型 职工医保/居民医保/生育保险
   */
  insuranceType?: string;

  /**
   * 有效期至
   */
  validDate?: string | number;

  /**
   * 状态 有效/暂停/注销
   */
  status?: string;

  /**
   * 申请日期
   */
  applyDate?: string;

  /**
   * 审批日期
   */
  approveDate?: string;

  /**
   * 是否删除
   */
  delFlag?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
