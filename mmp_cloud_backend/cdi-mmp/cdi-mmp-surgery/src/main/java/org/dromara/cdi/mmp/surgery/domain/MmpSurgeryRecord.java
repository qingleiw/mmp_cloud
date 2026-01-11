package org.dromara.cdi.mmp.surgery.domain;

import org.dromara.common.mybatis.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;

/**
 * 手术记录对象 mmp_surgery_record
 *
 * @author Lion Li
 * @date 2025-12-28
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_surgery_record")
public class MmpSurgeryRecord extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 手术记录ID（HIS系统ID）
     */
    private String surgeryRecordId;

    /**
     * 手术申请ID
     */
    private Long applicationId;

    /**
     * 患者ID
     */
    private String patientId;

    /**
     * 患者姓名
     */
    private String patientName;

    /**
     * 主刀医生ID
     */
    private Long doctorId;

    /**
     * 主刀医生姓名
     */
    private String doctorName;

    /**
     * 手术科室ID
     */
    private Long departmentId;

    /**
     * 手术科室名称
     */
    private String departmentName;

    /**
     * 手术编码
     */
    private String surgeryCode;

    /**
     * 手术名称
     */
    private String surgeryName;

    /**
     * 手术等级
     */
    private String surgeryLevel;

    /**
     * 手术类型
     */
    private String surgeryType;

    /**
     * 麻醉方式
     */
    private String anesthesiaMethod;

    /**
     * 手术开始时间
     */
    private Date surgeryStartTime;

    /**
     * 手术结束时间
     */
    private Date surgeryEndTime;

    /**
     * 手术时长(分钟)
     */
    private Long surgeryDuration;

    /**
     * ASA分级
     */
    private String asaGrade;

    /**
     * 失血量(ml)
     */
    private Long bloodLoss;

    /**
     * 手术状态
     */
    private String surgeryStatus;

    /**
     * 是否有并发症
     */
    private Long complicationFlag;

    /**
     * 删除标志
     */
    private String delFlag;


}
