package org.dromara.cdi.mmp.emergency.domain;

import org.dromara.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;

/**
 * 突发事件记录对象 mmp_emergency_incident
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_emergency_incident")
public class MmpEmergencyIncident extends TenantEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 事件编码
     */
    private String incidentCode;

    /**
     * 事件标题
     */
    private String incidentTitle;

    /**
     * 事件类型
     */
    private String incidentType;

    /**
     * 事件等级
     */
    private String incidentLevel;

    /**
     * 发生时间
     */
    private Date occurrenceTime;

    /**
     * 发生地点
     */
    private String location;

    /**
     * 事件描述
     */
    private String description;

    /**
     * 受影响人员
     */
    private String affectedPersons;

    /**
     * 响应队伍
     */
    private String responseTeam;

    /**
     * 响应措施
     */
    private String responseMeasures;

    /**
     * 解决时间
     */
    private Date resolutionTime;

    /**
     * 伤亡情况
     */
    private String casualties;

    /**
     * 经济损失
     */
    private Long economicLoss;

    /**
     * 经验教训
     */
    private String lessonsLearned;

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
