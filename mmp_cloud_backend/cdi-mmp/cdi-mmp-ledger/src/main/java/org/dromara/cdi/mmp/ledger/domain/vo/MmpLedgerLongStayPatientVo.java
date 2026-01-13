package org.dromara.cdi.mmp.ledger.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.cdi.mmp.ledger.domain.MmpLedgerLongStayPatient;
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
 * 住院超30天患者登记本视图对象 mmp_ledger_long_stay_patient
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpLedgerLongStayPatient.class)
public class MmpLedgerLongStayPatientVo implements Serializable {

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
     * 出院日期
     */
    @ExcelProperty(value = "出院日期")
    private Date dischargeDate;

    /**
     * 住院天数
     */
    @ExcelProperty(value = "住院天数")
    private Long hospitalDays;

    /**
     * 所在科室
     */
    @ExcelProperty(value = "所在科室")
    private String department;

    /**
     * 诊断
     */
    @ExcelProperty(value = "诊断")
    private String diagnosis;

    /**
     * 治疗方案
     */
    @ExcelProperty(value = "治疗方案")
    private String treatmentPlan;

    /**
     * 并发症
     */
    @ExcelProperty(value = "并发症")
    private String complications;

    /**
     * 特殊原因
     */
    @ExcelProperty(value = "特殊原因")
    private String specialReasons;

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
