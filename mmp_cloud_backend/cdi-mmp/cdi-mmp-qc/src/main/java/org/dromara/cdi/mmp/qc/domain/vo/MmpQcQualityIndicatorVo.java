package org.dromara.cdi.mmp.qc.domain.vo;

import org.dromara.cdi.mmp.qc.domain.MmpQcQualityIndicator;
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
 * 质量指标视图对象 mmp_qc_quality_indicator
 *
 * @author Lion Li
 * @date 2025-12-30
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpQcQualityIndicator.class)
public class MmpQcQualityIndicatorVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 指标编码
     */
    @ExcelProperty(value = "指标编码")
    private String indicatorCode;

    /**
     * 指标名称
     */
    @ExcelProperty(value = "指标名称")
    private String indicatorName;

    /**
     * 指标层级
     */
    @ExcelProperty(value = "指标层级")
    private Long indicatorLevel;

    /**
     * 定义
     */
    @ExcelProperty(value = "定义")
    private String definition;

    /**
     * 计算公式
     */
    @ExcelProperty(value = "计算公式")
    private String formula;

    /**
     * 意义
     */
    @ExcelProperty(value = "意义")
    private String significance;

    /**
     * 说明
     */
    @ExcelProperty(value = "说明")
    private String remark;

    /**
     * 单位
     */
    @ExcelProperty(value = "单位")
    private String unit;

    /**
     * 数据类型：rate-比率，count-计数，ratio-比值
     */
    @ExcelProperty(value = "数据类型：rate-比率，count-计数，ratio-比值")
    private String dataType;

    /**
     * 标准值
     */
    @ExcelProperty(value = "标准值")
    private Long standardValue;

    /**
     * 满分分值
     */
    @ExcelProperty(value = "满分分值")
    private Long maxScore;

    /**
     * 排序
     */
    @ExcelProperty(value = "排序")
    private Long sortOrder;

    /**
     * 状态：1-启用，0-禁用
     */
    @ExcelProperty(value = "状态：1-启用，0-禁用")
    private Long status;

    /**
     * 是否删除
     */
    @ExcelProperty(value = "是否删除")
    private Long delFlag;


}
