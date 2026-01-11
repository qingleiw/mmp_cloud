package org.dromara.cdi.mmp.emergency.domain.bo;

import org.dromara.cdi.mmp.emergency.domain.MmpEmergencyDrillPlan;
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
 * 应急演练计划业务对象 mmp_emergency_drill_plan
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpEmergencyDrillPlan.class, reverseConvertGenerate = false)
public class MmpEmergencyDrillPlanBo extends BaseEntity {

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
     * 演练类型
     */
    private String drillType;

    /**
     * 演练场景
     */
    private String drillScenario;

    /**
     * 计划日期
     */
    private Date plannedDate;

    /**
     * 实际日期
     */
    private Date actualDate;

    /**
     * 演练地点
     */
    private String location;

    /**
     * 组织者
     */
    private String organizer;

    /**
     * 参与人员
     */
    private String participants;

    /**
     * 演练目标
     */
    private String objectives;

    /**
     * 演练流程
     */
    private String procedures;

    /**
     * 评估标准
     */
    private String evaluationCriteria;

    /**
     * 状态：planned-已计划，executing-执行中，completed-已完成
     */
    private String status;

    /**
     * 演练结果
     */
    private String drillResult;

    /**
     * 经验教训
     */
    private String lessonsLearned;

    /**
     * 备注
     */
    private String remark;


}
