package org.dromara.cdi.mmp.surgery.domain;

import org.dromara.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;

/**
 * 手术并发症记录对象 mmp_surgery_complication_record
 *
 * @author Lion Li
 * @date 2025-12-26
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_surgery_complication_record")
public class MmpSurgeryComplicationRecord extends TenantEntity {

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
     * 医师ID
     */
    private Long doctorId;

    /**
     * 医师姓名
     */
    private String doctorName;

    /**
     * 患者ID
     */
    private String patientId;

    /**
     * 手术编码
     */
    private String surgeryCode;

    /**
     * 手术名称
     */
    private String surgeryName;

    /**
     * 并发症类型
     */
    private String complicationType;

    /**
     * 并发症描述
     */
    private String complicationDescription;

    /**
     * 并发症等级
     */
    private String complicationLevel;

    /**
     * 发生时间
     */
    private Date occurrenceTime;

    /**
     * 是否为非计划二次手术
     */
    private Long isPlannedSecondary;

    /**
     * 删除标志（0代表存在 1代表删除）
     */
    private String delFlag;


}
