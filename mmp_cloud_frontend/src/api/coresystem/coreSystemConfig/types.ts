export interface CoreSystemConfigVO {
  /**
   * 主键ID
   */
  id: string | number;

  /**
   * 制度编码
   */
  systemCode: string;

  /**
   * 制度名称
   */
  systemName: string;

  /**
   * 制度类型
   */
  systemType: string;

  /**
   * 制度描述
   */
  systemDescription: string;

  /**
   * 制度总分
   */
  totalScore: number;

  /**
   * 权重
   */
  weight: number;

  /**
   * 是否启用
   */
  isEnabled: number;

  /**
   * 是否自定义 1-是 0-否
   */
  isCustom: number;

  /**
   * 是否删除
   */
  delFlag?: string;
}

export interface CoreSystemConfigForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 制度编码
   */
  systemCode?: string;

  /**
   * 制度名称
   */
  systemName?: string;

  /**
   * 制度类型
   */
  systemType?: string;

  /**
   * 制度描述
   */
  systemDescription?: string;

  /**
   * 制度总分
   */
  totalScore?: number;

  /**
   * 权重
   */
  weight?: number;

  /**
   * 是否启用
   */
  isEnabled?: number;

  /**
   * 是否自定义 1-是 0-否
   */
  isCustom?: number;

  /**
   * 是否删除
   */
  delFlag?: string;
}

export interface CoreSystemConfigQuery extends PageQuery {
  /**
   * 制度编码
   */
  systemCode?: string;

  /**
   * 制度名称
   */
  systemName?: string;

  /**
   * 制度类型
   */
  systemType?: string;

  /**
   * 制度描述
   */
  systemDescription?: string;

  /**
   * 制度总分
   */
  totalScore?: number;

  /**
   * 权重
   */
  weight?: number;

  /**
   * 是否启用
   */
  isEnabled?: number;

  /**
   * 是否自定义 1-是 0-否
   */
  isCustom?: number;

  /**
   * 是否删除
   */
  delFlag?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
