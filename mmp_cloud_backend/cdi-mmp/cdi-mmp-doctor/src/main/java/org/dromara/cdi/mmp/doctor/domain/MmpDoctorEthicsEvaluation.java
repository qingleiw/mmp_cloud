package org.dromara.cdi.mmp.doctor.domain;

import org.dromara.common.mybatis.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 医德医风考评对象 mmp_doctor_ethics_evaluation
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_doctor_ethics_evaluation")
public class MmpDoctorEthicsEvaluation extends BaseEntity {

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
