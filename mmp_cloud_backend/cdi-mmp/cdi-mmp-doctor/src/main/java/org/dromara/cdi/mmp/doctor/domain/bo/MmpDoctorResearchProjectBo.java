package org.dromara.cdi.mmp.doctor.domain.bo;

import org.dromara.cdi.mmp.doctor.domain.MmpDoctorResearchProject;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;
import java.util.Date;

/**
 * 科研项目业务对象 mmp_doctor_research_project
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpDoctorResearchProject.class, reverseConvertGenerate = false)
public class MmpDoctorResearchProjectBo extends BaseEntity {

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
