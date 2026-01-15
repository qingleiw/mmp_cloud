export interface NatdssB16-2PathologicalExamRecordVO {
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
   * 性别
   */
  gender: string;

  /**
   * 年龄(岁)
   */
  age: number;

  /**
   * 出生日期
   */
  dateOfBirth: string;

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
   * 病理号
   */
  pathologyNo: string;

  /**
   * 病理检查流水号
   */
  pathologySn: string;

  /**
   * 检查时间
   */
  examDatetime: string;

  /**
   * 病理检查类型代码
   */
  pathologyTestTypeCode: string;

  /**
   * 病理检查类型
   */
  pathologyTestType: string;

  /**
   * 标本部位
   */
  specimenSite: string;

  /**
   * 标本来源
   */
  specimenObtainMethod: string;

  /**
   * 标本类型
   */
  specimenType: string;

  /**
   * 标本编号
   */
  specimenCode: string;

  /**
   * 标本采集时间
   */
  collectedDatetime: string;

  /**
   * 标本接收时间
   */
  receivedDatetime: string;

  /**
   * 报告单号
   */
  reportNo: string;

  /**
   * 报告时间
   */
  reportDatetime: string;

  /**
   * TNM分期版本
   */
  stagingVersion: string;

  /**
   * 病理分期
   */
  clinicalStage: string;

  /**
   * pT分期
   */
  pathoTStaging: string;

  /**
   * pN分期
   */
  pathoNStaging: string;

  /**
   * pM分期
   */
  pathoMStaging: string;

  /**
   * 肉眼所见
   */
  grossDescription: string;

  /**
   * 镜下所见
   */
  microDescription: string;

  /**
   * 病理诊断结论
   */
  pathoDiagConclusion: string;

  /**
   * 免疫组化检测结果
   */
  ihcResults: string;

  /**
   * 有无分子检测
   */
  molTestMark: string;

  /**
   * 分子检测项目及方法
   */
  molTestGeneAndMethod: string;

  /**
   * 分子检测结果
   */
  molTestResult: string;

  /**
   * 分化程度
   */
  differentiationDegree: string;

  /**
   * 血管浸润
   */
  bloodVesselInfil: string;

  /**
   * 淋巴浸润
   */
  lymphInfilt: string;

  /**
   * 淋巴结转移
   */
  lymphMet: string;

  /**
   * 脉管瘤栓
   */
  vascTumourThrombus: string;

  /**
   * 神经侵犯
   */
  nerveInvasion: string;

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
   * 术中冰冻结果
   */
  intraoperativeFreezingResult: string;

  /**
   * 记录人1
   */
  recorder1: string;

  /**
   * 记录人2
   */
  recorder2: string;

  /**
   * 创建时间
   */
  createdTime: string;

  /**
   * 更新时间
   */
  updatedTime: string;

}

export interface NatdssB16-2PathologicalExamRecordForm extends BaseEntity {
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
   * 性别
   */
  gender?: string;

  /**
   * 年龄(岁)
   */
  age?: number;

  /**
   * 出生日期
   */
  dateOfBirth?: string;

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
   * 病理号
   */
  pathologyNo?: string;

  /**
   * 病理检查流水号
   */
  pathologySn?: string;

  /**
   * 检查时间
   */
  examDatetime?: string;

  /**
   * 病理检查类型代码
   */
  pathologyTestTypeCode?: string;

  /**
   * 病理检查类型
   */
  pathologyTestType?: string;

  /**
   * 标本部位
   */
  specimenSite?: string;

  /**
   * 标本来源
   */
  specimenObtainMethod?: string;

  /**
   * 标本类型
   */
  specimenType?: string;

  /**
   * 标本编号
   */
  specimenCode?: string;

  /**
   * 标本采集时间
   */
  collectedDatetime?: string;

  /**
   * 标本接收时间
   */
  receivedDatetime?: string;

  /**
   * 报告单号
   */
  reportNo?: string;

  /**
   * 报告时间
   */
  reportDatetime?: string;

  /**
   * TNM分期版本
   */
  stagingVersion?: string;

  /**
   * 病理分期
   */
  clinicalStage?: string;

  /**
   * pT分期
   */
  pathoTStaging?: string;

