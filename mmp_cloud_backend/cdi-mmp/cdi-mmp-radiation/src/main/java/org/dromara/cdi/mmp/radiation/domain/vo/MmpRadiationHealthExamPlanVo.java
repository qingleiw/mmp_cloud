package org.dromara.cdi.mmp.radiation.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.cdi.mmp.radiation.domain.MmpRadiationHealthExamPlan;
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
 * 职业健康体检计划视图对象 mmp_radiation_health_exam_plan
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpRadiationHealthExamPlan.class)
public class MmpRadiationHealthExamPlanVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 计划编码
     */
    @ExcelProperty(value = "计划编码")
    private String planCode;

    /**
     * 计划名称
     */
    @ExcelProperty(value = "计划名称")
    private String planName;

    /**
     * 体检类型：annual-年度体检，special-专项体检
     */
    @ExcelProperty(value = "体检类型：annual-年度体检，special-专项体检")
    private String examType;

    /**
     * 计划日期
     */
    @ExcelProperty(value = "计划日期")
    private Date plannedDate;

    /**
     * 体检地点
     */
    @ExcelProperty(value = "体检地点")
    private String location;

    /**
     * 体检机构
     */
    @ExcelProperty(value = "体检机构")
    private String examAgency;

    /**
     * 体检对象
     */
    @ExcelProperty(value = "体检对象")
    private String targetStaff;

    /**
     * 状态：planned-已计划，ongoing-进行中，completed-已完成，cancelled-已取消
     */
    @ExcelProperty(value = "状态：planned-已计划，ongoing-进行中，completed-已完成，cancelled-已取消")
    private String status;

    /**
     * 是否已发送提醒：0-否，1-是
     */
    @ExcelProperty(value = "是否已发送提醒：0-否，1-是")
    private String reminderSent;

    /**
     * 提醒时间
     */
    @ExcelProperty(value = "提醒时间")
    private Date reminderTime;

    /**
     * 备注
     */
    @ExcelProperty(value = "备注")
    private String remark;


}
