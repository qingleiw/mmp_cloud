package org.dromara.cdi.mmp.doctor.domain.vo;

import java.util.Date;

import org.dromara.cdi.mmp.doctor.domain.MmpDoctorAbilityAssessment;
import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;


/**
 * 医师能力评估视图对象 mmp_doctor_ability_assessment
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpDoctorAbilityAssessment.class)
public class MmpDoctorAbilityAssessmentVo implements Serializable {

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
     * 评估年度
     */
    @ExcelProperty(value = "评估年度")
    private Long assessmentYear;

    /**
     * 评估类型
     */
    @ExcelProperty(value = "评估类型")
    private String assessmentType;

    /**
     * 临床能力得分
     */
    @ExcelProperty(value = "临床能力得分")
    private Long clinicalAbilityScore;

    /**
     * 教学能力得分
     */
    @ExcelProperty(value = "教学能力得分")
    private Long teachingAbilityScore;

    /**
     * 科研能力得分
     */
    @ExcelProperty(value = "科研能力得分")
    private Long researchAbilityScore;

    /**
     * 管理能力得分
     */
    @ExcelProperty(value = "管理能力得分")
    private Long managementAbilityScore;

    /**
     * 总分
     */
    @ExcelProperty(value = "总分")
    private Long totalScore;

    /**
     * 评估结果 优秀/良好/合格/不合格
     */
    @ExcelProperty(value = "评估结果 优秀/良好/合格/不合格")
    private String assessmentResult;

    /**
     * 评估人
     */
    @ExcelProperty(value = "评估人")
    private String assessor;

    /**
     * 评估日期
     */
    @ExcelProperty(value = "评估日期")
    private Date assessmentDate;

    /**
     * 评估意见
     */
    @ExcelProperty(value = "评估意见")
    private String remark;

    /**
     * 是否删除
     */
    @ExcelProperty(value = "是否删除")
    private Long delFlag;


}
