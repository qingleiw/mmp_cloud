package org.dromara.cdi.mmp.natdss.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.cdi.mmp.natdss.domain.MmpNatdssB161ExamInfo;
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
 * B16-1 常规检查记录视图对象 mmp_natdss_b16_1_exam_info
 *
 * @author LionLi
 * @date 2026-01-15
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpNatdssB161ExamInfo.class)
public class MmpNatdssB161ExamInfoVo implements Serializable {

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
     * 申请科室代码
     */
    @ExcelProperty(value = "申请科室代码")
    private String applyDeptCode;

    /**
     * 申请科室名称
     */
    @ExcelProperty(value = "申请科室名称")
    private String applyDeptName;

    /**
     * 检查流水号
     */
    @ExcelProperty(value = "检查流水号")
    private String examSn;

    /**
     * 检查时间
     */
    @ExcelProperty(value = "检查时间")
    private Date examDatetime;

    /**
     * 检查类型:心电超声放射
     */
    @ExcelProperty(value = "检查类型:心电超声放射")
    private String examType;

    /**
     * 检查项目类型
     */
    @ExcelProperty(value = "检查项目类型")
    private String examItemType;

    /**
     * 检查项目代码
     */
    @ExcelProperty(value = "检查项目代码")
    private String examItemCode;

    /**
     * 检查项目名称
     */
    @ExcelProperty(value = "检查项目名称")
    private String examItemName;

    /**
     * 检查部位
     */
    @ExcelProperty(value = "检查部位")
    private String examSites;

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
     * 报告科室代码
     */
    @ExcelProperty(value = "报告科室代码")
    private String reportDeptCode;

    /**
     * 报告科室名称
     */
    @ExcelProperty(value = "报告科室名称")
    private String reportDeptName;

    /**
     * 检查所见
     */
    @ExcelProperty(value = "检查所见")
    private String examDiagDescription;

    /**
     * 检查结论
     */
    @ExcelProperty(value = "检查结论")
    private String examDiagConclusion;

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
