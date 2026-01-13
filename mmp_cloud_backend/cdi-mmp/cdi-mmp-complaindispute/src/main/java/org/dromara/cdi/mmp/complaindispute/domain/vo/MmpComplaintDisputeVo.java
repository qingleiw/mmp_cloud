package org.dromara.cdi.mmp.complaindispute.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.cdi.mmp.complaindispute.domain.MmpComplaintDispute;
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
 * 投诉纠纷主视图对象 mmp_complaint_dispute
 *
 * @author Lion Li
 * @date 2025-12-26
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpComplaintDispute.class)
public class MmpComplaintDisputeVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 投诉编号
     */
    @ExcelProperty(value = "投诉编号")
    private String complaintNo;

    /**
     * 投诉类型
     */
    @ExcelProperty(value = "投诉类型")
    private String complaintType;

    /**
     * 投诉来源
     */
    @ExcelProperty(value = "投诉来源")
    private String complaintSource;

    /**
     * 投诉人姓名
     */
    @ExcelProperty(value = "投诉人姓名")
    private String complainantName;

    /**
     * 投诉人联系方式
     */
    @ExcelProperty(value = "投诉人联系方式")
    private String complainantContact;

    /**
     * 患者姓名
     */
    @ExcelProperty(value = "患者姓名")
    private String patientName;

    /**
     * 涉及医师姓名
     */
    @ExcelProperty(value = "涉及医师姓名")
    private String doctorName;

    /**
     * 涉及科室名称
     */
    @ExcelProperty(value = "涉及科室名称")
    private String departmentName;

    /**
     * 投诉内容
     */
    @ExcelProperty(value = "投诉内容")
    private String complaintContent;

    /**
     * 投诉时间
     */
    @ExcelProperty(value = "投诉时间")
    private Date complaintTime;

    /**
     * 当前状态
     */
    @ExcelProperty(value = "当前状态")
    private String currentStatus;

    /**
     * 优先级
     */
    @ExcelProperty(value = "优先级")
    private String priorityLevel;

    /**
     * 是否构成纠纷
     */
    @ExcelProperty(value = "是否构成纠纷")
    private Long isDispute;

    /**
     * 纠纷确认说明
     */
    @ExcelProperty(value = "纠纷确认说明")
    private String disputeConfirmation;

    /**
     * 最终处理结果
     */
    @ExcelProperty(value = "最终处理结果")
    private String finalResult;

    /**
     * 删除标志（0代表存在 1代表删除）
     */
    @ExcelProperty(value = "删除标志", converter = ExcelDictConvert.class)
    @ExcelDictFormat(readConverterExp = "0=代表存在,1=代表删除")
    private String delFlag;


}
