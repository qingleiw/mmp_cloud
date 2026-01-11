package org.dromara.cdi.mmp.emergency.domain.bo;

import org.dromara.cdi.mmp.emergency.domain.MmpEmergencyPlanApproval;
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
 * 应急预案审批业务对象 mmp_emergency_plan_approval
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpEmergencyPlanApproval.class, reverseConvertGenerate = false)
public class MmpEmergencyPlanApprovalBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 预案ID
     */
    @NotNull(message = "预案ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long planId;

    /**
     * 审批阶段
     */
    private String approvalStage;

    /**
     * 审批人ID
     */
    private Long approverId;

    /**
     * 审批人姓名
     */
    private String approverName;

    /**
     * 审批意见
     */
    private String approvalOpinion;

    /**
     * 审批结果：approved-通过，rejected-驳回
     */
    private String approvalResult;

    /**
     * 审批时间
     */
    private Date approvalTime;

    /**
     * 备注
     */
    private String remark;


}
