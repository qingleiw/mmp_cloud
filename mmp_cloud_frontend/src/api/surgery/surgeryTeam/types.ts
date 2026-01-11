export interface SurgeryTeamVO extends BaseEntity {
  /**
   * 主键ID
   */
  id: string | number;

  /**
   * 医生姓名
   */
  doctorName: string;

  /**
   * 角色类型 主刀/一助/二助/巡回护士/器械护士/麻醉师
   */
  roleType: string;

  /**
   * 资格验证 1-已验证 0-未验证
   */
  qualificationVerify: number;

  /**
   * 删除标志
   */
  delFlag: string;
}

export interface SurgeryTeamForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 手术记录ID
   */
  surgeryRecordId?: string | number;

  /**
   * 医生ID
   */
  doctorId?: string | number;

  /**
   * 医生姓名
   */
  doctorName?: string;

  /**
   * 角色类型 主刀/一助/二助/巡回护士/器械护士/麻醉师
   */
  roleType?: string;

  /**
   * 资格验证 1-已验证 0-未验证
   */
  qualificationVerify?: number;

  /**
   * 删除标志
   */
  delFlag?: string;
}

export interface SurgeryTeamQuery extends PageQuery {
  /**
   * 医生姓名
   */
  doctorName?: string;

  /**
   * 角色类型 主刀/一助/二助/巡回护士/器械护士/麻醉师
   */
  roleType?: string;

  /**
   * 资格验证 1-已验证 0-未验证
   */
  qualificationVerify?: number;

  /**
   * 删除标志
   */
  delFlag?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
