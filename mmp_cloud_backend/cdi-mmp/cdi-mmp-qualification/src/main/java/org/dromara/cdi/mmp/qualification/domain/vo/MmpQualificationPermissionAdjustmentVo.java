package org.dromara.cdi.mmp.qualification.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.cdi.mmp.qualification.domain.MmpQualificationPermissionAdjustment;
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
 * 资质权限调整历史视图对象 mmp_qualification_permission_adjustment
 *
 * @author Lion Li
 * @date 2025-12-26
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpQualificationPermissionAdjustment.class)
public class MmpQualificationPermissionAdjustmentVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 医师姓名
     */
    @ExcelProperty(value = "医师姓名")
    private String doctorName;

    /**
     * 资质类型（手术权限、抗菌药物权限等）
     */
    @ExcelProperty(value = "资质类型", converter = ExcelDictConvert.class)
    @ExcelDictFormat(readConverterExp = "手=术权限、抗菌药物权限等")
    private String qualificationType;

    /**
     * 原权限级别
     */
    @ExcelProperty(value = "原权限级别")
    private String originalLevel;

    /**
     * 新权限级别
     */
    @ExcelProperty(value = "新权限级别")
    private String newLevel;

    /**
     * 调整原因
     */
    @ExcelProperty(value = "调整原因")
    private String adjustmentReason;

    /**
     * 调整依据（JSON格式，包含工作量、并发症等数据）
     */
    @ExcelProperty(value = "调整依据", converter = ExcelDictConvert.class)
    @ExcelDictFormat(readConverterExp = "J=SON格式，包含工作量、并发症等数据")
    private String adjustmentBasis;

    /**
     * 调整时间
     */
    @ExcelProperty(value = "调整时间")
    private Date adjustmentTime;

    /**
     * 操作人姓名
     */
    @ExcelProperty(value = "操作人姓名")
    private String operatorName;

    /**
     * 是否自动调整
     */
    @ExcelProperty(value = "是否自动调整")
    private Long isAutoAdjustment;

    /**
     * 删除标志（0代表存在 1代表删除）
     */
    @ExcelProperty(value = "删除标志", converter = ExcelDictConvert.class)
    @ExcelDictFormat(readConverterExp = "0=代表存在,1=代表删除")
    private String delFlag;


}
