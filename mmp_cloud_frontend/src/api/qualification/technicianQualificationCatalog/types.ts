export interface TechnicianQualificationCatalogVO {
  /**
   * 主键ID
   */
  id: string | number;

  /**
   * 资质编码
   */
  catalogCode: string;

  /**
   * 资质名称
   */
  catalogName: string;

  /**
   * 父级ID
   */
  parentId: string | number;

  /**
   * 目录层级
   */
  catalogLevel: number;

  /**
   * 资质类型 检查/检验/心电/病理/输血/核医学/放疗/POCT/药学调配
   */
  catalogType: string;

  /**
   * 资质描述
   */
  description: string;

  /**
   * 排序
   */
  sortOrder: number;

  /**
   * 是否启用
   */
  isEnabled: number;

  /**
   * 是否删除
   */
  delFlag?: string;
}

export interface TechnicianQualificationCatalogForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 资质编码
   */
  catalogCode?: string;

  /**
   * 资质名称
   */
  catalogName?: string;

  /**
   * 父级ID
   */
  parentId?: string | number;

  /**
   * 目录层级
   */
  catalogLevel?: number;

  /**
   * 资质类型 检查/检验/心电/病理/输血/核医学/放疗/POCT/药学调配
   */
  catalogType?: string;

  /**
   * 资质描述
   */
  description?: string;

  /**
   * 排序
   */
  sortOrder?: number;

  /**
   * 是否启用
   */
  isEnabled?: number;

  /**
   * 是否删除
   */
  delFlag?: string;
}

export interface TechnicianQualificationCatalogQuery extends PageQuery {
  /**
   * 资质编码
   */
  catalogCode?: string;

  /**
   * 资质名称
   */
  catalogName?: string;

  /**
   * 父级ID
   */
  parentId?: string | number;

  /**
   * 目录层级
   */
  catalogLevel?: number;

  /**
   * 资质类型 检查/检验/心电/病理/输血/核医学/放疗/POCT/药学调配
   */
  catalogType?: string;

  /**
   * 资质描述
   */
  description?: string;

  /**
   * 排序
   */
  sortOrder?: number;

  /**
   * 是否启用
   */
  isEnabled?: number;

  /**
   * 是否删除
   */
  delFlag?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
