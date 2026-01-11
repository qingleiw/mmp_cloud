package org.dromara.cdi.mmp.radiation.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.cdi.mmp.radiation.domain.MmpRadiationDoseRecord;
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
 * 个人剂量监测记录视图对象 mmp_radiation_dose_record
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpRadiationDoseRecord.class)
public class MmpRadiationDoseRecordVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 工作人员姓名
     */
    @ExcelProperty(value = "工作人员姓名")
    private String staffName;

    /**
     * 记录日期
     */
    @ExcelProperty(value = "记录日期")
    private Date recordDate;

    /**
     * 记录周期：daily-日，monthly-月，quarterly-季度，yearly-年
     */
    @ExcelProperty(value = "记录周期：daily-日，monthly-月，quarterly-季度，yearly-年")
    private String recordPeriod;

    /**
     * 剂量值
     */
    @ExcelProperty(value = "剂量值")
    private Long doseValue;

    /**
     * 剂量单位
     */
    @ExcelProperty(value = "剂量单位")
    private String doseUnit;

    /**
     * 测量方法
     */
    @ExcelProperty(value = "测量方法")
    private String measurementMethod;

    /**
     * 测量设备
     */
    @ExcelProperty(value = "测量设备")
    private String measurementDevice;

    /**
     * 备注
     */
    @ExcelProperty(value = "备注")
    private String remarks;

    /**
     * 备注
     */
    @ExcelProperty(value = "备注")
    private String remark;


}
