package org.dromara.cdi.mmp.doctor.domain;

import org.dromara.common.mybatis.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 医师资质目录对象 mmp_doctor_qualification_catalog
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_doctor_qualification_catalog")
public class MmpDoctorQualificationCatalog extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 资质编码
     */
    private String catalogCode;

    /**
     * 资质名称
     */
    private String catalogName;

    /**
     * 父级ID
     */
    private Long parentId;

    /**
     * 目录层级 1-一级 2-二级 3-三级 4-四级
     */
    private Long catalogLevel;

    /**
     * 资质类型 手术分级/有创操作/限制类技术/处方权/会诊权/其他
     */
    private String catalogType;

    /**
     * 资质子类型
     */
    private String subType;

    /**
     * 资质描述
     */
    private String description;

    /**
     * 排序
     */
    private Long sortOrder;

    /**
     * 是否启用 1-是 0-否
     */
    private Long isEnabled;

    /**
     * 是否删除
     */
    private Long delFlag;


}
