package org.dromara.cdi.mmp.emergency.domain.bo;

import org.dromara.cdi.mmp.emergency.domain.MmpEmergencyEvent;
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
 * 突发事件记录业务对象 mmp_emergency_event
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpEmergencyEvent.class, reverseConvertGenerate = false)
public class MmpEmergencyEventBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 事件编码
     */
    @NotBlank(message = "事件编码不能为空", groups = { AddGroup.class, EditGroup.class })
    private String eventCode;

    /**
     * 事件标题
     */
    @NotBlank(message = "事件标题不能为空", groups = { AddGroup.class, EditGroup.class })
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
    @NotNull(message = "发生时间不能为空", groups = { AddGroup.class, EditGroup.class })
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
    @NotBlank(message = "事件描述不能为空", groups = { AddGroup.class, EditGroup.class })
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
     * 备注
     */
    private String remark;


}
