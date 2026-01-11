export interface SupervisionPlanDeptVO {
  /**
   * 督导日期
   */
  supervisionDate: string;

  /**
   * 督导人
   */
  supervisor: string;

  /**
   * 状态：pending-待督导，completed-已完成
   */
  status: string;

  /**
   * 备注
   */
  remark: string;
}

export interface SupervisionPlanDeptForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 计划ID
   */
  planId?: string | number;

  /**
   * 科室ID
   */
  deptId?: string | number;

  /**
   * 督导日期
   */
  supervisionDate?: string;

  /**
   * 督导人
   */
  supervisor?: string;

  /**
   * 状态：pending-待督导，completed-已完成
   */
  status?: string;

  /**
   * 备注
   */
  remark?: string;
}

export interface SupervisionPlanDeptQuery extends PageQuery {
  /**
   * 督导日期
   */
  supervisionDate?: string;

  /**
   * 督导人
   */
  supervisor?: string;

  /**
   * 状态：pending-待督导，completed-已完成
   */
  status?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
