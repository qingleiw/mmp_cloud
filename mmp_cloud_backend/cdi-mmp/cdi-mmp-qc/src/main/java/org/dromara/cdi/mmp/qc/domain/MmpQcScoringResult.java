package org.dromara.cdi.mmp.qc.domain;

import org.dromara.common.mybatis.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;

/**
 * 评分结果对象 mmp_qc_scoring_result
 *
 * @author Lion Li
 * @date 2025-12-30
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_qc_scoring_result")
public class MmpQcScoringResult extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 采集记录ID
     */
    private Long collectionId;

    /**
     * 指标ID
     */
    private Long indicatorId;

    /**
     * 指标值
     */
    private Long indicatorValue;

    /**
     * 标准值
     */
    private Long standardValue;

    /**
     * 满分
     */
    private Long maxScore;

    /**
     * 实际得分
     */
    private Long actualScore;

    /**
     * 得分率
     */
    private Long scoreRate;

    /**
     * 评价等级：excellent-优秀，good-良好，qualified-合格，unqualified-不合格
     */
    private String evaluationLevel;

    /**
     * 计算时间
     */
    private Date calculateTime;

    /**
     * 是否删除
     */
    private Long delFlag;


}
