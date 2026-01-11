package org.dromara.cdi.mmp.radiation.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.cdi.mmp.radiation.domain.MmpRadiationDoseMonitoring;
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
 * 个人剂量监测视图对象 mmp_radiation_dose_monitoring
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpRadiationDoseMonitoring.class)
public class MmpRadiationDoseMonitoringVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 监测日期
     */
    @ExcelProperty(value = "监测日期")
    private Date monitoringDate;

    /**
     * 监测周期
     */
    @ExcelProperty(value = "监测周期")
    private String monitoringPeriod;

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
     * 监测方法
     */
    @ExcelProperty(value = "监测方法")
    private String monitoringMethod;

    /**
     * 监测设备
     */
    @ExcelProperty(value = "监测设备")
    private String monitoringDevice;

    /**
     * 监测人员
     */
    @ExcelProperty(value = "监测人员")
    private String monitoringPerson;

    /**
     * 是否超标：0-否，1-是
     */
    @ExcelProperty(value = "是否超标：0-否，1-是")
    private String isExceeded;

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
