package org.dromara.cdi.mmp.qualification.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.cdi.mmp.qualification.domain.MmpDepartmentQualificationCatalog;
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
 * 科室资质目录视图对象 mmp_department_qualification_catalog
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpDepartmentQualificationCatalog.class)
public class MmpDepartmentQualificationCatalogVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @ExcelProperty(value = "主键ID")
    private Long id;

    /**
     * 科室ID
     */
    @ExcelProperty(value = "科室ID")
    private Long departmentId;

    /**
     * 资质ID
     */
    @ExcelProperty(value = "资质ID")
    private Long qualificationId;

    /**
     * 资质类型 医师/医技
     */
    @ExcelProperty(value = "资质类型 医师/医技")
    private String qualificationType;

    /**
     * 是否启用
     */
    @ExcelProperty(value = "是否启用")
    private Long isEnabled;

    /**
     * 审批状态 待审批/已通过/已拒绝
     */
    @ExcelProperty(value = "审批状态 待审批/已通过/已拒绝")
    private String approveStatus;

    /**
     * 审批时间
     */
    @ExcelProperty(value = "审批时间")
    private Date approveTime;

    /**
     * 审批人
     */
    @ExcelProperty(value = "审批人")
    private String approveBy;

    /**
     * 是否删除
     */
    @ExcelProperty(value = "是否删除")
    private Long delFlag;


}
