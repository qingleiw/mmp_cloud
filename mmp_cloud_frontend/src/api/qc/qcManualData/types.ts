export interface QcManualDataVO {
  /**
   * 主键ID
   */
  id: string | number;

  /**
   * 指标ID
   */
  indicatorId: string | number;

  /**
   * 患者ID
   */
  patientId: string | number;

  /**
   * 就诊号
   */
  visitNo: string;

  /**
   * 数据类型
   */
  dataType: string;

  /**
   * 数据字段
   */
  dataField: string;

  /**
   * 数据值
   */
  dataValue: string;

  /**
   * 数据日期
   */
  dataDate: string;

  /**
   * 操作类型 新增/修正
   */
  operationType: string;

  /**
   * 原始值
   */
  originalValue: string;

  /**
   * 修改原因
   */
  modifyReason: string;

  /**
   * 是否删除
   */
  delFlag?: string;
}

export interface QcManualDataForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 指标ID
   */
  indicatorId?: string | number;

  /**
   * 患者ID
   */
  patientId?: string | number;

  /**
   * 就诊号
   */
  visitNo?: string;

  /**
   * 数据类型
   */
  dataType?: string;

  /**
   * 数据字段
   */
  dataField?: string;

  /**
   * 数据值
   */
  dataValue?: string;

  /**
   * 数据日期
   */
  dataDate?: string;

  /**
   * 操作类型 新增/修正
   */
  operationType?: string;

  /**
   * 原始值
   */
  originalValue?: string;

  /**
   * 修改原因
   */
  modifyReason?: string;

  /**
   * 是否删除
   */
  delFlag?: string;
}

export interface QcManualDataQuery extends PageQuery {
  /**
   * 指标ID
   */
  indicatorId?: string | number;

  /**
   * 患者ID
   */
  patientId?: string | number;

  /**
   * 就诊号
   */
  visitNo?: string;

  /**
   * 数据类型
   */
  dataType?: string;

  /**
   * 数据字段
   */
  dataField?: string;

  /**
   * 数据值
   */
  dataValue?: string;

  /**
   * 数据日期
   */
  dataDate?: string;

  /**
   * 操作类型 新增/修正
   */
  operationType?: string;

  /**
   * 原始值
   */
  originalValue?: string;

  /**
   * 修改原因
   */
  modifyReason?: string;

  /**
   * 是否删除
   */
  delFlag?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
