package org.dromara.cdi.mmp.ntp.domain;

import org.dromara.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;

/**
 * 新技术进展报告对象 mmp_new_technology_project_progress
 *
 * @author Lion Li
 * @date 2026-01-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_new_technology_project_progress")
public class MmpNewTechnologyProjectProgress extends TenantEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 报告编号
     */
    private String reportNo;

    /**
     * 项目ID
     */
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
     * 是否删除
     */
    @TableLogic
    private String delFlag;

    /**
     * 备注
     */
    private String remark;


}
