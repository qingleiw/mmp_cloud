export interface ComplaintDisputeVO {
  id: string | number;
  /**
   * 投诉编号
   */
  complaintNo: string;

  /**
   * 投诉类型
   */
  complaintType: string;

  /**
   * 投诉来源
   */
  complaintSource: string;

  /**
   * 投诉人姓名
   */
  complainantName: string;

  /**
   * 投诉人联系方式
   */
  complainantContact: string;

  /**
   * 患者姓名
   */
  patientName: string;

  /**
   * 涉及医师姓名
   */
  doctorName: string;

  /**
   * 涉及科室名称
   */
  departmentName: string;

  /**
   * 投诉内容
   */
  complaintContent: string;

  /**
   * 投诉时间
   */
  complaintTime: string;

  /**
   * 当前状态
   */
  currentStatus: string;

  /**
   * 优先级
   */
  priorityLevel: string;

  /**
   * 是否构成纠纷
   */
  isDispute: number;

  /**
   * 纠纷确认说明
   */
  disputeConfirmation: string;

  /**
   * 最终处理结果
   */
  finalResult: string;

  /**
   * 删除标志（0代表存在 1代表删除）
   */
  delFlag: string;
}

export interface ComplaintDisputeForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 投诉编号
   */
  complaintNo?: string;

  /**
   * 投诉类型
   */
  complaintType?: string;

  /**
   * 投诉来源
   */
  complaintSource?: string;

  /**
   * 投诉人姓名
   */
  complainantName?: string;

  /**
   * 投诉人联系方式
   */
  complainantContact?: string;

  /**
   * 患者姓名
   */
  patientName?: string;

  /**
   * 患者ID
   */
  patientId?: string | number;

  /**
   * 涉及医师ID
   */
  doctorId?: string | number;

  /**
   * 涉及医师姓名
   */
  doctorName?: string;

  /**
   * 涉及科室ID
   */
  departmentId?: string | number;

  /**
   * 涉及科室名称
   */
  departmentName?: string;

  /**
   * 投诉内容
   */
  complaintContent?: string;

  /**
   * 投诉时间
   */
  complaintTime?: string;

  /**
   * 当前状态
   */
  currentStatus?: string;

  /**
   * 优先级
   */
  priorityLevel?: string;

  /**
   * 是否构成纠纷
   */
  isDispute?: number;

  /**
   * 纠纷确认说明
   */
  disputeConfirmation?: string;

  /**
   * 最终处理结果
   */
  finalResult?: string;

  /**
   * 删除标志（0代表存在 1代表删除）
   */
  delFlag?: string;
}

export interface ComplaintDisputeQuery extends PageQuery {
  /**
   * 投诉编号
   */
  complaintNo?: string;

  /**
   * 投诉类型
   */
  complaintType?: string;

  /**
   * 投诉来源
   */
  complaintSource?: string;

  /**
   * 投诉人姓名
   */
  complainantName?: string;

  /**
   * 投诉人联系方式
   */
  complainantContact?: string;

  /**
   * 患者姓名
   */
  patientName?: string;

  /**
   * 涉及医师姓名
   */
  doctorName?: string;

  /**
   * 涉及科室名称
   */
  departmentName?: string;

  /**
   * 投诉内容
   */
  complaintContent?: string;

  /**
   * 投诉时间
   */
  complaintTime?: string;

  /**
   * 当前状态
   */
  currentStatus?: string;

  /**
   * 优先级
   */
  priorityLevel?: string;

  /**
   * 是否构成纠纷
   */
  isDispute?: number;

  /**
   * 纠纷确认说明
   */
  disputeConfirmation?: string;

  /**
   * 最终处理结果
   */
  finalResult?: string;

  /**
   * 删除标志（0代表存在 1代表删除）
   */
  delFlag?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
