export interface QualificationAdmissionConditionVO {
  /**
   * 主键ID
   */
  id: string | number;

  /**
   * 资质ID
   */
  qualificationId: string | number;

  /**
   * 资质类型 医师/医技
   */
  qualificationType: string;

  /**
   * 条件类型 学历/职称/工作年限/专业/培训/考核/证书
   */
  conditionType: string;

  /**
   * 条件运算符 =/>/</>=/<=/in
   */
  conditionOperator: string;

  /**
   * 条件值
   */
  conditionValue: string;

  /**
   * 条件单位
   */
  conditionUnit: string;

  /**
   * 是否必须 1-是 0-否
   */
  isRequired: number;

  /**
   * 逻辑关系 AND/OR
   */
  logicRelation: string;

  /**
   * 排序
   */
  sortOrder: number;

  /**
   * 备注
   */
  remark: string;

  /**
   * 是否删除
   */
  delFlag?: string;
}

export interface QualificationAdmissionConditionForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 资质ID
   */
  qualificationId?: string | number;

  /**
   * 资质类型 医师/医技
   */
  qualificationType?: string;

  /**
   * 条件类型 学历/职称/工作年限/专业/培训/考核/证书
   */
  conditionType?: string;

  /**
   * 条件运算符 =/>/</>=/<=/in
   */
  conditionOperator?: string;

  /**
   * 条件值
   */
  conditionValue?: string;

  /**
   * 条件单位
   */
  conditionUnit?: string;

  /**
   * 是否必须 1-是 0-否
   */
  isRequired?: number;

  /**
   * 逻辑关系 AND/OR
   */
  logicRelation?: string;

  /**
   * 排序
   */
  sortOrder?: number;

  /**
   * 备注
   */
  remark?: string;

  /**
   * 是否删除
   */
  delFlag?: string;
}

export interface QualificationAdmissionConditionQuery extends PageQuery {
  /**
   * 资质ID
   */
  qualificationId?: string | number;

  /**
   * 资质类型 医师/医技
   */
  qualificationType?: string;

  /**
   * 条件类型 学历/职称/工作年限/专业/培训/考核/证书
   */
  conditionType?: string;

  /**
   * 条件运算符 =/>/</>=/<=/in
   */
  conditionOperator?: string;

  /**
   * 条件值
   */
  conditionValue?: string;

  /**
   * 条件单位
   */
  conditionUnit?: string;

  /**
   * 是否必须 1-是 0-否
   */
  isRequired?: number;

  /**
   * 逻辑关系 AND/OR
   */
  logicRelation?: string;

  /**
   * 排序
   */
  sortOrder?: number;

  /**
   * 是否删除
   */
  delFlag?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
