export interface SupervisionPlanFormVO {
  /**
   * 排序
   */
  sortOrder: number;

  /**
   * 备注
   */
  remark: string;
}

export interface SupervisionPlanFormForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 计划ID
   */
  planId?: string | number;

  /**
   * 表单ID
   */
  formId?: string | number;

  /**
   * 排序
   */
  sortOrder?: number;

  /**
   * 备注
   */
  remark?: string;
}

export interface SupervisionPlanFormQuery extends PageQuery {
  /**
   * 排序
   */
  sortOrder?: number;

  /**
   * 日期范围参数
   */
  params?: any;
}
