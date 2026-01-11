package org.dromara.cdi.mmp.qc.domain.bo;

import org.dromara.cdi.mmp.qc.domain.MmpQcQualityIndicator;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;

/**
 * 质量指标业务对象 mmp_qc_quality_indicator
 *
 * @author Lion Li
 * @date 2025-12-30
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpQcQualityIndicator.class, reverseConvertGenerate = false)
public class MmpQcQualityIndicatorBo extends BaseEntity {

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
     * 所属专业ID
     */
    @NotNull(message = "所属专业ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long categoryId;

    /**
     * 父指标ID（用于分级指标）
     */
    private Long parentId;

    /**
     * 指标层级
     */
    private Long indicatorLevel;

    /**
     * 定义
     */
    private String definition;

    /**
     * 计算公式
     */
    private String formula;

    /**
     * 意义
     */
    private String significance;

    /**
     * 说明
     */
    private String remark;

    /**
     * 单位
     */
    private String unit;

    /**
     * 数据类型：rate-比率，count-计数，ratio-比值
     */
    private String dataType;

    /**
     * 标准值
     */
    private Long standardValue;

    /**
     * 满分分值
     */
    private Long maxScore;

    /**
     * 排序
     */
    private Long sortOrder;

    /**
     * 状态：1-启用，0-禁用
     */
    private Long status;

    /**
     * 是否删除
     */
    private Long delFlag;


}
