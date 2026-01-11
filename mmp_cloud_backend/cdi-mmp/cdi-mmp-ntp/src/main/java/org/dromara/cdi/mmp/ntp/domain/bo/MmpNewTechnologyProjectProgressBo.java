package org.dromara.cdi.mmp.ntp.domain.bo;

import org.dromara.cdi.mmp.ntp.domain.MmpNewTechnologyProjectProgress;
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
 * 新技术进展报告业务对象 mmp_new_technology_project_progress
 *
 * @author Lion Li
 * @date 2026-01-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpNewTechnologyProjectProgress.class, reverseConvertGenerate = false)
public class MmpNewTechnologyProjectProgressBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 报告编号
     */
    @NotBlank(message = "报告编号不能为空", groups = { AddGroup.class, EditGroup.class })
    private String reportNo;

    /**
     * 项目ID
     */
    @NotNull(message = "项目ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long projectId;

    /**
     * 报告类型 进展报告/结题报告
     */
    private String reportType;

    /**
     * 报告期间
     */
    private String reportPeriod;

    /**
     * 报告日期
     */
    private Date reportDate;

    /**
     * 开展病例数
     */
    private Long caseCount;

    /**
     * 成功病例数
     */
    private Long successCount;

    /**
     * 并发症例数
     */
    private Long complicationCount;

    /**
     * 不良反应例数
     */
    private Long adverseReactionCount;

    /**
     * 死亡例数
     */
    private Long mortalityCount;

    /**
     * 效果评价
     */
    private String effectEvaluation;

    /**
     * 存在问题
     */
    private String existingProblems;

    /**
     * 改进措施
     */
    private String improvementMeasures;

    /**
     * 下步计划
     */
    private String nextPlan;

    /**
     * 继续状态 继续开展/终止/暂停
     */
    private String continueStatus;

    /**
     * 运行监测指标JSON
     */
    private String monitoringIndicators;

    /**
     * 附件URLs
     */
    private String attachmentUrls;

    /**
     * 报告状态
     */
    private String reportStatus;

    /**
     * 工作流实例ID
     */
    private Long workflowInstanceId;

    /**
     * 备注
     */
    private String remark;


}
