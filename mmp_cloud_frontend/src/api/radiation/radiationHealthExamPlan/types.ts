export interface RadiationHealthExamPlanVO {
  /**
   * 计划编码
   */
  planCode: string;

  /**
   * 计划名称
   */
  planName: string;

  /**
   * 体检类型：annual-年度体检，special-专项体检
   */
  examType: string;

  /**
   * 计划日期
   */
  plannedDate: string;

  /**
   * 体检地点
   */
  location: string;

  /**
   * 体检机构
   */
  examAgency: string;

  /**
   * 体检对象
   */
  targetStaff: string;

  /**
   * 状态：planned-已计划，ongoing-进行中，completed-已完成，cancelled-已取消
   */
  status: string;

  /**
   * 是否已发送提醒：0-否，1-是
   */
  reminderSent: string;

  /**
   * 提醒时间
   */
  reminderTime: string;

  /**
   * 备注
   */
  remark: string;
}

export interface RadiationHealthExamPlanForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 计划编码
   */
  planCode?: string;

  /**
   * 计划名称
   */
  planName?: string;

  /**
   * 体检类型：annual-年度体检，special-专项体检
   */
  examType?: string;

  /**
   * 计划日期
   */
  plannedDate?: string;

  /**
   * 体检地点
   */
  location?: string;

  /**
   * 体检机构
   */
  examAgency?: string;

  /**
   * 体检对象
   */
  targetStaff?: string;

  /**
   * 状态：planned-已计划，ongoing-进行中，completed-已完成，cancelled-已取消
   */
  status?: string;

  /**
   * 是否已发送提醒：0-否，1-是
   */
  reminderSent?: string;

  /**
   * 提醒时间
   */
  reminderTime?: string;

  /**
   * 备注
   */
  remark?: string;
}

export interface RadiationHealthExamPlanQuery extends PageQuery {
  /**
   * 计划编码
   */
  planCode?: string;

  /**
   * 计划名称
   */
  planName?: string;

  /**
   * 体检类型：annual-年度体检，special-专项体检
   */
  examType?: string;

  /**
   * 计划日期
   */
  plannedDate?: string;

  /**
   * 体检地点
   */
  location?: string;

  /**
   * 体检机构
   */
  examAgency?: string;

  /**
   * 体检对象
   */
  targetStaff?: string;

  /**
   * 状态：planned-已计划，ongoing-进行中，completed-已完成，cancelled-已取消
   */
  status?: string;

  /**
   * 是否已发送提醒：0-否，1-是
   */
  reminderSent?: string;

  /**
   * 提醒时间
   */
  reminderTime?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
