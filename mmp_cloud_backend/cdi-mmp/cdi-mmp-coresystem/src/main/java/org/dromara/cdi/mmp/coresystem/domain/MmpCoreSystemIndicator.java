package org.dromara.cdi.mmp.coresystem.domain;

import org.dromara.common.mybatis.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 核心制度指标对象 mmp_core_system_indicator
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_core_system_indicator")
public class MmpCoreSystemIndicator extends BaseEntity {

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
     * 所属制度ID
     */
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
