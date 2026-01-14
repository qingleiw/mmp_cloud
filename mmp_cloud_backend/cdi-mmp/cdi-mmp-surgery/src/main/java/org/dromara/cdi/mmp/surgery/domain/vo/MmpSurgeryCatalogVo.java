package org.dromara.system.domain.vo;

import org.dromara.system.domain.MmpSurgeryCatalog;
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
 * 手术目录视图对象 mmp_surgery_catalog
 *
 * @author Lion Li
 * @date 2026-01-02
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpSurgeryCatalog.class)
public class MmpSurgeryCatalogVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 附加编码
     */
    @ExcelProperty(value = "附加编码")
    private String additionalCode;

    /**
     * 细目代码
     */
    @ExcelProperty(value = "细目代码")
    private String detailCode;

    /**
     * 手术操作名称
     */
    @ExcelProperty(value = "手术操作名称")
    private String surgeryName;

    /**
     * 类别
     */
    @ExcelProperty(value = "类别")
    private String category;

    /**
     * 手术等级
     */
    @ExcelProperty(value = "手术等级")
    private String surgeryLevel;

    /**
     * 是否启用
     */
    @ExcelProperty(value = "是否启用")
    private Long isEnabled;

    /**
     * 所属科室
     */
    @ExcelProperty(value = "所属科室")
    private String department;

    /**
     * 手术分类
     */
    @ExcelProperty(value = "手术分类")
    private String surgeryCategory;

    /**
     * 备注
     */
    @ExcelProperty(value = "备注")
    private String remark;


}
