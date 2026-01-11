package org.dromara.cdi.mmp.supervision.domain;

import org.dromara.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 专家组对象 mmp_supervision_expert_group
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_supervision_expert_group")
public class MmpSupervisionExpertGroup extends TenantEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 专家组编码
     */
    private String groupCode;

    /**
     * 专家组名称
     */
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
     * 是否删除
     */
    @TableLogic
    private Long delFlag;

    /**
     * 备注
     */
    private String remark;


}
