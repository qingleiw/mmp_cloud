package org.dromara.cdi.mmp.qc.domain.vo;

import org.dromara.cdi.mmp.qc.domain.MmpQcIndicatorCollectionConfig;
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
 * 质控指标数据采集配置视图对象 mmp_qc_indicator_collection_config
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpQcIndicatorCollectionConfig.class)
public class MmpQcIndicatorCollectionConfigVo implements Serializable {

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
     * 来源系统 HIS/EMR/LIS/PACS等
     */
    @ExcelProperty(value = "来源系统 HIS/EMR/LIS/PACS等")
    private String sourceSystem;

    /**
     * 来源表
     */
    @ExcelProperty(value = "来源表")
    private String sourceTable;

    /**
     * 来源字段
     */
    @ExcelProperty(value = "来源字段")
    private String sourceField;

    /**
     * 提取规则
     */
    @ExcelProperty(value = "提取规则")
    private String extractionRule;

    /**
     * 数据类型
     */
    @ExcelProperty(value = "数据类型")
    private String dataType;

    /**
     * 是否必需 1-是 0-否
     */
    @ExcelProperty(value = "是否必需 1-是 0-否")
    private Long isRequired;

    /**
     * 默认值
     */
    @ExcelProperty(value = "默认值")
    private String defaultValue;

    /**
     * 校验规则
     */
    @ExcelProperty(value = "校验规则")
    private String validationRule;

    /**
     * 是否删除
     */
    @ExcelProperty(value = "是否删除")
    private Long delFlag;


}
