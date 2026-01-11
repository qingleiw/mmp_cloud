package org.dromara.cdi.mmp.emergency.domain.bo;

import org.dromara.cdi.mmp.emergency.domain.MmpEmergencyMedicalSupport;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;

/**
 * 医疗保障资源业务对象 mmp_emergency_medical_support
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpEmergencyMedicalSupport.class, reverseConvertGenerate = false)
public class MmpEmergencyMedicalSupportBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 资源编码
     */
    @NotBlank(message = "资源编码不能为空", groups = { AddGroup.class, EditGroup.class })
    private String resourceCode;

    /**
     * 资源名称
     */
    @NotBlank(message = "资源名称不能为空", groups = { AddGroup.class, EditGroup.class })
    private String resourceName;

    /**
     * 资源类型
     */
    private String resourceType;

    /**
     * 所属部门
     */
    private String department;

    /**
     * 存放地点
     */
    private String location;

    /**
     * 数量
     */
    private Long quantity;

    /**
     * 单位
     */
    private String unit;

    /**
     * 联系人
     */
    private String contactPerson;

    /**
     * 联系方式
     */
    private String contactInfo;

    /**
     * 状态
     */
    private String status;

    /**
     * 备注
     */
    private String remark;


}
