export interface SupervisionExpertGroupVO {
  /**
   * 专家组编码
   */
  groupCode: string;

  /**
   * 专家组名称
   */
  groupName: string;

  /**
   * 专家组类型
   */
  groupType: string;

  /**
   * 专业领域
   */
  specialty: string;

  /**
   * 描述
   */
  description: string;

  /**
   * 状态
   */
  status: string;

  /**
   * 备注
   */
  remark: string;
}

export interface SupervisionExpertGroupForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 专家组编码
   */
  groupCode?: string;

  /**
   * 专家组名称
   */
  groupName?: string;

  /**
   * 专家组类型
   */
  groupType?: string;

  /**
   * 专业领域
   */
  specialty?: string;

  /**
   * 描述
   */
  description?: string;

  /**
   * 状态
   */
  status?: string;

  /**
   * 备注
   */
  remark?: string;
}

export interface SupervisionExpertGroupQuery extends PageQuery {
  /**
   * 专家组编码
   */
  groupCode?: string;

  /**
   * 专家组名称
   */
  groupName?: string;

  /**
   * 专家组类型
   */
  groupType?: string;

  /**
   * 专业领域
   */
  specialty?: string;

  /**
   * 描述
   */
  description?: string;

  /**
   * 状态
   */
  status?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
