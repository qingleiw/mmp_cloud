package org.dromara.cdi.mmp.complaindispute.domain.bo;

import org.dromara.cdi.mmp.complaindispute.domain.MmpComplaintDispute;
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
 * 投诉纠纷主业务对象 mmp_complaint_dispute
 *
 * @author Lion Li
 * @date 2025-12-26
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpComplaintDispute.class, reverseConvertGenerate = false)
public class MmpComplaintDisputeBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 投诉编号
     */
    @NotBlank(message = "投诉编号不能为空", groups = { AddGroup.class, EditGroup.class })
    private String complaintNo;

    /**
     * 投诉类型
     */
    @NotBlank(message = "投诉类型不能为空", groups = { AddGroup.class, EditGroup.class })
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
    @NotBlank(message = "投诉内容不能为空", groups = { AddGroup.class, EditGroup.class })
    private String complaintContent;

    /**
     * 投诉时间
     */
    @NotNull(message = "投诉时间不能为空", groups = { AddGroup.class, EditGroup.class })
    private Date complaintTime;

    /**
     * 当前状态
     */
    @NotBlank(message = "当前状态不能为空", groups = { AddGroup.class, EditGroup.class })
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
