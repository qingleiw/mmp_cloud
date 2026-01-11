export interface SupervisionResultVO {
  /**
   * 督导日期
   */
  supervisionDate: string;

  /**
   * 督导人
   */
  supervisor: string;

  /**
   * 总分
   */
  totalScore: number;

  /**
   * 等级
   */
  grade: string;

  /**
   * 状态：draft-草稿，submitted-已提交，reviewed-已审核
   */
  status: string;

  /**
   * 备注
   */
  remark: string;
}

export interface SupervisionResultForm extends BaseEntity {
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
   * 专家组ID
   */
  expertGroupId?: string | number;

  /**
   * 总分
   */
  totalScore?: number;

  /**
   * 等级
   */
  grade?: string;

  /**
   * 状态：draft-草稿，submitted-已提交，reviewed-已审核
   */
  status?: string;

  /**
   * 备注
   */
  remark?: string;
}

export interface SupervisionResultQuery extends PageQuery {
  /**
   * 督导日期
   */
  supervisionDate?: string;

  /**
   * 督导人
   */
  supervisor?: string;

  /**
   * 总分
   */
  totalScore?: number;

  /**
   * 等级
   */
  grade?: string;

  /**
   * 状态：draft-草稿，submitted-已提交，reviewed-已审核
   */
  status?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
