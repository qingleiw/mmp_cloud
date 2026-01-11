package org.dromara.cdi.mmp.surgery.domain.vo;

import org.dromara.cdi.mmp.surgery.domain.MmpSurgeryApprovalForm;
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
 * 重大手术审批报告单视图对象 mmp_surgery_approval_form
 *
 * @author Lion Li
 * @date 2025-12-28
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpSurgeryApprovalForm.class)
public class MmpSurgeryApprovalFormVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 申报科室
     */
    @ExcelProperty(value = "申报科室")
    private String deptName;

    /**
     * 申报日期
     */
    @ExcelProperty(value = "申报日期")
    private String reportDate;

    /**
     * 患者姓名
     */
    @ExcelProperty(value = "患者姓名")
    private String patientName;

    /**
     * 性别
     */
    @ExcelProperty(value = "性别")
    private String gender;

    /**
     * 年龄
     */
    @ExcelProperty(value = "年龄")
    private Long age;

    /**
     * 住院号
     */
    @ExcelProperty(value = "住院号")
    private String hospitalNumber;

    /**
     * 术前诊断
     */
    @ExcelProperty(value = "术前诊断")
    private String preoperativeDiagnosis;

    /**
     * 手术名称
     */
    @ExcelProperty(value = "手术名称")
    private String surgeryName;

    /**
     * 手术级别
     */
    @ExcelProperty(value = "手术级别")
    private String surgeryLevel;

    /**
     * 麻醉方式
     */
    @ExcelProperty(value = "麻醉方式")
    private String anesthesiaMethod;

    /**
     * 术者及职称
     */
    @ExcelProperty(value = "术者及职称")
    private String surgeon;

    /**
     * 助手及职称
     */
    @ExcelProperty(value = "助手及职称")
    private String assistant;

    /**
     * 术前讨论结果
     */
    @ExcelProperty(value = "术前讨论结果")
    private String discussionResult;

    /**
     * 报告医师
     */
    @ExcelProperty(value = "报告医师")
    private String reportingPhysician;

    /**
     * 报告日期
     */
    @ExcelProperty(value = "报告日期")
    private String reportingDate;

    /**
     * 患者或授权委托人知情同意情况
     */
    @ExcelProperty(value = "患者或授权委托人知情同意情况")
    private String informedConsent;

    /**
     * 科室主任签字
     */
    @ExcelProperty(value = "科室主任签字")
    private String departmentDirector;

    /**
     * 科室签字日期
     */
    @ExcelProperty(value = "科室签字日期")
    private String departmentDate;

    /**
     * 医务部主任签字
     */
    @ExcelProperty(value = "医务部主任签字")
    private String medicalDirector;

    /**
     * 审批状态
     */
    @ExcelProperty(value = "审批状态")
    private String status;

    /**
     * 删除标志（0代表存在 1代表删除）
     */
    @ExcelProperty(value = "删除标志", converter = ExcelDictConvert.class)
    @ExcelDictFormat(readConverterExp = "0=代表存在,1=代表删除")
    private Long delFlag;


}
