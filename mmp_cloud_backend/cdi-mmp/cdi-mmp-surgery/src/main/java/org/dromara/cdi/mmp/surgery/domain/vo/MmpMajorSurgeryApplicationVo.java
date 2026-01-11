package org.dromara.cdi.mmp.surgery.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.cdi.mmp.surgery.domain.MmpMajorSurgeryApplication;
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
 * 重大手术申请视图对象 mmp_major_surgery_application
 *
 * @author Lion Li
 * @date 2025-12-26
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpMajorSurgeryApplication.class)
public class MmpMajorSurgeryApplicationVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 申请编号
     */
    @ExcelProperty(value = "申请编号")
    private String applicationNo;

    /**
     * 患者姓名
     */
    @ExcelProperty(value = "患者姓名")
    private String patientName;

    /**
     * 申请医师姓名
     */
    @ExcelProperty(value = "申请医师姓名")
    private String doctorName;

    /**
     * 申请科室名称
     */
    @ExcelProperty(value = "申请科室名称")
    private String departmentName;

    /**
     * 拟手术名称
     */
    @ExcelProperty(value = "拟手术名称")
    private String surgeryName;

    /**
     * 手术原因
     */
    @ExcelProperty(value = "手术原因")
    private String surgeryReason;

    /**
     * 手术风险
     */
    @ExcelProperty(value = "手术风险")
    private String surgeryRisk;

    /**
     * 预计手术时间
     */
    @ExcelProperty(value = "预计手术时间")
    private Date expectedTime;

    /**
     * 申请状态
     */
    @ExcelProperty(value = "申请状态")
    private String applicationStatus;

    /**
     * 审批意见
     */
    @ExcelProperty(value = "审批意见")
    private String approvalOpinion;

    /**
     * 审批人姓名
     */
    @ExcelProperty(value = "审批人姓名")
    private String approverName;

    /**
     * 审批时间
     */
    @ExcelProperty(value = "审批时间")
    private Date approvalTime;

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
