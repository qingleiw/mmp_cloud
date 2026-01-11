package org.dromara.cdi.mmp.emergency.domain.bo;

import org.dromara.cdi.mmp.emergency.domain.MmpEmergencyDrillSummary;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 应急演练总结业务对象 mmp_emergency_drill_summary
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpEmergencyDrillSummary.class, reverseConvertGenerate = false)
public class MmpEmergencyDrillSummaryBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 计划ID
     */
    @NotNull(message = "计划ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long planId;

    /**
     * 实际开始时间
     */
    private Date actualStartTime;

    /**
     * 实际结束时间
     */
    private Date actualEndTime;

    /**
     * 实际参与人数
     */
    private Long participantsCount;

    /**
     * 演练过程描述
     */
    private String drillProcess;

    /**
     * 发现的问题
     */
    private String problemsFound;

    /**
     * 经验教训
     */
    private String lessonsLearned;

    /**
     * 改进措施
     */
    private String improvementMeasures;

    /**
     * 评价分数
     */
    private Long evaluationScore;

    /**
     * 评价人ID
     */
    private Long evaluatorId;

    /**
     * 评价人姓名
     */
    private String evaluatorName;

    /**
     * 评价时间
     */
    private Date evaluationTime;

    /**
     * 备注
     */
    private String remark;


}
