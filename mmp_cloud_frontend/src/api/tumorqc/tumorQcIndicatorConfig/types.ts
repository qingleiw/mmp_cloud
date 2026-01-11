export interface TumorQcIndicatorConfigVO {
  /**
   * 主键ID
   */
  id: string | number;

  /**
   * 指标编码
   */
  indicatorCode: string;

  /**
   * 指标名称
   */
  indicatorName: string;

  /**
   * 指标分类
   */
  indicatorCategory: string;

  /**
   * 肿瘤类型
   */
  tumorType: string;

  /**
   * 指标类型 强制性/推荐性
   */
  indicatorType: string;

  /**
   * 计算公式
   */
  calculationFormula: string;

  /**
   * 数据来源
   */
  dataSource: string;

  /**
   * 采集频率 实时/每日/每周/每月
   */
  collectionFrequency: string;

  /**
   * 标准值
   */
  standardValue: string;

  /**
   * 目标值
   */
  targetValue: string;

  /**
   * 生效日期
   */
  effectiveDate: string;

  /**
   * 政策级别 国家级/省级/市级
   */
  policyLevel: string;

  /**
   * 政策来源
   */
  policySource: string;

  /**
   * 是否启用
   */
  isEnabled: number;

  /**
   * 是否删除
   */
  delFlag: string;
}

export interface TumorQcIndicatorConfigForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 指标编码
   */
  indicatorCode?: string;

  /**
   * 指标名称
   */
  indicatorName?: string;

  /**
   * 指标分类
   */
  indicatorCategory?: string;

  /**
   * 肿瘤类型
   */
  tumorType?: string;

  /**
   * 指标类型 强制性/推荐性
   */
  indicatorType?: string;

  /**
   * 计算公式
   */
  calculationFormula?: string;

  /**
   * 数据来源
   */
  dataSource?: string;

  /**
   * 采集频率 实时/每日/每周/每月
   */
  collectionFrequency?: string;

  /**
   * 标准值
   */
  standardValue?: string;

  /**
   * 目标值
   */
  targetValue?: string;

  /**
   * 生效日期
   */
  effectiveDate?: string;

  /**
   * 政策级别 国家级/省级/市级
   */
  policyLevel?: string;

  /**
   * 政策来源
   */
  policySource?: string;

  /**
   * 是否启用
   */
  isEnabled?: number;

  /**
   * 是否删除
   */
  delFlag?: string;
}

export interface TumorQcIndicatorConfigQuery extends PageQuery {
  /**
   * 指标编码
   */
  indicatorCode?: string;

  /**
   * 指标名称
   */
  indicatorName?: string;

  /**
   * 指标分类
   */
  indicatorCategory?: string;

  /**
   * 肿瘤类型
   */
  tumorType?: string;

  /**
   * 指标类型 强制性/推荐性
   */
  indicatorType?: string;

  /**
   * 计算公式
   */
  calculationFormula?: string;

  /**
   * 数据来源
   */
  dataSource?: string;

  /**
   * 采集频率 实时/每日/每周/每月
   */
  collectionFrequency?: string;

  /**
   * 标准值
   */
  standardValue?: string;

  /**
   * 目标值
   */
  targetValue?: string;

  /**
   * 生效日期
   */
  effectiveDate?: string;

  /**
   * 政策级别 国家级/省级/市级
   */
  policyLevel?: string;

  /**
   * 政策来源
   */
  policySource?: string;

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
