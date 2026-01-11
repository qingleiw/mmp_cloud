package org.dromara.cdi.mmp.doctor.domain;

import org.dromara.common.mybatis.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;

/**
 * 医师电子化注册对象 mmp_doctor_electronic_registration
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_doctor_electronic_registration")
public class MmpDoctorElectronicRegistration extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 医生ID
     */
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
