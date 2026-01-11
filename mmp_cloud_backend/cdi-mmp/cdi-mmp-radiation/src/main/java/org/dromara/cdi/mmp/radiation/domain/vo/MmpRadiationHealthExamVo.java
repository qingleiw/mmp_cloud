package org.dromara.cdi.mmp.radiation.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.cdi.mmp.radiation.domain.MmpRadiationHealthExam;
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
 * 职业健康体检视图对象 mmp_radiation_health_exam
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpRadiationHealthExam.class)
public class MmpRadiationHealthExamVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 体检日期
     */
    @ExcelProperty(value = "体检日期")
    private Date examDate;

    /**
     * 体检类型
     */
    @ExcelProperty(value = "体检类型")
    private String examType;

    /**
     * 体检医院
     */
    @ExcelProperty(value = "体检医院")
    private String examHospital;

    /**
     * 体检医生
     */
    @ExcelProperty(value = "体检医生")
    private String examDoctor;

    /**
     * 体检结果
     */
    @ExcelProperty(value = "体检结果")
    private String examResults;

    /**
     * 诊断结果
     */
    @ExcelProperty(value = "诊断结果")
    private String diagnosis;

    /**
     * 建议
     */
    @ExcelProperty(value = "建议")
    private String recommendations;

    /**
     * 需要随访：0-否，1-是
     */
    @ExcelProperty(value = "需要随访：0-否，1-是")
    private String followUpRequired;

    /**
     * 下次体检日期
     */
    @ExcelProperty(value = "下次体检日期")
    private Date nextExamDate;

    /**
     * 状态
     */
    @ExcelProperty(value = "状态")
    private String status;

    /**
     * 备注
     */
    @ExcelProperty(value = "备注")
    private String remark;


}
