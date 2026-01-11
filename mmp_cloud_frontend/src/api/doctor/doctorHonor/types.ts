export interface DoctorHonorVO {
  /**
   * 主键ID
   */
  id: string | number;

  /**
   * 医生ID
   */
  doctorId: string | number;

  /**
   * 荣誉名称
   */
  honorName: string;

  /**
   * 荣誉级别 国家级/省级/市级/院级
   */
  honorLevel: string;

  /**
   * 授予单位
   */
  awardUnit: string;

  /**
   * 获得日期
   */
  awardDate: string;

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

export interface DoctorHonorForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 医生ID
   */
  doctorId?: string | number;

  /**
   * 荣誉名称
   */
  honorName?: string;

  /**
   * 荣誉级别 国家级/省级/市级/院级
   */
  honorLevel?: string;

  /**
   * 授予单位
   */
  awardUnit?: string;

  /**
   * 获得日期
   */
  awardDate?: string;

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

export interface DoctorHonorQuery extends PageQuery {
  /**
   * 医生ID
   */
  doctorId?: string | number;

  /**
   * 荣誉名称
   */
  honorName?: string;

  /**
   * 荣誉级别 国家级/省级/市级/院级
   */
  honorLevel?: string;

  /**
   * 授予单位
   */
  awardUnit?: string;

  /**
   * 获得日期
   */
  awardDate?: string;

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
