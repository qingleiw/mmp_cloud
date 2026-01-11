package org.dromara.cdi.mmp.emergency.domain.bo;

import org.dromara.cdi.mmp.emergency.domain.MmpEmergencyEventResponse;
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
 * 突发事件响应业务对象 mmp_emergency_event_response
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpEmergencyEventResponse.class, reverseConvertGenerate = false)
public class MmpEmergencyEventResponseBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 事件ID
     */
    @NotNull(message = "事件ID不能为空", groups = { AddGroup.class, EditGroup.class })
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
     * 备注
     */
    private String remark;


}
