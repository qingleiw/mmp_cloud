package org.dromara.cdi.mmp.doctor.domain.bo;

import org.dromara.cdi.mmp.doctor.domain.MmpDoctorCertificate;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;
import java.util.Date;

/**
 * 资质证书业务对象 mmp_doctor_certificate
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpDoctorCertificate.class, reverseConvertGenerate = false)
public class MmpDoctorCertificateBo extends BaseEntity {

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
     * 证书类型 执业/资格/培训等
     */
    private String certificateType;

    /**
     * 证书名称
     */
    private String certificateName;

    /**
     * 证书编号
     */
    private String certificateNo;

    /**
     * 发证机构
     */
    private String issueUnit;

    /**
     * 发证日期
     */
    private Date issueDate;

    /**
     * 有效期至
     */
    private Date validDate;

    /**
     * 是否长期有效 1-是 0-否
     */
    private Long isPermanent;

    /**
     * 证书附件URL
     */
    private String certificateUrl;

    /**
     * 状态 1-有效 2-即将到期 3-已过期 4-已注销
     */
    private Long status;

    /**
     * 提前提醒天数
     */
    private Long remindDays;

    /**
     * 备注
     */
    private String remark;

    /**
     * 是否删除
     */
    private Long delFlag;


}
