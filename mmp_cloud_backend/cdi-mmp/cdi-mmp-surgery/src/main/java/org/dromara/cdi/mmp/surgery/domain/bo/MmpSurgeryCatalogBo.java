package org.dromara.system.domain.bo;

import org.dromara.system.domain.MmpSurgeryCatalog;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;

/**
 * 手术目录业务对象 mmp_surgery_catalog
 *
 * @author Lion Li
 * @date 2026-01-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpSurgeryCatalog.class, reverseConvertGenerate = false)
public class MmpSurgeryCatalogBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 附加编码
     */
    @NotBlank(message = "附加编码不能为空", groups = { AddGroup.class, EditGroup.class })
    private String additionalCode;

    /**
     * 细目代码
     */
    @NotBlank(message = "细目代码不能为空", groups = { AddGroup.class, EditGroup.class })
    private String detailCode;

    /**
     * 手术操作名称
     */
    @NotBlank(message = "手术操作名称不能为空", groups = { AddGroup.class, EditGroup.class })
    private String surgeryName;

    /**
     * 类别
     */
    @NotBlank(message = "类别不能为空", groups = { AddGroup.class, EditGroup.class })
    private String category;

    /**
     * 手术等级
     */
    @NotBlank(message = "手术等级不能为空", groups = { AddGroup.class, EditGroup.class })
    private String surgeryLevel;

    /**
     * 是否启用
     */
    private Long isEnabled;

    /**
     * 所属科室
     */
    private String department;

    /**
     * 手术分类
     */
    private String surgeryCategory;

    /**
     * 备注
     */
    private String remark;


}
