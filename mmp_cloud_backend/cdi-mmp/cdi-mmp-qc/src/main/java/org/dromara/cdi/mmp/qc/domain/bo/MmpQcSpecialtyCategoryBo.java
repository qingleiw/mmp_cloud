package org.dromara.cdi.mmp.qc.domain.bo;

import org.dromara.cdi.mmp.qc.domain.MmpQcSpecialtyCategory;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;

/**
 * 专业类别业务对象 mmp_qc_specialty_category
 *
 * @author Lion Li
 * @date 2025-12-30
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpQcSpecialtyCategory.class, reverseConvertGenerate = false)
public class MmpQcSpecialtyCategoryBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 专业代码
     */
    @NotBlank(message = "专业代码不能为空", groups = { AddGroup.class, EditGroup.class })
    private String categoryCode;

    /**
     * 专业名称
     */
    @NotBlank(message = "专业名称不能为空", groups = { AddGroup.class, EditGroup.class })
    private String categoryName;

    /**
     * 发布年份
     */
    private Long publishYear;

    /**
     * 排序
     */
    private Long sortOrder;

    /**
     * 状态：1-启用，0-禁用
     */
    private Long status;

    /**
     * 是否删除
     */
    private Long delFlag;


}
