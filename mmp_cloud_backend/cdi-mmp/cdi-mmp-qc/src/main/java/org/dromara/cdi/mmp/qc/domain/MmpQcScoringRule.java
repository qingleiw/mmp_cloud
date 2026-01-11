package org.dromara.cdi.mmp.qc.domain;

import org.dromara.common.mybatis.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 评分规则对象 mmp_qc_scoring_rule
 *
 * @author Lion Li
 * @date 2025-12-30
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_qc_scoring_rule")
public class MmpQcScoringRule extends BaseEntity {

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
     * 规则类型：range-区间，threshold-阈值
     */
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
