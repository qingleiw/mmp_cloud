package org.dromara.cdi.mmp.exam.domain.bo;

import org.dromara.cdi.mmp.exam.domain.MmpExamQuestion;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;

/**
 * 资质考核题库业务对象 mmp_exam_question
 *
 * @author LionLi
 * @date 2026-01-18
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpExamQuestion.class, reverseConvertGenerate = false)
public class MmpExamQuestionBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 题目编号
     */
    private String questionCode;

    /**
     * 关联资质ID
     */
    private Long qualificationId;

    /**
     * 题型 单选/多选/判断/简答
     */
    private String questionType;

    /**
     * 题目内容
     */
    private String questionContent;

    /**
     * 选项A
     */
    private String optionA;

    /**
     * 选项B
     */
    private String optionB;

    /**
     * 选项C
     */
    private String optionC;

    /**
     * 选项D
     */
    private String optionD;

    /**
     * 选项E
     */
    private String optionE;

    /**
     * 正确答案
     */
    private String correctAnswer;

    /**
     * 答案解析
     */
    private String answerAnalysis;

    /**
     * 难度级别 1-易 2-中 3-难
     */
    private Long difficultyLevel;

    /**
     * 分值
     */
    private Long score;

    /**
     * 是否启用
     */
    private Long isEnabled;

    /**
     * 备注
     */
    private String remark;


}
