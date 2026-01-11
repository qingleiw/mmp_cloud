package org.dromara.cdi.mmp.emergency.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.cdi.mmp.emergency.domain.MmpEmergencyEventTreatment;
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
 * 突发事件救治视图对象 mmp_emergency_event_treatment
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpEmergencyEventTreatment.class)
public class MmpEmergencyEventTreatmentVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 患者姓名
     */
    @ExcelProperty(value = "患者姓名")
    private String patientName;

    /**
     * 诊断
     */
    @ExcelProperty(value = "诊断")
    private String diagnosis;

    /**
     * 救治措施
     */
    @ExcelProperty(value = "救治措施")
    private String treatmentMeasures;

    /**
     * 救治结果
     */
    @ExcelProperty(value = "救治结果")
    private String treatmentResult;

    /**
     * 救治医师
     */
    @ExcelProperty(value = "救治医师")
    private String treatingPhysician;

    /**
     * 救治时间
     */
    @ExcelProperty(value = "救治时间")
    private Date treatmentTime;

    /**
     * 备注
     */
    @ExcelProperty(value = "备注")
    private String remark;


}
