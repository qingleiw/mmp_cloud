package org.dromara.cdi.mmp.qualification.domain.vo;

import org.dromara.cdi.mmp.qualification.domain.MmpTechnicianQualificationCatalog;
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
 * 医技资质目录视图对象 mmp_technician_qualification_catalog
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpTechnicianQualificationCatalog.class)
public class MmpTechnicianQualificationCatalogVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @ExcelProperty(value = "主键ID")
    private Long id;

    /**
     * 资质编码
     */
    @ExcelProperty(value = "资质编码")
    private String catalogCode;

    /**
     * 资质名称
     */
    @ExcelProperty(value = "资质名称")
    private String catalogName;

    /**
     * 父级ID
     */
    @ExcelProperty(value = "父级ID")
    private Long parentId;

    /**
     * 目录层级
     */
    @ExcelProperty(value = "目录层级")
    private Long catalogLevel;

    /**
     * 资质类型 检查/检验/心电/病理/输血/核医学/放疗/POCT/药学调配
     */
    @ExcelProperty(value = "资质类型 检查/检验/心电/病理/输血/核医学/放疗/POCT/药学调配")
    private String catalogType;

    /**
     * 资质描述
     */
    @ExcelProperty(value = "资质描述")
    private String description;

    /**
     * 排序
     */
    @ExcelProperty(value = "排序")
    private Long sortOrder;

    /**
     * 是否启用
     */
    @ExcelProperty(value = "是否启用")
    private Long isEnabled;

    /**
     * 是否删除
     */
    @ExcelProperty(value = "是否删除")
    private Long delFlag;


}
