export interface TumorQcIndicatorDetailVO {
  /**
   * 主键ID
   */
  id: string | number;

  /**
   * 监测记录ID
   */
  recordId: string | number;

  /**
   * 指标ID
   */
  indicatorId: string | number;

  /**
   * 患者ID
   */
  patientId: string | number;

  /**
   * 患者姓名
   */
  patientName: string;

  /**
   * 就诊号
   */
  visitNo: string;

  /**
   * 诊断
   */
  diagnosis: string;

  /**
   * 指标结果 达标/不达标/不适用
   */
  indicatorResult: string;

  /**
   * 结果说明
   */
  resultDescription: string;

  /**
   * 相关数据JSON
   */
  relatedData: string;
}

export interface TumorQcIndicatorDetailForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 监测记录ID
   */
  recordId?: string | number;

  /**
   * 指标ID
   */
  indicatorId?: string | number;

  /**
   * 患者ID
   */
  patientId?: string | number;

  /**
   * 患者姓名
   */
  patientName?: string;

  /**
   * 就诊号
   */
  visitNo?: string;

  /**
   * 诊断
   */
  diagnosis?: string;

  /**
   * 指标结果 达标/不达标/不适用
   */
  indicatorResult?: string;

  /**
   * 结果说明
   */
  resultDescription?: string;

  /**
   * 相关数据JSON
   */
  relatedData?: string;
}

export interface TumorQcIndicatorDetailQuery extends PageQuery {
  /**
   * 监测记录ID
   */
  recordId?: string | number;

  /**
   * 指标ID
   */
  indicatorId?: string | number;

  /**
   * 患者ID
   */
  patientId?: string | number;

  /**
   * 患者姓名
   */
  patientName?: string;

  /**
   * 就诊号
   */
  visitNo?: string;

  /**
   * 诊断
   */
  diagnosis?: string;

  /**
   * 指标结果 达标/不达标/不适用
   */
  indicatorResult?: string;

  /**
   * 结果说明
   */
  resultDescription?: string;

  /**
   * 相关数据JSON
   */
  relatedData?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
