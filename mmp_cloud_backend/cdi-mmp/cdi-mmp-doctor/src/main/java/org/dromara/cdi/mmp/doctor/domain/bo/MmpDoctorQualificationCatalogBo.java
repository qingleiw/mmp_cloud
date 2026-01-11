package org.dromara.cdi.mmp.doctor.domain.bo;

import org.dromara.cdi.mmp.doctor.domain.MmpDoctorQualificationCatalog;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;

/**
 * 医师资质目录业务对象 mmp_doctor_qualification_catalog
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpDoctorQualificationCatalog.class, reverseConvertGenerate = false)
public class MmpDoctorQualificationCatalogBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 资质编码
     */
    @NotBlank(message = "资质编码不能为空", groups = { AddGroup.class, EditGroup.class })
    private String catalogCode;

    /**
     * 资质名称
     */
    @NotBlank(message = "资质名称不能为空", groups = { AddGroup.class, EditGroup.class })
    private String catalogName;

    /**
     * 父级ID
     */
    private Long parentId;

    /**
     * 目录层级 1-一级 2-二级 3-三级 4-四级
     */
    private Long catalogLevel;

    /**
     * 资质类型 手术分级/有创操作/限制类技术/处方权/会诊权/其他
     */
    private String catalogType;

    /**
     * 资质子类型
     */
    private String subType;

    /**
     * 资质描述
     */
    private String description;

    /**
     * 排序
     */
    private Long sortOrder;

    /**
     * 是否启用 1-是 0-否
     */
    private Long isEnabled;

    /**
     * 是否删除
     */
    private Long delFlag;


}
