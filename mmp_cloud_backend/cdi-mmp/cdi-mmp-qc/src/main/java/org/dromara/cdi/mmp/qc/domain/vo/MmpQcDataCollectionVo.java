package org.dromara.cdi.mmp.qc.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.cdi.mmp.qc.domain.MmpQcDataCollection;
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
 * 数据采集记录视图对象 mmp_qc_data_collection
 *
 * @author Lion Li
 * @date 2025-12-30
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpQcDataCollection.class)
public class MmpQcDataCollectionVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 统计周期：monthly-月度，quarterly-季度，yearly-年度
     */
    @ExcelProperty(value = "统计周期：monthly-月度，quarterly-季度，yearly-年度")
    private String collectionPeriod;

    /**
     * 统计年份
     */
    @ExcelProperty(value = "统计年份")
    private Long collectionYear;

    /**
     * 统计月份
     */
    @ExcelProperty(value = "统计月份")
    private Long collectionMonth;

    /**
     * 统计季度
     */
    @ExcelProperty(value = "统计季度")
    private Long collectionQuarter;

    /**
     * 科室名称
     */
    @ExcelProperty(value = "科室名称")
    private String departmentName;

    /**
     * 分子值
     */
    @ExcelProperty(value = "分子值")
    private Long numeratorValue;

    /**
     * 分母值
     */
    @ExcelProperty(value = "分母值")
    private Long denominatorValue;

    /**
     * 指标值（计算结果）
     */
    @ExcelProperty(value = "指标值", converter = ExcelDictConvert.class)
    @ExcelDictFormat(readConverterExp = "计=算结果")
    private Long indicatorValue;

    /**
     * 数据状态：0-草稿，1-已提交，2-已审核
     */
    @ExcelProperty(value = "数据状态：0-草稿，1-已提交，2-已审核")
    private Long dataStatus;

    /**
     * 采集人
     */
    @ExcelProperty(value = "采集人")
    private String collector;

    /**
     * 审核人
     */
    @ExcelProperty(value = "审核人")
    private String reviewer;

    /**
     * 采集时间
     */
    @ExcelProperty(value = "采集时间")
    private Date collectionTime;

    /**
     * 审核时间
     */
    @ExcelProperty(value = "审核时间")
    private Date reviewTime;

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
