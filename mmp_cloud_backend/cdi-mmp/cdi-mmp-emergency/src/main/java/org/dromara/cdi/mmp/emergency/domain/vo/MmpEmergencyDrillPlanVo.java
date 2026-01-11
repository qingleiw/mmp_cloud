package org.dromara.cdi.mmp.emergency.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.cdi.mmp.emergency.domain.MmpEmergencyDrillPlan;
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
 * 应急演练计划视图对象 mmp_emergency_drill_plan
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpEmergencyDrillPlan.class)
public class MmpEmergencyDrillPlanVo implements Serializable {

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
     * 演练类型
     */
    @ExcelProperty(value = "演练类型")
    private String drillType;

    /**
     * 演练场景
     */
    @ExcelProperty(value = "演练场景")
    private String drillScenario;

    /**
     * 计划日期
     */
    @ExcelProperty(value = "计划日期")
    private Date plannedDate;

    /**
     * 实际日期
     */
    @ExcelProperty(value = "实际日期")
    private Date actualDate;

    /**
     * 演练地点
     */
    @ExcelProperty(value = "演练地点")
    private String location;

    /**
     * 组织者
     */
    @ExcelProperty(value = "组织者")
    private String organizer;

    /**
     * 参与人员
     */
    @ExcelProperty(value = "参与人员")
    private String participants;

    /**
     * 演练目标
     */
    @ExcelProperty(value = "演练目标")
    private String objectives;

    /**
     * 演练流程
     */
    @ExcelProperty(value = "演练流程")
    private String procedures;

    /**
     * 评估标准
     */
    @ExcelProperty(value = "评估标准")
    private String evaluationCriteria;

    /**
     * 状态：planned-已计划，executing-执行中，completed-已完成
     */
    @ExcelProperty(value = "状态：planned-已计划，executing-执行中，completed-已完成")
    private String status;

    /**
     * 演练结果
     */
    @ExcelProperty(value = "演练结果")
    private String drillResult;

    /**
     * 经验教训
     */
    @ExcelProperty(value = "经验教训")
    private String lessonsLearned;

    /**
     * 备注
     */
    @ExcelProperty(value = "备注")
    private String remark;


}
