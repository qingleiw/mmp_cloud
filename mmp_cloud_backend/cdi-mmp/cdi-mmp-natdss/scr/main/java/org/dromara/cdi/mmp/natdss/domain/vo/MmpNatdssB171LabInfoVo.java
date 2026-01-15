package org.dromara.cdi.mmp.natdss.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.cdi.mmp.natdss.domain.MmpNatdssB171LabInfo;
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
 * B17-1 常规检验记录视图对象 mmp_natdss_b17_1_lab_info
 *
 * @author LionLi
 * @date 2026-01-15
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpNatdssB171LabInfo.class)
public class MmpNatdssB171LabInfoVo implements Serializable {

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
     * 就诊类型:住院、门诊
     */
    @ExcelProperty(value = "就诊类型:住院、门诊")
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
     * 患者姓名
     */
    @ExcelProperty(value = "患者姓名")
    private String name;

    /**
     * 申请单号
     */
    @ExcelProperty(value = "申请单号")
    private String applyNo;

    /**
     * 申请医嘱流水号
     */
    @ExcelProperty(value = "申请医嘱流水号")
    private String orderSn;

    /**
     * 申请时间
     */
    @ExcelProperty(value = "申请时间")
    private Date applyDatetime;

    /**
     * 标本类型代码
     */
    @ExcelProperty(value = "标本类型代码")
    private String specimenTypeCode;

    /**
     * 标本类型名称
     */
    @ExcelProperty(value = "标本类型名称")
    private String specimenTypeName;

    /**
     * 标本编号
     */
    @ExcelProperty(value = "标本编号")
    private String specimenCode;

    /**
     * 检验流水号
     */
    @ExcelProperty(value = "检验流水号")
    private String labSn;

    /**
     * 检验时间
     */
    @ExcelProperty(value = "检验时间")
    private Date testDatetime;

    /**
     * 检验方法代码
     */
    @ExcelProperty(value = "检验方法代码")
    private String testMethodCode;

    /**
     * 检验方法
     */
    @ExcelProperty(value = "检验方法")
    private String testMethod;

    /**
     * 检验类型
     */
    @ExcelProperty(value = "检验类型")
    private String labType;

    /**
     * 组合项目代码
     */
    @ExcelProperty(value = "组合项目代码")
    private String itemGroupCode;

    /**
     * 组合项目名称
     */
    @ExcelProperty(value = "组合项目名称")
    private String itemGroupName;

    /**
     * 明细项目代码
     */
    @ExcelProperty(value = "明细项目代码")
    private String itemCode;

    /**
     * 明细项目名称
     */
    @ExcelProperty(value = "明细项目名称")
    private String itemName;

    /**
     * 明细项目序号
     */
    @ExcelProperty(value = "明细项目序号")
    private String itemNo;

    /**
     * 检验-结果(数值)
     */
    @ExcelProperty(value = "检验-结果(数值)")
    private String resultQuantitative;

    /**
     * 检验-结果(定性)
     */
    @ExcelProperty(value = "检验-结果(定性)")
    private String resultQualitative;

    /**
     * 检验-计量单位
     */
    @ExcelProperty(value = "检验-计量单位")
    private String resultUnit;

    /**
     * 参考值
     */
    @ExcelProperty(value = "参考值")
    private String referenceRange;

    /**
     * 参考值提醒
     */
    @ExcelProperty(value = "参考值提醒")
    private String referenceRangeAlert;

    /**
     * 报告单号
     */
    @ExcelProperty(value = "报告单号")
    private String reportNo;

    /**
     * 报告时间
     */
    @ExcelProperty(value = "报告时间")
    private Date reportDatetime;

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
