package org.dromara.cdi.mmp.supervision.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.cdi.mmp.supervision.domain.MmpSupervisionPlanDept;
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
 * 督查计划科室关联视图对象 mmp_supervision_plan_dept
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpSupervisionPlanDept.class)
public class MmpSupervisionPlanDeptVo implements Serializable {

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
     * 状态：pending-待督导，completed-已完成
     */
    @ExcelProperty(value = "状态：pending-待督导，completed-已完成")
    private String status;

    /**
     * 备注
     */
    @ExcelProperty(value = "备注")
    private String remark;


}
