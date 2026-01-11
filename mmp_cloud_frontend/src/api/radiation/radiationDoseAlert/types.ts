export interface RadiationDoseAlertVO {
  /**
   * 预警类型：monthly-月度预警，quarterly-季度预警，yearly-年度预警
   */
  alertType: string;

  /**
   * 阈值
   */
  thresholdValue: number;

  /**
   * 预警级别：low-低，medium-中，high-高
   */
  alertLevel: string;

  /**
   * 是否启用：0-否，1-是
   */
  isActive: string;

  /**
   * 备注
   */
  remark: string;
}

export interface RadiationDoseAlertForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 预警类型：monthly-月度预警，quarterly-季度预警，yearly-年度预警
   */
  alertType?: string;

  /**
   * 阈值
   */
  thresholdValue?: number;

  /**
   * 预警级别：low-低，medium-中，high-高
   */
  alertLevel?: string;

  /**
   * 是否启用：0-否，1-是
   */
  isActive?: string;

  /**
   * 备注
   */
  remark?: string;
}

export interface RadiationDoseAlertQuery extends PageQuery {
  /**
   * 预警类型：monthly-月度预警，quarterly-季度预警，yearly-年度预警
   */
  alertType?: string;

  /**
   * 阈值
   */
  thresholdValue?: number;

  /**
   * 预警级别：low-低，medium-中，high-高
   */
  alertLevel?: string;

  /**
   * 是否启用：0-否，1-是
   */
  isActive?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
