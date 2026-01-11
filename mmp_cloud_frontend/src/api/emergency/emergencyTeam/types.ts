export interface EmergencyTeamVO {
  /**
   * 队伍编码
   */
  teamCode: string;

  /**
   * 队伍名称
   */
  teamName: string;

  /**
   * 队伍类型
   */
  teamType: string;

  /**
   * 专业特长
   */
  specialty: string;

  /**
   * 队长
   */
  leader: string;

  /**
   * 联系方式
   */
  contactInfo: string;

  /**
   * 成员数量
   */
  memberCount: number;

  /**
   * 状态
   */
  status: string;

  /**
   * 备注
   */
  remark: string;
}

export interface EmergencyTeamForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 队伍编码
   */
  teamCode?: string;

  /**
   * 队伍名称
   */
  teamName?: string;

  /**
   * 队伍类型
   */
  teamType?: string;

  /**
   * 专业特长
   */
  specialty?: string;

  /**
   * 队长
   */
  leader?: string;

  /**
   * 联系方式
   */
  contactInfo?: string;

  /**
   * 成员数量
   */
  memberCount?: number;

  /**
   * 状态
   */
  status?: string;

  /**
   * 备注
   */
  remark?: string;
}

export interface EmergencyTeamQuery extends PageQuery {
  /**
   * 队伍编码
   */
  teamCode?: string;

  /**
   * 队伍名称
   */
  teamName?: string;

  /**
   * 队伍类型
   */
  teamType?: string;

  /**
   * 专业特长
   */
  specialty?: string;

  /**
   * 队长
   */
  leader?: string;

  /**
   * 联系方式
   */
  contactInfo?: string;

  /**
   * 成员数量
   */
  memberCount?: number;

  /**
   * 状态
   */
  status?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
