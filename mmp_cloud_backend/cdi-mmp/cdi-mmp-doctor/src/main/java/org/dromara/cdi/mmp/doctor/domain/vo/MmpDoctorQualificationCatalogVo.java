package org.dromara.cdi.mmp.doctor.domain.vo;

import org.dromara.cdi.mmp.doctor.domain.MmpDoctorQualificationCatalog;
import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;


/**
 * 医师资质目录视图对象 mmp_doctor_qualification_catalog
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpDoctorQualificationCatalog.class)
public class MmpDoctorQualificationCatalogVo implements Serializable {

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
     * 目录层级 1-一级 2-二级 3-三级 4-四级
     */
    @ExcelProperty(value = "目录层级 1-一级 2-二级 3-三级 4-四级")
    private Long catalogLevel;

    /**
     * 资质类型 手术分级/有创操作/限制类技术/处方权/会诊权/其他
     */
    @ExcelProperty(value = "资质类型 手术分级/有创操作/限制类技术/处方权/会诊权/其他")
    private String catalogType;

    /**
     * 资质子类型
     */
    @ExcelProperty(value = "资质子类型")
    private String subType;

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
     * 是否启用 1-是 0-否
     */
    @ExcelProperty(value = "是否启用 1-是 0-否")
    private Long isEnabled;

    /**
     * 是否删除
     */
    @ExcelProperty(value = "是否删除")
    private Long delFlag;


}
