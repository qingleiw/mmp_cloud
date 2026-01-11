package org.dromara.cdi.mmp.doctor.domain;

import org.dromara.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 医师职业评分对象 mmp_doctor_professional_rating
 *
 * @author Lion Li
 * @date 2025-12-26
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_doctor_professional_rating")
public class MmpDoctorProfessionalRating extends TenantEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 医师ID
     */
    private Long doctorId;

    /**
     * 医师姓名
     */
    private String doctorName;

    /**
     * 评分年份
     */
    private Long ratingYear;

    /**
     * 评分季度
     */
    private Long ratingQuarter;

    /**
     * 基础分数
     */
    private Long baseScore;

    /**
     * 投诉扣分
     */
    private Long complaintDeduction;

    /**
     * 医疗质量评分
     */
    private Long medicalQualityScore;

    /**
     * 患者满意度
     */
    private Long patientSatisfaction;

    /**
     * 最终得分
     */
    private Long finalScore;

    /**
     * 评分等级
     */
    private String ratingLevel;

    /**
     * 删除标志（0代表存在 1代表删除）
     */
    private String delFlag;


}
