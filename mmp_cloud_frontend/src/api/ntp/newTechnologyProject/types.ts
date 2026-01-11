export interface NewTechnologyProjectVO {
  /**
   * 主键ID
   */
  id: string | number;

  /**
   * 项目编号
   */
  projectNo: string;

  /**
   * 项目名称
   */
  projectName: string;

  /**
   * 项目类型 新技术/新项目
   */
  projectType: string;

  /**
   * 技术分类
   */
  technologyCategory: string;

  /**
   * 风险等级 低风险/中风险/高风险
   */
  riskLevel: string;

  /**
   * 申请科室ID
   */
  applyDepartmentId: string | number;

  /**
   * 申请科室名称
   */
  applyDepartmentName: string;

  /**
   * 项目负责人
   */
  projectLeader: string;

  /**
   * 项目团队成员
   */
  projectTeam: string;

  /**
   * 技术来源
   */
  technologySource: string;

  /**
   * 申请理由
   */
  applyReason: string;

  /**
   * 技术描述
   */
  technologyDescription: string;

  /**
   * 适应症
   */
  indication: string;

  /**
   * 禁忌症
   */
  contraindication: string;

  /**
   * 预期效果
   */
  expectedEffect: string;

  /**
   * 潜在风险
   */
  potentialRisk: string;

  /**
   * 风险控制措施
   */
  riskControlMeasure: string;

  /**
   * 文献支持
   */
  literatureSupport: string;

  /**
   * 附件URLs
   */
  attachmentUrls: string;

  /**
   * 运行周期(天)
   */
  operationCycleDays: number;

  /**
   * 进展报告周期 月度/季度/半年度/年度
   */
  progressReportCycle: string;

  /**
   * 项目状态
   */
  projectStatus: string;

  /**
   * 批准日期
   */
  approveDate: string;

  /**
   * 开始日期
   */
  startDate: string;

  /**
   * 预计结束日期
   */
  endDate: string;

  /**
   * 实际结束日期
   */
  actualEndDate: string;

  /**
   * 结题类型 转常规/终止
   */
  conclusionType: string;

  /**
   * 工作流实例ID
   */
  workflowInstanceId: string | number;

  /**
   * 是否删除
   */
  isDeleted: number;

}

export interface NewTechnologyProjectForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 项目编号
   */
  projectNo?: string;

  /**
   * 项目名称
   */
  projectName?: string;

  /**
   * 项目类型 新技术/新项目
   */
  projectType?: string;

  /**
   * 技术分类
   */
  technologyCategory?: string;

  /**
   * 风险等级 低风险/中风险/高风险
   */
  riskLevel?: string;

  /**
   * 申请科室ID
   */
  applyDepartmentId?: string | number;

  /**
   * 申请科室名称
   */
  applyDepartmentName?: string;

  /**
   * 项目负责人
   */
  projectLeader?: string;

  /**
   * 项目团队成员
   */
  projectTeam?: string;

  /**
   * 技术来源
   */
  technologySource?: string;

  /**
   * 申请理由
   */
  applyReason?: string;

  /**
   * 技术描述
   */
  technologyDescription?: string;

  /**
   * 适应症
   */
  indication?: string;

  /**
   * 禁忌症
   */
  contraindication?: string;

  /**
   * 预期效果
   */
  expectedEffect?: string;

  /**
   * 潜在风险
   */
  potentialRisk?: string;

  /**
   * 风险控制措施
   */
  riskControlMeasure?: string;

  /**
   * 文献支持
   */
  literatureSupport?: string;

  /**
   * 附件URLs
   */
  attachmentUrls?: string;

  /**
   * 运行周期(天)
   */
  operationCycleDays?: number;

  /**
   * 进展报告周期 月度/季度/半年度/年度
   */
  progressReportCycle?: string;

  /**
   * 项目状态
   */
  projectStatus?: string;

  /**
   * 批准日期
   */
  approveDate?: string;

  /**
   * 开始日期
   */
  startDate?: string;

  /**
   * 预计结束日期
   */
  endDate?: string;

  /**
   * 实际结束日期
   */
  actualEndDate?: string;

  /**
   * 结题类型 转常规/终止
   */
  conclusionType?: string;

  /**
   * 工作流实例ID
   */
  workflowInstanceId?: string | number;

  /**
   * 是否删除
   */
  isDeleted?: number;

}

export interface NewTechnologyProjectQuery extends PageQuery {

  /**
   * 项目编号
   */
  projectNo?: string;

  /**
   * 项目名称
   */
  projectName?: string;

  /**
   * 项目类型 新技术/新项目
   */
  projectType?: string;

  /**
   * 技术分类
   */
  technologyCategory?: string;

  /**
   * 风险等级 低风险/中风险/高风险
   */
  riskLevel?: string;

  /**
   * 申请科室ID
   */
  applyDepartmentId?: string | number;

  /**
   * 申请科室名称
   */
  applyDepartmentName?: string;

  /**
   * 项目负责人
   */
  projectLeader?: string;

  /**
   * 项目团队成员
   */
  projectTeam?: string;

  /**
   * 技术来源
   */
  technologySource?: string;

  /**
   * 申请理由
   */
  applyReason?: string;

  /**
   * 技术描述
   */
  technologyDescription?: string;

  /**
   * 适应症
   */
  indication?: string;

  /**
   * 禁忌症
   */
  contraindication?: string;

  /**
   * 预期效果
   */
  expectedEffect?: string;

  /**
   * 潜在风险
   */
  potentialRisk?: string;

  /**
   * 风险控制措施
   */
  riskControlMeasure?: string;

  /**
   * 文献支持
   */
  literatureSupport?: string;

  /**
   * 附件URLs
   */
  attachmentUrls?: string;

  /**
   * 运行周期(天)
   */
  operationCycleDays?: number;

  /**
   * 进展报告周期 月度/季度/半年度/年度
   */
  progressReportCycle?: string;

  /**
   * 项目状态
   */
  projectStatus?: string;

  /**
   * 批准日期
   */
  approveDate?: string;

  /**
   * 开始日期
   */
  startDate?: string;

  /**
   * 预计结束日期
   */
  endDate?: string;

  /**
   * 实际结束日期
   */
  actualEndDate?: string;

  /**
   * 结题类型 转常规/终止
   */
  conclusionType?: string;

  /**
   * 工作流实例ID
   */
  workflowInstanceId?: string | number;

  /**
   * 删除标志（0代表存在 2代表删除）
   */
  delFlag?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
