export interface DoctorTrainingVO {
  /**
   * 主键ID
   */
  id: string | number;

  /**
   * 医生ID
   */
  doctorId: string | number;

  /**
   * 医生姓名
   */
  doctorName: string;

  /**
   * 培训类型 进修/继续教育/院内培训
   */
  trainingType: string;

  /**
   * 培训名称
   */
  trainingName: string;

  /**
   * 培训单位
   */
  trainingUnit: string;

  /**
   * 开始日期
   */
  startDate: string;

  /**
   * 结束日期
   */
  endDate: string;

  /**
   * 培训学时
   */
  trainingHours: number;

  /**
   * 培训内容
   */
  trainingContent: string;

  /**
   * 培训结果 合格/不合格
   */
  trainingResult: string;

  /**
   * 证书编号
   */
  certificateNo: string;

  /**
   * 证书附件URL
   */
  certificateUrl: string;

  /**
   * 学分
   */
  credits: number;

  /**
   * 备注
   */
  remark: string;

  /**
   * 是否删除
   */
  delFlag?: string;
}

export interface DoctorTrainingForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 医生ID
   */
  doctorId?: string | number;

  /**
   * 培训类型 进修/继续教育/院内培训
   */
  trainingType?: string;

  /**
   * 培训名称
   */
  trainingName?: string;

  /**
   * 培训单位
   */
  trainingUnit?: string;

  /**
   * 开始日期
   */
  startDate?: string;

  /**
   * 结束日期
   */
  endDate?: string;

  /**
   * 培训学时
   */
  trainingHours?: number;

  /**
   * 培训内容
   */
  trainingContent?: string;

  /**
   * 培训结果 合格/不合格
   */
  trainingResult?: string;

  /**
   * 证书编号
   */
  certificateNo?: string;

  /**
   * 证书附件URL
   */
  certificateUrl?: string;

  /**
   * 学分
   */
  credits?: number;

  /**
   * 备注
   */
  remark?: string;

  /**
   * 是否删除
   */
  delFlag?: string;
}

export interface DoctorTrainingQuery extends PageQuery {
  /**
   * 医生ID
   */
  doctorId?: string | number;

  /**
   * 培训类型 进修/继续教育/院内培训
   */
  trainingType?: string;

  /**
   * 培训名称
   */
  trainingName?: string;

  /**
   * 培训单位
   */
  trainingUnit?: string;

  /**
   * 开始日期
   */
  startDate?: string;

  /**
   * 结束日期
   */
  endDate?: string;

  /**
   * 培训学时
   */
  trainingHours?: number;

  /**
   * 培训内容
   */
  trainingContent?: string;

  /**
   * 培训结果 合格/不合格
   */
  trainingResult?: string;

  /**
   * 证书编号
   */
  certificateNo?: string;

  /**
   * 证书附件URL
   */
  certificateUrl?: string;

  /**
   * 学分
   */
  credits?: number;

  /**
   * 是否删除
   */
  delFlag?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
