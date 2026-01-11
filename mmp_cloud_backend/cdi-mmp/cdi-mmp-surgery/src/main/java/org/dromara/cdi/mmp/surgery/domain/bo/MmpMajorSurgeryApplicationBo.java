package org.dromara.cdi.mmp.surgery.domain.bo;

import org.dromara.cdi.mmp.surgery.domain.MmpMajorSurgeryApplication;
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
 * 重大手术申请业务对象 mmp_major_surgery_application
 *
 * @author Lion Li
 * @date 2025-12-26
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpMajorSurgeryApplication.class, reverseConvertGenerate = false)
public class MmpMajorSurgeryApplicationBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 申请编号
     */
    @NotBlank(message = "申请编号不能为空", groups = { AddGroup.class, EditGroup.class })
    private String applicationNo;

    /**
     * 患者ID
     */
    @NotBlank(message = "患者ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private String patientId;

    /**
     * 患者姓名
     */
    @NotBlank(message = "患者姓名不能为空", groups = { AddGroup.class, EditGroup.class })
    private String patientName;

    /**
     * 申请医师ID
     */
    @NotNull(message = "申请医师ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long doctorId;

    /**
     * 申请医师姓名
     */
    @NotBlank(message = "申请医师姓名不能为空", groups = { AddGroup.class, EditGroup.class })
    private String doctorName;

    /**
     * 申请科室ID
     */
    @NotNull(message = "申请科室ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long departmentId;

    /**
     * 申请科室名称
     */
    @NotBlank(message = "申请科室名称不能为空", groups = { AddGroup.class, EditGroup.class })
    private String departmentName;

    /**
     * 拟手术名称
     */
    @NotBlank(message = "拟手术名称不能为空", groups = { AddGroup.class, EditGroup.class })
    private String surgeryName;

    /**
     * 手术原因
     */
    @NotBlank(message = "手术原因不能为空", groups = { AddGroup.class, EditGroup.class })
    private String surgeryReason;

    /**
     * 手术风险
     */
    private String surgeryRisk;

    /**
     * 预计手术时间
     */
    @NotNull(message = "预计手术时间不能为空", groups = { AddGroup.class, EditGroup.class })
    private Date expectedTime;

    /**
     * 申请状态
     */
    @NotBlank(message = "申请状态不能为空", groups = { AddGroup.class, EditGroup.class })
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
