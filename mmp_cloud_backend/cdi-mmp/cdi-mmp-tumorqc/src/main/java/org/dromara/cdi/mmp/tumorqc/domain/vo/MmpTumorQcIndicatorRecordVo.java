package org.dromara.cdi.mmp.tumorqc.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.cdi.mmp.tumorqc.domain.MmpTumorQcIndicatorRecord;
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
 * 质控指标监测记录视图对象 mmp_tumor_qc_indicator_record
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpTumorQcIndicatorRecord.class)
public class MmpTumorQcIndicatorRecordVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @ExcelProperty(value = "主键ID")
    private Long id;

    /**
     * 记录日期
     */
    @ExcelProperty(value = "记录日期")
    private Date recordDate;

    /**
     * 计算周期
     */
    @ExcelProperty(value = "计算周期")
    private String calculationCycle;

    /**
     * 科室ID
     */
    @ExcelProperty(value = "科室ID")
    private Long departmentId;

    /**
     * 科室名称
     */
    @ExcelProperty(value = "科室名称")
    private String departmentName;

    /**
     * 指标ID
     */
    @ExcelProperty(value = "指标ID")
    private Long indicatorId;

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
     * 分子
     */
    @ExcelProperty(value = "分子")
    private Long numerator;

    /**
     * 分母
     */
    @ExcelProperty(value = "分母")
    private Long denominator;

    /**
     * 指标值
     */
    @ExcelProperty(value = "指标值")
    private Long indicatorValue;

    /**
     * 目标值
     */
    @ExcelProperty(value = "目标值")
    private String targetValue;

    /**
     * 达标状态 达标/不达标
     */
    @ExcelProperty(value = "达标状态 达标/不达标")
    private String complianceStatus;

    /**
     * 完成率(%)
     */
    @ExcelProperty(value = "完成率(%)")
    private Long completionRate;

    /**
     * 院内排名
     */
    @ExcelProperty(value = "院内排名")
    private Long rankInHospital;

    /**
     * 趋势方向
     */
    @ExcelProperty(value = "趋势方向")
    private String trendDirection;

    /**
     * 是否异常 1-是 0-否
     */
    @ExcelProperty(value = "是否异常 1-是 0-否")
    private Long isAbnormal;

    /**
     * 数据来源说明
     */
    @ExcelProperty(value = "数据来源说明")
    private String dataSource;

    /**
     * 是否人工录入 1-是 0-否
     */
    @ExcelProperty(value = "是否人工录入 1-是 0-否")
    private Long isManual;

    /**
     * 备注
     */
    @ExcelProperty(value = "备注")
    private String remark;


}
