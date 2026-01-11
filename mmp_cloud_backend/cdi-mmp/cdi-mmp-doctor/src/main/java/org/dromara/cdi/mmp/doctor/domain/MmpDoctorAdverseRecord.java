package org.dromara.cdi.mmp.doctor.domain;

import org.dromara.common.mybatis.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;

/**
 * 不良行为记录对象 mmp_doctor_adverse_record
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_doctor_adverse_record")
public class MmpDoctorAdverseRecord extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 医生ID
     */
    private Long doctorId;

    /**
     * 记录类型 医疗事故/差错/违规
     */
    private String recordType;

    /**
     * 记录标题
     */
    private String recordTitle;

    /**
     * 发生日期
     */
    private Date occurDate;

    /**
     * 事件描述
     */
    private String description;

    /**
     * 后果
     */
    private String consequence;

    /**
     * 处理措施
     */
    private String handlingMeasure;

    /**
     * 处罚情况
     */
    private String punishment;

    /**
     * 记录状态 待处理/处理中/已处理
     */
    private String recordStatus;

    /**
     * 是否删除
     */
    private Long delFlag;


}
