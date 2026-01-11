package org.dromara.cdi.mmp.qualification.domain;

import org.dromara.common.mybatis.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 医技资质目录对象 mmp_technician_qualification_catalog
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_technician_qualification_catalog")
public class MmpTechnicianQualificationCatalog extends BaseEntity {

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
     * 目录层级
     */
    private Long catalogLevel;

    /**
     * 资质类型 检查/检验/心电/病理/输血/核医学/放疗/POCT/药学调配
     */
    private String catalogType;

    /**
     * 资质描述
     */
    private String description;

    /**
     * 排序
     */
    private Long sortOrder;

    /**
     * 是否启用
     */
    private Long isEnabled;

    /**
     * 是否删除
     */
    private Long delFlag;


}
