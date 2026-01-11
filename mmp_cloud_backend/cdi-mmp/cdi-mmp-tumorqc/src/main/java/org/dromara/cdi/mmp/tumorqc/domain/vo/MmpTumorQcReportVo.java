package org.dromara.cdi.mmp.tumorqc.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.cdi.mmp.tumorqc.domain.MmpTumorQcReport;
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
 * 肿瘤质控报告视图对象 mmp_tumor_qc_report
 *
 * @author Lion Li
 * @date 2025-12-26
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpTumorQcReport.class)
public class MmpTumorQcReportVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 报告编码
     */
    @ExcelProperty(value = "报告编码")
    private String reportCode;

    /**
     * 报告标题
     */
    @ExcelProperty(value = "报告标题")
    private String reportTitle;

    /**
     * 报告类型
     */
    @ExcelProperty(value = "报告类型")
    private String reportType;

    /**
     * 报告周期开始
     */
    @ExcelProperty(value = "报告周期开始")
    private Date periodStart;

    /**
     * 报告周期结束
     */
    @ExcelProperty(value = "报告周期结束")
    private Date periodEnd;

    /**
     * 报告内容
     */
    @ExcelProperty(value = "报告内容")
    private String reportContent;

    /**
     * 报告摘要
     */
    @ExcelProperty(value = "报告摘要")
    private String summary;

    /**
     * 建议措施
     */
    @ExcelProperty(value = "建议措施")
    private String recommendations;

    /**
     * 状态（0草稿 1已发布）
     */
    @ExcelProperty(value = "状态", converter = ExcelDictConvert.class)
    @ExcelDictFormat(readConverterExp = "0=草稿,1=已发布")
    private String status;

    /**
     * 发布时间
     */
    @ExcelProperty(value = "发布时间")
    private Date publishTime;

    /**
     * 删除标志（0代表存在 1代表删除）
     */
    @ExcelProperty(value = "删除标志", converter = ExcelDictConvert.class)
    @ExcelDictFormat(readConverterExp = "0=代表存在,1=代表删除")
    private String delFlag;


}
