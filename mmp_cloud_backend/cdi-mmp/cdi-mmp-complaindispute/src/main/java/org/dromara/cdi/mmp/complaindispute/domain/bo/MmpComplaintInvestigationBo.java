package org.dromara.cdi.mmp.complaindispute.domain.bo;

import org.dromara.cdi.mmp.complaindispute.domain.MmpComplaintInvestigation;
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
 * 投诉调查记录业务对象 mmp_complaint_investigation
 *
 * @author Lion Li
 * @date 2025-12-26
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpComplaintInvestigation.class, reverseConvertGenerate = false)
public class MmpComplaintInvestigationBo extends BaseEntity {

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
     * 调查人ID
     */
    @NotNull(message = "调查人ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long investigatorId;

    /**
     * 调查人姓名
     */
    @NotBlank(message = "调查人姓名不能为空", groups = { AddGroup.class, EditGroup.class })
    private String investigatorName;

    /**
     * 调查内容
     */
    @NotBlank(message = "调查内容不能为空", groups = { AddGroup.class, EditGroup.class })
    private String investigationContent;

    /**
     * 调查结果
     */
    private String investigationResult;

    /**
     * 调查时间
     */
    @NotNull(message = "调查时间不能为空", groups = { AddGroup.class, EditGroup.class })
    private Date investigationTime;

    /**
     * 附件（JSON格式）
     */
    private String attachments;

    /**
     * 删除标志（0代表存在 1代表删除）
     */
    private String delFlag;


}
