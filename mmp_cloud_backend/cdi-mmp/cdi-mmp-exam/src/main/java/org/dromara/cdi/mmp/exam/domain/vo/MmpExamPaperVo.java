package org.dromara.cdi.mmp.exam.domain.vo;

import org.dromara.cdi.mmp.exam.domain.MmpExamPaper;
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
 * 资质考核试卷视图对象 mmp_exam_paper
 *
 * @author LionLi
 * @date 2026-01-18
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpExamPaper.class)
public class MmpExamPaperVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @ExcelProperty(value = "主键ID")
    private Long id;

    /**
     * 试卷编号
     */
    @ExcelProperty(value = "试卷编号")
    private String paperCode;

    /**
     * 试卷名称
     */
    @ExcelProperty(value = "试卷名称")
    private String paperName;

    /**
     * 关联资质ID
     */
    @ExcelProperty(value = "关联资质ID")
    private Long qualificationId;

    /**
     * 总分
     */
    @ExcelProperty(value = "总分")
    private Long totalScore;

    /**
     * 及格分
     */
    @ExcelProperty(value = "及格分")
    private Long passScore;

    /**
     * 考试时长(分钟)
     */
    @ExcelProperty(value = "考试时长(分钟)")
    private Long examDuration;

    /**
     * 题目ID列表JSON
     */
    @ExcelProperty(value = "题目ID列表JSON")
    private String questionIds;

    /**
     * 是否随机抽题 1-是 0-否
     */
    @ExcelProperty(value = "是否随机抽题 1-是 0-否")
    private Long isRandom;

    /**
     * 随机规则JSON
     */
    @ExcelProperty(value = "随机规则JSON")
    private String randomRule;

    /**
     * 是否启用
     */
    @ExcelProperty(value = "是否启用")
    private Long isEnabled;

    /**
     * 备注
     */
    @ExcelProperty(value = "备注")
    private String remark;


}
