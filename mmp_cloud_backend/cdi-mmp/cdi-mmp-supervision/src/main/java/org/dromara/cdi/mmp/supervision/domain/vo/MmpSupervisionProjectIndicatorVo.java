package org.dromara.cdi.mmp.supervision.domain.vo;

import org.dromara.cdi.mmp.supervision.domain.MmpSupervisionProjectIndicator;
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
 * 督查项目指标视图对象 mmp_supervision_project_indicator
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpSupervisionProjectIndicator.class)
public class MmpSupervisionProjectIndicatorVo implements Serializable {

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
     * 指标类型
     */
    @ExcelProperty(value = "指标类型")
    private String indicatorType;

    /**
     * 指标描述
     */
    @ExcelProperty(value = "指标描述")
    private String indicatorDescription;

    /**
     * 评分标准
     */
    @ExcelProperty(value = "评分标准")
    private String scoringStandard;

    /**
     * 权重
     */
    @ExcelProperty(value = "权重")
    private Long weight;

    /**
     * 满分值
     */
    @ExcelProperty(value = "满分值")
    private Long maxScore;

    /**
     * 排序
     */
    @ExcelProperty(value = "排序")
    private Long sortOrder;

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
