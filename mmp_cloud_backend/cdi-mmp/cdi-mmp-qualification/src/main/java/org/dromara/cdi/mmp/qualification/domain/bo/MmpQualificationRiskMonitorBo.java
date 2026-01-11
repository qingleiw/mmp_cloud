package org.dromara.cdi.mmp.qualification.domain.bo;

import org.dromara.cdi.mmp.qualification.domain.MmpQualificationRiskMonitor;
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
 * 资质风险监测业务对象 mmp_qualification_risk_monitor
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpQualificationRiskMonitor.class, reverseConvertGenerate = false)
public class MmpQualificationRiskMonitorBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 风险编号
     */
    @NotBlank(message = "风险编号不能为空", groups = { AddGroup.class, EditGroup.class })
    private String riskNo;

    /**
     * 人员ID
     */
    @NotNull(message = "人员ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long staffId;

    /**
     * 人员姓名
     */
    private String staffName;

    /**
     * 资质ID
     */
    private Long qualificationId;

    /**
     * 资质名称
     */
    private String qualificationName;

    /**
     * 风险类型 超权限/即将过期/质量问题/安全事件
     */
    private String riskType;

    /**
     * 风险等级 高/中/低
     */
    private String riskLevel;

    /**
     * 风险描述
     */
    private String riskDescription;

    /**
     * 风险发生时间
     */
    private Date riskDate;

    /**
     * 关联患者ID
     */
    private Long relatedPatientId;

    /**
     * 关联事件ID
     */
    private Long relatedEventId;

    /**
     * 处理状态
     */
    private String handlingStatus;

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
    private Long delFlag;


}
