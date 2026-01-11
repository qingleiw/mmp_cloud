package org.dromara.cdi.mmp.qc.domain.bo;

import org.dromara.cdi.mmp.qc.domain.MmpQcScoringRule;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;

/**
 * 评分规则业务对象 mmp_qc_scoring_rule
 *
 * @author Lion Li
 * @date 2025-12-30
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpQcScoringRule.class, reverseConvertGenerate = false)
public class MmpQcScoringRuleBo extends BaseEntity {

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
     * 规则类型：range-区间，threshold-阈值
     */
    @NotBlank(message = "规则类型：range-区间，threshold-阈值不能为空", groups = { AddGroup.class, EditGroup.class })
    private String ruleType;

    /**
     * 最小值
     */
    private Long minValue;

    /**
     * 最大值
     */
    private Long maxValue;

    /**
     * 得分
     */
    private Long score;

    /**
     * 得分率
     */
    private Long scoreRate;

    /**
     * 规则描述
     */
    private String description;

    /**
     * 排序
     */
    private Long sortOrder;

    /**
     * 状态
     */
    private Long status;

    /**
     * 是否删除
     */
    private Long delFlag;


}
