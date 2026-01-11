export interface EmergencyPlanVO {
  /**
   * 预案编码
   */
  planCode: string;

  /**
   * 预案名称
   */
  planName: string;

  /**
   * 预案类型：fire-消防预案，medical-医疗应急预案，disaster-灾害预案，infection-感染控制预案
   */
  planType: string;

  /**
   * 状态：draft-草稿，review-审核中，approved-已批准，archived-已归档
   */
  status: string;

  /**
   * 生效日期
   */
  effectiveDate: string;

  /**
   * 审核日期
   */
  reviewDate: string;

  /**
   * 下次审核日期
   */
  nextReviewDate: string;

  /**
   * 关键词
   */
  keywords: string;

  /**
   * 文件路径
   */
  filePath: string;

  /**
   * 文件名称
   */
  fileName: string;

  /**
   * 文件大小
   */
  fileSize: number;

  /**
   * 上传者
   */
  uploadBy: string;

  /**
   * 上传时间
   */
  uploadTime: string;

  /**
   * 批准人
   */
  approveBy: string;

  /**
   * 批准时间
   */
  approveTime: string;

  /**
   * 备注
   */
  remark: string;
}

export interface EmergencyPlanForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 预案编码
   */
  planCode?: string;

  /**
   * 预案名称
   */
  planName?: string;

  /**
   * 预案类型：fire-消防预案，medical-医疗应急预案，disaster-灾害预案，infection-感染控制预案
   */
  planType?: string;

  /**
   * 状态：draft-草稿，review-审核中，approved-已批准，archived-已归档
   */
  status?: string;

  /**
   * 生效日期
   */
  effectiveDate?: string;

  /**
   * 审核日期
   */
  reviewDate?: string;

  /**
   * 下次审核日期
   */
  nextReviewDate?: string;

  /**
   * 关键词
   */
  keywords?: string;

  /**
   * 文件路径
   */
  filePath?: string;

  /**
   * 文件名称
   */
  fileName?: string;

  /**
   * 文件大小
   */
  fileSize?: number;

  /**
   * 上传者
   */
  uploadBy?: string;

  /**
   * 上传时间
   */
  uploadTime?: string;

  /**
   * 批准人
   */
  approveBy?: string;

  /**
   * 批准时间
   */
  approveTime?: string;

  /**
   * 备注
   */
  remark?: string;
}

export interface EmergencyPlanQuery extends PageQuery {
  /**
   * 预案编码
   */
  planCode?: string;

  /**
   * 预案名称
   */
  planName?: string;

  /**
   * 预案类型：fire-消防预案，medical-医疗应急预案，disaster-灾害预案，infection-感染控制预案
   */
  planType?: string;

  /**
   * 状态：draft-草稿，review-审核中，approved-已批准，archived-已归档
   */
  status?: string;

  /**
   * 生效日期
   */
  effectiveDate?: string;

  /**
   * 审核日期
   */
  reviewDate?: string;

  /**
   * 下次审核日期
   */
  nextReviewDate?: string;

  /**
   * 关键词
   */
  keywords?: string;

  /**
   * 文件路径
   */
  filePath?: string;

  /**
   * 文件名称
   */
  fileName?: string;

  /**
   * 文件大小
   */
  fileSize?: number;

  /**
   * 上传者
   */
  uploadBy?: string;

  /**
   * 上传时间
   */
  uploadTime?: string;

  /**
   * 批准人
   */
  approveBy?: string;

  /**
   * 批准时间
   */
  approveTime?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
