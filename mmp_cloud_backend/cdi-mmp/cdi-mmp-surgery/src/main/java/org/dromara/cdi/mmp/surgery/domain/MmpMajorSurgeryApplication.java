package org.dromara.cdi.mmp.surgery.domain;

import org.dromara.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;

/**
 * 重大手术申请对象 mmp_major_surgery_application
 *
 * @author Lion Li
 * @date 2025-12-26
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_major_surgery_application")
public class MmpMajorSurgeryApplication extends TenantEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 申请编号
     */
    private String applicationNo;

    /**
     * 患者ID
     */
    private String patientId;

    /**
     * 患者姓名
     */
    private String patientName;

    /**
     * 申请医师ID
     */
    private Long doctorId;

    /**
     * 申请医师姓名
     */
    private String doctorName;

    /**
     * 申请科室ID
     */
    private Long departmentId;

    /**
     * 申请科室名称
     */
    private String departmentName;

    /**
     * 拟手术名称
     */
    private String surgeryName;

    /**
     * 手术原因
     */
    private String surgeryReason;

    /**
     * 手术风险
     */
    private String surgeryRisk;

    /**
     * 预计手术时间
     */
    private Date expectedTime;

    /**
     * 申请状态
     */
    private String applicationStatus;

    /**
     * 审批意见
     */
    private String approvalOpinion;

    /**
     * 审批人ID
     */
    private Long approverId;

    /**
     * 审批人姓名
     */
    private String approverName;

    /**
     * 审批时间
     */
    private Date approvalTime;

    /**
     * 附件（JSON格式）
     */
    private String attachments;

    /**
     * 删除标志（0代表存在 1代表删除）
     */
    private String delFlag;


}
