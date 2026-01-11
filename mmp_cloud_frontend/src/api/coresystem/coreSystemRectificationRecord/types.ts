export interface CoreSystemRectificationRecordVO extends BaseEntity {
  /**
   * 主键ID
   */
  id: string | number;

  /**
   * 整改ID
   */
  rectificationId: string;

  /**
   * 制度ID
   */
  systemId: string | number;

  /**
   * 制度名称
   */
  systemName: string;

  /**
   * 整改人ID
   */
  rectifierId: string | number;

  /**
   * 整改人名称
   */
  rectifierName: string;

  /**
   * 整改状态(0:进行中,1:已完成,2:已验收)
   */
  rectificationStatus: string;

  /**
   * 开始时间
   */
  rectificationStartTime: string;

  /**
   * 完成时间
   */
  rectificationEndTime: string;

  /**
   * 整改内容
   */
  rectificationContent: string;

  /**
   * 整改措施
   */
  rectificationMeasures: string;

  /**
   * 验收结果(1:合格,0:不合格)
   */
  acceptanceResult: string;

  /**
   * 验收意见
   */
  acceptanceOpinion: string;

  /**
   * 删除标志(0:未删除,1:已删除)
   */
  delFlag: string;
}

export interface CoreSystemRectificationRecordForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 整改ID
   */
  rectificationId?: string | number;

  /**
   * 制度ID
   */
  systemId?: string | number;

  /**
   * 制度名称
   */
  systemName?: string;

  /**
   * 整改人ID
   */
  rectifierId?: string | number;

  /**
   * 整改人名称
   */
  rectifierName?: string;

  /**
   * 整改状态(0:进行中,1:已完成,2:已验收)
   */
  rectificationStatus?: string;

  /**
   * 开始时间
   */
  rectificationStartTime?: string;

  /**
   * 完成时间
   */
  rectificationEndTime?: string;

  /**
   * 整改内容
   */
  rectificationContent?: string;

  /**
   * 整改措施
   */
  rectificationMeasures?: string;

  /**
   * 验收结果(1:合格,0:不合格)
   */
  acceptanceResult?: string;

  /**
   * 验收意见
   */
  acceptanceOpinion?: string;

  /**
   * 删除标志(0:未删除,1:已删除)
   */
  delFlag?: string;
}

export interface CoreSystemRectificationRecordQuery extends PageQuery {
  /**
   * 制度名称
   */
  systemName?: string;

  /**
   * 整改人名称
   */
  rectifierName?: string;

  /**
   * 整改状态(0:进行中,1:已完成,2:已验收)
   */
  rectificationStatus?: string;

  /**
   * 开始时间
   */
  rectificationStartTime?: string;

  /**
   * 完成时间
   */
  rectificationEndTime?: string;

  /**
   * 整改内容
   */
  rectificationContent?: string;

  /**
   * 整改措施
   */
  rectificationMeasures?: string;

  /**
   * 验收结果(1:合格,0:不合格)
   */
  acceptanceResult?: string;

  /**
   * 验收意见
   */
  acceptanceOpinion?: string;

  /**
   * 删除标志(0:未删除,1:已删除)
   */
  delFlag?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
