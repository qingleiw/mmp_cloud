export interface RadiationHealthExamResultVO {
  /**
   * 工作人员姓名
   */
  staffName: string;

  /**
   * 体检日期
   */
  examDate: string;

  /**
   * 体检结果：normal-正常，abnormal-异常
   */
  examResult: string;

  /**
   * 体检报告文件路径
   */
  examReportFile: string;

  /**
   * 体检报告文件名
   */
  examReportName: string;

  /**
   * 主要发现
   */
  keyFindings: string;

  /**
   * 建议措施
   */
  recommendations: string;

  /**
   * 是否需要随访：0-否，1-是
   */
  followUpRequired: string;

  /**
   * 随访日期
   */
  followUpDate: string;

  /**
   * 备注
   */
  remark: string;
}

export interface RadiationHealthExamResultForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 体检计划ID
   */
  planId?: string | number;

  /**
   * 工作人员ID
   */
  staffId?: string | number;

  /**
   * 工作人员姓名
   */
  staffName?: string;

  /**
   * 体检日期
   */
  examDate?: string;

  /**
   * 体检结果：normal-正常，abnormal-异常
   */
  examResult?: string;

  /**
   * 体检报告文件路径
   */
  examReportFile?: string;

  /**
   * 体检报告文件名
   */
  examReportName?: string;

  /**
   * 主要发现
   */
  keyFindings?: string;

  /**
   * 建议措施
   */
  recommendations?: string;

  /**
   * 是否需要随访：0-否，1-是
   */
  followUpRequired?: string;

  /**
   * 随访日期
   */
  followUpDate?: string;

  /**
   * 备注
   */
  remark?: string;
}

export interface RadiationHealthExamResultQuery extends PageQuery {
  /**
   * 工作人员姓名
   */
  staffName?: string;

  /**
   * 体检日期
   */
  examDate?: string;

  /**
   * 体检结果：normal-正常，abnormal-异常
   */
  examResult?: string;

  /**
   * 体检报告文件路径
   */
  examReportFile?: string;

  /**
   * 体检报告文件名
   */
  examReportName?: string;

  /**
   * 主要发现
   */
  keyFindings?: string;

  /**
   * 建议措施
   */
  recommendations?: string;

  /**
   * 是否需要随访：0-否，1-是
   */
  followUpRequired?: string;

  /**
   * 随访日期
   */
  followUpDate?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
