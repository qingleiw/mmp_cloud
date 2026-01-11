export interface NewTechnologyProjectDocumentVO {
  /**
   * 文档类型：application-申报书，approval-批复文件，progress-进展报告，final-结题报告
   */
  documentType: string;

  /**
   * 文档名称
   */
  documentName: string;

  /**
   * 文件路径
   */
  filePath: string;

  /**
   * 文件名
   */
  fileName: string;

  /**
   * 文件大小
   */
  fileSize: number;

  /**
   * 上传人
   */
  uploadBy: string;

  /**
   * 上传时间
   */
  uploadTime: string;

  /**
   * 状态
   */
  status: string;

  /**
   * 备注
   */
  remark: string;

}

export interface NewTechnologyProjectDocumentForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 项目ID
   */
  projectId?: string | number;

  /**
   * 文档类型：application-申报书，approval-批复文件，progress-进展报告，final-结题报告
   */
  documentType?: string;

  /**
   * 文档名称
   */
  documentName?: string;

  /**
   * 文件路径
   */
  filePath?: string;

  /**
   * 文件名
   */
  fileName?: string;

  /**
   * 文件大小
   */
  fileSize?: number;

  /**
   * 上传人
   */
  uploadBy?: string;

  /**
   * 上传时间
   */
  uploadTime?: string;

  /**
   * 状态
   */
  status?: string;

  /**
   * 备注
   */
  remark?: string;

}

export interface NewTechnologyProjectDocumentQuery extends PageQuery {

  /**
   * 文档类型：application-申报书，approval-批复文件，progress-进展报告，final-结题报告
   */
  documentType?: string;

  /**
   * 文档名称
   */
  documentName?: string;

  /**
   * 文件路径
   */
  filePath?: string;

  /**
   * 文件名
   */
  fileName?: string;

  /**
   * 文件大小
   */
  fileSize?: number;

  /**
   * 上传人
   */
  uploadBy?: string;

  /**
   * 上传时间
   */
  uploadTime?: string;

  /**
   * 状态
   */
  status?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
