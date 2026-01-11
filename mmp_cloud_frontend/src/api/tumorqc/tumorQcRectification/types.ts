export interface TumorQcRectificationVO {
  /**
   * 整改编码
   */
  rectificationCode: string;

  /**
   * 问题描述
   */
  problemDescription: string;

  /**
   * 整改措施
   */
  rectificationMeasures: string;

  /**
   * 负责人姓名
   */
  responsiblePersonName: string;

  /**
   * 整改期限
   */
  deadline: string;

  /**
   * 完成时间
   */
  completionTime: string;

  /**
   * 整改结果
   */
  rectificationResult: string;

  /**
   * 验证状态（0待验证 1已验证）
   */
  verificationStatus: string;

  /**
   * 状态（0进行中 1已完成）
   */
  status: string;

  /**
   * 删除标志（0代表存在 1代表删除）
   */
  delFlag: string;
}

export interface TumorQcRectificationForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 整改编码
   */
  rectificationCode?: string;

  /**
   * 关联检查ID
   */
  inspectionId?: string | number;

  /**
   * 问题描述
   */
  problemDescription?: string;

  /**
   * 整改措施
   */
  rectificationMeasures?: string;

  /**
   * 负责人ID
   */
  responsiblePersonId?: string | number;

  /**
   * 负责人姓名
   */
  responsiblePersonName?: string;

  /**
   * 整改期限
   */
  deadline?: string;

  /**
   * 完成时间
   */
  completionTime?: string;

  /**
   * 整改结果
   */
  rectificationResult?: string;

  /**
   * 验证状态（0待验证 1已验证）
   */
  verificationStatus?: string;

  /**
   * 状态（0进行中 1已完成）
   */
  status?: string;

  /**
   * 删除标志（0代表存在 1代表删除）
   */
  delFlag?: string;
}

export interface TumorQcRectificationQuery extends PageQuery {
  /**
   * 整改编码
   */
  rectificationCode?: string;

  /**
   * 问题描述
   */
  problemDescription?: string;

  /**
   * 整改措施
   */
  rectificationMeasures?: string;

  /**
   * 负责人姓名
   */
  responsiblePersonName?: string;

  /**
   * 整改期限
   */
  deadline?: string;

  /**
   * 完成时间
   */
  completionTime?: string;

  /**
   * 整改结果
   */
  rectificationResult?: string;

  /**
   * 验证状态（0待验证 1已验证）
   */
  verificationStatus?: string;

  /**
   * 状态（0进行中 1已完成）
   */
  status?: string;

  /**
   * 删除标志（0代表存在 1代表删除）
   */
  delFlag?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
