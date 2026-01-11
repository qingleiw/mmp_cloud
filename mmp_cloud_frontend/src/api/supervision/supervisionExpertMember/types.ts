export interface SupervisionExpertMemberVO {
  /**
   * 专家姓名
   */
  expertName: string;

  /**
   * 专家职称
   */
  expertTitle: string;

  /**
   * 所在医院
   */
  hospital: string;

  /**
   * 专业特长
   */
  specialty: string;

  /**
   * 联系方式
   */
  contactInfo: string;

  /**
   * 状态
   */
  status: string;

  /**
   * 备注
   */
  remark: string;
}

export interface SupervisionExpertMemberForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 专家组ID
   */
  groupId?: string | number;

  /**
   * 专家姓名
   */
  expertName?: string;

  /**
   * 专家职称
   */
  expertTitle?: string;

  /**
   * 所在医院
   */
  hospital?: string;

  /**
   * 专业特长
   */
  specialty?: string;

  /**
   * 联系方式
   */
  contactInfo?: string;

  /**
   * 状态
   */
  status?: string;

  /**
   * 备注
   */
  remark?: string;
}

export interface SupervisionExpertMemberQuery extends PageQuery {
  /**
   * 专家姓名
   */
  expertName?: string;

  /**
   * 专家职称
   */
  expertTitle?: string;

  /**
   * 所在医院
   */
  hospital?: string;

  /**
   * 专业特长
   */
  specialty?: string;

  /**
   * 联系方式
   */
  contactInfo?: string;

  /**
   * 状态
   */
  status?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
