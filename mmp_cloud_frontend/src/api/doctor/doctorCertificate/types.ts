export interface DoctorCertificateVO {
  /**
   * 主键ID
   */
  id: string | number;

  /**
   * 医生ID
   */
  doctorId: string | number;

  /**
   * 医生姓名
   */
  doctorName: string;

  /**
   * 证书类型 执业/资格/培训等
   */
  certificateType: string;

  /**
   * 证书名称
   */
  certificateName: string;

  /**
   * 证书编号
   */
  certificateNo: string;

  /**
   * 发证机构
   */
  issueUnit: string;

  /**
   * 发证日期
   */
  issueDate: string;

  /**
   * 有效期至
   */
  validDate: string | number;

  /**
   * 是否长期有效 1-是 0-否
   */
  isPermanent: number;

  /**
   * 证书附件URL
   */
  certificateUrl: string;

  /**
   * 状态 1-有效 2-即将到期 3-已过期 4-已注销
   */
  status: number;

  /**
   * 提前提醒天数
   */
  remindDays: number;

  /**
   * 备注
   */
  remark: string;

  /**
   * 是否删除
   */
  delFlag?: string;
}

export interface DoctorCertificateForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 医生ID
   */
  doctorId?: string | number;

  /**
   * 证书类型 执业/资格/培训等
   */
  certificateType?: string;

  /**
   * 证书名称
   */
  certificateName?: string;

  /**
   * 证书编号
   */
  certificateNo?: string;

  /**
   * 发证机构
   */
  issueUnit?: string;

  /**
   * 发证日期
   */
  issueDate?: string;

  /**
   * 有效期至
   */
  validDate?: string | number;

  /**
   * 是否长期有效 1-是 0-否
   */
  isPermanent?: number;

  /**
   * 证书附件URL
   */
  certificateUrl?: string;

  /**
   * 状态 1-有效 2-即将到期 3-已过期 4-已注销
   */
  status?: number;

  /**
   * 提前提醒天数
   */
  remindDays?: number;

  /**
   * 备注
   */
  remark?: string;

  /**
   * 是否删除
   */
  delFlag?: string;
}

export interface DoctorCertificateQuery extends PageQuery {
  /**
   * 医生ID
   */
  doctorId?: string | number;

  /**
   * 证书类型 执业/资格/培训等
   */
  certificateType?: string;

  /**
   * 证书名称
   */
  certificateName?: string;

  /**
   * 证书编号
   */
  certificateNo?: string;

  /**
   * 发证机构
   */
  issueUnit?: string;

  /**
   * 发证日期
   */
  issueDate?: string;

  /**
   * 有效期至
   */
  validDate?: string | number;

  /**
   * 是否长期有效 1-是 0-否
   */
  isPermanent?: number;

  /**
   * 证书附件URL
   */
  certificateUrl?: string;

  /**
   * 状态 1-有效 2-即将到期 3-已过期 4-已注销
   */
  status?: number;

  /**
   * 提前提醒天数
   */
  remindDays?: number;

  /**
   * 是否删除
   */
  delFlag?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
