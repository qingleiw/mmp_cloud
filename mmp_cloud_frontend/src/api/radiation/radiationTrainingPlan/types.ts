export interface RadiationTrainingPlanVO {
  id: string | number;
  /**
   * 计划编码
   */
  planCode: string;

  /**
   * 计划名称
   */
  planName: string;

  /**
   * 培训类型：radiation-放射防护，safety-安全培训，emergency-应急培训
   */
  trainingType: string;

  /**
   * 计划日期
   */
  plannedDate: string;

  /**
   * 计划时间
   */
  plannedTime: string;

  /**
   * 培训地点
   */
  location: string;

  /**
   * 培训师
   */
  trainer: string;

  /**
   * 培训内容
   */
  trainingContent: string;

  /**
   * 培训对象
   */
  targetAudience: string;

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

export interface RadiationTrainingPlanForm extends BaseEntity {
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
   * 培训类型：radiation-放射防护，safety-安全培训，emergency-应急培训
   */
  trainingType?: string;

  /**
   * 计划日期
   */
  plannedDate?: string;

  /**
   * 计划时间
   */
  plannedTime?: string;

  /**
   * 培训地点
   */
  location?: string;

  /**
   * 培训师
   */
  trainer?: string;

  /**
   * 培训内容
   */
  trainingContent?: string;

  /**
   * 培训对象
   */
  targetAudience?: string;

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

  /**
   * 删除标志
   */
  delFlag?: string;
}

export interface RadiationTrainingPlanQuery extends PageQuery {
  /**
   * 计划编码
   */
  planCode?: string;

  /**
   * 计划名称
   */
  planName?: string;

  /**
   * 培训类型：radiation-放射防护，safety-安全培训，emergency-应急培训
   */
  trainingType?: string;

  /**
   * 计划日期
   */
  plannedDate?: string;

  /**
   * 计划时间
   */
  plannedTime?: string;

  /**
   * 培训地点
   */
  location?: string;

  /**
   * 培训师
   */
  trainer?: string;

  /**
   * 培训内容
   */
  trainingContent?: string;

  /**
   * 培训对象
   */
  targetAudience?: string;

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
   * 删除标志
   */
  delFlag?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
