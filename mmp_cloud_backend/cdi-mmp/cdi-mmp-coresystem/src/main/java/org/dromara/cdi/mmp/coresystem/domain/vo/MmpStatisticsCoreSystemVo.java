package org.dromara.cdi.mmp.coresystem.domain.vo;

import java.util.Date;

import org.dromara.cdi.mmp.coresystem.domain.MmpStatisticsCoreSystem;
import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;


/**
 * 核心制度落实情况监测视图对象 mmp_statistics_core_system
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpStatisticsCoreSystem.class)
public class MmpStatisticsCoreSystemVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 制度编码
     */
    @ExcelProperty(value = "制度编码")
    private String systemCode;

    /**
     * 制度名称
     */
    @ExcelProperty(value = "制度名称")
    private String systemName;

    /**
     * 执行部门
     */
    @ExcelProperty(value = "执行部门")
    private String department;

    /**
     * 监测日期
     */
    @ExcelProperty(value = "监测日期")
    private Date monitoringDate;

    /**
     * 落实率
     */
    @ExcelProperty(value = "落实率")
    private Long complianceRate;

    /**
     * 执行次数
     */
    @ExcelProperty(value = "执行次数")
    private Long executionCount;

    /**
     * 合格次数
     */
    @ExcelProperty(value = "合格次数")
    private Long qualifiedCount;

    /**
     * 发现问题
     */
    @ExcelProperty(value = "发现问题")
    private String issuesFound;

    /**
     * 改进措施
     */
    @ExcelProperty(value = "改进措施")
    private String improvementMeasures;

    /**
     * 下次监测日期
     */
    @ExcelProperty(value = "下次监测日期")
    private Date nextMonitoringDate;

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
