export interface NatdssB091InpatientNursingRecordVO {
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
   * 护理记录流水号
   */
  recordSn: string;

  /**
   * 科室代码
   */
  deptCode: string;

  /**
   * 科室名称
   */
  deptName: string;

  /**
   * 床号
   */
  bedNo: string;

  /**
   * 护理记录时间
   */
  recordDatetime: string;

  /**
   * 护理测量时间
   */
  testDatetime: string;

  /**
   * 测量方式
   */
  testMethod: string;

  /**
   * 测量项目代码
   */
  itemCode: string;

  /**
   * 测量项目名称
   */
  itemName: string;

  /**
   * 疼痛评分
   */
  painScores: string;

  /**
   * 测量结果值1
   */
  itemResultValue1: string;

  /**
   * 测量结果单位1
   */
  itemResultUnit1: string;

  /**
   * 测量结果值2
   */
  itemResultValue2: string;

  /**
   * 测量结果单位2
   */
  itemResultUnit2: string;

  /**
   * 病情观察及措施
   */
  observationMeasures: string;

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

export interface NatdssB091InpatientNursingRecordForm extends BaseEntity {
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
   * 护理记录流水号
   */
  recordSn?: string;

  /**
   * 科室代码
   */
  deptCode?: string;

  /**
   * 科室名称
   */
  deptName?: string;

  /**
   * 床号
   */
  bedNo?: string;

  /**
   * 护理记录时间
   */
  recordDatetime?: string;

  /**
   * 护理测量时间
   */
  testDatetime?: string;

  /**
   * 测量方式
   */
  testMethod?: string;

  /**
   * 测量项目代码
   */
  itemCode?: string;

  /**
   * 测量项目名称
   */
  itemName?: string;

  /**
   * 疼痛评分
   */
  painScores?: string;

  /**
   * 测量结果值1
   */
  itemResultValue1?: string;

  /**
   * 测量结果单位1
   */
  itemResultUnit1?: string;

  /**
   * 测量结果值2
   */
  itemResultValue2?: string;

  /**
   * 测量结果单位2
   */
  itemResultUnit2?: string;

  /**
   * 病情观察及措施
   */
  observationMeasures?: string;

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

export interface NatdssB091InpatientNursingRecordQuery extends PageQuery {

  /**
   * 患者ID
   */
  patientId?: string | number;

  /**
   * 单次就诊唯一标识号
   */
  visitSn?: string;

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
   * 护理记录流水号
   */
  recordSn?: string;

  /**
   * 科室代码
   */
  deptCode?: string;

  /**
   * 科室名称
   */
  deptName?: string;

  /**
   * 床号
   */
  bedNo?: string;

  /**
   * 护理记录时间
   */
  recordDatetime?: string;

  /**
   * 护理测量时间
   */
  testDatetime?: string;

  /**
   * 测量方式
   */
  testMethod?: string;

  /**
   * 测量项目代码
   */
  itemCode?: string;

  /**
   * 测量项目名称
   */
  itemName?: string;

  /**
   * 疼痛评分
   */
  painScores?: string;

  /**
   * 测量结果值1
   */
  itemResultValue1?: string;

  /**
   * 测量结果单位1
   */
  itemResultUnit1?: string;

  /**
   * 测量结果值2
   */
  itemResultValue2?: string;

  /**
   * 测量结果单位2
   */
  itemResultUnit2?: string;

  /**
   * 病情观察及措施
   */
  observationMeasures?: string;

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



