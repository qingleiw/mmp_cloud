package org.dromara.cdi.mmp.doctor.domain.bo;

import org.dromara.cdi.mmp.doctor.domain.MmpDoctorElectronicRegistration;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;
import java.util.Date;

/**
 * 医师电子化注册业务对象 mmp_doctor_electronic_registration
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpDoctorElectronicRegistration.class, reverseConvertGenerate = false)
public class MmpDoctorElectronicRegistrationBo extends BaseEntity {

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
     * 注册编号
     */
    private String registrationNo;

    /**
     * 注册类型 首次注册/变更注册/多机构备案
     */
    private String registrationType;

    /**
     * 执业类别
     */
    private String practiceCategory;

    /**
     * 执业范围
     */
    private String practiceScope;

    /**
     * 执业地点
     */
    private String practiceLocation;

    /**
     * 发证日期
     */
    private Date issueDate;

    /**
     * 有效期至
     */
    private Date validDate;

    /**
     * 注册机关
     */
    private String registrationAuthority;

    /**
     * 注册状态 有效/注销/吊销
     */
    private String registrationStatus;

    /**
     * 是否多机构备案 1-是 0-否
     */
    private Long multiInstitutionFlag;

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
