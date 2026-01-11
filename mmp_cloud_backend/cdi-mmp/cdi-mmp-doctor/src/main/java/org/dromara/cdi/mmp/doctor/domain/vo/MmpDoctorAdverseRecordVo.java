package org.dromara.cdi.mmp.doctor.domain.vo;

import java.util.Date;

import org.dromara.cdi.mmp.doctor.domain.MmpDoctorAdverseRecord;
import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;


/**
 * 不良行为记录视图对象 mmp_doctor_adverse_record
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpDoctorAdverseRecord.class)
public class MmpDoctorAdverseRecordVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @ExcelProperty(value = "主键ID")
    private Long id;

    /**
     * 医生ID
     */
    @ExcelProperty(value = "医生ID")
    private Long doctorId;

    /**
     * 记录类型 医疗事故/差错/违规
     */
    @ExcelProperty(value = "记录类型 医疗事故/差错/违规")
    private String recordType;

    /**
     * 记录标题
     */
    @ExcelProperty(value = "记录标题")
    private String recordTitle;

    /**
     * 发生日期
     */
    @ExcelProperty(value = "发生日期")
    private Date occurDate;

    /**
     * 事件描述
     */
    @ExcelProperty(value = "事件描述")
    private String description;

    /**
     * 后果
     */
    @ExcelProperty(value = "后果")
    private String consequence;

    /**
     * 处理措施
     */
    @ExcelProperty(value = "处理措施")
    private String handlingMeasure;

    /**
     * 处罚情况
     */
    @ExcelProperty(value = "处罚情况")
    private String punishment;

    /**
     * 记录状态 待处理/处理中/已处理
     */
    @ExcelProperty(value = "记录状态 待处理/处理中/已处理")
    private String recordStatus;

    /**
     * 是否删除
     */
    @ExcelProperty(value = "是否删除")
    private Long delFlag;


}
