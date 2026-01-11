package org.dromara.cdi.mmp.ntp.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.cdi.mmp.ntp.domain.MmpNewTechnologyProjectAssessment;
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
 * 项目考核评估视图对象 mmp_new_technology_project_assessment
 *
 * @author Lion Li
 * @date 2026-01-07
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpNewTechnologyProjectAssessment.class)
public class MmpNewTechnologyProjectAssessmentVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 考核年份
     */
    @ExcelProperty(value = "考核年份")
    private Long assessmentYear;

    /**
     * 考核类型：midterm-中期考核，final-结题考核，annual-年度考核
     */
    @ExcelProperty(value = "考核类型：midterm-中期考核，final-结题考核，annual-年度考核")
    private String assessmentType;

    /**
     * 考核日期
     */
    @ExcelProperty(value = "考核日期")
    private Date assessmentDate;

    /**
     * 考核人
     */
    @ExcelProperty(value = "考核人")
    private String assessor;

    /**
     * 考核结果：excellent-优秀，good-良好，qualified-合格，unqualified-不合格
     */
    @ExcelProperty(value = "考核结果：excellent-优秀，good-良好，qualified-合格，unqualified-不合格")
    private String assessmentResult;

    /**
     * 评分
     */
    @ExcelProperty(value = "评分")
    private Long score;

    /**
     * 考核意见
     */
    @ExcelProperty(value = "考核意见")
    private String assessmentOpinion;

    /**
     * 改进措施
     */
    @ExcelProperty(value = "改进措施")
    private String improvementMeasures;

    /**
     * 状态
     */
    @ExcelProperty(value = "状态")
    private String status;

    /**
     * 备注
     */
    @ExcelProperty(value = "备注")
    private String remark;


}
