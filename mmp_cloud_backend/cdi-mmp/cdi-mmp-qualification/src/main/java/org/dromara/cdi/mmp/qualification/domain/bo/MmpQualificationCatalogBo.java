package org.dromara.cdi.mmp.qualification.domain.bo;

import org.dromara.cdi.mmp.qualification.domain.MmpQualificationCatalog;
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
 * 医生手术授权目录业务对象 mmp_qualification_catalog
 *
 * @author Lion Li
 * @date 2025-12-30
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpQualificationCatalog.class, reverseConvertGenerate = false)
public class MmpQualificationCatalogBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 医生ID
     */
    @NotNull(message = "医生ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long doctorId;

    /**
     * 医生姓名
     */
    @NotBlank(message = "医生姓名不能为空", groups = { AddGroup.class, EditGroup.class })
    private String doctorName;

    /**
     * 科室
     */
    private String department;

    /**
     * 职务
     */
    private String position;

    /**
     * 职称
     */
    private String title;

    /**
     * 所授权手术级别
     */
    private String authorizedLevel;

    /**
     * 一级手术授权（1=通过，0=未通过）
     */
    private Long level1;

    /**
     * 二级手术授权（1=通过，0=未通过）
     */
    private Long level2;

    /**
     * 三级手术授权（1=通过，0=未通过）
     */
    private Long level3;

    /**
     * 四级手术授权（1=通过，0=未通过）
     */
    private Long level4;

    /**
     * 手术名称
     */
    private String surgeryName;

    /**
     * 手术代码
     */
    private String surgeryCode;

    /**
     * 手术级别（三级/四级）
     */
    private String surgeryLevel;

    /**
     * 资质类型
     */
    private String qualificationType;

    /**
     * 有效期开始
     */
    private Date validStartDate;

    /**
     * 有效期结束
     */
    private Date validEndDate;

    /**
     * 状态
     */
    private String status;

    /**
     * 数据来源
     */
    private String dataSource;

    /**
     * 是否删除
     */
    private Long delFlag;


}
