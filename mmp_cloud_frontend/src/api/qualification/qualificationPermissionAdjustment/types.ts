export interface QualificationPermissionAdjustmentVO {
  /**
   * 主键ID
   */
  id: string | number;

  /**
   * 医师姓名
   */
  doctorName: string;

  /**
   * 资质类型（手术权限、抗菌药物权限等）
   */
  qualificationType: string;

  /**
   * 原权限级别
   */
  originalLevel: string;

  /**
   * 新权限级别
   */
  newLevel: string;

  /**
   * 调整原因
   */
  adjustmentReason: string;

  /**
   * 调整依据（JSON格式，包含工作量、并发症等数据）
   */
  adjustmentBasis: string;

  /**
   * 调整时间
   */
  adjustmentTime: string;

  /**
   * 操作人姓名
   */
  operatorName: string;

  /**
   * 是否自动调整
   */
  isAutoAdjustment: number;

  /**
   * 删除标志（0代表存在 1代表删除）
   */
  delFlag: string;
}

export interface QualificationPermissionAdjustmentForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 医师ID
   */
  doctorId?: string | number;

  /**
   * 医师姓名
   */
  doctorName?: string;

  /**
   * 资质类型（手术权限、抗菌药物权限等）
   */
  qualificationType?: string;

  /**
   * 原权限级别
   */
  originalLevel?: string;

  /**
   * 新权限级别
   */
  newLevel?: string;

  /**
   * 调整原因
   */
  adjustmentReason?: string;

  /**
   * 调整依据（JSON格式，包含工作量、并发症等数据）
   */
  adjustmentBasis?: string;

  /**
   * 调整时间
   */
  adjustmentTime?: string;

  /**
   * 操作人ID
   */
  operatorId?: string | number;

  /**
   * 操作人姓名
   */
  operatorName?: string;

  /**
   * 是否自动调整
   */
  isAutoAdjustment?: number;

  /**
   * 删除标志（0代表存在 1代表删除）
   */
  delFlag?: string;
}

export interface QualificationPermissionAdjustmentQuery extends PageQuery {
  /**
   * 医师姓名
   */
  doctorName?: string;

  /**
   * 资质类型（手术权限、抗菌药物权限等）
   */
  qualificationType?: string;

  /**
   * 原权限级别
   */
  originalLevel?: string;

  /**
   * 新权限级别
   */
  newLevel?: string;

  /**
   * 调整原因
   */
  adjustmentReason?: string;

  /**
   * 调整依据（JSON格式，包含工作量、并发症等数据）
   */
  adjustmentBasis?: string;

  /**
   * 调整时间
   */
  adjustmentTime?: string;

  /**
   * 操作人姓名
   */
  operatorName?: string;

  /**
   * 是否自动调整
   */
  isAutoAdjustment?: number;

  /**
   * 删除标志（0代表存在 1代表删除）
   */
  delFlag?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
