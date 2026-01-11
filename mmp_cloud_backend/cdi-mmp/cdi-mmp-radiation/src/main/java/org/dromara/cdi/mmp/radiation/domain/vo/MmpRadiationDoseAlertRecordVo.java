package org.dromara.cdi.mmp.radiation.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.cdi.mmp.radiation.domain.MmpRadiationDoseAlertRecord;
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
 * 剂量异常预警记录视图对象 mmp_radiation_dose_alert_record
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpRadiationDoseAlertRecord.class)
public class MmpRadiationDoseAlertRecordVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 工作人员姓名
     */
    @ExcelProperty(value = "工作人员姓名")
    private String staffName;

    /**
     * 预警日期
     */
    @ExcelProperty(value = "预警日期")
    private Date alertDate;

    /**
     * 预警类型
     */
    @ExcelProperty(value = "预警类型")
    private String alertType;

    /**
     * 当前剂量
     */
    @ExcelProperty(value = "当前剂量")
    private Long currentDose;

    /**
     * 阈值
     */
    @ExcelProperty(value = "阈值")
    private Long thresholdValue;

    /**
     * 预警级别
     */
    @ExcelProperty(value = "预警级别")
    private String alertLevel;

    /**
     * 预警信息
     */
    @ExcelProperty(value = "预警信息")
    private String alertMessage;

    /**
     * 是否已处理：0-否，1-是
     */
    @ExcelProperty(value = "是否已处理：0-否，1-是")
    private String isHandled;

    /**
     * 处理人
     */
    @ExcelProperty(value = "处理人")
    private String handler;

    /**
     * 处理时间
     */
    @ExcelProperty(value = "处理时间")
    private Date handleTime;

    /**
     * 处理结果
     */
    @ExcelProperty(value = "处理结果")
    private String handleResult;

    /**
     * 备注
     */
    @ExcelProperty(value = "备注")
    private String remark;


}
