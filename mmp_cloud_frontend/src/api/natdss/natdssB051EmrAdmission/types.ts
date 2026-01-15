export interface NatdssB051EmrAdmissionVO {
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
   * 入院记录流水号
   */
  recordSn: string;

  /**
   * 入院记录创建时间
   */
  recordDatetime: string;

  /**
   * KPS评分
   */
  kpsScore: string;

  /**
   * ECOG PS评分
   */
  ecogScore: string;

  /**
   * 文书内容
   */
  recordText: string;

  /**
   * 主诉
   */
  chiefComplaint: string;

  /**
   * 现病史
   */
  currentMedhistory: string;

  /**
   * 既往史
   */
  pastMedhistory: string;

  /**
   * 个人史
   */
  personalMedhistory: string;

  /**
   * 家族史
   */
  familyHistory: string;

  /**
   * 婚育史
   */
  marriageBirthHistory: string;

  /**
   * 月经史
   */
  menstrualHistory: string;

  /**
   * 收缩压(mmHg)
   */
  systolicPressure: string;

  /**
   * 舒张压(mmHg)
   */
  diastolicPressure: string;

  /**
   * 呼吸(次/分)
   */
  respiratoryRate: string;

  /**
   * 体温(℃)
   */
  bodyTemperature: string;

  /**
   * 心率(次/分)
   */
  heartRate: string;

  /**
   * 身高(cm)
   */
  height: string;

  /**
   * 体重(kg)
   */
  weight: string;

  /**
   * 体表面积(m²)
   */
  bodySurfaceArea: string;

  /**
   * 体格检查
   */
  physicalExam: string;

  /**
   * 专科检查
   */
  specialExam: string;

  /**
   * 辅助检查
   */
  auxiliaryExam: string;

  /**
   * 入院主要诊断编码
   */
  admissionMaindiagCode1: string;

  /**
   * 入院主要诊断名称
   */
  admissionMaindiagName1: string;

  /**
   * 入院诊断编码-2
   */
  admissionDiagCode2: string;

  /**
   * 入院诊断名称-2
   */
  admissionDiagName2: string;

  /**
   * 入院诊断编码-3
   */
  admissionDiagCode3: string;

  /**
   * 入院诊断名称-3
   */
  admissionDiagName3: string;

  /**
   * 入院诊断编码-4
   */
  admissionDiagCode4: string;

  /**
   * 入院诊断名称-4
   */
  admissionDiagName4: string;

  /**
   * 入院诊断编码-5
   */
  admissionDiagCode5: string;

  /**
   * 入院诊断名称-5
   */
  admissionDiagName5: string;

  /**
   * 入院诊断编码-N
   */
  admissionDiagCoden: string;

  /**
   * 入院诊断名称-N
   */
  admissionDiagNamen: string;

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

export interface NatdssB051EmrAdmissionForm extends BaseEntity {
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
   * 入院记录流水号
   */
  recordSn?: string;

  /**
   * 入院记录创建时间
   */
  recordDatetime?: string;

  /**
   * KPS评分
   */
  kpsScore?: string;

  /**
   * ECOG PS评分
   */
  ecogScore?: string;

  /**
   * 文书内容
   */
  recordText?: string;

  /**
   * 主诉
   */
  chiefComplaint?: string;

  /**
   * 现病史
   */
  currentMedhistory?: string;

  /**
   * 既往史
   */
  pastMedhistory?: string;

  /**
   * 个人史
   */
  personalMedhistory?: string;

  /**
   * 家族史
   */
  familyHistory?: string;

  /**
   * 婚育史
   */
  marriageBirthHistory?: string;

  /**
   * 月经史
   */
  menstrualHistory?: string;

  /**
   * 收缩压(mmHg)
   */
  systolicPressure?: string;

  /**
   * 舒张压(mmHg)
   */
  diastolicPressure?: string;

  /**
   * 呼吸(次/分)
   */
  respiratoryRate?: string;

  /**
   * 体温(℃)
   */
  bodyTemperature?: string;

  /**
   * 心率(次/分)
   */
  heartRate?: string;

  /**
   * 身高(cm)
   */
  height?: string;

  /**
   * 体重(kg)
   */
  weight?: string;

  /**
   * 体表面积(m²)
   */
  bodySurfaceArea?: string;

  /**
   * 体格检查
   */
  physicalExam?: string;

  /**
   * 专科检查
   */
  specialExam?: string;

  /**
   * 辅助检查
   */
  auxiliaryExam?: string;

  /**
   * 入院主要诊断编码
   */
  admissionMaindiagCode1?: string;

  /**
   * 入院主要诊断名称
   */
  admissionMaindiagName1?: string;

  /**
   * 入院诊断编码-2
   */
  admissionDiagCode2?: string;

  /**
   * 入院诊断名称-2
   */
  admissionDiagName2?: string;

  /**
   * 入院诊断编码-3
   */
  admissionDiagCode3?: string;

  /**
   * 入院诊断名称-3
   */
  admissionDiagName3?: string;

  /**
   * 入院诊断编码-4
   */
  admissionDiagCode4?: string;

  /**
   * 入院诊断名称-4
   */
  admissionDiagName4?: string;

  /**
   * 入院诊断编码-5
   */
  admissionDiagCode5?: string;

  /**
   * 入院诊断名称-5
   */
  admissionDiagName5?: string;

  /**
   * 入院诊断编码-N
   */
  admissionDiagCoden?: string;

  /**
   * 入院诊断名称-N
   */
  admissionDiagNamen?: string;

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

export interface NatdssB051EmrAdmissionQuery extends PageQuery {

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
   * 入院记录流水号
   */
  recordSn?: string;

  /**
   * 入院记录创建时间
   */
  recordDatetime?: string;

  /**
   * KPS评分
   */
  kpsScore?: string;

  /**
   * ECOG PS评分
   */
  ecogScore?: string;

  /**
   * 文书内容
   */
  recordText?: string;

  /**
   * 主诉
   */
  chiefComplaint?: string;

  /**
   * 现病史
   */
  currentMedhistory?: string;

  /**
   * 既往史
   */
  pastMedhistory?: string;

  /**
   * 个人史
   */
  personalMedhistory?: string;

  /**
   * 家族史
   */
  familyHistory?: string;

  /**
   * 婚育史
   */
  marriageBirthHistory?: string;

  /**
   * 月经史
   */
  menstrualHistory?: string;

  /**
   * 收缩压(mmHg)
   */
  systolicPressure?: string;

  /**
   * 舒张压(mmHg)
   */
  diastolicPressure?: string;

  /**
   * 呼吸(次/分)
   */
  respiratoryRate?: string;

  /**
   * 体温(℃)
   */
  bodyTemperature?: string;

  /**
   * 心率(次/分)
   */
  heartRate?: string;

  /**
   * 身高(cm)
   */
  height?: string;

  /**
   * 体重(kg)
   */
  weight?: string;

  /**
   * 体表面积(m²)
   */
  bodySurfaceArea?: string;

  /**
   * 体格检查
   */
  physicalExam?: string;

  /**
   * 专科检查
   */
  specialExam?: string;

  /**
   * 辅助检查
   */
  auxiliaryExam?: string;

  /**
   * 入院主要诊断编码
   */
  admissionMaindiagCode1?: string;

  /**
   * 入院主要诊断名称
   */
  admissionMaindiagName1?: string;

  /**
   * 入院诊断编码-2
   */
  admissionDiagCode2?: string;

  /**
   * 入院诊断名称-2
   */
  admissionDiagName2?: string;

  /**
   * 入院诊断编码-3
   */
  admissionDiagCode3?: string;

  /**
   * 入院诊断名称-3
   */
  admissionDiagName3?: string;

  /**
   * 入院诊断编码-4
   */
  admissionDiagCode4?: string;

  /**
   * 入院诊断名称-4
   */
  admissionDiagName4?: string;

  /**
   * 入院诊断编码-5
   */
  admissionDiagCode5?: string;

  /**
   * 入院诊断名称-5
   */
  admissionDiagName5?: string;

  /**
   * 入院诊断编码-N
   */
  admissionDiagCoden?: string;

  /**
   * 入院诊断名称-N
   */
  admissionDiagNamen?: string;

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



