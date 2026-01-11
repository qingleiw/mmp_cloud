package org.dromara.cdi.mmp.supervision.domain.bo;

import org.dromara.cdi.mmp.supervision.domain.MmpSupervisionForm;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;

/**
 * 督查单业务对象 mmp_supervision_form
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpSupervisionForm.class, reverseConvertGenerate = false)
public class MmpSupervisionFormBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 表单编码
     */
    @NotBlank(message = "表单编码不能为空", groups = { AddGroup.class, EditGroup.class })
    private String formCode;

    /**
     * 表单名称
     */
    @NotBlank(message = "表单名称不能为空", groups = { AddGroup.class, EditGroup.class })
    private String formName;

    /**
     * 关联项目ID
     */
    @NotNull(message = "关联项目ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long projectId;

    /**
     * 表单描述
     */
    private String formDescription;

    /**
     * 表单配置（JSON格式）
     */
    private String formConfig;

    /**
     * 状态
     */
    private String status;

    /**
     * 备注
     */
    private String remark;


}
