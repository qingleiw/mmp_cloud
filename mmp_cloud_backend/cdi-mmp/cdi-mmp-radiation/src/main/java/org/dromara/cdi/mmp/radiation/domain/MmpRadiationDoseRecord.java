package org.dromara.cdi.mmp.radiation.domain;

import org.dromara.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;

/**
 * 个人剂量监测记录对象 mmp_radiation_dose_record
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_radiation_dose_record")
public class MmpRadiationDoseRecord extends TenantEntity {

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
    private Long staffId;

    /**
     * 工作人员姓名
     */
    private String staffName;

    /**
     * 记录日期
     */
    private Date recordDate;

    /**
     * 记录周期：daily-日，monthly-月，quarterly-季度，yearly-年
     */
    private String recordPeriod;

    /**
     * 剂量值
     */
    private Long doseValue;

    /**
     * 剂量单位
     */
    private String doseUnit;

    /**
     * 测量方法
     */
    private String measurementMethod;

    /**
     * 测量设备
     */
    private String measurementDevice;

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
