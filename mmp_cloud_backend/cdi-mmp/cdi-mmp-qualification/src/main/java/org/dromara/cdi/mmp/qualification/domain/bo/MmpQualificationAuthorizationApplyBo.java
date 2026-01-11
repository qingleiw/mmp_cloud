package org.dromara.cdi.mmp.qualification.domain.bo;

import org.dromara.cdi.mmp.qualification.domain.MmpQualificationAuthorizationApply;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;

/**
 * 资质授权申请业务对象 mmp_qualification_authorization_apply
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpQualificationAuthorizationApply.class, reverseConvertGenerate = false)
public class MmpQualificationAuthorizationApplyBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 申请单号
     */
    @NotBlank(message = "申请单号不能为空", groups = { AddGroup.class, EditGroup.class })
    private String applyNo;

    /**
     * 申请人ID
     */
    @NotNull(message = "申请人ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long applicantId;

    /**
     * 申请人姓名
     */
    private String applicantName;

    /**
     * 申请人类型 医师/医技
     */
    private String applicantType;

    /**
     * 科室ID
     */
    private Long departmentId;

    /**
     * 科室名称
     */
    private String departmentName;

    /**
     * 资质ID列表(逗号分隔)
     */
    private String qualificationIds;

    /**
     * 申请理由
     */
    private String applyReason;

    /**
     * 关联证书ID
     */
    private String certificateIds;

    /**
     * 考核成绩
     */
    private Long examScore;

    /**
     * 工作量数据JSON
     */
    private String workQuantity;

    /**
     * 工作质量数据JSON
     */
    private String workQuality;

    /**
     * 申请状态
     */
    private String applyStatus;

    /**
     * 当前审批节点
     */
    private String currentNode;

    /**
     * 工作流实例ID
     */
    private Long workflowInstanceId;

    /**
     * 是否删除
     */
    private Long delFlag;


}
