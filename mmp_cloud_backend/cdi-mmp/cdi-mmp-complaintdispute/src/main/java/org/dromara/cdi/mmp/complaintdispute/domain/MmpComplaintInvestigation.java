package org.dromara.cdi.mmp.complaintdispute.domain;

import org.dromara.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;

/**
 * 投诉调查记录对象 mmp_complaint_investigation
 *
 * @author Lion Li
 * @date 2025-12-26
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_complaint_investigation")
public class MmpComplaintInvestigation extends TenantEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 投诉ID
     */
    private Long complaintId;

    /**
     * 调查人ID
     */
    private Long investigatorId;

    /**
     * 调查人姓名
     */
    private String investigatorName;

    /**
     * 调查内容
     */
    private String investigationContent;

    /**
     * 调查结果
     */
    private String investigationResult;

    /**
     * 调查时间
     */
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
