export interface SurgeryRecordVO {
  id: string | number;
  /**
   * 患者姓名
   */
  patientName: string;

  /**
   * 主刀医生姓名
   */
  doctorName: string;

  /**
   * 手术科室名称
   */
  departmentName: string;

  /**
   * 手术编码
   */
  surgeryCode: string;

  /**
   * 手术名称
   */
  surgeryName: string;

  /**
   * 手术等级
   */
  surgeryLevel: string;

  /**
   * 手术类型
   */
  surgeryType: string;

  /**
   * 麻醉方式
   */
  anesthesiaMethod: string;

  /**
   * 手术开始时间
   */
  surgeryStartTime: string;

  /**
   * 手术结束时间
   */
  surgeryEndTime: string;

  /**
   * 手术时长(分钟)
   */
  surgeryDuration: number;

  /**
   * ASA分级
   */
  asaGrade: string;

  /**
   * 失血量(ml)
   */
  bloodLoss: number;

  /**
   * 手术状态
   */
  surgeryStatus: string;

  /**
   * 是否有并发症
   */
  complicationFlag: number;

  /**
   * 删除标志
   */
  delFlag: string;
}

export interface SurgeryRecordForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 手术记录ID（HIS系统ID）
   */
  surgeryRecordId?: string | number;

  /**
   * 手术申请ID
   */
  applicationId?: string | number;

  /**
   * 患者ID
   */
  patientId?: string | number;

  /**
   * 患者姓名
   */
  patientName?: string;

  /**
   * 主刀医生ID
   */
  doctorId?: string | number;

  /**
   * 主刀医生姓名
   */
  doctorName?: string;

  /**
   * 手术科室ID
   */
  departmentId?: string | number;

  /**
   * 手术科室名称
   */
  departmentName?: string;

  /**
   * 手术编码
   */
  surgeryCode?: string;

  /**
   * 手术名称
   */
  surgeryName?: string;

  /**
   * 手术等级
   */
  surgeryLevel?: string;

  /**
   * 手术类型
   */
  surgeryType?: string;

  /**
   * 麻醉方式
   */
  anesthesiaMethod?: string;

  /**
   * 手术开始时间
   */
  surgeryStartTime?: string;

  /**
   * 手术结束时间
   */
  surgeryEndTime?: string;

  /**
   * 手术时长(分钟)
   */
  surgeryDuration?: number;

  /**
   * ASA分级
   */
  asaGrade?: string;

  /**
   * 失血量(ml)
   */
  bloodLoss?: number;

  /**
   * 手术状态
   */
  surgeryStatus?: string;

  /**
   * 是否有并发症
   */
  complicationFlag?: number;

  /**
   * 删除标志
   */
  delFlag?: string;
}

export interface SurgeryRecordQuery extends PageQuery {
  /**
   * 患者姓名
   */
  patientName?: string;

  /**
   * 主刀医生姓名
   */
  doctorName?: string;

  /**
   * 手术科室名称
   */
  departmentName?: string;

  /**
   * 手术编码
   */
  surgeryCode?: string;

  /**
   * 手术名称
   */
  surgeryName?: string;

  /**
   * 手术等级
   */
  surgeryLevel?: string;

  /**
   * 手术类型
   */
  surgeryType?: string;

  /**
   * 麻醉方式
   */
  anesthesiaMethod?: string;

  /**
   * 手术开始时间
   */
  surgeryStartTime?: string;

  /**
   * 手术结束时间
   */
  surgeryEndTime?: string;

  /**
   * 手术时长(分钟)
   */
  surgeryDuration?: number;

  /**
   * ASA分级
   */
  asaGrade?: string;

  /**
   * 失血量(ml)
   */
  bloodLoss?: number;

  /**
   * 手术状态
   */
  surgeryStatus?: string;

  /**
   * 是否有并发症
   */
  complicationFlag?: number;

  /**
   * 删除标志
   */
  delFlag?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
