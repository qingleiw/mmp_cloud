package org.dromara.cdi.mmp.doctor.domain.bo;

import org.dromara.cdi.mmp.doctor.domain.MmpDoctorBasicInfo;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;
import java.util.Date;

/**
 * 医师基本信息业务对象 mmp_doctor_info
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpDoctorBasicInfo.class, reverseConvertGenerate = false)
public class MmpDoctorBasicInfoBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 医生工号
     */
    @NotBlank(message = "医生工号不能为空", groups = { AddGroup.class, EditGroup.class })
    private String doctorCode;

    /**
     * 医生姓名
     */
    @NotBlank(message = "医生姓名不能为空", groups = { AddGroup.class, EditGroup.class })
    private String doctorName;

    /**
     * 性别 1-男 2-女
     */
    private Long gender;

    /**
     * 出生日期
     */
    private Date birthDate;

    /**
     * 身份证号
     */
    private String idCard;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 照片URL
     */
    private String photoUrl;

    /**
     * 科室ID
     */
    private Long deptId;

    /**
     * 科室名称
     */
    private String departmentName;

    /**
     * 职称
     */
    private String title;

    /**
     * 职称级别 1-初级 2-中级 3-副高 4-正高
     */
    private Long titleLevel;

    /**
     * 状态 1-在职 2-离职 3-退休
     */
    private Long status;

    /**
     * 入职日期
     */
    private Date entryDate;

    /**
     * 是否删除 0-否 1-是
     */
    private Long delFlag;


}
