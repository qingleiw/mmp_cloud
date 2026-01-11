package org.dromara.cdi.mmp.doctor.domain.vo;

import java.util.Date;

import org.dromara.cdi.mmp.doctor.domain.MmpDoctorResearchProject;
import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;


/**
 * 科研项目视图对象 mmp_doctor_research_project
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpDoctorResearchProject.class)
public class MmpDoctorResearchProjectVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @ExcelProperty(value = "主键ID")
    private Long id;

    /**
     * 医生ID
     */
    @ExcelProperty(value = "医生ID")
    private Long doctorId;

    /**
     * 项目名称
     */
    @ExcelProperty(value = "项目名称")
    private String projectName;

    /**
     * 项目编号
     */
    @ExcelProperty(value = "项目编号")
    private String projectNo;

    /**
     * 项目级别 国家级/省级/市级/院级
     */
    @ExcelProperty(value = "项目级别 国家级/省级/市级/院级")
    private String projectLevel;

    /**
     * 项目类型
     */
    @ExcelProperty(value = "项目类型")
    private String projectType;

    /**
     * 承担角色 主持人/参与人
     */
    @ExcelProperty(value = "承担角色 主持人/参与人")
    private String role;

    /**
     * 开始日期
     */
    @ExcelProperty(value = "开始日期")
    private Date startDate;

    /**
     * 结束日期
     */
    @ExcelProperty(value = "结束日期")
    private Date endDate;

    /**
     * 资助金额
     */
    @ExcelProperty(value = "资助金额")
    private Long fundingAmount;

    /**
     * 项目状态 在研/结题/终止
     */
    @ExcelProperty(value = "项目状态 在研/结题/终止")
    private String status;

    /**
     * 备注
     */
    @ExcelProperty(value = "备注")
    private String remark;

    /**
     * 是否删除
     */
    @ExcelProperty(value = "是否删除")
    private Long delFlag;


}
