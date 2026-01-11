package org.dromara.cdi.mmp.qualification.domain.bo;

import org.dromara.cdi.mmp.qualification.domain.MmpDepartmentQualificationCatalog;
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
 * 科室资质目录业务对象 mmp_department_qualification_catalog
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpDepartmentQualificationCatalog.class, reverseConvertGenerate = false)
public class MmpDepartmentQualificationCatalogBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 科室ID
     */
    @NotNull(message = "科室ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long departmentId;

    /**
     * 资质ID
     */
    @NotNull(message = "资质ID不能为空", groups = { AddGroup.class, EditGroup.class })
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
