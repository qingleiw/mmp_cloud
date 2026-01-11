package org.dromara.cdi.mmp.radiation.domain.vo;

import org.dromara.cdi.mmp.radiation.domain.MmpRadiationDoseAlert;
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
 * 剂量监测预警设置视图对象 mmp_radiation_dose_alert
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpRadiationDoseAlert.class)
public class MmpRadiationDoseAlertVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 预警类型：monthly-月度预警，quarterly-季度预警，yearly-年度预警
     */
    @ExcelProperty(value = "预警类型：monthly-月度预警，quarterly-季度预警，yearly-年度预警")
    private String alertType;

    /**
     * 阈值
     */
    @ExcelProperty(value = "阈值")
    private Long thresholdValue;

    /**
     * 预警级别：low-低，medium-中，high-高
     */
    @ExcelProperty(value = "预警级别：low-低，medium-中，high-高")
    private String alertLevel;

    /**
     * 是否启用：0-否，1-是
     */
    @ExcelProperty(value = "是否启用：0-否，1-是")
    private String isActive;

    /**
     * 备注
     */
    @ExcelProperty(value = "备注")
    private String remark;


}
