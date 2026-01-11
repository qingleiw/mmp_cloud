package org.dromara.cdi.mmp.doctor.domain;

import org.dromara.common.mybatis.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;

/**
 * 科研项目对象 mmp_doctor_research_project
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_doctor_research_project")
public class MmpDoctorResearchProject extends BaseEntity {

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
     * 项目名称
     */
    private String projectName;

    /**
     * 项目编号
     */
    private String projectNo;

    /**
     * 项目级别 国家级/省级/市级/院级
     */
    private String projectLevel;

    /**
     * 项目类型
     */
    private String projectType;

    /**
     * 承担角色 主持人/参与人
     */
    private String role;

    /**
     * 开始日期
     */
    private Date startDate;

    /**
     * 结束日期
     */
    private Date endDate;

    /**
     * 资助金额
     */
    private Long fundingAmount;

    /**
     * 项目状态 在研/结题/终止
     */
    private String status;

    /**
     * 备注
     */
    private String remark;

    /**
     * 是否删除
     */
    private Long delFlag;


}
