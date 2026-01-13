package org.dromara.cdi.mmp.ledger.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.cdi.mmp.ledger.domain.MmpLedgerPatientFullCycle;
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
 * 患者医疗全周期信息管理视图对象 mmp_ledger_patient_full_cycle
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpLedgerPatientFullCycle.class)
public class MmpLedgerPatientFullCycleVo implements Serializable {

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
     * 就诊科室
     */
    @ExcelProperty(value = "就诊科室")
    private String department;

    /**
     * 主治医师
     */
    @ExcelProperty(value = "主治医师")
    private String attendingPhysician;

    /**
     * 诊断信息
     */
    @ExcelProperty(value = "诊断信息")
    private String diagnosis;

    /**
     * 治疗记录
     */
    @ExcelProperty(value = "治疗记录")
    private String treatmentRecords;

    /**
     * 检查结果
     */
    @ExcelProperty(value = "检查结果")
    private String examinationResults;

    /**
     * 用药记录
     */
    @ExcelProperty(value = "用药记录")
    private String medicationRecords;

    /**
     * 随访记录
     */
    @ExcelProperty(value = "随访记录")
    private String followUpRecords;

    /**
     * 治疗结局
     */
    @ExcelProperty(value = "治疗结局")
    private String outcome;

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
