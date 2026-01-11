package org.dromara.cdi.mmp.supervision.domain;

import org.dromara.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 专家组成员对象 mmp_supervision_expert_member
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_supervision_expert_member")
public class MmpSupervisionExpertMember extends TenantEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 专家组ID
     */
    private Long groupId;

    /**
     * 专家姓名
     */
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
     * 是否删除
     */
    @TableLogic
    private Long delFlag;

    /**
     * 备注
     */
    private String remark;


}
