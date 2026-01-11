package org.dromara.cdi.mmp.qualification.domain.bo;

import org.dromara.cdi.mmp.qualification.domain.MmpQualificationPermissionAdjustment;
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
 * 资质权限调整历史业务对象 mmp_qualification_permission_adjustment
 *
 * @author Lion Li
 * @date 2025-12-26
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpQualificationPermissionAdjustment.class, reverseConvertGenerate = false)
public class MmpQualificationPermissionAdjustmentBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 医师ID
     */
    @NotNull(message = "医师ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long doctorId;

    /**
     * 医师姓名
     */
    private String doctorName;

    /**
     * 资质类型（手术权限、抗菌药物权限等）
     */
    @NotBlank(message = "资质类型（手术权限、抗菌药物权限等）不能为空", groups = { AddGroup.class, EditGroup.class })
    private String qualificationType;

    /**
     * 原权限级别
     */
    private String originalLevel;

    /**
     * 新权限级别
     */
    @NotBlank(message = "新权限级别不能为空", groups = { AddGroup.class, EditGroup.class })
    private String newLevel;

    /**
     * 调整原因
     */
    @NotBlank(message = "调整原因不能为空", groups = { AddGroup.class, EditGroup.class })
    private String adjustmentReason;

    /**
     * 调整依据（JSON格式，包含工作量、并发症等数据）
     */
    private String adjustmentBasis;

    /**
     * 调整时间
     */
    @NotNull(message = "调整时间不能为空", groups = { AddGroup.class, EditGroup.class })
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
