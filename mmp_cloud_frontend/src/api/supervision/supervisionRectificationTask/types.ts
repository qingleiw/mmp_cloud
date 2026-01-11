export interface SupervisionRectificationTaskVO {
  /**
   * 任务描述
   */
  taskDescription: string;

  /**
   * 责任部门
   */
  responsibleDept: string;

  /**
   * 责任人
   */
  responsiblePerson: string;

  /**
   * 截止日期
   */
  deadline: string;

  /**
   * 状态
   */
  status: string;

  /**
   * 备注
   */
  remark: string;
}

export interface SupervisionRectificationTaskForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 问题ID
   */
  issueId?: string | number;

  /**
   * 任务描述
   */
  taskDescription?: string;

  /**
   * 责任部门
   */
  responsibleDept?: string;

  /**
   * 责任人
   */
  responsiblePerson?: string;

  /**
   * 截止日期
   */
  deadline?: string;

  /**
   * 状态
   */
  status?: string;

  /**
   * 备注
   */
  remark?: string;
}

export interface SupervisionRectificationTaskQuery extends PageQuery {
  /**
   * 任务描述
   */
  taskDescription?: string;

  /**
   * 责任部门
   */
  responsibleDept?: string;

  /**
   * 责任人
   */
  responsiblePerson?: string;

  /**
   * 截止日期
   */
  deadline?: string;

  /**
   * 状态
   */
  status?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
