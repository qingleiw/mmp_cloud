package org.dromara.cdi.mmp.ledger.domain;

import org.dromara.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;

/**
 * 危重病人抢救登记本对象 mmp_ledger_critical_patient
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_ledger_critical_patient")
public class MmpLedgerCriticalPatient extends TenantEntity {

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
     * 抢救日期
     */
    private Date rescueDate;

    /**
     * 抢救科室
     */
    private String department;

    /**
     * 抢救医师
     */
    private String rescuePhysician;

    /**
     * 诊断
     */
    private String diagnosis;

    /**
     * 抢救原因
     */
    private String rescueReason;

    /**
     * 抢救措施
     */
    private String rescueMeasures;

    /**
     * 抢救时长(分钟)
     */
    private Long rescueDuration;

    /**
     * 抢救结局
     */
    private String rescueOutcome;

    /**
     * 并发症
     */
    private String complications;

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
