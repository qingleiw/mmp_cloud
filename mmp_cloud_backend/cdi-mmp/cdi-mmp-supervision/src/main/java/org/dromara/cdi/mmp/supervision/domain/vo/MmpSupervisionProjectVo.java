package org.dromara.cdi.mmp.supervision.domain.vo;

import org.dromara.cdi.mmp.supervision.domain.MmpSupervisionProject;
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
 * 督查项目视图对象 mmp_supervision_project
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpSupervisionProject.class)
public class MmpSupervisionProjectVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 项目编码
     */
    @ExcelProperty(value = "项目编码")
    private String projectCode;

    /**
     * 项目名称
     */
    @ExcelProperty(value = "项目名称")
    private String projectName;

    /**
     * 项目类型
     */
    @ExcelProperty(value = "项目类型")
    private String projectType;

    /**
     * 项目描述
     */
    @ExcelProperty(value = "项目描述")
    private String projectDescription;

    /**
     * 督导部门
     */
    @ExcelProperty(value = "督导部门")
    private String supervisionDepartment;

    /**
     * 负责人
     */
    @ExcelProperty(value = "负责人")
    private String responsiblePerson;

    /**
     * 联系方式
     */
    @ExcelProperty(value = "联系方式")
    private String contactInfo;

    /**
     * 督导频次
     */
    @ExcelProperty(value = "督导频次")
    private String supervisionFrequency;

    /**
     * 状态：active-启用，inactive-停用
     */
    @ExcelProperty(value = "状态：active-启用，inactive-停用")
    private String status;

    /**
     * 备注
     */
    @ExcelProperty(value = "备注")
    private String remark;


}
