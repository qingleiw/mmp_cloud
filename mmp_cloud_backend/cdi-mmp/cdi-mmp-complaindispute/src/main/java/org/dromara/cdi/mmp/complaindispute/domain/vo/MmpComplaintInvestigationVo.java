package org.dromara.cdi.mmp.complaindispute.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.cdi.mmp.complaindispute.domain.MmpComplaintInvestigation;
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
 * 投诉调查记录视图对象 mmp_complaint_investigation
 *
 * @author Lion Li
 * @date 2025-12-26
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpComplaintInvestigation.class)
public class MmpComplaintInvestigationVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 调查人姓名
     */
    @ExcelProperty(value = "调查人姓名")
    private String investigatorName;

    /**
     * 调查内容
     */
    @ExcelProperty(value = "调查内容")
    private String investigationContent;

    /**
     * 调查结果
     */
    @ExcelProperty(value = "调查结果")
    private String investigationResult;

    /**
     * 调查时间
     */
    @ExcelProperty(value = "调查时间")
    private Date investigationTime;

    /**
     * 附件（JSON格式）
     */
    @ExcelProperty(value = "附件", converter = ExcelDictConvert.class)
    @ExcelDictFormat(readConverterExp = "J=SON格式")
    private String attachments;

    /**
     * 删除标志（0代表存在 1代表删除）
     */
    @ExcelProperty(value = "删除标志", converter = ExcelDictConvert.class)
    @ExcelDictFormat(readConverterExp = "0=代表存在,1=代表删除")
    private String delFlag;


}
