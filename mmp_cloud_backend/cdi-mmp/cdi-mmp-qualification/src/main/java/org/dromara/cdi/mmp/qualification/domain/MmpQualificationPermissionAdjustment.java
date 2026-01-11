package org.dromara.cdi.mmp.qualification.domain;

import org.dromara.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;

/**
 * 资质权限调整历史对象 mmp_qualification_permission_adjustment
 *
 * @author Lion Li
 * @date 2025-12-26
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_qualification_permission_adjustment")
public class MmpQualificationPermissionAdjustment extends TenantEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 医师ID
     */
    private Long doctorId;

    /**
     * 医师姓名
     */
    private String doctorName;

    /**
     * 资质类型（手术权限、抗菌药物权限等）
     */
    private String qualificationType;

    /**
     * 原权限级别
     */
    private String originalLevel;

    /**
     * 新权限级别
     */
    private String newLevel;

    /**
     * 调整原因
     */
    private String adjustmentReason;

    /**
     * 调整依据（JSON格式，包含工作量、并发症等数据）
     */
    private String adjustmentBasis;

    /**
     * 调整时间
     */
    private Date adjustmentTime;

    /**
     * 操作人ID
     */
    private Long operatorId;

    /**
     * 操作人姓名
     */
    private String operatorName;

    /**
     * 是否自动调整
     */
    private Long isAutoAdjustment;

    /**
     * 删除标志（0代表存在 1代表删除）
     */
    private String delFlag;


}
