package org.dromara.cdi.mmp.doctor.domain;

import org.dromara.common.mybatis.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;

/**
 * 医师能力评估对象 mmp_doctor_ability_assessment
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_doctor_ability_assessment")
public class MmpDoctorAbilityAssessment extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 医生ID
     */
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
