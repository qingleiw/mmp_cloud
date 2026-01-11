export interface QcSpecialtyCategoryVO {
  /**
   * 专业代码
   */
  categoryCode: string;

  /**
   * 专业名称
   */
  categoryName: string;

  /**
   * 发布年份
   */
  publishYear: number;

  /**
   * 排序
   */
  sortOrder: number;

  /**
   * 状态：1-启用，0-禁用
   */
  status: number;

  /**
   * 是否删除
   */
  delFlag?: string;
}

export interface QcSpecialtyCategoryForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 专业代码
   */
  categoryCode?: string;

  /**
   * 专业名称
   */
  categoryName?: string;

  /**
   * 发布年份
   */
  publishYear?: number;

  /**
   * 排序
   */
  sortOrder?: number;

  /**
   * 状态：1-启用，0-禁用
   */
  status?: number;

  /**
   * 是否删除
   */
  delFlag?: string;
}

export interface QcSpecialtyCategoryQuery extends PageQuery {
  /**
   * 专业代码
   */
  categoryCode?: string;

  /**
   * 专业名称
   */
  categoryName?: string;

  /**
   * 发布年份
   */
  publishYear?: number;

  /**
   * 排序
   */
  sortOrder?: number;

  /**
   * 状态：1-启用，0-禁用
   */
  status?: number;

  /**
   * 是否删除
   */
  delFlag?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
