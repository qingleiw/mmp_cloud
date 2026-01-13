package org.dromara.cdi.mmp.ledger.domain.bo;

import org.dromara.cdi.mmp.ledger.domain.MmpLedgerUnplannedReoperation;
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
 * 非计划再次手术登记本业务对象 mmp_ledger_unplanned_reoperation
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpLedgerUnplannedReoperation.class, reverseConvertGenerate = false)
public class MmpLedgerUnplannedReoperationBo extends BaseEntity {

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
     * 第一次手术日期
     */
    @NotNull(message = "第一次手术日期不能为空", groups = { AddGroup.class, EditGroup.class })
    private Date firstOperationDate;

    /**
     * 再次手术日期
     */
    @NotNull(message = "再次手术日期不能为空", groups = { AddGroup.class, EditGroup.class })
    private Date reoperationDate;

    /**
     * 手术科室
     */
    private String department;

    /**
     * 手术医师
     */
    private String surgeon;

    /**
     * 第一次手术名称
     */
    private String firstOperationName;

    /**
     * 再次手术名称
     */
    private String reoperationName;

    /**
     * 再次手术原因
     */
    private String reoperationReason;

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
