package org.dromara.cdi.mmp.supervision.domain.vo;

import org.dromara.cdi.mmp.supervision.domain.MmpSupervisionForm;
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
 * 督查单视图对象 mmp_supervision_form
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpSupervisionForm.class)
public class MmpSupervisionFormVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 表单编码
     */
    @ExcelProperty(value = "表单编码")
    private String formCode;

    /**
     * 表单名称
     */
    @ExcelProperty(value = "表单名称")
    private String formName;

    /**
     * 表单描述
     */
    @ExcelProperty(value = "表单描述")
    private String formDescription;

    /**
     * 表单配置（JSON格式）
     */
    @ExcelProperty(value = "表单配置", converter = ExcelDictConvert.class)
    @ExcelDictFormat(readConverterExp = "J=SON格式")
    private String formConfig;

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
