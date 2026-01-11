package org.dromara.cdi.mmp.doctor.domain.vo;

import java.util.Date;

import org.dromara.cdi.mmp.doctor.domain.MmpDoctorBasicInfo;
import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;


/**
 * 医师基本信息视图对象 mmp_doctor_info
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpDoctorBasicInfo.class)
public class MmpDoctorBasicInfoVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @ExcelProperty(value = "主键ID")
    private Long id;

    /**
     * 医生工号
     */
    @ExcelProperty(value = "医生工号")
    private String doctorCode;

    /**
     * 医生姓名
     */
    @ExcelProperty(value = "医生姓名")
    private String doctorName;

    /**
     * 性别 1-男 2-女
     */
    @ExcelProperty(value = "性别 1-男 2-女")
    private Long gender;

    /**
     * 出生日期
     */
    @ExcelProperty(value = "出生日期")
    private Date birthDate;

    /**
     * 身份证号
     */
    @ExcelProperty(value = "身份证号")
    private String idCard;

    /**
     * 联系电话
     */
    @ExcelProperty(value = "联系电话")
    private String phone;

    /**
     * 电子邮箱
     */
    @ExcelProperty(value = "电子邮箱")
    private String email;

    /**
     * 照片URL
     */
    @ExcelProperty(value = "照片URL")
    private String photoUrl;

    /**
     * 科室ID
     */
    @ExcelProperty(value = "科室ID")
    private Long deptId;

    /**
     * 科室名称
     */
    @ExcelProperty(value = "科室名称")
    private String departmentName;

    /**
     * 职称
     */
    @ExcelProperty(value = "职称")
    private String title;

    /**
     * 职称级别 1-初级 2-中级 3-副高 4-正高
     */
    @ExcelProperty(value = "职称级别 1-初级 2-中级 3-副高 4-正高")
    private Long titleLevel;

    /**
     * 状态 1-在职 2-离职 3-退休
     */
    @ExcelProperty(value = "状态 1-在职 2-离职 3-退休")
    private Long status;

    /**
     * 入职日期
     */
    @ExcelProperty(value = "入职日期")
    private Date entryDate;

    /**
     * 是否删除 0-否 1-是
     */
    @ExcelProperty(value = "是否删除 0-否 1-是")
    private Long delFlag;


}
