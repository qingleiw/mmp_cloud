package org.dromara.cdi.mmp.ntp.domain.bo;

import org.dromara.cdi.mmp.ntp.domain.MmpNewTechnologyProjectAssessment;
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
 * 项目考核评估业务对象 mmp_new_technology_project_assessment
 *
 * @author Lion Li
 * @date 2026-01-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpNewTechnologyProjectAssessment.class, reverseConvertGenerate = false)
public class MmpNewTechnologyProjectAssessmentBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 项目ID
     */
    @NotNull(message = "项目ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long projectId;

    /**
     * 考核年份
     */
    @NotNull(message = "考核年份不能为空", groups = { AddGroup.class, EditGroup.class })
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
     * 备注
     */
    private String remark;


}
