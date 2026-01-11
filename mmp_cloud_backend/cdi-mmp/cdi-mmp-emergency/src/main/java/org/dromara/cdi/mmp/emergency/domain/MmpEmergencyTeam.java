package org.dromara.cdi.mmp.emergency.domain;

import org.dromara.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 应急队伍对象 mmp_emergency_team
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_emergency_team")
public class MmpEmergencyTeam extends TenantEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 队伍编码
     */
    private String teamCode;

    /**
     * 队伍名称
     */
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
     * 是否删除
     */
    @TableLogic
    private Long delFlag;

    /**
     * 备注
     */
    private String remark;


}
