export interface SupervisionFormFieldVO {
  /**
   * 字段编码
   */
  fieldCode: string;

  /**
   * 字段名称
   */
  fieldName: string;

  /**
   * 字段类型
   */
  fieldType: string;

  /**
   * 字段配置（JSON格式）
   */
  fieldConfig: string;

  /**
   * 是否必填：0-否，1-是
   */
  requiredFlag: string;

  /**
   * 排序
   */
  sortOrder: number;

  /**
   * 状态
   */
  status: string;

  /**
   * 备注
   */
  remark: string;
}

export interface SupervisionFormFieldForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 表单ID
   */
  formId?: string | number;

  /**
   * 字段编码
   */
  fieldCode?: string;

  /**
   * 字段名称
   */
  fieldName?: string;

  /**
   * 字段类型
   */
  fieldType?: string;

  /**
   * 字段配置（JSON格式）
   */
  fieldConfig?: string;

  /**
   * 是否必填：0-否，1-是
   */
  requiredFlag?: string;

  /**
   * 排序
   */
  sortOrder?: number;

  /**
   * 状态
   */
  status?: string;

  /**
   * 备注
   */
  remark?: string;
}

export interface SupervisionFormFieldQuery extends PageQuery {
  /**
   * 字段编码
   */
  fieldCode?: string;

  /**
   * 字段名称
   */
  fieldName?: string;

  /**
   * 字段类型
   */
  fieldType?: string;

  /**
   * 字段配置（JSON格式）
   */
  fieldConfig?: string;

  /**
   * 是否必填：0-否，1-是
   */
  requiredFlag?: string;

  /**
   * 排序
   */
  sortOrder?: number;

  /**
   * 状态
   */
  status?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
