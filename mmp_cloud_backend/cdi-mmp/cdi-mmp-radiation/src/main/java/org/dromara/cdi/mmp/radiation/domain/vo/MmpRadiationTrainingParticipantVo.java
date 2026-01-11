package org.dromara.cdi.mmp.radiation.domain.vo;

import org.dromara.cdi.mmp.radiation.domain.MmpRadiationTrainingParticipant;
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
 * 培训参与记录视图对象 mmp_radiation_training_participant
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpRadiationTrainingParticipant.class)
public class MmpRadiationTrainingParticipantVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 工作人员姓名
     */
    @ExcelProperty(value = "工作人员姓名")
    private String staffName;

    /**
     * 出席状态：registered-已报名，attended-出席，absent-缺席
     */
    @ExcelProperty(value = "出席状态：registered-已报名，attended-出席，absent-缺席")
    private String attendanceStatus;

    /**
     * 培训成绩
     */
    @ExcelProperty(value = "培训成绩")
    private Long score;

    /**
     * 评价
     */
    @ExcelProperty(value = "评价")
    private String evaluation;

    /**
     * 是否发放证书：0-否，1-是
     */
    @ExcelProperty(value = "是否发放证书：0-否，1-是")
    private String certificateIssued;

    /**
     * 证书编号
     */
    @ExcelProperty(value = "证书编号")
    private String certificateNumber;

    /**
     * 备注
     */
    @ExcelProperty(value = "备注")
    private String remark;


}
