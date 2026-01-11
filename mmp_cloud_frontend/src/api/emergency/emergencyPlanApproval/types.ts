export interface EmergencyPlanApprovalVO {
  /**
   * 审批阶段
   */
  approvalStage: string;

  /**
   * 审批人姓名
   */
  approverName: string;

  /**
   * 审批意见
   */
  approvalOpinion: string;

  /**
   * 审批结果：approved-通过，rejected-驳回
   */
  approvalResult: string;

  /**
   * 审批时间
   */
  approvalTime: string;

  /**
   * 备注
   */
  remark: string;
}

export interface EmergencyPlanApprovalForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 预案ID
   */
  planId?: string | number;

  /**
   * 审批阶段
   */
  approvalStage?: string;

  /**
   * 审批人ID
   */
  approverId?: string | number;

  /**
   * 审批人姓名
   */
  approverName?: string;

  /**
   * 审批意见
   */
  approvalOpinion?: string;

  /**
   * 审批结果：approved-通过，rejected-驳回
   */
  approvalResult?: string;

  /**
   * 审批时间
   */
  approvalTime?: string;

  /**
   * 备注
   */
  remark?: string;
}

export interface EmergencyPlanApprovalQuery extends PageQuery {
  /**
   * 审批阶段
   */
  approvalStage?: string;

  /**
   * 审批人姓名
   */
  approverName?: string;

  /**
   * 审批意见
   */
  approvalOpinion?: string;

  /**
   * 审批结果：approved-通过，rejected-驳回
   */
  approvalResult?: string;

  /**
   * 审批时间
   */
  approvalTime?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
