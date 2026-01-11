export interface SurgeryVideoVO {
  /**
   * 主键ID
   */
  id: string | number;

  /**
   * 视频编号
   */
  videoNo: string | number;

  /**
   * 视频标题
   */
  videoTitle: string | number;

  /**
   * 视频类型 手术全程/关键步骤/教学片段
   */
  videoType: string | number;

  /**
   * 视频URL
   */
  videoUrl: string | number;

  /**
   * 视频时长(秒)
   */
  videoDuration: string | number;

  /**
   * 视频大小(字节)
   */
  videoSize: string | number;

  /**
   * 视频格式
   */
  videoFormat: string | number;

  /**
   * 录制设备
   */
  recordingDevice: string;

  /**
   * 录制医生姓名
   */
  recordingDoctorName: string;

  /**
   * 上传时间
   */
  uploadTime: string;

  /**
   * 审核状态 pending-待审核 approved-已通过 rejected-已拒绝
   */
  reviewStatus: string;

  /**
   * 审核时间
   */
  reviewTime: string;

  /**
   * 审核意见
   */
  reviewComment: string;

  /**
   * 访问级别 internal-院内 public-公开 restricted-受限
   */
  accessLevel: string;

  /**
   * 删除标志
   */
  delFlag: string;
}

export interface SurgeryVideoForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 手术记录ID
   */
  surgeryRecordId?: string | number;

  /**
   * 视频编号
   */
  videoNo?: string | number;

  /**
   * 视频标题
   */
  videoTitle?: string | number;

  /**
   * 视频类型 手术全程/关键步骤/教学片段
   */
  videoType?: string | number;

  /**
   * 视频URL
   */
  videoUrl?: string | number;

  /**
   * 视频时长(秒)
   */
  videoDuration?: string | number;

  /**
   * 视频大小(字节)
   */
  videoSize?: string | number;

  /**
   * 视频格式
   */
  videoFormat?: string | number;

  /**
   * 录制设备
   */
  recordingDevice?: string;

  /**
   * 录制医生ID
   */
  recordingDoctorId?: string | number;

  /**
   * 录制医生姓名
   */
  recordingDoctorName?: string;

  /**
   * 上传时间
   */
  uploadTime?: string;

  /**
   * 审核状态 pending-待审核 approved-已通过 rejected-已拒绝
   */
  reviewStatus?: string;

  /**
   * 审核人ID
   */
  reviewerId?: string | number;

  /**
   * 审核时间
   */
  reviewTime?: string;

  /**
   * 审核意见
   */
  reviewComment?: string;

  /**
   * 访问级别 internal-院内 public-公开 restricted-受限
   */
  accessLevel?: string;

  /**
   * 删除标志
   */
  delFlag?: string;
}

export interface SurgeryVideoQuery extends PageQuery {
  /**
   * 视频编号
   */
  videoNo?: string | number;

  /**
   * 视频标题
   */
  videoTitle?: string | number;

  /**
   * 视频类型 手术全程/关键步骤/教学片段
   */
  videoType?: string | number;

  /**
   * 视频URL
   */
  videoUrl?: string | number;

  /**
   * 视频时长(秒)
   */
  videoDuration?: string | number;

  /**
   * 视频大小(字节)
   */
  videoSize?: string | number;

  /**
   * 视频格式
   */
  videoFormat?: string | number;

  /**
   * 录制设备
   */
  recordingDevice?: string;

  /**
   * 录制医生姓名
   */
  recordingDoctorName?: string;

  /**
   * 上传时间
   */
  uploadTime?: string;

  /**
   * 审核状态 pending-待审核 approved-已通过 rejected-已拒绝
   */
  reviewStatus?: string;

  /**
   * 审核时间
   */
  reviewTime?: string;

  /**
   * 审核意见
   */
  reviewComment?: string;

  /**
   * 访问级别 internal-院内 public-公开 restricted-受限
   */
  accessLevel?: string;

  /**
   * 删除标志
   */
  delFlag?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
