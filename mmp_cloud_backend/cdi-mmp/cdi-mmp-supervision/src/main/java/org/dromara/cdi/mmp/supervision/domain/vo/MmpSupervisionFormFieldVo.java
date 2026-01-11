package org.dromara.cdi.mmp.supervision.domain.vo;

import org.dromara.cdi.mmp.supervision.domain.MmpSupervisionFormField;
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
 * 督查单字段视图对象 mmp_supervision_form_field
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpSupervisionFormField.class)
public class MmpSupervisionFormFieldVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 字段编码
     */
    @ExcelProperty(value = "字段编码")
    private String fieldCode;

    /**
     * 字段名称
     */
    @ExcelProperty(value = "字段名称")
    private String fieldName;

    /**
     * 字段类型
     */
    @ExcelProperty(value = "字段类型")
    private String fieldType;

    /**
     * 字段配置（JSON格式）
     */
    @ExcelProperty(value = "字段配置", converter = ExcelDictConvert.class)
    @ExcelDictFormat(readConverterExp = "J=SON格式")
    private String fieldConfig;

    /**
     * 是否必填：0-否，1-是
     */
    @ExcelProperty(value = "是否必填：0-否，1-是")
    private String requiredFlag;

    /**
     * 排序
     */
    @ExcelProperty(value = "排序")
    private Long sortOrder;

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
