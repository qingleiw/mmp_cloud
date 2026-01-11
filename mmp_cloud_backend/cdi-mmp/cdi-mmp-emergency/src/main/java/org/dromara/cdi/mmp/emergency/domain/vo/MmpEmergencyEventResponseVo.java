package org.dromara.cdi.mmp.emergency.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.cdi.mmp.emergency.domain.MmpEmergencyEventResponse;
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
 * 突发事件响应视图对象 mmp_emergency_event_response
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpEmergencyEventResponse.class)
public class MmpEmergencyEventResponseVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 响应队伍
     */
    @ExcelProperty(value = "响应队伍")
    private String responseTeam;

    /**
     * 响应开始时间
     */
    @ExcelProperty(value = "响应开始时间")
    private Date responseStartTime;

    /**
     * 响应结束时间
     */
    @ExcelProperty(value = "响应结束时间")
    private Date responseEndTime;

    /**
     * 响应措施
     */
    @ExcelProperty(value = "响应措施")
    private String responseMeasures;

    /**
     * 责任人
     */
    @ExcelProperty(value = "责任人")
    private String responsiblePerson;

    /**
     * 备注
     */
    @ExcelProperty(value = "备注")
    private String remark;


}
