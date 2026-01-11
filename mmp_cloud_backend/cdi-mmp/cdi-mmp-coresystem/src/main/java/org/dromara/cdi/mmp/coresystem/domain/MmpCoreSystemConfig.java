package org.dromara.cdi.mmp.coresystem.domain;

import org.dromara.common.mybatis.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 核心制度配置对象 mmp_core_system_config
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_core_system_config")
public class MmpCoreSystemConfig extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 制度编码
     */
    private String systemCode;

    /**
     * 制度名称
     */
    private String systemName;

    /**
     * 制度类型
     */
    private String systemType;

    /**
     * 制度描述
     */
    private String systemDescription;

    /**
     * 制度总分
     */
    private Long totalScore;

    /**
     * 权重
     */
    private Long weight;

    /**
     * 是否启用
     */
    private Long isEnabled;

    /**
     * 是否自定义 1-是 0-否
     */
    private Long isCustom;

    /**
     * 是否删除
     */
    private Long delFlag;


}
