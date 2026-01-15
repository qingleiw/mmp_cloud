export interface NatdssB151OutpatientExpenseRecordVO {
  /**
   * 系统自增主键
   */
  id: string | number;

  /**
   * 患者ID
   */
  patientId: string | number;

  /**
   * 单次就诊唯一标识号
   */
  visitSn: string;

  /**
   * 就诊类型:门诊、急诊
   */
  visitType: string;

  /**
   * 就诊卡号
   */
  visitCardNo: string;

  /**
   * 门诊号
   */
  outpatientNo: string;

  /**
   * 就诊次数
   */
  visitTimes: number;

  /**
   * 收费记录明细流水号
   */
  expenseSn: string;

  /**
   * 收据号
   */
  receiptNo: string;

  /**
   * 医嘱流水号
   */
  orderSn: string;

  /**
   * 收费时间
   */
  expenseDatetime: string;

  /**
   * 交易类别代码
   */
  transactionTypeCode: string;

  /**
   * 交易类别名称
   */
  transactionTypeName: string;

  /**
   * 收费项目类型代码
   */
  itemTypeCode: string;

  /**
   * 收费项目类型名称
   */
  itemTypeName: string;

  /**
   * 收费项目代码
   */
  itemCode: string;

  /**
   * 收费项目名称
   */
  itemName: string;

  /**
   * 收费项目单位
   */
  itemUnit: string;

  /**
   * 费用明细项目单价(元)
   */
  itemUnitPrice: number;

  /**
   * 费用明细项目数量
   */
  itemAmount: number;

  /**
   * 费用明细项目金额(元)
   */
  itemTotalPrice: number;

  /**
   * 扩展字段1
   */
  extendData1: string;

  /**
   * 扩展字段2
   */
  extendData2: string;

  /**
   * 记录状态:1正常 0作废
   */
  recordStatus: number;

  /**
   * 创建时间
   */
  createdTime: string;

  /**
   * 更新时间
   */
  updatedTime: string;

}

export interface NatdssB151OutpatientExpenseRecordForm extends BaseEntity {
  /**
   * 系统自增主键
   */
  id?: string | number;

  /**
   * 患者ID
   */
  patientId?: string | number;

  /**
   * 单次就诊唯一标识号
   */
  visitSn?: string;

  /**
   * 就诊类型:门诊、急诊
   */
  visitType?: string;

  /**
   * 就诊卡号
   */
  visitCardNo?: string;

  /**
   * 门诊号
   */
  outpatientNo?: string;

  /**
   * 就诊次数
   */
  visitTimes?: number;

  /**
   * 收费记录明细流水号
   */
  expenseSn?: string;

  /**
   * 收据号
   */
  receiptNo?: string;

  /**
   * 医嘱流水号
   */
  orderSn?: string;

  /**
   * 收费时间
   */
  expenseDatetime?: string;

  /**
   * 交易类别代码
   */
  transactionTypeCode?: string;

  /**
   * 交易类别名称
   */
  transactionTypeName?: string;

  /**
   * 收费项目类型代码
   */
  itemTypeCode?: string;

  /**
   * 收费项目类型名称
   */
  itemTypeName?: string;

  /**
   * 收费项目代码
   */
  itemCode?: string;

  /**
   * 收费项目名称
   */
  itemName?: string;

  /**
   * 收费项目单位
   */
  itemUnit?: string;

  /**
   * 费用明细项目单价(元)
   */
  itemUnitPrice?: number;

  /**
   * 费用明细项目数量
   */
  itemAmount?: number;

  /**
   * 费用明细项目金额(元)
   */
  itemTotalPrice?: number;

  /**
   * 扩展字段1
   */
  extendData1?: string;

  /**
   * 扩展字段2
   */
  extendData2?: string;

  /**
   * 记录状态:1正常 0作废
   */
  recordStatus?: number;

  /**
   * 创建时间
   */
  createdTime?: string;

  /**
   * 更新时间
   */
  updatedTime?: string;

}

export interface NatdssB151OutpatientExpenseRecordQuery extends PageQuery {

  /**
   * 患者ID
   */
  patientId?: string | number;

  /**
   * 单次就诊唯一标识号
   */
  visitSn?: string;

  /**
   * 就诊类型:门诊、急诊
   */
  visitType?: string;

  /**
   * 就诊卡号
   */
  visitCardNo?: string;

  /**
   * 门诊号
   */
  outpatientNo?: string;

  /**
   * 就诊次数
   */
  visitTimes?: number;

  /**
   * 收费记录明细流水号
   */
  expenseSn?: string;

  /**
   * 收据号
   */
  receiptNo?: string;

  /**
   * 医嘱流水号
   */
  orderSn?: string;

  /**
   * 收费时间
   */
  expenseDatetime?: string;

  /**
   * 交易类别代码
   */
  transactionTypeCode?: string;

  /**
   * 交易类别名称
   */
  transactionTypeName?: string;

  /**
   * 收费项目类型代码
   */
  itemTypeCode?: string;

  /**
   * 收费项目类型名称
   */
  itemTypeName?: string;

  /**
   * 收费项目代码
   */
  itemCode?: string;

  /**
   * 收费项目名称
   */
  itemName?: string;

  /**
   * 收费项目单位
   */
  itemUnit?: string;

  /**
   * 费用明细项目单价(元)
   */
  itemUnitPrice?: number;

  /**
   * 费用明细项目数量
   */
  itemAmount?: number;

  /**
   * 费用明细项目金额(元)
   */
  itemTotalPrice?: number;

  /**
   * 扩展字段1
   */
  extendData1?: string;

  /**
   * 扩展字段2
   */
  extendData2?: string;

  /**
   * 记录状态:1正常 0作废
   */
  recordStatus?: number;

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



