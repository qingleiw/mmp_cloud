package org.dromara.cdi.mmp.tumorqc.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.cdi.mmp.tumorqc.domain.MmpTumorQcResult;
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
 * 肿瘤质控结果视图对象 mmp_tumor_qc_result
 *
 * @author Lion Li
 * @date 2025-12-26
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpTumorQcResult.class)
public class MmpTumorQcResultVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 结果编码
     */
    @ExcelProperty(value = "结果编码")
    private String resultCode;

    /**
     * 指标名称
     */
    @ExcelProperty(value = "指标名称")
    private String indicatorName;

    /**
     * 结果值
     */
    @ExcelProperty(value = "结果值")
    private Long resultValue;

    /**
     * 目标值
     */
    @ExcelProperty(value = "目标值")
    private Long targetValue;

    /**
     * 达标率
     */
    @ExcelProperty(value = "达标率")
    private Long complianceRate;

    /**
     * 结果分析
     */
    @ExcelProperty(value = "结果分析")
    private String analysis;

    /**
     * 统计周期开始
     */
    @ExcelProperty(value = "统计周期开始")
    private Date periodStart;

    /**
     * 统计周期结束
     */
    @ExcelProperty(value = "统计周期结束")
    private Date periodEnd;

    /**
     * 状态（0正常 1异常）
     */
    @ExcelProperty(value = "状态", converter = ExcelDictConvert.class)
    @ExcelDictFormat(readConverterExp = "0=正常,1=异常")
    private String status;

    /**
     * 删除标志（0代表存在 1代表删除）
     */
    @ExcelProperty(value = "删除标志", converter = ExcelDictConvert.class)
    @ExcelDictFormat(readConverterExp = "0=代表存在,1=代表删除")
    private String delFlag;


}
