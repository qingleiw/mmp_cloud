export interface SurgeryCatalogVO {
  /**
   * 附加编码
   */
  additionalCode: string;

  /**
   * 细目代码
   */
  detailCode: string;

  /**
   * 手术操作名称
   */
  surgeryName: string;

  /**
   * 类别
   */
  category: string;

  /**
   * 手术等级
   */
  surgeryLevel: string;

  /**
   * 是否启用
   */
  isEnabled: number;

  /**
   * 所属科室
   */
  department: string;

  /**
   * 手术分类
   */
  surgeryCategory: string;

  /**
   * 备注
   */
  remark: string;
}

export interface SurgeryCatalogForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 附加编码
   */
  additionalCode?: string;

  /**
   * 细目代码
   */
  detailCode?: string;

  /**
   * 手术操作名称
   */
  surgeryName?: string;

  /**
   * 类别
   */
  category?: string;

  /**
   * 手术等级
   */
  surgeryLevel?: string;

  /**
   * 是否启用
   */
  isEnabled?: number;

  /**
   * 所属科室
   */
  department?: string;

  /**
   * 手术分类
   */
  surgeryCategory?: string;

  /**
   * 备注
   */
  remark?: string;
}

export interface SurgeryCatalogQuery extends PageQuery {
  /**
   * 附加编码
   */
  additionalCode?: string;

  /**
   * 细目代码
   */
  detailCode?: string;

  /**
   * 手术操作名称
   */
  surgeryName?: string;

  /**
   * 类别
   */
  category?: string;

  /**
   * 手术等级
   */
  surgeryLevel?: string;

  /**
   * 是否启用
   */
  isEnabled?: number;

  /**
   * 所属科室
   */
  department?: string;

  /**
   * 手术分类
   */
  surgeryCategory?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
