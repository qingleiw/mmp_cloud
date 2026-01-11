package org.dromara.cdi.mmp.emergency.domain.bo;

import org.dromara.cdi.mmp.emergency.domain.MmpEmergencyTeam;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;

/**
 * 应急队伍业务对象 mmp_emergency_team
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpEmergencyTeam.class, reverseConvertGenerate = false)
public class MmpEmergencyTeamBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 队伍编码
     */
    @NotBlank(message = "队伍编码不能为空", groups = { AddGroup.class, EditGroup.class })
    private String teamCode;

    /**
     * 队伍名称
     */
    @NotBlank(message = "队伍名称不能为空", groups = { AddGroup.class, EditGroup.class })
    private String teamName;

    /**
     * 队伍类型
     */
    private String teamType;

    /**
     * 专业特长
     */
    private String specialty;

    /**
     * 队长
     */
    private String leader;

    /**
     * 联系方式
     */
    private String contactInfo;

    /**
     * 成员数量
     */
    private Long memberCount;

    /**
     * 状态
     */
    private String status;

    /**
     * 备注
     */
    private String remark;


}
