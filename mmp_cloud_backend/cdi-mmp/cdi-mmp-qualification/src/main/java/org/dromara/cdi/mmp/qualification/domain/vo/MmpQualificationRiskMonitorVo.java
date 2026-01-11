package org.dromara.cdi.mmp.qualification.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.cdi.mmp.qualification.domain.MmpQualificationRiskMonitor;
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
 * 资质风险监测视图对象 mmp_qualification_risk_monitor
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpQualificationRiskMonitor.class)
public class MmpQualificationRiskMonitorVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @ExcelProperty(value = "主键ID")
    private Long id;

    /**
     * 风险编号
     */
    @ExcelProperty(value = "风险编号")
    private String riskNo;

    /**
     * 人员ID
     */
    @ExcelProperty(value = "人员ID")
    private Long staffId;

    /**
     * 人员姓名
     */
    @ExcelProperty(value = "人员姓名")
    private String staffName;

    /**
     * 资质ID
     */
    @ExcelProperty(value = "资质ID")
    private Long qualificationId;

    /**
     * 资质名称
     */
    @ExcelProperty(value = "资质名称")
    private String qualificationName;

    /**
     * 风险类型 超权限/即将过期/质量问题/安全事件
     */
    @ExcelProperty(value = "风险类型 超权限/即将过期/质量问题/安全事件")
    private String riskType;

    /**
     * 风险等级 高/中/低
     */
    @ExcelProperty(value = "风险等级 高/中/低")
    private String riskLevel;

    /**
     * 风险描述
     */
    @ExcelProperty(value = "风险描述")
    private String riskDescription;

    /**
     * 风险发生时间
     */
    @ExcelProperty(value = "风险发生时间")
    private Date riskDate;

    /**
     * 关联患者ID
     */
    @ExcelProperty(value = "关联患者ID")
    private Long relatedPatientId;

    /**
     * 关联事件ID
     */
    @ExcelProperty(value = "关联事件ID")
    private Long relatedEventId;

    /**
     * 处理状态
     */
    @ExcelProperty(value = "处理状态")
    private String handlingStatus;

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
     * 是否删除
     */
    @ExcelProperty(value = "是否删除")
    private Long delFlag;


}
