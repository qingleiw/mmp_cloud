package org.dromara.cdi.mmp.radiation.domain;

import org.dromara.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 剂量监测预警设置对象 mmp_radiation_dose_alert
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_radiation_dose_alert")
public class MmpRadiationDoseAlert extends TenantEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 预警类型：monthly-月度预警，quarterly-季度预警，yearly-年度预警
     */
    private String alertType;

    /**
     * 阈值
     */
    private Long thresholdValue;

    /**
     * 预警级别：low-低，medium-中，high-高
     */
    private String alertLevel;

    /**
     * 是否启用：0-否，1-是
     */
    private String isActive;

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
