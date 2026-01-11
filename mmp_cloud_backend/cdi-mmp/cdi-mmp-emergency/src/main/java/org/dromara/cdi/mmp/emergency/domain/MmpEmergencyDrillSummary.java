package org.dromara.cdi.mmp.emergency.domain;

import org.dromara.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;

/**
 * 应急演练总结对象 mmp_emergency_drill_summary
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_emergency_drill_summary")
public class MmpEmergencyDrillSummary extends TenantEntity {

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
     * 实际开始时间
     */
    private Date actualStartTime;

    /**
     * 实际结束时间
     */
    private Date actualEndTime;

    /**
     * 实际参与人数
     */
    private Long participantsCount;

    /**
     * 演练过程描述
     */
    private String drillProcess;

    /**
     * 发现的问题
     */
    private String problemsFound;

    /**
     * 经验教训
     */
    private String lessonsLearned;

    /**
     * 改进措施
     */
    private String improvementMeasures;

    /**
     * 评价分数
     */
    private Long evaluationScore;

    /**
     * 评价人ID
     */
    private Long evaluatorId;

    /**
     * 评价人姓名
     */
    private String evaluatorName;

    /**
     * 评价时间
     */
    private Date evaluationTime;

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
