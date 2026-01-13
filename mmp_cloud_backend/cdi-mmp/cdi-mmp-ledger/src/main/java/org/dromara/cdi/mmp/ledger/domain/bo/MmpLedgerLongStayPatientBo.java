package org.dromara.cdi.mmp.ledger.domain.bo;

import org.dromara.cdi.mmp.ledger.domain.MmpLedgerLongStayPatient;
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
 * 住院超30天患者登记本业务对象 mmp_ledger_long_stay_patient
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpLedgerLongStayPatient.class, reverseConvertGenerate = false)
public class MmpLedgerLongStayPatientBo extends BaseEntity {

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
     * 备注
     */
    private String remark;


}
