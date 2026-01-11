package org.dromara.cdi.mmp.qualification.domain;

import org.dromara.common.mybatis.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;

/**
 * 科室资质目录对象 mmp_department_qualification_catalog
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_department_qualification_catalog")
public class MmpDepartmentQualificationCatalog extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 科室ID
     */
    private Long departmentId;

    /**
     * 资质ID
     */
    private Long qualificationId;

    /**
     * 资质类型 医师/医技
     */
    private String qualificationType;

    /**
     * 是否启用
     */
    private Long isEnabled;

    /**
     * 审批状态 待审批/已通过/已拒绝
     */
    private String approveStatus;

    /**
     * 审批时间
     */
    private Date approveTime;

    /**
     * 审批人
     */
    private String approveBy;

    /**
     * 是否删除
     */
    private Long delFlag;


}
