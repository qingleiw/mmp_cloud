export interface NewTechnologyProjectMappingVO {
  /**
   * 对码类型 医嘱项/ICD-9/收费项
   */
  mappingType: string;

  /**
   * 源编码
   */
  sourceCode: string;

  /**
   * 源名称
   */
  sourceName: string;

  /**
   * 目标系统 HIS/收费系统
   */
  targetSystem: string;

  /**
   * 备注
   */
  remark: string;
}

export interface NewTechnologyProjectMappingForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 项目ID
   */
  projectId?: string | number;

  /**
   * 对码类型 医嘱项/ICD-9/收费项
   */
  mappingType?: string;

  /**
   * 源编码
   */
  sourceCode?: string;

  /**
   * 源名称
   */
  sourceName?: string;

  /**
   * 目标系统 HIS/收费系统
   */
  targetSystem?: string;

  /**
   * 备注
   */
  remark?: string;
}

export interface NewTechnologyProjectMappingQuery extends PageQuery {
  /**
   * 对码类型 医嘱项/ICD-9/收费项
   */
  mappingType?: string;

  /**
   * 源编码
   */
  sourceCode?: string;

  /**
   * 源名称
   */
  sourceName?: string;

  /**
   * 目标系统 HIS/收费系统
   */
  targetSystem?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
