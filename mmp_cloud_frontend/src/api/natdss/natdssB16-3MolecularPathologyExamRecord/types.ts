export interface NatdssB16-3MolecularPathologyExamRecordVO {
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
   * 分子病理号
   */
  molPathoNo: string;

  /**
   * 检测流水号
   */
  labSn: string;

  /**
   * 检测时间
   */
  examDatetime: string;

  /**
   * 标本编号
   */
  sampleNo: string;

  /**
   * 标本类型
   */
  sampleType: string;

  /**
   * 检测平台
   */
  testPlatform: string;

  /**
   * 检测项目
   */
  testItem: string;

  /**
   * 检测方法
   */
  testMethod: string;

  /**
   * 检测内容
   */
  testContent: string;

  /**
   * 检测结果
   */
  testResult: string;

  /**
   * 报告单号
   */
  reportNo: string;

  /**
   * 报告时间
   */
  reportDatetime: string;

  /**
   * 外显子
   */
  testExon: string;

  /**
   * 位点
   */
  testLocus: string;

  /**
   * 检测基因
   */
  testGene: string;

  /**
   * 转录本
   */
  transcript: string;

  /**
   * 核苷酸改变
   */
  nucleAlt: string;

  /**
   * 氨基酸改变
   */
  aminoAcidAlt: string | number;

  /**
   * 丰度
   */
  mutAbundance: string;

  /**
   * 变异类型
   */
  variationType: string;

  /**
   * 变异解读
   */
  mutInterpretation: string;

  /**
   * 基因型
   */
  genoType: string;

  /**
   * 取材部位
   */
  samplingSite: string;

  /**
   * 测序深度
   */
  geneSequencingDepth: string;

  /**
   * 肿瘤突变负荷
   */
  tmb: string;

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

export interface NatdssB16-3MolecularPathologyExamRecordForm extends BaseEntity {
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
   * 分子病理号
   */
  molPathoNo?: string;

  /**
   * 检测流水号
   */
  labSn?: string;

  /**
   * 检测时间
   */
  examDatetime?: string;

  /**
   * 标本编号
   */
  sampleNo?: string;

  /**
   * 标本类型
   */
  sampleType?: string;

  /**
   * 检测平台
   */
  testPlatform?: string;

  /**
   * 检测项目
   */
  testItem?: string;

  /**
   * 检测方法
   */
  testMethod?: string;

  /**
   * 检测内容
   */
  testContent?: string;

  /**
   * 检测结果
   */
  testResult?: string;

  /**
   * 报告单号
   */
  reportNo?: string;

  /**
   * 报告时间
   */
  reportDatetime?: string;

  /**
   * 外显子
   */
  testExon?: string;

  /**
   * 位点
   */
  testLocus?: string;

  /**
   * 检测基因
   */
  testGene?: string;

  /**
   * 转录本
   */
  transcript?: string;

  /**
   * 核苷酸改变
   */
  nucleAlt?: string;

  /**
   * 氨基酸改变
   */
  aminoAcidAlt?: string | number;

  /**
   * 丰度
   */
  mutAbundance?: string;

  /**
   * 变异类型
   */
  variationType?: string;

  /**
   * 变异解读
   */
  mutInterpretation?: string;

  /**
   * 基因型
   */
  genoType?: string;

  /**
   * 取材部位
   */
  samplingSite?: string;

  /**
   * 测序深度
   */
  geneSequencingDepth?: string;

  /**
   * 肿瘤突变负荷
   */
  tmb?: string;

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

export interface NatdssB16-3MolecularPathologyExamRecordQuery extends PageQuery {

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
   * 分子病理号
   */
  molPathoNo?: string;

  /**
   * 检测流水号
   */
  labSn?: string;

  /**
   * 检测时间
   */
  examDatetime?: string;

  /**
   * 标本编号
   */
  sampleNo?: string;

  /**
   * 标本类型
   */
  sampleType?: string;

  /**
   * 检测平台
   */
  testPlatform?: string;

  /**
   * 检测项目
   */
  testItem?: string;

  /**
   * 检测方法
   */
  testMethod?: string;

  /**
   * 检测内容
   */
  testContent?: string;

  /**
   * 检测结果
   */
  testResult?: string;

  /**
   * 报告单号
   */
  reportNo?: string;

  /**
   * 报告时间
   */
  reportDatetime?: string;

  /**
   * 外显子
   */
  testExon?: string;

  /**
   * 位点
   */
  testLocus?: string;

  /**
   * 检测基因
   */
  testGene?: string;

  /**
   * 转录本
   */
  transcript?: string;

  /**
   * 核苷酸改变
   */
  nucleAlt?: string;

  /**
   * 氨基酸改变
   */
  aminoAcidAlt?: string | number;

  /**
   * 丰度
   */
  mutAbundance?: string;

  /**
   * 变异类型
   */
  variationType?: string;

  /**
   * 变异解读
   */
  mutInterpretation?: string;

  /**
   * 基因型
   */
  genoType?: string;

  /**
   * 取材部位
   */
  samplingSite?: string;

  /**
   * 测序深度
   */
  geneSequencingDepth?: string;

  /**
   * 肿瘤突变负荷
   */
  tmb?: string;

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



