package org.dromara.cdi.mmp.ntp.domain;

import org.dromara.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;

/**
 * 项目考核评估对象 mmp_new_technology_project_assessment
 *
 * @author Lion Li
 * @date 2026-01-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_new_technology_project_assessment")
public class MmpNewTechnologyProjectAssessment extends TenantEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 项目ID
     */
    private Long projectId;

    /**
     * 考核年份
     */
    private Long assessmentYear;

    /**
     * 考核类型：midterm-中期考核，final-结题考核，annual-年度考核
     */
    private String assessmentType;

    /**
     * 考核日期
     */
    private Date assessmentDate;

    /**
     * 考核人
     */
    private String assessor;

    /**
     * 考核结果：excellent-优秀，good-良好，qualified-合格，unqualified-不合格
     */
    private String assessmentResult;

    /**
     * 评分
     */
    private Long score;

    /**
     * 考核意见
     */
    private String assessmentOpinion;

    /**
     * 改进措施
     */
    private String improvementMeasures;

    /**
     * 状态
     */
    private String status;

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
