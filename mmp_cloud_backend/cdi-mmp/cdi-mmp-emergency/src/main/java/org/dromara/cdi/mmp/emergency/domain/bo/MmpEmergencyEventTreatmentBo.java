package org.dromara.cdi.mmp.emergency.domain.bo;

import org.dromara.cdi.mmp.emergency.domain.MmpEmergencyEventTreatment;
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
 * 突发事件救治业务对象 mmp_emergency_event_treatment
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpEmergencyEventTreatment.class, reverseConvertGenerate = false)
public class MmpEmergencyEventTreatmentBo extends BaseEntity {

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
     * 备注
     */
    private String remark;


}
