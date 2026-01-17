package org.dromara.cdi.mmp.exam.domain;

import org.dromara.common.mybatis.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 资质考核题库对象 mmp_qualification_exam_question
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_qualification_exam_question")
public class MmpQualificationExamQuestion extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id")
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
     * 是否删除
     */
    private Long delFlag;


}
