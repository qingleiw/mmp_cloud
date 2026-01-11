package org.dromara.cdi.mmp.emergency.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.cdi.mmp.emergency.domain.MmpEmergencyDrillSummary;
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
 * 应急演练总结视图对象 mmp_emergency_drill_summary
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpEmergencyDrillSummary.class)
public class MmpEmergencyDrillSummaryVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 实际开始时间
     */
    @ExcelProperty(value = "实际开始时间")
    private Date actualStartTime;

    /**
     * 实际结束时间
     */
    @ExcelProperty(value = "实际结束时间")
    private Date actualEndTime;

    /**
     * 实际参与人数
     */
    @ExcelProperty(value = "实际参与人数")
    private Long participantsCount;

    /**
     * 演练过程描述
     */
    @ExcelProperty(value = "演练过程描述")
    private String drillProcess;

    /**
     * 发现的问题
     */
    @ExcelProperty(value = "发现的问题")
    private String problemsFound;

    /**
     * 经验教训
     */
    @ExcelProperty(value = "经验教训")
    private String lessonsLearned;

    /**
     * 改进措施
     */
    @ExcelProperty(value = "改进措施")
    private String improvementMeasures;

    /**
     * 评价分数
     */
    @ExcelProperty(value = "评价分数")
    private Long evaluationScore;

    /**
     * 评价人姓名
     */
    @ExcelProperty(value = "评价人姓名")
    private String evaluatorName;

    /**
     * 评价时间
     */
    @ExcelProperty(value = "评价时间")
    private Date evaluationTime;

    /**
     * 备注
     */
    @ExcelProperty(value = "备注")
    private String remark;


}
