package org.dromara.cdi.mmp.ledger.domain.bo;

import org.dromara.cdi.mmp.ledger.domain.MmpLedgerCriticalPatient;
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
 * 危重病人抢救登记本业务对象 mmp_ledger_critical_patient
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpLedgerCriticalPatient.class, reverseConvertGenerate = false)
public class MmpLedgerCriticalPatientBo extends BaseEntity {

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
    @NotNull(message = "入院日期不能为空", groups = { AddGroup.class, EditGroup.class })
    private Date admissionDate;

    /**
     * 抢救日期
     */
    @NotNull(message = "抢救日期不能为空", groups = { AddGroup.class, EditGroup.class })
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
     * 备注
     */
    private String remark;


}
