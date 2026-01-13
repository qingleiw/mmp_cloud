package org.dromara.cdi.mmp.ledger.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.cdi.mmp.ledger.domain.MmpLedgerCriticalPatient;
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
 * 危重病人抢救登记本视图对象 mmp_ledger_critical_patient
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpLedgerCriticalPatient.class)
public class MmpLedgerCriticalPatientVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 患者姓名
     */
    @ExcelProperty(value = "患者姓名")
    private String patientName;

    /**
     * 入院日期
     */
    @ExcelProperty(value = "入院日期")
    private Date admissionDate;

    /**
     * 抢救日期
     */
    @ExcelProperty(value = "抢救日期")
    private Date rescueDate;

    /**
     * 抢救科室
     */
    @ExcelProperty(value = "抢救科室")
    private String department;

    /**
     * 抢救医师
     */
    @ExcelProperty(value = "抢救医师")
    private String rescuePhysician;

    /**
     * 诊断
     */
    @ExcelProperty(value = "诊断")
    private String diagnosis;

    /**
     * 抢救原因
     */
    @ExcelProperty(value = "抢救原因")
    private String rescueReason;

    /**
     * 抢救措施
     */
    @ExcelProperty(value = "抢救措施")
    private String rescueMeasures;

    /**
     * 抢救时长(分钟)
     */
    @ExcelProperty(value = "抢救时长(分钟)")
    private Long rescueDuration;

    /**
     * 抢救结局
     */
    @ExcelProperty(value = "抢救结局")
    private String rescueOutcome;

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
