export interface RadiationDoseMonitoringVO {
  /**
   * 监测日期
   */
  monitoringDate: string;

  /**
   * 监测周期
   */
  monitoringPeriod: string;

  /**
   * 剂量值
   */
  doseValue: number;

  /**
   * 剂量单位
   */
  doseUnit: string;

  /**
   * 监测方法
   */
  monitoringMethod: string;

  /**
   * 监测设备
   */
  monitoringDevice: string;

  /**
   * 监测人员
   */
  monitoringPerson: string;

  /**
   * 是否超标：0-否，1-是
   */
  isExceeded: string;

  /**
   * 备注
   */
  remarks: string;

  /**
   * 备注
   */
  remark: string;
}

export interface RadiationDoseMonitoringForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 工作人员ID
   */
  workerId?: string | number;

  /**
   * 监测日期
   */
  monitoringDate?: string;

  /**
   * 监测周期
   */
  monitoringPeriod?: string;

  /**
   * 剂量值
   */
  doseValue?: number;

  /**
   * 剂量单位
   */
  doseUnit?: string;

  /**
   * 监测方法
   */
  monitoringMethod?: string;

  /**
   * 监测设备
   */
  monitoringDevice?: string;

  /**
   * 监测人员
   */
  monitoringPerson?: string;

  /**
   * 是否超标：0-否，1-是
   */
  isExceeded?: string;

  /**
   * 备注
   */
  remarks?: string;

  /**
   * 备注
   */
  remark?: string;
}

export interface RadiationDoseMonitoringQuery extends PageQuery {
  /**
   * 监测日期
   */
  monitoringDate?: string;

  /**
   * 监测周期
   */
  monitoringPeriod?: string;

  /**
   * 剂量值
   */
  doseValue?: number;

  /**
   * 剂量单位
   */
  doseUnit?: string;

  /**
   * 监测方法
   */
  monitoringMethod?: string;

  /**
   * 监测设备
   */
  monitoringDevice?: string;

  /**
   * 监测人员
   */
  monitoringPerson?: string;

  /**
   * 是否超标：0-否，1-是
   */
  isExceeded?: string;

  /**
   * 备注
   */
  remarks?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
