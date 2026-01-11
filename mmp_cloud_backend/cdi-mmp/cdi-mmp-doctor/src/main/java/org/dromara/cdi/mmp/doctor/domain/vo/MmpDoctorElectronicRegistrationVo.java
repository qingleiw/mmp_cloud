package org.dromara.cdi.mmp.doctor.domain.vo;

import java.util.Date;

import org.dromara.cdi.mmp.doctor.domain.MmpDoctorElectronicRegistration;
import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;


/**
 * 医师电子化注册视图对象 mmp_doctor_electronic_registration
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpDoctorElectronicRegistration.class)
public class MmpDoctorElectronicRegistrationVo implements Serializable {

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
     * 注册编号
     */
    @ExcelProperty(value = "注册编号")
    private String registrationNo;

    /**
     * 注册类型 首次注册/变更注册/多机构备案
     */
    @ExcelProperty(value = "注册类型 首次注册/变更注册/多机构备案")
    private String registrationType;

    /**
     * 执业类别
     */
    @ExcelProperty(value = "执业类别")
    private String practiceCategory;

    /**
     * 执业范围
     */
    @ExcelProperty(value = "执业范围")
    private String practiceScope;

    /**
     * 执业地点
     */
    @ExcelProperty(value = "执业地点")
    private String practiceLocation;

    /**
     * 发证日期
     */
    @ExcelProperty(value = "发证日期")
    private Date issueDate;

    /**
     * 有效期至
     */
    @ExcelProperty(value = "有效期至")
    private Date validDate;

    /**
     * 注册机关
     */
    @ExcelProperty(value = "注册机关")
    private String registrationAuthority;

    /**
     * 注册状态 有效/注销/吊销
     */
    @ExcelProperty(value = "注册状态 有效/注销/吊销")
    private String registrationStatus;

    /**
     * 是否多机构备案 1-是 0-否
     */
    @ExcelProperty(value = "是否多机构备案 1-是 0-否")
    private Long multiInstitutionFlag;

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
