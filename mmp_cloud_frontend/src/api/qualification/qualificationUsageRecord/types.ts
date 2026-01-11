export interface QualificationUsageRecordVO {
  /**
   * 主键ID
   */
  id: string | number;

  /**
   * 授权记录ID
   */
  authorizationId: string | number;

  /**
   * 人员ID
   */
  staffId: string | number;

  /**
   * 资质ID
   */
  qualificationId: string | number;

  /**
   * 使用时间
   */
  usageDate: string;

  /**
   * 患者ID
   */
  patientId: string | number;

  /**
   * 患者姓名
   */
  patientName: string;

  /**
   * 操作编码
   */
  operationCode: string;

  /**
   * 操作名称
   */
  operationName: string;

  /**
   * 使用结果 正常/异常
   */
  usageResult: string;

  /**
   * 是否超权限 1-是 0-否
   */
  isOverAuthority: number;

  /**
   * 来源系统
   */
  sourceSystem: string;
}

export interface QualificationUsageRecordForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 授权记录ID
   */
  authorizationId?: string | number;

  /**
   * 人员ID
   */
  staffId?: string | number;

  /**
   * 资质ID
   */
  qualificationId?: string | number;

  /**
   * 使用时间
   */
  usageDate?: string;

  /**
   * 患者ID
   */
  patientId?: string | number;

  /**
   * 患者姓名
   */
  patientName?: string;

  /**
   * 操作编码
   */
  operationCode?: string;

  /**
   * 操作名称
   */
  operationName?: string;

  /**
   * 使用结果 正常/异常
   */
  usageResult?: string;

  /**
   * 是否超权限 1-是 0-否
   */
  isOverAuthority?: number;

  /**
   * 来源系统
   */
  sourceSystem?: string;
}

export interface QualificationUsageRecordQuery extends PageQuery {
  /**
   * 授权记录ID
   */
  authorizationId?: string | number;

  /**
   * 人员ID
   */
  staffId?: string | number;

  /**
   * 资质ID
   */
  qualificationId?: string | number;

  /**
   * 使用时间
   */
  usageDate?: string;

  /**
   * 患者ID
   */
  patientId?: string | number;

  /**
   * 患者姓名
   */
  patientName?: string;

  /**
   * 操作编码
   */
  operationCode?: string;

  /**
   * 操作名称
   */
  operationName?: string;

  /**
   * 使用结果 正常/异常
   */
  usageResult?: string;

  /**
   * 是否超权限 1-是 0-否
   */
  isOverAuthority?: number;

  /**
   * 来源系统
   */
  sourceSystem?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
