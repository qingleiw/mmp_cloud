package org.dromara.cdi.mmp.radiation.domain;

import org.dromara.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;

/**
 * 职业健康培训计划对象 mmp_radiation_training_plan
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_radiation_training_plan")
public class MmpRadiationTrainingPlan extends TenantEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 计划编码
     */
    private String planCode;

    /**
     * 计划名称
     */
    private String planName;

    /**
     * 培训类型：radiation-放射防护，safety-安全培训，emergency-应急培训
     */
    private String trainingType;

    /**
     * 计划日期
     */
    private Date plannedDate;

    /**
     * 计划时间
     */
    private Date plannedTime;

    /**
     * 培训地点
     */
    private String location;

    /**
     * 培训师
     */
    private String trainer;

    /**
     * 培训内容
     */
    private String trainingContent;

    /**
     * 培训对象
     */
    private String targetAudience;

    /**
     * 状态：planned-已计划，ongoing-进行中，completed-已完成，cancelled-已取消
     */
    private String status;

    /**
     * 是否已发送提醒：0-否，1-是
     */
    private String reminderSent;

    /**
     * 提醒时间
     */
    private Date reminderTime;

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
