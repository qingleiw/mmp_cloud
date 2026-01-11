package org.dromara.cdi.mmp.qc.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.cdi.mmp.qc.domain.MmpQcManualData;
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
 * 人工补录数据视图对象 mmp_qc_manual_data
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpQcManualData.class)
public class MmpQcManualDataVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @ExcelProperty(value = "主键ID")
    private Long id;

    /**
     * 指标ID
     */
    @ExcelProperty(value = "指标ID")
    private Long indicatorId;

    /**
     * 患者ID
     */
    @ExcelProperty(value = "患者ID")
    private Long patientId;

    /**
     * 就诊号
     */
    @ExcelProperty(value = "就诊号")
    private String visitNo;

    /**
     * 数据类型
     */
    @ExcelProperty(value = "数据类型")
    private String dataType;

    /**
     * 数据字段
     */
    @ExcelProperty(value = "数据字段")
    private String dataField;

    /**
     * 数据值
     */
    @ExcelProperty(value = "数据值")
    private String dataValue;

    /**
     * 数据日期
     */
    @ExcelProperty(value = "数据日期")
    private Date dataDate;

    /**
     * 操作类型 新增/修正
     */
    @ExcelProperty(value = "操作类型 新增/修正")
    private String operationType;

    /**
     * 原始值
     */
    @ExcelProperty(value = "原始值")
    private String originalValue;

    /**
     * 修改原因
     */
    @ExcelProperty(value = "修改原因")
    private String modifyReason;

    /**
     * 是否删除
     */
    @ExcelProperty(value = "是否删除")
    private Long delFlag;


}
