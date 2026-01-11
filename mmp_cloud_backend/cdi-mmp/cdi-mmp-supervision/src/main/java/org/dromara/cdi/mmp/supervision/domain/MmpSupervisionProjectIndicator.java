package org.dromara.cdi.mmp.supervision.domain;

import org.dromara.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 督查项目指标对象 mmp_supervision_project_indicator
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_supervision_project_indicator")
public class MmpSupervisionProjectIndicator extends TenantEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 项目ID
     */
    private Long projectId;

    /**
     * 指标编码
     */
    private String indicatorCode;

    /**
     * 指标名称
     */
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
     * 是否删除
     */
    @TableLogic
    private Long delFlag;

    /**
     * 备注
     */
    private String remark;


}
