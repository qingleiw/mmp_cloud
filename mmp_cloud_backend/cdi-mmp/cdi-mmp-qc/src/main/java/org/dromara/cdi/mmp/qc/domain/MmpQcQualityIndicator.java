package org.dromara.cdi.mmp.qc.domain;

import org.dromara.common.mybatis.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 质量指标对象 mmp_qc_quality_indicator
 *
 * @author Lion Li
 * @date 2025-12-30
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_qc_quality_indicator")
public class MmpQcQualityIndicator extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 指标编码
     */
    private String indicatorCode;

    /**
     * 指标名称
     */
    private String indicatorName;

    /**
     * 所属专业ID
     */
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
