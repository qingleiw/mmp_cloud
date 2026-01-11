package org.dromara.cdi.mmp.qualification.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.cdi.mmp.qualification.domain.MmpQualificationExamArrangement;
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
 * 资质考试安排视图对象 mmp_qualification_exam_arrangement
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpQualificationExamArrangement.class)
public class MmpQualificationExamArrangementVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @ExcelProperty(value = "主键ID")
    private Long id;

    /**
     * 考试编号
     */
    @ExcelProperty(value = "考试编号")
    private String examCode;

    /**
     * 考试名称
     */
    @ExcelProperty(value = "考试名称")
    private String examName;

    /**
     * 试卷ID
     */
    @ExcelProperty(value = "试卷ID")
    private Long paperId;

    /**
     * 资质ID
     */
    @ExcelProperty(value = "资质ID")
    private Long qualificationId;

    /**
     * 考试开始时间
     */
    @ExcelProperty(value = "考试开始时间")
    private Date examStartTime;

    /**
     * 考试结束时间
     */
    @ExcelProperty(value = "考试结束时间")
    private Date examEndTime;

    /**
     * 考生ID列表
     */
    @ExcelProperty(value = "考生ID列表")
    private String examineeIds;

    /**
     * 考试状态 未开始/进行中/已结束
     */
    @ExcelProperty(value = "考试状态 未开始/进行中/已结束")
    private String examStatus;

    /**
     * 是否删除
     */
    @ExcelProperty(value = "是否删除")
    private Long delFlag;


}
