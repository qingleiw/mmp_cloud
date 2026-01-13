package org.dromara.cdi.mmp.ledger.domain.bo;

import org.dromara.cdi.mmp.ledger.domain.MmpLedgerPatientFullCycle;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 患者医疗全周期信息管理业务对象 mmp_ledger_patient_full_cycle
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpLedgerPatientFullCycle.class, reverseConvertGenerate = false)
public class MmpLedgerPatientFullCycleBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 患者ID
     */
    @NotBlank(message = "患者ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private String patientId;

    /**
     * 患者姓名
     */
    @NotBlank(message = "患者姓名不能为空", groups = { AddGroup.class, EditGroup.class })
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
     * 备注
     */
    private String remark;


}
