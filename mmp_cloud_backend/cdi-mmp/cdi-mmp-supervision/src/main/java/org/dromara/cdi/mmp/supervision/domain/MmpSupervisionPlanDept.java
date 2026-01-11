package org.dromara.cdi.mmp.supervision.domain;

import org.dromara.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;

/**
 * 督查计划科室关联对象 mmp_supervision_plan_dept
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_supervision_plan_dept")
public class MmpSupervisionPlanDept extends TenantEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 计划ID
     */
    private Long planId;

    /**
     * 科室ID
     */
    private Long deptId;

    /**
     * 督导日期
     */
    private Date supervisionDate;

    /**
     * 督导人
     */
    private String supervisor;

    /**
     * 状态：pending-待督导，completed-已完成
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
