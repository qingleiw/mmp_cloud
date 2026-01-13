package org.dromara.cdi.mmp.complaindispute.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.cdi.mmp.complaindispute.domain.MmpComplaintHandling;
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
 * 投诉处理记录视图对象 mmp_complaint_handling
 *
 * @author Lion Li
 * @date 2025-12-26
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpComplaintHandling.class)
public class MmpComplaintHandlingVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 处理人姓名
     */
    @ExcelProperty(value = "处理人姓名")
    private String handlerName;

    /**
     * 处理措施
     */
    @ExcelProperty(value = "处理措施")
    private String handlingMeasure;

    /**
     * 处理结果
     */
    @ExcelProperty(value = "处理结果")
    private String handlingResult;

    /**
     * 处理时间
     */
    @ExcelProperty(value = "处理时间")
    private Date handlingTime;

    /**
     * 反馈内容
     */
    @ExcelProperty(value = "反馈内容")
    private String feedbackContent;

    /**
     * 反馈时间
     */
    @ExcelProperty(value = "反馈时间")
    private Date feedbackTime;

    /**
     * 删除标志（0代表存在 1代表删除）
     */
    @ExcelProperty(value = "删除标志", converter = ExcelDictConvert.class)
    @ExcelDictFormat(readConverterExp = "0=代表存在,1=代表删除")
    private String delFlag;


}
