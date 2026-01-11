package org.dromara.cdi.mmp.emergency.domain.vo;

import org.dromara.cdi.mmp.emergency.domain.MmpEmergencyMedicalSupport;
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
 * 医疗保障资源视图对象 mmp_emergency_medical_support
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpEmergencyMedicalSupport.class)
public class MmpEmergencyMedicalSupportVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 资源编码
     */
    @ExcelProperty(value = "资源编码")
    private String resourceCode;

    /**
     * 资源名称
     */
    @ExcelProperty(value = "资源名称")
    private String resourceName;

    /**
     * 资源类型
     */
    @ExcelProperty(value = "资源类型")
    private String resourceType;

    /**
     * 所属部门
     */
    @ExcelProperty(value = "所属部门")
    private String department;

    /**
     * 存放地点
     */
    @ExcelProperty(value = "存放地点")
    private String location;

    /**
     * 数量
     */
    @ExcelProperty(value = "数量")
    private Long quantity;

    /**
     * 单位
     */
    @ExcelProperty(value = "单位")
    private String unit;

    /**
     * 联系人
     */
    @ExcelProperty(value = "联系人")
    private String contactPerson;

    /**
     * 联系方式
     */
    @ExcelProperty(value = "联系方式")
    private String contactInfo;

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
