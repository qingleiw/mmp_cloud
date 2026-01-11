package org.dromara.cdi.mmp.ntp.domain.vo;

import org.dromara.cdi.mmp.ntp.domain.MmpNewTechnologyProjectMapping;
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
 * 新技术项目对码视图对象 mmp_new_technology_project_mapping
 *
 * @author Lion Li
 * @date 2026-01-07
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpNewTechnologyProjectMapping.class)
public class MmpNewTechnologyProjectMappingVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 对码类型 医嘱项/ICD-9/收费项
     */
    @ExcelProperty(value = "对码类型 医嘱项/ICD-9/收费项")
    private String mappingType;

    /**
     * 源编码
     */
    @ExcelProperty(value = "源编码")
    private String sourceCode;

    /**
     * 源名称
     */
    @ExcelProperty(value = "源名称")
    private String sourceName;

    /**
     * 目标系统 HIS/收费系统
     */
    @ExcelProperty(value = "目标系统 HIS/收费系统")
    private String targetSystem;

    /**
     * 备注
     */
    @ExcelProperty(value = "备注")
    private String remark;


}
