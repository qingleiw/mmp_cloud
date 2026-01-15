export interface NatdssB141OutpatientOrderAndPresVO {
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
   * 医嘱流水号
   */
  orderSn: string;

  /**
   * 医技申请单号
   */
  requestNo: string;

  /**
   * 医嘱开具时间
   */
  orderGivenTime: string;

  /**
   * 就诊科室代码
   */
  visitDeptCode: string;

  /**
   * 就诊科室名称
   */
  visitDeptName: string;

  /**
   * 医嘱下达科室代码
   */
  orderDeptCode: string;

  /**
   * 医嘱下达科室名称
   */
  orderDeptName: string;

  /**
   * 医嘱开单医生代码
   */
  orderDoctorNo: string;

  /**
   * 职称名称
   */
  technicalTitle: string;

  /**
   * 职务名称
   */
  jobTitle: string;

  /**
   * 医嘱执行科室代码
   */
  executiveDeptCode: string;

  /**
   * 医嘱执行科室名称
   */
  executiveDeptName: string;

  /**
   * 处方分类代码
   */
  prescriptionClassCode: string;

  /**
   * 处方分类名称
   */
  prescriptionClassName: string;

  /**
   * 医嘱分类代码
   */
  orderClassCode: string;

  /**
   * 医嘱分类名称
   */
  orderClassName: string;

  /**
   * 医嘱项目代码
   */
  orderItemCode: string;

  /**
   * 医嘱项目名称
   */
  orderItemName: string;

  /**
   * 医嘱组号
   */
  orderGroupNo: string;

  /**
   * 单次剂量
   */
  dose: number;

  /**
   * 剂量单位
   */
  doseUnit: string;

  /**
   * 药品剂型
   */
  form: string;

  /**
   * 规格
   */
  spec: string;

  /**
   * 使用频率代码
   */
  frequencyCode: string;

  /**
   * 使用频率
   */
  frequency: string;

  /**
   * 给药途径
   */
  administrationRoute: string;

  /**
   * 液体配置
   */
  liquidConfiguration: string | number;

  /**
   * 注射方式
   */
  injectionType: string;

  /**
   * 用药顺序
   */
  drugOrder: string;

  /**
   * 用药配伍
   */
  drugCompatibility: string;

  /**
   * 输液时长
   */
  infusionDuration: string;

  /**
   * 使用天数
   */
  daysOfMedication: number;

  /**
   * 药品使用总剂量
   */
  totalDose: number;

  /**
   * 总量单位
   */
  totalDoseUnit: string;

  /**
   * 医嘱数量
   */
  numOfOrders: string;

  /**
   * 医嘱数量单位
   */
  numOfOrdersUnit: string;

  /**
   * 医嘱备注
   */
  orderNote: string;

  /**
   * 草药备注
   */
  herbalNote: string;

  /**
   * 是否药品
   */
  drugFlag: string;

  /**
   * 生产厂家
   */
  manufac: string;

  /**
   * 药品商品名
   */
  tradeName: string;

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

export interface NatdssB141OutpatientOrderAndPresForm extends BaseEntity {
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
   * 医嘱流水号
   */
  orderSn?: string;

  /**
   * 医技申请单号
   */
  requestNo?: string;

  /**
   * 医嘱开具时间
   */
  orderGivenTime?: string;

  /**
   * 就诊科室代码
   */
  visitDeptCode?: string;

  /**
   * 就诊科室名称
   */
  visitDeptName?: string;

  /**
   * 医嘱下达科室代码
   */
  orderDeptCode?: string;

  /**
   * 医嘱下达科室名称
   */
  orderDeptName?: string;

  /**
   * 医嘱开单医生代码
   */
  orderDoctorNo?: string;

  /**
   * 职称名称
   */
  technicalTitle?: string;

  /**
   * 职务名称
   */
  jobTitle?: string;

  /**
   * 医嘱执行科室代码
   */
  executiveDeptCode?: string;

  /**
   * 医嘱执行科室名称
   */
  executiveDeptName?: string;

  /**
   * 处方分类代码
   */
  prescriptionClassCode?: string;

  /**
   * 处方分类名称
   */
  prescriptionClassName?: string;

  /**
   * 医嘱分类代码
   */
  orderClassCode?: string;

  /**
   * 医嘱分类名称
   */
  orderClassName?: string;

  /**
   * 医嘱项目代码
   */
  orderItemCode?: string;

  /**
   * 医嘱项目名称
   */
  orderItemName?: string;

  /**
   * 医嘱组号
   */
  orderGroupNo?: string;

  /**
   * 单次剂量
   */
  dose?: number;

  /**
   * 剂量单位
   */
  doseUnit?: string;

  /**
   * 药品剂型
   */
  form?: string;

  /**
   * 规格
   */
  spec?: string;

  /**
   * 使用频率代码
   */
  frequencyCode?: string;

  /**
   * 使用频率
   */
  frequency?: string;

  /**
   * 给药途径
   */
  administrationRoute?: string;

  /**
   * 液体配置
   */
  liquidConfiguration?: string | number;

  /**
   * 注射方式
   */
  injectionType?: string;

  /**
   * 用药顺序
   */
  drugOrder?: string;

  /**
   * 用药配伍
   */
  drugCompatibility?: string;

  /**
   * 输液时长
   */
  infusionDuration?: string;

  /**
   * 使用天数
   */
  daysOfMedication?: number;

  /**
   * 药品使用总剂量
   */
  totalDose?: number;

  /**
   * 总量单位
   */
  totalDoseUnit?: string;

  /**
   * 医嘱数量
   */
  numOfOrders?: string;

  /**
   * 医嘱数量单位
   */
  numOfOrdersUnit?: string;

  /**
   * 医嘱备注
   */
  orderNote?: string;

  /**
   * 草药备注
   */
  herbalNote?: string;

  /**
   * 是否药品
   */
  drugFlag?: string;

  /**
   * 生产厂家
   */
  manufac?: string;

  /**
   * 药品商品名
   */
  tradeName?: string;

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

export interface NatdssB141OutpatientOrderAndPresQuery extends PageQuery {

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
   * 医嘱流水号
   */
  orderSn?: string;

  /**
   * 医技申请单号
   */
  requestNo?: string;

  /**
   * 医嘱开具时间
   */
  orderGivenTime?: string;

  /**
   * 就诊科室代码
   */
  visitDeptCode?: string;

  /**
   * 就诊科室名称
   */
  visitDeptName?: string;

  /**
   * 医嘱下达科室代码
   */
  orderDeptCode?: string;

  /**
   * 医嘱下达科室名称
   */
  orderDeptName?: string;

  /**
   * 医嘱开单医生代码
   */
  orderDoctorNo?: string;

  /**
   * 职称名称
   */
  technicalTitle?: string;

  /**
   * 职务名称
   */
  jobTitle?: string;

  /**
   * 医嘱执行科室代码
   */
  executiveDeptCode?: string;

  /**
   * 医嘱执行科室名称
   */
  executiveDeptName?: string;

  /**
   * 处方分类代码
   */
  prescriptionClassCode?: string;

  /**
   * 处方分类名称
   */
  prescriptionClassName?: string;

  /**
   * 医嘱分类代码
   */
  orderClassCode?: string;

  /**
   * 医嘱分类名称
   */
  orderClassName?: string;

  /**
   * 医嘱项目代码
   */
  orderItemCode?: string;

  /**
   * 医嘱项目名称
   */
  orderItemName?: string;

  /**
   * 医嘱组号
   */
  orderGroupNo?: string;

  /**
   * 单次剂量
   */
  dose?: number;

  /**
   * 剂量单位
   */
  doseUnit?: string;

  /**
   * 药品剂型
   */
  form?: string;

  /**
   * 规格
   */
  spec?: string;

  /**
   * 使用频率代码
   */
  frequencyCode?: string;

  /**
   * 使用频率
   */
  frequency?: string;

  /**
   * 给药途径
   */
  administrationRoute?: string;

  /**
   * 液体配置
   */
  liquidConfiguration?: string | number;

  /**
   * 注射方式
   */
  injectionType?: string;

  /**
   * 用药顺序
   */
  drugOrder?: string;

  /**
   * 用药配伍
   */
  drugCompatibility?: string;

  /**
   * 输液时长
   */
  infusionDuration?: string;

  /**
   * 使用天数
   */
  daysOfMedication?: number;

  /**
   * 药品使用总剂量
   */
  totalDose?: number;

  /**
   * 总量单位
   */
  totalDoseUnit?: string;

  /**
   * 医嘱数量
   */
  numOfOrders?: string;

  /**
   * 医嘱数量单位
   */
  numOfOrdersUnit?: string;

  /**
   * 医嘱备注
   */
  orderNote?: string;

  /**
   * 草药备注
   */
  herbalNote?: string;

  /**
   * 是否药品
   */
  drugFlag?: string;

  /**
   * 生产厂家
   */
  manufac?: string;

  /**
   * 药品商品名
   */
  tradeName?: string;

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



