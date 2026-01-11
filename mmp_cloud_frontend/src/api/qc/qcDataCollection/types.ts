export interface QcDataCollectionVO {
  /**
   * 统计周期：monthly-月度，quarterly-季度，yearly-年度
   */
  collectionPeriod: string;

  /**
   * 统计年份
   */
  collectionYear: number;

  /**
   * 统计月份
   */
  collectionMonth: number;

  /**
   * 统计季度
   */
  collectionQuarter: number;

  /**
   * 科室名称
   */
  departmentName: string;

  /**
   * 分子值
   */
  numeratorValue: number;

  /**
   * 分母值
   */
  denominatorValue: number;

  /**
   * 指标值（计算结果）
   */
  indicatorValue: number;

  /**
   * 数据状态：0-草稿，1-已提交，2-已审核
   */
  dataStatus: number;

  /**
   * 采集人
   */
  collector: string;

  /**
   * 审核人
   */
  reviewer: string;

  /**
   * 采集时间
   */
  collectionTime: string;

  /**
   * 审核时间
   */
  reviewTime: string;

  /**
   * 备注
   */
  remark: string;

  /**
   * 是否删除
   */
  delFlag: string;
}

export interface QcDataCollectionForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 指标ID
   */
  indicatorId?: string | number;

  /**
   * 统计周期：monthly-月度，quarterly-季度，yearly-年度
   */
  collectionPeriod?: string;

  /**
   * 统计年份
   */
  collectionYear?: number;

  /**
   * 统计月份
   */
  collectionMonth?: number;

  /**
   * 统计季度
   */
  collectionQuarter?: number;

  /**
   * 科室ID
   */
  departmentId?: string | number;

  /**
   * 科室名称
   */
  departmentName?: string;

  /**
   * 分子值
   */
  numeratorValue?: number;

  /**
   * 分母值
   */
  denominatorValue?: number;

  /**
   * 指标值（计算结果）
   */
  indicatorValue?: number;

  /**
   * 数据状态：0-草稿，1-已提交，2-已审核
   */
  dataStatus?: number;

  /**
   * 采集人
   */
  collector?: string;

  /**
   * 审核人
   */
  reviewer?: string;

  /**
   * 采集时间
   */
  collectionTime?: string;

  /**
   * 审核时间
   */
  reviewTime?: string;

  /**
   * 备注
   */
  remark?: string;

  /**
   * 是否删除
   */
  delFlag?: string;
}

export interface QcDataCollectionQuery extends PageQuery {
  /**
   * 统计周期：monthly-月度，quarterly-季度，yearly-年度
   */
  collectionPeriod?: string;

  /**
   * 统计年份
   */
  collectionYear?: number;

  /**
   * 统计月份
   */
  collectionMonth?: number;

  /**
   * 统计季度
   */
  collectionQuarter?: number;

  /**
   * 科室名称
   */
  departmentName?: string;

  /**
   * 分子值
   */
  numeratorValue?: number;

  /**
   * 分母值
   */
  denominatorValue?: number;

  /**
   * 指标值（计算结果）
   */
  indicatorValue?: number;

  /**
   * 数据状态：0-草稿，1-已提交，2-已审核
   */
  dataStatus?: number;

  /**
   * 采集人
   */
  collector?: string;

  /**
   * 审核人
   */
  reviewer?: string;

  /**
   * 采集时间
   */
  collectionTime?: string;

  /**
   * 审核时间
   */
  reviewTime?: string;

  /**
   * 是否删除
   */
  delFlag?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
