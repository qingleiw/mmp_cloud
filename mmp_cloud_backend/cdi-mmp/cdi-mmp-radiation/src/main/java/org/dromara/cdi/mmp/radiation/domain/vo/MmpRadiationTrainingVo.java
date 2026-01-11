package org.dromara.cdi.mmp.radiation.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.cdi.mmp.radiation.domain.MmpRadiationTraining;
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
 * 职业健康培训视图对象 mmp_radiation_training
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpRadiationTraining.class)
public class MmpRadiationTrainingVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 培训编码
     */
    @ExcelProperty(value = "培训编码")
    private String trainingCode;

    /**
     * 培训名称
     */
    @ExcelProperty(value = "培训名称")
    private String trainingName;

    /**
     * 培训类型
     */
    @ExcelProperty(value = "培训类型")
    private String trainingType;

    /**
     * 培训日期
     */
    @ExcelProperty(value = "培训日期")
    private Date trainingDate;

    /**
     * 培训师
     */
    @ExcelProperty(value = "培训师")
    private String trainer;

    /**
     * 参与人员
     */
    @ExcelProperty(value = "参与人员")
    private String participants;

    /**
     * 培训内容
     */
    @ExcelProperty(value = "培训内容")
    private String trainingContent;

    /**
     * 培训学时
     */
    @ExcelProperty(value = "培训学时")
    private Long trainingHours;

    /**
     * 评估结果
     */
    @ExcelProperty(value = "评估结果")
    private String evaluationResults;

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
