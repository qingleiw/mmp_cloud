package org.dromara.cdi.mmp.tumorqc.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.cdi.mmp.tumorqc.domain.MmpTumorQcIndicatorConfig;
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
 * 肿瘤质控指标配置视图对象 mmp_tumor_qc_indicator_config
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpTumorQcIndicatorConfig.class)
public class MmpTumorQcIndicatorConfigVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @ExcelProperty(value = "主键ID")
    private Long id;

    /**
     * 指标编码
     */
    @ExcelProperty(value = "指标编码")
    private String indicatorCode;

    /**
     * 指标名称
     */
    @ExcelProperty(value = "指标名称")
    private String indicatorName;

    /**
     * 指标分类
     */
    @ExcelProperty(value = "指标分类")
    private String indicatorCategory;

    /**
     * 肿瘤类型
     */
    @ExcelProperty(value = "肿瘤类型")
    private String tumorType;

    /**
     * 指标类型 强制性/推荐性
     */
    @ExcelProperty(value = "指标类型 强制性/推荐性")
    private String indicatorType;

    /**
     * 计算公式
     */
    @ExcelProperty(value = "计算公式")
    private String calculationFormula;

    /**
     * 数据来源
     */
    @ExcelProperty(value = "数据来源")
    private String dataSource;

    /**
     * 采集频率 实时/每日/每周/每月
     */
    @ExcelProperty(value = "采集频率 实时/每日/每周/每月")
    private String collectionFrequency;

    /**
     * 标准值
     */
    @ExcelProperty(value = "标准值")
    private String standardValue;

    /**
     * 目标值
     */
    @ExcelProperty(value = "目标值")
    private String targetValue;

    /**
     * 生效日期
     */
    @ExcelProperty(value = "生效日期")
    private Date effectiveDate;

    /**
     * 政策级别 国家级/省级/市级
     */
    @ExcelProperty(value = "政策级别 国家级/省级/市级")
    private String policyLevel;

    /**
     * 政策来源
     */
    @ExcelProperty(value = "政策来源")
    private String policySource;

    /**
     * 是否启用
     */
    @ExcelProperty(value = "是否启用")
    private Long isEnabled;

    /**
     * 是否删除
     */
    @ExcelProperty(value = "是否删除")
    private Long delFlag;


}
