package org.dromara.cdi.mmp.supervision.domain.bo;

import org.dromara.cdi.mmp.supervision.domain.MmpSupervisionPlanDept;
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
 * 督查计划科室关联业务对象 mmp_supervision_plan_dept
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpSupervisionPlanDept.class, reverseConvertGenerate = false)
public class MmpSupervisionPlanDeptBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 计划ID
     */
    @NotNull(message = "计划ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long planId;

    /**
     * 科室ID
     */
    @NotNull(message = "科室ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long deptId;

    /**
     * 督导日期
     */
    private Date supervisionDate;

    /**
     * 督导人
     */
    private String supervisor;

    /**
     * 状态：pending-待督导，completed-已完成
     */
    private String status;

    /**
     * 备注
     */
    private String remark;


}
