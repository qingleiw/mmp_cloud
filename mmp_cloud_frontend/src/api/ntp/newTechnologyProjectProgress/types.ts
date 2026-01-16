export interface NewTechnologyProjectProgressVO extends BaseEntity {
  /**
   * 主键ID
   */
  id: string | number;

  /**
   * 报告编号
   */
  reportNo: string;

  /**
   * 报告类型 进展报告/结题报告
   */
  reportType: string;

  /**
   * 报告期间
   */
  reportPeriod: string;

  /**
   * 报告日期
   */
  reportDate: string;

  /**
   * 开展病例数
   */
  caseCount: number;

  /**
   * 成功病例数
   */
  successCount: number;

  /**
   * 并发症例数
   */
  complicationCount: number;

  /**
   * 不良反应例数
   */
  adverseReactionCount: number;

  /**
   * 死亡例数
   */
  mortalityCount: number;

  /**
   * 效果评价
   */
  effectEvaluation: string;

  /**
   * 存在问题
   */
  existingProblems: string;

  /**
   * 改进措施
   */
  improvementMeasures: string;

  /**
   * 下步计划
   */
  nextPlan: string;

  /**
   * 继续状态 继续开展/终止/暂停
   */
  continueStatus: string;

  /**
   * 运行监测指标JSON
   */
  monitoringIndicators: string;

  /**
   * 附件URLs
   */
  attachmentUrls: string;

  /**
   * 报告状态
   */
  reportStatus: string;

  /**
   * 备注
   */
  remark: string;
}

export interface NewTechnologyProjectProgressForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 报告编号
   */
  reportNo?: string;

  /**
   * 项目ID
   */
  projectId?: string | number;

  /**
   * 报告类型 进展报告/结题报告
   */
  reportType?: string;

  /**
   * 报告期间
   */
  reportPeriod?: string;

  /**
   * 报告日期
   */
  reportDate?: string;

  /**
   * 开展病例数
   */
  caseCount?: number;

  /**
   * 成功病例数
   */
  successCount?: number;

  /**
   * 并发症例数
   */
  complicationCount?: number;

  /**
   * 不良反应例数
   */
  adverseReactionCount?: number;

  /**
   * 死亡例数
   */
  mortalityCount?: number;

  /**
   * 效果评价
   */
  effectEvaluation?: string;

  /**
   * 存在问题
   */
  existingProblems?: string;

  /**
   * 改进措施
   */
  improvementMeasures?: string;

  /**
   * 下步计划
   */
  nextPlan?: string;

  /**
   * 继续状态 继续开展/终止/暂停
   */
  continueStatus?: string;

  /**
   * 运行监测指标JSON
   */
  monitoringIndicators?: string;

  /**
   * 附件URLs
   */
  attachmentUrls?: string;

  /**
   * 报告状态
   */
  reportStatus?: string;

  /**
   * 工作流实例ID
   */
  workflowInstanceId?: string | number;

  /**
   * 备注
   */
  remark?: string;
}

export interface NewTechnologyProjectProgressQuery extends PageQuery {
  /**
   * 报告编号
   */
  reportNo?: string;

  /**
   * 报告类型 进展报告/结题报告
   */
  reportType?: string;

  /**
   * 报告期间
   */
  reportPeriod?: string;

  /**
   * 报告日期
   */
  reportDate?: string;

  /**
   * 开展病例数
   */
  caseCount?: number;

  /**
   * 成功病例数
   */
  successCount?: number;

  /**
   * 并发症例数
   */
  complicationCount?: number;

  /**
   * 不良反应例数
   */
  adverseReactionCount?: number;

  /**
   * 死亡例数
   */
  mortalityCount?: number;

  /**
   * 效果评价
   */
  effectEvaluation?: string;

  /**
   * 存在问题
   */
  existingProblems?: string;

  /**
   * 改进措施
   */
  improvementMeasures?: string;

  /**
   * 下步计划
   */
  nextPlan?: string;

  /**
   * 继续状态 继续开展/终止/暂停
   */
  continueStatus?: string;

  /**
   * 运行监测指标JSON
   */
  monitoringIndicators?: string;

  /**
   * 附件URLs
   */
  attachmentUrls?: string;

  /**
   * 报告状态
   */
  reportStatus?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
