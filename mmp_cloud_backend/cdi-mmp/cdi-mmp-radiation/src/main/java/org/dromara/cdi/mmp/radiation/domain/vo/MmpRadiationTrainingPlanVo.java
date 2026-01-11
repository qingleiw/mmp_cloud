package org.dromara.cdi.mmp.radiation.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.cdi.mmp.radiation.domain.MmpRadiationTrainingPlan;
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
 * 职业健康培训计划视图对象 mmp_radiation_training_plan
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpRadiationTrainingPlan.class)
public class MmpRadiationTrainingPlanVo implements Serializable {

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
     * 培训类型：radiation-放射防护，safety-安全培训，emergency-应急培训
     */
    @ExcelProperty(value = "培训类型：radiation-放射防护，safety-安全培训，emergency-应急培训")
    private String trainingType;

    /**
     * 计划日期
     */
    @ExcelProperty(value = "计划日期")
    private Date plannedDate;

    /**
     * 计划时间
     */
    @ExcelProperty(value = "计划时间")
    private Date plannedTime;

    /**
     * 培训地点
     */
    @ExcelProperty(value = "培训地点")
    private String location;

    /**
     * 培训师
     */
    @ExcelProperty(value = "培训师")
    private String trainer;

    /**
     * 培训内容
     */
    @ExcelProperty(value = "培训内容")
    private String trainingContent;

    /**
     * 培训对象
     */
    @ExcelProperty(value = "培训对象")
    private String targetAudience;

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
