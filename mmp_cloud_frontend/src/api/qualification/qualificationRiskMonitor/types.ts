export interface QualificationRiskMonitorVO {
  /**
   * 主键ID
   */
  id: string | number;

  /**
   * 风险编号
   */
  riskNo: string;

  /**
   * 人员ID
   */
  staffId: string | number;

  /**
   * 人员姓名
   */
  staffName: string;

  /**
   * 资质ID
   */
  qualificationId: string | number;

  /**
   * 资质名称
   */
  qualificationName: string;

  /**
   * 风险类型 超权限/即将过期/质量问题/安全事件
   */
  riskType: string;

  /**
   * 风险等级 高/中/低
   */
  riskLevel: string;

  /**
   * 风险描述
   */
  riskDescription: string;

  /**
   * 风险发生时间
   */
  riskDate: string;

  /**
   * 关联患者ID
   */
  relatedPatientId: string | number;

  /**
   * 关联事件ID
   */
  relatedEventId: string | number;

  /**
   * 处理状态
   */
  handlingStatus: string;

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
   * 是否删除
   */
  delFlag?: string;
}

export interface QualificationRiskMonitorForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 风险编号
   */
  riskNo?: string;

  /**
   * 人员ID
   */
  staffId?: string | number;

  /**
   * 人员姓名
   */
  staffName?: string;

  /**
   * 资质ID
   */
  qualificationId?: string | number;

  /**
   * 资质名称
   */
  qualificationName?: string;

  /**
   * 风险类型 超权限/即将过期/质量问题/安全事件
   */
  riskType?: string;

  /**
   * 风险等级 高/中/低
   */
  riskLevel?: string;

  /**
   * 风险描述
   */
  riskDescription?: string;

  /**
   * 风险发生时间
   */
  riskDate?: string;

  /**
   * 关联患者ID
   */
  relatedPatientId?: string | number;

  /**
   * 关联事件ID
   */
  relatedEventId?: string | number;

  /**
   * 处理状态
   */
  handlingStatus?: string;

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
   * 是否删除
   */
  delFlag?: string;
}

export interface QualificationRiskMonitorQuery extends PageQuery {
  /**
   * 风险编号
   */
  riskNo?: string;

  /**
   * 人员ID
   */
  staffId?: string | number;

  /**
   * 人员姓名
   */
  staffName?: string;

  /**
   * 资质ID
   */
  qualificationId?: string | number;

  /**
   * 资质名称
   */
  qualificationName?: string;

  /**
   * 风险类型 超权限/即将过期/质量问题/安全事件
   */
  riskType?: string;

  /**
   * 风险等级 高/中/低
   */
  riskLevel?: string;

  /**
   * 风险描述
   */
  riskDescription?: string;

  /**
   * 风险发生时间
   */
  riskDate?: string;

  /**
   * 关联患者ID
   */
  relatedPatientId?: string | number;

  /**
   * 关联事件ID
   */
  relatedEventId?: string | number;

  /**
   * 处理状态
   */
  handlingStatus?: string;

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
   * 是否删除
   */
  delFlag?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
