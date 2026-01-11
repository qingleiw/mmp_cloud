package org.dromara.cdi.mmp.ntp.domain.bo;

import org.dromara.cdi.mmp.ntp.domain.MmpNewTechnologyProjectExtension;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 新技术延期申请业务对象 mmp_new_technology_project_extension
 *
 * @author Lion Li
 * @date 2026-01-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpNewTechnologyProjectExtension.class, reverseConvertGenerate = false)
public class MmpNewTechnologyProjectExtensionBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 申请编号
     */
    @NotBlank(message = "申请编号不能为空", groups = { AddGroup.class, EditGroup.class })
    private String applyNo;

    /**
     * 项目ID
     */
    @NotNull(message = "项目ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long projectId;

    /**
     * 原结束日期
     */
    private Date originalEndDate;

    /**
     * 延期天数
     */
    private Long extendDays;

    /**
     * 新结束日期
     */
    private Date newEndDate;

    /**
     * 延期理由
     */
    private String extensionReason;

    /**
     * 申请状态
     */
    private String applyStatus;

    /**
     * 工作流实例ID
     */
    private Long workflowInstanceId;

    /**
     * 备注
     */
    private String remark;


}
