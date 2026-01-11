package org.dromara.cdi.mmp.doctor.domain.bo;

import org.dromara.cdi.mmp.doctor.domain.MmpDoctorAdverseRecord;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;
import java.util.Date;

/**
 * 不良行为记录业务对象 mmp_doctor_adverse_record
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpDoctorAdverseRecord.class, reverseConvertGenerate = false)
public class MmpDoctorAdverseRecordBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 医生ID
     */
    @NotNull(message = "医生ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long doctorId;

    /**
     * 记录类型 医疗事故/差错/违规
     */
    private String recordType;

    /**
     * 记录标题
     */
    private String recordTitle;

    /**
     * 发生日期
     */
    private Date occurDate;

    /**
     * 事件描述
     */
    private String description;

    /**
     * 后果
     */
    private String consequence;

    /**
     * 处理措施
     */
    private String handlingMeasure;

    /**
     * 处罚情况
     */
    private String punishment;

    /**
     * 记录状态 待处理/处理中/已处理
     */
    private String recordStatus;

    /**
     * 是否删除
     */
    private Long delFlag;


}
