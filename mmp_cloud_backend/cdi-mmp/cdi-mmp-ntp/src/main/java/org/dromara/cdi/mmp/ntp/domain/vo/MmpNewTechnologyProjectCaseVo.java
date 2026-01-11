package org.dromara.cdi.mmp.ntp.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.cdi.mmp.ntp.domain.MmpNewTechnologyProjectCase;
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
 * 新技术病例登记视图对象 mmp_new_technology_project_case
 *
 * @author Lion Li
 * @date 2026-01-07
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpNewTechnologyProjectCase.class)
public class MmpNewTechnologyProjectCaseVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 患者姓名
     */
    @ExcelProperty(value = "患者姓名")
    private String patientName;

    /**
     * 就诊类型 门诊/住院
     */
    @ExcelProperty(value = "就诊类型 门诊/住院")
    private String visitType;

    /**
     * 就诊号
     */
    @ExcelProperty(value = "就诊号")
    private String visitNo;

    /**
     * 就诊日期
     */
    @ExcelProperty(value = "就诊日期")
    private Date visitDate;

    /**
     * 就诊科室名称
     */
    @ExcelProperty(value = "就诊科室名称")
    private String visitDepartmentName;

    /**
     * 诊断
     */
    @ExcelProperty(value = "诊断")
    private String diagnosis;

    /**
     * 操作医生
     */
    @ExcelProperty(value = "操作医生")
    private String operator;

    /**
     * 操作时间
     */
    @ExcelProperty(value = "操作时间")
    private Date operationDate;

    /**
     * 效果评价
     */
    @ExcelProperty(value = "效果评价")
    private String effectEvaluation;

    /**
     * 并发症
     */
    @ExcelProperty(value = "并发症")
    private String complication;

    /**
     * 不良反应
     */
    @ExcelProperty(value = "不良反应")
    private String adverseReaction;

    /**
     * 随访状态
     */
    @ExcelProperty(value = "随访状态")
    private String followUpStatus;

    /**
     * 随访结果
     */
    @ExcelProperty(value = "随访结果")
    private String followUpResult;

    /**
     * 是否已报备 1-是 0-否
     */
    @ExcelProperty(value = "是否已报备 1-是 0-否")
    private Long isReported;

    /**
     * 报备时间
     */
    @ExcelProperty(value = "报备时间")
    private Date reportTime;

    /**
     * 备注
     */
    @ExcelProperty(value = "备注")
    private String remark;


}
