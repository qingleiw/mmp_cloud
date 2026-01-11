package org.dromara.cdi.mmp.emergency.domain;

import org.dromara.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;

/**
 * 突发事件救治对象 mmp_emergency_event_treatment
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_emergency_event_treatment")
public class MmpEmergencyEventTreatment extends TenantEntity {

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
     * 患者ID
     */
    private String patientId;

    /**
     * 患者姓名
     */
    private String patientName;

    /**
     * 诊断
     */
    private String diagnosis;

    /**
     * 救治措施
     */
    private String treatmentMeasures;

    /**
     * 救治结果
     */
    private String treatmentResult;

    /**
     * 救治医师
     */
    private String treatingPhysician;

    /**
     * 救治时间
     */
    private Date treatmentTime;

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
