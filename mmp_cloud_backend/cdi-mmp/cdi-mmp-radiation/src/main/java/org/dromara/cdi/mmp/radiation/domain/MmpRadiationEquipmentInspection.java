package org.dromara.cdi.mmp.radiation.domain;

import org.dromara.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;

/**
 * 放射设备检测记录对象 mmp_radiation_equipment_inspection
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_radiation_equipment_inspection")
public class MmpRadiationEquipmentInspection extends TenantEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 设备ID
     */
    private Long equipmentId;

    /**
     * 检测日期
     */
    private Date inspectionDate;

    /**
     * 检测机构
     */
    private String inspectionAgency;

    /**
     * 检测人员
     */
    private String inspectorName;

    /**
     * 检测结果：pass-合格，fail-不合格
     */
    private String inspectionResult;

    /**
     * 检测报告
     */
    private String inspectionReport;

    /**
     * 下次检测日期
     */
    private Date nextInspectionDate;

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
