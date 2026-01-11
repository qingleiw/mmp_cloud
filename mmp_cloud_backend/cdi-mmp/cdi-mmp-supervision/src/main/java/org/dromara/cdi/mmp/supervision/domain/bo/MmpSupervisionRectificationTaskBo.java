package org.dromara.cdi.mmp.supervision.domain.bo;

import org.dromara.cdi.mmp.supervision.domain.MmpSupervisionRectificationTask;
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
 * 整改任务业务对象 mmp_supervision_rectification_task
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpSupervisionRectificationTask.class, reverseConvertGenerate = false)
public class MmpSupervisionRectificationTaskBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 问题ID
     */
    @NotNull(message = "问题ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long issueId;

    /**
     * 任务描述
     */
    @NotBlank(message = "任务描述不能为空", groups = { AddGroup.class, EditGroup.class })
    private String taskDescription;

    /**
     * 责任部门
     */
    private String responsibleDept;

    /**
     * 责任人
     */
    private String responsiblePerson;

    /**
     * 截止日期
     */
    private Date deadline;

    /**
     * 状态
     */
    private String status;

    /**
     * 备注
     */
    private String remark;


}
