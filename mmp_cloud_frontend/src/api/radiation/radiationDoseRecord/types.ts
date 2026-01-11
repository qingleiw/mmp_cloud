export interface RadiationDoseRecordVO {
  id: string | number;
  /**
   * 工作人员姓名
   */
  staffName: string;

  /**
   * 记录日期
   */
  recordDate: string;

  /**
   * 记录周期：daily-日，monthly-月，quarterly-季度，yearly-年
   */
  recordPeriod: string;

  /**
   * 剂量值
   */
  doseValue: number;

  /**
   * 剂量单位
   */
  doseUnit: string;

  /**
   * 测量方法
   */
  measurementMethod: string;

  /**
   * 测量设备
   */
  measurementDevice: string;

  /**
   * 备注
   */
  remarks: string;

  /**
   * 备注
   */
  remark: string;
}

export interface RadiationDoseRecordForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 工作人员ID
   */
  staffId?: string | number;

  /**
   * 工作人员姓名
   */
  staffName?: string;

  /**
   * 记录日期
   */
  recordDate?: string;

  /**
   * 记录周期：daily-日，monthly-月，quarterly-季度，yearly-年
   */
  recordPeriod?: string;

  /**
   * 剂量值
   */
  doseValue?: number;

  /**
   * 剂量单位
   */
  doseUnit?: string;

  /**
   * 测量方法
   */
  measurementMethod?: string;

  /**
   * 测量设备
   */
  measurementDevice?: string;

  /**
   * 备注
   */
  remarks?: string;

  /**
   * 备注
   */
  remark?: string;
}

export interface RadiationDoseRecordQuery extends PageQuery {
  /**
   * 工作人员姓名
   */
  staffName?: string;

  /**
   * 记录日期
   */
  recordDate?: string;

  /**
   * 记录周期：daily-日，monthly-月，quarterly-季度，yearly-年
   */
  recordPeriod?: string;

  /**
   * 剂量值
   */
  doseValue?: number;

  /**
   * 剂量单位
   */
  doseUnit?: string;

  /**
   * 测量方法
   */
  measurementMethod?: string;

  /**
   * 测量设备
   */
  measurementDevice?: string;

  /**
   * 备注
   */
  remarks?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
