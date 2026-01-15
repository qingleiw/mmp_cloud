export interface NatdssB012DrugUseVO {
  /**
   * 系统自增主键
   */
  id: string | number;

  /**
   * 药品使用流水号
   */
  presSn: string;

  /**
   * 本院药品编码
   */
  hosDrugCode: string;

  /**
   * 药品通用名
   */
  genericName: string;

  /**
   * 药品商品名
   */
  tradeName: string;

  /**
   * 生产厂家
   */
  manufac: string;

  /**
   * 批准文号
   */
  approvalNo: string;

  /**
   * 药品剂型
   */
  form: string;

  /**
   * 药品规格
   */
  spec: string;

  /**
   * 包装数量
   */
  packingQuantity: string;

  /**
   * 包装单位
   */
  packingUnit: string;

  /**
   * 药品单价
   */
  presUnitPrice: number;

  /**
   * 使用数量
   */
  presQuantity: number;

  /**
   * 使用金额
   */
  presTotalPrice: number;

  /**
   * 来源:门诊/住院
   */
  presOrigin: string;

  /**
   * 收费时间
   */
  presDate: string;

  /**
   * 费用类型
   */
  insuranceType: string;

  /**
   * 创建时间
   */
  createdTime: string;

  /**
   * 更新时间
   */
  updatedTime: string;

}

export interface NatdssB012DrugUseForm extends BaseEntity {
  /**
   * 系统自增主键
   */
  id?: string | number;

  /**
   * 药品使用流水号
   */
  presSn?: string;

  /**
   * 本院药品编码
   */
  hosDrugCode?: string;

  /**
   * 药品通用名
   */
  genericName?: string;

  /**
   * 药品商品名
   */
  tradeName?: string;

  /**
   * 生产厂家
   */
  manufac?: string;

  /**
   * 批准文号
   */
  approvalNo?: string;

  /**
   * 药品剂型
   */
  form?: string;

  /**
   * 药品规格
   */
  spec?: string;

  /**
   * 包装数量
   */
  packingQuantity?: string;

  /**
   * 包装单位
   */
  packingUnit?: string;

  /**
   * 药品单价
   */
  presUnitPrice?: number;

  /**
   * 使用数量
   */
  presQuantity?: number;

  /**
   * 使用金额
   */
  presTotalPrice?: number;

  /**
   * 来源:门诊/住院
   */
  presOrigin?: string;

  /**
   * 收费时间
   */
  presDate?: string;

  /**
   * 费用类型
   */
  insuranceType?: string;

  /**
   * 创建时间
   */
  createdTime?: string;

  /**
   * 更新时间
   */
  updatedTime?: string;

}

export interface NatdssB012DrugUseQuery extends PageQuery {

  /**
   * 药品使用流水号
   */
  presSn?: string;

  /**
   * 本院药品编码
   */
  hosDrugCode?: string;

  /**
   * 药品通用名
   */
  genericName?: string;

  /**
   * 药品商品名
   */
  tradeName?: string;

  /**
   * 生产厂家
   */
  manufac?: string;

  /**
   * 批准文号
   */
  approvalNo?: string;

  /**
   * 药品剂型
   */
  form?: string;

  /**
   * 药品规格
   */
  spec?: string;

  /**
   * 包装数量
   */
  packingQuantity?: string;

  /**
   * 包装单位
   */
  packingUnit?: string;

  /**
   * 药品单价
   */
  presUnitPrice?: number;

  /**
   * 使用数量
   */
  presQuantity?: number;

  /**
   * 使用金额
   */
  presTotalPrice?: number;

  /**
   * 来源:门诊/住院
   */
  presOrigin?: string;

  /**
   * 收费时间
   */
  presDate?: string;

  /**
   * 费用类型
   */
  insuranceType?: string;

  /**
   * 创建时间
   */
  createdTime?: string;

  /**
   * 更新时间
   */
  updatedTime?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}



