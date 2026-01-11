package org.dromara.cdi.mmp.supervision.domain.bo;

import org.dromara.cdi.mmp.supervision.domain.MmpSupervisionProjectIndicator;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;

/**
 * 督查项目指标业务对象 mmp_supervision_project_indicator
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpSupervisionProjectIndicator.class, reverseConvertGenerate = false)
public class MmpSupervisionProjectIndicatorBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 项目ID
     */
    @NotNull(message = "项目ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long projectId;

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
     * 指标类型
     */
    private String indicatorType;

    /**
     * 指标描述
     */
    private String indicatorDescription;

    /**
     * 评分标准
     */
    private String scoringStandard;

    /**
     * 权重
     */
    private Long weight;

    /**
     * 满分值
     */
    private Long maxScore;

    /**
     * 排序
     */
    private Long sortOrder;

    /**
     * 状态
     */
    private String status;

    /**
     * 备注
     */
    private String remark;


}
