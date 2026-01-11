package org.dromara.cdi.mmp.coresystem.domain.bo;

import org.dromara.cdi.mmp.coresystem.domain.MmpCoreSystemIndicator;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;

/**
 * 核心制度指标业务对象 mmp_core_system_indicator
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpCoreSystemIndicator.class, reverseConvertGenerate = false)
public class MmpCoreSystemIndicatorBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 指标编码
     */
    @NotBlank(message = "指标编码不能为空", groups = { AddGroup.class, EditGroup.class })
    private String indicatorCode;

    /**
     * 指标名称
     */
    @NotBlank(message = "指标名称不能为空", groups = { AddGroup.class, EditGroup.class })
    private String indicatorName;

    /**
     * 所属制度ID
     */
    @NotNull(message = "所属制度ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long systemId;

    /**
     * 父指标ID
     */
    private Long parentId;

    /**
     * 指标类型 数量指标/率指标/时间指标
     */
    private String indicatorType;

    /**
     * 计算公式
     */
    private String calculationFormula;

    /**
     * 计算周期 日/周/月/季度/年
     */
    private String calculationCycle;

    /**
     * 数据来源
     */
    private String dataSource;

    /**
     * 目标值
     */
    private String targetValue;

    /**
     * 指标分值
     */
    private Long indicatorScore;

    /**
     * 是否反向指标 1-是 0-否
     */
    private Long isReverse;

    /**
     * 预警阈值
     */
    private String alertThreshold;

    /**
     * 是否启用
     */
    private Long isEnabled;

    /**
     * 是否自定义
     */
    private Long isCustom;

    /**
     * 是否删除
     */
    private Long delFlag;


}
