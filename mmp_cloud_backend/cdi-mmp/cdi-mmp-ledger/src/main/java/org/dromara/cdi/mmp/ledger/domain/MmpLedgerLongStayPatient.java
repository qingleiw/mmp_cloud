package org.dromara.cdi.mmp.ledger.domain;

import org.dromara.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;

/**
 * 住院超30天患者登记本对象 mmp_ledger_long_stay_patient
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_ledger_long_stay_patient")
public class MmpLedgerLongStayPatient extends TenantEntity {

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
     * 住院天数
     */
    private Long hospitalDays;

    /**
     * 所在科室
     */
    private String department;

    /**
     * 诊断
     */
    private String diagnosis;

    /**
     * 治疗方案
     */
    private String treatmentPlan;

    /**
     * 并发症
     */
    private String complications;

    /**
     * 特殊原因
     */
    private String specialReasons;

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
