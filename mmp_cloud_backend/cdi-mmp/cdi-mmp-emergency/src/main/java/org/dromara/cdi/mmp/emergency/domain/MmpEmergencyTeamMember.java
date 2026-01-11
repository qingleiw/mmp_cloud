package org.dromara.cdi.mmp.emergency.domain;

import org.dromara.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 应急队伍成员对象 mmp_emergency_team_member
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_emergency_team_member")
public class MmpEmergencyTeamMember extends TenantEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 队伍ID
     */
    private Long teamId;

    /**
     * 成员姓名
     */
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
     * 是否删除
     */
    @TableLogic
    private Long delFlag;

    /**
     * 备注
     */
    private String remark;


}
