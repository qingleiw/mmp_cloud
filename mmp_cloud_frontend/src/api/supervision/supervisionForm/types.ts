export interface SupervisionFormVO {
  /**
   * 表单编码
   */
  formCode: string;

  /**
   * 表单名称
   */
  formName: string;

  /**
   * 表单描述
   */
  formDescription: string;

  /**
   * 表单配置（JSON格式）
   */
  formConfig: string;

  /**
   * 状态
   */
  status: string;

  /**
   * 备注
   */
  remark: string;
}

export interface SupervisionFormForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 表单编码
   */
  formCode?: string;

  /**
   * 表单名称
   */
  formName?: string;

  /**
   * 关联项目ID
   */
  projectId?: string | number;

  /**
   * 表单描述
   */
  formDescription?: string;

  /**
   * 表单配置（JSON格式）
   */
  formConfig?: string;

  /**
   * 状态
   */
  status?: string;

  /**
   * 备注
   */
  remark?: string;
}

export interface SupervisionFormQuery extends PageQuery {
  /**
   * 表单编码
   */
  formCode?: string;

  /**
   * 表单名称
   */
  formName?: string;

  /**
   * 表单描述
   */
  formDescription?: string;

  /**
   * 表单配置（JSON格式）
   */
  formConfig?: string;

  /**
   * 状态
   */
  status?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
