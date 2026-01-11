package org.dromara.cdi.mmp.doctor.domain.bo;

import org.dromara.cdi.mmp.doctor.domain.MmpDoctorAbilityAssessment;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;
import java.util.Date;

/**
 * 医师能力评估业务对象 mmp_doctor_ability_assessment
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpDoctorAbilityAssessment.class, reverseConvertGenerate = false)
public class MmpDoctorAbilityAssessmentBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 医生ID
     */
    @NotNull(message = "医生ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long doctorId;

    /**
     * 评估年度
     */
    private Long assessmentYear;

    /**
     * 评估类型
     */
    private String assessmentType;

    /**
     * 临床能力得分
     */
    private Long clinicalAbilityScore;

    /**
     * 教学能力得分
     */
    private Long teachingAbilityScore;

    /**
     * 科研能力得分
     */
    private Long researchAbilityScore;

    /**
     * 管理能力得分
     */
    private Long managementAbilityScore;

    /**
     * 总分
     */
    private Long totalScore;

    /**
     * 评估结果 优秀/良好/合格/不合格
     */
    private String assessmentResult;

    /**
     * 评估人
     */
    private String assessor;

    /**
     * 评估日期
     */
    private Date assessmentDate;

    /**
     * 评估意见
     */
    private String remark;

    /**
     * 是否删除
     */
    private Long delFlag;


}
