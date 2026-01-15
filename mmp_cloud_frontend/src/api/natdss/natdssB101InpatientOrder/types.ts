export interface NatdssB101InpatientOrderVO {
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
   * 病案号
   */
  medicalRecordNo: string;

  /**
   * 住院号
   */
  inpatientNo: string;

  /**
   * 住院次数
   */
  hospitalizationTimes: string;

  /**
   * 医嘱流水号
   */
  orderSn: string;

  /**
   * 医技申请单号
   */
  requestNo: string;

  /**
   * 医嘱下达时间
   */
  orderGivenTime: string;

  /**
   * 医嘱确认时间
   */
  orderConfirmTime: string;

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
   * 住院科室代码
   */
  visitDeptCode: string;

  /**
   * 住院科室名称
   */
  visitDeptName: string;

  /**
   * 医嘱开始时间
   */
  orderStartDatetime: string;

  /**
   * 医嘱停止时间
   */
  orderEndDatetime: string;

  /**
   * 医嘱执行科室代码
   */
  executiveDeptCode: string;

  /**
   * 医嘱执行科室名称
   */
  executiveDeptName: string;

  /**
   * 医嘱类别:长期医嘱、临时医嘱、出院带药
   */
  orderType: string;

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
  dose: string;

  /**
   * 单次剂量单位
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
  frequencyName: string;

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
   * 医嘱项目数量
   */
  numOfOrder: string;

  /**
   * 医嘱项目数量单位
   */
  numOfOrderUnit: string;

  /**
   * 草药备注
   */
  herbalNote: string;

  /**
   * 医嘱备注
   */
  orderNote: string;

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

export interface NatdssB101InpatientOrderForm extends BaseEntity {
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
   * 病案号
   */
  medicalRecordNo?: string;

  /**
   * 住院号
   */
  inpatientNo?: string;

  /**
   * 住院次数
   */
  hospitalizationTimes?: string;

  /**
   * 医嘱流水号
   */
  orderSn?: string;

  /**
   * 医技申请单号
   */
  requestNo?: string;

  /**
   * 医嘱下达时间
   */
  orderGivenTime?: string;

  /**
   * 医嘱确认时间
   */
  orderConfirmTime?: string;

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
   * 住院科室代码
   */
  visitDeptCode?: string;

  /**
   * 住院科室名称
   */
  visitDeptName?: string;

  /**
   * 医嘱开始时间
   */
  orderStartDatetime?: string;

  /**
   * 医嘱停止时间
   */
  orderEndDatetime?: string;

  /**
   * 医嘱执行科室代码
   */
  executiveDeptCode?: string;

  /**
   * 医嘱执行科室名称
   */
  executiveDeptName?: string;

  /**
   * 医嘱类别:长期医嘱、临时医嘱、出院带药
   */
  orderType?: string;

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
  dose?: string;

  /**
   * 单次剂量单位
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
  frequencyName?: string;

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
   * 医嘱项目数量
   */
  numOfOrder?: string;

  /**
   * 医嘱项目数量单位
   */
  numOfOrderUnit?: string;

  /**
   * 草药备注
   */
  herbalNote?: string;

  /**
   * 医嘱备注
   */
  orderNote?: string;

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

export interface NatdssB101InpatientOrderQuery extends PageQuery {

  /**
   * 患者ID
   */
  patientId?: string | number;

  /**
   * 单次就诊唯一标识号
   */
  visitSn?: string;

  /**
   * 病案号
   */
  medicalRecordNo?: string;

  /**
   * 住院号
   */
  inpatientNo?: string;

  /**
   * 住院次数
   */
  hospitalizationTimes?: string;

  /**
   * 医嘱流水号
   */
  orderSn?: string;

  /**
   * 医技申请单号
   */
  requestNo?: string;

  /**
   * 医嘱下达时间
   */
  orderGivenTime?: string;

  /**
   * 医嘱确认时间
   */
  orderConfirmTime?: string;

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
   * 住院科室代码
   */
  visitDeptCode?: string;

  /**
   * 住院科室名称
   */
  visitDeptName?: string;

  /**
   * 医嘱开始时间
   */
  orderStartDatetime?: string;

  /**
   * 医嘱停止时间
   */
  orderEndDatetime?: string;

  /**
   * 医嘱执行科室代码
   */
  executiveDeptCode?: string;

  /**
   * 医嘱执行科室名称
   */
  executiveDeptName?: string;

  /**
   * 医嘱类别:长期医嘱、临时医嘱、出院带药
   */
  orderType?: string;

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
  dose?: string;

  /**
   * 单次剂量单位
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
  frequencyName?: string;

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
   * 医嘱项目数量
   */
  numOfOrder?: string;

  /**
   * 医嘱项目数量单位
   */
  numOfOrderUnit?: string;

  /**
   * 草药备注
   */
  herbalNote?: string;

  /**
   * 医嘱备注
   */
  orderNote?: string;

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



