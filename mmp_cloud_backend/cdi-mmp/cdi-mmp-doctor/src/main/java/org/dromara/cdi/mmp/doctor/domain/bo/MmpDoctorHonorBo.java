package org.dromara.cdi.mmp.doctor.domain.bo;

import org.dromara.cdi.mmp.doctor.domain.MmpDoctorHonor;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;
import java.util.Date;

/**
 * 荣誉奖励业务对象 mmp_doctor_honor
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpDoctorHonor.class, reverseConvertGenerate = false)
public class MmpDoctorHonorBo extends BaseEntity {

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
     * 荣誉名称
     */
    private String honorName;

    /**
     * 荣誉级别 国家级/省级/市级/院级
     */
    private String honorLevel;

    /**
     * 授予单位
     */
    private String awardUnit;

    /**
     * 获得日期
     */
    private Date awardDate;

    /**
     * 证书编号
     */
    private String certificateNo;

    /**
     * 证书附件URL
     */
    private String certificateUrl;

    /**
     * 备注
     */
    private String remark;

    /**
     * 是否删除
     */
    private Long delFlag;


}
