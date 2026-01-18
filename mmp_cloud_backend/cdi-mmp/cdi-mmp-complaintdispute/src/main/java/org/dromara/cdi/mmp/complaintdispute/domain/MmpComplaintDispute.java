package org.dromara.cdi.mmp.complaintdispute.domain;

import org.dromara.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;

/**
 * 投诉纠纷主对象 mmp_complaint_dispute
 *
 * @author Lion Li
 * @date 2025-12-26
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_complaint_dispute")
public class MmpComplaintDispute extends TenantEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 投诉编号
     */
    private String complaintNo;

    /**
     * 投诉类型
     */
    private String complaintType;

    /**
     * 投诉来源
     */
    private String complaintSource;

    /**
     * 投诉人姓名
     */
    private String complainantName;

    /**
     * 投诉人联系方式
     */
    private String complainantContact;

    /**
     * 患者姓名
     */
    private String patientName;

    /**
     * 患者ID
     */
    private String patientId;

    /**
     * 涉及医师ID
     */
    private Long doctorId;

    /**
     * 涉及医师姓名
     */
    private String doctorName;

    /**
     * 涉及科室ID
     */
    private Long departmentId;

    /**
     * 涉及科室名称
     */
    private String departmentName;

    /**
     * 投诉内容
     */
    private String complaintContent;

    /**
     * 投诉时间
     */
    private Date complaintTime;

    /**
     * 当前状态
     */
    private String currentStatus;

    /**
     * 优先级
     */
    private String priorityLevel;

    /**
     * 是否构成纠纷
     */
    private Long isDispute;

    /**
     * 纠纷确认说明
     */
    private String disputeConfirmation;

    /**
     * 最终处理结果
     */
    private String finalResult;

    /**
     * 删除标志（0代表存在 1代表删除）
     */
    private String delFlag;


}
