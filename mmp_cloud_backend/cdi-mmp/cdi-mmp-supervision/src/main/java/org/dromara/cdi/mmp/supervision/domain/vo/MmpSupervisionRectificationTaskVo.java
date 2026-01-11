package org.dromara.cdi.mmp.supervision.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.cdi.mmp.supervision.domain.MmpSupervisionRectificationTask;
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
 * 整改任务视图对象 mmp_supervision_rectification_task
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpSupervisionRectificationTask.class)
public class MmpSupervisionRectificationTaskVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 任务描述
     */
    @ExcelProperty(value = "任务描述")
    private String taskDescription;

    /**
     * 责任部门
     */
    @ExcelProperty(value = "责任部门")
    private String responsibleDept;

    /**
     * 责任人
     */
    @ExcelProperty(value = "责任人")
    private String responsiblePerson;

    /**
     * 截止日期
     */
    @ExcelProperty(value = "截止日期")
    private Date deadline;

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
