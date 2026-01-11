package org.dromara.cdi.mmp.supervision.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.cdi.mmp.supervision.domain.MmpSupervisionResult;
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
 * 督查结果视图对象 mmp_supervision_result
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpSupervisionResult.class)
public class MmpSupervisionResultVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 督导日期
     */
    @ExcelProperty(value = "督导日期")
    private Date supervisionDate;

    /**
     * 督导人
     */
    @ExcelProperty(value = "督导人")
    private String supervisor;

    /**
     * 总分
     */
    @ExcelProperty(value = "总分")
    private Long totalScore;

    /**
     * 等级
     */
    @ExcelProperty(value = "等级")
    private String grade;

    /**
     * 状态：draft-草稿，submitted-已提交，reviewed-已审核
     */
    @ExcelProperty(value = "状态：draft-草稿，submitted-已提交，reviewed-已审核")
    private String status;

    /**
     * 备注
     */
    @ExcelProperty(value = "备注")
    private String remark;


}
