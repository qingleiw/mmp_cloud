package org.dromara.cdi.mmp.complaindispute.domain;

import org.dromara.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;

/**
 * 投诉处理记录对象 mmp_complaint_handling
 *
 * @author Lion Li
 * @date 2025-12-26
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_complaint_handling")
public class MmpComplaintHandling extends TenantEntity {

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
     * 处理人ID
     */
    private Long handlerId;

    /**
     * 处理人姓名
     */
    private String handlerName;

    /**
     * 处理措施
     */
    private String handlingMeasure;

    /**
     * 处理结果
     */
    private String handlingResult;

    /**
     * 处理时间
     */
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
