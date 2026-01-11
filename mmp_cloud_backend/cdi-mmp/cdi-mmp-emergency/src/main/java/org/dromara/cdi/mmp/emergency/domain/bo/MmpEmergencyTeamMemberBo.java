package org.dromara.cdi.mmp.emergency.domain.bo;

import org.dromara.cdi.mmp.emergency.domain.MmpEmergencyTeamMember;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;

/**
 * 应急队伍成员业务对象 mmp_emergency_team_member
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpEmergencyTeamMember.class, reverseConvertGenerate = false)
public class MmpEmergencyTeamMemberBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 队伍ID
     */
    @NotNull(message = "队伍ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long teamId;

    /**
     * 成员姓名
     */
    @NotBlank(message = "成员姓名不能为空", groups = { AddGroup.class, EditGroup.class })
    private String memberName;

    /**
     * 成员类型
     */
    private String memberType;

    /**
     * 所在部门
     */
    private String department;

    /**
     * 职位
     */
    private String position;

    /**
     * 专业特长
     */
    private String specialty;

    /**
     * 联系方式
     */
    private String contactInfo;

    /**
     * 紧急联系人
     */
    private String emergencyContact;

    /**
     * 状态
     */
    private String status;

    /**
     * 备注
     */
    private String remark;


}
