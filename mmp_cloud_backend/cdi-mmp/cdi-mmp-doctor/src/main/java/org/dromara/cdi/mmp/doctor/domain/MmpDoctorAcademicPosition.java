package org.dromara.cdi.mmp.doctor.domain;

import org.dromara.common.mybatis.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;

/**
 * 学术任职对象 mmp_doctor_academic_position
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_doctor_academic_position")
public class MmpDoctorAcademicPosition extends BaseEntity {

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
