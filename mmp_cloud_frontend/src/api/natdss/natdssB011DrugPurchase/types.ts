export interface NatdssB011DrugPurchaseVO {
  /**
   * 系统自增主键
   */
  id: string | number;

  /**
   * 药品入库明细流水号
   */
  purSn: string;

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
  purUnitPrice: number;

  /**
   * 采购数量
   */
  purQuantity: number;

  /**
   * 采购金额
   */
  purTotalPrice: number;

  /**
   * 采购时间
   */
  purDate: string;

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

export interface NatdssB011DrugPurchaseForm extends BaseEntity {
  /**
   * 系统自增主键
   */
  id?: string | number;

  /**
   * 药品入库明细流水号
   */
  purSn?: string;

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
  purUnitPrice?: number;

  /**
   * 采购数量
   */
  purQuantity?: number;

  /**
   * 采购金额
   */
  purTotalPrice?: number;

  /**
   * 采购时间
   */
  purDate?: string;

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

export interface NatdssB011DrugPurchaseQuery extends PageQuery {

  /**
   * 药品入库明细流水号
   */
  purSn?: string;

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
  purUnitPrice?: number;

  /**
   * 采购数量
   */
  purQuantity?: number;

  /**
   * 采购金额
   */
  purTotalPrice?: number;

  /**
   * 采购时间
   */
  purDate?: string;

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



