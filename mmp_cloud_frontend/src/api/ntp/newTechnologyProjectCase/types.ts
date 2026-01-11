export interface NewTechnologyProjectCaseVO {
  /**
   * 患者姓名
   */
  patientName: string;

  /**
   * 就诊类型 门诊/住院
   */
  visitType: string;

  /**
   * 就诊号
   */
  visitNo: string;

  /**
   * 就诊日期
   */
  visitDate: string;

  /**
   * 就诊科室名称
   */
  visitDepartmentName: string;

  /**
   * 诊断
   */
  diagnosis: string;

  /**
   * 操作医生
   */
  operator: string;

  /**
   * 操作时间
   */
  operationDate: string;

  /**
   * 效果评价
   */
  effectEvaluation: string;

  /**
   * 并发症
   */
  complication: string;

  /**
   * 不良反应
   */
  adverseReaction: string;

  /**
   * 随访状态
   */
  followUpStatus: string;

  /**
   * 随访结果
   */
  followUpResult: string;

  /**
   * 是否已报备 1-是 0-否
   */
  isReported: number;

  /**
   * 报备时间
   */
  reportTime: string;

  /**
   * 备注
   */
  remark: string;

}

export interface NewTechnologyProjectCaseForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 项目ID
   */
  projectId?: string | number;

  /**
   * 患者ID
   */
  patientId?: string | number;

  /**
   * 患者姓名
   */
  patientName?: string;

  /**
   * 就诊类型 门诊/住院
   */
  visitType?: string;

  /**
   * 就诊号
   */
  visitNo?: string;

  /**
   * 就诊日期
   */
  visitDate?: string;

  /**
   * 就诊科室ID
   */
  visitDepartmentId?: string | number;

  /**
   * 就诊科室名称
   */
  visitDepartmentName?: string;

  /**
   * 诊断
   */
  diagnosis?: string;

  /**
   * 操作医生
   */
  operator?: string;

  /**
   * 操作时间
   */
  operationDate?: string;

  /**
   * 效果评价
   */
  effectEvaluation?: string;

  /**
   * 并发症
   */
  complication?: string;

  /**
   * 不良反应
   */
  adverseReaction?: string;

  /**
   * 随访状态
   */
  followUpStatus?: string;

  /**
   * 随访结果
   */
  followUpResult?: string;

  /**
   * 是否已报备 1-是 0-否
   */
  isReported?: number;

  /**
   * 报备时间
   */
  reportTime?: string;

  /**
   * 备注
   */
  remark?: string;

}

export interface NewTechnologyProjectCaseQuery extends PageQuery {

  /**
   * 患者姓名
   */
  patientName?: string;

  /**
   * 就诊类型 门诊/住院
   */
  visitType?: string;

  /**
   * 就诊号
   */
  visitNo?: string;

  /**
   * 就诊日期
   */
  visitDate?: string;

  /**
   * 就诊科室名称
   */
  visitDepartmentName?: string;

  /**
   * 诊断
   */
  diagnosis?: string;

  /**
   * 操作医生
   */
  operator?: string;

  /**
   * 操作时间
   */
  operationDate?: string;

  /**
   * 效果评价
   */
  effectEvaluation?: string;

  /**
   * 并发症
   */
  complication?: string;

  /**
   * 不良反应
   */
  adverseReaction?: string;

  /**
   * 随访状态
   */
  followUpStatus?: string;

  /**
   * 随访结果
   */
  followUpResult?: string;

  /**
   * 是否已报备 1-是 0-否
   */
  isReported?: number;

  /**
   * 报备时间
   */
  reportTime?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
