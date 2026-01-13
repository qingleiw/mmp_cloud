package org.dromara.cdi.mmp.ledger.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.cdi.mmp.ledger.domain.MmpLedgerMajorSurgery;
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
 * 重大疑难手术监测与管理视图对象 mmp_ledger_major_surgery
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpLedgerMajorSurgery.class)
public class MmpLedgerMajorSurgeryVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 患者姓名
     */
    @ExcelProperty(value = "患者姓名")
    private String patientName;

    /**
     * 手术日期
     */
    @ExcelProperty(value = "手术日期")
    private Date operationDate;

    /**
     * 手术科室
     */
    @ExcelProperty(value = "手术科室")
    private String department;

    /**
     * 主刀医师
     */
    @ExcelProperty(value = "主刀医师")
    private String surgeon;

    /**
     * 手术名称
     */
    @ExcelProperty(value = "手术名称")
    private String operationName;

    /**
     * 手术等级
     */
    @ExcelProperty(value = "手术等级")
    private String operationLevel;

    /**
     * 术前诊断
     */
    @ExcelProperty(value = "术前诊断")
    private String preoperativeDiagnosis;

    /**
     * 术后诊断
     */
    @ExcelProperty(value = "术后诊断")
    private String postoperativeDiagnosis;

    /**
     * 手术时长(分钟)
     */
    @ExcelProperty(value = "手术时长(分钟)")
    private Long operationDuration;

    /**
     * 麻醉方式
     */
    @ExcelProperty(value = "麻醉方式")
    private String anesthesiaMethod;

    /**
     * 术中并发症
     */
    @ExcelProperty(value = "术中并发症")
    private String complications;

    /**
     * 手术结局
     */
    @ExcelProperty(value = "手术结局")
    private String outcome;

    /**
     * 随访结果
     */
    @ExcelProperty(value = "随访结果")
    private String followUpResults;

    /**
     * 医疗评价
     */
    @ExcelProperty(value = "医疗评价")
    private String medicalEvaluation;

    /**
     * 状态
     */
    @ExcelProperty(value = "状态")
    private String status;

    /**
     * 备注
     */
    @ExcelProperty(value = "备注")
    private String remark;


}
