export interface EmergencyMedicalSupportVO {
  /**
   * 资源编码
   */
  resourceCode: string;

  /**
   * 资源名称
   */
  resourceName: string;

  /**
   * 资源类型
   */
  resourceType: string;

  /**
   * 所属部门
   */
  department: string;

  /**
   * 存放地点
   */
  location: string;

  /**
   * 数量
   */
  quantity: number;

  /**
   * 单位
   */
  unit: string;

  /**
   * 联系人
   */
  contactPerson: string;

  /**
   * 联系方式
   */
  contactInfo: string;

  /**
   * 状态
   */
  status: string;

  /**
   * 备注
   */
  remark: string;
}

export interface EmergencyMedicalSupportForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 资源编码
   */
  resourceCode?: string;

  /**
   * 资源名称
   */
  resourceName?: string;

  /**
   * 资源类型
   */
  resourceType?: string;

  /**
   * 所属部门
   */
  department?: string;

  /**
   * 存放地点
   */
  location?: string;

  /**
   * 数量
   */
  quantity?: number;

  /**
   * 单位
   */
  unit?: string;

  /**
   * 联系人
   */
  contactPerson?: string;

  /**
   * 联系方式
   */
  contactInfo?: string;

  /**
   * 状态
   */
  status?: string;

  /**
   * 备注
   */
  remark?: string;
}

export interface EmergencyMedicalSupportQuery extends PageQuery {
  /**
   * 资源编码
   */
  resourceCode?: string;

  /**
   * 资源名称
   */
  resourceName?: string;

  /**
   * 资源类型
   */
  resourceType?: string;

  /**
   * 所属部门
   */
  department?: string;

  /**
   * 存放地点
   */
  location?: string;

  /**
   * 数量
   */
  quantity?: number;

  /**
   * 单位
   */
  unit?: string;

  /**
   * 联系人
   */
  contactPerson?: string;

  /**
   * 联系方式
   */
  contactInfo?: string;

  /**
   * 状态
   */
  status?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
