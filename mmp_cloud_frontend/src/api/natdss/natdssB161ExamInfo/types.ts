export interface NatdssB161ExamInfoVO {
  /**
   * 系统自增主键
   */
  id: string | number;

  /**
   * 患者ID
   */
  patientId: string | number;

  /**
   * 单次就诊唯一标识号
   */
  visitSn: string;

  /**
   * 就诊类型:住院、门诊
   */
  visitType: string;

  /**
   * 就诊卡号
   */
  visitCardNo: string;

  /**
   * 门诊号
   */
  outpatientNo: string;

  /**
   * 就诊次数
   */
  visitTimes: number;

  /**
   * 病案号
   */
  medicalRecordNo: string;

  /**
   * 住院号
   */
  inpatientNo: string;

  /**
   * 住院次数
   */
  hospitalizationTimes: string;

  /**
   * 患者姓名
   */
  name: string;

  /**
   * 申请单号
   */
  applyNo: string;

  /**
   * 申请医嘱流水号
   */
  orderSn: string;

  /**
   * 申请时间
   */
  applyDatetime: string;

  /**
   * 申请科室代码
   */
  applyDeptCode: string;

  /**
   * 申请科室名称
   */
  applyDeptName: string;

  /**
   * 检查流水号
   */
  examSn: string;

  /**
   * 检查时间
   */
  examDatetime: string;

  /**
   * 检查类型:心电超声放射
   */
  examType: string;

  /**
   * 检查项目类型
   */
  examItemType: string;

  /**
   * 检查项目代码
   */
  examItemCode: string;

  /**
   * 检查项目名称
   */
  examItemName: string;

  /**
   * 检查部位
   */
  examSites: string;

  /**
   * 报告单号
   */
  reportNo: string;

  /**
   * 报告时间
   */
  reportDatetime: string;

  /**
   * 报告科室代码
   */
  reportDeptCode: string;

  /**
   * 报告科室名称
   */
  reportDeptName: string;

  /**
   * 检查所见
   */
  examDiagDescription: string;

  /**
   * 检查结论
   */
  examDiagConclusion: string;

  /**
   * 扩展字段1
   */
  extendData1: string;

  /**
   * 扩展字段2
   */
  extendData2: string;

  /**
   * 记录状态:1正常 0作废
   */
  recordStatus: number;

  /**
   * 创建时间
   */
  createdTime: string;

  /**
   * 更新时间
   */
  updatedTime: string;

}

export interface NatdssB161ExamInfoForm extends BaseEntity {
  /**
   * 系统自增主键
   */
  id?: string | number;

  /**
   * 患者ID
   */
  patientId?: string | number;

  /**
   * 单次就诊唯一标识号
   */
  visitSn?: string;

  /**
   * 就诊类型:住院、门诊
   */
  visitType?: string;

  /**
   * 就诊卡号
   */
  visitCardNo?: string;

  /**
   * 门诊号
   */
  outpatientNo?: string;

  /**
   * 就诊次数
   */
  visitTimes?: number;

  /**
   * 病案号
   */
  medicalRecordNo?: string;

  /**
   * 住院号
   */
  inpatientNo?: string;

  /**
   * 住院次数
   */
  hospitalizationTimes?: string;

  /**
   * 患者姓名
   */
  name?: string;

  /**
   * 申请单号
   */
  applyNo?: string;

  /**
   * 申请医嘱流水号
   */
  orderSn?: string;

  /**
   * 申请时间
   */
  applyDatetime?: string;

  /**
   * 申请科室代码
   */
  applyDeptCode?: string;

  /**
   * 申请科室名称
   */
  applyDeptName?: string;

  /**
   * 检查流水号
   */
  examSn?: string;

  /**
   * 检查时间
   */
  examDatetime?: string;

  /**
   * 检查类型:心电超声放射
   */
  examType?: string;

  /**
   * 检查项目类型
   */
  examItemType?: string;

  /**
   * 检查项目代码
   */
  examItemCode?: string;

  /**
   * 检查项目名称
   */
  examItemName?: string;

  /**
   * 检查部位
   */
  examSites?: string;

  /**
   * 报告单号
   */
  reportNo?: string;

  /**
   * 报告时间
   */
  reportDatetime?: string;

  /**
   * 报告科室代码
   */
  reportDeptCode?: string;

  /**
   * 报告科室名称
   */
  reportDeptName?: string;

  /**
   * 检查所见
   */
  examDiagDescription?: string;

  /**
   * 检查结论
   */
  examDiagConclusion?: string;

  /**
   * 扩展字段1
   */
  extendData1?: string;

  /**
   * 扩展字段2
   */
  extendData2?: string;

  /**
   * 记录状态:1正常 0作废
   */
  recordStatus?: number;

  /**
   * 创建时间
   */
  createdTime?: string;

  /**
   * 更新时间
   */
  updatedTime?: string;

}

export interface NatdssB161ExamInfoQuery extends PageQuery {

  /**
   * 患者ID
   */
  patientId?: string | number;

  /**
   * 单次就诊唯一标识号
   */
  visitSn?: string;

  /**
   * 就诊类型:住院、门诊
   */
  visitType?: string;

  /**
   * 就诊卡号
   */
  visitCardNo?: string;

  /**
   * 门诊号
   */
  outpatientNo?: string;

  /**
   * 就诊次数
   */
  visitTimes?: number;

  /**
   * 病案号
   */
  medicalRecordNo?: string;

  /**
   * 住院号
   */
  inpatientNo?: string;

  /**
   * 住院次数
   */
  hospitalizationTimes?: string;

  /**
   * 患者姓名
   */
  name?: string;

  /**
   * 申请单号
   */
  applyNo?: string;

  /**
   * 申请医嘱流水号
   */
  orderSn?: string;

  /**
   * 申请时间
   */
  applyDatetime?: string;

  /**
   * 申请科室代码
   */
  applyDeptCode?: string;

  /**
   * 申请科室名称
   */
  applyDeptName?: string;

  /**
   * 检查流水号
   */
  examSn?: string;

  /**
   * 检查时间
   */
  examDatetime?: string;

  /**
   * 检查类型:心电超声放射
   */
  examType?: string;

  /**
   * 检查项目类型
   */
  examItemType?: string;

  /**
   * 检查项目代码
   */
  examItemCode?: string;

  /**
   * 检查项目名称
   */
  examItemName?: string;

  /**
   * 检查部位
   */
  examSites?: string;

  /**
   * 报告单号
   */
  reportNo?: string;

  /**
   * 报告时间
   */
  reportDatetime?: string;

  /**
   * 报告科室代码
   */
  reportDeptCode?: string;

  /**
   * 报告科室名称
   */
  reportDeptName?: string;

  /**
   * 检查所见
   */
  examDiagDescription?: string;

  /**
   * 检查结论
   */
  examDiagConclusion?: string;

  /**
   * 扩展字段1
   */
  extendData1?: string;

  /**
   * 扩展字段2
   */
  extendData2?: string;

  /**
   * 记录状态:1正常 0作废
   */
  recordStatus?: number;

  /**
   * 创建时间
   */
  createdTime?: string;

  /**
   * 更新时间
   */
  updatedTime?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}



