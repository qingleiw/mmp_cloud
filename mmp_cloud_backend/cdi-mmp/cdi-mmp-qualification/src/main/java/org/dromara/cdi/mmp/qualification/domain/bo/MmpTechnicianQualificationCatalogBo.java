package org.dromara.cdi.mmp.qualification.domain.bo;

import org.dromara.cdi.mmp.qualification.domain.MmpTechnicianQualificationCatalog;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;

/**
 * 医技资质目录业务对象 mmp_technician_qualification_catalog
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpTechnicianQualificationCatalog.class, reverseConvertGenerate = false)
public class MmpTechnicianQualificationCatalogBo extends BaseEntity {

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
     * 目录层级
     */
    private Long catalogLevel;

    /**
     * 资质类型 检查/检验/心电/病理/输血/核医学/放疗/POCT/药学调配
     */
    private String catalogType;

    /**
     * 资质描述
     */
    private String description;

    /**
     * 排序
     */
    private Long sortOrder;

    /**
     * 是否启用
     */
    private Long isEnabled;

    /**
     * 是否删除
     */
    private Long delFlag;


}
