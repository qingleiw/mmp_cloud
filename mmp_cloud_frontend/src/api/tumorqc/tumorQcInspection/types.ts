export interface TumorQcInspectionVO {
  /**
   * 检查编码
   */
  inspectionCode: string;

  /**
   * 检查日期
   */
  inspectionDate: string;

  /**
   * 检查人姓名
   */
  inspectorName: string;

  /**
   * 检查科室名称
   */
  departmentName: string;

  /**
   * 检查类型
   */
  inspectionType: string;

  /**
   * 检查结果
   */
  inspectionResult: string;

  /**
   * 问题描述
   */
  problemDescription: string;

  /**
   * 整改建议
   */
  suggestion: string;

  /**
   * 状态（0待整改 1已整改）
   */
  status: string;

  /**
   * 删除标志（0代表存在 1代表删除）
   */
  delFlag: string;
}

export interface TumorQcInspectionForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 检查编码
   */
  inspectionCode?: string;

  /**
   * 关联方案ID
   */
  planId?: string | number;

  /**
   * 检查日期
   */
  inspectionDate?: string;

  /**
   * 检查人ID
   */
  inspectorId?: string | number;

  /**
   * 检查人姓名
   */
  inspectorName?: string;

  /**
   * 检查科室ID
   */
  departmentId?: string | number;

  /**
   * 检查科室名称
   */
  departmentName?: string;

  /**
   * 检查类型
   */
  inspectionType?: string;

  /**
   * 检查结果
   */
  inspectionResult?: string;

  /**
   * 问题描述
   */
  problemDescription?: string;

  /**
   * 整改建议
   */
  suggestion?: string;

  /**
   * 状态（0待整改 1已整改）
   */
  status?: string;

  /**
   * 删除标志（0代表存在 1代表删除）
   */
  delFlag?: string;
}

export interface TumorQcInspectionQuery extends PageQuery {
  /**
   * 检查编码
   */
  inspectionCode?: string;

  /**
   * 检查日期
   */
  inspectionDate?: string;

  /**
   * 检查人姓名
   */
  inspectorName?: string;

  /**
   * 检查科室名称
   */
  departmentName?: string;

  /**
   * 检查类型
   */
  inspectionType?: string;

  /**
   * 检查结果
   */
  inspectionResult?: string;

  /**
   * 问题描述
   */
  problemDescription?: string;

  /**
   * 整改建议
   */
  suggestion?: string;

  /**
   * 状态（0待整改 1已整改）
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
