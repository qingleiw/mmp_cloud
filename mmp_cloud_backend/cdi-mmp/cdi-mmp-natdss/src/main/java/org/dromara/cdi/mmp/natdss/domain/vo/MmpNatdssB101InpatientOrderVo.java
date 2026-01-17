package org.dromara.cdi.mmp.natdss.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.cdi.mmp.natdss.domain.MmpNatdssB101InpatientOrder;
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
 * B10-1 住院医嘱记录视图对象 mmp_natdss_b10_1_inpatient_order
 *
 * @author LionLi
 * @date 2026-01-15
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpNatdssB101InpatientOrder.class)
public class MmpNatdssB101InpatientOrderVo implements Serializable {

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
     * 病案号
     */
    @ExcelProperty(value = "病案号")
    private String medicalRecordNo;

    /**
     * 住院号
     */
    @ExcelProperty(value = "住院号")
    private String inpatientNo;

    /**
     * 住院次数
     */
    @ExcelProperty(value = "住院次数")
    private String hospitalizationTimes;

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
     * 医嘱下达时间
     */
    @ExcelProperty(value = "医嘱下达时间")
    private Date orderGivenTime;

    /**
     * 医嘱确认时间
     */
    @ExcelProperty(value = "医嘱确认时间")
    private Date orderConfirmTime;

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
     * 住院科室代码
     */
    @ExcelProperty(value = "住院科室代码")
    private String visitDeptCode;

    /**
     * 住院科室名称
     */
    @ExcelProperty(value = "住院科室名称")
    private String visitDeptName;

    /**
     * 医嘱开始时间
     */
    @ExcelProperty(value = "医嘱开始时间")
    private Date orderStartDatetime;

    /**
     * 医嘱停止时间
     */
    @ExcelProperty(value = "医嘱停止时间")
    private Date orderEndDatetime;

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
     * 医嘱类别:长期医嘱、临时医嘱、出院带药
     */
    @ExcelProperty(value = "医嘱类别:长期医嘱、临时医嘱、出院带药")
    private String orderType;

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
    private String dose;

    /**
     * 单次剂量单位
     */
    @ExcelProperty(value = "单次剂量单位")
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
    private String frequencyName;

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
     * 医嘱项目数量
     */
    @ExcelProperty(value = "医嘱项目数量")
    private String numOfOrder;

    /**
     * 医嘱项目数量单位
     */
    @ExcelProperty(value = "医嘱项目数量单位")
    private String numOfOrderUnit;

    /**
     * 草药备注
     */
    @ExcelProperty(value = "草药备注")
    private String herbalNote;

    /**
     * 医嘱备注
     */
    @ExcelProperty(value = "医嘱备注")
    private String orderNote;

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
