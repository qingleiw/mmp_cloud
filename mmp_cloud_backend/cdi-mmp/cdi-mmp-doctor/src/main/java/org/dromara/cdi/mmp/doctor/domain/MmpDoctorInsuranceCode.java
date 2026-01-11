package org.dromara.cdi.mmp.doctor.domain;

import org.dromara.common.mybatis.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;

/**
 * 医保医师码对象 mmp_doctor_insurance_code
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_doctor_insurance_code")
public class MmpDoctorInsuranceCode extends BaseEntity {

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
