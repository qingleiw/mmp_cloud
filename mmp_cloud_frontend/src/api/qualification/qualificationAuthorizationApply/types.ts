export interface QualificationAuthorizationApplyVO {
  /**
   * 主键ID
   */
  id: string | number;

  /**
   * 申请单号
   */
  applyNo: string;

  /**
   * 申请人ID
   */
  applicantId: string | number;

  /**
   * 申请人姓名
   */
  applicantName: string;

  /**
   * 申请人类型 医师/医技
   */
  applicantType: string;

  /**
   * 科室ID
   */
  departmentId: string | number;

  /**
   * 科室名称
   */
  departmentName: string;

  /**
   * 资质ID列表(逗号分隔)
   */
  qualificationIds: string | number;

  /**
   * 申请理由
   */
  applyReason: string;

  /**
   * 关联证书ID
   */
  certificateIds: string | number;

  /**
   * 考核成绩
   */
  examScore: number;

  /**
   * 工作量数据JSON
   */
  workQuantity: string;

  /**
   * 工作质量数据JSON
   */
  workQuality: string;

  /**
   * 申请状态
   */
  applyStatus: string;

  /**
   * 当前审批节点
   */
  currentNode: string;

  /**
   * 工作流实例ID
   */
  workflowInstanceId: string | number;

  /**
   * 是否删除
   */
  delFlag?: string;
}

export interface QualificationAuthorizationApplyForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 申请单号
   */
  applyNo?: string;

  /**
   * 申请人ID
   */
  applicantId?: string | number;

  /**
   * 申请人姓名
   */
  applicantName?: string;

  /**
   * 申请人类型 医师/医技
   */
  applicantType?: string;

  /**
   * 科室ID
   */
  departmentId?: string | number;

  /**
   * 科室名称
   */
  departmentName?: string;

  /**
   * 资质ID列表(逗号分隔)
   */
  qualificationIds?: string | number;

  /**
   * 申请理由
   */
  applyReason?: string;

  /**
   * 关联证书ID
   */
  certificateIds?: string | number;

  /**
   * 考核成绩
   */
  examScore?: number;

  /**
   * 工作量数据JSON
   */
  workQuantity?: string;

  /**
   * 工作质量数据JSON
   */
  workQuality?: string;

  /**
   * 申请状态
   */
  applyStatus?: string;

  /**
   * 当前审批节点
   */
  currentNode?: string;

  /**
   * 工作流实例ID
   */
  workflowInstanceId?: string | number;

  /**
   * 是否删除
   */
  delFlag?: string;
}

export interface QualificationAuthorizationApplyQuery extends PageQuery {
  /**
   * 申请单号
   */
  applyNo?: string;

  /**
   * 申请人ID
   */
  applicantId?: string | number;

  /**
   * 申请人姓名
   */
  applicantName?: string;

  /**
   * 申请人类型 医师/医技
   */
  applicantType?: string;

  /**
   * 科室ID
   */
  departmentId?: string | number;

  /**
   * 科室名称
   */
  departmentName?: string;

  /**
   * 资质ID列表(逗号分隔)
   */
  qualificationIds?: string | number;

  /**
   * 申请理由
   */
  applyReason?: string;

  /**
   * 关联证书ID
   */
  certificateIds?: string | number;

  /**
   * 考核成绩
   */
  examScore?: number;

  /**
   * 工作量数据JSON
   */
  workQuantity?: string;

  /**
   * 工作质量数据JSON
   */
  workQuality?: string;

  /**
   * 申请状态
   */
  applyStatus?: string;

  /**
   * 当前审批节点
   */
  currentNode?: string;

  /**
   * 工作流实例ID
   */
  workflowInstanceId?: string | number;

  /**
   * 是否删除
   */
  delFlag?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
