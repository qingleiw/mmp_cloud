package org.dromara.cdi.mmp.doctor.domain.bo;

import org.dromara.cdi.mmp.doctor.domain.MmpDoctorEthicsEvaluation;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;

/**
 * 医德医风考评业务对象 mmp_doctor_ethics_evaluation
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpDoctorEthicsEvaluation.class, reverseConvertGenerate = false)
public class MmpDoctorEthicsEvaluationBo extends BaseEntity {

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
     * 考评年度
     */
    private Long evaluationYear;

    /**
     * 考评周期
     */
    private String evaluationCycle;

    /**
     * 自评得分
     */
    private Long selfScore;

    /**
     * 同行评议得分
     */
    private Long peerScore;

    /**
     * 患者评价得分
     */
    private Long patientScore;

    /**
     * 科室评价得分
     */
    private Long departmentScore;

    /**
     * 医院评价得分
     */
    private Long hospitalScore;

    /**
     * 总分
     */
    private Long totalScore;

    /**
     * 考评结果 优秀/良好/合格/不合格
     */
    private String evaluationResult;

    /**
     * 奖惩情况
     */
    private String rewardPunishment;

    /**
     * 考评意见
     */
    private String remark;

    /**
     * 是否删除
     */
    private Long delFlag;


}
