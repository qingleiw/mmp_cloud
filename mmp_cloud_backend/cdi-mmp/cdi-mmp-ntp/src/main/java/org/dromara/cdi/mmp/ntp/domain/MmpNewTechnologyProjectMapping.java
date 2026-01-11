package org.dromara.cdi.mmp.ntp.domain;

import org.dromara.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 新技术项目对码对象 mmp_new_technology_project_mapping
 *
 * @author Lion Li
 * @date 2026-01-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_new_technology_project_mapping")
public class MmpNewTechnologyProjectMapping extends TenantEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 项目ID
     */
    private Long projectId;

    /**
     * 对码类型 医嘱项/ICD-9/收费项
     */
    private String mappingType;

    /**
     * 源编码
     */
    private String sourceCode;

    /**
     * 源名称
     */
    private String sourceName;

    /**
     * 目标系统 HIS/收费系统
     */
    private String targetSystem;

    /**
     * 是否删除
     */
    @TableLogic
    private String delFlag;

    /**
     * 备注
     */
    private String remark;


}
