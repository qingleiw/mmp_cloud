package org.dromara.cdi.mmp.supervision.domain;

import org.dromara.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;

/**
 * 整改任务对象 mmp_supervision_rectification_task
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_supervision_rectification_task")
public class MmpSupervisionRectificationTask extends TenantEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 问题ID
     */
    private Long issueId;

    /**
     * 任务描述
     */
    private String taskDescription;

    /**
     * 责任部门
     */
    private String responsibleDept;

    /**
     * 责任人
     */
    private String responsiblePerson;

    /**
     * 截止日期
     */
    private Date deadline;

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
