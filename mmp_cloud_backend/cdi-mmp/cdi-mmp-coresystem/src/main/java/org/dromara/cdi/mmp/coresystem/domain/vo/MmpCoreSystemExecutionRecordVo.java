package org.dromara.cdi.mmp.coresystem.domain.vo;

import java.util.Date;

import org.dromara.cdi.mmp.coresystem.domain.MmpCoreSystemExecutionRecord;
import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;


/**
 * 制度执行记录视图对象 mmp_core_system_execution_record
 *
 * @author Lion Li
 * @date 2025-12-26
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpCoreSystemExecutionRecord.class)
public class MmpCoreSystemExecutionRecordVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 执行ID
     */
    @ExcelProperty(value = "执行ID")
    private Long id;

    /**
     * 制度名称
     */
    @ExcelProperty(value = "制度名称")
    private String systemName;

    /**
     * 执行人姓名
     */
    @ExcelProperty(value = "执行人姓名")
    private String executorName;

    /**
     * 执行时间
     */
    @ExcelProperty(value = "执行时间")
    private Date executionTime;

    /**
     * 执行结果 1-成功 0-失败
     */
    @ExcelProperty(value = "执行结果 1-成功 0-失败")
    private String executionResult;

    /**
     * 备注
     */
    @ExcelProperty(value = "备注")
    private String remark;

    /**
     * 是否删除 0-未删除 1-已删除
     */
    @ExcelProperty(value = "是否删除 0-未删除 1-已删除")
    private String delFlag;


}
