export interface DoctorQualificationCatalogVO {
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
   * 目录层级 1-一级 2-二级 3-三级 4-四级
   */
  catalogLevel: number;

  /**
   * 资质类型 手术分级/有创操作/限制类技术/处方权/会诊权/其他
   */
  catalogType: string;

  /**
   * 资质子类型
   */
  subType: string;

  /**
   * 资质描述
   */
  description: string;

  /**
   * 排序
   */
  sortOrder: number;

  /**
   * 是否启用 1-是 0-否
   */
  isEnabled: number;

  /**
   * 是否删除
   */
  delFlag?: string;
}

export interface DoctorQualificationCatalogForm extends BaseEntity {
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
   * 目录层级 1-一级 2-二级 3-三级 4-四级
   */
  catalogLevel?: number;

  /**
   * 资质类型 手术分级/有创操作/限制类技术/处方权/会诊权/其他
   */
  catalogType?: string;

  /**
   * 资质子类型
   */
  subType?: string;

  /**
   * 资质描述
   */
  description?: string;

  /**
   * 排序
   */
  sortOrder?: number;

  /**
   * 是否启用 1-是 0-否
   */
  isEnabled?: number;

  /**
   * 是否删除
   */
  delFlag?: string;
}

export interface DoctorQualificationCatalogQuery extends PageQuery {
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
   * 目录层级 1-一级 2-二级 3-三级 4-四级
   */
  catalogLevel?: number;

  /**
   * 资质类型 手术分级/有创操作/限制类技术/处方权/会诊权/其他
   */
  catalogType?: string;

  /**
   * 资质子类型
   */
  subType?: string;

  /**
   * 资质描述
   */
  description?: string;

  /**
   * 排序
   */
  sortOrder?: number;

  /**
   * 是否启用 1-是 0-否
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
