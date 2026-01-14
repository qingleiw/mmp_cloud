export interface MedicalStatsVO {
  /**
   * 主键ID
   */
  id: string | number;

  /**
   * 科室ID
   */
  deptId: string | number;

  /**
   * 科室名称
   */
  deptName: string;

  /**
   * 统计日期
   */
  statDate: string;

  /**
   * 新入院患者数
   */
  newAdmissions: number;

  /**
   * 在院患者数
   */
  inWard: number;

  /**
   * 危重患者数
   */
  critical: number;

  /**
   * 出院患者数
   */
  discharged: number;

  /**
   * 死亡患者数
   */
  deaths: number;

  /**
   * 转入患者数
   */
  transfersIn: number;

  /**
   * 转出患者数
   */
  transfersOut: number;

  /**
   * 关注患者数
   */
  attentionPatients: number;

  /**
   * 抢救次数
   */
  rescues: number;

  /**
   * 危急值次数
   */
  criticalValues: number;

  /**
   * 病危患者数
   */
  criticallyIll: number;

  /**
   * 病重患者数
   */
  seriouslyIll: number;

  /**
   * 会诊次数
   */
  consultations: number;

  /**
   * 住院超30天患者数
   */
  longStayPatients: number;

  /**
   * 三级手术次数
   */
  level3Surgeries: number;

  /**
   * 四级手术次数
   */
  level4Surgeries: number;

  /**
   * 二次手术次数
   */
  secondarySurgeries: number;

  /**
   * 输血次数
   */
  bloodTransfusions: number;

  /**
   * 入径患者数
   */
  pathwayEntries: number;

  /**
   * 抗菌药物使用次数
   */
  antibioticUsage: number;

  /**
   * 创建时间
   */
  createTime?: string;

  /**
   * 更新时间
   */
  updateTime?: string;

  /**
   * 创建者
   */
  createBy?: string;

  /**
   * 更新者
   */
  updateBy?: string;

  /**
   * 备注
   */
  remark?: string;
}

export interface MedicalStatsForm {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 科室ID
   */
  deptId: string | number;

  /**
   * 科室名称
   */
  deptName: string;

  /**
   * 统计日期
   */
  statDate: string;

  /**
   * 新入院患者数
   */
  newAdmissions: number;

  /**
   * 在院患者数
   */
  inWard: number;

  /**
   * 危重患者数
   */
  critical: number;

  /**
   * 出院患者数
   */
  discharged: number;

  /**
   * 死亡患者数
   */
  deaths: number;

  /**
   * 转入患者数
   */
  transfersIn: number;

  /**
   * 转出患者数
   */
  transfersOut: number;

  /**
   * 关注患者数
   */
  attentionPatients: number;

  /**
   * 抢救次数
   */
  rescues: number;

  /**
   * 危急值次数
   */
  criticalValues: number;

  /**
   * 病危患者数
   */
  criticallyIll: number;

  /**
   * 病重患者数
   */
  seriouslyIll: number;

  /**
   * 会诊次数
   */
  consultations: number;

  /**
   * 住院超30天患者数
   */
  longStayPatients: number;

  /**
   * 三级手术次数
   */
  level3Surgeries: number;

  /**
   * 四级手术次数
   */
  level4Surgeries: number;

  /**
   * 二次手术次数
   */
  secondarySurgeries: number;

  /**
   * 输血次数
   */
  bloodTransfusions: number;

  /**
   * 入径患者数
   */
  pathwayEntries: number;

  /**
   * 抗菌药物使用次数
   */
  antibioticUsage: number;

  /**
   * 备注
   */
  remark?: string;
}

export interface MedicalStatsQuery {
  /**
   * 科室ID
   */
  deptId?: string | number;

  /**
   * 统计日期
   */
  statDate?: string;

  /**
   * 日期范围
   */
  dateRange?: string[];

  /**
   * 当前页码
   */
  pageNum?: number;

  /**
   * 每页大小
   */
  pageSize?: number;
}
