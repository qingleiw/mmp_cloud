package org.dromara.cdi.mmp.complaindispute.domain.bo;

import org.dromara.cdi.mmp.complaindispute.domain.MmpComplaintHandling;
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
 * 投诉处理记录业务对象 mmp_complaint_handling
 *
 * @author Lion Li
 * @date 2025-12-26
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpComplaintHandling.class, reverseConvertGenerate = false)
public class MmpComplaintHandlingBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 投诉ID
     */
    @NotNull(message = "投诉ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long complaintId;

    /**
     * 处理人ID
     */
    @NotNull(message = "处理人ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long handlerId;

    /**
     * 处理人姓名
     */
    @NotBlank(message = "处理人姓名不能为空", groups = { AddGroup.class, EditGroup.class })
    private String handlerName;

    /**
     * 处理措施
     */
    @NotBlank(message = "处理措施不能为空", groups = { AddGroup.class, EditGroup.class })
    private String handlingMeasure;

    /**
     * 处理结果
     */
    private String handlingResult;

    /**
     * 处理时间
     */
    @NotNull(message = "处理时间不能为空", groups = { AddGroup.class, EditGroup.class })
    private Date handlingTime;

    /**
     * 反馈内容
     */
    private String feedbackContent;

    /**
     * 反馈时间
     */
    private Date feedbackTime;

    /**
     * 删除标志（0代表存在 1代表删除）
     */
    private String delFlag;


}
