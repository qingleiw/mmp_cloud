export interface QualificationAuthorizationRecordVO {
  /**
   * 主键ID
   */
  id: string | number;

  /**
   * 授权编号
   */
  authorizationNo: string;

  /**
   * 人员ID
   */
  staffId: string | number;

  /**
   * 人员姓名
   */
  staffName: string;

  /**
   * 人员类型 医师/医技
   */
  staffType: string;

  /**
   * 资质ID
   */
  qualificationId: string | number;

  /**
   * 资质编码
   */
  qualificationCode: string;

  /**
   * 资质名称
   */
  qualificationName: string;

  /**
   * 授权类型 首次授权/再授权/升级/降级/直接授权
   */
  authorizationType: string;

  /**
   * 授权级别
   */
  authorizationLevel: string;

  /**
   * 有效期开始
   */
  validStartDate: string | number;

  /**
   * 有效期结束
   */
  validEndDate: string | number;

  /**
   * 授权状态 有效/即将到期/已过期/已停用
   */
  authorizationStatus: string;

  /**
   * 关联申请ID
   */
  applyId: string | number;

  /**
   * 特殊限制条件
   */
  specialCondition: string;

  /**
   * 限定患者ID(紧急授权)
   */
  patientId: string | number;

  /**
   * 授权理由
   */
  authorizationReason: string;

  /**
   * 是否删除
   */
  delFlag?: string;
}

export interface QualificationAuthorizationRecordForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 授权编号
   */
  authorizationNo?: string;

  /**
   * 人员ID
   */
  staffId?: string | number;

  /**
   * 人员姓名
   */
  staffName?: string;

  /**
   * 人员类型 医师/医技
   */
  staffType?: string;

  /**
   * 资质ID
   */
  qualificationId?: string | number;

  /**
   * 资质编码
   */
  qualificationCode?: string;

  /**
   * 资质名称
   */
  qualificationName?: string;

  /**
   * 授权类型 首次授权/再授权/升级/降级/直接授权
   */
  authorizationType?: string;

  /**
   * 授权级别
   */
  authorizationLevel?: string;

  /**
   * 有效期开始
   */
  validStartDate?: string | number;

  /**
   * 有效期结束
   */
  validEndDate?: string | number;

  /**
   * 授权状态 有效/即将到期/已过期/已停用
   */
  authorizationStatus?: string;

  /**
   * 关联申请ID
   */
  applyId?: string | number;

  /**
   * 特殊限制条件
   */
  specialCondition?: string;

  /**
   * 限定患者ID(紧急授权)
   */
  patientId?: string | number;

  /**
   * 授权理由
   */
  authorizationReason?: string;

  /**
   * 是否删除
   */
  delFlag?: string;
}

export interface QualificationAuthorizationRecordQuery extends PageQuery {
  /**
   * 授权编号
   */
  authorizationNo?: string;

  /**
   * 人员ID
   */
  staffId?: string | number;

  /**
   * 人员姓名
   */
  staffName?: string;

  /**
   * 人员类型 医师/医技
   */
  staffType?: string;

  /**
   * 资质ID
   */
  qualificationId?: string | number;

  /**
   * 资质编码
   */
  qualificationCode?: string;

  /**
   * 资质名称
   */
  qualificationName?: string;

  /**
   * 授权类型 首次授权/再授权/升级/降级/直接授权
   */
  authorizationType?: string;

  /**
   * 授权级别
   */
  authorizationLevel?: string;

  /**
   * 有效期开始
   */
  validStartDate?: string | number;

  /**
   * 有效期结束
   */
  validEndDate?: string | number;

  /**
   * 授权状态 有效/即将到期/已过期/已停用
   */
  authorizationStatus?: string;

  /**
   * 关联申请ID
   */
  applyId?: string | number;

  /**
   * 特殊限制条件
   */
  specialCondition?: string;

  /**
   * 限定患者ID(紧急授权)
   */
  patientId?: string | number;

  /**
   * 授权理由
   */
  authorizationReason?: string;

  /**
   * 是否删除
   */
  delFlag?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
