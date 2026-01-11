package org.dromara.cdi.mmp.doctor.domain.vo;

import java.util.Date;

import org.dromara.cdi.mmp.doctor.domain.MmpDoctorHonor;
import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;


/**
 * 荣誉奖励视图对象 mmp_doctor_honor
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpDoctorHonor.class)
public class MmpDoctorHonorVo implements Serializable {

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
     * 荣誉名称
     */
    @ExcelProperty(value = "荣誉名称")
    private String honorName;

    /**
     * 荣誉级别 国家级/省级/市级/院级
     */
    @ExcelProperty(value = "荣誉级别 国家级/省级/市级/院级")
    private String honorLevel;

    /**
     * 授予单位
     */
    @ExcelProperty(value = "授予单位")
    private String awardUnit;

    /**
     * 获得日期
     */
    @ExcelProperty(value = "获得日期")
    private Date awardDate;

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
