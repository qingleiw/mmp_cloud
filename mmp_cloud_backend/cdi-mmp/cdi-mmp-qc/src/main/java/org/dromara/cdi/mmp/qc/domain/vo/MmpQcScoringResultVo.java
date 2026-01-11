package org.dromara.cdi.mmp.qc.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.cdi.mmp.qc.domain.MmpQcScoringResult;
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
 * 评分结果视图对象 mmp_qc_scoring_result
 *
 * @author Lion Li
 * @date 2025-12-30
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpQcScoringResult.class)
public class MmpQcScoringResultVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 指标值
     */
    @ExcelProperty(value = "指标值")
    private Long indicatorValue;

    /**
     * 标准值
     */
    @ExcelProperty(value = "标准值")
    private Long standardValue;

    /**
     * 满分
     */
    @ExcelProperty(value = "满分")
    private Long maxScore;

    /**
     * 实际得分
     */
    @ExcelProperty(value = "实际得分")
    private Long actualScore;

    /**
     * 得分率
     */
    @ExcelProperty(value = "得分率")
    private Long scoreRate;

    /**
     * 评价等级：excellent-优秀，good-良好，qualified-合格，unqualified-不合格
     */
    @ExcelProperty(value = "评价等级：excellent-优秀，good-良好，qualified-合格，unqualified-不合格")
    private String evaluationLevel;

    /**
     * 计算时间
     */
    @ExcelProperty(value = "计算时间")
    private Date calculateTime;

    /**
     * 是否删除
     */
    @ExcelProperty(value = "是否删除")
    private Long delFlag;


}
