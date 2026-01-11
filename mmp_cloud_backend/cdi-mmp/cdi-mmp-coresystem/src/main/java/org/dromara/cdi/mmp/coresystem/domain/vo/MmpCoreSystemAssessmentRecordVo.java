package org.dromara.cdi.mmp.coresystem.domain.vo;

import java.util.Date;

import org.dromara.cdi.mmp.coresystem.domain.MmpCoreSystemAssessmentRecord;
import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;


/**
 * 制度考核记录视图对象 mmp_core_system_assessment_record
 *
 * @author Lion Li
 * @date 2025-12-26
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpCoreSystemAssessmentRecord.class)
public class MmpCoreSystemAssessmentRecordVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 制度名称
     */
    @ExcelProperty(value = "制度名称")
    private String systemName;

    /**
     * 考核人名称
     */
    @ExcelProperty(value = "考核人名称")
    private String assessorName;

    /**
     * 考核时间
     */
    @ExcelProperty(value = "考核时间")
    private Date assessmentTime;

    /**
     * 考核周期(monthly:月度,quarterly:季度,half-yearly:半年度,yearly:年度)
     */
    @ExcelProperty(value = "考核周期(monthly:月度,quarterly:季度,half-yearly:半年度,yearly:年度)")
    private String assessmentCycle;

    /**
     * 考核分数
     */
    @ExcelProperty(value = "考核分数")
    private Long assessmentScore;

    /**
     * 考核等级(A:优秀,B:良好,C:合格,D:不合格)
     */
    @ExcelProperty(value = "考核等级(A:优秀,B:良好,C:合格,D:不合格)")
    private String assessmentGrade;

    /**
     * 考核结果
     */
    @ExcelProperty(value = "考核结果")
    private String assessmentResult;

    /**
     * 考核意见
     */
    @ExcelProperty(value = "考核意见")
    private String assessmentOpinion;

    /**
     * 删除标志(0:未删除,1:已删除)
     */
    @ExcelProperty(value = "删除标志(0:未删除,1:已删除)")
    private Long delFlag;


}
