package org.dromara.cdi.mmp.supervision.domain.bo;

import org.dromara.cdi.mmp.supervision.domain.MmpSupervisionRectificationProgress;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;

/**
 * 整改进度业务对象 mmp_supervision_rectification_progress
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpSupervisionRectificationProgress.class, reverseConvertGenerate = false)
public class MmpSupervisionRectificationProgressBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 任务ID
     */
    @NotNull(message = "任务ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long taskId;

    /**
     * 进度描述
     */
    private String progressDescription;

    /**
     * 进度百分比
     */
    private Long progressPercentage;

    /**
     * 附件URL
     */
    private String attachmentUrls;

    /**
     * 状态
     */
    private String status;

    /**
     * 备注
     */
    private String remark;


}
