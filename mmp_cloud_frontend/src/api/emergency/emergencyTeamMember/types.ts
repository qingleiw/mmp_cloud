export interface EmergencyTeamMemberVO {
  /**
   * 成员姓名
   */
  memberName: string;

  /**
   * 成员类型
   */
  memberType: string;

  /**
   * 所在部门
   */
  department: string;

  /**
   * 职位
   */
  position: string;

  /**
   * 专业特长
   */
  specialty: string;

  /**
   * 联系方式
   */
  contactInfo: string;

  /**
   * 紧急联系人
   */
  emergencyContact: string;

  /**
   * 状态
   */
  status: string;

  /**
   * 备注
   */
  remark: string;
}

export interface EmergencyTeamMemberForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 队伍ID
   */
  teamId?: string | number;

  /**
   * 成员姓名
   */
  memberName?: string;

  /**
   * 成员类型
   */
  memberType?: string;

  /**
   * 所在部门
   */
  department?: string;

  /**
   * 职位
   */
  position?: string;

  /**
   * 专业特长
   */
  specialty?: string;

  /**
   * 联系方式
   */
  contactInfo?: string;

  /**
   * 紧急联系人
   */
  emergencyContact?: string;

  /**
   * 状态
   */
  status?: string;

  /**
   * 备注
   */
  remark?: string;
}

export interface EmergencyTeamMemberQuery extends PageQuery {
  /**
   * 成员姓名
   */
  memberName?: string;

  /**
   * 成员类型
   */
  memberType?: string;

  /**
   * 所在部门
   */
  department?: string;

  /**
   * 职位
   */
  position?: string;

  /**
   * 专业特长
   */
  specialty?: string;

  /**
   * 联系方式
   */
  contactInfo?: string;

  /**
   * 紧急联系人
   */
  emergencyContact?: string;

  /**
   * 状态
   */
  status?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
