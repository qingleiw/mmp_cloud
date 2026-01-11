package org.dromara.cdi.mmp.surgery.domain.bo;

import org.dromara.cdi.mmp.surgery.domain.MmpSurgeryApprovalForm;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;

/**
 * 重大手术审批报告单业务对象 mmp_surgery_approval_form
 *
 * @author Lion Li
 * @date 2025-12-28
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpSurgeryApprovalForm.class, reverseConvertGenerate = false)
public class MmpSurgeryApprovalFormBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 申报科室
     */
    @NotBlank(message = "申报科室不能为空", groups = { AddGroup.class, EditGroup.class })
    private String deptName;

    /**
     * 申报日期
     */
    @NotBlank(message = "申报日期不能为空", groups = { AddGroup.class, EditGroup.class })
    private String reportDate;

    /**
     * 患者姓名
     */
    @NotBlank(message = "患者姓名不能为空", groups = { AddGroup.class, EditGroup.class })
    private String patientName;

    /**
     * 性别
     */
    @NotBlank(message = "性别不能为空", groups = { AddGroup.class, EditGroup.class })
    private String gender;

    /**
     * 年龄
     */
    @NotNull(message = "年龄不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long age;

    /**
     * 住院号
     */
    @NotBlank(message = "住院号不能为空", groups = { AddGroup.class, EditGroup.class })
    private String hospitalNumber;

    /**
     * 术前诊断
     */
    @NotBlank(message = "术前诊断不能为空", groups = { AddGroup.class, EditGroup.class })
    private String preoperativeDiagnosis;

    /**
     * 手术名称
     */
    @NotBlank(message = "手术名称不能为空", groups = { AddGroup.class, EditGroup.class })
    private String surgeryName;

    /**
     * 手术级别
     */
    @NotBlank(message = "手术级别不能为空", groups = { AddGroup.class, EditGroup.class })
    private String surgeryLevel;

    /**
     * 麻醉方式
     */
    @NotBlank(message = "麻醉方式不能为空", groups = { AddGroup.class, EditGroup.class })
    private String anesthesiaMethod;

    /**
     * 术者及职称
     */
    @NotBlank(message = "术者及职称不能为空", groups = { AddGroup.class, EditGroup.class })
    private String surgeon;

    /**
     * 助手及职称
     */
    @NotBlank(message = "助手及职称不能为空", groups = { AddGroup.class, EditGroup.class })
    private String assistant;

    /**
     * 术前讨论结果
     */
    @NotBlank(message = "术前讨论结果不能为空", groups = { AddGroup.class, EditGroup.class })
    private String discussionResult;

    /**
     * 报告医师
     */
    @NotBlank(message = "报告医师不能为空", groups = { AddGroup.class, EditGroup.class })
    private String reportingPhysician;

    /**
     * 报告日期
     */
    @NotBlank(message = "报告日期不能为空", groups = { AddGroup.class, EditGroup.class })
    private String reportingDate;

    /**
     * 患者或授权委托人知情同意情况
     */
    @NotBlank(message = "患者或授权委托人知情同意情况不能为空", groups = { AddGroup.class, EditGroup.class })
    private String informedConsent;

    /**
     * 科室主任签字
     */
    @NotBlank(message = "科室主任签字不能为空", groups = { AddGroup.class, EditGroup.class })
    private String departmentDirector;

    /**
     * 科室签字日期
     */
    @NotBlank(message = "科室签字日期不能为空", groups = { AddGroup.class, EditGroup.class })
    private String departmentDate;

    /**
     * 医务部主任签字
     */
    private String medicalDirector;

    /**
     * 审批状态
     */
    private String status;

    /**
     * 删除标志（0代表存在 1代表删除）
     */
    private Long delFlag;


}
