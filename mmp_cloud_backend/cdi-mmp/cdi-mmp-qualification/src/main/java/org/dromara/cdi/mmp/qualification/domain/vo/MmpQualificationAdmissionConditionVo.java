package org.dromara.cdi.mmp.qualification.domain.vo;

import org.dromara.cdi.mmp.qualification.domain.MmpQualificationAdmissionCondition;
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
 * 资质准入条件视图对象 mmp_qualification_admission_condition
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpQualificationAdmissionCondition.class)
public class MmpQualificationAdmissionConditionVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @ExcelProperty(value = "主键ID")
    private Long id;

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
     * 条件类型 学历/职称/工作年限/专业/培训/考核/证书
     */
    @ExcelProperty(value = "条件类型 学历/职称/工作年限/专业/培训/考核/证书")
    private String conditionType;

    /**
     * 条件运算符 =/>/</>=/<=/in
     */
    @ExcelProperty(value = "条件运算符 =/>/</>=/<=/in")
    private String conditionOperator;

    /**
     * 条件值
     */
    @ExcelProperty(value = "条件值")
    private String conditionValue;

    /**
     * 条件单位
     */
    @ExcelProperty(value = "条件单位")
    private String conditionUnit;

    /**
     * 是否必须 1-是 0-否
     */
    @ExcelProperty(value = "是否必须 1-是 0-否")
    private Long isRequired;

    /**
     * 逻辑关系 AND/OR
     */
    @ExcelProperty(value = "逻辑关系 AND/OR")
    private String logicRelation;

    /**
     * 排序
     */
    @ExcelProperty(value = "排序")
    private Long sortOrder;

    /**
     * 备注
     */
    @ExcelProperty(value = "备注")
    private String remark;

    /**
     * 是否删除
     */
    @ExcelProperty(value = "是否删除")
    private Long delFlag;


}
