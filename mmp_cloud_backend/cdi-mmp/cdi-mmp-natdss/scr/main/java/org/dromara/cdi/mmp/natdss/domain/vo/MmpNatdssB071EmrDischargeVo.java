package org.dromara.cdi.mmp.natdss.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.cdi.mmp.natdss.domain.MmpNatdssB071EmrDischarge;
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
 * B07-1 出院记录视图对象 mmp_natdss_b07_1_emr_discharge
 *
 * @author LionLi
 * @date 2026-01-15
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpNatdssB071EmrDischarge.class)
public class MmpNatdssB071EmrDischargeVo implements Serializable {

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
     * 出院记录流水号
     */
    @ExcelProperty(value = "出院记录流水号")
    private String recordSn;

    /**
     * 出院记录创建时间
     */
    @ExcelProperty(value = "出院记录创建时间")
    private Date recordDatetime;

    /**
     * 入院时间
     */
    @ExcelProperty(value = "入院时间")
    private Date admissionDatetime;

    /**
     * 出院医嘱
     */
    @ExcelProperty(value = "出院医嘱")
    private String dischargeOrder;

    /**
     * 出院时间
     */
    @ExcelProperty(value = "出院时间")
    private Date dischargeDatetime;

    /**
     * 实际住院天数
     */
    @ExcelProperty(value = "实际住院天数")
    private Long lengthOfStay;

    /**
     * KPS评分
     */
    @ExcelProperty(value = "KPS评分")
    private String kpsScore;

    /**
     * ECOG PS评分
     */
    @ExcelProperty(value = "ECOG PS评分")
    private String ecogScore;

    /**
     * 文书内容
     */
    @ExcelProperty(value = "文书内容")
    private String recordText;

    /**
     * 入院情况
     */
    @ExcelProperty(value = "入院情况")
    private String admissionCondition;

    /**
     * 诊疗经过
     */
    @ExcelProperty(value = "诊疗经过")
    private String treatmentInfo;

    /**
     * 出院情况
     */
    @ExcelProperty(value = "出院情况")
    private String dischargeCondition;

    /**
     * 入院主要诊断编码
     */
    @ExcelProperty(value = "入院主要诊断编码")
    private String admissionMaindiagCode1;

    /**
     * 入院主要诊断名称
     */
    @ExcelProperty(value = "入院主要诊断名称")
    private String admissionMaindiagName1;

    /**
     * 入院诊断编码-2
     */
    @ExcelProperty(value = "入院诊断编码-2")
    private String admissionDiagCode2;

    /**
     * 入院诊断名称-2
     */
    @ExcelProperty(value = "入院诊断名称-2")
    private String admissionDiagName2;

    /**
     * 入院诊断编码-3
     */
    @ExcelProperty(value = "入院诊断编码-3")
    private String admissionDiagCode3;

    /**
     * 入院诊断名称-3
     */
    @ExcelProperty(value = "入院诊断名称-3")
    private String admissionDiagName3;

    /**
     * 入院诊断编码-4
     */
    @ExcelProperty(value = "入院诊断编码-4")
    private String admissionDiagCode4;

    /**
     * 入院诊断名称-4
     */
    @ExcelProperty(value = "入院诊断名称-4")
    private String admissionDiagName4;

    /**
     * 入院诊断编码-5
     */
    @ExcelProperty(value = "入院诊断编码-5")
    private String admissionDiagCode5;

    /**
     * 入院诊断名称-5
     */
    @ExcelProperty(value = "入院诊断名称-5")
    private String admissionDiagName5;

    /**
     * 入院诊断编码-N
     */
    @ExcelProperty(value = "入院诊断编码-N")
    private String admissionDiagCoden;

    /**
     * 入院诊断名称-N
     */
    @ExcelProperty(value = "入院诊断名称-N")
    private String admissionDiagNamen;

    /**
     * 出院主要诊断编码
     */
    @ExcelProperty(value = "出院主要诊断编码")
    private String dischargeMaindiagCode1;

    /**
     * 出院主要诊断名称
     */
    @ExcelProperty(value = "出院主要诊断名称")
    private String dischargeMaindiagName1;

    /**
     * 出院诊断编码-2
     */
    @ExcelProperty(value = "出院诊断编码-2")
    private String dischargeDiagCode2;

    /**
     * 出院诊断名称-2
     */
    @ExcelProperty(value = "出院诊断名称-2")
    private String dischargeDiagName2;

    /**
     * 出院诊断编码-3
     */
    @ExcelProperty(value = "出院诊断编码-3")
    private String dischargeDiagCode3;

    /**
     * 出院诊断名称-3
     */
    @ExcelProperty(value = "出院诊断名称-3")
    private String dischargeDiagName3;

    /**
     * 出院诊断编码-4
     */
    @ExcelProperty(value = "出院诊断编码-4")
    private String dischargeDiagCode4;

    /**
     * 出院诊断名称-4
     */
    @ExcelProperty(value = "出院诊断名称-4")
    private String dischargeDiagName4;

    /**
     * 出院诊断编码-5
     */
    @ExcelProperty(value = "出院诊断编码-5")
    private String dischargeDiagCode5;

    /**
     * 出院诊断名称-5
     */
    @ExcelProperty(value = "出院诊断名称-5")
    private String dischargeDiagName5;

    /**
     * 出院诊断编码-N
     */
    @ExcelProperty(value = "出院诊断编码-N")
    private String dischargeDiagCoden;

    /**
     * 出院诊断名称-N
     */
    @ExcelProperty(value = "出院诊断名称-N")
    private String dischargeDiagNamen;

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
