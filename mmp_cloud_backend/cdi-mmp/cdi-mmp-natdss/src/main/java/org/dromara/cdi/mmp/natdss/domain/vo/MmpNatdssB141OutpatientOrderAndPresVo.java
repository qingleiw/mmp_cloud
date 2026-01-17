package org.dromara.cdi.mmp.natdss.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.cdi.mmp.natdss.domain.MmpNatdssB141OutpatientOrderAndPres;
import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import org.dromara.common.excel.annotation.ExcelDictFormat;
import org.dromara.common.excel.convert.ExcelDictConvert;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;



/**
 * B14-1 门诊医嘱处方记录视图对象 mmp_natdss_b14_1_outpatient_order_and_pres
 *
 * @author LionLi
 * @date 2026-01-15
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpNatdssB141OutpatientOrderAndPres.class)
public class MmpNatdssB141OutpatientOrderAndPresVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 系统自增主键
     */
    @ExcelProperty(value = "系统自增主键")
    private Long id;

    /**
     * 患者ID
     */
    @ExcelProperty(value = "患者ID")
    private String patientId;

    /**
     * 单次就诊唯一标识号
     */
    @ExcelProperty(value = "单次就诊唯一标识号")
    private String visitSn;

    /**
     * 就诊类型:门诊、急诊
     */
    @ExcelProperty(value = "就诊类型:门诊、急诊")
    private String visitType;

    /**
     * 就诊卡号
     */
    @ExcelProperty(value = "就诊卡号")
    private String visitCardNo;

    /**
     * 门诊号
     */
    @ExcelProperty(value = "门诊号")
    private String outpatientNo;

    /**
     * 就诊次数
     */
    @ExcelProperty(value = "就诊次数")
    private Long visitTimes;

    /**
     * 医嘱流水号
     */
    @ExcelProperty(value = "医嘱流水号")
    private String orderSn;

    /**
     * 医技申请单号
     */
    @ExcelProperty(value = "医技申请单号")
    private String requestNo;

    /**
     * 医嘱开具时间
     */
    @ExcelProperty(value = "医嘱开具时间")
    private Date orderGivenTime;

    /**
     * 就诊科室代码
     */
    @ExcelProperty(value = "就诊科室代码")
    private String visitDeptCode;

    /**
     * 就诊科室名称
     */
    @ExcelProperty(value = "就诊科室名称")
    private String visitDeptName;

    /**
     * 医嘱下达科室代码
     */
    @ExcelProperty(value = "医嘱下达科室代码")
    private String orderDeptCode;

    /**
     * 医嘱下达科室名称
     */
    @ExcelProperty(value = "医嘱下达科室名称")
    private String orderDeptName;

    /**
     * 医嘱开单医生代码
     */
    @ExcelProperty(value = "医嘱开单医生代码")
    private String orderDoctorNo;

    /**
     * 职称名称
     */
    @ExcelProperty(value = "职称名称")
    private String technicalTitle;

    /**
     * 职务名称
     */
    @ExcelProperty(value = "职务名称")
    private String jobTitle;

    /**
     * 医嘱执行科室代码
     */
    @ExcelProperty(value = "医嘱执行科室代码")
    private String executiveDeptCode;

    /**
     * 医嘱执行科室名称
     */
    @ExcelProperty(value = "医嘱执行科室名称")
    private String executiveDeptName;

    /**
     * 处方分类代码
     */
    @ExcelProperty(value = "处方分类代码")
    private String prescriptionClassCode;

    /**
     * 处方分类名称
     */
    @ExcelProperty(value = "处方分类名称")
    private String prescriptionClassName;

    /**
     * 医嘱分类代码
     */
    @ExcelProperty(value = "医嘱分类代码")
    private String orderClassCode;

    /**
     * 医嘱分类名称
     */
    @ExcelProperty(value = "医嘱分类名称")
    private String orderClassName;

    /**
     * 医嘱项目代码
     */
    @ExcelProperty(value = "医嘱项目代码")
    private String orderItemCode;

    /**
     * 医嘱项目名称
     */
    @ExcelProperty(value = "医嘱项目名称")
    private String orderItemName;

    /**
     * 医嘱组号
     */
    @ExcelProperty(value = "医嘱组号")
    private String orderGroupNo;

    /**
     * 单次剂量
     */
    @ExcelProperty(value = "单次剂量")
    private Long dose;

    /**
     * 剂量单位
     */
    @ExcelProperty(value = "剂量单位")
    private String doseUnit;

    /**
     * 药品剂型
     */
    @ExcelProperty(value = "药品剂型")
    private String form;

    /**
     * 规格
     */
    @ExcelProperty(value = "规格")
    private String spec;

    /**
     * 使用频率代码
     */
    @ExcelProperty(value = "使用频率代码")
    private String frequencyCode;

    /**
     * 使用频率
     */
    @ExcelProperty(value = "使用频率")
    private String frequency;

    /**
     * 给药途径
     */
    @ExcelProperty(value = "给药途径")
    private String administrationRoute;

    /**
     * 液体配置
     */
    @ExcelProperty(value = "液体配置")
    private String liquidConfiguration;

    /**
     * 注射方式
     */
    @ExcelProperty(value = "注射方式")
    private String injectionType;

    /**
     * 用药顺序
     */
    @ExcelProperty(value = "用药顺序")
    private String drugOrder;

    /**
     * 用药配伍
     */
    @ExcelProperty(value = "用药配伍")
    private String drugCompatibility;

    /**
     * 输液时长
     */
    @ExcelProperty(value = "输液时长")
    private String infusionDuration;

    /**
     * 使用天数
     */
    @ExcelProperty(value = "使用天数")
    private Long daysOfMedication;

    /**
     * 药品使用总剂量
     */
    @ExcelProperty(value = "药品使用总剂量")
    private Long totalDose;

    /**
     * 总量单位
     */
    @ExcelProperty(value = "总量单位")
    private String totalDoseUnit;

    /**
     * 医嘱数量
     */
    @ExcelProperty(value = "医嘱数量")
    private String numOfOrders;

    /**
     * 医嘱数量单位
     */
    @ExcelProperty(value = "医嘱数量单位")
    private String numOfOrdersUnit;

    /**
     * 医嘱备注
     */
    @ExcelProperty(value = "医嘱备注")
    private String orderNote;

    /**
     * 草药备注
     */
    @ExcelProperty(value = "草药备注")
    private String herbalNote;

    /**
     * 是否药品
     */
    @ExcelProperty(value = "是否药品")
    private String drugFlag;

    /**
     * 生产厂家
     */
    @ExcelProperty(value = "生产厂家")
    private String manufac;

    /**
     * 药品商品名
     */
    @ExcelProperty(value = "药品商品名")
    private String tradeName;

    /**
     * 扩展字段1
     */
    @ExcelProperty(value = "扩展字段1")
    private String extendData1;

    /**
     * 扩展字段2
     */
    @ExcelProperty(value = "扩展字段2")
    private String extendData2;

    /**
     * 记录状态:1正常 0作废
     */
    @ExcelProperty(value = "记录状态:1正常 0作废")
    private Long recordStatus;

    /**
     * 创建时间
     */
    @ExcelProperty(value = "创建时间")
    private Date createdTime;

    /**
     * 更新时间
     */
    @ExcelProperty(value = "更新时间")
    private Date updatedTime;


}
