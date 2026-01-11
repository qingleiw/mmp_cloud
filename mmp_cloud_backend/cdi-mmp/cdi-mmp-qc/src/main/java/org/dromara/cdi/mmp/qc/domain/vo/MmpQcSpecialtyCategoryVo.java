package org.dromara.cdi.mmp.qc.domain.vo;

import org.dromara.cdi.mmp.qc.domain.MmpQcSpecialtyCategory;
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
 * 专业类别视图对象 mmp_qc_specialty_category
 *
 * @author Lion Li
 * @date 2025-12-30
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpQcSpecialtyCategory.class)
public class MmpQcSpecialtyCategoryVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 专业代码
     */
    @ExcelProperty(value = "专业代码")
    private String categoryCode;

    /**
     * 专业名称
     */
    @ExcelProperty(value = "专业名称")
    private String categoryName;

    /**
     * 发布年份
     */
    @ExcelProperty(value = "发布年份")
    private Long publishYear;

    /**
     * 排序
     */
    @ExcelProperty(value = "排序")
    private Long sortOrder;

    /**
     * 状态：1-启用，0-禁用
     */
    @ExcelProperty(value = "状态：1-启用，0-禁用")
    private Long status;

    /**
     * 是否删除
     */
    @ExcelProperty(value = "是否删除")
    private Long delFlag;


}
