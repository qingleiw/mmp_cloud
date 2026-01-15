export interface NewTechnologyProjectImplementationVO {
  /**
   * 项目编号
   */
  projectNo: string;

  /**
   * 实施状态 0-未开始 1-进行中 2-已完成 3-暂停
   */
  implementationStatus: number;

  /**
   * 实施医生
   */
  implementDoctor: string;

  /**
   * 实施地点
   */
  implementationLocation: string;

  /**
   * 实施日期
   */
  implementationDate: string;

  /**
   * 实施结果
   */
  implementationResult: string;

  /**
   * 备注
   */
  remark: string;

  /**
   * 是否删除
   */
  isDeleted: number;
}

export interface NewTechnologyProjectImplementationForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 项目编号
   */
  projectNo?: string;

  /**
   * 实施状态 0-未开始 1-进行中 2-已完成 3-暂停
   */
  implementationStatus?: number;

  /**
   * 实施医生
   */
  implementDoctor?: string;

  /**
   * 实施地点
   */
  implementationLocation?: string;

  /**
   * 实施日期
   */
  implementationDate?: string;

  /**
   * 实施结果
   */
  implementationResult?: string;

  /**
   * 备注
   */
  remark?: string;

  /**
   * 是否删除
   */
  isDeleted?: number;
}

export interface NewTechnologyProjectImplementationQuery extends PageQuery {
  /**
   * 项目编号
   */
  projectNo?: string;

  /**
   * 实施状态 0-未开始 1-进行中 2-已完成 3-暂停
   */
  implementationStatus?: number;

  /**
   * 实施医生
   */
  implementDoctor?: string;

  /**
   * 实施地点
   */
  implementationLocation?: string;

  /**
   * 实施日期
   */
  implementationDate?: string;

  /**
   * 实施结果
   */
  implementationResult?: string;

  /**
   * 是否删除
   */
  isDeleted?: number;

  /**
   * 日期范围参数
   */
  params?: any;
}
