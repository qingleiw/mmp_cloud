package org.dromara.cdi.mmp.qualification.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.cdi.mmp.qualification.domain.MmpQualificationExamRecord;
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
 * 资质考试记录视图对象 mmp_qualification_exam_record
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpQualificationExamRecord.class)
public class MmpQualificationExamRecordVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @ExcelProperty(value = "主键ID")
    private Long id;

    /**
     * 考试安排ID
     */
    @ExcelProperty(value = "考试安排ID")
    private Long examId;

    /**
     * 考生ID
     */
    @ExcelProperty(value = "考生ID")
    private Long examineeId;

    /**
     * 考生姓名
     */
    @ExcelProperty(value = "考生姓名")
    private String examineeName;

    /**
     * 试卷ID
     */
    @ExcelProperty(value = "试卷ID")
    private Long paperId;

    /**
     * 开始时间
     */
    @ExcelProperty(value = "开始时间")
    private Date startTime;

    /**
     * 提交时间
     */
    @ExcelProperty(value = "提交时间")
    private Date submitTime;

    /**
     * 答题卡JSON
     */
    @ExcelProperty(value = "答题卡JSON")
    private String answerSheet;

    /**
     * 客观题得分
     */
    @ExcelProperty(value = "客观题得分")
    private Long objectiveScore;

    /**
     * 主观题得分
     */
    @ExcelProperty(value = "主观题得分")
    private Long subjectiveScore;

    /**
     * 总分
     */
    @ExcelProperty(value = "总分")
    private Long totalScore;

    /**
     * 考试结果 及格/不及格
     */
    @ExcelProperty(value = "考试结果 及格/不及格")
    private String examResult;

    /**
     * 阅卷状态
     */
    @ExcelProperty(value = "阅卷状态")
    private String markingStatus;

    /**
     * 阅卷人
     */
    @ExcelProperty(value = "阅卷人")
    private String marker;

    /**
     * 阅卷时间
     */
    @ExcelProperty(value = "阅卷时间")
    private Date markingTime;


}
