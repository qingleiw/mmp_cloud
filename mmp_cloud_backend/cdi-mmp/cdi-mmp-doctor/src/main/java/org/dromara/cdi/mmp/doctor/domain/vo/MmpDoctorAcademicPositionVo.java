package org.dromara.cdi.mmp.doctor.domain.vo;

import java.util.Date;

import org.dromara.cdi.mmp.doctor.domain.MmpDoctorAcademicPosition;
import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;


/**
 * 学术任职视图对象 mmp_doctor_academic_position
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpDoctorAcademicPosition.class)
public class MmpDoctorAcademicPositionVo implements Serializable {

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
     * 学术组织
     */
    @ExcelProperty(value = "学术组织")
    private String organization;

    /**
     * 职务
     */
    @ExcelProperty(value = "职务")
    private String position;

    /**
     * 职务级别
     */
    @ExcelProperty(value = "职务级别")
    private String positionLevel;

    /**
     * 任职开始日期
     */
    @ExcelProperty(value = "任职开始日期")
    private Date startDate;

    /**
     * 任职结束日期
     */
    @ExcelProperty(value = "任职结束日期")
    private Date endDate;

    /**
     * 是否现任 1-是 0-否
     */
    @ExcelProperty(value = "是否现任 1-是 0-否")
    private Long isCurrent;

    /**
     * 任职证明URL
     */
    @ExcelProperty(value = "任职证明URL")
    private String appointmentUrl;

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
