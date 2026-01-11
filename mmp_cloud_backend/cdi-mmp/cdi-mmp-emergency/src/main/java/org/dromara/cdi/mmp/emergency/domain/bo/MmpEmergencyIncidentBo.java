package org.dromara.cdi.mmp.emergency.domain.bo;

import org.dromara.cdi.mmp.emergency.domain.MmpEmergencyIncident;
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
 * 突发事件记录业务对象 mmp_emergency_incident
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpEmergencyIncident.class, reverseConvertGenerate = false)
public class MmpEmergencyIncidentBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 事件编码
     */
    @NotBlank(message = "事件编码不能为空", groups = { AddGroup.class, EditGroup.class })
    private String incidentCode;

    /**
     * 事件标题
     */
    @NotBlank(message = "事件标题不能为空", groups = { AddGroup.class, EditGroup.class })
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
    @NotNull(message = "发生时间不能为空", groups = { AddGroup.class, EditGroup.class })
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
     * 备注
     */
    private String remark;


}
