package org.dromara.cdi.mmp.ntp.domain.bo;

import org.dromara.cdi.mmp.ntp.domain.MmpNewTechnologyProjectMapping;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;

/**
 * 新技术项目对码业务对象 mmp_new_technology_project_mapping
 *
 * @author Lion Li
 * @date 2026-01-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpNewTechnologyProjectMapping.class, reverseConvertGenerate = false)
public class MmpNewTechnologyProjectMappingBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 项目ID
     */
    @NotNull(message = "项目ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long projectId;

    /**
     * 对码类型 医嘱项/ICD-9/收费项
     */
    private String mappingType;

    /**
     * 源编码
     */
    private String sourceCode;

    /**
     * 源名称
     */
    private String sourceName;

    /**
     * 目标系统 HIS/收费系统
     */
    private String targetSystem;

    /**
     * 备注
     */
    private String remark;


}
