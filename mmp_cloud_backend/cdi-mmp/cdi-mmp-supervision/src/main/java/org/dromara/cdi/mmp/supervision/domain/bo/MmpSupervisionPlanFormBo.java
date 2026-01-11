package org.dromara.cdi.mmp.supervision.domain.bo;

import org.dromara.cdi.mmp.supervision.domain.MmpSupervisionPlanForm;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;

/**
 * 督查计划单关联业务对象 mmp_supervision_plan_form
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpSupervisionPlanForm.class, reverseConvertGenerate = false)
public class MmpSupervisionPlanFormBo extends BaseEntity {

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
     * 表单ID
     */
    @NotNull(message = "表单ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long formId;

    /**
     * 排序
     */
    private Long sortOrder;

    /**
     * 备注
     */
    private String remark;


}
