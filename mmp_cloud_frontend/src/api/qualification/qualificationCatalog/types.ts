export interface QualificationCatalogVO {
  id: string | number;
  /**
   * 医生姓名
   */
  doctorName: string;

  /**
   * 科室
   */
  department: string;

  /**
   * 职务
   */
  position: string;

  /**
   * 职称
   */
  title: string;

  /**
   * 所授权手术级别
   */
  authorizedLevel: string;

  /**
   * 一级手术授权（1=通过，0=未通过）
   */
  level1: number;

  /**
   * 二级手术授权（1=通过，0=未通过）
   */
  level2: number;

  /**
   * 三级手术授权（1=通过，0=未通过）
   */
  level3: number;

  /**
   * 四级手术授权（1=通过，0=未通过）
   */
  level4: number;

  /**
   * 手术名称
   */
  surgeryName: string;

  /**
   * 手术代码
   */
  surgeryCode: string;

  /**
   * 手术级别（三级/四级）
   */
  surgeryLevel: string;

  /**
   * 资质类型
   */
  qualificationType: string;

  /**
   * 有效期开始
   */
  validStartDate: string | number;

  /**
   * 有效期结束
   */
  validEndDate: string | number;

  /**
   * 状态
   */
  status: string;

  /**
   * 数据来源
   */
  dataSource: string;

  /**
   * 是否删除
   */
  delFlag?: string;
}

export interface QualificationCatalogForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 医生ID
   */
  doctorId?: string | number;

  /**
   * 医生姓名
   */
  doctorName?: string;

  /**
   * 科室
   */
  department?: string;

  /**
   * 职务
   */
  position?: string;

  /**
   * 职称
   */
  title?: string;

  /**
   * 所授权手术级别
   */
  authorizedLevel?: string;

  /**
   * 一级手术授权（1=通过，0=未通过）
   */
  level1?: number;

  /**
   * 二级手术授权（1=通过，0=未通过）
   */
  level2?: number;

  /**
   * 三级手术授权（1=通过，0=未通过）
   */
  level3?: number;

  /**
   * 四级手术授权（1=通过，0=未通过）
   */
  level4?: number;

  /**
   * 手术名称
   */
  surgeryName?: string;

  /**
   * 手术代码
   */
  surgeryCode?: string;

  /**
   * 手术级别（三级/四级）
   */
  surgeryLevel?: string;

  /**
   * 资质类型
   */
  qualificationType?: string;

  /**
   * 有效期开始
   */
  validStartDate?: string | number;

  /**
   * 有效期结束
   */
  validEndDate?: string | number;

  /**
   * 状态
   */
  status?: string;

  /**
   * 数据来源
   */
  dataSource?: string;

  /**
   * 是否删除
   */
  delFlag?: string;
}

export interface QualificationCatalogQuery extends PageQuery {
  /**
   * 医生姓名
   */
  doctorName?: string;

  /**
   * 科室
   */
  department?: string;

  /**
   * 职务
   */
  position?: string;

  /**
   * 职称
   */
  title?: string;

  /**
   * 所授权手术级别
   */
  authorizedLevel?: string;

  /**
   * 一级手术授权（1=通过，0=未通过）
   */
  level1?: number;

  /**
   * 二级手术授权（1=通过，0=未通过）
   */
  level2?: number;

  /**
   * 三级手术授权（1=通过，0=未通过）
   */
  level3?: number;

  /**
   * 四级手术授权（1=通过，0=未通过）
   */
  level4?: number;

  /**
   * 手术名称
   */
  surgeryName?: string;

  /**
   * 手术代码
   */
  surgeryCode?: string;

  /**
   * 手术级别（三级/四级）
   */
  surgeryLevel?: string;

  /**
   * 资质类型
   */
  qualificationType?: string;

  /**
   * 有效期开始
   */
  validStartDate?: string | number;

  /**
   * 有效期结束
   */
  validEndDate?: string | number;

  /**
   * 状态
   */
  status?: string;

  /**
   * 数据来源
   */
  dataSource?: string;

  /**
   * 是否删除
   */
  delFlag?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
