package org.dromara.cdi.mmp.qc.domain.vo;

import org.dromara.cdi.mmp.qc.domain.MmpQcScoringRule;
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
 * 评分规则视图对象 mmp_qc_scoring_rule
 *
 * @author Lion Li
 * @date 2025-12-30
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpQcScoringRule.class)
public class MmpQcScoringRuleVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 规则类型：range-区间，threshold-阈值
     */
    @ExcelProperty(value = "规则类型：range-区间，threshold-阈值")
    private String ruleType;

    /**
     * 最小值
     */
    @ExcelProperty(value = "最小值")
    private Long minValue;

    /**
     * 最大值
     */
    @ExcelProperty(value = "最大值")
    private Long maxValue;

    /**
     * 得分
     */
    @ExcelProperty(value = "得分")
    private Long score;

    /**
     * 得分率
     */
    @ExcelProperty(value = "得分率")
    private Long scoreRate;

    /**
     * 规则描述
     */
    @ExcelProperty(value = "规则描述")
    private String description;

    /**
     * 排序
     */
    @ExcelProperty(value = "排序")
    private Long sortOrder;

    /**
     * 状态
     */
    @ExcelProperty(value = "状态")
    private Long status;

    /**
     * 是否删除
     */
    @ExcelProperty(value = "是否删除")
    private Long delFlag;


}
