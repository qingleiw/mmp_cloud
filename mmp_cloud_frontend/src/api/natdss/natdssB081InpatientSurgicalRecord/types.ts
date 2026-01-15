export interface NatdssB081InpatientSurgicalRecordVO {
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
   * 手术记录流水号
   */
  recordSn: string;

  /**
   * 手术记录时间
   */
  recordDatetime: string;

  /**
   * 主刀医生代码
   */
  surgeonNo: string;

  /**
   * 医师职称名称
   */
  technicalTitle: string;

  /**
   * 医师职务名称
   */
  jobTitle: string;

  /**
   * 手术执行科室编号
   */
  executiveDeptCode: string;

  /**
   * 手术执行科室名称
   */
  executiveDeptName: string;

  /**
   * 手术编码
   */
  surgeryCode: string;

  /**
   * 手术名称
   */
  surgeryName: string;

  /**
   * 手术开始时间
   */
  startDatetime: string;

  /**
   * 手术结束时间
   */
  finishDatetime: string;

  /**
   * 切口类型
   */
  incisionType: string;

  /**
   * 手术级别
   */
  surgeryLevel: string;

  /**
   * 手术入路
   */
  surgicalApproach: string;

  /**
   * 是否预防性使用抗生素
   */
  preventiveAntibioticMark: string;

  /**
   * 手术过程描述
   */
  proceduresDescription: string;

  /**
   * 麻醉医师代码
   */
  asaSurgeonNo: string;

  /**
   * 麻醉医师职称名称
   */
  asaTechnicalTitle: string;

  /**
   * 麻醉医师职务名称
   */
  asaJobTitle: string;

  /**
   * 麻醉方式代码
   */
  anesthesiaTypeCode: string;

  /**
   * 麻醉方式
   */
  anesthesiaType: string;

  /**
   * 麻醉评分
   */
  asaPhysicalStatus: string;

  /**
   * 麻醉开始时间
   */
  anesthesiaStartTime: string;

  /**
   * 麻醉结束时间
   */
  anesthesiaEndTime: string;

  /**
   * 总入量(ml)
   */
  intakeVolume: string;

  /**
   * 总出量(ml)
   */
  outputVolume: string;

  /**
   * 输血血型-ABO
   */
  bloodTransAbo: string;

  /**
   * 输血血型-Rh
   */
  bloodTransRh: string;

  /**
   * 输血成份类型代码
   */
  bloodTransComponentCode: string;

  /**
   * 输血成份类型
   */
  bloodTransComponent: string;

  /**
   * 输血量(ml)
   */
  bloodTransVolume: string;

  /**
   * 出血量(ml)
   */
  bloodLossVolume: string;

  /**
   * 尿量(ml)
   */
  urineVolume: string;

  /**
   * 术前主要诊断编码
   */
  presurgeryMaindiagCode1: string;

  /**
   * 术前主要诊断名称
   */
  presurgeryMaindiagName1: string;

  /**
   * 术前诊断编码-2
   */
  presurgeryDiagCode2: string;

  /**
   * 术前诊断名称-2
   */
  presurgeryDiagName2: string;

  /**
   * 术前诊断编码-3
   */
  presurgeryDiagCode3: string;

  /**
   * 术前诊断名称-3
   */
  presurgeryDiagName3: string;

  /**
   * 术前诊断编码-4
   */
  presurgeryDiagCode4: string;

  /**
   * 术前诊断名称-4
   */
  presurgeryDiagName4: string;

  /**
   * 术前诊断编码-5
   */
  presurgeryDiagCode5: string;

  /**
   * 术前诊断名称-5
   */
  presurgeryDiagName5: string;

  /**
   * 术中主要诊断编码
   */
  intrasurgeryMaindiagCode1: string;

  /**
   * 术中主要诊断名称
   */
  intrasurgeryMaindiagName1: string;

  /**
   * 术中诊断编码-2
   */
  intrasurgeryDiagCode2: string;

  /**
   * 术中诊断名称-2
   */
  intrasurgeryDiagName2: string;

  /**
   * 术中诊断编码-3
   */
  intrasurgeryDiagCode3: string;

  /**
   * 术中诊断名称-3
   */
  intrasurgeryDiagName3: string;

  /**
   * 术中诊断编码-4
   */
  intrasurgeryDiagCode4: string;

  /**
   * 术中诊断名称-4
   */
  intrasurgeryDiagName4: string;

  /**
   * 术中诊断编码-5
   */
  intrasurgeryDiagCode5: string;

  /**
   * 术中诊断名称-5
   */
  intrasurgeryDiagName5: string;

  /**
   * 术后主要诊断编码
   */
  postsurgeryMaindiagCode1: string;

  /**
   * 术后主要诊断名称
   */
  postsurgeryMaindiagName1: string;

  /**
   * 术后诊断编码-2
   */
  postsurgeryDiagCode2: string;

  /**
   * 术后诊断名称-2
   */
  postsurgeryDiagName2: string;

  /**
   * 术后诊断编码-3
   */
  postsurgeryDiagCode3: string;

  /**
   * 术后诊断名称-3
   */
  postsurgeryDiagName3: string;

  /**
   * 术后诊断编码-4
   */
  postsurgeryDiagCode4: string;

  /**
   * 术后诊断名称-4
   */
  postsurgeryDiagName4: string;

  /**
   * 术后诊断编码-5
   */
  postsurgeryDiagCode5: string;

  /**
   * 术后诊断名称-5
   */
  postsurgeryDiagName5: string;

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

export interface NatdssB081InpatientSurgicalRecordForm extends BaseEntity {
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
   * 手术记录流水号
   */
  recordSn?: string;

  /**
   * 手术记录时间
   */
  recordDatetime?: string;

  /**
   * 主刀医生代码
   */
  surgeonNo?: string;

  /**
   * 医师职称名称
   */
  technicalTitle?: string;

  /**
   * 医师职务名称
   */
  jobTitle?: string;

  /**
   * 手术执行科室编号
   */
  executiveDeptCode?: string;

  /**
   * 手术执行科室名称
   */
  executiveDeptName?: string;

  /**
   * 手术编码
   */
  surgeryCode?: string;

  /**
   * 手术名称
   */
  surgeryName?: string;

  /**
   * 手术开始时间
   */
  startDatetime?: string;

  /**
   * 手术结束时间
   */
  finishDatetime?: string;

  /**
   * 切口类型
   */
  incisionType?: string;

  /**
   * 手术级别
   */
  surgeryLevel?: string;

  /**
   * 手术入路
   */
  surgicalApproach?: string;

  /**
   * 是否预防性使用抗生素
   */
  preventiveAntibioticMark?: string;

  /**
   * 手术过程描述
   */
  proceduresDescription?: string;

  /**
   * 麻醉医师代码
   */
  asaSurgeonNo?: string;

  /**
   * 麻醉医师职称名称
   */
  asaTechnicalTitle?: string;

  /**
   * 麻醉医师职务名称
   */
  asaJobTitle?: string;

  /**
   * 麻醉方式代码
   */
  anesthesiaTypeCode?: string;

  /**
   * 麻醉方式
   */
  anesthesiaType?: string;

  /**
   * 麻醉评分
   */
  asaPhysicalStatus?: string;

  /**
   * 麻醉开始时间
   */
  anesthesiaStartTime?: string;

  /**
   * 麻醉结束时间
   */
  anesthesiaEndTime?: string;

  /**
   * 总入量(ml)
   */
  intakeVolume?: string;

  /**
   * 总出量(ml)
   */
  outputVolume?: string;

  /**
   * 输血血型-ABO
   */
  bloodTransAbo?: string;

  /**
   * 输血血型-Rh
   */
  bloodTransRh?: string;

  /**
   * 输血成份类型代码
   */
  bloodTransComponentCode?: string;

  /**
   * 输血成份类型
   */
  bloodTransComponent?: string;

  /**
   * 输血量(ml)
   */
  bloodTransVolume?: string;

  /**
   * 出血量(ml)
   */
  bloodLossVolume?: string;

  /**
   * 尿量(ml)
   */
  urineVolume?: string;

  /**
   * 术前主要诊断编码
   */
  presurgeryMaindiagCode1?: string;

  /**
   * 术前主要诊断名称
   */
  presurgeryMaindiagName1?: string;

  /**
   * 术前诊断编码-2
   */
  presurgeryDiagCode2?: string;

  /**
   * 术前诊断名称-2
   */
  presurgeryDiagName2?: string;

  /**
   * 术前诊断编码-3
   */
  presurgeryDiagCode3?: string;

  /**
   * 术前诊断名称-3
   */
  presurgeryDiagName3?: string;

  /**
   * 术前诊断编码-4
   */
  presurgeryDiagCode4?: string;

  /**
   * 术前诊断名称-4
   */
  presurgeryDiagName4?: string;

  /**
   * 术前诊断编码-5
   */
  presurgeryDiagCode5?: string;

  /**
   * 术前诊断名称-5
   */
  presurgeryDiagName5?: string;

  /**
   * 术中主要诊断编码
   */
  intrasurgeryMaindiagCode1?: string;

  /**
   * 术中主要诊断名称
   */
  intrasurgeryMaindiagName1?: string;

  /**
   * 术中诊断编码-2
   */
  intrasurgeryDiagCode2?: string;

  /**
   * 术中诊断名称-2
   */
  intrasurgeryDiagName2?: string;

  /**
   * 术中诊断编码-3
   */
  intrasurgeryDiagCode3?: string;

  /**
   * 术中诊断名称-3
   */
  intrasurgeryDiagName3?: string;

  /**
   * 术中诊断编码-4
   */
  intrasurgeryDiagCode4?: string;

  /**
   * 术中诊断名称-4
   */
  intrasurgeryDiagName4?: string;

  /**
   * 术中诊断编码-5
   */
  intrasurgeryDiagCode5?: string;

  /**
   * 术中诊断名称-5
   */
  intrasurgeryDiagName5?: string;

  /**
   * 术后主要诊断编码
   */
  postsurgeryMaindiagCode1?: string;

  /**
   * 术后主要诊断名称
   */
  postsurgeryMaindiagName1?: string;

  /**
   * 术后诊断编码-2
   */
  postsurgeryDiagCode2?: string;

  /**
   * 术后诊断名称-2
   */
  postsurgeryDiagName2?: string;

  /**
   * 术后诊断编码-3
   */
  postsurgeryDiagCode3?: string;

  /**
   * 术后诊断名称-3
   */
  postsurgeryDiagName3?: string;

  /**
   * 术后诊断编码-4
   */
  postsurgeryDiagCode4?: string;

  /**
   * 术后诊断名称-4
   */
  postsurgeryDiagName4?: string;

  /**
   * 术后诊断编码-5
   */
  postsurgeryDiagCode5?: string;

  /**
   * 术后诊断名称-5
   */
  postsurgeryDiagName5?: string;

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

export interface NatdssB081InpatientSurgicalRecordQuery extends PageQuery {

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
   * 手术记录流水号
   */
  recordSn?: string;

  /**
   * 手术记录时间
   */
  recordDatetime?: string;

  /**
   * 主刀医生代码
   */
  surgeonNo?: string;

  /**
   * 医师职称名称
   */
  technicalTitle?: string;

  /**
   * 医师职务名称
   */
  jobTitle?: string;

  /**
   * 手术执行科室编号
   */
  executiveDeptCode?: string;

  /**
   * 手术执行科室名称
   */
  executiveDeptName?: string;

  /**
   * 手术编码
   */
  surgeryCode?: string;

  /**
   * 手术名称
   */
  surgeryName?: string;

  /**
   * 手术开始时间
   */
  startDatetime?: string;

  /**
   * 手术结束时间
   */
  finishDatetime?: string;

  /**
   * 切口类型
   */
  incisionType?: string;

  /**
   * 手术级别
   */
  surgeryLevel?: string;

  /**
   * 手术入路
   */
  surgicalApproach?: string;

  /**
   * 是否预防性使用抗生素
   */
  preventiveAntibioticMark?: string;

  /**
   * 手术过程描述
   */
  proceduresDescription?: string;

  /**
   * 麻醉医师代码
   */
  asaSurgeonNo?: string;

  /**
   * 麻醉医师职称名称
   */
  asaTechnicalTitle?: string;

  /**
   * 麻醉医师职务名称
   */
  asaJobTitle?: string;

  /**
   * 麻醉方式代码
   */
  anesthesiaTypeCode?: string;

  /**
   * 麻醉方式
   */
  anesthesiaType?: string;

  /**
   * 麻醉评分
   */
  asaPhysicalStatus?: string;

  /**
   * 麻醉开始时间
   */
  anesthesiaStartTime?: string;

  /**
   * 麻醉结束时间
   */
  anesthesiaEndTime?: string;

  /**
   * 总入量(ml)
   */
  intakeVolume?: string;

  /**
   * 总出量(ml)
   */
  outputVolume?: string;

  /**
   * 输血血型-ABO
   */
  bloodTransAbo?: string;

  /**
   * 输血血型-Rh
   */
  bloodTransRh?: string;

  /**
   * 输血成份类型代码
   */
  bloodTransComponentCode?: string;

  /**
   * 输血成份类型
   */
  bloodTransComponent?: string;

  /**
   * 输血量(ml)
   */
  bloodTransVolume?: string;

  /**
   * 出血量(ml)
   */
  bloodLossVolume?: string;

  /**
   * 尿量(ml)
   */
  urineVolume?: string;

  /**
   * 术前主要诊断编码
   */
  presurgeryMaindiagCode1?: string;

  /**
   * 术前主要诊断名称
   */
  presurgeryMaindiagName1?: string;

  /**
   * 术前诊断编码-2
   */
  presurgeryDiagCode2?: string;

  /**
   * 术前诊断名称-2
   */
  presurgeryDiagName2?: string;

  /**
   * 术前诊断编码-3
   */
  presurgeryDiagCode3?: string;

  /**
   * 术前诊断名称-3
   */
  presurgeryDiagName3?: string;

  /**
   * 术前诊断编码-4
   */
  presurgeryDiagCode4?: string;

  /**
   * 术前诊断名称-4
   */
  presurgeryDiagName4?: string;

  /**
   * 术前诊断编码-5
   */
  presurgeryDiagCode5?: string;

  /**
   * 术前诊断名称-5
   */
  presurgeryDiagName5?: string;

  /**
   * 术中主要诊断编码
   */
  intrasurgeryMaindiagCode1?: string;

  /**
   * 术中主要诊断名称
   */
  intrasurgeryMaindiagName1?: string;

  /**
   * 术中诊断编码-2
   */
  intrasurgeryDiagCode2?: string;

  /**
   * 术中诊断名称-2
   */
  intrasurgeryDiagName2?: string;

  /**
   * 术中诊断编码-3
   */
  intrasurgeryDiagCode3?: string;

  /**
   * 术中诊断名称-3
   */
  intrasurgeryDiagName3?: string;

  /**
   * 术中诊断编码-4
   */
  intrasurgeryDiagCode4?: string;

  /**
   * 术中诊断名称-4
   */
  intrasurgeryDiagName4?: string;

  /**
   * 术中诊断编码-5
   */
  intrasurgeryDiagCode5?: string;

  /**
   * 术中诊断名称-5
   */
  intrasurgeryDiagName5?: string;

  /**
   * 术后主要诊断编码
   */
  postsurgeryMaindiagCode1?: string;

  /**
   * 术后主要诊断名称
   */
  postsurgeryMaindiagName1?: string;

  /**
   * 术后诊断编码-2
   */
  postsurgeryDiagCode2?: string;

  /**
   * 术后诊断名称-2
   */
  postsurgeryDiagName2?: string;

  /**
   * 术后诊断编码-3
   */
  postsurgeryDiagCode3?: string;

  /**
   * 术后诊断名称-3
   */
  postsurgeryDiagName3?: string;

  /**
   * 术后诊断编码-4
   */
  postsurgeryDiagCode4?: string;

  /**
   * 术后诊断名称-4
   */
  postsurgeryDiagName4?: string;

  /**
   * 术后诊断编码-5
   */
  postsurgeryDiagCode5?: string;

  /**
   * 术后诊断名称-5
   */
  postsurgeryDiagName5?: string;

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



