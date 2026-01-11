export interface QcIndicatorCollectionConfigVO {
  /**
   * 主键ID
   */
  id: string | number;

  /**
   * 指标ID
   */
  indicatorId: string | number;

  /**
   * 来源系统 HIS/EMR/LIS/PACS等
   */
  sourceSystem: string;

  /**
   * 来源表
   */
  sourceTable: string;

  /**
   * 来源字段
   */
  sourceField: string;

  /**
   * 提取规则
   */
  extractionRule: string;

  /**
   * 数据类型
   */
  dataType: string;

  /**
   * 是否必需 1-是 0-否
   */
  isRequired: number;

  /**
   * 默认值
   */
  defaultValue: string;

  /**
   * 校验规则
   */
  validationRule: string | number;

  /**
   * 是否删除
   */
  delFlag?: string;
}

export interface QcIndicatorCollectionConfigForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 指标ID
   */
  indicatorId?: string | number;

  /**
   * 来源系统 HIS/EMR/LIS/PACS等
   */
  sourceSystem?: string;

  /**
   * 来源表
   */
  sourceTable?: string;

  /**
   * 来源字段
   */
  sourceField?: string;

  /**
   * 提取规则
   */
  extractionRule?: string;

  /**
   * 数据类型
   */
  dataType?: string;

  /**
   * 是否必需 1-是 0-否
   */
  isRequired?: number;

  /**
   * 默认值
   */
  defaultValue?: string;

  /**
   * 校验规则
   */
  validationRule?: string | number;

  /**
   * 是否删除
   */
  delFlag?: string;
}

export interface QcIndicatorCollectionConfigQuery extends PageQuery {
  /**
   * 指标ID
   */
  indicatorId?: string | number;

  /**
   * 来源系统 HIS/EMR/LIS/PACS等
   */
  sourceSystem?: string;

  /**
   * 来源表
   */
  sourceTable?: string;

  /**
   * 来源字段
   */
  sourceField?: string;

  /**
   * 提取规则
   */
  extractionRule?: string;

  /**
   * 数据类型
   */
  dataType?: string;

  /**
   * 是否必需 1-是 0-否
   */
  isRequired?: number;

  /**
   * 默认值
   */
  defaultValue?: string;

  /**
   * 校验规则
   */
  validationRule?: string | number;

  /**
   * 是否删除
   */
  delFlag?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
