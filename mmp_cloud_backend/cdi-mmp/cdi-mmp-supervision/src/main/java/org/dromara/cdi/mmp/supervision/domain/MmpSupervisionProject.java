package org.dromara.cdi.mmp.supervision.domain;

import org.dromara.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 督查项目对象 mmp_supervision_project
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_supervision_project")
public class MmpSupervisionProject extends TenantEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 项目编码
     */
    private String projectCode;

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 项目类型
     */
    private String projectType;

    /**
     * 项目描述
     */
    private String projectDescription;

    /**
     * 督导部门
     */
    private String supervisionDepartment;

    /**
     * 负责人
     */
    private String responsiblePerson;

    /**
     * 联系方式
     */
    private String contactInfo;

    /**
     * 督导频次
     */
    private String supervisionFrequency;

    /**
     * 状态：active-启用，inactive-停用
     */
    private String status;

    /**
     * 是否删除
     */
    @TableLogic
    private Long delFlag;

    /**
     * 备注
     */
    private String remark;


}
