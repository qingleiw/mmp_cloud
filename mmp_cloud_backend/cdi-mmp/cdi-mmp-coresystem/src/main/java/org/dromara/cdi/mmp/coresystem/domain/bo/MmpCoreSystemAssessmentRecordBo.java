package org.dromara.cdi.mmp.coresystem.domain.bo;

import org.dromara.cdi.mmp.coresystem.domain.MmpCoreSystemAssessmentRecord;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;
import java.util.Date;

/**
 * 制度考核记录业务对象 mmp_core_system_assessment_record
 *
 * @author Lion Li
 * @date 2025-12-26
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpCoreSystemAssessmentRecord.class, reverseConvertGenerate = false)
public class MmpCoreSystemAssessmentRecordBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 考核ID
     */
    @NotBlank(message = "考核ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private String assessmentId;

    /**
     * 制度ID
     */
    @NotNull(message = "制度ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long systemId;

    /**
     * 制度名称
     */
    @NotBlank(message = "制度名称不能为空", groups = { AddGroup.class, EditGroup.class })
    private String systemName;

    /**
     * 考核人ID
     */
    @NotNull(message = "考核人ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long assessorId;

    /**
     * 考核人名称
     */
    @NotBlank(message = "考核人名称不能为空", groups = { AddGroup.class, EditGroup.class })
    private String assessorName;

    /**
     * 考核时间
     */
    @NotNull(message = "考核时间不能为空", groups = { AddGroup.class, EditGroup.class })
    private Date assessmentTime;

    /**
     * 考核周期(monthly:月度,quarterly:季度,half-yearly:半年度,yearly:年度)
     */
    @NotBlank(message = "考核周期(monthly:月度,quarterly:季度,half-yearly:半年度,yearly:年度)不能为空", groups = { AddGroup.class, EditGroup.class })
    private String assessmentCycle;

    /**
     * 考核分数
     */
    @NotNull(message = "考核分数不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long assessmentScore;

    /**
     * 考核等级(A:优秀,B:良好,C:合格,D:不合格)
     */
    @NotBlank(message = "考核等级(A:优秀,B:良好,C:合格,D:不合格)不能为空", groups = { AddGroup.class, EditGroup.class })
    private String assessmentGrade;

    /**
     * 考核结果
     */
    @NotBlank(message = "考核结果不能为空", groups = { AddGroup.class, EditGroup.class })
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
