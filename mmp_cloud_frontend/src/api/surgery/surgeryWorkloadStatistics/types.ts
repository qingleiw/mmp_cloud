export interface SurgeryWorkloadStatisticsVO {
  /**
   * 医师姓名
   */
  doctorName: string;

  /**
   * 手术编码
   */
  surgeryCode: string;

  /**
   * 手术名称
   */
  surgeryName: string;

  /**
   * 手术级别
   */
  surgeryLevel: string;

  /**
   * 手术数量
   */
  surgeryCount: number;

  /**
   * 主刀次数
   */
  mainOperatorCount: number;

  /**
   * 一助次数
   */
  firstAssistantCount: number;

  /**
   * 统计年份
   */
  statisticsYear: number;

  /**
   * 统计月份
   */
  statisticsMonth: number;

  /**
   * 删除标志（0代表存在 1代表删除）
   */
  delFlag: string;
}

export interface SurgeryWorkloadStatisticsForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 医师ID
   */
  doctorId?: string | number;

  /**
   * 医师姓名
   */
  doctorName?: string;

  /**
   * 手术编码
   */
  surgeryCode?: string;

  /**
   * 手术名称
   */
  surgeryName?: string;

  /**
   * 手术级别
   */
  surgeryLevel?: string;

  /**
   * 手术数量
   */
  surgeryCount?: number;

  /**
   * 主刀次数
   */
  mainOperatorCount?: number;

  /**
   * 一助次数
   */
  firstAssistantCount?: number;

  /**
   * 统计年份
   */
  statisticsYear?: number;

  /**
   * 统计月份
   */
  statisticsMonth?: number;

  /**
   * 删除标志（0代表存在 1代表删除）
   */
  delFlag?: string;
}

export interface SurgeryWorkloadStatisticsQuery extends PageQuery {
  /**
   * 医师姓名
   */
  doctorName?: string;

  /**
   * 手术编码
   */
  surgeryCode?: string;

  /**
   * 手术名称
   */
  surgeryName?: string;

  /**
   * 手术级别
   */
  surgeryLevel?: string;

  /**
   * 手术数量
   */
  surgeryCount?: number;

  /**
   * 主刀次数
   */
  mainOperatorCount?: number;

  /**
   * 一助次数
   */
  firstAssistantCount?: number;

  /**
   * 统计年份
   */
  statisticsYear?: number;

  /**
   * 统计月份
   */
  statisticsMonth?: number;

  /**
   * 删除标志（0代表存在 1代表删除）
   */
  delFlag?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
