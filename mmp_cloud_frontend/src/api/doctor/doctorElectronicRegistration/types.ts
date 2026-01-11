export interface DoctorElectronicRegistrationVO {
  /**
   * 主键ID
   */
  id: string | number;

  /**
   * 医生ID
   */
  doctorId: string | number;

  /**
   * 注册编号
   */
  registrationNo: string;

  /**
   * 注册类型 首次注册/变更注册/多机构备案
   */
  registrationType: string;

  /**
   * 执业类别
   */
  practiceCategory: string;

  /**
   * 执业范围
   */
  practiceScope: string;

  /**
   * 执业地点
   */
  practiceLocation: string;

  /**
   * 发证日期
   */
  issueDate: string;

  /**
   * 有效期至
   */
  validDate: string | number;

  /**
   * 注册机关
   */
  registrationAuthority: string;

  /**
   * 注册状态 有效/注销/吊销
   */
  registrationStatus: string;

  /**
   * 是否多机构备案 1-是 0-否
   */
  multiInstitutionFlag: number;

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

export interface DoctorElectronicRegistrationForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 医生ID
   */
  doctorId?: string | number;

  /**
   * 注册编号
   */
  registrationNo?: string;

  /**
   * 注册类型 首次注册/变更注册/多机构备案
   */
  registrationType?: string;

  /**
   * 执业类别
   */
  practiceCategory?: string;

  /**
   * 执业范围
   */
  practiceScope?: string;

  /**
   * 执业地点
   */
  practiceLocation?: string;

  /**
   * 发证日期
   */
  issueDate?: string;

  /**
   * 有效期至
   */
  validDate?: string | number;

  /**
   * 注册机关
   */
  registrationAuthority?: string;

  /**
   * 注册状态 有效/注销/吊销
   */
  registrationStatus?: string;

  /**
   * 是否多机构备案 1-是 0-否
   */
  multiInstitutionFlag?: number;

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

export interface DoctorElectronicRegistrationQuery extends PageQuery {
  /**
   * 医生ID
   */
  doctorId?: string | number;

  /**
   * 注册编号
   */
  registrationNo?: string;

  /**
   * 注册类型 首次注册/变更注册/多机构备案
   */
  registrationType?: string;

  /**
   * 执业类别
   */
  practiceCategory?: string;

  /**
   * 执业范围
   */
  practiceScope?: string;

  /**
   * 执业地点
   */
  practiceLocation?: string;

  /**
   * 发证日期
   */
  issueDate?: string;

  /**
   * 有效期至
   */
  validDate?: string | number;

  /**
   * 注册机关
   */
  registrationAuthority?: string;

  /**
   * 注册状态 有效/注销/吊销
   */
  registrationStatus?: string;

  /**
   * 是否多机构备案 1-是 0-否
   */
  multiInstitutionFlag?: number;

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
