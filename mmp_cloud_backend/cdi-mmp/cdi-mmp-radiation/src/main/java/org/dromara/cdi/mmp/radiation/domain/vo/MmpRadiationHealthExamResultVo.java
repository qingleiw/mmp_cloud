package org.dromara.cdi.mmp.radiation.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.cdi.mmp.radiation.domain.MmpRadiationHealthExamResult;
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
 * 体检结果记录视图对象 mmp_radiation_health_exam_result
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpRadiationHealthExamResult.class)
public class MmpRadiationHealthExamResultVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 工作人员姓名
     */
    @ExcelProperty(value = "工作人员姓名")
    private String staffName;

    /**
     * 体检日期
     */
    @ExcelProperty(value = "体检日期")
    private Date examDate;

    /**
     * 体检结果：normal-正常，abnormal-异常
     */
    @ExcelProperty(value = "体检结果：normal-正常，abnormal-异常")
    private String examResult;

    /**
     * 体检报告文件路径
     */
    @ExcelProperty(value = "体检报告文件路径")
    private String examReportFile;

    /**
     * 体检报告文件名
     */
    @ExcelProperty(value = "体检报告文件名")
    private String examReportName;

    /**
     * 主要发现
     */
    @ExcelProperty(value = "主要发现")
    private String keyFindings;

    /**
     * 建议措施
     */
    @ExcelProperty(value = "建议措施")
    private String recommendations;

    /**
     * 是否需要随访：0-否，1-是
     */
    @ExcelProperty(value = "是否需要随访：0-否，1-是")
    private String followUpRequired;

    /**
     * 随访日期
     */
    @ExcelProperty(value = "随访日期")
    private Date followUpDate;

    /**
     * 备注
     */
    @ExcelProperty(value = "备注")
    private String remark;


}
