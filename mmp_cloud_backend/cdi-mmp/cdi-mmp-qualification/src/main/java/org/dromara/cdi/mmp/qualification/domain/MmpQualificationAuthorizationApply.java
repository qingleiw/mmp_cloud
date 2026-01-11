package org.dromara.cdi.mmp.qualification.domain;

import org.dromara.common.mybatis.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 资质授权申请对象 mmp_qualification_authorization_apply
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_qualification_authorization_apply")
public class MmpQualificationAuthorizationApply extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 申请单号
     */
    private String applyNo;

    /**
     * 申请人ID
     */
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
