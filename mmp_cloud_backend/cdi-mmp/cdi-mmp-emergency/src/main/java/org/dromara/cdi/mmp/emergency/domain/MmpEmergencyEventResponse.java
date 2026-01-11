package org.dromara.cdi.mmp.emergency.domain;

import org.dromara.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;

/**
 * 突发事件响应对象 mmp_emergency_event_response
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_emergency_event_response")
public class MmpEmergencyEventResponse extends TenantEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 事件ID
     */
    private Long eventId;

    /**
     * 响应队伍
     */
    private String responseTeam;

    /**
     * 响应开始时间
     */
    private Date responseStartTime;

    /**
     * 响应结束时间
     */
    private Date responseEndTime;

    /**
     * 响应措施
     */
    private String responseMeasures;

    /**
     * 责任人
     */
    private String responsiblePerson;

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
