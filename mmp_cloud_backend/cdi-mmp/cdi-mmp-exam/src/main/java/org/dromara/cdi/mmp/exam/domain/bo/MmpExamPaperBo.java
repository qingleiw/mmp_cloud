package org.dromara.cdi.mmp.exam.domain.bo;

import org.dromara.cdi.mmp.exam.domain.MmpExamPaper;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;

/**
 * 资质考核试卷业务对象 mmp_exam_paper
 *
 * @author LionLi
 * @date 2026-01-18
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpExamPaper.class, reverseConvertGenerate = false)
public class MmpExamPaperBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 试卷编号
     */
    @NotBlank(message = "试卷编号不能为空", groups = { AddGroup.class, EditGroup.class })
    private String paperCode;

    /**
     * 试卷名称
     */
    private String paperName;

    /**
     * 关联资质ID
     */
    private Long qualificationId;

    /**
     * 总分
     */
    private Long totalScore;

    /**
     * 及格分
     */
    private Long passScore;

    /**
     * 考试时长(分钟)
     */
    private Long examDuration;

    /**
     * 题目ID列表JSON
     */
    private String questionIds;

    /**
     * 是否随机抽题 1-是 0-否
     */
    private Long isRandom;

    /**
     * 随机规则JSON
     */
    private String randomRule;

    /**
     * 是否启用
     */
    private Long isEnabled;

    /**
     * 备注
     */
    private String remark;


}
