package org.dromara.cdi.mmp.doctor.domain.bo;

import org.dromara.cdi.mmp.doctor.domain.MmpDoctorAcademicPosition;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;
import java.util.Date;

/**
 * 学术任职业务对象 mmp_doctor_academic_position
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpDoctorAcademicPosition.class, reverseConvertGenerate = false)
public class MmpDoctorAcademicPositionBo extends BaseEntity {

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
     * 学术组织
     */
    private String organization;

    /**
     * 职务
     */
    private String position;

    /**
     * 职务级别
     */
    private String positionLevel;

    /**
     * 任职开始日期
     */
    private Date startDate;

    /**
     * 任职结束日期
     */
    private Date endDate;

    /**
     * 是否现任 1-是 0-否
     */
    private Long isCurrent;

    /**
     * 任职证明URL
     */
    private String appointmentUrl;

    /**
     * 备注
     */
    private String remark;

    /**
     * 是否删除
     */
    private Long delFlag;


}
