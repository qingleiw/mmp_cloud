package org.dromara.cdi.mmp.exam.domain.vo;

import org.dromara.cdi.mmp.exam.domain.MmpQualificationExamQuestion;
import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import org.dromara.common.excel.annotation.ExcelDictFormat;
import org.dromara.common.excel.convert.ExcelDictConvert;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;



/**
 * 资质考核题库视图对象 mmp_qualification_exam_question
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpQualificationExamQuestion.class)
public class MmpQualificationExamQuestionVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @ExcelProperty(value = "主键ID")
    private Long id;

    /**
     * 题目编号
     */
    @ExcelProperty(value = "题目编号")
    private String questionCode;

    /**
     * 关联资质ID
     */
    @ExcelProperty(value = "关联资质ID")
    private Long qualificationId;

    /**
     * 题型 单选/多选/判断/简答
     */
    @ExcelProperty(value = "题型 单选/多选/判断/简答")
    private String questionType;

    /**
     * 题目内容
     */
    @ExcelProperty(value = "题目内容")
    private String questionContent;

    /**
     * 选项A
     */
    @ExcelProperty(value = "选项A")
    private String optionA;

    /**
     * 选项B
     */
    @ExcelProperty(value = "选项B")
    private String optionB;

    /**
     * 选项C
     */
    @ExcelProperty(value = "选项C")
    private String optionC;

    /**
     * 选项D
     */
    @ExcelProperty(value = "选项D")
    private String optionD;

    /**
     * 选项E
     */
    @ExcelProperty(value = "选项E")
    private String optionE;

    /**
     * 正确答案
     */
    @ExcelProperty(value = "正确答案")
    private String correctAnswer;

    /**
     * 答案解析
     */
    @ExcelProperty(value = "答案解析")
    private String answerAnalysis;

    /**
     * 难度级别 1-易 2-中 3-难
     */
    @ExcelProperty(value = "难度级别 1-易 2-中 3-难")
    private Long difficultyLevel;

    /**
     * 分值
     */
    @ExcelProperty(value = "分值")
    private Long score;

    /**
     * 是否启用
     */
    @ExcelProperty(value = "是否启用")
    private Long isEnabled;

    /**
     * 是否删除
     */
    @ExcelProperty(value = "是否删除")
    private Long delFlag;


}
