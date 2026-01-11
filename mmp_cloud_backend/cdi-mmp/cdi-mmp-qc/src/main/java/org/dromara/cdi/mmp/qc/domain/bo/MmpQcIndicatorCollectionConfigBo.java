package org.dromara.cdi.mmp.qc.domain.bo;

import org.dromara.cdi.mmp.qc.domain.MmpQcIndicatorCollectionConfig;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;

/**
 * 质控指标数据采集配置业务对象 mmp_qc_indicator_collection_config
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpQcIndicatorCollectionConfig.class, reverseConvertGenerate = false)
public class MmpQcIndicatorCollectionConfigBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 指标ID
     */
    @NotNull(message = "指标ID不能为空", groups = { AddGroup.class, EditGroup.class })
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