  /**
   * pN分期
   */
  pathoNStaging?: string;

  /**
   * pM分期
   */
  pathoMStaging?: string;

  /**
   * 肉眼所见
   */
  grossDescription?: string;

  /**
   * 镜下所见
   */
  microDescription?: string;

  /**
   * 病理诊断结论
   */
  pathoDiagConclusion?: string;

  /**
   * 免疫组化检测结果
   */
  ihcResults?: string;

  /**
   * 有无分子检测
   */
  molTestMark?: string;

  /**
   * 分子检测项目及方法
   */
  molTestGeneAndMethod?: string;

  /**
   * 分子检测结果
   */
  molTestResult?: string;

  /**
   * 分化程度
   */
  differentiationDegree?: string;

  /**
   * 血管浸润
   */
  bloodVesselInfil?: string;

  /**
   * 淋巴浸润
   */
  lymphInfilt?: string;

  /**
   * 淋巴结转移
   */
  lymphMet?: string;

  /**
   * 脉管瘤栓
   */
  vascTumourThrombus?: string;

  /**
   * 神经侵犯
   */
  nerveInvasion?: string;

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
   * 术中冰冻结果
   */
  intraoperativeFreezingResult?: string;

  /**
   * 记录人1
   */
  recorder1?: string;

  /**
   * 记录人2
   */
  recorder2?: string;

  /**
   * 创建时间
   */
  createdTime?: string;

  /**
   * 更新时间
   */
  updatedTime?: string;

}

export interface NatdssB16-2PathologicalExamRecordQuery extends PageQuery {

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
   * 性别
   */
  gender?: string;

  /**
   * 年龄(岁)
   */
  age?: number;

  /**
   * 出生日期
   */
  dateOfBirth?: string;

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
   * 病理号
   */
  pathologyNo?: string;

  /**
   * 病理检查流水号
   */
  pathologySn?: string;

  /**
   * 检查时间
   */
  examDatetime?: string;

  /**
   * 病理检查类型代码
   */
  pathologyTestTypeCode?: string;

  /**
   * 病理检查类型
   */
  pathologyTestType?: string;

  /**
   * 标本部位
   */
  specimenSite?: string;

  /**
   * 标本来源
   */
  specimenObtainMethod?: string;

  /**
   * 标本类型
   */
  specimenType?: string;

  /**
   * 标本编号
   */
  specimenCode?: string;

  /**
   * 标本采集时间
   */
  collectedDatetime?: string;

  /**
   * 标本接收时间
   */
  receivedDatetime?: string;

  /**
   * 报告单号
   */
  reportNo?: string;

  /**
   * 报告时间
   */
  reportDatetime?: string;

  /**
   * TNM分期版本
   */
  stagingVersion?: string;

  /**
   * 病理分期
   */
  clinicalStage?: string;

  /**
   * pT分期
   */
  pathoTStaging?: string;

  /**
   * pN分期
   */
  pathoNStaging?: string;

  /**
   * pM分期
   */
  pathoMStaging?: string;

  /**
   * 肉眼所见
   */
  grossDescription?: string;

  /**
   * 镜下所见
   */
  microDescription?: string;

  /**
   * 病理诊断结论
   */
  pathoDiagConclusion?: string;

  /**
   * 免疫组化检测结果
   */
  ihcResults?: string;

  /**
   * 有无分子检测
   */
  molTestMark?: string;

  /**
   * 分子检测项目及方法
   */
  molTestGeneAndMethod?: string;

  /**
   * 分子检测结果
   */
  molTestResult?: string;

  /**
   * 分化程度
   */
  differentiationDegree?: string;

  /**
   * 血管浸润
   */
  bloodVesselInfil?: string;

  /**
   * 淋巴浸润
   */
  lymphInfilt?: string;

  /**
   * 淋巴结转移
   */
  lymphMet?: string;

  /**
   * 脉管瘤栓
   */
  vascTumourThrombus?: string;

  /**
   * 神经侵犯
   */
  nerveInvasion?: string;

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
   * 术中冰冻结果
   */
  intraoperativeFreezingResult?: string;

  /**
   * 记录人1
   */
  recorder1?: string;

  /**
   * 记录人2
   */
  recorder2?: string;

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



