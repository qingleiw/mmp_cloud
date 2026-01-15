package org.dromara.cdi.mmp.natdss.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.cdi.mmp.natdss.domain.MmpNatdssB091InpatientNursingRecord;
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
 * B09-1 住院护理记录视图对象 mmp_natdss_b09_1_inpatient_nursing_record
 *
 * @author LionLi
 * @date 2026-01-15
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpNatdssB091InpatientNursingRecord.class)
public class MmpNatdssB091InpatientNursingRecordVo implements Serializable {

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
     * 护理记录流水号
     */
    @ExcelProperty(value = "护理记录流水号")
    private String recordSn;

    /**
     * 科室代码
     */
    @ExcelProperty(value = "科室代码")
    private String deptCode;

    /**
     * 科室名称
     */
    @ExcelProperty(value = "科室名称")
    private String deptName;

    /**
     * 床号
     */
    @ExcelProperty(value = "床号")
    private String bedNo;

    /**
     * 护理记录时间
     */
    @ExcelProperty(value = "护理记录时间")
    private Date recordDatetime;

    /**
     * 护理测量时间
     */
    @ExcelProperty(value = "护理测量时间")
    private Date testDatetime;

    /**
     * 测量方式
     */
    @ExcelProperty(value = "测量方式")
    private String testMethod;

    /**
     * 测量项目代码
     */
    @ExcelProperty(value = "测量项目代码")
    private String itemCode;

    /**
     * 测量项目名称
     */
    @ExcelProperty(value = "测量项目名称")
    private String itemName;

    /**
     * 疼痛评分
     */
    @ExcelProperty(value = "疼痛评分")
    private String painScores;

    /**
     * 测量结果值1
     */
    @ExcelProperty(value = "测量结果值1")
    private String itemResultValue1;

    /**
     * 测量结果单位1
     */
    @ExcelProperty(value = "测量结果单位1")
    private String itemResultUnit1;

    /**
     * 测量结果值2
     */
    @ExcelProperty(value = "测量结果值2")
    private String itemResultValue2;

    /**
     * 测量结果单位2
     */
    @ExcelProperty(value = "测量结果单位2")
    private String itemResultUnit2;

    /**
     * 病情观察及措施
     */
    @ExcelProperty(value = "病情观察及措施")
    private String observationMeasures;

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
