package org.dromara.cdi.mmp.ledger.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.cdi.mmp.ledger.domain.MmpLedgerUnplannedReoperation;
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
 * 非计划再次手术登记本视图对象 mmp_ledger_unplanned_reoperation
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpLedgerUnplannedReoperation.class)
public class MmpLedgerUnplannedReoperationVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 患者姓名
     */
    @ExcelProperty(value = "患者姓名")
    private String patientName;

    /**
     * 第一次手术日期
     */
    @ExcelProperty(value = "第一次手术日期")
    private Date firstOperationDate;

    /**
     * 再次手术日期
     */
    @ExcelProperty(value = "再次手术日期")
    private Date reoperationDate;

    /**
     * 手术科室
     */
    @ExcelProperty(value = "手术科室")
    private String department;

    /**
     * 手术医师
     */
    @ExcelProperty(value = "手术医师")
    private String surgeon;

    /**
     * 第一次手术名称
     */
    @ExcelProperty(value = "第一次手术名称")
    private String firstOperationName;

    /**
     * 再次手术名称
     */
    @ExcelProperty(value = "再次手术名称")
    private String reoperationName;

    /**
     * 再次手术原因
     */
    @ExcelProperty(value = "再次手术原因")
    private String reoperationReason;

    /**
     * 并发症
     */
    @ExcelProperty(value = "并发症")
    private String complications;

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
