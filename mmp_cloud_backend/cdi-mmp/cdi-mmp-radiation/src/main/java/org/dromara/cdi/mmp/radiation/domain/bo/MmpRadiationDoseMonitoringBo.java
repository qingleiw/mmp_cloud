package org.dromara.cdi.mmp.radiation.domain.bo;

import org.dromara.cdi.mmp.radiation.domain.MmpRadiationDoseMonitoring;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 个人剂量监测业务对象 mmp_radiation_dose_monitoring
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpRadiationDoseMonitoring.class, reverseConvertGenerate = false)
public class MmpRadiationDoseMonitoringBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 工作人员ID
     */
    @NotNull(message = "工作人员ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long workerId;

    /**
     * 监测日期
     */
    @NotNull(message = "监测日期不能为空", groups = { AddGroup.class, EditGroup.class })
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
     * 备注
     */
    private String remark;


}
