package org.dromara.cdi.mmp.doctor.domain.bo;

import org.dromara.cdi.mmp.doctor.domain.MmpDoctorInsuranceCode;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;
import java.util.Date;

/**
 * 医保医师码业务对象 mmp_doctor_insurance_code
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpDoctorInsuranceCode.class, reverseConvertGenerate = false)
public class MmpDoctorInsuranceCodeBo extends BaseEntity {

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
     * 医保医师码
     */
    private String insuranceCode;

    /**
     * 医保类型 职工医保/居民医保/生育保险
     */
    private String insuranceType;

    /**
     * 有效期至
     */
    private Date validDate;

    /**
     * 状态 有效/暂停/注销
     */
    private String status;

    /**
     * 申请日期
     */
    private Date applyDate;

    /**
     * 审批日期
     */
    private Date approveDate;

    /**
     * 备注
     */
    private String remark;

    /**
     * 是否删除
     */
    private Long delFlag;


}
