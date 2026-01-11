package org.dromara.cdi.mmp.emergency.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.cdi.mmp.emergency.domain.MmpEmergencyIncident;
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
 * 突发事件记录视图对象 mmp_emergency_incident
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpEmergencyIncident.class)
public class MmpEmergencyIncidentVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 事件编码
     */
    @ExcelProperty(value = "事件编码")
    private String incidentCode;

    /**
     * 事件标题
     */
    @ExcelProperty(value = "事件标题")
    private String incidentTitle;

    /**
     * 事件类型
     */
    @ExcelProperty(value = "事件类型")
    private String incidentType;

    /**
     * 事件等级
     */
    @ExcelProperty(value = "事件等级")
    private String incidentLevel;

    /**
     * 发生时间
     */
    @ExcelProperty(value = "发生时间")
    private Date occurrenceTime;

    /**
     * 发生地点
     */
    @ExcelProperty(value = "发生地点")
    private String location;

    /**
     * 事件描述
     */
    @ExcelProperty(value = "事件描述")
    private String description;

    /**
     * 受影响人员
     */
    @ExcelProperty(value = "受影响人员")
    private String affectedPersons;

    /**
     * 响应队伍
     */
    @ExcelProperty(value = "响应队伍")
    private String responseTeam;

    /**
     * 响应措施
     */
    @ExcelProperty(value = "响应措施")
    private String responseMeasures;

    /**
     * 解决时间
     */
    @ExcelProperty(value = "解决时间")
    private Date resolutionTime;

    /**
     * 伤亡情况
     */
    @ExcelProperty(value = "伤亡情况")
    private String casualties;

    /**
     * 经济损失
     */
    @ExcelProperty(value = "经济损失")
    private Long economicLoss;

    /**
     * 经验教训
     */
    @ExcelProperty(value = "经验教训")
    private String lessonsLearned;

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
