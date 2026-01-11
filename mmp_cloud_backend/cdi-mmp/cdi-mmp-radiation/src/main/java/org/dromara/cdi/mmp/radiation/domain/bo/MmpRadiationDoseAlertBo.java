package org.dromara.cdi.mmp.radiation.domain.bo;

import org.dromara.cdi.mmp.radiation.domain.MmpRadiationDoseAlert;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;

/**
 * 剂量监测预警设置业务对象 mmp_radiation_dose_alert
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpRadiationDoseAlert.class, reverseConvertGenerate = false)
public class MmpRadiationDoseAlertBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 预警类型：monthly-月度预警，quarterly-季度预警，yearly-年度预警
     */
    private String alertType;

    /**
     * 阈值
     */
    @NotNull(message = "阈值不能为空", groups = { AddGroup.class, EditGroup.class })
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
     * 备注
     */
    private String remark;


}
