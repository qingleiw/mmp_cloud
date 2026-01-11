package org.dromara.cdi.mmp.supervision.domain.bo;

import org.dromara.cdi.mmp.supervision.domain.MmpSupervisionExpertMember;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;

/**
 * 专家组成员业务对象 mmp_supervision_expert_member
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpSupervisionExpertMember.class, reverseConvertGenerate = false)
public class MmpSupervisionExpertMemberBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 专家组ID
     */
    @NotNull(message = "专家组ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long groupId;

    /**
     * 专家姓名
     */
    @NotBlank(message = "专家姓名不能为空", groups = { AddGroup.class, EditGroup.class })
    private String expertName;

    /**
     * 专家职称
     */
    private String expertTitle;

    /**
     * 所在医院
     */
    private String hospital;

    /**
     * 专业特长
     */
    private String specialty;

    /**
     * 联系方式
     */
    private String contactInfo;

    /**
     * 状态
     */
    private String status;

    /**
     * 备注
     */
    private String remark;


}
