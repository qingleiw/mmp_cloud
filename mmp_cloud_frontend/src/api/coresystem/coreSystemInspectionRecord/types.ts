export interface CoreSystemInspectionRecordVO extends BaseEntity {
  /**
   * 检查ID
   */
  id: string | number;

  /**
   * 制度ID
   */
  systemId: string | number;

  /**
   * 制度名称
   */
  systemName: string;

  /**
   * 检查人ID
   */
  inspectorId: string | number;

  /**
   * 检查人姓名
   */
  inspectorName: string;

  /**
   * 检查时间
   */
  inspectionTime: string;

  /**
   * 检查结果 1-合格 0-不合格
   */
  inspectionResult: string;

  /**
   * 检查内容
   */
  inspectionContent: string;

  /**
   * 问题描述
   */
  problemDescription: string;

  /**
   * 整改建议
   */
  rectificationSuggestion: string;

  /**
   * 删除标志 0-未删除 1-已删除
   */
  delFlag: string;
}

export interface CoreSystemInspectionRecordForm extends BaseEntity {
  /**
   * 检查ID
   */
  id?: string | number;

  /**
   * 制度ID
   */
  systemId?: string | number;

  /**
   * 制度名称
   */
  systemName?: string;

  /**
   * 检查人ID
   */
  inspectorId?: string | number;

  /**
   * 检查人姓名
   */
  inspectorName?: string;

  /**
   * 检查时间
   */
  inspectionTime?: string;

  /**
   * 检查结果 1-合格 0-不合格
   */
  inspectionResult?: string;

  /**
   * 检查内容
   */
  inspectionContent?: string;

  /**
   * 问题描述
   */
  problemDescription?: string;

  /**
   * 整改建议
   */
  rectificationSuggestion?: string;

  /**
   * 删除标志 0-未删除 1-已删除
   */
  delFlag?: string;
}

export interface CoreSystemInspectionRecordQuery extends PageQuery {
  /**
   * 制度名称
   */
  systemName?: string;

  /**
   * 检查人姓名
   */
  inspectorName?: string;

  /**
   * 检查时间
   */
  inspectionTime?: string;

  /**
   * 检查结果 1-合格 0-不合格
   */
  inspectionResult?: string;

  /**
   * 检查内容
   */
  inspectionContent?: string;

  /**
   * 问题描述
   */
  problemDescription?: string;

  /**
   * 整改建议
   */
  rectificationSuggestion?: string;

  /**
   * 删除标志 0-未删除 1-已删除
   */
  delFlag?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
