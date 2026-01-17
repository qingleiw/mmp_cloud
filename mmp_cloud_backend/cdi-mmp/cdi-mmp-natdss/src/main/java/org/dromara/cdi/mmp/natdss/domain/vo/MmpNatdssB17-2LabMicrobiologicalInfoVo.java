package org.dromara.cdi.mmp.natdss.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.cdi.mmp.natdss.domain.MmpNatdssB17-2LabMicrobiologicalInfo;
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
 * B17-2 微生物检验记录视图对象 mmp_natdss_b17-2_lab_microbiological_info
 *
 * @author LionLi
 * @date 2026-01-15
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpNatdssB17-2LabMicrobiologicalInfo.class)
public class MmpNatdssB17-2LabMicrobiologicalInfoVo implements Serializable {

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
     * 微生物检验流水号
     */
    @ExcelProperty(value = "微生物检验流水号")
    private String labSn;

    /**
     * 检验时间
     */
    @ExcelProperty(value = "检验时间")
    private Date testDatetime;

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
     * 标本编号
     */
    @ExcelProperty(value = "标本编号")
    private String specimenCode;

    /**
     * 标本来源
     */
    @ExcelProperty(value = "标本来源")
    private String sampleType;

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
     * 培养结果
     */
    @ExcelProperty(value = "培养结果")
    private String cultivationResult;

    /**
     * 结果代码
     */
    @ExcelProperty(value = "结果代码")
    private String resultCode;

    /**
     * 结果阴阳性
     */
    @ExcelProperty(value = "结果阴阳性")
    private String resultPosNeg;

    /**
     * 药敏方法
     */
    @ExcelProperty(value = "药敏方法")
    private String sensTestMethod;

    /**
     * 耐药机制
     */
    @ExcelProperty(value = "耐药机制")
    private String resisMechanism;

    /**
     * 检测抗生素编码
     */
    @ExcelProperty(value = "检测抗生素编码")
    private String antibioticsCode;

    /**
     * 检测抗生素名称
     */
    @ExcelProperty(value = "检测抗生素名称")
    private String antibiotics;

    /**
     * 抗生素检测结果
     */
    @ExcelProperty(value = "抗生素检测结果")
    private String antibioResult;

    /**
     * 药敏结果
     */
    @ExcelProperty(value = "药敏结果")
    private String sensitivityResult;

    /**
     * 结果参考值
     */
    @ExcelProperty(value = "结果参考值")
    private String resultReference;

    /**
     * 多重耐药名称
     */
    @ExcelProperty(value = "多重耐药名称")
    private String mdroName;

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
     * 培养代码
     */
    @ExcelProperty(value = "培养代码")
    private String cultivationCode;

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
