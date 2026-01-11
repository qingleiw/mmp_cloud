export interface SupervisionResultDetailVO {
  /**
   * 得分
   */
  score: number;

  /**
   * 备注
   */
  remarks: string;

  /**
   * 备注
   */
  remark: string;
}

export interface SupervisionResultDetailForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 结果ID
   */
  resultId?: string | number;

  /**
   * 指标ID
   */
  indicatorId?: string | number;

  /**
   * 得分
   */
  score?: number;

  /**
   * 备注
   */
  remarks?: string;

  /**
   * 备注
   */
  remark?: string;
}

export interface SupervisionResultDetailQuery extends PageQuery {
  /**
   * 得分
   */
  score?: number;

  /**
   * 备注
   */
  remarks?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
