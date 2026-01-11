package org.dromara.cdi.mmp.radiation.domain.bo;

import org.dromara.cdi.mmp.radiation.domain.MmpRadiationDoseAlertRecord;
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
 * 剂量异常预警记录业务对象 mmp_radiation_dose_alert_record
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpRadiationDoseAlertRecord.class, reverseConvertGenerate = false)
public class MmpRadiationDoseAlertRecordBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 工作人员ID
     */
    @NotNull(message = "工作人员ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long staffId;

    /**
     * 工作人员姓名
     */
    private String staffName;

    /**
     * 预警日期
     */
    @NotNull(message = "预警日期不能为空", groups = { AddGroup.class, EditGroup.class })
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
     * 备注
     */
    private String remark;


}
