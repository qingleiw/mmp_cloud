package org.dromara.cdi.mmp.supervision.domain.bo;

import org.dromara.cdi.mmp.supervision.domain.MmpSupervisionExpertGroup;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;

/**
 * 专家组业务对象 mmp_supervision_expert_group
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpSupervisionExpertGroup.class, reverseConvertGenerate = false)
public class MmpSupervisionExpertGroupBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 专家组编码
     */
    @NotBlank(message = "专家组编码不能为空", groups = { AddGroup.class, EditGroup.class })
    private String groupCode;

    /**
     * 专家组名称
     */
    @NotBlank(message = "专家组名称不能为空", groups = { AddGroup.class, EditGroup.class })
    private String groupName;

    /**
     * 专家组类型
     */
    private String groupType;

    /**
     * 专业领域
     */
    private String specialty;

    /**
     * 描述
     */
    private String description;

    /**
     * 状态
     */
    private String status;

    /**
     * 备注
     */
    private String remark;


}
