package org.dromara.cdi.mmp.coresystem.domain.bo;

import org.dromara.cdi.mmp.coresystem.domain.MmpCoreSystemConfig;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;

/**
 * 核心制度配置业务对象 mmp_core_system_config
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpCoreSystemConfig.class, reverseConvertGenerate = false)
public class MmpCoreSystemConfigBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 制度编码
     */
    @NotBlank(message = "制度编码不能为空", groups = { AddGroup.class, EditGroup.class })
    private String systemCode;

    /**
     * 制度名称
     */
    @NotBlank(message = "制度名称不能为空", groups = { AddGroup.class, EditGroup.class })
    private String systemName;

    /**
     * 制度类型
     */
    private String systemType;

    /**
     * 制度描述
     */
    private String systemDescription;

    /**
     * 制度总分
     */
    private Long totalScore;

    /**
     * 权重
     */
    private Long weight;

    /**
     * 是否启用
     */
    private Long isEnabled;

    /**
     * 是否自定义 1-是 0-否
     */
    private Long isCustom;

    /**
     * 是否删除
     */
    private Long delFlag;


}
