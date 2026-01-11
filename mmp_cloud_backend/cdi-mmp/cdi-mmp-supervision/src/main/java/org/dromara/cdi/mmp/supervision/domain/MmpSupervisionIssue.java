package org.dromara.cdi.mmp.supervision.domain;

import org.dromara.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;

/**
 * 督导问题对象 mmp_supervision_issue
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_supervision_issue")
public class MmpSupervisionIssue extends TenantEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 结果ID
     */
    private Long resultId;

    /**
     * 问题类型
     */
    private String issueType;

    /**
     * 问题描述
     */
    private String issueDescription;

    /**
     * 严重程度
     */
    private String severity;

    /**
     * 责任人
     */
    private String responsiblePerson;

    /**
     * 整改期限
     */
    private Date rectificationDeadline;

    /**
     * 状态：pending-待整改，rectifying-整改中，completed-已完成
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
