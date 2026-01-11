package org.dromara.cdi.mmp.radiation.domain;

import org.dromara.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;

/**
 * 剂量异常预警记录对象 mmp_radiation_dose_alert_record
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_radiation_dose_alert_record")
public class MmpRadiationDoseAlertRecord extends TenantEntity {

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
     * 预警日期
     */
    private Date alertDate;

    /**
     * 预警类型
     */
    private String alertType;

    /**
     * 当前剂量
     */
    private Long currentDose;

    /**
     * 阈值
     */
    private Long thresholdValue;

    /**
     * 预警级别
     */
    private String alertLevel;

    /**
     * 预警信息
     */
    private String alertMessage;

    /**
     * 是否已处理：0-否，1-是
     */
    private String isHandled;

    /**
     * 处理人
     */
    private String handler;

    /**
     * 处理时间
     */
    private Date handleTime;

    /**
     * 处理结果
     */
    private String handleResult;

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
