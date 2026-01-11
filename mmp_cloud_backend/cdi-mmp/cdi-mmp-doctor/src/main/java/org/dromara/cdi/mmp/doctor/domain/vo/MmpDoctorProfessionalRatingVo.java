package org.dromara.cdi.mmp.doctor.domain.vo;

import org.dromara.cdi.mmp.doctor.domain.MmpDoctorProfessionalRating;
import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import org.dromara.common.excel.annotation.ExcelDictFormat;
import org.dromara.common.excel.convert.ExcelDictConvert;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;


/**
 * 医师职业评分视图对象 mmp_doctor_professional_rating
 *
 * @author Lion Li
 * @date 2025-12-26
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpDoctorProfessionalRating.class)
public class MmpDoctorProfessionalRatingVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 医师ID
     */
    @ExcelProperty(value = "医师ID")
    private Long doctorId;

    /**
     * 医师姓名
     */
    @ExcelProperty(value = "医师姓名")
    private String doctorName;

    /**
     * 评分年份
     */
    @ExcelProperty(value = "评分年份")
    private Long ratingYear;

    /**
     * 评分季度
     */
    @ExcelProperty(value = "评分季度")
    private Long ratingQuarter;

    /**
     * 基础分数
     */
    @ExcelProperty(value = "基础分数")
    private Long baseScore;

    /**
     * 投诉扣分
     */
    @ExcelProperty(value = "投诉扣分")
    private Long complaintDeduction;

    /**
     * 医疗质量评分
     */
    @ExcelProperty(value = "医疗质量评分")
    private Long medicalQualityScore;

    /**
     * 患者满意度
     */
    @ExcelProperty(value = "患者满意度")
    private Long patientSatisfaction;

    /**
     * 最终得分
     */
    @ExcelProperty(value = "最终得分")
    private Long finalScore;

    /**
     * 评分等级
     */
    @ExcelProperty(value = "评分等级")
    private String ratingLevel;

    /**
     * 删除标志（0代表存在 1代表删除）
     */
    @ExcelProperty(value = "删除标志", converter = ExcelDictConvert.class)
    @ExcelDictFormat(readConverterExp = "0=代表存在,1=代表删除")
    private String delFlag;


}
