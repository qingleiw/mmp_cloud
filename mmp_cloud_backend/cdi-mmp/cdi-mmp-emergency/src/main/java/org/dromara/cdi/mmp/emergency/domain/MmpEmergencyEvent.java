package org.dromara.cdi.mmp.emergency.domain;

import org.dromara.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;

/**
 * 突发事件记录对象 mmp_emergency_event
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_emergency_event")
public class MmpEmergencyEvent extends TenantEntity {

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
    private String eventCode;

    /**
     * 事件标题
     */
    private String eventTitle;

    /**
     * 事件类型
     */
    private String eventType;

    /**
     * 事件等级
     */
    private String eventLevel;

    /**
     * 发生时间
     */
    private Date occurrenceTime;

    /**
     * 发现时间
     */
    private Date discoveryTime;

    /**
     * 报告时间
     */
    private Date reportTime;

    /**
     * 报告人
     */
    private String reporter;

    /**
     * 发生地点
     */
    private String location;

    /**
     * 受影响人员
     */
    private String affectedPersons;

    /**
     * 事件描述
     */
    private String eventDescription;

    /**
     * 立即措施
     */
    private String immediateMeasures;

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
