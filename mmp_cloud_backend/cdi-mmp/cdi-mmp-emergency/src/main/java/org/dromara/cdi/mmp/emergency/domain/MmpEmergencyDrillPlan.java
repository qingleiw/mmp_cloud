package org.dromara.cdi.mmp.emergency.domain;

import org.dromara.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;

/**
 * 应急演练计划对象 mmp_emergency_drill_plan
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_emergency_drill_plan")
public class MmpEmergencyDrillPlan extends TenantEntity {

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
     * 是否删除
     */
    @TableLogic
    private Long delFlag;

    /**
     * 备注
     */
    private String remark;


}
