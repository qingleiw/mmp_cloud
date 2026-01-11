package org.dromara.cdi.mmp.supervision.domain.bo;

import org.dromara.cdi.mmp.supervision.domain.MmpSupervisionFormField;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;

/**
 * 督查单字段业务对象 mmp_supervision_form_field
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpSupervisionFormField.class, reverseConvertGenerate = false)
public class MmpSupervisionFormFieldBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 表单ID
     */
    @NotNull(message = "表单ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long formId;

    /**
     * 字段编码
     */
    @NotBlank(message = "字段编码不能为空", groups = { AddGroup.class, EditGroup.class })
    private String fieldCode;

    /**
     * 字段名称
     */
    @NotBlank(message = "字段名称不能为空", groups = { AddGroup.class, EditGroup.class })
    private String fieldName;

    /**
     * 字段类型
     */
    @NotBlank(message = "字段类型不能为空", groups = { AddGroup.class, EditGroup.class })
    private String fieldType;

    /**
     * 字段配置（JSON格式）
     */
    private String fieldConfig;

    /**
     * 是否必填：0-否，1-是
     */
    private String requiredFlag;

    /**
     * 排序
     */
    private Long sortOrder;

    /**
     * 状态
     */
    private String status;

    /**
     * 备注
     */
    private String remark;


}
