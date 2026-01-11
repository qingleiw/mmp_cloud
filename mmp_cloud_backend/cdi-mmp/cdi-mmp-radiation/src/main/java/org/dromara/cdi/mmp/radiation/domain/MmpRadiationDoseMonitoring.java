package org.dromara.cdi.mmp.radiation.domain;

import org.dromara.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;

/**
 * 个人剂量监测对象 mmp_radiation_dose_monitoring
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_radiation_dose_monitoring")
public class MmpRadiationDoseMonitoring extends TenantEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 工作人员ID
     */
    private Long workerId;

    /**
     * 监测日期
     */
    private Date monitoringDate;

    /**
     * 监测周期
     */
    private String monitoringPeriod;

    /**
     * 剂量值
     */
    private Long doseValue;

    /**
     * 剂量单位
     */
    private String doseUnit;

    /**
     * 监测方法
     */
    private String monitoringMethod;

    /**
     * 监测设备
     */
    private String monitoringDevice;

    /**
     * 监测人员
     */
    private String monitoringPerson;

    /**
     * 是否超标：0-否，1-是
     */
    private String isExceeded;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 是否删除
     */
    @TableLogic
    private Long delFlag;

    /**
     * 备注
     */
    private String remark;


}
