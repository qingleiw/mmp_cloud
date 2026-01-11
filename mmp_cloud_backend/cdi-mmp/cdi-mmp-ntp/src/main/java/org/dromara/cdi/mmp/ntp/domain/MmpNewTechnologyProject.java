package org.dromara.cdi.mmp.ntp.domain;

import org.dromara.common.mybatis.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;

/**
 * 新技术项目基本信息对象 mmp_new_technology_project
 *
 * @author Lion Li
 * @date 2026-01-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_new_technology_project")
public class MmpNewTechnologyProject extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 项目编号
     */
    private String projectNo;

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 项目类型 新技术/新项目
     */
    private String projectType;

    /**
     * 技术分类
     */
    private String technologyCategory;

    /**
     * 风险等级 低风险/中风险/高风险
     */
    private String riskLevel;

    /**
     * 申请科室ID
     */
    private Long applyDepartmentId;

    /**
     * 申请科室名称
     */
    private String applyDepartmentName;

    /**
     * 项目负责人
     */
    private String projectLeader;

    /**
     * 项目团队成员
     */
    private String projectTeam;

    /**
     * 技术来源
     */
    private String technologySource;

    /**
     * 申请理由
     */
    private String applyReason;

    /**
     * 技术描述
     */
    private String technologyDescription;

    /**
     * 适应症
     */
    private String indication;

    /**
     * 禁忌症
     */
    private String contraindication;

    /**
     * 预期效果
     */
    private String expectedEffect;

    /**
     * 潜在风险
     */
    private String potentialRisk;

    /**
     * 风险控制措施
     */
    private String riskControlMeasure;

    /**
     * 文献支持
     */
    private String literatureSupport;

    /**
     * 附件URLs
     */
    private String attachmentUrls;

    /**
     * 运行周期(天)
     */
    private Long operationCycleDays;

    /**
     * 进展报告周期 月度/季度/半年度/年度
     */
    private String progressReportCycle;

    /**
     * 项目状态
     */
    private String projectStatus;

    /**
     * 批准日期
     */
    private Date approveDate;

    /**
     * 开始日期
     */
    private Date startDate;

    /**
     * 预计结束日期
     */
    private Date endDate;

    /**
     * 实际结束日期
     */
    private Date actualEndDate;

    /**
     * 结题类型 转常规/终止
     */
    private String conclusionType;

    /**
     * 工作流实例ID
     */
    private Long workflowInstanceId;

    /**
     * 删除标志（0代表存在 2代表删除）
     */
    @TableLogic
    private String delFlag;


}
