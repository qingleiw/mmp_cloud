package org.dromara.cdi.mmp.radiation.domain.bo;

import org.dromara.cdi.mmp.radiation.domain.MmpRadiationTrainingPlan;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 职业健康培训计划业务对象 mmp_radiation_training_plan
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpRadiationTrainingPlan.class, reverseConvertGenerate = false)
public class MmpRadiationTrainingPlanBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 计划编码
     */
    @NotBlank(message = "计划编码不能为空", groups = { AddGroup.class, EditGroup.class })
    private String planCode;

    /**
     * 计划名称
     */
    @NotBlank(message = "计划名称不能为空", groups = { AddGroup.class, EditGroup.class })
    private String planName;

    /**
     * 培训类型：radiation-放射防护，safety-安全培训，emergency-应急培训
     */
    private String trainingType;

    /**
     * 计划日期
     */
    @NotNull(message = "计划日期不能为空", groups = { AddGroup.class, EditGroup.class })
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
     * 备注
     */
    private String remark;


}
