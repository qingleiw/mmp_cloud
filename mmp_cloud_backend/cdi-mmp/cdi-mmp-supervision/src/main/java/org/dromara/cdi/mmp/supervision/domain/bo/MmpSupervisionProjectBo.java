package org.dromara.cdi.mmp.supervision.domain.bo;

import org.dromara.cdi.mmp.supervision.domain.MmpSupervisionProject;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;

/**
 * 督查项目业务对象 mmp_supervision_project
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpSupervisionProject.class, reverseConvertGenerate = false)
public class MmpSupervisionProjectBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 项目编码
     */
    @NotBlank(message = "项目编码不能为空", groups = { AddGroup.class, EditGroup.class })
    private String projectCode;

    /**
     * 项目名称
     */
    @NotBlank(message = "项目名称不能为空", groups = { AddGroup.class, EditGroup.class })
    private String projectName;

    /**
     * 项目类型
     */
    private String projectType;

    /**
     * 项目描述
     */
    private String projectDescription;

    /**
     * 督导部门
     */
    private String supervisionDepartment;

    /**
     * 负责人
     */
    private String responsiblePerson;

    /**
     * 联系方式
     */
    private String contactInfo;

    /**
     * 督导频次
     */
    private String supervisionFrequency;

    /**
     * 状态：active-启用，inactive-停用
     */
    private String status;

    /**
     * 备注
     */
    private String remark;


}
