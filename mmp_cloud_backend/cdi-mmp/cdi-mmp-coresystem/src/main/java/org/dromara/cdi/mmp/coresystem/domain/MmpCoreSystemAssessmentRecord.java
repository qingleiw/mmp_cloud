package org.dromara.cdi.mmp.coresystem.domain;

import org.dromara.common.mybatis.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;

/**
 * 制度考核记录对象 mmp_core_system_assessment_record
 *
 * @author Lion Li
 * @date 2025-12-26
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_core_system_assessment_record")
public class MmpCoreSystemAssessmentRecord extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 考核ID
     */
    private String assessmentId;

    /**
     * 制度ID
     */
    private Long systemId;

    /**
     * 制度名称
     */
    private String systemName;

    /**
     * 考核人ID
     */
    private Long assessorId;

    /**
     * 考核人名称
     */
    private String assessorName;

    /**
     * 考核时间
     */
    private Date assessmentTime;

    /**
     * 考核周期(monthly:月度,quarterly:季度,half-yearly:半年度,yearly:年度)
     */
    private String assessmentCycle;

    /**
     * 考核分数
     */
    private Long assessmentScore;

    /**
     * 考核等级(A:优秀,B:良好,C:合格,D:不合格)
     */
    private String assessmentGrade;

    /**
     * 考核结果
     */
    private String assessmentResult;

    /**
     * 考核意见
     */
    private String assessmentOpinion;

    /**
     * 删除标志(0:未删除,1:已删除)
     */
    private Long delFlag;


}
