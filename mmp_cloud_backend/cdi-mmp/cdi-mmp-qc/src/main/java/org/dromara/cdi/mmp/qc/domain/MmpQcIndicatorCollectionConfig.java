package org.dromara.cdi.mmp.qc.domain;

import org.dromara.common.mybatis.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 质控指标数据采集配置对象 mmp_qc_indicator_collection_config
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_qc_indicator_collection_config")
public class MmpQcIndicatorCollectionConfig extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 指标ID
     */
    private Long indicatorId;

    /**
     * 来源系统 HIS/EMR/LIS/PACS等
     */
    private String sourceSystem;

    /**
     * 来源表
     */
    private String sourceTable;

    /**
     * 来源字段
     */
    private String sourceField;

    /**
     * 提取规则
     */
    private String extractionRule;

    /**
     * 数据类型
     */
    private String dataType;

    /**
     * 是否必需 1-是 0-否
     */
    private Long isRequired;

    /**
     * 默认值
     */
    private String defaultValue;

    /**
     * 校验规则
     */
    private String validationRule;

    /**
     * 是否删除
     */
    private Long delFlag;


}
