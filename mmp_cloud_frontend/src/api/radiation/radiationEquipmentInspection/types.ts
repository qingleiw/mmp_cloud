export interface RadiationEquipmentInspectionVO {
  /**
   * 检测日期
   */
  inspectionDate: string;

  /**
   * 检测机构
   */
  inspectionAgency: string;

  /**
   * 检测人员
   */
  inspectorName: string;

  /**
   * 检测结果：pass-合格，fail-不合格
   */
  inspectionResult: string;

  /**
   * 检测报告
   */
  inspectionReport: string;

  /**
   * 下次检测日期
   */
  nextInspectionDate: string;

  /**
   * 备注
   */
  remark: string;
}

export interface RadiationEquipmentInspectionForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 设备ID
   */
  equipmentId?: string | number;

  /**
   * 检测日期
   */
  inspectionDate?: string;

  /**
   * 检测机构
   */
  inspectionAgency?: string;

  /**
   * 检测人员
   */
  inspectorName?: string;

  /**
   * 检测结果：pass-合格，fail-不合格
   */
  inspectionResult?: string;

  /**
   * 检测报告
   */
  inspectionReport?: string;

  /**
   * 下次检测日期
   */
  nextInspectionDate?: string;

  /**
   * 备注
   */
  remark?: string;
}

export interface RadiationEquipmentInspectionQuery extends PageQuery {
  /**
   * 检测日期
   */
  inspectionDate?: string;

  /**
   * 检测机构
   */
  inspectionAgency?: string;

  /**
   * 检测人员
   */
  inspectorName?: string;

  /**
   * 检测结果：pass-合格，fail-不合格
   */
  inspectionResult?: string;

  /**
   * 检测报告
   */
  inspectionReport?: string;

  /**
   * 下次检测日期
   */
  nextInspectionDate?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
