package org.dromara.cdi.mmp.qualification.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.cdi.mmp.qualification.domain.MmpQualificationUsageRecord;
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
 * 资质使用记录视图对象 mmp_qualification_usage_record
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpQualificationUsageRecord.class)
public class MmpQualificationUsageRecordVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @ExcelProperty(value = "主键ID")
    private Long id;

    /**
     * 授权记录ID
     */
    @ExcelProperty(value = "授权记录ID")
    private Long authorizationId;

    /**
     * 人员ID
     */
    @ExcelProperty(value = "人员ID")
    private Long staffId;

    /**
     * 资质ID
     */
    @ExcelProperty(value = "资质ID")
    private Long qualificationId;

    /**
     * 使用时间
     */
    @ExcelProperty(value = "使用时间")
    private Date usageDate;

    /**
     * 患者ID
     */
    @ExcelProperty(value = "患者ID")
    private Long patientId;

    /**
     * 患者姓名
     */
    @ExcelProperty(value = "患者姓名")
    private String patientName;

    /**
     * 操作编码
     */
    @ExcelProperty(value = "操作编码")
    private String operationCode;

    /**
     * 操作名称
     */
    @ExcelProperty(value = "操作名称")
    private String operationName;

    /**
     * 使用结果 正常/异常
     */
    @ExcelProperty(value = "使用结果 正常/异常")
    private String usageResult;

    /**
     * 是否超权限 1-是 0-否
     */
    @ExcelProperty(value = "是否超权限 1-是 0-否")
    private Long isOverAuthority;

    /**
     * 来源系统
     */
    @ExcelProperty(value = "来源系统")
    private String sourceSystem;


}
