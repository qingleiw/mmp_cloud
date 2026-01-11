package org.dromara.cdi.mmp.qualification.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.cdi.mmp.qualification.domain.MmpQualificationCatalog;
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
 * 医生手术授权目录视图对象 mmp_qualification_catalog
 *
 * @author Lion Li
 * @date 2025-12-30
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpQualificationCatalog.class)
public class MmpQualificationCatalogVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 医生姓名
     */
    @ExcelProperty(value = "医生姓名")
    private String doctorName;

    /**
     * 科室
     */
    @ExcelProperty(value = "科室")
    private String department;

    /**
     * 职务
     */
    @ExcelProperty(value = "职务")
    private String position;

    /**
     * 职称
     */
    @ExcelProperty(value = "职称")
    private String title;

    /**
     * 所授权手术级别
     */
    @ExcelProperty(value = "所授权手术级别")
    private String authorizedLevel;

    /**
     * 一级手术授权（1=通过，0=未通过）
     */
    @ExcelProperty(value = "一级手术授权", converter = ExcelDictConvert.class)
    @ExcelDictFormat(readConverterExp = "1==通过，0=未通过")
    private Long level1;

    /**
     * 二级手术授权（1=通过，0=未通过）
     */
    @ExcelProperty(value = "二级手术授权", converter = ExcelDictConvert.class)
    @ExcelDictFormat(readConverterExp = "1==通过，0=未通过")
    private Long level2;

    /**
     * 三级手术授权（1=通过，0=未通过）
     */
    @ExcelProperty(value = "三级手术授权", converter = ExcelDictConvert.class)
    @ExcelDictFormat(readConverterExp = "1==通过，0=未通过")
    private Long level3;

    /**
     * 四级手术授权（1=通过，0=未通过）
     */
    @ExcelProperty(value = "四级手术授权", converter = ExcelDictConvert.class)
    @ExcelDictFormat(readConverterExp = "1==通过，0=未通过")
    private Long level4;

    /**
     * 手术名称
     */
    @ExcelProperty(value = "手术名称")
    private String surgeryName;

    /**
     * 手术代码
     */
    @ExcelProperty(value = "手术代码")
    private String surgeryCode;

    /**
     * 手术级别（三级/四级）
     */
    @ExcelProperty(value = "手术级别", converter = ExcelDictConvert.class)
    @ExcelDictFormat(readConverterExp = "三=级/四级")
    private String surgeryLevel;

    /**
     * 资质类型
     */
    @ExcelProperty(value = "资质类型")
    private String qualificationType;

    /**
     * 有效期开始
     */
    @ExcelProperty(value = "有效期开始")
    private Date validStartDate;

    /**
     * 有效期结束
     */
    @ExcelProperty(value = "有效期结束")
    private Date validEndDate;

    /**
     * 状态
     */
    @ExcelProperty(value = "状态")
    private String status;

    /**
     * 数据来源
     */
    @ExcelProperty(value = "数据来源")
    private String dataSource;

    /**
     * 是否删除
     */
    @ExcelProperty(value = "是否删除")
    private Long delFlag;


}
