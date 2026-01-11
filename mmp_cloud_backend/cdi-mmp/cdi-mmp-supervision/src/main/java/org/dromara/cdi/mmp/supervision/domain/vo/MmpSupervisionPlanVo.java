package org.dromara.cdi.mmp.supervision.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.cdi.mmp.supervision.domain.MmpSupervisionPlan;
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
 * 督查计划视图对象 mmp_supervision_plan
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpSupervisionPlan.class)
public class MmpSupervisionPlanVo implements Serializable {

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
     * 计划类型
     */
    @ExcelProperty(value = "计划类型")
    private String planType;

    /**
     * 督导周期
     */
    @ExcelProperty(value = "督导周期")
    private String supervisionPeriod;

    /**
     * 开始日期
     */
    @ExcelProperty(value = "开始日期")
    private Date startDate;

    /**
     * 结束日期
     */
    @ExcelProperty(value = "结束日期")
    private Date endDate;

    /**
     * 负责人
     */
    @ExcelProperty(value = "负责人")
    private String responsiblePerson;

    /**
     * 状态：draft-草稿，published-已发布，executing-执行中，completed-已完成
     */
    @ExcelProperty(value = "状态：draft-草稿，published-已发布，executing-执行中，completed-已完成")
    private String status;

    /**
     * 备注
     */
    @ExcelProperty(value = "备注")
    private String remark;


}
