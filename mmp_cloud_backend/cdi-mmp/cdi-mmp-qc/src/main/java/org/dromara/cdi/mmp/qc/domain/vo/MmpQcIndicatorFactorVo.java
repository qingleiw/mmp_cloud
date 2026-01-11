package org.dromara.cdi.mmp.qc.domain.vo;

import org.dromara.cdi.mmp.qc.domain.MmpQcIndicatorFactor;
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
 * 指标计算因子视图对象 mmp_qc_indicator_factor
 *
 * @author Lion Li
 * @date 2025-12-30
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpQcIndicatorFactor.class)
public class MmpQcIndicatorFactorVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 因子类型：numerator-分子，denominator-分母
     */
    @ExcelProperty(value = "因子类型：numerator-分子，denominator-分母")
    private String factorType;

    /**
     * 因子名称
     */
    @ExcelProperty(value = "因子名称")
    private String factorName;

    /**
     * 因子代码
     */
    @ExcelProperty(value = "因子代码")
    private String factorCode;

    /**
     * 因子描述
     */
    @ExcelProperty(value = "因子描述")
    private String description;

    /**
     * 数据来源
     */
    @ExcelProperty(value = "数据来源")
    private String dataSource;

    /**
     * 排序
     */
    @ExcelProperty(value = "排序")
    private Long sortOrder;

    /**
     * 是否删除
     */
    @ExcelProperty(value = "是否删除")
    private Long delFlag;


}
