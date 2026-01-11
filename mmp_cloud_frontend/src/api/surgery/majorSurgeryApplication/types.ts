export interface MajorSurgeryApplicationVO {
  /**
   * 主键ID
   */
  id: string | number;

  /**
   * 申请编号
   */
  applicationNo: string;

  /**
   * 患者姓名
   */
  patientName: string;

  /**
   * 申请医师姓名
   */
  doctorName: string;

  /**
   * 申请科室名称
   */
  departmentName: string;

  /**
   * 拟手术名称
   */
  surgeryName: string;

  /**
   * 手术原因
   */
  surgeryReason: string;

  /**
   * 手术风险
   */
  surgeryRisk: string;

  /**
   * 预计手术时间
   */
  expectedTime: string;

  /**
   * 申请状态
   */
  applicationStatus: string;

  /**
   * 审批意见
   */
  approvalOpinion: string;

  /**
   * 审批人姓名
   */
  approverName: string;

  /**
   * 审批时间
   */
  approvalTime: string;

  /**
   * 附件（JSON格式）
   */
  attachments: string;

  /**
   * 删除标志（0代表存在 1代表删除）
   */
  delFlag: string;
}

export interface MajorSurgeryApplicationForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 申请编号
   */
  applicationNo?: string;

  /**
   * 患者ID
   */
  patientId?: string | number;

  /**
   * 患者姓名
   */
  patientName?: string;

  /**
   * 申请医师ID
   */
  doctorId?: string | number;

  /**
   * 申请医师姓名
   */
  doctorName?: string;

  /**
   * 申请科室ID
   */
  departmentId?: string | number;

  /**
   * 申请科室名称
   */
  departmentName?: string;

  /**
   * 拟手术名称
   */
  surgeryName?: string;

  /**
   * 手术原因
   */
  surgeryReason?: string;

  /**
   * 手术风险
   */
  surgeryRisk?: string;

  /**
   * 预计手术时间
   */
  expectedTime?: string;

  /**
   * 申请状态
   */
  applicationStatus?: string;

  /**
   * 审批意见
   */
  approvalOpinion?: string;

  /**
   * 审批人ID
   */
  approverId?: string | number;

  /**
   * 审批人姓名
   */
  approverName?: string;

  /**
   * 审批时间
   */
  approvalTime?: string;

  /**
   * 附件（JSON格式）
   */
  attachments?: string;

  /**
   * 删除标志（0代表存在 1代表删除）
   */
  delFlag?: string;
}

export interface MajorSurgeryApplicationQuery extends PageQuery {
  /**
   * 申请编号
   */
  applicationNo?: string;

  /**
   * 患者姓名
   */
  patientName?: string;

  /**
   * 申请医师姓名
   */
  doctorName?: string;

  /**
   * 申请科室名称
   */
  departmentName?: string;

  /**
   * 拟手术名称
   */
  surgeryName?: string;

  /**
   * 手术原因
   */
  surgeryReason?: string;

  /**
   * 手术风险
   */
  surgeryRisk?: string;

  /**
   * 预计手术时间
   */
  expectedTime?: string;

  /**
   * 申请状态
   */
  applicationStatus?: string;

  /**
   * 审批意见
   */
  approvalOpinion?: string;

  /**
   * 审批人姓名
   */
  approverName?: string;

  /**
   * 审批时间
   */
  approvalTime?: string;

  /**
   * 附件（JSON格式）
   */
  attachments?: string;

  /**
   * 删除标志（0代表存在 1代表删除）
   */
  delFlag?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
