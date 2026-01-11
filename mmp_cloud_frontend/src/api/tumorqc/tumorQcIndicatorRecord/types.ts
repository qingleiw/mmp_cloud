export interface TumorQcIndicatorRecordVO {
  /**
   * 主键ID
   */
  id: string | number;

  /**
   * 记录日期
   */
  recordDate: string;

  /**
   * 计算周期
   */
  calculationCycle: string;

  /**
   * 科室ID
   */
  departmentId: string | number;

  /**
   * 科室名称
   */
  departmentName: string;

  /**
   * 指标ID
   */
  indicatorId: string | number;

  /**
   * 指标编码
   */
  indicatorCode: string;

  /**
   * 指标名称
   */
  indicatorName: string;

  /**
   * 分子
   */
  numerator: number;

  /**
   * 分母
   */
  denominator: number;

  /**
   * 指标值
   */
  indicatorValue: number;

  /**
   * 目标值
   */
  targetValue: string;

  /**
   * 达标状态 达标/不达标
   */
  complianceStatus: string;

  /**
   * 完成率(%)
   */
  completionRate: number;

  /**
   * 院内排名
   */
  rankInHospital: number;

  /**
   * 趋势方向
   */
  trendDirection: string;

  /**
   * 是否异常 1-是 0-否
   */
  isAbnormal: number;

  /**
   * 数据来源说明
   */
  dataSource: string;

  /**
   * 是否人工录入 1-是 0-否
   */
  isManual: number;

  /**
   * 备注
   */
  remark: string;
}

export interface TumorQcIndicatorRecordForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 记录日期
   */
  recordDate?: string;

  /**
   * 计算周期
   */
  calculationCycle?: string;

  /**
   * 科室ID
   */
  departmentId?: string | number;

  /**
   * 科室名称
   */
  departmentName?: string;

  /**
   * 指标ID
   */
  indicatorId?: string | number;

  /**
   * 指标编码
   */
  indicatorCode?: string;

  /**
   * 指标名称
   */
  indicatorName?: string;

  /**
   * 分子
   */
  numerator?: number;

  /**
   * 分母
   */
  denominator?: number;

  /**
   * 指标值
   */
  indicatorValue?: number;

  /**
   * 目标值
   */
  targetValue?: string;

  /**
   * 达标状态 达标/不达标
   */
  complianceStatus?: string;

  /**
   * 完成率(%)
   */
  completionRate?: number;

  /**
   * 院内排名
   */
  rankInHospital?: number;

  /**
   * 趋势方向
   */
  trendDirection?: string;

  /**
   * 是否异常 1-是 0-否
   */
  isAbnormal?: number;

  /**
   * 数据来源说明
   */
  dataSource?: string;

  /**
   * 是否人工录入 1-是 0-否
   */
  isManual?: number;

  /**
   * 备注
   */
  remark?: string;
}

export interface TumorQcIndicatorRecordQuery extends PageQuery {
  /**
   * 记录日期
   */
  recordDate?: string;

  /**
   * 计算周期
   */
  calculationCycle?: string;

  /**
   * 科室ID
   */
  departmentId?: string | number;

  /**
   * 科室名称
   */
  departmentName?: string;

  /**
   * 指标ID
   */
  indicatorId?: string | number;

  /**
   * 指标编码
   */
  indicatorCode?: string;

  /**
   * 指标名称
   */
  indicatorName?: string;

  /**
   * 分子
   */
  numerator?: number;

  /**
   * 分母
   */
  denominator?: number;

  /**
   * 指标值
   */
  indicatorValue?: number;

  /**
   * 目标值
   */
  targetValue?: string;

  /**
   * 达标状态 达标/不达标
   */
  complianceStatus?: string;

  /**
   * 完成率(%)
   */
  completionRate?: number;

  /**
   * 院内排名
   */
  rankInHospital?: number;

  /**
   * 趋势方向
   */
  trendDirection?: string;

  /**
   * 是否异常 1-是 0-否
   */
  isAbnormal?: number;

  /**
   * 数据来源说明
   */
  dataSource?: string;

  /**
   * 是否人工录入 1-是 0-否
   */
  isManual?: number;

  /**
   * 日期范围参数
   */
  params?: any;
}
