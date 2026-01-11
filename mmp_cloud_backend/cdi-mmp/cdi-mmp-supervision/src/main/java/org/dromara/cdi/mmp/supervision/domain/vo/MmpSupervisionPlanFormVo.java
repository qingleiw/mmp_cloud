package org.dromara.cdi.mmp.supervision.domain.vo;

import org.dromara.cdi.mmp.supervision.domain.MmpSupervisionPlanForm;
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
 * 督查计划单关联视图对象 mmp_supervision_plan_form
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpSupervisionPlanForm.class)
public class MmpSupervisionPlanFormVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 排序
     */
    @ExcelProperty(value = "排序")
    private Long sortOrder;

    /**
     * 备注
     */
    @ExcelProperty(value = "备注")
    private String remark;


}
