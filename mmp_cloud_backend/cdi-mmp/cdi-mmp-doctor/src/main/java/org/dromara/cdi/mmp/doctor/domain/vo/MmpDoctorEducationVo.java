package org.dromara.cdi.mmp.doctor.domain.vo;

import java.util.Date;

import org.dromara.cdi.mmp.doctor.domain.MmpDoctorEducation;
import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;


/**
 * 教育经历视图对象 mmp_doctor_education
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpDoctorEducation.class)
public class MmpDoctorEducationVo implements Serializable {

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
     * 学校名称
     */
    @ExcelProperty(value = "学校名称")
    private String schoolName;

    /**
     * 专业
     */
    @ExcelProperty(value = "专业")
    private String major;

    /**
     * 学历 本科/硕士/博士
     */
    @ExcelProperty(value = "学历 本科/硕士/博士")
    private String educationLevel;

    /**
     * 学位
     */
    @ExcelProperty(value = "学位")
    private String degree;

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
     * 是否全日制 1-是 0-否
     */
    @ExcelProperty(value = "是否全日制 1-是 0-否")
    private Long isFullTime;

    /**
     * 证书编号
     */
    @ExcelProperty(value = "证书编号")
    private String certificateNo;

    /**
     * 证书附件URL
     */
    @ExcelProperty(value = "证书附件URL")
    private String certificateUrl;

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
