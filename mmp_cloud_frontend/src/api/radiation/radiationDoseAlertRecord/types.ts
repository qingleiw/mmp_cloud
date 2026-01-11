export interface RadiationDoseAlertRecordVO {
  /**
   * 工作人员姓名
   */
  staffName: string;

  /**
   * 预警日期
   */
  alertDate: string;

  /**
   * 预警类型
   */
  alertType: string;

  /**
   * 当前剂量
   */
  currentDose: number;

  /**
   * 阈值
   */
  thresholdValue: number;

  /**
   * 预警级别
   */
  alertLevel: string;

  /**
   * 预警信息
   */
  alertMessage: string;

  /**
   * 是否已处理：0-否，1-是
   */
  isHandled: string;

  /**
   * 处理人
   */
  handler: string;

  /**
   * 处理时间
   */
  handleTime: string;

  /**
   * 处理结果
   */
  handleResult: string;

  /**
   * 备注
   */
  remark: string;
}

export interface RadiationDoseAlertRecordForm extends BaseEntity {
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
   * 预警日期
   */
  alertDate?: string;

  /**
   * 预警类型
   */
  alertType?: string;

  /**
   * 当前剂量
   */
  currentDose?: number;

  /**
   * 阈值
   */
  thresholdValue?: number;

  /**
   * 预警级别
   */
  alertLevel?: string;

  /**
   * 预警信息
   */
  alertMessage?: string;

  /**
   * 是否已处理：0-否，1-是
   */
  isHandled?: string;

  /**
   * 处理人
   */
  handler?: string;

  /**
   * 处理时间
   */
  handleTime?: string;

  /**
   * 处理结果
   */
  handleResult?: string;

  /**
   * 备注
   */
  remark?: string;
}

export interface RadiationDoseAlertRecordQuery extends PageQuery {
  /**
   * 工作人员姓名
   */
  staffName?: string;

  /**
   * 预警日期
   */
  alertDate?: string;

  /**
   * 预警类型
   */
  alertType?: string;

  /**
   * 当前剂量
   */
  currentDose?: number;

  /**
   * 阈值
   */
  thresholdValue?: number;

  /**
   * 预警级别
   */
  alertLevel?: string;

  /**
   * 预警信息
   */
  alertMessage?: string;

  /**
   * 是否已处理：0-否，1-是
   */
  isHandled?: string;

  /**
   * 处理人
   */
  handler?: string;

  /**
   * 处理时间
   */
  handleTime?: string;

  /**
   * 处理结果
   */
  handleResult?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
