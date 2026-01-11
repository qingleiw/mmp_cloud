package org.dromara.cdi.mmp.doctor.domain.vo;

import java.util.Date;

import org.dromara.cdi.mmp.doctor.domain.MmpDoctorInsuranceCode;
import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;


/**
 * 医保医师码视图对象 mmp_doctor_insurance_code
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpDoctorInsuranceCode.class)
public class MmpDoctorInsuranceCodeVo implements Serializable {

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
     * 医保医师码
     */
    @ExcelProperty(value = "医保医师码")
    private String insuranceCode;

    /**
     * 医保类型 职工医保/居民医保/生育保险
     */
    @ExcelProperty(value = "医保类型 职工医保/居民医保/生育保险")
    private String insuranceType;

    /**
     * 有效期至
     */
    @ExcelProperty(value = "有效期至")
    private Date validDate;

    /**
     * 状态 有效/暂停/注销
     */
    @ExcelProperty(value = "状态 有效/暂停/注销")
    private String status;

    /**
     * 申请日期
     */
    @ExcelProperty(value = "申请日期")
    private Date applyDate;

    /**
     * 审批日期
     */
    @ExcelProperty(value = "审批日期")
    private Date approveDate;

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
