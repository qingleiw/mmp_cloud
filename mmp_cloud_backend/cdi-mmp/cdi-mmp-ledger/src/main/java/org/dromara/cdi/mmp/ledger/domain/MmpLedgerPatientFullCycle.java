package org.dromara.cdi.mmp.ledger.domain;

import org.dromara.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;

/**
 * 患者医疗全周期信息管理对象 mmp_ledger_patient_full_cycle
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_ledger_patient_full_cycle")
public class MmpLedgerPatientFullCycle extends TenantEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 患者ID
     */
    private String patientId;

    /**
     * 患者姓名
     */
    private String patientName;

    /**
     * 入院日期
     */
    private Date admissionDate;

    /**
     * 出院日期
     */
    private Date dischargeDate;

    /**
     * 就诊科室
     */
    private String department;

    /**
     * 主治医师
     */
    private String attendingPhysician;

    /**
     * 诊断信息
     */
    private String diagnosis;

    /**
     * 治疗记录
     */
    private String treatmentRecords;

    /**
     * 检查结果
     */
    private String examinationResults;

    /**
     * 用药记录
     */
    private String medicationRecords;

    /**
     * 随访记录
     */
    private String followUpRecords;

    /**
     * 治疗结局
     */
    private String outcome;

    /**
     * 医疗评价
     */
    private String medicalEvaluation;

    /**
     * 状态
     */
    private String status;

    /**
     * 是否删除
     */
    @TableLogic
    private Long delFlag;

    /**
     * 备注
     */
    private String remark;


}
