package org.dromara.cdi.mmp.emergency.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.cdi.mmp.emergency.domain.MmpEmergencyEvent;
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
 * 突发事件记录视图对象 mmp_emergency_event
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpEmergencyEvent.class)
public class MmpEmergencyEventVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 事件编码
     */
    @ExcelProperty(value = "事件编码")
    private String eventCode;

    /**
     * 事件标题
     */
    @ExcelProperty(value = "事件标题")
    private String eventTitle;

    /**
     * 事件类型
     */
    @ExcelProperty(value = "事件类型")
    private String eventType;

    /**
     * 事件等级
     */
    @ExcelProperty(value = "事件等级")
    private String eventLevel;

    /**
     * 发生时间
     */
    @ExcelProperty(value = "发生时间")
    private Date occurrenceTime;

    /**
     * 发现时间
     */
    @ExcelProperty(value = "发现时间")
    private Date discoveryTime;

    /**
     * 报告时间
     */
    @ExcelProperty(value = "报告时间")
    private Date reportTime;

    /**
     * 报告人
     */
    @ExcelProperty(value = "报告人")
    private String reporter;

    /**
     * 发生地点
     */
    @ExcelProperty(value = "发生地点")
    private String location;

    /**
     * 受影响人员
     */
    @ExcelProperty(value = "受影响人员")
    private String affectedPersons;

    /**
     * 事件描述
     */
    @ExcelProperty(value = "事件描述")
    private String eventDescription;

    /**
     * 立即措施
     */
    @ExcelProperty(value = "立即措施")
    private String immediateMeasures;

    /**
     * 状态
     */
    @ExcelProperty(value = "状态")
    private String status;

    /**
     * 备注
     */
    @ExcelProperty(value = "备注")
    private String remark;


}
