package org.dromara.cdi.mmp.doctor.domain.bo;

import org.dromara.cdi.mmp.doctor.domain.MmpDoctorProfessionalRating;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;

/**
 * 医师职业评分业务对象 mmp_doctor_professional_rating
 *
 * @author Lion Li
 * @date 2025-12-26
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpDoctorProfessionalRating.class, reverseConvertGenerate = false)
public class MmpDoctorProfessionalRatingBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 医师ID
     */
    @NotNull(message = "医师ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long doctorId;

    /**
     * 医师姓名
     */
    @NotBlank(message = "医师姓名不能为空", groups = { AddGroup.class, EditGroup.class })
    private String doctorName;

    /**
     * 评分年份
     */
    @NotNull(message = "评分年份不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long ratingYear;

    /**
     * 评分季度
     */
    @NotNull(message = "评分季度不能为空", groups = { AddGroup.class, EditGroup.class })
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
    @NotNull(message = "最终得分不能为空", groups = { AddGroup.class, EditGroup.class })
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
